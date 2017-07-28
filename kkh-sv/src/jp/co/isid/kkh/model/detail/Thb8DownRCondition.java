package jp.co.isid.kkh.model.detail;

import java.io.Serializable;

public class Thb8DownRCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ���O�C���S����ESQID */
    private String _esqId = null;

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

    /** ��No */
    private String _jyutNo = null;

    /** �󒍖���No */
    private String _jyMeiNo = null;

    /** ���㖾��No */
    private String _urMeiNo = null;

    /** �����t���O */
    private String _touFlg = null;

    /** �t�@�C���^�C���X�^���v */
    private String _fileTimStmp = null;

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
     * �N�����擾����
     * @return �N��
     */
    public String getYymm() {
        return _yymm;
    }

    /**
     * �N����ݒ肷��
     * @param yymm �N��
     */
    public void setYymm(String yymm) {
        this._yymm = yymm;
    }

    /**
     * ��No���擾����
     * @return ��No
     */
    public String getJyutNo() {
        return _jyutNo;
    }

    /**
     * ��No��ݒ肷��
     * @param jyutNo ��No
     */
    public void setJyutNo(String jyutNo) {
        this._jyutNo = jyutNo;
    }

    /**
     * �󒍖���No���擾����
     * @return �󒍖���No
     */
    public String getJyMeiNo() {
        return _jyMeiNo;
    }

    /**
     * �󒍖���No��ݒ肷��
     * @param jyMeiNo �󒍖���No
     */
    public void setJyMeiNo(String jyMeiNo) {
        this._jyMeiNo = jyMeiNo;
    }

    /**
     * ���㖾��No���擾����
     * @return ���㖾��No
     */
    public String getUrMeiNo() {
        return _urMeiNo;
    }

    /**
     * ���㖾��No��ݒ肷��
     * @param urMeiNo ���㖾��No
     */
    public void setUrMeiNo(String urMeiNo) {
        this._urMeiNo = urMeiNo;
    }

    /**
     * �����t���O���擾����
     * @return �����t���O
     */
    public String getTouFlg() {
        return _touFlg;
    }

    /**
     * �����t���O��ݒ肷��
     * @param urMeiNo �����t���O
     */
    public void setTouFlg(String touFlg) {
        this._touFlg = touFlg;
    }

    /**
     * �t�@�C���^�C���X�^���v���擾����
     * @return �t�@�C���^�C���X�^���v
     */
    public String getFileTimStmp() {
        return _fileTimStmp;
    }

    /**
     * �t�@�C���^�C���X�^���v��ݒ肷��
     * @param fileTimStmp �t�@�C���^�C���X�^���v
     */
    public void setFileTimStmp(String fileTimStmp) {
        this._fileTimStmp = fileTimStmp;
    }

}
