package jp.co.isid.kkh.customer.acom.model.claim;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;

/**
 *
 * <P>
 * 請求データ 一覧情報取得DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindClaimByCondDAO extends AbstractRdbDao {

    /** 列名 (種別コード) */
    static final String SYBT_CD = "SYBTCD";
    /** 列名 (メディア名) */
    static final String MEDIA_NM = "MEDIANM";
    /** 列名 (新聞_掲載場所名称) */
    static final String SNBN_KEIBAS_NM = "SNBN_KEIBASNM";
    /** 列名 (新聞_種別1名称) */
    static final String SNBN_SYBT1_NM = "SNBN_SYBT1NM";
    /** 列名 (新聞_種別2名称) */
    static final String SNBN_SYBT2_NM = "SNBN_SYBT2NM";
    /** 列名 (新聞_色刷名称) */
    static final String SNBN_SISAT_NM = "SNBN_SISATNM";
    /** 列名 (新聞_サイズ名称) */
    static final String SNBN_SIZE_NM = "SNBN_SIZENM";
    /** 列名 (雑誌_色刷名称) */
    static final String ZASI_SISAT_NM = "ZASI_SISATNM";
    /** 列名 (雑誌_サイズ名称) */
    static final String ZASI_SIZE_NM = "ZASI_SIZENM";
    /** 列名 (電波_交通掲載名称) */
    static final String DEMP_KOTKEI_NM = "DEMP_KOTKEINM";

    /** テーブル別名1 */
    private static final String TBL_A = "A";
    /** テーブル別名2 */
    private static final String TBL_B = "B";
    /** テーブル別名3 */
    private static final String TBL_C = "C";
    /** テーブル別名4 */
    private static final String TBL_D = "D";
    /** テーブル別名5 */
    private static final String TBL_E = "E";
    /** テーブル別名6 */
    private static final String TBL_F = "F";
    /** テーブル別名7 */
    private static final String TBL_G = "G";
    /** テーブル別名8 */
    private static final String TBL_H = "H";
    /** テーブル別名9 */
    private static final String TBL_I = "I";
    /** テーブル別名10 */
    private static final String TBL_J = "J";
    /** テーブル別名11 */
    private static final String TBL_K = "K";
    /** テーブル別名12 */
    private static final String TBL_AA = "AA";
    /** テーブル別名_サブクエリ1 */
    private static final String TBL_SUB_A = "SUB_A";
    /** テーブル別名_サブクエリ2 */
    private static final String TBL_SUB_B = "SUB_B";

    /** getSelectSQLで発行するSQLのモード */
    private enum SqlMode{
        /** 発注/請求番号 一覧 */
        CLAIMNO,
        /** 発注/請求 差異一覧 */
        CLAIMDIFF,
        /** 請求データ 一覧 */
        CLAIM,
        /** 値引マスタ */
        NEBIKI
        };
    private SqlMode _sqlMode = SqlMode.CLAIMNO;

    /** データ検索条件 */
    private FindClaimCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public FindClaimByCondDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * プライマリキーを返します。
     *
     * @return String[] プライマリキー
     */
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
    public String getTableName() {
        return null;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
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

        String ret = "";

        // 発注/請求番号 一覧情報取得
        if (_sqlMode == SqlMode.CLAIMNO) {
            ret = this.getSelectSQLForClaimNo();

        // 発注/請求 差異一覧取得
        } else if (_sqlMode == SqlMode.CLAIMDIFF) {
            ret = this.getSelectSQLForClaimDiff();

        // 請求データ 一覧情報取得
        } else if (_sqlMode == SqlMode.CLAIM) {
            ret = this.getSelectSQLForClaimData();

        // 値引マスタ
        } else if (_sqlMode == SqlMode.NEBIKI) {
            ret = this.getSelectSQLForNebiki();
        }

        return ret;
    }

    /**
     * 発注/請求番号 一覧情報取得のSQL文を返します。
     *
     * @return String SQL文
     */
    private String getSelectSQLForClaimNo() {

        StringBuffer sql = new StringBuffer();

        // ====================================================================================================
        // SELECT句
        // ====================================================================================================
        sql.append(" SELECT ");
        sql.append(" " + TBL_A + "." + TBTHB2KMEI.CODE1);        // 媒体コード
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE3);        // 発注番号
        sql.append("," + TBL_B + "." + TBTHB1DOWN.KKNAMEKJ);     // 件名
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA1);      // 請求書番号
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE1);        // 請求書発行日
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA6);      // 受注内容区分
        sql.append("," + TBL_A + "." + TBTHB2KMEI.KBN1);         // 出力フラグ
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME7);        // 実行日時
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYUTNO);       // 受注No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYMEINO);      // 受注明細No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.URMEINO);      // 売上明細No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.RENBN);        // 連番

        // ====================================================================================================
        // FROM句
        // ====================================================================================================
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + " " + TBL_A);
        sql.append("," + TBTHB1DOWN.TBNAME + " " + TBL_B);

        // ====================================================================================================
        // WHERE句
        // ====================================================================================================
        sql.append(" WHERE");
        // 結合条件 ---------------------------------------------------------------------------------------------
        sql.append("     " + TBL_A + "." + TBTHB2KMEI.EGCD + "        = " + TBL_B + "." + TBTHB1DOWN.EGCD);
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.TKSKGYCD + "    = " + TBL_B + "." + TBTHB1DOWN.TKSKGYCD);
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBL_B + "." + TBTHB1DOWN.TKSBMNSEQNO);
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBL_B + "." + TBTHB1DOWN.TKSTNTSEQNO);
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.YYMM + "        = " + TBL_B + "." + TBTHB1DOWN.YYMM);
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.JYUTNO + "      = " + TBL_B + "." + TBTHB1DOWN.JYUTNO);
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.JYMEINO + "     = " + TBL_B + "." + TBTHB1DOWN.JYMEINO);
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.URMEINO + "     = " + TBL_B + "." + TBTHB1DOWN.URMEINO);
        // 検索条件 ---------------------------------------------------------------------------------------------
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.YYMM  + "       = '" + _cond.getYymm() + "'");
        sql.append(" AND " + TBL_A + "." + TBTHB2KMEI.CODE1 + "      IN (" + _cond.getSybt() + ")");
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.TJYUTNO +     " = ' '");

        // ====================================================================================================
        // GROUP BY句
        // ====================================================================================================
        sql.append(" GROUP BY");
        sql.append(" " + TBL_A + "." + TBTHB2KMEI.CODE3);        // コード3(発注番号)
        sql.append("," + TBL_B + "." + TBTHB1DOWN.KKNAMEKJ);     // 件名(漢字)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE1);        // コード1(媒体コード)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA1);      // その他1(請求書番号)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE1);        // 日付1(請求書発行日)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.KBN1);         // 区分1(出力フラグ)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME7);        // 名称7(漢字)(実行日時)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYUTNO);       // 受注No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYMEINO);      // 受注明細No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.URMEINO);      // 売上明細No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.RENBN);        // 連番
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA6);      // その他6(受注内容区分)

        // ====================================================================================================
        // ORDER BY句
        // ====================================================================================================
        sql.append(" ORDER BY");
        sql.append(" " + TBL_A + "." + TBTHB2KMEI.CODE3);        // コード3(発注番号)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA1);      // その他1(請求書番号)

        return sql.toString();
    }

    /**
     * 発注/請求 差異一覧情報取得のSQL文を返します。
     *
     * @return String SQL文
     */
    private String getSelectSQLForClaimDiff() {

        StringBuffer sql1 = new StringBuffer();
        sql1.append(" SELECT ");
        sql1.append(" " + TBL_A + "." + TBTHB5HIK.RECCD);                 // レコード種別
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRBAN);                 // 依頼番号
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRROWBAN);              // 依頼行番号
        sql1.append("," + TBL_A + "." + TBTHB5HIK.TOKUICD);               // 得意先コード
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SYOHIKBN);              // 商品区分
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SYOHINAME);             // 商品区分名称
        sql1.append("," + TBL_A + "." + TBTHB5HIK.TEKICD);                // 摘要コード
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SYBT);                  // 種別（媒体コード）
        sql1.append("," + TBL_A + "." + TBTHB5HIK.MEDIACD);               // メディアコード
        sql1.append("," + TBL_A + "." + TBTHB5HIK.TENCD);                 // 店番
        sql1.append("," + TBL_A + "." + TBTHB5HIK.HOSORYO1);              // 放送料1
        sql1.append("," + TBL_A + "." + TBTHB5HIK.HOSORYO2);              // 放送料2
        sql1.append("," + TBL_A + "." + TBTHB5HIK.HOSORYO3);              // 放送料3
        sql1.append("," + TBL_A + "." + TBTHB5HIK.HOSORYO4);              // 放送料4
        sql1.append("," + TBL_A + "." + TBTHB5HIK.HOSORYO5);              // 放送料5
        sql1.append("," + TBL_A + "." + TBTHB5HIK.HOSORYO6);              // 放送料6
        sql1.append("," + TBL_A + "." + TBTHB5HIK.KEISAITANKA);           // 掲載単価
        sql1.append("," + TBL_A + "." + TBTHB5HIK.KEISAIRYO);             // 掲載料
        sql1.append("," + TBL_A + "." + TBTHB5HIK.ANSYUBE);               // 按分種別
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRMONTH1);              // 依頼月1
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRMONTH2);              // 依頼月2
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRMONTH3);              // 依頼月3
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRMONTH4);              // 依頼月4
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRMONTH5);              // 依頼月5
        sql1.append("," + TBL_A + "." + TBTHB5HIK.IRMONTH6);              // 依頼月6
        sql1.append("," + TBL_A + "." + TBTHB5HIK.KEITAICD);              // 形態区分コード
        sql1.append("," + TBL_A + "." + TBTHB5HIK.KEITAINAME);            // 形態区分名
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SAIKBN);                // 細目区分
        sql1.append("," + TBL_A + "." + TBTHB5HIK.RIRENO);                // 履歴管理番号
        sql1.append("," + TBL_A + "." + TBTHB5HIK.BIKOU1);                // 備考1
        sql1.append("," + TBL_A + "." + TBTHB5HIK.BIKOU2);                // 備考2
        sql1.append("," + TBL_A + "." + TBTHB5HIK.PLACECD);               // 掲載場所コード
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SYBT1CD);               // 種別１コード
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SYBT2CD);               // 種別２コード
        sql1.append("," + TBL_A + "." + TBTHB5HIK.COLORCD);               // 色刷コード
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SIZECD);                // サイズコード
        sql1.append("," + TBL_A + "." + TBTHB5HIK.SPACECD);               // スペースコード
        sql1.append("," + TBL_A + "." + TBTHB5HIK.KOTUKEICD);             // 交通掲載コード
        sql1.append("," + TBL_A + "." + SYBT_CD);                         // 種別コード
        sql1.append(" FROM ");
        // 発注取込 -----------------------------------------------------------------------------------------
        sql1.append("(SELECT ");
        sql1.append("     " + TBL_SUB_A + "." + TBTHB5HIK.RECCD);         // レコード種別
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRBAN);         // 依頼番号
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRROWBAN);      // 依頼行番号
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.TOKUICD);       // 得意先コード
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYOHIKBN);      // 商品区分
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYOHINAME);     // 商品区分名称
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.TEKICD);        // 摘要コード
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYBT);          // 種別（媒体コード）
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.MEDIACD);       // メディアコード
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.TENCD);         // 店番
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO1);      // 放送料1
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO2);      // 放送料2
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO3);      // 放送料3
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO4);      // 放送料4
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO5);      // 放送料5
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO6);      // 放送料6
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEISAITANKA);   // 掲載単価
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEISAIRYO);     // 掲載料
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.ANSYUBE);       // 按分種別
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH1);      // 依頼月1
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH2);      // 依頼月2
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH3);      // 依頼月3
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH4);      // 依頼月4
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH5);      // 依頼月5
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH6);      // 依頼月6
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEITAICD);      // 形態区分コード
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEITAINAME);    // 形態区分名
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SAIKBN);        // 細目区分
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.RIRENO);        // 履歴管理番号
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.BIKOU1);        // 備考1
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.BIKOU2);        // 備考2
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.PLACECD);       // 掲載場所コード
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYBT1CD);       // 種別１コード
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYBT2CD);       // 種別２コード
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.COLORCD);       // 色刷コード
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SIZECD);        // サイズコード
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SPACECD);       // スペースコード
        sql1.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KOTUKEICD);     // 交通掲載コード
        sql1.append("    ,CASE TRIM(" + TBL_SUB_A + "." + TBTHB5HIK.SYBT + ")");
        sql1.append("         WHEN '21' THEN '02'");
        sql1.append("         WHEN '22' THEN '03'");
        sql1.append("         WHEN '31' THEN '06'");
        sql1.append("         WHEN '11' THEN");
        sql1.append("             CASE TRIM(" + TBL_SUB_A + "." + TBTHB5HIK.SAIKBN + ")");
        sql1.append("                 WHEN '1' THEN '04'");
        sql1.append("                 WHEN '2' THEN '04'");
        sql1.append("                 WHEN '4' THEN '05'");
        sql1.append("                 WHEN '5' THEN '05'");
        sql1.append("             END");
        sql1.append("         END AS " + SYBT_CD);                        // 種別コード
        sql1.append(" FROM ");
        sql1.append(" " + TBTHB5HIK.TBNAME + " " + TBL_SUB_A);
        sql1.append(",(SELECT");
        sql1.append("     " + TBTHB5HIK.RECCD);                                                  // レコード種別
        sql1.append("    ," + TBTHB5HIK.IRBAN);                                                  // 依頼番号
        sql1.append("    ," + TBTHB5HIK.IRROWBAN);                                               // 依頼行番号
        sql1.append("    ,MAX(" + TBTHB5HIK.RIRENO + ") AS " + TBTHB5HIK.RIRENO);                // 履歴管理番号
        sql1.append(" FROM ");
        sql1.append("     " + TBTHB5HIK.TBNAME);
        sql1.append(" WHERE ");
        sql1.append("     " + TBTHB5HIK.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");       // 依頼番号
        sql1.append(" AND " + TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");    // 依頼行番号
        sql1.append(" AND " + TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");    // 履歴管理番号
        sql1.append(" GROUP BY ");
        sql1.append(" " + TBTHB5HIK.RECCD);                                                      // レコード種別
        sql1.append("," + TBTHB5HIK.IRBAN);                                                      // 依頼番号
        sql1.append("," + TBTHB5HIK.IRROWBAN);                                                   // 依頼行番号
        sql1.append(") " + TBL_SUB_B);
        sql1.append(" WHERE ");
        // 結合条件
        sql1.append("     " + TBL_SUB_B + "." + TBTHB5HIK.RECCD + "       = " + TBL_SUB_A + "." + TBTHB5HIK.RECCD);
        sql1.append(" AND " + TBL_SUB_B + "." + TBTHB5HIK.IRBAN + "       = " + TBL_SUB_A + "." + TBTHB5HIK.IRBAN);
        sql1.append(" AND " + TBL_SUB_B + "." + TBTHB5HIK.IRROWBAN + "    = " + TBL_SUB_A + "." + TBTHB5HIK.IRROWBAN);
        sql1.append(" AND " + TBL_SUB_B + "." + TBTHB5HIK.RIRENO + "      = " + TBL_SUB_A + "." + TBTHB5HIK.RIRENO);
        // 検索条件
        sql1.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql1.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql1.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql1.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        // 可変条件
        sql1.append(this.GetCondition(TBL_SUB_A));
        sql1.append(" ) " + TBL_A);


        StringBuffer sql2 = new StringBuffer();
        sql2.append(" SELECT ");
        sql2.append(" " + TBL_B + "." + TBTHB5HIK.RECCD);                 // レコード種別
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRBAN);                 // 依頼番号
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRROWBAN);              // 依頼行番号
        sql2.append("," + TBL_B + "." + TBTHB5HIK.TOKUICD);               // 得意先コード
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SYOHIKBN);              // 商品区分
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SYOHINAME);             // 商品区分名称
        sql2.append("," + TBL_B + "." + TBTHB5HIK.TEKICD);                // 摘要コード
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SYBT);                  // 種別（媒体コード）
        sql2.append("," + TBL_B + "." + TBTHB5HIK.MEDIACD);               // メディアコード
        sql2.append("," + TBL_B + "." + TBTHB5HIK.TENCD);                 // 店番
        sql2.append("," + TBL_B + "." + TBTHB5HIK.HOSORYO1);              // 放送料1
        sql2.append("," + TBL_B + "." + TBTHB5HIK.HOSORYO2);              // 放送料2
        sql2.append("," + TBL_B + "." + TBTHB5HIK.HOSORYO3);              // 放送料3
        sql2.append("," + TBL_B + "." + TBTHB5HIK.HOSORYO4);              // 放送料4
        sql2.append("," + TBL_B + "." + TBTHB5HIK.HOSORYO5);              // 放送料5
        sql2.append("," + TBL_B + "." + TBTHB5HIK.HOSORYO6);              // 放送料6
        sql2.append("," + TBL_B + "." + TBTHB5HIK.KEISAITANKA);           // 掲載単価
        sql2.append("," + TBL_B + "." + TBTHB5HIK.KEISAIRYO);             // 掲載料
        sql2.append("," + TBL_B + "." + TBTHB5HIK.ANSYUBE);               // 按分種別
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRMONTH1);              // 依頼月1
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRMONTH2);              // 依頼月2
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRMONTH3);              // 依頼月3
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRMONTH4);              // 依頼月4
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRMONTH5);              // 依頼月5
        sql2.append("," + TBL_B + "." + TBTHB5HIK.IRMONTH6);              // 依頼月6
        sql2.append("," + TBL_B + "." + TBTHB5HIK.KEITAICD);              // 形態区分コード
        sql2.append("," + TBL_B + "." + TBTHB5HIK.KEITAINAME);            // 形態区分名
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SAIKBN);                // 細目区分
        sql2.append("," + TBL_B + "." + TBTHB5HIK.RIRENO);                // 履歴管理番号
        sql2.append("," + TBL_B + "." + TBTHB5HIK.BIKOU1);                // 備考1
        sql2.append("," + TBL_B + "." + TBTHB5HIK.BIKOU2);                // 備考2
        sql2.append("," + TBL_B + "." + TBTHB5HIK.PLACECD);               // 掲載場所コード
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SYBT1CD);               // 種別１コード
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SYBT2CD);               // 種別２コード
        sql2.append("," + TBL_B + "." + TBTHB5HIK.COLORCD);               // 色刷コード
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SIZECD);                // サイズコード
        sql2.append("," + TBL_B + "." + TBTHB5HIK.SPACECD);               // スペースコード
        sql2.append("," + TBL_B + "." + TBTHB5HIK.KOTUKEICD);             // 交通掲載コード
        sql2.append("," + TBL_B + "." + SYBT_CD);                         // 種別コード
        sql2.append(" FROM ");
        // 発注取込 -----------------------------------------------------------------------------------------
        sql2.append(" (SELECT ");
        sql2.append("     " + TBL_SUB_A + "." + TBTHB5HIK.RECCD);         // レコード種別
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRBAN);         // 依頼番号
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRROWBAN);      // 依頼行番号
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.TOKUICD);       // 得意先コード
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYOHIKBN);      // 商品区分
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYOHINAME);     // 商品区分名称
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.TEKICD);        // 摘要コード
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYBT);          // 種別（媒体コード）
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.MEDIACD);       // メディアコード
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.TENCD);         // 店番
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO1);      // 放送料1
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO2);      // 放送料2
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO3);      // 放送料3
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO4);      // 放送料4
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO5);      // 放送料5
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.HOSORYO6);      // 放送料6
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEISAITANKA);   // 掲載単価
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEISAIRYO);   // 掲載料
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.ANSYUBE);       // 按分種別
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH1);      // 依頼月1
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH2);      // 依頼月2
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH3);      // 依頼月3
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH4);      // 依頼月4
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH5);      // 依頼月5
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.IRMONTH6);      // 依頼月6
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEITAICD);      // 形態区分コード
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KEITAINAME);    // 形態区分名
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SAIKBN);        // 細目区分
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.RIRENO);        // 履歴管理番号
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.BIKOU1);        // 備考1
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.BIKOU2);        // 備考2
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.PLACECD);       // 掲載場所コード
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYBT1CD);       // 種別１コード
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SYBT2CD);       // 種別２コード
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.COLORCD);       // 色刷コード
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SIZECD);        // サイズコード
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.SPACECD);       // スペースコード
        sql2.append("    ," + TBL_SUB_A + "." + TBTHB5HIK.KOTUKEICD);     // 交通掲載コード
        sql2.append("    ,CASE TRIM(" + TBL_SUB_A + "." + TBTHB5HIK.SYBT + ")");
        sql2.append("         WHEN '21' THEN '02'");
        sql2.append("         WHEN '22' THEN '03'");
        sql2.append("         WHEN '31' THEN '06'");
        sql2.append("         WHEN '11' THEN");
        sql2.append("             CASE TRIM(" + TBL_SUB_A + "." + TBTHB5HIK.SAIKBN + ")");
        sql2.append("                 WHEN '1' THEN '04'");
        sql2.append("                 WHEN '2' THEN '04'");
        sql2.append("                 WHEN '4' THEN '05'");
        sql2.append("                 WHEN '5' THEN '05'");
        sql2.append("             END");
        sql2.append("         END AS " + SYBT_CD);                        // 種別コード
        sql2.append("    FROM ");
        sql2.append(" " + TBTHB5HIK.TBNAME + " " + TBL_SUB_A);
        sql2.append(",(SELECT");
        sql2.append("     " + TBTHB5HIK.RECCD);                                                  // レコード種別
        sql2.append("    ," + TBTHB5HIK.IRBAN);                                                  // 依頼番号
        sql2.append("    ," + TBTHB5HIK.IRROWBAN);                                               // 依頼行番号
        sql2.append("    ,MAX(" + TBTHB5HIK.RIRENO + ") AS " + TBTHB5HIK.RIRENO);                // 履歴管理番号
        sql2.append(" FROM ");
        sql2.append("     " + TBTHB5HIK.TBNAME);
        sql2.append(" WHERE ");
        sql2.append("     " + TBTHB5HIK.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");       // 依頼番号
        sql2.append(" AND " + TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");    // 依頼行番号
        sql2.append(" AND " + TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");    // 履歴管理番号
        sql2.append(" GROUP BY ");
        sql2.append(" " + TBTHB5HIK.RECCD);                                                      // レコード種別
        sql2.append("," + TBTHB5HIK.IRBAN);                                                      // 依頼番号
        sql2.append("," + TBTHB5HIK.IRROWBAN);                                                   // 依頼行番号
        sql2.append(") " + TBL_SUB_B);
        sql2.append(" WHERE ");
        // 結合条件
        sql2.append("     " + TBL_SUB_B + "." + TBTHB5HIK.RECCD + "       = " + TBL_SUB_A + "." + TBTHB5HIK.RECCD);
        sql2.append(" AND " + TBL_SUB_B + "." + TBTHB5HIK.IRBAN + "       = " + TBL_SUB_A + "." + TBTHB5HIK.IRBAN);
        sql2.append(" AND " + TBL_SUB_B + "." + TBTHB5HIK.IRROWBAN + "    = " + TBL_SUB_A + "." + TBTHB5HIK.IRROWBAN);
        sql2.append(" AND " + TBL_SUB_B + "." + TBTHB5HIK.RIRENO + "      = " + TBL_SUB_A + "." + TBTHB5HIK.RIRENO);
        // 検索条件
        sql2.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql2.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql2.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql2.append(" AND " + TBL_SUB_A + "." + TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        // 可変条件
        sql2.append(this.GetConditionDiff(TBL_SUB_A));
        // 広告費明細テーブルに存在するレコードが対象
        sql2.append(" AND EXISTS(");
        sql2.append("         SELECT");
        sql2.append("            'X'");
        sql2.append("        FROM");
        sql2.append("            " + TBTHB2KMEI.TBNAME);
        sql2.append("        WHERE");
        sql2.append("            " + TBTHB2KMEI.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql2.append("        AND " + TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql2.append("        AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql2.append("        AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql2.append("        AND " + TBTHB2KMEI.YYMM  + "       = '" + _cond.getYymm() + "'");
        sql2.append("        AND TRIM(" + TBTHB2KMEI.CODE1 + ") IN (" + _cond.getSybt() + ")");
        sql2.append("        AND TRIM(" + TBTHB2KMEI.CODE3 + ") = " + TBL_SUB_A + "." + TBTHB5HIK.IRBAN);
        sql2.append("        GROUP BY");
        sql2.append("            " + TBTHB2KMEI.CODE3);
        sql2.append("    )");
        sql2.append(" ) " + TBL_B);


        // SQL文字列の結合
        StringBuffer sql = new StringBuffer();
        // ==============================================================================================================
        // SELECT句
        // ==============================================================================================================
        sql.append(" SELECT ");
        sql.append(" " + TBL_AA + "." + TBTHB5HIK.RECCD);                                 // レコード種別
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRBAN);                                 // 依頼番号
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRROWBAN);                              // 依頼行番号
        sql.append("," + TBL_AA + "." + TBTHB5HIK.TOKUICD);                               // 得意先コード
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SYOHIKBN);                              // 商品区分
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SYOHINAME);                             // 商品区分名称
        sql.append("," + TBL_AA + "." + TBTHB5HIK.TEKICD);                                // 摘要コード
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SYBT);                                  // 種別（媒体コード）
        sql.append("," + TBL_AA + "." + TBTHB5HIK.MEDIACD);                               // メディアコード
        sql.append("," + TBL_AA + "." + TBTHB5HIK.TENCD);                                 // 店番
        sql.append("," + TBL_AA + "." + TBTHB5HIK.HOSORYO1);                              // 放送料1
        sql.append("," + TBL_AA + "." + TBTHB5HIK.HOSORYO2);                              // 放送料2
        sql.append("," + TBL_AA + "." + TBTHB5HIK.HOSORYO3);                              // 放送料3
        sql.append("," + TBL_AA + "." + TBTHB5HIK.HOSORYO4);                              // 放送料4
        sql.append("," + TBL_AA + "." + TBTHB5HIK.HOSORYO5);                              // 放送料5
        sql.append("," + TBL_AA + "." + TBTHB5HIK.HOSORYO6);                              // 放送料6
        sql.append("," + TBL_AA + "." + TBTHB5HIK.KEISAITANKA);                           // 掲載単価
        sql.append("," + TBL_AA + "." + TBTHB5HIK.KEISAIRYO);                             // 掲載料
        sql.append("," + TBL_AA + "." + TBTHB5HIK.ANSYUBE);                               // 按分種別
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRMONTH1);                              // 依頼月1
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRMONTH2);                              // 依頼月2
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRMONTH3);                              // 依頼月3
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRMONTH4);                              // 依頼月4
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRMONTH5);                              // 依頼月5
        sql.append("," + TBL_AA + "." + TBTHB5HIK.IRMONTH6);                              // 依頼月6
        sql.append("," + TBL_AA + "." + TBTHB5HIK.KEITAICD);                              // 形態区分コード
        sql.append("," + TBL_AA + "." + TBTHB5HIK.KEITAINAME);                            // 形態区分名
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SAIKBN);                                // 細目区分
        sql.append("," + TBL_AA + "." + TBTHB5HIK.RIRENO);                                // 履歴管理番号
        sql.append("," + TBL_AA + "." + TBTHB5HIK.BIKOU1);                                // 備考1
        sql.append("," + TBL_AA + "." + TBTHB5HIK.BIKOU2);                                // 備考2
        sql.append("," + TBL_AA + "." + TBTHB5HIK.PLACECD);                               // 掲載場所コード
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SYBT1CD);                               // 種別１コード
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SYBT2CD);                               // 種別２コード
        sql.append("," + TBL_AA + "." + TBTHB5HIK.COLORCD);                               // 色刷コード
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SIZECD);                                // サイズコード
        sql.append("," + TBL_AA + "." + TBTHB5HIK.SPACECD);                               // スペースコード
        sql.append("," + TBL_AA + "." + TBTHB5HIK.KOTUKEICD);                             // 交通掲載コード
        sql.append("," + TBL_AA + "." + SYBT_CD);                                         // 種別コード
        sql.append("," + TBL_C + "." + TBTHBAMST.FIELD3 + " AS " + MEDIA_NM);             // メディア名
        sql.append("," + TBL_D + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_KEIBAS_NM);       // 掲載場所名称
        sql.append("," + TBL_E + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SYBT1_NM);        // 種別1名称
        sql.append("," + TBL_F + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SYBT2_NM);        // 種別2名称
        sql.append("," + TBL_G + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SISAT_NM);        // 色刷名称
        sql.append("," + TBL_H + "." + TBTHBAMST.FIELD3 + " AS " + ZASI_SIZE_NM);         // 雑誌サイズ名称
        sql.append("," + TBL_J + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SIZE_NM);         // 新聞スペース名称
        sql.append("," + TBL_I + "." + TBTHBAMST.FIELD3 + " AS " + DEMP_KOTKEI_NM);       // 交通掲載名称

        // ==============================================================================================================
        // FROM句
        // ==============================================================================================================
        sql.append(" FROM ");
        sql.append(" ( ");
        sql.append(sql1.toString());    // SQL1
        sql.append(" UNION ");
        sql.append(sql2.toString());    // SQL2
        sql.append(" ) " + TBL_AA);

        // メディアコード変換マスタ -------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '910'");
        sql.append(" ) " + TBL_C);

        // 掲載場所変換マスタ ----------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '906'");
        sql.append(" ) " + TBL_D);

        // 記雑コード変換マスタ ---------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '908'");
        sql.append(" ) " + TBL_E);

        // 朝夕コード変換マスタ ---------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '909'");
        sql.append(" ) " + TBL_F);

        // 色刷変換マスタ ---------------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '911'");
        sql.append(" ) " + TBL_G);

        // サイズコード変換マスタ(雑誌) ------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '907'");
        sql.append(" ) " + TBL_H);

        // サイズコード変換マスタ(新聞) ------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '907'");
        sql.append(" ) " + TBL_J);

        // 掲載場所変換マスタ ----------------------------------------------------------------------------
        sql.append(",(SELECT");
        sql.append("     TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("    ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append(" FROM ");
        sql.append("     " + TBTHBAMST.TBNAME);
        sql.append(" WHERE ");
        sql.append("     " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHBAMST.SYBT  + "       = '906'");
        sql.append(" ) " + TBL_I);

        // ==============================================================================================================
        // WHERE句
        // ==============================================================================================================
        sql.append(" WHERE ");
        // 結合条件
        sql.append("     " + TBL_C + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_C + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.MEDIACD + ")");
        sql.append(" AND " + TBL_D + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_D + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.PLACECD + ")");
        sql.append(" AND " + TBL_E + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_E + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.SYBT1CD + ")");
        sql.append(" AND " + TBL_F + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_F + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.SYBT2CD + ")");
        sql.append(" AND " + TBL_G + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_G + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.COLORCD + ")");
        sql.append(" AND " + TBL_H + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_H + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.SIZECD + ")");
        sql.append(" AND " + TBL_J + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_J + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.SPACECD + ")");
        sql.append(" AND " + TBL_I + "." + TBTHBAMST.FIELD1 + " (+)= TRIM(" + TBL_AA + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_I + "." + TBTHBAMST.FIELD2 + " (+)= TRIM(" + TBL_AA + "." + TBTHB5HIK.KOTUKEICD + ")");

        return sql.toString();
    }

    /**
     * 請求データ 一覧情報取得のSQL文を返します。
     *
     * @return String SQL文
     */
    private String getSelectSQLForClaimData() {

        StringBuffer sql = new StringBuffer();

        // ============================================================================================================================================
        // SELECT句
        // ============================================================================================================================================
        sql.append(" SELECT ");
        // 広告費明細テーブルデータ
        sql.append(" " + TBL_A + "." + TBTHB2KMEI.TIMSTMP);
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE3);                           // 依頼番号（発注番号）
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE4);                           // 依頼行番号（発注行番号）
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA5);                         // 取引先コード
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME2);                           // 会社名
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE5);                           // 請求部署コード
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE1);                           // 請求年月日
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA1);                         // 請求書番号
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA2);                         // 請求書行番号
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE2);                           // 支払日
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA3);                         // 商品区分
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME1);                           // 商品区分名称
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE6);                           // 摘要コード
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE1);                           // 媒体コード
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE2);                           // メディアコード
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA4);                         // 店番
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SEIGAK);                          // 金額
        sql.append("," + TBL_A + "." + TBTHB2KMEI.KNGK1);                           // 消費税
        sql.append("," + TBL_A + "." + TBTHB2KMEI.MEIHNFLG);                        // 按分種別
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA6);                         // 区分
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA9);                         // 掲載日（新聞・雑誌）
        sql.append("," + TBL_A + "." + TBTHB2KMEI.HNNERT);                          // 値引率
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NEBIGAK);                         // 値引額
        sql.append("," + TBL_A + "." + TBTHB2KMEI.RITU1);                           // 消費税率
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYUTNO);                          // 受注No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYMEINO);                         // 受注明細No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.URMEINO);                         // 売上明細No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE3);                           // 登録年月日
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE4);                           // 変更年月日
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE5);                           // 取消年月日
        sql.append("," + TBL_A + "." + TBTHB2KMEI.KBN1);                            // 処理区分
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME7);                           // 出力日時
        sql.append("," + TBL_A + "." + TBTHB2KMEI.RENBN);                           // 連番
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA7);                         // 掲載単価
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME11);                          // 名称11(漢字)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME12);                          // 名称12(漢字)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME13);                          // 名称13(漢字)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME14);                          // 名称14(漢字)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME15);                          // 名称15(漢字)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME16);                          // 名称16(漢字)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.NAME17);                          // 名称17(漢字)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.KBN2);                            // 値引行区分
        sql.append("," + TBL_K + "." + TBTHB5HIK.SAIKBN);                           // 細目区分
        // 受注ダウンロードテーブルデータ
        sql.append("," + TBL_B + "." + TBTHB1DOWN.FIELD4);                          // 放送期間（スポット）
        sql.append("," + TBL_B + "." + TBTHB1DOWN.FIELD8);                          // 放送期間（タイム）
        sql.append("," + TBL_B + "." + TBTHB1DOWN.FIELD9);                          // スペース（雑誌）
        sql.append("," + TBL_B + "." + TBTHB1DOWN.FIELD11);                         // スペース（新聞）
        sql.append("," + TBL_B + "." + TBTHB1DOWN.KKNAMEKJ);                        // 件名
        sql.append("," + TBL_B + "." + TBTHB1DOWN.TMSPKBN);                         // タイムスポット区分
        sql.append("," + TBL_B + "." + TBTHB1DOWN.KOKKBN);                          // 国際区分
        // 以下、マスタ取得データ
        sql.append("," + TBL_C + "." + TBTHBAMST.FIELD3 + " AS " + MEDIA_NM);       // メディア名
        sql.append("," + TBL_D + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_KEIBAS_NM); // 新聞_掲載場所名称(電波_交通掲載名称)
        sql.append("," + TBL_E + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SYBT1_NM);  // 新聞_種別1名称
        sql.append("," + TBL_F + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SYBT2_NM);  // 新聞_種別2名称
        sql.append("," + TBL_H + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SISAT_NM);  // 新聞_色刷名称
        sql.append("," + TBL_J + "." + TBTHBAMST.FIELD3 + " AS " + SNBN_SIZE_NM);   // 新聞_サイズ名称
        sql.append("," + TBL_G + "." + TBTHBAMST.FIELD3 + " AS " + ZASI_SISAT_NM);  // 雑誌_色刷名称
        sql.append("," + TBL_I + "." + TBTHBAMST.FIELD3 + " AS " + ZASI_SIZE_NM);   // 雑誌_サイズ名称

        // ============================================================================================================================================
        // FROM句
        // ============================================================================================================================================
        sql.append(" FROM");

        // 広告費明細テーブル ----------------------------------------------------------------------------
        sql.append("    (SELECT");
        sql.append("     " + TBTHB2KMEI.EGCD);                                                                       // 営業所（取）コード
        sql.append("    ," + TBTHB2KMEI.TKSKGYCD);                                                                   // 得意先企業コード
        sql.append("    ," + TBTHB2KMEI.TKSBMNSEQNO);                                                                // 得意先部門SEQNO
        sql.append("    ," + TBTHB2KMEI.TKSTNTSEQNO);                                                                // 得意先担当SEQNO
        sql.append("    ," + TBTHB2KMEI.YYMM);                                                                       // 年月
        sql.append("    ,TO_CHAR(" + TBTHB2KMEI.TIMSTMP + ", 'YYYY/MM/DD HH24:MI:SS') AS " + TBTHB2KMEI.TIMSTMP);    // タイムスタンプ
        sql.append("    ," + TBTHB2KMEI.CODE3);                                                                      // 依頼番号（発注番号）
        sql.append("    ," + TBTHB2KMEI.CODE4);                                                                      // 依頼行番号（発注行番号）
        sql.append("    ," + TBTHB2KMEI.SONOTA5);                                                                    // 取引先コード
        sql.append("    ," + TBTHB2KMEI.NAME2);                                                                      // 会社名
        sql.append("    ," + TBTHB2KMEI.CODE5);                                                                      // 請求部署コード
        sql.append("    ," + TBTHB2KMEI.DATE1);                                                                      // 請求年月日
        sql.append("    ," + TBTHB2KMEI.SONOTA1);                                                                    // 請求書番号
        sql.append("    ," + TBTHB2KMEI.SONOTA2);                                                                    // 請求書行番号
        sql.append("    ," + TBTHB2KMEI.DATE2);                                                                      // 支払日
        sql.append("    ," + TBTHB2KMEI.SONOTA3);                                                                    // 商品区分
        sql.append("    ," + TBTHB2KMEI.NAME1);                                                                      // 商品区分名称
        sql.append("    ," + TBTHB2KMEI.CODE6);                                                                      // 摘要コード
        sql.append("    ," + TBTHB2KMEI.CODE1);                                                                      // 媒体コード
        sql.append("    ," + TBTHB2KMEI.CODE2);                                                                      // メディアコード
        sql.append("    ,CASE WHEN TRIM(" + TBTHB2KMEI.MEIHNFLG + ") <> '1' THEN");                                  // 按分種別が「1：定率按分」以外の場合のみ、店番を設定する
        sql.append("         " + TBTHB2KMEI.SONOTA4);
        sql.append("          ELSE ''");
        sql.append("     END AS " + TBTHB2KMEI.SONOTA4);                                                             // 店番
        sql.append("    ,NVL(" + TBTHB2KMEI.SEIGAK + ", 0) AS " + TBTHB2KMEI.SEIGAK);                                // 金額
        sql.append("    ,NVL(" + TBTHB2KMEI.KNGK1 + ",  0) AS " + TBTHB2KMEI.KNGK1);                                 // 消費税
        sql.append("    ," + TBTHB2KMEI.MEIHNFLG);                                                                   // 按分種別
        sql.append("    ," + TBTHB2KMEI.SONOTA6);                                                                    // 区分
        sql.append("    ," + TBTHB2KMEI.SONOTA9);                                                                    // 掲載日（新聞・雑誌）
        sql.append("    ," + TBTHB2KMEI.HNNERT);                                                                     // 値引率
        sql.append("    ," + TBTHB2KMEI.NEBIGAK);                                                                    // 値引額
        sql.append("    ," + TBTHB2KMEI.RITU1);                                                                      // 消費税率
        sql.append("    ," + TBTHB2KMEI.JYUTNO);                                                                     // 受注No
        sql.append("    ," + TBTHB2KMEI.JYMEINO);                                                                    // 受注明細No
        sql.append("    ," + TBTHB2KMEI.URMEINO);                                                                    // 売上明細No
        sql.append("    ," + TBTHB2KMEI.DATE3);                                                                      // 登録年月日
        sql.append("    ," + TBTHB2KMEI.DATE4);                                                                      // 変更年月日
        sql.append("    ," + TBTHB2KMEI.DATE5);                                                                      // 取消年月日
        sql.append("    ," + TBTHB2KMEI.KBN1);                                                                       // 処理区分
        sql.append("    ," + TBTHB2KMEI.NAME7);                                                                      // 出力日時
        sql.append("    ," + TBTHB2KMEI.RENBN);                                                                      // 連番
        sql.append("    ," + TBTHB2KMEI.SONOTA7);                                                                    // 掲載単価
        sql.append("    ,NVL(" + TBTHB2KMEI.NAME11 + ", '') AS " + TBTHB2KMEI.NAME11);                               // 名称11(漢字)
        sql.append("    ,NVL(" + TBTHB2KMEI.NAME12 + ", '') AS " + TBTHB2KMEI.NAME12);                               // 名称12(漢字)
        sql.append("    ,NVL(" + TBTHB2KMEI.NAME13 + ", '') AS " + TBTHB2KMEI.NAME13);                               // 名称13(漢字)
        sql.append("    ,NVL(" + TBTHB2KMEI.NAME14 + ", '') AS " + TBTHB2KMEI.NAME14);                               // 名称14(漢字)
        sql.append("    ,NVL(" + TBTHB2KMEI.NAME15 + ", '') AS " + TBTHB2KMEI.NAME15);                               // 名称15(漢字)
        sql.append("    ,NVL(" + TBTHB2KMEI.NAME16 + ", '') AS " + TBTHB2KMEI.NAME16);                               // 名称16(漢字)
        sql.append("    ,NVL(" + TBTHB2KMEI.NAME17 + ", '') AS " + TBTHB2KMEI.NAME17);                               // 名称17(漢字)
        sql.append("    ,NVL(TRIM(" + TBTHB2KMEI.KBN2 + ")  , '') AS " + TBTHB2KMEI.KBN2);                           // 値引行区分
        sql.append("    ,CASE TRIM(" + TBTHB2KMEI.CODE1 + ")");
        sql.append("         WHEN '21' THEN '02'");
        sql.append("         WHEN '22' THEN '03'");
        sql.append("         WHEN '31' THEN '06'");
        sql.append("         WHEN '11' THEN");
        sql.append("             CASE TRIM(" + TBTHB2KMEI.SONOTA6 + ")");
        sql.append("                 WHEN '05' THEN '04'");
        sql.append("                 WHEN '07' THEN '04'");
        sql.append("                 WHEN '03' THEN '05'");
        sql.append("                 WHEN '04' THEN '05'");
        sql.append("             END");
        sql.append("     END AS " + SYBT_CD);                                                                        // 種別コード
        sql.append("     FROM");
        sql.append("         " + TBTHB2KMEI.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHB2KMEI.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHB2KMEI.YYMM  + "       = '" + _cond.getYymm() + "'");
        sql.append("     AND " + TBTHB2KMEI.CODE1 + "       IN(" + _cond.getSybt() + ")");
        sql.append("    ) " + TBL_A);

        // 受注ダウンロードテーブル -------------------------------------------------------------------------
        sql.append("   ," + TBTHB1DOWN.TBNAME + " " + TBL_B);

        // メディアコード変換マスタ -------------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // フィールド4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '910'");
        sql.append("    ) " + TBL_C);

        // 掲載場所変換マスタ ----------------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // フィールド4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '906'");
        sql.append("    ) " + TBL_D);

        // 記雑コード変換マスタ ---------------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // フィールド4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '908'");
        sql.append("    ) " + TBL_E);

        // 朝夕コード変換マスタ ---------------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // フィールド4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '909'");
        sql.append("    ) " + TBL_F);

        // 色刷変換マスタ(雑誌) --------------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // フィールド4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '911'");
        sql.append("    ) " + TBL_G);

        // 色刷変換マスタ(新聞) --------------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // フィールド4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '911'");
        sql.append("    ) " + TBL_H);

        // サイズコード変換マスタ(雑誌) ----------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // フィールド4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '907'");
        sql.append("    ) " + TBL_I);

        // サイズコード変換マスタ(新聞) ----------------------------------------------------------------------
        sql.append("   ,(SELECT");
        sql.append("         TRIM(" + TBTHBAMST.FIELD1 + ") AS " + TBTHBAMST.FIELD1);    // フィールド1
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD2 + ") AS " + TBTHBAMST.FIELD2);    // フィールド2
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD3 + ") AS " + TBTHBAMST.FIELD3);    // フィールド3
        sql.append("        ,TRIM(" + TBTHBAMST.FIELD4 + ") AS " + TBTHBAMST.FIELD4);    // フィールド4
        sql.append("     FROM");
        sql.append("         " + TBTHBAMST.TBNAME);
        sql.append("     WHERE");
        sql.append("         " + TBTHBAMST.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append("     AND " + TBTHBAMST.SYBT  + "       = '907'");
        sql.append("    ) " + TBL_J);

        // 発注取込 -----------------------------------------------------------------------------------------
        sql.append("    ,(SELECT");
        sql.append("         " + TBTHB5HIK.IRBAN  );                                        // 依頼番号（発注番号）
        sql.append("        ," + TBTHB5HIK.IRROWBAN  );                                     // 依頼行番号（発注行番号）
        sql.append("        ,NVL(" + TBTHB5HIK.SAIKBN + ", '') AS " + TBTHB5HIK.SAIKBN);    // 細目区分
        sql.append("     FROM ");
        sql.append("         " + TBTHB5HIK.TBNAME);
        sql.append("     WHERE ");
        sql.append("         " + TBTHB5HIK.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        // 可変条件
        sql.append(this.GetCondition(""));
        sql.append("     GROUP BY");
        sql.append("         " + TBTHB5HIK.IRBAN  );
        sql.append("        ," + TBTHB5HIK.IRROWBAN  );
        sql.append("        ," + TBTHB5HIK.SAIKBN );
        sql.append("     UNION ");
        sql.append("     SELECT");
        sql.append("         " + TBTHB5HIK.IRBAN  );                                        // 依頼番号（発注番号）
        sql.append("        ," + TBTHB5HIK.IRROWBAN  );                                     // 依頼行番号（発注行番号）
        sql.append("        ,NVL(" + TBTHB5HIK.SAIKBN + ", '') AS " + TBTHB5HIK.SAIKBN);    // 細目区分
        sql.append("     FROM ");
        sql.append("         " + TBTHB5HIK.TBNAME);
        sql.append("     WHERE ");
        sql.append("         " + TBTHB5HIK.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append("     AND " + TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append("     AND " + TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        // 可変条件
        sql.append(this.GetConditionDiff(""));
        sql.append("     GROUP BY");
        sql.append("         " + TBTHB5HIK.IRBAN  );
        sql.append("        ," + TBTHB5HIK.IRROWBAN  );
        sql.append("        ," + TBTHB5HIK.SAIKBN );
        sql.append("    ) " + TBL_K);

        // ============================================================================================================================================
        // WHERE句
        // ============================================================================================================================================
        sql.append(" WHERE");
        // 結合条件 -------------------------------------------------------------------------------------------------------
        sql.append("     " + TBL_B + "." + TBTHB1DOWN.EGCD + "        = " + TBL_A + "." + TBTHB2KMEI.EGCD);
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.TKSKGYCD + "    = " + TBL_A + "." + TBTHB2KMEI.TKSKGYCD);
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBL_A + "." + TBTHB2KMEI.TKSBMNSEQNO);
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBL_A + "." + TBTHB2KMEI.TKSTNTSEQNO);
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.YYMM + "        = " + TBL_A + "." + TBTHB2KMEI.YYMM);
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.JYUTNO + "      = " + TBL_A + "." + TBTHB2KMEI.JYUTNO);
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.JYMEINO + "     = " + TBL_A + "." + TBTHB2KMEI.JYMEINO);
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.URMEINO + "     = " + TBL_A + "." + TBTHB2KMEI.URMEINO);
        sql.append(" AND " + TBL_C + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_C + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.CODE2 + ")");
        sql.append(" AND " + TBL_D + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_D + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.NAME11 + ")");
        sql.append(" AND " + TBL_E + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_E + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.NAME12 + ")");
        sql.append(" AND " + TBL_F + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_F + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.NAME13 + ")");
        sql.append(" AND " + TBL_G + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_G + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.NAME11 + ")");
        sql.append(" AND " + TBL_H + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_H + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.NAME14 + ")");
        sql.append(" AND " + TBL_I + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_I + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.NAME12 + ")");
        sql.append(" AND " + TBL_J + "." + TBTHBAMST.FIELD1 + "    (+)= TRIM(" + TBL_A + "." + SYBT_CD + ")");
        sql.append(" AND " + TBL_J + "." + TBTHBAMST.FIELD2 + "    (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.NAME15 + ")");
        sql.append(" AND " + TBL_K + "." + TBTHB5HIK.IRBAN + "     (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.CODE3 + ")");
        sql.append(" AND " + TBL_K + "." + TBTHB5HIK.IRROWBAN + "  (+)= TRIM(" + TBL_A + "." + TBTHB2KMEI.CODE4 + ")");
        // 検索条件 -------------------------------------------------------------------------------------------------------
        sql.append(" AND " + TBL_B + "." + TBTHB1DOWN.TJYUTNO + " = ' '");

        // ============================================================================================================================================
        // ORDER BY句
        // ============================================================================================================================================
        sql.append(" ORDER BY");
        sql.append(" " + TBL_A + "." + TBTHB2KMEI.CODE3);        // コード3(発注番号)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.SONOTA1);      // その他1(請求書番号)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.DATE1);        // 日付1(請求書発行日)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.KBN2);         // 区分2(値引行区分)
        sql.append("," + TBL_A + "." + TBTHB2KMEI.CODE4);        // 発注行番号
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYUTNO);       // 受注No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.JYMEINO);      // 受注明細No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.URMEINO);      // 売上明細No
        sql.append("," + TBL_A + "." + TBTHB2KMEI.RENBN);        // 連番

        return sql.toString();
    }

    /**
     * 値引マスタ 情報取得のSQL文を返します。
     *
     * @return String SQL文
     */
    private String getSelectSQLForNebiki() {

        StringBuffer sql = new StringBuffer();

        // ====================================================================================================
        // SELECT句
        // ====================================================================================================
        sql.append(" SELECT ");
        sql.append("  " + TBL_A + ".MEU19_NBIKSINSEINO");    //
        sql.append(" ," + TBL_B + ".MEU1A_GYOMKBN");         // 業務区分
        sql.append(" ," + TBL_B + ".MEU1A_BTAICD");          // 媒体コード（メディアコード）
        sql.append(" ," + TBL_B + ".MEU1A_HMOKCD");          // 費目コード
        sql.append(" ," + TBL_B + ".MEU1A_NBIKRITU");        // 値引率

        // ====================================================================================================
        // FROM句
        // ====================================================================================================
        sql.append(" FROM");
        sql.append("  rcmn_MEU19NBJK    " + TBL_A);
        sql.append(" ,rcmn_MEU1ANBNAIYO " + TBL_B);

        // ====================================================================================================
        // WHERE句
        // ====================================================================================================
        sql.append(" WHERE");
        sql.append("     " + TBL_A + ".MEU19_THSKGYCD      = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBL_A + ".MEU19_SEQNO         = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBL_A + ".MEU19_TRTNTSEQNO    = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBL_A + ".MEU19_TYSYMD       <= '" + _cond.getKeisaiDay() + "'");
        sql.append(" AND " + TBL_A + ".MEU19_TYEYMD       >= '" + _cond.getKeisaiDay() + "'");
        sql.append(" AND " + TBL_A + ".MEU19_ENDYMD        = '99999999'");

        // 結合条件 ---------------------------------------------------------------------------------------------
        sql.append(" AND " + TBL_A + ".MEU19_THSKGYCD      = " + TBL_B + ".MEU1A_THSKGYCD");
        sql.append(" AND " + TBL_A + ".MEU19_SEQNO         = " + TBL_B + ".MEU1A_SEQNO");
        sql.append(" AND " + TBL_A + ".MEU19_TRTNTSEQNO    = " + TBL_B + ".MEU1A_TRTNTSEQNO");
        sql.append(" AND " + TBL_A + ".MEU19_NBIKSINSEINO  = " + TBL_B + ".MEU1A_NBIKSINSEINO");

        // ====================================================================================================
        // ORDER BY句
        // ====================================================================================================
        sql.append(" ORDER BY");
        sql.append(" " + TBL_A + ".MEU19_NBIKSINSEINO");
        sql.append("," + TBL_A + ".MEU19_KESYM");

        return sql.toString();
    }

    /**
     * 可変の検索条件を取得する
     * @param  tblName テーブル名
     * @return 可変の検索条件
     */
    private String GetCondition(String tblName) {

        StringBuffer buff = new StringBuffer();

        // 検索条件．種別の要素取得（カンマ区切りの為、分割して取得する）
        String[] baitai = _cond.getSybt().replace("\'","").split(",");

        // テーブル名の設定
        String tblStr = "";
        if (tblName.equals("")) {
            tblStr = "";
        }
        else {
            tblStr = tblName + ".";
        }

        for (int i = 0; i < baitai.length; i++) {

            // 種別が「21:新聞」の場合
            if (FindClaimByCondManager.C_BAITAI_SHINBUN.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // 検索条件の設定
                StringBuffer temp = new StringBuffer();
                temp.append("(");
                temp.append(tblStr + TBTHB5HIK.SYBT + " = '" + FindClaimByCondManager.C_BAITAI_SHINBUN + "'");
                temp.append(" AND ");
                temp.append(tblStr + TBTHB5HIK.URIYYMM + " = '" + _cond.getYymm() + "'");
                temp.append(")");

                buff.append(temp.toString());

            // 種別が「22:雑誌」の場合
            } else if (FindClaimByCondManager.C_BAITAI_ZASHI.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // 検索条件の設定
                StringBuffer temp = new StringBuffer();
                temp.append("(");
                temp.append(tblStr + TBTHB5HIK.SYBT + " = '" + FindClaimByCondManager.C_BAITAI_ZASHI + "'");
                temp.append(" AND ");
                temp.append(tblStr + TBTHB5HIK.URIYYMM + " = '" + _cond.getYymm() + "'");
                temp.append(")");

                buff.append(temp.toString());

            // 種別が「11:電波」の場合
            } else if (FindClaimByCondManager.C_BAITAI_DENPA.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // 検索条件の設定
                StringBuffer temp = new StringBuffer();
                temp.append(" ( ");
                temp.append(tblStr + TBTHB5HIK.SYBT + " = '" + FindClaimByCondManager.C_BAITAI_DENPA + "'");
                temp.append(" AND ");
                temp.append(" ( ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH1 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO1 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH2 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO2 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH3 + ") = '" + _cond.getYymm() + "'");
                temp.append("  AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO3 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH4 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO4 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH5 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO5 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" (");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH6 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO6 + " <> 0");
                temp.append(" ) ");
                temp.append(" ) ");
                temp.append(" ) ");

                buff.append(temp.toString());

            // 種別が「31:交通」の場合
            } else if (FindClaimByCondManager.C_BAITAI_KOTSU.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // 検索条件の設定
                StringBuffer temp = new StringBuffer();
                temp.append("(");
                temp.append(tblStr + TBTHB5HIK.SYBT + " = '" + FindClaimByCondManager.C_BAITAI_KOTSU + "'");
                temp.append(" AND ");
                temp.append(tblStr + TBTHB5HIK.URIYYMM + " = '" + _cond.getYymm() + "'");
                temp.append(")");

                buff.append(temp.toString());
            }
        }

        // 検索条件が指定されている場合は、作成した文字列を返す
        if (0 < buff.toString().length()) {
            return " AND (" +  buff.toString() + ") ";
        } else {
            return "";
        }
    }

    /**
     * 可変の検索条件を取得する
     * @param  tblName テーブル名
     * @return 可変の検索条件
     */
    private String GetConditionDiff(String tblName) {

        StringBuffer buff = new StringBuffer();

        // 検索条件．種別の要素取得（カンマ区切りの為、分割して取得する）
        String[] baitai = _cond.getSybt().replace("\'","").split(",");

        // テーブル名の設定
        String tblStr = "";
        if (tblName.equals("")) {
            tblStr = "";
        }
        else {
            tblStr = tblName + ".";
        }

        for (int i = 0; i < baitai.length; i++) {

            // 種別が「21:新聞」の場合
            if (FindClaimByCondManager.C_BAITAI_SHINBUN.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // 検索条件の設定
                StringBuffer temp = new StringBuffer();
                temp.append("(");
                temp.append(tblStr + TBTHB5HIK.SYBT + " <> '" + FindClaimByCondManager.C_BAITAI_SHINBUN + "'");
                temp.append(" AND ");
                temp.append(tblStr + TBTHB5HIK.URIYYMM + " <> '" + _cond.getYymm() + "'");
                temp.append(")");

                buff.append(temp.toString());

            // 種別が「22:雑誌」の場合
            } else if (FindClaimByCondManager.C_BAITAI_ZASHI.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // 検索条件の設定
                StringBuffer temp = new StringBuffer();
                temp.append("(");
                temp.append(tblStr + TBTHB5HIK.SYBT + " <> '" + FindClaimByCondManager.C_BAITAI_ZASHI + "'");
                temp.append(" AND ");
                temp.append(tblStr + TBTHB5HIK.URIYYMM + " <> '" + _cond.getYymm() + "'");
                temp.append(")");

                buff.append(temp.toString());

            // 種別が「11:電波」の場合
            } else if (FindClaimByCondManager.C_BAITAI_DENPA.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // 検索条件の設定
                StringBuffer temp = new StringBuffer();
                temp.append(" ( ");
                temp.append(tblStr + TBTHB5HIK.SYBT + " = '" + FindClaimByCondManager.C_BAITAI_DENPA + "'");
                temp.append(" AND ");
                temp.append(" NOT ( ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH1 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO1 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH2 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO2 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH3 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO3 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH4 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO4 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH5 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO5 + " <> 0");
                temp.append(" ) ");
                temp.append(" OR ");
                temp.append(" ( ");
                temp.append(" TRIM(" + tblStr + TBTHB5HIK.IRMONTH6 + ") = '" + _cond.getYymm() + "'");
                temp.append(" AND ");
                temp.append(" " + tblStr + TBTHB5HIK.HOSORYO6 + " <> 0");
                temp.append(" ) ");
                temp.append(" ) ");
                temp.append(" ) ");

                buff.append(temp.toString());

            // 種別が「31:交通」の場合
            } else if (FindClaimByCondManager.C_BAITAI_KOTSU.equals(baitai[i].trim())) {

                if (0 < buff.toString().length()) {
                    buff.append(" OR ");
                }

                // 検索条件の設定
                StringBuffer temp = new StringBuffer();
                temp.append("(");
                temp.append(tblStr + TBTHB5HIK.SYBT + " = '" + FindClaimByCondManager.C_BAITAI_KOTSU + "'");
                temp.append(" AND ");
                temp.append(tblStr + TBTHB5HIK.URIYYMM + " = '" + _cond.getYymm() + "'");
                temp.append(")");

                buff.append(temp.toString());
            }
        }

        // 検索条件が指定されている場合は、作成した文字列を返す
        if (0 < buff.toString().length()) {
            return " AND (" +  buff.toString() + ") ";
        } else {
            return "";
        }
    }

    /**
     * 発注/請求番号 一覧情報の検索を行います。
     *
     * @return 発注/請求番号 一覧情報を含むVOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<FindClaimNoCondVO> findClaimNoDataByCondition(
            FindClaimCondition cond) throws KKHException {

        super.setModel(new FindClaimNoCondVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.CLAIMNO;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * 発注/請求 差異一覧情報の検索を行います。
     *
     * @return 発注/請求 差異一覧情報を含むVOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<FindClaimDiffCondVO> findClaimDiffDataByCondition(
            FindClaimCondition cond) throws KKHException {

        super.setModel(new FindClaimDiffCondVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.CLAIMDIFF;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * 請求データ 一覧情報の検索を行います。
     *
     * @return 請求データ 一覧情報を含むVOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<FindClaimCondVO> findClaimDataByCondition(
            FindClaimCondition cond) throws KKHException {

        super.setModel(new FindClaimCondVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.CLAIM;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * 値引マスタ 情報の検索を行います。
     *
     * @return 値引マスタ 情報を含むVOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<FindNebikiCondVO> findNebikiDataByCondition(
            FindClaimCondition cond) throws KKHException {

        super.setModel(new FindNebikiCondVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.NEBIKI;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }
}