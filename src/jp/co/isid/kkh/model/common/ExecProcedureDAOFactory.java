package jp.co.isid.kkh.model.common;

import jp.co.isid.nj.integ.DaoFactory;

public class ExecProcedureDAOFactory extends DaoFactory {
    /**
	    * インスタンス化を禁止します。
	    */
	    private ExecProcedureDAOFactory() {
	    }


	    /**
	    * DAOインスタンスを生成します。
	    * @return DAOインスタンス
	    */
	    public static ExecProcedureDAO createExecProcedureDAO() {
	        return (ExecProcedureDAO) DaoFactory.createDao(ExecProcedureDAO.class);
	    }
}
