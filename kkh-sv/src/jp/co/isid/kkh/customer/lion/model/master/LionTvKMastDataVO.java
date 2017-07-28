package jp.co.isid.kkh.customer.lion.model.master;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.integ.tbl.TBTHB11WLTVK;
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
public class LionTvKMastDataVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public LionTvKMastDataVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new LionTvKMastDataVO();
    }

    /**
     * �o�^�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �o�^�^�C���X�^���v
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHB11WLTVK.TRKTIMSTMP, val);
    }

    /**
     * �o�^�^�C���X�^���v��Ԃ��܂��B
     * @return String �o�^�^�C���X�^���v
     */
    @XmlElement(required = true)
    public Date getTrkTimStmp() {
        return (Date) get(TBTHB11WLTVK.TRKTIMSTMP);
    }

    /**
     * �o�^�v���O������ݒ肵�܂��B
     * @param val String �o�^�v���O����
     */
    public void setTrkPl(String val) {
        set(TBTHB11WLTVK.TRKPL, val);
    }

    /**
     * �o�^�v���O������Ԃ��܂��B
     * @return String �o�^�v���O����
     */
    public String getTrkPl() {
        return (String) get(TBTHB11WLTVK.TRKPL);
    }

    /**
     * �o�^�S���҂�ݒ肵�܂��B
     * @param val String �o�^�S����
     */
    public void setTrkTnt(String val) {
        set(TBTHB11WLTVK.TRKTNT, val);
    }

    /**
     * �o�^�S���҂�Ԃ��܂��B
     * @return String �o�^�S����
     */
    public String getTrkTnt() {
        return (String) get(TBTHB11WLTVK.TRKTNT);
    }

    /**
     * �X�V�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �X�V�^�C���X�^���v
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHB11WLTVK.UPDTIMSTMP, val);
    }

    /**
     * �X�V�^�C���X�^���v��Ԃ��܂��B
     * @return String �X�V�^�C���X�^���v
     */
    @XmlElement(required = true)
    public Date getUpdTimStmp() {
        return (Date) get(TBTHB11WLTVK.UPDTIMSTMP);
    }

    /**
     * �X�V�v���O������ݒ肵�܂��B
     * @param val String �X�V�v���O����
     */
    public void setUpdaPl(String val) {
        set(TBTHB11WLTVK.UPDAPL, val);
    }

    /**
     * �X�V�v���O������Ԃ��܂��B
     * @return String �X�V�v���O����
     */
    public String getUpdaPl() {
        return (String) get(TBTHB11WLTVK.UPDAPL);
    }

    /**
     * �X�V�S���҂�ݒ肵�܂��B
     * @param val String �X�V�S����
     */
    public void setUpdTnt(String val) {
        set(TBTHB11WLTVK.UPDTNT   , val);
    }

    /**
     * �X�V�S���҂�Ԃ��܂��B
     * @return String �X�V�S����
     */
    public String getUpdTnt() {
        return (String) get(TBTHB11WLTVK.UPDTNT   );
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
     * @param val String �c�Ə��i��j�R�[�h
     */
    public void setEgCd(String val) {
        set(TBTHB11WLTVK.EGCD, val);
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
     * @return String �c�Ə��i��j�R�[�h
     */
    public String getEgCd() {
        return (String) get(TBTHB11WLTVK.EGCD);
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String val) {
        set(TBTHB11WLTVK.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB11WLTVK.TKSKGYCD);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB11WLTVK.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB11WLTVK.TKSBMNSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB11WLTVK.TKSTNTSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB11WLTVK.TKSTNTSEQNO);
    }

    /**
     * �����ǃR�[�h��ݒ肵�܂��B
     * @param val String KYOKUCD
     */
    public void setKyokuCd(String val) {
        set(TBTHB11WLTVK.KYOKUCD, val);
    }

    /**
     * �����ǃR�[�h��Ԃ��܂��B
     * @return String KYOKUCD
     */
    public String getKyokuCd() {
        return (String) get(TBTHB11WLTVK.KYOKUCD);
    }

    /**
     * �����ǖ���ݒ肵�܂��B
     * @param val String KYOKUNAME
     */
    public void setKyokuName(String val) {
        set(TBTHB11WLTVK.KYOKUNAME, val);
    }

    /**
     * �����ǖ���Ԃ��܂��B
     * @return String KYOKUNAME
     */
    public String getKyokuName() {
        return (String) get(TBTHB11WLTVK.KYOKUNAME);
    }

    /**
     * �L���i�����ǃR�[�h�j��ݒ肵�܂��B
     * @param val String KIGOU
     */
    public void setKigou(String val) {
        set(TBTHB11WLTVK.KIGOU, val);
    }

    /**
     * �L���i�����ǃR�[�h�j��Ԃ��܂��B
     * @return String KIGOU
     */
    public String getKigou() {
        return (String) get(TBTHB11WLTVK.KIGOU);
    }

    /**
     * �n���ݒ肵�܂��B
     * @param val String KEIRETSU
     */
    public void setKeiretsu(String val) {
        set(TBTHB11WLTVK.KEIRETSU, val);
    }

    /**
     * �n���Ԃ��܂��B
     * @return String KEIRETSU
     */
    public String getKeiretsu() {
        return (String) get(TBTHB11WLTVK.KEIRETSU);
    }

    /**
     * �n���ݒ肵�܂��B
     * @param val String TIKU
     */
    public void setTiku(String val) {
        set(TBTHB11WLTVK.TIKU, val);
    }

    /**
     * �n���Ԃ��܂��B
     * @return String TIKU
     */
    public String getTiku() {
        return (String) get(TBTHB11WLTVK.TIKU);
    }

    /**
     * �n��\������ݒ肵�܂��B
     * @param val String THYOJIJYUN
     */
    public void setTHyojiJyun(String val) {
        set(TBTHB11WLTVK.THYOJIJYUN, val);
    }

    /**
     * �n��\������Ԃ��܂��B
     * @return String THYOJIJYUN
     */
    public String getTHyojiJyun() {
        return (String) get(TBTHB11WLTVK.THYOJIJYUN);
    }

    /**
     * �\������ݒ肵�܂��B
     * @param val String HYOJIJYUN
     */
    public void setHyojijyun(String val) {
        set(TBTHB11WLTVK.HYOJIJYUN, val);
    }

    /**
     * �\������Ԃ��܂��B
     * @return String HYOJIJYUN
     */
    public String getHyojijyun() {
        return (String) get(TBTHB11WLTVK.HYOJIJYUN);
    }

}