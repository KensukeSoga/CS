package jp.co.isid.kkh.customer.mac.model.master;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �}�N�h�i���h�X�܃}�X�^�����e�[�u���L�[���ڎ擾DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 *
 * @author
 */
final class FindMasterMacTnpRKeyByCondDAOFactory extends DaoFactory {

	/**
	 * �C���X�^���X�����֎~���܂��B
	 */
	private FindMasterMacTnpRKeyByCondDAOFactory() {
	}

	/**
	 * �f�[�^�擾DAO�C���X�^���X�𐶐����܂��B
	 *
	 * @return DAO�C���X�^���X
	 */
	public static FindMasterMacTnpRKeyByCondDAO createFindMasterMacTnpRKeyByCondDAO() {
		return (FindMasterMacTnpRKeyByCondDAO) DaoFactory.createDao(FindMasterMacTnpRKeyByCondDAO.class);
	}
}
