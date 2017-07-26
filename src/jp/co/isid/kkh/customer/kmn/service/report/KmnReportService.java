package jp.co.isid.kkh.customer.kmn.service.report;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.customer.kmn.controller.report.FindReportKmnByCondCmd;
import jp.co.isid.kkh.customer.kmn.controller.report.FindReportKmnListByCondCmd;
import jp.co.isid.kkh.customer.kmn.controller.report.GetMaxSeqNoByCondCmd;
import jp.co.isid.kkh.customer.kmn.controller.report.UpdateSeqNoByCondCmd;
import jp.co.isid.kkh.customer.kmn.model.report.MaxSeqNoCondition;
import jp.co.isid.kkh.customer.kmn.model.report.MaxSeqNoResult;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnCondition;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnListCondition;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnListResult;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnResult;
import jp.co.isid.kkh.customer.kmn.model.report.UpdateSeqNoCondition;
import jp.co.isid.kkh.customer.kmn.model.report.UpdateSeqNoResult;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>
 * 帳票のサービス(公文)
 * </P>
 * <P>
 * 帳票のサービスクラスです。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
@WebService(serviceName = "kmnReportService", targetNamespace = "http://report.service.kmn.customer.kkh.isid.co.jp/")
public class KmnReportService {

    /**
     * （公文_帳票出力）データを取得する。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "ReportKmnResult")
    public ReportKmnResult findReportKmnByCond(
            @WebParam(name = "condition") ReportKmnCondition condition)
            throws ServiceException {

        try {
            FindReportKmnByCondCmd cmd = new FindReportKmnByCondCmd();
            cmd.setReportKmnCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getReportKmnResult();
        } catch (KKHException e) {
            ReportKmnResult result = new ReportKmnResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * 帳票（公文_請求一覧）データを取得する。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "ReportKmnListResult")
    public ReportKmnListResult findReportKmnListByCond(
            @WebParam(name = "condition") ReportKmnListCondition condition)
            throws ServiceException {

        try {
            FindReportKmnListByCondCmd cmd = new FindReportKmnListByCondCmd();
            cmd.setReportKmnListCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getReportKmnListResult();
        } catch (KKHException e) {
            ReportKmnListResult result = new ReportKmnListResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * シークエンスNo最大値を取得する。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "MaxSeqNoResult")
    public MaxSeqNoResult getMaxSeqNoByCond(
            @WebParam(name = "condition") MaxSeqNoCondition condition)
            throws ServiceException {
        try {
            GetMaxSeqNoByCondCmd cmd = new GetMaxSeqNoByCondCmd();
            cmd.setMaxSeqNoCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getMaxSeqNoResult();
        } catch (KKHException e) {
            MaxSeqNoResult result = new MaxSeqNoResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * シークエンスNoを登録する。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "UpdateSeqNoResult")
    public UpdateSeqNoResult updateSeqNoByCond(
            @WebParam(name = "condition") UpdateSeqNoCondition condition)
            throws ServiceException {
        try {
            UpdateSeqNoByCondCmd cmd = new UpdateSeqNoByCondCmd();
            cmd.setUpdateSeqNoCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getUpdateSeqNoResult();
        } catch (KKHException e) {
            UpdateSeqNoResult result = new UpdateSeqNoResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }
}
