package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class FindLionCardNoItrDAO extends AbstractRdbDao  {

    /** 汎用マスタ検索条件 */
    private FindLionCardNoItrCondition _cond;

    //種別//////////////////////////////////////////////////////////////////////////////////////////////
    /** 汎用マスタ：媒体種別：媒体区分(104) */
    public static final String C_HBAMST_SYBT_BAITAI_KBN =  LionConstants.MastBaitaiShubetsu.BAITAI_KBN.getCode();

    //カードNo///////////////////////////////////////////////////////////////////////////////////////////
    /** 汎用マスタ：カードNO：テレビタイム（ローカル） */
    public static final String C_HBAMST_CARD_TV_LOCAL =  LionConstants.CardNo.TV_LOCAL.getCode();
    /** 汎用マスタ：カードNO：テレビ（ネット） */
    public static final String C_HBAMST_CARD_TV_TIME =  LionConstants.CardNo.TV_TIME.getCode();
    /** 汎用マスタ：カードNO：ラジオタイム（ネット） */
    public static final String C_HBAMST_CARD_RD_TIME =  LionConstants.CardNo.RD_TIME.getCode();
    /** 汎用マスタ：カードNO：ラジオタイム（ローカル） */
    public static final String C_HBAMST_CARD_RD_LOCAL =  LionConstants.CardNo.RD_LOCAL.getCode();
    /** 汎用マスタ：カードNO：スポット（テレビ、ラジオ） */
    public static final String C_HBAMST_CARD_SPOT =  LionConstants.CardNo.SPOT.getCode();
    /** 汎用マスタ：カードNO：新聞 */
    public static final String C_HBAMST_CARD_SHINBUN =  LionConstants.CardNo.SHINBUN.getCode();
    /** 汎用マスタ：カードNO：雑誌 */
    public static final String C_HBAMST_CARD_ZASHI =  LionConstants.CardNo.ZASHI.getCode();
    /** 汎用マスタ：カードNO：交通 */
    public static final String C_HBAMST_CARD_KOUTU =  LionConstants.CardNo.KOUTU.getCode();
    /** 汎用マスタ：カードNO：その他 */
    public static final String C_HBAMST_CARD_SONOTA =  LionConstants.CardNo.SONOTA.getCode();
    /** 汎用マスタ：カードNO：制作 */
    public static final String C_HBAMST_CARD_SEISAKUHI =  LionConstants.CardNo.SEISAKUHI.getCode();
    /** 汎用マスタ：カードNO：チラシ */
    public static final String C_HBAMST_CARD_LEAFLET =  LionConstants.CardNo.LEAFLET.getCode();
    /** 汎用マスタ：カードNO：サンプリング */
    public static final String C_HBAMST_CARD_SAMPLING =  LionConstants.CardNo.SAMPLING.getCode();
    /** 汎用マスタ：カードNO：BS・CS */
    public static final String C_HBAMST_CARD_BSCS =  LionConstants.CardNo.BSCS.getCode();
    /** 汎用マスタ：カードNO：インターネット */
    public static final String C_HBAMST_CARD_INTERNET =  LionConstants.CardNo.INTERNET.getCode();
    /** 汎用マスタ：カードNO：モバイル */
    public static final String C_HBAMST_CARD_MOBILE =  LionConstants.CardNo.MOBILE.getCode();
    /** 汎用マスタ：カードNO：事業費 */
    public static final String C_HBAMST_CARD_BUSINESSEXP =  LionConstants.CardNo.BUSINESSEXP.getCode();

    //Field1コード///////////////////////////////////////////////////////////////////////////////////////////
    /** テレビタイム */
    public static final String C_HBAMST_FIELD1_TV_LOCAL =  LionConstants.Field1Code.TV_TIME.getCode();
    /** ラジオタイム */
    public static final String C_HBAMST_FIELD1_RD_TIME =  LionConstants.Field1Code.RD_TIME.getCode();
    /** スポット（テレビ） */
    public static final String C_HBAMST_FIELD1_TV_SPOT =  LionConstants.Field1Code.TV_SPOT.getCode();
    /** スポット（ラジオ） */
    public static final String C_HBAMST_FIELD1_RD_SPOT =  LionConstants.Field1Code.RD_SPOT.getCode();
    /** 新聞 */
    public static final String C_HBAMST_FIELD1_SHINBUN =  LionConstants.Field1Code.SHINBUN.getCode();
    /** 雑誌 */
    public static final String C_HBAMST_FIELD1_ZASHI =  LionConstants.Field1Code.ZASHI.getCode();
    /** 交通 */
    public static final String C_HBAMST_FIELD1_KOUTU =  LionConstants.Field1Code.KOTSU.getCode();
    /** その他 */
    public static final String C_HBAMST_FIELD1_SONOTA =  LionConstants.Field1Code.SONOTA.getCode();
    /** 制作1 */
    public static final String C_HBAMST_FIELD1_SEISAKU1 =  LionConstants.Field1Code.SEISAKU1.getCode();
    /** 制作2 */
    public static final String C_HBAMST_FIELD1_SEISAKU2 =  LionConstants.Field1Code.SEISAKU2.getCode();
    /** チラシ */
    public static final String C_HBAMST_FIELD1_CHIRASHI =  LionConstants.Field1Code.CHIRASHI.getCode();
    /** サンプリング */
    public static final String C_HBAMST_FIELD1_SAMPLING =  LionConstants.Field1Code.SAMPLING.getCode();
    /** BS・CS */
    public static final String C_HBAMST_FIELD1_BSCS =  LionConstants.Field1Code.BS_CS.getCode();
    /** インターネット */
    public static final String C_HBAMST_FIELD1_INTERNET =  LionConstants.Field1Code.INTERNET.getCode();
    //2017/06/05 ライオン対応 ITCOM A.Nakamura Add Start
    /** ソーシャルメディア */
    public static final String C_HBAMST_FIELD1_SOCIALMEDIA =  LionConstants.Field1Code.SOCIALMEDIA.getCode();
    /** デジタル動画 */
    public static final String C_HBAMST_FIELD1_DIGITALMOVIE =  LionConstants.Field1Code.DIGITALMOVIE.getCode();
    //2017/06/05 ライオン対応 ITCOM A.Nakamura Add End
    /** モバイル */
    public static final String C_HBAMST_FIELD1_MOBILE =  LionConstants.Field1Code.MOBILE.getCode();
    /** 事業費 */
    public static final String C_HBAMST_FIELD1_JIGYOHI =  LionConstants.Field1Code.JIGYOHI.getCode();

    /**
     * デフォルトコンストラクタ。
     */
    public FindLionCardNoItrDAO() {
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
                TBTHBAMST.EGCD,
                TBTHBAMST.TKSKGYCD,
                TBTHBAMST.TKSBMNSEQNO,
                TBTHBAMST.TKSTNTSEQNO,
                TBTHBAMST.SYBT,
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
     * @return String テーブル名
     */
    @Override
    public String getTableName() {
        return TBTHBAMST.TBNAME;
    }


    /**
     * テーブル列名を返します。
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHBAMST.TRKTIMSTMP,
                TBTHBAMST.TRKPL,
                TBTHBAMST.TRKTNT,
                TBTHBAMST.UPDTIMSTMP,
                TBTHBAMST.UPDAPL,
                TBTHBAMST.UPDTNT,
                TBTHBAMST.EGCD,
                TBTHBAMST.TKSKGYCD,
                TBTHBAMST.TKSBMNSEQNO,
                TBTHBAMST.TKSTNTSEQNO,
                TBTHBAMST.SYBT,
                TBTHBAMST.FIELD1,
                TBTHBAMST.FIELD2
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

        //テレビタイム(ネット)・テレビタイム(ローカル)
        if( _cond.getCode().equals(C_HBAMST_CARD_TV_TIME) || _cond.getCode().equals(C_HBAMST_CARD_TV_LOCAL)){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_TV_LOCAL  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //ラジオタイム(ネット)・ラジオタイム(ローカル)
        else if( _cond.getCode().equals(C_HBAMST_CARD_RD_TIME) || _cond.getCode().equals(C_HBAMST_CARD_RD_LOCAL)){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_RD_TIME  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //スポット
        else if( _cond.getCode().equals(C_HBAMST_CARD_SPOT) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " IN ('" + C_HBAMST_FIELD1_TV_SPOT  + "','" + C_HBAMST_FIELD1_RD_SPOT + "') ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //新聞
        else if( _cond.getCode().equals(C_HBAMST_CARD_SHINBUN) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_SHINBUN  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //雑誌
        else if( _cond.getCode().equals(C_HBAMST_CARD_ZASHI) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_ZASHI  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //交通
        else if( _cond.getCode().equals(C_HBAMST_CARD_KOUTU) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_KOUTU  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //その他
        else if( _cond.getCode().equals(C_HBAMST_CARD_SONOTA) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_SONOTA  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //制作
        else if( _cond.getCode().equals(C_HBAMST_CARD_SEISAKUHI) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod Start
            //媒体区分40、41以外を表示
            sql.append(TBTHBAMST.FIELD1 + " BETWEEN '" + C_HBAMST_FIELD1_SEISAKU1  + "' AND '" + C_HBAMST_FIELD1_SEISAKU2 + "' AND ");
            sql.append(TBTHBAMST.FIELD1 + " NOT IN ('40' ,'41') ");
            //sql.append(TBTHBAMST.FIELD1  + " BETWEEN '" + C_HBAMST_FIELD1_SEISAKU1  + "' AND '" + C_HBAMST_FIELD1_SEISAKU2  + "' ");
          //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod End
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //チラシ
        else if( _cond.getCode().equals(C_HBAMST_CARD_LEAFLET) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_CHIRASHI  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //サンプリング
        else if( _cond.getCode().equals(C_HBAMST_CARD_SAMPLING) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_SAMPLING  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //BS・CS
        else if( _cond.getCode().equals(C_HBAMST_CARD_BSCS) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_BSCS  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //インターネット
        else if( _cond.getCode().equals(C_HBAMST_CARD_INTERNET) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod Start
            sql.append(TBTHBAMST.FIELD1  + " IN ('" + C_HBAMST_FIELD1_INTERNET  + "','" + C_HBAMST_FIELD1_SOCIALMEDIA + "','" +C_HBAMST_FIELD1_DIGITALMOVIE + "') ");
            //sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_INTERNET  + "' ");
            //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod End
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //モバイル
        else if( _cond.getCode().equals(C_HBAMST_CARD_MOBILE) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_MOBILE  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        //事業費
        else if( _cond.getCode().equals(C_HBAMST_CARD_BUSINESSEXP) ){
            sql.append(" SELECT ");
            sql.append("  " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ," + TBTHBAMST.FIELD2 + " ");
            sql.append(" FROM ");
            sql.append("  " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHBAMST.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(TBTHBAMST.SYBT  + " = '" + C_HBAMST_SYBT_BAITAI_KBN  + "' AND ");
            sql.append(TBTHBAMST.FIELD1  + " = '" + C_HBAMST_FIELD1_JIGYOHI  + "' ");
            sql.append("  ORDER BY ");
            sql.append(TBTHBAMST.FIELD1);
        }

        return sql.toString();
    }


    /**
     * 汎用マスタの検索を行います。
     *
     * @return テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<FindLionCardNoItrVO> findLionCardNoItrByCondition(FindLionCardNoItrCondition cond) throws KKHException {

        super.setModel(new FindLionCardNoItrVO());

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
    protected List<FindLionCardNoItrVO> createFindedModelInstances(List hashList) {
        List<FindLionCardNoItrVO> list = new ArrayList<FindLionCardNoItrVO>();
        if (getModel() instanceof FindLionCardNoItrVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindLionCardNoItrVO vo = new FindLionCardNoItrVO();
                vo.setField1((String)result.get(TBTHBAMST.FIELD1.toUpperCase()));
                vo.setField2((String)result.get(TBTHBAMST.FIELD2.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
