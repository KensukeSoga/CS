package jp.co.isid.kkh.customer.ash.model.detail;

import jp.co.isid.kkh.model.AbstractServiceCondition;

/**
 * <P>
 * �L�[�ǂ̔ԑg�R�[�h��Condition
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/08/20 HLC S.Jang)<BR>
 * </P>
 *
 * @author HLC ��(Jang)
 */
public class FindKeyKyokuBangumiCdCondition extends AbstractServiceCondition {
    private static final long serialVersionUID = 1L;

    /** ��ʃR�[�h (�}�̃R�[�h) */
    private String _sybt = null;

    /** ��ʃR�[�h (�}�̃R�[�h)���擾 */
    public String getSybt() {
        return this._sybt;
    }

    /** ��ʃR�[�h (�}�̃R�[�h)��ݒ� */
    public void setSybt(String sybt) {
        this._sybt = sybt;
    }

}
