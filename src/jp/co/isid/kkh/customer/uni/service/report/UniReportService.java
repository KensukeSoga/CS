package jp.co.isid.kkh.customer.uni.service.report;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.customer.uni.controller.report.FindReportUniByCondCmd;
import jp.co.isid.kkh.customer.uni.model.report.ReportUniCondition;
import jp.co.isid.kkh.customer.uni.model.report.ReportUniResult;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>
 * ���[�̃T�[�r�X(���j�`���[��)
 * </P>
 * <P>
 * ���[�̃T�[�r�X�N���X�ł��B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/23 JSE Y.Sato)<BR>
 * </P>
 *
 * @author Y.Sato
 */
@WebService(serviceName = "uniReportService", targetNamespace = "http://report.service.uni.customer.kkh.isid.co.jp/")
public class UniReportService {

    /**
     * ���[�i���j�`���[��_�L����ו\�j�f�[�^���擾����B
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "ReportUniResult")
    public ReportUniResult findReportUniByCond(
            @WebParam(name = "condition") ReportUniCondition condition)
            throws ServiceException {

        try {
            FindReportUniByCondCmd cmd = new FindReportUniByCondCmd();
            cmd.setReportUniCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getReportUniResult();
        } catch (KKHException e) {
            ReportUniResult result = new ReportUniResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

}
