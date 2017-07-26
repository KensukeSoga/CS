package jp.co.isid.kkh.customer.acom.model.claim;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * ����/�����ԍ� �ꗗ���擾DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/2 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
final class FindClaimByCondDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private FindClaimByCondDAOFactory() {
    }

    /**
     * �f�[�^�擾DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static FindClaimByCondDAO createFindKenMeisaiByCondDAO() {
        return (FindClaimByCondDAO) DaoFactory.createDao(FindClaimByCondDAO.class);
    }
}
