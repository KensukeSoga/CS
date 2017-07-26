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
 * 広告費明細のサービス(スカパー)
 * </P>
 * <P>
 * 広告費明細のサービスクラスです。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/21 JSE Y.Sato)<BR>
 * </P>
 *
 * @author Y.Sato
 */
@WebService(serviceName = "detailSkypService", targetNamespace = "http://detail.service.skyp.customer.kkh.isid.co.jp/")
public class DetailSkypService {

    /**
     * 並び順情報を取得する。
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
     * 並び順情報を更新する。
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
