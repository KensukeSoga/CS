package jp.co.isid.kkh.model.detail;


import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * 発注データ登録DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/28 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
final class JyutNoTouInsDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    private JyutNoTouInsDAOFactory() {
    }

    /**
     * 更新DAOインスタンスを生成します。
     * @return 更新・削除DAOインスタンス
     */
    public static JyutNoTouInsDAO createJyutNoTouUpdateDAO() {
        return (JyutNoTouInsDAO) DaoFactory.createDao(JyutNoTouInsDAO.class);
    }
}
