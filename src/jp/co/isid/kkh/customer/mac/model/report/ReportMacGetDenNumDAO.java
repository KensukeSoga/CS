package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
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
 * ・新規作成(2011/11/07 JSE KT)<BR>
 * </P>
 * @author
 */
public class ReportMacGetDenNumDAO extends AbstractSimpleRdbDao {

    /**汎用マスタ検索条件 */
    private ReportMacGetDenNumCondition _cond;

    /** getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode{KIND,ITEM,};
//    private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * デフォルトコンストラクタ。
     */
    public ReportMacGetDenNumDAO() {
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
//		};
        return null;
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
        return TBTHB2KMEI.TBNAME;
    }


    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        return new String[]{

                TBTHBAMST.FIELD1,		// 伝票番号
                TBTHBAMST.FIELD2,		// 伝票番号上限
                TBTHBAMST.FIELD3,		// 取引先コード
                TBTHBAMST.FIELD4,		// 電話番号
                TBTHBAMST.FIELD5,		// 連絡先住所
                TBTHBAMST.FIELD6,		// 伝票調整
                TBTHBAMST.FIELD7,		// ラベル調整
                TBTHBAMST.INTVALUE2,	// 消費税
        };
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
        return getSelectSQLForItem();
    }

    private String getSelectSQLForItem(){

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
        sql.append("  " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append("  " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append("  " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append("  " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");
        sql.append("  " + TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");
        sql.append("  " + TBTHBAMST.SYBT  + " = '201' ");

        return sql.toString();
    }

    /**
     * 帳票データ（MAC)の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportMacGetDenNumVO> findReportMacGetDenNumByCondition(ReportMacGetDenNumCondition cond) throws KKHException {

        super.setModel(new ReportMacGetDenNumVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

}
