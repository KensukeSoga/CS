package jp.co.isid.kkh.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �L����חp���㖾��VIEWDAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class ThbAdmUriagemDAOFactory extends DaoFactory {

    /**
     * �C���X�^���X�����֎~���܂��B
     */
    private ThbAdmUriagemDAOFactory() {
    }

    /**
     * DAO�C���X�^���X�𐶐����܂��B
     *
     * @return DAO�C���X�^���X
     */
    public static ThbAdmUriagemDAO createThbAdmUriagemDAO() {
        return (ThbAdmUriagemDAO) DaoFactory.createDao(ThbAdmUriagemDAO.class);
    }
}
