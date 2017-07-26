package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB10WLRDB;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB9WLTVB;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
//import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionSonotaDAO.SqlMode;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ライオン帳票(見積書)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/03/5 fourm H.izawa)<BR>
 * ・消費税端数調整対応(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author fourm H.izawa
 */

public class NewReportLionDAO extends AbstractRdbDao {

    /** 汎用マスタ検索条件 */
    private NewReportLionCondition _cond;

    //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod Start
    //ソーシャルメディアとデジタル動画を追加
    private enum SqlMode {SHINBUN,ZASHI,KOUTSU,JIGYOUHI,MOBILE,INTERNET,TIRASHI,SONOTA,
        SAMPLING,BSCS,TVSPOT,TVTIME,RADIOTIME,RADIOSPOT,SOCIALMEDIA,DIGITALMOVIE,ALLBAITAI };
    /* private enum SqlMode {SHINBUN,ZASHI,KOUTSU,JIGYOUHI,MOBILE,INTERNET,
                            TIRASHI,SONOTA,SAMPLING,BSCS,TVSPOT,TVTIME,RADIOTIME,RADIOSPOT,ALLBAITAI };*/
    //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod End
    private SqlMode _sqlMode = SqlMode.SHINBUN;

    private enum BaitaiCode {
    	//2017/06/05 ライオン対応 ITCOM A.Nakamura Mod Start
    	//ソーシャルメディアとデジタル動画を追加
    	SHINBUN("130"),ZASHI("140"),KOUTSU("150"),JIGYOUHI("250"),MOBILE("260"),INTERNET("116"),
    	TIRASHI("280"),SONOTA("190"),SAMPLING("290"),BSCS("300"),TVSPOT("110"),TVTIME("100"),
        RADIOTIME("120"),RADIOSPOT("125"),SOCIALMEDIA("117"),DIGITALMOVIE("118"),ALLBAITAI("900");
//        SHINBUN("130"),ZASHI("140"),KOUTSU("150"),JIGYOUHI("250"),MOBILE("260"),INTERNET("116"),
//        TIRASHI("280"),SONOTA("190"),SAMPLING("290"),BSCS("300"),TVSPOT("110"),TVTIME("100"),
//        RADIOTIME("120"),RADIOSPOT("125"),ALLBAITAI("900");
    	//2017/06/05 ライオン対応 ITCOM A.Nakamura Mod End

        private final String _code;

        private BaitaiCode(String code) {
            _code = code;
        }

        // コード取得
        public String getCode() {
            return _code;
        }
    }

    /**
     * インラインビュー
     */
    private static final String TBTB1 = "TB1";
    private static final String TBMST = "MST";

    /**
     * デフォルトコンストラクタ。
     */
    public NewReportLionDAO() {
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
        // new String[] {};
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
        return null;
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {

        //表紙
        if(_cond.getBaitaiCd().equals(BaitaiCode.ALLBAITAI.getCode()))
        {
            _sqlMode = SqlMode.ALLBAITAI;
            return getSelectSQLForAllBaitai();
        }
        //新聞
        if(_cond.getBaitaiCd().equals(BaitaiCode.SHINBUN.getCode()))
        {
            _sqlMode = SqlMode.SHINBUN;
            return  getSelectSQLForShinbun();
        }
        //雑誌
        else if(_cond.getBaitaiCd().equals(BaitaiCode.ZASHI.getCode()))
        {
            _sqlMode = SqlMode.ZASHI;
            return  getSelectSQLForZashi();
        }
        //交通
        else if(_cond.getBaitaiCd().equals(BaitaiCode.KOUTSU.getCode()))
        {
            _sqlMode = SqlMode.KOUTSU;
            return  getSelectSQLForKoutsu();
        }
        //事業費
        else if(_cond.getBaitaiCd().equals(BaitaiCode.JIGYOUHI.getCode()))
        {
            _sqlMode = SqlMode.JIGYOUHI;
            return  getSelectSQLForJigyouhi();
        }
        //モバイル
        else if(_cond.getBaitaiCd().equals(BaitaiCode.MOBILE.getCode()))
        {
            _sqlMode = SqlMode.MOBILE;
            return  getSelectSQLForMobile();
        }
        //インターネット
        else if(_cond.getBaitaiCd().equals(BaitaiCode.INTERNET.getCode()))
        {
            _sqlMode = SqlMode.INTERNET;
            return  getSelectSQLForInterNet();
        }
        //チラシ
        else if(_cond.getBaitaiCd().equals(BaitaiCode.TIRASHI.getCode()))
        {
            _sqlMode = SqlMode.TIRASHI;
            return  getSelectSQLForTirashi();
        }
        //その他
        else if(_cond.getBaitaiCd().equals(BaitaiCode.SONOTA.getCode()))
        {
            _sqlMode = SqlMode.SONOTA;
            return  getSelectSQLForSonota();
        }
        //サンプリング
        else if(_cond.getBaitaiCd().equals(BaitaiCode.SAMPLING.getCode()))
        {
            _sqlMode = SqlMode.SAMPLING;
            return  getSelectSQLForSampling();
        }
        //BSCS
        else if(_cond.getBaitaiCd().equals(BaitaiCode.BSCS.getCode()))
        {
            _sqlMode = SqlMode.BSCS;
            return  getSelectSQLForBsCs();
        }
        //テレビスポット
        else if(_cond.getBaitaiCd().equals(BaitaiCode.TVSPOT.getCode()))
        {
            _sqlMode = SqlMode.TVSPOT;
            return  getSelectSQLForTvSpot();
        }
        //テレビタイム
        else if(_cond.getBaitaiCd().equals(BaitaiCode.TVTIME.getCode()))
        {
            _sqlMode = SqlMode.TVTIME;
            return getSelectSQLForTvTime();
        }
        //ラジオタイム
        else if(_cond.getBaitaiCd().equals(BaitaiCode.RADIOTIME.getCode()))
        {
            _sqlMode = SqlMode.RADIOTIME;
            return  getSelectSQLForRadioTime();
        }
        //ラジオスポット
        else if(_cond.getBaitaiCd().equals(BaitaiCode.RADIOSPOT.getCode()))
        {
            _sqlMode = SqlMode.RADIOSPOT;
            return  getSelectSQLForRadioSpot();
        }
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Add Start
        //ソーシャルメディアとデジタル動画を追加
        //ソーシャルメディア
        else if(_cond.getBaitaiCd().equals(BaitaiCode.SOCIALMEDIA.getCode()))
        {
            _sqlMode = SqlMode.SOCIALMEDIA;
            return  getSelectSQLForSocialMedia();
        }
        //デジタル動画
        else if(_cond.getBaitaiCd().equals(BaitaiCode.DIGITALMOVIE.getCode()))
        {
            _sqlMode = SqlMode.DIGITALMOVIE;
            return  getSelectSQLForDigitalMovie();
        }
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Add End
        return null;
    }

    //*********************
    //表紙検索
    //*********************
    private String getSelectSQLForAllBaitai() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        sql.append(" " + TBTHB2KMEI.CODE6 + " " + NewReportLionVO.BAITAICD+ ",");                                                       //媒体コード
        sql.append("  " + TBTHB2KMEI.CODE1 + " " + NewReportLionVO.BAITAIKOCD+ ",");                                                    //媒体子コード
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + "," );                                        //消費税率
        sql.append("  SUM(" + TBTHB2KMEI.SEIGAK + ") " + NewReportLionVO.SUMSEIGAK+ ",");                                               //請求金額合計
        sql.append("  SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ "))) " + NewReportLionVO.SUMSZEIGAK);   //消費税額合計
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
        sql.append(" GROUP BY");
        sql.append(" " + TBTHB2KMEI.CODE6 + ",");
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01),");
        sql.append(" " + TBTHB2KMEI.CODE1);
        sql.append(" ORDER BY");
        sql.append(" " + TBTHB2KMEI.CODE6);

        return sql.toString();
    }

    //*********************
    //新聞検索
    //*********************
    private String getSelectSQLForShinbun() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append("  " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ", ");//商品名
        sql.append("  mast1." + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SHIMEI + " , "); //紙名
        sql.append("  " + TBTHB2KMEI.CODE2 + " " + NewReportLionVO.KYOKUCD + " , "); //局誌コード
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN + " " );
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" ELSE '' ");
        sql.append(" END " + NewReportLionVO.SYURUI + ", "); //掲載
        sql.append("  " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ", ");//見積もり料金
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU ," ); //消費税率
        sql.append("  DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ ")) " + NewReportLionVO.SZEIGAK+ ", ");//消費税額
        sql.append("  " + TBTHB2KMEI.NAME4 +  " "+ NewReportLionVO.TEIKARYOKIN + ", ");//定価料金
        //sql.append("  " + TBTHB1DOWN.FIELD11 +  " "+ NewReportLionVO.SPACE + ", ");//スペース
        //sql.append("  " + TBTHB2KMEI.NAME7 +  " "+ NewReportLionVO.KIKAN + ", ");//掲載期間
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN + " " );
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD11 + " ");
        sql.append(" ELSE '' ");
        sql.append(" END " + NewReportLionVO.SPACE + ", ");//スペース
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN + " " );
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12 + " ");
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10 + " ");
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6 + " ");
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3 + " ");
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" ELSE '' ");
        sql.append(" END " + NewReportLionVO.KIKAN + ", ");//掲載期間
        sql.append("  mast2." + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + " , "); //請求ブランド
        sql.append("  " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ " ");//コード（ブランド）
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast1 ,  ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast2   ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('007') AND ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND ");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = mast1." + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast1." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast1." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast1." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = mast2." + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast2." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast2." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast2." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" mast1." + TBTHBAMST.SYBT + " = '105' AND ");
        sql.append(" mast2." + TBTHBAMST.SYBT + " = '201' AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ") = mast1." + TBTHBAMST.FIELD1 + " AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = mast2." + TBTHBAMST.FIELD1 + "  ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB1DOWN.JYUTNO + ", ");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ", ");
        sql.append("  " + TBTHB1DOWN.URMEINO + " ");

        return sql.toString();
    }

    //*********************
    //雑誌検索
    //*********************
    private String getSelectSQLForZashi() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append("  " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ", ");//商品名
        sql.append("  mast1." + TBTHBAMST.FIELD2 + " " + NewReportLionVO.ZASHIMEI + " , "); //雑誌名
        sql.append("  " + TBTHB2KMEI.CODE2 + " " + NewReportLionVO.ZASHICD + ", ");//雑誌コード
        sql.append("  " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ", ");//見積もり料金
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU ," ); //消費税率
        sql.append("  DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ ")) " + NewReportLionVO.SZEIGAK+ ", ");//消費税額
        sql.append("  " + TBTHB2KMEI.NAME4 +  " "+ NewReportLionVO.TEIKARYOKIN + ", ");//定価料金
        sql.append("  " + TBTHB2KMEI.NAME2 +  " "+ NewReportLionVO.SPACE + ", ");//スペース
        //sql.append("  " + TBTHB2KMEI.NAME7 +  " "+ NewReportLionVO.KIKAN + ", ");//掲載期間
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN + " " );
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12 + " ");
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10 + " ");
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6 + " ");
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3 + " ");
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" ELSE '' ");
        sql.append(" END " + NewReportLionVO.KIKAN + ", ");//掲載期間
        sql.append("  mast2." + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + " , "); //請求ブランド
        sql.append("  " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ " ");//コード（ブランド）
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast1 ,  ");
        sql.append("  " + TBTHBAMST.TBNAME + " mast2   ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('008') AND ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND ");
        sql.append(" mast1." + TBTHBAMST.SYBT + " = '106' AND ");
        sql.append(" mast2." + TBTHBAMST.SYBT + " = '201' AND ");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = mast1." + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast1." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast1." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast1." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = mast2." + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = mast2." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = mast2." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = mast2." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ") = mast1." + TBTHBAMST.FIELD1 + " AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = mast2." + TBTHBAMST.FIELD1 + "  ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB1DOWN.JYUTNO + ", ");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ", ");
        sql.append("  " + TBTHB1DOWN.URMEINO + " ");

        return sql.toString();
    }

    //*********************
    //交通検索
    //*********************
    private String getSelectSQLForKoutsu() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");                                                  //商品名
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");                                              //見積料金
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + "," );                                    //消費税率
        sql.append(" DECODE(TRIM(" + TBTHB2KMEI.NAME1 + "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ ")) " + NewReportLionVO.SZEIGAK+ ",");  //消費税額
        //sql.append("  " + TBTHB2KMEI.NAME4 +  " "+ NewReportLionVO.TEIKARYOKIN + ", ");//定価料金
        //sql.append("  " + TBTHB2KMEI.NAME7 +  " "+ NewReportLionVO.KIKAN + ", ");//掲載期間
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE ''");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                                                          //掲載期間
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");                                               //請求ブランド
        sql.append(" " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE);                                                            //コード（ブランド）
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '009' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        sql.append(" " + TBTHB1DOWN.JYUTNO + ",");
        sql.append(" " + TBTHB1DOWN.JYMEINO + ",");
        sql.append(" " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }

    //*********************
    //事業費検索
    //*********************
    private String getSelectSQLForJigyouhi() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append("  " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ", ");//商品名
        sql.append("  MST2." + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SYURUI + " , "); //種類
        sql.append("  " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ", ");//見積もり料金
        sql.append("  " + TBTHB2KMEI.NAME4 +  " "+ NewReportLionVO.TEIKARYOKIN + ", ");//定価料金
        //sql.append("  " + TBTHB2KMEI.NAME7 +  " "+ NewReportLionVO.KIKAN + ", ");//掲載期間
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN + " " );
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12 + " ");
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10 + " ");
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6 + " ");
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3 + " ");
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" ELSE '' ");
        sql.append(" END " + NewReportLionVO.KIKAN + ", ");//掲載期間
        sql.append("  MST1." + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + " , "); //請求ブランド
        sql.append("  " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ ", ");//コード（ブランド）
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU ," ); //消費税率
        sql.append("  " + TBTHB2KMEI.NAME1 +  " "+ NewReportLionVO.SZEIGAK + " ");//消費税額
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        sql.append("  " + TBTHBAMST.TBNAME + " MST1,  ");
        sql.append("  " + TBTHBAMST.TBNAME + " MST2  ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('019') AND ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND ");
        sql.append(" MST1." + TBTHBAMST.SYBT + " = '201' AND ");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = MST1." + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = MST1." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = MST1." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = MST1." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = MST1." + TBTHBAMST.FIELD1 + " AND  ");
        sql.append(" MST2." + TBTHBAMST.SYBT + " = '104' AND ");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = MST2." + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = MST2." + TBTHBAMST.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = MST2." + TBTHBAMST.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = MST2." + TBTHBAMST.TKSTNTSEQNO + " AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE1 + ") = MST2." + TBTHBAMST.FIELD1 + "  ");
        sql.append(" ORDER BY ");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(NewReportLionVO.CODE + ",");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append("  " + TBTHB1DOWN.JYUTNO + ", ");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ", ");
        sql.append("  " + TBTHB1DOWN.URMEINO + " ");

        return sql.toString();
    }

    //*********************
    //モバイル検索
    //*********************
    private String getSelectSQLForMobile() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");                                                  //商品名
        sql.append(" " + TBTHB1DOWN.HIMKNMKJ + " " + NewReportLionVO.HIMOKUMEI+ ",");                                               //費目名
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");                                              //見積料金、定価料金
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + ",");                                     //消費税率
        sql.append(" DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ ")) " + NewReportLionVO.SZEIGAK+ ",");   //消費税額
        //sql.append("  " + TBTHB1DOWN.FIELD10 + " " + NewReportLionVO.KIKAN+ ", ");//期間
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE ''");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                                                          //期間
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");                                               //請求ブランド
        sql.append(" " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE);                                                            //コード（ブランド）
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '018' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        sql.append("  " + TBTHB1DOWN.JYUTNO + ",");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ",");
        sql.append("  " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }

    //*********************
    //インターネット検索
    //*********************
    private String getSelectSQLForInterNet() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");              //商品名
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");          //見積料金
        //sql.append("  " + TBTHB1DOWN.FIELD3 +  " "+ NewReportLionVO.KIKAN + ", ");//期間
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE ''");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                      //期間
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");           //請求ブランド
        sql.append(" " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ ",");                   //コード（ブランド）
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + ","); //消費税率
        sql.append("  " + TBTHB2KMEI.NAME1 +  " "+ NewReportLionVO.SZEIGAK);                    //消費税額
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME + ",");
        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
        sql.append("  " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '017' AND");
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Add Start
        //媒体区分を追加
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '17' AND");
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Add End
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + NewReportLionVO.CODE + ",");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append("  " + TBTHB1DOWN.JYUTNO + ",");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ",");
        sql.append("  " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }
    //2017/06/05 ライオン対応 ITCOM A.Nakamura Add Start
    //*********************
    //ソーシャルメディア検索
    //*********************
    private String getSelectSQLForSocialMedia() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");              //商品名
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");          //見積料金
        //sql.append("  " + TBTHB1DOWN.FIELD3 +  " "+ NewReportLionVO.KIKAN + ", ");//期間
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE ''");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                      //期間
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");           //請求ブランド
        sql.append(" " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ ",");                   //コード（ブランド）
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + ","); //消費税率
        sql.append("  " + TBTHB2KMEI.NAME1 +  " "+ NewReportLionVO.SZEIGAK);                    //消費税額
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME + ",");
        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
        sql.append("  " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '017' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '1B' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + NewReportLionVO.CODE + ",");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append("  " + TBTHB1DOWN.JYUTNO + ",");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ",");
        sql.append("  " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }
  //*********************
    //デジタル動画検索
    //*********************
    private String getSelectSQLForDigitalMovie() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");              //商品名
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");          //見積料金
        //sql.append("  " + TBTHB1DOWN.FIELD3 +  " "+ NewReportLionVO.KIKAN + ", ");//期間
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE ''");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                      //期間
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");           //請求ブランド
        sql.append(" " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ ",");                   //コード（ブランド）
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + ","); //消費税率
        sql.append("  " + TBTHB2KMEI.NAME1 +  " "+ NewReportLionVO.SZEIGAK);                    //消費税額
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME + ",");
        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
        sql.append("  " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '017' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '1C' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + NewReportLionVO.CODE + ",");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append("  " + TBTHB1DOWN.JYUTNO + ",");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ",");
        sql.append("  " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }
    //2017/06/05 ライオン対応 ITCOM A.Nakamura Add End

    //*********************
    //チラシ検索
    //*********************
    private String getSelectSQLForTirashi() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");              //商品名
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");          //見積料金
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + " ,");          //請求ブランド
        //sql.append("  " + TBTHB1DOWN.FIELD12 + " " + NewReportLionVO.KIKAN+ ", ");//期間
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE '' ");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                      //期間
        sql.append(" " + TBTHB2KMEI.CODE3 + " "+ NewReportLionVO.CODE+ ",");                    //コード（ブランド）
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + "," );//消費税率
        sql.append(" " + TBTHB2KMEI.NAME1 +  " "+ NewReportLionVO.SZEIGAK);                     //消費税額
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME + ",");
        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
        sql.append("  " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '014' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + NewReportLionVO.CODE + ",");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB1DOWN.JYUTNO + ",");
        sql.append(" " + TBTHB1DOWN.JYMEINO + ",");
        sql.append(" " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }

    //*********************
    //その他検索
    //*********************
    private String getSelectSQLForSonota() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");              //商品名
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");          //見積料金
        //sql.append("  " + TBTHB1DOWN.FIELD5 +  " "+ NewReportLionVO.KIKAN + ", ");//期間
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE ''");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                      //期間
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");           //請求ブランド
        sql.append(" " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ ",");                   //コード（ブランド）
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) "+ NewReportLionVO.SHOHIZEI_RITU+ ",");   //消費税率
        sql.append(" " + TBTHB2KMEI.NAME1 +  " "+ NewReportLionVO.SZEIGAK);//消費税額
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME + ",");
        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
        sql.append("  " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '010' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + NewReportLionVO.CODE + ",");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB1DOWN.JYUTNO + ",");
        sql.append(" " + TBTHB1DOWN.JYMEINO + ",");
        sql.append(" " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }

    //*********************
    //サンプリング検索
    //*********************
    private String getSelectSQLForSampling() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.NAME10 + " " + NewReportLionVO.KENNAME + ",");              //商品名
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");          //見積料金
        //sql.append("  " + TBTHB1DOWN.FIELD12 +  " "+ NewReportLionVO.KIKAN + ", ");//期間
        sql.append(" CASE " + TBTHB1DOWN.SEIKBN);
        sql.append(" WHEN '11' THEN " + TBTHB1DOWN.FIELD12);
        sql.append(" WHEN '21' THEN " + TBTHB1DOWN.FIELD10);
        sql.append(" WHEN '41' THEN " + TBTHB1DOWN.FIELD6);
        sql.append(" WHEN '42' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" WHEN '81' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '71' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '61' THEN " + TBTHB1DOWN.FIELD5);
        sql.append(" WHEN '31' THEN " + TBTHB1DOWN.FIELD3);
        sql.append(" WHEN '32' THEN " + TBTHB1DOWN.FIELD4);
        sql.append(" ELSE '' ");
        sql.append(" END " + NewReportLionVO.KIKAN + ",");                                      //期間
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");           //請求ブランド
        sql.append(" " + TBTHB2KMEI.CODE3 +  " "+ NewReportLionVO.CODE+ ",");                   //コード（ブランド）
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + ","); //消費税率
        sql.append(" " + TBTHB2KMEI.NAME1 +  " "+ NewReportLionVO.SZEIGAK);                     //消費税額
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME + ",");
        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
        sql.append("  " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '015' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" " + NewReportLionVO.CODE + ",");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB1DOWN.JYUTNO + ",");
        sql.append(" " + TBTHB1DOWN.JYMEINO + ",");
        sql.append(" " + TBTHB1DOWN.URMEINO);

        return sql.toString();
    }

    //*********************
    //BSCS検索
    //*********************
    private String getSelectSQLForBsCs() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(" /*+ ORDERED */");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" " + TBTHB9WLTVB.BANNAME + " " + NewReportLionVO.BANMEI + ",");                                                 //番組名
        //sql.append("  " + TBTHB11WLTVK.KYOKUNAME + " " + NewReportLionVO.HOUSOUKYOKU + ",");                                      //放送局
        sql.append(" " + TBTHB1DOWN.FIELD2 + " " + NewReportLionVO.HOUSOUKYOKU + ",");                                              //放送局
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + NewReportLionVO.MITUMORIRYO + ",");                                              //見積料金
        sql.append(" (" + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU ," );                                                        //消費税率
        sql.append(" DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ ")) " + NewReportLionVO.SZEIGAK+ ",");   //消費税額
        sql.append(" " + TBTHB2KMEI.KNGK1 +  " "+ NewReportLionVO.TEIKARYOKIN + ",");                                               //放送料金
        sql.append(" " + TBTHB2KMEI.SONOTA7 +  " "+ NewReportLionVO.CMBYOUSU + ",");                                                //秒数
        sql.append(" " + TBTHB2KMEI.SONOTA5 +  " "+ NewReportLionVO.HONSU + ",");                                                   //本数
        sql.append(" " + TBTHB1DOWN.FIELD8 +  " "+ NewReportLionVO.KIKAN + ",");                                                    //放送期間
        sql.append(" " + TBTHB2KMEI.CODE5 +  " "+ NewReportLionVO.BANCD + ",");                                                     //番組コード
        sql.append(" " + TBTHB2KMEI.CODE2 +  " "+ NewReportLionVO.KYOKUCD);                                                         //局誌コード
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        sql.append(", " + TBTHB2KMEI.CODE3 + " " + NewReportLionVO.CODE);                                                           //ブランドコード
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME + ",");
        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
        //sql.append("  " + TBTHB11WLTVK.TBNAME + ", ");
        sql.append("  " + TBTHB9WLTVB.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('016') AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE5 + ") = " + TBTHB9WLTVB.BANCD);
        //sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ") = " + TBTHB11WLTVK.KYOKUCD + "  ");
        sql.append(" ORDER BY");
        sql.append("  " + TBTHB1DOWN.JYUTNO + ",");
        sql.append("  " + TBTHB1DOWN.JYMEINO + ",");
        /* 2015/08/18 UnixAB号機サーバリプレース対応 oki keisuke  UPD START*/
        sql.append("  " + TBTHB1DOWN.URMEINO + ",");
        sql.append("  " + TBTHB9WLTVB.HYOJIJYUN + ",");
        sql.append("  " + TBTHB2KMEI.RENBN + " ");
        // sql.append("  " + TBTHB1DOWN.URMEINO );
        /* 2015/08/18 UnixAB号機サーバリプレース対応 oki keisuke UPD END*/

        return sql.toString();
    }

    //*********************
    //テレビタイム検索
    //*********************
    private String getSelectSQLForTvTime(){

        // SQL.
        StringBuffer sql = new StringBuffer();

        /* 2014/07/31 消費税端数調整対応 HLC fujimoto MOD start */
        //※不要な内部結合を解消することによるパフォーマンス改善
        sql.append("SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + TBTB1 + "." + NewReportLionVO.KENNAME + ",");              //番組名
        sql.append(" " + TBTB1 + "." + NewReportLionVO.HOUSOUKYOKU + ",");          //放送局
        sql.append(" " + TBTB1 + "." + NewReportLionVO.NETKYOKU + ",");             //ネット局
        sql.append(" " + TBTB1 + "." + NewReportLionVO.MITUMORIRYO + ",");          //見積料金
        sql.append(" " + TBTB1 + "." + NewReportLionVO.SHOHIZEI_RITU + ",");        //消費税率
        sql.append(" " + TBTB1 + "." + NewReportLionVO.SZEIGAK + ",");              //消費税額
        sql.append(" " + TBTB1 + "." + NewReportLionVO.CMBYOUSU + ",");             //CM秒数
        sql.append(" " + TBTB1 + "." + NewReportLionVO.HONSU + ",");                //本数
        sql.append(" " + TBTB1 + "." + NewReportLionVO.TEIKARYOKIN + ",");          //放送料金
        sql.append(" " + TBTB1 + "." + NewReportLionVO.KIKAN + ",");                //期間
        sql.append(" " + TBTB1 + "." + NewReportLionVO.SUMSEIGAK + ",");            //実施電波料
        sql.append(" " + TBTHB9WLTVB.HYOJIJYUN + " " + NewReportLionVO.AREA + ","); //表示順
        sql.append(" " + TBTB1 + "." + NewReportLionVO.CODE);                       //ブランドコード
        sql.append(" FROM");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + " KENNAME,");
        sql.append(" " + TBTHB1DOWN.FIELD1 + " HOUSOUKYOKU,");
        sql.append(" " + TBTHB1DOWN.FIELD3 + " NETKYOKU,");
        sql.append(" " + TBTHB1DOWN.FIELD5 + " CMBYOUSU,");
        sql.append(" " + TBTHB1DOWN.FIELD6 + " HONSU,");
        sql.append(" " + TBTHB1DOWN.FIELD8 + " KIKAN,");
        sql.append(" " + TBTHB2KMEI.EGCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.CODE5 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + " * 0.01 SHOHIZEI_RITU,");
        sql.append(" SUM(" + TBTHB2KMEI.SEIGAK + ") MITUMORIRYO,");
        sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1 + "),'','0',TRIM(" + TBTHB2KMEI.NAME1 + "))) SZEIGAK,");
        sql.append(" SUM(" + TBTHB2KMEI.KNGK1 + " + " + TBTHB2KMEI.KNGK2 + " + " + TBTHB2KMEI.KNGK3 + ") TEIKARYOKIN,");
        sql.append(" SUM(" + TBTHB2KMEI.KNGK1 + ") SUMSEIGAK,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " CODE");
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHB2KMEI.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB1DOWN.EGCD + "= '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ( '001','002' ) AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + "= " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '");
        sql.append(" GROUP BY");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + ",");
        sql.append(" " + TBTHB1DOWN.FIELD1 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD3 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD5 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD6 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD8 + ",");
        sql.append(" " + TBTHB2KMEI.EGCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + TBTHB2KMEI.CODE3 + ",");
        sql.append(" " + TBTHB2KMEI.CODE5 + "");
        sql.append(" ) " + TBTB1 + ",");
        sql.append(" " + TBTHB9WLTVB.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB9WLTVB.EGCD + " = " + TBTB1 + "." + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB9WLTVB.TKSKGYCD + " = " + TBTB1 + "." + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB9WLTVB.TKSBMNSEQNO + " = " + TBTB1 + "." + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB9WLTVB.TKSTNTSEQNO + " = " + TBTB1 + "." + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB9WLTVB.BANCD + " = TRIM(" + TBTB1 + "." + TBTHB2KMEI.CODE5 + ")");
        sql.append(" ORDER BY");
        sql.append(" CAST(" + TBTHB9WLTVB.HYOJIJYUN + " AS INT),");
        sql.append(" " + TBTHB9WLTVB.BANCD);

//        sql.append(" SELECT ");
//        sql.append("  " + TBTHB1DOWN.KKNAMEKJ + " " + NewReportLionVO.KENNAME + ", ");//番組名
//        sql.append("  " + TBTHB1DOWN.FIELD1+ " " + NewReportLionVO.HOUSOUKYOKU + ", ");//放送局
//        sql.append("  " + TBTHB1DOWN.FIELD3+ " " + NewReportLionVO.NETKYOKU + ", ");//ネット局
//        sql.append("  TB1." + NewReportLionVO.MITUMORIRYO + " " + NewReportLionVO.MITUMORIRYO + ", ");//見積もり料金
//        sql.append(" (TB1." + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU ," ); //消費税率
//        sql.append("  TB1." + NewReportLionVO.SZEIGAK + " " + NewReportLionVO.SZEIGAK + ", ");//消費税額
//        sql.append("  " + TBTHB1DOWN.FIELD5+  " "+ NewReportLionVO.CMBYOUSU + ", ");//秒数
//        sql.append("  " + TBTHB1DOWN.FIELD6+  " "+ NewReportLionVO.HONSU + ", ");//本数
//        sql.append("  TB1." + NewReportLionVO.TEIKARYOKIN +  " "+ NewReportLionVO.TEIKARYOKIN + ", ");//放送料金
//        sql.append("  " + TBTHB1DOWN.FIELD8 +  " "+ NewReportLionVO.KIKAN + ", ");//放送期間
//        //okazaki
//        sql.append("  TB1." + NewReportLionVO.SUMSEIGAK + " " + NewReportLionVO.SUMSEIGAK + ", ");//実施電波料
//        sql.append("  " + TBTHB9WLTVB.HYOJIJYUN + " " + NewReportLionVO.AREA + " ");//表示順
//        //okazaki
//        sql.append(" FROM ");
//        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
//        sql.append(" (SELECT ");
//        sql.append(" " + TBTHB2KMEI.EGCD + ", ");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + ", ");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + ", ");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + ", ");
//        sql.append(" " + TBTHB2KMEI.JYUTNO + ", ");
//        sql.append(" " + TBTHB2KMEI.JYMEINO + ", ");
//        sql.append(" " + TBTHB2KMEI.URMEINO + ", ");
//        sql.append(" " + TBTHB2KMEI.CODE5 + ", ");
//        sql.append(" " + TBTHB2KMEI.RITU1 + ", ");
//        sql.append(" SUM(" + TBTHB2KMEI.SEIGAK+ ") " + NewReportLionVO.MITUMORIRYO + ", ");
//        sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ "))) " + NewReportLionVO.SZEIGAK+ ", ");//消費税額
//        sql.append(" SUM(" + TBTHB2KMEI.KNGK1+ " + " + TBTHB2KMEI.KNGK2+ " + " + TBTHB2KMEI.KNGK3+ ") " + NewReportLionVO.TEIKARYOKIN + ", ");
//        //okazaki
//        sql.append(" SUM(" + TBTHB2KMEI.KNGK1+ ") " + NewReportLionVO.SUMSEIGAK+ " "); //実施電波料
//        //okazaki
//        sql.append(" FROM ");
//        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
//        sql.append("  " + TBTHB2KMEI.TBNAME + " ");
//        sql.append(" WHERE ");
//        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
//        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND ");
//        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('001','002') AND ");
//        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
//        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
//        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
//        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
//        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
//        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '   ");
//        sql.append(" GROUP BY ");
//        sql.append(" " + TBTHB2KMEI.JYUTNO  + ", ");
//        sql.append(" " + TBTHB2KMEI.JYMEINO  + ", ");
//        sql.append(" " + TBTHB2KMEI.URMEINO  + ", ");
//        sql.append(" " + TBTHB2KMEI.RITU1 + ", ");
//        sql.append(" " + TBTHB2KMEI.CODE5  + " ) TB1 , ");
//        sql.append(" " + TBTHB9WLTVB.TBNAME  + " ");
//        sql.append(" WHERE ");
//        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND ");
//        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
//        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
//        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
//        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND ");
//        sql.append(" TB1." + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO+ " AND ");
//        sql.append(" TB1." + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
//        sql.append(" TB1." + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
//        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
//        sql.append(" " + TBTHB9WLTVB.EGCD + " (+) = TB1." + TBTHB2KMEI.EGCD + " AND ");
//        sql.append(" " + TBTHB9WLTVB.TKSKGYCD + " (+) = TB1." + TBTHB2KMEI.TKSKGYCD + " AND ");
//        sql.append(" " + TBTHB9WLTVB.TKSBMNSEQNO + " (+) = TB1." + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
//        sql.append(" " + TBTHB9WLTVB.TKSTNTSEQNO + " (+) = TB1." + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
//        sql.append(" " + TBTHB9WLTVB.BANCD + " (+) = TRIM(TB1." + TBTHB2KMEI.CODE5 + ") ");
//        sql.append(" ORDER BY ");
//        sql.append(" CAST(" + TBTHB9WLTVB.HYOJIJYUN  + " AS INT) , ");
//        sql.append(" " + TBTHB9WLTVB.BANCD  + " ");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto MOD end */

        return sql.toString();
    }

    //*********************
    //テレビスポット検索
    //*********************
    private String getSelectSQLForTvSpot() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        /* 2014/07/31 消費税端数調整対応 HLC fujimoto MOD start */
        //※不要な内部結合を解消することによるパフォーマンス改善
        sql.append("SELECT");
        sql.append(" " + TBTB1 + "." + NewReportLionVO.KENNAME + ",");                                              //商品名
        sql.append(" CONCAT(" + TBTB1 + "." + TBTHB1DOWN.FIELD1 + ", '他') " + NewReportLionVO.HOUSOUKYOKU + ",");  //放送局
        sql.append(" " + TBTB1 + "." + NewReportLionVO.MITUMORIRYO + ",");                                          //見積料金
        sql.append(" " + TBTB1 + "." + NewReportLionVO.SHOHIZEI_RITU + ",");                                        //消費税率
        sql.append(" " + TBTB1 + "." + NewReportLionVO.SZEIGAK + ",");                                              //請求金額
        sql.append(" " + TBTB1 + "." + NewReportLionVO.TEIKARYOKIN + ",");                                          //定価料金
        sql.append(" " + TBTB1 + "." + NewReportLionVO.CMBYOUSU + ",");                                             //CM秒数
        sql.append(" " + TBTB1 + "." + NewReportLionVO.KIKAN + ",");                                                //期間
        sql.append(" " + TBMST + "." + NewReportLionVO.SEIKYUBRAND + ",");                                          //請求ブランド
        sql.append(" " + TBMST + "." + NewReportLionVO.CODE);                                                       //ブランドコード
        sql.append(" FROM");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" " + TBTHBAMST.FIELD1 + " " + NewReportLionVO.CODE + ",");
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND);
        sql.append(" FROM");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201'");
        sql.append(" ) " + TBMST + ",");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + " " + NewReportLionVO.KENNAME + ",");
        sql.append(" " + TBTHB1DOWN.FIELD1 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD4 + " " + NewReportLionVO.KIKAN + ",");
        sql.append(" " + TBTHB1DOWN.FIELD5 + " " + NewReportLionVO.CMBYOUSU + ",");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") " + TBTHB2KMEI.CODE3 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + " * 0.01 " + NewReportLionVO.SHOHIZEI_RITU + ",");
        sql.append(" SUM(" + TBTHB2KMEI.SEIGAK + ") " + NewReportLionVO.MITUMORIRYO + ",");
        sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1 + "),'','0',TRIM(" + TBTHB2KMEI.NAME1 + "))) " + NewReportLionVO.SZEIGAK + ",");
        sql.append(" SUM(" + TBTHB2KMEI.KNGK1 + ") " + NewReportLionVO.TEIKARYOKIN);
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHB2KMEI.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '005' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '02' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '");
        sql.append(" GROUP BY");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + ",");
        sql.append(" " + TBTHB1DOWN.FIELD1 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD4 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD5 + ",");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + TBTHB2KMEI.CODE3);
        sql.append(" ) " + TBTB1);
        sql.append(" WHERE");
        sql.append(" " + TBTB1 + "." + TBTHB2KMEI.CODE3 + " = " + TBMST + "." + NewReportLionVO.CODE);
        /* 2015/08/18 UnixAB号機サーバリプレース対応 oki keisuke ADD START*/
        sql.append(" ORDER BY");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + NewReportLionVO.SHOHIZEI_RITU + ",");
        sql.append(" " + TBTHB2KMEI.CODE3 + " ");
        /* 2015/08/18 UnixAB号機サーバリプレース対応 oki keisuke ADD END*/

        //sql.append(" SELECT ");
        //sql.append("/*+ ordered */");
        //sql.append("  " + TBTHB1DOWN.KKNAMEKJ + " " + NewReportLionVO.KENNAME + ", ");//商品名
        //sql.append("  CONCAT(" + TBTHB1DOWN.FIELD1+ ", '他') " + NewReportLionVO.HOUSOUKYOKU+ ", ");//放送局
        //sql.append("  TB1." + NewReportLionVO.MITUMORIRYO + " " + NewReportLionVO.MITUMORIRYO + ", ");//見積もり料金
        //sql.append(" (TB1." + TBTHB2KMEI.RITU1 + "* 0.01) AS SHOHIZEI_RITU ," ); //消費税率
        //sql.append("  TB1." + NewReportLionVO.SZEIGAK + " " + NewReportLionVO.SZEIGAK + ", ");//消費税額
        //sql.append("  TB1." + NewReportLionVO.TEIKARYOKIN +  " "+ NewReportLionVO.TEIKARYOKIN + ", ");//放送料金
        //sql.append("  " + TBTHB1DOWN.FIELD5 +  " "+ NewReportLionVO.CMBYOUSU + ", ");//素材秒数
        //sql.append("  " + TBTHB1DOWN.FIELD4 +  " "+ NewReportLionVO.KIKAN + ", ");//放送期間
        //sql.append("  " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + " , "); //請求ブランド
        //sql.append("  " + TBTHBAMST.FIELD1 +  " "+ NewReportLionVO.CODE+ " ");//コード（ブランド）
        //sql.append(" FROM ");
        //sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        //sql.append("  " + TBTHBAMST.TBNAME + ", ");
        //sql.append(" (SELECT ");
        //sql.append(" " + TBTHB2KMEI.JYUTNO + ", ");
        //sql.append(" " + TBTHB2KMEI.JYMEINO + ", ");
        //sql.append(" " + TBTHB2KMEI.URMEINO + ", ");
        //sql.append(" " + TBTHB2KMEI.CODE3 + ", ");
        //sql.append(" " + TBTHB2KMEI.RITU1 + ", ");
        //sql.append(" SUM(" + TBTHB2KMEI.SEIGAK+ ") " + NewReportLionVO.MITUMORIRYO + ", ");
        //sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ "))) " + NewReportLionVO.SZEIGAK+ ", ");//消費税額
        //sql.append(" SUM(" + TBTHB2KMEI.KNGK1+ ") " + NewReportLionVO.TEIKARYOKIN + " ");
        //sql.append(" FROM ");
        //sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        //sql.append("  " + TBTHB2KMEI.TBNAME + " ");
        //sql.append(" WHERE ");
        //sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        //sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        //sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        //sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        //sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND ");
        //sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('005') AND ");
        //sql.append(" " + TBTHB2KMEI.CODE1 + " IN ('02') AND ");
        //sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        //sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        //sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        //sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        //sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        //sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        //sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        //sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        //sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '   ");
        //sql.append(" GROUP BY ");
        //sql.append(" " + TBTHB2KMEI.JYUTNO  + ", ");
        //sql.append(" " + TBTHB2KMEI.JYMEINO  + ", ");
        //sql.append(" " + TBTHB2KMEI.URMEINO  + ", ");
        //sql.append(" " + TBTHB2KMEI.RITU1 + ", ");
        //sql.append(" " + TBTHB2KMEI.CODE3  + " ) TB1 ");
        //sql.append(" WHERE ");
        //sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        //sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        //sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        //sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        //sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND ");
        //sql.append(" TB1." + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO+ " AND ");
        //sql.append(" TB1." + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        //sql.append(" TB1." + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        //sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND ");
        //sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHBAMST.EGCD + " AND ");
        //sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND ");
        //sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND ");
        //sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND ");
        //sql.append(" " + TBTHBAMST.SYBT + " = '201' AND ");
        //sql.append(" TRIM(TB1." + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1 + "   ");
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto MOD end */

        return sql.toString();
    }

    //*********************
    //ラジオタイム検索
    //*********************
    private String getSelectSQLForRadioTime() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        //※不要な内部結合を解消することによるパフォーマンス改善
        sql.append("SELECT");
        sql.append(" " + TBTB1 + "." + NewReportLionVO.BANMEI + ",");                   //番組名
        sql.append(" " + TBTB1 + "." + NewReportLionVO.HOUSOUKYOKU + ",");              //放送局
        sql.append(" " + TBTB1 + "." + NewReportLionVO.MITUMORIRYO + ",");              //見積料金
        sql.append(" " + TBTB1 + "." + NewReportLionVO.SHOHIZEI_RITU + ",");            //消費税率
        sql.append(" " + TBTB1 + "." + NewReportLionVO.SZEIGAK + ",");                  //消費税額
        sql.append(" " + TBTB1 + "." + NewReportLionVO.CMBYOUSU + ",");                 //CM秒数
        sql.append(" " + TBTB1 + "." + NewReportLionVO.HONSU + ",");                    //本数
        sql.append(" " + TBTB1 + "." + NewReportLionVO.TEIKARYOKIN + ",");              //実施料金＋製作費＝放送料金
        sql.append(" " + TBTB1 + "." + NewReportLionVO.KIKAN + ",");                    //期間
        sql.append(" " + TBTHB10WLRDB.HYOJIJYUN + " " + NewReportLionVO.AREA + ",");    //表示順
        sql.append(" " + TBTB1 + "." + NewReportLionVO.CODE);                           //ブランドコード
        sql.append(" FROM");
        sql.append(" (");
        sql.append(" SELECT");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + " BANMEI,");
        sql.append(" " + TBTHB1DOWN.FIELD1 + " HOUSOUKYOKU,");
        sql.append(" " + TBTHB1DOWN.FIELD5 + " CMBYOUSU,");
        sql.append(" " + TBTHB1DOWN.FIELD6 + " HONSU,");
        sql.append(" " + TBTHB1DOWN.FIELD8 + " KIKAN,");
        sql.append(" " + TBTHB2KMEI.EGCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.CODE5 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + " * 0.01 SHOHIZEI_RITU,");
        sql.append(" SUM(" + TBTHB2KMEI.SEIGAK + ") MITUMORIRYO,");
        sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1 + "),'','0',TRIM(" + TBTHB2KMEI.NAME1 + "))) SZEIGAK,");
        sql.append(" SUM(" + TBTHB2KMEI.KNGK1 + " + " + TBTHB2KMEI.KNGK3 + " ) TEIKARYOKIN,");
        sql.append(" " + TBTHB2KMEI.CODE3 + " CODE");
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHB2KMEI.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ( '003','004' ) AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " =" + TBTHB1DOWN.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '");
        sql.append(" GROUP BY");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + ",");
        sql.append(" " + TBTHB1DOWN.FIELD1 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD5 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD6 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD8 + ",");
        sql.append(" " + TBTHB2KMEI.EGCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + ",");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + ",");
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + TBTHB2KMEI.CODE5 + ",");
        sql.append(" " + TBTHB2KMEI.CODE3);
        sql.append(" ) " + TBTB1 + ",");
        sql.append(" " + TBTHB10WLRDB.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB10WLRDB.EGCD + " = " + TBTB1 + "." + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB10WLRDB.TKSKGYCD + " = " + TBTB1 + "." + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB10WLRDB.TKSBMNSEQNO + " = " + TBTB1 + "." + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB10WLRDB.TKSTNTSEQNO + " = " + TBTB1 + "." + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB10WLRDB.BANCD + " = TRIM(" + TBTB1 + "." + TBTHB2KMEI.CODE5 + ")");
        sql.append(" ORDER BY");
        sql.append(" CAST(" + TBTHB10WLRDB.HYOJIJYUN + " AS INT),");
        sql.append(" " + TBTHB10WLRDB.BANCD);

//        sql.append("SELECT");
//        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + " " + NewReportLionVO.BANMEI + ",");                                                     //番組名
//        sql.append(" " + TBTHB1DOWN.FIELD1+ " " + NewReportLionVO.HOUSOUKYOKU + ",");                                                   //放送局
//        sql.append(" " + TBTB1 +"." + NewReportLionVO.MITUMORIRYO + " " + NewReportLionVO.MITUMORIRYO + ",");                          //見積料金
//        sql.append(" (" + TBTB1 + "." + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + ",");                          //消費税率
//        sql.append(" " + TBTB1 + "." + NewReportLionVO.SZEIGAK + " " + NewReportLionVO.SZEIGAK + ",");                                 //消費税額
//        sql.append(" " + TBTHB1DOWN.FIELD5 + " "+ NewReportLionVO.CMBYOUSU + ",");                                                      //秒数
//        sql.append(" " + TBTHB1DOWN.FIELD6 + " "+ NewReportLionVO.HONSU + ",");                                                         //本数
//        sql.append(" " + TBTB1 + "." + NewReportLionVO.TEIKARYOKIN +   " "+ NewReportLionVO.TEIKARYOKIN + ",");                        //実施料金＋制作費＝放送料金
//        sql.append(" " + TBTHB1DOWN.FIELD8 + " "+ NewReportLionVO.KIKAN + ",");                                                         //放送期間
//        sql.append(" " + TBTHB10WLRDB.HYOJIJYUN + " "+ NewReportLionVO.AREA);                                                           //表示順
//        sql.append(", " + TBTB1 + "." + NewReportLionVO.CODE);                                                                         //ブランドコード
//        sql.append(" FROM");
//        sql.append("  " + TBTHB1DOWN.TBNAME + ",");
//        sql.append(" (SELECT");
//        sql.append(" " + TBTHB2KMEI.EGCD + ",");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + ",");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + ",");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + ",");
//        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
//        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
//        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
//        sql.append(" " + TBTHB2KMEI.CODE5 + ",");
//        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
//        sql.append(" SUM(" + TBTHB2KMEI.SEIGAK + ") " + NewReportLionVO.MITUMORIRYO + ",");
//        sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1+ "),'','0',TRIM("+ TBTHB2KMEI.NAME1+ "))) " + NewReportLionVO.SZEIGAK+ ",");  //消費税額
//        sql.append(" SUM(" + TBTHB2KMEI.KNGK1 + " + " + TBTHB2KMEI.KNGK3 + " ) " + NewReportLionVO.TEIKARYOKIN);
//        sql.append(", " + TBTHB2KMEI.CODE3 + " " + NewReportLionVO.CODE);                                                               //ブランドコード
//        sql.append(" FROM ");
//        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
//        sql.append(" " + TBTHB2KMEI.TBNAME);
//        sql.append(" WHERE");
//        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
//        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
//        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('003','004') AND");
//        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
//        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
//        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
//        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
//        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
//        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '");
//        sql.append(" GROUP BY");
//        sql.append(" " + TBTHB2KMEI.JYUTNO  + ",");
//        sql.append(" " + TBTHB2KMEI.JYMEINO  + ",");
//        sql.append(" " + TBTHB2KMEI.URMEINO  + ",");
//        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
//        sql.append(" " + TBTHB2KMEI.CODE5);
//        sql.append(", " + TBTHB2KMEI.CODE3);
//        sql.append(" ) " + TBTB1 + ",");
//        sql.append(" " + TBTHB10WLRDB.TBNAME);
//        sql.append(" WHERE");
//        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
//        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
//        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
//        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
//        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
//        sql.append(" TB1." + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO+ " AND");
//        sql.append(" TB1." + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
//        sql.append(" TB1." + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
//        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
//        sql.append(" " + TBTHB10WLRDB.EGCD + " (+) = TB1." + TBTHB2KMEI.EGCD + " AND");
//        sql.append(" " + TBTHB10WLRDB.TKSKGYCD + " (+) = TB1." + TBTHB2KMEI.TKSKGYCD + " AND");
//        sql.append(" " + TBTHB10WLRDB.TKSBMNSEQNO + " (+) = TB1." + TBTHB2KMEI.TKSBMNSEQNO + " AND");
//        sql.append(" " + TBTHB10WLRDB.TKSTNTSEQNO + " (+) = TB1." + TBTHB2KMEI.TKSTNTSEQNO + " AND");
//        sql.append(" " + TBTHB10WLRDB.BANCD + " (+) = TRIM(TB1." + TBTHB2KMEI.CODE5 + ")");
//        sql.append(" ORDER BY");
//        sql.append(" CAST(" + TBTHB10WLRDB.HYOJIJYUN  + " AS INT),");
//        sql.append(" " + TBTHB10WLRDB.BANCD);
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto MOD end */

        return sql.toString();
    }

    //*********************
    //ラジオスポット検索
    //*********************
    private String getSelectSQLForRadioSpot() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
        //※不要な内部結合を解消することによるパフォーマンス改善
        sql.append("SELECT");
        sql.append(" /*+ ORDERED */");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + " " + NewReportLionVO.KENNAME + ",");                                                        //商品名
        sql.append(" " + TBTHB1DOWN.FIELD2 + " " + NewReportLionVO.HOUSOUKYOKU + ",");                                                      //放送局
        sql.append(" SUM(" + TBTHB2KMEI.SEIGAK + ") " + NewReportLionVO.MITUMORIRYO + ",");                                                 //見積料金
        sql.append(" " + TBTHB2KMEI.RITU1 + " * 0.01 " + NewReportLionVO.SHOHIZEI_RITU + ",");                                              //消費税率
        sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1 + "),'','0',TRIM(" + TBTHB2KMEI.NAME1 + "))) " + NewReportLionVO.SZEIGAK + ",");  //消費税額
        sql.append(" SUM(" + TBTHB2KMEI.KNGK1 + ") " + NewReportLionVO.TEIKARYOKIN + ", ");                                                 //放送料金
        sql.append(" " + TBTHB1DOWN.FIELD5 + " " + NewReportLionVO.CMBYOUSU + ",");                                                         //素材秒数
        sql.append(" " + TBTHB1DOWN.FIELD6 + " " + NewReportLionVO.HONSU + ",");                                                            //本数
        sql.append(" " + TBTHB1DOWN.FIELD4 + " " + NewReportLionVO.KIKAN + ",");                                                            //放送期間
        sql.append(" " + TBTHB2KMEI.CODE3 + " " + NewReportLionVO.CODE + ",");                                                              //ブランドコード
        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND);                                                             //請求ブランド
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '005' AND");
        sql.append(" " + TBTHB2KMEI.CODE1 + " = '05' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM + " AND");
        sql.append(" " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO + " AND");
        sql.append(" " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHBAMST.EGCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD +" AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1 + " AND");
        sql.append(" " + TBTHBAMST.SYBT + " = '201'");
        sql.append(" GROUP BY");
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + ",");
        sql.append(" " + TBTHB1DOWN.FIELD2 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD5 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD6 + ",");
        sql.append(" " + TBTHB1DOWN.FIELD4 + ",");
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
        sql.append(" " + TBTHB2KMEI.CODE3 + ",");
        sql.append(" " + TBTHBAMST.FIELD1 + ",");
        sql.append(" " + TBTHBAMST.FIELD2);
        sql.append(" ORDER BY");
        sql.append(" " + NewReportLionVO.CODE + ",");
        sql.append(" " + NewReportLionVO.HOUSOUKYOKU);

//        sql.append("SELECT");
//        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + " " + NewReportLionVO.KENNAME + ",");                                                    //商品名
//        sql.append(" " + TBTHB1DOWN.FIELD2 + " " + NewReportLionVO.HOUSOUKYOKU + ",");                                                  //放送局
//        sql.append(" TB1." + NewReportLionVO.MITUMORIRYO + " " + NewReportLionVO.MITUMORIRYO + ",");                                    //見積料金
//        sql.append(" (TB1." + TBTHB2KMEI.RITU1 + "* 0.01) " + NewReportLionVO.SHOHIZEI_RITU + ",");                                     //消費税率
//        sql.append(" TB1." + NewReportLionVO.SZEIGAK + " " + NewReportLionVO.SZEIGAK + ",");                                            //消費税額
//        sql.append(" TB1." + NewReportLionVO.TEIKARYOKIN + " "+ NewReportLionVO.TEIKARYOKIN + ",");                                     //実施料金＋制作費＝放送料金
//        sql.append(" " + TBTHB1DOWN.FIELD5 +  " "+ NewReportLionVO.CMBYOUSU + ",");                                                     //秒数
//        sql.append(" " + TBTHB1DOWN.FIELD6 +  " "+ NewReportLionVO.HONSU + ",");                                                        //本数
//        sql.append(" " + TBTHB1DOWN.FIELD4 +  " "+ NewReportLionVO.KIKAN + ",");                                                        //放送期間
//        sql.append(" " + TBTHBAMST.FIELD2 + " " + NewReportLionVO.SEIKYUBRAND + ",");                                                   //請求ブランド
//        sql.append(" " + TBTHBAMST.FIELD1 +  " "+ NewReportLionVO.CODE);                                                                //コード（ブランド）
//        sql.append(" FROM");
//        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
//        sql.append(" " + TBTHBAMST.TBNAME + ",");
//        sql.append(" ( SELECT");
//        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");
//        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");
//        sql.append(" " + TBTHB2KMEI.URMEINO + ",");
//        sql.append(" " + TBTHB2KMEI.CODE3 + ",");
//        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
//        sql.append(" SUM(" + TBTHB2KMEI.SEIGAK + ") " + NewReportLionVO.MITUMORIRYO + ",");
//        sql.append(" SUM(DECODE(TRIM(" + TBTHB2KMEI.NAME1 + "),'','0',TRIM("+ TBTHB2KMEI.NAME1 + "))) " + NewReportLionVO.SZEIGAK+ ",");//消費税額
//        sql.append(" SUM(" + TBTHB2KMEI.KNGK1 + ") " + NewReportLionVO.TEIKARYOKIN);
//        sql.append(" FROM");
//        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
//        sql.append(" " + TBTHB2KMEI.TBNAME);
//        sql.append(" WHERE");
//        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
//        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "' AND");
//        sql.append(" " + TBTHB2KMEI.CODE6 + " = '005' AND");
//        sql.append(" " + TBTHB2KMEI.CODE1 + " = '05' AND");
//        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND");
//        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND");
//        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND");
//        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND");
//        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND");
//        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND");
//        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
//        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
//        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '");
//        sql.append(" GROUP BY");
//        sql.append(" " + TBTHB2KMEI.JYUTNO  + ",");
//        sql.append(" " + TBTHB2KMEI.JYMEINO  + ",");
//        sql.append(" " + TBTHB2KMEI.URMEINO  + ",");
//        sql.append(" " + TBTHB2KMEI.RITU1 + ",");
//        sql.append(" " + TBTHB2KMEI.CODE3);
//        sql.append(" ) TB1");
//        sql.append(" WHERE");
//        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
//        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
//        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
//        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
//        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
//        sql.append(" TB1." + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO+ " AND");
//        sql.append(" TB1." + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND");
//        sql.append(" TB1." + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND");
//        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' '  AND");
//        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHBAMST.EGCD + " AND");
//        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " AND");
//        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " AND");
//        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " AND");
//        sql.append(" " + TBTHBAMST.SYBT + " = '201'  AND");
//        sql.append(" TRIM(TB1." + TBTHB2KMEI.CODE3 + ") = " + TBTHBAMST.FIELD1);
        /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */

        return sql.toString();
    }

    /**
     * 帳票データ(ライオン)の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<NewReportLionVO> findReportLionByCondition(NewReportLionCondition cond)
            throws KKHException {

        super.setModel(new NewReportLionVO());

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
    protected List<NewReportLionVO> createFindedModelInstances(List hashList) {
        List<NewReportLionVO> list = new ArrayList<NewReportLionVO>();
        if (getModel() instanceof NewReportLionVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                NewReportLionVO vo = new NewReportLionVO();

                //********************
                //全媒体
                //********************
                if(_sqlMode.equals(SqlMode.ALLBAITAI))
                {
                    vo.setBaitaicd((String) result.get(NewReportLionVO.BAITAICD.toUpperCase().trim()));                     //媒体コード
                    vo.setBaitaikocd((String) result.get(NewReportLionVO.BAITAIKOCD.toUpperCase().trim()));                 //媒体子コード
                    vo.setSumseigak((String) result.get(NewReportLionVO.SUMSEIGAK.toUpperCase().trim()).toString());        //請求金額合計
                    vo.setSumszeigak((String) result.get(NewReportLionVO.SUMSZEIGAK.toUpperCase().trim()).toString());      //消費税金額合計
                }
                //********************
                //新聞
                //********************
                else if(_sqlMode.equals(SqlMode.SHINBUN))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //商品名
                    vo.setShimei((String) result.get(NewReportLionVO.SHIMEI.toUpperCase().trim()));                         //紙名
                    vo.setKyokuCd((String) result.get(NewReportLionVO.KYOKUCD.toUpperCase().trim()));                       //局誌コード
                    vo.setSyurui((String) result.get(NewReportLionVO.SYURUI.toUpperCase().trim()));                         //掲載
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積料金
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //消費税率
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //消費税金額
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()));               //定価料金
                    vo.setSpace((String) result.get(NewReportLionVO.SPACE.toUpperCase().trim()));                           //スペース
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //請求ブランド
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //コード
                }
                //********************
                //雑誌
                //********************
                else if(_sqlMode.equals(SqlMode.ZASHI))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //商品名
                    vo.setZashimei((String) result.get(NewReportLionVO.ZASHIMEI.toUpperCase().trim()));                     //雑誌名
                    vo.setZashicd((String) result.get(NewReportLionVO.ZASHICD.toUpperCase().trim()));                       //雑誌コード
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積料金
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //消費税率
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //消費税金額
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()));               //定価料金
                    vo.setSpace((String) result.get(NewReportLionVO.SPACE.toUpperCase().trim()));                           //スペース
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //請求ブランド
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //コード
                }
                //********************
                //交通
                //********************
                else if(_sqlMode.equals(SqlMode.KOUTSU))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //商品名
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積料金
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //消費税率
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //消費税金額
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()));               //定価料金
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //請求ブランド
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //コード
                }
                //********************
                //事業費
                //********************
                else if(_sqlMode.equals(SqlMode.JIGYOUHI))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //商品名
                    vo.setSyurui((String) result.get(NewReportLionVO.SYURUI.toUpperCase().trim()));                         //種類
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積料金
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()));               //定価料金
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //請求ブランド
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //コード
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //消費税率
                    vo.setSzeigak((String)result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()));                        //消費税
                }
                //********************
                //モバイル
                //********************
                else if(_sqlMode.equals(SqlMode.MOBILE))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //商品名
                    vo.setHimokumei((String) result.get(NewReportLionVO.HIMOKUMEI.toUpperCase().trim()));                   //費目名
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積料金
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //消費税率
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //消費税金額
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //請求ブランド
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //コード
                }
                //********************
                //インターネット
                //********************
                else if(_sqlMode.equals(SqlMode.INTERNET))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //商品名
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積料金
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //請求ブランド
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //コード
                    vo.setShohizeiRitu((BigDecimal) result.get(ReportLionVO.SHOHIZEI_RITU.toUpperCase()));                  //消費税率
                    vo.setSzeigak((String)result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()));                        //消費税
                }
                //2017/06/05 ライオン対応 ITCOM A.Nakamura Add Start
              //********************
                //ソーシャルメディア
                //********************
                else if(_sqlMode.equals(SqlMode.SOCIALMEDIA))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //商品名
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積料金
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //請求ブランド
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //コード
                    vo.setShohizeiRitu((BigDecimal) result.get(ReportLionVO.SHOHIZEI_RITU.toUpperCase()));                  //消費税率
                    vo.setSzeigak((String)result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()));                        //消費税
                }
              //********************
                //デジタル動画
                //********************
                else if(_sqlMode.equals(SqlMode.DIGITALMOVIE))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //商品名
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積料金
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //請求ブランド
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //コード
                    vo.setShohizeiRitu((BigDecimal) result.get(ReportLionVO.SHOHIZEI_RITU.toUpperCase()));                  //消費税率
                    vo.setSzeigak((String)result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()));                        //消費税
                }

                //2017/06/05 ライオン対応 ITCOM A.Nakamura Add End

                //********************
                //チラシ
                //********************
                else if(_sqlMode.equals(SqlMode.TIRASHI))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //商品名
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積料金
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //請求ブランド
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //コード
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //消費税率
                    vo.setSzeigak((String)result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()));                        //消費税
                }
                //********************
                //その他
                //********************
                else if(_sqlMode.equals(SqlMode.SONOTA))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //商品名
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積もり料金
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //請求ブランド
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //コード
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //消費税率
                    vo.setSzeigak((String)result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()));                        //消費税
                }
                //********************
                //サンプリング
                //********************
                else if(_sqlMode.equals(SqlMode.SAMPLING))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //商品名
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積料金
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //請求ブランド
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //コード
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //消費税率
                    vo.setSzeigak((String)result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()));                        //消費税
                }
                //********************
                //BSCS
                //********************
                else if (_sqlMode.equals(SqlMode.BSCS))
                {
                    vo.setBanmei((String) result.get(NewReportLionVO.BANMEI.toUpperCase().trim()));                         //番組名
                    vo.setHousoukyoku((String) result.get(NewReportLionVO.HOUSOUKYOKU.toUpperCase().trim()));               //放送局
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積料金
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //消費税率
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //消費税金額
                    vo.setCmbyousu((String) result.get(NewReportLionVO.CMBYOUSU.toUpperCase().trim()));                     //CM秒数
                    vo.setHonsu((String) result.get(NewReportLionVO.HONSU.toUpperCase().trim()));                           //本数
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()).toString());    //放送料金
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    vo.setBanCd((String) result.get(NewReportLionVO.BANCD.toUpperCase().trim()));                           //番組コード
                    vo.setKyokuCd((String) result.get(NewReportLionVO.KYOKUCD.toUpperCase().trim()));                       //局誌コード
                    /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim().toString()));                  //ブランドコード
                    /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
                }
                //********************
                //テレビタイム
                //********************
                else if(_sqlMode.equals(SqlMode.TVTIME))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //番組名
                    vo.setHousoukyoku((String) result.get(NewReportLionVO.HOUSOUKYOKU.toUpperCase().trim()));               //放送局
                    vo.setNetKyoku((String) result.get(NewReportLionVO.NETKYOKU.toUpperCase().trim()));                     //ネット局
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積料金
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //消費税率
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //消費税金額
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()).toString());    //定価料金
                    vo.setCmbyousu((String) result.get(NewReportLionVO.CMBYOUSU.toUpperCase().trim()));                     //CM秒数
                    vo.setHonsu((String) result.get(NewReportLionVO.HONSU.toUpperCase().trim()));                           //本数
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    //okazaki
                    vo.setSumseigak((String) result.get(NewReportLionVO.SUMSEIGAK.toUpperCase().trim()).toString());        //実施電波料
                    vo.setArea((String) result.get(NewReportLionVO.AREA.toUpperCase().trim()).toString());                  //表示順
                    //okazaki
                    /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
                    vo.setCode((String)result.get(NewReportLionVO.CODE.toUpperCase().trim().toString()));                   //ブランドコード
                    /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
                }
                //********************
                //テレビスポット
                //********************
                else if(_sqlMode.equals(SqlMode.TVSPOT))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //商品名
                    vo.setHousoukyoku((String) result.get(NewReportLionVO.HOUSOUKYOKU.toUpperCase().trim()));               //放送局
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積料金
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //消費税率
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //消費税金額
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()).toString());    //定価料金
                    vo.setCmbyousu((String) result.get(NewReportLionVO.CMBYOUSU.toUpperCase().trim()));                     //素材秒数
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //請求ブランド
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //コード
                }
                //********************
                //ラジオタイム
                //********************
                else if(_sqlMode.equals(SqlMode.RADIOTIME))
                {
                    vo.setBanmei((String) result.get(NewReportLionVO.BANMEI.toUpperCase().trim()));                         //番組名
                    vo.setHousoukyoku((String) result.get(NewReportLionVO.HOUSOUKYOKU.toUpperCase().trim()));               //放送局
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積料金
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //消費税率
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //消費税金額
                    vo.setCmbyousu((String) result.get(NewReportLionVO.CMBYOUSU.toUpperCase().trim()));                     //CM秒数
                    vo.setHonsu((String) result.get(NewReportLionVO.HONSU.toUpperCase().trim()));                           //本数
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()).toString());    //放送料金
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    vo.setArea((String) result.get(NewReportLionVO.AREA.toUpperCase().trim()).toString());                  //表示順
                    /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD start */
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim().toString()));                  //ブランドコード
                    /* 2014/07/31 消費税端数調整対応 HLC fujimoto ADD end */
                }
                //********************
                //ラジオスポット
                //********************
                else if(_sqlMode.equals(SqlMode.RADIOSPOT))
                {
                    vo.setKenname((String) result.get(NewReportLionVO.KENNAME.toUpperCase().trim()));                       //商品名
                    vo.setHousoukyoku((String) result.get(NewReportLionVO.HOUSOUKYOKU.toUpperCase().trim()));               //放送局
                    vo.setMitumoriryo((String) result.get(NewReportLionVO.MITUMORIRYO.toUpperCase().trim()).toString());    //見積料金
                    vo.setShohizeiRitu((BigDecimal) result.get(NewReportLionVO.SHOHIZEI_RITU.toUpperCase()));               //消費税率
                    vo.setSzeigak((String) result.get(NewReportLionVO.SZEIGAK.toUpperCase().trim()).toString());            //消費税金額
                    vo.setTeikaryokin((String) result.get(NewReportLionVO.TEIKARYOKIN.toUpperCase().trim()).toString());    //放送料金
                    vo.setCmbyousu((String) result.get(NewReportLionVO.CMBYOUSU.toUpperCase().trim()));                     //CM秒数
                    vo.setHonsu((String) result.get(NewReportLionVO.HONSU.toUpperCase().trim()));                           //本数
                    vo.setKikan((String) result.get(NewReportLionVO.KIKAN.toUpperCase().trim()));                           //期間
                    vo.setSeikyubrand((String) result.get(NewReportLionVO.SEIKYUBRAND.toUpperCase().trim()));               //請求ブランド
                    vo.setCode((String) result.get(NewReportLionVO.CODE.toUpperCase().trim()));                             //コード

                }
//              vo.setBrandMei((String) result.get(ReportLionVO.BRAND_MEI.toUpperCase().trim())); //ブランド名
//              vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));           //請求額

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
