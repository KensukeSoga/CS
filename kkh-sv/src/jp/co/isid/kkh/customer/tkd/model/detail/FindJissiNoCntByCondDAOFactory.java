package jp.co.isid.kkh.customer.tkd.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �g�p�ώ��{No�̌����擾DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/13 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class FindJissiNoCntByCondDAOFactory extends DaoFactory {

	/**
	 * �C���X�^���X�����֎~���܂��B
	 */
	private FindJissiNoCntByCondDAOFactory() {
	}

	/**
	 * �f�[�^�擾DAO�C���X�^���X�𐶐����܂��B
	 *
	 * @return DAO�C���X�^���X
	 */
	public static FindJissiNoCntByCondDAO createFindJissiNoCntByCondDAO() {
		return (FindJissiNoCntByCondDAO) DaoFactory.createDao(FindJissiNoCntByCondDAO.class);
	}
}
