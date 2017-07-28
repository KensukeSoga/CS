package jp.co.isid.kkh.controller.history;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.history.HistoryJyutDownCondition;
import jp.co.isid.kkh.model.history.HistoryJyutDownManager;
import jp.co.isid.kkh.model.history.HistoryJyutDownResult;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * LION�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/1 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class HistoryLionJyutDownByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private HistoryJyutDownCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        HistoryJyutDownManager manager = HistoryJyutDownManager.getInstance();
        HistoryJyutDownResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindHistoryLionJyutDownCondition(HistoryJyutDownCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return HistoryLionJyutDownResult ������������
     */
    public HistoryJyutDownResult getHistoryLionJyutDownResult() {
        return (HistoryJyutDownResult) super.getResult().get(RESULT_KEY);
    }

}
