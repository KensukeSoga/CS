package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB11WLTVK;
import jp.co.isid.kkh.integ.tbl.TBTHB12WLRDK;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 * <P>
 * ライオンFD出力データ取得DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FDLionDAO extends AbstractRdbDao {

    /** ライオンFD出力データ検索条件 */
    private FDLionCondition _cond;

    /** ﾃﾚﾋﾞﾀｲﾑ */
    private static final String MEDIA_TYPE_TVTIME = "TVTIME";

    /** ﾃﾚﾋﾞ･ﾗｼﾞｵｽﾎﾟｯﾄ */
    private static final String MEDIA_TYPE_TVSP = "TVSP";

    /** ﾗｼﾞｵﾀｲﾑ */
    private static final String MEDIA_TYPE_RD_TIME = "RD_TIME";

    /** 新聞 */
    private static final String MEDIA_TYPE_NEWS = "NEWS";

    /** 雑誌 */
    private static final String MEDIA_TYPE_MAG = "MAG";

    /** 交通広告 */
    private static final String MEDIA_TYPE_KOUTUU = "KOUTUU";

    /** その他 */
    private static final String MEDIA_TYPE_ATHER = "ATHER";

    /** ﾁﾗｼ */
    private static final String MEDIA_TYPE_Leaflet = "Leaflet";

    /** ｻﾝﾌﾟﾘﾝｸﾞ */
    private static final String MEDIA_TYPE_Sampling = "Sampling";

    /** BS･CS */
    private static final String MEDIA_TYPE_BSCS = "BSCS";

    /** Internet */
    private static final String MEDIA_TYPE_Internet = "Internet";

    /** ﾓﾊﾞｲﾙ */
    private static final String MEDIA_TYPE_Mobile = "Mobile";

    /** 事業費 */
    private static final String MEDIA_TYPE_BusinessExp = "BusinessExp";

    /** 全媒体消費税 */
    private static final String MEDIA_TYPE_Syouhi = "Syouhi";

    /** 制作 */
    private static final String MEDIA_TYPE_SEISAKU = "SEISAKU";


    /**
     * デフォルトコンストラクタ。
     */
    public FDLionDAO() {
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
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    @Override
    public String getTableName() {
        return null;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
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

    private String getSelectSQLForItem() {

        StringBuffer sql = new StringBuffer();

        if (_cond.getKbn().equals(MEDIA_TYPE_TVTIME)) {

            // FOG141_TVTIME
            sql.append("SELECT ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " kadoNo, ");
            sql.append("    " + TBTHB2KMEI.YYMM + " nentuki, ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " dairitencd, ");
            sql.append("    " + TBTHB2KMEI.CODE1 + " baitaicd, ");
            sql.append("    " + TBTHB2KMEI.CODE5 + " bangumi, ");
            sql.append("    " + TBTHB2KMEI.CODE3 + " brandcd, ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " kyokucd, ");
            sql.append("    " + TBTHB2KMEI.SONOTA3 + " netfc, ");
            sql.append("    NULL kyokuNm, ");
            sql.append("    NULL brandName, ");
            sql.append("    D." + TBTHB11WLTVK.KYOKUNAME + " kyokuNameTR, ");
            sql.append("    NULL NewsName, ");
            sql.append("    " + TBTHB2KMEI.SONOTA2 + " fukencd, ");
            sql.append("    " + TBTHB2KMEI.KNGK1 + " denpa, ");
            sql.append("    " + TBTHB2KMEI.KNGK2 + " neto, ");
            sql.append("    " + TBTHB2KMEI.KNGK3 + " seisaku, ");
            sql.append("    " + TBTHB2KMEI.SEIGAK + " seikyuu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA6 + " soubyousu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA7 + " byousu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA4 + " gensen, ");
            sql.append("    " + TBTHB2KMEI.SONOTA5 + " honsu, ");
            sql.append("    NULL housou, ");
            sql.append("    0 syouhizeigaku, ");
            sql.append("    NULL kyusi, ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + " jyunban, ");
            sql.append("    (" + TBTHB2KMEI.SEIGAK + "*(" + TBTHB2KMEI.RITU1 + "*0.01)) syouhi, ");
            sql.append("    (" + TBTHB2KMEI.RITU1 + "*0.01) syouhizeiritu, ");
            sql.append("    (" + TBTHB2KMEI.HNNERT + "*0.01) nebikiritu, ");
            sql.append("    NULL GYOMKBN ");
            sql.append("FROM ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    " + TBTHB11WLTVK.TBNAME + " D, ");
            sql.append("    " + TBTHB1DOWN.TBNAME + " ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("    D." + TBTHB11WLTVK.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    D." + TBTHB11WLTVK.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    D." + TBTHB11WLTVK.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYM() + "' AND ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " In ('001','002') AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE2 + ") = TRIM(D." + TBTHB11WLTVK.KYOKUCD + ") AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " (+)= " + TBTHB2KMEI.EGCD + " AND ");
            sql.append("    " + TBTHB1DOWN.YYMM + " (+)= " + TBTHB2KMEI.YYMM + " AND ");
            sql.append("    " + TBTHB1DOWN.JYUTNO + " (+) = " + TBTHB2KMEI.JYUTNO + " AND ");
            sql.append("    " + TBTHB1DOWN.JYMEINO + " (+) = " + TBTHB2KMEI.JYMEINO + " AND ");
            sql.append("    " + TBTHB1DOWN.URMEINO + " (+) = " + TBTHB2KMEI.URMEINO + " ");
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + ", ");
            sql.append("    " + TBTHB2KMEI.SONOTA2 + " ");

        } else if (_cond.getKbn().equals(MEDIA_TYPE_TVSP)) {

            // FOG141_TVSP
            sql.append("SELECT ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " kadoNo, ");
            sql.append("    " + TBTHB2KMEI.YYMM + " nentuki, ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " dairitencd, ");
            sql.append("    " + TBTHB2KMEI.CODE1 + " baitaicd, ");
            sql.append("    " + TBTHB2KMEI.CODE5 + " bangumi, ");
            sql.append("    " + TBTHB2KMEI.CODE3 + " brandcd, ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " kyokucd, ");
            sql.append("    " + TBTHB2KMEI.SONOTA3 + " netfc, ");
            sql.append("    NULL kyokuNm, ");
            sql.append("    B." + TBTHBAMST.FIELD2 + " brandName, ");
            sql.append("    D." + TBTHB11WLTVK.KYOKUNAME + " kyokuNameTR, ");
            sql.append("    NULL NewsName, ");
            sql.append("    " + TBTHB2KMEI.SONOTA2 + " fukencd, ");
            sql.append("    " + TBTHB2KMEI.KNGK1 + " denpa, ");
            sql.append("    " + TBTHB2KMEI.KNGK2 + " neto, ");
            sql.append("    " + TBTHB2KMEI.KNGK3 + " seisaku, ");
            sql.append("    " + TBTHB2KMEI.SEIGAK + " seikyuu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA6 + " soubyousu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA7 + " byousu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA4 + " gensen, ");
            sql.append("    NULL honsu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA8 + " housou, ");
            sql.append("    0 syouhizeigaku, ");
            sql.append("    " + TBTHB2KMEI.SONOTA1 + " kyusi, ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + " jyunban, ");
            sql.append("    (" + TBTHB2KMEI.SEIGAK + "*(" + TBTHB2KMEI.RITU1 + "*0.01)) syouhi, ");
            sql.append("    (" + TBTHB2KMEI.RITU1 + "*0.01) syouhizeiritu, ");
            sql.append("    (" + TBTHB2KMEI.HNNERT + "*0.01) nebikiritu, ");
            sql.append("    " + TBTHB1DOWN.GYOMKBN + " GYOMKBN ");
            sql.append("FROM ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    (SELECT ");
            sql.append("        " + TBTHB11WLTVK.TKSKGYCD + ", ");
            sql.append("        " + TBTHB11WLTVK.TKSBMNSEQNO + ", ");
            sql.append("        " + TBTHB11WLTVK.TKSTNTSEQNO + ", ");
            sql.append("        " + TBTHB11WLTVK.KYOKUCD + ", ");
            sql.append("        " + TBTHB11WLTVK.KYOKUNAME + " ");
            sql.append("    FROM ");
            sql.append("        " + TBTHB11WLTVK.TBNAME + " ");
            sql.append("    UNION ");
            sql.append("    SELECT ");
            sql.append("        " + TBTHB12WLRDK.TKSKGYCD + " AS " + TBTHB11WLTVK.TKSKGYCD + ", ");
            sql.append("        " + TBTHB12WLRDK.TKSBMNSEQNO + " AS " + TBTHB11WLTVK.TKSBMNSEQNO + ", ");
            sql.append("        " + TBTHB12WLRDK.TKSTNTSEQNO + " AS " + TBTHB11WLTVK.TKSTNTSEQNO + ", ");
            sql.append("        " + TBTHB12WLRDK.KYOKUCD + " AS " + TBTHB11WLTVK.KYOKUCD + ", ");
            sql.append("        " + TBTHB12WLRDK.KYOKUNAME + " AS " + TBTHB11WLTVK.KYOKUNAME + " ");
            sql.append("    FROM ");
            sql.append("        " + TBTHB12WLRDK.TBNAME + " ");
            sql.append("    ) D, ");
            sql.append("    " + TBTHBAMST.TBNAME + " B, ");
            sql.append("    " + TBTHB1DOWN.TBNAME + " ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("    D." + TBTHB11WLTVK.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    D." + TBTHB11WLTVK.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    D." + TBTHB11WLTVK.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    B." + TBTHBAMST.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    B." + TBTHBAMST.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    B." + TBTHBAMST.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYM() + "' AND ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " in ('005') AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE2 + ") = TRIM(D." + TBTHB11WLTVK.KYOKUCD + "(+)) AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(B." + TBTHBAMST.FIELD1 + ") AND ");
            sql.append("    B." + TBTHBAMST.SYBT + " = '201' AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " (+)= " + TBTHB2KMEI.EGCD + " AND ");
            sql.append("    " + TBTHB1DOWN.YYMM + " (+)= " + TBTHB2KMEI.YYMM + " AND ");
            sql.append("    " + TBTHB1DOWN.JYUTNO + " (+) = " + TBTHB2KMEI.JYUTNO + " AND ");
            sql.append("    " + TBTHB1DOWN.JYMEINO + " (+) = " + TBTHB2KMEI.JYMEINO + " AND ");
            sql.append("    " + TBTHB1DOWN.URMEINO + " (+) = " + TBTHB2KMEI.URMEINO + " ");
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB1DOWN.GYOMKBN + " DESC, ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.SONOTA2 + " ");

        } else if (_cond.getKbn().equals(MEDIA_TYPE_RD_TIME)) {

            // FOG141_RD_TIME
            sql.append("SELECT ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " kadoNo, ");
            sql.append("    " + TBTHB2KMEI.YYMM + " nentuki, ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " dairitencd, ");
            sql.append("    " + TBTHB2KMEI.CODE1 + " baitaicd, ");
            sql.append("    " + TBTHB2KMEI.CODE5 + " bangumi, ");
            sql.append("    " + TBTHB2KMEI.CODE3 + " brandcd, ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " kyokucd, ");
            sql.append("    " + TBTHB2KMEI.SONOTA3 + " netfc, ");
            sql.append("    NULL kyokuNm, ");
            sql.append("    NULL brandName, ");
            sql.append("    D." + TBTHB12WLRDK.KYOKUNAME + " kyokuNameTR, ");
            sql.append("    NULL NewsName, ");
            sql.append("    " + TBTHB2KMEI.SONOTA2 + " fukencd, ");
            sql.append("    " + TBTHB2KMEI.KNGK1 + " denpa, ");
            sql.append("    " + TBTHB2KMEI.KNGK2 + " neto, ");
            sql.append("    " + TBTHB2KMEI.KNGK3 + " seisaku, ");
            sql.append("    " + TBTHB2KMEI.SEIGAK + " seikyuu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA6 + " soubyousu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA7 + " byousu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA4 + " gensen, ");
            sql.append("    " + TBTHB2KMEI.SONOTA5 + " honsu, ");
            sql.append("    NULL housou, ");
            sql.append("    0 syouhizeigaku, ");
            sql.append("    NULL kyusi, ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + " jyunban, ");
            sql.append("    (" + TBTHB2KMEI.SEIGAK + "*(" + TBTHB2KMEI.RITU1 + "*0.01)) syouhi, ");
            sql.append("    (" + TBTHB2KMEI.RITU1 + "*0.01) syouhizeiritu, ");
            sql.append("    (" + TBTHB2KMEI.HNNERT + "*0.01) nebikiritu, ");
            sql.append("    NULL GYOMKBN ");
            sql.append("FROM ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    " + TBTHB12WLRDK.TBNAME + " D, ");
            sql.append("    " + TBTHB1DOWN.TBNAME + " ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("    D." + TBTHB12WLRDK.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    D." + TBTHB12WLRDK.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    D." + TBTHB12WLRDK.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYM() + "' AND ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " In ('003','004') AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE2 + ") = TRIM(D." + TBTHB12WLRDK.KYOKUCD + ") AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " (+)= " + TBTHB2KMEI.EGCD + " AND ");
            sql.append("    " + TBTHB1DOWN.YYMM + " (+)= " + TBTHB2KMEI.YYMM + " AND ");
            sql.append("    " + TBTHB1DOWN.JYUTNO + " (+) = " + TBTHB2KMEI.JYUTNO + " AND ");
            sql.append("    " + TBTHB1DOWN.JYMEINO + " (+) = " + TBTHB2KMEI.JYMEINO + " AND ");
            sql.append("    " + TBTHB1DOWN.URMEINO + " (+) = " + TBTHB2KMEI.URMEINO + " ");
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.SONOTA2 + " ");

        } else if (_cond.getKbn().equals(MEDIA_TYPE_NEWS)) {

            // FOG141_NEWS
            sql.append("SELECT ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " kadoNo, ");
            sql.append("    " + TBTHB2KMEI.YYMM + " nentuki, ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " dairitencd, ");
            sql.append("    " + TBTHB2KMEI.CODE1 + " baitaicd, ");
            sql.append("    " + TBTHB2KMEI.CODE5 + " bangumi, ");
            sql.append("    " + TBTHB2KMEI.CODE3 + " brandcd, ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " kyokucd, ");
            sql.append("    " + TBTHB2KMEI.SONOTA3 + " netfc, ");
            sql.append("    NULL kyokuNm, ");
            sql.append("    B." + TBTHBAMST.FIELD2 + " brandName, ");
            sql.append("    NULL kyokuNameTR, ");
            sql.append("    A." + TBTHBAMST.FIELD2 + " NewsName, ");
            sql.append("    " + TBTHB2KMEI.SONOTA2 + " fukencd, ");
            sql.append("    " + TBTHB2KMEI.KNGK1 + " denpa, ");
            sql.append("    " + TBTHB2KMEI.KNGK2 + " neto, ");
            sql.append("    " + TBTHB2KMEI.KNGK3 + " seisaku, ");
            sql.append("    " + TBTHB2KMEI.SEIGAK + " seikyuu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA6 + " soubyousu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA7 + " byousu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA4 + " gensen, ");
            sql.append("    NULL honsu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA8 + " housou, ");
            sql.append("    0 syouhizeigaku, ");
            sql.append("    " + TBTHB2KMEI.SONOTA1 + " kyusi, ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + " jyunban, ");
            sql.append("    (" + TBTHB2KMEI.SEIGAK + "*(" + TBTHB2KMEI.RITU1 + "*0.01)) syouhi, ");
            sql.append("    (" + TBTHB2KMEI.RITU1 + "*0.01) syouhizeiritu, ");
            sql.append("    (" + TBTHB2KMEI.HNNERT + "*0.01) nebikiritu, ");
            sql.append("    NULL GYOMKBN ");
            sql.append("FROM ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
//			sql.append("    " + TBTHBAMST.TBNAME + " A, ");
//			sql.append("    " + TBTHBAMST.TBNAME + " B, ");
            sql.append("    ( ");
            sql.append("        SELECT");
            sql.append("            TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1 + ",");
            sql.append("            " + TBTHBAMST.FIELD2 + " ");
            sql.append("        FROM");
            sql.append("            " + TBTHBAMST.TBNAME + " ");
            sql.append("        WHERE");
            sql.append("            " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("            " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("            " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("            " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("            " + TBTHBAMST.SYBT + " = '105' ");
            sql.append("    ) A, ");
            sql.append("    ( ");
            sql.append("        SELECT");
            sql.append("            TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1 + ",");
            sql.append("            " + TBTHBAMST.FIELD2 + " ");
            sql.append("        FROM");
            sql.append("            " + TBTHBAMST.TBNAME + " ");
            sql.append("        WHERE");
            sql.append("            " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("            " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("            " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("            " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("            " + TBTHBAMST.SYBT + " = '201' ");
            sql.append("    ) B, ");
            sql.append("    " + TBTHB1DOWN.TBNAME + " ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
//			sql.append("    A." + TBTHBAMST.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
//			sql.append("    A." + TBTHBAMST.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
//			sql.append("    A." + TBTHBAMST.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
//			sql.append("    B." + TBTHBAMST.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
//			sql.append("    B." + TBTHBAMST.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
//			sql.append("    B." + TBTHBAMST.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYM() + "' AND ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " = '007' AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE2 + ") = A." + TBTHBAMST.FIELD1 + "(+) AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = B." + TBTHBAMST.FIELD1 + "(+) AND ");
//			sql.append("    B." + TBTHBAMST.SYBT + " = '201' AND ");
//			sql.append("    A." + TBTHBAMST.SYBT + " = '105' AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + " (+)= " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + " (+)= " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + " (+)= " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " (+)= " + TBTHB2KMEI.EGCD + " AND ");
            sql.append("    " + TBTHB1DOWN.YYMM + " (+)= " + TBTHB2KMEI.YYMM + " AND ");
            sql.append("    " + TBTHB1DOWN.JYUTNO + " (+) = " + TBTHB2KMEI.JYUTNO + " AND ");
            sql.append("    " + TBTHB1DOWN.JYMEINO + " (+) = " + TBTHB2KMEI.JYMEINO + " AND ");
            sql.append("    " + TBTHB1DOWN.URMEINO + " (+) = " + TBTHB2KMEI.URMEINO + " ");
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.SONOTA2 + " ");

        } else if (_cond.getKbn().equals(MEDIA_TYPE_MAG)) {

            // FOG141_MAG
            sql.append("SELECT ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " kadoNo, ");
            sql.append("    " + TBTHB2KMEI.YYMM + " nentuki, ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " dairitencd, ");
            sql.append("    " + TBTHB2KMEI.CODE1 + " baitaicd, ");
            sql.append("    " + TBTHB2KMEI.CODE5 + " bangumi, ");
            sql.append("    " + TBTHB2KMEI.CODE3 + " brandcd, ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " kyokucd, ");
            sql.append("    " + TBTHB2KMEI.SONOTA3 + " netfc, ");
            sql.append("    NULL kyokuNm, ");
            sql.append("    B." + TBTHBAMST.FIELD2 + " brandName, ");
            sql.append("    NULL kyokuNameTR, ");
            sql.append("    A." + TBTHBAMST.FIELD2 + " NewsName, ");
            sql.append("    " + TBTHB2KMEI.SONOTA2 + " fukencd, ");
            sql.append("    " + TBTHB2KMEI.KNGK1 + " denpa, ");
            sql.append("    " + TBTHB2KMEI.KNGK2 + " neto, ");
            sql.append("    " + TBTHB2KMEI.KNGK3 + " seisaku, ");
            sql.append("    " + TBTHB2KMEI.SEIGAK + " seikyuu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA6 + " soubyousu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA7 + " byousu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA4 + " gensen, ");
            sql.append("    NULL honsu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA8 + " housou, ");
            sql.append("    0 syouhizeigaku, ");
            sql.append("    " + TBTHB2KMEI.SONOTA1 + " kyusi, ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + " jyunban, ");
            sql.append("    (" + TBTHB2KMEI.SEIGAK + "*(" + TBTHB2KMEI.RITU1 + "*0.01)) syouhi, ");
            sql.append("    (" + TBTHB2KMEI.RITU1 + "*0.01) syouhizeiritu, ");
            sql.append("    (" + TBTHB2KMEI.HNNERT + "*0.01) nebikiritu, ");
            sql.append("    NULL GYOMKBN ");
            sql.append("FROM ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
//			sql.append("    " + TBTHBAMST.TBNAME + " A, ");
//			sql.append("    " + TBTHBAMST.TBNAME + " B, ");
            sql.append("    ( ");
            sql.append("        SELECT");
            sql.append("            TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1 + ",");
            sql.append("            " + TBTHBAMST.FIELD2 + " ");
            sql.append("        FROM");
            sql.append("            " + TBTHBAMST.TBNAME + " ");
            sql.append("        WHERE");
            sql.append("            " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("            " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("            " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("            " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("            " + TBTHBAMST.SYBT + " = '106' ");
            sql.append("    ) A, ");
            sql.append("    ( ");
            sql.append("        SELECT");
            sql.append("            TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1 + ",");
            sql.append("            " + TBTHBAMST.FIELD2 + " ");
            sql.append("        FROM");
            sql.append("            " + TBTHBAMST.TBNAME + " ");
            sql.append("        WHERE");
            sql.append("            " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("            " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("            " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("            " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("            " + TBTHBAMST.SYBT + " = '201' ");
            sql.append("    ) B, ");

            sql.append("    " + TBTHB1DOWN.TBNAME + " ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
//			sql.append("    A." + TBTHBAMST.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
//			sql.append("    A." + TBTHBAMST.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
//			sql.append("    A." + TBTHBAMST.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
//			sql.append("    B." + TBTHBAMST.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
//			sql.append("    B." + TBTHBAMST.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
//			sql.append("    B." + TBTHBAMST.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYM() + "' AND ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " = '008' AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE2 + ") = A." + TBTHBAMST.FIELD1 + "(+) AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = B." + TBTHBAMST.FIELD1 + "(+) AND ");
//			sql.append("    B." + TBTHBAMST.SYBT + " = '201' AND ");
//			sql.append("    A." + TBTHBAMST.SYBT + " = '106' AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + " (+)= " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + " (+)= " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + " (+)= " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " (+)= " + TBTHB2KMEI.EGCD + " AND ");
            sql.append("    " + TBTHB1DOWN.YYMM + " (+)= " + TBTHB2KMEI.YYMM + " AND ");
            sql.append("    " + TBTHB1DOWN.JYUTNO + " (+) = " + TBTHB2KMEI.JYUTNO + " AND ");
            sql.append("    " + TBTHB1DOWN.JYMEINO + " (+) = " + TBTHB2KMEI.JYMEINO + " AND ");
            sql.append("    " + TBTHB1DOWN.URMEINO + " (+) = " + TBTHB2KMEI.URMEINO + " ");
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.SONOTA2 + " ");

        } else if (_cond.getKbn().equals(MEDIA_TYPE_KOUTUU)) {

            // FOG141_KOUTUU
            sql.append("SELECT ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " kadoNo, ");
            sql.append("    " + TBTHB2KMEI.YYMM + " nentuki, ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " dairitencd, ");
            sql.append("    " + TBTHB2KMEI.CODE1 + " baitaicd, ");
            sql.append("    " + TBTHB2KMEI.CODE5 + " bangumi, ");
            sql.append("    " + TBTHB2KMEI.CODE3 + " brandcd, ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " kyokucd, ");
            sql.append("    " + TBTHB2KMEI.SONOTA3 + " netfc, ");
            sql.append("    NULL kyokuNm, ");
            sql.append("    B." + TBTHBAMST.FIELD2 + " brandName, ");
            sql.append("    NULL kyokuNameTR, ");
            sql.append("    NULL NewsName, ");
            sql.append("    " + TBTHB2KMEI.SONOTA2 + " fukencd, ");
            sql.append("    " + TBTHB2KMEI.KNGK1 + " denpa, ");
            sql.append("    " + TBTHB2KMEI.KNGK2 + " neto, ");
            sql.append("    " + TBTHB2KMEI.KNGK3 + " seisaku, ");
            sql.append("    " + TBTHB2KMEI.SEIGAK + " seikyuu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA6 + " soubyousu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA7 + " byousu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA4 + " gensen, ");
            sql.append("    NULL honsu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA8 + " housou, ");
            sql.append("    0 syouhizeigaku, ");
            sql.append("    " + TBTHB2KMEI.SONOTA1 + " kyusi, ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + " jyunban, ");
            sql.append("    (" + TBTHB2KMEI.SEIGAK + "*(" + TBTHB2KMEI.RITU1 + "*0.01)) syouhi, ");
            sql.append("    (" + TBTHB2KMEI.RITU1 + "*0.01) syouhizeiritu, ");
            sql.append("    (" + TBTHB2KMEI.HNNERT + "*0.01) nebikiritu, ");
            sql.append("    NULL GYOMKBN ");
            sql.append("FROM ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    " + TBTHBAMST.TBNAME + " B, ");
            sql.append("    " + TBTHB1DOWN.TBNAME + " ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("    B." + TBTHBAMST.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    B." + TBTHBAMST.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    B." + TBTHBAMST.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYM() + "' AND ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " = '009' AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(B." + TBTHBAMST.FIELD1 + ") AND ");
            sql.append("    B." + TBTHBAMST.SYBT + " = '201' AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(B." + TBTHBAMST.FIELD1 + ") AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " (+)= " + TBTHB2KMEI.EGCD + " AND ");
            sql.append("    " + TBTHB1DOWN.YYMM + " (+)= " + TBTHB2KMEI.YYMM + " AND ");
            sql.append("    " + TBTHB1DOWN.JYUTNO + " (+) = " + TBTHB2KMEI.JYUTNO + " AND ");
            sql.append("    " + TBTHB1DOWN.JYMEINO + " (+) = " + TBTHB2KMEI.JYMEINO + " AND ");
            sql.append("    " + TBTHB1DOWN.URMEINO + " (+) = " + TBTHB2KMEI.URMEINO + " ");
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + ", ");
            sql.append("    " + TBTHB2KMEI.SONOTA2 + " ");

        } else if (_cond.getKbn().equals(MEDIA_TYPE_ATHER)) {

            // FOG141_ATHER
            sql.append("SELECT ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE6 + ") kadoNo, ");
            sql.append("    " + TBTHB2KMEI.YYMM + " nentuki, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE4 + ") dairitencd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE1 + ") baitaicd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE5 + ") bangumi, ");
            sql.append("    " + TBTHB2KMEI.CODE3 + " brandcd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE2 + ") kyokucd, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA3 + ") netfc, ");
            sql.append("    NULL kyokuNm, ");
            sql.append("    MIN(B." + TBTHBAMST.FIELD2 + ") brandName, ");
            sql.append("    NULL kyokuNameTR, ");
            sql.append("    NULL NewsName, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA2 + ") fukencd, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK1 + ") denpa, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK2 + ") neto, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK3 + ") seisaku, ");
            sql.append("    SUM(" + TBTHB2KMEI.SEIGAK + ") seikyuu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA6 + ") soubyousu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA7 + ") byousu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA4 + ") gensen, ");
            sql.append("    NULL honsu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA8 + ") housou, ");
            sql.append("    0 syouhizeigaku, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA1 + ") kyusi, ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + " jyunban, ");
            sql.append("    SUM((" + TBTHB2KMEI.SEIGAK + "*(" + TBTHB2KMEI.RITU1 + "*0.01))) syouhi, ");
            sql.append("    (min(" + TBTHB2KMEI.RITU1 + ")*0.01) syouhizeiritu, ");
            sql.append("    (min(" + TBTHB2KMEI.HNNERT + ")*0.01) nebikiritu, ");
            sql.append("    NULL GYOMKBN ");
            sql.append("FROM ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    " + TBTHBAMST.TBNAME + " B, ");
            sql.append("    " + TBTHB1DOWN.TBNAME + " ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("    B." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    B." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    B." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYM() + "' AND ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " = '010' AND ");
            sql.append("    B." + TBTHBAMST.SYBT + " = '201' AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + " (+)= " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + " (+)= " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + " (+)= " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " (+)= " + TBTHB2KMEI.EGCD + " AND ");
            sql.append("    " + TBTHB1DOWN.YYMM + " (+)= " + TBTHB2KMEI.YYMM + " AND ");
            sql.append("    " + TBTHB1DOWN.JYUTNO + " (+) = " + TBTHB2KMEI.JYUTNO + " AND ");
            sql.append("    " + TBTHB1DOWN.JYMEINO + " (+) = " + TBTHB2KMEI.JYMEINO + " AND ");
            sql.append("    " + TBTHB1DOWN.URMEINO + " (+) = " + TBTHB2KMEI.URMEINO + " AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(B." + TBTHBAMST.FIELD1 + ") ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE6 + ", ");
            sql.append("    " + TBTHB2KMEI.YYMM + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.JYUTNO + ", ");
            sql.append("    " + TBTHB2KMEI.JYMEINO + ", ");
            sql.append("    " + TBTHB2KMEI.URMEINO + " ");
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.YYMM + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + " ");

        } else if (_cond.getKbn().equals(MEDIA_TYPE_Leaflet)) {

            // FOG141_Leaflet
            sql.append("SELECT ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE6 + ") kadoNo, ");
            sql.append("    " + TBTHB2KMEI.YYMM + " nentuki, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE4 + ") dairitencd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE1 + ") baitaicd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE5 + ") bangumi, ");
            sql.append("    " + TBTHB2KMEI.CODE3 + " brandcd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE2 + ") kyokucd, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA3 + ") netfc, ");
            sql.append("    NULL kyokuNm, ");
            sql.append("    MIN(B." + TBTHBAMST.FIELD2 + ") brandName, ");
            sql.append("    NULL kyokuNameTR, ");
            sql.append("    NULL NewsName, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA2 + ") fukencd, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK1 + ") denpa, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK2 + ") neto, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK3 + ") seisaku, ");
            sql.append("    SUM(" + TBTHB2KMEI.SEIGAK + ") seikyuu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA6 + ") soubyousu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA7 + ") byousu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA4 + ") gensen, ");
            sql.append("    NULL honsu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA8 + ") housou, ");
            sql.append("    0 syouhizeigaku, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA1 + ") kyusi, ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + " jyunban, ");
            sql.append("    SUM((" + TBTHB2KMEI.SEIGAK + "*(" + TBTHB2KMEI.RITU1 + "*0.01))) syouhi, ");
            sql.append("    (min(" + TBTHB2KMEI.RITU1 + ")*0.01) syouhizeiritu, ");
            sql.append("    (min(" + TBTHB2KMEI.HNNERT + ")*0.01) nebikiritu, ");
            sql.append("    NULL GYOMKBN ");
            sql.append("FROM ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    " + TBTHBAMST.TBNAME + " B, ");
            sql.append("    " + TBTHB1DOWN.TBNAME + " ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("    B." + TBTHBAMST.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    B." + TBTHBAMST.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    B." + TBTHBAMST.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYM() + "' AND ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " = '014' AND ");
            sql.append("    B." + TBTHBAMST.SYBT + " = '201' AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " (+)= " + TBTHB2KMEI.EGCD + " AND ");
            sql.append("    " + TBTHB1DOWN.YYMM + " (+)= " + TBTHB2KMEI.YYMM + " AND ");
            sql.append("    " + TBTHB1DOWN.JYUTNO + " (+) = " + TBTHB2KMEI.JYUTNO + " AND ");
            sql.append("    " + TBTHB1DOWN.JYMEINO + " (+) = " + TBTHB2KMEI.JYMEINO + " AND ");
            sql.append("    " + TBTHB1DOWN.URMEINO + " (+) = " + TBTHB2KMEI.URMEINO + " AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(B." + TBTHBAMST.FIELD1 + ") ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE6 + ", ");
            sql.append("    " + TBTHB2KMEI.YYMM + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.JYUTNO + ", ");
            sql.append("    " + TBTHB2KMEI.JYMEINO + ", ");
            sql.append("    " + TBTHB2KMEI.URMEINO + " ");
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.YYMM + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + " ");

        } else if (_cond.getKbn().equals(MEDIA_TYPE_Sampling)) {

            // FOG141_Sampling
            sql.append("SELECT ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE6 + ") kadoNo, ");
            sql.append("    " + TBTHB2KMEI.YYMM + " nentuki, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE4 + ") dairitencd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE1 + ") baitaicd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE5 + ") bangumi, ");
            sql.append("    " + TBTHB2KMEI.CODE3 + " brandcd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE2 + ") kyokucd, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA3 + ") netfc, ");
            sql.append("    NULL kyokuNm, ");
            sql.append("    MIN(B." + TBTHBAMST.FIELD2 + ") brandName, ");
            sql.append("    NULL kyokuNameTR, ");
            sql.append("    NULL NewsName, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA2 + ") fukencd, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK1 + ") denpa, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK2 + ") neto, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK3 + ") seisaku, ");
            sql.append("    SUM(" + TBTHB2KMEI.SEIGAK + ") seikyuu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA6 + ") soubyousu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA7 + ") byousu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA4 + ") gensen, ");
            sql.append("    NULL honsu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA8 + ") housou, ");
            sql.append("    0 syouhizeigaku, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA1 + ") kyusi, ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + " jyunban, ");
            sql.append("    SUM((" + TBTHB2KMEI.SEIGAK + "*(" + TBTHB2KMEI.RITU1 + "*0.01))) syouhi, ");
            sql.append("    (min(" + TBTHB2KMEI.RITU1 + ")*0.01) syouhizeiritu, ");
            sql.append("    (min(" + TBTHB2KMEI.HNNERT + ")*0.01) nebikiritu, ");
            sql.append("    NULL GYOMKBN ");
            sql.append("FROM ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    " + TBTHBAMST.TBNAME + " B, ");
            sql.append("    " + TBTHB1DOWN.TBNAME + " ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("    B." + TBTHBAMST.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    B." + TBTHBAMST.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    B." + TBTHBAMST.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYM() + "' AND ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " = '015' AND ");
            sql.append("    B." + TBTHBAMST.SYBT + " = '201' AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " (+)= " + TBTHB2KMEI.EGCD + " AND ");
            sql.append("    " + TBTHB1DOWN.YYMM + " (+)= " + TBTHB2KMEI.YYMM + " AND ");
            sql.append("    " + TBTHB1DOWN.JYUTNO + " (+) = " + TBTHB2KMEI.JYUTNO + " AND ");
            sql.append("    " + TBTHB1DOWN.JYMEINO + " (+) = " + TBTHB2KMEI.JYMEINO + " AND ");
            sql.append("    " + TBTHB1DOWN.URMEINO + " (+) = " + TBTHB2KMEI.URMEINO + " AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(B." + TBTHBAMST.FIELD1 + ") ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE6 + ", ");
            sql.append("    " + TBTHB2KMEI.YYMM + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.JYUTNO + ", ");
            sql.append("    " + TBTHB2KMEI.JYMEINO + ", ");
            sql.append("    " + TBTHB2KMEI.URMEINO + " ");
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.YYMM + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + " ");

        } else if (_cond.getKbn().equals(MEDIA_TYPE_BSCS)) {

            // FOG141_BSCS
            sql.append("SELECT ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " kadoNo, ");
            sql.append("    " + TBTHB2KMEI.YYMM + " nentuki, ");
            sql.append("    " + TBTHB2KMEI.CODE4 + " dairitencd, ");
            sql.append("    " + TBTHB2KMEI.CODE1 + " baitaicd, ");
            sql.append("    " + TBTHB2KMEI.CODE5 + " bangumi, ");
            sql.append("    " + TBTHB2KMEI.CODE3 + " brandcd, ");
            sql.append("    " + TBTHB2KMEI.CODE2 + " kyokucd, ");
            sql.append("    " + TBTHB2KMEI.SONOTA3 + " netfc, ");
            sql.append("    NULL kyokuNm, ");
            sql.append("    NULL brandName, ");
            sql.append("    D." + TBTHB11WLTVK.KYOKUNAME + " kyokuNameTR, ");
            sql.append("    NULL NewsName, ");
            sql.append("    " + TBTHB2KMEI.SONOTA2 + " fukencd, ");
            sql.append("    " + TBTHB2KMEI.KNGK1 + " denpa, ");
            sql.append("    " + TBTHB2KMEI.KNGK2 + " neto, ");
            sql.append("    " + TBTHB2KMEI.KNGK3 + " seisaku, ");
            sql.append("    " + TBTHB2KMEI.SEIGAK + " seikyuu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA6 + " soubyousu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA7 + " byousu, ");
            sql.append("    " + TBTHB2KMEI.SONOTA4 + " gensen, ");
            sql.append("    " + TBTHB2KMEI.SONOTA5 + " honsu, ");
            sql.append("    NULL housou, ");
            sql.append("    0 syouhizeigaku, ");
            sql.append("    NULL kyusi, ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + " jyunban, ");
            sql.append("    (" + TBTHB2KMEI.SEIGAK + "*(" + TBTHB2KMEI.RITU1 + "*0.01)) syouhi, ");
            sql.append("    (" + TBTHB2KMEI.RITU1 + "*0.01) syouhizeiritu, ");
            sql.append("    (" + TBTHB2KMEI.HNNERT + "*0.01) nebikiritu, ");
            sql.append("    NULL GYOMKBN ");
            sql.append("FROM ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    " + TBTHB11WLTVK.TBNAME + " D, ");
            sql.append("    " + TBTHB1DOWN.TBNAME + " ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("    D." + TBTHB11WLTVK.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    D." + TBTHB11WLTVK.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    D." + TBTHB11WLTVK.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYM() + "' AND ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " = '016' AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE2 + ") = TRIM(D." + TBTHB11WLTVK.KYOKUCD + ") AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " (+)= " + TBTHB2KMEI.EGCD + " AND ");
            sql.append("    " + TBTHB1DOWN.YYMM + " (+)= " + TBTHB2KMEI.YYMM + " AND ");
            sql.append("    " + TBTHB1DOWN.JYUTNO + " (+) = " + TBTHB2KMEI.JYUTNO + " AND ");
            sql.append("    " + TBTHB1DOWN.JYMEINO + " (+) = " + TBTHB2KMEI.JYMEINO + " AND ");
            sql.append("    " + TBTHB1DOWN.URMEINO + " (+) = " + TBTHB2KMEI.URMEINO + " ");
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE5 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE2 + ", ");
            sql.append("    " + TBTHB2KMEI.SONOTA2 + " ");

        } else if (_cond.getKbn().equals(MEDIA_TYPE_Internet)) {

            // FOG141_Internet
            sql.append("SELECT ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE6 + ") kadoNo, ");
            sql.append("    " + TBTHB2KMEI.YYMM + " nentuki, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE4 + ") dairitencd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE1 + ") baitaicd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE5 + ") bangumi, ");
            sql.append("    " + TBTHB2KMEI.CODE3 + " brandcd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE2 + ") kyokucd, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA3 + ") netfc, ");
            sql.append("    A." + TBTHBAMST.FIELD2 + " kyokuNm, ");
            sql.append("    MIN(B." + TBTHBAMST.FIELD2 + ") brandName, ");
            sql.append("    NULL kyokuNameTR, ");
            sql.append("    NULL NewsName, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA2 + ") fukencd, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK1 + ") denpa, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK2 + ") neto, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK3 + ") seisaku, ");
            sql.append("    SUM(" + TBTHB2KMEI.SEIGAK + ") seikyuu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA6 + ") soubyousu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA7 + ") byousu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA4 + ") gensen, ");
            sql.append("    NULL honsu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA8 + ") housou, ");
            sql.append("    0 syouhizeigaku, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA1 + ") kyusi, ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + " jyunban, ");
            sql.append("    SUM((" + TBTHB2KMEI.SEIGAK + "*(" + TBTHB2KMEI.RITU1 + "*0.01))) syouhi, ");
            sql.append("    (min(" + TBTHB2KMEI.RITU1 + ")*0.01) syouhizeiritu, ");
            sql.append("    (min(" + TBTHB2KMEI.HNNERT + ")*0.01) nebikiritu, ");
            sql.append("    NULL GYOMKBN ");
            sql.append("FROM ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    " + TBTHBAMST.TBNAME + " B, ");
            sql.append("    " + TBTHB1DOWN.TBNAME + ", ");
            sql.append("    " + TBTHBAMST.TBNAME + " A ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("    B." + TBTHBAMST.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    B." + TBTHBAMST.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    B." + TBTHBAMST.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYM() + "' AND ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " = '017' AND ");
            sql.append("    B." + TBTHBAMST.SYBT + " = '201' AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    A." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    A." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    A." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    A." + TBTHBAMST.SYBT + "(+) = '114' AND ");
            sql.append("    TRIM(A." + TBTHBAMST.FIELD1 + "(+)) = TRIM(" + TBTHB2KMEI.CODE2 + ") AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " (+)= " + TBTHB2KMEI.EGCD + " AND ");
            sql.append("    " + TBTHB1DOWN.YYMM + " (+)= " + TBTHB2KMEI.YYMM + " AND ");
            sql.append("    " + TBTHB1DOWN.JYUTNO + " (+) = " + TBTHB2KMEI.JYUTNO + " AND ");
            sql.append("    " + TBTHB1DOWN.JYMEINO + " (+) = " + TBTHB2KMEI.JYMEINO + " AND ");
            sql.append("    " + TBTHB1DOWN.URMEINO + " (+) = " + TBTHB2KMEI.URMEINO + " AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(B." + TBTHBAMST.FIELD1 + ") ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE6 + ", ");
            sql.append("    " + TBTHB2KMEI.YYMM + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.JYUTNO + ", ");
            sql.append("    " + TBTHB2KMEI.JYMEINO + ", ");
            sql.append("    " + TBTHB2KMEI.URMEINO + ", ");
            sql.append("    A." + TBTHBAMST.FIELD2 + " ");
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.YYMM + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + " ");

        } else if (_cond.getKbn().equals(MEDIA_TYPE_Mobile)) {

            // FOG141_Mobile
            sql.append("SELECT ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE6 + ") kadoNo, ");
            sql.append("    " + TBTHB2KMEI.YYMM + " nentuki, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE4 + ") dairitencd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE1 + ") baitaicd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE5 + ") bangumi, ");
            sql.append("    " + TBTHB2KMEI.CODE3 + " brandcd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE2 + ") kyokucd, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA3 + ") netfc, ");
            sql.append("    A." + TBTHBAMST.FIELD2 + " kyokuNm, ");
            sql.append("    MIN(B." + TBTHBAMST.FIELD2 + ") brandName, ");
            sql.append("    NULL kyokuNameTR, ");
            sql.append("    NULL NewsName, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA2 + ") fukencd, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK1 + ") denpa, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK2 + ") neto, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK3 + ") seisaku, ");
            sql.append("    SUM(" + TBTHB2KMEI.SEIGAK + ") seikyuu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA6 + ") soubyousu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA7 + ") byousu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA4 + ") gensen, ");
            sql.append("    NULL honsu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA8 + ") housou, ");
            sql.append("    0 syouhizeigaku, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA1 + ") kyusi, ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + " jyunban, ");
            sql.append("    SUM((" + TBTHB2KMEI.SEIGAK + "*(" + TBTHB2KMEI.RITU1 + "*0.01))) syouhi, ");
            sql.append("    (min(" + TBTHB2KMEI.RITU1 + ")*0.01) syouhizeiritu, ");
            sql.append("    (min(" + TBTHB2KMEI.HNNERT + ")*0.01) nebikiritu, ");
            sql.append("    NULL GYOMKBN ");
            sql.append("FROM ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    " + TBTHBAMST.TBNAME + " B, ");
            sql.append("    " + TBTHB1DOWN.TBNAME + ", ");
            sql.append("    " + TBTHBAMST.TBNAME + " A ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("    B." + TBTHBAMST.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    B." + TBTHBAMST.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    B." + TBTHBAMST.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYM() + "' AND ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " = '018' AND ");
            sql.append("    B." + TBTHBAMST.SYBT + " = '201' AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    A." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    A." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    A." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    A." + TBTHBAMST.SYBT + "(+) = '115' AND ");
            sql.append("    TRIM(A." + TBTHBAMST.FIELD1 + "(+)) = TRIM(" + TBTHB2KMEI.CODE2 + ") AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + " (+)= " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + " (+)= " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + " (+)= " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " (+)= " + TBTHB2KMEI.EGCD + " AND ");
            sql.append("    " + TBTHB1DOWN.YYMM + " (+)= " + TBTHB2KMEI.YYMM + " AND ");
            sql.append("    " + TBTHB1DOWN.JYUTNO + " (+) = " + TBTHB2KMEI.JYUTNO + " AND ");
            sql.append("    " + TBTHB1DOWN.JYMEINO + " (+) = " + TBTHB2KMEI.JYMEINO + " AND ");
            sql.append("    " + TBTHB1DOWN.URMEINO + " (+) = " + TBTHB2KMEI.URMEINO + " AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(B." + TBTHBAMST.FIELD1 + ") ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE6 + ", ");
            sql.append("    " + TBTHB2KMEI.YYMM + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.JYUTNO + ", ");
            sql.append("    " + TBTHB2KMEI.JYMEINO + ", ");
            sql.append("    " + TBTHB2KMEI.URMEINO + ", ");
            sql.append("    A." + TBTHBAMST.FIELD2 + " ");
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.YYMM + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + " ");

        } else if (_cond.getKbn().equals(MEDIA_TYPE_BusinessExp)) {

            // FOG141_BusinessExp
            sql.append("SELECT ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE6 + ") kadoNo, ");
            sql.append("    " + TBTHB2KMEI.YYMM + " nentuki, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE4 + ") dairitencd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE1 + ") baitaicd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE5 + ") bangumi, ");
            sql.append("    " + TBTHB2KMEI.CODE3 + " brandcd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE2 + ") kyokucd, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA3 + ") netfc, ");
            sql.append("    NULL kyokuNm, ");
            sql.append("    MIN(B." + TBTHBAMST.FIELD2 + ") brandName, ");
            sql.append("    NULL kyokuNameTR, ");
            sql.append("    NULL NewsName, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA2 + ") fukencd, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK1 + ") denpa, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK2 + ") neto, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK3 + ") seisaku, ");
            sql.append("    SUM(" + TBTHB2KMEI.SEIGAK + ") seikyuu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA6 + ") soubyousu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA7 + ") byousu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA4 + ") gensen, ");
            sql.append("    NULL honsu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA8 + ") housou, ");
            sql.append("    0 syouhizeigaku, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA1 + ") kyusi, ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + " jyunban, ");
            sql.append("    SUM((" + TBTHB2KMEI.SEIGAK + "*(" + TBTHB2KMEI.RITU1 + "*0.01))) syouhi, ");
            sql.append("    (min(" + TBTHB2KMEI.RITU1 + ")*0.01) syouhizeiritu, ");
            sql.append("    (min(" + TBTHB2KMEI.HNNERT + ")*0.01) nebikiritu, ");
            sql.append("    NULL GYOMKBN ");
            sql.append("FROM ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    " + TBTHBAMST.TBNAME + " B, ");
            sql.append("    " + TBTHB1DOWN.TBNAME + " ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("    B." + TBTHBAMST.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    B." + TBTHBAMST.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    B." + TBTHBAMST.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYM() + "' AND ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " = '019' AND ");
            sql.append("    B." + TBTHBAMST.SYBT + " = '201' AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + " (+) = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + " (+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + " (+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " (+)= " + TBTHB2KMEI.EGCD + " AND ");
            sql.append("    " + TBTHB1DOWN.YYMM + " (+)= " + TBTHB2KMEI.YYMM + " AND ");
            sql.append("    " + TBTHB1DOWN.JYUTNO + " (+) = " + TBTHB2KMEI.JYUTNO + " AND ");
            sql.append("    " + TBTHB1DOWN.JYMEINO + " (+) = " + TBTHB2KMEI.JYMEINO + " AND ");
            sql.append("    " + TBTHB1DOWN.URMEINO + " (+) = " + TBTHB2KMEI.URMEINO + " AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(B." + TBTHBAMST.FIELD1 + ") ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE6 + ", ");
            sql.append("    " + TBTHB2KMEI.YYMM + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.JYUTNO + ", ");
            sql.append("    " + TBTHB2KMEI.JYMEINO + ", ");
            sql.append("    " + TBTHB2KMEI.URMEINO + " ");
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.YYMM + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + " ");

        } else if (_cond.getKbn().equals(MEDIA_TYPE_Syouhi)) {

            // FOG141_Syouhi
            sql.append("SELECT ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " kadoNo, ");
            sql.append("    NULL nentuki, ");
            sql.append("    NULL dairitencd, ");
            sql.append("    NULL baitaicd, ");
            sql.append("    NULL bangumi, ");
            sql.append("    NULL brandcd, ");
            sql.append("    NULL kyokucd, ");
            sql.append("    NULL netfc, ");
            sql.append("    NULL kyokuNm, ");
            sql.append("    NULL brandName, ");
            sql.append("    NULL kyokuNameTR, ");
            sql.append("    NULL NewsName, ");
            sql.append("    NULL fukencd, ");
            sql.append("    0 denpa, ");
            sql.append("    0 neto, ");
            sql.append("    0 seisaku, ");
            sql.append("    sum(" + TBTHB2KMEI.SEIGAK + ") seikyuu, ");
            sql.append("    NULL soubyousu, ");
            sql.append("    NULL byousu, ");
            sql.append("    NULL gensen, ");
            sql.append("    NULL honsu, ");
            sql.append("    NULL housou, ");
            sql.append("    0 syouhizeigaku, ");
            sql.append("    NULL kyusi, ");
            sql.append("    NULL jyunban, ");
            sql.append("    sum(" + TBTHB2KMEI.NAME1 + ") syouhi, ");
            //消費税対応 2013/10/02 update HLC H.Watabe start
            //sql.append("    0 syouhizeiritu, ");
            sql.append("    (" + TBTHB2KMEI.RITU1 + "*0.01) syouhizeiritu, ");
            //消費税対応 2013/10/02 update HLC H.Watabe end
            sql.append("    0 nebikiritu, ");
            sql.append("    NULL GYOMKBN ");
            sql.append("FROM ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    " + TBTHB1DOWN.TBNAME + " ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYM() + "' AND ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " In ('001','002','003','004','005','007','008','009','010','014','015','016','017','018','019') AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " (+)= " + TBTHB2KMEI.EGCD + " AND ");
            sql.append("    " + TBTHB1DOWN.YYMM + " (+)= " + TBTHB2KMEI.YYMM + " AND ");
            sql.append("    " + TBTHB1DOWN.JYUTNO + " (+) = " + TBTHB2KMEI.JYUTNO + " AND ");
            sql.append("    " + TBTHB1DOWN.JYMEINO + " (+) = " + TBTHB2KMEI.JYMEINO + " AND ");
            sql.append("    " + TBTHB1DOWN.URMEINO + " (+) = " + TBTHB2KMEI.URMEINO + " ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE6 + ", ");
            //消費税対応 2013/10/02 update HLC H.Watabe start
            //sql.append("    " + TBTHB2KMEI.CODE1 + " ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    (" + TBTHB2KMEI.RITU1 + "*0.01)");
            //消費税対応 2013/10/02 update HLC H.Watabe end
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " ");

        } else if (_cond.getKbn().equals(MEDIA_TYPE_SEISAKU)) {

            // FOG141_SEISAKU
            sql.append("SELECT ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE6 + ") kadoNo, ");
            sql.append("    " + TBTHB2KMEI.YYMM + " nentuki, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE4 + ") dairitencd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE1 + ") baitaicd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE5 + ") bangumi, ");
            sql.append("    " + TBTHB2KMEI.CODE3 + " brandcd, ");
            sql.append("    MIN(" + TBTHB2KMEI.CODE2 + ") kyokucd, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA3 + ") netfc, ");
            sql.append("    NULL kyokuNm, " );
            sql.append("    min(B." + TBTHBAMST.FIELD2 + ") brandName, ");
            sql.append("    NULL kyokuNameTR, " );
            sql.append("    NULL NewsName, " );
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA2 + ") fukencd, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK1 + ") denpa, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK2 + ") neto, ");
            sql.append("    SUM(" + TBTHB2KMEI.KNGK3 + ") seisaku, ");
            sql.append("    SUM(" + TBTHB2KMEI.SEIGAK + ") seikyuu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA6 + ") soubyousu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA7 + ") byousu, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA4 + ") gensen, ");
            sql.append("    NULL honsu, " );
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA8 + ") housou, ");
            sql.append("    sum(" + TBTHB2KMEI.NAME1 + ") syouhizeigaku, ");
            sql.append("    MIN(" + TBTHB2KMEI.SONOTA1 + ") kyusi, ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + " jyunban, ");
            sql.append("    0 syouhi, " );
            sql.append("    (min(" + TBTHB2KMEI.RITU1 + ")*0.01) syouhizeiritu, ");
            sql.append("    (min(" + TBTHB2KMEI.HNNERT + ")*0.01) nebikiritu, ");
            sql.append("    NULL GYOMKBN " );
            sql.append("FROM ");
            sql.append("    " + TBTHB2KMEI.TBNAME + ", ");
            sql.append("    " + TBTHBAMST.TBNAME + " B, ");
            sql.append("    " + TBTHB1DOWN.TBNAME + " ");
            sql.append("WHERE ");
            sql.append("    " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd() + "' AND ");
            sql.append("    " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTntcd() + "' AND ");
            sql.append("    B." + TBTHBAMST.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    B." + TBTHBAMST.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    B." + TBTHBAMST.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB2KMEI.YYMM + " = '" + _cond.getYM() + "'  AND ");
            sql.append("    " + TBTHB2KMEI.CODE6 + " = '012'  AND ");
            sql.append("    B." + TBTHBAMST.SYBT + " = '201'  AND ");
            sql.append("    " + TBTHB1DOWN.TJYUTNO + " = ' '  AND ");
            sql.append("    " + TBTHB1DOWN.TKSKGYCD + " (+)= " + TBTHB2KMEI.TKSKGYCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSBMNSEQNO + " (+)= " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.EGCD + " (+)= " + TBTHB2KMEI.EGCD + " AND ");
            sql.append("    " + TBTHB1DOWN.TKSTNTSEQNO + " (+)= " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append("    " + TBTHB1DOWN.YYMM + " (+)= " + TBTHB2KMEI.YYMM + "  AND ");
            sql.append("    " + TBTHB1DOWN.JYUTNO + " (+) = " + TBTHB2KMEI.JYUTNO + "  AND ");
            sql.append("    " + TBTHB1DOWN.JYMEINO + " (+) = " + TBTHB2KMEI.JYMEINO + "  AND ");
            sql.append("    " + TBTHB1DOWN.URMEINO + " (+) = " + TBTHB2KMEI.URMEINO + "  AND ");
            sql.append("    TRIM(" + TBTHB2KMEI.CODE3 + ") = TRIM(B." + TBTHBAMST.FIELD1 + ") ");
            sql.append("GROUP BY ");
            sql.append("    " + TBTHB2KMEI.CODE6 + ", ");
            sql.append("    " + TBTHB2KMEI.YYMM + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + ", ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.JYUTNO + ", ");
            sql.append("    " + TBTHB2KMEI.JYMEINO + ", ");
            sql.append("    " + TBTHB2KMEI.URMEINO + " ");
            sql.append("ORDER BY ");
            sql.append("    " + TBTHB2KMEI.SONOTA9 + ", ");
            sql.append("    " + TBTHB2KMEI.YYMM + ", ");
            sql.append("    " + TBTHB2KMEI.CODE3 + ", ");
            sql.append("    " + TBTHB2KMEI.CODE1 + " ");
        }

        return sql.toString();
    }

    /**
     * ライオンFD出力データの検索を行います。
     *
     * @return ライオンFD出力データ取得VOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<FDLionVO> findFDLionByCondition(FDLionCondition cond) throws KKHException {

        super.setModel(new FDLionVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * Modelの生成を行う<br>
     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
     *
     * @param hashList
     *            List 検索結果
     * @return List<CommonCodeMasterVO> 変換後の検索結果
     */
    @Override
    protected List<FDLionVO> createFindedModelInstances(List hashList) {
        List<FDLionVO> list = new ArrayList<FDLionVO>();
        if (getModel() instanceof FDLionVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FDLionVO vo = new FDLionVO();

                vo.setKadoNo((String) result.get(FDLionVO.kadoNo.toUpperCase()));
                vo.setNentuki((String) result.get(FDLionVO.nentuki.toUpperCase()));
                vo.setDairitencd((String) result.get(FDLionVO.dairitencd.toUpperCase()));
                vo.setBaitaicd((String) result.get(FDLionVO.baitaicd.toUpperCase()));
                vo.setBangumi((String) result.get(FDLionVO.bangumi.toUpperCase()));
                vo.setBrandcd((String) result.get(FDLionVO.brandcd.toUpperCase()));
                vo.setKyokucd((String) result.get(FDLionVO.kyokucd.toUpperCase()));
                vo.setNetfc((String) result.get(FDLionVO.netfc.toUpperCase()));
                vo.setKyokuNm((String) result.get(FDLionVO.kyokuNm.toUpperCase()));
                vo.setBrandName((String) result.get(FDLionVO.brandName.toUpperCase()));
                vo.setKyokuNameTR((String) result.get(FDLionVO.kyokuNameTR.toUpperCase()));
                vo.setNewsName((String) result.get(FDLionVO.NewsName.toUpperCase()));
                vo.setFukencd((String) result.get(FDLionVO.fukencd.toUpperCase()));
                vo.setDenpa((BigDecimal) result.get(FDLionVO.denpa.toUpperCase()));
                vo.setNeto((BigDecimal) result.get(FDLionVO.neto.toUpperCase()));
                vo.setSeisaku((BigDecimal) result.get(FDLionVO.seisaku.toUpperCase()));
                vo.setSeikyuu((BigDecimal) result.get(FDLionVO.seikyuu.toUpperCase()));
                vo.setSoubyousu((String) result.get(FDLionVO.soubyousu.toUpperCase()));
                vo.setByousu((String) result.get(FDLionVO.byousu.toUpperCase()));
                vo.setGensen((String) result.get(FDLionVO.gensen.toUpperCase()));
                vo.setHonsu((String) result.get(FDLionVO.honsu.toUpperCase()));
                vo.setHousou((String) result.get(FDLionVO.housou.toUpperCase()));
                vo.setSyouhizeigaku((BigDecimal) result.get(FDLionVO.syouhizeigaku.toUpperCase()));
                vo.setKyusi((String) result.get(FDLionVO.kyusi.toUpperCase()));
                vo.setJyunban((String) result.get(FDLionVO.jyunban.toUpperCase()));
                vo.setSyouhi((BigDecimal) result.get(FDLionVO.syouhi.toUpperCase()));
                vo.setSyouhizeiritu((BigDecimal) result.get(FDLionVO.syouhizeiritu.toUpperCase()));
                vo.setNebikiritu((BigDecimal) result.get(FDLionVO.nebikiritu.toUpperCase()));
                vo.setGYOMKBN((String) result.get(FDLionVO.GYOMKBN.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
