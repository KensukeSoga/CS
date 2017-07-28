package jp.co.isid.kkh.customer.acom.model.claim;

import jp.co.isid.kkh.model.detail.Thb2KmeiVO;

/**
 * <P>
 * ���M�t���O�X�V���VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/20 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class UpdateOutFlgVO extends Thb2KmeiVO {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public UpdateOutFlgVO() {
        super();
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new UpdateOutFlgVO();
    }

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
    /** ��No */
    private String[] _jyutNo = null;
    /** �󒍖���No */
    private String[] _jyMeiNo = null;
    /** ���㖾��No */
    private String[] _urMeiNo = null;
    /** �A�� */
    private String[] _renban = null;
    /** ���M�t���O */
    private String _outFlg = null;
    /** �o�͓��� */
    private String _outDate = null;
    /** ������No */
    private String[] _seiNo = null;
    /** �������sNo */
    private String[] _seiGyoNo = null;
    /** �����N���� */
    private String[] _seiYymm = null;
    /** �_�~�[�v���p�e�B */
    private String _dummy = null;

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
     * ��No���擾����
     * @return ��No
     */
    public String[] getJyutNo() {
        return _jyutNo;
    }

    /**
     * ��No��ݒ肷��
     * @param jyutNo ��No
     */
    public void setJyutNo(String[] jyutNo) {
        _jyutNo = jyutNo;
    }

    /**
     * �󒍖���No���擾����
     * @return _jyMeiNo �󒍖���No
     */
    public String[] getJyMeiNo() {
        return _jyMeiNo;
    }

    /**
     * �󒍖���No��ݒ肷��
     * @param jyMeiNo �󒍖���No
     */
    public void setJyMeiNo(String[] jyMeiNo) {
        _jyMeiNo = jyMeiNo;
    }

    /**
     * ���㖾��No���擾����
     * @return _urMeiNo
     */
    public String[] getUrMeiNo() {
        return _urMeiNo;
    }

    /**
     * ���㖾��No��ݒ肷��
     * @param urMeiNo ���㖾��No
     */
    public void setUrMeiNo(String[] urMeiNo) {
        _urMeiNo = urMeiNo;
    }

    /**
     * �o�͓������擾����
     * @return _outFlg �o�͓���
     */
    public String getOutDate() {
        return _outDate;
    }

    /**
     * �o�͓�����ݒ肷��
     * @param outFlg �o�͓���
     */
    public void setOutDate(String outDate) {
        _outDate = outDate;
    }

    /**
     * ���M�t���O���擾����
     * @return _outFlg ���M�t���O
     */
    public String getOutFlg() {
        return _outFlg;
    }

    /**
     * ���M�t���O��ݒ肷��
     * @param outFlg ���M�t���O
     */
    public void setOutFlg(String outFlg) {
        _outFlg = outFlg;
    }

    /**
     * �A�Ԃ��擾����
     * @return _renban �A��
     */
    public String[] getRenban() {
        return _renban;
    }

    /**
     * �A�Ԃ�ݒ肷��
     * @param renban �A��
     */
    public void setRenban(String[] renban) {
        _renban = renban;
    }

    /**
     * ������No���擾����
     * @return _seiNo ������No
     */
    public String[] getSeiNo() {
        return _seiNo;
    }

    /**
     * ������No��ݒ肷��
     * @param seiNo ������No
     */
    public void setSeiNo(String[] seiNo) {
        _seiNo = seiNo;
    }

    /**
     * �������sNo���擾����
     * @return _seiGyoNo �������sNo
     */
    public String[] getSeiGyoNo() {
        return _seiGyoNo;
    }

    /**
     * �������sNo��ݒ肷��
     * @param seiGyoNo �������sNo
     */
    public void setSeiGyoNo(String[] seiGyoNo) {
        _seiGyoNo = seiGyoNo;
    }

    /**
     * �����N�������擾����
     * @return _seiYymm �����N����
     */
    public String[] getSeiYymm() {
        return _seiYymm;
    }

    /**
     * �����N������ݒ肷��
     * @param seiYymm �����N����
     */
    public void setSeiYymm(String[] seiYymm) {
        _seiYymm = seiYymm;
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
}
