package jp.co.isid.kkh.customer.tkd.service.report;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.customer.tkd.controller.report.ReportTkdBillingByItemByCondCmd;
import jp.co.isid.kkh.customer.tkd.controller.report.ReportTkdBillingByMiddleClassificationByCondCmd;
import jp.co.isid.kkh.customer.tkd.controller.report.ReportTkdBillingForPlanningCostByCondCmd;
import jp.co.isid.kkh.customer.tkd.model.report.ReportTkdBillingByItemCondition;
import jp.co.isid.kkh.customer.tkd.model.report.ReportTkdBillingByItemResult;
import jp.co.isid.kkh.customer.tkd.model.report.ReportTkdBillingByMiddleClassificationCondition;
import jp.co.isid.kkh.customer.tkd.model.report.ReportTkdBillingByMiddleClassificationResult;
import jp.co.isid.kkh.customer.tkd.model.report.ReportTkdBillingForPlanningCostCondition;
import jp.co.isid.kkh.customer.tkd.model.report.ReportTkdBillingForPlanningCostResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>
 * ���[�̃T�[�r�X
 * </P>
 * <P>
 * ���[�̃T�[�r�X�N���X�ł��B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/15 JSE KT)<BR>
 * </P>
 *
 * @author JSE H.Sasaki
 */
@WebService(serviceName = "reportTkdBillingService", targetNamespace = "http://report.service.tkd.customer.kkh.isid.co.jp/")
public class ReportTkdBillingService {

	/**
	 * ���c�������ׁi�����ޕʁj�f�[�^���擾����
	 *
	 * @throws ServiceException
	 */
	@WebMethod
	@WebResult(name = "ReportTkdBillingByMiddleClassificationResult")
	public ReportTkdBillingByMiddleClassificationResult findReportTkdBillingByMiddleClassificationByCond(@WebParam(name = "condition") ReportTkdBillingByMiddleClassificationCondition condition) throws ServiceException {
		try {
			ReportTkdBillingByMiddleClassificationByCondCmd cmd = new ReportTkdBillingByMiddleClassificationByCondCmd();
			cmd.setFindReportTkdBillingCondition(condition);
			CommandInvokerUtil.getCommandInvoker().execute(cmd);
			return cmd.getReportTkdBillingResult();
		} catch (KKHException e) {
			ReportTkdBillingByMiddleClassificationResult result = new ReportTkdBillingByMiddleClassificationResult();
			result.toErrorInfo(e);
			return result;
		} catch (Throwable e) {
			ExceptionHandler.getInstance().handleException(e);
			return null;
		}
	}

	/**
	 * ���c�������ׁi�i�ڕʁj�f�[�^���擾����
	 *
	 * @throws ServiceException
	 */
	@WebMethod
	@WebResult(name = "ReportTkdBillingByItemResult")
	public ReportTkdBillingByItemResult findReportTkdBillingByItemByCond(@WebParam(name = "condition") ReportTkdBillingByItemCondition condition) throws ServiceException {
		try {
			ReportTkdBillingByItemByCondCmd cmd = new ReportTkdBillingByItemByCondCmd();
			cmd.setFindReportTkdBillingCondition(condition);
			CommandInvokerUtil.getCommandInvoker().execute(cmd);
			return cmd.getReportTkdBillingResult();
		} catch (KKHException e) {
			ReportTkdBillingByItemResult result = new ReportTkdBillingByItemResult();
			result.toErrorInfo(e);
			return result;
		} catch (Throwable e) {
			ExceptionHandler.getInstance().handleException(e);
			return null;
		}
	}

	/**
	 * ���c�������ׁi����j�f�[�^���擾����
	 *
	 * @throws ServiceException
	 */
	@WebMethod
	@WebResult(name = "ReportTkdBillingForPlanningCostResult")
	public ReportTkdBillingForPlanningCostResult findReportTkdBillingForPlanningCostByCond(@WebParam(name = "condition") ReportTkdBillingForPlanningCostCondition condition) throws ServiceException {
		try {
			ReportTkdBillingForPlanningCostByCondCmd cmd = new ReportTkdBillingForPlanningCostByCondCmd();
			cmd.setFindReportTkdBillingCondition(condition);
			CommandInvokerUtil.getCommandInvoker().execute(cmd);
			return cmd.getReportTkdBillingResult();
		} catch (KKHException e) {
			ReportTkdBillingForPlanningCostResult result = new ReportTkdBillingForPlanningCostResult();
			result.toErrorInfo(e);
			return result;
		} catch (Throwable e) {
			ExceptionHandler.getInstance().handleException(e);
			return null;
		}
	}
}
