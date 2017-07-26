package jp.co.isid.kkh.customer.ash.model.report;

import java.math.BigDecimal;





import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �L����׏��iAsh�j�f�[�^VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/13 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshKoukokuHiVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportAshKoukokuHiVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportAshKoukokuHiVO();
    }

    /**
     * ����No��ݒ肵�܂�
     * @param val String ����No
     */
    public void setSeikyuNo(String val) {
        set("SEIKYUNO", val);
    }

    /**
     * ����No���擾���܂�
     * @return ����No
     */
    public String getSeikyuNo() {
        return (String) get("SEIKYUNO");
    }

    /**
     * �}�̃R�[�h��ݒ肵�܂�
     * @param val String �}�̃R�[�h
     */
    public void setBaitaiCD(String val) {
        set("BAITAICD", val);
    }

    /**
     * �}�̃R�[�h���擾���܂�
     * @return �}�̃R�[�h
     */
    public String getBaitaiCD() {
        return (String) get("BAITAICD");
    }

    /**
     * �������z��ݒ肵�܂�
     * @param val BigDecimal �������z
     */
    public void setSeikyukin(BigDecimal val) {
        set("SEIKYUKIN", val);
    }

    /**
     * �������z���擾���܂�
     * @return �������z
     */
    public BigDecimal getSeikyukin() {
        return (BigDecimal) get("SEIKYUKIN");
    }

    /**
     * �ǖ���ݒ肵�܂�
     * @param val String �ǖ�
     */
    public void setKyokuNM(String val) {
        set("KYOKUNM", val);
    }

    /**
     * �ǖ����擾���܂�
     * @return �ǖ�
     */
    public String getKyokuNM() {
        return (String) get("KYOKUNM");
    }

    /**
     * �ǃR�[�h��ݒ肵�܂�
     * @param val String �ǃR�[�h
     */
    public void setKyokuCD(String val) {
        set("KYOKUCD", val);
    }

    /**
     * �ǃR�[�h���擾���܂�
     * @return �ǃR�[�h
     */
    public String getKyokuCD() {
        return (String) get("KYOKUCD");
    }

    /**
     * �i�햼��ݒ肵�܂�
     * @param val String �i�햼
     */
    public void setHinsyuNM(String val) {
        set("HINSYUNM", val);
    }

    /**
     * �i�햼���擾���܂�
     * @return �i�햼
     */
    public String getHinsyuNM() {
        return (String) get("HINSYUNM");
    }

    /**
     * �i��R�[�h��ݒ肵�܂�
     * @param val String �i��R�[�h
     */
    public void setHinsyuCD(String val) {
        set("HINSYUCD", val);
    }

    /**
     * �i��R�[�h���擾���܂�
     * @return �i��R�[�h
     */
    public String getHinsyuCD() {
        return (String) get("HINSYUCD");
    }

    /**
     * �㗝�X�R�[�h��ݒ肵�܂�
     * @param val String �㗝�X�R�[�h
     */
    public void setDairitenCD(String val) {
        set("DAIRITENCD", val);
    }

    /**
     * �㗝�X�R�[�h���擾���܂�
     * @return �㗝�X�R�[�h
     */
    public String getDairitenCD() {
        return (String) get("DAIRITENCD");
    }

    /**
     * �ԑg�R�[�h��ݒ肵�܂�
     * @param val String �ԑg�R�[�h
     */
    public void setBangumiCD(String val) {
        set("BANGUMICD", val);
    }

    /**
     * �ԑg�R�[�h���擾���܂�
     * @return �ԑg�R�[�h
     */
    public String getBangumiCD() {
        return (String) get("BANGUMICD");
    }

    /**
     * ������ݒ肵�܂�
     * @param val String ����
     */
    public void setKenmei(String val) {
        set("KENMEI", val);
    }

    /**
     * �������擾���܂�
     * @return ����
     */
    public String getKenmei() {
        return (String) get("KENMEI");
    }

    /**
     * �A�Ԃ�ݒ肵�܂�
     * @param val String �A��
     */
    public void setRENBN(String val) {
        set("RENBN", val);
    }

    /**
     * �A�Ԃ��擾���܂�
     * @return �A��
     */
    public String getRENBN() {
        return (String) get("RENBN");
    }

    /**
     * ��NO��ݒ肵�܂�
     * @param val String ��NO
     */
    public void setJYUTNO(String val) {
        set("JYUTNO", val);
    }

    /**
     * ��NO���擾���܂�
     * @return ��NO
     */
    public String getJYUTNO() {
        return (String) get("JYUTNO");
    }

    /**
     * �󒍖���NO��ݒ肵�܂�
     * @param val String �󒍖���NO
     */
    public void setJYMEINO(String val) {
        set("JYMEINO", val);
    }

    /**
     * �󒍖���NO���擾���܂�
     * @return �󒍖���NO
     */
    public String getJYMEINO() {
        return (String) get("JYMEINO");
    }

    /**
     * ���㖾��NO��ݒ肵�܂�
     * @param val String ���㖾��NO
     */
    public void setURMEINO(String val) {
        set("URMEINO", val);
    }

    /**
     * ���㖾��NO���擾���܂�
     * @return ���㖾��NO
     */
    public String getURMEINO() {
        return (String) get("URMEINO");
    }

    /**
     * �L�[�ǂ�ݒ肵�܂�
     * @param val String �L�[��
     */
    public void setKeykyoku(String val) {
        set("KEYKYOKU", val);
    }

    /**
     * �L�[�ǂ��擾���܂�
     * @return �L�[��
     */
    public String getKeykyoku() {
        return (String) get("KEYKYOKU");
    }

    /**
     * �G���R�[�h��ݒ肵�܂�
     * @param val String �G���R�[�h
     */
    public void setCODE6(String val) {
        set("CODE6", val);
    }

    /**
     * �G���R�[�h���擾���܂�
     * @return �G���R�[�h
     */
    public String getCODE6() {
        return (String) get("CODE6");
    }

    /**
     * �Ǘ��̂�ݒ肵�܂�
     * @param val String �Ǘ���
     */
    public void setKyokuRyaku(String val) {
        set("KYOKURYAKU", val);
    }

    /**
     * �Ǘ��̂��擾���܂�
     * @return �Ǘ���
     */
    public String getKyokuRyaku() {
        return (String) get("KYOKURYAKU");
    }

    /**
     * �\�[�g�ԍ���ݒ肵�܂�
     * @param val String �\�[�g�ԍ�
     */
    public void setSONOTA10(String val) {
        set("SONOTA10", val);
    }

    /**
     * �\�[�g�ԍ����擾���܂�
     * @return �\�[�g�ԍ�
     */
    public String getSONOTA10() {
        return (String) get("SONOTA10");
    }

}