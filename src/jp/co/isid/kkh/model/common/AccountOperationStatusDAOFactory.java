package jp.co.isid.kkh.model.common;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 業務会計稼働状況DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/09 JSE H.Abe)<BR>
 * </P>
 * @author
 */
public class AccountOperationStatusDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private AccountOperationStatusDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static AccountOperationStatusDAO createAccountOperationStatusDAO() {
        return (AccountOperationStatusDAO) DaoFactory.createDao(AccountOperationStatusDAO.class);
    }
}
