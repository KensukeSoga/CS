package jp.co.isid.kkh.customer.acom.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU29CC;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomCondition;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomVO;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;
import jp.co.isid.kkh.util.constants.KKHConstants;

/**
 *
 * <P>
 * 帳票（アコム)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/11)<BR>
 * </P>
 *
 * @author
 */

public class ReportAcomDAO extends AbstractRdbDao {

    /** 汎用マスタ検索条件 */
    private ReportAcomCondition _cond;

    /** 汎用マスタ：媒体区分：新聞 */
    public static final String C_BAITAI_SHINBUN = "21";

    /** 汎用マスタ：媒体区分：雑誌 */
    public static final String C_BAITAI_ZASHI = "22";

    /** 汎用マスタ：媒体区分：電波 */
    public static final String C_BAITAI_DENPA = "11";

    /** 汎用マスタ：媒体区分：広告 */
    public static final String C_BAITAI_KOTSU = "31";

    /** 汎用マスタ：媒体種別：新聞 */
    public static final String C_HBAMST_F1_SHINBUN = "02";

    /** 汎用マスタ：媒体種別：雑誌 */
    public static final String C_HBAMST_F1_ZASHI = "03";

    /** 汎用マスタ：媒体種別：電波 */
    public static final String C_HBAMST_F1_DENPA = "mast7.gyomKbn";

    /** 汎用マスタ：媒体種別：テレビ */
    public static final String C_HBAMST_F1_TV = "04";

    /** 汎用マスタ：媒体種別：ラジオ */
    public static final String C_HBAMST_F1_RADIO = "05";

    /** 汎用マスタ：媒体種別：衛星メディア */
    public static final String C_HBAMST_F1_EISEI = "07";

    /** 汎用マスタ：媒体種別：交通 */
    public static final String C_HBAMST_F1_KOTSU = "06";

    /** 汎用マスタ：掲載場所 */
    public static final String C_HBAMST_SYBT_KSAI = "906";

    /** 汎用マスタ：サイズ */
    public static final String C_HBAMST_SYBT_SIZE = "907";

    /** 汎用マスタ：記雑 */
    public static final String C_HBAMST_SYBT_KZA = "908";

    /** 汎用マスタ：朝夕 */
    public static final String C_HBAMST_SYBT_CHOYU = "909";

    /** 汎用マスタ：メディア */
    public static final String C_HBAMST_SYBT_MEDIA = "910";

    /** 汎用マスタ：色刷 */
    public static final String C_HBAMST_SYBT_IRO = "911";

    /** 業務区分マスタ：コード：ラジオ*/
    public static final String C_GYOM_CD_RADIO = KKHConstants.GyomKbn.RADIO.getCode();
    //public static final String C_GYOM_CD_RADIO = "11030";

    /** 業務区分マスタ：コード：テレビタイム */
    public static final String C_GYOM_CD_TVTIME = KKHConstants.GyomKbn.TVTIME.getCode();
    //public static final String C_GYOM_CD_TVTIME = "11040";

    /** 業務区分マスタ：コード：テレビスポット */
    public static final String C_GYOM_CD_TVSPOT = KKHConstants.GyomKbn.TVSPOT.getCode();
    //public static final String C_GYOM_CD_TVSPOT = "11045";

    /** 業務区分マスタ：コード：衛星メディア */
    public static final String C_GYOM_CD_EISEI = KKHConstants.GyomKbn.EISEIM.getCode();
    //public static final String C_GYOM_CD_EISEI = "11050";

    /** getSelectSQLで発行するSQLのモード() */
//	private enum SqlMode {
//		KIND, ITEM,
//	};

    //private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * デフォルトコンストラクタ。
     */
    public ReportAcomDAO() {
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
/*		return new String[] {
                TBTHB2KMEI.EGCD,
                TBTHB2KMEI.TKSKGYCD,
                TBTHB2KMEI.TKSBMNSEQNO,
                TBTHB2KMEI.TKSTNTSEQNO,
                TBTHB2KMEI.YYMM,
                TBTHB2KMEI.JYUTNO,
                TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO,
                TBTHB2KMEI.RENBN };*/
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
        /*
        return new String[] {
                TBTHB2KMEI.TIMSTMP, TBTHB2KMEI.UPDAPL,
                TBTHB2KMEI.UPDTNT, TBTHB2KMEI.EGCD, TBTHB2KMEI.TKSKGYCD,
                TBTHB2KMEI.TKSBMNSEQNO, TBTHB2KMEI.TKSTNTSEQNO,
                TBTHB2KMEI.YYMM, TBTHB2KMEI.JYUTNO, TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO, TBTHB2KMEI.HIMKCD, TBTHB2KMEI.RENBN,
                TBTHB2KMEI.DATEFROM, TBTHB2KMEI.DATETO, TBTHB2KMEI.SEIGAK,
                TBTHB2KMEI.HNNERT, TBTHB2KMEI.HNMAEGAK, TBTHB2KMEI.NEBIGAK,
                TBTHB2KMEI.DATE1, TBTHB2KMEI.DATE2, TBTHB2KMEI.DATE3,
                TBTHB2KMEI.DATE4, TBTHB2KMEI.DATE5, TBTHB2KMEI.DATE6,
                TBTHB2KMEI.KBN1, TBTHB2KMEI.KBN2, TBTHB2KMEI.KBN3,
                TBTHB2KMEI.CODE1, TBTHB2KMEI.CODE2, TBTHB2KMEI.CODE3,
                TBTHB2KMEI.CODE4, TBTHB2KMEI.CODE5, TBTHB2KMEI.CODE6,
                TBTHB2KMEI.NAME1, TBTHB2KMEI.NAME2, TBTHB2KMEI.NAME3,
                TBTHB2KMEI.NAME4, TBTHB2KMEI.NAME5, TBTHB2KMEI.NAME6,
                TBTHB2KMEI.NAME7, TBTHB2KMEI.NAME8, TBTHB2KMEI.NAME9,
                TBTHB2KMEI.NAME10, TBTHB2KMEI.KNGK1, TBTHB2KMEI.KNGK2,
                TBTHB2KMEI.KNGK3, TBTHB2KMEI.RITU1, TBTHB2KMEI.RITU2,
                TBTHB2KMEI.SONOTA1, TBTHB2KMEI.SONOTA2, TBTHB2KMEI.SONOTA3,
                TBTHB2KMEI.SONOTA4, TBTHB2KMEI.SONOTA5, TBTHB2KMEI.SONOTA6,
                TBTHB2KMEI.SONOTA7, TBTHB2KMEI.SONOTA8, TBTHB2KMEI.SONOTA9,
                TBTHB2KMEI.SONOTA10, TBTHB2KMEI.BUNFLG, TBTHB2KMEI.MEIHNFLG,
                TBTHB2KMEI.NEBHNFLG
                };*/
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

        String baitai = "";	//媒体.
        String mstField1 = "";	//汎用マスタのFIELD1のキー

        // SQL.
        StringBuffer sql = new StringBuffer();

        // 指定した媒体をセット.
        baitai = _cond.getbaitai();

        //*********************************
        //チェックした媒体によって分岐
        //*********************************
        //新聞
        if (baitai.equals(C_BAITAI_SHINBUN)){
            mstField1 = C_HBAMST_F1_SHINBUN;
        }
        //雑誌
        else if(baitai.equals(C_BAITAI_ZASHI)){
            mstField1 = C_HBAMST_F1_ZASHI;
        }
        //電波
        else if(baitai.equals(C_BAITAI_DENPA)){
            mstField1 = C_HBAMST_F1_DENPA;
        }
        //交通
        else if(baitai.equals(C_BAITAI_KOTSU)){
            mstField1 = C_HBAMST_F1_KOTSU;
        }

        // 各媒体共通項目↓.
        sql.append(" SELECT ");
        sql.append("  " + TBTHB1DOWN.FIELD1 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD2 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD3 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD4 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD5 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD6 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD7 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD8 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD9 + " ");
        sql.append(" ," + TBTHB1DOWN.FIELD11 + " ");
        sql.append(" ," + TBTHB1DOWN.EGCD + " ");
        sql.append(" ," + TBTHB1DOWN.GYOMKBN + " ");
        sql.append(" ," + TBTHB1DOWN.KKNAMEKJ + " ");
        sql.append(" ," + TBTHB1DOWN.HIMKNMKJ + " ");
        sql.append(" ," + TBTHB1DOWN.TMSPKBN + " ");
        sql.append(" ," + TBTHB1DOWN.YYMM + " ");
        sql.append(" ," + TBTHB2KMEI.CODE1 + " ");
        sql.append(" ," + TBTHB2KMEI.CODE2 + " ");
        sql.append(" ," + TBTHB2KMEI.CODE3 + " ");
        sql.append(" ," + TBTHB2KMEI.CODE4 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME3 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME4 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME5 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME6 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME11 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME12 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME13 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME14 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME15 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME16 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME17 + " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA1 + " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA7 + " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA9 + " ");
        sql.append(" ," + TBTHB2KMEI.SEIGAK + " ");
        sql.append(" ," + TBTHB2KMEI.NEBIGAK + " ");
        sql.append(" ," + TBTHB2KMEI.RENBN + " ");
        sql.append(" ," + TBTHB2KMEI.KBN2 + " ");
        sql.append(" ," + TBTHB2KMEI.JYUTNO + " ");
        sql.append(" ," + TBTHB2KMEI.JYMEINO + " ");
        sql.append(" ," + TBTHB2KMEI.URMEINO + " ");
        //媒体：新聞
        if(baitai.equals(C_BAITAI_SHINBUN)){
            sql.append(" ," + "mast1.HBA_FIELD3" + " AS BASHO" + " ");	//場所
            sql.append(" ," + "mast2.HBA_FIELD3" + " AS SAIZU" + " ");	//サイズ
            sql.append(" ," + "mast3.HBA_FIELD3" + " AS KIZATSU" + " ");//記雑
            sql.append(" ," + "mast4.HBA_FIELD3" + " AS CHOYU" + " ");	//朝夕
            sql.append(" ," + "mast5.HBA_FIELD3" + " AS MEDIA" + " ");	//メディア
            sql.append(" ," + "mast6.HBA_FIELD3" + " AS IROZURI" + " ");//色刷
        }
        //媒体：雑誌
        else if(baitai.equals(C_BAITAI_ZASHI)){
            sql.append(" ," + "mast2.HBA_FIELD3" + " AS SAIZU" + " ");	//サイズ
            sql.append(" ," + "mast5.HBA_FIELD3" + " AS MEDIA" + " ");	//メディア
            sql.append(" ," + "mast6.HBA_FIELD3" + " AS IROZURI" + " ");//色刷
        }
        //媒体：電波
        else if(baitai.equals(C_BAITAI_DENPA)){
            sql.append(" ," + "mast5.HBA_FIELD1" + " ");
            sql.append(" ," + "mast5.HBA_FIELD2" + " ");
            sql.append(" ," + "mast5.HBA_FIELD3" + " AS MEDIA" + " ");	 //メディア
            sql.append(" ," + "mast5.HBA_FIELD4" + " AS MEDIARYA" + " ");//メディア(略)
            sql.append(" ," + "mast7.gyomKbn" + " "); 					//業務区分
            sql.append(" ," + "mast7.MEU29_KYCD" + " "); 				//
            sql.append(" ," + "mast7.MEU29_NAIYJ" + " ");				//名称
        }
        //媒体：交通
        else if(baitai.equals(C_BAITAI_KOTSU)){
            sql.append(" ," + "mast1.HBA_FIELD3" + " AS BASHO" + " ");	//場所
            sql.append(" ," + "mast5.HBA_FIELD3" + " AS MEDIA" + " "); 	//メディア
        }

        //*************************************************************************************************
        //SQL作成
        //*************************************************************************************************
        //sql.append(" ," + TBTHBAMST.FIELD3 + " " + "AS " + TBTHB1DOWN.FIELD2 + " ");	//名前を変更
        sql.append(" FROM ");
            //*************************************************************************************************
            //THB1DOWNテーブル
            //*************************************************************************************************
            sql.append(" /* THB1DOWN */");
            sql.append(" (SELECT ");
            sql.append("  " + TBTHB1DOWN.FIELD1);
            sql.append(" ," + TBTHB1DOWN.FIELD2);
            sql.append(" ," + TBTHB1DOWN.FIELD3);
            sql.append(" ," + TBTHB1DOWN.FIELD4);
            sql.append(" ," + TBTHB1DOWN.FIELD5);
            sql.append(" ," + TBTHB1DOWN.FIELD6);
            sql.append(" ," + TBTHB1DOWN.FIELD7);
            sql.append(" ," + TBTHB1DOWN.FIELD8);
            sql.append(" ," + TBTHB1DOWN.FIELD9);
            sql.append(" ," + TBTHB1DOWN.FIELD11);
            sql.append(" ," + TBTHB1DOWN.GYOMKBN);
            sql.append(" ," + TBTHB1DOWN.HIMKNMKJ);
            sql.append(" ," + TBTHB1DOWN.KKNAMEKJ);
            sql.append(" ," + TBTHB1DOWN.TMSPKBN);
            sql.append(" ," + TBTHB1DOWN.EGCD + " ");
            sql.append(" ," + TBTHB1DOWN.TKSKGYCD + " ");
            sql.append(" ," + TBTHB1DOWN.TKSBMNSEQNO + " ");
            sql.append(" ," + TBTHB1DOWN.TKSTNTSEQNO + " ");
            sql.append(" ," + TBTHB1DOWN.JYUTNO + " ");
            sql.append(" ," + TBTHB1DOWN.JYMEINO + " ");
            sql.append(" ," + TBTHB1DOWN.URMEINO + " ");
            sql.append(" ," + TBTHB1DOWN.YYMM + " ");
            sql.append(" ," + TBTHB1DOWN.TOUFLG + " ");
            sql.append(" FROM " );
            sql.append(TBTHB1DOWN.TBNAME + " thb1");
            sql.append(" WHERE ");
            sql.append("thb1." + TBTHB1DOWN.EGCD 		+ " = '" + _cond.getEgCd()  	  + "' AND ");
            sql.append("thb1." + TBTHB1DOWN.TKSKGYCD 	+ " = '" + _cond.getTksKgyCd()    + "' AND ");
            sql.append("thb1." + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("thb1." + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("thb1." + TBTHB1DOWN.YYMM 		+ " = '" + _cond.getYm()		  + "' AND ");
            sql.append("thb1." + TBTHB1DOWN.TOUFLG 		+ " <> '" + "1" + "' ");	//★可変
            sql.append(") thb1 ");

            //*************************************************************************************************
            //THB2KMEIテーブル
            //*************************************************************************************************
            sql.append(" /* THB2KMEI */");
            sql.append(" LEFT OUTER JOIN ");
            sql.append(" (SELECT");
            sql.append("  " + TBTHB2KMEI.CODE1 + " ");
            sql.append(" ," + TBTHB2KMEI.CODE2 + " ");
            sql.append(" ," + TBTHB2KMEI.CODE3 + " ");
            sql.append(" ," + TBTHB2KMEI.CODE4 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME3 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME4 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME5 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME6 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME11 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME12 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME13 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME14 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME15 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME16 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME17 + " ");
            sql.append(" ," + TBTHB2KMEI.SEIGAK + " ");
            sql.append(" ," + TBTHB2KMEI.NEBIGAK + " ");
            sql.append(" ," + TBTHB2KMEI.SONOTA1 + " ");
            sql.append(" ," + TBTHB2KMEI.SONOTA7 + " ");
            sql.append(" ," + TBTHB2KMEI.SONOTA9 + " ");
            sql.append(" ," + TBTHB2KMEI.EGCD + " ");
            sql.append(" ," + TBTHB2KMEI.TKSKGYCD + " ");
            sql.append(" ," + TBTHB2KMEI.TKSBMNSEQNO + " ");
            sql.append(" ," + TBTHB2KMEI.TKSTNTSEQNO + " ");
            sql.append(" ," + TBTHB2KMEI.JYUTNO + " ");
            sql.append(" ," + TBTHB2KMEI.JYMEINO + " ");
            sql.append(" ," + TBTHB2KMEI.URMEINO + " ");
            sql.append(" ," + TBTHB2KMEI.RENBN + " ");
            sql.append(" ," + TBTHB2KMEI.KBN2 + " ");
            sql.append(" ," + TBTHB2KMEI.YYMM + " ");
            sql.append(" FROM " );
            sql.append(TBTHB2KMEI.TBNAME + " thb2");
            sql.append(" WHERE ");
            sql.append("thb2." + TBTHB2KMEI.EGCD 		+ " = '" + _cond.getEgCd()  	  + "' AND ");
            sql.append("thb2." + TBTHB2KMEI.TKSKGYCD 	+ " = '" + _cond.getTksKgyCd()    + "' AND ");
            sql.append("thb2." + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append("thb2." + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append("thb2." + TBTHB2KMEI.YYMM 		+ " = '" + _cond.getYm()		  + "' AND ");
            sql.append("thb2." + TBTHB2KMEI.CODE1 		+ " = '" + baitai 				  + "' ");	//★可変
            //sql.append("thb2." + TBTHB2KMEI.NAME6 			+ " <> '" +  " 	+ "' ");
            sql.append(") thb2 ON ( ");
            sql.append(TBTHB1DOWN.EGCD 		  + " = " + TBTHB2KMEI.EGCD 	   + " AND ");
            sql.append(TBTHB1DOWN.TKSKGYCD 	  + " = " + TBTHB2KMEI.TKSKGYCD    + " AND ");
            sql.append(TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND ");
            sql.append(TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND ");
            sql.append(TBTHB1DOWN.YYMM 		  + " = " + TBTHB2KMEI.YYMM 	   + " AND ");
//			sql.append("TRIM(" + TBTHB1DOWN.JYUTNO  + ") = TRIM(" + TBTHB2KMEI.JYUTNO + ") AND ");
//			sql.append("TRIM(" + TBTHB1DOWN.JYMEINO + ") = TRIM(" + TBTHB2KMEI.JYMEINO + ") AND ");
//			sql.append("TRIM(" + TBTHB1DOWN.URMEINO + ") = TRIM(" + TBTHB2KMEI.URMEINO + ")" + ")");
            sql.append("TRIM(" + TBTHB1DOWN.JYUTNO  + ") = TRIM(" + TBTHB2KMEI.NAME3 + ") AND ");
            sql.append("TRIM(" + TBTHB1DOWN.JYMEINO + ") = TRIM(" + TBTHB2KMEI.NAME4 + ") AND ");
            sql.append("TRIM(" + TBTHB1DOWN.URMEINO + ") = TRIM(" + TBTHB2KMEI.NAME5 + ")" + ")");

        //*************************************************************************************************
        //掲載場所
        //*************************************************************************************************
        sql.append(" /* 掲載場所 */");
        //媒体：新聞・交通
        if (baitai.equals(C_BAITAI_SHINBUN) || baitai.equals(C_BAITAI_KOTSU)) {
            sql.append(" LEFT OUTER JOIN ");
            sql.append(" (SELECT");
            sql.append("  " + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 		 + " = '" + _cond.getEgCd()  	   + "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 	 + " = '" + _cond.getTksKgyCd()    + "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append(TBTHBAMST.SYBT 		 + " = '" + C_HBAMST_SYBT_KSAI	   + "' AND ");
            sql.append(TBTHBAMST.FIELD1 	 + " = '" + mstField1  + "'");	//★可変
            sql.append(") mast1 ON (");
            sql.append("TRIM(mast1." + TBTHBAMST.FIELD2 + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME11 + ")" + ")");
        }
        //*************************************************************************************************
        //サイズ
        //*************************************************************************************************
        sql.append(" /* サイズ */");
        //媒体：新聞
        if(baitai.equals(C_BAITAI_SHINBUN) || baitai.equals(C_BAITAI_ZASHI)){
            sql.append(" LEFT OUTER JOIN ");
            sql.append(" (SELECT");
            sql.append("  " + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 		 + " = '" + _cond.getEgCd()  	   + "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 	 + " = '" + _cond.getTksKgyCd()    + "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append(TBTHBAMST.SYBT 		 + " = '" + C_HBAMST_SYBT_SIZE	   + "' AND ");
            sql.append(TBTHBAMST.FIELD1 	 + " = '" + mstField1  + "'");	//★可変
            sql.append(") mast2 ON (");
//			sql.append("TRIM(mast2." + TBTHBAMST.FIELD2 + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME15 + ")" + ")");
            //媒体：新聞
            if(baitai.equals(C_BAITAI_SHINBUN)){
                sql.append("TRIM(mast2." + TBTHBAMST.FIELD2  + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME15 + ")" + ")");
            }
            //媒体：雑誌
            else if(baitai.equals(C_BAITAI_ZASHI)){
                sql.append("TRIM(mast2." + TBTHBAMST.FIELD2  + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME12 + ")" + ")");
            }
        }
        //*************************************************************************************************
        //記雑
        //*************************************************************************************************
        sql.append(" /* 記雑 */");
        //媒体：新聞
        if(baitai.equals(C_BAITAI_SHINBUN)){
            sql.append(" LEFT OUTER JOIN ");
            sql.append(" (SELECT");
            sql.append("  " + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 		 + " = '" + _cond.getEgCd()		   + "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 	 + " = '" + _cond.getTksKgyCd()    + "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append(TBTHBAMST.SYBT 		 + " = '" + C_HBAMST_SYBT_KZA 	   + "' AND ");
            sql.append(TBTHBAMST.FIELD1 	 + " = '" + mstField1 + "'");	//★可変
            sql.append(") mast3 ON (");
            sql.append("TRIM(mast3." + TBTHBAMST.FIELD2 + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME12 + ")" + ")");
        }
        //*************************************************************************************************
        //朝夕
        //*************************************************************************************************
        sql.append(" /* 朝夕 */");
        //媒体：新聞
        if(baitai.equals(C_BAITAI_SHINBUN)){
            sql.append(" LEFT OUTER JOIN ");
            sql.append(" (SELECT");
            sql.append("  " + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 		 + " = '" + _cond.getEgCd()  	   + "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 	 + " = '" + _cond.getTksKgyCd()    + "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append(TBTHBAMST.SYBT 		 + " = '" + C_HBAMST_SYBT_CHOYU	   + "' AND ");
            sql.append("TRIM(" + TBTHBAMST.FIELD1 + ") = '" + mstField1 + "'");	//★可変
            sql.append(") mast4 ON (");
            sql.append("TRIM(mast4." + TBTHBAMST.FIELD2 + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME13 + ")" + ")");
        }
        //*************************************************************************************************
        //業務区分
        //*************************************************************************************************
        sql.append(" /* 業務区分 */");
        //電波
        if (baitai.equals(C_BAITAI_DENPA)){
            sql.append(" LEFT OUTER JOIN ");
            sql.append(" (SELECT");
            sql.append("  " + TBRCMN_MEU29CC.MEU29_KYCD 	+ " , " );
            sql.append("  " + " CASE "+ TBRCMN_MEU29CC.MEU29_KYCD );
            sql.append(" 		 WHEN '" + C_GYOM_CD_TVTIME + "' THEN '" + C_HBAMST_F1_TV + "' ");	//テレビタイム→テレビ
            sql.append(" 		 WHEN '" + C_GYOM_CD_TVSPOT + "' THEN '" + C_HBAMST_F1_TV + "' ");	//TVスポット→テレビ
            sql.append(" 		 WHEN '" + C_GYOM_CD_RADIO  + "' THEN '" + C_HBAMST_F1_RADIO + "' ");	//ラジオ→ラジオ
            sql.append(" 		 WHEN '" + C_GYOM_CD_EISEI  + "' THEN '" + C_HBAMST_F1_EISEI + "' ");	//衛生メディア→衛星
            sql.append(" 		END " + " AS gyomKbn"		+ " , " );
            sql.append("  " + TBRCMN_MEU29CC.MEU29_NAIYJ );
            sql.append(" FROM " );
            sql.append(TBRCMN_MEU29CC.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBRCMN_MEU29CC.MEU29_KYCDKND	+ " = "  + "'87'" + " AND ");
            sql.append(TBRCMN_MEU29CC.MEU29_HKYMD	+ " <= " + "to_Char(sysdate,'yyyymmdd')" + " AND ");
            sql.append(TBRCMN_MEU29CC.MEU29_HAISYMD	+ " >= " + "to_Char(sysdate,'yyyymmdd')");
            sql.append(") mast7 ON (");
            sql.append("TRIM(thb1." + TBTHB1DOWN.GYOMKBN + ") = " + "TRIM(mast7." + TBRCMN_MEU29CC.MEU29_KYCD + ")" + ")");
        }
        //*************************************************************************************************
        //メディア
        //*************************************************************************************************
        sql.append(" /* メディア */");
        sql.append(" LEFT OUTER JOIN ");
        sql.append(" (SELECT");
        sql.append("  " + TBTHBAMST.FIELD1 );
        sql.append(" ," + TBTHBAMST.FIELD2 );
        sql.append(" ," + TBTHBAMST.FIELD3 );
        sql.append(" ," + TBTHBAMST.FIELD4 );	//メディア(略)
        sql.append(" FROM " );
        sql.append(TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append(TBTHBAMST.EGCD		 + " = '" + _cond.getEgCd()  		+ "' AND ");
        sql.append(TBTHBAMST.TKSKGYCD 	 + " = '" + _cond.getTksKgyCd()  	+ "' AND ");
        sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() 	+ "' AND ");
        sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo()	+ "' AND ");
        sql.append(TBTHBAMST.SYBT 		 + " = '" + C_HBAMST_SYBT_MEDIA + "'  ");
        sql.append(") mast5 ON (");
        //sql.append("mast5."+ TBTHBAMST.FIELD1 + " = " + mstField1	+ " AND ");	//★可変;
        sql.append(" TRIM(mast5." + TBTHBAMST.FIELD2  + ") = " + "TRIM(thb2." + TBTHB2KMEI.CODE2 + ")" + " AND ");
        //電波
        if (baitai.equals(C_BAITAI_DENPA)){
            sql.append("TRIM(" + "mast5."+ TBTHBAMST.FIELD1 + ") = " + mstField1 + " " + ")");	//★可変;
        }
        else{
            sql.append("TRIM(" + "mast5."+ TBTHBAMST.FIELD1 + ") = '" + mstField1 + "'" + ")");	//★可変
        }
/*		//新聞 か 雑誌
        if (baitai.equals(C_BAITAI_SHINBUN) || baitai.equals(C_BAITAI_ZASHI) ){
            sql.append("mast5."+ THBAMST.FIELD1 + " = '" + mstField1	+ "' AND ");	//★可変
        }
        //電波
        else if (baitai.equals(C_BAITAI_DENPA)){
            sql.append("mast5."+ THBAMST.FIELD1 + " = " + mstField1	+ " AND ");	//★可変;
        }
        //★交通
        else if (baitai.equals(C_BAITAI_KOTSU)){
            sql.append("mast5."+ THBAMST.FIELD1 + " = " + mstField1	+ " AND ");	//★可変;
        }
*/
        //*************************************************************************************************
        //色刷
        //*************************************************************************************************
        sql.append(" /* 色刷 */");
        //媒体：新聞 か 雑誌
        if(baitai.equals(C_BAITAI_SHINBUN) || baitai.equals(C_BAITAI_ZASHI)){
            sql.append(" LEFT OUTER JOIN ");
            sql.append(" (SELECT");
            sql.append("  " + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 		 + " = '" + _cond.getEgCd()		   + "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 	 + " = '" + _cond.getTksKgyCd()    + "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
            sql.append(TBTHBAMST.SYBT 		 + " = '" + C_HBAMST_SYBT_IRO	   + "' AND ");
            sql.append("TRIM(" + TBTHBAMST.FIELD1 + ") = '" + mstField1 + "'");	//★可変
            sql.append(") mast6 ON (");
//			sql.append("TRIM(mast6." + TBTHBAMST.FIELD2  + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME14 + ")" + ")");
            //媒体：新聞
            if(baitai.equals(C_BAITAI_SHINBUN)){
                sql.append("TRIM(mast6." + TBTHBAMST.FIELD2  + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME14 + ")" + ")");
            }
            //媒体：雑誌
            else if(baitai.equals(C_BAITAI_ZASHI)){
                sql.append("TRIM(mast6." + TBTHBAMST.FIELD2  + ") = " + "TRIM(thb2." + TBTHB2KMEI.NAME11 + ")" + ")");
            }
        }
        //*************************************************************************************************
        //WHERE句
        //*************************************************************************************************
        sql.append(" WHERE ");
        sql.append(TBTHB1DOWN.EGCD 		  + " = '" + _cond.getEgCd()		+ "' AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD 	  + " = '" + _cond.getTksKgyCd()    + "' AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(TBTHB1DOWN.YYMM 		  + " = '" + _cond.getYm() 			+ "' AND ");
        sql.append(TBTHB1DOWN.TOUFLG 	  + " <> '" + "1" 					+ "' AND ");
        sql.append("TRIM(" + TBTHB2KMEI.CODE1 + ") = '" + baitai + "'");
        //*************************************************************************************************
        //ORDER BY句
        //*************************************************************************************************
        sql.append(" ORDER BY ");
        sql.append(TBTHB2KMEI.SONOTA1 + ", ");
        sql.append(TBTHB2KMEI.CODE3   + ", ");
        sql.append(TBTHB2KMEI.KBN2 	  + ", ");
        sql.append(TBTHB2KMEI.CODE2   + ", ");
        sql.append(TBTHB2KMEI.CODE4   + ", ");
        sql.append(TBTHB2KMEI.NAME6   + ", ");
        sql.append(TBTHB1DOWN.JYUTNO  + ", ");
        sql.append(TBTHB1DOWN.JYMEINO + ", ");
        sql.append(TBTHB1DOWN.URMEINO);

        return sql.toString();
    }

    /**
     * 帳票データ(アコム)の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportAcomVO> findReportAcomByCondition(ReportAcomCondition cond)
            throws KKHException {

        super.setModel(new ReportAcomVO());

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
    protected List<ReportAcomVO> createFindedModelInstances(List hashList) {
        List<ReportAcomVO> list = new ArrayList<ReportAcomVO>();
        if (getModel() instanceof ReportAcomVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ReportAcomVO vo = new ReportAcomVO();
                vo.setName3((String) result.get(TBTHB2KMEI.NAME3.toUpperCase()));			//受注No
                vo.setName4((String) result.get(TBTHB2KMEI.NAME4.toUpperCase()));			//受注明細No
                vo.setName5((String) result.get(TBTHB2KMEI.NAME5.toUpperCase()));			//売上明細No
                vo.setName6((String) result.get(TBTHB2KMEI.NAME6.toUpperCase()));			//請求原票No
                vo.setName11((String) result.get(TBTHB2KMEI.NAME11.toUpperCase()));			//★
                vo.setName12((String) result.get(TBTHB2KMEI.NAME12.toUpperCase()));			//★
                vo.setName13((String) result.get(TBTHB2KMEI.NAME13.toUpperCase()));			//備考１(雑誌)
                vo.setName14((String) result.get(TBTHB2KMEI.NAME14.toUpperCase()));			//備考２(雑誌)
                vo.setName15((String) result.get(TBTHB2KMEI.NAME15.toUpperCase()));			//
                vo.setName16((String) result.get(TBTHB2KMEI.NAME16.toUpperCase()));			//備考１(新聞)
                vo.setName17((String) result.get(TBTHB2KMEI.NAME17.toUpperCase()));			//備考２(新聞)
                vo.setCode2((String) result.get(TBTHB2KMEI.CODE2.toUpperCase()));			//１行目
                vo.setCode3((String) result.get(TBTHB2KMEI.CODE3.toUpperCase()));			//発注番号
                vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase()));			//発注行番号
                vo.setSonota1((String) result.get(TBTHB2KMEI.SONOTA1.toUpperCase()));		//
                vo.setSonota7((String) result.get(TBTHB2KMEI.SONOTA7.toUpperCase()));		//新聞、雑誌：単価、金額
                vo.setSonota9((String) result.get(TBTHB2KMEI.SONOTA9.toUpperCase()));		//
                vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));		//金額
                vo.setNebigak((BigDecimal) result.get(TBTHB2KMEI.NEBIGAK.toUpperCase()));	//値引額
                vo.setJyutNo((String) result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));			//受注No
                vo.setJyMeiNo((String) result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));		//受注明細No
                vo.setUrMeiNo((String) result.get(TBTHB2KMEI.URMEINO.toUpperCase()));		//売上明細No
                vo.setRenbn((String) result.get(TBTHB2KMEI.RENBN.toUpperCase()));
                vo.setKbn2((String) result.get(TBTHB2KMEI.KBN2.toUpperCase()));			//値引区分(1:値引行)
                vo.setYymm((String) result.get(TBTHB1DOWN.YYMM.toUpperCase()));			//放送局略名（新聞：スペース）
                vo.setField1((String) result.get(TBTHB1DOWN.FIELD1.toUpperCase()));			//放送局略名（新聞：スペース）
                vo.setField2((String) result.get(TBTHB1DOWN.FIELD2.toUpperCase()));			//放送局名(新聞：新聞名 )
                vo.setField3((String) result.get(TBTHB1DOWN.FIELD3.toUpperCase()));			//ネット局数or放送局数（新聞：掲載日）
                vo.setField4((String) result.get(TBTHB1DOWN.FIELD4.toUpperCase()));			//放送時間（新聞：朝夕）
                vo.setField5((String) result.get(TBTHB1DOWN.FIELD5.toUpperCase()));			//秒数
                vo.setField6((String) result.get(TBTHB1DOWN.FIELD6.toUpperCase()));			//回数or本数（掲載版）
                vo.setField7((String) result.get(TBTHB1DOWN.FIELD7.toUpperCase()));			//
                vo.setField8((String) result.get(TBTHB1DOWN.FIELD8.toUpperCase()));			//放送期間（記雑区分）
                vo.setField9((String) result.get(TBTHB1DOWN.FIELD9.toUpperCase()));			//
                vo.setField11((String) result.get(TBTHB1DOWN.FIELD11.toUpperCase()));		//
                vo.setKkNameKj((String) result.get(TBTHB1DOWN.KKNAMEKJ.toUpperCase()));		//件名
                vo.setHimknmkj((String) result.get(TBTHB1DOWN.HIMKNMKJ.toUpperCase()));		//費目名
                vo.setTmspkbn((String) result.get(TBTHB1DOWN.TMSPKBN.toUpperCase()));		//タイムスポット区分
                vo.setGyomkbn((String) result.get(TBTHB1DOWN.GYOMKBN.toUpperCase()));		//業務区分
                vo.setGyomKbnMei((String) result.get(TBRCMN_MEU29CC.MEU29_NAIYJ.toUpperCase()));		//業務区分名称
                vo.setBasho((String) result.get(ReportAcomVO.BASHO.toUpperCase()));				//場所
                vo.setSaizu((String) result.get(ReportAcomVO.SAIZU.toUpperCase()));				//サイズ
                vo.setKizatsu((String) result.get(ReportAcomVO.KIZATSU.toUpperCase()));			//記雑
                vo.setChoyu((String) result.get(ReportAcomVO.CHOYU.toUpperCase()));				//朝夕
                vo.setMedia((String) result.get(ReportAcomVO.MEDIA.toUpperCase()));				//メディア
                vo.setMediaRya((String) result.get(ReportAcomVO.MEDIARYA.toUpperCase()));		//メディア(略)
                vo.setIrozuri((String) result.get(ReportAcomVO.IROZURI.toUpperCase()));			//色刷

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }
}
