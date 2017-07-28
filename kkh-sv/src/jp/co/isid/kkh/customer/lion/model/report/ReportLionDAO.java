package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU29CC;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionVO;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * 帳票（Lion)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/11)<BR>
 * </P>
 *
 * @author
 */

public class ReportLionDAO extends AbstractRdbDao {

    /** 汎用マスタ検索条件 */
    private ReportLionCondition _cond;

    /** 汎用マスタ：媒体区分：テレビタイム */
    public static final String C_BAITAI_TV_TIME = "テレビタイム";

    /** 汎用マスタ：媒体区分：ラジオタイム */
    private static final String C_BAITAI_RD_TIME = "ラジオタイム";

    /** 汎用マスタ：媒体区分：テレビスポット */
    private static final String C_BAITAI_TV_SPOT = "テレビスポット";

    /** 汎用マスタ：媒体区分：ラジオスポット */
    private static final String C_BAITAI_RD_SPOT = "ラジオスポット";

    /** 汎用マスタ：媒体種別：ブランドマスタ */
    public static final String C_HBAMST_SYBT_BRAND = "201";

    /** 汎用マスタ：媒体種別：テレビ局マスタ */
    public static final String C_HBAMST_SYBT_TV_KYOKU = "401";

    /** 汎用マスタ：媒体種別：ラジオ局マスタ */
    public static final String C_HBAMST_SYBT_RD_KYOKU = "402";

    /** 汎用マスタ：媒体種別：テレビ番組マスタ */
    public static final String C_HBAMST_SYBT_TV_BANGUMI = "601";

    /** 汎用マスタ：媒体種別：テレビ番組マスタ */
    public static final String C_HBAMST_SYBT_RD_BANGUMI = "602";

    /** 汎用マスタ：媒体区分：電波 */
    public static final String C_BAITAI_DENPA = "11";

    /** 汎用マスタ：媒体種別：新聞 */
    public static final String C_HBAMST_F1_SHINBUN = "02";

    /** 汎用マスタ：媒体種別：雑誌 */
    public static final String C_HBAMST_F1_ZASHI = "03";

    /** 汎用マスタ：媒体種別：電波 */
    public static final String C_HBAMST_F1_DENPA = "mast7.gyomKbn";

    /** 汎用マスタ：媒体種別：テレビ */
    public static final String C_HBAMST_F1_TV = "04";

    /** 汎用マスタ：媒体種別：ラジオ */
    public static final String C_HBAMST_F1_RD = "05";

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
    public static final String C_GYOM_CD_RD = "11030";

    /** 業務区分マスタ：コード：テレビタイム */
    public static final String C_GYOM_CD_TVTIME = "11040";

    /** 業務区分マスタ：コード：テレビスポット */
    public static final String C_GYOM_CD_TVSPOT = "11045";

    /** 業務区分マスタ：コード：衛星メディア */
    public static final String C_GYOM_CD_EISEI = "11050";

    /** getSelectSQLで発行するSQLのモード() */
//	private enum SqlMode {
//		KIND, ITEM,
//	};

    //private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * デフォルトコンストラクタ。
     */
    public ReportLionDAO() {
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
        return getSelectSQLForItem();
    }

    private String getSelectSQLForItem() {

        String _baitai = "";	//媒体.

        // SQL.
        StringBuffer sql = new StringBuffer();

        // 指定した媒体をセット.
        _baitai = _cond.getbaitai();

        //*********************************
        //指定した媒体によって分岐
        //*********************************
        //テレビタイム
        if (_baitai.equals(C_BAITAI_TV_TIME)){
        }

/*		//*********************************
        //チェックした媒体によって分岐
        //*********************************
        //新聞
        if (_baitai.equals(C_BAITAI_SHINBUN)){
            _mstField1 = C_HBAMST_F1_SHINBUN;
        }
        //雑誌
        else if(_baitai.equals(C_BAITAI_ZASHI)){
            _mstField1 = C_HBAMST_F1_ZASHI;
        }
        //電波
        else if(_baitai.equals(C_BAITAI_DENPA)){
            _mstField1 = C_HBAMST_F1_DENPA;
        }
        //交通
        else if(_baitai.equals(C_BAITAI_KOTSU)){
            _mstField1 = C_HBAMST_F1_KOTSU;
        }*/

        // 各媒体共通項目↓.
        sql.append(" SELECT ");
/*		sql.append("  " + TBTHB1DOWN.FIELD1 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD2 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD3 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD4 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD5 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD6 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD7 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD8 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD9 	+ " ");
        sql.append(" ," + TBTHB1DOWN.FIELD11 	+ " ");
        sql.append(" ," + TBTHB1DOWN.EGCD 		+ " ");
        sql.append(" ," + TBTHB1DOWN.GYOMKBN 	+ " ");
        sql.append(" ," + TBTHB1DOWN.KKNAMEKJ 	+ " ");
        sql.append(" ," + TBTHB1DOWN.HIMKNMKJ 	+ " ");
        sql.append(" ," + TBTHB1DOWN.TMSPKBN 	+ " ");
        sql.append(" ," + TBTHB1DOWN.YYMM	 	+ " ");*/
        sql.append("  " + TBTHB2KMEI.YYMM		+ " ");
        sql.append(" ," + TBTHB2KMEI.CODE1		+ " ");
        sql.append(" ," + TBTHB2KMEI.CODE2 		+ " ");
        sql.append(" ," + TBTHB2KMEI.CODE3 		+ " ");
        sql.append(" ," + TBTHB2KMEI.CODE4 		+ " ");
        sql.append(" ," + TBTHB2KMEI.CODE5 		+ " ");
        sql.append(" ," + TBTHB2KMEI.CODE6 		+ " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA5 	+ " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA7 	+ " ");
/*		sql.append(" , TRIM(" + TBTHB2KMEI.CODE1	+ ") ");
        sql.append(" , TRIM(" + TBTHB2KMEI.CODE2 	+ ") ");
        sql.append(" , TRIM(" + TBTHB2KMEI.CODE3 	+ ") ");
        sql.append(" , TRIM(" + TBTHB2KMEI.CODE4 	+ ") ");
        sql.append(" , TRIM(" + TBTHB2KMEI.CODE5 	+ ") ");
        sql.append(" , TRIM(" + TBTHB2KMEI.CODE6 	+ ") ");
        sql.append(" , TRIM(" + TBTHB2KMEI.SONOTA5 	+ ") ");*/
        sql.append(" ," + TBTHB2KMEI.KNGK2 		+ " ");
        sql.append(" ," + TBTHB2KMEI.KNGK3 		+ " ");
        sql.append(" ," + TBTHB2KMEI.SEIGAK 	+ " ");
        sql.append(" ," + TBTHB2KMEI.NEBIGAK 	+ " ");
        sql.append(" ," + TBTHB2KMEI.RITU1 		+ " ");	//消費税率
        sql.append(" ," + "TRUNC("
                        + "DECODE(TRIM(" + TBTHB2KMEI.SEIGAK + ") , NULL , 0 , " + TBTHB2KMEI.SEIGAK  + ")"
                        + " * "
                        + "DECODE(TRIM(" + TBTHB2KMEI.RITU1  + ") , NULL , 5 , " + TBTHB2KMEI.RITU1   + ")"
                        + "/ 100  )"
                        +  "AS SHOHIZEI_GAK " 	+ " ");	//消費税額
        sql.append(" ," + TBTHB2KMEI.NAME1 		+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME2 		+ " ");
//		sql.append(" ," + TBTHB2KMEI.NAME3 		+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME4 		+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME5 		+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME6 		+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME7 		+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME8 		+ " ");
/*		sql.append(" ," + TBTHB2KMEI.NAME11 	+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME12 	+ " ");
        sql.append(" ,to_single_byte(" + TBTHB2KMEI.NAME13 	+ ") AS " + TBTHB2KMEI.NAME13  + " ");	// 半角に変換
        sql.append(" ," + TBTHB2KMEI.NAME14 	+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME15 	+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME16 	+ " ");
        sql.append(" ," + TBTHB2KMEI.NAME17 	+ " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA1 	+ " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA7 	+ " ");
        sql.append(" ," + TBTHB2KMEI.SONOTA9 	+ " ");
        sql.append(" ," + TBTHB2KMEI.RENBN 		+ " ");
        sql.append(" ," + TBTHB2KMEI.KBN2 		+ " ");
        sql.append(" ," + TBTHB2KMEI.JYUTNO 	+ " ");
        sql.append(" ," + TBTHB2KMEI.JYMEINO 	+ " ");
        sql.append(" ," + TBTHB2KMEI.URMEINO 	+ " ");*/
        //媒体：テレビタイム、ラジオタイム、テレビスポット
        if(_baitai.equals(C_BAITAI_TV_TIME) || _baitai.equals(C_BAITAI_RD_TIME) || _baitai.equals(C_BAITAI_TV_SPOT) || _baitai.equals(C_BAITAI_RD_SPOT)){
            sql.append(" ," + "mast3.HBA_FIELD1" 	+ " AS " + ReportLionVO.KYOKU_CD	+ " ");		//局コード
            sql.append(" ," + "mast3.HBA_FIELD2" 	+ " AS " + ReportLionVO.KYOKU_MEI	+ " ");		//局名
        }

        //媒体：テレビタイム、ラジオタイム
        if(_baitai.equals(C_BAITAI_TV_TIME) || _baitai.equals(C_BAITAI_RD_TIME)){
            sql.append(" ," + "mast1.HBA_FIELD1" 	+ " AS "+ ReportLionVO.BANGUMI_CD	+ " ");		//番組コード
            sql.append(" ," + "mast1.HBA_FIELD2" 	+ " AS "+ ReportLionVO.BANGUMI_MEI	+ " ");		//番組名
        }

        //媒体：テレビスポット、ラジオスポット
        if(_baitai.equals(C_BAITAI_TV_SPOT) || _baitai.equals(C_BAITAI_RD_SPOT)){
            sql.append(" ," + "mast5.HBA_FIELD1" 	+ " AS " + ReportLionVO.BRAND_CD	+ " ");		//ブランドコード
            sql.append(" ," + "mast5.HBA_FIELD2" 	+ " AS " + ReportLionVO.BRAND_MEI	+ " ");		//ブランド名
            sql.append(" ," + "DECODE(TRIM(" + TBTHB2KMEI.SONOTA5 + ") , NULL , 0 , " + TBTHB2KMEI.SONOTA5 +  ")"
                            + " * "
                            + "DECODE(TRIM(" + TBTHB2KMEI.SONOTA7 + ") , NULL , 0 , " + TBTHB2KMEI.SONOTA7 +  ")"
                            + "  AS BYOSU_GOKEI " + " ");	//回数 * CM1本秒数
        }

        /*		//媒体：新聞
        if(_baitai.equals(C_BAITAI_SHINBUN)){
            sql.append(" ," + "mast1.HBA_FIELD3" 	+ " AS BASHO"	+ " ");	//場所
            sql.append(" ," + "mast5.HBA_FIELD3" 	+ " AS SAIZU"	+ " ");	//サイズ
            sql.append(" ," + "mast3.HBA_FIELD3" 	+ " AS KIZATSU"	+ " ");	//記雑
            sql.append(" ," + "mast3.HBA_FIELD3" 	+ " AS CHOYU"	+ " ");	//朝夕
            sql.append(" ," + "mast5.HBA_FIELD3" 	+ " AS MEDIA"	+ " ");	//メディア
            sql.append(" ," + "mast1.HBA_FIELD3" 	+ " AS IROZURI"	+ " ");	//色刷
        }
        //媒体：雑誌
        else if(_baitai.equals(C_BAITAI_ZASHI)){
            sql.append(" ," + "mast5.HBA_FIELD3" 	+ " AS SAIZU"	+ " ");	//サイズ
            sql.append(" ," + "mast5.HBA_FIELD3" 	+ " AS MEDIA"	+ " ");	//メディア
            sql.append(" ," + "mast1.HBA_FIELD3" 	+ " AS IROZURI"	+ " ");	//色刷
        }
        //媒体：電波
        else if(_baitai.equals(C_BAITAI_DENPA)){
            sql.append(" ," + "mast5.HBA_FIELD1"	+ " ");
            sql.append(" ," + "mast5.HBA_FIELD2" 	+ " ");
            sql.append(" ," + "mast5.HBA_FIELD3" 	+ " AS MEDIA"	+ " ");		//メディア
            sql.append(" ," + "mast5.HBA_FIELD4" 	+ " AS MEDIARYA"	+ " ");	//メディア(略)
            sql.append(" ," + "mast7.gyomKbn"	+ " ");			//業務区分
            sql.append(" ," + "mast7.MEU29_KYCD"	+ " ");		//業務区分
            sql.append(" ," + "mast7.MEU29_NAIYJ"	+ " ");		//業務区分名称
        }
        //媒体：交通
        else if(_baitai.equals(C_BAITAI_KOTSU)){
            sql.append(" ," + "mast5.HBA_FIELD3" 	+ " AS MEDIA"	+ " ");	//メディア
        }*/

        //*************************************************************************************************
        //FROM
        //*************************************************************************************************
        //sql.append(" ," + TBTHBAMST.FIELD3 + " " + "AS " + TBTHB1DOWN.FIELD2 + " ");	//名前を変更
        sql.append(" FROM ");
        sql.append(TBTHB1DOWN.TBNAME + " thb1" + " , ");
        sql.append(TBTHB2KMEI.TBNAME + " thb2" + "   ");

        //*************************************************************************************************
        //番組マスタ
        //*************************************************************************************************
        //媒体：テレビタイム、ラジオタイム
        if(_baitai.equals(C_BAITAI_TV_TIME) || _baitai.equals(C_BAITAI_RD_TIME)){
            sql.append("  (SELECT");
            sql.append("  " + TBTHBAMST.FIELD1);
            sql.append(" ," + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" ," + TBTHBAMST.FIELD4 );
            sql.append(" ," + TBTHBAMST.FIELD5 );
            sql.append(" ," + TBTHBAMST.FIELD6 );
            sql.append(" ," + TBTHBAMST.INTVALUE6 );
            sql.append(" ," + TBTHBAMST.TKSKGYCD );
            sql.append(" ," + TBTHBAMST.TKSBMNSEQNO );
            sql.append(" ," + TBTHBAMST.TKSTNTSEQNO );
            sql.append(" ," + TBTHBAMST.SYBT);
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 			+ " = '" + _cond.getEgCd()  		+ "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 		+ " = '" + _cond.getTksKgyCd()  	+ "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO 	+ " = '" + _cond.getTksBmnSeqNo() 		+ "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO 	+ " = '" + _cond.getTksTntSeqNo() 		+ "' AND ");
            //媒体：テレビタイム
            if(_baitai.equals(C_BAITAI_TV_TIME)){
                sql.append(TBTHBAMST.SYBT 			+ " = '" + C_HBAMST_SYBT_TV_BANGUMI	+ "'     ");	//テレビ番組マスタ
            }
            //媒体：ラジオタイム
            else if(_baitai.equals(C_BAITAI_RD_TIME)){
                sql.append(TBTHBAMST.SYBT 			+ " = '" + C_HBAMST_SYBT_RD_BANGUMI	+ "'     ");	//ラジオ番組マスタ
            }
            sql.append(") mast1"	+	" , ");
        }
        //*************************************************************************************************
        //局マスタ
        //*************************************************************************************************
        //媒体：テレビタイム、ラジオタイム、テレビスポット、ラジオスポット
        if(_baitai.equals(C_BAITAI_TV_TIME) || _baitai.equals(C_BAITAI_RD_TIME) || _baitai.equals(C_BAITAI_TV_SPOT) || _baitai.equals(C_BAITAI_RD_SPOT)){
            sql.append("  ( SELECT");
            sql.append("  " + TBTHBAMST.FIELD1);
            sql.append(" ," + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" ," + TBTHBAMST.FIELD4 );
            sql.append(" ," + TBTHBAMST.FIELD5 );
            sql.append(" ," + TBTHBAMST.FIELD6 );
            sql.append(" ," + TBTHBAMST.TKSKGYCD );
            sql.append(" ," + TBTHBAMST.TKSBMNSEQNO );
            sql.append(" ," + TBTHBAMST.TKSTNTSEQNO );
            sql.append(" ," + TBTHBAMST.SYBT);
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 			+ " = '" + _cond.getEgCd()  		+ "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 		+ " = '" + _cond.getTksKgyCd()  	+ "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO 	+ " = '" + _cond.getTksBmnSeqNo() 		+ "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO 	+ " = '" + _cond.getTksTntSeqNo() 		+ "' AND ");
            //媒体：テレビタイム、テレビスポット
            if(_baitai.equals(C_BAITAI_TV_TIME) || _baitai.equals(C_BAITAI_TV_SPOT)){
                sql.append(TBTHBAMST.SYBT 			+ " = '" + C_HBAMST_SYBT_TV_KYOKU	+ "'     ");	//テレビ局マスタ
            }
            //媒体：ラジオタイム、ラジオスポット
            else if(_baitai.equals(C_BAITAI_RD_TIME) || _baitai.equals(C_BAITAI_RD_SPOT)){
                sql.append(TBTHBAMST.SYBT 			+ " = '" + C_HBAMST_SYBT_RD_KYOKU	+ "'     ");	//ラジオ局マスタ
            }
        sql.append(") mast3 "	+	" , ");
        }

        //*************************************************************************************************
        //ブランドマスタ
        //*************************************************************************************************
        //媒体：テレビスポット
        if(_baitai.equals(C_BAITAI_TV_SPOT) || _baitai.equals(C_BAITAI_RD_SPOT)){
            sql.append(" ( SELECT");
            sql.append("  " + TBTHBAMST.FIELD1);
            sql.append(" ," + TBTHBAMST.FIELD2 );
            sql.append(" ," + TBTHBAMST.FIELD3 );
            sql.append(" ," + TBTHBAMST.FIELD4 );
            sql.append(" ," + TBTHBAMST.FIELD5 );
            sql.append(" ," + TBTHBAMST.FIELD6 );
            sql.append(" ," + TBTHBAMST.TKSKGYCD );
            sql.append(" ," + TBTHBAMST.TKSBMNSEQNO );
            sql.append(" ," + TBTHBAMST.TKSTNTSEQNO );
            sql.append(" ," + TBTHBAMST.SYBT);
            sql.append(" FROM " );
            sql.append(TBTHBAMST.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD 			+ " = '" + _cond.getEgCd()  		+ "' AND ");
            sql.append(TBTHBAMST.TKSKGYCD 		+ " = '" + _cond.getTksKgyCd()  	+ "' AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO 	+ " = '" + _cond.getTksBmnSeqNo() 		+ "' AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO 	+ " = '" + _cond.getTksTntSeqNo() 		+ "' AND ");
            sql.append(TBTHBAMST.SYBT 			+ " = '" + C_HBAMST_SYBT_BRAND		+ "'     ");	//ブランドマスタ
/*			//媒体：テレビスポット
            if(_baitai.equals(C_BAITAI_TV_SPOT)){
                sql.append(TBTHBAMST.SYBT 			+ " = '" + C_HBAMST_SYBT_BRAND	+ "'     ");	//ブランドマスタ
            }
*/		sql.append(") mast5 "	+	" , ");
        }
        //*************************************************************************************************
        //WHERE句
        //*************************************************************************************************
        sql.append(" WHERE ");
        sql.append(TBTHB1DOWN.EGCD 			+ " = '" + _cond.getEgCd() 			+ "' AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD 		+ " = '" + _cond.getTksKgyCd() 		+ "' AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO 	+ " = '" + _cond.getTksBmnSeqNo() 		+ "' AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO 	+ " = '" + _cond.getTksTntSeqNo() 		+ "' AND ");
        sql.append(TBTHB1DOWN.YYMM 			+ " = '" + _cond.getYm() 			+ "' AND ");

        sql.append(TBTHB1DOWN.EGCD 			+ " = " + TBTHB2KMEI.EGCD  			+ "  AND ");
        sql.append(TBTHB1DOWN.TKSKGYCD 		+ " = " + TBTHB2KMEI.TKSKGYCD 		+ "  AND ");
        sql.append(TBTHB1DOWN.TKSBMNSEQNO 	+ " = " + TBTHB2KMEI.TKSBMNSEQNO 	+ "  AND ");
        sql.append(TBTHB1DOWN.TKSTNTSEQNO 	+ " = " + TBTHB2KMEI.TKSTNTSEQNO 	+ "  AND ");
        sql.append(TBTHB1DOWN.YYMM 			+ " = " + TBTHB2KMEI.YYMM 			+ "  AND ");

        sql.append(TBTHB1DOWN.JYUTNO 		+ " = " + TBTHB2KMEI.JYUTNO  		+ "  AND ");
        sql.append(TBTHB1DOWN.JYMEINO 		+ " = " + TBTHB2KMEI.JYMEINO 		+ "  AND ");
        sql.append(TBTHB1DOWN.URMEINO 		+ " = " + TBTHB2KMEI.URMEINO 		+ "  AND ");
        sql.append(TBTHB1DOWN.TJYUTNO 		+ " = " + "' '" 					+ "  AND ");
        //媒体：テレビタイム
        if(_baitai.equals(C_BAITAI_TV_TIME)){
            sql.append(				  TBTHB2KMEI.CODE6 		 + " IN "+ " ('001' , '002' ) "  				+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE1 	+")" + " = " + " '01' "								+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE5 	+")" + " = " + "mast1." +TBTHBAMST.FIELD1 + "(+)"	+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE2 	+")" + " = " + "mast3." +TBTHBAMST.FIELD1 + "(+)"	+ "      ");
        }
        //媒体：ラジオタイム
        else if(_baitai.equals(C_BAITAI_RD_TIME)){
            sql.append(				  TBTHB2KMEI.CODE6 		 + " IN "+ " ('003' , '004' ) "  				+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE1 	+")" + " = " + " '04' "								+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE5 	+")" + " = " + "mast1." +TBTHBAMST.FIELD1 + "(+)"	+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE2 	+")" + " = " + "mast3." +TBTHBAMST.FIELD1 + "(+)"	+ "      ");
        }
        //媒体：テレビスポット
        else if(_baitai.equals(C_BAITAI_TV_SPOT)){
            sql.append(				  TBTHB2KMEI.CODE6 		 + " = " + " '005' "  							+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE1 	+")" + " = " + " '02' "								+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE2 	+")" + " = " + "mast3." +TBTHBAMST.FIELD1			+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE3 	+")" + " = " + "mast5." +TBTHBAMST.FIELD1			+ "      ");
        }
        //媒体：ラジオスポット
        else if(_baitai.equals(C_BAITAI_RD_SPOT)){
            sql.append(				  TBTHB2KMEI.CODE6 		 + " = " + " '005' "  							+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE1 	+")" + " = " + " '05' "								+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE2 	+")" + " = " + "mast3." +TBTHBAMST.FIELD1			+ "  AND ");
            sql.append(" TRIM(thb2."+ TBTHB2KMEI.CODE3 	+")" + " = " + "mast5." +TBTHBAMST.FIELD1			+ "      ");
        }
        //*************************************************************************************************
        //OREDER BY
        //*************************************************************************************************
        sql.append(" ORDER BY ");
        //媒体：テレビタイム、ラジオタイム
        if(_baitai.equals(C_BAITAI_TV_TIME) || _baitai.equals(C_BAITAI_RD_TIME)){
            sql.append(TBTHB2KMEI.CODE6 					+ ", ");
            sql.append("mast1."	+ TBTHBAMST.INTVALUE6 		+ ", ");
            sql.append("thb2."	+ TBTHB2KMEI.CODE5 			+ ", ");
            sql.append("thb2."	+ TBTHB2KMEI.CODE2 			+ "  ");
        }
        //媒体：テレビスポット、ラジオスポット
        else if(_baitai.equals(C_BAITAI_TV_SPOT) || _baitai.equals(C_BAITAI_RD_SPOT)){
            sql.append("thb2."	+ TBTHB2KMEI.CODE3 			+ ", ");	//ブランドコード
            sql.append("mast3."	+ TBTHBAMST.FIELD1 			+ ", ");	//局コード
            sql.append("mast3."	+ TBTHBAMST.FIELD4 			+ ", ");
            sql.append("thb2."	+ TBTHB2KMEI.CODE2 			+ "  ");	//局コード
        }

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
    public List<ReportLionVO> findReportLionByCondition(ReportLionCondition cond)
            throws KKHException {

        super.setModel(new ReportLionVO());

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
    protected List<ReportLionVO> createFindedModelInstances(List hashList) {
        List<ReportLionVO> list = new ArrayList<ReportLionVO>();
        if (getModel() instanceof ReportLionVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ReportLionVO vo = new ReportLionVO();
                vo.setYymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase()));			//
                vo.setName3((String) result.get(TBTHB2KMEI.NAME3.toUpperCase()));			//受注No
                vo.setName4((String) result.get(TBTHB2KMEI.NAME4.toUpperCase()));			//受注明細No
                vo.setName5((String) result.get(TBTHB2KMEI.NAME5.toUpperCase()));			//
                vo.setName6((String) result.get(TBTHB2KMEI.NAME6.toUpperCase()));			//請求原票No
                vo.setName7((String) result.get(TBTHB2KMEI.NAME7.toUpperCase()));			//
                vo.setName11((String) result.get(TBTHB2KMEI.NAME11.toUpperCase()));			//
                vo.setName12((String) result.get(TBTHB2KMEI.NAME12.toUpperCase()));			//
                vo.setName13((String) result.get(TBTHB2KMEI.NAME13.toUpperCase()));			//備考１(雑誌)
                vo.setName14((String) result.get(TBTHB2KMEI.NAME14.toUpperCase()));			//備考２(雑誌)
                vo.setName15((String) result.get(TBTHB2KMEI.NAME15.toUpperCase()));			//
                vo.setName16((String) result.get(TBTHB2KMEI.NAME16.toUpperCase()));			//備考１(新聞)
                vo.setName17((String) result.get(TBTHB2KMEI.NAME17.toUpperCase()));			//備考２(新聞)
                vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));			//
                vo.setCode2((String) result.get(TBTHB2KMEI.CODE2.toUpperCase().trim()));			//
                vo.setCode3((String) result.get(TBTHB2KMEI.CODE3.toUpperCase().trim()));			//
                vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));			//
                vo.setCode5((String) result.get(TBTHB2KMEI.CODE5.toUpperCase().trim()));			//
                vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));			//
                vo.setSonota1((String) result.get(TBTHB2KMEI.SONOTA1.toUpperCase()));		//
                vo.setSonota5((String) result.get(TBTHB2KMEI.SONOTA5.toUpperCase().trim()));		//
                vo.setSonota7((String) result.get(TBTHB2KMEI.SONOTA7.toUpperCase()));		//
                vo.setSonota9((String) result.get(TBTHB2KMEI.SONOTA9.toUpperCase()));		//
                vo.setKngk2((BigDecimal) result.get(TBTHB2KMEI.KNGK2.toUpperCase()));		//金額2
                vo.setKngk3((BigDecimal) result.get(TBTHB2KMEI.KNGK3.toUpperCase()));		//金額2
                vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));		//請求額
                vo.setNebigak((BigDecimal) result.get(TBTHB2KMEI.NEBIGAK.toUpperCase()));	//値引額
                vo.setJyutNo((String) result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));			//受注No
                vo.setJyMeiNo((String) result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));		//受注明細No
                vo.setUrMeiNo((String) result.get(TBTHB2KMEI.URMEINO.toUpperCase()));		//売上明細No
                vo.setRenbn((String) result.get(TBTHB2KMEI.RENBN.toUpperCase()));
                vo.setKbn2((String) result.get(TBTHB2KMEI.KBN2.toUpperCase()));				//値引区分(1:値引行)
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
                vo.setBasho((String) result.get(ReportLionVO.BASHO.toUpperCase()));				//場所
                vo.setSaizu((String) result.get(ReportLionVO.SAIZU.toUpperCase()));				//サイズ
                vo.setKizatsu((String) result.get(ReportLionVO.KIZATSU.toUpperCase()));			//記雑
                vo.setChoyu((String) result.get(ReportLionVO.CHOYU.toUpperCase()));				//朝夕
                vo.setMedia((String) result.get(ReportLionVO.MEDIA.toUpperCase()));				//メディア
                vo.setMediaRya((String) result.get(ReportLionVO.MEDIARYA.toUpperCase()));		//メディア(略)
                vo.setIrozuri((String) result.get(ReportLionVO.IROZURI.toUpperCase()));			//色刷

                vo.setShohizeiGak((BigDecimal) result.get(ReportLionVO.SHOHIZEI_GAK.toUpperCase()));	//消費税額

                vo.setByosuGokei((BigDecimal) result.get(ReportLionVO.BYOSU_GOKEI.toUpperCase()));		//CM秒数合計

                vo.setBrandCd((String) result.get(ReportLionVO.BRAND_CD.toUpperCase()));			//ブランドコード
                vo.setBrandMei((String) result.get(ReportLionVO.BRAND_MEI.toUpperCase()));			//ブランド名称

                vo.setKyokuCd((String) result.get(ReportLionVO.KYOKU_CD.toUpperCase()));			//局コード
                vo.setKyokuMei((String) result.get(ReportLionVO.KYOKU_MEI.toUpperCase()));			//局名称

                vo.setBangumiCd((String) result.get(ReportLionVO.BANGUMI_CD.toUpperCase()));		//番組コード
                vo.setBangumiMei((String) result.get(ReportLionVO.BANGUMI_MEI.toUpperCase()));		//番組名称

                vo.setTvKyokuCd((String) result.get(ReportLionVO.TV_KYOKU_CD.toUpperCase()));		//テレビ局コード
                vo.setTvKyokuMei((String) result.get(ReportLionVO.TV_KYOKU_MEI.toUpperCase()));		//テレビ局名称
                vo.setTvBangumiCd((String) result.get(ReportLionVO.TV_BANGUMI_CD.toUpperCase()));	//テレビ番組コード
                vo.setTvBangumiMei((String) result.get(ReportLionVO.TV_BANGUMI_MEI.toUpperCase()));	//テレビ番組名称

                vo.setRdKyokuCd((String) result.get(ReportLionVO.RD_KYOKU_CD.toUpperCase()));		//ラジオ局コード
                vo.setRdKyokuMei((String) result.get(ReportLionVO.RD_KYOKU_MEI.toUpperCase()));		//ラジオ局名称
                vo.setRdBangumiCd((String) result.get(ReportLionVO.RD_BANGUMI_CD.toUpperCase()));	//ラジオ番組コード
                vo.setRdBangumiMei((String) result.get(ReportLionVO.RD_BANGUMI_MEI.toUpperCase()));	//ラジオ番組名称

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
