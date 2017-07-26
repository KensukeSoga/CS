package jp.co.isid.kkh.model.log;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �ėp���O����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/11 IP H.Shimizu)<BR>
 * </P>
 * @author
 */
public class LogDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private LogDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static LogDAO createLogDAO() {
        return (LogDAO) DaoFactory.createDao(LogDAO.class);
    }
}
