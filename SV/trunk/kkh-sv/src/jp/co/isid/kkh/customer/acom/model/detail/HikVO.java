package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.Date;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �����f�[�^VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/1/10 form H.Izawa)<BR>
 * </P>
 * @author form H.Izawa
 */

public class HikVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public HikVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new HikVO();
    }

    /**
     * �o�^�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �o�^�^�C���X�^���v
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHB5HIK.TRKTIMSTMP, val);
    }

    /**
     * �o�^�^�C���X�^���v��Ԃ��܂��B
     * @return String �o�^�^�C���X�^���v
     */
    @XmlElement(required = true)
    public Date getTrkTimStmp() {
        return (Date) get(TBTHB5HIK.TRKTIMSTMP);
    }

    /**
     * �o�^�v���O������ݒ肵�܂��B
     * @param val String �o�^�v���O����
     */
    public void setTrkPl(String val) {
        set(TBTHB5HIK.TRKPL, val);
    }

    /**
     * �o�^�v���O������Ԃ��܂��B
     * @return String �o�^�v���O����
     */
    public String getTrkPl() {
        return (String) get(TBTHB5HIK.TRKPL);
    }

    /**
     * �o�^�S���҂�ݒ肵�܂��B
     * @param val String �o�^�S����
     */
    public void setTrkTnt(String val) {
        set(TBTHB5HIK.TRKTNT, val);
    }

    /**
     * �o�^�S���҂�Ԃ��܂��B
     * @return String �o�^�S����
     */
    public String getTrkTnt() {
        return (String) get(TBTHB5HIK.TRKTNT);
    }

    /**
     * �X�V�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �X�V�^�C���X�^���v
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHB5HIK.UPDTIMSTMP, val);
    }

    /**
     * �X�V�^�C���X�^���v��Ԃ��܂��B
     * @return String �X�V�^�C���X�^���v
     */
    @XmlElement(required = true)
    public Date getUpdTimStmp() {
        return (Date) get(TBTHB5HIK.UPDTIMSTMP);
    }

    /**
     * �X�V�v���O������ݒ肵�܂��B
     * @param val String �X�V�v���O����
     */
    public void setUpdaPl(String val) {
        set(TBTHB5HIK.UPDAPL, val);
    }

    /**
     * �X�V�v���O������Ԃ��܂��B
     * @return String �X�V�v���O����
     */
    public String getUpdaPl() {
        return (String) get(TBTHB5HIK.UPDAPL);
    }

    /**
     * �X�V�S���҂�ݒ肵�܂��B
     * @param val String �X�V�S����
     */
    public void setUpdTnt(String val) {
        set(TBTHB5HIK.UPDTN, val);
    }

    /**
     * �X�V�S���҂�Ԃ��܂��B
     * @return String �X�V�S����
     */
    public String getUpdTnt() {
        return (String) get(TBTHB5HIK.UPDTN);
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
     * @param val String �c�Ə��i��j�R�[�h
     */
    public void setEgCd(String val) {
        set(TBTHB5HIK.EGCD, val);
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
     * @return String �c�Ə��i��j�R�[�h
     */
    public String getEgCd() {
        return (String) get(TBTHB5HIK.EGCD);
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String val) {
        set(TBTHB5HIK.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB5HIK.TKSKGYCD);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB5HIK.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB5HIK.TKSBMNSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB5HIK.TKSTNTSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB5HIK.TKSTNTSEQNO);
    }

    /**
     * ��ʂ�ݒ肵�܂��B
     * @param val String ���
     */
    public void setSybt(String val) {
        set(TBTHB5HIK.SYBT, val);
    }

    /**
     * ��ʂ�Ԃ��܂��B
     * @return String ���
     */
    public String getSybt() {
        return (String) get(TBTHB5HIK.SYBT);
    }

    /**
     * ���R�[�h��ʂ�ݒ肵�܂��B
     * @param val String ���R�[�h���
     */
    public void setRecCd(String val) {
        set(TBTHB5HIK.RECCD, val);
    }

    /**
     * ���R�[�h��ʂ�Ԃ��܂��B
     * @return String ���R�[�h���
     */
    public String getRecCd() {
        return (String) get(TBTHB5HIK.RECCD);
    }

    /**
     * �˗��ԍ���ݒ肵�܂��B
     * @param val String �˗��ԍ�
     */
    public void setIrban(String val) {
        set(TBTHB5HIK.IRBAN, val);
    }

    /**
     * �˗��ԍ���Ԃ��܂��B
     * @return String �˗��ԍ�
     */
    public String getIrban() {
        return (String) get(TBTHB5HIK.IRBAN);
    }

    /**
     * �˗��s�ԍ���ݒ肵�܂��B
     * @param val String �˗��s�ԍ�
     */
    public void setIrrowban(String val) {
        set(TBTHB5HIK.IRROWBAN, val);
    }

    /**
     * �˗��s�ԍ���Ԃ��܂��B
     * @return String �˗��s�ԍ�
     */
    public String getIrrowban() {
        return (String) get(TBTHB5HIK.IRROWBAN);
    }

    /**
     * �����Ǘ��ԍ���ݒ肵�܂��B
     * @param val String �����Ǘ��ԍ�
     */
    public void setRireNo(String val) {
        set(TBTHB5HIK.RIRENO, val);
    }

    /**
     * �����Ǘ��ԍ���Ԃ��܂��B
     * @return String �����Ǘ��ԍ�
     */
    public String getRireNo() {
        return (String) get(TBTHB5HIK.RIRENO);
    }

    /**
     * �˗��N����ݒ肵�܂��B
     * @param val String �˗��N��
     */
    public void setIryymm(String val) {
        set(TBTHB5HIK.IRYYMM, val);
    }

    /**
     * �˗��N����Ԃ��܂��B
     * @return String �˗��N��
     */
    public String getIryymm() {
        return (String) get(TBTHB5HIK.IRYYMM);
    }

    /**
     * �˗��敪��ݒ肵�܂��B
     * @param val String �˗��敪
     */
    public void setIrKbn(String val) {
        set(TBTHB5HIK.IRKBN, val);
    }

    /**
     * �˗��敪��Ԃ��܂��B
     * @return String �˗��敪
     */
    public String getIrKbn() {
        return (String) get(TBTHB5HIK.IRKBN);
    }

    /**
     * ���Ӑ�R�[�h��ݒ肵�܂��B
     * @param val String ���Ӑ�R�[�h
     */
    public void setTokuiCd(String val) {
        set(TBTHB5HIK.TOKUICD, val);
    }

    /**
     * ���Ӑ�R�[�h��Ԃ��܂��B
     * @return String ���Ӑ�R�[�h
     */
    public String getTokuiCd() {
        return (String) get(TBTHB5HIK.TOKUICD);
    }

    /**
     * �c�ƕ��R�[�h��ݒ肵�܂��B
     * @param val String �c�ƕ��R�[�h
     */
    public void setEiCode(String val) {
        set(TBTHB5HIK.EICODE, val);
    }

    /**
     * �c�ƕ��R�[�h��Ԃ��܂��B
     * @return String �c�ƕ��R�[�h
     */
    public String getEiCode() {
        return (String) get(TBTHB5HIK.EICODE);
    }

    /**
     * �c�ƕ�����ݒ肵�܂��B
     * @param val String �c�ƕ���
     */
    public void setEiName(String val) {
        set(TBTHB5HIK.EINAME, val);
    }

    /**
     * �c�ƕ�����Ԃ��܂��B
     * @return String �c�ƕ���
     */
    public String getEiName() {
        return (String) get(TBTHB5HIK.EINAME);
    }

    /**
     * �X�Ԃ�ݒ肵�܂��B
     * @param val String �X��
     */
    public void setTenCd(String val) {
        set(TBTHB5HIK.TENCD, val);
    }

    /**
     * �X�Ԃ�Ԃ��܂��B
     * @return String �X��
     */
    public String getTenCd() {
        return (String) get(TBTHB5HIK.TENCD);
    }

    /**
     * �X����ݒ肵�܂��B
     * @param val String �X��
     */
    public void setTenName(String val) {
        set(TBTHB5HIK.TENNAME, val);
    }

    /**
     * �X����Ԃ��܂��B
     * @return String �X��
     */
    public String getTenName() {
        return (String) get(TBTHB5HIK.TENNAME);
    }

    /**
     * �\�Z�敪��ݒ肵�܂��B
     * @param val String �\�Z�敪
     */
    public void setYosaKbn(String val) {
        set(TBTHB5HIK.YOSAKBN, val);
    }

    /**
     * �\�Z�敪��Ԃ��܂��B
     * @return String �\�Z�敪
     */
    public String getYosaKbn() {
        return (String) get(TBTHB5HIK.YOSAKBN);
    }

    /**
     * �˗����e��ݒ肵�܂��B
     * @param val String �˗����e
     */
    public void setIrnai(String val) {
        set(TBTHB5HIK.IRNAI, val);
    }

    /**
     * �˗����e��Ԃ��܂��B
     * @return String �˗����e
     */
    public String getIrnai() {
        return (String) get(TBTHB5HIK.IRNAI);
    }

    /**
     * ���f�B�A�R�[�h��ݒ肵�܂��B
     * @param val String ���f�B�A�R�[�h
     */
    public void setMediaCd(String val) {
        set(TBTHB5HIK.MEDIACD, val);
    }

    /**
     * ���f�B�A�R�[�h��Ԃ��܂��B
     * @return String ���f�B�A�R�[�h
     */
    public String getMediaCd() {
        return (String) get(TBTHB5HIK.MEDIACD);
    }

    /**
     * ���f�B�A����ݒ肵�܂��B
     * @param val String ���f�B�A��
     */
    public void setMediaName(String val) {
        set(TBTHB5HIK.MEDIANAME, val);
    }

    /**
     * ���f�B�A����Ԃ��܂��B
     * @return String ���f�B�A��
     */
    public String getMediaName() {
        return (String) get(TBTHB5HIK.MEDIANAME);
    }

    /**
     * �T�C�Y�R�[�h��ݒ肵�܂��B
     * @param val String �T�C�Y�R�[�h
     */
    public void setSizeCd(String val) {
        set(TBTHB5HIK.SIZECD, val);
    }

    /**
     * �T�C�Y�R�[�h��Ԃ��܂��B
     * @return String �T�C�Y�R�[�h
     */
    public String getSizeCd() {
        return (String) get(TBTHB5HIK.SIZECD);
    }
    /**
     * �T�C�Y��ݒ肵�܂��B
     * @param val String �T�C�Y
     */
    public void setSizeName(String val) {
        set(TBTHB5HIK.SIZENAME, val);
    }

    /**
     * �T�C�Y��Ԃ��܂��B
     * @return String �T�C�Y
     */
    public String getSizeName() {
        return (String) get(TBTHB5HIK.SIZENAME);
    }

    /**
     * �f�ړ�1��ݒ肵�܂��B
     * @param val String �f�ړ�1
     */
    public void setKeisai1(String val) {
        set(TBTHB5HIK.KEISAI1, val);
    }

    /**
     * �f�ړ�1��Ԃ��܂��B
     * @return String �f�ړ�1
     */
    public String getKeisai1() {
        return (String) get(TBTHB5HIK.KEISAI1);
    }

    /**
     * �f�ړ�2��ݒ肵�܂��B
     * @param val String �f�ړ�2
     */
    public void setKeisai2(String val) {
        set(TBTHB5HIK.KEISAI2, val);
    }

    /**
     * �f�ړ�2��Ԃ��܂��B
     * @return String �f�ړ�2
     */
    public String getKeisai2() {
        return (String) get(TBTHB5HIK.KEISAI2);
    }

    /**
     * �f�ړ�3��ݒ肵�܂��B
     * @param val String �f�ړ�3
     */
    public void setKeisai3(String val) {
        set(TBTHB5HIK.KEISAI3, val);
    }

    /**
     * �f�ړ�3��Ԃ��܂��B
     * @return String �f�ړ�3
     */
    public String getKeisai3() {
        return (String) get(TBTHB5HIK.KEISAI3);
    }

    /**
     * �f�ړ�4��ݒ肵�܂��B
     * @param val String �f�ړ�4
     */
    public void setKeisai4(String val) {
        set(TBTHB5HIK.KEISAI4, val);
    }

    /**
     * �f�ړ�4��Ԃ��܂��B
     * @return String �f�ړ�4
     */
    public String getKeisai4() {
        return (String) get(TBTHB5HIK.KEISAI4);
    }

    /**
     * �f�ړ�5��ݒ肵�܂��B
     * @param val String �f�ړ�5
     */
    public void setKeisai5(String val) {
        set(TBTHB5HIK.KEISAI5, val);
    }

    /**
     * �f�ړ�5��Ԃ��܂��B
     * @return String �f�ړ�5
     */
    public String getKeisai5() {
        return (String) get(TBTHB5HIK.KEISAI5);
    }

    /**
     * �`�ԋ敪�R�[�h��ݒ肵�܂��B
     * @param val String �`�ԋ敪�R�[�h
     */
    public void setKeitaiCd(String val) {
        set(TBTHB5HIK.KEITAICD, val);
    }

    /**
     * �`�ԋ敪�R�[�h��Ԃ��܂��B
     * @return String �`�ԋ敪�R�[�h
     */
    public String getKeitaiCd() {
        return (String) get(TBTHB5HIK.KEITAICD);
    }

    /**
     * �`�ԋ敪����ݒ肵�܂��B
     * @param val String �`�ԋ敪��
     */
    public void setKeitaiName(String val) {
        set(TBTHB5HIK.KEITAINAME, val);
    }

    /**
     * �`�ԋ敪����Ԃ��܂��B
     * @return String �`�ԋ敪��
     */
    public String getKeitaiName() {
        return (String) get(TBTHB5HIK.KEITAINAME);
    }

    /**
     * �˗���1��ݒ肵�܂��B
     * @param val String �˗���1
     */
    public void setIrmonth1(String val) {
        set(TBTHB5HIK.IRMONTH1, val);
    }

    /**
     * �˗���1��Ԃ��܂��B
     * @return String �˗���1
     */
    public String getIrmonth1() {
        return (String) get(TBTHB5HIK.IRMONTH1);
    }

    /**
     * ������1��ݒ肵�܂��B
     * @param val BigDecimal ������1
     */
    public void setHosoryo1(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO1, val);
    }

    /**
     * ������1��Ԃ��܂��B
     * @return BigDecimal ������1
     */
    @XmlElement(required = true)
    public BigDecimal getHosoryo1() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO1);
    }

    /**
     * �˗���2��ݒ肵�܂��B
     * @param val String �˗���2
     */
    public void setIrmonth2(String val) {
        set(TBTHB5HIK.IRMONTH2, val);
    }

    /**
     * �˗���2��Ԃ��܂��B
     * @return String �˗���2
     */
    public String getIrmonth2() {
        return (String) get(TBTHB5HIK.IRMONTH2);
    }

    /**
     * ������2��ݒ肵�܂��B
     * @param val BigDecimal ������2
     */
    public void setHosoryo2(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO2, val);
    }

    /**
     * ������2��Ԃ��܂��B
     * @return BigDecimal ������2
     */
    @XmlElement(required = true)
    public BigDecimal getHosoryo2() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO2);
    }

    /**
     * �˗���3��ݒ肵�܂��B
     * @param val String �˗���3
     */
    public void setIrmonth3(String val) {
        set(TBTHB5HIK.IRMONTH3, val);
    }

    /**
     * �˗���3��Ԃ��܂��B
     * @return String �˗���3
     */
    public String getIrmonth3() {
        return (String) get(TBTHB5HIK.IRMONTH3);
    }

    /**
     * ������3��ݒ肵�܂��B
     * @param val BigDecimal ������3
     */
    public void setHosoryo3(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO3, val);
    }

    /**
     * ������3��Ԃ��܂��B
     * @return BigDecimal ������3
     */
    @XmlElement(required = true)
    public BigDecimal getHosoryo3() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO3);
    }

    /**
     * �˗���4��ݒ肵�܂��B
     * @param val String �˗���4
     */
    public void setIrmonth4(String val) {
        set(TBTHB5HIK.IRMONTH4, val);
    }

    /**
     * �˗���4��Ԃ��܂��B
     * @return String �˗���4
     */
    public String getIrmonth4() {
        return (String) get(TBTHB5HIK.IRMONTH4);
    }

    /**
     * ������4��ݒ肵�܂��B
     * @param val BigDecimal ������4
     */
    public void setHosoryo4(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO4, val);
    }

    /**
     * ������4��Ԃ��܂��B
     * @return BigDecimal ������4
     */
    @XmlElement(required = true)
    public BigDecimal getHosoryo4() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO4);
    }

    /**
     * �˗���5��ݒ肵�܂��B
     * @param val String �˗���5
     */
    public void setIrmonth5(String val) {
        set(TBTHB5HIK.IRMONTH5, val);
    }

    /**
     * �˗���5��Ԃ��܂��B
     * @return String �˗���5
     */
    public String getIrmonth5() {
        return (String) get(TBTHB5HIK.IRMONTH5);
    }

    /**
     * ������5��ݒ肵�܂��B
     * @param val BigDecimal ������5
     */
    public void setHosoryo5(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO5, val);
    }

    /**
     * ������5��Ԃ��܂��B
     * @return BigDecimal ������5
     */
    @XmlElement(required = true)
    public BigDecimal getHosoryo5() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO5);
    }

    /**
     * �˗���6��ݒ肵�܂��B
     * @param val String �˗���6
     */
    public void setIrmonth6(String val) {
        set(TBTHB5HIK.IRMONTH6, val);
    }

    /**
     * �˗���6��Ԃ��܂��B
     * @return String �˗���6
     */
    public String getIrmonth6() {
        return (String) get(TBTHB5HIK.IRMONTH6);
    }

    /**
     * ������6��ݒ肵�܂��B
     * @param val BigDecimal ������6
     */
    public void setHosoryo6(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO6, val);
    }

    /**
     * ������6��Ԃ��܂��B
     * @return BigDecimal ������6
     */
    @XmlElement(required = true)
    public BigDecimal getHosoryo6() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO6);
    }

    /**
     * ��ʌf�ڃR�[�h��ݒ肵�܂��B
     * @param val String ��ʌf�ڃR�[�h
     */
    public void setKotukeiCd(String val) {
        set(TBTHB5HIK.KOTUKEICD, val);
    }

    /**
     * ��ʌf�ڃR�[�h��Ԃ��܂��B
     * @return String ��ʌf�ڃR�[�h
     */
    public String getKotukeiCd() {
        return (String) get(TBTHB5HIK.KOTUKEICD);
    }

    /**
     * ��ʌf�ږ���ݒ肵�܂��B
     * @param val String ��ʌf�ږ�
     */
    public void setKotukeiName(String val) {
        set(TBTHB5HIK.KOTUKEINAME, val);
    }

    /**
     * ��ʌf�ږ���Ԃ��܂��B
     * @return String ��ʌf�ږ�
     */
    public String getKotukeiName() {
        return (String) get(TBTHB5HIK.KOTUKEINAME);
    }

    /**
     * �f�ړ���ݒ肵�܂��B
     * @param val String �f�ړ�
     */
    public void setKeisai(String val) {
        set(TBTHB5HIK.KEISAI, val);
    }

    /**
     * �f�ړ���Ԃ��܂��B
     * @return String �f�ړ�
     */
    public String getKeisai() {
        return (String) get(TBTHB5HIK.KEISAI);
    }

    /**
     * �f�ڗ���ݒ肵�܂��B
     * @param val BigDecimal �f�ڗ�
     */
    public void setKeisairyo(BigDecimal val) {
        set(TBTHB5HIK.KEISAIRYO, val);
    }

    /**
     * �f�ڗ���Ԃ��܂��B
     * @return BigDecimal �f�ڗ�
     */
    @XmlElement(required = true)
    public BigDecimal getKeisairyo() {
        return (BigDecimal) get(TBTHB5HIK.KEISAIRYO);
    }

    /**
     * �f�ڒP����ݒ肵�܂��B
     * @param val String �f�ڒP��
     */
    public void setKeisaiTanka(String val) {
        set(TBTHB5HIK.KEISAITANKA, val);
    }

    /**
     * �f�ڒP����Ԃ��܂��B
     * @return String �f�ڒP��
     */
    @XmlElement(required = true)
    public String getKeisaiTanka() {
        return (String) get(TBTHB5HIK.KEISAITANKA);
    }

    /**
     * �f�ډ񐔂�ݒ肵�܂��B
     * @param val String �f�ډ�
     */
    public void setKeisaiCnt(String val) {
        set(TBTHB5HIK.KEISAICNT, val);
    }

    /**
     * �f�ډ񐔂�Ԃ��܂��B
     * @return String �f�ډ�
     */
    public String getKeisaiCnt() {
        return (String) get(TBTHB5HIK.KEISAICNT);
    }

    /**
     * ���i�敪��ݒ肵�܂��B
     * @param val String ���i�敪
     */
    public void setSyohiKbn(String val) {
        set(TBTHB5HIK.SYOHIKBN, val);
    }

    /**
     * ���i�敪��Ԃ��܂��B
     * @return String ���i�敪
     */
    public String getSyohiKbn() {
        return (String) get(TBTHB5HIK.SYOHIKBN);
    }

    /**
     * ���i����ݒ肵�܂��B
     * @param val String �X�y�[�X��
     */
    public void setSyohiName(String val) {
        set(TBTHB5HIK.SYOHINAME, val);
    }

    /**
     * ���i����Ԃ��܂��B
     * @return String �X�y�[�X��
     */
    public String getSyohiName() {
        return (String) get(TBTHB5HIK.SYOHINAME);
    }

    /**
     * �זڋ敪��ݒ肵�܂��B
     * @param val String �זڋ敪
     */
    public void setSaiKbn(String val) {
        set(TBTHB5HIK.SAIKBN, val);
    }

    /**
     * �זڋ敪��Ԃ��܂��B
     * @return String �זڋ敪
     */
    public String getSaiKbn() {
        return (String) get(TBTHB5HIK.SAIKBN);
    }

    /**
     * �E�v�R�[�h��ݒ肵�܂��B
     * @param val String �E�v�R�[�h
     */
    public void setTekiCd(String val) {
        set(TBTHB5HIK.TEKICD, val);
    }

    /**
     * �E�v�R�[�h��Ԃ��܂��B
     * @return String �E�v�R�[�h
     */
    public String getTekiCd() {
        return (String) get(TBTHB5HIK.TEKICD);
    }

    /**
     * ����\��N����ݒ肵�܂��B
     * @param val String ����\��N��
     */
    public void setUriyymm(String val) {
        set(TBTHB5HIK.URIYYMM, val);
    }

    /**
     * ����\��N����Ԃ��܂��B
     * @return String ����\��N��
     */
    public String getUriyymm() {
        return (String) get(TBTHB5HIK.URIYYMM);
    }

    /**
     * �S���Җ���ݒ肵�܂��B
     * @param val String �S���Җ�
     */
    public void setTanName(String val) {
        set(TBTHB5HIK.TANNAME, val);
    }

    /**
     * �S���Җ���Ԃ��܂��B
     * @return String �S���Җ�
     */
    public String getTanName() {
        return (String) get(TBTHB5HIK.TANNAME);
    }

    /**
     * �S���ҋΖ���������ݒ肵�܂��B
     * @param val String �S���ҋΖ�������
     */
    public void setTankinName(String val) {
        set(TBTHB5HIK.TANKINNAME, val);
    }

    /**
     * �S���ҋΖ���������Ԃ��܂��B
     * @return String �S���ҋΖ�������
     */
    public String getTankinName() {
        return (String) get(TBTHB5HIK.TANKINNAME);
    }

    /**
     * ����ʂ�ݒ肵�܂��B
     * @param val String �����
     */
    public void setAnsyube(String val) {
        set(TBTHB5HIK.ANSYUBE, val);
    }

    /**
     * ����ʂ�Ԃ��܂��B
     * @return String �����
     */
    public String getAnsyube() {
        return (String) get(TBTHB5HIK.ANSYUBE);
    }

    /**
     * �X�V�敪��ݒ肵�܂��B
     * @param val String �X�V�敪
     */
    public void setKouKbn(String val) {
        set(TBTHB5HIK.KOUKBN, val);
    }

    /**
     * �X�V�敪��Ԃ��܂��B
     * @return String �X�V�敪
     */
    public String getKouKbn() {
        return (String) get(TBTHB5HIK.KOUKBN);
    }

    /**
     * ���l1��ݒ肵�܂��B
     * @param val String ���l1
     */
    public void setBikou1(String val) {
        set(TBTHB5HIK.BIKOU1, val);
    }

    /**
     * ���l1��Ԃ��܂��B
     * @return String ���l1
     */
    public String getBikou1() {
        return (String) get(TBTHB5HIK.BIKOU1);
    }

    /**
     * ���l2��ݒ肵�܂��B
     * @param val String ���l2
     */
    public void setBikou2(String val) {
        set(TBTHB5HIK.BIKOU2, val);
    }

    /**
     * ���l2��Ԃ��܂��B
     * @return String ���l2
     */
    public String getBikou2() {
        return (String) get(TBTHB5HIK.BIKOU2);
    }

    /**
     * �F���R�[�h��ݒ肵�܂��B
     * @param val String �F���R�[�h
     */
    public void setColorCd(String val) {
        set(TBTHB5HIK.COLORCD , val);
    }

    /**
     * �F���R�[�h��Ԃ��܂��B
     * @return String �F���R�[�h
     */
    public String getColorCd() {
        return (String) get(TBTHB5HIK.COLORCD );
    }

    /**
     * �X�y�[�X�R�[�h��ݒ肵�܂��B
     * @param val String �X�y�[�X�R�[�h
     */
    public void setSpaceCd(String val) {
        set(TBTHB5HIK.SPACECD , val);
    }

    /**
     * �X�y�[�X�R�[�h��Ԃ��܂��B
     * @return String �X�y�[�X�R�[�h
     */
    public String getSpaceCd() {
        return (String) get(TBTHB5HIK.SPACECD );
    }

    /**
     * ��ʂP�R�[�h��ݒ肵�܂��B
     * @param val String ��ʂP�R�[�h
     */
    public void setSybt1Cd(String val) {
        set(TBTHB5HIK.SYBT1CD , val);
    }

    /**
     * ��ʂP�R�[�h��Ԃ��܂��B
     * @return String ��ʂP�R�[�h
     */
    public String getSybt1Cd() {
        return (String) get(TBTHB5HIK.SYBT1CD);
    }

    /**
     * ��ʂQ�R�[�h��ݒ肵�܂��B
     * @param val String ��ʂQ�R�[�h
     */
    public void setSybt2Cd(String val) {
        set(TBTHB5HIK.SYBT2CD , val);
    }

    /**
     * ��ʂQ�R�[�h��Ԃ��܂��B
     * @return String ��ʂQ�R�[�h
     */
    public String getSybt2Cd() {
        return (String) get(TBTHB5HIK.SYBT2CD);
    }

    /**
     * �f�U�C���ύX�񐔂�ݒ肵�܂��B
     * @param val String �f�U�C���ύX��
     */
    public void setDesignCnt(String val) {
        set(TBTHB5HIK.DESIGNCNT , val);
    }

    /**
     * �f�U�C���ύX�񐔂�Ԃ��܂��B
     * @return String �f�U�C���ύX��
     */
    public String getDesignCnt() {
        return (String) get(TBTHB5HIK.DESIGNCNT);
    }

    /**
     * �f�ڏꏊ�R�[�h��ݒ肵�܂��B
     * @param val String �f�ڏꏊ�R�[�h
     */
    public void setPlaceCd(String val) {
        set(TBTHB5HIK.PLACECD , val);
    }

    /**
     * �f�ڏꏊ�R�[�h��Ԃ��܂��B
     * @return String �f�ڏꏊ�R�[�h
     */
    public String getPlaceCd() {
        return (String) get(TBTHB5HIK.PLACECD);
    }

    /**
     * ������ݒ肵�܂��B
     * @param val BigDecimal �����
     */
    public void setPrintryo(BigDecimal val) {
        set(TBTHB5HIK.PRINTRYO, val);
    }

    /**
     * ������Ԃ��܂��B
     * @return BigDecimal �����
     */
    @XmlElement(required = true)
    public BigDecimal getPrintryo() {
        return (BigDecimal) get(TBTHB5HIK.PRINTRYO);
    }

    /**
     * ���֍�Ɨ���ݒ肵�܂��B
     * @param val BigDecimal ���֍�Ɨ�
     */
    public void setSashikaeryo(BigDecimal val) {
        set(TBTHB5HIK.SASHIKAERYO, val);
    }

    /**
     * ���֍�Ɨ���Ԃ��܂��B
     * @return BigDecimal ���֍�Ɨ�
     */
    @XmlElement(required = true)
    public BigDecimal getSashikaeryo() {
        return (BigDecimal) get(TBTHB5HIK.SASHIKAERYO);
    }

    /**
     * �f�U�C������ݒ肵�܂��B
     * @param val BigDecimal �f�U�C����
     */
    public void setDesignryo(BigDecimal val) {
        set(TBTHB5HIK.DESIGNRYO, val);
    }

    /**
     * �f�U�C������Ԃ��܂��B
     * @return BigDecimal �f�U�C����
     */
    @XmlElement(required = true)
    public BigDecimal getDesignryo() {
        return (BigDecimal) get(TBTHB5HIK.DESIGNRYO);
    }

    /**
     * �ŉ����ݒ肵�܂��B
     * @param val BigDecimal �ŉ���
     */
    public void setHanshitaryo(BigDecimal val) {
        set(TBTHB5HIK.HANSHITARYO, val);
    }

    /**
     * �ŉ����Ԃ��܂��B
     * @return BigDecimal �ŉ���
     */
    @XmlElement(required = true)
    public BigDecimal getHanshitaryo() {
        return (BigDecimal) get(TBTHB5HIK.HANSHITARYO);
    }

    /**
     * ���ő��ݒ肵�܂��B
     * @param val BigDecimal ���ő�
     */
    public void setSeihanryo(BigDecimal val) {
        set(TBTHB5HIK.SEIHANRYO, val);
    }

    /**
     * ���ő��Ԃ��܂��B
     * @return BigDecimal ���ő�
     */
    @XmlElement(required = true)
    public BigDecimal getSeihanryo() {
        return (BigDecimal) get(TBTHB5HIK.SEIHANRYO);
    }

    /**
     * �o�^�N������ݒ肵�܂��B
     * @param val String �o�^�N����
     */
    public void setTouDate(String val) {
        set(TBTHB5HIK.TOUDATE, val);
    }

    /**
     * �o�^�N������Ԃ��܂��B
     * @return String �o�^�N����
     */
    public String getTouDate() {
        return (String) get(TBTHB5HIK.TOUDATE);
    }

    /**
     * �ύX�N������ݒ肵�܂��B
     * @param val String �ύX�N����
     */
    public void setHenDate(String val) {
        set(TBTHB5HIK.HENDATE, val);
    }

    /**
     * �ύX�N������Ԃ��܂��B
     * @return String �ύX�N����
     */
    public String getHenDate() {
        return (String) get(TBTHB5HIK.HENDATE);
    }

    /**
     * ����N������ݒ肵�܂��B
     * @param val String ����N����
     */
    public void setTorDate(String val) {
        set(TBTHB5HIK.TORDATE, val);
    }

    /**
     * ����N������Ԃ��܂��B
     * @return String ����N����
     */
    public String getTorDate() {
        return (String) get(TBTHB5HIK.TORDATE);
    }

//    /**
//     * �ŐV�f�[�^�t���O��ݒ肵�܂��B
//     * @param val String �ŐV�f�[�^�t���O
//     */
//    public void setSaisinFlg(String val) {
//        set("SAISINFLG", val);
//    }
//
//    /**
//     * �ŐV�f�[�^�t���O��Ԃ��܂��B
//     * @return String �ŐV�f�[�^�t���O
//     */
//    public String getSaisinFlg() {
//        return (String) get("SAISINFLG");
//    }
//
//    /**
//     * �X�V�敪����ݒ肵�܂��B
//     * @param val String �X�V�敪��
//     */
//    public void setKouKbnName(String val) {
//        set("KOUKBNNAME", val);
//    }
//
//    /**
//     * �X�V�敪����Ԃ��܂��B
//     * @return String �X�V�敪��
//     */
//    public String getKouKbnName() {
//        return (String) get("KOUKBNNAME");
//    }

//    /**
//     * �X�e�[�^�X��ݒ肵�܂��B
//     * @param val String �X�e�[�^�X
//     */
//    public void setStatus(String val) {
//        set("STATUS", val);
//    }
//
//    /**
//     * �X�e�[�^�X��Ԃ��܂��B
//     * @return String �X�e�[�^�X
//     */
//    public String getStatus() {
//        return (String) get("STATUS");
//    }

    /**
     * �X�y�[�X����ݒ肵�܂��B
     * @param val String �X�y�[�X��
     */
    public void setSpaceName(String val) {
        set(TBTHB5HIK.SPACENAME, val);
    }

    /**
     * �X�y�[�X����Ԃ��܂��B
     * @return String �X�y�[�X��
     */
    public String getSpaceName() {
        return (String) get(TBTHB5HIK.SPACENAME);
    }

    /**
     * �_�~�[1��ݒ肵�܂��B
     * @param val String �_�~�[1
     */
    public void setDummy1(String val) {
        set("DUMMY1", val);
    }

    /**
     * �_�~�[1��Ԃ��܂��B
     * @return String �_�~�[1
     */
    public String gettDummy1() {
        return (String) get("DUMMY1");
    }

    /**
     * �_�~�[2��ݒ肵�܂��B
     * @param val String �_�~�[2
     */
    public void setDummy2(String val) {
        set("DUMMY2", val);
    }

    /**
     * �_�~�[2��Ԃ��܂��B
     * @return String �_�~�[2
     */
    public String gettDummy2() {
        return (String) get("DUMMY2");
    }

}
