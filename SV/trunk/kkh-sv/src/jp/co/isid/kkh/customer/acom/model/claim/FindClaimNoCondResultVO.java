package jp.co.isid.kkh.customer.acom.model.claim;


import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 発注/請求番号 一覧情報VO (返却用)
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindClaimNoCondResultVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public FindClaimNoCondResultVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindClaimNoCondResultVO();
    }

    /**
     * 処理区分を取得する
     * @return 処理区分
     */
    public String getShoriKbn() {
        return (String) get("SHORIKBN");
    }

    /**
     * 処理区分を設定する
     * @param val 処理区分
     */
    public void setShoriKbn(String val) {
        set("SHORIKBN", val);
    }

    /**
     * 出力選択を取得する
     * @return 出力選択
     */
    public String getOutSelect() {
        return (String) get("OUTSELECT");
    }

    /**
     * 出力選択を設定する
     * @param val 出力選択
     */
    public void setOutSelect(String val) {
        set("OUTSELECT", val);
    }

    /**
     * 依頼番号（発注番号）を取得する
     * @return 依頼番号（発注番号）
     */
    public String getIraiNo() {
        return (String) get("IRAINO");
    }

    /**
     * 依頼番号（発注番号）を設定する
     * @param val 依頼番号（発注番号）
     */
    public void setIraiNo(String val) {
        set("IRAINO", val);
    }

    /**
     * 請求書番号を取得する
     * @return 請求書番号
     */
    public String getSeiNo() {
        return (String) get("SEINO");
    }

    /**
     * 請求書番号を設定する
     * @param val 請求書番号
     */
    public void setSeiNo(String val) {
        set("SEINO", val);
    }

    /**
     * 請求書発行日を取得する
     * @return 請求書発行日
     */
    public String getSeiYymm() {
        return (String) get("SEIYYMM");
    }

    /**
     * 請求書発行日を設定する
     * @param val 請求書発行日
     */
    public void setSeiYymm(String val) {
        set("SEIYYMM", val);
    }

    /**
     * 件名を取得する
     * @return 件名
     */
    public String getKenmei() {
        return (String) get("KENMEI");
    }

    /**
     * 件名を設定する
     * @param val 件名
     */
    public void setKenmei(String val) {
        set("KENMEI", val);
    }

    /**
     * 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )を取得する
     * @return 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )
     */
    public String getBaitaiCd() {
        return (String) get("BAITAICD");
    }

    /**
     * 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )を設定する
     * @param val 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )
     */
    public void setBaitaiCd(String val) {
        set("BAITAICD", val);
    }

    /**
     * 実行日時を取得する
     * @return 実行日時
     */
    public String getOutDate() {
        return (String) get("OUTDATE");
    }

    /**
     * 実行日時を設定する
     * @param val 実行日時
     */
    public void setOutDate(String val) {
        set("OUTDATE", val);
    }

    /**
     * 受注Noを取得する
     * @return 受注No
     */
    public String getJyutNo() {
        return (String) get("JYUTNO");
    }

    /**
     * 受注Noを設定する
     * @param val 受注No
     */
    public void setJyutNo(String val) {
        set("JYUTNO", val);
    }

    /**
     * 受注明細Noを取得する
     * @return 受注明細No
     */
    public String getJymeiNo() {
        return (String) get("JYMEINO");
    }

    /**
     * 受注明細Noを設定する
     * @param val 受注明細No
     */
    public void setJymeiNo(String val) {
        set("JYMEINO", val);
    }

    /**
     * 売上明細Noを取得する
     * @return 売上明細No
     */
    public String getUrmeiNo() {
        return (String) get("URMEINO");
    }

    /**
     * 売上明細Noを設定する
     * @param val 売上明細No
     */
    public void setUrmeiNo(String val) {
        set("URMEINO", val);
    }

    /**
     * 連番を取得する
     * @return 連番
     */
    public String getRenBan() {
        return (String) get("RENBAN");
    }

    /**
     * 連番を設定する
     * @param val 連番
     */
    public void setRenBan(String val) {
        set("RENBAN", val);
    }

}