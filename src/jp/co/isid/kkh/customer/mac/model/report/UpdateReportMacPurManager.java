package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;


/**
 * <P>
 * データ更新(購入伝票)manager
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/17 IP Shimizu)<BR>
 * </P>
 * @author
 */
public class UpdateReportMacPurManager {

    /** シングルトンインスタンス */
    private static UpdateReportMacPurManager _manager = new UpdateReportMacPurManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private UpdateReportMacPurManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static UpdateReportMacPurManager getInstance() {
        return _manager;
    }


    /**
     * マスタ(データ)の登録
     *
     * @param list マスタデータVO（INSERT用）のリスト
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void updateReportMacSysDenNum(UpdateReportMacPurCondition vo) throws KKHException {


            UpdateReportMacPurDAO dao = UpdateReportMacPurDAOFactory.createMasterRegisterDAO();
            dao.updateReportMacSysDenNum(vo);
    }

    /**
     * マスタ(データ)の登録
     *
     * @param list マスタデータVO（INSERT用）のリスト
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void updateReportMacPurchase(List<UpdateReportMacPurDataVO> list) throws KKHException {



        for (UpdateReportMacPurDataVO vo : list) {
            UpdateReportMacPurDAO dao = UpdateReportMacPurDAOFactory.createMasterRegisterDAO();
            dao.updateReportMacPurchase(vo);
        }
    }
}
