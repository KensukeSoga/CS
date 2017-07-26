package jp.co.isid.kkh.model.log;

import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB6LOG;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �ėp���O�f�[�^VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/11 IP H.SHimizu)<BR>
 * </P>
 * @author
 */
public class LogVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public LogVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new LogVO();
    }

    /**
     * �o�^�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �o�^�^�C���X�^���v
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHB6LOG.TRKTIMSTMP, val);
    }

    /**
     * �o�^�^�C���X�^���v��Ԃ��܂��B
     * @return String �o�^�^�C���X�^���v
     */
    public Date getTrkTimStmp() {
        return (Date) get(TBTHB6LOG.TRKTIMSTMP);
    }

    /**
     * �o�^�v���O������ݒ肵�܂��B
     * @param val String �o�^�v���O����
     */
    public void setTrkPl(String val) {
        set(TBTHB6LOG.TRKPL, val);
    }

    /**
     * �o�^�v���O������Ԃ��܂��B
     * @return String �o�^�v���O����
     */
    public String getTrkPl() {
        return (String) get(TBTHB6LOG.TRKPL);
    }

    /**
     * �o�^�S���҂�ݒ肵�܂��B
     * @param val String �o�^�S����
     */
    public void setTrkTnt(String val) {
        set(TBTHB6LOG.TRKTNT, val);
    }

    /**
     * �o�^�S���҂�Ԃ��܂��B
     * @return String �o�^�S����
     */
    public String getTrkTnt() {
        return (String) get(TBTHB6LOG.TRKTNT);
    }

    /**
     * �X�V�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �X�V�^�C���X�^���v
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHB6LOG.UPDTIMSTMP, val);
    }

    /**
     * �X�V�^�C���X�^���v��Ԃ��܂��B
     * @return String �X�V�^�C���X�^���v
     */
    public Date getUpdTimStmp() {
        return (Date) get(TBTHB6LOG.UPDTIMSTMP);
    }

    /**
     * �X�V�v���O������ݒ肵�܂��B
     * @param val String �X�V�v���O����
     */
    public void setUpdPl(String val) {
        set(TBTHB6LOG.UPDAPL, val);
    }

    /**
     * �X�V�v���O������Ԃ��܂��B
     * @return String �X�V�v���O����
     */
    public String getUpdPl() {
        return (String) get(TBTHB6LOG.UPDAPL);
    }

    /**
     * �X�V�S���҂�ݒ肵�܂��B
     * @param val String �X�V�S����
     */
    public void setUpdTnt(String val) {
        set(TBTHB6LOG.UPDTNT, val);
    }

    /**
     * �X�V�S���҂�Ԃ��܂��B
     * @return String �X�V�S����
     */
    public String getUpdTnt() {
        return (String) get(TBTHB6LOG.UPDTNT);
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
     * @param val String �c�Ə��i��j�R�[�h
     */
    public void setEgCd(String val) {
        set(TBTHB6LOG.EGCD, val);
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
     * @return String �c�Ə��i��j�R�[�h
     */
    public String getEgCd() {
        return (String) get(TBTHB6LOG.EGCD);
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String val) {
        set(TBTHB6LOG.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB6LOG.TKSKGYCD);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB6LOG.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB6LOG.TKSBMNSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB6LOG.TKSTNTSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB6LOG.TKSTNTSEQNO);
    }

    /**
     * ��ʂ�ݒ肵�܂��B
     * @param val String ���
     */
    public void setSybt(String val) {
        set(TBTHB6LOG.SYBT, val);
    }

    /**
     * �@�\ID��Ԃ��܂��B
     * @return String ���
     */
    public String getSybt() {
        return (String) get(TBTHB6LOG.SYBT);
    }

    /**
     * �@�\ID��ݒ肵�܂��B
     * @param val String �@�\ID
     */
    public void setKinoId(String val) {
        set(TBTHB6LOG.KINOID, val);
    }

    /**
     * �@�\ID��Ԃ��܂��B
     * @return String �@�\ID
     */
    public String getKinoId() {
        return (String) get(TBTHB6LOG.KINOID);
    }

    /**
     * �敪��ݒ肵�܂��B
     * @param val String �敪
     */
    public void setKbn(String val) {
        set(TBTHB6LOG.KBN, val);
    }

    /**
     * �敪��Ԃ��܂��B
     * @return String �敪
     */
    public String getKbn() {
        return (String) get(TBTHB6LOG.KBN);
    }

    /**
     * ���e��ݒ肵�܂��B
     * @param val String ���e
     */
    public void setDesc(String val) {
        set(TBTHB6LOG.DESC, val);
    }

    /**
     * ���e��Ԃ��܂��B
     * @return String ���e
     */
    public String getDesc() {
        return (String) get(TBTHB6LOG.DESC);
    }

    /**
     * �G���[���e��ݒ肵�܂��B
     * @param val String �G���[���e
     */
    public void setErrDesc(String val) {
        set(TBTHB6LOG.ERRDESC, val);
    }

    /**
     * �G���[���e��Ԃ��܂��B
     * @return String �G���[���e
     */
    public String getErrDesc() {
        return (String) get(TBTHB6LOG.ERRDESC);
    }

    /**
     * �X�V������ݒ肵�܂��B
     * @param val String �X�V����
     */
    public void setUpdDate(String val) {
        set(TBTHB6LOG.UPDDATE, val);
    }

    /**
     * �X�V������Ԃ��܂��B
     * @return String �X�V����
     */
    public String getUpdDate() {
        return (String) get(TBTHB6LOG.UPDDATE);
    }

    /**
     * �S���Җ���ݒ肵�܂��B
     * @param val String �S���Җ�
     */
    public void setTanName(String val) {
        set(TBTHB6LOG.TANNAME, val);
    }

    /**
     * �S���Җ���Ԃ��܂��B
     * @return String �S���Җ�
     */
    public String getTanName() {
        return (String) get(TBTHB6LOG.TANNAME);
    }

    /**
     * ����M��ނ�ݒ肵�܂��B
     * @param val String ����M���
     */
    public void setReceptionKind(String val) {
        set(TBTHB6LOG.RECEPTIONKIND, val);
    }

    /**
     * ����M��ނ�Ԃ��܂��B
     * @return String ����M���
     */
    public String getReceptionKind() {
        return (String) get(TBTHB6LOG.RECEPTIONKIND);
    }

    /**
     * �X�e�[�^�X��ݒ肵�܂��B
     * @param val String �X�e�[�^�X
     */
    public void setStatus(String val) {
        set(TBTHB6LOG.STATUS, val);
    }

    /**
     * �X�e�[�^�X��Ԃ��܂��B
     * @return String �X�e�[�^�X
     */
    public String getStatus() {
        return (String) get(TBTHB6LOG.STATUS);
    }

}
