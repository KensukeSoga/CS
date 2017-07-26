package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ライオン見積書データ取得VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/03/5 fourm H.izawa)<BR>
 * ・消費税端数調整対応(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author fourm H.izawa
 *
 */
public class NewReportLionVO extends AbstractModel{

    private static final long serialVersionUID = 1L;

    /**件名*/
    public static final String KENNAME = "KENNAME";

    /**見積もり料金*/
    public static final String MITUMORIRYO = "MITUMORIRYO";

    /**定価料金*/
    public static final String TEIKARYOKIN = "TEIKARYOKIN";

    /**スペース*/
    public static final String SPACE = "SPACE";

    /**期間*/
    public static final String KIKAN = "KIKAN";

    /**備考*/
    public static final String BIKOU = "BIKOU";

    /**請求ブランド*/
    public static final String SEIKYUBRAND = "SEIKYUBRAND";

    /**コード*/
    public static final String CODE = "CODE";

    /**エリア*/
    public static final String AREA = "AREA";

    /**掲出*/
    public static final String KEISYUTU = "KEISYUTU";

    /**種類*/
    public static final String SYURUI = "SYURUI";

    /**紙名*/
    public static final String SHIMEI = "SHIMEI";

    /**雑誌名*/
    public static final String ZASHIMEI = "ZASHIMEI";

    /**雑誌コード*/
    public static final String ZASHICD = "ZASHICD";

    /**番組名*/
    public static final String BANMEI = "BANMEI";

    /**放送局*/
    public static final String HOUSOUKYOKU = "HOUSOUKYOKU";

    /**媒体コード*/
    public static final String BAITAICD = "BAITAICD";

    /**媒体子コード*/
    public static final String BAITAIKOCD = "BAITAIKOCD";

    /**CM秒数*/
    public static final String CMBYOUSU = "CMBYOUSU";

    /**本数*/
    public static final String HONSU = "HONSU";

    /**番組コード*/
    public static final String BANCD = "BANCD";

    /**局誌コード*/
    public static final String KYOKUCD = "KYOKUCD";

    /**請求金額合計*/
    public static final String SUMSEIGAK = "SUMSEIGAK";

    /**消費税額合計*/
    public static final String SUMSZEIGAK = "SUMSZEIGAK";

    /** 消費税率 */
    public static final String SHOHIZEI_RITU = "SHOHIZEI_RITU";

    /**消費税額*/
    public static final String SZEIGAK = "SZEIGAK";

    /**費目名*/
    public static final String HIMOKUMEI = "HIMOKUMEI";

    /**ネット局*/
    public static final String NETKYOKU =  "NETKYOKU";

    /**
     * 新規インスタンスを構築します。
     */
    public NewReportLionVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new NewReportLionVO();
    }


    /**
     * ネット局を設定します。
     * @param val String NETKYOKU
     */
    public void setNetKyoku(String val) {
        set(NETKYOKU, val);
    }

    /**
     * ネット局を返します。
     * @return String NETKYOKU
     */
    public  String getNetKyoku() {
        return (String) get(NETKYOKU);
    }

    /**
     * 費目名を設定します。
     * @param val String HIMOKUMEI
     */
    public void setHimokumei(String val) {
        set(HIMOKUMEI, val);
    }

    /**
     *費目名を返します。
     * @return String HIMOKUMEI
     */
    public  String getHimokumei() {
        return (String) get(HIMOKUMEI);
    }

    /**
     * 請求金額を設定します。
     * @param val String SZEIGAK
     */
    public void setSzeigak(String val) {
        set(SZEIGAK, val);
    }

    /**
     * 請求金額を返します。
     * @return String SZEIGAK
     */
    public  String getSzeigak() {
        return (String) get(SZEIGAK);
    }


    /**
     * 請求金額合計を設定します。
     * @param val String SUMSEIGAK
     */
    public void setSumseigak(String val) {
        set(SUMSEIGAK, val);
    }

    /**
     * 請求金額合計を返します。
     * @return String SUMSEIGAK
     */
    public  String getSumseigak() {
        return (String) get(SUMSEIGAK);
    }

    /**
     * 消費税率を設定する
     * @param val SHOHIZEI_RITU
     */
    public void setShohizeiRitu(BigDecimal val) {
        set(SHOHIZEI_RITU, val);
    }

    /**
     * 消費税率を取得する
     * @return SHOHIZEI_RITU
     */
    public BigDecimal getShohizeiRitu() {
        return (BigDecimal) get(SHOHIZEI_RITU);
    }

    /**
     * 消費税額合計を設定します。
     * @param val String SUMSZEIGAK
     */
    public void setSumszeigak(String val) {
        set(SUMSZEIGAK, val);
    }

    /**
     * 消費税額合計を返します。
     * @return String SUMSZEIGAK
     */
    public  String getSumszeigak() {
        return (String) get(SUMSZEIGAK);
    }

    /**
     * 件名を設定します。
     * @param val String KENNAME
     */
    public void setKenname(String val) {
        set(KENNAME, val);
    }

    /**
     * 件名を返します。
     * @return String KENNAME
     */
    public  String getKenname() {
        return (String) get(KENNAME);
    }

    /**
     * 見積料を設定します。
     * @param val String MITUMORIRYO
     */
    public void setMitumoriryo(String val) {
        set(MITUMORIRYO, val);
    }

    /**
     * 見積料を返します。
     * @return String MITUMORIRYO
     */
    public  String getMitumoriryo() {
        return (String) get(MITUMORIRYO);
    }

    /**
     * 定価料金を設定します。
     * @param val String TEIKARYOKIN
     */
    public void setTeikaryokin(String val) {
        set(TEIKARYOKIN, val);
    }

    /**
     * 定価料金を返します。
     * @return String TEIKARYOKIN
     */
    public  String getTeikaryokin() {
        return (String) get(TEIKARYOKIN);
    }

    /**
     * スペースを設定します。
     * @param val String SPACE
     */
    public void setSpace(String val) {
        set(SPACE, val);
    }

    /**
     * スペースを返します。
     * @return String SPACE
     */
    public  String getSpace() {
        return (String) get(SPACE);
    }

    /**
     * 期間を設定します。
     * @param val String KIKAN
     */
    public void setKikan(String val) {
        set(KIKAN, val);
    }

    /**
     * 期間を返します。
     * @return String KIKAN
     */
    public  String getKikan() {
        return (String) get(KIKAN);
    }

    /**
     * 備考を設定します。
     * @param val String BIKOU
     */
    public void setBikou(String val) {
        set(BIKOU, val);
    }

    /**
     * 備考を返します。
     * @return String BIKOU
     */
    public  String getBikou() {
        return (String) get(BIKOU);
    }

    /**
     * 請求ブランドを設定します。
     * @param val String SEIKYUBRAND
     */
    public void setSeikyubrand(String val) {
        set(SEIKYUBRAND, val);
    }

    /**
     * 請求ブランドを返します。
     * @return String SEIKYUBRAND
     */
    public  String getSeikyubrand() {
        return (String) get(SEIKYUBRAND);
    }

    /**
     * コードを設定します。
     * @param val String CODE
     */
    public void setCode(String val) {
        set(CODE, val);
    }

    /**
     * コードを返します。
     * @return String CODE
     */
    public  String getCode() {
        return (String) get(CODE);
    }

    /**
     * エリアを設定します。
     * @param val String AREA
     */
    public void setArea(String val) {
      set(AREA, val);
    }

    /**
     * エリアを返します。
     * @return String AREA
     */
    public  String getArea() {
        return (String) get(AREA);
    }

    /**
     * 掲出を設定します。
     * @param val String KEISYUTU
     */
    public void setKeisyutu(String val) {
        set(KEISYUTU, val);
    }

    /**
     * 掲出を返します。
     * @return String KEISYUTU
     */
    public  String getKeisyutu() {
        return (String) get(KEISYUTU);
    }

    /**
     * 種類を設定します。
     * @param val String SYURUI
     */
    public void setSyurui(String val) {
        set(SYURUI, val);
    }

    /**
     * 種類を返します。
     * @return String SYURUI
     */
    public  String getSyurui() {
        return (String) get(SYURUI);
    }

    /**
     * 紙名を設定します。
     * @param val String SHIMEI
     */
    public void setShimei(String val) {
        set(SHIMEI, val);
    }

    /**
     * 紙名を返します。
     * @return String SHIMEI
     */
    public  String getShimei() {
        return (String) get(SHIMEI);
    }

    /**
     * 雑誌名を設定します。
     * @param val String ZASHIMEI
     */
    public void setZashimei(String val) {
        set(ZASHIMEI, val);
    }

    /**
     * 雑誌名を返します。
     * @return String ZASHIMEI
     */
    public  String getZashimei() {
        return (String) get(ZASHIMEI);
    }

    /**
     * 雑誌コードを設定します。
     * @param val String ZASHICD
     */
    public void setZashicd(String val) {
        set(ZASHICD, val);
    }

    /**
     * 雑誌コードを返します。
     * @return String ZASHICD
     */
    public  String getZashicd() {
        return (String) get(ZASHICD);
    }

    /**
     * 番組名を設定します。
     * @param val String BANMEI
     */
    public void setBanmei(String val) {
        set(BANMEI, val);
    }

    /**
     * 番組名を返します。
     * @return String BANMEI
     */
    public String getBanmei() {
        return (String) get(BANMEI);
    }

    /**
     * 放送局を設定します。
     * @param val String HOUSOUKYOKU
     */
    public void setHousoukyoku(String val) {
        set(HOUSOUKYOKU, val);
    }

    /**
     * 放送局を返します。
     * @return String HOUSOUKYOKU
     */
    public  String getHousoukyoku() {
        return (String) get(HOUSOUKYOKU);
    }

    /**
     * 媒体コードを設定します。
     * @param val String BAITAICD
     */
    public void setBaitaicd(String val) {
        set(BAITAICD, val);
    }

    /**
     * 媒体コードを返します。
     * @return String BAITAICD
     */
    public  String getBaitaicd() {
        return (String) get(BAITAICD);
    }

    /**
     * 媒体子コードを設定します。
     * @param val String BAITAIKOCD
     */
    public void setBaitaikocd(String val) {
        set(BAITAIKOCD, val);
    }

    /**
     * 媒体子コードを返します。
     * @return String BAITAIKOCD
     */
    public  String getBaitaikocd() {
        return (String) get(BAITAIKOCD);
    }

    /**
     * CM秒数を設定します。
     * @param val String CMBYOUSU
     */
    public void setCmbyousu(String val) {
        set(CMBYOUSU, val);
    }

    /**
     * CM秒数を返します。
     * @return String CMBYOUSU
     */
    public  String getCmbyousu() {
        return (String) get(CMBYOUSU);
    }

    /**
     * 本数を設定します。
     * @param val String HONSU
     */
    public void setHonsu(String val) {
        set(HONSU, val);
    }

    /**
     * 本数を返します。
     * @return String HONSU
     */
    public  String getHonsu() {
        return (String) get(HONSU);
    }

    /**
     * 番組コードを設定します。
     * @param val String BANCD
     */
    public void setBanCd(String val) {
        set(BANCD, val);
    }

    /**
     * 番組コードを返します。
     * @return String BANCD
     */
    public  String getBanCd() {
        return (String) get(BANCD);
    }

    /**
     * 局誌コードを設定します。
     * @param val String KYOKUCD
     */
    public void setKyokuCd(String val) {
        set(KYOKUCD, val);
    }

    /**
     * 局誌コードを返します。
     * @return String KYOKUCD
     */
    public  String getKyokuCd() {
        return (String) get(KYOKUCD);
    }

}
