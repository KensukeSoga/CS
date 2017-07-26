package jp.co.isid.kkh.customer.tkd.model.detail;


import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * ���{NO����UP/DOWN�i���{No�����t�^�j�pDAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/7 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
final class AutoJissiBycondDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private AutoJissiBycondDAOFactory() {
    }

    /**
     * �X�VDAO�C���X�^���X�𐶐����܂��B
     * @return �X�V�E�폜DAO�C���X�^���X
     */
    public static AutoJissiBycondDAO createAutojissiDAO() {
        return (AutoJissiBycondDAO) DaoFactory.createDao(AutoJissiBycondDAO.class);
    }
}
