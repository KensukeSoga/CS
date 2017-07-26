package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ライオン制作費請求予定表検索結果VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class InvoicePlanLionVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** 受注No */
    public static final String JYUTNO = "JYUTNO";
    /** 受注明細No */
    public static final String JYMEINO = "JYMEINO";
    /** 売上明細No */
    public static final String URMEINO = "URMEINO";
    /** ブランドコード */
    public static final String BRDCD = "BRDCD";
    /** ブランド名 */
    public static final String BRDNM = "BRDNM";
    /** 件名 */
    public static final String KENNM = "KENNM";
    /** 請求金額 */
    public static final String SEIGAK = "SEIGAK";
    /** 媒体区分コード */
    public static final String BAITAIKBN = "BAITAIKBN";
    /** 媒体区分名 */
    public static final String BAITAINM = "BAITAINM";

    /**
     * 新規インスタンスを構築します。
     */
    public InvoicePlanLionVO() {
    }

    /**
     * 新規インスタンスを構築します。
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new InvoicePlanLionVO();
    }

    /** 受注Noを取得する
     * @return 受注No
     */
    public String getJyutno() {
        return (String) get(JYUTNO);
    }

    /**
     * 受注Noを設定する
     * @param val String 受注No
     */
    public void setJyutno(String val) {
        set(JYUTNO, val);
    }

    /**
     * 受注明細Noを取得する
     * @return 受注明細No
     */
    public String getJymeino() {
        return (String) get(JYMEINO);
    }

    /**
     * 受注明細Noを設定する
     * @param val String 受注明細No
     */
    public void setJymeino(String val) {
        set(JYMEINO, val);
    }

    /**
     * 売上明細Noを取得する
     * @return 売上明細No
     */
    public String getUrmeino() {
        return (String) get(URMEINO);
    }

    /**
     * 売上明細Noを設定する
     * @param val String 売上明細No
     */
    public void setUrmeino(String val) {
        set(URMEINO, val);
    }

    /**
     * ブランドコードを取得する
     * @return ブランドコード
     */
    public String getBrdCd() {
        return (String) get(BRDCD);
    }

    /**
     * ブランドコードを設定する
     * @param val String ブランドコード
     */
    public void setBrdCd(String val) {
        set(BRDCD, val);
    }

    /**
     * ブランド名を取得する
     * @return ブランド名
     */
    public String getBrdNm() {
        return (String) get(BRDNM);
    }

    /**
     * ブランド名を設定する
     * @param val String ブランド名
     */
    public void setBrdNm(String val) {
        set(BRDNM, val);
    }

    /**
     * 件名を取得する
     * @return 件名
     */
    public String getKenNm() {
        return (String) get(KENNM);
    }

    /**
     * 件名を設定する
     * @param val String 件名
     */
    public void setKenNm(String val) {
        set(KENNM, val);
    }

    /**
     * 請求金額を取得する
     * @return 請求金額
     */
    public BigDecimal getSeigak() {
        return (BigDecimal) get(SEIGAK);
    }

    /**
     * 請求金額を設定する
     * @param val BigDecimal 請求金額
     */
    public void setSeigak(BigDecimal val) {
        set(SEIGAK, val);
    }

    /**
     * 媒体区分コードを取得する
     * @return 媒体区分
     */
    public String getBaitaiKbn() {
        return (String) get(BAITAIKBN);
    }

    /**
     * 媒体区分コードを設定する
     * @param val String 媒体区分
     */
    public void setBaitaiKbn(String val) {
        set(BAITAIKBN, val);
    }

    /**
     * 媒体区分名を取得する
     * @return 媒体区分名
     */
    public String getBaitaiNm() {
        return (String) get(BAITAINM);
    }

    /**
     * 媒体区分名を設定する
     * @param val String 媒体区分名
     */
    public void setBaitaiNm(String val) {
        set(BAITAINM, val);
    }

}