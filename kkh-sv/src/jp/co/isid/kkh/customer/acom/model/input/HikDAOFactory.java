package jp.co.isid.kkh.customer.acom.model.input;

import jp.co.isid.nj.integ.DaoFactory;


/**
 * <P>
 * �����f�[�^�}�X�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/08 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
public class HikDAOFactory extends DaoFactory {

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private HikDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static HikDAO createHikDAO() {
        return (HikDAO) DaoFactory.createDao(HikDAO.class);
    }


    /**
     * DAO�C���X�^���X�𐶐����܂��B
     * @return DAO�C���X�^���X
     */
     public static HikCheckDataDAO createHikCheckDataDAO() {
         return (HikCheckDataDAO) DaoFactory.createDao(HikCheckDataDAO.class);
     }

     /**
      * DAO�C���X�^���X�𐶐����܂��B
      * @return DAO�C���X�^���X
      */
      public static HikSearchDateCntDAO createHikFindDateDAO() {
          return (HikSearchDateCntDAO) DaoFactory.createDao(HikSearchDateCntDAO.class);
      }
}
