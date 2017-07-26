package jp.co.isid.kkh.customer.lion.service.detail;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


import jp.co.isid.kkh.customer.lion.controller.detail.FindLionCardNoItrCmd;
import jp.co.isid.kkh.customer.lion.controller.detail.FindLionCardNoGetByCondCmd;
import jp.co.isid.kkh.customer.lion.controller.detail.FindLionCodeItrCmd;
import jp.co.isid.kkh.customer.lion.controller.detail.FindLionTVSpotByCondCmd;
import jp.co.isid.kkh.customer.lion.controller.detail.UpdateSubjectCmd;
import jp.co.isid.kkh.customer.lion.model.detail.UpdateSubjectResult;
import jp.co.isid.kkh.customer.lion.model.detail.UpdateSubjectVO;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoGetCondition;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoGetResult;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrCondition;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCardNoItrResult;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCodeItrCondition;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionCodeItrResult;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionDetailResult;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionDetailCondition;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotCondition;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotResult;
import jp.co.isid.kkh.customer.lion.controller.detail.FindLionDetailByCondCmd;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
*
* <P>広告費明細のサービス(ライオン)</P>
* <P>
* 広告費明細のサービスクラスです。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2012/2/9 A.naito)<BR>
* </P>
* @author A.naito
*/
@WebService(serviceName = "lionDetailService",
        targetNamespace = "http://detail.service.lion.customer.kkh.isid.co.jp/")
public class LionDetailService {
    /**
     * 件名変更処理を行う。
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "UpdateSubjectResult")
    public UpdateSubjectResult updateSubjectData(
            @WebParam(name = "condition")
            UpdateSubjectVO vo) throws ServiceException {

        try {
            UpdateSubjectCmd cmd = new UpdateSubjectCmd();
            cmd.setUpdateSubjectVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getUpdateSubjectResult();
        } catch (KKHException e) {
            UpdateSubjectResult result = new UpdateSubjectResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
        * 詳細（MEI2)の検索を行います。
        * @throws ServiceException
        */
       @WebMethod
       @WebResult(name = "FindLionDetailResult")
       public FindLionDetailResult findLionDetailByCond(
               @WebParam(name = "condition")
               FindLionDetailCondition condition) throws ServiceException {

           try {
               FindLionDetailByCondCmd cmd = new FindLionDetailByCondCmd();
               cmd.setFindLionDetailCondition(condition);
               CommandInvokerUtil.getCommandInvoker().execute(cmd);
               return cmd.getFindLionDetailResult();
           } catch (KKHException e) {
               FindLionDetailResult result = new FindLionDetailResult();
               result.toErrorInfo(e);
               return result;
           } catch (Throwable e) {
               ExceptionHandler.getInstance().handleException(e);
               return null;
           }

       }

        /**
        * 詳細（カードNO有無)の検索を行います。
        * @throws ServiceException
        */
       @WebMethod
       @WebResult(name = "FindLionCardNoGetResult")
       public FindLionCardNoGetResult findLionCardNoGetByCond(
               @WebParam(name = "condition")
               FindLionCardNoGetCondition condition) throws ServiceException {

           try {
               FindLionCardNoGetByCondCmd cmd = new FindLionCardNoGetByCondCmd();
               cmd.setFindLionCardNoGetCondition(condition);
               CommandInvokerUtil.getCommandInvoker().execute(cmd);
               return cmd.getFindLionCardNoGetResult();
           } catch (KKHException e) {
               FindLionCardNoGetResult result = new FindLionCardNoGetResult();
               result.toErrorInfo(e);
               return result;
           } catch (Throwable e) {
               ExceptionHandler.getInstance().handleException(e);
               return null;
           }

       }

       /**
        * カードNOごとの媒体区分検索処理を行う。
        * @throws ServiceException
        */
       @WebMethod
       @WebResult(name = "FindLionCardNoItrResult")
       public FindLionCardNoItrResult cardNoItrData(
               @WebParam(name = "condition")
               FindLionCardNoItrCondition condition) throws ServiceException {

           try {
               FindLionCardNoItrCmd cmd = new FindLionCardNoItrCmd();
               cmd.setFindLionCardNoItrCondition(condition);
               CommandInvokerUtil.getCommandInvoker().execute(cmd);
               return cmd.getFindLionCardNoItrResult();
           } catch (KKHException e) {
               FindLionCardNoItrResult result = new FindLionCardNoItrResult();
               result.toErrorInfo(e);
               return result;
           } catch (Throwable e) {
               ExceptionHandler.getInstance().handleException(e);
               return null;
           }

       }

       /**
        * 媒体種別ごとの媒体CD、名称検索処理を行う。
        * @throws ServiceException
        */
       @WebMethod
       @WebResult(name = "FindLionCodeItrResult")
       public FindLionCodeItrResult codeItrData(
               @WebParam(name = "condition")
               FindLionCodeItrCondition condition) throws ServiceException {

           try {
               FindLionCodeItrCmd cmd = new FindLionCodeItrCmd();
               cmd.setFindLionCodeItrCondition(condition);
               CommandInvokerUtil.getCommandInvoker().execute(cmd);
               return cmd.getFindLionCodeItrResult();
           } catch (KKHException e) {
               FindLionCodeItrResult result = new FindLionCodeItrResult();
               result.toErrorInfo(e);
               return result;
           } catch (Throwable e) {
               ExceptionHandler.getInstance().handleException(e);
               return null;
           }

       }

    /**
     * ライオンTVSpotデータの検索処理を行う。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "FindLionTVSpotResult")
    public FindLionTVSpotResult findLionTVSpotByCond(@WebParam(name = "condition") FindLionTVSpotCondition condition) throws ServiceException {

        try {
            FindLionTVSpotByCondCmd cmd = new FindLionTVSpotByCondCmd();
            cmd.setFindLionTVSpotCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getFindLionTVSpotResult();
        } catch (KKHException e) {
            FindLionTVSpotResult result = new FindLionTVSpotResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }
}