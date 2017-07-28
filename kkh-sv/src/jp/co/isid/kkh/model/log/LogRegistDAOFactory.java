package jp.co.isid.kkh.model.log;

import jp.co.isid.kkh.model.log.LogRegistDAO;
import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �ėp���O�f�[�^�o�^DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/17 IP H.Shimizu)<BR>
 * </P>
 * @author IP H.Shimizu
 */
final class LogRegistDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private LogRegistDAOFactory() {
    }

    /**
     * �X�VDAO�C���X�^���X�𐶐����܂��B
     * @return �X�V�E�폜DAO�C���X�^���X
     */
    public static LogRegistDAO createLogRegistDAO() {
        return (LogRegistDAO) DaoFactory.createDao(LogRegistDAO.class);
    }
}
