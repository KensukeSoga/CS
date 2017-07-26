package jp.co.isid.kkh.model.detail;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class DetailUpdateDataVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ESQ-ID */
    private String _esqId = "";

    /** �_�E�����[�h�e�[�u�� */
    private Thb1DownVO _thb1Down = null;

    /** �L����׃e�[�u�����X�g */
    private List<Thb2KmeiVO> _thb2Kmei = null;

    /** �������ꂽ�Ƃ��p�Ή� */
    private Thb1DownVO _TouKouThb1Down = null;

    /** �ő�X�V���t(�r���`�F�b�N�p) */
    private Date _maxUpdDate;

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
     * �_�E�����[�h�e�[�u�����擾����
     * @return �_�E�����[�h�e�[�u��
     */
    public Thb1DownVO getThb1Down() {
        return _thb1Down;
    }

    /**
     * �_�E�����[�h�e�[�u����ݒ肷��
     * @param thb1Down �_�E�����[�h�e�[�u��
     */
    public void setThb1Down(Thb1DownVO thb1Down) {
        this._thb1Down = thb1Down;
    }

    /**
     * �L����׃e�[�u�����X�g���擾����
     * @return �L����׃e�[�u�����X�g
     */
    public List<Thb2KmeiVO> getThb2Kmei() {
        return _thb2Kmei;
    }

    /**
     * �L����׃e�[�u�����X�g��ݒ肷��
     * @param thb2Kmei �L����׃e�[�u�����X�g
     */
    public void setThb2Kmei(List<Thb2KmeiVO> thb2Kmei) {
        this._thb2Kmei = thb2Kmei;
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
     * �_�E�����[�h�e�[�u�����擾����i��������Ă���悤�j
     * @return �_�E�����[�h�e�[�u��
     */
    public Thb1DownVO getTouKouThb1Down() {
        return _TouKouThb1Down;
    }

    /**
     * �_�E�����[�h�e�[�u����ݒ肷��i��������Ă���悤�j
     * @param thb1Down �_�E�����[�h�e�[�u��
     */
    public void setTouKouThb1Down(Thb1DownVO TouKouThb1Down) {
        this._TouKouThb1Down = TouKouThb1Down;
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
