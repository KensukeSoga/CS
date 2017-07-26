package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���[�i����_�����ꗗ�j�f�[�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/1/31 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
final class ReportKmnListDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private ReportKmnListDAOFactory() {
    }

    /**
     * �f�[�^�擾DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static ReportKmnListDAO createFindReportKmnListDAO() {
        return (ReportKmnListDAO) DaoFactory.createDao(ReportKmnListDAO.class);
    }
}
