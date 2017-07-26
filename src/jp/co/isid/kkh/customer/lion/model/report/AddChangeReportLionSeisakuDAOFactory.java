package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���C�I�����[(���쎺���X�g)DAO�t�@�N�g���[
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </BR>
 *
 * @author HLC S.Fujimoto
 */
public class AddChangeReportLionSeisakuDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private AddChangeReportLionSeisakuDAOFactory() {
    }

    /**
     * DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static AddChangeReportLionSeisakuDAO createDAO() {
        return (AddChangeReportLionSeisakuDAO) DaoFactory.createDao(AddChangeReportLionSeisakuDAO.class);
    }

}
