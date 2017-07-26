package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �f�[�^�X�VCondition(������)
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/18 IP Shimizu)<BR>
 * </P>
 * @author
 */
public class UpdateReportMacReqCondition extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** ���O�C���S����ESQID */
    private String _esqId = null;

    /** �A�v��ID */
    private String _aplId = null;

    /** �c�Ə��i��j�R�[�h */
    private String _egCd = null;

    /** ���Ӑ��ƃR�[�h */
    private String _tksKgyCd = null;

    /** ���Ӑ敔��SEQNO */
    private String _tksBmnSeqNo = null;

    /** ���Ӑ�S��SEQNO */
    private String _tksTntSeqNo = null;

    /** �`�[�ԍ� */
//    private String _denNum = null;

    /** �c�Ɠ� */
    private String _hostDate = null;

    /** �X�V�����ő�l*/
//    private Date _maxUpDate = null;

    /** �f�[�^VO���X�g */
    private List<UpdateReportMacReqVO> _reportData = null;

    /** �_�~�[�v���p�e�B */
    private String _dummy = null;


    /**
     * ���O�C���S����ESQID���擾����
     @return ���O�C���S����ESQID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ���O�C���S����ESQID��ݒ肷��
     @param esqId ���O�C���S����ESQID
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * �A�v��ID���擾����
     @return �A�v��ID
     */
    public String getAplId() {
        return _aplId;
    }

    /**
     * �A�v��ID��ݒ肷��
     @param aplId �A�v��ID
     */
    public void setAplId(String aplId) {
        this._aplId = aplId;
    }

    /**
     * �c�Ə��i��j�R�[�h���擾����
     @return �c�Ə��i��j�R�[�h
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肷��
     @param egCd �c�Ə��i��j�R�[�h
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * ���Ӑ��ƃR�[�h���擾����
     @return ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肷��
     @param tksKgyCd ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * ���Ӑ敔��SEQNO���擾����
     @return ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肷��
     @param tksBmnSeqNo ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String tksBmnSeqNo) {
        this._tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO���擾����
     @return ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肷��
     @param tksTntSeqNo ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * �ėp�}�X�^�f�[�^VO���X�g���擾����
     @return �ėp�}�X�^�f�[�^VO���X�g
     */
    public List<UpdateReportMacReqVO> getReportData() {
        return _reportData;
    }

    /**
     * �f�[�^VO���X�g��ݒ肷��
     @param reportData �f�[�^VO���X�g
     */
    public void setReportData(List<UpdateReportMacReqVO> reportData) {
        this._reportData = reportData;
    }

    /**
     * �z�X�g�c�Ɠ����擾����
     @return �z�X�g�c�Ɠ�
     */
    public String getHostDate() {
        return _hostDate;
    }

    /**
     * �z�X�g�c�Ɠ���ݒ肷��
     @param �z�X�g�c�Ɠ�
     */
    public void setHostDate(String hostDate) {
        this._hostDate = hostDate;
    }

    /**
     * �_�~�[�v���p�e�B���擾����
     @return �_�~�[�v���p�e�B
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * �_�~�[�v���p�e�B��ݒ肷��
     @param dummy �_�~�[�v���p�e�B
     */
    public void setDummy(String dummy) {
        this._dummy = dummy;
    }

}
