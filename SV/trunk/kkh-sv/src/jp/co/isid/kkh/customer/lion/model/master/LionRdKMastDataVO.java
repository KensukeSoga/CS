package jp.co.isid.kkh.customer.lion.model.master;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.integ.tbl.TBTHB12WLRDK;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �}�X�^�f�[�^VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/04 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class LionRdKMastDataVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public LionRdKMastDataVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new LionRdKMastDataVO();
    }

    /**
     * �o�^�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �o�^�^�C���X�^���v
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHB12WLRDK.TRKTIMSTMP, val);
    }

    /**
     * �o�^�^�C���X�^���v��Ԃ��܂��B
     * @return String �o�^�^�C���X�^���v
     */
    @XmlElement(required = true)
    public Date getTrkTimStmp() {
        return (Date) get(TBTHB12WLRDK.TRKTIMSTMP);
    }

    /**
     * �o�^�v���O������ݒ肵�܂��B
     * @param val String �o�^�v���O����
     */
    public void setTrkPl(String val) {
        set(TBTHB12WLRDK.TRKPL, val);
    }

    /**
     * �o�^�v���O������Ԃ��܂��B
     * @return String �o�^�v���O����
     */
    public String getTrkPl() {
        return (String) get(TBTHB12WLRDK.TRKPL);
    }

    /**
     * �o�^�S���҂�ݒ肵�܂��B
     * @param val String �o�^�S����
     */
    public void setTrkTnt(String val) {
        set(TBTHB12WLRDK.TRKTNT, val);
    }

    /**
     * �o�^�S���҂�Ԃ��܂��B
     * @return String �o�^�S����
     */
    public String getTrkTnt() {
        return (String) get(TBTHB12WLRDK.TRKTNT);
    }

    /**
     * �X�V�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �X�V�^�C���X�^���v
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHB12WLRDK.UPDTIMSTMP, val);
    }

    /**
     * �X�V�^�C���X�^���v��Ԃ��܂��B
     * @return String �X�V�^�C���X�^���v
     */
    @XmlElement(required = true)
    public Date getUpdTimStmp() {
        return (Date) get(TBTHB12WLRDK.UPDTIMSTMP);
    }

    /**
     * �X�V�v���O������ݒ肵�܂��B
     * @param val String �X�V�v���O����
     */
    public void setUpdaPl(String val) {
        set(TBTHB12WLRDK.UPDAPL, val);
    }

    /**
     * �X�V�v���O������Ԃ��܂��B
     * @return String �X�V�v���O����
     */
    public String getUpdaPl() {
        return (String) get(TBTHB12WLRDK.UPDAPL);
    }

    /**
     * �X�V�S���҂�ݒ肵�܂��B
     * @param val String �X�V�S����
     */
    public void setUpdTnt(String val) {
        set(TBTHB12WLRDK.UPDTNT   , val);
    }

    /**
     * �X�V�S���҂�Ԃ��܂��B
     * @return String �X�V�S����
     */
    public String getUpdTnt() {
        return (String) get(TBTHB12WLRDK.UPDTNT   );
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
     * @param val String �c�Ə��i��j�R�[�h
     */
    public void setEgCd(String val) {
        set(TBTHB12WLRDK.EGCD, val);
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
     * @return String �c�Ə��i��j�R�[�h
     */
    public String getEgCd() {
        return (String) get(TBTHB12WLRDK.EGCD);
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String val) {
        set(TBTHB12WLRDK.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB12WLRDK.TKSKGYCD);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB12WLRDK.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB12WLRDK.TKSBMNSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB12WLRDK.TKSTNTSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB12WLRDK.TKSTNTSEQNO);
    }

    /**
     * �����ǃR�[�h��ݒ肵�܂��B
     * @param val String KYOKUCD
     */
    public void setKyokuCd(String val) {
        set(TBTHB12WLRDK.KYOKUCD, val);
    }

    /**
     * �����ǃR�[�h��Ԃ��܂��B
     * @return String KYOKUCD
     */
    public String getKyokuCd() {
        return (String) get(TBTHB12WLRDK.KYOKUCD);
    }

    /**
     * �����ǖ���ݒ肵�܂��B
     * @param val String KYOKUNAME
     */
    public void setKyokuName(String val) {
        set(TBTHB12WLRDK.KYOKUNAME, val);
    }

    /**
     * �����ǖ���Ԃ��܂��B
     * @return String KYOKUNAME
     */
    public String getKyokuName() {
        return (String) get(TBTHB12WLRDK.KYOKUNAME);
    }

    /**
     * �L���i�����ǃR�[�h�j��ݒ肵�܂��B
     * @param val String KIGOU
     */
    public void setKigou(String val) {
        set(TBTHB12WLRDK.KIGOU, val);
    }

    /**
     * �L���i�����ǃR�[�h�j��Ԃ��܂��B
     * @return String KIGOU
     */
    public String getKigou() {
        return (String) get(TBTHB12WLRDK.KIGOU);
    }

    /**
     * �n���ݒ肵�܂��B
     * @param val String KEIRETSU
     */
    public void setKeiretsu(String val) {
        set(TBTHB12WLRDK.KEIRETSU, val);
    }

    /**
     * �n���Ԃ��܂��B
     * @return String KEIRETSU
     */
    public String getKeiretsu() {
        return (String) get(TBTHB12WLRDK.KEIRETSU);
    }

    /**
     * �\������ݒ肵�܂��B
     * @param val String HYOJIJYUN
     */
    public void setHyojijyun(String val) {
        set(TBTHB12WLRDK.HYOJIJYUN, val);
    }

    /**
     * �\������Ԃ��܂��B
     * @return String HYOJIJYUN
     */
    public String getHyojijyun() {
        return (String) get(TBTHB12WLRDK.HYOJIJYUN);
    }

}