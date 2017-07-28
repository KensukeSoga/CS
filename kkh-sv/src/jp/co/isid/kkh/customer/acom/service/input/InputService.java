package jp.co.isid.kkh.customer.acom.service.input;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.customer.acom.controller.input.FindHikByCondCmd;
import jp.co.isid.kkh.customer.acom.controller.input.FindHikCheckDataByCondCmd;
import jp.co.isid.kkh.customer.acom.controller.input.FindHikDateCntByCondCmd;
import jp.co.isid.kkh.customer.acom.controller.input.HikRegistCmd;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.input.HikRegistVOList;
import jp.co.isid.kkh.customer.acom.model.input.HikCommonCondition;
import jp.co.isid.kkh.customer.acom.model.input.HikSearchDateCntVOList;
import jp.co.isid.kkh.customer.acom.model.input.HikSearchResult;
import jp.co.isid.kkh.customer.acom.model.input.HikRegistResult;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.util.KKHLogUtility;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>�����f�[�^�捞�̃T�[�r�X</P>
 * <P>
 * �����f�[�^�捞�e�[�u���}�X�^�̃T�[�r�X�N���X�ł��B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/08 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayash
i
 */
@WebService(serviceName = "inputService", targetNamespace = "http://input.service.acom.customer.kkh.isid.co.jp/")
public class InputService {

    /**
     * �����f�[�^�̏����������s���܂��B
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "HikSearchResult")
    public HikSearchResult findHikByCond(
            @WebParam(name = "condition")
            HikCommonCondition condition) throws ServiceException {

        try {
        	FindHikByCondCmd cmd = new FindHikByCondCmd();
            cmd.setHikSearchCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getHikSearchResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
        	HikSearchResult result = new HikSearchResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * �����f�[�^��(���t)�����������s���܂��B
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "HikSearchResult")
    public HikSearchResult findHikDateCntByCond(
            @WebParam(name = "volist")
            HikSearchDateCntVOList volist) throws ServiceException {

        try {
        	FindHikDateCntByCondCmd  cmd = new FindHikDateCntByCondCmd();
            cmd.setHikSearchDateCntVO(volist);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getHikSearchResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
        	HikSearchResult result = new HikSearchResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }


    /**
     * �����f�[�^(��r�p)�̏����������s���܂��B
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "HikCheckDataSearchResult")
    public HikSearchResult findHikCheckDataByCond(
            @WebParam(name = "volist")
            HikRegistVOList volist) throws ServiceException {

        try {
        	FindHikCheckDataByCondCmd cmd = new FindHikCheckDataByCondCmd();
            cmd.setHikRegistVOList(volist);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getHikSearchResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
        	HikSearchResult result = new HikSearchResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * �����f�[�^�̓o�^���s���܂��B
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "HikRegistResult")
    public HikRegistResult registHikByCond(
            @WebParam(name = "volist")
            HikRegistVOList volist) throws ServiceException {

        try {
        	HikRegistCmd cmd = new HikRegistCmd();
            cmd.setHikRegistVO(volist);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getHikRegistResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
        	HikRegistResult result = new HikRegistResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }
}
