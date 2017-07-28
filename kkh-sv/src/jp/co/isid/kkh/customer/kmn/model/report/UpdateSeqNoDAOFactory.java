package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �V�[�N�G���XNo�o�^�E�X�VDAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/26 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
final class UpdateSeqNoDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private UpdateSeqNoDAOFactory() {
    }

    /**
     * �f�[�^�擾DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static UpdateSeqNoDAO createUpdateSeqNoDAO() {
        return (UpdateSeqNoDAO) DaoFactory.createDao(UpdateSeqNoDAO.class);
    }
}
