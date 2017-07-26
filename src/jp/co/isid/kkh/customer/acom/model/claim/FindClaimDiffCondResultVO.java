package jp.co.isid.kkh.customer.acom.model.claim;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ����/���� ���وꗗ���VO (�ԋp�p)
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindClaimDiffCondResultVO extends AbstractModel {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindClaimDiffCondResultVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindClaimDiffCondResultVO();
    }

    /**
     * ��ʂ��擾����
     * @return ���
     */
    public String getSybt() {
        return (String) get("SYBT");
    }

    /**
     * ��ʂ�ݒ肷��
     * @param val ���
     */
    public void setSybt(String val) {
        set("SYBT", val);
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
     * �˗��s�ԍ��i�����s�ԍ��j���擾����
     * @return �˗��s�ԍ��i�����s�ԍ��j
     */
    public String getIraiGyoNo() {
        return (String) get("IRAIGYONO");
    }

    /**
     * �˗��s�ԍ��i�����s�ԍ��j��ݒ肷��
     * @param val �˗��s�ԍ��i�����s�ԍ��j
     */
    public void setIraiGyoNo(String val) {
        set("IRAIGYONO", val);
    }

    /**
     * �����R�[�h���擾����
     * @return �����R�[�h
     */
    public String getToriCd() {
        return (String) get("TORICD");
    }

    /**
     * �����R�[�h��ݒ肷��
     * @param val �����R�[�h
     */
    public void setToriCd(String val) {
        set("TORICD", val);
    }

    /**
     * ��Ж����擾����
     * @return ��Ж�
     */
    public String getKaiNm() {
        return (String) get("KAINM");
    }

    /**
     * ��Ж���ݒ肷��
     * @param val ��Ж�
     */
    public void setKaiNm(String val) {
        set("KAINM", val);
    }

    /**
     * ���������R�[�h���擾����
     * @return ���������R�[�h
     */
    public String getSeibuCd() {
        return (String) get("SEIBUCD");
    }

    /**
     * ���������R�[�h��ݒ肷��
     * @param val ���������R�[�h
     */
    public void setSeibuCd(String val) {
        set("SEIBUCD", val);
    }

    /**
     * �����N�������擾����
     * @return �����N����
     */
    public String getSeiYymm() {
        return (String) get("SEIYYMM");
    }

    /**
     * �����N������ݒ肷��
     * @param val �����N����
     */
    public void setSeiYymm(String val) {
        set("SEIYYMM", val);
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
     * ���e�敪���擾����
     * @return ���e�敪
     */
    public String getNaiyoKbn() {
        return (String) get("NAIYOKBN");
    }

    /**
     * ���e�敪��ݒ肷��
     * @param val ���e�敪
     */
    public void setNaiyoKbn(String val) {
        set("NAIYOKBN", val);
    }

    /**
     * �������s�ԍ����擾����
     * @return �������s�ԍ�
     */
    public String getSeiGyoNo() {
        return (String) get("SEIGYONO");
    }

    /**
     * �������s�ԍ���ݒ肷��
     * @param val �������s�ԍ�
     */
    public void setSeiGyoNo(String val) {
        set("SEIGYONO", val);
    }

    /**
     * �x�������擾����
     * @return �x����
     */
    public String getPayDay() {
        return (String) get("PAYDAY");
    }

    /**
     * �x������ݒ肷��
     * @param val �x����
     */
    public void setPayDay(String val) {
        set("PAYDAY", val);
    }

    /**
     * ���i�敪���擾����
     * @return ���i�敪
     */
    public String getSyohinKbn() {
        return (String) get("SHOHINKBN");
    }

    /**
     * ���i�敪��ݒ肷��
     * @param val ���i�敪
     */
    public void setSyohinKbn(String val) {
        set("SHOHINKBN", val);
    }

    /**
     * �E�v�R�[�h���擾����
     * @return �E�v�R�[�h
     */
    public String getTekiyoCd() {
        return (String) get("TEKIYOCD");
    }

    /**
     * �E�v�R�[�h��ݒ肷��
     * @param val �E�v�R�[�h
     */
    public void setTekiyoCd(String val) {
        set("TEKIYOCD", val);
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
     * ���f�B�A�R�[�h���擾����
     * @return ���f�B�A�R�[�h
     */
    public String getMediaCd() {
        return (String) get("MEDIACD");
    }

    /**
     * ���f�B�A�R�[�h��ݒ肷��
     * @param val ���f�B�A�R�[�h
     */
    public void setMediaCd(String val) {
        set("MEDIACD", val);
    }

    /**
     * ���f�B�A�����擾����
     * @return ���f�B�A��
     */
    public String getMediaNm() {
        return (String) get("MEDIANM");
    }

    /**
     * ���f�B�A����ݒ肷��
     * @param val ���f�B�A��
     */
    public void setMediaNm(String val) {
        set("MEDIANM", val);
    }

    /**
     * �X�Ԃ��擾����
     * @return �X��
     */
    public String getTenBan() {
        return (String) get("TENBAN");
    }

    /**
     * �X�Ԃ�ݒ肷��
     * @param val �X��
     */
    public void setTenBan(String val) {
        set("TENBAN", val);
    }

    /**
     * �`�ԋ敪�R�[�h���擾����
     * @return �`�ԋ敪�R�[�h
     */
    public String getKeitaiKbnCd() {
        return (String) get("KEITAIKBNCD");
    }

    /**
     * �`�ԋ敪�R�[�h��ݒ肷��
     * @param val �`�ԋ敪�R�[�h
     */
    public void setKeitaiKbnCd(String val) {
        set("KEITAIKBNCD", val);
    }

    /**
     * �`�ԋ敪���̂��擾����
     * @return �`�ԋ敪����
     */
    public String getKeitaiKbnNm() {
        return (String) get("KEITAIKBNNM");
    }

    /**
     * �`�ԋ敪���̂�ݒ肷��
     * @param val �`�ԋ敪����
     */
    public void setKeitaiKbnNm(String val) {
        set("KEITAIKBNNM", val);
    }

    /**
     * CM�b����1���擾����
     * @return CM�b����1
     */
    public String getCm1() {
        return (String) get("CM1");
    }

    /**
     * CM�b����1��ݒ肷��
     * @param val CM�b����1
     */
    public void setCm1(String val) {
        set("CM1", val);
    }

    /**
     * CM�b����2���擾����
     * @return CM�b����2
     */
    public String getCm2() {
        return (String) get("CM2");
    }

    /**
     * CM�b����2��ݒ肷��
     * @param val CM�b����2
     */
    public void setCm2(String val) {
        set("CM2", val);
    }

    /**
     * CM�b����3���擾����
     * @return CM�b����3
     */
    public String getCm3() {
        return (String) get("CM3");
    }

    /**
     * CM�b����3��ݒ肷��
     * @param val CM�b����3
     */
    public void setCm3(String val) {
        set("CM3", val);
    }

    /**
     * CM�b����4���擾����
     * @return CM�b����4
     */
    public String getCm4() {
        return (String) get("CM4");
    }

    /**
     * CM�b����4��ݒ肷��
     * @param val CM�b����4
     */
    public void setCm4(String val) {
        set("CM4", val);
    }

    /**
     * ���e����1���擾����
     * @return ���e����1
     */
    public String getName1() {
        return (String) get("NAME1");
    }

    /**
     * ���e����1��ݒ肷��
     * @param val ���e����1
     */
    public void setName1(String val) {
        set("NAME1", val);
    }

    /**
     * ���e����2���擾����
     * @return ���e����2
     */
    public String getName2() {
        return (String) get("NAME2");
    }

    /**
     * ���e����2��ݒ肷��
     * @param val ���e����2
     */
    public void setName2(String val) {
        set("NAME2", val);
    }

    /**
     * ���e����3���擾����
     * @return ���e����3
     */
    public String getName3() {
        return (String) get("NAME3");
    }

    /**
     * ���e����3��ݒ肷��
     * @param val ���e����3
     */
    public void setName3(String val) {
        set("NAME3", val);
    }

    /**
     * ���e����4���擾����
     * @return ���e����4
     */
    public String getName4() {
        return (String) get("NAME4");
    }

    /**
     * ���e����4��ݒ肷��
     * @param val ���e����4
     */
    public void setName4(String val) {
        set("NAME4", val);
    }

    /**
     * �ԑg��1���擾����
     * @return �ԑg��1
     */
    public String getBngm1() {
        return (String) get("BNGM1");
    }

    /**
     * �ԑg��1��ݒ肷��
     * @param val �ԑg��1
     */
    public void setBngm1(String val) {
        set("BNGM1", val);
    }

    /**
     * �ԑg��2���擾����
     * @return �ԑg��2
     */
    public String getBngm2() {
        return (String) get("BNGM2");
    }

    /**
     * �ԑg��2��ݒ肷��
     * @param val �ԑg��2
     */
    public void setBngm2(String val) {
        set("BNGM2", val);
    }

    /**
     * �ԑg��3���擾����
     * @return �ԑg��3
     */
    public String getBngm3() {
        return (String) get("BNGM3");
    }

    /**
     * �ԑg��3��ݒ肷��
     * @param val �ԑg��3
     */
    public void setBngm3(String val) {
        set("BNGM3", val);
    }

    /**
     * �ԑg��4���擾����
     * @return �ԑg��4
     */
    public String getBngm4() {
        return (String) get("BNGM4");
    }

    /**
     * �ԑg��4��ݒ肷��
     * @param val �ԑg��4
     */
    public void setBngm4(String val) {
        set("BNGM4", val);
    }

    /**
     * �f�ڏꏊ�R�[�h���擾����
     * @return �f�ڏꏊ�R�[�h
     */
    public String getKeisaiBasCd() {
        return (String) get("KEISAIBASCD");
    }

    /**
     * �f�ڏꏊ�R�[�h��ݒ肷��
     * @param val �f�ڏꏊ�R�[�h
     */
    public void setKeisaiBasCd(String val) {
        set("KEISAIBASCD", val);
    }

    /**
     * �f�ڏꏊ���̂��擾����
     * @return �f�ڏꏊ����
     */
    public String getKeisaiBasNm() {
        return (String) get("KEISAIBASNM");
    }

    /**
     * �f�ڏꏊ���̂�ݒ肷��
     * @param val �f�ڏꏊ����
     */
    public void setKeisaiBasNm(String val) {
        set("KEISAIBASNM", val);
    }

    /**
     * ���1�R�[�h���擾����
     * @return ���1�R�[�h
     */
    public String getSybt1Cd() {
        return (String) get("SYBT1CD");
    }

    /**
     * ���1�R�[�h��ݒ肷��
     * @param val ���1�R�[�h
     */
    public void setSybt1Cd(String val) {
        set("SYBT1CD", val);
    }

    /**
     * ���1���̂��擾����
     * @return ���1����
     */
    public String getSybt1Nm() {
        return (String) get("SYBT1NM");
    }

    /**
     * ���1���̂�ݒ肷��
     * @param val ���1����
     */
    public void setSybt1Nm(String val) {
        set("SYBT1NM", val);
    }

    /**
     * ���2�R�[�h���擾����
     * @return ���2�R�[�h
     */
    public String getSybt2Cd() {
        return (String) get("SYBT2CD");
    }

    /**
     * ���2�R�[�h��ݒ肷��
     * @param val ���2�R�[�h
     */
    public void setSybt2Cd(String val) {
        set("SYBT2CD", val);
    }

    /**
     * ���2���̂��擾����
     * @return ���2����
     */
    public String getSybt2Nm() {
        return (String) get("SYBT2NM");
    }

    /**
     * ���2���̂�ݒ肷��
     * @param val ���2����
     */
    public void setSybt2Nm(String val) {
        set("SYBT2NM", val);
    }

    /**
     * �F���R�[�h���擾����
     * @return �F���R�[�h
     */
    public String getSisaCd() {
        return (String) get("SISACD");
    }

    /**
     * �F���R�[�h��ݒ肷��
     * @param val �F���R�[�h
     */
    public void setSisaCd(String val) {
        set("SISACD", val);
    }

    /**
     * �F�����̂��擾����
     * @return �F������
     */
    public String getSisaNm() {
        return (String) get("SISANM");
    }

    /**
     * �F�����̂�ݒ肷��
     * @param val �F������
     */
    public void setSisaNm(String val) {
        set("SISANM", val);
    }

    /**
     * �T�C�Y�R�[�h���擾����
     * @return �T�C�Y�R�[�h
     */
    public String getSizeCd() {
        return (String) get("SIZECD");
    }

    /**
     * �T�C�Y�R�[�h��ݒ肷��
     * @param val �T�C�Y�R�[�h
     */
    public void setSizeCd(String val) {
        set("SIZECD", val);
    }

    /**
     * �T�C�Y���̂��擾����
     * @return �T�C�Y����
     */
    public String getSizeNm() {
        return (String) get("SIZENM");
    }

    /**
     * �T�C�Y���̂�ݒ肷��
     * @param val �T�C�Y����
     */
    public void setSizeNm(String val) {
        set("SIZENM", val);
    }

    /**
     * �X�y�[�X�R�[�h���擾����
     * @return �T�C�Y�R�[�h
     */
    public String getSpCd() {
        return (String) get("SPACECD");
    }

    /**
     * �X�y�[�X�R�[�h��ݒ肷��
     * @param val �T�C�Y�R�[�h
     */
    public void setSpCd(String val) {
        set("SPACECD", val);
    }

    /**
     * �X�y�[�X���̂��擾����
     * @return �X�y�[�X����
     */
    public String getSpNm() {
        return (String) get("SPACENM");
    }

    /**
     * �X�y�[�X���̂�ݒ肷��
     * @param val �X�y�[�X����
     */
    public void setSpNm(String val) {
        set("SPACENM", val);
    }

    /**
     * ��ʌf�ڃR�[�h���擾����
     * @return ��ʌf�ڃR�[�h
     */
    public String getKotukeiCd() {
        return (String) get("KOTUKEICD");
    }

    /**
     * ��ʌf�ڃR�[�h��ݒ肷��
     * @param val ��ʌf�ڃR�[�h
     */
    public void setKotukeiCd(String val) {
        set("KOTUKEICD", val);
    }

    /**
     * ��ʌf�ږ��̂��擾����
     * @return ��ʌf�ږ���
     */
    public String getKotukeiNm() {
        return (String) get("KOTUKEINM");
    }

    /**
     * ��ʌf�ږ��̂�ݒ肷��
     * @param val ��ʌf�ږ���
     */
    public void setKotukeiNm(String val) {
        set("KOTUKEINM", val);
    }

    /**
     * ���Ԃ��擾����
     * @return ����
     */
    public String getKikan() {
        return (String) get("KIKAN");
    }

    /**
     * ���Ԃ�ݒ肷��
     * @param val ����
     */
    public void setKikan(String val) {
        set("KIKAN", val);
    }

    /**
     * �f�ډ񐔂��擾����
     * @return �f�ډ�
     */
    public String getKeisaiSu() {
        return (String) get("KEISAISU");
    }

    /**
     * �f�ډ񐔂�ݒ肷��
     * @param val �f�ډ�
     */
    public void setKeisaiSu(String val) {
        set("KEISAISU", val);
    }

    /**
     * ���l1���擾����
     * @return ���l1
     */
    public String getBiko1() {
        return (String) get("BIKO1");
    }

    /**
     * ���l1��ݒ肷��
     * @param val ���l1
     */
    public void setBiko1(String val) {
        set("BIKO1", val);
    }

    /**
     * ���l2���擾����
     * @return ���l2
     */
    public String getBiko2() {
        return (String) get("BIKO2");
    }

    /**
     * ���l2��ݒ肷��
     * @param val ���l2
     */
    public void setBiko2(String val) {
        set("BIKO2", val);
    }

    /**
     * �f�ڒP�����擾����
     * @return �f�ڒP��
     */
    public String getKeisaiTnk() {
        return (String) get("KEISAITNK");
    }

    /**
     * �f�ڒP����ݒ肷��
     * @param val �f�ڒP��
     */
    public void setKeisaiTnk(String val) {
        set("KEISAITNK", val);
    }

    /**
     * �s�P�ʋ��z���擾����
     * @return �s�P�ʋ��z
     */
    public BigDecimal getKingak() {
        return (BigDecimal) get("KINGAK");
    }

    /**
     * �s�P�ʋ��z��ݒ肷��
     * @param val �s�P�ʋ��z
     */
    public void setKingak(BigDecimal val) {
        set("KINGAK", val);
    }

    /**
     * �s�P�ʏ���ł��擾����
     * @return �s�P�ʏ����
     */
    public BigDecimal getSyohizei() {
        return (BigDecimal) get("SYOHIZEI");
    }

    /**
     * �s�P�ʏ���ł�ݒ肷��
     * @param val �s�P�ʏ����
     */
    public void setSyohizei(BigDecimal val) {
        set("SYOHIZEI", val);
    }

    /**
     * �s�P�ʋ��z���v���擾����
     * @return �s�P�ʋ��z���v
     */
    public BigDecimal getKingakSum() {
        return (BigDecimal) get("KINGAKSUM");
    }

    /**
     * �s�P�ʋ��z���v��ݒ肷��
     * @param val �s�P�ʋ��z���v
     */
    public void setKingakSum(BigDecimal val) {
        set("KINGAKSUM", val);
    }

    /**
     * ����ʂ��擾����
     * @return �����
     */
    public String getAnbunSybt() {
        return (String) get("ANBUNSYBT");
    }

    /**
     * ����ʂ�ݒ肷��
     * @param val �����
     */
    public void setAnbunSybt(String val) {
        set("ANBUNSYBT", val);
    }

    /**
     * �敪���擾����
     * @return �敪
     */
    public String getKbn() {
        return (String) get("KBN");
    }

    /**
     * �敪��ݒ肷��
     * @param val �敪
     */
    public void setKbn(String val) {
        set("KBN", val);
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
     * �\�[�g�ԍ����擾����
     * @return �\�[�g�ԍ�
     */
    public String getSortNo() {
        return (String) get("SORTNO");
    }

    /**
     * �\�[�g�ԍ���ݒ肷��
     * @param val �\�[�g�ԍ�
     */
    public void setSortNo(String val) {
        set("SORTNO", val);
    }
}