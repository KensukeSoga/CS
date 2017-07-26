package jp.co.isid.kkh.customer.ash.service.report;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import jp.co.isid.kkh.customer.ash.controller.report.FDAshByCondCmd;
import jp.co.isid.kkh.customer.ash.controller.report.ReportAshKoukokuHiByCondCmd;
import jp.co.isid.kkh.customer.ash.controller.report.ReportAshMediaByCondCmd;
import jp.co.isid.kkh.customer.ash.controller.report.ReportAshMediaChklstByCondCmd;
import jp.co.isid.kkh.customer.ash.controller.report.ReportAshMediaCodeByCondCmd;
import jp.co.isid.kkh.customer.ash.model.report.FDAshResult;
import jp.co.isid.kkh.customer.ash.model.report.ReportAshKoukokuHiResult;
import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaChklstResult;
import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaCodeResult;
import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaCondition;
import jp.co.isid.kkh.customer.ash.model.report.ReportAshMediaResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
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
 * ・新規作成(2012/1/20 Fourm H.Izawa)<BR>
 * </P>
 * @author Fourm H.Izawa
 */
@WebService(serviceName = "ashReportService",
        targetNamespace = "http://report.service.ash.customer.kkh.isid.co.jp/")
public class AshReportService {

    /**
    * 媒体種別一覧表（Ash）データの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportAshMediaResult")
   public ReportAshMediaResult findReportAshMediaByCond(
           @WebParam(name = "condition")
           ReportAshMediaCondition condition) throws ServiceException {

       try {
           ReportAshMediaByCondCmd cmd = new ReportAshMediaByCondCmd();
           cmd.setFindReportAshMediaCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportAshMediaResult();
       } catch (KKHException e) {
           ReportAshMediaResult result = new ReportAshMediaResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }

   /**
    * 媒体コード（Ash）データの検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportAshMediaResult")
   public ReportAshMediaCodeResult findReportAshMediaCodeByCond(
           @WebParam(name = "condition")
           ReportAshMediaCondition condition) throws ServiceException {

       try {
           ReportAshMediaCodeByCondCmd cmd = new ReportAshMediaCodeByCondCmd();
           cmd.setFindReportAshMediaCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportAshMediaCodeResult();
       } catch (KKHException e) {
           ReportAshMediaCodeResult result = new ReportAshMediaCodeResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }

   /**
    * 媒体コード（Ash）データの検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportAshMediaChklstResult")
   public ReportAshMediaChklstResult findReportAshMediaChklstByCond(
           @WebParam(name = "condition")
           ReportAshMediaCondition condition) throws ServiceException {

       try {
           ReportAshMediaChklstByCondCmd cmd = new ReportAshMediaChklstByCondCmd();
           cmd.setFindReportAshMediaChklstCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportAshMediaChklstResult();
       } catch (KKHException e) {
           ReportAshMediaChklstResult result = new ReportAshMediaChklstResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }

   /**
    * 広告費明細書（Ash）データの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportAshKoukokuHiResult")
   public ReportAshKoukokuHiResult findReportAshKoukokuHiByCond(
           @WebParam(name = "condition")
           ReportAshMediaCondition condition) throws ServiceException {

       try {
           ReportAshKoukokuHiByCondCmd cmd = new ReportAshKoukokuHiByCondCmd();
           cmd.setFindReportAshKoukokuHiCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportAshKoukokuHiResult();
       } catch (KKHException e) {
           ReportAshKoukokuHiResult result = new ReportAshKoukokuHiResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }

   /**
    * 請求データ一覧（Ash）データの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "FDAshResult")
   public FDAshResult findFDAshByCond(
           @WebParam(name = "condition")
           ReportAshMediaCondition condition) throws ServiceException {

       try {
           FDAshByCondCmd cmd = new FDAshByCondCmd();
           cmd.setFindFDAshCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getFDAshResult();
       } catch (KKHException e) {
           FDAshResult result = new FDAshResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }

}