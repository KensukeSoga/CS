package jp.co.isid.kkh.model.detail;

import java.io.Serializable;

public class JyutNoTouInsVO implements Serializable {

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

    /** ������No */
    private String _keyJyutno = null;

    /** �����󒍖���No */
    private String _keyJyMeiNo = null;

    /** �������㖾��No */
    private String _keyUriMeiNo = null;

    /** ��ڃR�[�h */
    private String _himkCd = null;

    /** �Ɩ��敪 */
    private String _gyomKbn = null;

    /** ���ۃ}�X�����敪 */
    private String _msKbn = null;

    /** �^�C���X�|�b�g�敪 */
    private String _tmsKbn = null;

    /** ���ۋ敪 */
    private String _kokKbn = null;

    /** �����敪 */
    private String _seiKbn = null;

    /** ���iNo */
    private String _syoNo = null;

    /** ���� */
    private String _kknameKj = null;

    /** �c�Ɖ�ʃ^�C�v */
    private String _egGamenType = null;

    /** ���E���ŋ敪 */
    private String _kkakShanKbn = null;

    /** ��藿�� */
    private String _toriRyouKin = null;

    /** �������z */
    private String _seikyuKin = null;

    /** �l���� */
    private String _nebikiRitu = null;

    /** �l���z */
    private String _nebikiGaku = null;

    /** ����ŋ敪 */
    private String _szeiKbn = null;

    /** ����ŗ� */
    private String _szeiRitu = null;

    /** ����Ŋz */
    private String _szeiGaku = null;

    /** ��ږ� */
    private String _himkNmkj = null;
    /** �t�B�[���h1 */
    private String _field1 = null;
    /** �t�B�[���h2 */
    private String _field2 = null;
    /** �t�B�[���h3 */
    private String _field3 = null;
    /** �t�B�[���h4 */
    private String _field4 = null;
    /** �t�B�[���h5 */
    private String _field5 = null;
    /** �t�B�[���h6 */
    private String _field6 = null;
    /** �t�B�[���h7 */
    private String _field7 = null;
    /** �t�B�[���h8 */
    private String _field8 = null;
    /** �t�B�[���h9 */
    private String _field9 = null;
    /** �t�B�[���h10 */
    private String _field10 = null;
    /** �t�B�[���h11 */
    private String _field11 = null;
    /** �t�B�[���h12 */
    private String _field12 = null;
    /** �_�E�����[�h�t�@�C���^�C���X�^���v */
    private String _fileTimStmp = null;
    /** ���דo�^���� */
    private String _meiTimStmp = null;
    /** �󒍍폜�t���O */
    private String _jyutDelFlg = null;
    /**  �_�~�[�v���p�e�B */
    private String _dummy = null;

    /**
     * esqId��Ԃ��܂�
     * @return String ESQ-ID
     */
    public String get_esqId() {
        return _esqId;
    }

    /**
     * esqId��ݒ肷��
     * @param esqid String ESQ-ID
     */
    public void set_esqId(String esqId) {
        _esqId = esqId;
    }

    /**
     * aplId��Ԃ��܂�
     * @return String �A�v��ID
     */
    public String get_aplId() {
        return _aplId;
    }

    /**
     * aplId��ݒ肷��
     * @param aplId String �A�v��ID
     */
    public void set_aplId(String aplId) {
        _aplId = aplId;
    }

    /**
     * �c�Ə��R�[�h��Ԃ��܂�
     * @return String �c�Ə��R�[�h
     */
    public String get_egCd() {
        return _egCd;
    }

    /**
     * �c�Ə��R�[�h��ݒ肷��
     * @param egCd String �c�Ə��R�[�h
     */
    public void set_egCd(String egCd) {
        _egCd = egCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂�
     * @return String ���Ӑ��ƃR�[�h
     */
    public String get_tksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肷��
     * @param tkskgycd String ���Ӑ��ƃR�[�h
     */
    public void set_tksKgyCd(String tksKgyCd) {
        _tksKgyCd = tksKgyCd;
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂�
     * @return String ���Ӑ敔��SEQNO
     */
    public String get_tksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肷��
     * @param tksBmnSeqNo String ���Ӑ敔��SEQNO
     */
    public void set_tksBmnSeqNo(String tksBmnSeqNo) {
        _tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂�
     * @return String ���Ӑ�S��SEQNO
     */
    public String get_tksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肷��
     * @param tkstntseqno String ���Ӑ�S��SEQNO
     */
    public void set_tksTntSeqNo(String tksTntSeqNo) {
        _tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * �N����Ԃ��܂�
     * @return String �N��
     */
    public String get_YYMM() {
        return _YYMM;
    }

    /**
     * �N����ݒ肷��
     * @param yymm String �N��
     */
    public void set_YYMM(String yymm) {
        _YYMM = yymm;
    }
    /**
     * ������No��Ԃ��܂�
     * @return String ������No
     */
    public String get_keyJyutno() {
        return _keyJyutno;
    }
    /**
     * ������No��ݒ肷��
     * @param keyJyutno String ������No
     */
    public void set_keyJyutno(String keyJyutno) {
        _keyJyutno = keyJyutno;
    }

    /**
     * �����󒍖���No��Ԃ��܂�
     * @return String �����󒍖���No
     */
    public String get_keyJyMeiNo() {
        return _keyJyMeiNo;
    }

    /**
     * �����󒍖���No��ݒ肷��
     * @param keyJyMeiNo String �����󒍖���No
     */
    public void set_keyJyMeiNo(String keyJyMeiNo) {
        _keyJyMeiNo = keyJyMeiNo;
    }

    /**
     * �������㖾��No��Ԃ��܂�
     * @return String �������㖾��No
     */
    public String get_keyUriMeiNo() {
        return _keyUriMeiNo;
    }

    /**
     * �������㖾��No��ݒ肷��
     * @param _keyUriMeiNo String �������㖾��No
     */
    public void set_keyUriMeiNo(String keyUriMeiNo) {
        _keyUriMeiNo = keyUriMeiNo;
    }

    /**
     * ��ڃR�[�h��Ԃ��܂�
     * @return String ��ڃR�[�h
     */
    public String get_himkCd() {
        return _himkCd;
    }
    /**
     * ��ڃR�[�h��ݒ肷��
     * @param _himkCd String ��ڃR�[�h
     */
    public void set_himkCd(String himkCd) {
        _himkCd = himkCd;
    }

    /**
     * �Ɩ��敪��Ԃ��܂�
     * @return String �Ɩ��敪
     */
    public String get_gyomKbn() {
        return _gyomKbn;
    }

    /**
     * �Ɩ��敪��ݒ肷��
     * @param gyomKbn String �Ɩ��敪
     */
    public void set_gyomKbn(String gyomKbn) {
        _gyomKbn = gyomKbn;
    }

    /**
     * ���ۃ}�X�����敪��Ԃ��܂�
     * @return String ���ۃ}�X�����敪
     */
    public String get_msKbn() {
        return _msKbn;
    }

    /**
     * ���ۃ}�X�����敪��ݒ肷��
     * @param msKbn String ���ۃ}�X�����敪
     */
    public void set_msKbn(String msKbn) {
        _msKbn = msKbn;
    }

    /**
     * �^�C���X�|�b�g�敪��Ԃ��܂�
     * @return String �^�C���X�|�b�g�敪
     */
    public String get_tmsKbn() {
        return _tmsKbn;
    }

    /**
     * �^�C���X�|�b�g�敪��ݒ肷��
     * @param tmsKbn String �^�C���X�|�b�g�敪
     */
    public void set_tmsKbn(String tmsKbn) {
        _tmsKbn = tmsKbn;
    }

    /**
     * ���ۋ敪��Ԃ��܂�
     * @return String ���ۋ敪
     */
    public String get_kokKbn() {
        return _kokKbn;
    }

    /**
     * ���ۋ敪��ݒ肷��
     * @param kokKbn String ���ۋ敪
     */
    public void set_kokKbn(String kokKbn) {
        _kokKbn = kokKbn;
    }

    /**
     * �����敪��Ԃ��܂�
     * @return String �����敪
     */
    public String get_seiKbn() {
        return _seiKbn;
    }

    /**
     * �����敪��ݒ肷��
     * @param seiKbn String �����敪
     */
    public void set_seiKbn(String seiKbn) {
        _seiKbn = seiKbn;
    }

    /**
     * ���iNo��Ԃ��܂�
     * @return String ���iNo
     */
    public String get_syoNo() {
        return _syoNo;
    }

    /**
     * ���iNo��ݒ肷��
     * @param syoNo String ���iNo
     */
    public void set_syoNo(String syoNo) {
        _syoNo = syoNo;
    }

    /**
     * ������Ԃ��܂�
     * @return String ����
     */
    public String get_kknameKj() {
        return _kknameKj;
    }

    /**
     * ������ݒ肷��
     * @param _kknameKj
     */
    public void set_kknameKj(String kknameKj) {
        _kknameKj = kknameKj;
    }

    /**
     * �c�Ɖ�ʃ^�C�v��Ԃ��܂�
     * @return _egGamenType
     */
    public String get_egGamenType() {
        return _egGamenType;
    }

    /**
     * �c�Ɖ�ʃ^�C�v��ݒ肷��
     * @param _egGamenType
     */
    public void set_egGamenType(String egGamenType) {
        _egGamenType = egGamenType;
    }

    /**
     * ���E���ŋ敪��Ԃ��܂�
     * @return _kkakShanKbn
     */
    public String get_kkakShanKbn() {
        return _kkakShanKbn;
    }

    /**
     * ���E���ŋ敪��ݒ肷��
     * @param _kkakShanKbn
     */
    public void set_kkakShanKbn(String kkakShanKbn) {
        _kkakShanKbn = kkakShanKbn;
    }

    /**
     * ��藿����Ԃ��܂�
     * @return _toriRyouKin
     */
    public String get_toriRyouKin() {
        return _toriRyouKin;
    }

    /**
     * ��藿����ݒ肷��
     * @param _toriRyouKin
     */
    public void set_toriRyouKin(String toriRyouKin) {
        _toriRyouKin = toriRyouKin;
    }

    /**
     * �������z��Ԃ��܂�
     * @return _seikyuKin
     */
    public String get_seikyuKin() {
        return _seikyuKin;
    }

    /**
     * �������z��ݒ肷��
     * @param _seikyuKin
     */
    public void set_seikyuKin(String seikyuKin) {
        _seikyuKin = seikyuKin;
    }

    /**
     * �l������Ԃ��܂�
     * @return _nebikiRitu
     */
    public String get_nebikiRitu() {
        return _nebikiRitu;
    }

    /**
     * �l������ݒ肷��
     * @param _nebikiRitu
     */
    public void set_nebikiRitu(String nebikiRitu) {
        _nebikiRitu = nebikiRitu;
    }

    /**
     * �l���z��Ԃ��܂�
     * @return _nebikiGaku
     */
    public String get_nebikiGaku() {
        return _nebikiGaku;
    }

    /**
     * �l���z��ݒ肷��
     * @param _nebikiGaku
     */
    public void set_nebikiGaku(String nebikiGaku) {
        _nebikiGaku = nebikiGaku;
    }

    /**
     * ����ŋ敪��Ԃ��܂�
     * @return _szeiKbn
     */
    public String get_szeiKbn() {
        return _szeiKbn;
    }

    /**
     * ����ŋ敪��ݒ肷��
     * @param _szeiKbn
     */
    public void set_szeiKbn(String szeiKbn) {
        _szeiKbn = szeiKbn;
    }

    /**
     * ����ŗ���Ԃ��܂�
     * @return _szeiRitu
     */
    public String get_szeiRitu() {
        return _szeiRitu;
    }

    /**
     * ����ŗ���ݒ肷��
     * @param _szeiRitu
     */
    public void set_szeiRitu(String szeiRitu) {
        _szeiRitu = szeiRitu;
    }

    /**
     * ����Ŋz��Ԃ��܂�
     * @return _szeiGaku
     */
    public String get_szeiGaku() {
        return _szeiGaku;
    }

    /**
     * ����Ŋz��ݒ肷��
     * @param _szeiGaku
     */
    public void set_szeiGaku(String szeiGaku) {
        _szeiGaku = szeiGaku;
    }

    /**
     * ��ږ���Ԃ��܂�
     * @return _himkNmkj
     */
    public String get_himkNmkj() {
        return _himkNmkj;
    }

    /**
     * ��ږ���ݒ肷��
     * @param _himkNmkj
     */
    public void set_himkNmkj(String himkNmkj) {
        _himkNmkj = himkNmkj;
    }

    /**
     * �t�B�[���h1��Ԃ��܂�
     * @return _field1
     */
    public String get_field1() {
        return _field1;
    }

    /**
     * �t�B�[���h1��ݒ肷��
     * @param _field1
     */
    public void set_field1(String field1) {
        _field1 = field1;
    }

    public String get_field2() {
        return _field2;
    }

    public void set_field2(String field2) {
        _field2 = field2;
    }

    public String get_field3() {
        return _field3;
    }

    public void set_field3(String field3) {
        _field3 = field3;
    }

    public String get_field4() {
        return _field4;
    }

    public void set_field4(String field4) {
        _field4 = field4;
    }

    public String get_field5() {
        return _field5;
    }

    public void set_field5(String field5) {
        _field5 = field5;
    }

    public String get_field6() {
        return _field6;
    }

    public void set_field6(String field6) {
        _field6 = field6;
    }

    public String get_field7() {
        return _field7;
    }

    public void set_field7(String field7) {
        _field7 = field7;
    }

    public String get_field8() {
        return _field8;
    }

    public void set_field8(String field8) {
        _field8 = field8;
    }

    public String get_field9() {
        return _field9;
    }

    public void set_field9(String field9) {
        _field9 = field9;
    }

    public String get_field10() {
        return _field10;
    }

    public void set_field10(String field10) {
        _field10 = field10;
    }

    public String get_field11() {
        return _field11;
    }

    public void set_field11(String field11) {
        _field11 = field11;
    }

    public String get_field12() {
        return _field12;
    }

    public void set_field12(String field12) {
        _field12 = field12;
    }

    public String get_fileTimStmp() {
        return _fileTimStmp;
    }

    public void set_fileTimStmp(String fileTimStmp) {
        _fileTimStmp = fileTimStmp;
    }

    public String get_meiTimStmp() {
        return _meiTimStmp;
    }

    public void set_meiTimStmp(String meiTimStmp) {
        _meiTimStmp = meiTimStmp;
    }

    public String get_jyutDelFlg() {
        return _jyutDelFlg;
    }

    public void set_jyutDelFlg(String jyutDelFlg) {
        _jyutDelFlg = jyutDelFlg;
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
