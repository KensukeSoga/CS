package jp.co.isid.kkh.customer.skyp.model.detail;


import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;

/**
 * <P>
 * ���я��X�V���VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/22 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class UpdateOrderVO extends Thb2KmeiVO {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public UpdateOrderVO() {
        super();
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new UpdateOrderVO();
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
    /** �N�� */
    private String _yymm = null;
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
     * �N����Ԃ��܂��B
     *
     * @return yymm
     */
    public String getYymm() {
        return _yymm;
    }

    /**
     * �N����ݒ肵�܂��B
     *
     * @param yymm
     */
    public void setYymm(String yymm) {
        this._yymm = yymm;
    }

    /**
     * ���я���ݒ肵�܂��B
     *
     * @param val
     *            String[] ���я�
     */
    public void setOrder(String[] val) {
        set(TBTHB2KMEI.SONOTA1, val);
    }

    /**
     * ���я���Ԃ��܂��B
     *
     * @return String[] ���я�
     */
    public String[] getOrder() {
        return (String[]) get(TBTHB2KMEI.SONOTA1);
    }

    /**
     * �}�̖��̂�ݒ肵�܂��B
     *
     * @param val
     *            String[] �}�̖���
     */
    public void setBaitaiNm(String[] val) {
        set(TBTHB2KMEI.NAME7, val);
    }

    /**
     * �}�̖��̂�Ԃ��܂��B
     *
     * @return String[] �}�̖���
     */
    public String[] getBaitaiNm() {
        return (String[]) get(TBTHB2KMEI.NAME7);
    }

    /**
     * �}�̋敪��ݒ肵�܂��B
     *
     * @param val
     *            String[] �}�̋敪
     */
    public void setBaitaiKbn(String[] val) {
        set(TBTHB2KMEI.NAME13, val);
    }

    /**
     * �}�̋敪��Ԃ��܂��B
     *
     * @return String[] �}�̋敪
     */
    public String[] getBaitaiKbn() {
        return (String[]) get(TBTHB2KMEI.NAME13);
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
