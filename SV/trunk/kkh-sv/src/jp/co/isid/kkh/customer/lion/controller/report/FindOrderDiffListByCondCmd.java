package jp.co.isid.kkh.customer.lion.controller.report;

import jp.co.isid.kkh.customer.lion.model.report.OrderDiffListLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.OrderDiffListLionManager;
import jp.co.isid.kkh.customer.lion.model.report.OrderDiffListLionResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���C�I���󒍍��وꗗ�����R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/11/10 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class FindOrderDiffListByCondCmd extends Command{

    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private OrderDiffListLionCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        OrderDiffListLionManager manager = OrderDiffListLionManager.getInstance();
        OrderDiffListLionResult result = manager.findByCondition(_condition);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * �������ʂ��擾���܂�
     * @return OrderDiffListLionResult ��������
     */
    public OrderDiffListLionResult getOrderDiffListLionResult() {
        return (OrderDiffListLionResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * ����������ݒ肵�܂��B
     * @param condition OrderDiffListLionCondition ��������
     */
    public void setFindOrderDiffListLionCondition(OrderDiffListLionCondition condition) {
        _condition = condition;
    }

}
