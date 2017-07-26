package jp.co.isid.kkh.customer.skyp.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.skyp.model.detail.FindOrderByCondManager;
import jp.co.isid.kkh.customer.skyp.model.detail.FindOrderByCondResult;
import jp.co.isid.kkh.customer.skyp.model.detail.FindOrderCondition;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���я���񌟍��R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/21 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindOrderByCondCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private FindOrderCondition _condition;

    /**
     * �����������g�p���A ���я���񌟍����������s���܂��B
     *
     * @throws KKHException
     *             �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        FindOrderByCondManager manager = FindOrderByCondManager.getInstance();
        FindOrderByCondResult result = manager.findOrderByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition
     *            FindOrderCondition ��������
     */
    public void setFindOrderCondition(FindOrderCondition condition) {
        _condition = condition;
    }

    /**
     * ���я���񌟍����ʂ�Ԃ��܂��B
     *
     * @return FindOrderByCondResult ������������
     */
    public FindOrderByCondResult getFindByCondResult() {
        return (FindOrderByCondResult) super.getResult().get(RESULT_KEY);
    }
}
