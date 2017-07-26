package jp.co.isid.kkh.customer.epson.model.report;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 提出帳票（エプソン)VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/5 JSE YS)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSubMissionVO extends AbstractModel {

    /** */
    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportEpsonSubMissionVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportEpsonSubMissionVO();
    }

    /**
     * 先頭列を取得する
     * @return 先頭列
     */
    public String getFirstCol() {
        return (String) get("FIRSTCOL");
    }

    /**
     * 先頭列を設定する
     * @param val 先頭列
     */
    public void setFirstCol(String val) {
        set("FIRSTCOL", val);
    }

    /**
     * 伝票登録NOを取得する
     * @return 伝票登録NO
     */
    public String getDenpyoNo() {
        return (String) get("DENPYONO");
    }

    /**
     * 伝票登録NOを設定する
     * @param val 伝票登録NO
     */
    public void setDenpyoNo(String val) {
        set("DENPYONO", val);
    }

    /**
     * 明細NOを取得する
     * @return 明細NO
     */
    public String getMeisaiNo() {
        return (String) get("MEISAINO");
    }

    /**
     * 明細NOを設定する
     * @param val 明細NO
     */
    public void setMeisaiNo(String val) {
        set("MEISAINO", val);
    }

    /**
     * 会社CDを取得する
     * @return 会社CD
     */
    public String getKaishCd() {
        return (String) get("KAISHCD");
    }

    /**
     * 会社CDを設定する
     * @param val 会社CD
     */
    public void setKaishCd(String val) {
        set("KAISHCD", val);
    }

    /**
     * 起票部門CDを取得する
     * @return 起票部門CD
     */
    public String getKihyoBmnCd() {
        return (String) get("KIHYOBMNCD");
    }

    /**
     * 起票部門CDを設定する
     * @param val 起票部門CD
     */
    public void setKihyoBmnCd(String val) {
        set("KIHYOBMNCD", val);
    }

    /**
     * 仕入先コードを取得する
     * @return 仕入先コード
     */
    public String getShireskCd() {
        return (String) get("SHIIRESKCD");
    }

    /**
     * 仕入先コードを設定する
     * @param val 仕入先コード
     */
    public void setShireskCd(String val) {
        set("SHIIRESKCD", val);
    }

    /**
     * 通貨CDを取得する
     * @return 通貨CD
     */
    public String getTukaCd() {
        return (String) get("TUKACD");
    }

    /**
     * 通貨CDを設定する
     * @param val 通貨CD
     */
    public void setTukaCd(String val) {
        set("TUKACD", val);
    }

    /**
     * 発注先部門CDを取得する
     * @return 発注先部門CD
     */
    public String getHatskCd() {
        return (String) get("HATSKCD");
    }

    /**
     * 発注先部門CDを設定する
     * @param val 発注先部門CD
     */
    public void setHatskCd(String val) {
        set("HATSKCD", val);
    }

    /**
     * 計上日を取得する
     * @return 計上日
     */
    public String getKeijyobi() {
        return (String) get("KEIJYOBI");
    }

    /**
     * 計上日を設定する
     * @param val 計上日
     */
    public void setKeijyobi(String val) {
        set("KEIJYOBI", val);
    }

    /**
     * 換算レートを取得する
     * @return 換算レート
     */
    public BigDecimal getRate() {
        return (BigDecimal) get("RATE");
    }

    /**
     * 換算レートを設定する
     * @param val 換算レート
     */
    public void setRate(BigDecimal val) {
        set("RATE", val);
    }

    /**
     * 取引先請求Noを取得する
     * @return 取引先請求No
     */
    public String getSeiNo() {
        return (String) get("SEINO");
    }

    /**
     * 取引先請求Noを設定する
     * @param val 取引先請求No
     */
    public void setSeiNo(String val) {
        set("SEINO", val);
    }

    /**
     * 内外税区分を取得する
     * @return 内外税区分
     */
    public BigDecimal getZeiKbn() {
        return (BigDecimal) get("ZEIKBN");
    }

    /**
     * 内外税区分を設定する
     * @param val 内外税区分
     */
    public void setZeiKbn(BigDecimal val) {
        set("ZEIKBN", val);
    }

    /**
     * 取引識別コードを取得する
     * @return 取引識別コード
     */
    public String getToriSikiCd() {
        return (String) get("TORISIKICD");
    }

    /**
     * 取引識別コードを設定する
     * @param val 取引識別コード
     */
    public void setToriSikiCd(String val) {
        set("TORISIKICD", val);
    }

    /**
     * 原価センタを取得する
     * @return 原価センタ
     */
    public String getGenkaCent() {
        return (String) get("GENKACENT");
    }

    /**
     * 原価センタを設定する
     * @param val 原価センタ
     */
    public void setGenkaCent(String val) {
        set("GENKACENT", val);
    }

    /**
     * 利益センタを取得する
     * @return 利益センタ
     */
    public String getRiekiCent() {
        return (String) get("RIEKICENT");
    }

    /**
     * 利益センタを設定する
     * @param val 利益センタ
     */
    public void setRiekiCent(String val) {
        set("RIEKICENT", val);
    }

    /**
     * 指図Noを取得する
     * @return 指図No
     */
    public String getSashizuNo() {
        return (String) get("SASHIZUNO");
    }

    /**
     * 指図Noを設定する
     * @param val 指図No
     */
    public void setSashizuNo(String val) {
        set("SASHIZUNO", val);
    }

    /**
     * セグメント指図番号を取得する
     * @return セグメント指図番号
     */
    public String getSeguSashiNo() {
        return (String) get("SEGUSASHINO");
    }

    /**
     * セグメント指図番号を設定する
     * @param val セグメント指図番号
     */
    public void setSeguSashiNo(String val) {
        set("SEGUSASHINO", val);
    }

    /**
     * 取引先（立替先）を取得する
     * @return 取引先（立替先）
     */
    public String getToriSaki() {
        return (String) get("TORISAKI");
    }

    /**
     * 取引先（立替先）を設定する
     * @param val 取引先（立替先）
     */
    public void setToriSaki(String val) {
        set("TORISAKI", val);
    }

    /**
     * 具体的取引内容を取得する
     * @return 具体的取引内容
     */
    public String getToriNaiyo() {
        return (String) get("TORINAIYO");
    }

    /**
     * 具体的取引内容を設定する
     * @param val 具体的取引内容
     */
    public void setToriNaiyo(String val) {
        set("TORINAIYO", val);
    }

    /**
     * 取引金額を取得する
     * @return 取引金額
     */
    public BigDecimal getToriGak() {
        return (BigDecimal) get("TORIGAK");
    }

    /**
     * 取引金額を設定する
     * @param val 取引金額
     */
    public void setToriGak(BigDecimal val) {
        set("TORIGAK", val);
    }

    /**
     * 消費税額を取得する
     * @return 消費税額
     */
    public BigDecimal getSyohiGak() {
        return (BigDecimal) get("SYOHIGAK");
    }

    /**
     * 消費税額を設定する
     * @param val 消費税額
     */
    public void setSyohiGak(BigDecimal val) {
        set("SYOHIGAK", val);
    }

    /**
     * 換算金額を取得する
     * @return 換算金額
     */
    public String getKansanGak() {
        return (String) get("KANSANGAK");
    }

    /**
     * 換算金額を設定する
     * @param val 換算金額
     */
    public void setKansanGak(String val) {
        set("KANSANGAK", val);
    }

    /**
     * 換算消費税額を取得する
     * @return 換算消費税額
     */
    public String getKansanSGak() {
        return (String) get("KANSANSGAK");
    }

    /**
     * 換算消費税額を設定する
     * @param val 換算消費税額
     */
    public void setKansanSGak(String val) {
        set("KANSANSGAK", val);
    }

    /**
     * 消込Keyを取得する
     * @return 消込Key
     */
    public String getKeshikomiKey() {
        return (String) get("KESHIKOMIKEY");
    }

    /**
     * 消込Keyを設定する
     * @param val 消込Key
     */
    public void setKeshikomiKey(String val) {
        set("KESHIKOMIKEY", val);
    }

    /**
     * 品目コードを取得する
     * @return 品目コード
     */
    public String getHinmokuCd() {
        return (String) get("HINMOKUCD");
    }

    /**
     * 品目コードを設定する
     * @param val 品目コード
     */
    public void setHinmokuCd(String val) {
        set("HINMOKUCD", val);
    }

    /**
     * 品目名称を取得する
     * @return 品目名称
     */
    public String getHinmokuMei() {
        return (String) get("HINMOKUMEI");
    }

    /**
     * 品目名称を設定する
     * @param val 品目名称
     */
    public void setHinmokuMei(String val) {
        set("HINMOKUMEI", val);
    }

    /**
     * 型番を取得する
     * @return 型番
     */
    public String getKataban() {
        return (String) get("KATABAN");
    }

    /**
     * 型番を設定する
     * @param val 型番
     */
    public void setKataban(String val) {
        set("KATABAN", val);
    }

    /**
     * 数量を取得する
     * @return 数量
     */
    public String getSuryo() {
        return (String) get("SURYO");
    }

    /**
     * 数量を設定する
     * @param val 数量
     */
    public void setSuryo(String val) {
        set("SURYO", val);
    }

    /**
     * 単位を取得する
     * @return 単位
     */
    public String getTani() {
        return (String) get("TANI");
    }

    /**
     * 単位を設定する
     * @param val 単位
     */
    public void setTani(String val) {
        set("TANI", val);
    }

    /**
     * 取引単価を取得する
     * @return 取引単価
     */
    public String getToriTank() {
        return (String) get("TORITANK");
    }

    /**
     * 取引単価を設定する
     * @param val 取引単価
     */
    public void setToriTank(String val) {
        set("TORITANK", val);
    }

    /**
     * 換算単価を取得する
     * @return 換算単価
     */
    public String getKansanTank() {
        return (String) get("KANSANTANK");
    }

    /**
     * 換算単価を設定する
     * @param val 換算単価
     */
    public void setKansanTank(String val) {
        set("KANSANTANK", val);
    }

    /**
     * P/ONoを取得する
     * @return P/ONo
     */
    public String getPoNo() {
        return (String) get("PONO");
    }

    /**
     * P/ONoを設定する
     * @param val P/ONo
     */
    public void setPoNo(String val) {
        set("PONO", val);
    }

    /**
     * 契約Noを取得する
     * @return 契約No
     */
    public String getKeiyakuNo() {
        return (String) get("KEIYAKUNO");
    }

    /**
     * 契約Noを設定する
     * @param val 契約No
     */
    public void setKeiyakuNo(String val) {
        set("KEIYAKUNO", val);
    }

    /**
     * 稟議書Noを取得する
     * @return 稟議書No
     */
    public String getRingiNo() {
        return (String) get("RINGINO");
    }

    /**
     * 稟議書Noを設定する
     * @param val 稟議書No
     */
    public void setRingiNo(String val) {
        set("RINGINO", val);
    }

    /**
     * 源泉税取引金額を取得する
     * @return 源泉税取引金額
     */
    public String getGensenToriGak() {
        return (String) get("GENSENTORIGAK");
    }

    /**
     * 源泉税取引金額を設定する
     * @param val 源泉税取引金額
     */
    public void setGensenToriGak(String val) {
        set("GENSENTORIGAK", val);
    }

    /**
     * 源泉税率を取得する
     * @return 源泉税率
     */
    public String getGensenZeiRitu() {
        return (String) get("GENSENZEIRITU");
    }

    /**
     * 源泉税率を設定する
     * @param val 源泉税率
     */
    public void setGensenZeiRitu(String val) {
        set("GENSENZEIRITU", val);
    }

    /**
     * 前払対象区分を取得する
     * @return 前払対象区分
     */
    public String getMaeTaisyoKbn() {
        return (String) get("MAETAISYOKBN");
    }

    /**
     * 前払対象区分を設定する
     * @param val 前払対象区分
     */
    public void setMaeTaisyoKbn(String val) {
        set("MAETAISYOKBN", val);
    }

    /**
     * 条件確定区分を取得する
     * @return 条件確定区分
     */
    public String getJyokenKakuKbn() {
        return (String) get("JYOKENKAKUKBN");
    }

    /**
     * 条件確定区分を設定する
     * @param val 条件確定区分
     */
    public void setJyokenKakuKbn(String val) {
        set("JYOKENKAKUKBN", val);
    }

    /**
     * 期間（From）を取得する
     * @return 期間（From）
     */
    public String getKikanFrom() {
        return (String) get("KIKANFROM");
    }

    /**
     * 期間（From）を設定する
     * @param val 期間（From）
     */
    public void setKikanFrom(String val) {
        set("KIKANFROM", val);
    }

    /**
     * 期間（To）を取得する
     * @return 期間（To）
     */
    public String getKikanTo() {
        return (String) get("KIKANTO");
    }

    /**
     * 期間（To）を設定する
     * @param val 期間（To）
     */
    public void setKikanTo(String val) {
        set("KIKANTO", val);
    }

    /**
     * 振替条件を取得する
     * @return 振替条件
     */
    public String getFurikaeJyoken() {
        return (String) get("FURIKAEJYOKEN");
    }

    /**
     * 振替条件を設定する
     * @param val 振替条件
     */
    public void setFurikaeJyoken(String val) {
        set("FURIKAEJYOKEN", val);
    }

    /**
     * 最終列を取得する
     * @return 最終列
     */
    public String getLastCol() {
        return (String) get("LASTCOLN");
    }

    /**
     * 最終列を設定する
     * @param val 最終列
     */
    public void setLastCol(String val) {
        set("LASTCOLN", val);
    }

}