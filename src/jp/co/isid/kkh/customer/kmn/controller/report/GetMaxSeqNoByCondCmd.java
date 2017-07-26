package jp.co.isid.kkh.customer.kmn.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.kmn.model.report.MaxSeqNoCondition;
import jp.co.isid.kkh.customer.kmn.model.report.MaxSeqNoManager;
import jp.co.isid.kkh.customer.kmn.model.report.MaxSeqNoResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �V�[�N�G���XNo�ő�l�擾�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/2/25 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class GetMaxSeqNoByCondCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private MaxSeqNoCondition _condition;

    /**
     * �����������g�p���A�V�[�N�G���XNo�ő�l���擾���܂��B
     *
     * @throws KKHException
     *             �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        MaxSeqNoManager manager = MaxSeqNoManager.getInstance();
        MaxSeqNoResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition
     *            setReportKmnListCondition ��������
     */
    public void setMaxSeqNoCondition(MaxSeqNoCondition condition) {
        _condition = condition;
    }

    /**
     * �V�[�N�G���XNo�ő�l��Ԃ��܂��B
     *
     * @return ReportUniResult ������������
     */
    public MaxSeqNoResult getMaxSeqNoResult() {
        return (MaxSeqNoResult) super.getResult().get(RESULT_KEY);
    }
}
