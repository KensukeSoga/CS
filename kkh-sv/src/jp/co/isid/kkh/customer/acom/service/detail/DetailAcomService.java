package jp.co.isid.kkh.customer.acom.service.detail;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.customer.acom.controller.detail.FindHatyuConfirmCmd;
import jp.co.isid.kkh.customer.acom.controller.detail.FindHatyuNumBycondCmd;
import jp.co.isid.kkh.customer.acom.controller.detail.FindMeisaiByCondCmd;
import jp.co.isid.kkh.customer.acom.controller.detail.FindSyouhinNameCmd;
import jp.co.isid.kkh.customer.acom.controller.detail.FindThb5HikBycondCmd;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.detail.FindHatyuConfirmResult;
import jp.co.isid.kkh.customer.acom.model.detail.FindMeisaiDataCondition;
import jp.co.isid.kkh.customer.acom.model.detail.FindMeisaiDataResult;
import jp.co.isid.kkh.customer.acom.model.detail.FindHatyuNumByCondVO;
import jp.co.isid.kkh.customer.acom.model.detail.FindHatyuNumBycondResult;
import jp.co.isid.kkh.customer.acom.model.detail.FindSyohinNameGetCond;
import jp.co.isid.kkh.customer.acom.model.detail.FindThb5HikResult;
import jp.co.isid.kkh.customer.acom.model.detail.Thb5HikVO;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.util.KKHLogUtility;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>
 * 発注データ取込のサービス
 * </P>
 * <P>
 * 発注データ取込テーブルマスタのサービスクラスです。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/08 HLC J.Morobayashi)<BR>
 * </P>
 *
 * @author HLC J.Morobayash i
 */
@WebService(serviceName = "detailAcomService", targetNamespace = "http://datail.service.acom.customer.kkh.isid.co.jp/")
public class DetailAcomService {

    /**
     * 発注番号取得を行う。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "FindHatyuNumBycondResult")
    public FindHatyuNumBycondResult findHatyuNumget(
            @WebParam(name = "FindHatyuNumByCondVO") FindHatyuNumByCondVO vo)
            throws ServiceException {

        try {
            FindHatyuNumBycondCmd cmd = new FindHatyuNumBycondCmd();
            cmd.setFindHatyuNumBycondVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getFindHatyuNumBycondResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
            FindHatyuNumBycondResult result = new FindHatyuNumBycondResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * 発注データの取得を行う。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "FindThb5HikResult")
    public FindThb5HikResult findHatyuget(
            @WebParam(name = "Thb5HikVO") Thb5HikVO vo) throws ServiceException {

        try {
            FindThb5HikBycondCmd cmd = new FindThb5HikBycondCmd();
            cmd.setFind8HikBycondVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getFindThb5HikResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
            FindThb5HikResult result = new FindThb5HikResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * 明細検索(受注内容を検索条件に入れない)
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "DetailDataResult")
    public FindMeisaiDataResult findMeisaiDataByCond(
            @WebParam(name = "condition")
            FindMeisaiDataCondition condition) throws ServiceException {

        try {
            FindMeisaiByCondCmd cmd = new FindMeisaiByCondCmd();
            cmd.setDetailDataCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getDetailDataResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
            FindMeisaiDataResult result = new FindMeisaiDataResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * 商品名称の取得
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "String")
    public String findsyouhinName(
            @WebParam(name = "condition")
            FindSyohinNameGetCond condition) throws ServiceException {

        try {
        	FindSyouhinNameCmd cmd = new FindSyouhinNameCmd();
            cmd.setFindSyouhinName(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getFindSyouhinNameResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
            String error = "error";
            return error;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }
    /**
     * 発注番号の確認
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "FindHatyuConfirmResult")
    public FindHatyuConfirmResult findHatyuConfirm(
            @WebParam(name = "FindHatyuNumByCondVO")
            FindHatyuNumByCondVO condition) throws ServiceException {

        try {
        	FindHatyuConfirmCmd cmd = new FindHatyuConfirmCmd();
            cmd.setFindHatyuNumBycondVO(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getFindHatyuNumBycondResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
        	FindHatyuConfirmResult result = new FindHatyuConfirmResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }
}
