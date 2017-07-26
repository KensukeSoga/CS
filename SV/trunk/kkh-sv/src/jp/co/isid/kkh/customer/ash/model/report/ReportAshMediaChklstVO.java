package jp.co.isid.kkh.customer.ash.model.report;

import java.math.BigDecimal;





import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���[�iAsh)VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/20 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshMediaChklstVO extends AbstractModel {

    private static final long serialVersionUID = 7;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportAshMediaChklstVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportAshMediaChklstVO();
    }

    /**
     * �������ԍ���ݒ肵�܂��B
     * @param val String SeikyuNo
     */
    public void setSeikyuNo(String val) {
        set("SEIKYUNO", val);
    }

    /**
     * �������ԍ���Ԃ��܂��B
     * @return String SeikyuNo
     */
    public String getSeikyuNo() {
        return (String) get("SEIKYUNO");
    }

    /**
     * �}�̋敪��ݒ肵�܂��B
     * @param val String BaitaiKbn
     */
    public void setBaitaiKbn(String val) {
        set("BAITAIKBN", val);
    }

    /**
     * �}�̋敪��Ԃ��܂��B
     * @return String BaitaiKbn
     */
    public String getBaitaiKbn() {
        return (String) get("BAITAIKBN");
    }

    /**
     * �}�̃R�[�h��ݒ肵�܂��B
     * @param val String BaitaiCD
     */
    public void setBaitaiCD(String val) {
        set("BAITAICD", val);
    }

    /**
     * �}�̃R�[�h��Ԃ��܂��B
     * @return String BaitaiCD
     */
    public String getBaitaiCD() {
        return (String) get("BAITAICD");
    }

    /**
     * �������z��ݒ肵�܂��B
     * @param val String SeikyukinKomi
     */
    public void setSeikyukinKomi(BigDecimal val) {
        set("SEIKYUKINKOMI", val);
    }

    /**
     * �������z��Ԃ��܂��B
     * @return String SeikyukinKomi
     */
    public BigDecimal getSeikyukinKomi() {
        return (BigDecimal) get("SEIKYUKINKOMI");
    }

    /**
     * �������z��ݒ肵�܂��B
     * @param val String Seikyukin
     */
    public void setSeikyukin(BigDecimal val) {
        set("SEIKYUKIN", val);
    }

    /**
     * �������z��Ԃ��܂��B
     * @return String Seikyukin
     */
    public BigDecimal getSeikyukin() {
        return (BigDecimal) get("SEIKYUKIN");
    }

    /**
     * �ǖ���ݒ肵�܂��B
     * @param val String KyokuNM
     */
    public void setKyokuNM(String val) {
        set("KYOKUNM", val);
    }

    /**
     * �ǖ���Ԃ��܂��B
     * @return String KyokuNM
     */
    public String getKyokuNM() {
        return (String) get("KYOKUNM");
    }

    /**
     * �ǃR�[�h��ݒ肵�܂��B
     * @param val String KyokuCD
     */
    public void setKyokuCD(String val) {
        set("KYOKUCD", val);
    }

    /**
     * �ǃR�[�h��Ԃ��܂��B
     * @return String KyokuCD
     */
    public String getKyokuCD() {
        return (String) get("KYOKUCD");
    }

    /**
     * �ǔ}�̃R�[�h��ݒ肵�܂��B
     * @param val String KyokuBaitaiCd
     */
    public void setKyokuBaitaiCd(String val) {
        set("KYOKUBAITAICD", val);
    }

    /**
     * �ǔ}�̃R�[�h��Ԃ��܂��B
     * @return String KyokuBaitaiCd
     */
    public String getKyokuBaitaiCd() {
        return (String) get("KYOKUBAITAICD");
    }

    /**
     * �i�햼��ݒ肵�܂��B
     * @param val String HinsyuNM
     */
    public void setHinsyuNM(String val) {
        set("HINSYUNM", val);
    }

    /**
     * �i�햼��Ԃ��܂��B
     * @return String HinsyuNM
     */
    public String getHinsyuNM() {
        return (String) get("HINSYUNM");
    }

    /**
     * �i��R�[�h��ݒ肵�܂��B
     * @param val String HinsyuCD
     */
    public void setHinsyuCD(String val) {
        set("HINSYUCD", val);
    }

    /**
     * �i��R�[�h��Ԃ��܂��B
     * @return String HinsyuCD
     */
    public String getHinsyuCD() {
        return (String) get("HINSYUCD");
    }

    /**
     * �i��}�̃R�[�h��ݒ肵�܂��B
     * @param val String HinsyuBaitaiCd
     */
    public void setHinsyuBaitaiCd(String val) {
        set("HINSYUBAITAICD", val);
    }

    /**
     * �i��}�̃R�[�h��Ԃ��܂��B
     * @return String HinsyuBaitaiCd
     */
    public String getHinsyuBaitaiCd() {
        return (String) get("HINSYUBAITAICD");
    }

    /**
     * �㗝�X�R�[�h��ݒ肵�܂��B
     * @param val String DairitenCD
     */
    public void setDairitenCD(String val) {
        set("DAIRITENCD", val);
    }

    /**
     * �㗝�X�R�[�h��Ԃ��܂��B
     * @return String DairitenCD
     */
    public String getDairitenCD() {
        return (String) get("DAIRITENCD");
    }

    /**
     * �ԑg�R�[�h��ݒ肵�܂��B
     * @param val String BangumiCD
     */
    public void setBangumiCD(String val) {
        set("BANGUMICD", val);
    }

    /**
     * �ԑg�R�[�h��Ԃ��܂��B
     * @return String BangumiCD
     */
    public String getBangumiCD() {
        return (String) get("BANGUMICD");
    }
    /**
     * ������ݒ肵�܂��B
     * @param val String Kenmei
     */
    public void setKenmei(String val) {
        set("KENMEI", val);
    }

    /**
     * ������Ԃ��܂��B
     * @return String Kenmei
     */
    public String getKenmei() {
        return (String) get("KENMEI");
    }

    /**
     * �A�Ԃ�ݒ肵�܂��B
     * @param val String Renban
     */
    public void setRenbn(String val) {
        set(TBTHB2KMEI.RENBN, val);
    }

    /**
     * �A�Ԃ�Ԃ��܂��B
     * @return String Renban
     */
    public String getRenbn() {
        return (String) get(TBTHB2KMEI.RENBN);
    }

    /**
     * ��No��ݒ肵�܂��B
     * @param val String JyutNo
     */
    public void setJyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * ��No��Ԃ��܂��B
     * @return String JyutNo
     */
    public String getJyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * �󒍖���No��ݒ肵�܂��B
     * @param val String JyMeiNo
     */
    public void setJyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * �󒍖���No��Ԃ��܂��B
     * @return String JyMeiNo
     */
    public String getJyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * ���㖾��No��ݒ肵�܂��B
     * @param val String UrMeiNo
     */
    public void setUrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * ���㖾��No��Ԃ��܂��B
     * @return String UrMeiNo
     */
    public String getUrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * ��ǂ�ݒ肵�܂��B
     * @param val String Keykyoku
     */
    public void setKeykyoku(String val) {
        set("KEYKYOKU", val);
    }

    /**
     * ��ǂ�Ԃ��܂��B
     * @return String Keykyoku
     */
    public String getKeykyoku() {
        return (String) get("KEYKYOKU");
    }

    /**
     * �G�����ނ�ݒ肵�܂��B
     * @param val String Code6
     */
    public void setCode6(String val) {
        set(TBTHB2KMEI.CODE6, val);
    }

    /**
     * �G�����ނ�Ԃ��܂��B
     * @return String Code6
     */
    public String getCode6() {
        return (String) get(TBTHB2KMEI.CODE6);
    }

    /**
     * �Ǘ��̂�ݒ肵�܂��B
     * @param val String KyokuRyaku
     */
    public void setKyokuRyaku(String val) {
        set("KYOKURYAKU", val);
    }

    /**
     * �Ǘ��̂�Ԃ��܂��B
     * @return String KyokuRyaku
     */
    public String getKyokuRyaku() {
        return (String) get("KYOKURYAKU");
    }
    /**
     * ����ݒ肵�܂��B
     * @param val String Sonota10
     */
    public void setSonota10(String val) {
        set(TBTHB2KMEI.SONOTA10 , val);
    }

    /**
     * ����Ԃ��܂��B
     * @return String Sonota10
     */
    public String getSonota10() {
        return (String) get(TBTHB2KMEI.SONOTA10);
    }

    /**
     * �ŗ���ݒ肵�܂��B
     * @param val String Ritu1
     */
    public void setRitu1(BigDecimal val) {
        set(TBTHB2KMEI.RITU1 , val);
    }

    /**
     * �ŗ���Ԃ��܂��B
     * @return String Ritu1
     */
    public BigDecimal getRitu1() {
        return (BigDecimal) get(TBTHB2KMEI.RITU1);
    }

    /**
     * �A�b�v���[�h���Q�Ή��B
     * @param val String Field6
     */
    public void setField6(String val) {
        set(TBTHBAMST.FIELD6 , val);
    }

    /**
     * �A�b�v���[�h���Q�Ή�
     * @return String Field6
     */
    public String getField6() {
        return (String) get(TBTHBAMST.FIELD6);
    }

}
