package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �V�[�N�G���XNo�ő�l�擾DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/25 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
final class MaxSeqNoDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private MaxSeqNoDAOFactory() {
    }

    /**
     * �f�[�^�擾DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static MaxSeqNoDAO createMaxSeqNoDAO() {
        return (MaxSeqNoDAO) DaoFactory.createDao(MaxSeqNoDAO.class);
    }
}
