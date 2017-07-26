package jp.co.isid.kkh.model.common;

import jp.co.isid.nj.integ.DaoFactory;

public class ExecProcedureDAOFactory extends DaoFactory {
    /**
	    * �C���X�^���X�����֎~���܂��B
	    */
	    private ExecProcedureDAOFactory() {
	    }


	    /**
	    * DAO�C���X�^���X�𐶐����܂��B
	    * @return DAO�C���X�^���X
	    */
	    public static ExecProcedureDAO createExecProcedureDAO() {
	        return (ExecProcedureDAO) DaoFactory.createDao(ExecProcedureDAO.class);
	    }
}
