package jp.co.isid.kkh.customer.lion.service.report;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.customer.lion.controller.report.FindAddChangeReportBaitaiByCondCmd;
import jp.co.isid.kkh.customer.lion.controller.report.FindAddChangeReportSeisakuByCondCmd;
import jp.co.isid.kkh.customer.lion.controller.report.FindFDLionByCondCmd;
import jp.co.isid.kkh.customer.lion.controller.report.FindInvoicePlanByCondCmd;
import jp.co.isid.kkh.customer.lion.controller.report.FindNewReportLionByCondCmd;
import jp.co.isid.kkh.customer.lion.controller.report.FindOrderDiffListByCondCmd;
import jp.co.isid.kkh.customer.lion.controller.report.FindReportLionByCondCmd;
import jp.co.isid.kkh.customer.lion.controller.report.FindDetailListLionByCondCmd;
import jp.co.isid.kkh.customer.lion.controller.report.LionHistoryByCondCmd;
import jp.co.isid.kkh.customer.lion.model.report.AddChangeReportLionBaitaiCondition;
import jp.co.isid.kkh.customer.lion.model.report.AddChangeReportLionBaitaiResult;
import jp.co.isid.kkh.customer.lion.model.report.AddChangeReportLionSeisakuCondition;
import jp.co.isid.kkh.customer.lion.model.report.AddChangeReportLionSeisakuResult;
import jp.co.isid.kkh.customer.lion.model.report.FDLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.FDLionResult;
import jp.co.isid.kkh.customer.lion.model.report.InvoicePlanLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.InvoicePlanLionResult;
import jp.co.isid.kkh.customer.lion.model.report.LionHistoryCondition;
import jp.co.isid.kkh.customer.lion.model.report.LionHistoryResult;
import jp.co.isid.kkh.customer.lion.model.report.NewReportLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.NewReportLionResult;
import jp.co.isid.kkh.customer.lion.model.report.OrderDiffListLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.OrderDiffListLionResult;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionResult;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;
/**
* <P>
* ���C�I�����[�T�[�r�X
* </P>
* <P>
* ���Ӑ惉�C�I���̒��[�T�[�r�X�N���X�ł��B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2012/01/12)<BR>
* �E��r���[�Ή��A�������\��\�Ή�(2014/07/31 HLC S.Fujimoto)<BR>
* �E��r���[�Ή�(2014/11/10 HLC S.Fujimoto)<BR>
* </P>
*
* @author
*/
@WebService(serviceName = "lionReportService",
       targetNamespace = "http://report.service.lion.customer.kkh.isid.co.jp/")
public class LionReportService {

    /**
    * ���C�I���v���[�t���X�g���[�f�[�^�̏����������s���܂��B
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "ReportLionResult")
   public ReportLionResult findReportLionByCond(
           @WebParam(name = "condition")
           ReportLionCondition condition) throws ServiceException {

       try {
           FindReportLionByCondCmd cmd = new FindReportLionByCondCmd();
           cmd.setFindReportLionCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportLionResult();
       } catch (KKHException e) {
           ReportLionResult result = new ReportLionResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }

   /**
    * ���C�I�����ϒ��[�f�[�^�̏����������s���܂��B
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "NewReportLionResult")
   public NewReportLionResult findNewReportLionByCond(
           @WebParam(name = "condition")
           NewReportLionCondition condition) throws ServiceException {

       try {
           FindNewReportLionByCondCmd cmd = new FindNewReportLionByCondCmd();
           cmd.setFindReportLionCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getReportLionResult();
       } catch (KKHException e) {
           NewReportLionResult result = new NewReportLionResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }

    /**
     * ���C�I��FD�o�̓f�[�^�̏����������s���܂��B
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "FindFDLionResult")
    public FDLionResult findFDLionByCond(@WebParam(name = "condition") FDLionCondition condition) throws ServiceException {
        try {
            FindFDLionByCondCmd cmd = new FindFDLionByCondCmd();
            cmd.setFindFDLionCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getFindFDLionResult();
        } catch (KKHException e) {
            FDLionResult result = new FDLionResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    // 2013/02/01 add start H.Okazaki
    /**
    * ���C�I�����׈ꗗ���[�f�[�^�̏����������s���܂��B
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "DetailListLionResult")
   public DetailListLionResult findDetailListLionByCond(
           @WebParam(name = "condition")
           DetailListLionCondition condition) throws ServiceException {

       try {
           FindDetailListLionByCondCmd cmd = new FindDetailListLionByCondCmd();
           cmd.setFindDetailListLionCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getDetailListLionResult();
       } catch (KKHException e) {
           DetailListLionResult result = new DetailListLionResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }
   // 2013/02/01 add end H.Okazaki

   /* 2014/07/31 ��r���[�Ή��A�������\��\�Ή� HLC fujimoto ADD start */
   /**
    * ���C�I�����쎺���X�g�f�[�^�̏����������s���܂��B
    * @param condition ���C�I�����[(���쎺���X�g)��������
    * @return ���C�I�����[(���쎺���X�g)�������ʕێ��N���X
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "AddChangeReportResult")
   public AddChangeReportLionSeisakuResult findAddChangeReportSeisakuByCond(
           @WebParam(name = "condition")
           AddChangeReportLionSeisakuCondition condition) throws ServiceException {

       try {
           FindAddChangeReportSeisakuByCondCmd cmd = new FindAddChangeReportSeisakuByCondCmd();
           cmd.setFindAddChangeReportCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getAddChangeReportResult();
       } catch (KKHException e) {
           AddChangeReportLionSeisakuResult result = new AddChangeReportLionSeisakuResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }

   /**
    * ���C�I���ǉ��ύX���X�g�f�[�^�̏����������s���܂��B
    * @param condition ���C�I�����[(�ǉ��ύX���X�g)��������
    * @return ���C�I�����[(�ǉ��ύX���X�g)�������ʕێ��N���X
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "AddChangeReportResult")
   public AddChangeReportLionBaitaiResult findAddChangeReportBaitaiByCond(
           @WebParam(name = "condition")
           AddChangeReportLionBaitaiCondition condition) throws ServiceException {

       try {
           FindAddChangeReportBaitaiByCondCmd cmd = new FindAddChangeReportBaitaiByCondCmd();
           cmd.setFindAddChangeReportCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getAddChangeReportResult();
       } catch (KKHException e) {
           AddChangeReportLionBaitaiResult result = new AddChangeReportLionBaitaiResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }

   /**
    * ���C�I���󒍃_�E�����[�h�A�L����׃f�[�^�̗���o�^���s���܂��B
    * @param cond ���C�I����������
    * @return ���C�I���������s����
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "LionHistoryResult")
   public LionHistoryResult registerLionOrderHistory(@WebParam(name = "condition") LionHistoryCondition cond)
       throws ServiceException {

       try {
           LionHistoryByCondCmd cmd = new LionHistoryByCondCmd();
           cmd.setLionHistoryCondition(cond);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getInsertHistoryResult();
       } catch (KKHException e) {
           LionHistoryResult result = new LionHistoryResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }

   /**
    * ���C�I�������\��\�f�[�^�̏����������s���܂��B
    * @param condition ���C�I���������\��\��������
    * @return ���C�I���������\��\�������ʕێ��N���X
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "InvoicePlanLionResult")
   public InvoicePlanLionResult findInvoicePlanByCond(
           @WebParam(name = "condition")
           InvoicePlanLionCondition condition) throws ServiceException {

       try {
           FindInvoicePlanByCondCmd cmd = new FindInvoicePlanByCondCmd();
           cmd.setFindInvoicePlanLionCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getInvoicePlanLionResult();
       } catch (KKHException e) {
           InvoicePlanLionResult result = new InvoicePlanLionResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }
   /* 2014/07/31 ��r���[�Ή��A�������\��\�Ή� HLC fujimoto ADD end */

   /* 2014/11/10 ��r���[�Ή� HLC fujimoto ADD start */
   /**
    * ���C�I���󒍍��وꗗ�f�[�^�̏����������s���܂��B
    * @param condition ���C�I���󒍍��وꗗ��������
    * @return ���C�I���󒍍��وꗗ�������ʕێ��N���X
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "InvoicePlanLionResult")
   public OrderDiffListLionResult findOrderDiffListByCond(
           @WebParam(name = "condition")
           OrderDiffListLionCondition condition) throws ServiceException {

       try {
           FindOrderDiffListByCondCmd cmd = new FindOrderDiffListByCondCmd();
           cmd.setFindOrderDiffListLionCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getOrderDiffListLionResult();
       } catch (KKHException e) {
           OrderDiffListLionResult result = new OrderDiffListLionResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }
   }
   /* 2014/11/10 ��r���[�Ή� HLC fujimoto ADD end */

}
