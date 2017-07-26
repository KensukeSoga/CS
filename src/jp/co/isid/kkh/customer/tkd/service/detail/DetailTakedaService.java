package jp.co.isid.kkh.customer.tkd.service.detail;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.customer.tkd.controller.detail.AutoJissiBycondCmd;
import jp.co.isid.kkh.customer.tkd.controller.detail.FindJissiNoCntByCondCmd;
import jp.co.isid.kkh.customer.tkd.controller.detail.FindMaxJissiNoByCondCmd;
import jp.co.isid.kkh.customer.tkd.controller.detail.FindThb2KmeiBycondCmd;
import jp.co.isid.kkh.customer.tkd.controller.detail.UpJissiBycondCmd;
import jp.co.isid.kkh.customer.tkd.model.detail.AutoJissiBycondResult;
import jp.co.isid.kkh.customer.tkd.model.detail.AutoJissiBycondVO;
import jp.co.isid.kkh.customer.tkd.model.detail.FindJissiNoCntByCondResult;
import jp.co.isid.kkh.customer.tkd.model.detail.FindJissiNoCntCondition;
import jp.co.isid.kkh.customer.tkd.model.detail.FindMaxJissiNoByCondResult;
import jp.co.isid.kkh.customer.tkd.model.detail.FindMaxJissiNoCondition;
import jp.co.isid.kkh.customer.tkd.model.detail.FindThb2KmeiBycondResult;
import jp.co.isid.kkh.customer.tkd.model.detail.FindThb2KmeiBycondVO;
import jp.co.isid.kkh.customer.tkd.model.detail.UpJissiBycondResult;
import jp.co.isid.kkh.customer.tkd.model.detail.UpJissiBycondVO;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>�L����ׂ̃T�[�r�X(���c��i)</P>
 * <P>
 * �L����ׂ̃T�[�r�X�N���X�ł��B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/06 H.izawa)<BR>
 * </P>
 * @author H.izawa
 */
@WebService(serviceName = "detailTakedaService",
        targetNamespace = "http://detail.service.tkd.customer.kkh.isid.co.jp/")
public class DetailTakedaService {

    /**
     * ���{NO�̕ύX�������s���B
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "UpJissiBycondResult")
    public UpJissiBycondResult upJissiNoBycond(
            @WebParam(name = "condition")
            UpJissiBycondVO vo) throws ServiceException {

        try {
            UpJissiBycondCmd cmd = new UpJissiBycondCmd();
            cmd.setUpJissiBycondVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getUpJissiBycondResult();
        } catch (KKHException e) {
            UpJissiBycondResult result = new UpJissiBycondResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * ���{NO�̕t�^�������s���B
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "AutoJissiBycondResult")
    public AutoJissiBycondResult autoNoBycond(
            @WebParam(name = "condition")
            AutoJissiBycondVO vo) throws ServiceException {

        try {
            AutoJissiBycondCmd cmd = new AutoJissiBycondCmd();
            cmd.setAutoJissiBycondVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getAutoJissiBycondResult();
        } catch (KKHException e) {
            AutoJissiBycondResult result = new AutoJissiBycondResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * ���{NO�̏������s���B
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "FindThb2KmeiBycondResult")
    public FindThb2KmeiBycondResult jissiNo(
            @WebParam(name = "condition")
            FindThb2KmeiBycondVO vo) throws ServiceException {

        try {
            FindThb2KmeiBycondCmd cmd = new FindThb2KmeiBycondCmd();
            cmd.setFindThb2KmeiBycondVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getFindThb2KmeiBycondResult();
        } catch (KKHException e) {
            FindThb2KmeiBycondResult result = new FindThb2KmeiBycondResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * ���{NO�̍ő�l���擾����B
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "FindMaxJissiNoByCondResult")
    public FindMaxJissiNoByCondResult findMaxJissiNoByCond(
            @WebParam(name = "condition")
            FindMaxJissiNoCondition condition) throws ServiceException {

        try {
            FindMaxJissiNoByCondCmd cmd = new FindMaxJissiNoByCondCmd();
            cmd.setFindMaxJissiNoCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getFindByCondResult();
        } catch (KKHException e) {
        	FindMaxJissiNoByCondResult result = new FindMaxJissiNoByCondResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * �g�p�ώ��{NO�̌������擾����B
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "FindJissiNoCntByCondResult")
    public FindJissiNoCntByCondResult findJissiNoCntByCond(
            @WebParam(name = "condition")
            FindJissiNoCntCondition condition) throws ServiceException {

        try {
            FindJissiNoCntByCondCmd cmd = new FindJissiNoCntByCondCmd();
            cmd.setFindJissiNoCntCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getFindByCondResult();
        } catch (KKHException e) {
        	FindJissiNoCntByCondResult result = new FindJissiNoCntByCondResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

}
