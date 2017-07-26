package jp.co.isid.kkh.customer.acom.model.claim;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ����/���� ���وꗗ���VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindClaimDiffCondVO extends AbstractModel {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindClaimDiffCondVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindClaimDiffCondVO();
    }

    /**
     * ���R�[�h��ʂ��擾����
     * @return ���R�[�h���
     */
    public String getRecCd() {
        return (String) get(TBTHB5HIK.RECCD);
    }

    /**
     * ���R�[�h��ʂ�ݒ肷��
     * @param val ���R�[�h���
     */
    public void setRecCd(String val) {
        set(TBTHB5HIK.RECCD, val);
    }

    /**
     * �˗��ԍ����擾����
     * @return �˗��ԍ�
     */
    public String getIrBan() {
        return (String) get(TBTHB5HIK.IRBAN);
    }

    /**
     * �˗��ԍ���ݒ肷��
     * @param val �˗��ԍ�
     */
    public void setIrBan(String val) {
        set(TBTHB5HIK.IRBAN, val);
    }

    /**
     * �˗��s�ԍ����擾����
     * @return �˗��s�ԍ�
     */
    public String getIrRowBan() {
        return (String) get(TBTHB5HIK.IRROWBAN);
    }

    /**
     * �˗��s�ԍ���ݒ肷��
     * @param val �˗��s�ԍ�
     */
    public void setIrRowBan(String val) {
        set(TBTHB5HIK.IRROWBAN, val);
    }

    /**
     * ���Ӑ�R�[�h�i�����R�[�h�j���擾����
     * @return ���Ӑ�R�[�h�i�����R�[�h�j
     */
    public String getTokuiCd() {
        return (String) get(TBTHB5HIK.TOKUICD);
    }

    /**
     * ���Ӑ�R�[�h�i�����R�[�h�j��ݒ肷��
     * @param val ���Ӑ�R�[�h�i�����R�[�h�j
     */
    public void setTokuiCd(String val) {
        set(TBTHB5HIK.TOKUICD, val);
    }

    /**
     * ���i�敪���擾����
     * @return ���i�敪
     */
    public String getSyohinKbn() {
        return (String) get(TBTHB5HIK.SYOHIKBN);
    }

    /**
     * ���i�敪��ݒ肷��
     * @param val ���i�敪
     */
    public void setSyohinKbn(String val) {
        set(TBTHB5HIK.SYOHIKBN, val);
    }

    /**
     * ���i�敪���̂��擾����
     * @return ���i�敪����
     */
    public String getSyohinKbnNm() {
        return (String) get(TBTHB5HIK.SYOHINAME);
    }

    /**
     * ���i�敪���̂�ݒ肷��
     * @param val ���i�敪����
     */
    public void setSyohinKbnNm(String val) {
        set(TBTHB5HIK.SYOHINAME, val);
    }

    /**
     * �E�v�R�[�h���擾����
     * @return �E�v�R�[�h
     */
    public String getTekiCd() {
        return (String) get(TBTHB5HIK.TEKICD);
    }

    /**
     * �E�v�R�[�h��ݒ肷��
     * @param val �E�v�R�[�h
     */
    public void setTekiCd(String val) {
        set(TBTHB5HIK.TEKICD, val);
    }

    /**
     * ��ʁi�}�̃R�[�h�j���擾����
     * @return ��ʁi�}�̃R�[�h�j
     */
    public String getSybt() {
        return (String) get(TBTHB5HIK.SYBT);
    }

    /**
     * ��ʁi�}�̃R�[�h�j��ݒ肷��
     * @param val ��ʁi�}�̃R�[�h�j
     */
    public void setSybt(String val) {
        set(TBTHB5HIK.SYBT, val);
    }

    /**
     * ���f�B�A�R�[�h���擾����
     * @return ���f�B�A�R�[�h
     */
    public String getMediaCd() {
        return (String) get(TBTHB5HIK.MEDIACD);
    }

    /**
     * ���f�B�A�R�[�h��ݒ肷��
     * @param val ���f�B�A�R�[�h
     */
    public void setMediaCd(String val) {
        set(TBTHB5HIK.MEDIACD, val);
    }

    /**
     * �X�Ԃ��擾����
     * @return �X��
     */
    public String getTenBan() {
        return (String) get(TBTHB5HIK.TENCD);
    }

    /**
     * �X�Ԃ�ݒ肷��
     * @param val �X��
     */
    public void setTenBan(String val) {
        set(TBTHB5HIK.TENCD, val);
    }

    /**
     * �f�ڒP�����擾����
     * @return �f�ڒP��
     */
    public String getKeisaiTnk() {
        return (String) get(TBTHB5HIK.KEISAITANKA);
    }

    /**
     * �f�ڒP����ݒ肷��
     * @param val �f�ڒP��
     */
    public void setKeisaiTnk(String val) {
        set(TBTHB5HIK.KEISAITANKA, val);
    }

    /**
     * �f�ڗ����擾����
     * @return �f�ڗ�
     */
    public BigDecimal getKeisaiRyo() {
        return (BigDecimal) get(TBTHB5HIK.KEISAIRYO);
    }

    /**
     * �f�ڗ���ݒ肷��
     * @param val �f�ڗ�
     */
    public void setKeisaiRyo(BigDecimal val) {
        set(TBTHB5HIK.KEISAIRYO, val);
    }


    /**
     * ������1���擾����
     * @return ������1
     */
    public BigDecimal getHosoRyo1() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO1);
    }

    /**
     * ������1��ݒ肷��
     * @param val ������1
     */
    public void setHosoRyo1(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO1, val);
    }

    /**
     * ������2���擾����
     * @return ������2
     */
    public BigDecimal getHosoRyo2() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO2);
    }

    /**
     * ������2��ݒ肷��
     * @param val ������2
     */
    public void setHosoRyo2(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO2, val);
    }

    /**
     * ������3���擾����
     * @return ������3
     */
    public BigDecimal getHosoRyo3() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO3);
    }

    /**
     * ������3��ݒ肷��
     * @param val ������3
     */
    public void setHosoRyo3(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO3, val);
    }

    /**
     * ������4���擾����
     * @return ������4
     */
    public BigDecimal getHosoRyo4() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO4);
    }

    /**
     * ������4��ݒ肷��
     * @param val ������4
     */
    public void setHosoRyo4(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO4, val);
    }

    /**
     * ������5���擾����
     * @return ������5
     */
    public BigDecimal getHosoRyo5() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO5);
    }

    /**
     * ������5��ݒ肷��
     * @param val ������5
     */
    public void setHosoRyo5(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO5, val);
    }

    /**
     * ������6���擾����
     * @return ������6
     */
    public BigDecimal getHosoRyo6() {
        return (BigDecimal) get(TBTHB5HIK.HOSORYO6);
    }

    /**
     * ������6��ݒ肷��
     * @param val ������6
     */
    public void setHosoRyo6(BigDecimal val) {
        set(TBTHB5HIK.HOSORYO6, val);
    }

    /**
     * ����ʂ��擾����
     * @return �����
     */
    public String getAnSybt() {
        return (String) get(TBTHB5HIK.ANSYUBE);
    }

    /**
     * ����ʂ�ݒ肷��
     * @param val �����
     */
    public void setAnSybt(String val) {
        set(TBTHB5HIK.ANSYUBE, val);
    }

    /**
     * �˗���1���擾����
     * @return �˗���1
     */
    public String getIrMonth1() {
        return (String) get(TBTHB5HIK.IRMONTH1);
    }

    /**
     * �˗���1��ݒ肷��
     * @param val �˗���1
     */
    public void setIrMonth1(String val) {
        set(TBTHB5HIK.IRMONTH1, val);
    }

    /**
     * �˗���2���擾����
     * @return �˗���2
     */
    public String getIrMonth2() {
        return (String) get(TBTHB5HIK.IRMONTH2);
    }

    /**
     * �˗���2��ݒ肷��
     * @param val �˗���2
     */
    public void setIrMonth2(String val) {
        set(TBTHB5HIK.IRMONTH2, val);
    }

    /**
     * �˗���3���擾����
     * @return �˗���3
     */
    public String getIrMonth3() {
        return (String) get(TBTHB5HIK.IRMONTH3);
    }

    /**
     * �˗���3��ݒ肷��
     * @param val �˗���3
     */
    public void setIrMonth3(String val) {
        set(TBTHB5HIK.IRMONTH3, val);
    }

    /**
     * �˗���4���擾����
     * @return �˗���4
     */
    public String getIrMonth4() {
        return (String) get(TBTHB5HIK.IRMONTH4);
    }

    /**
     * �˗���4��ݒ肷��
     * @param val �˗���4
     */
    public void setIrMonth4(String val) {
        set(TBTHB5HIK.IRMONTH4, val);
    }

    /**
     * �˗���5���擾����
     * @return �˗���5
     */
    public String getIrMonth5() {
        return (String) get(TBTHB5HIK.IRMONTH5);
    }

    /**
     * �˗���5��ݒ肷��
     * @param val �˗���5
     */
    public void setIrMonth5(String val) {
        set(TBTHB5HIK.IRMONTH5, val);
    }

    /**
     * �˗���6���擾����
     * @return �˗���6
     */
    public String getIrMonth6() {
        return (String) get(TBTHB5HIK.IRMONTH6);
    }

    /**
     * �˗���6��ݒ肷��
     * @param val �˗���6
     */
    public void setIrMonth6(String val) {
        set(TBTHB5HIK.IRMONTH6, val);
    }

    /**
     * �`�ԋ敪�R�[�h���擾����
     * @return �`�ԋ敪�R�[�h
     */
    public String getKeitaiCd() {
        return (String) get(TBTHB5HIK.KEITAICD);
    }

    /**
     * �`�ԋ敪�R�[�h��ݒ肷��
     * @param val �`�ԋ敪�R�[�h
     */
    public void setKeitaiCd(String val) {
        set(TBTHB5HIK.KEITAICD, val);
    }

    /**
     * �`�ԋ敪�����擾����
     * @return �`�ԋ敪��
     */
    public String getKeitaiName() {
        return (String) get(TBTHB5HIK.KEITAINAME);
    }

    /**
     * �`�ԋ敪����ݒ肷��
     * @param val �`�ԋ敪��
     */
    public void setKeitaiName(String val) {
        set(TBTHB5HIK.KEITAINAME, val);
    }

    /**
     * �זڋ敪���擾����
     * @return �זڋ敪
     */
    public String getSaiKbn() {
        return (String) get(TBTHB5HIK.SAIKBN);
    }

    /**
     * �זڋ敪��ݒ肷��
     * @param val �זڋ敪
     */
    public void setSaiKbn(String val) {
        set(TBTHB5HIK.SAIKBN, val);
    }

    /**
     * �����Ǘ��ԍ����擾����
     * @return �����Ǘ��ԍ�
     */
    public String getRireNo() {
        return (String) get(TBTHB5HIK.RIRENO);
    }

    /**
     * �����Ǘ��ԍ���ݒ肷��
     * @param val �����Ǘ��ԍ�
     */
    public void setRireNo(String val) {
        set(TBTHB5HIK.RIRENO, val);
    }

    /**
     * ���l1���擾����
     * @return ���l1
     */
    public String getBikou1() {
        return (String) get(TBTHB5HIK.BIKOU1);
    }

    /**
     * ���l1��ݒ肷��
     * @param val ���l1
     */
    public void setBikou1(String val) {
        set(TBTHB5HIK.BIKOU1, val);
    }

    /**
     * ���l2���擾����
     * @return ���l2
     */
    public String getBikou2() {
        return (String) get(TBTHB5HIK.BIKOU2);
    }

    /**
     * ���l2��ݒ肷��
     * @param val ���l2
     */
    public void setBikou2(String val) {
        set(TBTHB5HIK.BIKOU2, val);
    }

    /**
     * �f�ڏꏊ�R�[�h���擾����
     * @return �f�ڏꏊ�R�[�h
     */
    public String getPlaceCd() {
        return (String) get(TBTHB5HIK.PLACECD);
    }

    /**
     * �f�ڏꏊ�R�[�h��ݒ肷��
     * @param val �f�ڏꏊ�R�[�h
     */
    public void setPlaceCd(String val) {
        set(TBTHB5HIK.PLACECD, val);
    }

    /**
     * ��ʂP�R�[�h���擾����
     * @return ��ʂP�R�[�h
     */
    public String getSybt1Cd() {
        return (String) get(TBTHB5HIK.SYBT1CD);
    }

    /**
     * ��ʂP�R�[�h��ݒ肷��
     * @param val ��ʂP�R�[�h
     */
    public void setSybt1Cd(String val) {
        set(TBTHB5HIK.SYBT1CD, val);
    }

    /**
     * ��ʂQ�R�[�h���擾����
     * @return ��ʂQ�R�[�h
     */
    public String getSybt2Cd() {
        return (String) get(TBTHB5HIK.SYBT2CD);
    }

    /**
     * ��ʂQ�R�[�h��ݒ肷��
     * @param val ��ʂQ�R�[�h
     */
    public void setSybt2Cd(String val) {
        set(TBTHB5HIK.SYBT2CD, val);
    }

    /**
     * �F���R�[�h���擾����
     * @return �F���R�[�h
     */
    public String getColorCd() {
        return (String) get(TBTHB5HIK.COLORCD);
    }

    /**
     * �F���R�[�h��ݒ肷��
     * @param val �F���R�[�h
     */
    public void setColorCd(String val) {
        set(TBTHB5HIK.COLORCD, val);
    }

    /**
     * �T�C�Y�R�[�h���擾����
     * @return �T�C�Y�R�[�h
     */
    public String getSizeCd() {
        return (String) get(TBTHB5HIK.SIZECD);
    }

    /**
     * �T�C�Y�R�[�h��ݒ肷��
     * @param val �T�C�Y�R�[�h
     */
    public void setSizeCd(String val) {
        set(TBTHB5HIK.SIZECD, val);
    }

    /**
     * �X�y�[�X�R�[�h���擾����
     * @return �X�y�[�X�R�[�h
     */
    public String getSpCd() {
        return (String) get(TBTHB5HIK.SPACECD);
    }

    /**
     * �X�y�[�X�R�[�h��ݒ肷��
     * @param val �X�y�[�X�R�[�h
     */
    public void setSpCd(String val) {
        set(TBTHB5HIK.SPACECD, val);
    }

    /**
     * ��ʌf�ڃR�[�h���擾����
     * @return ��ʌf�ڃR�[�h
     */
    public String getKotuKeiCd() {
        return (String) get(TBTHB5HIK.KOTUKEICD);
    }

    /**
     * ��ʌf�ڃR�[�h��ݒ肷��
     * @param val ��ʌf�ڃR�[�h
     */
    public void setKotuKeiCd(String val) {
        set(TBTHB5HIK.KOTUKEICD, val);
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
    public String getKeiBasNm() {
        return (String) get(FindClaimByCondDAO.SNBN_KEIBAS_NM);
    }

    /**
     * �V��_�f�ڏꏊ���̂�ݒ肷��
     * @param val �V��_�f�ڏꏊ����
     */
    public void setKeiBasNm(String val) {
        set(FindClaimByCondDAO.SNBN_KEIBAS_NM, val);
    }

    /**
     * �V��_���1���̂��擾����
     * @return �V��_���1����
     */
    public String getSybt1Nm() {
        return (String) get(FindClaimByCondDAO.SNBN_SYBT1_NM);
    }

    /**
     * �V��_���1���̂�ݒ肷��
     * @param val �V��_���1����
     */
    public void setSybt1Nm(String val) {
        set(FindClaimByCondDAO.SNBN_SYBT1_NM, val);
    }

    /**
     * �V��_���2���̂��擾����
     * @return �V��_���2����
     */
    public String getSybt2Nm() {
        return (String) get(FindClaimByCondDAO.SNBN_SYBT2_NM);
    }

    /**
     * �V��_���2���̂�ݒ肷��
     * @param val �V��_���2����
     */
    public void setSybt2Nm(String val) {
        set(FindClaimByCondDAO.SNBN_SYBT2_NM, val);
    }

    /**
     * �V��_�F�����̂��擾����
     * @return �V��_�F������
     */
    public String getSisatNm() {
        return (String) get(FindClaimByCondDAO.SNBN_SISAT_NM);
    }

    /**
     * �V��_�F�����̂�ݒ肷��
     * @param val �V��_�F������
     */
    public void setSisatNm(String val) {
        set(FindClaimByCondDAO.SNBN_SISAT_NM, val);
    }

    /**
     * �V��_�X�y�[�X���̂��擾����
     * @return �V��_�X�y�[�X����
     */
    public String getSpNm() {
        return (String) get(FindClaimByCondDAO.SNBN_SIZE_NM);
    }

    /**
     * �V��_�X�y�[�X���̂�ݒ肷��
     * @param val �V��_�X�y�[�X����
     */
    public void setSpNm(String val) {
        set(FindClaimByCondDAO.SNBN_SIZE_NM, val);
    }

    /**
     * �G��_�T�C�Y���̂��擾����
     * @return �G��_�T�C�Y����
     */
    public String getSizeNm() {
        return (String) get(FindClaimByCondDAO.ZASI_SIZE_NM);
    }

    /**
     * �G��_�T�C�Y���̂�ݒ肷��
     * @param val �G��_�T�C�Y����
     */
    public void setSizeNm(String val) {
        set(FindClaimByCondDAO.ZASI_SIZE_NM, val);
    }

    /**
     * �d�g_��ʌf�ږ��̂��擾����
     * @return �d�g_��ʌf�ږ���
     */
    public String getKotKeiNm() {
        return (String) get(FindClaimByCondDAO.DEMP_KOTKEI_NM);
    }

    /**
     * �d�g_��ʌf�ږ��̂�ݒ肷��
     * @param val �d�g_��ʌf�ږ���
     */
    public void setKotKeiNm(String val) {
        set(FindClaimByCondDAO.DEMP_KOTKEI_NM, val);
    }
}