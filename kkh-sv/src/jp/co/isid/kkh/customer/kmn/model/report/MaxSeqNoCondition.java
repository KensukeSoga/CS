package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

/**
 * <P>
 * �V�[�N�G���XNo�ő�l�擾Condition
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/2/25 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class MaxSeqNoCondition extends AbstractServiceCondition {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** �����N�� */
    private String _yyMm = null;

    /**
     * �����N����Ԃ��܂��B
     *
     * @return yyMm
     */
    public String getYyMm() {
        return _yyMm;
    }

    /**
     * �����N����ݒ肵�܂��B
     *
     * @param yyMm
     */
    public void setYyMm(String yyMm) {
        this._yyMm = yyMm;
    }
}

