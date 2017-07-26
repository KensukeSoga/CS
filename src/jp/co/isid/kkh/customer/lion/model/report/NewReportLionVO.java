package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���C�I�����Ϗ��f�[�^�擾VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/03/5 fourm H.izawa)<BR>
 * �E����Œ[�������Ή�(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author fourm H.izawa
 *
 */
public class NewReportLionVO extends AbstractModel{

    private static final long serialVersionUID = 1L;

    /**����*/
    public static final String KENNAME = "KENNAME";

    /**���ς��藿��*/
    public static final String MITUMORIRYO = "MITUMORIRYO";

    /**�艿����*/
    public static final String TEIKARYOKIN = "TEIKARYOKIN";

    /**�X�y�[�X*/
    public static final String SPACE = "SPACE";

    /**����*/
    public static final String KIKAN = "KIKAN";

    /**���l*/
    public static final String BIKOU = "BIKOU";

    /**�����u�����h*/
    public static final String SEIKYUBRAND = "SEIKYUBRAND";

    /**�R�[�h*/
    public static final String CODE = "CODE";

    /**�G���A*/
    public static final String AREA = "AREA";

    /**�f�o*/
    public static final String KEISYUTU = "KEISYUTU";

    /**���*/
    public static final String SYURUI = "SYURUI";

    /**����*/
    public static final String SHIMEI = "SHIMEI";

    /**�G����*/
    public static final String ZASHIMEI = "ZASHIMEI";

    /**�G���R�[�h*/
    public static final String ZASHICD = "ZASHICD";

    /**�ԑg��*/
    public static final String BANMEI = "BANMEI";

    /**������*/
    public static final String HOUSOUKYOKU = "HOUSOUKYOKU";

    /**�}�̃R�[�h*/
    public static final String BAITAICD = "BAITAICD";

    /**�}�̎q�R�[�h*/
    public static final String BAITAIKOCD = "BAITAIKOCD";

    /**CM�b��*/
    public static final String CMBYOUSU = "CMBYOUSU";

    /**�{��*/
    public static final String HONSU = "HONSU";

    /**�ԑg�R�[�h*/
    public static final String BANCD = "BANCD";

    /**�ǎ��R�[�h*/
    public static final String KYOKUCD = "KYOKUCD";

    /**�������z���v*/
    public static final String SUMSEIGAK = "SUMSEIGAK";

    /**����Ŋz���v*/
    public static final String SUMSZEIGAK = "SUMSZEIGAK";

    /** ����ŗ� */
    public static final String SHOHIZEI_RITU = "SHOHIZEI_RITU";

    /**����Ŋz*/
    public static final String SZEIGAK = "SZEIGAK";

    /**��ږ�*/
    public static final String HIMOKUMEI = "HIMOKUMEI";

    /**�l�b�g��*/
    public static final String NETKYOKU =  "NETKYOKU";

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public NewReportLionVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new NewReportLionVO();
    }


    /**
     * �l�b�g�ǂ�ݒ肵�܂��B
     * @param val String NETKYOKU
     */
    public void setNetKyoku(String val) {
        set(NETKYOKU, val);
    }

    /**
     * �l�b�g�ǂ�Ԃ��܂��B
     * @return String NETKYOKU
     */
    public  String getNetKyoku() {
        return (String) get(NETKYOKU);
    }

    /**
     * ��ږ���ݒ肵�܂��B
     * @param val String HIMOKUMEI
     */
    public void setHimokumei(String val) {
        set(HIMOKUMEI, val);
    }

    /**
     *��ږ���Ԃ��܂��B
     * @return String HIMOKUMEI
     */
    public  String getHimokumei() {
        return (String) get(HIMOKUMEI);
    }

    /**
     * �������z��ݒ肵�܂��B
     * @param val String SZEIGAK
     */
    public void setSzeigak(String val) {
        set(SZEIGAK, val);
    }

    /**
     * �������z��Ԃ��܂��B
     * @return String SZEIGAK
     */
    public  String getSzeigak() {
        return (String) get(SZEIGAK);
    }


    /**
     * �������z���v��ݒ肵�܂��B
     * @param val String SUMSEIGAK
     */
    public void setSumseigak(String val) {
        set(SUMSEIGAK, val);
    }

    /**
     * �������z���v��Ԃ��܂��B
     * @return String SUMSEIGAK
     */
    public  String getSumseigak() {
        return (String) get(SUMSEIGAK);
    }

    /**
     * ����ŗ���ݒ肷��
     * @param val SHOHIZEI_RITU
     */
    public void setShohizeiRitu(BigDecimal val) {
        set(SHOHIZEI_RITU, val);
    }

    /**
     * ����ŗ����擾����
     * @return SHOHIZEI_RITU
     */
    public BigDecimal getShohizeiRitu() {
        return (BigDecimal) get(SHOHIZEI_RITU);
    }

    /**
     * ����Ŋz���v��ݒ肵�܂��B
     * @param val String SUMSZEIGAK
     */
    public void setSumszeigak(String val) {
        set(SUMSZEIGAK, val);
    }

    /**
     * ����Ŋz���v��Ԃ��܂��B
     * @return String SUMSZEIGAK
     */
    public  String getSumszeigak() {
        return (String) get(SUMSZEIGAK);
    }

    /**
     * ������ݒ肵�܂��B
     * @param val String KENNAME
     */
    public void setKenname(String val) {
        set(KENNAME, val);
    }

    /**
     * ������Ԃ��܂��B
     * @return String KENNAME
     */
    public  String getKenname() {
        return (String) get(KENNAME);
    }

    /**
     * ���ϗ���ݒ肵�܂��B
     * @param val String MITUMORIRYO
     */
    public void setMitumoriryo(String val) {
        set(MITUMORIRYO, val);
    }

    /**
     * ���ϗ���Ԃ��܂��B
     * @return String MITUMORIRYO
     */
    public  String getMitumoriryo() {
        return (String) get(MITUMORIRYO);
    }

    /**
     * �艿������ݒ肵�܂��B
     * @param val String TEIKARYOKIN
     */
    public void setTeikaryokin(String val) {
        set(TEIKARYOKIN, val);
    }

    /**
     * �艿������Ԃ��܂��B
     * @return String TEIKARYOKIN
     */
    public  String getTeikaryokin() {
        return (String) get(TEIKARYOKIN);
    }

    /**
     * �X�y�[�X��ݒ肵�܂��B
     * @param val String SPACE
     */
    public void setSpace(String val) {
        set(SPACE, val);
    }

    /**
     * �X�y�[�X��Ԃ��܂��B
     * @return String SPACE
     */
    public  String getSpace() {
        return (String) get(SPACE);
    }

    /**
     * ���Ԃ�ݒ肵�܂��B
     * @param val String KIKAN
     */
    public void setKikan(String val) {
        set(KIKAN, val);
    }

    /**
     * ���Ԃ�Ԃ��܂��B
     * @return String KIKAN
     */
    public  String getKikan() {
        return (String) get(KIKAN);
    }

    /**
     * ���l��ݒ肵�܂��B
     * @param val String BIKOU
     */
    public void setBikou(String val) {
        set(BIKOU, val);
    }

    /**
     * ���l��Ԃ��܂��B
     * @return String BIKOU
     */
    public  String getBikou() {
        return (String) get(BIKOU);
    }

    /**
     * �����u�����h��ݒ肵�܂��B
     * @param val String SEIKYUBRAND
     */
    public void setSeikyubrand(String val) {
        set(SEIKYUBRAND, val);
    }

    /**
     * �����u�����h��Ԃ��܂��B
     * @return String SEIKYUBRAND
     */
    public  String getSeikyubrand() {
        return (String) get(SEIKYUBRAND);
    }

    /**
     * �R�[�h��ݒ肵�܂��B
     * @param val String CODE
     */
    public void setCode(String val) {
        set(CODE, val);
    }

    /**
     * �R�[�h��Ԃ��܂��B
     * @return String CODE
     */
    public  String getCode() {
        return (String) get(CODE);
    }

    /**
     * �G���A��ݒ肵�܂��B
     * @param val String AREA
     */
    public void setArea(String val) {
      set(AREA, val);
    }

    /**
     * �G���A��Ԃ��܂��B
     * @return String AREA
     */
    public  String getArea() {
        return (String) get(AREA);
    }

    /**
     * �f�o��ݒ肵�܂��B
     * @param val String KEISYUTU
     */
    public void setKeisyutu(String val) {
        set(KEISYUTU, val);
    }

    /**
     * �f�o��Ԃ��܂��B
     * @return String KEISYUTU
     */
    public  String getKeisyutu() {
        return (String) get(KEISYUTU);
    }

    /**
     * ��ނ�ݒ肵�܂��B
     * @param val String SYURUI
     */
    public void setSyurui(String val) {
        set(SYURUI, val);
    }

    /**
     * ��ނ�Ԃ��܂��B
     * @return String SYURUI
     */
    public  String getSyurui() {
        return (String) get(SYURUI);
    }

    /**
     * ������ݒ肵�܂��B
     * @param val String SHIMEI
     */
    public void setShimei(String val) {
        set(SHIMEI, val);
    }

    /**
     * ������Ԃ��܂��B
     * @return String SHIMEI
     */
    public  String getShimei() {
        return (String) get(SHIMEI);
    }

    /**
     * �G������ݒ肵�܂��B
     * @param val String ZASHIMEI
     */
    public void setZashimei(String val) {
        set(ZASHIMEI, val);
    }

    /**
     * �G������Ԃ��܂��B
     * @return String ZASHIMEI
     */
    public  String getZashimei() {
        return (String) get(ZASHIMEI);
    }

    /**
     * �G���R�[�h��ݒ肵�܂��B
     * @param val String ZASHICD
     */
    public void setZashicd(String val) {
        set(ZASHICD, val);
    }

    /**
     * �G���R�[�h��Ԃ��܂��B
     * @return String ZASHICD
     */
    public  String getZashicd() {
        return (String) get(ZASHICD);
    }

    /**
     * �ԑg����ݒ肵�܂��B
     * @param val String BANMEI
     */
    public void setBanmei(String val) {
        set(BANMEI, val);
    }

    /**
     * �ԑg����Ԃ��܂��B
     * @return String BANMEI
     */
    public String getBanmei() {
        return (String) get(BANMEI);
    }

    /**
     * �����ǂ�ݒ肵�܂��B
     * @param val String HOUSOUKYOKU
     */
    public void setHousoukyoku(String val) {
        set(HOUSOUKYOKU, val);
    }

    /**
     * �����ǂ�Ԃ��܂��B
     * @return String HOUSOUKYOKU
     */
    public  String getHousoukyoku() {
        return (String) get(HOUSOUKYOKU);
    }

    /**
     * �}�̃R�[�h��ݒ肵�܂��B
     * @param val String BAITAICD
     */
    public void setBaitaicd(String val) {
        set(BAITAICD, val);
    }

    /**
     * �}�̃R�[�h��Ԃ��܂��B
     * @return String BAITAICD
     */
    public  String getBaitaicd() {
        return (String) get(BAITAICD);
    }

    /**
     * �}�̎q�R�[�h��ݒ肵�܂��B
     * @param val String BAITAIKOCD
     */
    public void setBaitaikocd(String val) {
        set(BAITAIKOCD, val);
    }

    /**
     * �}�̎q�R�[�h��Ԃ��܂��B
     * @return String BAITAIKOCD
     */
    public  String getBaitaikocd() {
        return (String) get(BAITAIKOCD);
    }

    /**
     * CM�b����ݒ肵�܂��B
     * @param val String CMBYOUSU
     */
    public void setCmbyousu(String val) {
        set(CMBYOUSU, val);
    }

    /**
     * CM�b����Ԃ��܂��B
     * @return String CMBYOUSU
     */
    public  String getCmbyousu() {
        return (String) get(CMBYOUSU);
    }

    /**
     * �{����ݒ肵�܂��B
     * @param val String HONSU
     */
    public void setHonsu(String val) {
        set(HONSU, val);
    }

    /**
     * �{����Ԃ��܂��B
     * @return String HONSU
     */
    public  String getHonsu() {
        return (String) get(HONSU);
    }

    /**
     * �ԑg�R�[�h��ݒ肵�܂��B
     * @param val String BANCD
     */
    public void setBanCd(String val) {
        set(BANCD, val);
    }

    /**
     * �ԑg�R�[�h��Ԃ��܂��B
     * @return String BANCD
     */
    public  String getBanCd() {
        return (String) get(BANCD);
    }

    /**
     * �ǎ��R�[�h��ݒ肵�܂��B
     * @param val String KYOKUCD
     */
    public void setKyokuCd(String val) {
        set(KYOKUCD, val);
    }

    /**
     * �ǎ��R�[�h��Ԃ��܂��B
     * @return String KYOKUCD
     */
    public  String getKyokuCd() {
        return (String) get(KYOKUCD);
    }

}
