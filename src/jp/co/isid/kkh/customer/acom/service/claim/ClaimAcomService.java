package jp.co.isid.kkh.customer.acom.service.claim;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.util.KKHLogUtility;
import jp.co.isid.kkh.customer.acom.controller.claim.FindClaimByCondCmd;
import jp.co.isid.kkh.customer.acom.controller.claim.UpdateOutFlgCmd;
import jp.co.isid.kkh.customer.acom.model.claim.FindClaimByCondResult;
import jp.co.isid.kkh.customer.acom.model.claim.FindClaimCondition;
import jp.co.isid.kkh.customer.acom.model.claim.UpdateOutFlgResult;
import jp.co.isid.kkh.customer.acom.model.claim.UpdateOutFlgVO;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>
 * 請求データ出力のサービス
 * </P>
 * <P>
 * 請求データ出力のサービスクラスです。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author Y.Sato
 */
@WebService(serviceName = "claimAcomService", targetNamespace = "http://claim.service.acom.customer.kkh.isid.co.jp/")
public class ClaimAcomService {

    /**
     * 請求データ一覧情報を取得する。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "FindClaimByCondResult")
    public FindClaimByCondResult findClaimByCond(
            @WebParam(name = "condition") FindClaimCondition condition)
            throws ServiceException {

        try {
            FindClaimByCondCmd cmd = new FindClaimByCondCmd();
            cmd.setFindClaimCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getFindClaimByCondResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
            FindClaimByCondResult result = new FindClaimByCondResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * 送信フラグ情報を更新する。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "UpdateOutFlgResult")
    public UpdateOutFlgResult updateOutFlg(
            @WebParam(name = "vo") UpdateOutFlgVO vo)
            throws ServiceException {

        try {
            UpdateOutFlgCmd cmd = new UpdateOutFlgCmd();
            cmd.setUpdateOutFlgVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getUpdateOutFlgResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
            UpdateOutFlgResult result = new UpdateOutFlgResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }
}
