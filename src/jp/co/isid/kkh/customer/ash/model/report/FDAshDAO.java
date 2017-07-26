package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 * <P>
 * 請求データ一覧検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・アサヒ消費税対応(2016/11/22 HLC K.Soga)<BR>
 * </P>
 * @author
 */
public class FDAshDAO extends AbstractSimpleRdbDao {

    /**汎用マスタ検索条件 */
    private ReportAshMediaCondition _cond;

    /** デフォルトコンストラクタ */
    public FDAshDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * プライマリキーを返します。
     * @return String[] プライマリキー
     */
    @Override
    public String[] getPrimryKeyNames() {
        return null;
    }

    /**
     * 更新日付フィールドを返します。
     * @return String 更新日付フィールド
     */
    public String getTimeStampKeyName() {
        return null;
    }

    /**
     * テーブル名を返します。
     * @return String テーブル名
     */
    @Override
    public String getTableName() {
        return TBTHB2KMEI.TBNAME;
    }

    /**
     * テーブル列名を返します。
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        return null;
    }

    /**
     * デフォルトのSQL文を返します。
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
        return getSelectSQLForItem();
    }

    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        sql.append("(SELECT");
        sql.append(" " + TBTHB2KMEI.NAME4 + " seikyuno,");
        sql.append(" " + TBTHB2KMEI.CODE1 + " baitaicd,");
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD Start */
        //sql.append(" (ROUND(" + TBTHB2KMEI.SEIGAK + ") + (TRUNC(ROUND(" + TBTHB2KMEI.SEIGAK + ") * (0.01 * " + TBTHB2KMEI.RITU1 + "))))" + " seikyukinzeiari,");
        //請求金額(税込)(請求金額 + 消費税)
        sql.append(" ROUND(" + TBTHB2KMEI.SEIGAK + ") + ROUND(" + TBTHB2KMEI.KNGK1 + ")" + " seikyukinzeiari,");
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD End */
        sql.append(" ROUND(" + TBTHB2KMEI.SEIGAK + ") seikyukinzeinashi,");
        sql.append(" " + TBTHB2KMEI.CODE2 + " kyokucd,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " hinsyucd,");
        sql.append(" " + TBTHB2KMEI.CODE4 + " dairitencd,");
        sql.append(" " + TBTHB2KMEI.CODE5 + " bangumicd,");
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 +" KKNAMEKJ, ");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" " + TBTHB2KMEI.NAME10 + " kenmei,");
        sql.append(" ' ' jyutjymei,");
        sql.append(" " + TBTHB2KMEI.SONOTA10 + " sortno,");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " jyutno,");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " jymeino,");
        sql.append(" " + TBTHB2KMEI.URMEINO + " urmeino,");
        sql.append(" " + TBTHB2KMEI.RENBN + " renbn,");
        sql.append(" " + TBTHB2KMEI.SEIGAK + " seikyukin,");
        sql.append(" " + TBTHB2KMEI.RITU1 + " shohizeiritu");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " <> ' ' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " NOT IN ('130','140')");
        sql.append(" )");

        sql.append(" UNION ALL");
        sql.append(" (SELECT");
        sql.append(" MIN(" + TBTHB2KMEI.NAME4 + ") seikyuno,");
        sql.append(" MIN(" + TBTHB2KMEI.CODE1 + ") baitaicd,");
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD Start */
        //sql.append(" SUM(ROUND(" + TBTHB2KMEI.SEIGAK + ") + (TRUNC(ROUND(" + TBTHB2KMEI.SEIGAK + ") * (0.01 * " + TBTHB2KMEI.RITU1 + "))))" + " seikyukinzeiari,");
        //請求金額(税込)(請求金額 + 消費税)
        sql.append(" SUM(ROUND(" + TBTHB2KMEI.SEIGAK + ") + ROUND(" + TBTHB2KMEI.KNGK1 + "))" + " seikyukinzeiari,");
        /** 2016/11/24 アサヒ消費税対応 HLC K.Soga MOD End */
        sql.append(" SUM(ROUND(" + TBTHB2KMEI.SEIGAK + ")) seikyukinzeinashi,");
        sql.append(" MIN(" + TBTHB2KMEI.CODE2 + ") kyokucd,");
        sql.append(" MIN(" + TBTHB2KMEI.CODE3 + ") hinsyucd,");
        sql.append(" MIN(" + TBTHB2KMEI.CODE4 + ") dairitencd,");
        sql.append(" MIN(" + TBTHB2KMEI.CODE5 + ") bangumicd,");
        /** 2013/01/17 JSE M.Naito DEL Start */
        //sql.append(" " + TBTHB2KMEI.NAME8 +" KKNAMEKJ, ");
        /** 2013/01/17 JSE M.Naito DEL End */
        sql.append(" MIN(" + TBTHB2KMEI.NAME10 + ") kenmei,");
        sql.append(" SUBSTR(" + TBTHB2KMEI.NAME3 + ",1,14) jyutjymei,");
        sql.append(" MIN(" + TBTHB2KMEI.SONOTA10 + ") sortno,");
        sql.append(" MIN(" + TBTHB2KMEI.JYUTNO + ") jyutno,");
        sql.append(" MIN(" + TBTHB2KMEI.JYMEINO + ") jymeino,");
        sql.append(" MIN(" + TBTHB2KMEI.URMEINO + ") urmeino,");
        sql.append(" MIN(" + TBTHB2KMEI.RENBN + ") renbn,");
        sql.append(" MIN(" + TBTHB2KMEI.SEIGAK + ") seikyukin,");
        sql.append(" MIN(" + TBTHB2KMEI.RITU1 + ") shohizeiritu");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " <> ' ' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('130','140')");

        sql.append("GROUP BY");
        sql.append(" SUBSTR(" + TBTHB2KMEI.NAME3 + ",1,14),");
        sql.append(" " + TBTHB2KMEI.CODE1 + ",");
        sql.append(" " + TBTHB2KMEI.SONOTA9);
        sql.append(")");

        sql.append("ORDER BY");
        sql.append(" sortno,");
        sql.append(" baitaicd,");
        sql.append(" seikyuno,");
        sql.append(" jyutno,");
        sql.append(" jymeino,");
        sql.append(" urmeino,");
        sql.append(" renbn");
        return sql.toString();
    }

    /**
     * 請求データ一覧の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<FDAshVO> findFDAshByCondition(ReportAshMediaCondition cond) throws KKHException {

        super.setModel(new FDAshVO());
        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }
}