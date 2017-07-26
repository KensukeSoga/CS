package jp.co.isid.kkh.customer.skyp.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.skyp.model.detail.UpdateOrderManager;
import jp.co.isid.kkh.customer.skyp.model.detail.UpdateOrderResult;
import jp.co.isid.kkh.customer.skyp.model.detail.UpdateOrderVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * ���я��X�V�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/22 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class UpdateOrderCmd extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private UpdateOrderVO _vo;

    /**
     * ���я��X�V���������s���܂��B
     *
     * @throws KKHException
     *             �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {
        UpdateOrderManager manager = UpdateOrderManager.getInstance();
        UpdateOrderResult result = manager.updateThb2KmeiForOrder(_vo);
        getResult().set(RESULT_KEY, result);
    }

    /**
     * ���я��X�V���VO��ݒ肵�܂��B
     *
     * @param vo
     *            UpdateOrderVO ��������
     */
    public void setUpdateOrderVO(UpdateOrderVO vo) {
        _vo = vo;
    }

    /**
     * ���я��X�V���ʂ�Ԃ��܂��B
     *
     * @return UpdateOrderResult ���я��X�V����
     */
    public UpdateOrderResult getUpdateOrderResult() {
        return (UpdateOrderResult) super.getResult().get(RESULT_KEY);
    }
}
