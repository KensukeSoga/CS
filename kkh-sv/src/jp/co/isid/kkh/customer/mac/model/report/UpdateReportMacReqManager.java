package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;


/**
 * <P>
 * データ更新(請求書)manager
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/18 IP Shimizu)<BR>
 * </P>
 * @author
 */
public class UpdateReportMacReqManager {

    /** シングルトンインスタンス */
    private static UpdateReportMacReqManager _manager = new UpdateReportMacReqManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private UpdateReportMacReqManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static UpdateReportMacReqManager getInstance() {
        return _manager;
    }

    /**
     * マスタ(データ)の登録
     *
     * @param list マスタデータVO（INSERT用）のリスト
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void updateReportMacRequest(List<UpdateReportMacReqDataVO> list) throws KKHException {



        for (UpdateReportMacReqDataVO vo : list) {
            UpdateReportMacReqDAO dao = UpdateReportMacReqDAOFactory.createMasterRegisterDAO();
            dao.updateReportMacRequest(vo);
        }
    }
}
