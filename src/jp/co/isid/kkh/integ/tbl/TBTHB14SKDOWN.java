package jp.co.isid.kkh.integ.tbl;

/**
 *
 * <P>請求回収ダウンロード</P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/04/23)<BR>
 * </P>
 * @author
 */
public class TBTHB14SKDOWN {

    /**
     * インスタンス生成禁止。
     */
    private TBTHB14SKDOWN() {
    }

    /** 広告費明細テーブル */
    public static final String TBNAME = "THB14SKDOWN";

    /** タイムスタンプ (TIMSTMP) */
    public static final String TIMSTMP = "HB14_TIMSTMP";

    /** 更新プログラム (UPDAPL) */
    public static final String UPDAPL = "HB14_UPDAPL";

    /** 更新担当者 (UPDTNT) */
    public static final String UPDTNT = "HB14_UPDTNT";

    /** 請求ヘッダ最終更新日時 (SEIHUPDTIMSTMP) */
    public static final String SEIHUPDTIMSTMP = "HB14_SEIHUPDTIMSTMP";

    /** 営業所（取）コード (EGCD) */
    public static final String EGCD = "HB14_EGCD";

    /** 得意先企業コード (TKSKGYCD) */
    public static final String TKSKGYCD = "HB14_TKSKGYCD";

    /** 得意先部門SEQNO (TKSBMNSEQNO) */
    public static final String TKSBMNSEQNO = "HB14_TKSBMNSEQNO";

    /** 得意先担当SEQNO (TKSTNTSEQNO) */
    public static final String TKSTNTSEQNO = "HB14_TKSTNTSEQNO";

    /** 請求NO (SEINO) */
    public static final String SEINO = "HB14_SEINO";

    /** 請求ステータス (SEISTATUS) */
    public static final String SEISTATUS = "HB14_SEISTATUS";

    /** 請求データ種別 (SEISYBT) */
    public static final String SEISYBT = "HB14_SEISYBT";

    /** 請求書通貨コード (SEITSUKACD) */
    public static final String SEITSUKACD = "HB14_SEITSUKACD";

    /** 請求額合計 (SEIGAKGK) */
    public static final String SEIGAKGK = "HB14_SEIGAKGK";

    /** 請求時取料金合計 (TORIGAKGK) */
    public static final String TORIGAKGK = "HB14_TORIGAKGK";

    /** 請求時値引額合計 (NEBIGAKGK) */
    public static final String NEBIGAKGK = "HB14_NEBIGAKGK";

    /** 請求時消費税額合計 (SZEIGAKGK) */
    public static final String SZEIGAKGK = "HB14_SZEIGAKGK";

    /** 前受振替額 (MAEFURIGAK) */
    public static final String MAEFURIGAK = "HB14_MAEFURIGAK";

    /** 前受振替消費税 (MAEFURISZEIGAK) */
    public static final String MAEFURISZEIGAK = "HB14_MAEFURISZEIGAK";

    /** 回収ステータス (KAISTATUS) */
    public static final String KAISTATUS = "HB14_KAISTATUS";

    /** 最終消込年月日 (KESHIDATE) */
    public static final String KESHIDATE = "HB14_KESHIDATE";

    /** 回収額 (KAIGAK) */
    public static final String KAIGAK = "HB14_KAIGAK";

    /** 回収営業所コード (KAIEGCD) */
    public static final String KAIEGCD = "HB14_KAIEGCD";

    /** 請求書上の発行日 (SEIHAKDATE) */
    public static final String SEIHAKDATE = "HB14_SEIHAKDATE";

    /** 請求書出力年月日 (SEISYUDATE) */
    public static final String SEISYUDATE = "HB14_SEISYUDATE";

    /** 請求書再出力年月日 (SEISAISYUDATE) */
    public static final String SEISAISYUDATE = "HB14_SEISAISYUDATE";

    /** 再発行回数 (SAIHAKCNT) */
    public static final String SAIHAKCNT = "HB14_SAIHAKCNT";

    /** 請求書取消年月日 (SEITORIDATE) */
    public static final String SEITORIDATE = "HB14_SEITORIDATE";

    /** 請求年月 (SEIYYMM) */
    public static final String SEIYYMM = "HB14_SEIYYMM";

    /** 入金先企業コード (NYUKGYCD) */
    public static final String NYUKGYCD = "HB14_NYUKGYCD";

    /** 請求先企業コード (SEIKGYCD) */
    public static final String SEIKGYCD = "HB14_SEIKGYCD";

    /** 請求先部門SEQNO (SEIBMNSEQNO) */
    public static final String SEIBMNSEQNO = "HB14_SEIBMNSEQNO";

    /** 請求先担当SEQNO (SEITNTSEQNO) */
    public static final String SEITNTSEQNO = "HB14_SEITNTSEQNO";

    /** 請求先名称（上） (SEINAMEUP) */
    public static final String SEINAMEUP = "HB14_SEINAMEUP";

    /** 請求先名称（下） (SEINAMEDOWN) */
    public static final String SEINAMEDOWN = "HB14_SEINAMEDOWN";

    /** 請求先部門名称 (SEIBMNNAME) */
    public static final String SEIBMNNAME = "HB14_SEIBMNNAME";

    /** 営業局名 (EGKYONAME) */
    public static final String EGKYONAME = "HB14_EGKYONAME";

    /** 営業担当者コード (EGTNTCD) */
    public static final String EGTNTCD = "HB14_EGTNTCD";

    /** 営業担当者名 (EGTNTNAME) */
    public static final String EGTNTNAME = "HB14_EGTNTNAME";

    /** 請求担当者コード (SEITNTCD) */
    public static final String SEITNTCD = "HB14_SEITNTCD";

    /** 請求担当者名 (SEITNTNAME) */
    public static final String SEITNTNAME = "HB14_SEITNTNAME";

    /** 先方指定請求NO (SENSEINO) */
    public static final String SENSEINO = "HB14_SENSEINO";

    /** 請求ヘッダ媒体名 (SEIBAINAME) */
    public static final String SEIBAINAME = "HB14_SEIBAINAME";

    /** 請求件名表示基準年月日 (SEIHYODATE) */
    public static final String SEIHYODATE = "HB14_SEIHYODATE";

    /** 広告件名（漢字）（上） (KOUNAMEUP) */
    public static final String KOUNAMEUP = "HB14_KOUNAMEUP";

    /** 広告件名（漢字）（下） (KOUNAMEDOWN) */
    public static final String KOUNAMEDOWN = "HB14_KOUNAMEDOWN";

    /** 振替ステータス (FURISTATUS) */
    public static final String FURISTATUS = "HB14_FURISTATUS";

    /** 請求明細SEQ (SEIMEINO) */
    public static final String SEIMEINO = "HB14_SEIMEINO";

    /** 営業所コード（扱） (ATUEGCD) */
    public static final String ATUEGCD = "HB14_ATUEGCD";

    /** 得意先企業コード（扱） (ATUTKSKGYCD) */
    public static final String ATUTKSKGYCD = "HB14_ATUTKSKGYCD";

    /** 得意先部門SEQNO（扱） (ATUTKSBMNSEQNO) */
    public static final String ATUTKSBMNSEQNO = "HB14_ATUTKSBMNSEQNO";

    /** 得意先担当SEQNO（扱） (ATUTKSTNTSEQNO) */
    public static final String ATUTKSTNTSEQNO = "HB14_ATUTKSTNTSEQNO";

    /** 受注NO (JYUTNO) */
    public static final String JYUTNO = "HB14_JYUTNO";

    /** 受注明細NO (JYMEINO) */
    public static final String JYMEINO = "HB14_JYMEINO";

    /** 売上明細NO (URMEINO) */
    public static final String URMEINO = "HB14_URMEINO";

    /** 請求原票NO (GPYNO) */
    public static final String GPYNO = "HB14_GPYNO";

    /** 受注通貨コード (JYTSUKACD) */
    public static final String JYTSUKACD = "HB14_JYTSUKACD";

    /** 請求時換算レート (SEIKANRATE) */
    public static final String SEIKANRATE = "HB14_SEIKANRATE";

    /** レートタイプ (RATETYPE) */
    public static final String RATETYPE = "HB14_RATETYPE";

    /** 請求時換算年月日 (SEIKANDATE) */
    public static final String SEIKANDATE = "HB14_SEIKANDATE";

    /** 請求取料金（受注通貨） (TORIGAKJY) */
    public static final String TORIGAKJY = "HB14_TORIGAKJY";

    /** 請求取料金（円貨） (TORIGAKEN) */
    public static final String TORIGAKEN = "HB14_TORIGAKEN";

    /** 請求値引額（受注通貨） (NEBIGAKJY) */
    public static final String NEBIGAKJY = "HB14_NEBIGAKJY";

    /** 請求値引額（円貨） (NEBIGAKEN) */
    public static final String NEBIGAKEN = "HB14_NEBIGAKEN";

    /** 請求消費税額（円貨） (SZEIGAKEN) */
    public static final String SZEIGAKEN = "HB14_SZEIGAKEN";

    /** 振替年月日 (FURIDATE) */
    public static final String FURIDATE = "HB14_FURIDATE";

    /** 振替取消年月日 (FURITORIDATE) */
    public static final String FURITORIDATE = "HB14_FURITORIDATE";

    /** 消費税区分 (SZEIKBN) */
    public static final String SZEIKBN = "HB14_SZEIKBN";

    /** 計上予定年月日 (KEIYODATE) */
    public static final String KEIYODATE = "HB14_KEIYODATE";

    /** 計上年月日 (KEIDATE) */
    public static final String KEIDATE = "HB14_KEIDATE";

    /** ダウンロードファイルタイムスタンプ (FILETIMSTMP) */
    public static final String FILETIMSTMP = "HB14_FILETIMSTMP";

    /** 広告費明細反映日時 (KKHMEITIMSTMP) */
    public static final String KKHMEITIMSTMP = "HB14_KKHMEITIMSTMP";
}