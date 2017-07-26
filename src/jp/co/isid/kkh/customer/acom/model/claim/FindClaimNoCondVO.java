package jp.co.isid.kkh.customer.acom.model.claim;


import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 発注/請求番号 一覧情報VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindClaimNoCondVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public FindClaimNoCondVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FindClaimNoCondVO();
    }

    /**
     * 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )を取得する
     * @return 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )
     */
    public String getBaitaiCd() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )を設定する
     * @param val 媒体コード(21:新聞 22:雑誌 11:電波 31:交通 )
     */
    public void setBaitaiCd(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * 依頼番号（発注番号）を取得する
     * @return 依頼番号（発注番号）
     */
    public String getIraiNo() {
        return (String) get(TBTHB2KMEI.CODE3);
    }

    /**
     * 依頼番号（発注番号）を設定する
     * @param val 依頼番号（発注番号）
     */
    public void setIraiNo(String val) {
        set(TBTHB2KMEI.CODE3, val);
    }

    /**
     * 件名を取得する
     * @return 件名
     */
    public String getKenmei() {
        return (String) get(TBTHB1DOWN.KKNAMEKJ);
    }

    /**
     * 件名を設定する
     * @param val 件名
     */
    public void setKenmei(String val) {
        set(TBTHB1DOWN.KKNAMEKJ, val);
    }

    /**
     * 請求書番号を取得する
     * @return 請求書番号
     */
    public String getSeiNo() {
        return (String) get(TBTHB2KMEI.SONOTA1);
    }

    /**
     * 請求書番号を設定する
     * @param val 請求書番号
     */
    public void setSeiNo(String val) {
        set(TBTHB2KMEI.SONOTA1, val);
    }

    /**
     * 請求書発行日を取得する
     * @return 請求書発行日
     */
    public String getSeiYymm() {
        return (String) get(TBTHB2KMEI.DATE1);
    }

    /**
     * 請求書発行日を設定する
     * @param val 請求書発行日
     */
    public void setSeiYymm(String val) {
        set(TBTHB2KMEI.DATE1, val);
    }

    /**
     * 受注内容区分を取得する
     * @return 受注内容区分
     */
    public String getKbn() {
        return (String) get(TBTHB2KMEI.SONOTA6);
    }

    /**
     * 受注内容区分を設定する
     * @param val 受注内容区分
     */
    public void setKbn(String val) {
        set(TBTHB2KMEI.SONOTA6, val);
    }

    /**
     * 出力フラグを取得する
     * @return 出力フラグ
     */
    public String getShoriKbn() {
        return (String) get(TBTHB2KMEI.KBN1);
    }

    /**
     * 出力フラグを設定する
     * @param val 出力フラグ
     */
    public void setShoriKbn(String val) {
        set(TBTHB2KMEI.KBN1, val);
    }

    /**
     * 実行日時を取得する
     * @return 実行日時
     */
    public String getOutDate() {
        return (String) get(TBTHB2KMEI.NAME7);
    }

    /**
     * 実行日時を設定する
     * @param val 実行日時
     */
    public void setOutDate(String val) {
        set(TBTHB2KMEI.NAME7, val);
    }

    /**
     * 受注Noを取得する
     * @return 受注No
     */
    public String getJyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * 受注Noを設定する
     * @param val 受注No
     */
    public void setJyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * 受注明細Noを取得する
     * @return 受注明細No
     */
    public String getJymeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * 受注明細Noを設定する
     * @param val 受注明細No
     */
    public void setJymeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * 売上明細Noを取得する
     * @return 売上明細No
     */
    public String getUrmeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * 売上明細Noを設定する
     * @param val 売上明細No
     */
    public void setUrmeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * 連番を取得する
     * @return 連番
     */
    public String getRenBan() {
        return (String) get(TBTHB2KMEI.RENBN);
    }

    /**
     * 連番を設定する
     * @param val 連番
     */
    public void setRenBan(String val) {
        set(TBTHB2KMEI.RENBN, val);
    }

}