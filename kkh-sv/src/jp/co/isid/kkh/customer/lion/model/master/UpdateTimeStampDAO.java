package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.kkh.integ.tbl.TBTHBBSYS;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 発注データ登録DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/6 Fourm A.naito)<BR>
 * </P>
 * @author Fourm A.naito
 */
public class UpdateTimeStampDAO extends AbstractSimpleRdbDao  {

    public static final String C_WRFL_TVBMST = "TVBMST"; // TV番組マスタ
    public static final String C_WRFL_RDBMST = "RDBMST"; // ラジオ番組マスタ
    public static final String C_WRFL_TVKMST = "TVKMST"; // TV局マスタ
    public static final String C_WRFL_RDKMST = "RDKMST"; // ラジオ局マスタ
    public static final String C_WRFL_TVRMST = "TVRMST"; // TV料金マスタ
    public static final String C_WRFL_RDRMST = "RDRMST"; // ラジオ料金マスタ
    public static final String C_WRFL_TVCMST = "TVCMST"; // TVCM秒数マスタ
    public static final String C_WRFL_RDCMST = "RDCMST"; // ラジオ秒数マスタ

	private UpdateTimeStampVO _vo;


	/**
     * デフォルトコンストラクタ。
     */
    public UpdateTimeStampDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }


	@Override
	public String[] getPrimryKeyNames() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/**
     * システム日付で更新する列の定義です
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return null;
    }

    /**
     * 更新日付フィールドを返します。
     *
     * @return String 更新日付フィールド
     */
    public String getTimeStampKeyName() {
        return null;
    }

    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    public String getTableName() {
        return null;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return null;
    }

    /**
     * 実施NO自動UP/DOWNの登録を行います。
     *
     * @param vo VO 実施NoVO
     * @throws UserException データアクセス中にエラーが発生した場合
     */
    public void jissiUp(UpdateTimeStampVO vo) throws KKHException {
    	//パラメータチェック
        if (vo == null) {
        	throw new KKHException("登録エラー", "BD-E0002");
        }
        //super.setModel(vo);
        _vo = vo;

        try {
          super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }


    /**
     * EXEC-SQL生成
     */
    @Override
    public String getExecString() {
    	StringBuffer sql = new StringBuffer();
      	sql.append("UPDATE ");
    	sql.append(TBTHBBSYS.TBNAME);
    	sql.append(" SET ");
        if (_vo.get_mstkbn().equals(C_WRFL_TVBMST)) {
        	sql.append(TBTHBBSYS.FIELD2 + " = ");
        }
        else if (_vo.get_mstkbn().equals(C_WRFL_RDBMST)) {
        	sql.append(TBTHBBSYS.FIELD3 + " = ");
        }
        else if (_vo.get_mstkbn().equals(C_WRFL_TVKMST)) {
        	sql.append(TBTHBBSYS.FIELD4 + " = ");
        }
        else if (_vo.get_mstkbn().equals(C_WRFL_RDKMST)) {
        	sql.append(TBTHBBSYS.FIELD5 + " = ");
        }
        else if (_vo.get_mstkbn().equals(C_WRFL_TVRMST)) {
        	sql.append(TBTHBBSYS.FIELD6 + " = ");
        }
        else if (_vo.get_mstkbn().equals(C_WRFL_RDRMST)) {
        	sql.append(TBTHBBSYS.FIELD7 + " = ");
        }
        else if (_vo.get_mstkbn().equals(C_WRFL_TVCMST)) {
        	sql.append(TBTHBBSYS.FIELD8 + " = ");
        }
        else if (_vo.get_mstkbn().equals(C_WRFL_RDCMST)) {
        	sql.append(TBTHBBSYS.FIELD9 + " = ");
        }
    	sql.append("'" + _vo.gettimeStamp() + "'");
    	sql.append(" WHERE ");
    	sql.append(TBTHBBSYS.EGCD + " = ");
    	sql.append("'" + _vo.get_egCd() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHBBSYS.TKSKGYCD + " = ");
    	sql.append("'" + _vo.get_tksKgyCd() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHBBSYS.TKSBMNSEQNO + " = ");
    	sql.append("'" + _vo.get_tksBmnSeqNo() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHBBSYS.TKSTNTSEQNO + " = ");
    	sql.append("'" + _vo.get_TksTntSeqNo() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHBBSYS.SYBT + " = ");
    	sql.append("'" + _vo.get_syBt() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHBBSYS.FIELD1 + " = ");
    	sql.append("'" + _vo.get_field1() + "'");


    	return sql.toString();
    }
}
