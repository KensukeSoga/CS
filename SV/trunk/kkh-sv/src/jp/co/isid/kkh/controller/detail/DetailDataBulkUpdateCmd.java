package jp.co.isid.kkh.controller.detail;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.DetailDataBulkUpdateResult;
import jp.co.isid.kkh.model.detail.DetailDataBulkUpdateVO;
import jp.co.isid.kkh.model.detail.DetailManager;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 広告費明細－表示データ更新コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/11 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class DetailDataBulkUpdateCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 広告費明細表示データ更新処理用VO */
    private DetailDataBulkUpdateVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 広告費明細表示データ更新処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        DetailManager manager = DetailManager.getInstance();

        // 広告費明細データの登録
        DetailDataBulkUpdateResult result = manager.bulkUpdateDetailData(_vo);
        // 正常終了
        getResult().set(RESULT_KEY, result);

//        throw new KKHException("");
    }

    /**
     * 広告費明細データ更新(一括)VOを設定します。
     *
     * @param vo DetailDataBulkUpdateVO 広告費明細データ更新(一括)VO
     */
    public void setDetailDataBulkUpdateVO(DetailDataBulkUpdateVO vo) {
        _vo = vo;
    }

    /**
     * 登録後結果を返します。
     *
     * @return UpdateDisplayDataResult 登録後のプランデータ
     */
    public DetailDataBulkUpdateResult getDetailDataBulkUpdateResult() {
        return (DetailDataBulkUpdateResult) super.getResult().get(RESULT_KEY);
    }

}
