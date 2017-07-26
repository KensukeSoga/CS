package jp.co.isid.kkh.integ.tbl;

/**
 *
 * <P>
 * 広告費明細用売上明細VIEW
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/10 JSE H.Abe)<BR>
 * </P>
 */
public class VWTHB_ADMURIAGEM {

    /**
     * インスタンス生成禁止。
     */
    private VWTHB_ADMURIAGEM() {
    }

    /** 広告費明細用売上明細VIEW */
    public static final String TBNAME = "THB_ADMURIAGEM";

    /** 扱営業所コード (ATEGSYOCD) */
    public static final String ATEGSYOCD = "ATEGSYOCD";

    /** 得意先企業コード (TKSKGYCD) */
    public static final String TKSKGYCD = "TKSKGYCD";

    /** 得意先部門ＳＥＱＮＯ (TKSBMNSEQNO) */
    public static final String TKSBMNSEQNO = "TKSBMNSEQNO";

    /** 得意先担当ＳＥＱＮＯ (TKSTNTSEQNO) */
    public static final String TKSTNTSEQNO = "TKSTNTSEQNO";

    /** 受注ＮＯ (JYUTNO) */
    public static final String JYUTNO = "JYUTNO";

    /** 受注明細ＳＥＱ (JYMEISEQ) */
    public static final String JYMEISEQ = "JYMEISEQ";

    /** 売上明細ＳＥＱ (URMEISEQ) */
    public static final String URMEISEQ = "URMEISEQ";

    /** 初期登録日時 (INSDATE) */
    public static final String INSDATE = "INSDATE";

    /** 初期登録担当者コード (INSTNTCD) */
    public static final String INSTNTCD = "INSTNTCD";

    /** 初期登録アプリＩＤ (INSAPLID) */
    public static final String INSAPLID = "INSAPLID";

    /** 最終更新日時 (UPDAPLDATE) */
    public static final String UPDAPLDATE = "UPDAPLDATE";

    /** 最終更新担当者コード (UPDTNTCD) */
    public static final String UPDTNTCD = "UPDTNTCD";

    /** 最終更新オンラインアプリＩＤ (UPDONLAPLID) */
    public static final String UPDONLAPLID = "UPDONLAPLID";

    /** 最終更新バッチアプリＩＤ (UPDBATAPLID) */
    public static final String UPDBATAPLID = "UPDBATAPLID";

    /** 請求状態 (SEIKJTAI) */
    public static final String SEIKJTAI = "SEIKJTAI";

    /** 請求作業ステータス (SEISAGSTS) */
    public static final String SEISAGSTS = "SEISAGSTS";

    /** 中止区分 (STPKBN) */
    public static final String STPKBN = "STPKBN";

}