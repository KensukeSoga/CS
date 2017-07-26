package jp.co.isid.kkh.customer.skyp.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���[�i�X�J�p�[_�[�i�^�������j�f�[�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/16 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class ReportSkypDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private ReportSkypDAOFactory() {
    }

    /**
     * �f�[�^�擾DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static ReportSkypDAO createFindReportSkypDAO() {
        return (ReportSkypDAO) DaoFactory.createDao(ReportSkypDAO.class);
    }
}
