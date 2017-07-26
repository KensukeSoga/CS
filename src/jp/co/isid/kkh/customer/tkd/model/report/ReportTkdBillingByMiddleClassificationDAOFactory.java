package jp.co.isid.kkh.customer.tkd.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���c�������ׁi�����ޕʁj�擾DAO�t�@�N�g���[
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByMiddleClassificationDAOFactory extends DaoFactory {

	/**
	 * �C���X�^���X�����֎~���܂��B
	 */
	private ReportTkdBillingByMiddleClassificationDAOFactory() {
	}

	/**
	 * DAO�C���X�^���X�𐶐����܂��B
	 *
	 * @return DAO�C���X�^���X
	 */
	public static ReportTkdBillingByMiddleClassificationDAO createDAO() {
		return (ReportTkdBillingByMiddleClassificationDAO) DaoFactory.createDao(ReportTkdBillingByMiddleClassificationDAO.class);
	}
}
