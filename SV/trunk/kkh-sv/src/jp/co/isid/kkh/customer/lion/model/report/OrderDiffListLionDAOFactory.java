package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���C�I���󒍍��وꗗ����DAO�t�@�N�g���[
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/11/10 HLC S.Fujimoto)<BR>
 * </BR>
 *
 * @author HLC S.Fujimoto
 */
public class OrderDiffListLionDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private OrderDiffListLionDAOFactory() {
    }

    /**
     * DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static OrderDiffListLionDAO createDAO() {
        return (OrderDiffListLionDAO) DaoFactory.createDao(OrderDiffListLionDAO.class);
    }

}
