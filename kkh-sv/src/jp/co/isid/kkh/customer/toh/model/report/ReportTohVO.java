package jp.co.isid.kkh.customer.toh.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���[�iTOH)VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/04 JSE KT)<BR>
 * </P>
 * @author
 */
public class ReportTohVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportTohVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportTohVO();
    }

     /**
      * ��NO��ݒ肵�܂��B
      * @param val String ��NO
      */
     public void setJyutNo(String val) {
         set(TBTHB2KMEI.JYUTNO, val);
     }

     /**
      * ��NO��Ԃ��܂��B
      * @return String ��NO
      */
     public String getJyutNo() {
         return (String) get(TBTHB2KMEI.JYUTNO);
     }

    /**
     * �󒍖���NO��ݒ肵�܂��B
     * @param val String �󒍖���NO
     */
    public void setJyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * �󒍖���NO��Ԃ��܂��B
     * @return String �󒍖���NO
     */
    public String getJyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * ���㖾��NO��ݒ肵�܂��B
     * @param val String ���㖾��NO
     */
    public void setUrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * ���㖾��NO��Ԃ��܂��B
     * @return String ���㖾��NO
     */
    public String getUrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * �f�ړ���ݒ肵�܂��B
     * @param val String �f�ړ�
     */
    public void setDate1(String val) {
        set(TBTHB2KMEI.DATE1, val);
    }

    /**
     * �f�ړ���Ԃ��܂��B
     * @return String �f�ړ�
     */
    public String getDate1() {
        return (String) get(TBTHB2KMEI.DATE1);
    }

    /**
     * CODE1��ݒ肵�܂��B
     * @param val String CODE1
     */
    public void setCode1(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * CODE1��Ԃ��܂��B
     * @return String CODE1
     */
    public String getCode1() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * ������ݒ肵�܂��B
     * @param val String ����
     */
    public void setName8(String val) {
        set(TBTHB2KMEI.NAME8, val);
    }

    /**
     * ������Ԃ��܂��B
     * @return String ����
     */
    public String getName8() {
        return (String) get(TBTHB2KMEI.NAME8);
    }

    /**
     * �}�̖���ݒ肵�܂��B
     * @param val String �}�̖�
     */
    public void setName2(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * �}�̖���Ԃ��܂��B
     * @return String �}�̖�
     */
    public String getName2() {
        return (String) get(TBTHB2KMEI.NAME2);
    }

    /**
     * ������ݒ肵�܂��B
     * @param val String ����
     */
    public void setSeiGak(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * ������Ԃ��܂��B
     * @return String ����
     */
    public BigDecimal getSeiGak() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    // ����őΉ� 2013/10/09 add HLC H.Watabe start
    /**
     * ����ŗ���ݒ肵�܂��B
     * @param val String ����ŗ�
     */
    public void setRitu1(BigDecimal val) {
        set(TBTHB2KMEI.RITU1, val);
    }

    /**
     * ����ŗ���Ԃ��܂��B
     * @return String ����ŗ�
     */
    public BigDecimal getRitu1() {
        return (BigDecimal) get(TBTHB2KMEI.RITU1);
    }
    // ����őΉ� 2013/10/09 add HLC H.Watabe end

    /**
     * �敪1��ݒ肵�܂��B
     * @param val String �敪1
     */
    public void setKbn1(String val) {
        set(TBTHB2KMEI.KBN1, val);
    }

    /**
     * �敪1��Ԃ��܂��B
     * @return String �敪1
     */
    public String getKbn1() {
        return (String) get(TBTHB2KMEI.KBN1);
    }

    /**
     * �敪2��ݒ肵�܂��B
     * @param val String �敪2
     */
    public void setKbn2(String val) {
        set(TBTHB2KMEI.KBN2, val);
    }

    /**
     * �敪2��Ԃ��܂��B
     * @return String �敪2
     */
    public String getKbn2() {
        return (String) get(TBTHB2KMEI.KBN2);
    }

    /**
     * ���z1��ݒ肵�܂��B
     * @param val BigDecimal ���z1
     */
    public void setKngk1(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * ���z1��Ԃ��܂��B
     * @return BigDecimal ���z1
     */
    public BigDecimal getKngk1() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

//    /**
//     * �o�^�^�C���X�^���v��ݒ肵�܂��B
//     * @param val String �o�^�^�C���X�^���v
//     */
//    public void setTrkTimStmp(Date val) {
//        set(TBTHB6LOG.TRKTIMSTMP, val);
//    }
//
//    /**
//     * �o�^�^�C���X�^���v��Ԃ��܂��B
//     * @return String �o�^�^�C���X�^���v
//     */
//    public Date getTrkTimStmp() {
//        return (Date) get(TBTHB6LOG.TRKTIMSTMP);
//    }
//
//    /**
//     * �o�^�v���O������ݒ肵�܂��B
//     * @param val String �o�^�v���O����
//     */
//    public void setTrkPl(String val) {
//        set(TBTHB6LOG.TRKPL, val);
//    }
//
//    /**
//     * �o�^�v���O������Ԃ��܂��B
//     * @return String �o�^�v���O����
//     */
//    public String getTrkPl() {
//        return (String) get(TBTHB6LOG.TRKPL);
//    }
//
//    /**
//     * �o�^�S���҂�ݒ肵�܂��B
//     * @param val String �o�^�S����
//     */
//    public void setTrkTnt(String val) {
//        set(TBTHB6LOG.TRKTNT, val);
//    }
//
//    /**
//     * �o�^�S���҂�Ԃ��܂��B
//     * @return String �o�^�S����
//     */
//    public String getTrkTnt() {
//        return (String) get(TBTHB6LOG.TRKTNT);
//    }
//
//    /**
//     * �X�V�^�C���X�^���v��ݒ肵�܂��B
//     * @param val String �X�V�^�C���X�^���v
//     */
//    public void setUpdTimStmp(Date val) {
//        set(TBTHB6LOG.UPDTIMSTMP, val);
//    }
//
//    /**
//     * �X�V�^�C���X�^���v��Ԃ��܂��B
//     * @return String �X�V�^�C���X�^���v
//     */
//    public Date getUpdTimStmp() {
//        return (Date) get(TBTHB6LOG.UPDTIMSTMP);
//    }
//
//    /**
//     * �X�V�v���O������ݒ肵�܂��B
//     * @param val String �X�V�v���O����
//     */
//    public void setUpdPl(String val) {
//        set(TBTHB6LOG.UPDAPL, val);
//    }
//
//    /**
//     * �X�V�v���O������Ԃ��܂��B
//     * @return String �X�V�v���O����
//     */
//    public String getUpdPl() {
//        return (String) get(TBTHB6LOG.UPDAPL);
//    }
//
//    /**
//     * �X�V�S���҂�ݒ肵�܂��B
//     * @param val String �X�V�S����
//     */
//    public void setUpdTnt(String val) {
//        set(TBTHB6LOG.UPDTNT, val);
//    }
//
//    /**
//     * �X�V�S���҂�Ԃ��܂��B
//     * @return String �X�V�S����
//     */
//    public String getUpdTnt() {
//        return (String) get(TBTHB6LOG.UPDTNT);
//    }
//
//    /**
//     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
//     * @param val String �c�Ə��i��j�R�[�h
//     */
//    public void setEgCd(String val) {
//        set(TBTHB6LOG.EGCD, val);
//    }
//
//    /**
//     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
//     * @return String �c�Ə��i��j�R�[�h
//     */
//    public String getEgCd() {
//        return (String) get(TBTHB6LOG.EGCD);
//    }
//
//    /**
//     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
//     * @param val String ���Ӑ��ƃR�[�h
//     */
//    public void setTksKgyCd(String val) {
//        set(TBTHB6LOG.TKSKGYCD, val);
//    }
//
//    /**
//     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
//     * @return String ���Ӑ��ƃR�[�h
//     */
//    public String getTksKgyCd() {
//        return (String) get(TBTHB6LOG.TKSKGYCD);
//    }
//
//    /**
//     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
//     * @param val String ���Ӑ敔��SEQNO
//     */
//    public void setTksBmnSeqNo(String val) {
//        set(TBTHB6LOG.TKSBMNSEQNO, val);
//    }
//
//    /**
//     * ���Ӑ敔��SEQNO��Ԃ��܂��B
//     * @return String ���Ӑ敔��SEQNO
//     */
//    public String getTksBmnSeqNo() {
//        return (String) get(TBTHB6LOG.TKSBMNSEQNO);
//    }
//
//    /**
//     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
//     * @param val String ���Ӑ�S��SEQNO
//     */
//    public void setTksTntSeqNo(String val) {
//        set(TBTHB6LOG.TKSTNTSEQNO, val);
//    }
//
//    /**
//     * ���Ӑ�S��SEQNO��Ԃ��܂��B
//     * @return String ���Ӑ�S��SEQNO
//     */
//    public String getTksTntSeqNo() {
//        return (String) get(TBTHB6LOG.TKSTNTSEQNO);
//    }
//
//    /**
//     * ��ʂ�ݒ肵�܂��B
//     * @param val String ���
//     */
//    public void setSybt(String val) {
//        set(TBTHB6LOG.SYBT, val);
//    }
//
//    /**
//     * ��ʂ�Ԃ��܂��B
//     * @return String ���
//     */
//    public String getSybt() {
//        return (String) get(TBTHB6LOG.SYBT);
//    }
//
//    /**
//     * �敪��ݒ肵�܂��B
//     * @param val String �敪
//     */
//    public void setKbn(String val) {
//        set(TBTHB6LOG.KBN, val);
//    }
//
//    /**
//     * �敪��Ԃ��܂��B
//     * @return String �敪
//     */
//    public String getKbn() {
//        return (String) get(TBTHB6LOG.KBN);
//    }
//
//    /**
//     * ���e��ݒ肵�܂��B
//     * @param val String ���e
//     */
//    public void setDesc(String val) {
//        set(TBTHB6LOG.DESC, val);
//    }
//
//    /**
//     * ���e��Ԃ��܂��B
//     * @return String ���e
//     */
//    public String getDesc() {
//        return (String) get(TBTHB6LOG.DESC);
//    }
//
//    /**
//     * �X�V������ݒ肵�܂��B
//     * @param val String �X�V����
//     */
//    public void setUpdDate(String val) {
//        set(TBTHB6LOG.UPDDATE, val);
//    }
//
//    /**
//     * �X�V������Ԃ��܂��B
//     * @return String �X�V����
//     */
//    public String getUpdDate() {
//        return (String) get(TBTHB6LOG.UPDDATE);
//    }
//
//    /**
//     * ����M��ނ�ݒ肵�܂��B
//     * @param val String ����M���
//     */
//    public void setReceptionKind(String val) {
//        set(TBTHB6LOG.RECEPTIONKIND, val);
//    }
//
//    /**
//     * ����M��ނ�Ԃ��܂��B
//     * @return String ����M���
//     */
//    public String getReceptionKind() {
//        return (String) get(TBTHB6LOG.RECEPTIONKIND);
//    }
//
//    /**
//     * �X�e�[�^�X��ݒ肵�܂��B
//     * @param val String �X�e�[�^�X
//     */
//    public void setStatus(String val) {
//        set(TBTHB6LOG.STATUS, val);
//    }
//
//    /**
//     * �X�e�[�^�X��Ԃ��܂��B
//     * @return String �X�e�[�^�X
//     */
//    public String getStatus() {
//        return (String) get(TBTHB6LOG.STATUS);
//    }

//    /**
//     * �V�K�C���X�^���X���\�z���܂��B
//     */
//    public ReportTohVO() {
//    }
//
//    /**
//     * �V�K�C���X�^���X���\�z���܂��B
//     *
//     * @return �V�K�C���X�^���X
//     */
//    public Object newInstance() {
//        return new ReportTohVO();
//    }
//
//    /**
//     * ��NO��ݒ肵�܂��B
//     * @param val String ��NO
//     */
//    public void setHb2JyutNo(String val) {
//        set(TBTHB2KMEI.JYUTNO, val);
//    }
//
//    /**
//     * ��NO��Ԃ��܂��B
//     * @return String ��NO
//     */
//    public String getHb2JyutNo() {
//        return (String) get(TBTHB2KMEI.JYUTNO);
//    }
//
//    /**
//     * �󒍖���NO��ݒ肵�܂��B
//     * @param val String �󒍖���NO
//     */
//    public void setHb2JyMeiNo(String val) {
//        set(TBTHB2KMEI.JYMEINO, val);
//    }
//
//    /**
//     * �󒍖���NO��Ԃ��܂��B
//     * @return String �󒍖���NO
//     */
//    public String getHb2JyMeiNo() {
//        return (String) get(TBTHB2KMEI.JYMEINO);
//    }
//
//    /**
//     * ���㖾��NO��ݒ肵�܂��B
//     * @param val String ���㖾��NO
//     */
//    public void setHb2UrMeiNo(String val) {
//        set(TBTHB2KMEI.URMEINO, val);
//    }
//
//    /**
//     * ���㖾��NO��Ԃ��܂��B
//     * @return String ���㖾��NO
//     */
//    public String getHb2UrMeiNo() {
//        return (String) get(TBTHB2KMEI.URMEINO);
//    }
//
//    /**
//     * �f�ړ���ݒ肵�܂��B
//     * @param val String �f�ړ�
//     */
//    public void setHb2Date1(String val) {
//        set(TBTHB2KMEI.DATE1, val);
//    }
//
//    /**
//     * �f�ړ���Ԃ��܂��B
//     * @return String �f�ړ�
//     */
//    public String getHb2Date1() {
//        return (String) get(TBTHB2KMEI.DATE1);
//    }
//
//    /**
//     * CODE1��ݒ肵�܂��B
//     * @param val String CODE1
//     */
//    public void setHb2Code1(String val) {
//        set(TBTHB2KMEI.CODE1, val);
//    }
//
//    /**
//     * CODE1��Ԃ��܂��B
//     * @return String CODE1
//     */
//    public String getHb2Code1() {
//        return (String) get(TBTHB2KMEI.CODE1);
//    }
//
//    /**
//     * ������ݒ肵�܂��B
//     * @param val String ����
//     */
//    public void setHb2Name8(String val) {
//        set(TBTHB2KMEI.NAME8, val);
//    }
//
//    /**
//     * ������Ԃ��܂��B
//     * @return String ����
//     */
//    public String getHb2Name8() {
//        return (String) get(TBTHB2KMEI.NAME8);
//    }
//
//    /**
//     * �}�̖���ݒ肵�܂��B
//     * @param val String �}�̖�
//     */
//    public void setHb2Name2(String val) {
//        set(TBTHB2KMEI.NAME2, val);
//    }
//
//    /**
//     * �}�̖���Ԃ��܂��B
//     * @return String �}�̖�
//     */
//    public String getHb2Name2() {
//        return (String) get(TBTHB2KMEI.NAME2);
//    }
//
//    /**
//     * ������ݒ肵�܂��B
//     * @param val String ����
//     */
//    public void setHb2SeiGak(BigDecimal val) {
//        set(TBTHB2KMEI.SEIGAK, val);
//    }
//
//    /**
//     * ������Ԃ��܂��B
//     * @return String ����
//     */
//    public BigDecimal getHb2SeiGak() {
//        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
//    }
//
//    /**
//     * �敪1��ݒ肵�܂��B
//     * @param val String �敪1
//     */
//    public void setHb2Kbn1(String val) {
//        set(TBTHB2KMEI.KBN1, val);
//    }
//
//    /**
//     * �敪1��Ԃ��܂��B
//     * @return String �敪1
//     */
//    public String getHb2Kbn1() {
//        return (String) get(TBTHB2KMEI.KBN1);
//    }
//
//    /**
//     * �敪2��ݒ肵�܂��B
//     * @param val String �敪2
//     */
//    public void setHb2Kbn2(String val) {
//        set(TBTHB2KMEI.KBN2, val);
//    }
//
//    /**
//     * �敪2��Ԃ��܂��B
//     * @return String �敪2
//     */
//    public String getHb2Kbn2() {
//        return (String) get(TBTHB2KMEI.KBN2);
//    }
//
//    /**
//     * ���z1��ݒ肵�܂��B
//     * @param val BigDecimal ���z1
//     */
//    public void setHb2Kngk1(BigDecimal val) {
//        set(TBTHB2KMEI.KNGK1, val);
//    }
//
//    /**
//     * ���z1��Ԃ��܂��B
//     * @return BigDecimal ���z1
//     */
//    @XmlElement(required = true)
//    public BigDecimal getHb2Kngk1() {
//        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
//    }

}