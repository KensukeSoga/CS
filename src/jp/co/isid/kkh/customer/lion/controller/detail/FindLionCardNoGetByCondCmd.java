package jp.co.isid.kkh.customer.lion.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoGetCondition;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoGetResult;
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
public class FindLionCardNoGetByCondCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private FindLionCardNoGetCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        FindLionDetailManager manager = FindLionDetailManager.getInstance();
        FindLionCardNoGetResult result = manager.findLionCardNoGetByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition CommonCodeMasterSearchCondition ��������
     */
    public void setFindLionCardNoGetCondition(FindLionCardNoGetCondition condition) {
        _condition = condition;
    }

    /**
     * �����������ʂ�Ԃ��܂��B
     *
     * @return FindTvKMastResult ������������
     */
    public FindLionCardNoGetResult getFindLionCardNoGetResult() {
        return (FindLionCardNoGetResult) super.getResult().get(RESULT_KEY);
    }

}
