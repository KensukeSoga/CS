package jp.co.isid.kkh.customer.uni.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ���[�i���j�`���[��_�L����ו\�j�f�[�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/23 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class ReportUniDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private ReportUniDAOFactory() {
    }

    /**
     * �f�[�^�擾DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static ReportUniDAO createFindReportUniDAO() {
        return (ReportUniDAO) DaoFactory.createDao(ReportUniDAO.class);
    }
}
