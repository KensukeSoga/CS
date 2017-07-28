package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �J�[�hNO�ꗗVO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/21 JSE A.Naito)<BR>
 * </P>
 * @author
 */
public class FindLionCardNoItrVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindLionCardNoItrVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindLionCardNoItrVO();
    }

    /**
     * �R�[�h��ݒ肵�܂��B
     * @param val String KYOKUNAME
     */
    public void setField1(String val) {
        set(TBTHBAMST.FIELD1, val);
    }

    /**
     * �R�[�h��Ԃ��܂��B
     * @return String KYOKUNAME
     */
    public String getField1() {
        return (String) get(TBTHBAMST.FIELD1);
    }

    /**
     * ���̂�ݒ肵�܂��B
     * @param val String KIGOU
     */
    public void setField2(String val) {
        set(TBTHBAMST.FIELD2, val);
    }

    /**
     * ���̂�Ԃ��܂��B
     * @return String KIGOU
     */
    public String getField2() {
        return (String) get(TBTHBAMST.FIELD2);
    }

}