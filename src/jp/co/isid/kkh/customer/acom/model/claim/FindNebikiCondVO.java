package jp.co.isid.kkh.customer.acom.model.claim;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �����f�[�^ �ꗗ���VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindNebikiCondVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindNebikiCondVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindNebikiCondVO();
    }

    /**
     * �l���\��NO���擾����
     * @return �l���\��NO
     */
    public String getSinseiNo() {
        return (String) get("MEU19_NBIKSINSEINO");
    }

    /**
     * �l���\��NO��ݒ肷��
     * @param val �l���\��NO
     */
    public void setSinseiNo(String val) {
        set("MEU19_NBIKSINSEINO", val);
    }

    /**
     * �Ɩ��敪���擾����
     * @return �Ɩ��敪
     */
    public String getGMkbnCd() {
        return (String) get("MEU1A_GYOMKBN");
    }

    /**
     * �Ɩ��敪��ݒ肷��
     * @param val �Ɩ��敪
     */
    public void setGMkbnCd(String val) {
        set("MEU1A_GYOMKBN", val);
    }

    /**
     * �}�̃R�[�h���擾����
     * @return �}�̃R�[�h
     */
    public String getBtCd() {
        return (String) get("MEU1A_BTAICD");
    }

    /**
     * �}�̃R�[�h��ݒ肷��
     * @param val �}�̃R�[�h
     */
    public void setBtCd(String val) {
        set("MEU1A_BTAICD", val);
    }

    /**
     * ��ڋ敪���擾����
     * @return ��ڋ敪
     */
    public String getHmCd() {
        return (String) get("MEU1A_HMOKCD");
    }

    /**
     * ��ڋ敪��ݒ肷��
     * @param val ��ڋ敪
     */
    public void setHmCd(String val) {
        set("MEU1A_HMOKCD", val);
    }

    /**
     * �l�������擾����
     * @return �l����
     */
    public BigDecimal getNebikiR() {
        return (BigDecimal) get("MEU1A_NBIKRITU");
    }

    /**
     * �l������ݒ肷��
     * @param val �l����
     */
    public void setNebikiR(BigDecimal val) {
        set("MEU1A_NBIKRITU", val);
    }

}
