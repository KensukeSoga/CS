package jp.co.isid.kkh.customer.acom.model.input;

import jp.co.isid.kkh.customer.acom.model.input.HikRegistDAO;
import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �����f�[�^�o�^DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/14 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
final class HikRegistDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private HikRegistDAOFactory() {
    }

    /**
     * �X�VDAO�C���X�^���X�𐶐����܂��B
     * @return �X�V�E�폜DAO�C���X�^���X
     */
    public static HikRegistDAO createHikRegistDAO() {
        return (HikRegistDAO) DaoFactory.createDao(HikRegistDAO.class);
    }
}
