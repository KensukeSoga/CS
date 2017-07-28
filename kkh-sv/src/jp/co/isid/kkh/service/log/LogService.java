package jp.co.isid.kkh.service.log;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.controller.log.FindLogByCondCmd;
import jp.co.isid.kkh.controller.log.LogRegistCmd;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.log.LogCondition;
import jp.co.isid.kkh.model.log.LogResult;
import jp.co.isid.kkh.model.log.LogVO;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.util.KKHLogUtility;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>ログマスタ検索のサービス</P>
 * <P>
 * ログマスタ検索のサービスクラスです。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/11 IP H.Shimizu)<BR>
 * </P>
 * @author IP H.Shimizu
 */
@WebService(serviceName = "logService",
        targetNamespace = "http://log.service.kkh.isid.co.jp/")
public class LogService {

    /**
    * メッセージの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "LogResult")
   public LogResult findLogByCond(
           @WebParam(name = "condition")
           LogCondition condition) throws ServiceException {

       try {
    	   FindLogByCondCmd cmd = new FindLogByCondCmd();
           cmd.setFindLogCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getLogResult();
       } catch (KKHException e) {
    	   KKHLogUtility.outLog(e);
    	   LogResult result = new LogResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

   /**
    * ログデータの登録を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "LogResult")
   public LogResult registLog(
           @WebParam(name = "logVO")
           LogVO logVO) throws ServiceException {

       try {
    	   LogRegistCmd cmd = new LogRegistCmd();
           cmd.setRegistLogVO(logVO);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return new LogResult();
       } catch (KKHException e) {
    	   KKHLogUtility.outLog(e);
    	   LogResult result = new LogResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }

}
