package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���C�I��FD�o�̓f�[�^�擾VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FDLionVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** ����No */
    public static final String kadoNo = "kadoNo";

    /** �N�� */
    public static final String nentuki = "nentuki";

    /** �㗝�XCD */
    public static final String dairitencd = "dairitencd";

    /** �}�̋敪 */
    public static final String baitaicd = "baitaicd";

    /** �ԑgCD */
    public static final String bangumi = "bangumi";

    /** ������CD */
    public static final String brandcd = "brandcd";

    /** �ǎ�CD */
    public static final String kyokucd = "kyokucd";

    /** ȯ�FC */
    public static final String netfc = "netfc";

    /** �ǎ����� */
    public static final String kyokuNm = "kyokuNm";

    /** �����ޖ��� */
    public static final String brandName = "brandName";

    /** �ǎ����� */
    public static final String kyokuNameTR = "kyokuNameTR";

    /** �ǎ����� */
    public static final String NewsName = "NewsName";

    /** �{��CD */
    public static final String fukencd = "fukencd";

    /** �d�g�� */
    public static final String denpa = "denpa";

    /** ȯė��E�f�ڗ� */
    public static final String neto = "neto";

    /** ����� */
    public static final String seisaku = "seisaku";

    /** ���z */
    public static final String seikyuu = "seikyuu";

    /** ���b�� */
    public static final String soubyousu = "soubyousu";

    /** �b���E����ŋ敪 */
    public static final String byousu = "byousu";

    /** ����� */
    public static final String gensen = "gensen";

    /** */
    public static final String honsu = "honsu";

    /** */
    public static final String housou = "housou";

    /** */
    public static final String syouhizeigaku = "syouhizeigaku";

    /** */
    public static final String kyusi = "kyusi";

    /** �\�[�g���� */
    public static final String jyunban = "jyunban";

    /** */
    public static final String syouhi = "syouhi";

    /** ����ŗ� */
    public static final String syouhizeiritu = "syouhizeiritu";

    /** �l������ */
    public static final String nebikiritu = "nebikiritu";

    /** �Ɩ��敪 */
    public static final String GYOMKBN = "GYOMKBN";

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FDLionVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
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
