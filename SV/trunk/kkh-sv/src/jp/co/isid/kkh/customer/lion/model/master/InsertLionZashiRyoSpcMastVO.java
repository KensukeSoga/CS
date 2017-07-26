package jp.co.isid.kkh.customer.lion.model.master;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.model.master.MasterDataVO;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �}�X�^�f�[�^�o�^�����pVO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/03/07 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class InsertLionZashiRyoSpcMastVO extends AbstractModel {

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

    /** �}�X�^�L�[ */
    private String _masterKey = null;

    /** �t�B���^�[�o�����[ */
    private String _filterValue = null;

    /** �ėp�}�X�^�f�[�^VO���X�g */
    private List<MasterDataVO> _masterData = null;

    /** �_�~�[�v���p�e�B */
    private String _dummy = null;

    /** �X�V�����ő�l */
    private Date _maxupdate = null;

    /** ��� */
    private String _sybt = null;

    /** �G���R�[�h */
    private String _zashiCd = null;

    /**
     * ���O�C���S����ESQID���擾����
     * @return ���O�C���S����ESQID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ���O�C���S����ESQID��ݒ肷��
     * @param esqId ���O�C���S����ESQID
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * �A�v��ID���擾����
     * @return �A�v��ID
     */
    public String getAplId() {
        return _aplId;
    }

    /**
     * �A�v��ID��ݒ肷��
     * @param aplId �A�v��ID
     */
    public void setAplId(String aplId) {
        this._aplId = aplId;
    }

    /**
     * �c�Ə��i��j�R�[�h���擾����
     * @return �c�Ə��i��j�R�[�h
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肷��
     * @param egCd �c�Ə��i��j�R�[�h
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * ���Ӑ��ƃR�[�h���擾����
     * @return ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肷��
     * @param tksKgyCd ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * ���Ӑ敔��SEQNO���擾����
     * @return ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肷��
     * @param tksBmnSeqNo ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String tksBmnSeqNo) {
        this._tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO���擾����
     * @return ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肷��
     * @param tksTntSeqNo ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * �}�X�^�L�[���擾����
     * @return �}�X�^�L�[
     */
    public String getMasterKey() {
        return _masterKey;
    }

    /**
     * �}�X�^�L�[��ݒ肷��
     * @param masterKey �}�X�^�L�[
     */
    public void setMasterKey(String masterKey) {
        this._masterKey = masterKey;
    }

    /**
     * �t�B���^�[�o�����[���擾����
     * @return �t�B���^�[�o�����[
     */
    public String getFilterValue() {
        return _filterValue;
    }

    /**
     * �t�B���^�[�o�����[��ݒ肷��
     * @param filterValue �t�B���^�[�o�����[
     */
    public void setFilterValue(String filterValue) {
        this._filterValue = filterValue;
    }

    /**
     * ��ʂ��擾����
     * @return ���
     */
    public String get_sybt() {
        return _sybt;
    }

    /**
     * ��ʂ�ݒ肷��
     * @param sybt ���
     */
    public void set_sybt(String sybt) {
        _sybt = sybt;
    }

    /**
     * �G���R�[�h���擾����
     * @return �G���R�[�h
     */
    public String get_zashiCd() {
        return _zashiCd;
    }

    /**
     * �G���R�[�h��ݒ肷��
     * @param zashiCd �G���R�[�h
     */
    public void set_zashiCd(String zashiCd) {
        _zashiCd = zashiCd;
    }

    /**
     * �ėp�}�X�^�f�[�^VO���X�g���擾����
     * @return �ėp�}�X�^�f�[�^VO���X�g
     */
    public List<MasterDataVO> getMasterData() {
        return _masterData;
    }

    /**
     * �ėp�}�X�^�f�[�^VO���X�g��ݒ肷��
     * @param masterData �ėp�}�X�^�f�[�^VO���X�g
     */
    public void setMasterData(List<MasterDataVO> masterData) {
        this._masterData = masterData;
    }

    /**
     * �_�~�[�v���p�e�B���擾����
     * @return �_�~�[�v���p�e�B
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * �_�~�[�v���p�e�B��ݒ肷��
     * @param dummy �_�~�[�v���p�e�B
     */
    public void setDummy(String dummy) {
        this._dummy = dummy;
    }

    /**
     * �X�V�����ő�l���擾����
     * @return Date �X�V�����ő�l
     */
    @XmlElement(required = true)
    public Date get_maxupdate() {
        return _maxupdate;
    }

    /**
     * �X�V�����ő�l��ݒ肷��
     * @param maxupdate Date �X�V�����ő�l
     */
    public void set_maxupdate(Date maxupdate) {
        _maxupdate = maxupdate;
    }

}
