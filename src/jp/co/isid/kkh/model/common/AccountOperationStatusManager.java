package jp.co.isid.kkh.model.common;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * 業務会計稼働状況Manager
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/09 JSE H.Abe)<BR>
 * </P>
 *
 * @author
 */
public class AccountOperationStatusManager {

    /** 稼働状態：稼働中 */
    private static String OPERATION_STATUS_ACTIVE = "0";

    /** シングルトンインスタンス */
    private static AccountOperationStatusManager _manager = new AccountOperationStatusManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private AccountOperationStatusManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static AccountOperationStatusManager getInstance() {
        return _manager;
    }

    /**
     * 業務会計稼働状況をチェックします。
     *
     * @param cond 業務会計稼働状況検索条件
     * @return true：稼働中、false：停止中
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public boolean checkAccountOperationStatus(AccountOperationStatusCondition cond) throws KKHException {

        AccountOperationStatusDAO dao = AccountOperationStatusDAOFactory.createAccountOperationStatusDAO();

        // 業務会計稼働状況取得
        List<AccountOperationStatusVO> voList = dao.getAccountOperationStatus(cond);

        if (voList.size() > 0) {
            // 稼働中の場合
            if (OPERATION_STATUS_ACTIVE.equals(voList.get(0).getKanriFlg())) {
                return true;
            }
        }
        return false;
    }

}
