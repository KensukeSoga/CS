package jp.co.isid.kkh.customer.ash.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �X�VDAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/29 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class UpdateDataAshDAOFactory extends DaoFactory {

	/**
	 * �C���X�^���X�����֎~���܂��B
	 */
	private UpdateDataAshDAOFactory() {
	}

	/**
	 * �f�[�^�擾DAO�C���X�^���X�𐶐����܂��B
	 *
	 * @return DAO�C���X�^���X
	 */
	public static UpdateDataAshDAO createUpdateOutFlgDAO() {
		return (UpdateDataAshDAO) DaoFactory.createDao(UpdateDataAshDAO.class);
	}
}
