package jp.co.isid.kkh.customer.mac.controller.report;

import java.util.ArrayList;
import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.Thb1DownDAO;
import jp.co.isid.kkh.model.detail.Thb1DownDAOFactory;
import jp.co.isid.kkh.model.detail.Thb1DownVO;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacReqDataVO;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacReqManager;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacReqResult;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacReqVO;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacReqCondition;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 請求書更新コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/18 IP Shimizu)<BR>
 * </P>
 *
 * @author IP Shimizu
 */
public class UpdateReportMacReqCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** マスタデータ登録処理用VO */
    private UpdateReportMacReqCondition _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * マスタデータ登録処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        UpdateReportMacReqManager manager = UpdateReportMacReqManager.getInstance();

        // 入力チェック
        checkInput();

        // マスタデータの編集
        List<UpdateReportMacReqDataVO> updateVOList = new ArrayList<UpdateReportMacReqDataVO>();
        updateVOList = editDataUpdateVO(_vo);
        // マスタデータの登録
        manager.updateReportMacRequest(updateVOList);

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();
        //受注タイムスタンプの更新
        for(UpdateReportMacReqDataVO row : updateVOList){
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
        getResult().set(RESULT_KEY, new UpdateReportMacReqResult());
    }

    /**
     * 実行結果を返します。
     *
     * @return 実行結果
     */
    public UpdateReportMacReqResult getUpdateReportMacReqResult() {
        return (UpdateReportMacReqResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * 更新条件を設定します。
     *
     * @param vo UpdateReportMacPurVO 更新条件
     */
    public void setUpdateReportMacVO(UpdateReportMacReqCondition vo) {
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
        if (_vo.getReportData() == null) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(_vo.getHostDate())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
    }

    /**
     * データの編集
     *
     *@return データVO（UPDATE用）のリスト
     */
    private List<UpdateReportMacReqDataVO> editDataUpdateVO(UpdateReportMacReqCondition cond) {

        List<UpdateReportMacReqDataVO> updateVOList = new ArrayList<UpdateReportMacReqDataVO>();

        // マスタレコード数分ループ
        for (UpdateReportMacReqVO updateDataVO : cond.getReportData()) {
            UpdateReportMacReqDataVO updateVO = new UpdateReportMacReqDataVO();
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
            updateVOList.add(updateVO);
        }

        return updateVOList;
    }

}
