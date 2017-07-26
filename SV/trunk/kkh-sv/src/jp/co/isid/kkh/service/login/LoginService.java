package jp.co.isid.kkh.service.login;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.controller.login.AccountSecurityRoleGetCmd;
import jp.co.isid.kkh.controller.login.CustomerInfoGetCmd;
import jp.co.isid.kkh.controller.login.LoginCmd;
import jp.co.isid.kkh.controller.login.LoginInitInfoGetCmd;
import jp.co.isid.kkh.controller.login.OpenCustomerInfoGetCmd;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.login.AccountSecurityRoleCondition;
import jp.co.isid.kkh.model.login.AccountSecurityRoleResult;
import jp.co.isid.kkh.model.login.CustomerInfoCondition;
import jp.co.isid.kkh.model.login.CustomerInfoResult;
import jp.co.isid.kkh.model.login.LoginCondition;
import jp.co.isid.kkh.model.login.LoginInitInfoCondition;
import jp.co.isid.kkh.model.login.LoginInitInfoResult;
import jp.co.isid.kkh.model.login.LoginResult;
import jp.co.isid.kkh.model.login.OpenCustomerInfoCondition;
import jp.co.isid.kkh.model.login.OpenCustomerInfoResult;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.util.KKHLogUtility;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>
 * ログインサービス
 * </P>
 * <P>
 * ログインサービスクラスです。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
@WebService(serviceName = "loginService", targetNamespace = "http://login.service.kkh.isid.co.jp/")
public class LoginService {

    /**
     * 業務会計セキュリティロールを取得します。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "accountSecurityRoleResult")
    public AccountSecurityRoleResult getAccountSecurityRole(@WebParam(name = "condition") AccountSecurityRoleCondition condition)
            throws ServiceException {

        try {
            AccountSecurityRoleGetCmd cmd = new AccountSecurityRoleGetCmd();
            cmd.setAccountSecurityRoleCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getAccountSecurityRoleResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
            AccountSecurityRoleResult result = new AccountSecurityRoleResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }

    }

    /**
     * ログイン初期情報を取得します。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "loginInitInfoResult")
    public LoginInitInfoResult getLoginInitInfo(@WebParam(name = "condition") LoginInitInfoCondition condition)
            throws ServiceException {

        try {
            LoginInitInfoGetCmd cmd = new LoginInitInfoGetCmd();
            cmd.setPersonalInfoCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getPersonalInfoResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
            LoginInitInfoResult result = new LoginInitInfoResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }

    }

    /**
     * 得意先情報を取得します。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "customerInfoResult")
    public CustomerInfoResult getCustomerInfo(@WebParam(name = "condition") CustomerInfoCondition condition)
            throws ServiceException {

        try {
            CustomerInfoGetCmd cmd = new CustomerInfoGetCmd();
            cmd.setCustomerInfoCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getCustomerInfoResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
            CustomerInfoResult result = new CustomerInfoResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }

    }

    /**
     * ログイン処理を行います。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "loginResult")
    public LoginResult login(@WebParam(name = "condition") LoginCondition condition)
            throws ServiceException {

        try {
            LoginCmd cmd = new LoginCmd();
            cmd.setLoginCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getLoginResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
            LoginResult result = new LoginResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }

    }

    /**
     * 開放得意先情報を取得します。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "openCustomerInfoResult")
    public OpenCustomerInfoResult getOpenCustomerInfo(@WebParam(name = "condition") OpenCustomerInfoCondition condition)
            throws ServiceException {

        try {
            OpenCustomerInfoGetCmd cmd = new OpenCustomerInfoGetCmd();
            cmd.setOpenCustomerInfoCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getOpenCustomerInfoResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
            OpenCustomerInfoResult result = new OpenCustomerInfoResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }

    }

}
