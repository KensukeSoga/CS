package jp.co.isid.kkh.customer.mac.service.report;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.customer.mac.controller.report.FindReportMacByCondCmd;
import jp.co.isid.kkh.customer.mac.controller.report.FindReportMacGetDenNumByCondCmd;
import jp.co.isid.kkh.customer.mac.controller.report.FindReportMacPurchaseByCondCmd;
import jp.co.isid.kkh.customer.mac.controller.report.FindReportMacRequestByCondCmd;
import jp.co.isid.kkh.customer.mac.controller.report.FindReportMacSchklstByCondCmd;
import jp.co.isid.kkh.customer.mac.controller.report.ReportMacLicenseeByCondCmd;
import jp.co.isid.kkh.customer.mac.controller.report.UpdateReportMacPurCmd;
import jp.co.isid.kkh.customer.mac.controller.report.UpdateReportMacReqCmd;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacCondition;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacGetDenNumCondition;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacGetDenNumResult;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacLicenseeResult;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacPurchaseCondition;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacPurchaseResult;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacRequestCondition;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacRequestResult;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacResult;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacSchklstCondition;
import jp.co.isid.kkh.customer.mac.model.report.ReportMacSchklstResult;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacPurCondition;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacPurResult;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacReqCondition;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacReqResult;
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
 * ・新規作成(2011/12/26 JSE KT)<BR>
 * </P>
 * @author JSE KT
 */
@WebService(serviceName = "macReportService",
        targetNamespace = "http://report.service.mac.customer.kkh.isid.co.jp/")
public class MacReportService {

    /**
    * 購入伝票一覧表（MAC）データの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportMacResult")
   public ReportMacResult findReportMacByCond(
           @WebParam(name = "condition")
           ReportMacCondition condition) throws ServiceException {

       try {
    	   FindReportMacByCondCmd cmd = new FindReportMacByCondCmd();
           cmd.setFindReportMacCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportMacResult();
       } catch (KKHException e) {
    	   ReportMacResult result = new ReportMacResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }


   /**
    * 請求明細チェックリスト（MAC）データの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportMacSchklstResult")
   public ReportMacSchklstResult findReportMacSchklstByCond(
           @WebParam(name = "condition")
           ReportMacSchklstCondition condition) throws ServiceException {

       try {
    	   FindReportMacSchklstByCondCmd cmd = new FindReportMacSchklstByCondCmd();
           cmd.setFindReportMacSchklstCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportMacSchklstResult();
       } catch (KKHException e) {
    	   ReportMacSchklstResult result = new ReportMacSchklstResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

   /**
    * 購入伝票（MAC）データの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportMacPurchaseResult")
   public ReportMacPurchaseResult findReportMacPurchaseByCond(
           @WebParam(name = "condition")
           ReportMacPurchaseCondition condition) throws ServiceException {

       try {
    	   FindReportMacPurchaseByCondCmd cmd = new FindReportMacPurchaseByCondCmd();
           cmd.setFindReportMacPurchaseCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportMacPurchaseResult();
       } catch (KKHException e) {
    	   ReportMacPurchaseResult result = new ReportMacPurchaseResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

   /**
    * ライセンシー向け（MAC）データの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportMacLicenseeResult")
   public ReportMacLicenseeResult findReportMacLicenseeByCond(
           @WebParam(name = "condition")
           ReportMacCondition condition) throws ServiceException {

       try {
    	   ReportMacLicenseeByCondCmd cmd = new ReportMacLicenseeByCondCmd();
           cmd.setFindReportMacLicenseeCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportMacLicenseeResult();
       } catch (KKHException e) {
    	   ReportMacLicenseeResult result = new ReportMacLicenseeResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

   /**
    * 購入伝票用に伝票NOの条件検索を行います。(採番)
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportMacGetDenNumResult")
   public ReportMacGetDenNumResult findReportMacGetDenNumByCond(
           @WebParam(name = "condition")
           ReportMacGetDenNumCondition condition) throws ServiceException {

       try {
    	   FindReportMacGetDenNumByCondCmd cmd = new FindReportMacGetDenNumByCondCmd();
           cmd.setFindReportMacGetDenNumCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportMacGetDenNumResult();
       } catch (KKHException e) {
    	   ReportMacGetDenNumResult result = new ReportMacGetDenNumResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

   /**
    * 購入伝票用に伝票NOの採番（更新）を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "UpdateReportMacPurResult")
   public UpdateReportMacPurResult updateReportMacPur(
           @WebParam(name = "condition")
           UpdateReportMacPurCondition vo) throws ServiceException {

       try {
    	   UpdateReportMacPurCmd cmd = new UpdateReportMacPurCmd();
           cmd.setUpdateReportMacVO(vo);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getUpdateReportMacPurResult();
       } catch (KKHException e) {
    	   UpdateReportMacPurResult result = new UpdateReportMacPurResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

   /**
    * 請求書（MAC）データの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportMacRequestResult")
   public ReportMacRequestResult findReportMacRequestByCond(
           @WebParam(name = "condition")
           ReportMacRequestCondition condition) throws ServiceException {

       try {
    	   FindReportMacRequestByCondCmd cmd = new FindReportMacRequestByCondCmd();
           cmd.setFindReportMacRequestCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportMacRequestResult();
       } catch (KKHException e) {
    	   ReportMacRequestResult result = new ReportMacRequestResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }
   /**
    * 請求書の更新処理を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "UpdateReportMacReqResult")
   public UpdateReportMacReqResult updateReportMacReq(
           @WebParam(name = "condition")
           UpdateReportMacReqCondition vo) throws ServiceException {

       try {
    	   UpdateReportMacReqCmd cmd = new UpdateReportMacReqCmd();
           cmd.setUpdateReportMacVO(vo);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getUpdateReportMacReqResult();
       } catch (KKHException e) {
    	   UpdateReportMacReqResult result = new UpdateReportMacReqResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }
}