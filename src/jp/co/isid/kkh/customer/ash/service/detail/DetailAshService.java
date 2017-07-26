package jp.co.isid.kkh.customer.ash.service.detail;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import jp.co.isid.kkh.customer.ash.controller.detail.DetailDataAshMergeCmd;
import jp.co.isid.kkh.customer.ash.controller.detail.FindDetailDataAshByCondCmd;
import jp.co.isid.kkh.customer.ash.controller.detail.FindKeyKyokuBangumiCdCmd;
import jp.co.isid.kkh.customer.ash.controller.detail.GetFDSeqCmd;
import jp.co.isid.kkh.customer.ash.model.detail.DetailDataAshCondition;
import jp.co.isid.kkh.customer.ash.model.detail.DetailDataAshMergeResult;
import jp.co.isid.kkh.customer.ash.model.detail.DetailDataAshMergeVO;
import jp.co.isid.kkh.customer.ash.model.detail.DetailDataAshResult;
import jp.co.isid.kkh.customer.ash.model.detail.FindKeyKyokuBangumiCdCondition;
import jp.co.isid.kkh.customer.ash.model.detail.FindKeyKyokuBangumiCdResult;
import jp.co.isid.kkh.customer.ash.model.detail.GetFDSeqCondition;
import jp.co.isid.kkh.customer.ash.model.detail.GetFDSeqResult;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.service.CommandInvokerUtil;
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
 * ・アサヒビール系列局対応(2014/08/20 HLC Jang)<BR>
 * </P>
 * @author JSE K.Fukuda
 */
@WebService(serviceName = "detailAshService",
        targetNamespace = "http://detail.service.ash.customer.kkh.isid.co.jp/")
public class DetailAshService {

    /**
     * 広告費明細入力－広告費明細データの条件検索を行います。
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "DetailDataAshResult")
    public DetailDataAshResult findDetailDataAshByCond(
            @WebParam(name = "condition")
            DetailDataAshCondition condition) throws ServiceException {

        try {
            FindDetailDataAshByCondCmd cmd = new FindDetailDataAshByCondCmd();
            cmd.setDetailDataAshCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getDetailDataAshResult();
        } catch (KKHException e) {
            DetailDataAshResult result = new DetailDataAshResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * FD SEQの取得を行います。
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "GetFDSeqResult")
    public GetFDSeqResult getFDSeq(
            @WebParam(name = "condition")
            GetFDSeqCondition condition) throws ServiceException {

        try {
            GetFDSeqCmd cmd = new GetFDSeqCmd();
            cmd.setGetFDSeqCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getGetFDSeqResult();
        } catch (KKHException e) {
            GetFDSeqResult result = new GetFDSeqResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * 受注統合(明細統合)を行います。
     * @param vo
     * @return
     * @throws ServiceException
     */
    @WebMethod
    @WebResult(name = "DetailDataAshMergeResult")
    public DetailDataAshMergeResult mergeData(
            @WebParam(name = "DetailDataAshMergeVO")
            DetailDataAshMergeVO vo) throws ServiceException {

        try {
            DetailDataAshMergeCmd cmd = new DetailDataAshMergeCmd();
            cmd.setDetailDataAshMergeVO(vo);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getDetailDataAshMergeResult();
        } catch (KKHException e) {
            DetailDataAshMergeResult result = new DetailDataAshMergeResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
            return null;
        }
    }

    /**
     * キー局の番組コードを取得します。
     * @param FindKeyKyokuBangumiCdCondition
     * @return FindKeyKyokuBangumiCdResult
     * @throws ServiceException
     * @author HLC 張(Jang) 2014/08/20
     */
    @WebMethod
    @WebResult(name="DetailDataAshResult")
    public FindKeyKyokuBangumiCdResult findKeyKyokuBangumiCd(@WebParam(name="condition") FindKeyKyokuBangumiCdCondition condition) throws ServiceException {

        try {
            FindKeyKyokuBangumiCdCmd cmd = new FindKeyKyokuBangumiCdCmd();
            cmd.setFindKeyKyokuBangumiCdCondition(condition);
            CommandInvokerUtil.getCommandInvoker().execute(cmd);
            return cmd.getFindKeyKyokuBangumiCdResultResult();
        }
        catch (KKHException e) {
            FindKeyKyokuBangumiCdResult result = new FindKeyKyokuBangumiCdResult();
            result.toErrorInfo(e);
            return result;
        } catch (Throwable e) {
            ExceptionHandler.getInstance().handleException(e);
        return null;
        }
    }

}
