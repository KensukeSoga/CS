package jp.co.isid.kkh.model.detail;


import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �����f�[�^�o�^DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/27 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
final class JyutNoTouUpdateDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private JyutNoTouUpdateDAOFactory() {
    }

    /**
     * �X�VDAO�C���X�^���X�𐶐����܂��B
     * @return �X�V�E�폜DAO�C���X�^���X
     */
    public static JyutNoTouUpdateDAO createJyutNoTouUpdateDAO() {
        return (JyutNoTouUpdateDAO) DaoFactory.createDao(JyutNoTouUpdateDAO.class);
    }
}
