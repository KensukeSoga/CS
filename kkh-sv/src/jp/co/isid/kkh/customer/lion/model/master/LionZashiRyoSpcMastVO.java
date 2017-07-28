package jp.co.isid.kkh.customer.lion.model.master;

import java.math.BigDecimal;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ���W�I��VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/03/02 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class LionZashiRyoSpcMastVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public LionZashiRyoSpcMastVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new LionZashiRyoSpcMastVO();
    }

    /** VAL1 */
    public static final String VAL1 = "VAL1";

    /** VAL2 */
    public static final String VAL2 = "VAL2";

    /** VAL3 */
    public static final String VAL3 = "VAL3";

    //���I�}�X�^////////////////////////////////
    /**
     * VAL1��ݒ肷��
     * @param val VAL1
     */
    public void setVal1(String val) {
        set(VAL1, val);
    }

    /**
     * VAL1���擾����
     * @return VAL1
     */
    public String getVal1() {
        return (String) get(VAL1);
    }

    /**
     * VAL2��ݒ肷��
     * @param val VAL2
     */
    public void setVal2(String val) {
        set(VAL2, val);
    }

    /**
     * VAL2���擾����
     * @return VAL2
     */
    public String getVal2() {
        return  (String) get(VAL2);
    }

    /**
     * VAL3��ݒ肷��
     * @param val VAL3
     */
    public void setVal3(BigDecimal val) {
        set(VAL3, val);
    }

    /**
     * VAL3���擾����
     * @return VAL3
     */
    public BigDecimal getVal3() {
        return  (BigDecimal) get(VAL3);
    }

}