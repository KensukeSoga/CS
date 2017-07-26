package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �ėp�}�X�^�o�^DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/03/05 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class UpdateLionZashiRyoSpcMastDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private UpdateLionZashiRyoSpcMastDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static UpdateLionZashiRyoSpcMastDAO createUpdateLionZashiRyoSpcMastDAO() {
        return (UpdateLionZashiRyoSpcMastDAO) DaoFactory.createDao(UpdateLionZashiRyoSpcMastDAO.class);
    }
}
