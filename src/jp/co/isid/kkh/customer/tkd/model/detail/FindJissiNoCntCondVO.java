package jp.co.isid.kkh.customer.tkd.model.detail;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �g�p�ώ��{No����VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/13 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindJissiNoCntCondVO extends AbstractModel {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindJissiNoCntCondVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindJissiNoCntCondVO();
    }

    /**
     * �g�p�ώ��{No�̌�����ݒ肵�܂��B
     *
     * @param val
     *            BigDecimal �g�p�ώ��{No�̌���
     */
    public void setKngk1(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * �g�p�ώ��{No�̌�����Ԃ��܂��B
     *
     * @return BigDecimal �g�p�ώ��{No�̌���
     */
    public BigDecimal getKngk1() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

}