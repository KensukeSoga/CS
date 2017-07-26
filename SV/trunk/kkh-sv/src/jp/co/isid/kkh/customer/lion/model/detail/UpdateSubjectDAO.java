package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 件名変更データ登録DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/09 Fourm A.naito)<BR>
 * </P>
 * @author Fourm A.naito
 */
public class UpdateSubjectDAO extends AbstractSimpleRdbDao  {

	private UpdateSubjectVO _vo;


	/**
     * デフォルトコンストラクタ。
     */
    public UpdateSubjectDAO() {
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
     * 件名変更データの登録を行います。
     *
     * @param vo VO 件名変更VO
     * @throws UserException データアクセス中にエラーが発生した場合
     */
    public void jissiUp(UpdateSubjectVO vo) throws KKHException {
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
    	sql.append(TBTHB1DOWN.TBNAME);
    	sql.append(" SET ");
    	sql.append(TBTHB1DOWN.KKNAMEKJ + " = ");
    	sql.append("'" + _vo.get_kkNameKJ() + "'");
    	sql.append(" WHERE ");
    	sql.append(TBTHB1DOWN.EGCD + " = ");
    	sql.append("'" + _vo.get_egCd() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHB1DOWN.TKSKGYCD + " = ");
    	sql.append("'" + _vo.get_tksKgyCd() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHB1DOWN.TKSBMNSEQNO + " = ");
    	sql.append("'" + _vo.get_tksBmnSeqNo() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHB1DOWN.TKSTNTSEQNO + " = ");
    	sql.append("'" + _vo.get_TksTntSeqNo() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHB1DOWN.YYMM + " = ");
    	sql.append("'" + _vo.get_YYMM() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHB1DOWN.JYUTNO + " = ");
    	sql.append("'" + _vo.get_jyutNo() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHB1DOWN.JYMEINO + " = ");
    	sql.append("'" + _vo.get_jyMeiNo() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHB1DOWN.URMEINO + " = ");
    	sql.append("'" + _vo.get_lUrmeino() + "'");

    	return sql.toString();
    }
}
