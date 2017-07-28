package jp.co.isid.kkh.service.mastermaintenance;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.controller.master.FindMasterByCondCmd;
import jp.co.isid.kkh.controller.master.FindMasterDefineByCondCmd;
import jp.co.isid.kkh.controller.master.FindMasterItemByCondCmd;
import jp.co.isid.kkh.controller.master.MasterRegisterCmd;
import jp.co.isid.kkh.controller.master.MasterTablesRegisterCmd;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterCondition;
import jp.co.isid.kkh.model.master.MasterItemResult;
import jp.co.isid.kkh.model.master.MasterRegisterResult;
import jp.co.isid.kkh.model.master.MasterRegisterVO;
import jp.co.isid.kkh.model.master.MasterResult;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.util.KKHLogUtility;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>マスタメンテナンスのサービス</P>
 * <P>
 * マスタメンテナンステーブルマスタのサービスクラスです。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author JSE K.Fukuda
 */
@WebService(serviceName = "masterService",
        targetNamespace = "http://mastermaintenance.service.kkh.isid.co.jp/")
public class MasterService {

    /**
     * マスタ定義の条件検索を行います。
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "MasterResult")
    public MasterResult findMasterDefineByCond(
            @WebParam(name = "condition")
            MasterCondition condition) throws ServiceException {

        try {
            FindMasterDefineByCondCmd cmd = new FindMasterDefineByCondCmd();
            cmd.setFindMasterDefineCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getMasterResult();
        } catch (KKHException e) {
            KKHLogUtility.outLog(e);
            MasterResult result = new MasterResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }

    }

    /**
    * マスタデータの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "MasterResult")
   public MasterResult findMasterByCond(
           @WebParam(name = "condition")
           MasterCondition condition) throws ServiceException {

       try {
           FindMasterByCondCmd cmd = new FindMasterByCondCmd();
           cmd.setFindMasterCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getMasterResult();
       } catch (KKHException e) {
           KKHLogUtility.outLog(e);
           MasterResult result = new MasterResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

   /**
    * マスタデータの登録を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "masterRegisterResult")
    public MasterRegisterResult registerMaster(@WebParam(name = "masterRegisterVO") MasterRegisterVO masterRegisterVO)
            throws ServiceException {

        try {
            MasterRegisterCmd cmd = new MasterRegisterCmd();
            cmd.setMasterRegisterVO(masterRegisterVO);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getMasterRegisterResult();
        } catch (KKHException e) {
            KKHLogUtility.outLog(e);
            MasterRegisterResult result = new MasterRegisterResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }
   /**
    * マスタデータの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "MasterItemResult")
   public MasterItemResult findMasterItemByCond(
           @WebParam(name = "condition")
           MasterCondition condition) throws ServiceException {

       try {
           FindMasterItemByCondCmd cmd = new FindMasterItemByCondCmd();
           cmd.setFindMasterCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getMasterItemResult();
       } catch (KKHException e) {
           KKHLogUtility.outLog(e);
           MasterItemResult result = new MasterItemResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }
   /**
    * 複数のマスタデータの登録を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "masterRegisterResult")
    public MasterRegisterResult registerMasterTables(
            @WebParam(name = "masterRegisterVO1") MasterRegisterVO masterRegisterVO1,
            @WebParam(name = "masterRegisterVO2") MasterRegisterVO masterRegisterVO2)
            throws ServiceException {

        try {
            MasterTablesRegisterCmd cmd = new MasterTablesRegisterCmd();
            cmd.setMasterTablesRegisterVO(masterRegisterVO1, masterRegisterVO2);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getMasterRegisterResult();
        } catch (KKHException e) {
            KKHLogUtility.outLog(e);
            MasterRegisterResult result = new MasterRegisterResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

}
