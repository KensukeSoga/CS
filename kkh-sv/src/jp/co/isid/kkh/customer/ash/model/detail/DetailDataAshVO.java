package jp.co.isid.kkh.customer.ash.model.detail;

import jp.co.isid.kkh.model.detail.Thb2KmeiVO;

/**
 * <P>
 * �L����׃f�[�^VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/14 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class DetailDataAshVO extends Thb2KmeiVO {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public DetailDataAshVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new DetailDataAshVO();
    }

    /** �ǃ}�X�^ �t�B�[���h�P */
    private String _kyokuField1 = null;

    /** �ǃ}�X�^ �t�B�[���h�Q */
    private String _kyokuField2 = null;

    /** �ǃ}�X�^ �t�B�[���h�R */
    private String _kyokuField3 = null;

    /** �ǃ}�X�^ �t�B�[���h�S */
    private String _kyokuField4 = null;

    /** ���i�}�X�^ �t�B�[���h�P */
    private String _shouhinField1 = null;

    /** ���i�}�X�^ �t�B�[���h�Q */
    private String _shouhinField2 = null;

    /**
     * �ǃ}�X�^ �t�B�[���h�P���擾����
     * @return �ǃ}�X�^ �t�B�[���h�P
     */
    public String getKyokuField1() {
        return _kyokuField1;
    }

    /**
     * �ǃ}�X�^ �t�B�[���h�P��ݒ肷��
     * @param kyokuField1 �ǃ}�X�^ �t�B�[���h�P
     */
    public void setKyokuField1(String kyokuField1) {
        this._kyokuField1 = kyokuField1;
    }

    /**
     * �ǃ}�X�^ �t�B�[���h�Q���擾����
     * @return �ǃ}�X�^ �t�B�[���h�Q
     */
    public String getKyokuField2() {
        return _kyokuField2;
    }

    /**
     * �ǃ}�X�^ �t�B�[���h�Q��ݒ肷��
     * @param kyokuField2 �ǃ}�X�^ �t�B�[���h�Q
     */
    public void setKyokuField2(String kyokuField2) {
        this._kyokuField2 = kyokuField2;
    }

    /**
     * �ǃ}�X�^ �t�B�[���h�R���擾����
     * @return �ǃ}�X�^ �t�B�[���h�R
     */
    public String getKyokuField3() {
        return _kyokuField3;
    }

    /**
     * �ǃ}�X�^ �t�B�[���h�R��ݒ肷��
     * @param kyokuField3 �ǃ}�X�^ �t�B�[���h�R
     */
    public void setKyokuField3(String kyokuField3) {
        this._kyokuField3 = kyokuField3;
    }

    /**
     * �ǃ}�X�^ �t�B�[���h�S���擾����
     * @return �ǃ}�X�^ �t�B�[���h�S
     */
    public String getKyokuField4() {
        return _kyokuField4;
    }

    /**
     * �ǃ}�X�^ �t�B�[���h�S��ݒ肷��
     * @param kyokuField4 �ǃ}�X�^ �t�B�[���h�S
     */
    public void setKyokuField4(String kyokuField4) {
        this._kyokuField4 = kyokuField4;
    }

    /**
     * ���i�}�X�^ �t�B�[���h�P���擾����
     * @return ���i�}�X�^ �t�B�[���h�P
     */
    public String getShouhinField1() {
        return _shouhinField1;
    }

    /**
     * ���i�}�X�^ �t�B�[���h�P��ݒ肷��
     * @param shouhinField1 ���i�}�X�^ �t�B�[���h�P
     */
    public void setShouhinField1(String shouhinField1) {
        this._shouhinField1 = shouhinField1;
    }

    /**
     * ���i�}�X�^ �t�B�[���h�Q���擾����
     * @return ���i�}�X�^ �t�B�[���h�Q
     */
    public String getShouhinField2() {
        return _shouhinField2;
    }

    /**
     * ���i�}�X�^ �t�B�[���h�Q��ݒ肷��
     * @param shouhinField2 ���i�}�X�^ �t�B�[���h�Q
     */
    public void setShouhinField2(String shouhinField2) {
        this._shouhinField2 = shouhinField2;
    }

}
