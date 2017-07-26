package jp.co.isid.kkh.customer.acom.model.claim;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���M�t���O���X�VDAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/20 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class UpdateOutFlgDAOFactory extends DaoFactory {

	/**
	 * �C���X�^���X�����֎~���܂��B
	 */
	private UpdateOutFlgDAOFactory() {
	}

	/**
	 * �f�[�^�擾DAO�C���X�^���X�𐶐����܂��B
	 *
	 * @return DAO�C���X�^���X
	 */
	public static UpdateOutFlgDAO createUpdateOutFlgDAO() {
		return (UpdateOutFlgDAO) DaoFactory.createDao(UpdateOutFlgDAO.class);
	}
}
