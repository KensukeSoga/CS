package jp.co.isid.kkh.customer.ash.model.report;

import java.math.BigDecimal;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���[(Ash)VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/20 fourm h.izawa)<BR>
 * �E�A�T�q����őΉ�(2016/11/22 HLC K.Soga)<BR>
 * </P>
 * @author
 */
public class ReportAshMediaVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** �V�K�C���X�^���X���\�z���܂��B */
    public ReportAshMediaVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportAshMediaVO();
    }

    /**
     * �������ԍ���ݒ肵�܂��B
     * @param val String NAME33
     */
    public void setName33(String val) {
        set("NAME33", val);
    }

    /**
     * �������ԍ���Ԃ��܂��B
     * @return String NAME33
     */
    public String getName33() {
        return (String) get("NAME33");
    }

    /**
     * ��ږ���ݒ肵�܂��B
     * @param val String NAME2
     */
    public void setName2(String val) {
        set("NAME2", val);
    }

    /**
     * ��ږ���Ԃ��܂��B
     * @return String NAME2
     */
    public String getName2() {
        return (String) get("NAME2");
    }

    /**
     * ��ږ�(����)��ݒ肵�܂��B
     * @param val String Himknmkj
     */
    public void setHimknmkj(String val) {
        set("HIMKNMKJ", val);
    }

    /**
     * ��ږ�(����)��Ԃ��܂��B
     * @return String Himknmkj
     */
    public String getHimknmkj() {
        return (String) get("HIMKNMKJ");
    }

    /**
     * �������z��ݒ肵�܂��B
     * @param val BigDecimal SeiGak
     */
    public void setSeiGak(BigDecimal val) {
        set("SEIGAK", val);
    }

    /**
     * �������z��Ԃ��܂��B
     * @return BigDecimal SeiGak
     */
    public BigDecimal getSeiGak() {
        return (BigDecimal) get("SEIGAK");
    }

    /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD Start */
    /**
     * �l���z��ݒ肵�܂��B
     * @param val BigDecimal NebikiGaku
     */
    public void setNebikiGaku(BigDecimal val) {
        set("NEBIKIGAKU", val);
    }

    /**
     * �l���z��Ԃ��܂��B
     * @return BigDecimal NebikiGaku
     */
    public BigDecimal getNebikiGaku() {
        return (BigDecimal) get("NEBIKIGAKU");
    }
    /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD End */

    /**
     * ����(����)��ݒ肵�܂��B
     * @param val String KkNameKj
     */
    public void setKkNameKj(String val) {
        set("KKNAMEKJ", val);
    }

    /**
     * ����(����)��Ԃ��܂��B
     * @return String KkNameKj
     */
    public String getKkNameKj() {
        return (String) get("KKNAMEKJ");
    }

    /**
     * ��No��ݒ肵�܂��B
     * @param val String JyutNo2
     */
    public void setJyutNo2(String val) {
        set("JYUTNO2", val);
    }

    /**
     * ��No��Ԃ��܂��B
     * @return String JyutNo2
     */
    public String getJyutNo2() {
        return (String) get("JYUTNO2");
    }

    /**
     * ���㖾��No��ݒ肵�܂��B
     * @param val String UrMeiNo02
     */
    public void setUrMeiNo2(String val) {
        set("URMEINO2", val);
    }

    /**
     * ���㖾��No��Ԃ��܂��B
     * @return String UrMeiNo02
     */
    public String getUrMeiNo2() {
        return (String) get("URMEINO2");
    }

    /**
     * �󒍖���No��ݒ肵�܂��B
     * @param val String JyMeiNo02
     */
    public void setJyMeiNo2(String val) {
        set("JYMEINO2", val);
    }

    /**
     * �󒍖���No��Ԃ��܂��B
     * @return String JyMeiNo02
     */
    public String getJyMeiNo2() {
        return (String) get("JYMEINO2");
    }

    /**
     * �{����ݒ肵�܂��B
     * @param val String Sonota2
     */
    public void setSonota2(String val) {
        set("SONOTA2", val);
    }

    /**
     * �{����Ԃ��܂��B
     * @return String Sonota2
     */
    public String getSonota2() {
        return (String) get("SONOTA2");
    }

    /**
     * �A�Ԃ�ݒ肵�܂��B
     * @param val String Renban2
     */
    public void setRenban2(String val) {
        set("RENBAN2", val);
    }

    /**
     * �A�Ԃ�Ԃ��܂��B
     * @return String Renban2
     */
    public String getRenban2() {
        return (String) get("RENBAN2");
    }

    /**
     * �l������ݒ肵�܂��B
     * @param val String Hnnert
     */
    public void setHnnert(BigDecimal val) {
        set("HNNERT", val);
    }

    /**
     * �l������Ԃ��܂��B
     * @return String Hnnert
     */
    public BigDecimal getHnnert() {
        return (BigDecimal) get("HNNERT");
    }

    /**
     * ������ݒ肵�܂��B
     * @param val String HnmeGak
     */
    public void setHnmeGak(BigDecimal val) {
        set("HNMAEGAK", val);
    }

    /**
     * ������Ԃ��܂��B
     * @return String HnmeGak
     */
    public BigDecimal getHnmeGak() {
        return (BigDecimal) get("HNMAEGAK");
    }
    /**
     * ����ŗ���ݒ肵�܂��B
     * @param val String Ritu1
     */
    public void setRitu1(BigDecimal val) {
        set("RITU1", val);
    }

    /**
     * ����ŗ���Ԃ��܂��B
     * @return String Ritu1
     */
    public BigDecimal getRitu1() {
        return (BigDecimal) get("RITU1");
    }

    /**
     * �}�̃R�[�h��ݒ肵�܂��B
     * @param val String Code1
     */
    public void setCode1(String val) {
        set("CODE1", val);
    }

    /**
     * �}�̃R�[�h��Ԃ��܂��B
     * @return String Code1
     */
    public String getCode1() {
        return (String) get("CODE1");
    }

    /**
     * �i��R�[�h��ݒ肵�܂��B
     * @param val String Code3
     */
    public void setCode3(String val) {
        set("CODE3", val);
    }

    /**
     * �i��R�[�h��Ԃ��܂��B
     * @return String Code3
     */
    public String getCode3() {
        return (String) get("CODE3");
    }

    /**
     * �\�[�g�ԍ���ݒ肵�܂��B
     * @param val String Sonota10
     */
    public void setSonota10(String val) {
        set("SONOTA10", val);
    }

    /**
     * �\�[�g�ԍ���Ԃ��܂��B
     * @return String Sonota10
     */
    public String getSonota10() {
        return (String) get("SONOTA10");
    }

    /**
     * �f�ړ����������ݒ肵�܂��B
     * @param val String Name5
     */
    public void setName5(String val) {
        set("NAME5", val);
    }

    /**
     * �f�ړ����������Ԃ��܂��B
     * @return String Name5
     */
    public String getName5() {
        return (String) get("NAME5");
    }

    /**
     * ���[�敪��ݒ肵�܂��B
     * @param val String Sonota3
     */
    public void setSonota3(String val) {
        set("SONOTA3", val);
    }

    /**
     * ���[�敪��Ԃ��܂��B
     * @return String Sonota3
     */
    public String getSonota3() {
        return (String) get("SONOTA3");
    }

    /**
     * �f�ڔ�&�f�ڍ���ݒ肵�܂��B
     * @param val String Sonota5
     */
    public void setSonota5(String val) {
        set("SONOTA5", val);
    }

    /**
     * �f�ڔ�&�f�ڍ���Ԃ��܂��B
     * @return String Sonota5
     */
    public String getSonota5() {
        return (String) get("SONOTA5");
    }

    /**
     * �L�G�敪��ݒ肵�܂��B
     * @param val String Sonota6
     */
    public void setSonota6(String val) {
        set("SONOTA6", val);
    }

    /**
     * �L�G�敪��Ԃ��܂��B
     * @return String Sonota6
     */
    public String getSonota6() {
        return (String) get("SONOTA6");
    }

    /**
     * �Ǻ��ނ�ݒ肵�܂��B
     * @param val String Code2
     */
    public void setCode2(String val) {
        set("CODE2", val);
    }

    /**
     * �Ǻ��ނ�Ԃ��܂��B
     * @return String Code2
     */
    public String getCode2() {
        return (String) get("CODE2");
    }

    /**
     * �G�����ނ�ݒ肵�܂��B
     * @param val String Code6
     */
    public void setCode6(String val) {
        set("CODE6", val);
    }

    /**
     * �G�����ނ�Ԃ��܂��B
     * @return String Code6
     */
    public String getCode6() {
        return (String) get("CODE6");
    }
    /**
     * �X�y�[�X��ݒ肵�܂��B
     * @param val String Name1
     */
    public void setName1(String val) {
        set("NAME1", val);
    }

    /**
     * �X�y�[�X��Ԃ��܂��B
     * @return String Name1
     */
    public String getName1() {
        return (String) get("NAME1");
    }

    /**
     * �������ԁA�w�H������ݒ肵�܂��B
     * @param val String Name6
     */
    public void setName6(String val) {
        set("NAME6", val);
    }

    /**
     * �������ԁA�w�H������Ԃ��܂��B
     * @return String Name6
     */
    public String getName6() {
        return (String) get("NAME6");
    }

    /**
     * �j����ݒ肵�܂��B
     * @param val String Name9
     */
    public void setName9(String val) {
        set("NAME9", val);
    }

    /**
     * �j����Ԃ��܂��B
     * @return String Name9
     */
    public String getName9() {
        return (String) get("NAME9");
    }

    /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD Start */
    /**
     * ����Ŋz��ݒ肵�܂��B
     * @param val BigDecimal Kngk1
     */
    public void setKngk1(BigDecimal val) {
        set("KNGK1", val);
    }

    /**
     * ����Ŋz��Ԃ��܂��B
     * @return BigDecimal Kngk1
     */
    public BigDecimal getKngk1() {
        return (BigDecimal) get("KNGK1");
    }
    /** 2016/11/22 �A�T�q����őΉ� HLC K.Soga ADD End */

    /**
     * �ǃl�b�g����ݒ肵�܂��B
     * @param val String Sonota7
     */
    public void setSonota7(String val) {
        set("SONOTA7", val);
    }

    /**
     * �ǃl�b�g����Ԃ��܂��B
     * @return String Sonota7
     */
    public String getSonota7() {
        return (String) get("SONOTA7");
    }

    /**
     * �L�[�ǃR�[�h��ݒ肵�܂��B
     * @param val String Sonota8
     */
    public void setSonota8(String val) {
        set("SONOTA8", val);
    }

    /**
     * �L�[�ǃR�[�h��Ԃ��܂��B
     * @return String Sonota8
     */
    public String getSonota8() {
        return (String) get("SONOTA8");
    }
}