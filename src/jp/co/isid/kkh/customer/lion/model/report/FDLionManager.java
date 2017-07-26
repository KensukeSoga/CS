package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���C�I��FD�o�̓f�[�^�擾�}�l�[�W���[
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FDLionManager {

	/** �V���O���g���C���X�^���X */
	private static FDLionManager _manager = new FDLionManager();

	/**
	 * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
	 */
	private FDLionManager() {
	}

	/**
	 * �C���X�^���X��Ԃ��܂��B
	 *
	 * @return �C���X�^���X
	 */
	public static FDLionManager getInstance() {
		return _manager;
	}

	/**
	 * ���C�I��FD�o�̓f�[�^���������܂��B
	 *
	 * @return FDLionResult ���C�I��FD�o�̓f�[�^�擾����
	 * @throws KKHException
	 *             �������ɃG���[�����������ꍇ
	 */
	public FDLionResult findByCondition(FDLionCondition cond) throws KKHException {

		FDLionResult result = new FDLionResult();

		FDLionDAO dao = FDLionDAOFactory.createDAO();

		List<FDLionVO> list = dao.findFDLionByCondition(cond);

		result.setFDLion(list);

		return result;
	}
}
