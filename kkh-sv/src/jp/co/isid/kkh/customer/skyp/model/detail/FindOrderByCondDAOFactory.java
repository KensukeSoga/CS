package jp.co.isid.kkh.customer.skyp.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���я����擾DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/21 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class FindOrderByCondDAOFactory extends DaoFactory {

	/**
	 * �C���X�^���X�����֎~���܂��B
	 */
	private FindOrderByCondDAOFactory() {
	}

	/**
	 * �f�[�^�擾DAO�C���X�^���X�𐶐����܂��B
	 *
	 * @return DAO�C���X�^���X
	 */
	public static FindOrderByCondDAO createFindOrderByCondDAO() {
		return (FindOrderByCondDAO) DaoFactory.createDao(FindOrderByCondDAO.class);
	}
}
