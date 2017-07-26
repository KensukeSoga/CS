package jp.co.isid.kkh.customer.mac.model.report;

import java.math.BigDecimal;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 帳票（MAC)VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/1/12 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportMacLicenseeVO extends AbstractModel {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 新規インスタンスを構築します。
     */
    public ReportMacLicenseeVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportMacLicenseeVO();
    }


	/**
	* 料金を設定します。
	* @param val String 料金
	*/
	public void setSeiGak(BigDecimal val) {
	  set(TBTHB2KMEI.SEIGAK, val);
	}

	/**
	* 料金を返します。
	* @return String 料金
	*/
	public BigDecimal getSeiGak() {
	  return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
	}

	/**
	* CODE1を設定します。
	* @param val String CODE1
	*/
	public void setCode1(String val) {
	  set(TBTHB2KMEI.CODE1, val);
	}

	/**
	* CODE1を返します。
	* @return String CODE1
	*/
	public String getCode1() {
	  return (String) get(TBTHB2KMEI.CODE1);
	}

	/**
	* NAME1を設定します。
	* @param val String NAME1
	*/
	public void setName1(String val) {
	  set(TBTHB2KMEI.NAME1, val);
	}

	/**
	* NAME1を返します。
	* @return String NAME1
	*/
	public String getName1() {
	  return (String) get(TBTHB2KMEI.NAME1);
	}

	/**
	* NAME2を設定します。
	* @param val String NAME2
	*/
	public void setName2(String val) {
	  set(TBTHB2KMEI.NAME2, val);
	}

	/**
	* NAME2を返します。
	* @return String NAME2
	*/
	public String getName2() {
	  return (String) get(TBTHB2KMEI.NAME2);
	}
	/**
	* NAME3を設定します。
	* @param val String NAME3
	*/
	public void setName3(String val) {
	  set(TBTHB2KMEI.NAME3, val);
	}

	/**
	* NAME3を返します。
	* @return String NAME3
	*/
	public String getName3() {
	  return (String) get(TBTHB2KMEI.NAME3);
	}

	/**
	* 金額1を設定します。
	* @param val BigDecimal 金額1
	*/
	public void setKngk1(BigDecimal val) {
	  set(TBTHB2KMEI.KNGK1, val);
	}

	/**
	* 金額1を返します。
	* @return BigDecimal 金額1
	*/
	public BigDecimal getKngk1() {
	  return (BigDecimal) get(TBTHB2KMEI.KNGK1);
	}

	/**
	* 金額2を設定します。
	* @param val BigDecimal 金額2
	*/
	public void setKngk2(BigDecimal val) {
	  set(TBTHB2KMEI.KNGK2, val);
	}

	/**
	* 金額2を返します。
	* @return BigDecimal 金額2
	*/
	public BigDecimal getKngk2() {
	  return (BigDecimal) get(TBTHB2KMEI.KNGK2);
	}

	/**
	* SONOTA1を設定します。
	* @param val String SONOTA1
	*/
	public void setSonota1(String val) {
	  set(TBTHB2KMEI.SONOTA1, val);
	}

	/**
	* SONOTA1を返します。
	* @return String SONOTA1
	*/
	public String getSonota1() {
	  return (String) get(TBTHB2KMEI.SONOTA1);
	}

	/**
	 * 受注NOを設定します。
	 * @param val String 受注NO
	 */
	 public void setJyutNo(String val) {
	     set(TBTHB2KMEI.JYUTNO, val);
	 }

	 /**
	 * 受注NOを返します。
	 * @return String 受注NO
	 */
	 public String getJyutNo() {
	     return (String) get(TBTHB2KMEI.JYUTNO);
	 }

	/**
	* 受注明細NOを設定します。
	* @param val String 受注明細NO
	*/
	public void setJyMeiNo(String val) {
	  set(TBTHB2KMEI.JYMEINO, val);
	}

	/**
	* 受注明細NOを返します。
	* @return String 受注明細NO
	*/
	public String getJyMeiNo() {
	  return (String) get(TBTHB2KMEI.JYMEINO);
	}

	/**
	* 売上明細NOを設定します。
	* @param val String 売上明細NO
	*/
	public void setUrMeiNo(String val) {
	  set(TBTHB2KMEI.URMEINO, val);
	}

	/**
	* 売上明細NOを返します。
	* @return String 売上明細NO
	*/
	public String getUrMeiNo() {
	  return (String) get(TBTHB2KMEI.URMEINO);
	}

	/**
	* RENBNを設定します。
	* @param val String RENBN
	*/
	public void setRenbn(String val) {
	  set(TBTHB2KMEI.RENBN, val);
	}

	/**
	* RENBNを返します。
	* @return String RENBN
	*/
	public String getRenbn() {
	  return (String) get(TBTHB2KMEI.RENBN);
	}

	/**
	* Field4を設定します。
	* @param val String Field4
	*/
	public void setField4(String val){
	  set(TBTHBAMST.FIELD4,val);
	}

	/**
	* Field4を返します。
	* @return String Field4
	*/
	public String getField4(){
	 return (String)get(TBTHBAMST.FIELD4);
	}
	/**
	* Field12を設定します。
	* @param val String Field12
	*/
	public void setField12(String val){
	  set(TBTHBAMST.FIELD12,val);
	}

	/**
	* Field12を返します。
	* @return String Field12
	*/
	public String getField12(){
	 return (String)get(TBTHBAMST.FIELD12);
	}
	/**
	* Field5を設定します。
	* @param val String Field5
	*/
	public void setField5(String val){
	  set(TBTHBAMST.FIELD5,val);
	}

	/**
	* Field5を返します。
	* @return String Field5
	*/
	public String getField5(){
	 return (String)get(TBTHBAMST.FIELD5);
	}
	/**
	* Field6を設定します。
	* @param val String Field6
	*/
	public void setField6(String val){
	  set(TBTHBAMST.FIELD6,val);
	}

	/**
	* Field6を返します。
	* @return String Field6
	*/
	public String getField6(){
	 return (String)get(TBTHBAMST.FIELD6);
	}
	/**
	* Field10を設定します。
	* @param val String Field10
	*/
	public void setField10(String val){
	  set(TBTHBAMST.FIELD10,val);
	}

	/**
	* Field10を返します。
	* @return String Field10
	*/
	public String getField10(){
	 return (String)get(TBTHBAMST.FIELD10);
	}
	/**
	* Field11を設定します。
	* @param val String Field11
	*/
	public void setField11(String val){
	  set(TBTHBAMST.FIELD11,val);
	}

	/**
	* Field11を返します。
	* @return String Field11
	*/
	public String getField11(){
	 return (String)get(TBTHBAMST.FIELD11);
	}

	/**
	* Field20を設定します。
	* @param val String Field20
	*/
	public void setField20(String val){
	  set(TBTHBAMST.FIELD20,val);
	}
	/**
	* Field20を返します。
	* @return String Field20
	*/
	public String getField20(){
	 return (String)get(TBTHBAMST.FIELD20);
	}

	/**
	* SONOTA2を設定します。
	* @param val String SONOTA2
	*/
	public void setSonota2(String val) {
	  set(TBTHB2KMEI.SONOTA2, val);
	}

	/**
	* SONOTA2を返します。
	* @return String SONOTA2
	*/
	public String getSonota2() {
	  return (String) get(TBTHB2KMEI.SONOTA2);
	}

    //消費税対応 2013/10/21 add HLC H.Watabe start
    /**
     * Ritu1を設定します。
     * @param val BigDecimal Ritu1
     */
    public void setRitu1(BigDecimal val) {
      set(TBTHB2KMEI.RITU1, val);
    }

    /**
     * Ritu1を返します。
     * @return BigDecimal Ritu1
     */
    public BigDecimal getRitu1() {
      return (BigDecimal) get(TBTHB2KMEI.RITU1);
    }
    //消費税対応 2013/10/21 add HLC H.Watabe start
}