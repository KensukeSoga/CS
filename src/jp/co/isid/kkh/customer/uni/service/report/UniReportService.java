package jp.co.isid.kkh.customer.uni.service.report;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.customer.uni.controller.report.FindReportUniByCondCmd;
import jp.co.isid.kkh.customer.uni.model.report.ReportUniCondition;
import jp.co.isid.kkh.customer.uni.model.report.ReportUniResult;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>
 * 帳票のサービス(ユニチャーム)
 * </P>
 * <P>
 * 帳票のサービスクラスです。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/23 JSE Y.Sato)<BR>
 * </P>
 *
 * @author Y.Sato
 */
@WebService(serviceName = "uniReportService", targetNamespace = "http://report.service.uni.customer.kkh.isid.co.jp/")
public class UniReportService {

    /**
     * 帳票（ユニチャーム_広告費明細表）データを取得する。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "ReportUniResult")
    public ReportUniResult findReportUniByCond(
            @WebParam(name = "condition") ReportUniCondition condition)
            throws ServiceException {

        try {
            FindReportUniByCondCmd cmd = new FindReportUniByCondCmd();
            cmd.setReportUniCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getReportUniResult();
        } catch (KKHException e) {
            ReportUniResult result = new ReportUniResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

}
