package jp.co.isid.kkh.customer.tkd.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���c�������ׁi�i�ڕʁj�擾DAO�t�@�N�g���[
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 * 
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByItemDAOFactory extends DaoFactory {

	/**
	 * �C���X�^���X�����֎~���܂��B
	 */
	private ReportTkdBillingByItemDAOFactory() {
	}

	/**
	 * DAO�C���X�^���X�𐶐����܂��B
	 * 
	 * @return DAO�C���X�^���X
	 */
	public static ReportTkdBillingByItemDAO createDAO() {
		return (ReportTkdBillingByItemDAO) DaoFactory.createDao(ReportTkdBillingByItemDAO.class);
	}
}
