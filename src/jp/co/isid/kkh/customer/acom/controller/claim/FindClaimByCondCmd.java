package jp.co.isid.kkh.customer.acom.controller.claim;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.claim.FindClaimByCondManager;
import jp.co.isid.kkh.customer.acom.model.claim.FindClaimByCondResult;
import jp.co.isid.kkh.customer.acom.model.claim.FindClaimCondition;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �����f�[�^�ꗗ��񌟍��R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class FindClaimByCondCmd extends Command {

    /** */
    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private FindClaimCondition _condition;

    /**
     * �����������g�p���A ����/�����ԍ� �ꗗ��񌟍����������s���܂��B
     *
     * @throws KKHException
     *             �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        FindClaimByCondManager manager = FindClaimByCondManager.getInstance();
        FindClaimByCondResult result = manager.findClaimByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition
     *            FindClaimCondition ��������
     */
    public void setFindClaimCondition(FindClaimCondition condition) {
        _condition = condition;
    }

    /**
     * �����f�[�^�ꗗ��񌟍����ʂ�Ԃ��܂��B
     *
     * @return FindClaimByCondResult ������������
     */
    public FindClaimByCondResult getFindClaimByCondResult() {
        return (FindClaimByCondResult) super.getResult().get(RESULT_KEY);
    }
}
