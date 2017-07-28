package jp.co.isid.kkh.customer.mac.controller.report;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.Thb1DownDAO;
import jp.co.isid.kkh.model.detail.Thb1DownDAOFactory;
import jp.co.isid.kkh.model.detail.Thb1DownVO;
import jp.co.isid.kkh.model.master.MasterDataCondition;
import jp.co.isid.kkh.model.master.MasterManager;
import jp.co.isid.kkh.model.master.MasterRegisterResult;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacPurDataVO;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacPurManager;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacPurResult;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacPurVO;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacPurCondition;
import jp.co.isid.kkh.service.base.ErrorInfo;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 購入伝票更新コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/18 IP Shimizu)<BR>
 * </P>
 *
 * @author IP Shimizu
 */
public class UpdateReportMacPurCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** マスタデータ登録処理用VO */
    private UpdateReportMacPurCondition _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * マスタデータ登録処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        MasterManager datemanager = MasterManager.getInstance();
        UpdateReportMacPurManager manager = UpdateReportMacPurManager.getInstance();

        // 入力チェック
        checkInput();

        //更新日時最大値の取得
        Date maxupdate = _vo.getMaxUpDate();

        // マスタデータ取得を設定
        MasterDataCondition masterDataCondition = new MasterDataCondition();
        setMasterDataCondition(masterDataCondition, _vo);


     // マスタデータの更新タイムスタンプ（最大値）を取得
        Date newTimStmp = datemanager.findMasterUpdTimStmpMaxByCondition(masterDataCondition);

        // 現在のタイムスタンプの最大値を取得
        Date currentTimStmp = maxupdate;

        if(newTimStmp != null)
        {
            // 排他チェック
            ErrorInfo errorInfo = checkExclusion(newTimStmp, currentTimStmp);
            if (errorInfo != null) {
                MasterRegisterResult result = new MasterRegisterResult();
                result.setErrorInfo(errorInfo);
                getResult().set(RESULT_KEY, result);
                return;
            }
        }

        // マスタデータの編集
        List<UpdateReportMacPurDataVO> updateVOList = new ArrayList<UpdateReportMacPurDataVO>();
        updateVOList = editDataUpdateVO(_vo);
        // マスタデータの登録
        manager.updateReportMacPurchase(updateVOList);
        manager.updateReportMacSysDenNum(_vo);

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();
        //受注タイムスタンプの更新
        for(UpdateReportMacPurDataVO row : updateVOList){
            Thb1DownVO vo1down = new Thb1DownVO();
            vo1down.setHb1EgCd(row.getEgCd());
            vo1down.setHb1TksKgyCd(row.getTksKgyCd());
            vo1down.setHb1TksBmnSeqNo(row.getTksBmnSeqNo());
            vo1down.setHb1TksTntSeqNo(row.getTksTntSeqNo());
            vo1down.setHb1Yymm(row.getYymm());
            vo1down.setHb1JyutNo(row.getJyutNo());
            vo1down.setHb1JyMeiNo(row.getJyMeiNo());
            vo1down.setHb1UrMeiNo(row.getUrMeiNo());
            dao.updateSysdateTo1down(vo1down);
        }

        // 正常終了
        getResult().set(RESULT_KEY, new UpdateReportMacPurResult());
    }

    /**
     * 実行結果を返します。
     *
     * @return 実行結果
     */
    public UpdateReportMacPurResult getUpdateReportMacPurResult() {
        return (UpdateReportMacPurResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * マスタデータ取得
     *
     * @param cond マスタデータ取得
     */
    private void setMasterDataCondition(MasterDataCondition cond, UpdateReportMacPurCondition vo) {

        cond.setEgCd(vo.getEgCd());
        cond.setTksKgyCd(vo.getTksKgyCd());
        cond.setTksBmnSeqNo(vo.getTksBmnSeqNo());
        cond.setTksTntSeqNo(vo.getTksTntSeqNo());
        cond.setSybt("201");
    }

    /**
     * 更新条件を設定します。
     *
     * @param vo UpdateReportMacPurVO 更新条件
     */
    public void setUpdateReportMacVO(UpdateReportMacPurCondition vo) {
        _vo = vo;
    }

    /**
     * パラメータ入力チェック
     *
     * @throws KKHException パラメータ指定エラーの場合
     */
    private void checkInput() throws KKHException {

        //パラメータの必須チェック
        if (StringUtil.isBlank(_vo.getEsqId())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getAplId())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getEgCd())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getTksKgyCd())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getTksBmnSeqNo())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getTksTntSeqNo())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getDenNum())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getHostDate())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        try {
            if (_vo.getReportData() == null && _vo.getMaxUpDate() == DateFormat.getDateInstance().parse("1000/01/01 01:01:01")) {
                throw new KKHException("パラメータ指定エラー", "BD-E0001");
            }
        } catch (ParseException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }

    /**
     * 排他チェック
     *
     * @param newTimStmp 更新タイムスタンプ（最新）
     * @param currentTimStmp 更新タイムスタンプ（現在）
     * @return 正常：null、チェックエラー：エラー情報
     */
    private ErrorInfo checkExclusion(Date newTimStmp, Date currentTimStmp) {

        // 対象のタイムスタンプがどちらも存在しない場合
        if (newTimStmp == null && currentTimStmp == null) {
            return null;
        }
        // 対象のタイムスタンプの一方が存在しない場合
        if (newTimStmp == null || currentTimStmp == null) {
            return createErrorInfo("排他エラー", "BD-W0001");
        }
        // 更新タイムスタンプ（最新）が更新タイムスタンプ（現在）より大きい場合
        if (newTimStmp.compareTo(currentTimStmp) > 0) {
            return createErrorInfo("排他エラー", "BD-W0001");
        }
        return null;
    }

    /**
     * エラー情報生成
     *
     * @param message メッセージ
     * @param errorID エラーコード
     * @return エラー情報
     */
    private ErrorInfo createErrorInfo(String message, String errorID) {

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setError(true);
        errorInfo.setErrorCode(errorID);
        List<String> list = new ArrayList<String>();
        list.add(message);
        errorInfo.setNote(list);
        return errorInfo;
    }


    /**
     * データの編集
     *
     *@return データVO（UPDATE用）のリスト
     */
    private List<UpdateReportMacPurDataVO> editDataUpdateVO(UpdateReportMacPurCondition cond) {

        List<UpdateReportMacPurDataVO> updateVOList = new ArrayList<UpdateReportMacPurDataVO>();

        // マスタレコード数分ループ
        for (UpdateReportMacPurVO updateDataVO : cond.getReportData()) {
            UpdateReportMacPurDataVO updateVO = new UpdateReportMacPurDataVO();
            // 共通項目
            updateVO.setUpdApl(cond.getAplId());
            updateVO.setUpdTnt(cond.getEsqId());
            updateVO.setEgCd(cond.getEgCd());
            updateVO.setTksKgyCd(cond.getTksKgyCd());
            updateVO.setTksBmnSeqNo(cond.getTksBmnSeqNo());
            updateVO.setTksTntSeqNo(cond.getTksTntSeqNo());
            updateVO.setDate1(cond.getHostDate());
            updateVO.setYymm(updateDataVO.getYymm());
            updateVO.setJyutNo(updateDataVO.getJyutNo());
            updateVO.setJyMeiNo(updateDataVO.getJyMeiNo());
            updateVO.setUrMeiNo(updateDataVO.getUrMeiNo());
            updateVO.setRenbn(updateDataVO.getRenbn());
            updateVO.setSonota1(updateDataVO.getSonota1());
            updateVO.setKbn1(updateDataVO.getKbn1());
            updateVOList.add(updateVO);
        }

        return updateVOList;
    }

}
