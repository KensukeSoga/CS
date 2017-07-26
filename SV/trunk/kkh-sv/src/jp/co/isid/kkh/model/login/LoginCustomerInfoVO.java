package jp.co.isid.kkh.model.login;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���O�C�����Ӑ���VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class LoginCustomerInfoVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public LoginCustomerInfoVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new LoginCustomerInfoVO();
    }

    /** ���Ӑ��ƃR�[�h */
    private String _tksKgyCd = null;

    /** ���Ӑ敔��SEQNO */
    private String _tksBmnSeqNo = null;

    /** ���Ӑ�S��SEQNO */
    private String _tksTntSeqNo = null;

    /** ���Ӑ�R�[�h�i�\���j */
    private String _dispTksCd = null;

    /** ���Ӑ於�i�\���j */
    private String _dispTksName = null;

    /** �S���g�D���i�\���j */
    private String _dispTntSikName = null;

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
     * ���Ӑ�R�[�h�i�\���j���擾����
     * @return ���Ӑ�R�[�h�i�\���j
     */
    public String getDispTksCd() {
        return _dispTksCd;
    }

    /**
     * ���Ӑ�R�[�h�i�\���j��ݒ肷��
     * @param dispTksCd ���Ӑ�R�[�h�i�\���j
     */
    public void setDispTksCd(String dispTksCd) {
        this._dispTksCd = dispTksCd;
    }

    /**
     * ���Ӑ於�i�\���j���擾����
     * @return ���Ӑ於�i�\���j
     */
    public String getDispTksName() {
        return _dispTksName;
    }

    /**
     * ���Ӑ於�i�\���j��ݒ肷��
     * @param dispTksName ���Ӑ於�i�\���j
     */
    public void setDispTksName(String dispTksName) {
        this._dispTksName = dispTksName;
    }

    /**
     * �S���g�D���i�\���j���擾����
     * @return �S���g�D���i�\���j
     */
    public String getDispTntSikName() {
        return _dispTntSikName;
    }

    /**
     * �S���g�D���i�\���j��ݒ肷��
     * @param dispTntSikName �S���g�D���i�\���j
     */
    public void setDispTntSikName(String dispTntSikName) {
        this._dispTntSikName = dispTntSikName;
    }

}
