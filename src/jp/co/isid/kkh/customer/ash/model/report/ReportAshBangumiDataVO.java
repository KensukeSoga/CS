package jp.co.isid.kkh.customer.ash.model.report;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 帳票（Ash)VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/23 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshBangumiDataVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public ReportAshBangumiDataVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new ReportAshBangumiDataVO();
    }

    /**
     * 番組コードを設定します。
     * @param val String BangumiCD
     */
    public void setBangumiCD(String val) {
          set("BANGUMICD", val);
        }

    /**
     * 番組コードを返します。
     * @return String BangumiCD
     */
    public String getBangumiCD() {
          return (String) get("BANGUMICD");
        }

    /**
     * 番組名を設定します。
     * @param val String BangumiNM
     */
    public void setBangumiNM(String val) {
          set("BANGUMINM", val);
        }
    /**
     * 番組名を返します。
     * @return String BangumiNM
     */
    public String getBangumiNM() {
          return (String) get("BANGUMINM");
        }

    /**
     * 番組名を設定します。
     * @param val String BangumiNM
     */
    public void setSybt(String val) {
          set("SYBT", val);
        }
    /**
     * 番組名を返します。
     * @return String BangumiNM
     */
    public String getSybt() {
          return (String) get("SYBT");
        }

//    /**
//	*FIELD1を設定します。
//	* @param val String FIELD1
//	*/
//	public void setField1(String val) {
//		  set(TBTHBAMST.FIELD1, val);
//		}
//	/**
//	*FIELD1を返します。
//	* @return String FIELD1
//	*/
//	public String getField1() {
//		  return (String) get(TBTHBAMST.FIELD1);
//		}
//    /**
//	*FIELD2を設定します。
//	* @param val String FIELD2
//	*/
//	public void setField2(String val) {
//		  set(TBTHBAMST.FIELD2, val);
//		}
//	/**
//	*FIELD2を返します。
//	* @return String FIELD2
//	*/
//	public String getField2() {
//		  return (String) get(TBTHBAMST.FIELD2);
//		}
//    /**
//	*FIELD3を設定します。
//	* @param val String FIELD3
//	*/
//	public void setField3(String val) {
//		  set(TBTHBAMST.FIELD3, val);
//		}
//	/**
//	*FIELD3を返します。
//	* @return String FIELD3
//	*/
//	public String getField3() {
//		  return (String) get(TBTHBAMST.FIELD3);
//		}
//    /**
//	*FIELD4を設定します。
//	* @param val String FIELD4
//	*/
//	public void setField4(String val) {
//		  set(TBTHBAMST.FIELD4, val);
//		}
//	/**
//	*FIELD4を返します。
//	* @return String FIELD4
//	*/
//	public String getField4() {
//		  return (String) get(TBTHBAMST.FIELD4);
//		}
//    /**
//	*FIELD11を設定します。
//	* @param val String FIELD11
//	*/
//	public void setField11(String val) {
//		  set(TBTHBAMST.FIELD11, val);
//		}
//	/**
//	*FIELD11を返します。
//	* @return String FIELD11
//	*/
//	public String getField11() {
//		  return (String) get(TBTHBAMST.FIELD11);
//		}

}