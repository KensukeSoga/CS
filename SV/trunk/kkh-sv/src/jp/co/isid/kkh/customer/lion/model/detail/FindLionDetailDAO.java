package jp.co.isid.kkh.customer.lion.model.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.tbl.TBTHB11WLTVK;
import jp.co.isid.kkh.integ.tbl.TBTHB12WLRDK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class FindLionDetailDAO extends AbstractRdbDao  {

    /**テレビ局マスタ検索条件 */
    private FindLionDetailCondition _cond;

    //種別//////////////////////////////////////////////////////////////////////////////////////////////
    /** 汎用マスタ：媒体種別：ブランド */
    public static final String C_HBAMST_SYBT_BRAND =  LionConstants.MastBaitaiShubetsu.BRAND.getCode();
    /** 汎用マスタ：媒体種別：新聞 */
    public static final String C_HBAMST_SYBT_SHINBUN =  LionConstants.MastBaitaiShubetsu.SHINBUN.getCode();
    /** 汎用マスタ：媒体種別：雑誌 */
    public static final String C_HBAMST_SYBT_ZASHI =  LionConstants.MastBaitaiShubetsu.ZASHI.getCode();
    /** 汎用マスタ：媒体種別：製作費 */
    public static final String C_HBAMST_SYBT_BAITAI_KBN =  LionConstants.MastBaitaiShubetsu.BAITAI_KBN.getCode();
    /** 汎用マスタ：媒体種別：県 */
    public static final String C_HBAMST_SYBT_KEN =  LionConstants.MastBaitaiShubetsu.KEN.getCode();
    /** 汎用マスタ：媒体種別：インターネット */
    public static final String C_HBAMST_SYBT_INTERNET  =  LionConstants.MastBaitaiShubetsu.INTERNET.getCode();
    /** 汎用マスタ：媒体種別：モバイル */
    public static final String C_HBAMST_SYBT_MOBILE  =  LionConstants.MastBaitaiShubetsu.MOBILE.getCode();
    /** 汎用マスタ：カードNO：モバイル */
    public static final String C_HBAMST_SYBT_SONOTA_CD =  LionConstants.MastBaitaiShubetsu.BAITAI_KBN.getCode();

    //カードNo///////////////////////////////////////////////////////////////////////////////////////////
    /** 汎用マスタ：カードNO：新聞 */
    public static final String C_HBAMST_CARD_SHINBUN =  LionConstants.CardNo.SHINBUN.getCode();
    /** 汎用マスタ：カードNO：雑誌 */
    public static final String C_HBAMST_CARD_ZASHI =  LionConstants.CardNo.ZASHI.getCode();
    /** 汎用マスタ：カードNO：ラジオタイム（ネット） */
    public static final String C_HBAMST_CARD_RD_TIME =  LionConstants.CardNo.RD_TIME.getCode();
    /** 汎用マスタ：カードNO：ラジオタイム（ローカル） */
    public static final String C_HBAMST_CARD_RD_LOCAL =  LionConstants.CardNo.RD_LOCAL.getCode();
    /** 汎用マスタ：カードNO：スポット（テレビ、ラジオ） */
    public static final String C_HBAMST_CARD_SPOT =  LionConstants.CardNo.SPOT.getCode();
    /** 汎用マスタ：カードNO：テレビタイム（ローカル） */
    public static final String C_HBAMST_CARD_TV_LOCAL =  LionConstants.CardNo.TV_LOCAL.getCode();
    /** 汎用マスタ：カードNO：テレビ（ネット） */
    public static final String C_HBAMST_CARD_TV_TIME =  LionConstants.CardNo.TV_TIME.getCode();
    /** 汎用マスタ：カードNO：BS、CS */
    public static final String C_HBAMST_CARD_BSCS=  LionConstants.CardNo.BSCS.getCode();
    /** 汎用マスタ：カードNO：制作 */
    public static final String C_HBAMST_CARD_SEISAKUHI =  LionConstants.CardNo.SEISAKUHI.getCode();
    /** 汎用マスタ：カードNO：交通 */
    public static final String C_HBAMST_CARD_KOUTU =  LionConstants.CardNo.KOUTU.getCode();
    /** 汎用マスタ：カードNO：インターネット */
    public static final String C_HBAMST_CARD_INTERNET =  LionConstants.CardNo.INTERNET.getCode();
    /** 汎用マスタ：カードNO：モバイル */
    public static final String C_HBAMST_CARD_MOBILE =  LionConstants.CardNo.MOBILE.getCode();
    /** 汎用マスタ：カードNO：モバイル */
    public static final String C_HBAMST_CARD_SONOTA =  LionConstants.CardNo.SONOTA.getCode();

    //媒体区分//////////////////////////////////////////////////////////////////////////////////////////////
    /** 汎用マスタ：媒体区分：TVすぽ */
    public static final String C_HBAMST_BAITAIKBN_TV_SPOT =  LionConstants.BaitaiKbn.TV_SPOT.getCode();
    /** 汎用マスタ：媒体区分：らじすぽ */
    public static final String C_HBAMST_BAITAIKBN_RD_SPOT =  LionConstants.BaitaiKbn.RD_SPOT.getCode();

    /**
     * デフォルトコンストラクタ。
     */
    public FindLionDetailDAO() {
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

    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        //マスタ用stringbuffer
        StringBuffer lstrSelect = new StringBuffer();
        StringBuffer lstrFrom = new StringBuffer();
        StringBuffer lstrWhere = new StringBuffer();

        //マスタデータSQL（分岐）
        //新聞
        if (_cond.getCode6().equals(C_HBAMST_CARD_SHINBUN))
        {
            //SELECT
            lstrSelect.append(" ," + "SINBUN." + TBTHBAMST.FIELD2  + " AS VAL1 ");              //新聞名称
            lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //ブランド名称
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //ダミー３
            //FROM
            lstrFrom.append(",("); //マスタテーブル(新聞)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_SHINBUN + "' ");
            lstrFrom.append(") SINBUN, ");
            lstrFrom.append("("); //マスタテーブル(ブランド)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
            lstrFrom.append(") BRAND ");
            //where
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//ブランドコード
            lstrWhere.append(" AND SINBUN." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND SINBUN." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND SINBUN." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND SINBUN." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//新聞コード
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//連番(ソート順）
        }
        //雑誌
        else if (_cond.getCode6().equals(C_HBAMST_CARD_ZASHI))
        {
            //SELECT
            lstrSelect.append(" ," + "ZASSI." + TBTHBAMST.FIELD2  + " AS VAL1 ");              //新聞名称
            lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //ブランド名称
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //ダミー３
            //FROM
            lstrFrom.append(",("); //マスタテーブル(雑誌)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI + "' ");
            lstrFrom.append(") ZASSI, ");
            lstrFrom.append("("); //マスタテーブル(ブランド)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
            lstrFrom.append(") BRAND ");
            //where
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//ブランドコード
            lstrWhere.append(" AND ZASSI." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND ZASSI." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND ZASSI." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND ZASSI." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//新聞コード
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//連番(ソート順）
        }
        //ラジオタイム（ネット）,ラジオタイム（ローカル）
        else if (_cond.getCode6().equals(C_HBAMST_CARD_RD_LOCAL) || _cond.getCode6().equals(C_HBAMST_CARD_RD_TIME))
        {
            //SELECT
            lstrSelect.append(" ," + "RDKYK." + TBTHB12WLRDK.KYOKUNAME  + " AS VAL1 ");              //ラジオ局名称
            lstrSelect.append(" ," + "''"  + " AS VAL2 ");               //ダミー２
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //ダミー３
            //FROM
            lstrFrom.append(", " + TBTHB12WLRDK.TBNAME + " RDKYK "); //マスタテーブル(ラジオ局)
            //where
            lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.KYOKUCD + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//ブランドコード
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//連番(ソート順）
        }
        //スポット(テレビ)
        else if (_cond.getCode6().equals(C_HBAMST_CARD_SPOT))
        {
            if (_cond.getCode1().equals(C_HBAMST_BAITAIKBN_TV_SPOT)){
                //SELECT
                lstrSelect.append(" ," + "TVKYK." + TBTHB11WLTVK.KYOKUNAME  + " AS VAL1 ");          //TV番組名称
                lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //ブランド名称
                lstrSelect.append(" ," + "TVKYK." + TBTHB11WLTVK.TIKU  + " AS VAL3 ");               //地区コード
                //FROM
//                lstrFrom.append(", " + TBTHB11WLTVK.TBNAME + " TVKYK "); //マスタテーブル(ラジオ局)
                lstrFrom.append(",(");//マスタテーブル(テレビ局)
                lstrFrom.append("SELECT * ");
                lstrFrom.append("FROM  " + TBTHB11WLTVK.TBNAME + " ");
                lstrFrom.append("order by " + TBTHB11WLTVK.THYOJIJYUN + " ");
                lstrFrom.append(") TVKYK ");
                lstrFrom.append(",("); //マスタテーブル(ブランド)
                lstrFrom.append("SELECT * ");
                lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
                lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
                lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
                lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
                lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
                lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
                lstrFrom.append(") BRAND ");
                //where
                lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
                lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
                lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
                lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//ブランドコード
                lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
                lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
                lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
                lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.KYOKUCD + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//新聞コード
                lstrWhere.append(" order by "  + TBTHB11WLTVK.THYOJIJYUN );                 //地区順
            } else if (_cond.getCode1().equals(C_HBAMST_BAITAIKBN_RD_SPOT)){
                //SELECT
                lstrSelect.append(" ," + "RDKYK." + TBTHB12WLRDK.KYOKUNAME  + " AS VAL1 ");          //ラジオ番組名称
                lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //ブランド名称
                lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //ダミー３
                //FROM
                lstrFrom.append(", " + TBTHB12WLRDK.TBNAME + " RDKYK "); //マスタテーブル(ラジオ局)
                lstrFrom.append(",("); //マスタテーブル(ブランド)
                lstrFrom.append("SELECT * ");
                lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
                lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
                lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
                lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
                lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
                lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
                lstrFrom.append(") BRAND ");
                //where
                lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
                lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
                lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
                lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//ブランドコード
                lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
                lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
                lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
                lstrWhere.append(" AND RDKYK." + TBTHB12WLRDK.KYOKUCD + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//新聞コード
                //lstrWhere.append(" order by "  + TBTHB12WLRDK.HYOJIJYUN );                 //地区順
                lstrWhere.append(" order by "  + TBTHB2KMEI.RENBN );                 //連番(ソート順）
            }
        }
        //ＴＶタイムネット,ＴＶタイムローカルＢＳ・ＣＳ
        else if (_cond.getCode6().equals(C_HBAMST_CARD_TV_LOCAL) || _cond.getCode6().equals(C_HBAMST_CARD_TV_TIME) || _cond.getCode6().equals(C_HBAMST_CARD_BSCS))
        {
            //SELECT
            lstrSelect.append(" ," + "TVKYK." + TBTHB11WLTVK.KYOKUNAME  + " AS VAL1 ");              //ラジオ局名称
            lstrSelect.append(" ," + "''"  + " AS VAL2 ");               //ダミー２
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //ダミー３
            //FROM
            lstrFrom.append(", " + TBTHB11WLTVK.TBNAME + " TVKYK "); //マスタテーブル(ラジオ局)
            //where
            lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND TVKYK." + TBTHB11WLTVK.KYOKUCD + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//ブランドコード
            lstrWhere.append(" order by "  + TBTHB11WLTVK.THYOJIJYUN );                 //地区順
        }
        //制作
        else if (_cond.getCode6().equals(C_HBAMST_CARD_SEISAKUHI))
        {
            //SELECT
            lstrSelect.append(" ," + "SEISAKU." + TBTHBAMST.FIELD2  + " AS VAL1 ");              //制作費名称
            lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //ブランド名称
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //ダミー３
            //FROM
            lstrFrom.append(",("); //マスタテーブル(媒体、ブランド)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BAITAI_KBN + "' AND ");
            //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod Start
            //デジタル動画(媒体区分43)追加のため修正、媒体消費税は除く
            lstrFrom.append(TBTHBAMST.FIELD1 + " NOT IN ('40' ,'41') ");//製作費のみ対象
//            lstrFrom.append(TBTHBAMST.FIELD1 + " between '20' and '39' ");//製作費のみ対象
            //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod End
            lstrFrom.append(") SEISAKU, ");
            lstrFrom.append("("); //マスタテーブル(ブランド)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
            lstrFrom.append(") BRAND ");
            //where
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//ブランドコード
            lstrWhere.append(" AND SEISAKU." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND SEISAKU." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND SEISAKU." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND SEISAKU." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE1 + ") ");//制作コード
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//連番(ソート順）
        }
        //交通
        else if (_cond.getCode6().equals(C_HBAMST_CARD_KOUTU))
        {
            //SELECT
            lstrSelect.append(" ," + "KEN." + TBTHBAMST.FIELD2  + " AS VAL1 ");              //交通名称
            lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //ブランド名称
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //ダミー３
            //FROM
            lstrFrom.append(",("); //マスタテーブル(県)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_KEN + "' ");
            lstrFrom.append(") KEN, ");
            lstrFrom.append("("); //マスタテーブル(ブランド)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
            lstrFrom.append(") BRAND ");
            //where
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//ブランドコード
            lstrWhere.append(" AND KEN." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND KEN." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND KEN." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND KEN." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.SONOTA2 + ") ");//交通コード
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//連番(ソート順）
        }
        //インターネット
        else if (_cond.getCode6().equals(C_HBAMST_CARD_INTERNET))
        {
            //SELECT
            lstrSelect.append(" ," + "INTERNET." + TBTHBAMST.FIELD2  + " AS VAL1 ");              //インターネット局名称
            lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //ブランド名称
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //ダミー３
            //FROM
            lstrFrom.append(",("); //マスタテーブル(インターネット)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_INTERNET + "' ");
            lstrFrom.append(") INTERNET, ");
            lstrFrom.append("("); //マスタテーブル(ブランド)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
            lstrFrom.append(") BRAND ");
            //where
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//ブランドコード
            lstrWhere.append(" AND INTERNET." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND INTERNET." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND INTERNET." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND INTERNET." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//インターネット局コード
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//連番(ソート順）
        }
        //モバイル
        else if (_cond.getCode6().equals(C_HBAMST_CARD_MOBILE))
        {
            //SELECT
            lstrSelect.append(" ," + "MOB." + TBTHBAMST.FIELD2  + " AS VAL1 ");              //インターネット局名称
            lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //モバイル名称
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");
            //FROM
            lstrFrom.append(",("); //マスタテーブル(モバイル)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_MOBILE + "' ");
            lstrFrom.append(") MOB, ");
            lstrFrom.append("("); //マスタテーブル(ブランド)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
            lstrFrom.append(") BRAND ");
            //where
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//ブランドコード
            lstrWhere.append(" AND MOB." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND MOB." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND MOB." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND MOB." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE2 + ") ");//モバイルコード
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//連番(ソート順）
        }
        //その他(上記のIF以外すべて）
        else //if (_cond.getCode6().equals(C_HBAMST_CARD_SONOTA))
        {
            //SELECT
            lstrSelect.append(" ," + "SONOTA." + TBTHBAMST.FIELD2  + " AS VAL1 ");              //インターネット局名称
            lstrSelect.append(" ," + "BRAND." + TBTHBAMST.FIELD2  + " AS VAL2 ");               //その他の名称
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");
            //FROM
            lstrFrom.append(",("); //マスタテーブル(モバイル)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_SONOTA_CD + "' ");
            lstrFrom.append(") SONOTA, ");
            lstrFrom.append("("); //マスタテーブル(ブランド)
            lstrFrom.append("SELECT * ");
            lstrFrom.append("FROM  " + TBTHBAMST.TBNAME + " ");
            lstrFrom.append("WHERE " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()+ "'  AND ");
            lstrFrom.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
            lstrFrom.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
            lstrFrom.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
            lstrFrom.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BRAND + "' ");
            lstrFrom.append(") BRAND ");
            //where
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND BRAND." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE3 + ") ");//ブランドコード
            lstrWhere.append(" AND SONOTA." + TBTHBAMST.TKSKGYCD + "(+) = " + TBTHB2KMEI.TKSKGYCD + " ");
            lstrWhere.append(" AND SONOTA." + TBTHBAMST.TKSBMNSEQNO + "(+) = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
            lstrWhere.append(" AND SONOTA." + TBTHBAMST.TKSTNTSEQNO + "(+) = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
            lstrWhere.append(" AND SONOTA." + TBTHBAMST.FIELD1 + "(+) = TRIM(" + TBTHB2KMEI.CODE1 + ") ");//その他コード
            lstrWhere.append(" ORDER BY " + TBTHB2KMEI.RENBN);//連番(ソート順）
        }

        if ("".equals(lstrSelect.toString())){
            lstrSelect.append(" ," + "''"  + " AS VAL1 ");               //ダミー１
            lstrSelect.append(" ," + "''"  + " AS VAL2 ");               //ダミー２
            lstrSelect.append(" ," + "''"  + " AS VAL3 ");               //ダミー３
        }

        //明細データSQL
        sql.append(" SELECT ");
        sql.append("  " + TBTHB2KMEI.JYUTNO + " ");          //受注No
        sql.append(" ," + TBTHB2KMEI.JYMEINO + " ");      //受注明細No
        sql.append(" ," + TBTHB2KMEI.URMEINO + " ");      //売上明細No
        sql.append(" ," + TBTHB2KMEI.YYMM + " ");         //年月
        sql.append(" ," + TBTHB2KMEI.HIMKCD + " ");       //費目コード
        sql.append(" ," + TBTHB2KMEI.HNNERT + " ");        //値引率
        sql.append(" ," + TBTHB2KMEI.NEBIGAK + " ");       //値引額
        sql.append(" ," + TBTHB2KMEI.CODE1 + " ");         //媒体区分
        sql.append(" ," + TBTHB2KMEI.CODE2 + " ");         //局コード
        sql.append(" ," + TBTHB2KMEI.CODE3 + " ");         //ブランドコード
        sql.append(" ," + TBTHB2KMEI.CODE4 + " ");         //代理店コード
        sql.append(" ," + TBTHB2KMEI.CODE5 + " ");         //番組コード
        sql.append(" ," + TBTHB2KMEI.CODE6 + " ");         //カードＮｏ
        sql.append(" ," + TBTHB2KMEI.NAME1 + " ");         //消費税額
        sql.append(" ," + TBTHB2KMEI.NAME2 + " ");         //スペースコード
        sql.append(" ," + TBTHB2KMEI.NAME3 + " ");         //請求書番号
        sql.append(" ," + TBTHB2KMEI.NAME4 + " ");         //宣伝費
        sql.append(" ," + TBTHB2KMEI.NAME5 + " ");         //掲載日･号･等
        sql.append(" ," + TBTHB2KMEI.NAME6 + " ");         //路線名
        sql.append(" ," + TBTHB2KMEI.NAME7 + " ");         //期間
        sql.append(" ," + TBTHB2KMEI.NAME8 + " ");         //備考
        sql.append(" ," + TBTHB2KMEI.NAME10 + " ");        //件名
        sql.append(" ," + TBTHB2KMEI.KNGK1 + " ");         //電波料
        sql.append(" ," + TBTHB2KMEI.KNGK2 + " ");         //ネット料
        sql.append(" ," + TBTHB2KMEI.KNGK3 + " ");         //制作費
        sql.append(" ," + TBTHB2KMEI.SEIGAK + " ");        //請求金額
        sql.append(" ," + TBTHB2KMEI.RITU1 + " ");         //消費税率
        sql.append(" ," + TBTHB2KMEI.SONOTA1 + " ");       //休止回数
        sql.append(" ," + TBTHB2KMEI.SONOTA2 + " ");       //府県ＣＤ
        sql.append(" ," + TBTHB2KMEI.SONOTA3 + " ");       //ネットＦＣ
        sql.append(" ," + TBTHB2KMEI.SONOTA5 + " ");       //本数
        sql.append(" ," + TBTHB2KMEI.SONOTA6 + " ");       //総秒数
        sql.append(" ," + TBTHB2KMEI.SONOTA7 + " ");       //秒数
        sql.append(" ," + TBTHB2KMEI.SONOTA8 + " ");       //放送回数
        sql.append(" ," + TBTHB2KMEI.SONOTA9 + " ");       //ＦＤ用表示順序
        sql.append(" " + lstrSelect + " ");             //マスタデータ(select)
        sql.append(" ," + TBTHB2KMEI.TIMSTMP + " ");//YYYY/MM/DD HH24:MI:SS//) TIMSTMP  //タイムスタンプ
        sql.append(" " + "FROM" + " ");
        sql.append(" " + TBTHB2KMEI.TBNAME + " ");//広告費明細テーブル
        sql.append(" " + lstrFrom + " ");         //マスタデータ(from)
        sql.append(" " + "where" + " ");
        sql.append(TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");          //営業所
        sql.append(TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
        sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getBmncd()  + "'  AND ");//得意先BMN
        sql.append(TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTntcd()  + "'  AND ");//得意先TNT
        sql.append(TBTHB2KMEI.YYMM  + " = '" + _cond.getYymm()  + "'  AND ");//年月
        sql.append(TBTHB2KMEI.JYUTNO  + " = '" + _cond.getJyutno()  + "'  AND ");//受注ｎO
        sql.append(TBTHB2KMEI.JYMEINO  + " = '" + _cond.getJymeino()  + "'  AND ");//受注明細
        sql.append(TBTHB2KMEI.URMEINO  + " = '" + _cond.getUrmeino()  + "'  ");//売上明細
        sql.append(" " + lstrWhere   + " ");                                       //マスタデータ(コード)

        return sql.toString();
    }

    /**
     * TV局マスタの検索を行います。
     *
     * @return テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<FindLionDetailVO> findLionDetailByCondition(FindLionDetailCondition cond) throws KKHException {

        super.setModel(new FindLionDetailVO());

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
     * @param hashList List 検索結果
     * @return List<CommonCodeMasterVO> 変換後の検索結果
     */
    @Override
    protected List<FindLionDetailVO> createFindedModelInstances(List hashList) {
        List<FindLionDetailVO> list = new ArrayList<FindLionDetailVO>();
        if (getModel() instanceof FindLionDetailVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindLionDetailVO vo = new FindLionDetailVO();
                //MEI2
                vo.setJyutno((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
                vo.setJymeino((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
                vo.setUrmeino((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));
                vo.setYymm((String)result.get(TBTHB2KMEI.YYMM.toUpperCase()));
                vo.setHimkcd((String)result.get(TBTHB2KMEI.HIMKCD.toUpperCase()));
                vo.setHnnert((BigDecimal)result.get(TBTHB2KMEI.HNNERT.toUpperCase()));
                vo.setNebigak((BigDecimal)result.get(TBTHB2KMEI.NEBIGAK.toUpperCase()));
                vo.setCode1((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
                vo.setCode2((String)result.get(TBTHB2KMEI.CODE2.toUpperCase()));
                vo.setCode3((String)result.get(TBTHB2KMEI.CODE3.toUpperCase()));
                vo.setCode4((String)result.get(TBTHB2KMEI.CODE4.toUpperCase()));
                vo.setCode5((String)result.get(TBTHB2KMEI.CODE5.toUpperCase()));
                vo.setCode6((String)result.get(TBTHB2KMEI.CODE6.toUpperCase()));
                vo.setName1((String)result.get(TBTHB2KMEI.NAME1.toUpperCase()));
                vo.setName2((String)result.get(TBTHB2KMEI.NAME2.toUpperCase()));
                vo.setName3((String)result.get(TBTHB2KMEI.NAME3.toUpperCase()));
                vo.setName4((String)result.get(TBTHB2KMEI.NAME4.toUpperCase()));
                vo.setName5((String)result.get(TBTHB2KMEI.NAME5.toUpperCase()));
                vo.setName6((String)result.get(TBTHB2KMEI.NAME6.toUpperCase()));
                vo.setName7((String)result.get(TBTHB2KMEI.NAME7.toUpperCase()));
                vo.setName8((String)result.get(TBTHB2KMEI.NAME8.toUpperCase()));
                vo.setName10((String)result.get(TBTHB2KMEI.NAME10.toUpperCase()));
                vo.setKngk1((BigDecimal)result.get(TBTHB2KMEI.KNGK1.toUpperCase()));
                vo.setKngk2((BigDecimal)result.get(TBTHB2KMEI.KNGK2.toUpperCase()));
                vo.setKngk3((BigDecimal)result.get(TBTHB2KMEI.KNGK3.toUpperCase()));
                vo.setSeigak((BigDecimal)result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
                vo.setRitu1((BigDecimal)result.get(TBTHB2KMEI.RITU1.toUpperCase()));
                vo.setSonota1((String)result.get(TBTHB2KMEI.SONOTA1.toUpperCase()));
                vo.setSonota2((String)result.get(TBTHB2KMEI.SONOTA2.toUpperCase()));
                vo.setSonota3((String)result.get(TBTHB2KMEI.SONOTA3.toUpperCase()));
                vo.setSonota5((String)result.get(TBTHB2KMEI.SONOTA5.toUpperCase()));
                vo.setSonota6((String)result.get(TBTHB2KMEI.SONOTA6.toUpperCase()));
                vo.setSonota7((String)result.get(TBTHB2KMEI.SONOTA7.toUpperCase()));
                vo.setSonota8((String)result.get(TBTHB2KMEI.SONOTA8.toUpperCase()));
                vo.setSonota9((String)result.get(TBTHB2KMEI.SONOTA9.toUpperCase()));
                //マスタ１～３まで動的
                vo.setVal1((String)result.get(FindLionDetailVO.VAL1.toUpperCase()));
                vo.setVal2((String)result.get(FindLionDetailVO.VAL2.toUpperCase()));
                vo.setVal3((String)result.get(FindLionDetailVO.VAL3.toUpperCase()));
                //MEI2
                vo.setTimstmp((Date)result.get(TBTHB2KMEI.TIMSTMP.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
