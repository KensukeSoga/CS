package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ライオン受注差異一覧検索結果VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/11/10 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class OrderDiffListLionVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** 受注No */
    public static final String JYUTNO = "JYUTNO";
    /** 受注明細No */
    public static final String JYMEINO = "JYMEINO";
    /** 売上明細No */
    public static final String URMEINO = "URMEINO";
    /** 件名 */
    public static final String KKNAMEKJ = "KKNAMEKJ";
    /** 業務区分コード */
    public static final String GYOMKBN = "GYOMKBN";
    /** 業務区分名 */
    public static final String GYOMKBNKJ = "GYOMKBNKJ";
    /** 費目コード */
    public static final String HIMKCD = "HIMKCD";
    /** 費目名称 */
    public static final String HIMKNMKJ = "HIMKNMKJ";
    /** 媒体区分 */
    public static final String BAITAIKBN = "BAITAIKBN";
    /** ブランドコード */
    public static final String BRANDCD = "BRANDCD";
    /** ブランド名称 */
    public static final String BRANDNM = "BRANDNM";
    /** 取料金 */
    public static final String TORIGAK = "TORIGAK";
    /** 値引金額 */
    public static final String NEBIGAK = "NEBIGAK";
    /** 請求金額 */
    public static final String SEIGAK = "SEIGAK";
    /** 消費税額 */
    public static final String SZEIGAK = "SZEIGAK";
    /** 明細合計請求金額 */
    public static final String SEIGAK2 = "SEIGAK2";
    /** 明細合計消費税額 */
    public static final String SZEIGAK2 = "SZEIGAK2";
    /** SEQ */
    public static final String SEQ = "SEQ";

    /**
     * 新規インスタンスを構築します。
     */
    public OrderDiffListLionVO() {
    }

    /**
     * 新規インスタンスを構築します。
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new OrderDiffListLionVO();
    }

    /** 受注Noを取得する
     * @return String 受注No
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
     * @return String 受注明細No
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
     * @return String 売上明細No
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
     * 件名を取得する
     * @return String 件名
     */
    public String getKknamekj() {
        return (String) get(KKNAMEKJ);
    }

    /**
     * 件名を設定する
     * @param val String 件名
     */
    public void setKknamekj(String val) {
        set(KKNAMEKJ, val);
    }

    /**
     * 業務区分コードを取得する
     * @return String 業務区分コード
     */
    public String getGyomkbn() {
        return (String) get(GYOMKBN);
    }

    /**
     * 業務区分コードを設定する
     * @param val String 業務区分コード
     */
    public void setGyomkbn(String val) {
        set(GYOMKBN, val);
    }

    /**
     * 業務区分名称を取得する
     * @return String 業務区分名称
     */
    public String getGyomkbnkj() {
        return (String) get(GYOMKBNKJ);
    }

    /**
     * 業務区分名称を設定する
     * @param val String 業務区分名称
     */
    public void setGyomkbnkj(String val) {
        set(GYOMKBNKJ, val);
    }

    /**
     * 費目コードを取得する
     * @return String 費目コード
     */
    public String getHimkcd() {
        return (String) get(HIMKCD);
    }

    /**
     * 費目コードを設定する
     * @param val String 費目コード
     */
    public void setHimkcd(String val) {
        set(HIMKCD, val);
    }

    /**
     * 費目名称を取得する
     * @return String 費目名称
     */
    public String getHimknmkj() {
        return (String) get(HIMKNMKJ);
    }

    /**
     * 費目名称を設定する
     * @param val String 費目名称
     */
    public void setHimknmkj(String val) {
        set(HIMKNMKJ, val);
    }

    /**
     * 媒体区分を取得する
     * @return String 媒体区分
     */
    public String getBaitaikbn() {
        return (String) get(BAITAIKBN);
    }

    /**
     * 媒体区分を設定する
     * @param val String 媒体区分
     */
    public void setBaitaikbn(String val) {
        set(BAITAIKBN, val);
    }

    /**
     * ブランドコードを取得する
     * @return String ブランドコード
     */
    public String getBrandcd() {
        return (String) get(BRANDCD);
    }

    /**
     * ブランドコードを設定する
     * @param val String ブランドコード
     */
    public void setBrandcd(String val) {
        set(BRANDCD, val);
    }

    /**
     * ブランド名称を取得する
     * @return String ブランド名称
     */
    public String getBrandnm() {
        return (String) get(BRANDNM);
    }

    /**
     * ブランド名称を設定する
     * @param val String ブランド名称
     */
    public void setBrandnm(String val) {
        set(BRANDNM, val);
    }

    /**
     * 取料金を取得する
     * @return BigDecimal 取料金
     */
    public BigDecimal getTorigak() {
        return (BigDecimal) get(TORIGAK);
    }

    /**
     * 取料金を設定する
     * @param val BigDecimal 取料金
     */
    public void setTorigak(BigDecimal val) {
        set(TORIGAK, val);
    }

    /**
     * 値引金額を取得する
     * @return BigDecimal 値引金額
     */
    public BigDecimal getNebigak() {
        return (BigDecimal) get(NEBIGAK);
    }

    /**
     * 値引金額を設定する
     * @param val BigDecimal 値引金額
     */
    public void setNebigak(BigDecimal val) {
        set(NEBIGAK, val);
    }

    /**
     * 請求金額を取得する
     * @return BigDecimal 請求金額
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
     * 消費税額を取得する
     * @return BigDecimal 消費税額
     */
    public BigDecimal getSzeigak() {
        return (BigDecimal) get(SZEIGAK);
    }

    /**
     * 消費税額を設定する
     * @param val BigDecimal 消費税額
     */
    public void setSzeigak(BigDecimal val) {
        set(SZEIGAK, val);
    }

    /**
     * 明細合計請求金額を取得する
     * @return BigDecimal 明細合計請求金額
     */
    public BigDecimal getSeigak2() {
        return (BigDecimal) get(SEIGAK2);
    }

    /**
     * 明細合計請求金額を設定する
     * @param val BigDecimal 明細合計請求金額
     */
    public void setSeigak2(BigDecimal val) {
        set(SEIGAK2, val);
    }

    /**
     * 明細合計消費税額を取得する
     * @return BigDecimal 明細合計消費税額
     */
    public BigDecimal getSzeigak2() {
        return (BigDecimal) get(SZEIGAK2);
    }

    /**
     * 明細合計消費税額を設定する
     * @param val BigDecimal 明細合計消費税額
     */
    public void setSzeigak2(BigDecimal val) {
        set(SZEIGAK2, val);
    }

    /**
     * SEQを取得する
     * @return String SEQ
     */
    public String getSeq() {
        return (String) get(SEQ);
    }

    /**
     * SEQを設定する
     * @param val String SEQ
     */
    public void setSeq(String val) {
        set(SEQ, val);
    }

}
