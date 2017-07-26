package jp.co.isid.kkh.customer.epson.controller.detail;

import java.util.List;

import jp.co.isid.kkh.customer.epson.model.detail.BulkJyutyuDataEpsonMergeResult;
import jp.co.isid.kkh.customer.epson.model.detail.BulkJyutyuDataEpsonMergeVO;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.kkh.model.detail.JyutyuDataMergeResult;
import jp.co.isid.kkh.model.detail.JyutyuDataMergeVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 一括統合コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/24 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class BulkJyutyuDataEpsonMergeCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 一括統合処理用VO */
    private BulkJyutyuDataEpsonMergeVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 一括統合処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        // 入力チェック
        checkInput();

        DetailManager manager = DetailManager.getInstance();
        List<JyutyuDataMergeVO> jyutyuDataMergeVOList = _vo.getJyutyuDataMergeVOList();
        // 受注統合データリストの件数分、繰り返す
        for (JyutyuDataMergeVO vo : jyutyuDataMergeVOList) {
            // 受注統合
            JyutyuDataMergeResult result = manager.mergeJyutyuData(vo);
        }

        getResult().set(RESULT_KEY, new BulkJyutyuDataEpsonMergeResult());
    }

    /**
     * 一括統合VOの設定
     *
     * @param vo 一括統合VO
     */
    public void setBulkJyutyuDataEpsonMergeVO(BulkJyutyuDataEpsonMergeVO vo) {
        _vo = vo;
    }

    /**
     * 実行結果を返します。
     *
     * @return 実行結果
     */
    public BulkJyutyuDataEpsonMergeResult getBulkJyutyuDataEpsonMergeResult() {
        return (BulkJyutyuDataEpsonMergeResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * パラメータ入力チェック
     *
     * @throws KKHException パラメータ指定エラーの場合
     */
    private void checkInput() throws KKHException {

        if (_vo.getJyutyuDataMergeVOList() == null) {
            throw new KKHException("パラメータ指定エラー", "HB-E0017");
        }
    }

}
