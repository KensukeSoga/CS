package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���C�I�������쐬DAO�t�@�N�g���[
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </BR>
 *
 * @author HLC S.Fujimoto
 */
public class LionHistoryDetailDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private LionHistoryDetailDAOFactory() {
    }

    /**
     * DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static LionHistoryDetailDAO createDAO() {
        return (LionHistoryDetailDAO) DaoFactory.createDao(LionHistoryDetailDAO.class);
    }

}
