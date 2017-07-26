package jp.co.isid.kkh.customer.kmn.model.report;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.integ.tbl.TBTHB14SKDOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���[�i����_�����ꗗ�j�f�[�^VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/1/31 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class ReportKmnListVO extends AbstractModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportKmnListVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportKmnListVO();
    }

    //�I��
    public String Sentaku;
    //���e
    public String Naiyo;
    //����
    public String Atesaki;

    /**
     * �I����ݒ肵�܂��B
     * @param val String �I��
     */
    public void setSentaku(String val) {
        set(Sentaku, val);
    }

    /**
     * �I����Ԃ��܂��B
     * @return String �I��
     */
    public String getSentaku() {
        return (String) get(Sentaku);
    }

    /**
     * �o��No��ݒ肵�܂��B
     * @param val String �o��No
     */
    public void setShutNo(String val) {
        set(TBTHB2KMEI.CODE2, val);
    }

    /**
     * �o��No��Ԃ��܂��B
     * @return String �o��No
     */
    public String getShutNo() {
        return (String) get(TBTHB2KMEI.CODE2);
    }

    /**
     * �V�[�N�G���XNo��ݒ肵�܂��B
     * @param val String �V�[�N�G���XNo
     */
    public void setSeqNo(String val) {
        set(TBTHB2KMEI.CODE3, val);
    }

    /**
     * �V�[�N�G���XNo��Ԃ��܂��B
     * @return String �V�[�N�G���XNo
     */
    public String getSeqNo() {
        return (String) get(TBTHB2KMEI.CODE3);
    }

    /**
     * ��No��ݒ肵�܂��B
     * @param val String ��No
     */
    public void setJyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * ��No��Ԃ��܂��B
     * @return String ��No
     */
    public String getJyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * �󒍖���No��ݒ肵�܂��B
     * @param val String �󒍖���No
     */
    public void setJyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * �󒍖���No��Ԃ��܂��B
     * @return String �󒍖���No
     */
    public String getJyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * ���㖾��No��ݒ肵�܂��B
     * @param val String ���㖾��No
     */
    public void setUrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * ���㖾��No��Ԃ��܂��B
     * @return String ���㖾��No
     */
    public String getUrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * �A�Ԃ�ݒ肵�܂��B
     * @param val String �A��
     */
    public void setRenban(String val) {
        set(TBTHB2KMEI.RENBN, val);
    }

    /**
     * �A�Ԃ�Ԃ��܂��B
     * @return String �A��
     */
    public String getRenban() {
        return (String) get(TBTHB2KMEI.RENBN);
    }

    /**
     * ���e��ݒ肵�܂��B
     * @param val String ���e
     */
    public void setNaiyo(String val) {
        set(Naiyo, val);
    }

    /**
     * ���e��Ԃ��܂��B
     * @return String ���e
     */
    public String getNaiyo() {
        return (String) get(Naiyo);
    }

    /**
     * ��ڂ�ݒ肵�܂��B
     * @param String ���
     */
    public void setHimoku(String val) {
        set(TBTHB2KMEI.NAME1, val);
    }

    /**
     * ��ڂ�Ԃ��܂��B
     * @return String ���
     */
    public String getHimoku() {
        return (String) get(TBTHB2KMEI.NAME1);
    }

    /**
    * ����R�[�h��ݒ肵�܂��B
    * @param val String ����R�[�hNo
    */
   public void setBumonCd(String val) {
       set(TBTHB2KMEI.CODE1, val);
   }

   /**
    * ����R�[�h��Ԃ��܂��B
    * @return String ����R�[�hNo
    */
   public String getBumonCd() {
       return (String) get(TBTHB2KMEI.CODE1);
   }

   /**
    * ���喼��ݒ肵�܂��B
    * @param val String ���喼
    */
   public void setBumonNm(String val) {
       set(TBTHB2KMEI.NAME6, val);
   }

   /**
    * ���喼��Ԃ��܂��B
    * @return String ���喼
    */
   public String getBumonNm() {
       return (String) get(TBTHB2KMEI.NAME6);
   }

   /**
    * �����ݒ肵�܂��B
    * @param val String ����
    */
   public void setAtesaki(String val) {
       set(Atesaki, val);
   }

   /**
    * �����Ԃ��܂��B
    * @return String ����
    */
   public String getAtesaki() {
       return (String) get(Atesaki);
   }

    /**
     * ���Ԃ�ݒ肵�܂��B
     * @param val String ����
     */
    public void setKikan(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * ���Ԃ�Ԃ��܂��B
     * @return String ����
     */
    public String getKikan() {
        return (String) get(TBTHB2KMEI.NAME2);
    }

    /**
     * ���z��ݒ肵�܂��B
     * @param val BigDecimal ���z
     */
    public void setKingaku(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * ���z��Ԃ��܂��B
     * @return BigDecimal ���z
     */
    @XmlElement(required = true)
    public BigDecimal getKingaku() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

    /**
     * ���l��ݒ肵�܂��B
     * @param val String ���l
     */
    public void setBiko(String val) {
        set(TBTHB2KMEI.NAME15, val);
    }

    /**
     * ���l��Ԃ��܂��B
     * @return String ���l
     */
    public String getBiko() {
        return (String) get(TBTHB2KMEI.NAME15);
    }

    /**
     * ��������̃f�[�^����ݒ肵�܂��B
     * @param val String ��������̃f�[�^��
     */
    public void setSeiZumi(String val) {
        set("SKDOWN_CNT", val);
    }

    /**
     * ��������̃f�[�^����Ԃ��܂��B
     * @return String ��������̃f�[�^��
     */
    public String getSeiZumi() {
        return (String) get("SKDOWN_CNT");
    }

    /**
     * ��������̎�No��ݒ肵�܂��B
     * @param val String ��No
     */
    public void setSkJyutNo(String val) {
        set(TBTHB14SKDOWN.JYUTNO, val);
    }

    /**
     * ��������̎�No��Ԃ��܂��B
     * @return String ��No
     */
    public String getSkJyutNo() {
        return (String) get(TBTHB14SKDOWN.JYUTNO);
    }

    /**
     * �󒍂̎�No��ݒ肵�܂��B
     * @param val String ��No
     */
    public void setDJyutNo(String val) {
        set(TBTHB1DOWN.JYUTNO, val);
    }

    /**
     * �󒍂̎�No��Ԃ��܂��B
     * @return String ��No
     */
    public String getDJyutNo() {
        return (String) get(TBTHB1DOWN.JYUTNO);
    }

    /**
     * �󒍂̓������No��ݒ肵�܂��B
     * @param val String �������No
     */
    public void setDTJyutNo(String val) {
        set(TBTHB1DOWN.TJYUTNO, val);
    }

    /**
     * �󒍂̓������No��Ԃ��܂��B
     * @return String �������No
     */
    public String getDTJyutNo() {
        return (String) get(TBTHB1DOWN.TJYUTNO);
    }
}