package jp.co.isid.kkh.customer.mac.model.master;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterCondition;

/**
 * <P>
 * マクドナルド店舗マスタ履歴テーブル検索Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 * @author
 */
public class MasterMacTnpRManager {

    /** シングルトンインスタンス */
    private static MasterMacTnpRManager _manager = new MasterMacTnpRManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private MasterMacTnpRManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static MasterMacTnpRManager getInstance() {
        return _manager;
    }

    /**
     * マクドナルド店舗マスタ履歴テーブルに全データ登録
     *
     * @param cond 登録条件
     *        aplid アプリID
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void insertAllData(MasterCondition cond, String aplid) throws KKHException {
            MasterMacTnpRRegisterDAO dao = MasterMacTnpRRegisterDAOFactory.createMasterRegisterDAO();
            dao.insertAllDataVO(cond,aplid);
    }

    /**
     * マクドナルド店舗マスタ履歴テーブルに新規データ登録
     *
     * @param cond 登録条件
     *        aplid アプリID
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void insertNewData(MasterCondition cond, String aplid) throws KKHException {
            MasterMacTnpRRegisterDAO dao = MasterMacTnpRRegisterDAOFactory.createMasterRegisterDAO();
            dao.insertNewDataVO(cond,aplid);
    }

    /**
     * マクドナルド店舗マスタ履歴テーブルからデータ削除
     *
     * @param cond 登録条件
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void deleteData(MasterCondition cond) throws KKHException {
            MasterMacTnpRRegisterDAO dao = MasterMacTnpRRegisterDAOFactory.createMasterRegisterDAO();
            dao.deleteDataVO(cond);
    }

    /**
     * マクドナルド店舗マスタ履歴テーブルのデータを削除モードに更新
     *
     * @param cond 登録条件
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void updateDelMode(MasterCondition cond) throws KKHException {
            MasterMacTnpRRegisterDAO dao = MasterMacTnpRRegisterDAOFactory.createMasterRegisterDAO();
            dao.updateDelModeVO(cond);
    }

    /**
    * マクドナルド店舗マスタ履歴テーブルの更新実施キーを一括更新
     *
     * @param cond 登録条件
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public void updateDate(MasterCondition cond) throws KKHException {
            MasterMacTnpRRegisterDAO dao = MasterMacTnpRRegisterDAOFactory.createMasterRegisterDAO();
            dao.updateDateVO(cond);
    }

}
