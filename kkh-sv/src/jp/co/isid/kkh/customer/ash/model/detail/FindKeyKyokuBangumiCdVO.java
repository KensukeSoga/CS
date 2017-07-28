package jp.co.isid.kkh.customer.ash.model.detail;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �L�[�ǂ̔ԑg�R�[�h��VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/08/20 HLC S.Jang)<BR>
 * </P>
 *
 * @author HLC ��(Jang)
 */
public class FindKeyKyokuBangumiCdVO extends AbstractModel {
    private static final long serialVersionUID = 1L;

    public Object newInstance() {
        return new FindKeyKyokuBangumiCdVO();
    }

    /** �ǃR�[�h */
    private String KYOKUCD = null;
    /** �ǖ� */
    private String KYOKUNAME = null;
    /** �ԑg�R�[�h */
    private String BANGUMICD = null;
    /** �L�[�ǃR�[�h */
    private String KEYBANGUMICD = null;
    /** �ǖ�(����) */
    private String KYOKURYAKUSYOU = null;

    /**
     * �ǃR�[�h���擾����
     * @return �ǃR�[�h
     */
    public String getKYOKUCD() {
        return KYOKUCD;
    }

    /**
     * �ǃR�[�h��ݒ肷��
     * @param val String val
     */
    public void setKYOKUCD(String val) {
        KYOKUCD = val;
    }

    /**
     * �ǖ����擾����
     * @return �ǖ�
     */
    public String getKYOKUNAME() {
        return KYOKUNAME;
    }

    /**
     * �ǖ���ݒ肷��
     * @param val String �ǖ�
     */
    public void setKYOKUNAME(String val) {
        KYOKUNAME = val;
    }

    /**
     * �ԑg�R�[�h���擾����
     * @return �ԑg�R�[�h
     */
    public String getBANGUMICD() {
        return BANGUMICD;
    }

    /**
     * �ԑg�R�[�h��ݒ肷��
     * @param val String �ԑg�R�[�h
     */
    public void setBANGUMICD(String val) {
        BANGUMICD = val;
    }

    /**
     * �L�[�ǃR�[�h���擾����
     * @return �L�[�ǃR�[�h
     */
    public String getKEYBANGUMICD() {
        return KEYBANGUMICD;
    }

    /**
     * �L�[�ǃR�[�h��ݒ肷��
     * @param val String �L�[�ǃR�[�h
     */
    public void setKEYBANGUMICD(String val) {
        KEYBANGUMICD = val;
    }

    /**
     * �ǖ�(����)���擾����
     * @return �ǖ�(����)
     */
    public String getKYOKURYAKUSYOU() {
        return KYOKURYAKUSYOU;
    }

    /**
     * �ǖ�(����)��ݒ肷��
     * @param val String �ǖ�(����)
     */
    public void setKYOKURYAKUSYOU(String val) {
        KYOKURYAKUSYOU = val;
    }

}
