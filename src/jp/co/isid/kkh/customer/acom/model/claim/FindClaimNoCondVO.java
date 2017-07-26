package jp.co.isid.kkh.customer.acom.model.claim;


import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ����/�����ԍ� �ꗗ���VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindClaimNoCondVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindClaimNoCondVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindClaimNoCondVO();
    }

    /**
     * �}�̃R�[�h(21:�V�� 22:�G�� 11:�d�g 31:��� )���擾����
     * @return �}�̃R�[�h(21:�V�� 22:�G�� 11:�d�g 31:��� )
     */
    public String getBaitaiCd() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * �}�̃R�[�h(21:�V�� 22:�G�� 11:�d�g 31:��� )��ݒ肷��
     * @param val �}�̃R�[�h(21:�V�� 22:�G�� 11:�d�g 31:��� )
     */
    public void setBaitaiCd(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * �˗��ԍ��i�����ԍ��j���擾����
     * @return �˗��ԍ��i�����ԍ��j
     */
    public String getIraiNo() {
        return (String) get(TBTHB2KMEI.CODE3);
    }

    /**
     * �˗��ԍ��i�����ԍ��j��ݒ肷��
     * @param val �˗��ԍ��i�����ԍ��j
     */
    public void setIraiNo(String val) {
        set(TBTHB2KMEI.CODE3, val);
    }

    /**
     * �������擾����
     * @return ����
     */
    public String getKenmei() {
        return (String) get(TBTHB1DOWN.KKNAMEKJ);
    }

    /**
     * ������ݒ肷��
     * @param val ����
     */
    public void setKenmei(String val) {
        set(TBTHB1DOWN.KKNAMEKJ, val);
    }

    /**
     * �������ԍ����擾����
     * @return �������ԍ�
     */
    public String getSeiNo() {
        return (String) get(TBTHB2KMEI.SONOTA1);
    }

    /**
     * �������ԍ���ݒ肷��
     * @param val �������ԍ�
     */
    public void setSeiNo(String val) {
        set(TBTHB2KMEI.SONOTA1, val);
    }

    /**
     * ���������s�����擾����
     * @return ���������s��
     */
    public String getSeiYymm() {
        return (String) get(TBTHB2KMEI.DATE1);
    }

    /**
     * ���������s����ݒ肷��
     * @param val ���������s��
     */
    public void setSeiYymm(String val) {
        set(TBTHB2KMEI.DATE1, val);
    }

    /**
     * �󒍓��e�敪���擾����
     * @return �󒍓��e�敪
     */
    public String getKbn() {
        return (String) get(TBTHB2KMEI.SONOTA6);
    }

    /**
     * �󒍓��e�敪��ݒ肷��
     * @param val �󒍓��e�敪
     */
    public void setKbn(String val) {
        set(TBTHB2KMEI.SONOTA6, val);
    }

    /**
     * �o�̓t���O���擾����
     * @return �o�̓t���O
     */
    public String getShoriKbn() {
        return (String) get(TBTHB2KMEI.KBN1);
    }

    /**
     * �o�̓t���O��ݒ肷��
     * @param val �o�̓t���O
     */
    public void setShoriKbn(String val) {
        set(TBTHB2KMEI.KBN1, val);
    }

    /**
     * ���s�������擾����
     * @return ���s����
     */
    public String getOutDate() {
        return (String) get(TBTHB2KMEI.NAME7);
    }

    /**
     * ���s������ݒ肷��
     * @param val ���s����
     */
    public void setOutDate(String val) {
        set(TBTHB2KMEI.NAME7, val);
    }

    /**
     * ��No���擾����
     * @return ��No
     */
    public String getJyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * ��No��ݒ肷��
     * @param val ��No
     */
    public void setJyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * �󒍖���No���擾����
     * @return �󒍖���No
     */
    public String getJymeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * �󒍖���No��ݒ肷��
     * @param val �󒍖���No
     */
    public void setJymeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * ���㖾��No���擾����
     * @return ���㖾��No
     */
    public String getUrmeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * ���㖾��No��ݒ肷��
     * @param val ���㖾��No
     */
    public void setUrmeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * �A�Ԃ��擾����
     * @return �A��
     */
    public String getRenBan() {
        return (String) get(TBTHB2KMEI.RENBN);
    }

    /**
     * �A�Ԃ�ݒ肷��
     * @param val �A��
     */
    public void setRenBan(String val) {
        set(TBTHB2KMEI.RENBN, val);
    }

}