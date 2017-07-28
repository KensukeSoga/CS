package jp.co.isid.kkh.customer.tkd.model.detail;

import java.io.Serializable;

public class AutoJissiBycondVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** esqId */
    private String _esqId = null;

    /** aplId */
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
    private String _YYMM = null;

    /** ��No */
    private String[] _jyutNo;

    /** �󒍖���No */
    private String[] _jyMeiNo;

    /** ���㖾��No */
    private String[] _urMeiNo;

    /** �ϓ��l */
    private String fuyoOrUpdown;

    /** �z���� */
    private String[] _haibun;

    /** �}�̃R�[�h */
    private String[] _baitaiCd;

    /** ���{No */
    private String[] _jissiNo;

    /** �_�~�[�v���p�e�B */
    private String _dummy = null;

    /** �A�� */
    private String[] _Renban = null;

    private int num = 0;
    private int num2 = 0;

    /**
     * esqId��Ԃ��܂�
     * @return yymm
     */
    public String get_esqId() {
        return _esqId;
    }

    /**
     * esqId��ݒ肷��
     * @param esqId
     */
    public void set_esqId(String esqId) {
        _esqId = esqId;
    }

    /**
     * aplId��Ԃ��܂�
     * @return yymm
     */
    public String get_aplId() {
        return _aplId;
    }

    /**
     * aplId��ݒ肷��
     * @param esqId
     */
    public void set_aplId(String aplId) {
        _aplId = aplId;
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂�
     * @return yymm
     */
    public String get_egCd() {
        return _egCd;
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肷��
     * @param esqId
     */
    public void set_egCd(String egCd) {
        _egCd = egCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂�
     * @return yymm
     */
    public String get_tksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肷��
     * @param esqId
     */
    public void set_tksKgyCd(String tksKgyCd) {
        _tksKgyCd = tksKgyCd;
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂�
     * @return yymm
     */
    public String get_tksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肷��
     * @param esqId
     */
    public void set_tksBmnSeqNo(String tksBmnSeqNo) {
        _tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂�
     * @return yymm
     */
    public String get_tksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肷��
     * @param esqId
     */
    public void set_tksTntSeqNo(String tksTntSeqNo) {
        _tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * �N����Ԃ��܂�
     * @return yymm
     */
    public String get_YYMM() {
        return _YYMM;
    }

    /**
     * �N����ݒ肷��
     * @param esqId
     */
    public void set_YYMM(String yymm) {
        _YYMM = yymm;
    }

    /**
     * ��No��Ԃ��܂�
     * @return yymm
     */
    public String[] get_jyutNo() {
        return _jyutNo;
    }

    /**
     * ��No��ݒ肷��
     * @param _jyutNo
     */
    public void set_jyutNo(String[] jyutNo) {
        _jyutNo = jyutNo;
    }

    /**
     * �󒍖���No��Ԃ��܂�
     * @return _jyMeiNo
     */
    public String[] get_jyMeiNo() {
        return _jyMeiNo;
    }

    /**
     * �󒍖���No��ݒ肷��
     * @param _jyMeiNo
     */
    public void set_jyMeiNo(String[] jyMeiNo) {
        _jyMeiNo = jyMeiNo;
    }

    /**
     * ���㖾��No��Ԃ��܂�
     * @return _urMeiNo
     */
    public String[] get_urMeiNo() {
        return _urMeiNo;
    }

    /**
     * ���㖾��No��ݒ肷��
     * @param _urMeiNo
     */
    public void set_urMeiNo(String[] urMeiNo) {
        _urMeiNo = urMeiNo;
    }

    /**
     * �ϓ��l��Ԃ��܂�
     * @return fuyoOrUpdown
     */
    public String getFuyoOrUpdown() {
        return fuyoOrUpdown;
    }

    /** �ϓ��l��ݒ肷��
     * @param fuyoOrUpdown
     */
    public void setFuyoOrUpdown(String fuyoOrUpdown) {
        this.fuyoOrUpdown = fuyoOrUpdown;
    }

    /**
     * �_�~�[�v���p�e�B��Ԃ��܂�
     * @return yymm
     */
    public String get_dummy() {
        return _dummy;
    }

    /**
     * �_�~�[�v���p�e�B��ݒ肷��
     * @param esqId
     */
    public void set_dummy(String dummy) {
        _dummy = dummy;
    }

    /**
     * �l��Ԃ��܂�
     * @return num
     */
    public int getNum() {
        return num;
    }

    /**
     * �l��ݒ肷��
     * @param num
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * �z������Ԃ��܂�
     * @return haibun
     */
    public String[] get_haibun() {
        return _haibun;
    }

    /**
     * �z������ݒ肷��
     * @param haibun
     */
    public void set_haibun(String[] haibun) {
        _haibun = haibun;
    }

    /**
     * �}�̃R�[�h��Ԃ��܂�
     * @return baitaiCd
     */
    public String[] get_BaitaiCd() {
        return _baitaiCd;
    }

    /**
     * �}�̃R�[�h��ݒ肷��
     * @param baitaiCd
     */
    public void set_BaitaiCd(String[] baitaiCd) {
        _baitaiCd = baitaiCd;
    }

    /**
     * ���{No��Ԃ��܂�
     * @return jissiNo
     */
    public String[] get_JissiNo() {
        return _jissiNo;
    }

    /**
     * ���{No��ݒ肷��
     * @param baitaiCd
     */
    public void set_JissiNo(String[] jissiNo) {
        _jissiNo = jissiNo;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String[] get_Renban() {
        return _Renban;
    }

    public void set_Renban(String[] renban) {
        _Renban = renban;
    }

}
