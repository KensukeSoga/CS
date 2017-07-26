package jp.co.isid.kkh.integ.tbl;

/**
 *
 * <P>
 * 開放得意先管理テーブル
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/10 JSE H.Abe)<BR>
 * </P>
 */
public class TBTHBCKHT {

    /**
     * インスタンス生成禁止。
     */
    private TBTHBCKHT() {
    }

    /** 開放得意先管理テーブル */
    public static final String TBNAME = "THBCKHT";

    /** カラム名のプレフィックス */
    public static final String PREFIX = "HBC_";

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

    /** 画面表示フラグ (DISFLG) */
    public static final String DISFLG = PREFIX + "DISFLG";

    /** 使用開始年月日 (USTTIME) */
    public static final String USTTIME = PREFIX + "USTTIME";

    /** 廃止フラグ (REPFLG) */
    public static final String REPFLG = PREFIX + "REPFLG";

    /** 出稿情報表示有無 (SKDISPUMU) */
    public static final String SKDISPUMU = PREFIX + "SKDISPUMU";

    /** 出稿情報権限 (SKKGN) */
    public static final String SKKGN = PREFIX + "SKKGN";

    /** 複数得意先選択ダイアログ表示フラグ (DLGFLG) */
    public static final String DLGFLG = PREFIX + "DLGFLG";

    /** アプリID (APLID) */
    public static final String APLID = PREFIX + "APLID";

    /** 表示順 (CLTDIS) */
    public static final String CLTDIS = PREFIX + "CLTDIS";

}
