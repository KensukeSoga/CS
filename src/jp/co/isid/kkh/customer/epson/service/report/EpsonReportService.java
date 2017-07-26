package jp.co.isid.kkh.customer.epson.service.report;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.util.KKHLogUtility;
import jp.co.isid.kkh.customer.epson.controller.report.FindReportEpsonSeikyuPlanByCondCmd;
import jp.co.isid.kkh.customer.epson.controller.report.FindReportEpsonSubMissionByCondCmd;
import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSeikyuPlanCondition;
import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSeikyuPlanResult;
import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSubMissionCondition;
import jp.co.isid.kkh.customer.epson.model.report.ReportEpsonSubMissionResult;
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
 * �E�V�K�쐬(2012/3/5 JSE YS)<BR>
 * �E�X�V(2012/3/9 IP JK)<BR>
 * </P>
 * @author JSE KT
 */
@WebService(serviceName = "epsonReportService",
        targetNamespace = "http://report.service.kkh.isid.co.jp/")
public class EpsonReportService {

    /**
    * ��o���[�i�G�v�\���j�f�[�^�̏����������s���܂��B
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportEpsonSubMissionResult")
   public ReportEpsonSubMissionResult findReportEpsonSubMissionByCond(
           @WebParam(name = "condition")
           ReportEpsonSubMissionCondition condition) throws ServiceException {

       try {
           FindReportEpsonSubMissionByCondCmd cmd = new FindReportEpsonSubMissionByCondCmd();
           cmd.setFindReportEpsonSubMissionCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportEpsonSubMissionResult();
       } catch (KKHException e) {
    	   KKHLogUtility.outLog(e);
           ReportEpsonSubMissionResult result = new ReportEpsonSubMissionResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }

   /** 2012/03/09 UPDATE START */
   /**
    * �����\��ꗗ�i�G�v�\���j�f�[�^�̏����������s���܂��B
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportEpsonSeikyuPlanResult")
   public ReportEpsonSeikyuPlanResult findReportEpsonSeikyuPlanByCond(
           @WebParam(name = "condition")
           ReportEpsonSeikyuPlanCondition condition) throws ServiceException {

       try {
           FindReportEpsonSeikyuPlanByCondCmd cmd = new FindReportEpsonSeikyuPlanByCondCmd();
           cmd.setFindReportEpsonSeikyuPlanCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportEpsonSeikyuPlanResult();
       } catch (KKHException e) {
    	   KKHLogUtility.outLog(e);
           ReportEpsonSeikyuPlanResult result = new ReportEpsonSeikyuPlanResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }
   /** 2012/03/09 UPDATE END */

}