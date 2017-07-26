package jp.co.isid.kkh.customer.mac.model.report;

import java.math.BigDecimal;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���[�iMAC)VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/1/12 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportMacLicenseeVO extends AbstractModel {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportMacLicenseeVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportMacLicenseeVO();
    }


	/**
	* ������ݒ肵�܂��B
	* @param val String ����
	*/
	public void setSeiGak(BigDecimal val) {
	  set(TBTHB2KMEI.SEIGAK, val);
	}

	/**
	* ������Ԃ��܂��B
	* @return String ����
	*/
	public BigDecimal getSeiGak() {
	  return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
	}

	/**
	* CODE1��ݒ肵�܂��B
	* @param val String CODE1
	*/
	public void setCode1(String val) {
	  set(TBTHB2KMEI.CODE1, val);
	}

	/**
	* CODE1��Ԃ��܂��B
	* @return String CODE1
	*/
	public String getCode1() {
	  return (String) get(TBTHB2KMEI.CODE1);
	}

	/**
	* NAME1��ݒ肵�܂��B
	* @param val String NAME1
	*/
	public void setName1(String val) {
	  set(TBTHB2KMEI.NAME1, val);
	}

	/**
	* NAME1��Ԃ��܂��B
	* @return String NAME1
	*/
	public String getName1() {
	  return (String) get(TBTHB2KMEI.NAME1);
	}

	/**
	* NAME2��ݒ肵�܂��B
	* @param val String NAME2
	*/
	public void setName2(String val) {
	  set(TBTHB2KMEI.NAME2, val);
	}

	/**
	* NAME2��Ԃ��܂��B
	* @return String NAME2
	*/
	public String getName2() {
	  return (String) get(TBTHB2KMEI.NAME2);
	}
	/**
	* NAME3��ݒ肵�܂��B
	* @param val String NAME3
	*/
	public void setName3(String val) {
	  set(TBTHB2KMEI.NAME3, val);
	}

	/**
	* NAME3��Ԃ��܂��B
	* @return String NAME3
	*/
	public String getName3() {
	  return (String) get(TBTHB2KMEI.NAME3);
	}

	/**
	* ���z1��ݒ肵�܂��B
	* @param val BigDecimal ���z1
	*/
	public void setKngk1(BigDecimal val) {
	  set(TBTHB2KMEI.KNGK1, val);
	}

	/**
	* ���z1��Ԃ��܂��B
	* @return BigDecimal ���z1
	*/
	public BigDecimal getKngk1() {
	  return (BigDecimal) get(TBTHB2KMEI.KNGK1);
	}

	/**
	* ���z2��ݒ肵�܂��B
	* @param val BigDecimal ���z2
	*/
	public void setKngk2(BigDecimal val) {
	  set(TBTHB2KMEI.KNGK2, val);
	}

	/**
	* ���z2��Ԃ��܂��B
	* @return BigDecimal ���z2
	*/
	public BigDecimal getKngk2() {
	  return (BigDecimal) get(TBTHB2KMEI.KNGK2);
	}

	/**
	* SONOTA1��ݒ肵�܂��B
	* @param val String SONOTA1
	*/
	public void setSonota1(String val) {
	  set(TBTHB2KMEI.SONOTA1, val);
	}

	/**
	* SONOTA1��Ԃ��܂��B
	* @return String SONOTA1
	*/
	public String getSonota1() {
	  return (String) get(TBTHB2KMEI.SONOTA1);
	}

	/**
	 * ��NO��ݒ肵�܂��B
	 * @param val String ��NO
	 */
	 public void setJyutNo(String val) {
	     set(TBTHB2KMEI.JYUTNO, val);
	 }

	 /**
	 * ��NO��Ԃ��܂��B
	 * @return String ��NO
	 */
	 public String getJyutNo() {
	     return (String) get(TBTHB2KMEI.JYUTNO);
	 }

	/**
	* �󒍖���NO��ݒ肵�܂��B
	* @param val String �󒍖���NO
	*/
	public void setJyMeiNo(String val) {
	  set(TBTHB2KMEI.JYMEINO, val);
	}

	/**
	* �󒍖���NO��Ԃ��܂��B
	* @return String �󒍖���NO
	*/
	public String getJyMeiNo() {
	  return (String) get(TBTHB2KMEI.JYMEINO);
	}

	/**
	* ���㖾��NO��ݒ肵�܂��B
	* @param val String ���㖾��NO
	*/
	public void setUrMeiNo(String val) {
	  set(TBTHB2KMEI.URMEINO, val);
	}

	/**
	* ���㖾��NO��Ԃ��܂��B
	* @return String ���㖾��NO
	*/
	public String getUrMeiNo() {
	  return (String) get(TBTHB2KMEI.URMEINO);
	}

	/**
	* RENBN��ݒ肵�܂��B
	* @param val String RENBN
	*/
	public void setRenbn(String val) {
	  set(TBTHB2KMEI.RENBN, val);
	}

	/**
	* RENBN��Ԃ��܂��B
	* @return String RENBN
	*/
	public String getRenbn() {
	  return (String) get(TBTHB2KMEI.RENBN);
	}

	/**
	* Field4��ݒ肵�܂��B
	* @param val String Field4
	*/
	public void setField4(String val){
	  set(TBTHBAMST.FIELD4,val);
	}

	/**
	* Field4��Ԃ��܂��B
	* @return String Field4
	*/
	public String getField4(){
	 return (String)get(TBTHBAMST.FIELD4);
	}
	/**
	* Field12��ݒ肵�܂��B
	* @param val String Field12
	*/
	public void setField12(String val){
	  set(TBTHBAMST.FIELD12,val);
	}

	/**
	* Field12��Ԃ��܂��B
	* @return String Field12
	*/
	public String getField12(){
	 return (String)get(TBTHBAMST.FIELD12);
	}
	/**
	* Field5��ݒ肵�܂��B
	* @param val String Field5
	*/
	public void setField5(String val){
	  set(TBTHBAMST.FIELD5,val);
	}

	/**
	* Field5��Ԃ��܂��B
	* @return String Field5
	*/
	public String getField5(){
	 return (String)get(TBTHBAMST.FIELD5);
	}
	/**
	* Field6��ݒ肵�܂��B
	* @param val String Field6
	*/
	public void setField6(String val){
	  set(TBTHBAMST.FIELD6,val);
	}

	/**
	* Field6��Ԃ��܂��B
	* @return String Field6
	*/
	public String getField6(){
	 return (String)get(TBTHBAMST.FIELD6);
	}
	/**
	* Field10��ݒ肵�܂��B
	* @param val String Field10
	*/
	public void setField10(String val){
	  set(TBTHBAMST.FIELD10,val);
	}

	/**
	* Field10��Ԃ��܂��B
	* @return String Field10
	*/
	public String getField10(){
	 return (String)get(TBTHBAMST.FIELD10);
	}
	/**
	* Field11��ݒ肵�܂��B
	* @param val String Field11
	*/
	public void setField11(String val){
	  set(TBTHBAMST.FIELD11,val);
	}

	/**
	* Field11��Ԃ��܂��B
	* @return String Field11
	*/
	public String getField11(){
	 return (String)get(TBTHBAMST.FIELD11);
	}

	/**
	* Field20��ݒ肵�܂��B
	* @param val String Field20
	*/
	public void setField20(String val){
	  set(TBTHBAMST.FIELD20,val);
	}
	/**
	* Field20��Ԃ��܂��B
	* @return String Field20
	*/
	public String getField20(){
	 return (String)get(TBTHBAMST.FIELD20);
	}

	/**
	* SONOTA2��ݒ肵�܂��B
	* @param val String SONOTA2
	*/
	public void setSonota2(String val) {
	  set(TBTHB2KMEI.SONOTA2, val);
	}

	/**
	* SONOTA2��Ԃ��܂��B
	* @return String SONOTA2
	*/
	public String getSonota2() {
	  return (String) get(TBTHB2KMEI.SONOTA2);
	}

    //����őΉ� 2013/10/21 add HLC H.Watabe start
    /**
     * Ritu1��ݒ肵�܂��B
     * @param val BigDecimal Ritu1
     */
    public void setRitu1(BigDecimal val) {
      set(TBTHB2KMEI.RITU1, val);
    }

    /**
     * Ritu1��Ԃ��܂��B
     * @return BigDecimal Ritu1
     */
    public BigDecimal getRitu1() {
      return (BigDecimal) get(TBTHB2KMEI.RITU1);
    }
    //����őΉ� 2013/10/21 add HLC H.Watabe start
}