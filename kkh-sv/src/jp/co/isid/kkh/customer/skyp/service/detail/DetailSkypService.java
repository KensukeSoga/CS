package jp.co.isid.kkh.customer.skyp.service.detail;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.customer.skyp.controller.detail.FindOrderByCondCmd;
import jp.co.isid.kkh.customer.skyp.controller.detail.UpdateOrderCmd;
import jp.co.isid.kkh.customer.skyp.model.detail.FindOrderByCondResult;
import jp.co.isid.kkh.customer.skyp.model.detail.FindOrderCondition;
import jp.co.isid.kkh.customer.skyp.model.detail.UpdateOrderResult;
import jp.co.isid.kkh.customer.skyp.model.detail.UpdateOrderVO;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>
 * �L����ׂ̃T�[�r�X(�X�J�p�[)
 * </P>
 * <P>
 * �L����ׂ̃T�[�r�X�N���X�ł��B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/21 JSE Y.Sato)<BR>
 * </P>
 *
 * @author Y.Sato
 */
@WebService(serviceName = "detailSkypService", targetNamespace = "http://detail.service.skyp.customer.kkh.isid.co.jp/")
public class DetailSkypService {

    /**
     * ���я������擾����B
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "FindOrderByCondResult")
    public FindOrderByCondResult findOrderByCond(
            @WebParam(name = "condition") FindOrderCondition condition)
            throws ServiceException {

        try {
            FindOrderByCondCmd cmd = new FindOrderByCondCmd();
            cmd.setFindOrderCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getFindByCondResult();
        } catch (KKHException e) {
            FindOrderByCondResult result = new FindOrderByCondResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * ���я������X�V����B
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "UpdateOrderResult")
    public UpdateOrderResult updateOrderData(
            @WebParam(name = "vo") UpdateOrderVO vo)
            throws ServiceException {

        try {
            UpdateOrderCmd cmd = new UpdateOrderCmd();
            cmd.setUpdateOrderVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getUpdateOrderResult();
        } catch (KKHException e) {
            UpdateOrderResult result = new UpdateOrderResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }
}
