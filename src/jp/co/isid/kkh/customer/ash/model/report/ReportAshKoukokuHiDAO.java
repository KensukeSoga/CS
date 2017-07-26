package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;

//import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaCodeDAO.SqlMode;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;

import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.constants.KKHConstants;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 広告費明細書（Ash）データ検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/1/12 fourm h.izawa)<BR>
 * </P>
 * @author fourm h.izawa
 */
public class ReportAshKoukokuHiDAO extends AbstractSimpleRdbDao {

    /**汎用マスタ検索条件 */
    private ReportAshMediaCondition _cond;

    /** getSelectSQLで発行するSQLのモード() */
    private enum SqlMode{Data,Kingak,};
    private SqlMode _sqlMode = SqlMode.Data;

    /**
     * デフォルトコンストラクタ。
     */
    public ReportAshKoukokuHiDAO() {
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
//      };

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
                    TBTHB2KMEI.NAME4 + " SEIKYUNO",
                    TBTHB2KMEI.CODE1 + " BAITAICD",
                    TBTHB2KMEI.SEIGAK + " SEIKYUKIN",
                    "MST2."+TBTHBAMST.FIELD2 + " KYOKUNM",
                    TBTHB2KMEI.CODE2 + " KYOKUCD",
                    "MST1."+ TBTHBAMST.FIELD2 + " HINSYUNM",
                    TBTHB2KMEI.CODE3 + " HINSYUCD",
                    TBTHB2KMEI.CODE4 + " DAIRITENCD",
                    TBTHB2KMEI.CODE5 + " BANGUMICD",
                    // 2013/01/17 JSE M.Naito
                    //TBTHB2KMEI.NAME8 + " KENMEI",
                    TBTHB2KMEI.NAME10 + " KENMEI",
                    TBTHB2KMEI.RENBN + " RENBN",
                    TBTHB2KMEI.JYUTNO + " JYUTNO",
                    TBTHB2KMEI.JYMEINO + " JYMEINO",
                    TBTHB2KMEI.URMEINO + " URMEINO",
                    TBTHB2KMEI.SONOTA8 + " KEYKYOKU",
                    TBTHB2KMEI.CODE6 + " CODE6",
                    "MST2." + TBTHBAMST.FIELD4 + " KYOKURYAKU",
                    TBTHB2KMEI.SONOTA10 + " SONOTA10"
        };
    }

    /**
     * デフォルトのSQL文を返します。
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
        if(_sqlMode.equals(SqlMode.Data)){
            //広告費明細書データ検索
            return getSelectSQLForItem();
        }else if(_sqlMode.equals(SqlMode.Kingak)){
            //広告費明細書タイム金額検索
            return getSelectSQLTvAndRaidoKingak();
        }
        return "";
    }

    /**
     * 広告費明細書データ検索SQL文作成
     * @return SQL文
     */
    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        //テレビタイム・テレビスポット・テレビネットスポット
        sql.append("SELECT");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append(", " + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '204' AND");
        // UPD 2015/06/08 K.F アサヒ対応 Start
        //sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '100', '110' ) AND");
        if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
        	// アサヒビールの場合、テレビネットスポットを対象とする
        	sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '100', '105', '110' ) AND");
        }
        else
        {
        	sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '100', '110' ) AND");
        }
        // UPD 2015/06/08 K.F アサヒ対応 End
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //新聞
        sql.append(" UNION");
        sql.append(" SELECT");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append(", " + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '202' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '130' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //雑誌
        sql.append(" UNION");
        sql.append(" SELECT");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append(", " + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '203' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '140' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE6 + ") AND");
        //sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") ");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //ラジオタイム
        sql.append(" UNION");
        sql.append(" SELECT");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append("," + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '205' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '120' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //ラジオスポット
        sql.append(" UNION");
        sql.append(" SELECT");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append("," + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '205' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '125' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //交通
        sql.append(" UNION");
        sql.append(" SELECT");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append("," + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '206' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '150' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //制作
        sql.append(" UNION");
        sql.append(" SELECT");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append("," + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '216' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '170' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //PR
        sql.append(" UNION");

        //2013/02/22 jse okazaki PR媒体追加対応　Start
        sql.append(" SELECT");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append("," + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '221' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '119' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        //
        sql.append(" UNION");
        //2013/02/22 jse okazaki PR媒体追加対応　End

        sql.append(" SELECT");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append(", " + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '217' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '160', '180' ) AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);


        sql.append(" UNION");
        sql.append(" SELECT");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append("  " + getTableColumnNames()[i]);
            }else{
                sql.append(" ," + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '218' AND");
    	// UPD 2015/03/03 K.F アサヒ対応 START
        //sql.append(" " + TBTHB2KMEI.CODE1 + " IN ( '190', '115', '116', '117', '118', '195' ) AND");
    	if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
    		//アサヒビールの場合
    		// UPD 2015/06/08 K.F アサヒ対応 Start
    		//sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('190','115','116','117','118','195','193','194','199') ");
    		sql.append(" " + TBTHB2KMEI.CODE1 + " NOT IN ('100','105','110','130','140','120','150','170','119','160','180','230','240') ");
    		// UPD 2015/06/08 K.F アサヒ対応 End
    	}else{
    		//アサヒ飲料の場合
    		sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('190','115','116','117','118','195','321','322','331','332','333','334','336','380','382','389') ");
    	}
        sql.append(" AND");
    	// UPD 2015/03/03 K.F アサヒ対応 END
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
    	// ADD 2015/02/25 K.F START
        sql.append(" MST2."+ TBTHBAMST.FIELD9 + "(+) = RTRIM(" + TBTHB2KMEI.CODE1 + ") AND");
    	// ADD 2015/02/25 K.F END
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);


        sql.append(" UNION");
        sql.append(" SELECT");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append(", " + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '219' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '230' AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);


        sql.append(" UNION");
        sql.append(" SELECT");
        //全項目を取得
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append(" " + getTableColumnNames()[i]);
            }else{
                sql.append(", " + getTableColumnNames()[i]);
            }
        }
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " MST1,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST2");
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + "MST2." + TBTHBAMST.SYBT + "(+) = '220' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '240' AND");
        sql.append(" MST1."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST2."+ TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST1."+ TBTHBAMST.SYBT + "(+) =  '101' AND");
        sql.append(" MST2."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        sql.append(" MST1."+ TBTHBAMST.FIELD1 + "(+) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO);

        sql.append(" ORDER BY");
        sql.append(" SONOTA10,");
        sql.append(" BaitaiCD,");
        sql.append(" SeikyuNo,");
        sql.append(" JYUTNO,");
        sql.append(" JYMEINO,");
        sql.append(" URMEINO,");
        sql.append(" RENBN");

        return sql.toString();
    }

    /**
     * 広告費明細書タイム金額検索SQL文作成
     * @return SQL文
     */
    private String getSelectSQLTvAndRaidoKingak()
    {
        StringBuffer sql = new StringBuffer();
        sql.append(" (SELECT ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.URMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.CODE3 + " HinsyuCD, ");
        sql.append(" " + TBTHB2KMEI.CODE1 + " BaitaiCD, ");
        sql.append(" MAX(ROUND(" + TBTHB2KMEI.SEIGAK + ")) SEIGAK ");
        sql.append(" FROM ");
        sql.append(" " + TBTHB2KMEI.TBNAME + ", ");
        sql.append(" " + TBTHB1DOWN.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('100') ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO+ " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO+ " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO+ " " );
        sql.append(" GROUP BY ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.URMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.CODE3 + ", ");
        sql.append(" " + TBTHB2KMEI.CODE1 + ") ");
        sql.append(" UNION ");
        sql.append(" (SELECT ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.URMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.CODE3 + " HinsyuCD, ");
        sql.append(" " + TBTHB2KMEI.CODE1 + " BaitaiCD, ");
        sql.append(" MAX(ROUND(" + TBTHB2KMEI.SEIGAK + ")) SEIGAK ");
        sql.append(" FROM ");
        sql.append(" " + TBTHB2KMEI.TBNAME + ", ");
        sql.append(" " + TBTHB1DOWN.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' ");
        sql.append(" AND ");

        // 2015/07/31 アサヒビール広告費明細書不具合対応 k.soga Mod Start
        // sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('120') ");
         sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('120', '105') ");
        // 2015/07/31 アサヒビール広告費明細書不具合対応 k.soga Mod End

        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO+ " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO+ " " );
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO+ " " );
        sql.append(" GROUP BY ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.URMEINO + ", ");
        sql.append(" " + TBTHB2KMEI.CODE3 + ", ");
        sql.append(" " + TBTHB2KMEI.CODE1 + ") ");

        return sql.toString();

    }
    /**
     * アサヒ帳票(広告費明細書媒体種別データ)の検索を行います。
     * @param cond アサヒ帳票(広告費明細書)検索条件
     * @return アサヒ帳票(広告費明細書)VOリスト
     * @throws KKHException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportAshKoukokuHiVO> findReportAshKoukokuHiByCondition(ReportAshMediaCondition cond) throws KKHException {

        super.setModel(new ReportAshKoukokuHiVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.Data;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * アサヒ帳票(広告費明細書、テレビタイム・ラジオタイム明細金額データ)の検索を行います。
     * @param cond アサヒ帳票(広告費明細書)検索条件
     * @return アサヒ帳票(広告費明細書)タイム明細金額VOリスト
     * @throws KKHException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportAshTvAndRadioKingakVO> findTvAndRadioKingakByCondition(ReportAshMediaCondition cond) throws KKHException {

        super.setModel(new ReportAshTvAndRadioKingakVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.Kingak;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

//    /**
//     * Modelの生成を行う<br>
//     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
//     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
//     *
//     * @param hashList List 検索結果
//     * @return List<CommonCodeMasterVO> 変換後の検索結果
//     */
//    @Override
//    @SuppressWarnings("unchecked")
//    protected List<ReportMacVO> createFindedModelInstances(List hashList) {
//        List<ReportMacVO> list = new ArrayList<ReportMacVO>();
//        if (getModel() instanceof ReportMacVO) {
//            for (int i = 0; i < hashList.size(); i++) {
//                Map result = (Map) hashList.get(i);
//                ReportMacVO vo = new ReportMacVO();
//                vo.setSeiGak((BigDecimal)result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
//                vo.setDate1((String)result.get(TBTHB2KMEI.DATE1.toUpperCase()));
//                vo.setKbn1((String)result.get(TBTHB2KMEI.KBN1.toUpperCase()));
//                vo.setCode1((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
//                vo.setCode2((String)result.get(TBTHB2KMEI.CODE2.toUpperCase()));
//                vo.setCode4((String)result.get(TBTHB2KMEI.CODE4.toUpperCase()));
//                vo.setName1((String)result.get(TBTHB2KMEI.NAME1.toUpperCase()));
//                vo.setName2((String)result.get(TBTHB2KMEI.NAME2.toUpperCase()));
//                vo.setName3((String)result.get(TBTHB2KMEI.NAME3.toUpperCase()));
//                vo.setKngk1((BigDecimal)result.get(TBTHB2KMEI.KNGK1.toUpperCase()));
//                vo.setKngk2((BigDecimal)result.get(TBTHB2KMEI.KNGK2.toUpperCase()));
//                vo.setSonota1((String)result.get(TBTHB2KMEI.SONOTA1.toUpperCase()));
//                vo.setJyutNo((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
//                vo.setJyMeiNo((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
//                vo.setUrMeiNo((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));
//                vo.setRenbn((String)result.get(TBTHB2KMEI.RENBN.toUpperCase()));
//                vo.setSonota2((String)result.get(TBTHB2KMEI.SONOTA2.toUpperCase()));
//                // 検索結果直後の状態にする
//                ModelUtils.copyMemberSearchAfterInstace(vo);
//                list.add(vo);
//            }
//        }
//        return list;
//    }

}
