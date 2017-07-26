package jp.co.isid.kkh.customer.ash.model.detail;

import jp.co.isid.nj.integ.DaoFactory;

/**
 * <P>
 * �L�[�ǂ̔ԑg�R�[�h��DAOFactory
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/08/20 HLC S.Jang)<BR>
 * </P>
 *
 * @author HLC ��(Jang)
 */
public class FindKeyKyokuBangumiCdDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    public FindKeyKyokuBangumiCdDAOFactory(){
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static FindKeyKyokuBangumiCdDAO createFindKeyKyokuBangumiCdaDAO() {
        return (FindKeyKyokuBangumiCdDAO) DaoFactory
                .createDao(FindKeyKyokuBangumiCdDAO.class);
    }

}
