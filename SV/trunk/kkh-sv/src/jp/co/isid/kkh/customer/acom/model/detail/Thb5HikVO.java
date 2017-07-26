package jp.co.isid.kkh.customer.acom.model.detail;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class Thb5HikVO implements Serializable {

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

    /** �˗��ԍ� */
    private String _irban = null;

    /** �˗��s�ԍ� */
    private String _irGyoBan = null;

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
     * @return _aplId
     */
    public String get_aplId() {
        return _aplId;
    }

    /**
     * aplId��ݒ肷��
     * @param _aplId
     */
    public void set_aplId(String aplId) {
        _aplId = aplId;
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂�
     * @return _egCd
     */
    public String get_egCd() {
        return _egCd;
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肷��
     * @param _egCd
     */
    public void set_egCd(String egCd) {
        _egCd = egCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂�
     * @return _tksKgyCd
     */
    public String get_tksKgyCd() {
        return _tksKgyCd;
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肷��
     * @param _tksKgyCd
     */
    public void set_tksKgyCd(String tksKgyCd) {
        _tksKgyCd = tksKgyCd;
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂�
     * @return _tksBmnSeqNo
     */
    public String get_tksBmnSeqNo() {
        return _tksBmnSeqNo;
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肷��
     * @param _tksBmnSeqNo
     */
    public void set_tksBmnSeqNo(String tksBmnSeqNo) {
        _tksBmnSeqNo = tksBmnSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂�
     * @return _tksTntSeqNo
     */
    public String get_tksTntSeqNo() {
        return _tksTntSeqNo;
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肷��
     * @param _tksTntSeqNo
     */
    public void set_tksTntSeqNo(String tksTntSeqNo) {
        _tksTntSeqNo = tksTntSeqNo;
    }

    /**
     * �˗��ԍ���Ԃ��܂�
     * @return _irban
     */
    public String get_irban() {
        return _irban;
    }

    /**
     * �˗��ԍ���ݒ肷��
     * @param _irban
     */
    public void set_irban(String irban) {
        _irban = irban;
    }

    /**
     * �˗��s�ԍ���Ԃ��܂�
     * @return _irban
     */
    public String get_irGyoBan() {
        return _irGyoBan;
    }

    /**
     * �˗��s�ԍ���ݒ肷��
     * @param _irban
     */
    public void set_irGyoBan(String irGyoBan) {
        _irGyoBan = irGyoBan;
    }

}
