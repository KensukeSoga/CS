package jp.co.isid.kkh.customer.lion.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionDetailCondition;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionDetailResult;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionDetailManager;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * FindTvKMast�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/17 JSE A.Naito)<BR>
 * </P>
 * @author  JSE A.Naito
 */
public class FindLionDetailByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private FindLionDetailCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        FindLionDetailManager manager = FindLionDetailManager.getInstance();
        FindLionDetailResult result = manager.findLionDetailByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindLionDetailCondition(FindLionDetailCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return FindTvKMastResult ������������
     */
    public FindLionDetailResult getFindLionDetailResult() {
        return (FindLionDetailResult) super.getResult().get(RESULT_KEY);
    }

}
