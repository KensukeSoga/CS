package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 帳票（MAC)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/1/23 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshMediaCodeDAO extends AbstractSimpleRdbDao {

    /**汎用マスタ検索条件 */
    private ReportAshMediaCondition _cond;

    /* getSelectSQLで発行するSQLのモード() */
    private enum SqlMode{SYOHIN,BAITAI,OLDKYOKU,BANGUMIDATA,};
    private SqlMode _sqlMode = SqlMode.BAITAI;

    /**
     * デフォルトコンストラクタ。
     */
    public ReportAshMediaCodeDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * プライマリキーを返します。
     *
     * @return String[] プライマリキー
     */
    @Override
    public String[] getPrimryKeyNames() {
//		return new String[]{
//				TBTHB2KMEI.EGCD,
//				TBTHB2KMEI.TKSKGYCD,
//				TBTHB2KMEI.TKSBMNSEQNO,
//				TBTHB2KMEI.TKSTNTSEQNO,
//				TBTHB2KMEI.YYMM,
//				TBTHB2KMEI.JYUTNO,
//				TBTHB2KMEI.JYMEINO,
//				TBTHB2KMEI.URMEINO,
//				TBTHB2KMEI.RENBN
        return null;
//		};
    }

    /**
     * 更新日付フィールドを返します。
     *
     * @return String 更新日付フィールド
     */
    public String getTimeStampKeyName() {
        //new String[] {};
        return null;
    }

    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    @Override
    public String getTableName() {
        return TBTHBAMST.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHBAMST.SYBT,
                TBTHBAMST.FIELD1,
                TBTHBAMST.FIELD2,
                TBTHBAMST.FIELD3,
                TBTHBAMST.FIELD4,
                //2015/07/08 k.soga アサヒ対応 Add  Start
                TBTHBAMST.FIELD9
                //2015/07/08 k.soga アサヒ対応 Add End
        };
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
        if (_sqlMode.equals(SqlMode.BAITAI)){
        return getSelectSQLForBaitai();
        }else if(_sqlMode.equals(SqlMode.SYOHIN)){
            return getSelectSQLForSyohin();
        }else if(_sqlMode.equals(SqlMode.OLDKYOKU)){
            return getSelectSQLForOldKyoku();
        }else if(_sqlMode.equals(SqlMode.BANGUMIDATA)){
            return getSelectSQLBangumiData();
        }
        return "";
    }

    private String getSelectSQLForBaitai(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append("  " + getTableColumnNames()[i] + " ");
            }else{
                sql.append(" ," + getTableColumnNames()[i] + " ");
            }
        }
        sql.append(" FROM ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.SYBT + " LIKE '2%' ");
        sql.append(" ORDER BY ");
        sql.append(" " + TBTHBAMST.SYBT + " ");

        return sql.toString();
    }

    private String getSelectSQLForSyohin(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append("  " + getTableColumnNames()[i] + " ");
            }else{
                sql.append(" ," + getTableColumnNames()[i] + " ");
            }
        }
        sql.append(" FROM ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '101' ");

          return sql.toString();
    }

    private String getSelectSQLForOldKyoku()
    {
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append(" " + TBTHBAMST.FIELD1 + ", ");
        sql.append(" " + TBTHBAMST.FIELD2 + ", ");
        sql.append(" " + TBTHBAMST.FIELD3 + ", ");
        sql.append(" " + TBTHBAMST.FIELD4 + ", ");
        sql.append(" " + TBTHBAMST.FIELD11 + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '501' ");

        return sql.toString();
    }

    private String getSelectSQLBangumiData()
    {
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append(" " + TBTHBAMST.FIELD1 + " BangumiCD, ");
        sql.append(" " + TBTHBAMST.FIELD2 + " BangumiNM, ");
        sql.append(" " + TBTHBAMST.SYBT + " SYBT ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.SYBT + " IN ('130','129') ");
        sql.append(" ORDER BY ");
        sql.append(" SYBT ");

        return sql.toString();
    }

    /**
     * 帳票データ（MAC)の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportAshMediaCodeVO> findReportAshMediaCodeByCondition(ReportAshMediaCondition cond) throws KKHException {

        super.setModel(new ReportAshMediaCodeVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.BAITAI;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    @SuppressWarnings("unchecked")
    public List<ReportAshMediaCodeVO> findSyohinByCondition(ReportAshMediaCondition cond) throws KKHException {

        super.setModel(new ReportAshMediaCodeVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.SYOHIN;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }

    }

    @SuppressWarnings("unchecked")
    public List<ReportAshOldKyokuVO> findOldKyokuByCondition(ReportAshMediaCondition cond) throws KKHException {

        super.setModel(new ReportAshOldKyokuVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.OLDKYOKU;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    @SuppressWarnings("unchecked")
    public List<ReportAshBangumiDataVO> findBangumiDataByCondition(ReportAshMediaCondition cond) throws KKHException {

        super.setModel(new ReportAshBangumiDataVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.BANGUMIDATA;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

}
