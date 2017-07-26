package jp.co.isid.kkh.customer.acom.model.claim;


import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
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
public class FindClaimCondVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindClaimCondVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindClaimCondVO();
    }

    /**
     * �^�C���X�^���v���擾����
     * @return �^�C���X�^���v
     */
    public String getTimStmp() {
        return (String) get(TBTHB2KMEI.TIMSTMP);
    }

    /**
     * �^�C���X�^���v��ݒ肷��
     * @param val �^�C���X�^���v
     */
    public void setTimStmp(String val) {
        set(TBTHB2KMEI.TIMSTMP, val);
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
     * �˗��s�ԍ��i�����s�ԍ��j���擾����
     * @return �˗��s�ԍ��i�����s�ԍ��j
     */
    public String getIraiGyoNo() {
        return (String) get(TBTHB2KMEI.CODE4);
    }

    /**
     * �˗��s�ԍ��i�����s�ԍ��j��ݒ肷��
     * @param val �˗��s�ԍ��i�����s�ԍ��j
     */
    public void setIraiGyoNo(String val) {
        set(TBTHB2KMEI.CODE4, val);
    }

    /**
     * �����R�[�h���擾����
     * @return �����R�[�h
     */
    public String getToriCd() {
        return (String) get(TBTHB2KMEI.SONOTA5);
    }

    /**
     * �����R�[�h��ݒ肷��
     * @param val �����R�[�h
     */
    public void setToriCd(String val) {
        set(TBTHB2KMEI.SONOTA5, val);
    }

    /**
     * ��Ж����擾����
     * @return ��Ж�
     */
    public String getKaiNm() {
        return (String) get(TBTHB2KMEI.NAME2);
    }

    /**
     * ��Ж���ݒ肷��
     * @param val ��Ж�
     */
    public void setKaiNm(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * ���������R�[�h���擾����
     * @return ���������R�[�h
     */
    public String getSeibuCd() {
        return (String) get(TBTHB2KMEI.CODE5);
    }

    /**
     * ���������R�[�h��ݒ肷��
     * @param val ���������R�[�h
     */
    public void setSeibuCd(String val) {
        set(TBTHB2KMEI.CODE5, val);
    }

    /**
     * �����N�������擾����
     * @return �����N����
     */
    public String getSeiYymm() {
        return (String) get(TBTHB2KMEI.DATE1);
    }

    /**
     * �����N������ݒ肷��
     * @param val �����N����
     */
    public void setSeiYymm(String val) {
        set(TBTHB2KMEI.DATE1, val);
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
     * �������s�ԍ����擾����
     * @return �������s�ԍ�
     */
    public String getSeiGyoNo() {
        return (String) get(TBTHB2KMEI.SONOTA2);
    }

    /**
     * �������s�ԍ���ݒ肷��
     * @param val �������s�ԍ�
     */
    public void setSeiGyoNo(String val) {
        set(TBTHB2KMEI.SONOTA2, val);
    }

    /**
     * �x�������擾����
     * @return �x����
     */
    public String getPayDay() {
        return (String) get(TBTHB2KMEI.DATE2);
    }

    /**
     * �x������ݒ肷��
     * @param val �x����
     */
    public void setPayDay(String val) {
        set(TBTHB2KMEI.DATE2, val);
    }

    /**
     * ���i�敪���擾����
     * @return ���i�敪
     */
    public String getSyohinKbn() {
        return (String) get(TBTHB2KMEI.SONOTA3);
    }

    /**
     * ���i�敪��ݒ肷��
     * @param val ���i�敪
     */
    public void setSyohinKbn(String val) {
        set(TBTHB2KMEI.SONOTA3, val);
    }

    /**
     * ���i�敪���̂��擾����
     * @return ���i�敪����
     */
    public String getSyohinKbnNm() {
        return (String) get(TBTHB2KMEI.NAME1);
    }

    /**
     * ���i�敪���̂�ݒ肷��
     * @param val ���i�敪����
     */
    public void setSyohinKbnNm(String val) {
        set(TBTHB2KMEI.NAME1, val);
    }

    /**
     * �E�v�R�[�h���擾����
     * @return �E�v�R�[�h
     */
    public String getTekiyoCd() {
        return (String) get(TBTHB2KMEI.CODE6);
    }

    /**
     * �E�v�R�[�h��ݒ肷��
     * @param val �E�v�R�[�h
     */
    public void setTekiyoCd(String val) {
        set(TBTHB2KMEI.CODE6, val);
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
     * ���f�B�A�R�[�h���擾����
     * @return ���f�B�A�R�[�h
     */
    public String getMediaCd() {
        return (String) get(TBTHB2KMEI.CODE2);
    }

    /**
     * ���f�B�A�R�[�h��ݒ肷��
     * @param val ���f�B�A�R�[�h
     */
    public void setMediaCd(String val) {
        set(TBTHB2KMEI.CODE2, val);
    }

    /**
     * �X�Ԃ��擾����
     * @return �X��
     */
    public String getTenBan() {
        return (String) get(TBTHB2KMEI.SONOTA4);
    }

    /**
     * �X�Ԃ�ݒ肷��
     * @param val �X��
     */
    public void setTenBan(String val) {
        set(TBTHB2KMEI.SONOTA4, val);
    }

    /**
     * ���z���擾����
     * @return ���z
     */
    public BigDecimal getKingaku() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * ���z��ݒ肷��
     * @param val ���z
     */
    public void setKingaku(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * ����ł��擾����
     * @return �����
     */
    public BigDecimal getShohiZei() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

    /**
     * ����ł�ݒ肷��
     * @param val �����
     */
    public void setShohiZei(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * ����ʂ��擾����
     * @return �����
     */
    public String getAnbunSybt() {
        return (String) get(TBTHB2KMEI.MEIHNFLG);
    }

    /**
     * ����ʂ�ݒ肷��
     * @param val �����
     */
    public void setAnbunSybt(String val) {
        set(TBTHB2KMEI.MEIHNFLG, val);
    }

    /**
     * �敪���擾����
     * @return �敪
     */
    public String getKbn() {
        return (String) get(TBTHB2KMEI.SONOTA6);
    }

    /**
     * �敪��ݒ肷��
     * @param val �敪
     */
    public void setKbn(String val) {
        set(TBTHB2KMEI.SONOTA6, val);
    }

    /**
     * �f�ړ��i�V���E�G���j���擾����
     * @return �f�ړ��i�V���E�G���j
     */
    public String getKeisaiDay() {
        return (String) get(TBTHB2KMEI.SONOTA9);
    }

    /**
     * �f�ړ��i�V���E�G���j��ݒ肷��
     * @param val �f�ړ��i�V���E�G���j
     */
    public void setKeisaiDay(String val) {
        set(TBTHB2KMEI.SONOTA9, val);
    }

    /**
     * �������ԁi�X�|�b�g�j���擾����
     * @return �������ԁi�X�|�b�g�j
     */
    public String getKikanSpot() {
        return (String) get(TBTHB1DOWN.FIELD4);
    }

    /**
     * �������ԁi�X�|�b�g�j��ݒ肷��
     * @param val �������ԁi�X�|�b�g�j
     */
    public void setKikanSpot(String val) {
        set(TBTHB1DOWN.FIELD4, val);
    }

    /**
     * �������ԁi�^�C���j���擾����
     * @return �������ԁi�^�C���j
     */
    public String getKikanTime() {
        return (String) get(TBTHB1DOWN.FIELD8);
    }

    /**
     * �������ԁi�^�C���j��ݒ肷��
     * @param val �������ԁi�^�C���j
     */
    public void setKikanTime(String val) {
        set(TBTHB1DOWN.FIELD8, val);
    }

    /**
     * �X�y�[�X�i�G���j���擾����
     * @return �X�y�[�X�i�G���j
     */
    public String getSpaceZasi() {
        return (String) get(TBTHB1DOWN.FIELD9);
    }

    /**
     * �X�y�[�X�i�G���j��ݒ肷��
     * @param val �X�y�[�X�i�G���j
     */
    public void setSpaceZasi(String val) {
        set(TBTHB1DOWN.FIELD9, val);
    }

    /**
     * �X�y�[�X�i�V���j���擾����
     * @return �X�y�[�X�i�V���j
     */
    public String getSpaceSnbn() {
        return (String) get(TBTHB1DOWN.FIELD11);
    }

    /**
     * �X�y�[�X�i�V���j��ݒ肷��
     * @param val �X�y�[�X�i�V���j
     */
    public void setSpaceSnbn(String val) {
        set(TBTHB1DOWN.FIELD11, val);
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
     * �l�������擾����
     * @return �l����
     */
    public BigDecimal getNebiRitu() {
        return (BigDecimal) get(TBTHB2KMEI.HNNERT);
    }

    /**
     * �l������ݒ肷��
     * @param val �l����
     */
    public void setNebiRitu(BigDecimal val) {
        set(TBTHB2KMEI.HNNERT, val);
    }

    /**
     * �l���z���擾����
     * @return �l���z
     */
    public BigDecimal getNebiGaku() {
        return (BigDecimal) get(TBTHB2KMEI.NEBIGAK);
    }

    /**
     * �l���z��ݒ肷��
     * @param val �l���z
     */
    public void setNebiGaku(BigDecimal val) {
        set(TBTHB2KMEI.NEBIGAK, val);
    }

    /**
     * ����ŗ����擾����
     * @return ����ŗ�
     */
    public BigDecimal getSyohiRitu() {
        return (BigDecimal) get(TBTHB2KMEI.RITU1);
    }

    /**
     * ����ŗ���ݒ肷��
     * @param val ����ŗ�
     */
    public void setSyohiRitu(BigDecimal val) {
        set(TBTHB2KMEI.RITU1, val);
    }

    /**
     * ��NO.���擾����
     * @return ��NO.
     */
    public String getJyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * ��NO.��ݒ肷��
     * @param val ��NO.
     */
    public void setJyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * �^�C���E�X�|�b�g�敪���擾����
     * @return �^�C���E�X�|�b�g�敪
     */
    public String getTmSpKbn() {
        return (String) get(TBTHB1DOWN.TMSPKBN);
    }

    /**
     * �^�C���E�X�|�b�g�敪��ݒ肷��
     * @param val �^�C���E�X�|�b�g�敪
     */
    public void setTmSpKbn(String val) {
        set(TBTHB1DOWN.TMSPKBN, val);
    }

    /**
     * ���ۋ敪���擾����
     * @return ���ۋ敪
     */
    public String getKokKbn() {
        return (String) get(TBTHB1DOWN.KOKKBN);
    }

    /**
     * ���ۋ敪��ݒ肷��
     * @param val ���ۋ敪
     */
    public void setKokKbn(String val) {
        set(TBTHB1DOWN.KOKKBN, val);
    }

    /**
     * �o�^�N�������擾����
     * @return �o�^�N����
     */
    public String getTouDate() {
        return (String) get(TBTHB2KMEI.DATE3);
    }

    /**
     * �o�^�N������ݒ肷��
     * @param val �o�^�N����
     */
    public void setTouDate(String val) {
        set(TBTHB2KMEI.DATE3, val);
    }

    /**
     * �ύX�N�������擾����
     * @return �ύX�N����
     */
    public String getHenDate() {
        return (String) get(TBTHB2KMEI.DATE4);
    }

    /**
     * �ύX�N������ݒ肷��
     * @param val �ύX�N����
     */
    public void setHenDate(String val) {
        set(TBTHB2KMEI.DATE4, val);
    }

    /**
     * ����N�������擾����
     * @return ����N����
     */
    public String getTorDate() {
        return (String) get(TBTHB2KMEI.DATE5);
    }

    /**
     * ����N������ݒ肷��
     * @param val ����N����
     */
    public void setTorDate(String val) {
        set(TBTHB2KMEI.DATE5, val);
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
     * �����敪���擾����
     * @return �����敪
     */
    public String getShoriKbn() {
        return (String) get(TBTHB2KMEI.KBN1);
    }

    /**
     * �����敪��ݒ肷��
     * @param val �����敪
     */
    public void setShoriKbn(String val) {
        set(TBTHB2KMEI.KBN1, val);
    }

    /**
     * �o�͓������擾����
     * @return �o�͓���
     */
    public String getOutDate() {
        return (String) get(TBTHB2KMEI.NAME7);
    }

    /**
     * �o�͓�����ݒ肷��
     * @param val �o�͓���
     */
    public void setOutDate(String val) {
        set(TBTHB2KMEI.NAME7, val);
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

    /**
     * �f�ڒP�����擾����
     * @return �f�ڒP��
     */
    public String getKeisaiTnk() {
        return (String) get(TBTHB2KMEI.SONOTA7);
    }

    /**
     * �f�ڒP����ݒ肷��
     * @param val �f�ڒP��
     */
    public void setKeisaiTnk(String val) {
        set(TBTHB2KMEI.SONOTA7, val);
    }

    /**
     * ����11(����)���擾����
     * @return ����11(����)
     */
    public String getName11() {
        return (String) get(TBTHB2KMEI.NAME11);
    }

    /**
     * ����11(����)��ݒ肷��
     * @param val ����11(����)
     */
    public void setName11(String val) {
        set(TBTHB2KMEI.NAME11, val);
    }

    /**
     * ����12(����)���擾����
     * @return ����12(����)
     */
    public String getName12() {
        return (String) get(TBTHB2KMEI.NAME12);
    }

    /**
     * ����12(����)��ݒ肷��
     * @param val ����12(����)
     */
    public void setName12(String val) {
        set(TBTHB2KMEI.NAME12, val);
    }

    /**
     * ����13(����)���擾����
     * @return ����13(����)
     */
    public String getName13() {
        return (String) get(TBTHB2KMEI.NAME13);
    }

    /**
     * ����13(����)��ݒ肷��
     * @param val ����13(����)
     */
    public void setName13(String val) {
        set(TBTHB2KMEI.NAME13, val);
    }

    /**
     * ����14(����)���擾����
     * @return ����14(����)
     */
    public String getName14() {
        return (String) get(TBTHB2KMEI.NAME14);
    }

    /**
     * ����14(����)��ݒ肷��
     * @param val ����14(����)
     */
    public void setName14(String val) {
        set(TBTHB2KMEI.NAME14, val);
    }

    /**
     * ����15(����)���擾����
     * @return ����15(����)
     */
    public String getName15() {
        return (String) get(TBTHB2KMEI.NAME15);
    }

    /**
     * ����15(����)��ݒ肷��
     * @param val ����15(����)
     */
    public void setName15(String val) {
        set(TBTHB2KMEI.NAME15, val);
    }

    /**
     * ����16(����)���擾����
     * @return ����16(����)
     */
    public String getName16() {
        return (String) get(TBTHB2KMEI.NAME16);
    }

    /**
     * ����16(����)��ݒ肷��
     * @param val ����16(����)
     */
    public void setName16(String val) {
        set(TBTHB2KMEI.NAME16, val);
    }

    /**
     * ����17(����)���擾����
     * @return ����17(����)
     */
    public String getName17() {
        return (String) get(TBTHB2KMEI.NAME17);
    }

    /**
     * ����17(����)��ݒ肷��
     * @param val ����17(����)
     */
    public void setName17(String val) {
        set(TBTHB2KMEI.NAME17, val);
    }

    /**
     * �l���s�敪���擾����
     * @return �l���s�敪
     */
    public String getNebiKbn() {
        return (String) get(TBTHB2KMEI.KBN2);
    }

    /**
     * �l���s�敪��ݒ肷��
     * @param val �l���s�敪
     */
    public void setNebiKbn(String val) {
        set(TBTHB2KMEI.KBN2, val);
    }

    /**
     * �זڋ敪���擾����
     * @return �זڋ敪
     */
    public String getSaimokuKbn() {
        return (String) get(TBTHB5HIK.SAIKBN);
    }

    /**
     * �זڋ敪��ݒ肷��
     * @param val �זڋ敪
     */
    public void setSaimokuKbn(String val) {
        set(TBTHB5HIK.SAIKBN, val);
    }

    /**
     * ���f�B�A�����擾����
     * @return ���f�B�A��
     */
    public String getMediaNm() {
        return (String) get(FindClaimByCondDAO.MEDIA_NM);
    }

    /**
     * ���f�B�A����ݒ肷��
     * @param val ���f�B�A��
     */
    public void setMediaNm(String val) {
        set(FindClaimByCondDAO.MEDIA_NM, val);
    }

    /**
     * �V��_�f�ڏꏊ���̂��擾����
     * @return �V��_�f�ڏꏊ����
     */
    public String getSnbn_KeiBasNm() {
        return (String) get(FindClaimByCondDAO.SNBN_KEIBAS_NM);
    }

    /**
     * �V��_�f�ڏꏊ���̂�ݒ肷��
     * @param val �V��_�f�ڏꏊ����
     */
    public void setSnbn_KeiBasNm(String val) {
        set(FindClaimByCondDAO.SNBN_KEIBAS_NM, val);
    }

    /**
     * �V��_���1���̂��擾����
     * @return �V��_���1����
     */
    public String getSnbn_Sybt1Nm() {
        return (String) get(FindClaimByCondDAO.SNBN_SYBT1_NM);
    }

    /**
     * �V��_���1���̂�ݒ肷��
     * @param val �V��_���1����
     */
    public void setSnbn_Sybt1Nm(String val) {
        set(FindClaimByCondDAO.SNBN_SYBT1_NM, val);
    }

    /**
     * �V��_���2���̂��擾����
     * @return �V��_���2����
     */
    public String getSnbn_Sybt2Nm() {
        return (String) get(FindClaimByCondDAO.SNBN_SYBT2_NM);
    }

    /**
     * �V��_���2���̂�ݒ肷��
     * @param val �V��_���2����
     */
    public void setSnbn_Sybt2Nm(String val) {
        set(FindClaimByCondDAO.SNBN_SYBT2_NM, val);
    }

    /**
     * �V��_�F�����̂��擾����
     * @return �V��_�F������
     */
    public String getSnbn_SisatNm() {
        return (String) get(FindClaimByCondDAO.SNBN_SISAT_NM);
    }

    /**
     * �V��_�F�����̂�ݒ肷��
     * @param val �V��_�F������
     */
    public void setSnbn_SisatNm(String val) {
        set(FindClaimByCondDAO.SNBN_SISAT_NM, val);
    }

    /**
     * �V��_�T�C�Y���̂��擾����
     * @return �V��_�T�C�Y����
     */
    public String getSnbn_SizeNm() {
        return (String) get(FindClaimByCondDAO.SNBN_SIZE_NM);
    }

    /**
     * �V��_�T�C�Y���̂�ݒ肷��
     * @param val �V��_�T�C�Y����
     */
    public void setSnbn_SizeNm(String val) {
        set(FindClaimByCondDAO.SNBN_SIZE_NM, val);
    }

    /**
     * �G��_�F�����̂��擾����
     * @return �G��_�F������
     */
    public String getZasi_SisatNm() {
        return (String) get(FindClaimByCondDAO.ZASI_SISAT_NM);
    }

    /**
     * �G��_�F�����̂�ݒ肷��
     * @param val �G��_�F������
     */
    public void setZasi_SisatNm(String val) {
        set(FindClaimByCondDAO.ZASI_SISAT_NM, val);
    }

    /**
     * �G��_�T�C�Y���̂��擾����
     * @return �G��_�T�C�Y����
     */
    public String getZasi_SizeNm() {
        return (String) get(FindClaimByCondDAO.ZASI_SIZE_NM);
    }

    /**
     * �G��_�T�C�Y���̂�ݒ肷��
     * @param val �G��_�T�C�Y����
     */
    public void setZasi_SizeNm(String val) {
        set(FindClaimByCondDAO.ZASI_SIZE_NM, val);
    }

    /**
     * �d�g_��ʌf�ږ��̂��擾����
     * @return �d�g_��ʌf�ږ���
     */
    public String getDemp_kotKeiNm() {
        return (String) get(FindClaimByCondDAO.DEMP_KOTKEI_NM);
    }

    /**
     * �d�g_��ʌf�ږ��̂�ݒ肷��
     * @param val �d�g_��ʌf�ږ���
     */
    public void setDemp_kotKeiNm(String val) {
        set(FindClaimByCondDAO.DEMP_KOTKEI_NM, val);
    }

}
