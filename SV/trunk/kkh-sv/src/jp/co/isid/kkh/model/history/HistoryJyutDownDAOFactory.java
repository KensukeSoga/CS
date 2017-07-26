package jp.co.isid.kkh.model.history;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 *�}�̕ʈꗗ����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/1/20 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class HistoryJyutDownDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private HistoryJyutDownDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static HistoryJyutDownDAO createHistoryLionJyutDownDAO() {
        return (HistoryJyutDownDAO) DaoFactory.createDao(HistoryJyutDownDAO.class);
    }
}
