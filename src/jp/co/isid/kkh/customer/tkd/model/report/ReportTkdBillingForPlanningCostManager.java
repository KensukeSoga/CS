package jp.co.isid.kkh.customer.tkd.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���c�������ׁi����j�擾�}�l�[�W���[
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingForPlanningCostManager {

	/** �V���O���g���C���X�^���X */
	private static ReportTkdBillingForPlanningCostManager _manager = new ReportTkdBillingForPlanningCostManager();

	/**
	 * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
	 */
	private ReportTkdBillingForPlanningCostManager() {
	}

	/**
	 * �C���X�^���X��Ԃ��܂��B
	 *
	 * @return �C���X�^���X
	 */
	public static ReportTkdBillingForPlanningCostManager getInstance() {
		return _manager;
	}

	/**
	 * ���[�f�[�^(TOH)���������܂��B
	 *
	 * @return ReportTohResult �ėp�}�X�^�����f�[�^
	 * @throws KKHException
	 *             �������ɃG���[�����������ꍇ
	 */
	public ReportTkdBillingForPlanningCostResult findByCondition(ReportTkdBillingForPlanningCostCondition cond) throws KKHException {
		// ��������
		ReportTkdBillingForPlanningCostResult result = new ReportTkdBillingForPlanningCostResult();

		// ******************************************************
		// �L����׃f�[�^���擾
		// ******************************************************
		ReportTkdBillingForPlanningCostDAO dao = ReportTkdBillingForPlanningCostDAOFactory.createDAO();

		List<ReportTkdBillingForPlanningCostVO> list = dao.findReportTkdBillingByCondition(cond);

		result.setReportTkdBilling(list);

		return result;
	}
}
