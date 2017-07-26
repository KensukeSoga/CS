package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���C�I�����[(�ǉ��ύX���X�g)DAO�t�@�N�g���[
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </BR>
 *
 * @author HLC S.Fujimoto
 */
public class AddChangeReportLionBaitaiDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private AddChangeReportLionBaitaiDAOFactory() {
    }

    /**
     * DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static AddChangeReportLionBaitaiDAO createDAO() {
        return (AddChangeReportLionBaitaiDAO) DaoFactory.createDao(AddChangeReportLionBaitaiDAO.class);
    }

}
