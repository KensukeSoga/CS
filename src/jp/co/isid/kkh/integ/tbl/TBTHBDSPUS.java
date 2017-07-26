package jp.co.isid.kkh.integ.tbl;

/**
 *
 * <P>
 * 特別ユーザーマスタ
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/10 JSE H.Abe)<BR>
 * </P>
 */
public class TBTHBDSPUS {

    /**
     * インスタンス生成禁止。
     */
    private TBTHBDSPUS() {
    }

    /** 特別ユーザーマスタ */
    public static final String TBNAME = "THBDSPUS";

    /** カラム名のプレフィックス */
    public static final String PREFIX = "HBD_";

    /** 登録タイムスタンプ (TRKTIMSTMP) */
    public static final String TRKTIMSTMP = PREFIX + "TRKTIMSTMP";

    /** 登録プログラム (TRKPL) */
    public static final String TRKPL = PREFIX + "TRKPL";

    /** 登録担当者 (TRKTNT) */
    public static final String TRKTNT = PREFIX + "TRKTNT";

    /** 更新タイムスタンプ (UPDTIMSTMP) */
    public static final String UPDTIMSTMP = PREFIX + "UPDTIMSTMP";

    /** 更新プログラム (UPDAPL) */
    public static final String UPDAPL = PREFIX + "UPDAPL";

    /** 更新担当者 (UPDTNT) */
    public static final String UPDTNT = PREFIX + "UPDTNT";

    /** 営業所コード (EGSCD) */
    public static final String EGSCD = PREFIX + "EGSCD";

    /** 得意先企業コード (TKSKGYCD) */
    public static final String TKSKGYCD = PREFIX + "TKSKGYCD";

    /** 得意先部門SEQNO (TKSBMNSEQNO) */
    public static final String TKSBMNSEQNO = PREFIX + "TKSBMNSEQNO";

    /** 得意先担当SEQNO (TKSTNTSEQNO) */
    public static final String TKSTNTSEQNO = PREFIX + "TKSTNTSEQNO";

    /** 組織コード (SIKCD) */
    public static final String SIKCD = PREFIX + "SIKCD";

    /** ユーザー種別 (USERTYPE) */
    public static final String USERTYPE = PREFIX + "USERTYPE";

    /** ユーザーID (USERID) */
    public static final String USERID = PREFIX + "USERID";

    /** 営業所名 (EGSNM) */
    public static final String EGSNM = PREFIX + "EGSNM";

    /** 得意先企業名 (TKSKGYNM) */
    public static final String TKSKGYNM = PREFIX + "TKSKGYNM";

    /** 得意先部門名 (TKSBMNNM) */
    public static final String TKSBMNNM = PREFIX + "TKSBMNNM";

    /** 得意先担当部署名 (TKSTNTNM) */
    public static final String TKSTNTNM = PREFIX + "TKSTNTNM";

    /** パスワード (PASSWORD) */
    public static final String PASSWORD = PREFIX + "PASSWORD";

    /** ユーザー名（漢字） (USERNMKJ) */
    public static final String USERNMKJ = PREFIX + "USERNMKJ";

    /** ユーザー名（ｶﾅ） (USERNMKN) */
    public static final String USERNMKN = PREFIX + "USERNMKN";

    /** 広告主企業コード (CLNTKGYCD) */
    public static final String CLNTKGYCD = PREFIX + "CLNTKGYCD";

    /** 広告主SEQNO (CLNTSEQNO) */
    public static final String CLNTSEQNO = PREFIX + "CLNTSEQNO";

    /** 旧得意先コード (CLTCD) */
    public static final String CLTCD = PREFIX + "CLTCD";

    /** 削除フラグ (DELFLG) */
    public static final String DELFLG = PREFIX + "DELFLG";

}
