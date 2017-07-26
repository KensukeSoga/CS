package jp.co.isid.kkh.model.detail;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class Thb2KmeiVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public Thb2KmeiVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new Thb2KmeiVO();
    }

    /**
     * �^�C���X�^���v��ݒ肵�܂��B
     * @param val Date �^�C���X�^���v
     */
    public void setHb2TimStmp(Date val) {
        set(TBTHB2KMEI.TIMSTMP, val);
    }

    /**
     * �^�C���X�^���v��Ԃ��܂��B
     * @return Date �^�C���X�^���v
     */
    @XmlElement(required = true)
    public Date getHb2TimStmp() {
        return (Date) get(TBTHB2KMEI.TIMSTMP);
    }

    /**
     * �X�V�v���O������ݒ肵�܂��B
     * @param val String �X�V�v���O����
     */
    public void setHb2UpdApl(String val) {
        set(TBTHB2KMEI.UPDAPL, val);
    }

    /**
     * �X�V�v���O������Ԃ��܂��B
     * @return String �X�V�v���O����
     */
    public String getHb2UpdApl() {
        return (String) get(TBTHB2KMEI.UPDAPL);
    }

    /**
     * �X�V�S���҂�ݒ肵�܂��B
     * @param val String �X�V�S����
     */
    public void setHb2UpdTnt(String val) {
        set(TBTHB2KMEI.UPDTNT, val);
    }

    /**
     * �X�V�S���҂�Ԃ��܂��B
     * @return String �X�V�S����
     */
    public String getHb2UpdTnt() {
        return (String) get(TBTHB2KMEI.UPDTNT);
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
     * @param val String �c�Ə��i��j�R�[�h
     */
    public void setHb2EgCd(String val) {
        set(TBTHB2KMEI.EGCD, val);
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
     * @return String �c�Ə��i��j�R�[�h
     */
    public String getHb2EgCd() {
        return (String) get(TBTHB2KMEI.EGCD);
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setHb2TksKgyCd(String val) {
        set(TBTHB2KMEI.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getHb2TksKgyCd() {
        return (String) get(TBTHB2KMEI.TKSKGYCD);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setHb2TksBmnSeqNo(String val) {
        set(TBTHB2KMEI.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ敔��SEQNO
     */
    public String getHb2TksBmnSeqNo() {
        return (String) get(TBTHB2KMEI.TKSBMNSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setHb2TksTntSeqNo(String val) {
        set(TBTHB2KMEI.TKSTNTSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ�S��SEQNO
     */
    public String getHb2TksTntSeqNo() {
        return (String) get(TBTHB2KMEI.TKSTNTSEQNO);
    }

    /**
     * �N����ݒ肵�܂��B
     * @param val String �N��
     */
    public void setHb2Yymm(String val) {
        set(TBTHB2KMEI.YYMM, val);
    }

    /**
     * �N����Ԃ��܂��B
     * @return String �N��
     */
    public String getHb2Yymm() {
        return (String) get(TBTHB2KMEI.YYMM);
    }

    /**
     * ��No��ݒ肵�܂��B
     * @param val String ��No
     */
    public void setHb2JyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * ��No��Ԃ��܂��B
     * @return String ��No
     */
    public String getHb2JyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * �󒍖���No��ݒ肵�܂��B
     * @param val String �󒍖���No
     */
    public void setHb2JyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * �󒍖���No��Ԃ��܂��B
     * @return String �󒍖���No
     */
    public String getHb2JyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * ���㖾��No��ݒ肵�܂��B
     * @param val String ���㖾��No
     */
    public void setHb2UrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * ���㖾��No��Ԃ��܂��B
     * @return String ���㖾��No
     */
    public String getHb2UrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * ��ڃR�[�h��ݒ肵�܂��B
     * @param val String ��ڃR�[�h
     */
    public void setHb2HimkCd(String val) {
        set(TBTHB2KMEI.HIMKCD, val);
    }

    /**
     * ��ڃR�[�h��Ԃ��܂��B
     * @return String ��ڃR�[�h
     */
    public String getHb2HimkCd() {
        return (String) get(TBTHB2KMEI.HIMKCD);
    }

    /**
     * �A�Ԃ�ݒ肵�܂��B
     * @param val String �A��
     */
    public void setHb2Renbn(String val) {
        set(TBTHB2KMEI.RENBN, val);
    }

    /**
     * �A�Ԃ�Ԃ��܂��B
     * @return String �A��
     */
    public String getHb2Renbn() {
        return (String) get(TBTHB2KMEI.RENBN);
    }

    /**
     * �N����From��ݒ肵�܂��B
     * @param val String �N����From
     */
    public void setHb2DateFrom(String val) {
        set(TBTHB2KMEI.DATEFROM, val);
    }

    /**
     * �N����From��Ԃ��܂��B
     * @return String �N����From
     */
    public String getHb2DateFrom() {
        return (String) get(TBTHB2KMEI.DATEFROM);
    }

    /**
     * �N����To��ݒ肵�܂��B
     * @param val String �N����To
     */
    public void setHb2DateTo(String val) {
        set(TBTHB2KMEI.DATETO, val);
    }

    /**
     * �N����To��Ԃ��܂��B
     * @return String �N����To
     */
    public String getHb2DateTo() {
        return (String) get(TBTHB2KMEI.DATETO);
    }

    /**
     * �������z��ݒ肵�܂��B
     * @param val BigDecimal �������z
     */
    public void setHb2SeiGak(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * �������z��Ԃ��܂��B
     * @return BigDecimal �������z
     */
    @XmlElement(required = true)
    public BigDecimal getHb2SeiGak() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * �ύX�l������ݒ肵�܂��B
     * @param val BigDecimal �ύX�l����
     */
    public void setHb2Hnnert(BigDecimal val) {
        set(TBTHB2KMEI.HNNERT, val);
    }

    /**
     * �ύX�l������Ԃ��܂��B
     * @return BigDecimal �ύX�l����
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Hnnert() {
        return (BigDecimal) get(TBTHB2KMEI.HNNERT);
    }

    /**
     * �l�����ύX�O���z��ݒ肵�܂��B
     * @param val BigDecimal �l�����ύX�O���z
     */
    public void setHb2HnmaeGak(BigDecimal val) {
        set(TBTHB2KMEI.HNMAEGAK, val);
    }

    /**
     * �l�����ύX�O���z��Ԃ��܂��B
     * @return BigDecimal �l�����ύX�O���z
     */
    @XmlElement(required = true)
    public BigDecimal getHb2HnmaeGak() {
        return (BigDecimal) get(TBTHB2KMEI.HNMAEGAK);
    }

    /**
     * �l���z��ݒ肵�܂��B
     * @param val BigDecimal �l���z
     */
    public void setHb2NebiGak(BigDecimal val) {
        set(TBTHB2KMEI.NEBIGAK, val);
    }

    /**
     * �l���z��Ԃ��܂��B
     * @return BigDecimal �l���z
     */
    @XmlElement(required = true)
    public BigDecimal getHb2NebiGak() {
        return (BigDecimal) get(TBTHB2KMEI.NEBIGAK);
    }

    /**
     * ���t1��ݒ肵�܂��B
     * @param val String ���t1
     */
    public void setHb2Date1(String val) {
        set(TBTHB2KMEI.DATE1, val);
    }

    /**
     * ���t1��Ԃ��܂��B
     * @return String ���t1
     */
    public String getHb2Date1() {
        return (String) get(TBTHB2KMEI.DATE1);
    }

    /**
     * ���t2��ݒ肵�܂��B
     * @param val String ���t2
     */
    public void setHb2Date2(String val) {
        set(TBTHB2KMEI.DATE2, val);
    }

    /**
     * ���t2��Ԃ��܂��B
     * @return String ���t2
     */
    public String getHb2Date2() {
        return (String) get(TBTHB2KMEI.DATE2);
    }

    /**
     * ���t3��ݒ肵�܂��B
     * @param val String ���t3
     */
    public void setHb2Date3(String val) {
        set(TBTHB2KMEI.DATE3, val);
    }

    /**
     * ���t3��Ԃ��܂��B
     * @return String ���t3
     */
    public String getHb2Date3() {
        return (String) get(TBTHB2KMEI.DATE3);
    }

    /**
     * ���t4��ݒ肵�܂��B
     * @param val String ���t4
     */
    public void setHb2Date4(String val) {
        set(TBTHB2KMEI.DATE4, val);
    }

    /**
     * ���t4��Ԃ��܂��B
     * @return String ���t4
     */
    public String getHb2Date4() {
        return (String) get(TBTHB2KMEI.DATE4);
    }

    /**
     * ���t5��ݒ肵�܂��B
     * @param val String ���t5
     */
    public void setHb2Date5(String val) {
        set(TBTHB2KMEI.DATE5, val);
    }

    /**
     * ���t5��Ԃ��܂��B
     * @return String ���t5
     */
    public String getHb2Date5() {
        return (String) get(TBTHB2KMEI.DATE5);
    }

    /**
     * ���t6��ݒ肵�܂��B
     * @param val String ���t6
     */
    public void setHb2Date6(String val) {
        set(TBTHB2KMEI.DATE6, val);
    }

    /**
     * ���t6��Ԃ��܂��B
     * @return String ���t6
     */
    public String getHb2Date6() {
        return (String) get(TBTHB2KMEI.DATE6);
    }

    /**
     * �敪1��ݒ肵�܂��B
     * @param val String �敪1
     */
    public void setHb2Kbn1(String val) {
        set(TBTHB2KMEI.KBN1, val);
    }

    /**
     * �敪1��Ԃ��܂��B
     * @return String �敪1
     */
    public String getHb2Kbn1() {
        return (String) get(TBTHB2KMEI.KBN1);
    }

    /**
     * �敪2��ݒ肵�܂��B
     * @param val String �敪2
     */
    public void setHb2Kbn2(String val) {
        set(TBTHB2KMEI.KBN2, val);
    }

    /**
     * �敪2��Ԃ��܂��B
     * @return String �敪2
     */
    public String getHb2Kbn2() {
        return (String) get(TBTHB2KMEI.KBN2);
    }

    /**
     * �敪3��ݒ肵�܂��B
     * @param val String �敪3
     */
    public void setHb2Kbn3(String val) {
        set(TBTHB2KMEI.KBN3, val);
    }

    /**
     * �敪3��Ԃ��܂��B
     * @return String �敪3
     */
    public String getHb2Kbn3() {
        return (String) get(TBTHB2KMEI.KBN3);
    }

    /**
     * �R�[�h1��ݒ肵�܂��B
     * @param val String �R�[�h1
     */
    public void setHb2Code1(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * �R�[�h1��Ԃ��܂��B
     * @return String �R�[�h1
     */
    public String getHb2Code1() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * �R�[�h2��ݒ肵�܂��B
     * @param val String �R�[�h2
     */
    public void setHb2Code2(String val) {
        set(TBTHB2KMEI.CODE2, val);
    }

    /**
     * �R�[�h2��Ԃ��܂��B
     * @return String �R�[�h2
     */
    public String getHb2Code2() {
        return (String) get(TBTHB2KMEI.CODE2);
    }

    /**
     * �R�[�h3��ݒ肵�܂��B
     * @param val String �R�[�h3
     */
    public void setHb2Code3(String val) {
        set(TBTHB2KMEI.CODE3, val);
    }

    /**
     * �R�[�h3��Ԃ��܂��B
     * @return String �R�[�h3
     */
    public String getHb2Code3() {
        return (String) get(TBTHB2KMEI.CODE3);
    }

    /**
     * �R�[�h4��ݒ肵�܂��B
     * @param val String �R�[�h4
     */
    public void setHb2Code4(String val) {
        set(TBTHB2KMEI.CODE4, val);
    }

    /**
     * �R�[�h4��Ԃ��܂��B
     * @return String �R�[�h4
     */
    public String getHb2Code4() {
        return (String) get(TBTHB2KMEI.CODE4);
    }

    /**
     * �R�[�h5��ݒ肵�܂��B
     * @param val String �R�[�h5
     */
    public void setHb2Code5(String val) {
        set(TBTHB2KMEI.CODE5, val);
    }

    /**
     * �R�[�h5��Ԃ��܂��B
     * @return String �R�[�h5
     */
    public String getHb2Code5() {
        return (String) get(TBTHB2KMEI.CODE5);
    }

    /**
     * �R�[�h6��ݒ肵�܂��B
     * @param val String �R�[�h6
     */
    public void setHb2Code6(String val) {
        set(TBTHB2KMEI.CODE6, val);
    }

    /**
     * �R�[�h6��Ԃ��܂��B
     * @return String �R�[�h6
     */
    public String getHb2Code6() {
        return (String) get(TBTHB2KMEI.CODE6);
    }

    /**
     * ����1(����)��ݒ肵�܂��B
     * @param val String ����1(����)
     */
    public void setHb2Name1(String val) {
        set(TBTHB2KMEI.NAME1, val);
    }

    /**
     * ����1(����)��Ԃ��܂��B
     * @return String ����1(����)
     */
    public String getHb2Name1() {
        return (String) get(TBTHB2KMEI.NAME1);
    }

    /**
     * ����2(����)��ݒ肵�܂��B
     * @param val String ����2(����)
     */
    public void setHb2Name2(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * ����2(����)��Ԃ��܂��B
     * @return String ����2(����)
     */
    public String getHb2Name2() {
        return (String) get(TBTHB2KMEI.NAME2);
    }

    /**
     * ����3(����)��ݒ肵�܂��B
     * @param val String ����3(����)
     */
    public void setHb2Name3(String val) {
        set(TBTHB2KMEI.NAME3, val);
    }

    /**
     * ����3(����)��Ԃ��܂��B
     * @return String ����3(����)
     */
    public String getHb2Name3() {
        return (String) get(TBTHB2KMEI.NAME3);
    }

    /**
     * ����4(����)��ݒ肵�܂��B
     * @param val String ����4(����)
     */
    public void setHb2Name4(String val) {
        set(TBTHB2KMEI.NAME4, val);
    }

    /**
     * ����4(����)��Ԃ��܂��B
     * @return String ����4(����)
     */
    public String getHb2Name4() {
        return (String) get(TBTHB2KMEI.NAME4);
    }

    /**
     * ����5(����)��ݒ肵�܂��B
     * @param val String ����5(����)
     */
    public void setHb2Name5(String val) {
        set(TBTHB2KMEI.NAME5, val);
    }

    /**
     * ����5(����)��Ԃ��܂��B
     * @return String ����5(����)
     */
    public String getHb2Name5() {
        return (String) get(TBTHB2KMEI.NAME5);
    }

    /**
     * ����6(����)��ݒ肵�܂��B
     * @param val String ����6(����)
     */
    public void setHb2Name6(String val) {
        set(TBTHB2KMEI.NAME6, val);
    }

    /**
     * ����6(����)��Ԃ��܂��B
     * @return String ����6(����)
     */
    public String getHb2Name6() {
        return (String) get(TBTHB2KMEI.NAME6);
    }

    /**
     * ����7(����)��ݒ肵�܂��B
     * @param val String ����7(����)
     */
    public void setHb2Name7(String val) {
        set(TBTHB2KMEI.NAME7, val);
    }

    /**
     * ����7(����)��Ԃ��܂��B
     * @return String ����7(����)
     */
    public String getHb2Name7() {
        return (String) get(TBTHB2KMEI.NAME7);
    }

    /**
     * ����8(����)��ݒ肵�܂��B
     * @param val String ����8(����)
     */
    public void setHb2Name8(String val) {
        set(TBTHB2KMEI.NAME8, val);
    }

    /**
     * ����8(����)��Ԃ��܂��B
     * @return String ����8(����)
     */
    public String getHb2Name8() {
        return (String) get(TBTHB2KMEI.NAME8);
    }

    /**
     * ����9(����)��ݒ肵�܂��B
     * @param val String ����9(����)
     */
    public void setHb2Name9(String val) {
        set(TBTHB2KMEI.NAME9, val);
    }

    /**
     * ����9(����)��Ԃ��܂��B
     * @return String ����9(����)
     */
    public String getHb2Name9() {
        return (String) get(TBTHB2KMEI.NAME9);
    }

    /**
     * ����10(����)��ݒ肵�܂��B
     * @param val String ����10(����)
     */
    public void setHb2Name10(String val) {
        set(TBTHB2KMEI.NAME10, val);
    }

    /**
     * ����10(����)��Ԃ��܂��B
     * @return String ����10(����)
     */
    public String getHb2Name10() {
        return (String) get(TBTHB2KMEI.NAME10);
    }

    /**
     * ����11(����)��ݒ肵�܂��B
     * @param val String ����11(����)
     */
    public void setHb2Name11(String val) {
        set(TBTHB2KMEI.NAME11, val);
    }

    /**
     * ����11(����)��Ԃ��܂��B
     * @return String ����11(����)
     */
    public String getHb2Name11() {
        return (String) get(TBTHB2KMEI.NAME11);
    }

    /**
     * ����12(����)��ݒ肵�܂��B
     * @param val String ����12(����)
     */
    public void setHb2Name12(String val) {
        set(TBTHB2KMEI.NAME12, val);
    }

    /**
     * ����12(����)��Ԃ��܂��B
     * @return String ����12(����)
     */
    public String getHb2Name12() {
        return (String) get(TBTHB2KMEI.NAME12);
    }

    /**
     * ����13(����)��ݒ肵�܂��B
     * @param val String ����13(����)
     */
    public void setHb2Name13(String val) {
        set(TBTHB2KMEI.NAME13, val);
    }

    /**
     * ����13(����)��Ԃ��܂��B
     * @return String ����13(����)
     */
    public String getHb2Name13() {
        return (String) get(TBTHB2KMEI.NAME13);
    }

    /**
     * ����14(����)��ݒ肵�܂��B
     * @param val String ����14(����)
     */
    public void setHb2Name14(String val) {
        set(TBTHB2KMEI.NAME14, val);
    }

    /**
     * ����14(����)��Ԃ��܂��B
     * @return String ����14(����)
     */
    public String getHb2Name14() {
        return (String) get(TBTHB2KMEI.NAME14);
    }

    /**
     * ����15(����)��ݒ肵�܂��B
     * @param val String ����15(����)
     */
    public void setHb2Name15(String val) {
        set(TBTHB2KMEI.NAME15, val);
    }

    /**
     * ����15(����)��Ԃ��܂��B
     * @return String ����15(����)
     */
    public String getHb2Name15() {
        return (String) get(TBTHB2KMEI.NAME15);
    }

    /**
     * ����16(����)��ݒ肵�܂��B
     * @param val String ����16(����)
     */
    public void setHb2Name16(String val) {
        set(TBTHB2KMEI.NAME16, val);
    }

    /**
     * ����16(����)��Ԃ��܂��B
     * @return String ����16(����)
     */
    public String getHb2Name16() {
        return (String) get(TBTHB2KMEI.NAME16);
    }

    /**
     * ����17(����)��ݒ肵�܂��B
     * @param val String ����17(����)
     */
    public void setHb2Name17(String val) {
        set(TBTHB2KMEI.NAME17, val);
    }

    /**
     * ����17(����)��Ԃ��܂��B
     * @return String ����17(����)
     */
    public String getHb2Name17() {
        return (String) get(TBTHB2KMEI.NAME17);
    }

    /**
     * ����18(����)��ݒ肵�܂��B
     * @param val String ����18(����)
     */
    public void setHb2Name18(String val) {
        set(TBTHB2KMEI.NAME18, val);
    }

    /**
     * ����18(����)��Ԃ��܂��B
     * @return String ����18(����)
     */
    public String getHb2Name18() {
        return (String) get(TBTHB2KMEI.NAME18);
    }

    /**
     * ����19(����)��ݒ肵�܂��B
     * @param val String ����19(����)
     */
    public void setHb2Name19(String val) {
        set(TBTHB2KMEI.NAME19, val);
    }

    /**
     * ����19(����)��Ԃ��܂��B
     * @return String ����19(����)
     */
    public String getHb2Name19() {
        return (String) get(TBTHB2KMEI.NAME19);
    }

    /**
     * ����20(����)��ݒ肵�܂��B
     * @param val String ����20(����)
     */
    public void setHb2Name20(String val) {
        set(TBTHB2KMEI.NAME20, val);
    }

    /**
     * ����20(����)��Ԃ��܂��B
     * @return String ����20(����)
     */
    public String getHb2Name20() {
        return (String) get(TBTHB2KMEI.NAME20);
    }

    /**
     * ����21(����)��ݒ肵�܂��B
     * @param val String ����21(����)
     */
    public void setHb2Name21(String val) {
        set(TBTHB2KMEI.NAME21, val);
    }

    /**
     * ����21(����)��Ԃ��܂��B
     * @return String ����21(����)
     */
    public String getHb2Name21() {
        return (String) get(TBTHB2KMEI.NAME21);
    }

    /**
     * ����22(����)��ݒ肵�܂��B
     * @param val String ����22(����)
     */
    public void setHb2Name22(String val) {
        set(TBTHB2KMEI.NAME22, val);
    }

    /**
     * ����22(����)��Ԃ��܂��B
     * @return String ����22(����)
     */
    public String getHb2Name22() {
        return (String) get(TBTHB2KMEI.NAME22);
    }

    /**
     * ����23(����)��ݒ肵�܂��B
     * @param val String ����23(����)
     */
    public void setHb2Name23(String val) {
        set(TBTHB2KMEI.NAME23, val);
    }

    /**
     * ����23(����)��Ԃ��܂��B
     * @return String ����23(����)
     */
    public String getHb2Name23() {
        return (String) get(TBTHB2KMEI.NAME23);
    }

    /**
     * ����24(����)��ݒ肵�܂��B
     * @param val String ����24(����)
     */
    public void setHb2Name24(String val) {
        set(TBTHB2KMEI.NAME24, val);
    }

    /**
     * ����24(����)��Ԃ��܂��B
     * @return String ����24(����)
     */
    public String getHb2Name24() {
        return (String) get(TBTHB2KMEI.NAME24);
    }

    /**
     * ����25(����)��ݒ肵�܂��B
     * @param val String ����25(����)
     */
    public void setHb2Name25(String val) {
        set(TBTHB2KMEI.NAME25, val);
    }

    /**
     * ����25(����)��Ԃ��܂��B
     * @return String ����25(����)
     */
    public String getHb2Name25() {
        return (String) get(TBTHB2KMEI.NAME25);
    }

    /**
     * ����26(����)��ݒ肵�܂��B
     * @param val String ����26(����)
     */
    public void setHb2Name26(String val) {
        set(TBTHB2KMEI.NAME26, val);
    }

    /**
     * ����26(����)��Ԃ��܂��B
     * @return String ����26(����)
     */
    public String getHb2Name26() {
        return (String) get(TBTHB2KMEI.NAME26);
    }

    /**
     * ����27(����)��ݒ肵�܂��B
     * @param val String ����27(����)
     */
    public void setHb2Name27(String val) {
        set(TBTHB2KMEI.NAME27, val);
    }

    /**
     * ����27(����)��Ԃ��܂��B
     * @return String ����27(����)
     */
    public String getHb2Name27() {
        return (String) get(TBTHB2KMEI.NAME27);
    }

    /**
     * ����28(����)��ݒ肵�܂��B
     * @param val String ����28(����)
     */
    public void setHb2Name28(String val) {
        set(TBTHB2KMEI.NAME28, val);
    }

    /**
     * ����28(����)��Ԃ��܂��B
     * @return String ����28(����)
     */
    public String getHb2Name28() {
        return (String) get(TBTHB2KMEI.NAME28);
    }

    /**
     * ����29(����)��ݒ肵�܂��B
     * @param val String ����29(����)
     */
    public void setHb2Name29(String val) {
        set(TBTHB2KMEI.NAME29, val);
    }

    /**
     * ����29(����)��Ԃ��܂��B
     * @return String ����29(����)
     */
    public String getHb2Name29() {
        return (String) get(TBTHB2KMEI.NAME29);
    }

    /**
     * ����30(����)��ݒ肵�܂��B
     * @param val String ����30(����)
     */
    public void setHb2Name30(String val) {
        set(TBTHB2KMEI.NAME30, val);
    }

    /**
     * ����30(����)��Ԃ��܂��B
     * @return String ����30(����)
     */
    public String getHb2Name30() {
        return (String) get(TBTHB2KMEI.NAME30);
    }

    /**
     * ���z1��ݒ肵�܂��B
     * @param val BigDecimal ���z1
     */
    public void setHb2Kngk1(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * ���z1��Ԃ��܂��B
     * @return BigDecimal ���z1
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Kngk1() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

    /**
     * ���z2��ݒ肵�܂��B
     * @param val BigDecimal ���z2
     */
    public void setHb2Kngk2(BigDecimal val) {
        set(TBTHB2KMEI.KNGK2, val);
    }

    /**
     * ���z2��Ԃ��܂��B
     * @return BigDecimal ���z2
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Kngk2() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK2);
    }

    /**
     * ���z3��ݒ肵�܂��B
     * @param val BigDecimal ���z3
     */
    public void setHb2Kngk3(BigDecimal val) {
        set(TBTHB2KMEI.KNGK3, val);
    }

    /**
     * ���z3��Ԃ��܂��B
     * @return BigDecimal ���z3
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Kngk3() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK3);
    }

    /**
     * �䗦1��ݒ肵�܂��B
     * @param val BigDecimal �䗦1
     */
    public void setHb2Ritu1(BigDecimal val) {
        set(TBTHB2KMEI.RITU1, val);
    }

    /**
     * �䗦1��Ԃ��܂��B
     * @return BigDecimal �䗦1
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Ritu1() {
        return (BigDecimal) get(TBTHB2KMEI.RITU1);
    }

    /**
     * �䗦2��ݒ肵�܂��B
     * @param val BigDecimal �䗦2
     */
    public void setHb2Ritu2(BigDecimal val) {
        set(TBTHB2KMEI.RITU2, val);
    }

    /**
     * �䗦2��Ԃ��܂��B
     * @return BigDecimal �䗦2
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Ritu2() {
        return (BigDecimal) get(TBTHB2KMEI.RITU2);
    }

    /**
     * ���̑�1��ݒ肵�܂��B
     * @param val String ���̑�1
     */
    public void setHb2Sonota1(String val) {
        set(TBTHB2KMEI.SONOTA1, val);
    }

    /**
     * ���̑�1��Ԃ��܂��B
     * @return String ���̑�1
     */
    public String getHb2Sonota1() {
        return (String) get(TBTHB2KMEI.SONOTA1);
    }

    /**
     * ���̑�2��ݒ肵�܂��B
     * @param val String ���̑�2
     */
    public void setHb2Sonota2(String val) {
        set(TBTHB2KMEI.SONOTA2, val);
    }

    /**
     * ���̑�2��Ԃ��܂��B
     * @return String ���̑�2
     */
    public String getHb2Sonota2() {
        return (String) get(TBTHB2KMEI.SONOTA2);
    }

    /**
     * ���̑�3��ݒ肵�܂��B
     * @param val String ���̑�3
     */
    public void setHb2Sonota3(String val) {
        set(TBTHB2KMEI.SONOTA3, val);
    }

    /**
     * ���̑�3��Ԃ��܂��B
     * @return String ���̑�3
     */
    public String getHb2Sonota3() {
        return (String) get(TBTHB2KMEI.SONOTA3);
    }

    /**
     * ���̑�4��ݒ肵�܂��B
     * @param val String ���̑�4
     */
    public void setHb2Sonota4(String val) {
        set(TBTHB2KMEI.SONOTA4, val);
    }

    /**
     * ���̑�4��Ԃ��܂��B
     * @return String ���̑�4
     */
    public String getHb2Sonota4() {
        return (String) get(TBTHB2KMEI.SONOTA4);
    }

    /**
     * ���̑�5��ݒ肵�܂��B
     * @param val String ���̑�5
     */
    public void setHb2Sonota5(String val) {
        set(TBTHB2KMEI.SONOTA5, val);
    }

    /**
     * ���̑�5��Ԃ��܂��B
     * @return String ���̑�5
     */
    public String getHb2Sonota5() {
        return (String) get(TBTHB2KMEI.SONOTA5);
    }

    /**
     * ���̑�6��ݒ肵�܂��B
     * @param val String ���̑�6
     */
    public void setHb2Sonota6(String val) {
        set(TBTHB2KMEI.SONOTA6, val);
    }

    /**
     * ���̑�6��Ԃ��܂��B
     * @return String ���̑�6
     */
    public String getHb2Sonota6() {
        return (String) get(TBTHB2KMEI.SONOTA6);
    }

    /**
     * ���̑�7��ݒ肵�܂��B
     * @param val String ���̑�7
     */
    public void setHb2Sonota7(String val) {
        set(TBTHB2KMEI.SONOTA7, val);
    }

    /**
     * ���̑�7��Ԃ��܂��B
     * @return String ���̑�7
     */
    public String getHb2Sonota7() {
        return (String) get(TBTHB2KMEI.SONOTA7);
    }

    /**
     * ���̑�8��ݒ肵�܂��B
     * @param val String ���̑�8
     */
    public void setHb2Sonota8(String val) {
        set(TBTHB2KMEI.SONOTA8, val);
    }

    /**
     * ���̑�8��Ԃ��܂��B
     * @return String ���̑�8
     */
    public String getHb2Sonota8() {
        return (String) get(TBTHB2KMEI.SONOTA8);
    }

    /**
     * ���̑�9��ݒ肵�܂��B
     * @param val String ���̑�9
     */
    public void setHb2Sonota9(String val) {
        set(TBTHB2KMEI.SONOTA9, val);
    }

    /**
     * ���̑�9��Ԃ��܂��B
     * @return String ���̑�9
     */
    public String getHb2Sonota9() {
        return (String) get(TBTHB2KMEI.SONOTA9);
    }

    /**
     * ���̑�10��ݒ肵�܂��B
     * @param val String ���̑�10
     */
    public void setHb2Sonota10(String val) {
        set(TBTHB2KMEI.SONOTA10, val);
    }

    /**
     * ���̑�10��Ԃ��܂��B
     * @return String ���̑�10
     */
    public String getHb2Sonota10() {
        return (String) get(TBTHB2KMEI.SONOTA10);
    }

    /**
     * �����t���O��ݒ肵�܂��B
     * @param val String �����t���O
     */
    public void setHb2BunFlg(String val) {
        set(TBTHB2KMEI.BUNFLG, val);
    }

    /**
     * �����t���O��Ԃ��܂��B
     * @return String �����t���O
     */
    public String getHb2BunFlg() {
        return (String) get(TBTHB2KMEI.BUNFLG);
    }

    /**
     * �����ύX�t���O��ݒ肵�܂��B
     * @param val String �����ύX�t���O
     */
    public void setHb2MeihnFlg(String val) {
        set(TBTHB2KMEI.MEIHNFLG, val);
    }

    /**
     * �����ύX�t���O��Ԃ��܂��B
     * @return String �����ύX�t���O
     */
    public String getHb2MeihnFlg() {
        return (String) get(TBTHB2KMEI.MEIHNFLG);
    }

    /**
     * �l�����ύX�t���O��ݒ肵�܂��B
     * @param val String �l�����ύX�t���O
     */
    public void setHb2NebhnFlg(String val) {
        set(TBTHB2KMEI.NEBHNFLG, val);
    }

    /**
     * �l�����ύX�t���O��Ԃ��܂��B
     * @return String �l�����ύX�t���O
     */
    public String getHb2NebhnFlg() {
        return (String) get(TBTHB2KMEI.NEBHNFLG);
    }

}
