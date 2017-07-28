package jp.co.isid.kkh.customer.uni.model.report;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.nj.model.AbstractModel;


/**
 * <P>
 * ���[�i���j�`���[��_�L����ו\�j�f�[�^�ԋp�pVO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/23 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class ReportUniResultVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportUniResultVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportUniResultVO();
    }

    /**
     * �������[No��ݒ肵�܂��B
     * @param val String �������[No
     */
    public void setGpyNo(String val) {
        set("GPYNO", val);
    }

    /**
     * �������[No��Ԃ��܂��B
     * @return String �������[No
     */
    public String getGpyNo() {
        return (String) get("GPYNO");
    }

    /**
     * �������[�sNo��ݒ肵�܂��B
     * @param val String �������[�sNo
     */
    public void setMGpyNo(String val) {
        set("MGPYNO", val);
    }

    /**
     * �������[�sNo��Ԃ��܂��B
     * @return String �������[�sNo
     */
    public String getMGpyNo() {
        return (String) get("MGPYNO");
    }

    /**
     * ��No(��No + "-" + �󒍖���No + "-" + ���㖾��No)��ݒ肵�܂��B
     * @param val String ��No(��No + "-" + �󒍖���No + "-" + ���㖾��No)
     */
    public void setJutyuNo(String val) {
        set("JYUTYUNO", val);
    }

    /**
     * ��No(��No + "-" + �󒍖���No + "-" + ���㖾��No)��Ԃ��܂��B
     * @return String ��No(��No + "-" + �󒍖���No + "-" + ���㖾��No)
     */
    public String getJutyuNo() {
        return (String) get("JYUTYUNO");
    }

    /**
     * �Ɩ��敪��ݒ肵�܂��B
     * @param val String �Ɩ��敪
     */
    public void setGyomKbn(String val) {
        set("GYOMKBN", val);
    }

    /**
     * �Ɩ��敪��Ԃ��܂��B
     * @return String �Ɩ��敪
     */
    public String getGyomKbn() {
        return (String) get("GYOMKBN");
    }

    /**
     * �Ɩ��敪����ݒ肵�܂��B
     * @param val String �Ɩ��敪��
     */
    public void setGyomKbnNm(String val) {
        set("GYOMKBNNM", val);
    }

    /**
     * �Ɩ��敪����Ԃ��܂��B
     * @return String �Ɩ��敪��
     */
    public String getGyomKbnNm() {
        return (String) get("GYOMKBNNM");
    }

    /**
     * �����敪��ݒ肵�܂��B
     * @param val String �����敪
     */
    public void setSeiKbn(String val) {
        set("SEIKBN", val);
    }

    /**
     * �����敪��Ԃ��܂��B
     * @return String �����敪
     */
    public String getSeiKbn() {
        return (String) get("SEIKBN");
    }

    /**
     * ��ʃR�[�h��ݒ肵�܂��B
     * @param val String ��ʃR�[�h
     */
    public void setShubetsuCd(String val) {
        set("SHOWNUM", val);
    }

    /**
     * ��ʃR�[�h��Ԃ��܂��B
     * @return String ��ʃR�[�h
     */
    public String getShubetsuCd() {
        return (String) get("SHOWNUM");
    }

    /**
     * ��ʖ��̂�ݒ肵�܂��B
     * @param val String ��ʖ���
     */
    public void setShubetsuNm(String val) {
        set("SHUBETSUNM", val);
    }

    /**
     * ��ʖ��̂�Ԃ��܂��B
     * @return String ��ʖ���
     */
    public String getShubetsuNm() {
        return (String) get("SHUBETSUNM");
    }

    /**
     * ������ݒ肵�܂��B
     * @param val String ����
     */
    public void setKenmei(String val) {
        set("KENMEI", val);
    }

    /**
     * ������Ԃ��܂��B
     * @return String ����
     */
    public String getKenmei() {
        return (String) get("KENMEI");
    }

    /**
     * ��ڂ�ݒ肵�܂��B
     * @param val String ���
     */
    public void setHimoku(String val) {
        set("HIMOKU", val);
    }

    /**
     * ��ڂ�Ԃ��܂��B
     * @return String ���
     */
    public String getHimoku() {
        return (String) get("HIMOKU");
    }

    /**
     * ���e��ݒ肵�܂��B
     * @param val String ���e
     */
    public void setContents(String val) {
        set("CONTENTS", val);
    }

    /**
     * ���e��Ԃ��܂��B
     * @return String ���e
     */
    public String getContents() {
        return (String) get("CONTENTS");
    }

    /**
     * ���e�P��ݒ肵�܂��B
     * @param val String ���e�P
     */
    public void setContents1(String val) {
        set("CONTENTS1", val);
    }

    /**
     * ���e�P��Ԃ��܂��B
     * @return String ���e�P
     */
    public String getContents1() {
        return (String) get("CONTENTS1");
    }

    /**
     * ���e�Q��ݒ肵�܂��B
     * @param val String ���e�Q
     */
    public void setContents2(String val) {
        set("CONTENTS2", val);
    }

    /**
     * ���e�Q��Ԃ��܂��B
     * @return String ���e�Q
     */
    public String getContents2() {
        return (String) get("CONTENTS2");
    }

    /**
     * ���e�R��ݒ肵�܂��B
     * @param val String ���e�R
     */
    public void setContents3(String val) {
        set("CONTENTS3", val);
    }

    /**
     * ���e�R��Ԃ��܂��B
     * @return String ���e�R
     */
    public String getContents3() {
        return (String) get("CONTENTS3");
    }

    /**
     * ���e�S��ݒ肵�܂��B
     * @param val String ���e�S
     */
    public void setContents4(String val) {
        set("CONTENTS4", val);
    }

    /**
     * ���e�S��Ԃ��܂��B
     * @return String ���e�S
     */
    public String getContents4() {
        return (String) get("CONTENTS4");
    }

    /**
     * ���z��ݒ肵�܂��B
     * @param val BigDecimal ���z
     */
    public void setKngk(BigDecimal val) {
        set("KNGK", val);
    }

    /**
     * ���z��Ԃ��܂��B
     * @return BigDecimal ���z
     */
    @XmlElement(required = true)
    public BigDecimal getKngk() {
        return (BigDecimal) get("KNGK");
    }

    /**
     * ����Ŋz��ݒ肵�܂��B
     * @param val BigDecimal ����Ŋz
     */
    public void setTax(BigDecimal val) {
        set("TAX", val);
    }

    /**
     * ����Ŋz��Ԃ��܂��B
     * @return BigDecimal ����Ŋz
     */
    @XmlElement(required = true)
    public BigDecimal getTax() {
        return (BigDecimal) get("TAX");
    }

    /**
     * ���z�i�󒍃_�E�����[�h�f�[�^�j��ݒ肵�܂��B
     * @param val BigDecimal ���z
     */
    public void setKngkJ(BigDecimal val) {
        set("KNGK_J", val);
    }

    /**
     * ���z�i�󒍃_�E�����[�h�f�[�^�j��Ԃ��܂��B
     * @return BigDecimal ���z
     */
    @XmlElement(required = true)
    public BigDecimal getKngkJ() {
        return (BigDecimal) get("KNGK_J");
    }

    /**
     * ����Ŋz�i�󒍃_�E�����[�h�f�[�^�j��ݒ肵�܂��B
     * @param val BigDecimal ����Ŋz
     */
    public void setTaxJ(BigDecimal val) {
        set("TAX_J", val);
    }

    /**
     * ����Ŋz�i�󒍃_�E�����[�h�f�[�^�j��Ԃ��܂��B
     * @return BigDecimal ����Ŋz
     */
    @XmlElement(required = true)
    public BigDecimal getTaxJ() {
        return (BigDecimal) get("TAX_J");
    }

    /**
     * ������ݒ肵�܂��B
     * @param val String ����
     */
    public void setBusho(String val) {
        set("BUSHO", val);
    }

    /**
     * ������Ԃ��܂��B
     * @return String ����
     */
    public String getBusho() {
        return (String) get("BUSHO");
    }

    // 2013/01/09 JSE M.Naito add start
    /**
     * �����t���O��ݒ肵�܂��B
     * @param val String �����t���O
     */
    public void setTouFlg(String val) {
        set("TOUFLG", val);
    }

    /**
     * �����t���O��Ԃ��܂��B
     * @return String �����t���O
     */
    public String getTouFlg() {
        return (String) get("TOUFLG");
    }

    /**
     * �������No��ݒ肵�܂��B
     * @param val String �������No
     */
    public void setTJyutNo(String val) {
        set("TJYUTNO", val);
    }

    /**
     * �������No��Ԃ��܂��B
     * @return String �������No
     */
    public String getTJyutNo() {
        return (String) get("TJYUTNO");
    }

    /**
     * ������󒍖���No��ݒ肵�܂��B
     * @param val String ������󒍖���No
     */
    public void setTJymeiNo(String val) {
        set("TJYMEINO", val);
    }

    /**
     * ������󒍖���No��Ԃ��܂��B
     * @return String ������󒍖���No
     */
    public String getTJymeiNo() {
        return (String) get("TJYMEINO");
    }

    /**
     * �����攄�㖾��No��ݒ肵�܂��B
     * @param val String �����攄�㖾��No
     */
    public void setTUrmeiNo(String val) {
        set("TURMEINO", val);
    }

    /**
     * �����攄�㖾��No��Ԃ��܂��B
     * @return String �����攄�㖾��No
     */
    public String getTUrmeiNo() {
        return (String) get("TURMEINO");
    }
    // 2013/01/09 JSE M.Naito add end

}
