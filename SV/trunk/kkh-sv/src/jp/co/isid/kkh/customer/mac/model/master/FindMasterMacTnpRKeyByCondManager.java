package jp.co.isid.kkh.customer.mac.model.master;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �}�N�h�i���h�X�܃}�X�^�����e�[�u���L�[���ڎ擾Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 * @author
 */
public class FindMasterMacTnpRKeyByCondManager {

	/** �V���O���g���C���X�^���X */
	private static FindMasterMacTnpRKeyByCondManager _manager = new FindMasterMacTnpRKeyByCondManager();

	/**
	 * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
	 */
	private FindMasterMacTnpRKeyByCondManager() {
	}

	/**
	 * �C���X�^���X��Ԃ��܂��B
	 *
	 * @return �C���X�^���X
	 */
	public static FindMasterMacTnpRKeyByCondManager getInstance() {
		return _manager;
	}

	/**
	 * �g�p�ώ��{No�̌������������܂��B
	 *
	 * @return FindJissiNoCntByCondResult �g�p�ώ��{No�̌���
	 * @throws KKHException
	 *             �������ɃG���[�����������ꍇ
	 */
	public FindMasterMacTnpRKeyByCondResult findthb17rmtnp(
	        FindMasterMacTnpRByCondCondition cond) throws KKHException {

		// ��������
	    FindMasterMacTnpRKeyByCondResult result = new FindMasterMacTnpRKeyByCondResult();

	    FindMasterMacTnpRKeyByCondDAO dao = FindMasterMacTnpRKeyByCondDAOFactory.createFindMasterMacTnpRKeyByCondDAO();

		List<FindMasterMacTnpRKeyByCondVO> list = dao.findthb17rmtnp(cond);

        result.set_thb17RmtnpList(list);

        return result;
	}

}
