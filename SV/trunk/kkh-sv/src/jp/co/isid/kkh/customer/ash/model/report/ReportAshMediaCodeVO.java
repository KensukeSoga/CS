package jp.co.isid.kkh.customer.ash.model.report;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
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
public class ReportAshMediaCodeVO extends AbstractModel {

    private static final long serialVersionUID = 1L;
    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportAshMediaCodeVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportAshMediaCodeVO();
    }

    /**
     * ��ʂ�ݒ肵�܂��B
     * @param val String SYBT
     */
    public void setSybt(String val) {
        set(TBTHBAMST.SYBT, val);
     }

    /**
     * ��ʂ�Ԃ��܂��B
     * @return String SYBT
     */
    public String getSybt() {
        return (String) get(TBTHBAMST.SYBT);
    }

    /**
     * Field1��ݒ肵�܂��B
     * @param val String FIELD1
     */
    public void setField1(String val) {
        set(TBTHBAMST.FIELD1, val);
    }

    /**
     * Field1��Ԃ��܂��B
     * @return String FIELD1
     */
    public String getField1() {
        return (String) get(TBTHBAMST.FIELD1);
    }

    /**
     * FIELD2��ݒ肵�܂��B
     * @param val String FIELD2
     */
    public void setField2(String val) {
        set(TBTHBAMST.FIELD2, val);
    }

    /**
     * FIELD2��Ԃ��܂��B
     * @return String FIELD2
     */
    public String getField2() {
        return (String) get(TBTHBAMST.FIELD2);
    }

    /**
     * Field3��ݒ肵�܂��B
     * @param val String Field3
     */
    public void setField3(String val) {
        set(TBTHBAMST.FIELD3, val);
    }

    /**
     * FIELD3��Ԃ��܂��B
     * @return String FIELD3
     */
    public String getField3() {
        return (String) get(TBTHBAMST.FIELD3);
    }

    /**
     * FIELD4��ݒ肵�܂��B
     * @param val String FIELD4
     */
    public void setField4(String val) {
        set(TBTHBAMST.FIELD4, val);
    }

    /**
     * FIELD4��Ԃ��܂��B
     * @return String FIELD4
     */
    public String getField4() {
        return (String) get(TBTHBAMST.FIELD4);
    }

    //2015/07/08 k.soga �A�T�q�Ή� Add  Start
    /**
     * FIELD9��ݒ肵�܂��B
     * @param val String FIELD9
     */
    public void setField9(String val) {
        set(TBTHBAMST.FIELD9, val);
    }

    /**
     * FIELD9��Ԃ��܂��B
     * @return String FIELD9
     */
    public String getField9() {
        return (String) get(TBTHBAMST.FIELD9);
    }
    //2015/07/08 k.soga �A�T�q�Ή� Add  End
}
