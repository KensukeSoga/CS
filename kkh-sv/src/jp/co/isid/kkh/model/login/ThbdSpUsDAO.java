package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHBDSPUS;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class ThbdSpUsDAO extends AbstractRdbDao {

    /** ユーザー種別：スーパーユーザー */
    private static final String USER_KIND_SUPER = "1";

    /** ユーザー種別：特別ログインユーザー */
    private static final String USER_KIND_SPECIAL_LOGIN = "2";

    /** ユーザー種別：特別得意先ユーザー */
    private static final String USER_KIND_SPECIAL_CUSTOMER = "3";

    /** 削除フラグ：OFF */
    private static final String DELFLG_OFF = "0";

    /** 特別ユーザーマスタ検索条件 */
    private ThbdSpUsCondition _cond;

    /** getSelectSQLで発行するSQLのモード() */
    private enum SqlMode {
        SPECIAL_LOGIN_USER, SUPER_USER, SPECIAL_CUSTOMER_USER
    };

    private SqlMode _sqlMode = SqlMode.SPECIAL_LOGIN_USER;

    /**
     * デフォルトコンストラクタ。
     */
    public ThbdSpUsDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * プライマリキーを返します。
     *
     * @return String[] プライマリキー
     */
    public String[] getPrimryKeyNames() {
        return null;
    }

    /**
     * 更新日付フィールドを返します。
     *
     * @return String 更新日付フィールド
     */
    public String getTimeStampKeyName() {
        return null;
    }

    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    public String getTableName() {
        return "";
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[] {};
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @SuppressWarnings("static-access")
    @Override
    public String getSelectSQL() {

        if (_sqlMode.equals(_sqlMode.SPECIAL_LOGIN_USER)) {
            return getSelectSQLForSpecialLoginUser();
        } else if (_sqlMode.equals(_sqlMode.SUPER_USER)) {
            return getSelectSQLForSuperUser();
        } else if (_sqlMode.equals(_sqlMode.SPECIAL_CUSTOMER_USER)){
            return getSelectSQLForSpecialCustomer();
        }

        return "";
    }

    private String getSelectSQLForSpecialLoginUser(){
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHBDSPUS.EGSCD + " ");
        sql.append(" ," + TBTHBDSPUS.TKSKGYCD + " ");
        sql.append(" ," + TBTHBDSPUS.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHBDSPUS.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHBDSPUS.SIKCD + " ");
        sql.append(" ," + TBTHBDSPUS.USERID + " ");
        sql.append(" ," + TBTHBDSPUS.EGSNM + " ");
        sql.append(" ," + TBTHBDSPUS.TKSKGYNM + " ");
        sql.append(" ," + TBTHBDSPUS.TKSBMNNM + " ");
        sql.append(" ," + TBTHBDSPUS.TKSTNTNM + " ");
        sql.append(" ," + TBTHBDSPUS.PASSWORD + " ");
        sql.append(" ," + TBTHBDSPUS.USERNMKJ + " ");
        sql.append(" ," + TBTHBDSPUS.USERNMKN + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBDSPUS.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + TBTHBDSPUS.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBDSPUS.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBDSPUS.USERTYPE + " = '" + USER_KIND_SPECIAL_LOGIN + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBDSPUS.DELFLG + " = '" + DELFLG_OFF + "' ");

        return sql.toString();
    }

    private String getSelectSQLForSuperUser(){
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHBDSPUS.EGSCD + " ");
        sql.append(" ," + TBTHBDSPUS.TKSKGYCD + " ");
        sql.append(" ," + TBTHBDSPUS.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHBDSPUS.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHBDSPUS.SIKCD + " ");
        sql.append(" ," + TBTHBDSPUS.USERID + " ");
        sql.append(" ," + TBTHBDSPUS.EGSNM + " ");
        sql.append(" ," + TBTHBDSPUS.TKSKGYNM + " ");
        sql.append(" ," + TBTHBDSPUS.TKSBMNNM + " ");
        sql.append(" ," + TBTHBDSPUS.TKSTNTNM + " ");
        sql.append(" ," + TBTHBDSPUS.PASSWORD + " ");
        sql.append(" ," + TBTHBDSPUS.USERNMKJ + " ");
        sql.append(" ," + TBTHBDSPUS.USERNMKN + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBDSPUS.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + TBTHBDSPUS.USERID + " = '" + _cond.getUserId() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBDSPUS.USERTYPE + " = '" + USER_KIND_SUPER + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBDSPUS.DELFLG + " = '" + DELFLG_OFF + "' ");

        return sql.toString();
    }

    private String getSelectSQLForSpecialCustomer(){
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHBDSPUS.EGSCD + " ");
        sql.append(" ," + TBTHBDSPUS.TKSKGYCD + " ");
        sql.append(" ," + TBTHBDSPUS.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHBDSPUS.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHBDSPUS.SIKCD + " ");
        sql.append(" ," + TBTHBDSPUS.USERID + " ");
        sql.append(" ," + TBTHBDSPUS.EGSNM + " ");
        sql.append(" ," + TBTHBDSPUS.TKSKGYNM + " ");
        sql.append(" ," + TBTHBDSPUS.TKSBMNNM + " ");
        sql.append(" ," + TBTHBDSPUS.TKSTNTNM + " ");
        sql.append(" ," + TBTHBDSPUS.PASSWORD + " ");
        sql.append(" ," + TBTHBDSPUS.USERNMKJ + " ");
        sql.append(" ," + TBTHBDSPUS.USERNMKN + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBDSPUS.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + TBTHBDSPUS.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBDSPUS.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBDSPUS.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBDSPUS.SIKCD + " = '" + _cond.getSikCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBDSPUS.USERID + " = '" + _cond.getUserId() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBDSPUS.USERTYPE + " = '" + USER_KIND_SPECIAL_CUSTOMER + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBDSPUS.DELFLG + " = '" + DELFLG_OFF + "' ");

        return sql.toString();
    }

    /**
     * 特別ログインユーザー情報の検索を行います。
     *
     * @return 特別ユーザーマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ThbdSpUsVO> getSpecialLoginUserInfo(ThbdSpUsCondition cond) throws KKHException {

        super.setModel(new ThbdSpUsVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.SPECIAL_LOGIN_USER;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "HB-E0001");
        }

    }

    /**
     * スーパーユーザー情報の検索を行います。
     *
     * @return 特別ユーザーマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ThbdSpUsVO> getSuperUserInfo(ThbdSpUsCondition cond) throws KKHException {

        super.setModel(new ThbdSpUsVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.SUPER_USER;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "HB-E0001");
        }

    }

    /**
     * 特別得意先情報の検索を行います。
     *
     * @return 特別ユーザーマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ThbdSpUsVO> getSpecialCustomerInfo(ThbdSpUsCondition cond) throws KKHException {

        super.setModel(new ThbdSpUsVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.SPECIAL_CUSTOMER_USER;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "HB-E0001");
        }

    }

    /**
     * Modelの生成を行う<br>
     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
     *
     * @param hashList List 検索結果
     * @return List<ThbdSpUsVO> 変換後の検索結果
     */
    @Override
    protected List<ThbdSpUsVO> createFindedModelInstances(List hashList) {

        List<ThbdSpUsVO> list = new ArrayList<ThbdSpUsVO>();
        if (getModel() instanceof ThbdSpUsVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ThbdSpUsVO vo = new ThbdSpUsVO();
                vo.setEgsCd(StringUtil.trim((String) result.get(TBTHBDSPUS.EGSCD.toUpperCase())));
                vo.setTksKgyCd(StringUtil.trim((String) result.get(TBTHBDSPUS.TKSKGYCD.toUpperCase())));
                vo.setTksBmnSeqNo(StringUtil.trim((String) result.get(TBTHBDSPUS.TKSBMNSEQNO.toUpperCase())));
                vo.setTksTntSeqNo(StringUtil.trim((String) result.get(TBTHBDSPUS.TKSTNTSEQNO.toUpperCase())));
                vo.setSikCd(StringUtil.trim((String) result.get(TBTHBDSPUS.SIKCD.toUpperCase())));
                vo.setUserId(StringUtil.trim((String) result.get(TBTHBDSPUS.USERID.toUpperCase())));
                vo.setEgsNm(StringUtil.trim((String) result.get(TBTHBDSPUS.EGSNM.toUpperCase())));
                vo.setTksKgyNm(StringUtil.trim((String) result.get(TBTHBDSPUS.TKSKGYNM.toUpperCase())));
                vo.setTksBmnNm(StringUtil.trim((String) result.get(TBTHBDSPUS.TKSBMNNM.toUpperCase())));
                vo.setTksTntNm(StringUtil.trim((String) result.get(TBTHBDSPUS.TKSTNTNM.toUpperCase())));
                vo.setPassword(StringUtil.trim((String) result.get(TBTHBDSPUS.PASSWORD.toUpperCase())));
                vo.setUserNmKj(StringUtil.trim((String) result.get(TBTHBDSPUS.USERNMKJ.toUpperCase())));
                vo.setUserNmKn(StringUtil.trim((String) result.get(TBTHBDSPUS.USERNMKN.toUpperCase())));
                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
