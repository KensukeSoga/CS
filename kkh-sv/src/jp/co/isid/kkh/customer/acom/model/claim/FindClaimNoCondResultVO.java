package jp.co.isid.kkh.customer.acom.model.claim;


import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ����/�����ԍ� �ꗗ���VO (�ԋp�p)
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindClaimNoCondResultVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindClaimNoCondResultVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindClaimNoCondResultVO();
    }

    /**
     * �����敪���擾����
     * @return �����敪
     */
    public String getShoriKbn() {
        return (String) get("SHORIKBN");
    }

    /**
     * �����敪��ݒ肷��
     * @param val �����敪
     */
    public void setShoriKbn(String val) {
        set("SHORIKBN", val);
    }

    /**
     * �o�͑I�����擾����
     * @return �o�͑I��
     */
    public String getOutSelect() {
        return (String) get("OUTSELECT");
    }

    /**
     * �o�͑I����ݒ肷��
     * @param val �o�͑I��
     */
    public void setOutSelect(String val) {
        set("OUTSELECT", val);
    }

    /**
     * �˗��ԍ��i�����ԍ��j���擾����
     * @return �˗��ԍ��i�����ԍ��j
     */
    public String getIraiNo() {
        return (String) get("IRAINO");
    }

    /**
     * �˗��ԍ��i�����ԍ��j��ݒ肷��
     * @param val �˗��ԍ��i�����ԍ��j
     */
    public void setIraiNo(String val) {
        set("IRAINO", val);
    }

    /**
     * �������ԍ����擾����
     * @return �������ԍ�
     */
    public String getSeiNo() {
        return (String) get("SEINO");
    }

    /**
     * �������ԍ���ݒ肷��
     * @param val �������ԍ�
     */
    public void setSeiNo(String val) {
        set("SEINO", val);
    }

    /**
     * ���������s�����擾����
     * @return ���������s��
     */
    public String getSeiYymm() {
        return (String) get("SEIYYMM");
    }

    /**
     * ���������s����ݒ肷��
     * @param val ���������s��
     */
    public void setSeiYymm(String val) {
        set("SEIYYMM", val);
    }

    /**
     * �������擾����
     * @return ����
     */
    public String getKenmei() {
        return (String) get("KENMEI");
    }

    /**
     * ������ݒ肷��
     * @param val ����
     */
    public void setKenmei(String val) {
        set("KENMEI", val);
    }

    /**
     * �}�̃R�[�h(21:�V�� 22:�G�� 11:�d�g 31:��� )���擾����
     * @return �}�̃R�[�h(21:�V�� 22:�G�� 11:�d�g 31:��� )
     */
    public String getBaitaiCd() {
        return (String) get("BAITAICD");
    }

    /**
     * �}�̃R�[�h(21:�V�� 22:�G�� 11:�d�g 31:��� )��ݒ肷��
     * @param val �}�̃R�[�h(21:�V�� 22:�G�� 11:�d�g 31:��� )
     */
    public void setBaitaiCd(String val) {
        set("BAITAICD", val);
    }

    /**
     * ���s�������擾����
     * @return ���s����
     */
    public String getOutDate() {
        return (String) get("OUTDATE");
    }

    /**
     * ���s������ݒ肷��
     * @param val ���s����
     */
    public void setOutDate(String val) {
        set("OUTDATE", val);
    }

    /**
     * ��No���擾����
     * @return ��No
     */
    public String getJyutNo() {
        return (String) get("JYUTNO");
    }

    /**
     * ��No��ݒ肷��
     * @param val ��No
     */
    public void setJyutNo(String val) {
        set("JYUTNO", val);
    }

    /**
     * �󒍖���No���擾����
     * @return �󒍖���No
     */
    public String getJymeiNo() {
        return (String) get("JYMEINO");
    }

    /**
     * �󒍖���No��ݒ肷��
     * @param val �󒍖���No
     */
    public void setJymeiNo(String val) {
        set("JYMEINO", val);
    }

    /**
     * ���㖾��No���擾����
     * @return ���㖾��No
     */
    public String getUrmeiNo() {
        return (String) get("URMEINO");
    }

    /**
     * ���㖾��No��ݒ肷��
     * @param val ���㖾��No
     */
    public void setUrmeiNo(String val) {
        set("URMEINO", val);
    }

    /**
     * �A�Ԃ��擾����
     * @return �A��
     */
    public String getRenBan() {
        return (String) get("RENBAN");
    }

    /**
     * �A�Ԃ�ݒ肷��
     * @param val �A��
     */
    public void setRenBan(String val) {
        set("RENBAN", val);
    }

}