package jp.co.isid.kkh.customer.epson.model.detail;

import java.io.Serializable;
import java.util.List;

import jp.co.isid.kkh.model.detail.Thb1DownVO;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;

public class DetailDataEpsonVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ���׋敪 **/
    private String _kbn = null;

    /** �_�E�����[�h�e�[�u�� */
    private Thb1DownVO _thb1Down = null;

    /** �L����׃e�[�u�����X�g */
    private List<Thb2KmeiVO> _thb2Kmei = null;

    /** �_�~�[�v���p�e�B */
    private String _dummy = null;

    /**
     * ���׋敪���擾����
     * @return ���׋敪
     */
    public String getKbn() {
        return _kbn;
    }

    /**
     * ���׋敪��ݒ肷��
     */
    public void setKbn(String _kbn) {
        this._kbn = _kbn;
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
