package jp.co.isid.kkh.customer.epson.controller.detail;

import jp.co.isid.kkh.customer.epson.model.detail.DetailDataEpsonBulkUpdateResult;
import jp.co.isid.kkh.customer.epson.model.detail.DetailDataEpsonBulkUpdateVO;
import jp.co.isid.kkh.customer.epson.model.detail.DetailEpsonManager;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 広告費明細－表示データ更新コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/13)<BR>
 * </P>
 *
 * @author IP Shimizu
 */
public class DetailDataEpsonBulkUpdateCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 広告費明細表示データ更新処理用VO */
    private DetailDataEpsonBulkUpdateVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 広告費明細表示データ更新処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        DetailEpsonManager manager = DetailEpsonManager.getInstance();

        // 広告費明細データの登録
        DetailDataEpsonBulkUpdateResult result = manager.bulkUpdateDetailDataEpson(_vo);
        // 正常終了
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * 広告費明細データ更新(一括)VOを設定します。
     *
     * @param vo DetailDataBulkUpdateVO 広告費明細データ更新(一括)VO
     */
    public void setDetailDataEpsonBulkUpdateVO(DetailDataEpsonBulkUpdateVO vo) {
        _vo = vo;
    }

    /**
     * 登録後結果を返します。
     *
     * @return UpdateDisplayDataResult 登録後のプランデータ
     */
    public DetailDataEpsonBulkUpdateResult getDetailDataEpsonBulkUpdateResult() {
        return (DetailDataEpsonBulkUpdateResult) super.getResult().get(RESULT_KEY);
    }

}
