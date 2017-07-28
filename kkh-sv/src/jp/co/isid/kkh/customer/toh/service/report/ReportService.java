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
 * <P>���[�̃T�[�r�X</P>
 * <P>
 * ���[�̃T�[�r�X�N���X�ł��B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/15 JSE KT)<BR>
 * </P>
 * @author JSE KT
 */
@WebService(serviceName = "reportService",
        targetNamespace = "http://report.service.toh.customer.kkh.isid.co.jp/")
public class ReportService {

    /**
    * �������׈ꗗ�iTOH�j�f�[�^�̏����������s���܂��B
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
    * �N���ʔ}�̕ʏW�v�iTOH�j�f�[�^�̏����������s���܂��B
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
//    * ���b�Z�[�W�̏����������s���܂��B
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
