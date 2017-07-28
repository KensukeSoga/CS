package jp.co.isid.kkh.customer.lion.service.master;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.customer.lion.controller.master.FindRdKMastByCondCmd;
import jp.co.isid.kkh.customer.lion.controller.master.FindRdMastByCondCmd;
import jp.co.isid.kkh.customer.lion.controller.master.FindTvKMastByCondCmd;
import jp.co.isid.kkh.customer.lion.controller.master.FindTvMastByCondCmd;
import jp.co.isid.kkh.customer.lion.controller.master.InsertLionZashiRyoSpcMastCmd;
import jp.co.isid.kkh.customer.lion.controller.master.LionRdKMastRegisterCmd;
import jp.co.isid.kkh.customer.lion.controller.master.LionRdMastRegisterCmd;
import jp.co.isid.kkh.customer.lion.controller.master.LionTvKMastRegisterCmd;
import jp.co.isid.kkh.customer.lion.controller.master.LionZashiRyoSpcMastCmd;
import jp.co.isid.kkh.customer.lion.controller.master.UpdateTimeStampCmd;
import jp.co.isid.kkh.customer.lion.controller.master.LionTvMastRegisterCmd;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.lion.model.master.FindRdKMastCondition;
import jp.co.isid.kkh.customer.lion.model.master.FindRdKMastResult;
import jp.co.isid.kkh.customer.lion.model.master.FindRdMastCondition;
import jp.co.isid.kkh.customer.lion.model.master.FindRdMastResult;
import jp.co.isid.kkh.customer.lion.model.master.FindTvKMastCondition;
import jp.co.isid.kkh.customer.lion.model.master.FindTvKMastResult;
import jp.co.isid.kkh.customer.lion.model.master.FindTvMastCondition;
import jp.co.isid.kkh.customer.lion.model.master.FindTvMastResult;
import jp.co.isid.kkh.customer.lion.model.master.InsertLionZashiRyoSpcMastResult;
import jp.co.isid.kkh.customer.lion.model.master.InsertLionZashiRyoSpcMastVO;
import jp.co.isid.kkh.customer.lion.model.master.LionRdKMastRegisterVO;
import jp.co.isid.kkh.customer.lion.model.master.LionRdMastRegisterVO;
import jp.co.isid.kkh.customer.lion.model.master.LionTvKMastRegisterVO;
import jp.co.isid.kkh.customer.lion.model.master.LionZashiRyoSpcMastCondition;
import jp.co.isid.kkh.customer.lion.model.master.LionZashiRyoSpcMastResult;
import jp.co.isid.kkh.customer.lion.model.master.UpdateTimeStampResult;
import jp.co.isid.kkh.customer.lion.model.master.UpdateTimeStampVO;
import jp.co.isid.kkh.customer.lion.model.master.LionRegisterResult;
import jp.co.isid.kkh.customer.lion.model.master.LionTvMastRegisterVO;
import jp.co.isid.kkh.service.CommandInvokerUtil;
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
@WebService(serviceName = "masterLionService",
        targetNamespace = "http://master.service.lion.customer.kkh.isid.co.jp/")
public class MasterLionService {

   /**
    * マスタデータの登録を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "LionRegisterResult")
    public LionRegisterResult registerLionTvMast(@WebParam(name = "lionTvMastRegisterVO") LionTvMastRegisterVO lionRegisterVO)
            throws ServiceException {

        try {
            LionTvMastRegisterCmd cmd = new LionTvMastRegisterCmd();
            cmd.setLionTvMastRegisterVO(lionRegisterVO);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getLionRegisterResult();
        } catch (KKHException e) {
            LionRegisterResult result = new LionRegisterResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

   /**
    * ラジオ番組マスタデータの登録を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "LionRegisterResult")
    public LionRegisterResult registerLionRdMast(@WebParam(name = "lionRdMastRegisterVO") LionRdMastRegisterVO lionRegisterVO)
            throws ServiceException {

        try {
            LionRdMastRegisterCmd cmd = new LionRdMastRegisterCmd();
            cmd.setLionRdMastRegisterVO(lionRegisterVO);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getLionRegisterResult();
        } catch (KKHException e) {
            LionRegisterResult result = new LionRegisterResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

   /**
    * テレビ局マスタデータの登録を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "LionRegisterResult")
    public LionRegisterResult registerLionTvKMast(@WebParam(name = "lionTvKMastRegisterVO") LionTvKMastRegisterVO lionRegisterVO)
            throws ServiceException {

        try {
            LionTvKMastRegisterCmd cmd = new LionTvKMastRegisterCmd();
            cmd.setLionTvKMastRegisterVO(lionRegisterVO);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getLionRegisterResult();
        } catch (KKHException e) {
            LionRegisterResult result = new LionRegisterResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

   /**
    * ラジオ局マスタデータの登録を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "LionRegisterResult")
    public LionRegisterResult registerLionRdKMast(@WebParam(name = "lionRdKMastRegisterVO") LionRdKMastRegisterVO lionRegisterVO)
            throws ServiceException {

        try {
            LionRdKMastRegisterCmd cmd = new LionRdKMastRegisterCmd();
            cmd.setLionRdKMastRegisterVO(lionRegisterVO);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getLionRegisterResult();
        } catch (KKHException e) {
            LionRegisterResult result = new LionRegisterResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * タイムスタンプの変更処理を行う
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "UpdateTimeStampResult")
    public UpdateTimeStampResult updateTimeStampData(
            @WebParam(name = "condition")
            UpdateTimeStampVO vo) throws ServiceException {

        try {
            UpdateTimeStampCmd cmd = new UpdateTimeStampCmd();
            cmd.setUpdateTimeStampVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getUpdateTimeStampResult();
        } catch (KKHException e) {
            UpdateTimeStampResult result = new UpdateTimeStampResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
    * TV番組データの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "FindTvMastResult")
   public FindTvMastResult findTvMastByCond(
           @WebParam(name = "condition")
           FindTvMastCondition condition) throws ServiceException {

       try {
           FindTvMastByCondCmd cmd = new FindTvMastByCondCmd();
           cmd.setFindTvMastCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getFindTvMastResult();
       } catch (KKHException e) {
           FindTvMastResult result = new FindTvMastResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

    /**
    * ラジオ番組データの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "FindRdMastResult")
   public FindRdMastResult findRdMastByCond(
           @WebParam(name = "condition")
           FindRdMastCondition condition) throws ServiceException {

       try {
           FindRdMastByCondCmd cmd = new FindRdMastByCondCmd();
           cmd.setFindRdMastCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getFindRdMastResult();
       } catch (KKHException e) {
           FindRdMastResult result = new FindRdMastResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

   /**
    * TV局データの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "FindTvKMastResult")
   public FindTvKMastResult findTvKMastByCond(
           @WebParam(name = "condition")
           FindTvKMastCondition condition) throws ServiceException {

       try {
           FindTvKMastByCondCmd cmd = new FindTvKMastByCondCmd();
           cmd.setFindTvKMastCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getFindTvKMastResult();
       } catch (KKHException e) {
           FindTvKMastResult result = new FindTvKMastResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

   /**
    * ラジオ局データの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "FindRdKMastResult")
   public FindRdKMastResult findRdKMastByCond(
           @WebParam(name = "condition")
           FindRdKMastCondition condition) throws ServiceException {

       try {
           FindRdKMastByCondCmd cmd = new FindRdKMastByCondCmd();
           cmd.setFindRdKMastCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getFindRdKMastResult();
       } catch (KKHException e) {
           FindRdKMastResult result = new FindRdKMastResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

   /**
    * 雑誌料金スペースデータの条件検索を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "LionZashiRyoSpcMastResult")
   public LionZashiRyoSpcMastResult lionZashiRyoSpcMastByCond(
           @WebParam(name = "condition")
           LionZashiRyoSpcMastCondition condition) throws ServiceException {
       try {
           LionZashiRyoSpcMastCmd cmd = new LionZashiRyoSpcMastCmd();
           cmd.setLionZashiRyoSpcMastCondition(condition);
           CommandInvokerUtil.getCommandInvoker().execute(cmd);
           return cmd.getLionZashiRyoSpcMastResult();
       } catch (KKHException e) {
           LionZashiRyoSpcMastResult result = new LionZashiRyoSpcMastResult();
           result.toErrorInfo(e);
           return result;
       } catch (Throwable e) {
           ExceptionHandler.getInstance().handleException(e);
           return null;
       }

   }

   /**
    * 雑誌料金スペースデータの更新を行います。
    * @throws ServiceException
    */
   @WebMethod
   @WebResult(name = "InsertLionZashiRyoSpcMastResult")
    public InsertLionZashiRyoSpcMastResult insertLionZashiRyoSpcMast(@WebParam(name = "insertLionZashiRyoSpcMastVO") InsertLionZashiRyoSpcMastVO insertLionZashiRyoSpcMastVO)
            throws ServiceException {

        try {
            InsertLionZashiRyoSpcMastCmd cmd = new InsertLionZashiRyoSpcMastCmd();
            cmd.setInsertLionZashiRyoSpcMastVO(insertLionZashiRyoSpcMastVO);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getInsertLionZashiRyoSpcMastResult();
        } catch (KKHException e) {
            InsertLionZashiRyoSpcMastResult result = new InsertLionZashiRyoSpcMastResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

}
