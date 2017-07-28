package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ライオン受注差異一覧検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/11/10 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class OrderDiffListLionManager {

    /** シングルトンインスタンス */
    private static OrderDiffListLionManager _manager = new OrderDiffListLionManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private OrderDiffListLionManager() {
    }

    /**
     * インスタンスを返します。
     * @return インスタンス
     */
    public static OrderDiffListLionManager getInstance() {
        return _manager;
    }

    /**
     * ライオン受注差異一覧を検索します。
     * @param cond OrderDiffListLionCondition ライオン受注差異一覧帳票検索条件
     * @return OrderDiffListLionResult ライオン受注差異一覧検索結果データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public OrderDiffListLionResult findByCondition(OrderDiffListLionCondition cond) throws KKHException {

        // パラメータの必須チェック
        if (!CheckParameter(cond)) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }

        OrderDiffListLionResult result = new OrderDiffListLionResult();
        OrderDiffListLionDAO dao = OrderDiffListLionDAOFactory.createDAO();

        //受注差異一覧検索開始
        List<OrderDiffListLionVO> list = dao.findOrderDiffList(cond);

        //新規受注一覧検索開始
        List<OrderDiffListLionVO> list2 = dao.findNewOrderList(cond);

        //受注金額差異一覧検索開始
        List<OrderDiffListLionVO> list3 = dao.findOrderAmtDiffList(cond);

        //検索結果格納
        result.setOrderDiffListInfo(list);
        result.setNewOrderListInfo(list2);
        result.setOrderAmountDiffListInfo(list3);

        return result;
    }

    /**
     * パラメータ必須チェック
     * @param cond OrderDiffListLionCondition ライオン受注差異一覧帳票検索条件
     * @return True: OK、False: NG
     */
    private boolean CheckParameter(OrderDiffListLionCondition cond) {

        //ESQ-ID
        if (cond.getEsqId() == null || cond.getEsqId().equals("")) {
            return false;
        }
        //営業所コード
        if (cond.getEgCd() == null || cond.getEgCd().equals("")) {
            return false;
        }
        //得意先企業コード
        if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")) {
            return false;
        }
        //得意先部門SEQNO
        if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")) {
            return false;
        }
        //得意先担当SEQNO
        if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")) {
            return false;
        }
        //年月
        if (cond.getYymm() == null || cond.getYymm().equals("")) {
            return false;
        }

        return true;
    }

}
