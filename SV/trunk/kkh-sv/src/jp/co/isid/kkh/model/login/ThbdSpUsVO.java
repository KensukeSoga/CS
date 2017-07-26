package jp.co.isid.kkh.model.login;

import jp.co.isid.kkh.integ.tbl.TBTHBDSPUS;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���ʃ��[�U�[�}�X�^VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class ThbdSpUsVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ThbdSpUsVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ThbdSpUsVO();
    }

    /**
     * �c�Ə��R�[�h���擾����
     * @return �c�Ə��R�[�h
     */
    public String getEgsCd() {
        return (String) get(TBTHBDSPUS.EGSCD);
    }

    /**
     * �c�Ə��R�[�h��ݒ肷��
     * @param val �c�Ə��R�[�h
     */
    public void setEgsCd(String val) {
        set(TBTHBDSPUS.EGSCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h���擾����
     * @return ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return (String) get(TBTHBDSPUS.TKSKGYCD);
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肷��
     * @param val ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String val) {
        set(TBTHBDSPUS.TKSKGYCD, val);
    }

    /**
     * ���Ӑ敔��SEQNO���擾����
     * @return ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHBDSPUS.TKSBMNSEQNO);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肷��
     * @param val ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHBDSPUS.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO���擾����
     * @return ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHBDSPUS.TKSTNTSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肷��
     * @param val ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHBDSPUS.TKSTNTSEQNO, val);
    }

    /**
     * �g�D�R�[�h���擾����
     * @return �g�D�R�[�h
     */
    public String getSikCd() {
        return (String) get(TBTHBDSPUS.SIKCD);
    }

    /**
     * �g�D�R�[�h��ݒ肷��
     * @param val �g�D�R�[�h
     */
    public void setSikCd(String val) {
        set(TBTHBDSPUS.SIKCD, val);
    }

    /**
     * ���[�U�[ID���擾����
     * @return ���[�U�[ID
     */
    public String getUserId() {
        return (String) get(TBTHBDSPUS.USERID);
    }

    /**
     * ���[�U�[ID��ݒ肷��
     * @param val ���[�U�[ID
     */
    public void setUserId(String val) {
        set(TBTHBDSPUS.USERID, val);
    }

    /**
     * �c�Ə������擾����
     * @return �c�Ə���
     */
    public String getEgsNm() {
        return (String) get(TBTHBDSPUS.EGSNM);
    }

    /**
     * �c�Ə�����ݒ肷��
     * @param val �c�Ə���
     */
    public void setEgsNm(String val) {
        set(TBTHBDSPUS.EGSNM, val);
    }

    /**
     * ���Ӑ��Ɩ����擾����
     * @return ���Ӑ��Ɩ�
     */
    public String getTksKgyNm() {
        return (String) get(TBTHBDSPUS.TKSKGYNM);
    }

    /**
     * ���Ӑ��Ɩ���ݒ肷��
     * @param val ���Ӑ��Ɩ�
     */
    public void setTksKgyNm(String val) {
        set(TBTHBDSPUS.TKSKGYNM, val);
    }

    /**
     * ���Ӑ敔�喼���擾����
     * @return ���Ӑ敔�喼
     */
    public String getTksBmnNm() {
        return (String) get(TBTHBDSPUS.TKSBMNNM);
    }

    /**
     * ���Ӑ敔�喼��ݒ肷��
     * @param val ���Ӑ敔�喼
     */
    public void setTksBmnNm(String val) {
        set(TBTHBDSPUS.TKSBMNNM, val);
    }

    /**
     * ���Ӑ�S�����������擾����
     * @return ���Ӑ�S��������
     */
    public String getTksTntNm() {
        return (String) get(TBTHBDSPUS.TKSTNTNM);
    }

    /**
     * ���Ӑ�S����������ݒ肷��
     * @param val ���Ӑ�S��������
     */
    public void setTksTntNm(String val) {
        set(TBTHBDSPUS.TKSTNTNM, val);
    }

    /**
     * �p�X���[�h���擾����
     * @return �p�X���[�h
     */
    public String getPassword() {
        return (String) get(TBTHBDSPUS.PASSWORD);
    }

    /**
     * �p�X���[�h��ݒ肷��
     * @param val �p�X���[�h
     */
    public void setPassword(String val) {
        set(TBTHBDSPUS.PASSWORD, val);
    }

    /**
     * ���[�U�[���i�����j���擾����
     * @return ���[�U�[���i�����j
     */
    public String getUserNmKj() {
        return (String) get(TBTHBDSPUS.USERNMKJ);
    }

    /**
     * ���[�U�[���i�����j��ݒ肷��
     * @param val ���[�U�[���i�����j
     */
    public void setUserNmKj(String val) {
        set(TBTHBDSPUS.USERNMKJ, val);
    }

    /**
     * ���[�U�[���i�Łj���擾����
     * @return ���[�U�[���i�Łj
     */
    public String getUserNmKn() {
        return (String) get(TBTHBDSPUS.USERNMKN);
    }

    /**
     * ���[�U�[���i�Łj��ݒ肷��
     * @param val ���[�U�[���i�Łj
     */
    public void setUserNmKn(String val) {
        set(TBTHBDSPUS.USERNMKN, val);
    }

}
