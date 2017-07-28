package jp.co.isid.kkh.model.common;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU29CC;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �}�X�^�f�[�^VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/04 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class CommonCodeMasterVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public CommonCodeMasterVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new CommonCodeMasterVO();
    }

        /**
    * MEU29_KYCDKND��ݒ肵�܂��B
    * @param val String MEU29_KYCDKND
    */
   public void setKYCDKND(String val) {
       set(TBRCMN_MEU29CC.MEU29_KYCDKND, val);
   }

   /**
    * MEU29_KYCDKND��Ԃ��܂��B
    * @return String MEU29_KYCDKND
    */
   public String getKYCDKND() {
       return (String) get(TBRCMN_MEU29CC.MEU29_KYCDKND);
   }

   /**
    * MEU29_KYCD��ݒ肵�܂��B
    * @param val String MEU29_KYCD
    */
   public void setKYCD(String val) {
       set(TBRCMN_MEU29CC.MEU29_KYCD, val);
   }

   /**
    * MEU29_KYCD��Ԃ��܂��B
    * @return String MEU29_KYCD
    */
   public String getKYCD() {
       return (String) get(TBRCMN_MEU29CC.MEU29_KYCD);
   }

   /**
    * MEU29_HKYMD��ݒ肵�܂��B
    * @param val String MEU29_HKYMD
    */
   public void setHKYMD(String val) {
       set(TBRCMN_MEU29CC.MEU29_HKYMD, val);
   }

   /**
    * MEU29_HKYMD��Ԃ��܂��B
    * @return String MEU29_HKYMD
    */
   public String getHKYMD() {
       return (String) get(TBRCMN_MEU29CC.MEU29_HKYMD);
   }

   /**
    * MEU29_HAISYMD��ݒ肵�܂��B
    * @param val String MEU29_HAISYMD
    */
   public void setHAISYMD(String val) {
       set(TBRCMN_MEU29CC.MEU29_HAISYMD, val);
   }

   /**
    * MEU29_HAISYMD��Ԃ��܂��B
    * @return String MEU29_HAISYMD
    */
   public String getHAISYMD() {
       return (String) get(TBRCMN_MEU29CC.MEU29_HAISYMD);
   }

   /**
    * MEU29_NAIYKN��ݒ肵�܂��B
    * @param val String MEU29_NAIYKN
    */
   public void setNAIYKN(String val) {
       set(TBRCMN_MEU29CC.MEU29_NAIYKN, val);
   }

   /**
    * MEU29_NAIYKN��Ԃ��܂��B
    * @return String MEU29_NAIYKN
    */
   public String getNAIYKN() {
       return (String) get(TBRCMN_MEU29CC.MEU29_NAIYKN);
   }

   /**
    * MEU29_NAIYJ��ݒ肵�܂��B
    * @param val String MEU29_NAIYJ
    */
   public void setNAIYJ(String val) {
       set(TBRCMN_MEU29CC.MEU29_NAIYJ, val);
   }

   /**
    * MEU29_NAIYJ��Ԃ��܂��B
    * @return String MEU29_NAIYJ
    */
   public String getNAIYJ() {
       return (String) get(TBRCMN_MEU29CC.MEU29_NAIYJ);
   }

   /**
    * MEU29_YOBI1��ݒ肵�܂��B
    * @param val String MEU29_YOBI1
    */
   public void setYOBI1(String val) {
       set(TBRCMN_MEU29CC.MEU29_YOBI1, val);
   }

   /**
    * MEU29_YOBI1��Ԃ��܂��B
    * @return String MEU29_YOBI1
    */
   public String getYOBI1() {
       return (String) get(TBRCMN_MEU29CC.MEU29_YOBI1);
   }

   /**
    * MEU29_HOSOK��ݒ肵�܂��B
    * @param val String MEU29_HOSOK
    */
   public void setHOSOK(String val) {
       set(TBRCMN_MEU29CC.MEU29_HOSOK, val);
   }

   /**
    * MEU29_HOSOK��Ԃ��܂��B
    * @return String MEU29_HOSOK
    */
   public String getHOSOK() {
       return (String) get(TBRCMN_MEU29CC.MEU29_HOSOK);
   }

   /**
    * MEU29_YOBI2��ݒ肵�܂��B
    * @param val String MEU29_YOBI2
    */
   public void setYOBI2(String val) {
       set(TBRCMN_MEU29CC.MEU29_YOBI2, val);
   }

   /**
    * MEU29_YOBI2��Ԃ��܂��B
    * @return String MEU29_YOBI2
    */
   public String getYOBI2() {
       return (String) get(TBRCMN_MEU29CC.MEU29_YOBI2);
   }

}
