package jp.co.isid.kkh.customer.lion.model.master;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import jp.co.isid.kkh.integ.tbl.TBTHB9WLTVB;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �}�X�^�f�[�^VO�iINSERT�p�j
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/11 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class LionTvMastDataInsertVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public LionTvMastDataInsertVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new LionTvMastDataInsertVO();
    }

    public void SetData(String culumname, Object val){
        set(culumname, val);
    }

    /**
     * �o�^�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �o�^�^�C���X�^���v
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHB9WLTVB.TRKTIMSTMP, val);
    }

    /**
     * �o�^�^�C���X�^���v��Ԃ��܂��B
     * @return String �o�^�^�C���X�^���v
     */
    @XmlElement(required = true)
    public Date getTrkTimStmp() {
        return (Date) get(TBTHB9WLTVB.TRKTIMSTMP);
    }

    /**
     * �o�^�v���O������ݒ肵�܂��B
     * @param val String �o�^�v���O����
     */
    public void setTrkPl(String val) {
        set(TBTHB9WLTVB.TRKPL, val);
    }

    /**
     * �o�^�v���O������Ԃ��܂��B
     * @return String �o�^�v���O����
     */
    public String getTrkPl() {
        return (String) get(TBTHB9WLTVB.TRKPL);
    }

    /**
     * �o�^�S���҂�ݒ肵�܂��B
     * @param val String �o�^�S����
     */
    public void setTrkTnt(String val) {
        set(TBTHB9WLTVB.TRKTNT, val);
    }

    /**
     * �o�^�S���҂�Ԃ��܂��B
     * @return String �o�^�S����
     */
    public String getTrkTnt() {
        return (String) get(TBTHB9WLTVB.TRKTNT);
    }

    /**
     * �X�V�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �X�V�^�C���X�^���v
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHB9WLTVB.UPDTIMSTMP, val);
    }

    /**
     * �X�V�^�C���X�^���v��Ԃ��܂��B
     * @return String �X�V�^�C���X�^���v
     */
    @XmlElement(required = true)
    public Date getUpdTimStmp() {
        return (Date) get(TBTHB9WLTVB.UPDTIMSTMP);
    }

    /**
     * �X�V�v���O������ݒ肵�܂��B
     * @param val String �X�V�v���O����
     */
    public void setUpdaPl(String val) {
        set(TBTHB9WLTVB.UPDAPL, val);
    }

    /**
     * �X�V�v���O������Ԃ��܂��B
     * @return String �X�V�v���O����
     */
    public String getUpdaPl() {
        return (String) get(TBTHB9WLTVB.UPDAPL);
    }

    /**
     * �X�V�S���҂�ݒ肵�܂��B
     * @param val String �X�V�S����
     */
    public void setUpdTnt(String val) {
        set(TBTHB9WLTVB.UPDTNT   , val);
    }

    /**
     * �X�V�S���҂�Ԃ��܂��B
     * @return String �X�V�S����
     */
    public String getUpdTnt() {
        return (String) get(TBTHB9WLTVB.UPDTNT   );
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
     * @param val String �c�Ə��i��j�R�[�h
     */
    public void setEgCd(String val) {
        set(TBTHB9WLTVB.EGCD, val);
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
     * @return String �c�Ə��i��j�R�[�h
     */
    public String getEgCd() {
        return (String) get(TBTHB9WLTVB.EGCD);
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String val) {
        set(TBTHB9WLTVB.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB9WLTVB.TKSKGYCD);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB9WLTVB.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB9WLTVB.TKSBMNSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB9WLTVB.TKSTNTSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB9WLTVB.TKSTNTSEQNO);
    }

    /**
     * BANCD��ݒ肵�܂��B
     * @param val String BANCD
     */
    public void setBanCd(String val) {
        set(TBTHB9WLTVB.BANCD, val);
    }

    /**
     * BANCD��Ԃ��܂��B
     * @return String BANCD
     */
    public String getBanCd() {
        return (String) get(TBTHB9WLTVB.BANCD);
    }

    /**
     * BANNM��ݒ肵�܂��B
     * @param val String BANNM
     */
    public void setBanName(String val) {
        set(TBTHB9WLTVB.BANNAME, val);
    }

    /**
     * BANNM��Ԃ��܂��B
     * @return String BANNM
     */
    public String getBanName() {
        return (String) get(TBTHB9WLTVB.BANNAME);
    }

    /**
     * HKYOKUCD��ݒ肵�܂��B
     * @param val String HKYOKUCD
     */
    public void setHkyokuCd(String val) {
        set(TBTHB9WLTVB.HKYOKUCD, val);
    }

    /**
     * HKYOKUCD��Ԃ��܂��B
     * @return String HKYOKUCD
     */
    public String getHkyokuCd() {
        return (String) get(TBTHB9WLTVB.HKYOKUCD);
    }

    /**
     * SEISAKUHI��ݒ肵�܂��B
     * @param val String SEISAKUHI
     */
    public void setSeisakuhi(String val) {
        set(TBTHB9WLTVB.SEISAKUHI, val);
    }

    /**
     * SEISAKUHI��Ԃ��܂��B
     * @return String SEISAKUHI
     */
    public String getSeisakuhi() {
        return (String) get(TBTHB9WLTVB.SEISAKUHI);
    }


    /**
     * HYOJIJYUN��ݒ肵�܂��B
     * @param val String HYOJIJYUN
     */
    public void setHyojijyun(String val) {
        set(TBTHB9WLTVB.HYOJIJYUN, val);
    }

    /**
     * HYOJIJYUN��Ԃ��܂��B
     * @return String HYOJIJYUN
     */
    public String getHyojijyun() {
        return (String) get(TBTHB9WLTVB.HYOJIJYUN);
    }

    /**
     * TANKA��ݒ肵�܂��B
     * @param val String Tanka
     */
    public void setTanka(String val) {
        set(TBTHB9WLTVB.TANKA, val);
    }

    /**
     * TANKA��Ԃ��܂��B
     * @return String Tanka
     */
    public String getTanka() {
        return (String) get(TBTHB9WLTVB.TANKA);
    }

    /**
     * TYPE2��ݒ肵�܂��B
     * @param val String TYPE2
     */
    public void setType2(String val) {
        set(TBTHB9WLTVB.TYPE2, val);
    }

    /**
     * TYPE2��Ԃ��܂��B
     * @return String TYPE2
     */
    public String getType2() {
        return (String) get(TBTHB9WLTVB.TYPE2);
    }

}