package jp.co.isid.kkh.integ.tbl;

/**
 *
 * <P>受注ダウンロード履歴テーブル</P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class TBTHB91RRKDOWN {

    /**
     * インスタンス生成禁止。
     */
    private TBTHB91RRKDOWN() {
    }

    /** 受注ダウンロードテーブル */
    public static final String TBNAME = "THB91RRKDOWN";

    /** カラム名のプレフィックス */
    public static final String PREFIX = "HB91_";

    /** 登録タイムスタンプ (TRKTIMSTMP) */
    public static final String TRKTIMSTMP = PREFIX + "TRKTIMSTMP";

    /** 登録プログラム (TRKAPL) */
    public static final String TRKAPL = PREFIX + "TRKAPL";

    /** 登録担当者 (TRKTNT) */
    public static final String TRKTNT = PREFIX + "TRKTNT";

    /** 登録担当者名 (TRKTNTNM) */
    public static final String TRKTNTNM = PREFIX + "TRKTNTNM";

    /** 明細更新タイムスタンプ (KSNTIMSTMP) */
    public static final String KSNTIMSTMP = PREFIX + "KSNTIMSTMP";

    /** 明細更新者ID (KSNTNT) */
    public static final String KSNTNT = PREFIX  + "KSNTNT";

    /** 明細更新者名 (KSNTNTNM ) */
    public static final String KSNTNTNM = PREFIX + "KSNTNTNM";

    /** タイムスタンプ (TIMSTMP) */
    public static final String TIMSTMP = PREFIX + "TIMSTMP";

    /** 更新プログラム (UPDAPL) */
    public static final String UPDAPL = PREFIX + "UPDAPL";

    /** 更新担当者 (UPDTNT) */
    public static final String UPDTNT = PREFIX + "UPDTNT";

    /** 営業所（扱）コード (ATUEGCD) */
    public static final String ATUEGCD = PREFIX + "ATUEGCD";

    /** 履歴タイムスタンプ */
    public static final String RRKTIMSTMP = PREFIX + "RRKTIMSTMP";

    /** 営業所（取）コード (EGCD) */
    public static final String EGCD = PREFIX + "EGCD";

    /** 得意先企業コード (TKSKGYCD) */
    public static final String TKSKGYCD = PREFIX + "TKSKGYCD";

    /** 得意先部門SEQNO (TKSBMNSEQNO) */
    public static final String TKSBMNSEQNO = PREFIX + "TKSBMNSEQNO";

    /** 得意先担当SEQNO (TKSTNTSEQNO) */
    public static final String TKSTNTSEQNO = PREFIX + "TKSTNTSEQNO";

    /** 受注No (JYUTNO) */
    public static final String JYUTNO = PREFIX + "JYUTNO";

    /** 受注明細No (JYMEINO) */
    public static final String JYMEINO = PREFIX + "JYMEINO";

    /** 売上明細No (URMEINO) */
    public static final String URMEINO = PREFIX + "URMEINO";

    /** 請求原票No (GPYNO) */
    public static final String GPYNO = PREFIX + "GPYNO";

    /** ページNo (GPYOPAG) */
    public static final String GPYOPAG = PREFIX + "GPYOPAG";

    /** 請求No (SEINO) */
    public static final String SEINO = PREFIX + "SEINO";

    /** 費目コード (HIMKCD) */
    public static final String HIMKCD = PREFIX + "HIMKCD";

    /** 統合フラグ (TOUFLG) */
    public static final String TOUFLG = PREFIX + "TOUFLG";

    /** 年月 (YYMM) */
    public static final String YYMM = PREFIX + "YYMM";

    /** 業務区分 (GYOMKBN) */
    public static final String GYOMKBN = PREFIX + "GYOMKBN";

    /** マス正味区分 (MSKBN) */
    public static final String MSKBN = PREFIX + "MSKBN";

    /** タイムスポット区分 (TMSPKBN) */
    public static final String TMSPKBN = PREFIX + "TMSPKBN";

    /** 国際区分 (KOKKBN) */
    public static final String KOKKBN = PREFIX + "KOKKBN";

    /** 請求区分 (SEIKBN) */
    public static final String SEIKBN = PREFIX + "SEIKBN";

    /** 商品NO (SYONO) */
    public static final String SYONO = PREFIX + "SYONO";

    /** 件名(漢字) (KKNAMEKJ) */
    public static final String KKNAMEKJ = PREFIX + "KKNAMEKJ";

    /** 営業画面タイプ (EGGAMENTYPE) */
    public static final String EGGAMENTYPE = PREFIX + "EGGAMENTYPE";

    /** 企画・製版区分 (KKAKSHANKBN) */
    public static final String KKAKSHANKBN = PREFIX + "KKAKSHANKBN";

    /** 取料金 (TORIGAK) */
    public static final String TORIGAK = PREFIX + "TORIGAK";

    /** 請求単価 (SEITNKA) */
    public static final String SEITNKA = PREFIX + "SEITNKA";

    /** 請求金額 (SEIGAK) */
    public static final String SEIGAK = PREFIX + "SEIGAK";

    /** 値引率 (NEBIRITU) */
    public static final String NEBIRITU = PREFIX + "NEBIRITU";

    /** 値引額 (NEBIGAK) */
    public static final String NEBIGAK = PREFIX + "NEBIGAK";

    /** 消費税区分 (SZEIKBN) */
    public static final String SZEIKBN = PREFIX + "SZEIKBN";

    /** 消費税率 (SZEIRITU) */
    public static final String SZEIRITU = PREFIX + "SZEIRITU";

    /** 消費税額 (SZEIGAK) */
    public static final String SZEIGAK = PREFIX + "SZEIGAK";

    /** 費目名(漢字) (HIMKNMKJ) */
    public static final String HIMKNMKJ = PREFIX + "HIMKNMKJ";

    /** 費目名(カナ) (HIMKNMKN) */
    public static final String HIMKNMKN = PREFIX + "HIMKNMKN";

    /** 統合先受注No (TJYUTNO) */
    public static final String TJYUTNO = PREFIX + "TJYUTNO";

    /** 統合先受注明細No (TJYMEINO) */
    public static final String TJYMEINO = PREFIX + "TJYMEINO";

    /** 統合先売上明細No (TURMEINO) */
    public static final String TURMEINO = PREFIX + "TURMEINO";

    /** 未請求フラグ (MSEIFLG) */
    public static final String MSEIFLG = PREFIX + "MSEIFLG";

    /** 変更前年月 (YYMMOLD) */
    public static final String YYMMOLD = PREFIX + "YYMMOLD";

    /** フィールド1 (FIELD1) */
    public static final String FIELD1 = PREFIX + "FIELD1";

    /** フィールド２ (FIELD2) */
    public static final String FIELD2 = PREFIX + "FIELD2";

    /** フィールド３ (FIELD3) */
    public static final String FIELD3 = PREFIX + "FIELD3";

    /** フィールド４ (FIELD4) */
    public static final String FIELD4 = PREFIX + "FIELD4";

    /** フィールド５ (FIELD5) */
    public static final String FIELD5 = PREFIX + "FIELD5";

    /** フィールド６ (FIELD6) */
    public static final String FIELD6 = PREFIX + "FIELD6";

    /** フィールド７ (FIELD7) */
    public static final String FIELD7 = PREFIX + "FIELD7";

    /** フィールド８ (FIELD8) */
    public static final String FIELD8 = PREFIX + "FIELD8";

    /** フィールド９ (FIELD9) */
    public static final String FIELD9 = PREFIX + "FIELD9";

    /** フィールド１０ (FIELD10) */
    public static final String FIELD10 = PREFIX + "FIELD10";

    /** フィールド１１ (FIELD11) */
    public static final String FIELD11 = PREFIX + "FIELD11";

    /** フィールド１２ (FIELD12) */
    public static final String FIELD12 = PREFIX + "FIELD12";

    /** ダウンロードファイルタイムスタンプ (FILETIMSTMP) */
    public static final String FILETIMSTMP = PREFIX + "FILETIMSTMP";

    /** 明細登録日時 (MEITIMSTMP) */
    public static final String MEITIMSTMP = PREFIX + "MEITIMSTMP";

    /** 受注削除フラグ (JYUTDELFLG) */
    public static final String JYUTDELFLG = PREFIX + "JYUTDELFLG";

    /** 履歴作成担当者 (RRKTRKTNT) */
    public static final String RRKTRKTNT = PREFIX + "RRKTRKTNT";

    /** 履歴作成時選択媒体 (RRKGETBAITAI) */
    public static final String RRKGETBAITAI = PREFIX + "RRKGETBAITAI";

    /** 履歴AD1フラグ (RRKAD1FLG) */
    public static final String RRKAD1FLG = PREFIX + "RRKAD1FLG";

}