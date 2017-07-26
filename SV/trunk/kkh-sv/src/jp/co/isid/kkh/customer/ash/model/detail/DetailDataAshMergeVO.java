package jp.co.isid.kkh.customer.ash.model.detail;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.model.detail.Thb1DownVO;

public class DetailDataAshMergeVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ESQ-ID */
    private String _esqId = "";

    /** �_�E�����[�h�e�[�u��(������f�[�^) */
    private Thb1DownVO _tougouSaki = null;

    /** �_�E�����[�h�e�[�u��(�������f�[�^) */
    private List<Thb1DownVO> _tougouMotoList = null;

    /** �ő�X�V���t(�r���`�F�b�N�p) **/
    private Date _maxUpdDate;

    /** �}�̃R�[�h **/
    private String _baitaiCd;

    /** �_�~�[�v���p�e�B */
    private String _dummy = null;

    /**
     * ESQ-ID���擾����
     * @return ESQ-ID
     */
    public String getEsqId() {
        return _esqId;
    }

    /**
     * ESQ-ID��ݒ肷��
     * @param esqId ESQ-ID
     */
    public void setEsqId(String esqId) {
        this._esqId = esqId;
    }

    /**
     * �_�E�����[�h�e�[�u��(������f�[�^)���擾����
     * @return �_�E�����[�h�e�[�u��
     */
    public Thb1DownVO getTougouSaki() {
        return _tougouSaki;
    }

    /**
     * �_�E�����[�h�e�[�u��(������f�[�^)��ݒ肷��
     * @param thb1Down �_�E�����[�h�e�[�u��
     */
    public void setTougouSaki(Thb1DownVO tougouSaki) {
        this._tougouSaki = tougouSaki;
    }

    /**
     * �_�E�����[�h�e�[�u��(�������f�[�^)���擾����
     * @return �_�E�����[�h�e�[�u��
     */
    public List<Thb1DownVO> getTougouMotoList() {
        return _tougouMotoList;
    }

    /**
     * �_�E�����[�h�e�[�u��(�������f�[�^)��ݒ肷��
     * @param thb1Down �_�E�����[�h�e�[�u��
     */
    public void setTougouMotoList(List<Thb1DownVO> tougouMotoList) {
        this._tougouMotoList = tougouMotoList;
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
     * �}�̃R�[�h���擾����
     * @return �}�̃R�[�h
     */
    public String getBaitaiCd() {
        return _baitaiCd;
    }

    /**
     * �}�̃R�[�h��ݒ肷��
     * @param maxUpdDate �}�̃R�[�h
     */
    public void setBaitaiCd(String baitaiCd) {
        this._baitaiCd = baitaiCd;
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
