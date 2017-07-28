package jp.co.isid.kkh.model.detail;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �ėp�}�X�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class JyutyuDataDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private JyutyuDataDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static JyutyuDataDAO createJyutyuDataDAO() {
        return (JyutyuDataDAO) DaoFactory.createDao(JyutyuDataDAO.class);
    }
}
