package jp.co.isid.kkh.customer.kmn.service.report;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.customer.kmn.controller.report.FindReportKmnByCondCmd;
import jp.co.isid.kkh.customer.kmn.controller.report.FindReportKmnListByCondCmd;
import jp.co.isid.kkh.customer.kmn.controller.report.GetMaxSeqNoByCondCmd;
import jp.co.isid.kkh.customer.kmn.controller.report.UpdateSeqNoByCondCmd;
import jp.co.isid.kkh.customer.kmn.model.report.MaxSeqNoCondition;
import jp.co.isid.kkh.customer.kmn.model.report.MaxSeqNoResult;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnCondition;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnListCondition;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnListResult;
import jp.co.isid.kkh.customer.kmn.model.report.ReportKmnResult;
import jp.co.isid.kkh.customer.kmn.model.report.UpdateSeqNoCondition;
import jp.co.isid.kkh.customer.kmn.model.report.UpdateSeqNoResult;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>
 * ���[�̃T�[�r�X(����)
 * </P>
 * <P>
 * ���[�̃T�[�r�X�N���X�ł��B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
@WebService(serviceName = "kmnReportService", targetNamespace = "http://report.service.kmn.customer.kkh.isid.co.jp/")
public class KmnReportService {

    /**
     * �i����_���[�o�́j�f�[�^���擾����B
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "ReportKmnResult")
    public ReportKmnResult findReportKmnByCond(
            @WebParam(name = "condition") ReportKmnCondition condition)
            throws ServiceException {

        try {
            FindReportKmnByCondCmd cmd = new FindReportKmnByCondCmd();
            cmd.setReportKmnCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getReportKmnResult();
        } catch (KKHException e) {
            ReportKmnResult result = new ReportKmnResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * ���[�i����_�����ꗗ�j�f�[�^���擾����B
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "ReportKmnListResult")
    public ReportKmnListResult findReportKmnListByCond(
            @WebParam(name = "condition") ReportKmnListCondition condition)
            throws ServiceException {

        try {
            FindReportKmnListByCondCmd cmd = new FindReportKmnListByCondCmd();
            cmd.setReportKmnListCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getReportKmnListResult();
        } catch (KKHException e) {
            ReportKmnListResult result = new ReportKmnListResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * �V�[�N�G���XNo�ő�l���擾����B
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "MaxSeqNoResult")
    public MaxSeqNoResult getMaxSeqNoByCond(
            @WebParam(name = "condition") MaxSeqNoCondition condition)
            throws ServiceException {
        try {
            GetMaxSeqNoByCondCmd cmd = new GetMaxSeqNoByCondCmd();
            cmd.setMaxSeqNoCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getMaxSeqNoResult();
        } catch (KKHException e) {
            MaxSeqNoResult result = new MaxSeqNoResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * �V�[�N�G���XNo��o�^����B
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "UpdateSeqNoResult")
    public UpdateSeqNoResult updateSeqNoByCond(
            @WebParam(name = "condition") UpdateSeqNoCondition condition)
            throws ServiceException {
        try {
            UpdateSeqNoByCondCmd cmd = new UpdateSeqNoByCondCmd();
            cmd.setUpdateSeqNoCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getUpdateSeqNoResult();
        } catch (KKHException e) {
            UpdateSeqNoResult result = new UpdateSeqNoResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }
}
