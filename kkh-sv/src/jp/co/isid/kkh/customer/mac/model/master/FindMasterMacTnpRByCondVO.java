package jp.co.isid.kkh.customer.mac.model.master;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.integ.tbl.TBTHB17RMTNP;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �}�N�h�i���h�X�܃}�X�^�����e�[�u��VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 * @author
 */
@XmlRootElement(namespace = "http://master.model.mac.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://master.model.mac.customer.kkh.isid.co.jp/")
public class FindMasterMacTnpRByCondVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindMasterMacTnpRByCondVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindMasterMacTnpRByCondVO();
    }

    /**
     * �o�^�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �o�^�^�C���X�^���v
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHB17RMTNP.TRKTIMSTMP, val);
    }

    /**
     * �o�^�^�C���X�^���v��Ԃ��܂��B
     * @return String �o�^�^�C���X�^���v
     */
    @XmlElement(required = true)
    public Date getTrkTimStmp() {
        return (Date) get(TBTHB17RMTNP.TRKTIMSTMP);
    }

    /**
     * �o�^�v���O������ݒ肵�܂��B
     * @param val String �o�^�v���O����
     */
    public void setTrkPl(String val) {
        set(TBTHB17RMTNP.TRKPL, val);
    }

    /**
     * �o�^�v���O������Ԃ��܂��B
     * @return String �o�^�v���O����
     */
    public String getTrkPl() {
        return (String) get(TBTHB17RMTNP.TRKPL);
    }

    /**
     * �o�^�S���҂�ݒ肵�܂��B
     * @param val String �o�^�S����
     */
    public void setTrkTnt(String val) {
        set(TBTHB17RMTNP.TRKTNT, val);
    }

    /**
     * �o�^�S���҂�Ԃ��܂��B
     * @return String �o�^�S����
     */
    public String getTrkTnt() {
        return (String) get(TBTHB17RMTNP.TRKTNT);
    }

    /**
     * �X�V�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �X�V�^�C���X�^���v
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHB17RMTNP.UPDTIMSTMP, val);
    }

    /**
     * �X�V�^�C���X�^���v��Ԃ��܂��B
     * @return String �X�V�^�C���X�^���v
     */
    @XmlElement(required = true)
    public Date getUpdTimStmp() {
        return (Date) get(TBTHB17RMTNP.UPDTIMSTMP);
    }

    /**
     * �X�V�v���O������ݒ肵�܂��B
     * @param val String �X�V�v���O����
     */
    public void setUpdaPl(String val) {
        set(TBTHB17RMTNP.UPDAPL, val);
    }

    /**
     * �X�V�v���O������Ԃ��܂��B
     * @return String �X�V�v���O����
     */
    public String getUpdaPl() {
        return (String) get(TBTHB17RMTNP.UPDAPL);
    }

    /**
     * �X�V�S���҂�ݒ肵�܂��B
     * @param val String �X�V�S����
     */
    public void setUpdTnt(String val) {
        set(TBTHB17RMTNP.UPDTNT   , val);
    }

    /**
     * �X�V�S���҂�Ԃ��܂��B
     * @return String �X�V�S����
     */
    public String getUpdTnt() {
        return (String) get(TBTHB17RMTNP.UPDTNT   );
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
     * @param val String �c�Ə��i��j�R�[�h
     */
    public void setEgCd(String val) {
        set(TBTHB17RMTNP.EGCD, val);
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
     * @return String �c�Ə��i��j�R�[�h
     */
    public String getEgCd() {
        return (String) get(TBTHB17RMTNP.EGCD);
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String val) {
        set(TBTHB17RMTNP.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB17RMTNP.TKSKGYCD);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB17RMTNP.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB17RMTNP.TKSBMNSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB17RMTNP.TKSTNTSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB17RMTNP.TKSTNTSEQNO);
    }

    /**
     * �X�܃R�[�h��ݒ肵�܂��B
     *
     * @param val String �X�܃R�[�h
     */
    public void setTenpoCd(String val) {
        set(TBTHB17RMTNP.TENPOCD, val);
    }

    /**
     * �X�܃R�[�h��Ԃ��܂��B
     *
     * @return String �X�܃R�[�h
     */
    public String getTenpoCd() {
        return (String) get(TBTHB17RMTNP.TENPOCD);
    }

    /**
     * �X�ܖ���ݒ肵�܂��B
     *
     * @param val String �X�ܖ�
     */
    public void setTenpoNm(String val) {
        set(TBTHB17RMTNP.TENPONM, val);
    }

    /**
     * �X�ܖ���Ԃ��܂��B
     *
     * @return String �X�ܖ�
     */
    public String getTenpoNm() {
        return (String) get(TBTHB17RMTNP.TENPONM);
    }

    /**
     * �e���g���[��ݒ肵�܂��B
     *
     * @param val String �e���g���[
     */
    public void setTerritory(String val) {
        set(TBTHB17RMTNP.TERRITORY, val);
    }

    /**
     * �e���g���[��Ԃ��܂��B
     *
     * @return String �e���g���[
     */
    public String getTerritory() {
        return (String) get(TBTHB17RMTNP.TERRITORY);
    }

    /**
     * �X�܋敪��ݒ肵�܂��B
     *
     * @param val String �X�܋敪
     */
    public void setTenpoKbn(String val) {
        set(TBTHB17RMTNP.TENPOKBN, val);
    }

    /**
     * �X�܋敪��Ԃ��܂��B
     *
     * @return String �X�܋敪
     */
    public String getTenpoKbn() {
        return (String) get(TBTHB17RMTNP.TENPOKBN);
    }

    /**
     * ����Ȗڂ�ݒ肵�܂��B
     *
     * @param val String ����Ȗ�
     */
    public void setKamoku(String val) {
        set(TBTHB17RMTNP.KAMOKU, val);
    }

    /**
     * ����Ȗڂ�Ԃ��܂��B
     *
     * @return String ����Ȗ�
     */
    public String getKamoku() {
        return (String) get(TBTHB17RMTNP.KAMOKU);
    }

    /**
     * �X�֔ԍ���ݒ肵�܂��B
     *
     * @param val String �X�֔ԍ�
     */
    public void setYubinNo(String val) {
        set(TBTHB17RMTNP.YUBINNO, val);
    }

    /**
     * �X�֔ԍ���Ԃ��܂��B
     *
     * @return String �X�֔ԍ�
     */
    public String getYubinNo() {
        return (String) get(TBTHB17RMTNP.YUBINNO);
    }

    /**
     * �Z���P��ݒ肵�܂��B
     *
     * @param val String �Z���P
     */
    public void setAddress1(String val) {
        set(TBTHB17RMTNP.ADDRESS1, val);
    }

    /**
     * �Z���P��Ԃ��܂��B
     *
     * @return String �Z���P
     */
    public String getAddress1() {
        return (String) get(TBTHB17RMTNP.ADDRESS1);
    }

    /**
     * �Z���Q��ݒ肵�܂��B
     *
     * @param val String �Z���Q
     */
    public void setAddress2(String val) {
        set(TBTHB17RMTNP.ADDRESS2, val);
    }

    /**
     * �Z���Q��Ԃ��܂��B
     *
     * @return String �Z���Q
     */
    public String getAddress2() {
        return (String) get(TBTHB17RMTNP.ADDRESS2);
    }

    /**
     * �d�b�ԍ���ݒ肵�܂��B
     *
     * @param val String �d�b�ԍ�
     */
    public void setTelNo(String val) {
        set(TBTHB17RMTNP.TELNO, val);
    }

    /**
     * �d�b�ԍ���Ԃ��܂��B
     *
     * @return String �d�b�ԍ�
     */
    public String getTelNo() {
        return (String) get(TBTHB17RMTNP.TELNO);
    }

    /**
     * ���׍s�t���O��ݒ肵�܂��B
     *
     * @param val String ���׍s�t���O
     */
    public void setSplitFlg(String val) {
        set(TBTHB17RMTNP.SPLITFLG, val);
    }

    /**
     * ���׍s�t���O��Ԃ��܂��B
     *
     * @return String ���׍s�t���O
     */
    public String getSplitFlg() {
        return (String) get(TBTHB17RMTNP.SPLITFLG);
    }

    /**
     * ���C�Z���V�[�Ж���ݒ肵�܂��B
     *
     * @param val String ���C�Z���V�[�Ж�
     */
    public void setCompanyNm(String val) {
        set(TBTHB17RMTNP.COMPANYNM, val);
    }

    /**
     * ���C�Z���V�[�Ж���Ԃ��܂��B
     *
     * @return String ���C�Z���V�[�Ж�
     */
    public String getCompanyNm() {
        return (String) get(TBTHB17RMTNP.COMPANYNM);
    }

    /**
     * ��\�Җ���ݒ肵�܂��B
     *
     * @param val String ��\�Җ�
     */
    public void setName(String val) {
        set(TBTHB17RMTNP.NAME, val);
    }

    /**
     * ��\�Җ���Ԃ��܂��B
     *
     * @return String ��\�Җ�
     */
    public String getName() {
        return (String) get(TBTHB17RMTNP.NAME);
    }

    /**
     * �����R�[�h��ݒ肵�܂��B
     *
     * @param val String �����R�[�h
     */
    public void setTorihikiCd(String val) {
        set(TBTHB17RMTNP.TORIHIKICD, val);
    }

    /**
     * �����R�[�h��Ԃ��܂��B
     *
     * @return String �����R�[�h
     */
    public String getTorihikiCd() {
        return (String) get(TBTHB17RMTNP.TORIHIKICD);
    }

    /**
     * �X�e�[�^�X��ݒ肵�܂��B
     *
     * @param val String �X�e�[�^�X
     */
    public void setInStatus(String val) {
        set(TBTHB17RMTNP.INSTATUS, val);
    }

    /**
     * �X�e�[�^�X��Ԃ��܂��B
     *
     * @return String �X�e�[�^�X
     */
    public String getInStatus() {
        return (String) get(TBTHB17RMTNP.INSTATUS);
    }

    /**
     * ����G.OPEN�N������ݒ肵�܂��B
     *
     * @param val String ����G.OPEN�N����
     */
    public void setSGOpen(String val) {
        set(TBTHB17RMTNP.SGOPEN, val);
    }

    /**
     * ����G.OPEN�N������Ԃ��܂��B
     *
     * @return String ����G.OPEN�N����
     */
    public String getSGOpen() {
        return (String) get(TBTHB17RMTNP.SGOPEN);
    }

    /**
     * G.OPEN�N������ݒ肵�܂��B
     *
     * @param val String G.OPEN�N����
     */
    public void setGOpen(String val) {
        set(TBTHB17RMTNP.GOPEN, val);
    }

    /**
     * G.OPEN�N������Ԃ��܂��B
     *
     * @return String G.OPEN�N����
     */
    public String getGOpen() {
        return (String) get(TBTHB17RMTNP.GOPEN);
    }

    /**
     * G.CLOSE�N������ݒ肵�܂��B
     *
     * @param val String G.CLOSE�N����
     */
    public void setGClose(String val) {
        set(TBTHB17RMTNP.GCLOSE, val);
    }

    /**
     * G.CLOSE�N������Ԃ��܂��B
     *
     * @return String G.CLOSE�N����
     */
    public String getGClose() {
        return (String) get(TBTHB17RMTNP.GCLOSE);
    }

    /**
     * �X�V���{�L�[��ݒ肵�܂��B
     *
     * @param val String �X�V���{�L�[
     */
    public void setUpdRrkTimstmp(String val) {
        set(TBTHB17RMTNP.UPDRRKTIMSTMP, val);
    }

    /**
     * �X�V���{�L�[��Ԃ��܂��B
     *
     * @return String �X�V���{�L�[
     */
    public String getUpdRrkTimstmp() {
        return (String) get(TBTHB17RMTNP.UPDRRKTIMSTMP);
    }

    /**
     * ��荞�ݍX�V�t���O��ݒ肵�܂��B
     *
     * @param val String ��荞�ݍX�V�t���O
     */
    public void setTorikomiFlg(String val) {
        set(TBTHB17RMTNP.TORIKOMIFLG, val);
    }

    /**
     * ��荞�ݍX�V�t���O��Ԃ��܂��B
     *
     * @return String ��荞�ݍX�V�t���O
     */
    public String getTorikomiFlg() {
        return (String) get(TBTHB17RMTNP.TORIKOMIFLG);
    }

    /**
     * ������ʂ�ݒ肵�܂��B
     *
     * @param val String �������
     */
    public void setRrkSybt(String val) {
        set(TBTHB17RMTNP.RRKSYBT, val);
    }

    /**
     * ������ʂ�Ԃ��܂��B
     *
     * @return String �������
     */
    public String getRrkSybt() {
        return (String) get(TBTHB17RMTNP.RRKSYBT);
    }

}
