package jp.co.isid.kkh.customer.skyp.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���я����X�VDAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/22 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class UpdateOrderDAOFactory extends DaoFactory {

	/**
	 * �C���X�^���X�����֎~���܂��B
	 */
	private UpdateOrderDAOFactory() {
	}

	/**
	 * �f�[�^�擾DAO�C���X�^���X�𐶐����܂��B
	 *
	 * @return DAO�C���X�^���X
	 */
	public static UpdateOrderDAO createUpdateOrderDAO() {
		return (UpdateOrderDAO) DaoFactory.createDao(UpdateOrderDAO.class);
	}
}
