package jp.co.isid.kkh.model.detail;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.common.CommonCondition;
import jp.co.isid.kkh.model.common.CommonDAO;
import jp.co.isid.kkh.model.common.CommonDAOFactory;
import jp.co.isid.kkh.model.common.CommonVO;
import jp.co.isid.kkh.model.common.ExecProcedureDAO;
import jp.co.isid.kkh.model.common.ExecProcedureDAOFactory;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.kkh.util.constants.KKHConstants;

/**
 * <P>
 * 広告費明細入力Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/08 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class DetailManager {

    /** 受注削除フラグ：ＯＮ */
    private static final String JYUTDELFLG_ON = "1";

    /** 中止区分：中止 */
    private static final String STPKBN_STOP = "1";

    /** シングルトンインスタンス */
    private static DetailManager _manager = new DetailManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private DetailManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static DetailManager getInstance() {
        return _manager;
    }

    //**********************************************************************************************************************************************************************************
    //一括登録
    /**
     * ダウンロードデータの更新(明細登録時)
     *
     * @param cond 受注ダウンロードデータVO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void updateThb1DownForDisplayData(Thb1DownVO vo) throws KKHException {
        List<Thb2KmeiVO> vo2 = null;
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();
        thb1DownDao.updateThb1DownForDisplayData(vo,vo2);
    }

    /**
     * ダウンロードデータの更新
     *
     * @param cond 受注ダウンロードデータVO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void updateTourokuIkkatsuKoTaiou(Thb1DownVO vo1) throws KKHException {
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();
        thb1DownDao.updateTourokuKousinTaiou(vo1);
    }

    /**
     * ダウンロードデータの排他検索(明細登録時)
     *
     * @param cond 受注ダウンロードデータVO（検索用）
     * @return 受注ダウンロードデータリスト
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public List<Thb1DownVO> lockThb1Down(Thb1DownVO cond) throws KKHException {

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();
        return dao.lockThb1Down(cond);
    }

    /**
     * 広告費明細データの排他検索(明細登録時)
     *
     * @param cond 広告費明細データVO（検索用）
     * @return 広告費明細データリスト
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public List<Thb2KmeiVO> lockThb2Kmei(Thb2KmeiVO cond) throws KKHException {

        Thb2KmeiDAO dao = Thb2KmeiDAOFactory.createThb2KmeiDAO();
        return dao.lockThb2Kmei(cond);
    }

    /**
     * 履歴テーブルの更新(一括登録)
     *
     * @param cond 受注ダウンロードデータVO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void updateThb8RirekiForDisplayData(Thb1DownVO vo) throws KKHException {

        //明細登録日時の取得
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String meiTimStmp = sdf.format(new Date());

        //受注ダウンロードテーブル(親)
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();
        List<Thb1DownVO> thb1List = thb1DownDao.lockThb1Down(vo);

        List<Thb1DownVO> thb1ChildList = new ArrayList<Thb1DownVO>();

        //更新対象の受注ダウンロードデータが「統合」データの場合、統合前の(子)データを更新する
        if (vo.getHb1TouFlg().equals("1")){

            //受注ダウンロード履歴データ更新
            for(Thb1DownVO thb1DownVo : thb1ChildList){
                Thb8DownRDAO thb8DownRDao = Thb8DownRDAOFactory.createThb8DownRDAO();
                Thb8DownRCondition thb8DownCond = new Thb8DownRCondition();
                Thb8DownRVO thb8DownRVo = new Thb8DownRVO();
                //更新条件設定
                thb8DownCond.setEgCd(thb1DownVo.getHb1EgCd());
                thb8DownCond.setTksKgyCd(thb1DownVo.getHb1TksKgyCd());
                thb8DownCond.setTksBmnSeqNo(thb1DownVo.getHb1TksBmnSeqNo());
                thb8DownCond.setTksTntSeqNo(thb1DownVo.getHb1TksTntSeqNo());
                thb8DownCond.setYymm(thb1DownVo.getHb1Yymm());
                thb8DownCond.setJyutNo(thb1DownVo.getHb1JyutNo());
                thb8DownCond.setJyMeiNo(thb1DownVo.getHb1JyMeiNo());
                thb8DownCond.setUrMeiNo(thb1DownVo.getHb1UrMeiNo());
                thb8DownCond.setFileTimStmp(thb1DownVo.getHb1FileTimStmp());
                //更新値設定
                thb8DownRVo.setHb8UpdApl(vo.getHb1UpdApl());
                thb8DownRVo.setHb8UpdTnt(vo.getHb1UpdTnt());
                thb8DownRVo.setHb8FileTimStmp(thb1DownVo.getHb1FileTimStmp());
                thb8DownRVo.setHb8MeiTimStmp(meiTimStmp);

                thb8DownRDao.updateThb8DownRForDisplayData(thb8DownRVo, thb8DownCond);
            }
        }else{
            //受注ダウンロード履歴データ更新
            Thb8DownRDAO thb8DownRDao = Thb8DownRDAOFactory.createThb8DownRDAO();
            Thb8DownRCondition thb8DownCond = new Thb8DownRCondition();
            Thb8DownRVO thb8DownRVo = new Thb8DownRVO();
            thb8DownCond.setEgCd(thb1List.get(0).getHb1EgCd());
            thb8DownCond.setTksKgyCd(thb1List.get(0).getHb1TksKgyCd());
            thb8DownCond.setTksBmnSeqNo(thb1List.get(0).getHb1TksBmnSeqNo());
            thb8DownCond.setTksTntSeqNo(thb1List.get(0).getHb1TksTntSeqNo());
            thb8DownCond.setYymm(thb1List.get(0).getHb1Yymm());
            thb8DownCond.setJyutNo(thb1List.get(0).getHb1JyutNo());
            thb8DownCond.setJyMeiNo(thb1List.get(0).getHb1JyMeiNo());
            thb8DownCond.setUrMeiNo(thb1List.get(0).getHb1UrMeiNo());
            thb8DownCond.setFileTimStmp(thb1List.get(0).getHb1FileTimStmp());

            //更新値設定
            thb8DownRVo.setHb8UpdApl(vo.getHb1UpdApl());
            thb8DownRVo.setHb8UpdTnt(vo.getHb1UpdTnt());
            thb8DownRVo.setHb8FileTimStmp(thb1List.get(0).getHb1FileTimStmp());
            thb8DownRVo.setHb8MeiTimStmp(meiTimStmp);

            thb8DownRDao.updateThb8DownRForDisplayData(thb8DownRVo, thb8DownCond);
        }
    }

    //**********************************************************************************************************************************************************************************
    //明細登録
    /**
     * 表示データ登録
     * @param vo
     * @throws KKHException
     */
    public DetailUpdateDataResult updateDisplayData(DetailUpdateDataVO vo) throws KKHException{

        DetailUpdateDataResult result = new DetailUpdateDataResult();
        List<Thb2KmeiVO> resThb2KmeiList = new ArrayList<Thb2KmeiVO>();

        //DAO
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();
        Thb2KmeiDAO thb2KmeiDao = Thb2KmeiDAOFactory.createThb2KmeiDAO();

        //削除・排他データ取得条件
        Thb2KmeiVO deleteThb2KmeiCond = new Thb2KmeiVO();


        //*********************************************************************************************************
        //排他制御
        //*********************************************************************************************************
        //受注ダウンロードテーブル(親)
        List<Thb1DownVO> thb1List = thb1DownDao.lockThb1Down(vo.getThb1Down());
        if (thb1List.size() <= 0 || vo.getMaxUpdDate().compareTo(thb1List.get(0).getHb1TimStmp()) < 0 ){
            throw new KKHException("排他エラー", "LOCK-E0001");//TODO エラーコード
        }

        List<Thb1DownVO> thb1ChildList = new ArrayList<Thb1DownVO>();
        if (vo.getThb1Down().getHb1TouFlg().equals("1")){
            //受注ダウンロードテーブル(子)
            thb1ChildList = thb1DownDao.lockThb1DownForChild(vo.getThb1Down());
            if (thb1ChildList.size() <= 0 || vo.getMaxUpdDate().compareTo(thb1ChildList.get(0).getHb1TimStmp()) < 0 ){
                throw new KKHException("排他エラー", "LOCK-E0001");//TODO エラーコード
            }
        }

        //広告費明細テーブル
        deleteThb2KmeiCond.setHb2EgCd(vo.getThb1Down().getHb1EgCd());
        deleteThb2KmeiCond.setHb2TksKgyCd(vo.getThb1Down().getHb1TksKgyCd());
        deleteThb2KmeiCond.setHb2TksBmnSeqNo(vo.getThb1Down().getHb1TksBmnSeqNo());
        deleteThb2KmeiCond.setHb2TksTntSeqNo(vo.getThb1Down().getHb1TksTntSeqNo());
        deleteThb2KmeiCond.setHb2Yymm(vo.getThb1Down().getHb1Yymm());
        deleteThb2KmeiCond.setHb2JyutNo(vo.getThb1Down().getHb1JyutNo());
        deleteThb2KmeiCond.setHb2JyMeiNo(vo.getThb1Down().getHb1JyMeiNo());
        deleteThb2KmeiCond.setHb2UrMeiNo(vo.getThb1Down().getHb1UrMeiNo());
        List<Thb2KmeiVO> thb2List = thb2KmeiDao.lockThb2Kmei(deleteThb2KmeiCond);
        if (thb2List.size() > 0 && vo.getMaxUpdDate().compareTo(thb2List.get(0).getHb2TimStmp()) < 0 ){
            throw new KKHException("排他エラー", "LOCK-E0001");//TODO エラーコード
        }

//    	updThb1DownCond.setHb1EgCd(vo.getThb1Down().getHb1EgCd());
//    	updThb1DownCond.setHb1TksKgyCd(vo.getThb1Down().getHb1TksKgyCd());
//    	updThb1DownCond.setHb1TksBmnSeqNo(vo.getThb1Down().getHb1TksBmnSeqNo());
//    	updThb1DownCond.setHb1TksTntSeqNo(vo.getThb1Down().getHb1TksTntSeqNo());
//    	updThb1DownCond.setHb1Yymm(vo.getThb1Down().getHb1Yymm());
//    	updThb1DownCond.setHb1JyutNo(vo.getThb1Down().getHb1JyutNo());
//    	updThb1DownCond.setHb1JyMeiNo(vo.getThb1Down().getHb1JyMeiNo());
//    	updThb1DownCond.setHb1UrMeiNo(vo.getThb1Down().getHb1UrMeiNo());


        //*********************************************************************************************************
        //データ登録・更新
        //*********************************************************************************************************
        //明細登録日時の取得
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String meiTimStmp = sdf.format(new Date());

        //広告費明細データ削除
        thb2KmeiDao.deleteThb2KmeiByCondition(deleteThb2KmeiCond);

        //広告費明細データが存在する場合のみ更新
        if (vo.getThb2Kmei() != null && vo.getThb2Kmei().size() > 0){
            //広告費明細データ登録
            for (Thb2KmeiVO thb2KmeiVO : vo.getThb2Kmei()) {
                thb2KmeiDao.insertThb2Kmei(thb2KmeiVO);
                //登録データの取得
                resThb2KmeiList.add(thb2KmeiDao.loadThb2Kmei(thb2KmeiVO));
            }
            result.setThb2Kmei(resThb2KmeiList);


            //登録データの取得
            for (Thb1DownVO Thb1DownVO : thb1List) {
                result.setThb1Down(thb1DownDao.loadThb1Down(Thb1DownVO));
            }

            //更新対象の受注ダウンロードデータが「統合」データの場合、統合前の(子)データを更新する
            if (vo.getThb1Down().getHb1TouFlg().equals("1")){
                //受注ダウンロードデータ更新
                thb1DownDao.updateThb1DownForDisplayDataChild(vo.getThb1Down());

                //受注ダウンロード履歴データ更新
                for(Thb1DownVO thb1DownVo : thb1ChildList){
                    Thb8DownRDAO thb8DownRDao = Thb8DownRDAOFactory.createThb8DownRDAO();
                    Thb8DownRCondition thb8DownCond = new Thb8DownRCondition();
                    Thb8DownRVO thb8DownRVo = new Thb8DownRVO();
                    //更新条件設定
                    thb8DownCond.setEgCd(thb1DownVo.getHb1EgCd());
                    thb8DownCond.setTksKgyCd(thb1DownVo.getHb1TksKgyCd());
                    thb8DownCond.setTksBmnSeqNo(thb1DownVo.getHb1TksBmnSeqNo());
                    thb8DownCond.setTksTntSeqNo(thb1DownVo.getHb1TksTntSeqNo());
                    thb8DownCond.setYymm(thb1DownVo.getHb1Yymm());
                    thb8DownCond.setJyutNo(thb1DownVo.getHb1JyutNo());
                    thb8DownCond.setJyMeiNo(thb1DownVo.getHb1JyMeiNo());
                    thb8DownCond.setUrMeiNo(thb1DownVo.getHb1UrMeiNo());
                    thb8DownCond.setFileTimStmp(thb1DownVo.getHb1FileTimStmp());
                    //更新値設定
                    thb8DownRVo.setHb8UpdApl(vo.getThb1Down().getHb1UpdApl());
                    thb8DownRVo.setHb8UpdTnt(vo.getThb1Down().getHb1UpdTnt());
                    thb8DownRVo.setHb8FileTimStmp(thb1DownVo.getHb1FileTimStmp());
                    thb8DownRVo.setHb8MeiTimStmp(meiTimStmp);

                    thb8DownRDao.updateThb8DownRForDisplayData(thb8DownRVo, thb8DownCond);
                }
            }else{
                //受注ダウンロード履歴データ更新
                Thb8DownRDAO thb8DownRDao = Thb8DownRDAOFactory.createThb8DownRDAO();
                Thb8DownRCondition thb8DownCond = new Thb8DownRCondition();
                Thb8DownRVO thb8DownRVo = new Thb8DownRVO();
                thb8DownCond.setEgCd(thb1List.get(0).getHb1EgCd());
                thb8DownCond.setTksKgyCd(thb1List.get(0).getHb1TksKgyCd());
                thb8DownCond.setTksBmnSeqNo(thb1List.get(0).getHb1TksBmnSeqNo());
                thb8DownCond.setTksTntSeqNo(thb1List.get(0).getHb1TksTntSeqNo());
                thb8DownCond.setYymm(thb1List.get(0).getHb1Yymm());
                thb8DownCond.setJyutNo(thb1List.get(0).getHb1JyutNo());
                thb8DownCond.setJyMeiNo(thb1List.get(0).getHb1JyMeiNo());
                thb8DownCond.setUrMeiNo(thb1List.get(0).getHb1UrMeiNo());
                thb8DownCond.setFileTimStmp(thb1List.get(0).getHb1FileTimStmp());

                //更新値設定
                thb8DownRVo.setHb8UpdApl(vo.getThb1Down().getHb1UpdApl());
                thb8DownRVo.setHb8UpdTnt(vo.getThb1Down().getHb1UpdTnt());
                thb8DownRVo.setHb8FileTimStmp(thb1List.get(0).getHb1FileTimStmp());
                thb8DownRVo.setHb8MeiTimStmp(meiTimStmp);

                thb8DownRDao.updateThb8DownRForDisplayData(thb8DownRVo, thb8DownCond);
            }

        }
        if (vo.getThb2Kmei() != null && vo.getThb2Kmei().size() > 0){
            //受注ダウンロードデータ更新
            vo.getThb1Down().setHb1MeiTimStmp(meiTimStmp);
            thb1DownDao.updateThb1DownForDisplayData(vo.getThb1Down(), vo.getThb2Kmei());
        }else{
            if(!vo.getThb1Down().getHb1KsnTntNm().equals(""))
            {
                //受注ダウンロードデータ更新
                vo.getThb1Down().setHb1MeiTimStmp(meiTimStmp);
                thb1DownDao.updateThb1DownForDisplayData(vo.getThb1Down(), vo.getThb2Kmei());
            }
        }

        //統合されている場合
        if(vo.getTouKouThb1Down() != null)
        {
            if(!vo.getTouKouThb1Down().getHb1TrkTntNm().equals("") || !vo.getTouKouThb1Down().getHb1KsnTntNm().equals(""))
            {
                thb1DownDao.updateTourokuKousinTaiou(vo.getTouKouThb1Down());
            }

//    		if(vo.getTouKouThb1Down().getHb1TrkTntNm() != null || vo.getTouKouThb1Down().getHb1KsnTntNm() != null)
//    		{
//    			thb1DownDao.updateTourokuKousinTaiou(vo.getTouKouThb1Down());
//    		}
        }

        return result;
    }

    //**********************************************************************************************************************************************************************************
    //明細登録(一括)
    /**
     * 表示データ登録(一括)
     * @param vo
     * @throws KKHException
     */
    public DetailDataBulkUpdateResult bulkUpdateDetailData(DetailDataBulkUpdateVO vo) throws KKHException{

        DetailDataBulkUpdateResult result = new DetailDataBulkUpdateResult();

        for (DetailDataVO detailDataVo : vo.getDetailDataVOList()) {
            DetailUpdateDataVO detailUpdateVo = new DetailUpdateDataVO();

            detailUpdateVo.setEsqId(vo.getEsqId());
            detailUpdateVo.setThb1Down(detailDataVo.getThb1Down());
            detailUpdateVo.setThb2Kmei(detailDataVo.getThb2Kmei());
            detailUpdateVo.setMaxUpdDate(vo.getMaxUpdDate());

            updateDisplayData(detailUpdateVo);
        }

        return result;
    }

    //**********************************************************************************************************************************************************************************
    //明細検索(受注内容を検索条件に入れない)
    /**
     * 広告費明細データを検索します。
     *
     * @return DetailDataResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public DetailDataResult findDetailDataByCond(DetailDataCondition cond) throws KKHException {

        //検索結果
        DetailDataResult result = new DetailDataResult();

        //******************************************************
        //広告費明細データを取得
        //******************************************************
        Thb2KmeiDAO thb2KmeiDAO = Thb2KmeiDAOFactory.createThb2KmeiDAO();
        Thb2KmeiVO thb2KmeiCond = new Thb2KmeiVO();
        thb2KmeiCond.setHb2EgCd(cond.getEgCd());
        thb2KmeiCond.setHb2TksKgyCd(cond.getTksKgyCd());
        thb2KmeiCond.setHb2TksBmnSeqNo(cond.getTksBmnSeqNo());
        thb2KmeiCond.setHb2TksTntSeqNo(cond.getTksTntSeqNo());
        thb2KmeiCond.setHb2Yymm(cond.getYymm());
        thb2KmeiCond.setHb2JyutNo(cond.getJyutNo());
        thb2KmeiCond.setHb2JyMeiNo(cond.getJyMeiNo());
        thb2KmeiCond.setHb2UrMeiNo(cond.getUrMeiNo());

        List<Thb2KmeiVO> thb2KmeiList = thb2KmeiDAO.findThb2KmeiByCondCmn(thb2KmeiCond);
        result.setThb2KmeiList(thb2KmeiList);

        return result;
    }

    //**********************************************************************************************************************************************************************************
    //受注登録内容検索
    /**
     * 受注データを検索します。
     *
     * @return JyutyuDataResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public JyutyuDataCondResult findByCondition(JyutyuDataCondition cond) throws KKHException {

        //検索結果
        JyutyuDataCondResult result = new JyutyuDataCondResult();

        JyutyuDataDAO dao = JyutyuDataDAOFactory.createJyutyuDataDAO();

        //***********************************************************
        //汎用システムマスタの検索
        //(明細登録後の受注ダウンロード変更をチェックする項目の取得)
        //***********************************************************
        CommonDAO commonDao = CommonDAOFactory.createCommonDAO();
        CommonCondition commonCond = new CommonCondition();
        commonCond.setEgCd(cond.getEgCd());
        commonCond.setTksKgyCd(cond.getTksKgyCd());
        commonCond.setTksBmnSeqNo(cond.getTksBmnSeqNo());
        commonCond.setTksTntSeqNo(cond.getTksTntSeqNo());
        commonCond.setSybt("004");
        List<CommonVO> commonVoList = commonDao.findCommonByCondition(commonCond);

        //******************************************************
        //受注データを取得
        //******************************************************
        List<String> compareColumnList = new ArrayList<String>();
        for (CommonVO commonVO : commonVoList) {
            if (commonVO.getField2().equals("1") && StringUtil.isBlank(commonVO.getField1()) == false){
                compareColumnList.addAll(Arrays.asList(commonVO.getField1().split(",")));
            }
        }
        cond.setCompareColumnList(compareColumnList);
        if (compareColumnList.size() > 0){
            cond.setUpdPostFlag(true);
        }
        List<JyutyuDataVO> list = dao.findJyutyuDataCOMMONByCondition(cond);

        // 変更・削除チェックの場合
        if (cond.getUpdateCheckFlag() == true) {
            boolean updFlg = true;
            checkUpdate(cond, list ,updFlg);

            list = dao.findJyutyuDataCOMMONByCondition(cond);

            //更新フラグをfalseにする
            updFlg = false;
            //更新後の受注データを再取得する
            checkUpdate(cond, list ,updFlg);
        }

        result.setJutyuData(list);

        return result;
    }

    //**********************************************************************************************************************************************************************************
    //受注削除
    /**
     * 受注削除
     * @param vo
     * @throws KKHException
     */
    public void deleteJyutyuData(JyutyuDataDeleteVO vo) throws KKHException{

        //DAO
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();
        Thb2KmeiDAO thb2KmeiDao = Thb2KmeiDAOFactory.createThb2KmeiDAO();

        for (Thb1DownVO deleteThb1DownCond : vo.getThb1DownList()) {

            //削除・排他データ取得条件
            Thb2KmeiVO deleteThb2KmeiCond = new Thb2KmeiVO();

            //*********************************************************************************************************
            //排他制御
            //*********************************************************************************************************
            List<Thb1DownVO> thb1List = thb1DownDao.lockThb1DownForJyutyuDataDel(deleteThb1DownCond);
            if (thb1List.size() <= 0 || vo.getMaxUpdDate().compareTo(thb1List.get(0).getHb1TimStmp()) < 0 ){
                throw new KKHException("排他エラー", "LOCK-E0001");//TODO エラーコード
            }

            for (Thb1DownVO deleteThb1Down : thb1List) {
                deleteThb2KmeiCond.setHb2EgCd(deleteThb1Down.getHb1EgCd());
                deleteThb2KmeiCond.setHb2TksKgyCd(deleteThb1Down.getHb1TksKgyCd());
                deleteThb2KmeiCond.setHb2TksBmnSeqNo(deleteThb1Down.getHb1TksBmnSeqNo());
                deleteThb2KmeiCond.setHb2TksTntSeqNo(deleteThb1Down.getHb1TksTntSeqNo());
                deleteThb2KmeiCond.setHb2Yymm(deleteThb1Down.getHb1Yymm());
                deleteThb2KmeiCond.setHb2JyutNo(deleteThb1Down.getHb1JyutNo());
                deleteThb2KmeiCond.setHb2JyMeiNo(deleteThb1Down.getHb1JyMeiNo());
                deleteThb2KmeiCond.setHb2UrMeiNo(deleteThb1Down.getHb1UrMeiNo());
                List<Thb2KmeiVO> thb2List = thb2KmeiDao.lockThb2Kmei(deleteThb2KmeiCond);
                if (thb2List.size() > 0 && vo.getMaxUpdDate().compareTo(thb2List.get(0).getHb2TimStmp()) < 0 ){
                    throw new KKHException("排他エラー", "LOCK-E0001");//TODO エラーコード
                }
            }

            //*********************************************************************************************************
            //データ削除
            //*********************************************************************************************************
            for (Thb1DownVO deleteThb1Down : thb1List) {
                //広告費明細データ削除
                deleteThb2KmeiCond.setHb2EgCd(deleteThb1Down.getHb1EgCd());
                deleteThb2KmeiCond.setHb2TksKgyCd(deleteThb1Down.getHb1TksKgyCd());
                deleteThb2KmeiCond.setHb2TksBmnSeqNo(deleteThb1Down.getHb1TksBmnSeqNo());
                deleteThb2KmeiCond.setHb2TksTntSeqNo(deleteThb1Down.getHb1TksTntSeqNo());
                deleteThb2KmeiCond.setHb2Yymm(deleteThb1Down.getHb1Yymm());
                deleteThb2KmeiCond.setHb2JyutNo(deleteThb1Down.getHb1JyutNo());
                deleteThb2KmeiCond.setHb2JyMeiNo(deleteThb1Down.getHb1JyMeiNo());
                deleteThb2KmeiCond.setHb2UrMeiNo(deleteThb1Down.getHb1UrMeiNo());
                thb2KmeiDao.deleteThb2KmeiByCondition(deleteThb2KmeiCond);
            }

            //受注ダウンロードデータ更新
            thb1DownDao.deleteThb1DownByCondition(deleteThb1DownCond);
        }
    }

    //**********************************************************************************************************************************************************************************
    //年月変更
    /**
     * 請求年月変更
     * @param vo
     * @throws KKHException
     */
    public SeikyuYymmChangeResult changeSeikyuYymm(SeikyuYymmChangeVO vo) throws KKHException{

        SeikyuYymmChangeResult result = new SeikyuYymmChangeResult();
        List<Thb1DownVO> resThb1DownList = new ArrayList<Thb1DownVO>();

        //DAO
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();

        //*********************************************************************************************************
        //排他制御
        //*********************************************************************************************************
        for (Thb1DownVO thb1DownVo : vo.getThb1DownList()) {
            List<Thb1DownVO> thb1List = thb1DownDao.lockThb1Down(thb1DownVo);
            if (thb1List.size() <= 0 || vo.getMaxUpdDate().compareTo(thb1List.get(0).getHb1TimStmp()) < 0 ){
                throw new KKHException("排他エラー", "LOCK-E0001");//TODO エラーコード
            }
        }

        //*********************************************************************************************************
        //データ登録・更新
        //*********************************************************************************************************
        for (Thb1DownVO thb1DownVo : vo.getThb1DownList()) {
            Thb1DownVO updThb1DownVo = new Thb1DownVO();
            updThb1DownVo.setHb1TrkApl(thb1DownVo.getHb1TrkApl());	//登録プログラム
            updThb1DownVo.setHb1TrkTnt(thb1DownVo.getHb1TrkTnt());	//登録担当者
            updThb1DownVo.setHb1UpdApl(thb1DownVo.getHb1UpdApl());
            //updThb1DownVo.setHb1UpdTnt(vo.getEsqId());
            updThb1DownVo.setHb1UpdTnt(thb1DownVo.getHb1UpdTnt());
            updThb1DownVo.setHb1EgCd(thb1DownVo.getHb1EgCd());
            updThb1DownVo.setHb1TksKgyCd(thb1DownVo.getHb1TksKgyCd());
            updThb1DownVo.setHb1TksBmnSeqNo(thb1DownVo.getHb1TksBmnSeqNo());
            updThb1DownVo.setHb1TksTntSeqNo(thb1DownVo.getHb1TksTntSeqNo());
            updThb1DownVo.setHb1Yymm(vo.getYymmNew());
            updThb1DownVo.setHb1JyutNo(thb1DownVo.getHb1JyutNo());
            updThb1DownVo.setHb1JyMeiNo(thb1DownVo.getHb1JyMeiNo());
            updThb1DownVo.setHb1UrMeiNo(thb1DownVo.getHb1UrMeiNo());
            updThb1DownVo.setHb1TouFlg(thb1DownVo.getHb1TouFlg());
            if (thb1DownVo.getHb1YymmOld().equals(vo.getYymmNew())){
                //変更後請求年月が変更前年月と一致する場合は空をセット
                updThb1DownVo.setHb1YymmOld(" ");
            }else if (!thb1DownVo.getHb1YymmOld().trim().equals("")){
                //変更前年月が設定されている場合はそのままの値をセット
                updThb1DownVo.setHb1YymmOld(thb1DownVo.getHb1YymmOld());
            }else{
                //変更前年月が空の場合は更新する
                updThb1DownVo.setHb1YymmOld(thb1DownVo.getHb1Yymm());
            }

            Thb1DownVO uniqueChkData = thb1DownDao.loadThb1Down(updThb1DownVo);
            if (uniqueChkData != null) {
                throw new KKHException("請求年月変更先に重複する受注明細Noの情報が登録されています。", "UNIQUE-E0001");//TODO エラーコード
            }

            //受注ダウンロードデータ更新
            thb1DownDao.updateThb1DownForCngSeikyuYymm(thb1DownVo, updThb1DownVo);
            //更新後データを取得
            resThb1DownList.add(thb1DownDao.loadThb1Down(thb1DownVo));

        }

        result.setThb1DownList(resThb1DownList);
        return result;
    }

    //**********************************************************************************************************************************************************************************
    //新規登録
    /**
     * 新規登録
     *
     * @param vo ダウンロードデータVO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public JyutyuDataRegisterResult registerJyutyuData(JyutyuDataRegisterVO vo) throws KKHException {

        JyutyuDataRegisterResult result = new JyutyuDataRegisterResult();
        List<Thb1DownVO> retThb1DownList = new ArrayList<Thb1DownVO>();

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();

        for (Thb1DownVO thb1DownVo : vo.getThb1DownList()) {
            if (thb1DownVo.getHb1JyutNo() != null && !thb1DownVo.getHb1JyutNo().trim().equals("")){
                //受注Noが設定されている場合は重複チェックを行う
                if (checkUniqueJyutyuNo(thb1DownVo) == false){
                    throw new KKHException("設定された受注Ｎｏはすでに登録されています。", "UNIQUE-E0002");//TODO エラーコード
                }
            } else {
                //受注Noが設定されていない場合は採番を行う
                setJyutyuNo(thb1DownVo);
            }
            //登録処理
            dao.insertThb1Down(thb1DownVo);
            //登録データを検索して結果として保持する。
            retThb1DownList.add(dao.loadThb1Down(thb1DownVo));
        }

        result.setThb1DownList(retThb1DownList);
        return result;
    }

    private boolean checkUniqueJyutyuNo(Thb1DownVO vo) throws KKHException {

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();

        Thb1DownVO cond = new Thb1DownVO();
        cond.setHb1EgCd(vo.getHb1EgCd());
        cond.setHb1TksKgyCd(vo.getHb1TksKgyCd());
        cond.setHb1TksBmnSeqNo(vo.getHb1TksBmnSeqNo());
        cond.setHb1TksTntSeqNo(vo.getHb1TksTntSeqNo());
        cond.setHb1JyutNo(vo.getHb1JyutNo());
        cond.setHb1JyMeiNo(vo.getHb1JyMeiNo());
        cond.setHb1UrMeiNo(vo.getHb1UrMeiNo());
        List<Thb1DownVO> jyutyuNoList = dao.getJyutyuNoForUniqueCheck(cond);

        if (jyutyuNoList == null || jyutyuNoList.size() <= 0){
            return true;
        }else{
            return false;
        }
    }

    private void setJyutyuNo(Thb1DownVO vo) throws KKHException {

        String newJyutyuNo = "";

        if ((vo.getHb1TksKgyCd() + vo.getHb1TksBmnSeqNo() + vo.getHb1TksTntSeqNo()).equals(KKHConstants.TksKgyCode.LION.getCode())||
        		// 2016/01/29 アサヒ飲料カルピス対応 Hisada
        		//アサヒ飲料の条件を追加（受注Noの採番についてマスタを使用）
        		(vo.getHb1TksKgyCd() + vo.getHb1TksBmnSeqNo() + vo.getHb1TksTntSeqNo()).equals(KKHConstants.TksKgyCode.ASHI.getCode())){ 
            ExecProcedureDAO procDao = ExecProcedureDAOFactory.createExecProcedureDAO();
            newJyutyuNo = procDao.execPRCHB_SEQ_JYUTNO(vo.getHb1EgCd(), vo.getHb1TksKgyCd() + vo.getHb1TksBmnSeqNo() + vo.getHb1TksTntSeqNo() , vo.getHb1Yymm());
            newJyutyuNo = newJyutyuNo.trim();
        }else{
            String year = "";
            String mon = "";
            String number = "";

            year = vo.getHb1Yymm().substring(0, 4);

            String mm = vo.getHb1Yymm().substring(4, 6);
            if (mm.equals("01")){
                mon = "JA";
            }else if (mm.equals("02")){
                mon = "FB";
            }else if (mm.equals("03")){
                mon = "MR";
            }else if (mm.equals("04")){
                mon = "AP";
            }else if (mm.equals("05")){
                mon = "MY";
            }else if (mm.equals("06")){
                mon = "JN";
            }else if (mm.equals("07")){
                mon = "JL";
            }else if (mm.equals("08")){
                mon = "AU";
            }else if (mm.equals("09")){
                mon = "SP";
            }else if (mm.equals("10")){
                mon = "OC";
            }else if (mm.equals("11")){
                mon = "NV";
            }else if (mm.equals("12")){
                mon = "DC";
            }

            String maxJyutyuNo = "0000000000";
            //現在の受注No最大値を取得
            Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();
            Thb1DownVO cond = new Thb1DownVO();
            cond.setHb1EgCd(vo.getHb1EgCd());
            cond.setHb1TksKgyCd(vo.getHb1TksKgyCd());
            cond.setHb1TksBmnSeqNo(vo.getHb1TksBmnSeqNo());
            cond.setHb1TksTntSeqNo(vo.getHb1TksTntSeqNo());
            cond.setHb1Yymm(vo.getHb1Yymm());
            cond.setHb1JyutNo(year + mon);
            List<Thb1DownVO> maxJyutyuNoList = dao.getMaxJyutyuNo(cond);
            if (maxJyutyuNoList != null && maxJyutyuNoList.size() > 0 && !maxJyutyuNoList.get(0).getHb1JyutNo().trim().equals("")){
                maxJyutyuNo = maxJyutyuNoList.get(0).getHb1JyutNo();
            }

            number = new DecimalFormat("0000").format(Integer.parseInt(maxJyutyuNo.substring(6, 10)) + 1);

            newJyutyuNo = year + mon + number;
        }

        if (StringUtil.isBlank(newJyutyuNo)){
            throw new KKHException("受注番号が採番されていません。", "E");//TODO エラーコード
        }

        vo.setHb1JyutNo(newJyutyuNo);
    }

    //**********************************************************************************************************************************************************************************
    //受注統合
    /**
     * 受注統合
     *
     * @param vo ダウンロードデータVO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public JyutyuDataMergeResult mergeJyutyuData(JyutyuDataMergeVO vo) throws KKHException {

        JyutyuDataMergeResult result = new JyutyuDataMergeResult();
//    	List<Thb1DownVO> retThb1DownList = new ArrayList<Thb1DownVO>();

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();

        //*********************************************************************************************************
        //排他制御
        //*********************************************************************************************************
        for (Thb1DownVO thb1DownVO : vo.getTougouMotoList()) {
            List<Thb1DownVO> lockThb1Down = dao.lockThb1Down(thb1DownVO);
            if (lockThb1Down.size() <= 0 || vo.getMaxUpdDate().compareTo(lockThb1Down.get(0).getHb1TimStmp()) < 0 ){
                throw new KKHException("排他エラー", "LOCK-E0001");
            }
        }

        //*********************************************************************************************************
        //データ更新
        //*********************************************************************************************************

//    	for(Thb1DownVO Vo_i : vo.getTougouMotoList())
//    	{
//    		if(Vo_i.getHb1KsnTimStmp().toString().equals("Mon Jan 03 00:00:00 JST 1"))
//    		{
//    			Vo_i.setHb1KsnTimStmp(null);
//    		}
//    	}
        //統合元データの更新
        for (Thb1DownVO thb1DownVO : vo.getTougouMotoList()) {
            thb1DownVO.setHb1TJyutNo(vo.getTougouSaki().getHb1JyutNo());
            thb1DownVO.setHb1TJyMeiNo(vo.getTougouSaki().getHb1JyMeiNo());
            thb1DownVO.setHb1TUrMeiNo(vo.getTougouSaki().getHb1UrMeiNo());
            dao.updateThb1DownForJyutyuMerge(thb1DownVO);
        }

        //Voのタイムスタンプを見る
        if(vo.getTougouSaki().getHb1KsnTimStmp().toString().equals("Mon Jan 03 00:00:00 JST 1"))
        {
            vo.getTougouSaki().setHb1KsnTimStmp(null);
        }else
        {

//    		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//    		String datehenkan = sdf1.format(vo.getTougouSaki().getHb1KsnTimStmp());
//    		try {
//				Date date1 = DateFormat.getDateInstance().parse(datehenkan);
//				vo.getTougouSaki().setHb1KsnTimStmp(date1);
//			} catch (ParseException e) {
//				// TODO 自動生成された catch ブロック
//				e.printStackTrace();
//			}
        }

        //統合先データの登録
        dao.insertThb1Down(vo.getTougouSaki());

        return result;
    }

    //**********************************************************************************************************************************************************************************
    //統合解除
    /**
     * 統合解除
     *
     * @param vo ダウンロードデータVO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public JyutyuDataMergeCancelResult mergeCancelJyutyuData(JyutyuDataMergeCancelVO vo) throws KKHException {

        JyutyuDataMergeCancelResult result = new JyutyuDataMergeCancelResult();

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();

        //*********************************************************************************************************
        //排他制御
        //*********************************************************************************************************
        List<Thb1DownVO> lockThb1Down = dao.lockThb1Down(vo.getTougouSaki());
        if (lockThb1Down.size() <= 0 || vo.getMaxUpdDate().compareTo(lockThb1Down.get(0).getHb1TimStmp()) < 0 ){
            throw new KKHException("排他エラー", "LOCK-E0001");
        }

        //*********************************************************************************************************
        //データ更新
        //*********************************************************************************************************
        //統合元データの更新
        Thb1DownVO cond = new Thb1DownVO();
        //cond.setHb1UpdTnt(vo.getEsqId());
        cond.setHb1UpdTnt(vo.getTougouSaki().getHb1UpdTnt());
        cond.setHb1UpdApl(vo.getTougouSaki().getHb1UpdApl());
        cond.setHb1EgCd(vo.getTougouSaki().getHb1EgCd());
        cond.setHb1TksKgyCd(vo.getTougouSaki().getHb1TksKgyCd());
        cond.setHb1TksBmnSeqNo(vo.getTougouSaki().getHb1TksBmnSeqNo());
        cond.setHb1TksTntSeqNo(vo.getTougouSaki().getHb1TksTntSeqNo());
        cond.setHb1Yymm(vo.getTougouSaki().getHb1Yymm());
        cond.setHb1TJyutNo(vo.getTougouSaki().getHb1JyutNo());
        cond.setHb1TJyMeiNo(vo.getTougouSaki().getHb1JyMeiNo());
        cond.setHb1TUrMeiNo(vo.getTougouSaki().getHb1UrMeiNo());
        dao.updateThb1DownForJyutyuMergeCancel(cond);

        //統合先データの削除
        dao.deleteThb1Down(vo.getTougouSaki());

        return result;
    }

    //**********************************************************************************************************************************************************************************
    //履歴検索
    public Thb8DownRResult findJyutyuRirekiDataByCond(Thb8DownRCondition cond)throws KKHException {

        //検索結果
        Thb8DownRResult result = new Thb8DownRResult();

        //*************************************************
        //受注ダウンロード履歴データ取得
        //*************************************************
        Thb8DownRDAO dao = Thb8DownRDAOFactory.createThb8DownRDAO();
        List<Thb8DownRVO> voList = dao.findJyutyuRirekiDataByCond(cond);

        result.setThb8DownRList(voList);

        return result;
    }

    //**********************************************************************************************************************************************************************************
    //変更・削除チェック
    //**********************************************************************************************************************************************************************************
    /**
     * 引数１：受注データ条件
     * 引数２：受注データVO
     * 引数３：更新フラグ（true：受注テーブル更新する false：受注テーブル更新しない）
     * 戻り値：無し
     **/
    private void checkUpdate(JyutyuDataCondition cond, List<JyutyuDataVO> jyutyuDataVOList, boolean pUpdFlg) throws KKHException {

        // 受注データが０件の場合
        if (jyutyuDataVOList.size() == 0) {
            return;
        }

        // TODO 現在はJDBC接続を想定して実装している。DBリンクになった場合は要変更
        ThbAdmUriagemDAO thbAdmUriagemDAO = ThbAdmUriagemDAOFactory.createThbAdmUriagemDAO();
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();

        // 受注データの件数分、繰り返す
        for (int i = 0; i < jyutyuDataVOList.size(); i++) {
            JyutyuDataVO jyutyuDataVO = jyutyuDataVOList.get(i);
            if (JYUTDELFLG_ON.equals(jyutyuDataVO.getJyutDelFlg())) {
                continue;
            }
            // TODO 受注リストの件数分、VIEW検索、ダウンロードの更新を繰り返す。
            ThbAdmUriagemCondition thbAdmUriagemCondition = new ThbAdmUriagemCondition();
            thbAdmUriagemCondition.setAtEgsyoCd(jyutyuDataVO.getHb1AtuEgCd());
            thbAdmUriagemCondition.setTksKgyCd(jyutyuDataVO.getHb1TksKgyCd());
            thbAdmUriagemCondition.setTksBmnSeqNo(jyutyuDataVO.getHb1TksBmnSeqNo());
            thbAdmUriagemCondition.setTksTntSeqNo(jyutyuDataVO.getHb1TksTntSeqNo());
            thbAdmUriagemCondition.setJyutNo(jyutyuDataVO.getHb1JyutNo());
            thbAdmUriagemCondition.setJyMeiSeq(jyutyuDataVO.getHb1JyMeiNo());
            thbAdmUriagemCondition.setUrMeiSeq(jyutyuDataVO.getHb1UrMeiNo());
            // 広告費明細用売上明細VIEW検索
            List<ThbAdmUriagemVO> thbAdmUriagemList = thbAdmUriagemDAO.getAdmUriagemViewData(thbAdmUriagemCondition);
            // データなしの場合
            if (thbAdmUriagemList.size() == 0) {
                jyutyuDataVO.setJyutDelFlg(JYUTDELFLG_ON);
                jyutyuDataVO.setSeikJtai(null);
                jyutyuDataVO.setSeiSagSts(null);
                jyutyuDataVO.setStpKbn(null);
            // データありの場合
            } else {
                ThbAdmUriagemVO thbAdmUriagemVO = thbAdmUriagemList.get(0);
                // 中止区分が中止の場合
                if (STPKBN_STOP.equals(thbAdmUriagemVO.getStpKbn())) {
                    jyutyuDataVO.setJyutDelFlg(JYUTDELFLG_ON);
                // その他の場合
                } else {
                    jyutyuDataVO.setJyutDelFlg(null);
                }
                jyutyuDataVO.setSeikJtai(thbAdmUriagemVO.getSeikJtai());
                jyutyuDataVO.setSeiSagSts(thbAdmUriagemVO.getSeiSagSts());
                jyutyuDataVO.setStpKbn(thbAdmUriagemVO.getStpKbn());
            }
            // 広告費明細用売上明細VIEWの取得項目を反映した受注データをリストに再設定
            jyutyuDataVOList.set(i, jyutyuDataVO);

            //更新フラグがtrueの場合
            if(pUpdFlg == true)
            {
                // 受注削除フラグがＯＮの場合
                if (JYUTDELFLG_ON.equals(jyutyuDataVO.getJyutDelFlg())) {
                    Thb1DownVO updThb1DownVo = new Thb1DownVO();
                    updThb1DownVo.setHb1UpdApl(cond.getAplId());
                    updThb1DownVo.setHb1UpdTnt(cond.getEsqId());
                    updThb1DownVo.setHb1EgCd(jyutyuDataVO.getHb1EgCd());
                    updThb1DownVo.setHb1TksKgyCd(jyutyuDataVO.getHb1TksKgyCd());
                    updThb1DownVo.setHb1TksBmnSeqNo(jyutyuDataVO.getHb1TksBmnSeqNo());
                    updThb1DownVo.setHb1TksTntSeqNo(jyutyuDataVO.getHb1TksTntSeqNo());
                    updThb1DownVo.setHb1Yymm(jyutyuDataVO.getHb1Yymm());
                    updThb1DownVo.setHb1JyutNo(jyutyuDataVO.getHb1JyutNo());
                    updThb1DownVo.setHb1JyMeiNo(jyutyuDataVO.getHb1JyMeiNo());
                    updThb1DownVo.setHb1UrMeiNo(jyutyuDataVO.getHb1UrMeiNo());
                    updThb1DownVo.setHb1TouFlg(jyutyuDataVO.getHb1TouFlg());
                    // 受注ダウンロードデータ更新
                    thb1DownDao.updateThb1DownForUpdateCheck(updThb1DownVo);
                }
            }
        }
    }

    //**********************************************************************************************************************************************************************************
    //共通
    //**********************************************************************************************************************************************************************************
    /**
     * ダウンロードデータの検索
     *
     * @param vo ダウンロードデータVO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public Thb1DownVO loadThb1Down(Thb1DownVO vo) throws KKHException {
        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();
        return dao.loadThb1Down(vo);
    }

    /**
     * 広告費明細データの登録
     *
     * @param vo 広告費明細データVO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void insertThb2Kmei(Thb2KmeiVO vo) throws KKHException {
        Thb2KmeiDAO dao = Thb2KmeiDAOFactory.createThb2KmeiDAO();
        dao.insertThb2Kmei(vo);
    }

}
