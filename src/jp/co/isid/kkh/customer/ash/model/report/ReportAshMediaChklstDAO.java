package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;
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
 * <P>
 * 帳票(アサヒ)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/08 IP Shimizu)<BR>
 * ・アサヒ消費税対応(2016/11/22 HLC K.Soga)<BR>
 * </P>
 * @author
 */
public class ReportAshMediaChklstDAO extends AbstractSimpleRdbDao {

    /**汎用マスタ検索条件 */
    private ReportAshMediaCondition _cond;

    /** デフォルトコンストラクタ */
    public ReportAshMediaChklstDAO() {
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

        sql.append("(SELECT");
        sql.append(" " + TBTHB2KMEI.NAME4 + " SEIKYUNO,");
        sql.append(" (CASE RTRIM(" + TBTHB2KMEI.CODE1 + ")");
        sql.append(" WHEN '100' THEN 'AM'");
        sql.append(" WHEN '110' THEN 'BM'");
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki ADD Start */
        if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
            // アサヒビールの場合、テレビネットスポットを対象とする
            sql.append(" WHEN '105' THEN 'NS'");
        }
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki ADD End */
        sql.append(" END) BAITAIKBN,");
        sql.append(" " + TBTHB2KMEI.CODE1 + " BAITAICD,");
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD Start */
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD Start */
        //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI, ");
        //if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
            // アサヒビールの場合、消費税は請求原票と合わせるために四捨五入とする
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(round(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI, ");
        //}else{
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI, ");
        //}
        //税込金額(請求金額 + 消費税)
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") + round(" + TBTHB2KMEI.KNGK1 + ") SEIKYUKINKOMI,");
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD End */
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD End */
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") SEIKYUKIN,");
        sql.append(" MST02." + TBTHBAMST.FIELD2 + " KYOKUNM,");
        sql.append(" " + TBTHB2KMEI.CODE2 + " KYOKUCD,");
        sql.append(" MST02." + TBTHBAMST.FIELD5 + " KYOKUBAITAICD,");
        sql.append(" MST01." + TBTHBAMST.FIELD2 + " HINSYUNM,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " HINSYUCD,");
        sql.append(" MST01." + TBTHBAMST.FIELD5 + " HINSYUBAITAICD,");
        sql.append(" " + TBTHB2KMEI.CODE4 + " DAIRITENCD,");
        sql.append(" " + TBTHB2KMEI.CODE5 + " BANGUMICD,");
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 + " KENMEI,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 + " KENMEI,");
        sql.append(" " + TBTHB2KMEI.RENBN + " ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.SONOTA8 + " KEYKYOKU,");
        sql.append(" " + TBTHB2KMEI.CODE6 + ",");
        sql.append(" MST02." + TBTHBAMST.FIELD4 + " KYOKURYAKU,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" MST02." + TBTHBAMST.FIELD6);

        sql.append(" FROM");
        sql.append(" " + TBTHBAMST.TBNAME + " MST02,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST01,");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO +  " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD Start */
        //sql.append(" " + TBTHB2KMEI.CODE1 + " in ('100','110') ");
        if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
            //アサヒビールの場合、テレビネットスポットを対象とする
            sql.append(" " + TBTHB2KMEI.CODE1 + " in ('100','105','110') AND");
        }else{
            sql.append(" " + TBTHB2KMEI.CODE1 + " in ('100','110') AND");
        }
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD End */
        sql.append(" MST01." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.SYBT + " (+) = '101' AND");
        sql.append(" RTRIM(MST01." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" MST02." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.SYBT + " (+) = '204' AND");
        sql.append(" RTRIM(MST02." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE2 + ")");

        sql.append(" ) UNION");
        sql.append(" (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME4 + " SEIKYUNO,");
        sql.append(" 'IM' BAITAIKBN, ");
        sql.append(" " + TBTHB2KMEI.CODE1 + " BAITAICD,");
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD Start */
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD Start */
        //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
            //アサヒビールの場合
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(round(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}else{
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}
        //税込金額(請求金額 + 消費税)
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") + round(" + TBTHB2KMEI.KNGK1 + ") SEIKYUKINKOMI,");
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD End */
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD End */
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") SEIKYUKIN,");
        sql.append(" MST02." + TBTHBAMST.FIELD2 + " KYOKUNM,");
        sql.append(" " + TBTHB2KMEI.CODE2 + " KYOKUCD,");
        sql.append(" MST02." + TBTHBAMST.FIELD5 + " KYOKUBAITAICD,");
        sql.append(" MST01." + TBTHBAMST.FIELD2 + " HINSYUNM, ");
        sql.append(" " + TBTHB2KMEI.CODE3 + " HINSYUCD,");
        sql.append(" MST01." + TBTHBAMST.FIELD5 + " HINSYUBAITAICD,");
        sql.append(" " + TBTHB2KMEI.CODE4 + " DAIRITENCD,");
        sql.append(" " + TBTHB2KMEI.CODE5 + " BANGUMICD,");
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 + " KENMEI,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 + " KENMEI,");
        sql.append(" " + TBTHB2KMEI.RENBN + " ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.SONOTA8 + " KEYKYOKU,");
        sql.append(" " + TBTHB2KMEI.CODE6 + ", ");
        sql.append(" MST02." + TBTHBAMST.FIELD4 + " KYOKURYAKU,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + "''");

        sql.append(" FROM");
        sql.append(" " + TBTHBAMST.TBNAME + " MST02,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST01,");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO +  " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " in ('130') AND");
        sql.append(" MST01." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.SYBT + " (+) = '101' AND");
        sql.append(" RTRIM(MST01." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" MST02." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.SYBT + " (+) = '202' AND");
        sql.append(" RTRIM(MST02." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE2 + ")");

        sql.append(" ) UNION");
        sql.append(" (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME4 + " SEIKYUNO,");
        sql.append(" 'JM' BAITAIKBN,");
        sql.append(" " + TBTHB2KMEI.CODE1 + " BAITAICD,");
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD Start */
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD Start */
        //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
            //アサヒビールの場合
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(round(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}else{
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}
        //税込金額(請求金額 + 消費税)
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") + round(" + TBTHB2KMEI.KNGK1 + ") SEIKYUKINKOMI,");
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD End */
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD End */
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") SEIKYUKIN,");
        sql.append(" MST02." + TBTHBAMST.FIELD2 + " KYOKUNM,");
        sql.append(" " + TBTHB2KMEI.CODE2 + " KYOKUCD,");
        sql.append(" MST02." + TBTHBAMST.FIELD5 + " KYOKUBAITAICD,");
        sql.append(" MST01." + TBTHBAMST.FIELD2 + " HINSYUNM,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " HINSYUCD,");
        sql.append(" MST01." + TBTHBAMST.FIELD5 + " HINSYUBAITAICD,");
        sql.append(" " + TBTHB2KMEI.CODE4 + " DAIRITENCD,");
        sql.append(" " + TBTHB2KMEI.CODE5 + " BANGUMICD,");
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 + " KENMEI,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 + " KENMEI,");
        sql.append(" " + TBTHB2KMEI.RENBN + " ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.SONOTA8 + " KEYKYOKU,");
        sql.append(" " + TBTHB2KMEI.CODE6 + ",");
        sql.append(" MST02." + TBTHBAMST.FIELD4 + " KYOKURYAKU,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + "''");

        sql.append(" FROM");
        sql.append(" " + TBTHBAMST.TBNAME + " MST02,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST01,");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO +  " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " in ('140') AND");
        sql.append(" MST01." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.SYBT + " (+) = '101' AND");
        sql.append(" RTRIM(MST01." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" MST02." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.SYBT + " (+) = '203' AND");
        sql.append(" RTRIM(MST02." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE6 + ")");

        sql.append(" ) UNION");
        sql.append(" (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME4 + " SEIKYUNO,");
        sql.append(" 'GM' BAITAIKBN,");
        sql.append(" " + TBTHB2KMEI.CODE1 + " BAITAICD,");
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD Start */
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD Start */
        //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
            //アサヒビールの場合
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(round(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}else{
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}
        //税込金額(請求金額 + 消費税)
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") + round(" + TBTHB2KMEI.KNGK1 + ") SEIKYUKINKOMI,");
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD End */
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD End */
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") SEIKYUKIN,");
        sql.append(" MST02." + TBTHBAMST.FIELD2 + " KYOKUNM,");
        sql.append(" " + TBTHB2KMEI.CODE2 + " KYOKUCD,");
        sql.append(" MST02." + TBTHBAMST.FIELD5 + " KYOKUBAITAICD,");
        sql.append(" MST01." + TBTHBAMST.FIELD2 + " HINSYUNM,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " HINSYUCD,");
        sql.append(" MST01." + TBTHBAMST.FIELD5 + " HINSYUBAITAICD,");
        sql.append(" " + TBTHB2KMEI.CODE4 + " DAIRITENCD,");
        sql.append(" " + TBTHB2KMEI.CODE5 + " BANGUMICD,");
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 + " KENMEI,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 + " KENMEI,");
        sql.append(" " + TBTHB2KMEI.RENBN + " ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.SONOTA8 + " KEYKYOKU,");
        sql.append(" " + TBTHB2KMEI.CODE6 + ",");
        sql.append(" MST02." + TBTHBAMST.FIELD4 + " KYOKURYAKU,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + "''");

        sql.append(" FROM");
        sql.append(" " + TBTHBAMST.TBNAME + " MST02,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST01,");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO +  " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " in ('120') AND");
        sql.append(" MST01." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.SYBT + " (+) = '101' AND");
        sql.append(" RTRIM(MST01." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" MST02." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.SYBT + " (+) = '205' AND");
        sql.append(" RTRIM(MST02." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE2 + ")");

        sql.append(" ) UNION");
        sql.append(" (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME4 + " SEIKYUNO,");
        sql.append(" 'HM' BAITAIKBN,");
        sql.append(" " + TBTHB2KMEI.CODE1 + " BAITAICD,");
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD Start */
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD Start */
        //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
            //アサヒビールの場合
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(round(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}else{
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}
        //税込金額(請求金額 + 消費税)
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") + round(" + TBTHB2KMEI.KNGK1 + ") SEIKYUKINKOMI,");
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD End */
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD End */
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") SEIKYUKIN,");
        sql.append(" MST02." + TBTHBAMST.FIELD2 + " KYOKUNM,");
        sql.append(" " + TBTHB2KMEI.CODE2 + " KYOKUCD,");
        sql.append(" MST02." + TBTHBAMST.FIELD5 + " KYOKUBAITAICD,");
        sql.append(" MST01." + TBTHBAMST.FIELD2 + " HINSYUNM,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " HINSYUCD,");
        sql.append(" MST01." + TBTHBAMST.FIELD5 + " HINSYUBAITAICD,");
        sql.append(" " + TBTHB2KMEI.CODE4 + " DAIRITENCD,");
        sql.append(" " + TBTHB2KMEI.CODE5 + " BANGUMICD,");
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 + " KENMEI,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 + " KENMEI,");
        sql.append(" " + TBTHB2KMEI.RENBN + " ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.SONOTA8 + " KEYKYOKU,");
        sql.append(" " + TBTHB2KMEI.CODE6 + ",");
        sql.append(" MST02." + TBTHBAMST.FIELD4 + " KYOKURYAKU,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + "''");

        sql.append(" FROM");
        sql.append(" " + TBTHBAMST.TBNAME + " MST02,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST01,");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO +  " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " in ('125') AND");
        sql.append(" MST01." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.SYBT + " (+) = '101' AND");
        sql.append(" RTRIM(MST01." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" MST02." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.SYBT + " (+) = '205' AND");
        sql.append(" RTRIM(MST02." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE2 + ")");

        sql.append(" ) UNION");
        sql.append(" (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME4 + " SEIKYUNO,");
        sql.append(" 'KM' BAITAIKBN,");
        sql.append(" " + TBTHB2KMEI.CODE1 + " BAITAICD,");
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD Start */
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD Start */
        //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
            //アサヒビールの場合
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(round(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}else{
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}
        //税込金額(請求金額 + 消費税)
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") + round(" + TBTHB2KMEI.KNGK1 + ") SEIKYUKINKOMI,");
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD End */
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD End */
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") SEIKYUKIN,");
        sql.append(" MST02." + TBTHBAMST.FIELD2 + " KYOKUNM,");
        sql.append(" " + TBTHB2KMEI.CODE2 + " KYOKUCD,");
        sql.append(" MST02." + TBTHBAMST.FIELD5 + " KYOKUBAITAICD,");
        sql.append(" MST01." + TBTHBAMST.FIELD2 + " HINSYUNM,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " HINSYUCD,");
        sql.append(" MST01." + TBTHBAMST.FIELD5 + " HINSYUBAITAICD,");
        sql.append(" " + TBTHB2KMEI.CODE4 + " DAIRITENCD,");
        sql.append(" " + TBTHB2KMEI.CODE5 + " BANGUMICD,");
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 + " KENMEI, ");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 + " KENMEI,");
        sql.append(" " + TBTHB2KMEI.RENBN + " ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.SONOTA8 + " KEYKYOKU,");
        sql.append(" " + TBTHB2KMEI.CODE6 + ",");
        sql.append(" MST02." + TBTHBAMST.FIELD4 + " KYOKURYAKU,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + "''");

        sql.append(" FROM");
        sql.append(" " + TBTHBAMST.TBNAME + " MST02,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST01,");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO +  " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " in ('150') AND");
        sql.append(" MST01." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.SYBT + " (+) = '101' AND");
        sql.append(" RTRIM(MST01." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" MST02." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.SYBT + " (+) = '206' AND");
        sql.append(" RTRIM(MST02." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE2 + ")");

        sql.append(" ) UNION");
        sql.append(" (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME4 + " SEIKYUNO,");
        sql.append(" 'MM' BAITAIKBN,");
        sql.append(" " + TBTHB2KMEI.CODE1 + " BAITAICD,");
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD Start */
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD Start */
        //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
            //アサヒビールの場合
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(round(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}else{
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}
        //税込金額(請求金額 + 消費税)
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") + round(" + TBTHB2KMEI.KNGK1 + ") SEIKYUKINKOMI,");
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD End */
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD End */
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") SEIKYUKIN,");
        sql.append(" MST02." + TBTHBAMST.FIELD2 + " KYOKUNM,");
        sql.append(" " + TBTHB2KMEI.CODE2 + " KYOKUCD,");
        sql.append(" MST02." + TBTHBAMST.FIELD5 + " KYOKUBAITAICD,");
        sql.append(" MST01." + TBTHBAMST.FIELD2 + " HINSYUNM,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " HINSYUCD,");
        sql.append(" MST01." + TBTHBAMST.FIELD5 + " HINSYUBAITAICD,");
        sql.append(" " + TBTHB2KMEI.CODE4 + " DAIRITENCD,");
        sql.append(" " + TBTHB2KMEI.CODE5 + " BANGUMICD,");
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 + " KENMEI,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 + " KENMEI,");
        sql.append(" " + TBTHB2KMEI.RENBN + " ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.SONOTA8 + " KEYKYOKU,");
        sql.append(" " + TBTHB2KMEI.CODE6 + ",");
        sql.append(" MST02." + TBTHBAMST.FIELD4 + " KYOKURYAKU,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + "''");

        sql.append(" FROM");
        sql.append(" " + TBTHBAMST.TBNAME + " MST02,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST01,");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO +  " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " in ('170') AND");
        sql.append(" MST01." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.SYBT + " (+) = '101' AND");
        sql.append(" RTRIM(MST01." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" MST02." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.SYBT + " (+) = '216' AND");
        sql.append(" RTRIM(MST02." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE2 + ")");

        sql.append(" ) UNION");
        sql.append(" (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME4 + " SEIKYUNO,");
        sql.append(" (CASE RTRIM(" + TBTHB2KMEI.CODE1 + ")");
        sql.append(" WHEN '160' THEN 'LM'");
        sql.append(" WHEN '180' THEN 'NM'");
        sql.append(" END) BAITAIKBN,");
        sql.append(" " + TBTHB2KMEI.CODE1 + " BAITAICD,");
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD Start */
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD Start */
        //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
            //アサヒビールの場合
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(round(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}else{
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}
        //税込金額(請求金額 + 消費税)
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") + round(" + TBTHB2KMEI.KNGK1 + ") SEIKYUKINKOMI,");
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD End */
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD End */
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") SEIKYUKIN,");
        sql.append(" MST02." + TBTHBAMST.FIELD2 + " KYOKUNM,");
        sql.append(" " + TBTHB2KMEI.CODE2 + " KYOKUCD,");
        sql.append(" MST02." + TBTHBAMST.FIELD5 + " KYOKUBAITAICD,");
        sql.append(" MST01." + TBTHBAMST.FIELD2 + " HINSYUNM,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " HINSYUCD,");
        sql.append(" MST01." + TBTHBAMST.FIELD5 + " HINSYUBAITAICD,");
        sql.append(" " + TBTHB2KMEI.CODE4 + " DAIRITENCD,");
        sql.append(" " + TBTHB2KMEI.CODE5 + " BANGUMICD,");
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 + " KENMEI,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 + " KENMEI,");
        sql.append(" " + TBTHB2KMEI.RENBN + " ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.SONOTA8 + " KEYKYOKU,");
        sql.append(" " + TBTHB2KMEI.CODE6 + ",");
        sql.append(" MST02." + TBTHBAMST.FIELD4 + " KYOKURYAKU,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + "''");

        sql.append(" FROM");
        sql.append(" " + TBTHBAMST.TBNAME + " MST02,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST01,");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " in ('160','180') AND");
        sql.append(" MST01." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.SYBT + " (+) = '101' AND");
        sql.append(" RTRIM(MST01." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" MST02." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.SYBT + " (+) = '217' AND");
        sql.append(" RTRIM(MST02." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE2 + ")");

        sql.append(" ) UNION");
        sql.append(" (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME4 + " SEIKYUNO,");
        sql.append(" (CASE RTRIM(" + TBTHB2KMEI.CODE1 + ")");
        sql.append(" WHEN '190' THEN 'PM'");
        sql.append(" WHEN '115' THEN 'CM'");
        sql.append(" WHEN '116' THEN 'DM'");
        sql.append(" WHEN '117' THEN 'EM'");
        sql.append(" WHEN '118' THEN 'FM'");
        sql.append(" WHEN '195' THEN 'PM'");
        sql.append(" END) BAITAIKBN,");
        sql.append(" " + TBTHB2KMEI.CODE1 + " BAITAICD,");
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD Start */
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD Start */
        //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
            //アサヒビールの場合
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(round(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}else{
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}
        //税込金額(請求金額 + 消費税)
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") + round(" + TBTHB2KMEI.KNGK1 + ") SEIKYUKINKOMI,");
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD End */
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD End */
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") SEIKYUKIN,");
        sql.append(" MST02." + TBTHBAMST.FIELD2 + " KYOKUNM,");
        sql.append(" " + TBTHB2KMEI.CODE2 + " KYOKUCD,");
        /** 2015/07/03 アサヒ飲料対応 HLC K.Fujisaki MOD Start */
        //sql.append(" MST02." + TBTHBAMST.FIELD5 + " KYOKUBAITAICD,");
        sql.append(" MST02." + TBTHBAMST.FIELD1 + " KYOKUBAITAICD,");
        /** 2015/07/03 アサヒ飲料対応 HLC K.Fujisaki MOD End */
        sql.append(" MST01." + TBTHBAMST.FIELD2 + " HINSYUNM,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " HINSYUCD,");
        sql.append(" MST01." + TBTHBAMST.FIELD5 + " HINSYUBAITAICD,");
        sql.append(" " + TBTHB2KMEI.CODE4 + " DAIRITENCD,");
        sql.append(" " + TBTHB2KMEI.CODE5 + " BANGUMICD,");
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 + " KENMEI,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 + " KENMEI,");
        sql.append(" " + TBTHB2KMEI.RENBN + " ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.SONOTA8 + " KEYKYOKU,");
        sql.append(" " + TBTHB2KMEI.CODE6 + ",");
        sql.append(" MST02." + TBTHBAMST.FIELD4 + " KYOKURYAKU,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + "''");

        sql.append(" FROM");
        sql.append(" " + TBTHBAMST.TBNAME + " MST02,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST01,");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO +  " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        /** 2015/03/03 アサヒ対応 HLC K.Fujisaki MOD Start */
        //sql.append(" " + TBTHB2KMEI.CODE1 + " in ('190','115','116','117','118','195') ");
        if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
            //アサヒビールの場合
            /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD Start */
            //sql.append(" " + TBTHB2KMEI.CODE1 + " in ('190','115','116','117','118','195','193','194','199') ");
            sql.append(" " + TBTHB2KMEI.CODE1 + " NOT IN ('100','105','110','130','140','120','150','170','119','160','180','230','240') AND");
            /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD End */
        }else{
            //アサヒ飲料の場合
            sql.append(" " + TBTHB2KMEI.CODE1 + " in ('190','115','116','117','118','195','321','322','331','332','333','334','336','380','382','389') AND");
        }
        /** 2015/03/03 アサヒ対応 HLC K.Fujisaki MOD End */
        sql.append(" MST01." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.SYBT + " (+) = '101' AND");
        sql.append(" RTRIM(MST01." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" MST02." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.SYBT + " (+) = '218' AND");
        sql.append(" RTRIM(MST02." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE2 + ") AND");
        /** 2015/02/25 HLC K.Fujisaki ADD Start */
        sql.append(" RTRIM(MST02." + TBTHBAMST.FIELD9 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE1 + ")");
        /** 2015/02/25 HLC K.Fujisaki ADD End */

        sql.append(" ) UNION");
        sql.append(" (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME4 + " SEIKYUNO,");
        sql.append(" '' BAITAIKBN,");
        sql.append(" " + TBTHB2KMEI.CODE1 + " BAITAICD,");
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD Start */
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD Start */
        //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
            //アサヒビールの場合
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(round(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}else{
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}
        //税込金額(請求金額 + 消費税)
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") + round(" + TBTHB2KMEI.KNGK1 + ") SEIKYUKINKOMI,");
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD End */
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD End */
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") SEIKYUKIN,");
        sql.append(" MST02." + TBTHBAMST.FIELD2 + " KYOKUNM,");
        sql.append(" " + TBTHB2KMEI.CODE2 + " KYOKUCD,");
        sql.append(" MST02." + TBTHBAMST.FIELD5 + " KYOKUBAITAICD,");
        sql.append(" MST01." + TBTHBAMST.FIELD2 + " HINSYUNM,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " HINSYUCD,");
        sql.append(" MST01." + TBTHBAMST.FIELD5 + " HINSYUBAITAICD,");
        sql.append(" " + TBTHB2KMEI.CODE4 + " DAIRITENCD,");
        sql.append(" " + TBTHB2KMEI.CODE5 + " BANGUMICD,");
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 + " KENMEI,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 + " KENMEI,");
        sql.append(" " + TBTHB2KMEI.RENBN + " ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.SONOTA8 + " KEYKYOKU,");
        sql.append(" " + TBTHB2KMEI.CODE6 + ",");
        sql.append(" MST02." + TBTHBAMST.FIELD4 + " KYOKURYAKU,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + "''");

        sql.append(" FROM");
        sql.append(" " + TBTHBAMST.TBNAME + " MST02,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST01,");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO +  " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " in ('230') AND");
        sql.append(" MST01." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.SYBT + " (+) = '101' AND");
        sql.append(" RTRIM(MST01." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" MST02." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.SYBT + " (+) = '219' AND");
        sql.append(" RTRIM(MST02." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE2 + ")");

        sql.append(" ) UNION");
        sql.append(" (SELECT");
        sql.append(" " + TBTHB2KMEI.NAME4 + " SEIKYUNO,");
        sql.append(" 'MM' BAITAIKBN,");
        sql.append(" " + TBTHB2KMEI.CODE1 + " BAITAICD,");
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD Start */
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD Start */
        //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //if (KKHConstants.TksKgyCode.ASH.getCode().equals(_cond.getTksKgyCd() + _cond.getTksBmnSeqNo() + _cond.getTksTntSeqNo())){
            //アサヒビールの場合
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(round(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}else{
            //sql.append(" (round(" + TBTHB2KMEI.SEIGAK + ")+(trunc(round(" + TBTHB2KMEI.SEIGAK + ")*(0.01*" + TBTHB2KMEI.RITU1 + ")))) SEIKYUKINKOMI,");
        //}
        //税込金額(請求金額 + 消費税)
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") + round(" + TBTHB2KMEI.KNGK1 + ") SEIKYUKINKOMI,");
        /** 2015/06/08 アサヒ対応 HLC K.Fujisaki MOD End */
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD End */
        sql.append(" round(" + TBTHB2KMEI.SEIGAK + ") SEIKYUKIN,");
        sql.append(" MST02." + TBTHBAMST.FIELD2 + " KYOKUNM,");
        sql.append(" " + TBTHB2KMEI.CODE2 + " KYOKUCD,");
        sql.append(" MST02." + TBTHBAMST.FIELD5 + " KYOKUBAITAICD,");
        sql.append(" MST01." + TBTHBAMST.FIELD2 + " HINSYUNM,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " HINSYUCD,");
        sql.append(" MST01." + TBTHBAMST.FIELD5 + " HINSYUBAITAICD,");
        sql.append(" " + TBTHB2KMEI.CODE4 + " DAIRITENCD,");
        sql.append(" " + TBTHB2KMEI.CODE5 + " BANGUMICD,");
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 + " KENMEI,");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 + " KENMEI,");
        sql.append(" " + TBTHB2KMEI.RENBN + " ,");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.SONOTA8 + " KEYKYOKU,");
        sql.append(" " + TBTHB2KMEI.CODE6 + ",");
        sql.append(" MST02." + TBTHBAMST.FIELD4 + " KYOKURYAKU,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + "''");

        sql.append(" FROM");
        sql.append(" " + TBTHBAMST.TBNAME + " MST02,");
        sql.append(" " + TBTHBAMST.TBNAME + " MST01,");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + "= '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + "= '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + "= '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + "= '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO +  " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " in ('240') AND");
        sql.append(" MST01." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST01." + TBTHBAMST.SYBT + " (+) = '101' AND");
        sql.append(" RTRIM(MST01." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE3 + ") AND");
        sql.append(" MST02." + TBTHBAMST.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" MST02." + TBTHBAMST.SYBT + " (+) = '220' AND");
        sql.append(" RTRIM(MST02." + TBTHBAMST.FIELD1 + " (+)) = RTRIM(" + TBTHB2KMEI.CODE2 + ")");
        sql.append(" ) ");

        sql.append("ORDER BY");
        sql.append(" HB2_SONOTA10,");
        sql.append(" BAITAICD,");
        sql.append(" SEIKYUNO,");
        sql.append(" HB2_JYUTNO,");
        sql.append(" HB2_JYMEINO,");
        sql.append(" HB2_URMEINO,");
        sql.append(" HB2_RENBN");

        return sql.toString();
    }

    /**
     * 帳票データ（MAC)の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportAshMediaChklstVO> findReportAshMediaChklstByCondition(ReportAshMediaCondition cond) throws KKHException {

        super.setModel(new ReportAshMediaChklstVO());
        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    @Override
    public String[] getTableColumnNames() {
        return null;
    }

    @Override
    public String getTableName() {
        return null;
    }
}