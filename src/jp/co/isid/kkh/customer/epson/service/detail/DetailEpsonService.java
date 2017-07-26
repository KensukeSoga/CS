package jp.co.isid.kkh.customer.epson.service.detail;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.customer.epson.controller.detail.BulkJyutyuDataEpsonMergeCmd;
import jp.co.isid.kkh.customer.epson.controller.detail.DetailDataEpsonBulkUpdateCmd;
import jp.co.isid.kkh.customer.epson.controller.detail.FindDetailDataEpsonByCondCmd;
import jp.co.isid.kkh.customer.epson.controller.detail.FindSeikyuDataEpsonByCondCmd;
import jp.co.isid.kkh.customer.epson.model.detail.BulkJyutyuDataEpsonMergeResult;
import jp.co.isid.kkh.customer.epson.model.detail.BulkJyutyuDataEpsonMergeVO;
import jp.co.isid.kkh.customer.epson.model.detail.DetailDataEpsonBulkUpdateResult;
import jp.co.isid.kkh.customer.epson.model.detail.DetailDataEpsonBulkUpdateVO;
import jp.co.isid.kkh.customer.epson.model.detail.DetailDataEpsonCondition;
import jp.co.isid.kkh.customer.epson.model.detail.DetailDataEpsonResult;
import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataEpsonResult;
import jp.co.isid.kkh.customer.epson.model.detail.SeikyuDataCondition;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
import jp.co.isid.kkh.util.KKHLogUtility;
import jp.co.isid.soa.framework.service.exception.ExceptionHandler;
import jp.co.isid.soa.framework.service.exception.ServiceException;

/**
 *
 * <P>広告費明細のサービス</P>
 * <P>
 * 広告費明細のサービスクラスです。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/5 IP.Shimizu)<BR>
 * </P>
 * @author IP.Shimizu
 */
@WebService(serviceName = "detailEpsonService",
        targetNamespace = "http://detail.service.kkh.isid.co.jp/")
public class DetailEpsonService {

	/**
	 * 広告費明細入力－広告費明細データの条件検索を行います。
	 * @throws ServiceException
	 */
	@WebMethod
	@WebResult(name = "DetailDataEpsonResult")
	public DetailDataEpsonResult findDetailDataEpsonByCond(
	        @WebParam(name = "condition")
	        DetailDataEpsonCondition condition) throws ServiceException {

	    try {
	    	FindDetailDataEpsonByCondCmd cmd = new FindDetailDataEpsonByCondCmd();
	        cmd.setDetailDataEpsonCondition(condition);
	        CommandInvokerUtil.getCommandInvoker().execute(cmd);
	        return cmd.getDetailDataEpsonResult();
	    } catch (KKHException e) {
	    	KKHLogUtility.outLog(e);
	    	DetailDataEpsonResult result = new DetailDataEpsonResult();
	        result.toErrorInfo(e);
	        return result;
	    } catch (Throwable e) {
	        ExceptionHandler.getInstance().handleException(e);
	        return null;
	    }

	}

	/**
	 * 広告費明細データの複数一括更新を行います。
	 * @throws ServiceException
	 */
	@WebMethod
	@WebResult(name = "DetailDataEpsonBulkUpdateResult")
	public DetailDataEpsonBulkUpdateResult bulkUpdateDetailDataEpson(
	        @WebParam(name = "condition")
	        DetailDataEpsonBulkUpdateVO condition) throws ServiceException {

	    try {
	    	DetailDataEpsonBulkUpdateCmd cmd = new DetailDataEpsonBulkUpdateCmd();
	        cmd.setDetailDataEpsonBulkUpdateVO(condition);
	        CommandInvokerUtil.getCommandInvoker().execute(cmd);
	        return cmd.getDetailDataEpsonBulkUpdateResult();
	    } catch (KKHException e) {
	    	KKHLogUtility.outLog(e);
	    	DetailDataEpsonBulkUpdateResult result = new DetailDataEpsonBulkUpdateResult();
	        result.toErrorInfo(e);
	        return result;
	    } catch (Throwable e) {
	        ExceptionHandler.getInstance().handleException(e);
	        return null;
	    }

	}

    /**
     * 一括統合を行います。
     * @param vo
     * @return
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "bulkJyutyuDataEpsonMergeResult")
    public BulkJyutyuDataEpsonMergeResult mergeBulkJyutyuDataEpson(
            @WebParam(name = "bulkJyutyuDataEpsonMergeVO")
            BulkJyutyuDataEpsonMergeVO vo) throws ServiceException {

        try {
            BulkJyutyuDataEpsonMergeCmd cmd = new BulkJyutyuDataEpsonMergeCmd();
            cmd.setBulkJyutyuDataEpsonMergeVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getBulkJyutyuDataEpsonMergeResult();
        } catch (KKHException e) {
        	KKHLogUtility.outLog(e);
            BulkJyutyuDataEpsonMergeResult result = new BulkJyutyuDataEpsonMergeResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

	/**
	 * 請求回収データの条件検索を行います。
	 * @throws ServiceException
	 */
	@WebMethod
	@WebResult(name = "SeikyuDataEpsonResult")
	public SeikyuDataEpsonResult findSeikyuDataEpsonByCond(
	        @WebParam(name = "condition")
	        SeikyuDataCondition condition) throws ServiceException {

	    try {
	    	FindSeikyuDataEpsonByCondCmd cmd = new FindSeikyuDataEpsonByCondCmd();
	        cmd.setSeikyuDataCondition(condition);
	        CommandInvokerUtil.getCommandInvoker().execute(cmd);
	        return cmd.getSeikyuDataEpsonResult();
	    } catch (KKHException e) {
	    	KKHLogUtility.outLog(e);
	    	SeikyuDataEpsonResult result = new SeikyuDataEpsonResult();
	        result.toErrorInfo(e);
	        return result;
	    } catch (Throwable e) {
	        ExceptionHandler.getInstance().handleException(e);
	        return null;
	    }

	}


}
