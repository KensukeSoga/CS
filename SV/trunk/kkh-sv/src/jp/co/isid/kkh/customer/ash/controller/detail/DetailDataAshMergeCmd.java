package jp.co.isid.kkh.customer.ash.controller.detail;

import jp.co.isid.kkh.customer.ash.model.detail.DetailAshManager;
import jp.co.isid.kkh.customer.ash.model.detail.DetailDataAshMergeResult;
import jp.co.isid.kkh.customer.ash.model.detail.DetailDataAshMergeVO;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * 広告費明細－受注統合(明細統合)
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class DetailDataAshMergeCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** 受注統合(明細統合)処理用VO */
    private DetailDataAshMergeVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * 受注統合(明細統合)処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        DetailAshManager manager = DetailAshManager.getInstance();

        // 受注統合(明細統合)
        DetailDataAshMergeResult result = manager.mergeDataForAsh(_vo);

        // 正常終了
        getResult().set(RESULT_KEY, result);
    }

    /**
     * 受注統合(明細統合)VOを設定します。
     *
     * @param vo DetailDataAshMergeVO 受注統合(明細統合)VO
     */
    public void setDetailDataAshMergeVO(DetailDataAshMergeVO vo) {
        _vo = vo;
    }

    /**
     * 受注統合(明細統合)処理結果を返します。
     *
     * @return DetailDataAshMergeResult 受注統合(明細統合)処理結果
     */
    public DetailDataAshMergeResult getDetailDataAshMergeResult() {
        return (DetailDataAshMergeResult) super.getResult().get(RESULT_KEY);
    }

}
