package jp.co.isid.kkh.customer.skyp.service.report;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.customer.skyp.controller.report.FindReportSkypByCondCmd;
import jp.co.isid.kkh.customer.skyp.model.report.ReportSkypCondition;
import jp.co.isid.kkh.customer.skyp.model.report.ReportSkypResult;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>
 * 帳票のサービス(スカパー)
 * </P>
 * <P>
 * 帳票のサービスクラスです。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/16 JSE Y.Sato)<BR>
 * </P>
 *
 * @author Y.Sato
 */
@WebService(serviceName = "reportSkypService", targetNamespace = "http://report.service.skyp.customer.kkh.isid.co.jp/")
public class ReportSkypService {

    /**
     * 帳票（スカパー_納品／請求書）データを取得する。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "ReportSkypResult")
    public ReportSkypResult findReportSkypByCond(
            @WebParam(name = "condition") ReportSkypCondition condition)
            throws ServiceException {

        try {
            FindReportSkypByCondCmd cmd = new FindReportSkypByCondCmd();
            cmd.setReportSkypCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getReportSkypResult();
        } catch (KKHException e) {
            ReportSkypResult result = new ReportSkypResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

}
