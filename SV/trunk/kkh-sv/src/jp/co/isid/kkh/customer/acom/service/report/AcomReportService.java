package jp.co.isid.kkh.customer.acom.service.report;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.customer.acom.controller.report.FindReportAcomByCondCmd;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomCondition;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.util.KKHLogUtility;
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
* ・新規作成(2012/01/12)<BR>
* </P>
* @author
*/
@WebService(serviceName = "acomReportService",
       targetNamespace = "http://report.service.acom.customer.kkh.isid.co.jp/")
public class AcomReportService {
    /**
    * 購入伝票一覧表（ACOM）データの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportAcomResult")
   public ReportAcomResult findReportAcomByCond(
           @WebParam(name = "condition")
           ReportAcomCondition condition) throws ServiceException {

       try {
    	   FindReportAcomByCondCmd cmd = new FindReportAcomByCondCmd();
           cmd.setFindReportAcomCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportAcomResult();
       } catch (KKHException e) {
    	   KKHLogUtility.outLog(e);
    	   ReportAcomResult result = new ReportAcomResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }

}
