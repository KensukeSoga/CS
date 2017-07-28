package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
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
 * ・不具合対応(2014/04/30 HLC S.Fujimoto)<BR>
 * </P>
 * @author JSE KT
 */
public class ReportMacPurchaseDAO extends AbstractSimpleRdbDao {

    /**汎用マスタ検索条件 */
    private ReportMacPurchaseCondition _cond;

    /** getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode{KIND,ITEM,};
//    private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * デフォルトコンストラクタ。
     */
    public ReportMacPurchaseDAO() {
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
        return new String[]{
                TBTHB2KMEI.EGCD,
                TBTHB2KMEI.TKSKGYCD,
                TBTHB2KMEI.TKSBMNSEQNO,
                TBTHB2KMEI.TKSTNTSEQNO,
                TBTHB2KMEI.YYMM,
                TBTHB2KMEI.JYUTNO,
                TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO,
                TBTHB2KMEI.RENBN
        };
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

                TBTHB2KMEI.SEIGAK,	// 請求金額
                TBTHB2KMEI.DATE1,	// 年月
                TBTHB2KMEI.KBN1,	// 店舗区分
                TBTHB2KMEI.CODE1,	// 店舗コード
                TBTHB2KMEI.CODE4,	// 勘定科目
                TBTHB2KMEI.NAME1,	// 件名１
                TBTHB2KMEI.NAME2,	// 件名２
                TBTHB2KMEI.NAME3,	// 店舗名称
                TBTHB2KMEI.KNGK1,	// 単価
                TBTHB2KMEI.KNGK2,	// 数量
                TBTHB2KMEI.SONOTA1,	// 伝票NO
                TBTHB2KMEI.JYUTNO,	// 受注NO
                TBTHB2KMEI.JYMEINO,	// 受注明細NO
                TBTHB2KMEI.URMEINO,	// 売上明細NO
                TBTHB2KMEI.RENBN,	// 連番
                TBTHBAMST.FIELD10,	// 社名
                TBTHBAMST.FIELD13,	// 明細行フラグ
                TBTHB2KMEI.SONOTA2	// 分割コード
        };
    }
    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
        if (_cond.getreflg().equals("0"))
            {return getSelectSQLForPrint();}
        else
            {return getSelectSQLForRePrint();}
    }

    /**
     * 印刷時
     * @return
     */
    private String getSelectSQLForPrint(){

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
        //消費税対応 2013/10/21 add HLC H.Watabe start
        sql.append(" ,(" + TBTHB2KMEI.RITU1 + " * 0.01) AS "+ TBTHB2KMEI.RITU1 + " ");
        //消費税対応 2013/10/21 add HLC H.Watabe end
        sql.append(" FROM ");
        sql.append(" " + TBTHB2KMEI.TBNAME + ", ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        /* 不具合対応 2014/04/30 fujimoto ADD start */
        sql.append(", " + TBTHB1DOWN.TBNAME);
        /* 不具合対応 2014/04/30 fujimoto ADD end */
        sql.append(" WHERE ");
        sql.append("  " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSKGYCD + " = " +  TBTHBAMST.TKSKGYCD  + "  AND ");
        sql.append("  " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO  + "  AND ");
        sql.append("  " + TBTHB2KMEI.TKSTNTSEQNO  + " = " + TBTHBAMST.TKSTNTSEQNO  + "  AND ");
        /* 不具合対応 2014/04/30 fujimoto ADD start */
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD);
        sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD);
        sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO);
        sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO);
        sql.append(" AND " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO); // 受注NO
        sql.append(" AND " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO); // 受注明細NO
        sql.append(" AND " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO); // 売上明細NO
        sql.append(" AND " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM); // 年月
        sql.append(" AND " + TBTHB1DOWN.TJYUTNO + " = ' '");
        sql.append(" AND ");
        /* 不具合対応 2014/04/30 fujimoto ADD end */
        sql.append("  RTRIM(" + TBTHBAMST.FIELD1 + ") = RTRIM(" + TBTHB2KMEI.CODE1 + ") AND ");
        sql.append("  " + TBTHBAMST.SYBT  + " = '301'  AND ");
        if (!_cond.getterritory().equals(""))
        {
            sql.append("  " + TBTHBAMST.FIELD8 + " in (" + _cond.getterritory() + ") AND ");
        }
        if (!_cond.getYm().equals(""))
        {
            sql.append("  " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM + " = '" + _cond.getYm()  + "'  AND ");
        }
        sql.append("  RTRIM(" + TBTHB2KMEI.SONOTA1 + ") IS NULL AND ");
        sql.append("  RTRIM(" + TBTHB2KMEI.SONOTA2 + ") = '" + _cond.getsplitflg()  + "'  ");
        sql.append("  ORDER BY "); //GAC_FIELD1,HB2_CODE1,HB2_JYUTNO,HB2_JYMEINO,HB2_URMEINO "
        sql.append("  " + TBTHBAMST.FIELD8  + ", ");
        sql.append("  " + TBTHB2KMEI.CODE1 + ", ");
        sql.append("  " + TBTHB2KMEI.JYUTNO + ", ");   // 受注NO
        sql.append("  " + TBTHB2KMEI.JYMEINO + ", ");  // 受注明細NO
        sql.append("  " + TBTHB2KMEI.URMEINO + " ");  // 売上明細NO

        return sql.toString();
    }

    private String getSelectSQLForRePrint(){

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
        //消費税対応 2013/10/21 add HLC H.Watabe start
        sql.append(" ,(" + TBTHB2KMEI.RITU1 + " * 0.01) AS "+ TBTHB2KMEI.RITU1 + " ");
        //消費税対応 2013/10/21 add HLC H.Watabe end
        sql.append(" FROM ");
        sql.append(" " + TBTHB2KMEI.TBNAME + ", ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        /* 不具合対応 2014/04/30 fujimoto ADD start */
        sql.append(", " + TBTHB1DOWN.TBNAME);
        /* 不具合対応 2014/04/30 fujimoto ADD end */
        sql.append(" WHERE ");
        sql.append("  " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
        sql.append("  " + TBTHB2KMEI.TKSKGYCD + " = " +  TBTHBAMST.TKSKGYCD  + "  AND ");
        sql.append("  " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO  + "  AND ");
        sql.append("  " + TBTHB2KMEI.TKSTNTSEQNO  + " = " + TBTHBAMST.TKSTNTSEQNO  + "  AND ");
        /* 不具合対応 2014/04/30 fujimoto ADD start */
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD);
        sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD);
        sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO);
        sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO);
        sql.append(" AND " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO); // 受注NO
        sql.append(" AND " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO); // 受注明細NO
        sql.append(" AND " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO); // 売上明細NO
        sql.append(" AND " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM); // 年月
        sql.append(" AND " + TBTHB1DOWN.TJYUTNO + " = ' '");
        sql.append(" AND ");
        /* 不具合対応 2014/04/30 fujimoto ADD end */
        sql.append("  RTRIM(" + TBTHBAMST.FIELD1 + ") = RTRIM(" + TBTHB2KMEI.CODE1 + ") AND ");
        sql.append("  " + TBTHBAMST.SYBT  + " = '301'  AND ");
        if (!_cond.getterritory().equals(""))
        {
            sql.append("  " + TBTHBAMST.FIELD8 + " in (" + _cond.getterritory() + ") AND ");
        }
        if (!_cond.getYm().equals(""))
        {
            sql.append("  " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM + " = '" + _cond.getYm()  + "'  AND ");
        }
        if (!_cond.gettenpocd().equals("")){
            sql.append("  RTRIM(" + TBTHB2KMEI.CODE1 + ") = '" + _cond.gettenpocd()  + "' AND ");
        }
        //sql.append("  " + TBTHB2KMEI.SONOTA1 + " != " + "' ' AND ");
        //伝票番号のどちらも条件がない場合は全権検索
        if (_cond.getdenfr().equals("") && _cond.getdento().equals(""))
        {
            sql.append(" RTRIM(" + TBTHB2KMEI.SONOTA1 + ") IS NOT NULL AND ");
        }
        //TOが無く、FROMがある場合
        else if (_cond.getdento().equals("")){
            sql.append("  RTRIM(" + TBTHB2KMEI.SONOTA1 + ") >= '" + _cond.getdenfr()  + "' AND ");
        }
        //TOが無く、FROMがある場合
        else if (_cond.getdenfr().equals("")){
            sql.append("  RTRIM(" + TBTHB2KMEI.SONOTA1 + ") <= '" + _cond.getdento()  + "' AND ");
        }
        //TO、FROMに両方とも値がある場合
        else {
            sql.append("  RTRIM(" + TBTHB2KMEI.SONOTA1 + ") BETWEEN '" + _cond.getdenfr()  + "' AND ");
            sql.append("'" + _cond.getdento()  + "' AND ");
        }
        sql.append("  RTRIM(" + TBTHB2KMEI.SONOTA2 + ") = '" + _cond.getsplitflg()  + "'  ");
        sql.append("  ORDER BY ");
        sql.append("  " + TBTHBAMST.FIELD8  + ", ");
        sql.append("  " + TBTHB2KMEI.CODE1 + ", ");
        sql.append("  " + TBTHB2KMEI.SONOTA1 + " ");   // 受注NO

        return sql.toString();
    }


    /**
     * 帳票データ（MAC)の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportMacPurchaseVO> findReportMacPurchaseByCondition(ReportMacPurchaseCondition cond) throws KKHException {

        super.setModel(new ReportMacPurchaseVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }

    }

}
