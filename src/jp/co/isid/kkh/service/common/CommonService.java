package jp.co.isid.kkh.service.common;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.controller.common.AccountOperationStatusCheckCmd;
import jp.co.isid.kkh.controller.common.FindCommonByCondCmd;
import jp.co.isid.kkh.controller.common.FindCommonCodeMasterByCondCmd;
import jp.co.isid.kkh.controller.common.GetEigyoBiCmd;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.common.AccountOperationStatusCondition;
import jp.co.isid.kkh.model.common.AccountOperationStatusResult;
import jp.co.isid.kkh.model.common.CommonCodeMasterCondition;
import jp.co.isid.kkh.model.common.CommonCodeMasterResult;
import jp.co.isid.kkh.model.common.CommonCondition;
import jp.co.isid.kkh.model.common.CommonResult;
import jp.co.isid.kkh.model.common.EigyoBiCondition;
import jp.co.isid.kkh.model.common.EigyoBiResult;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.util.KKHLogUtility;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>マスタメンテナンスのサービス</P>
 * <P>
 * マスタメンテナンステーブルマスタのサービスクラスです。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/11 IP H.Shimizu)<BR>
 * </P>
 * @author IP H.Shimizu
 */
@WebService(serviceName = "commonService",
        targetNamespace = "http://common.service.kkh.isid.co.jp/")
public class CommonService {

    /**
    * メッセージの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "CommonResult")
   public CommonResult findCommonByCond(
           @WebParam(name = "condition")
           CommonCondition condition) throws ServiceException {

       try {
    	   FindCommonByCondCmd cmd = new FindCommonByCondCmd();
           cmd.setFindCommonCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getCommonResult();
       } catch (KKHException e) {
    	   KKHLogUtility.outLog(e);
    	   CommonResult result = new CommonResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

   /**
    * 共通コードマスタの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "CommonCodeMasterResult")
   public CommonCodeMasterResult findCommonCodeMasterByCond(
           @WebParam(name = "condition")
           CommonCodeMasterCondition condition) throws ServiceException {

       try {
       	FindCommonCodeMasterByCondCmd cmd = new FindCommonCodeMasterByCondCmd();
           cmd.setFindCommonCodeMasterCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getCommonCodeMasterResult();
       } catch (KKHException e) {
    	   KKHLogUtility.outLog(e);
    	   CommonCodeMasterResult result = new CommonCodeMasterResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

   /**
    * 共通コードマスタの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "EigyoBiResult")
   public EigyoBiResult getEigyoBi(
           @WebParam(name = "condition")
           EigyoBiCondition condition) throws ServiceException {

       try {
    	   GetEigyoBiCmd cmd = new GetEigyoBiCmd();
           cmd.setEigyoBiCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getEigyoBiResult();
       } catch (KKHException e) {
    	   KKHLogUtility.outLog(e);
    	   EigyoBiResult result = new EigyoBiResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

   /**
    * 業務会計稼働状況をチェックします。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "AccountOperationStatusResult")
   public AccountOperationStatusResult checkAccountOperationStatus(
           @WebParam(name = "condition")
           AccountOperationStatusCondition condition) throws ServiceException {

       try {
           AccountOperationStatusCheckCmd cmd = new AccountOperationStatusCheckCmd();
           cmd.setAccountOperationStatusCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getAccountOperationStatusResult();
       } catch (KKHException e) {
    	   KKHLogUtility.outLog(e);
           AccountOperationStatusResult result = new AccountOperationStatusResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

}
