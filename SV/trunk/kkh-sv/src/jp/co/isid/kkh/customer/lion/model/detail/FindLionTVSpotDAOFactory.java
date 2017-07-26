package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotDAO;
import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���C�I��TVSpot�f�[�^�擾DAO�t�@�N�g���[
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/03/05 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FindLionTVSpotDAOFactory extends DaoFactory {

	/**
	 * �C���X�^���X�����֎~���܂��B
	 */
	private FindLionTVSpotDAOFactory() {
	}

	/**
	 * DAO�C���X�^���X�𐶐����܂��B
	 *
	 * @return DAO�C���X�^���X
	 */
	public static FindLionTVSpotDAO createDAO() {
		return (FindLionTVSpotDAO) DaoFactory.createDao(FindLionTVSpotDAO.class);
	}
}
