package jp.co.isid.kkh.customer.ash.model.report;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���[�iAsh)VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/23 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshBangumiDataVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportAshBangumiDataVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportAshBangumiDataVO();
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
     * �ԑg����ݒ肵�܂��B
     * @param val String BangumiNM
     */
    public void setBangumiNM(String val) {
          set("BANGUMINM", val);
        }
    /**
     * �ԑg����Ԃ��܂��B
     * @return String BangumiNM
     */
    public String getBangumiNM() {
          return (String) get("BANGUMINM");
        }

    /**
     * �ԑg����ݒ肵�܂��B
     * @param val String BangumiNM
     */
    public void setSybt(String val) {
          set("SYBT", val);
        }
    /**
     * �ԑg����Ԃ��܂��B
     * @return String BangumiNM
     */
    public String getSybt() {
          return (String) get("SYBT");
        }

//    /**
//	*FIELD1��ݒ肵�܂��B
//	* @param val String FIELD1
//	*/
//	public void setField1(String val) {
//		  set(TBTHBAMST.FIELD1, val);
//		}
//	/**
//	*FIELD1��Ԃ��܂��B
//	* @return String FIELD1
//	*/
//	public String getField1() {
//		  return (String) get(TBTHBAMST.FIELD1);
//		}
//    /**
//	*FIELD2��ݒ肵�܂��B
//	* @param val String FIELD2
//	*/
//	public void setField2(String val) {
//		  set(TBTHBAMST.FIELD2, val);
//		}
//	/**
//	*FIELD2��Ԃ��܂��B
//	* @return String FIELD2
//	*/
//	public String getField2() {
//		  return (String) get(TBTHBAMST.FIELD2);
//		}
//    /**
//	*FIELD3��ݒ肵�܂��B
//	* @param val String FIELD3
//	*/
//	public void setField3(String val) {
//		  set(TBTHBAMST.FIELD3, val);
//		}
//	/**
//	*FIELD3��Ԃ��܂��B
//	* @return String FIELD3
//	*/
//	public String getField3() {
//		  return (String) get(TBTHBAMST.FIELD3);
//		}
//    /**
//	*FIELD4��ݒ肵�܂��B
//	* @param val String FIELD4
//	*/
//	public void setField4(String val) {
//		  set(TBTHBAMST.FIELD4, val);
//		}
//	/**
//	*FIELD4��Ԃ��܂��B
//	* @return String FIELD4
//	*/
//	public String getField4() {
//		  return (String) get(TBTHBAMST.FIELD4);
//		}
//    /**
//	*FIELD11��ݒ肵�܂��B
//	* @param val String FIELD11
//	*/
//	public void setField11(String val) {
//		  set(TBTHBAMST.FIELD11, val);
//		}
//	/**
//	*FIELD11��Ԃ��܂��B
//	* @return String FIELD11
//	*/
//	public String getField11() {
//		  return (String) get(TBTHBAMST.FIELD11);
//		}

}