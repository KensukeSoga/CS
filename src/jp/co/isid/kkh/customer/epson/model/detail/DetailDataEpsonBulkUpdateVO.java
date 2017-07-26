package jp.co.isid.kkh.customer.epson.model.detail;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.model.detail.Thb1DownVO;

public class DetailDataEpsonBulkUpdateVO implements Serializable {

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

    /** ���̓t���O */
    private String _inputFlg = null;

    /** �L����׃f�[�^VO���X�g */
    private List<DetailDataEpsonVO> _detailDataEpsonVOList = null;

    /** �󒍓o�^�ҍX�V�ҍX�V */
    private List<Thb1DownVO> _TouIkkatsuThb1Down = null;

    /** �ő�X�V���t(�r���`�F�b�N�p) **/
    private Date _maxUpdDate;

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
     * ���̓t���O���擾����
     * @return ���̓t���O
     */
    public String getInputFlg() {
        return _inputFlg;
    }

    /**
     * ���̓t���O��ݒ肷��
     * @param  ���̓t���O
     */
    public void setInputFlg(String inputFlg) {
        this._inputFlg = inputFlg;
    }

    /**
     * �_�E�����[�h�e�[�u�����擾����
     * @return �_�E�����[�h�e�[�u��
     */
    public List<DetailDataEpsonVO> getDetailDataEpsonVOList() {
        return _detailDataEpsonVOList;
    }

    /**
     * �_�E�����[�h�e�[�u����ݒ肷��
     * @param thb1Down �_�E�����[�h�e�[�u��
     */
    public void setDetailDataEpsonVOList(List<DetailDataEpsonVO> detailDataVOList) {
        this._detailDataEpsonVOList = detailDataVOList;
    }

    /**
     * �o�^�ҍX�V�҂̍X�V
     * @return �_�E�����[�h�e�[�u��
     */
    public List<Thb1DownVO> getTouIkkatsuThb1Down() {
        return _TouIkkatsuThb1Down;
    }

    /**
     * �o�^�ҍX�V�҂̍X�V
     * @param thb1Down �_�E�����[�h�e�[�u��
     */
    public void setTouIkkatsuThb1Down(List<Thb1DownVO> TouIkkatsuThb1Down) {
        this._TouIkkatsuThb1Down = TouIkkatsuThb1Down;
    }

    /**
     * �ő�X�V���t���擾����
     * @return �_�~�[�v���p�e�B
     */
    @XmlElement(required = true)
    public Date getMaxUpdDate() {
        return _maxUpdDate;
    }

    /**
     * �ő�X�V���t��ݒ肷��
     * @param maxUpdDate �_�~�[�v���p�e�B
     */
    public void setMaxUpdDate(Date maxUpdDate) {
        this._maxUpdDate = maxUpdDate;
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
