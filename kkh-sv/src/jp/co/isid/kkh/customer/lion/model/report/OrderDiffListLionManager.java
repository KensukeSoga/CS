package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���C�I���󒍍��وꗗ����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/11/10 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class OrderDiffListLionManager {

    /** �V���O���g���C���X�^���X */
    private static OrderDiffListLionManager _manager = new OrderDiffListLionManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private OrderDiffListLionManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * @return �C���X�^���X
     */
    public static OrderDiffListLionManager getInstance() {
        return _manager;
    }

    /**
     * ���C�I���󒍍��وꗗ���������܂��B
     * @param cond OrderDiffListLionCondition ���C�I���󒍍��وꗗ���[��������
     * @return OrderDiffListLionResult ���C�I���󒍍��وꗗ�������ʃf�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public OrderDiffListLionResult findByCondition(OrderDiffListLionCondition cond) throws KKHException {

        // �p�����[�^�̕K�{�`�F�b�N
        if (!CheckParameter(cond)) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }

        OrderDiffListLionResult result = new OrderDiffListLionResult();
        OrderDiffListLionDAO dao = OrderDiffListLionDAOFactory.createDAO();

        //�󒍍��وꗗ�����J�n
        List<OrderDiffListLionVO> list = dao.findOrderDiffList(cond);

        //�V�K�󒍈ꗗ�����J�n
        List<OrderDiffListLionVO> list2 = dao.findNewOrderList(cond);

        //�󒍋��z���وꗗ�����J�n
        List<OrderDiffListLionVO> list3 = dao.findOrderAmtDiffList(cond);

        //�������ʊi�[
        result.setOrderDiffListInfo(list);
        result.setNewOrderListInfo(list2);
        result.setOrderAmountDiffListInfo(list3);

        return result;
    }

    /**
     * �p�����[�^�K�{�`�F�b�N
     * @param cond OrderDiffListLionCondition ���C�I���󒍍��وꗗ���[��������
     * @return True: OK�AFalse: NG
     */
    private boolean CheckParameter(OrderDiffListLionCondition cond) {

        //ESQ-ID
        if (cond.getEsqId() == null || cond.getEsqId().equals("")) {
            return false;
        }
        //�c�Ə��R�[�h
        if (cond.getEgCd() == null || cond.getEgCd().equals("")) {
            return false;
        }
        //���Ӑ��ƃR�[�h
        if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")) {
            return false;
        }
        //���Ӑ敔��SEQNO
        if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")) {
            return false;
        }
        //���Ӑ�S��SEQNO
        if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")) {
            return false;
        }
        //�N��
        if (cond.getYymm() == null || cond.getYymm().equals("")) {
            return false;
        }

        return true;
    }

}
