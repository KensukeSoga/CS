package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

/**
 * <P>
 * ���[�i����_�����ꗗ�j�f�[�^Condition
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/1/31 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class ReportKmnListCondition extends AbstractServiceCondition {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** ���� */
    private String _bumonCd = null;
    /** �o�͒P�� */
    private String _output = null;

    /**
     * �����Ԃ��܂��B
     *
     * @return _bumonCd
     */
    public String getBumonCd() {
        return _bumonCd;
    }

    /**
     * �����ݒ肵�܂��B
     *
     * @param bumonCd
     */
    public void setBumonCd(String bumonCd) {
        this._bumonCd = bumonCd;
    }

    /**
     * �o�͒P�ʂ�Ԃ��܂��B
     *
     * @return _output
     */
    public String getOutput() {
        return _output;
    }

    /**
     * �o�͒P�ʂ�ݒ肵�܂��B
     *
     * @param _output
     */
    public void setOutput(String output) {
        this._output = output;
    }
}
