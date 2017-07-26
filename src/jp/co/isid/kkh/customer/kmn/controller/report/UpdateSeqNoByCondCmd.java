package jp.co.isid.kkh.customer.kmn.controller.report;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.kmn.model.report.UpdateSeqNoCondition;
import jp.co.isid.kkh.customer.kmn.model.report.UpdateSeqNoManager;
import jp.co.isid.kkh.customer.kmn.model.report.UpdateSeqNoResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �V�[�N�G���XNo�o�^�E�X�V�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/2/26 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class UpdateSeqNoByCondCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private UpdateSeqNoCondition _condition;

    /**
     * �����������g�p���A�V�[�N�G���XNo�ő�l���擾���܂��B
     *
     * @throws KKHException
     *             �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        UpdateSeqNoManager manager = UpdateSeqNoManager.getInstance();
        manager.updateDisplayData(_condition);
        getResult().set(RESULT_KEY, new UpdateSeqNoResult());
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition
     *            setReportKmnListCondition ��������
     */
    public void setUpdateSeqNoCondition(UpdateSeqNoCondition condition) {
        _condition = condition;
    }

    /**
     * �V�[�N�G���XNo�ő�l��Ԃ��܂��B
     *
     * @return ReportUniResult ������������
     */
    public UpdateSeqNoResult getUpdateSeqNoResult() {
        return (UpdateSeqNoResult) super.getResult().get(RESULT_KEY);
    }

}
