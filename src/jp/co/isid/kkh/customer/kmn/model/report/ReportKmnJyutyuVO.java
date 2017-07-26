package jp.co.isid.kkh.customer.kmn.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���[�i����_�`�[�j�f�[�^VO
 * �󒍃f�[�^�̂�
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
public class ReportKmnJyutyuVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportKmnJyutyuVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportKmnJyutyuVO();
    }

    /**
     * ��No���擾����
     * @return ��No
     */
    public String getJYUTNO() {
        return (String) get(TBTHB1DOWN.JYUTNO);
    }

    /**
     * ��No��ݒ肷��
     * @param val ��No
     */
    public void setJYUTNO(String val) {
        set(TBTHB1DOWN.JYUTNO, val);
    }

    /**
     * �󒍖���No���擾����
     * @return �󒍖���No
     */
    public String getJYMEINO() {
        return (String) get(TBTHB1DOWN.JYMEINO);
    }

    /**
     * �󒍖���No��ݒ肷��
     * @param val �󒍖���No
     */
    public void setJYMEINO(String val) {
        set(TBTHB1DOWN.JYMEINO, val);
    }

    /**
     * ���㖾��No���擾����
     * @return ���㖾��No
     */
    public String getURMEINO() {
        return (String) get(TBTHB1DOWN.URMEINO);
    }

    /**
     * ���㖾��No��ݒ肷��
     * @param val ���㖾��No
     */
    public void setURMEINO(String val) {
        set(TBTHB1DOWN.URMEINO, val);
    }

    /**
     * �������[No���擾����
     * @return �������[No
     */
    public String getGPYNO() {
        return (String) get(TBTHB1DOWN.GPYNO);
    }

    /**
     * �������[No��ݒ肷��
     * @param val �������[No
     */
    public void setGPYNO(String val) {
        set(TBTHB1DOWN.GPYNO, val);
    }

    /**
     * ����No���擾����
     * @return ����No
     */
    public String getSEINO() {
        return (String) get(TBTHB1DOWN.SEINO);
    }

    /**
     * ����No��ݒ肷��
     * @param val ����No
     */
    public void setSEINO(String val) {
        set(TBTHB1DOWN.SEINO, val);
    }

    /**
     * ��ڃR�[�h���擾����
     * @return ��ڃR�[�h
     */
    public String getHIMKCD() {
        return (String) get(TBTHB1DOWN.HIMKCD);
    }

    /**
     * ��ڃR�[�h��ݒ肷��
     * @param val ��ڃR�[�h
     */
    public void setHIMKCD(String val) {
        set(TBTHB1DOWN.HIMKCD, val);
    }

    /**
     * �����t���O���擾����
     * @return �����t���O
     */
    public String getTOUFLG() {
        return (String) get(TBTHB1DOWN.TOUFLG);
    }

    /**
     * �����t���O��ݒ肷��
     * @param val �����t���O
     */
    public void setTOUFLG(String val) {
        set(TBTHB1DOWN.TOUFLG, val);
    }

    /**
     * �N�����擾����
     * @return �N��
     */
    public String getYYMM() {
        return (String) get(TBTHB1DOWN.YYMM);
    }

    /**
     * �N����ݒ肷��
     * @param val �N��
     */
    public void setYYMM(String val) {
        set(TBTHB1DOWN.YYMM, val);
    }

    /**
     * �Ɩ��敪���擾����
     * @return �Ɩ��敪
     */
    public String getGYOMKBN() {
        return (String) get(TBTHB1DOWN.GYOMKBN);
    }

    /**
     * �Ɩ��敪��ݒ肷��
     * @param val �Ɩ��敪
     */
    public void setGYOMKBN(String val) {
        set(TBTHB1DOWN.GYOMKBN, val);
    }

    /**
     * �}�X�����敪���擾����
     * @return �}�X�����敪
     */
    public String getMSKBN() {
        return (String) get(TBTHB1DOWN.MSKBN);
    }

    /**
     * �}�X�����敪��ݒ肷��
     * @param val �}�X�����敪
     */
    public void setMSKBN(String val) {
        set(TBTHB1DOWN.MSKBN, val);
    }

    /**
     * �^�C���X�|�b�g�敪���擾����
     * @return �^�C���X�|�b�g�敪
     */
    public String getTMSPKBN() {
        return (String) get(TBTHB1DOWN.TMSPKBN);
    }

    /**
     * �^�C���X�|�b�g�敪��ݒ肷��
     * @param val �^�C���X�|�b�g�敪
     */
    public void setTMSPKBN(String val) {
        set(TBTHB1DOWN.TMSPKBN, val);
    }

    /**
     * ���ۋ敪���擾����
     * @return ���ۋ敪
     */
    public String getKOKKBN() {
        return (String) get(TBTHB1DOWN.KOKKBN);
    }

    /**
     * ���ۋ敪��ݒ肷��
     * @param val ���ۋ敪
     */
    public void setKOKKBN(String val) {
        set(TBTHB1DOWN.KOKKBN, val);
    }

    /**
     * �����敪���擾����
     * @return �����敪
     */
    public String getSEIKBN() {
        return (String) get(TBTHB1DOWN.SEIKBN);
    }

    /**
     * �����敪��ݒ肷��
     * @param val �����敪
     */
    public void setSEIKBN(String val) {
        set(TBTHB1DOWN.SEIKBN, val);
    }

    /**
     * ���iNO���擾����
     * @return ���iNO
     */
    public String getSYONO() {
        return (String) get(TBTHB1DOWN.SYONO);
    }

    /**
     * ���iNO��ݒ肷��
     * @param val ���iNO
     */
    public void setSYONO(String val) {
        set(TBTHB1DOWN.SYONO, val);
    }

    /**
     * ����(����)���擾����
     * @return ����(����)
     */
    public String getKKNAMEKJ() {
        return (String) get(TBTHB1DOWN.KKNAMEKJ);
    }

    /**
     * ����(����)��ݒ肷��
     * @param val ����(����)
     */
    public void setKKNAMEKJ(String val) {
        set(TBTHB1DOWN.KKNAMEKJ, val);
    }

    /**
     * �旿�����擾����
     * @return �旿��
     */
    public BigDecimal getTORIGAK() {
        return (BigDecimal) get(TBTHB1DOWN.TORIGAK);
    }

    /**
     * �旿����ݒ肷��
     * @param val �旿��
     */
    public void setTORIGAK(BigDecimal val) {
        set(TBTHB1DOWN.TORIGAK, val);
    }

    /**
     * �����P�����擾����
     * @return �����P��
     */
    public BigDecimal getSEITNKA() {
        return (BigDecimal) get(TBTHB1DOWN.SEITNKA);
    }

    /**
     * �����P����ݒ肷��
     * @param val �����P��
     */
    public void setSEITNKA(BigDecimal val) {
        set(TBTHB1DOWN.SEITNKA, val);
    }

    /**
     * �������z���擾����
     * @return �������z
     */
    public BigDecimal getSEIGAK() {
        return (BigDecimal) get(TBTHB1DOWN.SEIGAK);
    }

    /**
     * �������z��ݒ肷��
     * @param val �������z
     */
    public void setSEIGAK(BigDecimal val) {
        set(TBTHB1DOWN.SEIGAK, val);
    }

    /**
     * �l�������擾����
     * @return �l����
     */
    public BigDecimal getNEBIRITU() {
        return (BigDecimal) get(TBTHB1DOWN.NEBIRITU);
    }

    /**
     * �l������ݒ肷��
     * @param val �l����
     */
    public void setNEBIRITU(BigDecimal val) {
        set(TBTHB1DOWN.NEBIRITU, val);
    }

    /**
     * �l���z���擾����
     * @return �l���z
     */
    public BigDecimal getNEBIGAK() {
        return (BigDecimal) get(TBTHB1DOWN.NEBIGAK);
    }

    /**
     * �l���z��ݒ肷��
     * @param val �l���z
     */
    public void setNEBIGAK(BigDecimal val) {
        set(TBTHB1DOWN.NEBIGAK, val);
    }

    /**
     * ����ŋ敪���擾����
     * @return ����ŋ敪
     */
    public String getSZEIKBN() {
        return (String) get(TBTHB1DOWN.SZEIKBN);
    }

    /**
     * ����ŋ敪��ݒ肷��
     * @param val ����ŋ敪
     */
    public void setSZEIKBN(String val) {
        set(TBTHB1DOWN.SZEIKBN, val);
    }

    /**
     * ����ŗ����擾����
     * @return ����ŗ�
     */
    public BigDecimal getSZEIRITU() {
        return (BigDecimal) get(TBTHB1DOWN.SZEIRITU);
    }

    /**
     * ����ŗ���ݒ肷��
     * @param val ����ŗ�
     */
    public void setSZEIRITU(BigDecimal val) {
        set(TBTHB1DOWN.SZEIRITU, val);
    }

    /**
     * ����Ŋz���擾����
     * @return ����Ŋz
     */
    public BigDecimal getSZEIGAK() {
        return (BigDecimal) get(TBTHB1DOWN.SZEIGAK);
    }

    /**
     * ����Ŋz��ݒ肷��
     * @param val ����Ŋz
     */
    public void setSZEIGAK(BigDecimal val) {
        set(TBTHB1DOWN.SZEIGAK, val);
    }

    /**
     * ��ږ�(����)���擾����
     * @return ��ږ�(����)
     */
    public String getHIMKNMKJ() {
        return (String) get(TBTHB1DOWN.HIMKNMKJ);
    }

    /**
     * ��ږ�(����)��ݒ肷��
     * @param val ��ږ�(����)
     */
    public void setHIMKNMKJ(String val) {
        set(TBTHB1DOWN.HIMKNMKJ, val);
    }

    /**
     * ��ږ�(�J�i)���擾����
     * @return ��ږ�(�J�i)
     */
    public String getHIMKNMKN() {
        return (String) get(TBTHB1DOWN.HIMKNMKN);
    }

    /**
     * ��ږ�(�J�i)��ݒ肷��
     * @param val ��ږ�(�J�i)
     */
    public void setHIMKNMKN(String val) {
        set(TBTHB1DOWN.HIMKNMKN, val);
    }

    /**
     * �������No���擾����
     * @return �������No
     */
    public String getTJYUTNO() {
        return (String) get(TBTHB1DOWN.TJYUTNO);
    }

    /**
     * �������No��ݒ肷��
     * @param val �������No
     */
    public void setTJYUTNO(String val) {
        set(TBTHB1DOWN.TJYUTNO, val);
    }

    /**
     * ������󒍖���No���擾����
     * @return ������󒍖���No
     */
    public String getTJYMEINO() {
        return (String) get(TBTHB1DOWN.TJYMEINO);
    }

    /**
     * ������󒍖���No��ݒ肷��
     * @param val ������󒍖���No
     */
    public void setTJYMEINO(String val) {
        set(TBTHB1DOWN.TJYMEINO, val);
    }

    /**
     * �����攄�㖾��No���擾����
     * @return �����攄�㖾��No
     */
    public String getTURMEINO() {
        return (String) get(TBTHB1DOWN.TURMEINO);
    }

    /**
     * �����攄�㖾��No��ݒ肷��
     * @param val �����攄�㖾��No
     */
    public void setTURMEINO(String val) {
        set(TBTHB1DOWN.TURMEINO, val);
    }

    /**
     * �t�B�[���h1���擾����
     * @return �t�B�[���h1
     */
    public String getFIELD1() {
        return (String) get(TBTHB1DOWN.FIELD1);
    }

    /**
     * �t�B�[���h1��ݒ肷��
     * @param val �t�B�[���h1
     */
    public void setFIELD1(String val) {
        set(TBTHB1DOWN.FIELD1, val);
    }

    /**
     * �t�B�[���h�Q���擾����
     * @return �t�B�[���h�Q
     */
    public String getFIELD2() {
        return (String) get(TBTHB1DOWN.FIELD2);
    }

    /**
     * �t�B�[���h�Q��ݒ肷��
     * @param val �t�B�[���h�Q
     */
    public void setFIELD2(String val) {
        set(TBTHB1DOWN.FIELD2, val);
    }

    /**
     * �t�B�[���h�R���擾����
     * @return �t�B�[���h�R
     */
    public String getFIELD3() {
        return (String) get(TBTHB1DOWN.FIELD3);
    }

    /**
     * �t�B�[���h�R��ݒ肷��
     * @param val �t�B�[���h�R
     */
    public void setFIELD3(String val) {
        set(TBTHB1DOWN.FIELD3, val);
    }

    /**
     * �t�B�[���h�S���擾����
     * @return �t�B�[���h�S
     */
    public String getFIELD4() {
        return (String) get(TBTHB1DOWN.FIELD4);
    }

    /**
     * �t�B�[���h�S��ݒ肷��
     * @param val �t�B�[���h�S
     */
    public void setFIELD4(String val) {
        set(TBTHB1DOWN.FIELD4, val);
    }

    /**
     * �t�B�[���h�T���擾����
     * @return �t�B�[���h�T
     */
    public String getFIELD5() {
        return (String) get(TBTHB1DOWN.FIELD5);
    }

    /**
     * �t�B�[���h�T��ݒ肷��
     * @param val �t�B�[���h�T
     */
    public void setFIELD5(String val) {
        set(TBTHB1DOWN.FIELD5, val);
    }

    /**
     * �t�B�[���h�U���擾����
     * @return �t�B�[���h�U
     */
    public String getFIELD6() {
        return (String) get(TBTHB1DOWN.FIELD6);
    }

    /**
     * �t�B�[���h�U��ݒ肷��
     * @param val �t�B�[���h�U
     */
    public void setFIELD6(String val) {
        set(TBTHB1DOWN.FIELD6, val);
    }

    /**
     * �t�B�[���h�V���擾����
     * @return �t�B�[���h�V
     */
    public String getFIELD7() {
        return (String) get(TBTHB1DOWN.FIELD7);
    }

    /**
     * �t�B�[���h�V��ݒ肷��
     * @param val �t�B�[���h�V
     */
    public void setFIELD7(String val) {
        set(TBTHB1DOWN.FIELD7, val);
    }

    /**
     * �t�B�[���h�W���擾����
     * @return �t�B�[���h�W
     */
    public String getFIELD8() {
        return (String) get(TBTHB1DOWN.FIELD8);
    }

    /**
     * �t�B�[���h�W��ݒ肷��
     * @param val �t�B�[���h�W
     */
    public void setFIELD8(String val) {
        set(TBTHB1DOWN.FIELD8, val);
    }

    /**
     * �t�B�[���h�X���擾����
     * @return �t�B�[���h�X
     */
    public String getFIELD9() {
        return (String) get(TBTHB1DOWN.FIELD9);
    }

    /**
     * �t�B�[���h�X��ݒ肷��
     * @param val �t�B�[���h�X
     */
    public void setFIELD9(String val) {
        set(TBTHB1DOWN.FIELD9, val);
    }

    /**
     * �t�B�[���h�P�O���擾����
     * @return �t�B�[���h�P�O
     */
    public String getFIELD10() {
        return (String) get(TBTHB1DOWN.FIELD10);
    }

    /**
     * �t�B�[���h�P�O��ݒ肷��
     * @param val �t�B�[���h�P�O
     */
    public void setFIELD10(String val) {
        set(TBTHB1DOWN.FIELD10, val);
    }

    /**
     * �t�B�[���h�P�P���擾����
     * @return �t�B�[���h�P�P
     */
    public String getFIELD11() {
        return (String) get(TBTHB1DOWN.FIELD11);
    }

    /**
     * �t�B�[���h�P�P��ݒ肷��
     * @param val �t�B�[���h�P�P
     */
    public void setFIELD11(String val) {
        set(TBTHB1DOWN.FIELD11, val);
    }

    /**
     * �t�B�[���h�P�Q���擾����
     * @return �t�B�[���h�P�Q
     */
    public String getFIELD12() {
        return (String) get(TBTHB1DOWN.FIELD12);
    }

    /**
     * �t�B�[���h�P�Q��ݒ肷��
     * @param val �t�B�[���h�P�Q
     */
    public void setFIELD12(String val) {
        set(TBTHB1DOWN.FIELD12, val);
    }

}
