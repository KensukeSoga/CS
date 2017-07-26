package jp.co.isid.kkh.model.common;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU29CC;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * マスタデータVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/04 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class CommonCodeMasterVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public CommonCodeMasterVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new CommonCodeMasterVO();
    }

        /**
    * MEU29_KYCDKNDを設定します。
    * @param val String MEU29_KYCDKND
    */
   public void setKYCDKND(String val) {
       set(TBRCMN_MEU29CC.MEU29_KYCDKND, val);
   }

   /**
    * MEU29_KYCDKNDを返します。
    * @return String MEU29_KYCDKND
    */
   public String getKYCDKND() {
       return (String) get(TBRCMN_MEU29CC.MEU29_KYCDKND);
   }

   /**
    * MEU29_KYCDを設定します。
    * @param val String MEU29_KYCD
    */
   public void setKYCD(String val) {
       set(TBRCMN_MEU29CC.MEU29_KYCD, val);
   }

   /**
    * MEU29_KYCDを返します。
    * @return String MEU29_KYCD
    */
   public String getKYCD() {
       return (String) get(TBRCMN_MEU29CC.MEU29_KYCD);
   }

   /**
    * MEU29_HKYMDを設定します。
    * @param val String MEU29_HKYMD
    */
   public void setHKYMD(String val) {
       set(TBRCMN_MEU29CC.MEU29_HKYMD, val);
   }

   /**
    * MEU29_HKYMDを返します。
    * @return String MEU29_HKYMD
    */
   public String getHKYMD() {
       return (String) get(TBRCMN_MEU29CC.MEU29_HKYMD);
   }

   /**
    * MEU29_HAISYMDを設定します。
    * @param val String MEU29_HAISYMD
    */
   public void setHAISYMD(String val) {
       set(TBRCMN_MEU29CC.MEU29_HAISYMD, val);
   }

   /**
    * MEU29_HAISYMDを返します。
    * @return String MEU29_HAISYMD
    */
   public String getHAISYMD() {
       return (String) get(TBRCMN_MEU29CC.MEU29_HAISYMD);
   }

   /**
    * MEU29_NAIYKNを設定します。
    * @param val String MEU29_NAIYKN
    */
   public void setNAIYKN(String val) {
       set(TBRCMN_MEU29CC.MEU29_NAIYKN, val);
   }

   /**
    * MEU29_NAIYKNを返します。
    * @return String MEU29_NAIYKN
    */
   public String getNAIYKN() {
       return (String) get(TBRCMN_MEU29CC.MEU29_NAIYKN);
   }

   /**
    * MEU29_NAIYJを設定します。
    * @param val String MEU29_NAIYJ
    */
   public void setNAIYJ(String val) {
       set(TBRCMN_MEU29CC.MEU29_NAIYJ, val);
   }

   /**
    * MEU29_NAIYJを返します。
    * @return String MEU29_NAIYJ
    */
   public String getNAIYJ() {
       return (String) get(TBRCMN_MEU29CC.MEU29_NAIYJ);
   }

   /**
    * MEU29_YOBI1を設定します。
    * @param val String MEU29_YOBI1
    */
   public void setYOBI1(String val) {
       set(TBRCMN_MEU29CC.MEU29_YOBI1, val);
   }

   /**
    * MEU29_YOBI1を返します。
    * @return String MEU29_YOBI1
    */
   public String getYOBI1() {
       return (String) get(TBRCMN_MEU29CC.MEU29_YOBI1);
   }

   /**
    * MEU29_HOSOKを設定します。
    * @param val String MEU29_HOSOK
    */
   public void setHOSOK(String val) {
       set(TBRCMN_MEU29CC.MEU29_HOSOK, val);
   }

   /**
    * MEU29_HOSOKを返します。
    * @return String MEU29_HOSOK
    */
   public String getHOSOK() {
       return (String) get(TBRCMN_MEU29CC.MEU29_HOSOK);
   }

   /**
    * MEU29_YOBI2を設定します。
    * @param val String MEU29_YOBI2
    */
   public void setYOBI2(String val) {
       set(TBRCMN_MEU29CC.MEU29_YOBI2, val);
   }

   /**
    * MEU29_YOBI2を返します。
    * @return String MEU29_YOBI2
    */
   public String getYOBI2() {
       return (String) get(TBRCMN_MEU29CC.MEU29_YOBI2);
   }

}
