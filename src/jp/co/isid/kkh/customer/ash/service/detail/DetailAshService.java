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
 * <P>�L����ׂ̃T�[�r�X</P>
 * <P>
 * �L����ׂ̃T�[�r�X�N���X�ł��B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE K.Fukuda)<BR>
 * �E�A�T�q�r�[���n��ǑΉ�(2014/08/20 HLC Jang)<BR>
 * </P>
 * @author JSE K.Fukuda
 */
@WebService(serviceName = "detailAshService",
        targetNamespace = "http://detail.service.ash.customer.kkh.isid.co.jp/")
public class DetailAshService {

    /**
     * �L����ד��́|�L����׃f�[�^�̏����������s���܂��B
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
     * FD SEQ�̎擾���s���܂��B
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
     * �󒍓���(���ד���)���s���܂��B
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
     * �L�[�ǂ̔ԑg�R�[�h���擾���܂��B
     * @param FindKeyKyokuBangumiCdCondition
     * @return FindKeyKyokuBangumiCdResult
     * @throws ServiceException
     * @author HLC ��(Jang) 2014/08/20
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
