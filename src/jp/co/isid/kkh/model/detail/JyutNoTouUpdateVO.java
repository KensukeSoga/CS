package jp.co.isid.kkh.model.detail;

import java.io.Serializable;

public class JyutNoTouUpdateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**esqId*/
    private String _esqId = null;

    /**aplId*/
    private String _aplId = null;

    /**�c�Ə��i��j�R�[�h*/
    private String _egCd = null;

    /**���Ӑ��ƃR�[�h*/
    private String _tksKgyCd = null;

    /**���Ӑ敔��SEQNO*/
    private String _tksBmnSeqNo = null;

    /**���Ӑ�S��SEQNO*/
    private String _tksTntSeqNo = null;

    /**�N��*/
    private String _YYMM = null;

    /**��No*/
//	private String[] _jyutNo;

    /**�󒍖���No*/
//	private String[] _jyMeiNo;

    /**���㖾��No*/
//	private String[] _urMeiNo;

    /**������No*/
    private String _keyJyutno = null;

    /**�����󒍖���No*/
    private String _keyJyMeiNo = null;

    /**�������㖾��No*/
    private String _keyUriMeiNo = null;

    /**����Update�ׂ̈̕ϐ�*/
    private int Num = 0;

    /**�Ɩ��敪*/
    private String _Gyomkbn = null;
    /**�^�C���X�|�b�g�敪*/
    private String _Tmspkbn = null;

    /** �_�~�[�v���p�e�B */
    private String _dummy = null;

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
     * �Ɩ��敪��Ԃ��܂�
     * @return yymm
     */
    public String get_Gyomkbn() {
        return _Gyomkbn;
    }

    /**
     * �Ɩ��敪��ݒ肷��
     * @param esqId
     */
    public void set_Gyomkbn(String Gyomkbn) {
        _Gyomkbn = Gyomkbn;
    }

    /**
     * �^�C���X�|�b�g�敪��Ԃ��܂�
     * @return yymm
     */
    public String get_Tmspkbn() {
        return _Tmspkbn;
    }

    /**
     * �^�C���X�|�b�g�敪��ݒ肷��
     * @param esqId
     */
    public void set_Tmspkbn(String Tmspkbn) {
        _Tmspkbn = Tmspkbn;
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
     *������No��Ԃ��܂�
     * @return _keyJyutno
     */
    public String get_keyJyutno() {
        return _keyJyutno;
    }

    /**
     * ������No��ݒ肷��
     * @param _keyJyutno
     */
    public void set_keyJyutno(String keyJyutno) {
        _keyJyutno = keyJyutno;
    }

    /**
     * �����󒍖���No��Ԃ��܂�
     * @return _keyJyMeiNo
     */
    public String get_keyJyMeiNo() {
        return _keyJyMeiNo;
    }

    /**
     * �����󒍖���No��ݒ肷��
     * @param _keyJyMeiNo
     */
    public void set_keyJyMeiNo(String keyJyMeiNo) {
        _keyJyMeiNo = keyJyMeiNo;
    }

    /**
     * �������㖾��No��Ԃ��܂�
     * @return _keyUriMeiNo
     */
    public String get_keyUriMeiNo() {
        return _keyUriMeiNo;
    }

    /**
     * �������㖾��No��ݒ肷��
     * @param _keyUriMeiNo
     */
    public void set_keyUriMeiNo(String keyUriMeiNo) {
        _keyUriMeiNo = keyUriMeiNo;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    /**
     * �_�~�[�v���p�e�B��Ԃ��܂�
     * @return _dummy
     */
    public String get_dummy() {
        return _dummy;
    }

    /**
     * �_�~�[�v���p�e�B��ݒ肷��
     * @param _dummy
     */
    public void set_dummy(String dummy) {
        _dummy = dummy;
    }

}
