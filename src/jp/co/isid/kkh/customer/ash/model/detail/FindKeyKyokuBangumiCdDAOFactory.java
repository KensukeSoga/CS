package jp.co.isid.kkh.customer.ash.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * キー局の番組コードのDAOFactory
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/08/20 HLC S.Jang)<BR>
 * </P>
 *
 * @author HLC 張(Jang)
 */
public class FindKeyKyokuBangumiCdDAOFactory extends DaoFactory {

    /**
    * インスタンス化を禁止します。
    */
    public FindKeyKyokuBangumiCdDAOFactory(){
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static FindKeyKyokuBangumiCdDAO createFindKeyKyokuBangumiCdaDAO() {
        return (FindKeyKyokuBangumiCdDAO) DaoFactory
                .createDao(FindKeyKyokuBangumiCdDAO.class);
    }

}
