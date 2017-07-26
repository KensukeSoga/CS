package jp.co.isid.kkh.customer.epson.model.report;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ��o���[�i�G�v�\��)VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/5 JSE YS)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSubMissionVO extends AbstractModel {

    /** */
    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportEpsonSubMissionVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportEpsonSubMissionVO();
    }

    /**
     * �擪����擾����
     * @return �擪��
     */
    public String getFirstCol() {
        return (String) get("FIRSTCOL");
    }

    /**
     * �擪���ݒ肷��
     * @param val �擪��
     */
    public void setFirstCol(String val) {
        set("FIRSTCOL", val);
    }

    /**
     * �`�[�o�^NO���擾����
     * @return �`�[�o�^NO
     */
    public String getDenpyoNo() {
        return (String) get("DENPYONO");
    }

    /**
     * �`�[�o�^NO��ݒ肷��
     * @param val �`�[�o�^NO
     */
    public void setDenpyoNo(String val) {
        set("DENPYONO", val);
    }

    /**
     * ����NO���擾����
     * @return ����NO
     */
    public String getMeisaiNo() {
        return (String) get("MEISAINO");
    }

    /**
     * ����NO��ݒ肷��
     * @param val ����NO
     */
    public void setMeisaiNo(String val) {
        set("MEISAINO", val);
    }

    /**
     * ���CD���擾����
     * @return ���CD
     */
    public String getKaishCd() {
        return (String) get("KAISHCD");
    }

    /**
     * ���CD��ݒ肷��
     * @param val ���CD
     */
    public void setKaishCd(String val) {
        set("KAISHCD", val);
    }

    /**
     * �N�[����CD���擾����
     * @return �N�[����CD
     */
    public String getKihyoBmnCd() {
        return (String) get("KIHYOBMNCD");
    }

    /**
     * �N�[����CD��ݒ肷��
     * @param val �N�[����CD
     */
    public void setKihyoBmnCd(String val) {
        set("KIHYOBMNCD", val);
    }

    /**
     * �d����R�[�h���擾����
     * @return �d����R�[�h
     */
    public String getShireskCd() {
        return (String) get("SHIIRESKCD");
    }

    /**
     * �d����R�[�h��ݒ肷��
     * @param val �d����R�[�h
     */
    public void setShireskCd(String val) {
        set("SHIIRESKCD", val);
    }

    /**
     * �ʉ�CD���擾����
     * @return �ʉ�CD
     */
    public String getTukaCd() {
        return (String) get("TUKACD");
    }

    /**
     * �ʉ�CD��ݒ肷��
     * @param val �ʉ�CD
     */
    public void setTukaCd(String val) {
        set("TUKACD", val);
    }

    /**
     * �����敔��CD���擾����
     * @return �����敔��CD
     */
    public String getHatskCd() {
        return (String) get("HATSKCD");
    }

    /**
     * �����敔��CD��ݒ肷��
     * @param val �����敔��CD
     */
    public void setHatskCd(String val) {
        set("HATSKCD", val);
    }

    /**
     * �v������擾����
     * @return �v���
     */
    public String getKeijyobi() {
        return (String) get("KEIJYOBI");
    }

    /**
     * �v�����ݒ肷��
     * @param val �v���
     */
    public void setKeijyobi(String val) {
        set("KEIJYOBI", val);
    }

    /**
     * ���Z���[�g���擾����
     * @return ���Z���[�g
     */
    public BigDecimal getRate() {
        return (BigDecimal) get("RATE");
    }

    /**
     * ���Z���[�g��ݒ肷��
     * @param val ���Z���[�g
     */
    public void setRate(BigDecimal val) {
        set("RATE", val);
    }

    /**
     * ����搿��No���擾����
     * @return ����搿��No
     */
    public String getSeiNo() {
        return (String) get("SEINO");
    }

    /**
     * ����搿��No��ݒ肷��
     * @param val ����搿��No
     */
    public void setSeiNo(String val) {
        set("SEINO", val);
    }

    /**
     * ���O�ŋ敪���擾����
     * @return ���O�ŋ敪
     */
    public BigDecimal getZeiKbn() {
        return (BigDecimal) get("ZEIKBN");
    }

    /**
     * ���O�ŋ敪��ݒ肷��
     * @param val ���O�ŋ敪
     */
    public void setZeiKbn(BigDecimal val) {
        set("ZEIKBN", val);
    }

    /**
     * ������ʃR�[�h���擾����
     * @return ������ʃR�[�h
     */
    public String getToriSikiCd() {
        return (String) get("TORISIKICD");
    }

    /**
     * ������ʃR�[�h��ݒ肷��
     * @param val ������ʃR�[�h
     */
    public void setToriSikiCd(String val) {
        set("TORISIKICD", val);
    }

    /**
     * �����Z���^���擾����
     * @return �����Z���^
     */
    public String getGenkaCent() {
        return (String) get("GENKACENT");
    }

    /**
     * �����Z���^��ݒ肷��
     * @param val �����Z���^
     */
    public void setGenkaCent(String val) {
        set("GENKACENT", val);
    }

    /**
     * ���v�Z���^���擾����
     * @return ���v�Z���^
     */
    public String getRiekiCent() {
        return (String) get("RIEKICENT");
    }

    /**
     * ���v�Z���^��ݒ肷��
     * @param val ���v�Z���^
     */
    public void setRiekiCent(String val) {
        set("RIEKICENT", val);
    }

    /**
     * �w�}No���擾����
     * @return �w�}No
     */
    public String getSashizuNo() {
        return (String) get("SASHIZUNO");
    }

    /**
     * �w�}No��ݒ肷��
     * @param val �w�}No
     */
    public void setSashizuNo(String val) {
        set("SASHIZUNO", val);
    }

    /**
     * �Z�O�����g�w�}�ԍ����擾����
     * @return �Z�O�����g�w�}�ԍ�
     */
    public String getSeguSashiNo() {
        return (String) get("SEGUSASHINO");
    }

    /**
     * �Z�O�����g�w�}�ԍ���ݒ肷��
     * @param val �Z�O�����g�w�}�ԍ�
     */
    public void setSeguSashiNo(String val) {
        set("SEGUSASHINO", val);
    }

    /**
     * �����i���֐�j���擾����
     * @return �����i���֐�j
     */
    public String getToriSaki() {
        return (String) get("TORISAKI");
    }

    /**
     * �����i���֐�j��ݒ肷��
     * @param val �����i���֐�j
     */
    public void setToriSaki(String val) {
        set("TORISAKI", val);
    }

    /**
     * ��̓I������e���擾����
     * @return ��̓I������e
     */
    public String getToriNaiyo() {
        return (String) get("TORINAIYO");
    }

    /**
     * ��̓I������e��ݒ肷��
     * @param val ��̓I������e
     */
    public void setToriNaiyo(String val) {
        set("TORINAIYO", val);
    }

    /**
     * ������z���擾����
     * @return ������z
     */
    public BigDecimal getToriGak() {
        return (BigDecimal) get("TORIGAK");
    }

    /**
     * ������z��ݒ肷��
     * @param val ������z
     */
    public void setToriGak(BigDecimal val) {
        set("TORIGAK", val);
    }

    /**
     * ����Ŋz���擾����
     * @return ����Ŋz
     */
    public BigDecimal getSyohiGak() {
        return (BigDecimal) get("SYOHIGAK");
    }

    /**
     * ����Ŋz��ݒ肷��
     * @param val ����Ŋz
     */
    public void setSyohiGak(BigDecimal val) {
        set("SYOHIGAK", val);
    }

    /**
     * ���Z���z���擾����
     * @return ���Z���z
     */
    public String getKansanGak() {
        return (String) get("KANSANGAK");
    }

    /**
     * ���Z���z��ݒ肷��
     * @param val ���Z���z
     */
    public void setKansanGak(String val) {
        set("KANSANGAK", val);
    }

    /**
     * ���Z����Ŋz���擾����
     * @return ���Z����Ŋz
     */
    public String getKansanSGak() {
        return (String) get("KANSANSGAK");
    }

    /**
     * ���Z����Ŋz��ݒ肷��
     * @param val ���Z����Ŋz
     */
    public void setKansanSGak(String val) {
        set("KANSANSGAK", val);
    }

    /**
     * ����Key���擾����
     * @return ����Key
     */
    public String getKeshikomiKey() {
        return (String) get("KESHIKOMIKEY");
    }

    /**
     * ����Key��ݒ肷��
     * @param val ����Key
     */
    public void setKeshikomiKey(String val) {
        set("KESHIKOMIKEY", val);
    }

    /**
     * �i�ڃR�[�h���擾����
     * @return �i�ڃR�[�h
     */
    public String getHinmokuCd() {
        return (String) get("HINMOKUCD");
    }

    /**
     * �i�ڃR�[�h��ݒ肷��
     * @param val �i�ڃR�[�h
     */
    public void setHinmokuCd(String val) {
        set("HINMOKUCD", val);
    }

    /**
     * �i�ږ��̂��擾����
     * @return �i�ږ���
     */
    public String getHinmokuMei() {
        return (String) get("HINMOKUMEI");
    }

    /**
     * �i�ږ��̂�ݒ肷��
     * @param val �i�ږ���
     */
    public void setHinmokuMei(String val) {
        set("HINMOKUMEI", val);
    }

    /**
     * �^�Ԃ��擾����
     * @return �^��
     */
    public String getKataban() {
        return (String) get("KATABAN");
    }

    /**
     * �^�Ԃ�ݒ肷��
     * @param val �^��
     */
    public void setKataban(String val) {
        set("KATABAN", val);
    }

    /**
     * ���ʂ��擾����
     * @return ����
     */
    public String getSuryo() {
        return (String) get("SURYO");
    }

    /**
     * ���ʂ�ݒ肷��
     * @param val ����
     */
    public void setSuryo(String val) {
        set("SURYO", val);
    }

    /**
     * �P�ʂ��擾����
     * @return �P��
     */
    public String getTani() {
        return (String) get("TANI");
    }

    /**
     * �P�ʂ�ݒ肷��
     * @param val �P��
     */
    public void setTani(String val) {
        set("TANI", val);
    }

    /**
     * ����P�����擾����
     * @return ����P��
     */
    public String getToriTank() {
        return (String) get("TORITANK");
    }

    /**
     * ����P����ݒ肷��
     * @param val ����P��
     */
    public void setToriTank(String val) {
        set("TORITANK", val);
    }

    /**
     * ���Z�P�����擾����
     * @return ���Z�P��
     */
    public String getKansanTank() {
        return (String) get("KANSANTANK");
    }

    /**
     * ���Z�P����ݒ肷��
     * @param val ���Z�P��
     */
    public void setKansanTank(String val) {
        set("KANSANTANK", val);
    }

    /**
     * P/ONo���擾����
     * @return P/ONo
     */
    public String getPoNo() {
        return (String) get("PONO");
    }

    /**
     * P/ONo��ݒ肷��
     * @param val P/ONo
     */
    public void setPoNo(String val) {
        set("PONO", val);
    }

    /**
     * �_��No���擾����
     * @return �_��No
     */
    public String getKeiyakuNo() {
        return (String) get("KEIYAKUNO");
    }

    /**
     * �_��No��ݒ肷��
     * @param val �_��No
     */
    public void setKeiyakuNo(String val) {
        set("KEIYAKUNO", val);
    }

    /**
     * �g�c��No���擾����
     * @return �g�c��No
     */
    public String getRingiNo() {
        return (String) get("RINGINO");
    }

    /**
     * �g�c��No��ݒ肷��
     * @param val �g�c��No
     */
    public void setRingiNo(String val) {
        set("RINGINO", val);
    }

    /**
     * ����Ŏ�����z���擾����
     * @return ����Ŏ�����z
     */
    public String getGensenToriGak() {
        return (String) get("GENSENTORIGAK");
    }

    /**
     * ����Ŏ�����z��ݒ肷��
     * @param val ����Ŏ�����z
     */
    public void setGensenToriGak(String val) {
        set("GENSENTORIGAK", val);
    }

    /**
     * ����ŗ����擾����
     * @return ����ŗ�
     */
    public String getGensenZeiRitu() {
        return (String) get("GENSENZEIRITU");
    }

    /**
     * ����ŗ���ݒ肷��
     * @param val ����ŗ�
     */
    public void setGensenZeiRitu(String val) {
        set("GENSENZEIRITU", val);
    }

    /**
     * �O���Ώۋ敪���擾����
     * @return �O���Ώۋ敪
     */
    public String getMaeTaisyoKbn() {
        return (String) get("MAETAISYOKBN");
    }

    /**
     * �O���Ώۋ敪��ݒ肷��
     * @param val �O���Ώۋ敪
     */
    public void setMaeTaisyoKbn(String val) {
        set("MAETAISYOKBN", val);
    }

    /**
     * �����m��敪���擾����
     * @return �����m��敪
     */
    public String getJyokenKakuKbn() {
        return (String) get("JYOKENKAKUKBN");
    }

    /**
     * �����m��敪��ݒ肷��
     * @param val �����m��敪
     */
    public void setJyokenKakuKbn(String val) {
        set("JYOKENKAKUKBN", val);
    }

    /**
     * ���ԁiFrom�j���擾����
     * @return ���ԁiFrom�j
     */
    public String getKikanFrom() {
        return (String) get("KIKANFROM");
    }

    /**
     * ���ԁiFrom�j��ݒ肷��
     * @param val ���ԁiFrom�j
     */
    public void setKikanFrom(String val) {
        set("KIKANFROM", val);
    }

    /**
     * ���ԁiTo�j���擾����
     * @return ���ԁiTo�j
     */
    public String getKikanTo() {
        return (String) get("KIKANTO");
    }

    /**
     * ���ԁiTo�j��ݒ肷��
     * @param val ���ԁiTo�j
     */
    public void setKikanTo(String val) {
        set("KIKANTO", val);
    }

    /**
     * �U�֏������擾����
     * @return �U�֏���
     */
    public String getFurikaeJyoken() {
        return (String) get("FURIKAEJYOKEN");
    }

    /**
     * �U�֏�����ݒ肷��
     * @param val �U�֏���
     */
    public void setFurikaeJyoken(String val) {
        set("FURIKAEJYOKEN", val);
    }

    /**
     * �ŏI����擾����
     * @return �ŏI��
     */
    public String getLastCol() {
        return (String) get("LASTCOLN");
    }

    /**
     * �ŏI���ݒ肷��
     * @param val �ŏI��
     */
    public void setLastCol(String val) {
        set("LASTCOLN", val);
    }

}