package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ライオンFD出力データ取得VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FDLionVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** ｶｰﾄﾞNo */
    public static final String kadoNo = "kadoNo";

    /** 年月 */
    public static final String nentuki = "nentuki";

    /** 代理店CD */
    public static final String dairitencd = "dairitencd";

    /** 媒体区分 */
    public static final String baitaicd = "baitaicd";

    /** 番組CD */
    public static final String bangumi = "bangumi";

    /** ﾌﾞﾗﾝﾄﾞCD */
    public static final String brandcd = "brandcd";

    /** 局誌CD */
    public static final String kyokucd = "kyokucd";

    /** ﾈｯﾄFC */
    public static final String netfc = "netfc";

    /** 局誌名称 */
    public static final String kyokuNm = "kyokuNm";

    /** ﾌﾞﾗﾝﾄﾞ名称 */
    public static final String brandName = "brandName";

    /** 局誌名称 */
    public static final String kyokuNameTR = "kyokuNameTR";

    /** 局誌名称 */
    public static final String NewsName = "NewsName";

    /** 府県CD */
    public static final String fukencd = "fukencd";

    /** 電波料 */
    public static final String denpa = "denpa";

    /** ﾈｯﾄ料・掲載料 */
    public static final String neto = "neto";

    /** 制作費 */
    public static final String seisaku = "seisaku";

    /** 金額 */
    public static final String seikyuu = "seikyuu";

    /** 総秒数 */
    public static final String soubyousu = "soubyousu";

    /** 秒数・源泉税区分 */
    public static final String byousu = "byousu";

    /** 源泉税 */
    public static final String gensen = "gensen";

    /** */
    public static final String honsu = "honsu";

    /** */
    public static final String housou = "housou";

    /** */
    public static final String syouhizeigaku = "syouhizeigaku";

    /** */
    public static final String kyusi = "kyusi";

    /** ソート順番 */
    public static final String jyunban = "jyunban";

    /** */
    public static final String syouhi = "syouhi";

    /** 消費税率 */
    public static final String syouhizeiritu = "syouhizeiritu";

    /** 値引き率 */
    public static final String nebikiritu = "nebikiritu";

    /** 業務区分 */
    public static final String GYOMKBN = "GYOMKBN";

    /**
     * 新規インスタンスを構築します。
     */
    public FDLionVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new FDLionVO();
    }

    public String getKadoNo() {
        return (String) get(kadoNo);
    }

    public void setKadoNo(String val) {
        set(kadoNo, val);
    }

    public String getNentuki() {
        return (String) get(nentuki);
    }

    public void setNentuki(String val) {
        set(nentuki, val);
    }

    public String getDairitencd() {
        return (String) get(dairitencd);
    }

    public void setDairitencd(String val) {
        set(dairitencd, val);
    }

    public String getBaitaicd() {
        return (String) get(baitaicd);
    }

    public void setBaitaicd(String val) {
        set(baitaicd, val);
    }

    public String getBangumi() {
        return (String) get(bangumi);
    }

    public void setBangumi(String val) {
        set(bangumi, val);
    }

    public String getBrandcd() {
        return (String) get(brandcd);
    }

    public void setBrandcd(String val) {
        set(brandcd, val);
    }

    public String getKyokucd() {
        return (String) get(kyokucd);
    }

    public void setKyokucd(String val) {
        set(kyokucd, val);
    }

    public String getNetfc() {
        return (String) get(netfc);
    }

    public void setNetfc(String val) {
        set(netfc, val);
    }

    public String getKyokuNm() {
        return (String) get(kyokuNm);
    }

    public void setKyokuNm(String val) {
        set(kyokuNm, val);
    }

    public String getBrandName() {
        return (String) get(brandName);
    }

    public void setBrandName(String val) {
        set(brandName, val);
    }

    public String getKyokuNameTR() {
        return (String) get(kyokuNameTR);
    }

    public void setKyokuNameTR(String val) {
        set(kyokuNameTR, val);
    }

    public String getNewsName() {
        return (String) get(NewsName);
    }

    public void setNewsName(String val) {
        set(NewsName, val);
    }

    public String getFukencd() {
        return (String) get(fukencd);
    }

    public void setFukencd(String val) {
        set(fukencd, val);
    }

    public BigDecimal getDenpa() {
        return (BigDecimal) get(denpa);
    }

    public void setDenpa(BigDecimal val) {
        set(denpa, val);
    }

    public BigDecimal getNeto() {
        return (BigDecimal) get(neto);
    }

    public void setNeto(BigDecimal val) {
        set(neto, val);
    }

    public BigDecimal getSeisaku() {
        return (BigDecimal) get(seisaku);
    }

    public void setSeisaku(BigDecimal val) {
        set(seisaku, val);
    }

    public BigDecimal getSeikyuu() {
        return (BigDecimal) get(seikyuu);
    }

    public void setSeikyuu(BigDecimal val) {
        set(seikyuu, val);
    }

    public String getSoubyousu() {
        return (String) get(soubyousu);
    }

    public void setSoubyousu(String val) {
        set(soubyousu, val);
    }

    public String getByousu() {
        return (String) get(byousu);
    }

    public void setByousu(String val) {
        set(byousu, val);
    }

    public String getGensen() {
        return (String) get(gensen);
    }

    public void setGensen(String val) {
        set(gensen, val);
    }

    public String getHonsu() {
        return (String) get(honsu);
    }

    public void setHonsu(String val) {
        set(honsu, val);
    }

    public String getHousou() {
        return (String) get(housou);
    }

    public void setHousou(String val) {
        set(housou, val);
    }

    public BigDecimal getSyouhizeigaku() {
        return (BigDecimal) get(syouhizeigaku);
    }

    public void setSyouhizeigaku(BigDecimal val) {
        set(syouhizeigaku, val);
    }

    public String getKyusi() {
        return (String) get(kyusi);
    }

    public void setKyusi(String val) {
        set(kyusi, val);
    }

    public String getJyunban() {
        return (String) get(jyunban);
    }

    public void setJyunban(String val) {
        set(jyunban, val);
    }

    public BigDecimal getSyouhi() {
        return (BigDecimal) get(syouhi);
    }

    public void setSyouhi(BigDecimal val) {
        set(syouhi, val);
    }

    public BigDecimal getSyouhizeiritu() {
        return (BigDecimal) get(syouhizeiritu);
    }

    public void setSyouhizeiritu(BigDecimal val) {
        set(syouhizeiritu, val);
    }

    public BigDecimal getNebikiritu() {
        return (BigDecimal) get(nebikiritu);
    }

    public void setNebikiritu(BigDecimal val) {
        set(nebikiritu, val);
    }

    public String getGYOMKBN() {
        return (String) get(GYOMKBN);
    }

    public void setGYOMKBN(String val) {
        set(GYOMKBN, val);
    }

}
