package jp.co.isid.kkh.service.detail;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.controller.detail.BulkDataRegisterCmd;
import jp.co.isid.kkh.controller.detail.DetailDataBulkUpdateCmd;
import jp.co.isid.kkh.controller.detail.DetailUpdateDataCmd;
import jp.co.isid.kkh.controller.detail.FindDetailDataByCondCmd;
import jp.co.isid.kkh.controller.detail.FindJyutyuDataByCondCmd;
import jp.co.isid.kkh.controller.detail.FindJyutyuRirekiDataByCondCmd;
import jp.co.isid.kkh.controller.detail.JyutNoTouInsCmd;
import jp.co.isid.kkh.controller.detail.JyutNoTouUpdateCmd;
import jp.co.isid.kkh.controller.detail.JyutyuDataDeleteCmd;
import jp.co.isid.kkh.controller.detail.JyutyuDataMergeCancelCmd;
import jp.co.isid.kkh.controller.detail.JyutyuDataMergeCmd;
import jp.co.isid.kkh.controller.detail.JyutyuDataRegisterCmd;
import jp.co.isid.kkh.controller.detail.SeikyuYymmChangeCmd;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.BulkDataRegisterResult;
import jp.co.isid.kkh.model.detail.BulkDataRegisterVO;
import jp.co.isid.kkh.model.detail.DetailDataBulkUpdateResult;
import jp.co.isid.kkh.model.detail.DetailDataBulkUpdateVO;
import jp.co.isid.kkh.model.detail.DetailDataCondition;
import jp.co.isid.kkh.model.detail.DetailDataResult;
import jp.co.isid.kkh.model.detail.DetailUpdateDataResult;
import jp.co.isid.kkh.model.detail.DetailUpdateDataVO;
import jp.co.isid.kkh.model.detail.JyutNoTouInsResult;
import jp.co.isid.kkh.model.detail.JyutNoTouInsVO;
import jp.co.isid.kkh.model.detail.JyutNoTouUpdateResult;
import jp.co.isid.kkh.model.detail.JyutNoTouUpdateVO;
import jp.co.isid.kkh.model.detail.JyutyuDataCondResult;
import jp.co.isid.kkh.model.detail.JyutyuDataCondition;
import jp.co.isid.kkh.model.detail.JyutyuDataDeleteResult;
import jp.co.isid.kkh.model.detail.JyutyuDataDeleteVO;
import jp.co.isid.kkh.model.detail.JyutyuDataMergeCancelResult;
import jp.co.isid.kkh.model.detail.JyutyuDataMergeCancelVO;
import jp.co.isid.kkh.model.detail.JyutyuDataMergeResult;
import jp.co.isid.kkh.model.detail.JyutyuDataMergeVO;
import jp.co.isid.kkh.model.detail.JyutyuDataRegisterResult;
import jp.co.isid.kkh.model.detail.JyutyuDataRegisterVO;
import jp.co.isid.kkh.model.detail.SeikyuYymmChangeResult;
import jp.co.isid.kkh.model.detail.SeikyuYymmChangeVO;
import jp.co.isid.kkh.model.detail.Thb8DownRCondition;
import jp.co.isid.kkh.model.detail.Thb8DownRResult;
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
 * ・新規作成(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author JSE K.Fukuda
 */
@WebService(serviceName = "detailService",
        targetNamespace = "http://detail.service.kkh.isid.co.jp/")
public class DetailService {

	/**
	 * 受注データの条件検索を行います。
	 * @throws ServiceException
	 */
	@WebMethod
	@WebResult(name = "FindJyutyuDataByCondResult")
	public JyutyuDataCondResult findJyutyuDataByCond(
	        @WebParam(name = "condition")
	        JyutyuDataCondition condition) throws ServiceException {

	    try {
	    	FindJyutyuDataByCondCmd cmd = new FindJyutyuDataByCondCmd();
	        cmd.setFindJyutyuDataCondition(condition);
	        CommandInvokerUtil.getCommandInvoker().execute(cmd);
	        return cmd.getJyutyuDataResult();
	    } catch (KKHException e) {
	        KKHLogUtility.outLog(e);
	    	JyutyuDataCondResult result = new JyutyuDataCondResult();
	        result.toErrorInfo(e);
	        return result;
	    } catch (Throwable e) {
	        ExceptionHandler.getInstance().handleException(e);
	        return null;
	    }

	}

    /**
     * 広告費明細入力－表示データの更新・登録を行います。
     * @param vo
     * @return
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "DetailUpdateDataResult")
    public DetailUpdateDataResult updateDisplayData(
            @WebParam(name = "DetailUpdateDataVO")
            DetailUpdateDataVO vo) throws ServiceException {

        try {
        	DetailUpdateDataCmd cmd = new DetailUpdateDataCmd();
            cmd.setDetailUpdateDataVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getUpdateDisplayDataResult();
        } catch (KKHException e) {
	        KKHLogUtility.outLog(e);
        	DetailUpdateDataResult result = new DetailUpdateDataResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

	/**
	 * 広告費明細入力－広告費明細データの条件検索を行います。
	 * @throws ServiceException
	 */
	@WebMethod
	@WebResult(name = "DetailDataResult")
	public DetailDataResult findDetailDataByCond(
	        @WebParam(name = "condition")
	        DetailDataCondition condition) throws ServiceException {

	    try {
	    	FindDetailDataByCondCmd cmd = new FindDetailDataByCondCmd();
	        cmd.setDetailDataCondition(condition);
	        CommandInvokerUtil.getCommandInvoker().execute(cmd);
	        return cmd.getDetailDataResult();
	    } catch (KKHException e) {
	        KKHLogUtility.outLog(e);
	    	DetailDataResult result = new DetailDataResult();
	        result.toErrorInfo(e);
	        return result;
	    } catch (Throwable e) {
	        ExceptionHandler.getInstance().handleException(e);
	        return null;
	    }

	}

    /**
     * 一括登録を行います。
     *
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "bulkDataRegisterResult")
    public BulkDataRegisterResult registerBulkData(@WebParam(name = "bulkDataRegisterVO") BulkDataRegisterVO bulkDataRegisterVO)
            throws ServiceException {

        try {
            BulkDataRegisterCmd cmd = new BulkDataRegisterCmd();
            cmd.setBulkDataRegisterVO(bulkDataRegisterVO);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getBulkDataRegisterResult();
        } catch (KKHException e) {
	        KKHLogUtility.outLog(e);
            BulkDataRegisterResult result = new BulkDataRegisterResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * 広告費明細入力－受注削除を行います。
     * @param vo
     * @return
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "JyutyuDataDeleteResult")
    public JyutyuDataDeleteResult deleteJyutyuData(
            @WebParam(name = "JyutyuDataDeleteVO")
            JyutyuDataDeleteVO vo) throws ServiceException {

        try {
        	JyutyuDataDeleteCmd cmd = new JyutyuDataDeleteCmd();
            cmd.setJyutyuDataDeleteVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getJyutyuDataDeleteResult();
        } catch (KKHException e) {
	        KKHLogUtility.outLog(e);
        	JyutyuDataDeleteResult result = new JyutyuDataDeleteResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * 請求年月変更を行います。
     * @param vo
     * @return
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "SeikyuYymmChangeResult")
    public SeikyuYymmChangeResult changeSeikyuYymm(
            @WebParam(name = "SeikyuYymmChangeVO")
            SeikyuYymmChangeVO vo) throws ServiceException {

        try {
        	SeikyuYymmChangeCmd cmd = new SeikyuYymmChangeCmd();
            cmd.setSeikyuYymmChangeVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getSeikyuYymmChangeResult();
        } catch (KKHException e) {
	        KKHLogUtility.outLog(e);
        	SeikyuYymmChangeResult result = new SeikyuYymmChangeResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * 新規登録を行います。
     * @param vo
     * @return
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "JyutyuDataRegisterResult")
    public JyutyuDataRegisterResult registerJyutyuData(
            @WebParam(name = "JyutyuDataRegisterVO")
            JyutyuDataRegisterVO vo) throws ServiceException {

        try {
        	JyutyuDataRegisterCmd cmd = new JyutyuDataRegisterCmd();
            cmd.setJyutyuDataRegisterVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getJyutyuDataRegisterResult();
        } catch (KKHException e) {
	        KKHLogUtility.outLog(e);
        	JyutyuDataRegisterResult result = new JyutyuDataRegisterResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * 受注統合を行います。
     * @param vo
     * @return
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "JyutyuDataMergeResult")
    public JyutyuDataMergeResult mergeJyutyuData(
            @WebParam(name = "JyutyuDataMergeVO")
            JyutyuDataMergeVO vo) throws ServiceException {

        try {
        	JyutyuDataMergeCmd cmd = new JyutyuDataMergeCmd();
            cmd.setJyutyuDataMergeVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getJyutyuDataMergeResult();
        } catch (KKHException e) {
	        KKHLogUtility.outLog(e);
        	JyutyuDataMergeResult result = new JyutyuDataMergeResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * 受注解除を行います。
     * @param vo
     * @return
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "JyutyuDataMergeCancelResult")
    public JyutyuDataMergeCancelResult mergeCancelJyutyuData(
            @WebParam(name = "JyutyuDataMergeCancelVO")
            JyutyuDataMergeCancelVO vo) throws ServiceException {

        try {
        	JyutyuDataMergeCancelCmd cmd = new JyutyuDataMergeCancelCmd();
            cmd.setJyutyuDataMergeCancelVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getJyutyuDataMergeCancelResult();
        } catch (KKHException e) {
	        KKHLogUtility.outLog(e);
        	JyutyuDataMergeCancelResult result = new JyutyuDataMergeCancelResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * 受注Noの統合を行う。
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "JyutNoTouUpdateResult")
    public JyutNoTouUpdateResult JyutNoTouGou(
            @WebParam(name = "condition")
            JyutNoTouUpdateVO vo) throws ServiceException {

        try {
        	JyutNoTouUpdateCmd cmd = new JyutNoTouUpdateCmd();
            cmd.setJyutNoTouUpdateVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getJyutNoTouUpdateResult();
        } catch (KKHException e) {
	        KKHLogUtility.outLog(e);
        	JyutNoTouUpdateResult result = new JyutNoTouUpdateResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }

    }
    /**
     * 受注No統合の登録を行う。
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "JyutNoTouInsResult")
    public JyutNoTouInsResult JyutNoTouGouIns(
            @WebParam(name = "condition")
            JyutNoTouInsVO vo) throws ServiceException {

        try {
        	JyutNoTouInsCmd cmd = new JyutNoTouInsCmd();
            cmd.setJyutNoTouUpdateVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getJyutNoTouInsdateResult();
        } catch (KKHException e) {
	        KKHLogUtility.outLog(e);
        	JyutNoTouInsResult result = new JyutNoTouInsResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }

    }

	/**
	 * 受注ダウンロード履歴データの条件検索を行います。
	 * @throws ServiceException
	 */
	@WebMethod
	@WebResult(name = "Thb8DownRResult")
	public Thb8DownRResult findJyutyuRirekiDataByCond(
	        @WebParam(name = "condition")
	        Thb8DownRCondition condition) throws ServiceException {

	    try {
	    	FindJyutyuRirekiDataByCondCmd cmd = new FindJyutyuRirekiDataByCondCmd();
	        cmd.setThb8DownRCondition(condition);
	        CommandInvokerUtil.getCommandInvoker().execute(cmd);
	        return cmd.getThb8DownRResult();
	    } catch (KKHException e) {
	        KKHLogUtility.outLog(e);
	    	Thb8DownRResult result = new Thb8DownRResult();
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
	@WebResult(name = "DetailDataBulkUpdateResult")
	public DetailDataBulkUpdateResult bulkUpdateDetailData(
	        @WebParam(name = "condition")
	        DetailDataBulkUpdateVO condition) throws ServiceException {

	    try {
	    	DetailDataBulkUpdateCmd cmd = new DetailDataBulkUpdateCmd();
	        cmd.setDetailDataBulkUpdateVO(condition);
	        CommandInvokerUtil.getCommandInvoker().execute(cmd);
	        return cmd.getDetailDataBulkUpdateResult();
	    } catch (KKHException e) {
	        KKHLogUtility.outLog(e);
	    	DetailDataBulkUpdateResult result = new DetailDataBulkUpdateResult();
	        result.toErrorInfo(e);
	        return result;
	    } catch (Throwable e) {
	        ExceptionHandler.getInstance().handleException(e);
	        return null;
	    }

	}
}
