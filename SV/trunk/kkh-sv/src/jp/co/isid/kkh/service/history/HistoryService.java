package jp.co.isid.kkh.service.history;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.controller.history.HistoryLionJyutDownByCondCmd;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.history.HistoryJyutDownCondition;
import jp.co.isid.kkh.model.history.HistoryJyutDownResult;

import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.util.KKHLogUtility;

import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>履歴のサービス</P>
 * <P>
 * 履歴のサービスクラスです。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/1 Fourm H.Izawa)<BR>
 * </P>
 * @author Fourm H.Izawa
 */
@WebService(serviceName = "historyService",
        targetNamespace = "http://history.service.kkh.isid.co.jp/")
public class HistoryService {


   /**
    * 受注ダウンロードデータの検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "HistoryLionJyutDownResult")
   public HistoryJyutDownResult findHistoryByCond(
           @WebParam(name = "condition")
           HistoryJyutDownCondition condition) throws ServiceException {

       try {
    	   HistoryLionJyutDownByCondCmd cmd = new HistoryLionJyutDownByCondCmd();
           cmd.setFindHistoryLionJyutDownCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getHistoryLionJyutDownResult();
       } catch (KKHException e) {
    	   KKHLogUtility.outLog(e);
    	   HistoryJyutDownResult result = new HistoryJyutDownResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

}