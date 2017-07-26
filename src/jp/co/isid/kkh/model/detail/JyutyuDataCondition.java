package jp.co.isid.kkh.model.detail;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

public class JyutyuDataCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /** �c�Ə��i��j�R�[�h */
    private String _egCd;
    /** ���Ӑ��ƃR�[�h */
    private String _tksKgyCd;
    /** ���Ӑ敔��SEQNO */
    private String _tksBmnSeqNo;
    /** ���Ӑ�S��SEQNO */
    private String _tksTntSeqNo;
    /** �N�� */
    private String yymm;
    /** �I���N�� */
    private String yymmto;
    /** ���ۋ敪 */
    private String kokKbn;
    /** �^�C���^�X�|�b�g */
    private String tmspKbn;
    /** �Ɩ��敪 */
    private String gyomKbn;
    /** ��No */
    private String jyutNo;
    /** �������^�}�̏� */
    private String orderKbn;
    /** �ύX�E�폜�`�F�b�N�t���O */
    private boolean _updateCheckFlag = false;
    /** ���O�C���S����ESQID */
    private String _esqId = null;
    /** �A�v��ID */
    private String _aplId = null;
    /** ���� */
    private String _kkNameKj;

    /**
     * @return egCd
     */
    public String getEgCd() {
        return _egCd;
    }

    /**
     * @param egCd �Z�b�g���� egCd
     */
    public void setEgCd(String egCd) {
        this._egCd = egCd;
    }

    /**
     * @return tksKgyCd
     */
    public String getTksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * @param tksKgyCd �Z�b�g���� tksKgyCd
     */
    public void setTksKgyCd(String tksKgyCd) {
        this._tksKgyCd = tksKgyCd;
    }

    /**
     * @return tksBmnSeqNo
     */
    public String getTksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * @param tksBmnSeqNo �Z�b�g���� tksBmnSeqNo
     */
    public void setTksBmnSeqNo(String tksBmnSeqNo) {
        this._tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * @return tksTntSeqNo
     */
    public String getTksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * @param tksTntSeqNo �Z�b�g���� tksTntSeqNo
     */
    public void setTksTntSeqNo(String tksTntSeqNo) {
        this._tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * �N����Ԃ��܂��B
     * @return yymm
     */
    public String getYymm() {
        return yymm;
    }

    /**
     * �N����ݒ肵�܂��B
     * @param yymm
     */
    public void setYymm(String yymm) {
        this.yymm = yymm;
    }

    /**
     * �I���N����Ԃ��܂��B
     * @return yymmto
     */
    public String getYymmTo() {
        return yymmto;
    }

    /**
     * �I���N����ݒ肵�܂��B
     * @param yymmto
     */
    public void setYymmTo(String yymmto) {
        this.yymmto = yymmto;
    }

    /**
     * ���ۋ敪��Ԃ��܂��B
     * @return kokKbn
     */
    public String getKokKbn() {
        return kokKbn;
    }

    /**
     * ���ۋ敪��ݒ肵�܂��B
     * @param kokKbn
     */
    public void setKokKbn(String kokKbn) {
        this.kokKbn = kokKbn;
    }

    /**
     * �^�C���^�X�|�b�g��Ԃ��܂��B
     * @return tmspKbn
     */
    public String getTmspKbn() {
        return tmspKbn;
    }

    /**
     * �^�C���^�X�|�b�g��ݒ肵�܂��B
     * @param tmspKbn
     */
    public void setTmspKbn(String tmspKbn) {
        this.tmspKbn = tmspKbn;
    }

    /**
     * �Ɩ��敪��Ԃ��܂��B
     * @return gyomKbn
     */
    public String getGyomKbn() {
        return gyomKbn;
    }

    /**
     * �Ɩ��敪��ݒ肵�܂��B
     * @param gyomKbn
     */
    public void setGyomKbn(String gyomKbn) {
        this.gyomKbn = gyomKbn;
    }

    /**
     * ��No��Ԃ��܂��B
     * @return jyutNo
     */
    public String getJyutNo() {
        return jyutNo;
    }

    /**
     * ��No��ݒ肵�܂��B
     * @param jyutNo
     */
    public void setJyutNo(String jyutNo) {
        this.jyutNo = jyutNo;
    }

    /**
     * �������^�}�̏���Ԃ��܂��B
     * @return orderKbn
     */
    public String getOrderKbn() {
        return orderKbn;
    }

    /**
     * �������^�}�̏���ݒ肵�܂��B
     * @param orderKbn
     */
    public void setOrderKbn(String orderKbn) {
        this.orderKbn = orderKbn;
    }

    /**
     * �ύX�E�폜�`�F�b�N�t���O���擾����
     * @return �ύX�E�폜�`�F�b�N�t���O
     */
    public boolean getUpdateCheckFlag() {
        return _updateCheckFlag;
    }

    /**
     * �ύX�E�폜�`�F�b�N�t���O��ݒ肷��
     * @param updateCheckFlag �ύX�E�폜�`�F�b�N�t���O
     */
    public void setUpdateCheckFlag(boolean updateCheckFlag) {
        this._updateCheckFlag = updateCheckFlag;
    }

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
     * ������Ԃ��܂��B
     * @return ����
     */
    public String getKkNameKj() {
        return _kkNameKj;
    }

    /**
     * ������ݒ肵�܂��B
     * @param kkNameKj ����
     */
    public void setKkNameKj(String kkNameKj) {
        this._kkNameKj = kkNameKj;
    }

    //�T�[�r�X����J����������������������������������������������������������������������������������������������������������������������������������������������������������
    //@XmlTransient
    /** �ύX�`�F�b�N���ڃ��X�g */
    private List<String> _compareColumnList;
    /** �ύX�ʒm�@�\�̎g�p�ۃt���O */
    private boolean _updPostFlag = true;

    /**
     * �ύX�`�F�b�N���ڃ��X�g��Ԃ��܂��B
     * @return _compareColumnList
     */
    @XmlTransient
    public List<String> getCompareColumnList(){
        return _compareColumnList;
    }

    /**
     * �ύX�`�F�b�N���ڃ��X�g��ݒ肵�܂��B
     * @param compareColumnList
     */
    public void setCompareColumnList(List<String> compareColumnList){
        _compareColumnList = compareColumnList;
    }

    /**
     * �ύX�ʒm�@�\�̎g�p�ۃt���O��Ԃ��܂��B
     * @return _updPostFlag
     */
    @XmlTransient
    public boolean getUpdPostFlag(){
        return _updPostFlag;
    }

    /**
     * �ύX�ʒm�@�\�̎g�p�ۃt���O��ݒ肵�܂��B
     * @param updPostFlag
     */
    public void setUpdPostFlag(boolean updPostFlag){
        _updPostFlag = updPostFlag;
    }

    //�T�[�r�X����J����������������������������������������������������������������������������������������������������������������������������������������������������������

}
