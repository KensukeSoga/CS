package jp.co.isid.kkh.customer.tkd.model.report;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���c�������ׁi�����ޕʁj�擾�}�l�[�W���[
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByMiddleClassificationManager {

	/** �V���O���g���C���X�^���X */
	private static ReportTkdBillingByMiddleClassificationManager _manager = new ReportTkdBillingByMiddleClassificationManager();

	/**
	 * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
	 */
	private ReportTkdBillingByMiddleClassificationManager() {
	}

	/**
	 * �C���X�^���X��Ԃ��܂��B
	 *
	 * @return �C���X�^���X
	 */
	public static ReportTkdBillingByMiddleClassificationManager getInstance() {
		return _manager;
	}

	/**
	 * ���[�f�[�^(TKD)���������܂��B
	 *
	 * @return ReportTkdBillingByMiddleClassificationResult �ėp�}�X�^�����f�[�^
	 * @throws KKHException
	 *             �������ɃG���[�����������ꍇ
	 */
	public ReportTkdBillingByMiddleClassificationResult findByCondition(ReportTkdBillingByMiddleClassificationCondition cond) throws KKHException {
		// ��������
		ReportTkdBillingByMiddleClassificationResult result = new ReportTkdBillingByMiddleClassificationResult();

		// ******************************************************
		// �L����׃f�[�^���擾
		// ******************************************************
		ReportTkdBillingByMiddleClassificationDAO dao = ReportTkdBillingByMiddleClassificationDAOFactory.createDAO();

		List<ReportTkdBillingByMiddleClassificationVO> list = dao.findReportTkdBillingByCondition(cond);

		result.setReportTkdBilling(list);

		return result;
	}
}
