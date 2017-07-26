package jp.co.isid.kkh.customer.mac.model.report;

import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �f�[�^�X�V(������)�p���X�g
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/18)<BR>
 * </P>
 *
 * @author IP Shimizu
 */
public class UpdateReportMacReqDataVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public UpdateReportMacReqDataVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new UpdateReportMacReqDataVO();
    }

    public void SetData(String culumname, Object val){
        set(culumname, val);
    }

    /**
     * �^�C���X�^���v��ݒ肵�܂��B
     * @param val Date �^�C���X�^���v
     */
    public void setTimStmp(Date val) {
        set(TBTHB2KMEI.TIMSTMP, val);
    }

    /**
     * �^�C���X�^���v��Ԃ��܂��B
     * @return Date �^�C���X�^���v
     */
    public Date getTimStmp() {
        return (Date) get(TBTHB2KMEI.TIMSTMP);
    }

    /**
     * �X�V�v���O������ݒ肵�܂��B
     * @param val String �X�V�v���O����
     */
    public void setUpdApl(String val) {
        set(TBTHB2KMEI.UPDAPL, val);
    }

    /**
     * �X�V�v���O������Ԃ��܂��B
     * @return String �X�V�v���O����
     */
    public String getUpdApl() {
        return (String) get(TBTHB2KMEI.UPDAPL);
    }

    /**
     * �X�V�S���҂�ݒ肵�܂��B
     * @param val String �X�V�S����
     */
    public void setUpdTnt(String val) {
        set(TBTHB2KMEI.UPDTNT, val);
    }

    /**
     * �X�V�S���҂�Ԃ��܂��B
     * @return String �X�V�S����
     */
    public String getUpdTnt() {
        return (String) get(TBTHB2KMEI.UPDTNT);
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
     * @param val String �c�Ə��i��j�R�[�h
     */
    public void setEgCd(String val) {
        set(TBTHB2KMEI.EGCD, val);
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
     * @return String �c�Ə��i��j�R�[�h
     */
    public String getEgCd() {
        return (String) get(TBTHB2KMEI.EGCD);
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String val) {
        set(TBTHB2KMEI.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB2KMEI.TKSKGYCD);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB2KMEI.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB2KMEI.TKSBMNSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB2KMEI.TKSTNTSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB2KMEI.TKSTNTSEQNO);
    }

    /**
     * �N����ݒ肵�܂��B
     * @param val String �N��
     */
    public void setYymm(String val) {
        set(TBTHB2KMEI.YYMM, val);
    }

    /**
     * �N����Ԃ��܂��B
     * @return String �N��
     */
    public String getYymm() {
        return (String) get(TBTHB2KMEI.YYMM);
    }

    /**
     * ��No��ݒ肵�܂��B
     * @param val String ��No
     */
    public void setJyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * ��No��Ԃ��܂��B
     * @return String ��No
     */
    public String getJyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * �󒍖���No��ݒ肵�܂��B
     * @param val String �󒍖���No
     */
    public void setJyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * �󒍖���No��Ԃ��܂��B
     * @return String �󒍖���No
     */
    public String getJyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * ���㖾��No��ݒ肵�܂��B
     * @param val String ���㖾��No
     */
    public void setUrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * ���㖾��No��Ԃ��܂��B
     * @return String ���㖾��No
     */
    public String getUrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * �A�Ԃ�ݒ肵�܂��B
     * @param val String �A��
     */
    public void setRenbn(String val) {
        set(TBTHB2KMEI.RENBN, val);
    }

    /**
     * �A�Ԃ�Ԃ��܂��B
     * @return String �A��
     */
    public String getRenbn() {
        return (String) get(TBTHB2KMEI.RENBN);
    }

    /**
     * �c�Ɠ���ݒ肵�܂��B
     *
     * @param val String �c�Ɠ�
     */
    public void setDate1(String val) {
        set(TBTHB2KMEI.DATE2, val);
    }

    /**
     * �c�Ɠ���Ԃ��܂��B
     *
     * @return String �c�Ɠ�
     */
    public String getDate1() {
        return (String) get(TBTHB2KMEI.DATE2);
    }

}
