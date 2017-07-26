package jp.co.isid.kkh.customer.tkd.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���c�������ׁi�i�ڕʁj�擾�}�l�[�W���[
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByItemManager {

	/** �V���O���g���C���X�^���X */
	private static ReportTkdBillingByItemManager _manager = new ReportTkdBillingByItemManager();

	/**
	 * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
	 */
	private ReportTkdBillingByItemManager() {
	}

	/**
	 * �C���X�^���X��Ԃ��܂��B
	 *
	 * @return �C���X�^���X
	 */
	public static ReportTkdBillingByItemManager getInstance() {
		return _manager;
	}

	/**
	 * ���[�f�[�^(TKD)���������܂��B
	 *
	 * @return ReportTkdBillingByItemResult �ėp�}�X�^�����f�[�^
	 * @throws KKHException
	 *             �������ɃG���[�����������ꍇ
	 */
	public ReportTkdBillingByItemResult findByCondition(ReportTkdBillingByItemCondition cond) throws KKHException {
		// ��������
		ReportTkdBillingByItemResult result = new ReportTkdBillingByItemResult();

		// ******************************************************
		// �L����׃f�[�^���擾
		// ******************************************************
		ReportTkdBillingByItemDAO dao = ReportTkdBillingByItemDAOFactory.createDAO();

		List<ReportTkdBillingByItemVO> list = dao.findReportTkdBillingByCondition(cond);

		result.setReportTkdBilling(list);

		return result;

	}
}
