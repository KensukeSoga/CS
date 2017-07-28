package jp.co.isid.kkh.customer.toh.service.report;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.model.base.KKHException;

import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.customer.toh.controller.report.FindReportTohByCondCmd;
import jp.co.isid.kkh.customer.toh.controller.report.FindReportTohTotalByCondCmd;
import jp.co.isid.kkh.customer.toh.model.report.ReportTohCondition;
import jp.co.isid.kkh.customer.toh.model.report.ReportTohResult;
import jp.co.isid.kkh.customer.toh.model.report.ReportTohTotalCondition;
import jp.co.isid.kkh.customer.toh.model.report.ReportTohTotalResult;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>帳票のサービス</P>
 * <P>
 * 帳票のサービスクラスです。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/15 JSE KT)<BR>
 * </P>
 * @author JSE KT
 */
@WebService(serviceName = "reportService",
        targetNamespace = "http://report.service.toh.customer.kkh.isid.co.jp/")
public class ReportService {

    /**
    * 請求明細一覧（TOH）データの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportTohResult")
   public ReportTohResult findReportTohByCond(
           @WebParam(name = "condition")
           ReportTohCondition condition) throws ServiceException {

       try {
           FindReportTohByCondCmd cmd = new FindReportTohByCondCmd();
           cmd.setFindReportTohCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportTohResult();
       } catch (KKHException e) {
           ReportTohResult result = new ReportTohResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }

   /**
    * 年月別媒体別集計（TOH）データの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportTohTotalResult")
   public ReportTohTotalResult findReportTohTotalByCond(
           @WebParam(name = "condition")
           ReportTohTotalCondition condition) throws ServiceException {

       try {
           FindReportTohTotalByCondCmd cmd = new FindReportTohTotalByCondCmd();
           cmd.setFindReportTohTotalCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportTohTotalResult();
       } catch (KKHException e) {
           ReportTohTotalResult result = new ReportTohTotalResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }

//   /**
//    * メッセージの条件検索を行います。
//    * @throws ServiceException
//    */
//   @WebMethod
//   @WebResult(name = "LogResult")
//   public LogResult findLogByCond(
//           @WebParam(name = "condition")
//           LogCondition condition) throws ServiceException {
//
//       try {
//    	   FindLogByCondCmd cmd = new FindLogByCondCmd();
//           cmd.setFindLogCondition(condition);
//           CommandInvokerUtil.getCommandInvoker().execute(cmd);
//           return cmd.getLogResult();
//       } catch (KKHException e) {
//    	   LogResult result = new LogResult();
//           result.toErrorInfo(e);
//           return result;
//       } catch (Throwable e) {
//           ExceptionHandler.getInstance().handleException(e);
//           return null;
//       }
//
//   }

}
