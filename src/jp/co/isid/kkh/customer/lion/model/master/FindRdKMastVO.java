package jp.co.isid.kkh.customer.lion.model.master;

import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB12WLRDK;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���W�I��VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/20 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class FindRdKMastVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindRdKMastVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindRdMastVO();
    }

    /**
     * �o�^�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �o�^�^�C���X�^���v
     */
    public void setTrktimstmp(Date val) {
        set(TBTHB12WLRDK.TRKTIMSTMP, val);
    }

    /**
     * �o�^�^�C���X�^���v��Ԃ��܂��B
     * @return String �o�^�^�C���X�^���v
     */
    public Date getTrktimstmp() {
        return (Date) get(TBTHB12WLRDK.TRKTIMSTMP);
    }

    /**
     * �o�^�A�v���h�c��ݒ肵�܂��B
     * @param val String �o�^�A�v���h�c
     */
    public void setTrkpl(String val) {
        set(TBTHB12WLRDK.TRKPL, val);
    }

    /**
     * �o�^�A�v���h�c��Ԃ��܂��B
     * @return String �o�^�A�v���h�c
     */
    public String getTrkpl() {
        return (String) get(TBTHB12WLRDK.TRKPL);
    }

    /**
     * �o�^�S����ݒ肵�܂��B
     * @param val String �o�^�S��
     */
    public void setTrktnt(String val) {
        set(TBTHB12WLRDK.TRKTNT, val);
    }

    /**
     * �o�^�S����Ԃ��܂��B
     * @return String �o�^�S��
     */
    public String getTrktnt() {
        return (String) get(TBTHB12WLRDK.TRKTNT);
    }

    /**
     * �X�V�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �X�V�^�C���X�^���v
     */
    public void setUpdtimstmp(Date val) {
        set(TBTHB12WLRDK.UPDTIMSTMP, val);
    }

    /**
     * �X�V�^�C���X�^���v��Ԃ��܂��B
     * @return String �X�V�^�C���X�^���v
     */
    public Date getUpdtimstmp() {
        return (Date) get(TBTHB12WLRDK.UPDTIMSTMP);
    }

    /**
     * �X�V�A�v����ݒ肵�܂��B
     * @param val String �X�V�A�v��
     */
    public void setUpdakpl(String val) {
        set(TBTHB12WLRDK.UPDAPL, val);
    }

    /**
     * �X�V�A�v����Ԃ��܂��B
     * @return String �X�V�A�v��
     */
    public String getUpdakpl() {
        return (String) get(TBTHB12WLRDK.UPDAPL);
    }

    /**
     * �X�V�S����ݒ肵�܂��B
     * @param val String �X�V�S��
     */
    public void setUpdtnt(String val) {
        set(TBTHB12WLRDK.UPDTNT, val);
    }

    /**
     * �X�V�S����Ԃ��܂��B
     * @return String �X�V�S��
     */
    public String getUpdtnt() {
        return (String) get(TBTHB12WLRDK.UPDTNT);
    }

    /**
     * �c�Ə��R�[�h��ݒ肵�܂��B
     * @param val String �c�Ə��R�[�h
     */
    public void setEgcd(String val) {
        set(TBTHB12WLRDK.EGCD, val);
    }

    /**
     * �c�Ə��R�[�h��Ԃ��܂��B
     * @return String �c�Ə��R�[�h
     */
    public String getEgcd() {
        return (String) get(TBTHB12WLRDK.EGCD);
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setTkskgycd(String val) {
        set(TBTHB12WLRDK.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getTkskgycd() {
        return (String) get(TBTHB12WLRDK.TKSKGYCD);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setTksbmnseqno(String val) {
        set(TBTHB12WLRDK.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ敔��SEQNO
     */
    public String getTksbmnseqno() {
        return (String) get(TBTHB12WLRDK.TKSBMNSEQNO);
    }

    /**
    * ���Ӑ�S��SEQNO��ݒ肵�܂��B
    * @param val String ���Ӑ�S��SEQNO
    */
    public void setTkstntseqno(String val) {
        set(TBTHB12WLRDK.TKSTNTSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ�S��SEQNO
     */
    public String getTkstntseqno() {
        return (String) get(TBTHB12WLRDK.TKSTNTSEQNO);
    }

    /**
     * �����ǃR�[�h��ݒ肵�܂��B
     * @param val String �����ǃR�[�h
     */
    public void setKyokuCd(String val) {
        set(TBTHB12WLRDK.KYOKUCD, val);
    }

    /**
     * �����ǃR�[�h��Ԃ��܂��B
     * @return String �����ǃR�[�h
     */
    public String getKyokuCd() {
        return (String) get(TBTHB12WLRDK.KYOKUCD);
    }

    /**
     * �����ǖ���ݒ肵�܂��B
     * @param val String �����ǖ�
     */
    public void setKyokuName(String val) {
        set(TBTHB12WLRDK.KYOKUNAME, val);
    }

    /**
     * �����ǖ���Ԃ��܂��B
     * @return String �����ǖ�
     */
    public String getKyokuName() {
        return (String) get(TBTHB12WLRDK.KYOKUNAME);
    }

    /**
     * �L���i�����ǃR�[�h�j��ݒ肵�܂��B
     * @param val String �L���i�����ǃR�[�h�j
     */
    public void setKigou(String val) {
        set(TBTHB12WLRDK.KIGOU, val);
    }

    /**
     * �L���i�����ǃR�[�h�j��Ԃ��܂��B
     * @return String �L���i�����ǃR�[�h�j
     */
    public String getKigou() {
        return (String) get(TBTHB12WLRDK.KIGOU);
    }

    /**
     * �n���ݒ肵�܂��B
     * @param val String �n��
     */
    public void setKeiretsu(String val) {
        set(TBTHB12WLRDK.KEIRETSU, val);
    }

    /**
     * �n���Ԃ��܂��B
     * @return String �n��
     */
    public String getKeiretsu() {
        return (String) get(TBTHB12WLRDK.KEIRETSU);
    }
    /**
     * �\������ݒ肵�܂��B
     * @param val String �\����
     */
    public void setHyojijyun(String val) {
        set(TBTHB12WLRDK.HYOJIJYUN, val);
    }

    /**
     * �\������Ԃ��܂��B
     * @return String �\����
     */
    public String getHyojijyun() {
        return (String) get(TBTHB12WLRDK.HYOJIJYUN);
    }

}