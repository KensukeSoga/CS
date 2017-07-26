package jp.co.isid.kkh.customer.acom.model.input;

import jp.co.isid.kkh.customer.acom.model.input.HikSearchDateCntDAO;
import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * ���t�f�[�^�����擾DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/05 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
final class HikSearchDateCntDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private HikSearchDateCntDAOFactory() {
    }

    /**
     * ����DAO�C���X�^���X�𐶐����܂��B
     * @return DAO�C���X�^���X
     */
    public static HikSearchDateCntDAO createHikSearchDateCntDAO() {
        return (HikSearchDateCntDAO) DaoFactory.createDao(HikSearchDateCntDAO.class);
    }
}
