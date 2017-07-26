package jp.co.isid.kkh.customer.skyp.service.report;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.customer.skyp.controller.report.FindReportSkypByCondCmd;
import jp.co.isid.kkh.customer.skyp.model.report.ReportSkypCondition;
import jp.co.isid.kkh.customer.skyp.model.report.ReportSkypResult;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>
 * ���[�̃T�[�r�X(�X�J�p�[)
 * </P>
 * <P>
 * ���[�̃T�[�r�X�N���X�ł��B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/16 JSE Y.Sato)<BR>
 * </P>
 *
 * @author Y.Sato
 */
@WebService(serviceName = "reportSkypService", targetNamespace = "http://report.service.skyp.customer.kkh.isid.co.jp/")
public class ReportSkypService {

    /**
     * ���[�i�X�J�p�[_�[�i�^�������j�f�[�^���擾����B
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "ReportSkypResult")
    public ReportSkypResult findReportSkypByCond(
            @WebParam(name = "condition") ReportSkypCondition condition)
            throws ServiceException {

        try {
            FindReportSkypByCondCmd cmd = new FindReportSkypByCondCmd();
            cmd.setReportSkypCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getReportSkypResult();
        } catch (KKHException e) {
            ReportSkypResult result = new ReportSkypResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

}
