package jp.co.isid.kkh.model.common;

import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
public class ExecProcedureDAO extends AbstractRdbDao {

	public ExecProcedureDAO(){
      super.setPoolConnectClass(KKHPoolConnect.class);
      super.setDBModelInterface(KKHOracleModel.getInstance());
      super.setBigDecimalMode(true);
	}

	@Override
	public String[] getPrimryKeyNames() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String[] getTableColumnNames() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getTableName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getTimeStampKeyName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public String execPRCHB_SEQ_JYUTNO(String egCd, String tksCd, String yyyyMm) throws KKHException{

		try {
			ExecProcPRCHB_SEQ_JYUTNO rpcDao = new ExecProcPRCHB_SEQ_JYUTNO();

			rpcDao.setConnection(this.getConnection());

			return rpcDao.execPRCHB_SEQ_JYUTNO(egCd, tksCd, yyyyMm);
		} catch (UserException e) {
			throw new KKHException(e.getMessage(), "PROC_ERROR");
		}
	}

}
