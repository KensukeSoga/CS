package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���[�i���j�`���[��_�L����ו\�j�f�[�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
final class ReportKmnDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private ReportKmnDAOFactory() {
    }

    /**
     * �f�[�^�擾DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static ReportKmnDAO createFindReportKmnDAO() {
        return (ReportKmnDAO) DaoFactory.createDao(ReportKmnDAO.class);
    }
}
