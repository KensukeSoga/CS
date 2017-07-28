package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * CardNoGetVO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/20 JSE KTPRES)<BR>
 * </P>
 * @author
 */
public class FindLionCardNoGetVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindLionCardNoGetVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindLionCardNoGetVO();
    }

    /**
     * �}�̋敪��ݒ肵�܂��B
     * @param val val String �}�̋敪
     */
    public void setCode1(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * �}�̋敪��Ԃ��܂��B
     * @return String �}�̋敪
     */
    public String getCode1() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * �J�[�hNo��ݒ肵�܂��B
     * @param val String �J�[�hNo
     */
    public void setCode6(String val) {
      set(TBTHB2KMEI.CODE6, val);
    }

    /**
     * �J�[�hNo��Ԃ��܂��B
     * @return String �J�[�hNo
     */
    public String getCode6() {
      return (String) get(TBTHB2KMEI.CODE6);
    }

}