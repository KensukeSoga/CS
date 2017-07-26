package jp.co.isid.kkh.controller.login;

import java.util.ArrayList;
import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.common.CommonCondition;
import jp.co.isid.kkh.model.common.CommonDAO;
import jp.co.isid.kkh.model.common.CommonDAOFactory;
import jp.co.isid.kkh.model.common.CommonVO;
import jp.co.isid.kkh.model.login.LoginCondition;
import jp.co.isid.kkh.model.login.LoginCustomerInfoVO;
import jp.co.isid.kkh.model.login.LoginManager;
import jp.co.isid.kkh.model.login.LoginResult;
import jp.co.isid.kkh.model.login.RcmnMeu00SikCondition;
import jp.co.isid.kkh.model.login.RcmnMeu00SikVO;
import jp.co.isid.kkh.model.login.RcmnMeu07SikkrsprdCondition;
import jp.co.isid.kkh.model.login.RcmnMeu07SikkrsprdVO;
import jp.co.isid.kkh.model.login.RcmnMeu14ThstntTrCondition;
import jp.co.isid.kkh.model.login.RcmnMeu14ThstntTrVO;
import jp.co.isid.kkh.model.login.Tcm01KkhCondition;
import jp.co.isid.kkh.model.login.Tcm01KkhVO;
import jp.co.isid.kkh.model.login.ThbcKhtCondition;
import jp.co.isid.kkh.model.login.ThbcKhtVO;
import jp.co.isid.kkh.model.login.ThbdSpUsCondition;
import jp.co.isid.kkh.model.login.ThbdSpUsVO;
import jp.co.isid.kkh.model.login.Vkj02TitleClassGroupInfoCondition;
import jp.co.isid.kkh.model.login.Vkj02TitleClassGroupInfoVO;
import jp.co.isid.kkh.service.base.ErrorInfo;
import jp.co.isid.kkh.util.DateUtil;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.kkh.util.constants.KKHConstants;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ログイン処理コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * ・得意先ログイン無効化対応(2017/02/08 HLC K.Soga)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class LoginCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 階層コード：局所属 */
    private static final String KAISO_CD_KYOKU = "40";

    /** 信用コード：対象外 */
    private static final String[] SINCD_NOT_SUBJECT = { "7", "8", "9", "A", "X" };

    /** 主担当得意先：なし */
    private static final int MAIN_CUSTOMER_NOT_EXIST = -1;

    /** 検索結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** 検索条件 */
    private LoginCondition _condition;

    /** エラー情報 */
    ErrorInfo _errorInfo = null;

    /** スーパーユーザー情報 */
    ThbdSpUsVO _superUserInfo = null;

    /** 特別ログインユーザー情報リスト */
    List<ThbdSpUsVO> _specialLoginUserInfoList = null;

    /** 営業所情報（通常ユーザー） */
    RcmnMeu00SikVO _meu00SikVO = null;

    /** 対象取引先担当情報格納リスト */
    List<RcmnMeu14ThstntTrVO> _subjectMeu14ThstntTrVOList = null;

    /** ログイン得意先情報リスト */
    List<LoginCustomerInfoVO> _customerInfoVOList = null;

    /**
     * 検索条件を使用し、検索処理を実行します。
     *
     * @throws KKHException 検索に失敗した場合
     */
    public void execute() throws KKHException {

        //職位等級グループコード
        List<String> groupCdList = new ArrayList<String>();
        //組織コード
        String organizationCode = null;

        //入力チェック
        checkInput();

        //ユーザー種別判定
        String userType = judgeUserType();

        //通常ユーザーの場合
        if (KKHConstants.USER_KIND_NORMAL.equals(userType)) {
            //職位等級グループコード取得
            groupCdList = getGroupCdList();

            //営業所情報取得
            _meu00SikVO = getBusinessOfficeInfo();

            //局権限の場合
            if (KKHConstants.RELATIVE_AUTHORITY_KYOKU.equals(_condition.getRelativeAuthority())) {
                //組織コードの取得
                organizationCode = getOrganizationCode();
            }
        }

        //通常ユーザー、スーパーユーザーの場合
        if (KKHConstants.USER_KIND_NORMAL.equals(userType) || KKHConstants.USER_KIND_SUPER.equals(userType)) {
            //対象取引先担当情報格納リスト
            _subjectMeu14ThstntTrVOList = new ArrayList<RcmnMeu14ThstntTrVO>();

            //取引先担当情報取得
            List<RcmnMeu14ThstntTrVO> meu14ThstntTrVOList = getCustomerChargeInfo(userType);

            //得意先情報取得件数分ループ処理
            for (RcmnMeu14ThstntTrVO rcmnMeu14ThstntTrVO : meu14ThstntTrVOList) {
                // エラー情報を初期化
                _errorInfo = null;

                //スーパーユーザーの場合
                if (KKHConstants.USER_KIND_SUPER.equals(userType)) {
                    _subjectMeu14ThstntTrVOList.add(rcmnMeu14ThstntTrVO);
                    continue;
                }

                //特別得意先チェック
                if (checkSpecialCustomer(rcmnMeu14ThstntTrVO)) {
                    _subjectMeu14ThstntTrVOList.add(rcmnMeu14ThstntTrVO);
                    continue;
                }

                //局権限の場合
                if (KKHConstants.RELATIVE_AUTHORITY_KYOKU.equals(_condition.getRelativeAuthority())) {

                    //担当者組織チェック(局)
                    if (organizationCode.equals(rcmnMeu14ThstntTrVO.getSikcdKyk())) {
                        //信用コードチェック
                        if (!checkSinCd(rcmnMeu14ThstntTrVO.getSinCd())) {
                            _errorInfo = setErrorInfo("信用コードチェックエラー", "HB-W0107");
                        } else {
                            _subjectMeu14ThstntTrVOList.add(rcmnMeu14ThstntTrVO);
                        }
                        continue;
                    }

                //部権限の場合
                } else if (KKHConstants.RELATIVE_AUTHORITY_BU.equals(_condition.getRelativeAuthority())) {
                    //担当者組織チェック(部)
                    if (_condition.getOperationNo().equals(rcmnMeu14ThstntTrVO.getSikCdBu())) {
                        //信用コードチェック
                        if (!checkSinCd(rcmnMeu14ThstntTrVO.getSinCd())) {
                            throw new KKHException("信用コードチェックエラー", "HB-W0107");
                        } else {
                            _subjectMeu14ThstntTrVOList.add(rcmnMeu14ThstntTrVO);
                            continue;
                        }
                    }
                }

                //公開範囲得意先チェック
                _errorInfo = checkOpenRange(groupCdList, rcmnMeu14ThstntTrVO);
                if (_errorInfo != null){
                    continue;
                }

                //対象取引先担当情報格納リストに設定
                _subjectMeu14ThstntTrVOList.add(rcmnMeu14ThstntTrVO);
            }

            // 担当データが0件の場合
            if (_subjectMeu14ThstntTrVOList.size() == 0) {
                throw new KKHException(_errorInfo.getNote().get(0), _errorInfo.getErrorCode());
            }

            // ログイン得意先情報の設定
            _customerInfoVOList = setLoginCustomerInfo();

        // 特別ログインユーザーの場合
        } else {
            // ログイン得意先情報の設定
            _customerInfoVOList = setLoginCustomerInfoSpecialLogin();
        }

        // 主担当得意先INDEX取得
        int customerIndex = getMainCustomerIndex(userType);

        // 主担当得意先がある場合
        if (customerIndex != MAIN_CUSTOMER_NOT_EXIST) {
            //開放得意先情報存在チェック
            checkOpenCustomerInfo(userType, customerIndex);
        }

        /** 2017/02/08 得意先ログイン無効化対応 HLC K.Soga ADD Start */
        //得意先廃止チェック
        checkRepeal(userType);
        /** 2017/02/08 得意先ログイン無効化対応 HLC K.Soga ADD End */

        //返却値設定
        LoginResult result = setResult(userType, customerIndex);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 検索条件を設定します。
     *
     * @param condition 検索条件
     */
    public void setLoginCondition(LoginCondition condition) {
        _condition = condition;
    }

    /**
     * 検索結果を返します。
     *
     * @return 検索結果
     */
    public LoginResult getLoginResult() {
        return (LoginResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * パラメータ入力チェック
     *
     * @throws KKHException パラメータ指定エラーの場合
     */
    private void checkInput() throws KKHException {

        if (StringUtil.isBlank(_condition.getEsqId())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getOperationNo())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getUserId())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getCustomerCode())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getNormalUserFlag())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getOrganizationCode())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getEigyoBi())) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
    }

    /**
     * ユーザー種別判定
     *
     * @throws KKHException 処理中にエラーが発生した場合
     */
    private String judgeUserType() throws KKHException {

        //通常ユーザー
        if (KKHConstants.FLAG_ON.equals(_condition.getNormalUserFlag())) {
            return KKHConstants.USER_KIND_NORMAL;
        }

        //スーパーユーザー
        _superUserInfo = getSuperUserInfo();
        if (_superUserInfo != null) {
            return KKHConstants.USER_KIND_SUPER;
        }

        //特別ログインユーザー
        _specialLoginUserInfoList = getSpecialLoginUserInfo();
        return KKHConstants.USER_KIND_SPECIAL_LOGIN;
    }

    /**
     * スーパーユーザー情報取得
     *
     * @return スーパーユーザー情報VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    private ThbdSpUsVO getSuperUserInfo() throws KKHException {

        ThbdSpUsCondition cond = new ThbdSpUsCondition();
        cond.setUserId(_condition.getUserId());
        LoginManager manager = LoginManager.getInstance();
        ThbdSpUsVO vo = manager.getSuperUserInfo(cond);

        // データがあり、かつパスワードが一致した場合
        if (vo != null && vo.getPassword().equals(_condition.getPassword())) {
            return vo;
        } else {
            return null;
        }
    }

    /**
     * 特別ログインユーザー情報取得
     *
     * @return 特別ログインユーザー情報VOリスト
     * @throws KKHException 対象データが存在しない場合
     */
    private List<ThbdSpUsVO> getSpecialLoginUserInfo() throws KKHException {

        ThbdSpUsCondition cond = new ThbdSpUsCondition();
        cond.setTksKgyCd(_condition.getCustomerCode().substring(0, 6));
        cond.setTksBmnSeqNo(_condition.getCustomerCode().substring(6, 8));
        LoginManager manager = LoginManager.getInstance();
        List<ThbdSpUsVO> list = manager.getSpecialLoginUserInfo(cond);

        List<ThbdSpUsVO> subjectList = new ArrayList<ThbdSpUsVO>();
        for (int i = 0; i < list.size(); i++) {
            ThbdSpUsVO vo = list.get(i);

            // ユーザーID、パスワードが一致した場合
            if (vo.getUserId().equals(_condition.getUserId()) && vo.getPassword().equals(_condition.getPassword())) {
                subjectList.add(vo);
            }
        }

        //対象データがない場合
        if (subjectList.size() == 0) {
            throw new KKHException("特別ログインユーザー情報取得エラー", "HB-W0104");
        }

        return subjectList;
    }

    /**
     * 職位等級グループコード取得
     *
     * @return 職位等級グループコード
     * @throws KKHException 処理中にエラーが発生した場合
     */
    private List<String> getGroupCdList() throws KKHException {

        Vkj02TitleClassGroupInfoCondition cond = new Vkj02TitleClassGroupInfoCondition();
        cond.setEsqId(_condition.getEsqId());
        cond.setEigyoBi(_condition.getEigyoBi());
        LoginManager manager = LoginManager.getInstance();
        List<Vkj02TitleClassGroupInfoVO> voList = manager.getGroupInfo(cond);

        //職位等級グループコードを設定
        List<String> groupCdList = new ArrayList<String>();
        for (Vkj02TitleClassGroupInfoVO vo : voList) {
            groupCdList.add(vo.getGroupCd());
        }
        return groupCdList;
    }

    /**
     * 営業所情報取得
     *
     * @return 営業所情報VO
     * @throws KKHException 対象データが存在しない場合
     */
    private RcmnMeu00SikVO getBusinessOfficeInfo() throws KKHException {

        RcmnMeu00SikCondition cond = new RcmnMeu00SikCondition();
        cond.setOperationNo(_condition.getOperationNo());
        cond.setEigyoBi(_condition.getEigyoBi());
        LoginManager manager = LoginManager.getInstance();
        RcmnMeu00SikVO vo = manager.getBusinessOfficeInfo(cond);

        // データがない場合
        if (vo == null) {
            throw new KKHException("営業所情報取得エラー", "HB-E0015");
        }
        return vo;
    }

    /**
     * 取引先担当情報取得
     *
     * @param userType ユーザー種別
     * @return 取引先担当情報VO
     * @throws KKHException 対象データが存在しない場合
     */
    private List<RcmnMeu14ThstntTrVO> getCustomerChargeInfo(String userType) throws KKHException {

        RcmnMeu14ThstntTrCondition cond = new RcmnMeu14ThstntTrCondition();
        //通常ユーザーの場合
        if (KKHConstants.USER_KIND_NORMAL.equals(userType)) {
            cond.setEgCd(_meu00SikVO.getEgsyoCd());
        //スーパーユーザーの場合
        } else if (KKHConstants.USER_KIND_SUPER.equals(userType)) {
            cond.setEgCd(_superUserInfo.getEgsCd());
        }
        cond.setTksKgyCd(_condition.getCustomerCode().substring(0, 6));
        cond.setTksBmnSeqNo(_condition.getCustomerCode().substring(6, 8));
        cond.setEigyoBi(_condition.getEigyoBi());
        LoginManager manager = LoginManager.getInstance();
        List<RcmnMeu14ThstntTrVO> list = manager.getCustomerChargeInfo(cond);

        // データがない場合
        if (list.size() == 0) {
            throw new KKHException("取引先担当情報取得エラー", "HB-W0105");
        }
        return list;
    }

    /**
     * 特別得意先チェック
     *
     * @param rcmnMeu14ThstntTrVO 取引先担当情報
     * @return true：特別得意先、false：その他
     * @throws KKHException 処理中にエラーが発生した場合
     */
    private boolean checkSpecialCustomer(RcmnMeu14ThstntTrVO rcmnMeu14ThstntTrVO) throws KKHException {

        ThbdSpUsCondition cond = new ThbdSpUsCondition();
        cond.setTksKgyCd(rcmnMeu14ThstntTrVO.getThskgyCd());
        cond.setTksBmnSeqNo(rcmnMeu14ThstntTrVO.getSeqNo());
        cond.setTksTntSeqNo(rcmnMeu14ThstntTrVO.getTrtntSeqNo());
        cond.setSikCd(_condition.getOperationNo());
        cond.setUserId(_condition.getUserId());
        LoginManager manager = LoginManager.getInstance();
        ThbdSpUsVO vo = manager.getSpecialCustomerInfo(cond);

        // データがない場合
        if (vo == null) {
            return false;
        }
        return true;
    }

    /**
     * 組織コード取得
     *
     * @return 組織コード
     * @throws KKHException 処理中にエラーが発生した場合
     */
    private String getOrganizationCode() throws KKHException {

        // 局所属の場合
        if (KAISO_CD_KYOKU.equals(_meu00SikVO.getKaisoCd())) {
            // 運用No(組織コード
            return _condition.getOperationNo();
            // 部所属の場合
        } else {
            // 経理組織展開情報取得
            RcmnMeu07SikkrsprdVO rcmnMeu07SikkrsprdVO = getAccountingOrganizationInfo(_meu00SikVO.getJSikCd(),
            _meu00SikVO.getEgsyoCd());

            // 上位組織コード(局)
            return rcmnMeu07SikkrsprdVO.getSikCdKyk();
        }
    }

    /**
     * 経理組織展開情報取得
     *
     * @param higherOrganizationCode 上位組織コード
     * @param egCd 営業所コード
     * @return 経理組織展開情報VO
     * @throws KKHException 対象データが存在しない場合
     */
    private RcmnMeu07SikkrsprdVO getAccountingOrganizationInfo(String higherOrganizationCode, String egCd)
            throws KKHException {

        RcmnMeu07SikkrsprdCondition cond = new RcmnMeu07SikkrsprdCondition();
        cond.setHigherOrganizationCode(higherOrganizationCode);
        cond.setEgCd(egCd);
        cond.setEigyoBi(_condition.getEigyoBi());
        LoginManager manager = LoginManager.getInstance();
        RcmnMeu07SikkrsprdVO vo = manager.getAccountingOrganizationInfo(cond);

        // データがない場合
        if (vo == null) {
            throw new KKHException("上位組織情報取得エラー", "HB-E0016");
        }

        return vo;
    }

    /**
     * 公開範囲得意先チェック
     *
     * @param groupCdList 職位グループコード
     * @param rcmnMeu14ThstntTrVO 取引先担当情報
     * @return エラー情報
     * @throws KKHException 対象データが存在しない場合
     */
    private ErrorInfo checkOpenRange(List<String> groupCdList, RcmnMeu14ThstntTrVO rcmnMeu14ThstntTrVO) throws KKHException {

        Tcm01KkhCondition cond = new Tcm01KkhCondition();
        cond.setHigherOrganizationCode(_meu00SikVO.getJSikCd());
        cond.setOperationNo(_condition.getOperationNo());
        StringBuffer buffer = new StringBuffer();
        if (groupCdList.size() == 0) {
            buffer.append("'*'");
        } else {
            for (String groupCd : groupCdList) {
                buffer.append("'" + groupCd + "',");
            }
            buffer.append("'*'");
        }
        cond.setGroupCd(buffer.toString());
        cond.setTntCd("'" + _condition.getUserId() + "', '*'");
        cond.setCustomerCode(rcmnMeu14ThstntTrVO.getThskgyCd() + rcmnMeu14ThstntTrVO.getSeqNo()
                + rcmnMeu14ThstntTrVO.getTrtntSeqNo());
        cond.setEigyoBi(_condition.getEigyoBi());
        cond.setTermBegin(DateUtil.getTermBegin(_condition.getEigyoBi()));
        cond.setTermEnd(DateUtil.getTermEnd(_condition.getEigyoBi()));

        LoginManager manager = LoginManager.getInstance();
        Tcm01KkhVO vo = manager.getOpenRange(cond);

        // データが0件の場合
        if (vo == null) {
            return setErrorInfo("公開範囲情報取得エラー", "HB-W0106");
        }

        // 信用コードチェック
        if (checkSinCd(rcmnMeu14ThstntTrVO.getSinCd()) == false) {
            return setErrorInfo("信用コードチェックエラー", "HB-W0107");
        }

        return null;
    }

    /**
     * 開放得意先情報存在チェック
     *
     * @param userType ユーザー種別
     * @parama customerIndex 主担当得意先INDEX
     * @return 開放得意先情報VO
     * @throws KKHException 対象データが存在しない場合
     */
    private void checkOpenCustomerInfo(String userType, int customerIndex) throws KKHException {

        ThbcKhtCondition cond = new ThbcKhtCondition();

        //通常ユーザーの場合
        if (KKHConstants.USER_KIND_NORMAL.equals(userType)) {
            cond.setEgCd(_meu00SikVO.getEgsyoCd());
        //スーパーユーザーの場合
        } else if (KKHConstants.USER_KIND_SUPER.equals(userType)) {
            cond.setEgCd(_superUserInfo.getEgsCd());
        //特別ログインユーザーの場合
        } else {
            cond.setEgCd(_specialLoginUserInfoList.get(0).getEgsCd());
        }
        cond.setKgyCd(_customerInfoVOList.get(customerIndex).getTksKgyCd());
        cond.setBmnSeqNo(_customerInfoVOList.get(customerIndex).getTksBmnSeqNo());
        cond.setTntSeqNo(_customerInfoVOList.get(customerIndex).getTksTntSeqNo());
        LoginManager manager = LoginManager.getInstance();
        ThbcKhtVO vo = manager.getOpenCustomerInfo(cond);

        //データがない場合
        if (vo == null) {
            throw new KKHException("開放得意先情報取得エラー", "HB-W0108");
        }
    }

    /**
     * 信用コードチェック
     *
     * @param sinCd 信用コード
     * @return true：OK、false：NG
     */
    private boolean checkSinCd(String sinCd) {

        String subjectCode = sinCd.substring(0, 1);
        for (int i = 0; i < SINCD_NOT_SUBJECT.length; i++) {
            if (SINCD_NOT_SUBJECT[i].equals(subjectCode) == true) {
                return false;
            }
        }
        return true;
    }

    /**
     * 主担当得意先INDEX取得
     *
     * @param userType ユーザー種別
     * @return 主担当得意先INDEX
     */
    private int getMainCustomerIndex(String userType) {

        //1件のみの場合
        if (_customerInfoVOList.size() == 1) {
            return 0;
        }

        //特別ログインユーザーの場合
        if (KKHConstants.USER_KIND_SPECIAL_LOGIN.equals(userType)) {
            for (int i = 0; i < _specialLoginUserInfoList.size(); i++) {
                ThbdSpUsVO vo = _specialLoginUserInfoList.get(i);
                if (vo.getSikCd().equals(_condition.getOrganizationCode())) {
                    return i;
                }
            }
        //その他のユーザーの場合
        } else {
            for (int i = 0; i < _subjectMeu14ThstntTrVOList.size(); i++) {
                RcmnMeu14ThstntTrVO vo = _subjectMeu14ThstntTrVOList.get(i);
                if (vo.getSikCd().equals(_condition.getOrganizationCode())) {
                    return i;
                }
            }
        }

        //主担当得意先なし
        return MAIN_CUSTOMER_NOT_EXIST;
    }

    /**
     * ログイン得意先情報設定
     *
     * @return ログイン得意先情報
     */
    private List<LoginCustomerInfoVO> setLoginCustomerInfo() {

        List<LoginCustomerInfoVO> customerInfoVOList = new ArrayList<LoginCustomerInfoVO>();

        for (RcmnMeu14ThstntTrVO meu14ThstntTrVO : _subjectMeu14ThstntTrVOList) {
            LoginCustomerInfoVO customerInfoVO = new LoginCustomerInfoVO();
            customerInfoVO.setTksKgyCd(meu14ThstntTrVO.getThskgyCd());
            customerInfoVO.setTksBmnSeqNo(meu14ThstntTrVO.getSeqNo());
            customerInfoVO.setTksTntSeqNo(meu14ThstntTrVO.getTrtntSeqNo());
            customerInfoVO.setDispTksCd(meu14ThstntTrVO.getThskgyCd() + meu14ThstntTrVO.getSeqNo() + "-" + meu14ThstntTrVO.getTrtntSeqNo());
            customerInfoVO.setDispTksName(meu14ThstntTrVO.getThskgyDispKj() + meu14ThstntTrVO.getSubMei());
            customerInfoVO.setDispTntSikName(meu14ThstntTrVO.getBuHyojiKj());
            customerInfoVOList.add(customerInfoVO);
        }
        return customerInfoVOList;
    }

    /**
     * ログイン得意先情報設定(特別ログインユーザー)
     *
     * @return ログイン得意先情報
     */
    private List<LoginCustomerInfoVO> setLoginCustomerInfoSpecialLogin() {

        List<LoginCustomerInfoVO> customerInfoVOList = new ArrayList<LoginCustomerInfoVO>();

        for (ThbdSpUsVO thbdSpUsVO : _specialLoginUserInfoList) {
            LoginCustomerInfoVO customerInfoVO = new LoginCustomerInfoVO();
            customerInfoVO.setTksKgyCd(thbdSpUsVO.getTksKgyCd());
            customerInfoVO.setTksBmnSeqNo(thbdSpUsVO.getTksBmnSeqNo());
            customerInfoVO.setTksTntSeqNo(thbdSpUsVO.getTksTntSeqNo());
            customerInfoVO.setDispTksCd(thbdSpUsVO.getTksKgyCd() + thbdSpUsVO.getTksBmnSeqNo() + "-" + thbdSpUsVO.getTksTntSeqNo());
            customerInfoVO.setDispTksName(thbdSpUsVO.getTksKgyNm() + thbdSpUsVO.getTksBmnNm());
            customerInfoVO.setDispTntSikName(thbdSpUsVO.getTksTntNm());
            customerInfoVOList.add(customerInfoVO);
        }
        return customerInfoVOList;
    }

    /**
     * エラー情報設定(エラー)
     *
     * @param message メッセージ
     * @param errorID エラーコード
     * @return エラー情報
     */
    private ErrorInfo setErrorInfo(String message, String errorID) {

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setError(true);
        errorInfo.setErrorCode(errorID);
        List<String> list = new ArrayList<String>();
        list.add(message);
        errorInfo.setNote(list);
        return errorInfo;
    }

    /**
     * 返却値設定
     *
     * @param userType ユーザー種別
     * @param customerIndex 主担当得意先INDEX
     * @return ログイン情報
     */
    private LoginResult setResult(String userType, int customerIndex) {

        LoginResult result = new LoginResult();

        //通常ユーザーの場合
        if (KKHConstants.USER_KIND_NORMAL.equals(userType) == true) {
            result.setEgCd(_meu00SikVO.getEgsyoCd());
            result.setUserName(null);
        //スーパーユーザーの場合
        } else if (KKHConstants.USER_KIND_SUPER.equals(userType) == true) {
            result.setEgCd(_superUserInfo.getEgsCd());
            result.setUserName(_superUserInfo.getUserNmKj());
        //特別ログインユーザーの場合
        } else {
            result.setEgCd(_specialLoginUserInfoList.get(0).getEgsCd());
            result.setUserName(_specialLoginUserInfoList.get(0).getUserNmKj());
        }

        //1件の場合、また複数件で主担当得意先がない場合
        if (_customerInfoVOList.size() == 1 || customerIndex == MAIN_CUSTOMER_NOT_EXIST) {
            result.setLoginCustomerInfoVOList(_customerInfoVOList);
        //複数件で主担当得意先がある場合
        } else {
            List<LoginCustomerInfoVO> subjectCustomerInfoVOList = new ArrayList<LoginCustomerInfoVO>();
            subjectCustomerInfoVOList.add(_customerInfoVOList.get(customerIndex));
            result.setLoginCustomerInfoVOList(subjectCustomerInfoVOList);
        }

        //ユーザータイプのセット
        result.set_SystemAdministerFlg(userType);

        return result;
    }

    /** 2017/02/08 得意先ログイン無効化対応 HLC K.Soga ADD Start */
    /**
     * 得意先廃止チェック
     * @param userType ユーザー種別
     * @return ログイン情報
     */
    private void checkRepeal(String userType) throws KKHException{
        //初期設定
        CommonDAO commonDao = CommonDAOFactory.createCommonDAO();
        CommonCondition commonCond = new CommonCondition();

        //通常ユーザーの場合
        if (KKHConstants.USER_KIND_NORMAL.equals(userType)) {
            commonCond.setEgCd(_meu00SikVO.getEgsyoCd());
        //スーパーユーザーの場合
        } else if (KKHConstants.USER_KIND_SUPER.equals(userType)) {
            commonCond.setEgCd(_superUserInfo.getEgsCd());
        //特別ログインユーザーの場合
        } else {
            commonCond.setEgCd(_specialLoginUserInfoList.get(0).getEgsCd());
        }

        //得意先情報件数分ループ処理
        for(int i = 0; i < _customerInfoVOList.size(); i++){
            commonCond.setTksKgyCd(_customerInfoVOList.get(i).getTksKgyCd());
            commonCond.setTksBmnSeqNo(_customerInfoVOList.get(i).getTksBmnSeqNo());
            commonCond.setTksTntSeqNo(_customerInfoVOList.get(i).getTksTntSeqNo());
            commonCond.setSybt(KKHConstants.SYBT_REPEALFLG);
            commonCond.setfield1(KKHConstants.FIELD1_REPEALFLG);
            List<CommonVO> commonVoList = commonDao.findCommonByCondition(commonCond);

            //取得した汎用テーブルマスタ件数が0件の場合スキップする
            if(commonVoList.size() == 0){
                //ユーザー種別が通常ユーザーの場合
                if(KKHConstants.USER_KIND_NORMAL.equals(userType)){
                    throw new KKHException("得意先廃止設定エラー", "HB-W0168");
                }

                continue;
            }
            
            //取得した廃止フラグが[0]の場合
            if (commonVoList.get(0).getField2().equals(KKHConstants.FLAG_ON)) {
                throw new KKHException("得意先廃止エラー", "HB-W0167");
            }
        }
    }
    /** 2017/02/08 得意先ログイン無効化対応 HLC K.Soga ADD End */
}