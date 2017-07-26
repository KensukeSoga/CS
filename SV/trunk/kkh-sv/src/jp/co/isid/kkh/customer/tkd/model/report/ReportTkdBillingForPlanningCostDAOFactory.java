package jp.co.isid.kkh.customer.tkd.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���c�������ׁi����j�擾DAO�t�@�N�g���[
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingForPlanningCostDAOFactory extends DaoFactory {

	/**
	 * �C���X�^���X�����֎~���܂��B
	 */
	private ReportTkdBillingForPlanningCostDAOFactory() {
	}

	/**
	 * DAO�C���X�^���X�𐶐����܂��B
	 *
	 * @return DAO�C���X�^���X
	 */
	public static ReportTkdBillingForPlanningCostDAO createDAO() {
		return (ReportTkdBillingForPlanningCostDAO) DaoFactory.createDao(ReportTkdBillingForPlanningCostDAO.class);
	}
}
