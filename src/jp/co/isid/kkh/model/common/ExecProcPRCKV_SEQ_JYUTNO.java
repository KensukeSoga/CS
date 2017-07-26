package jp.co.isid.kkh.model.common;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.rpcapi.AbstractRpcDao;

public class ExecProcPRCKV_SEQ_JYUTNO extends AbstractRpcDao {

	private String _egCd = "";
	private String _tksCd = "";
	private String _yyyyMm = "";
	private String _newJyutNo = "";

	@Override
	public String getCallableSQL() {
		return "{call PRCKV_SEQ_JYUTNO(?,?,?,?)}";
	}

	@Override
	public void setInOutParameters() throws UserException {
		setString(1, _egCd);
		setString(2, _tksCd);
		setString(3, _yyyyMm);
		registerOutParameter(4, java.sql.Types.CHAR);
	}

	public String execPRCKV_SEQ_JYUTNO(String egCd, String tksCd, String yyyyMm) throws KKHException{

		_egCd = egCd;
		_tksCd = tksCd;
		_yyyyMm = yyyyMm;

		try {
			execProcedure();
			_newJyutNo = getString(4);
		} catch (UserException e) {
			throw new KKHException(e.getMessage(), "PROC_ERROR");//TODO
		}

		return _newJyutNo;
	}

	public void setInParameters(String egCd, String tksCd, String yyyyMm){
		_egCd = egCd;
		_tksCd = tksCd;
		_yyyyMm = yyyyMm;
	}
}
