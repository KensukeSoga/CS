package jp.co.isid.kkh.customer.mac.service.master;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.customer.mac.controller.master.MasterMacRegisterCmd;
import jp.co.isid.kkh.customer.mac.model.master.FindMasterMacTnpRByCondCondition;
import jp.co.isid.kkh.customer.mac.model.master.MasterMacRegisterResult;
import jp.co.isid.kkh.customer.mac.model.master.MasterMacRegisterVO;
import jp.co.isid.kkh.customer.mac.controller.master.FindMasterMacTnpRByCondCmd;
import jp.co.isid.kkh.customer.mac.model.master.FindMasterMacTnpRByCondResult;
import jp.co.isid.kkh.customer.mac.controller.master.FindMasterMacTnpRKeyByCondCmd;
import jp.co.isid.kkh.customer.mac.model.master.FindMasterMacTnpRKeyByCondResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>�}�X�^�����e�i���X�̃T�[�r�X</P>
 * <P>
 * �}�X�^�����e�i���X�e�[�u���}�X�^�̃T�[�r�X�N���X�ł��B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/27 IP Shimizu)<BR>
 * </P>
 * @author IP.Shimizu
 */
@WebService(serviceName = "masterMacService",
        targetNamespace = "http://master.service.mac.customer.kkh.isid.co.jp/")
public class MasterMacService {

   /**
    * �}�X�^�f�[�^�̓o�^���s���܂��B
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "masterRegisterResult")
    public MasterMacRegisterResult registerMacMaster(@WebParam(name = "masterMacRegisterVO") MasterMacRegisterVO masterRegisterVO)
            throws ServiceException {

        try {
            MasterMacRegisterCmd cmd = new MasterMacRegisterCmd();
            cmd.setMasterMacRegisterVO(masterRegisterVO);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getMasterMacRegisterResult();
        } catch (KKHException e) {
            MasterMacRegisterResult result = new MasterMacRegisterResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

   // 2013/02/01 add start H.Okazaki
   /**
    * �}�X�^�f�[�^�̓o�^���s���܂��B
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "FindMasterMacTnpRByCondResult")
    public FindMasterMacTnpRByCondResult findMacMasterTnpR(@WebParam(name = "condition") FindMasterMacTnpRByCondCondition condition) throws ServiceException {

        try {
            FindMasterMacTnpRByCondCmd cmd = new FindMasterMacTnpRByCondCmd();
            cmd.setFindMasterCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getMasterResult();
        } catch (KKHException e) {
            FindMasterMacTnpRByCondResult result = new FindMasterMacTnpRByCondResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

   /**
    * �}�X�^�f�[�^�̓o�^���s���܂��B
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "FindMasterMacTnpRKeyByCondResult")
    public FindMasterMacTnpRKeyByCondResult findMacMasterTnpRKey(@WebParam(name = "condition") FindMasterMacTnpRByCondCondition condition) throws ServiceException {

        try {
            FindMasterMacTnpRKeyByCondCmd cmd = new FindMasterMacTnpRKeyByCondCmd();
            cmd.setFindMasterCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getMasterResult();
        } catch (KKHException e) {
            FindMasterMacTnpRKeyByCondResult result = new FindMasterMacTnpRKeyByCondResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }
    // 2013/02/01 add end H.Okazaki

}
