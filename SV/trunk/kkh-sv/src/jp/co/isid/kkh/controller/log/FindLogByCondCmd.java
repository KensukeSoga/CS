package jp.co.isid.kkh.controller.log;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.log.LogCondition;
import jp.co.isid.kkh.model.log.LogManager;
import jp.co.isid.kkh.model.log.LogResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �ėp���O�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/11 IP H.Shimizu)<BR>
 * </P>
 * @author
 */
public class FindLogByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private LogCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        LogManager manager = LogManager.getInstance();
        LogResult result = manager.findLogByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindLogCondition(LogCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return LogResult ������������
     */
    public LogResult getLogResult() {
        return (LogResult) super.getResult().get(RESULT_KEY);
    }

}
