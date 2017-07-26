package jp.co.isid.kkh.customer.skyp.model.detail;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 並び順更新DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/22 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class UpdateOrderDAO extends AbstractSimpleRdbDao {

    private int _index;
    private UpdateOrderVO _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public UpdateOrderDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /** getExecSQLで発行するSQLのモード() */
    private enum SqlMode{KMEI, DOWN};
    private SqlMode _sqlMode = SqlMode.KMEI;


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
     * 並び順の更新を行います(明細)。
     *
     * @param vo
     *            vo 並び順更新情報VO
     * @param index
     *            index インデックス
     *
     * @return int 更新件数
     *
     * @throws UserException
     *             データアクセス中にエラーが発生した場合
     */
    public int updateThb2KmeiForOrder(UpdateOrderVO vo, int index)
            throws KKHException {
        // パラメータチェック
        if (vo == null) {
            throw new KKHException("登録エラー", "BD-E0002");
        }
        super.setModel(vo);
        try {
            _cond = vo;
            _index = index;
            _sqlMode = SqlMode.KMEI;
            return super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * 受注テーブルのタイムスタンプを更新する。
     *
     * @param vo
     *            vo 並び順更新情報VO
     *
     * @throws UserException
     *             データアクセス中にエラーが発生した場合
     */
    public void updateThb1DownForOrder(UpdateOrderVO vo)
            throws KKHException {
        // パラメータチェック
        if (vo == null) {
            throw new KKHException("登録エラー", "BD-E0002");
        }
        super.setModel(vo);
        try {
            _cond = vo;
            _sqlMode = SqlMode.DOWN;
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
    	if(_sqlMode.equals(SqlMode.KMEI)){
    		return getExecStringKMEI();
        }else{
            return getExecStringDOWN();
        }
    }

    /**
     * 明細更新SQL
     */
    public String getExecStringKMEI() {
        StringBuffer sql = new StringBuffer();

        UpdateOrderVO vo = (UpdateOrderVO) getModel();

        sql.append(" UPDATE");
        sql.append(" " + TBTHB2KMEI.TBNAME);
        sql.append(" SET");
        sql.append(" " + TBTHB2KMEI.TIMSTMP + " = " + getDBModelInterface().getSystemDateString());
        sql.append("," + TBTHB2KMEI.SONOTA1 + " = '" + vo.getOrder()[_index] + "'");
        sql.append(" WHERE");
        sql.append("     " + TBTHB2KMEI.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHB2KMEI.YYMM + "        = '" + _cond.getYymm() + "'");

        // 空文字の場合、NULLも条件に含める
        if (_cond.getBaitaiNm()[_index].equals("") ) {
            sql.append(" AND (TRIM(" + TBTHB2KMEI.NAME7 + ") = '' OR TRIM(" + TBTHB2KMEI.NAME7  + ") IS NULL)");
        }
        else {
            sql.append(" AND TRIM(" + TBTHB2KMEI.NAME7 + ") = '" + _cond.getBaitaiNm()[_index] + "'");
        }

        if (_cond.getBaitaiKbn()[_index].equals(""))
        {
            sql.append(" AND (TRIM(" + TBTHB2KMEI.NAME13 + ") = '' OR TRIM(" + TBTHB2KMEI.NAME13  + ") IS NULL)");
        }
        else
        {
            sql.append(" AND TRIM(" + TBTHB2KMEI.NAME13 + ") = '" + _cond.getBaitaiKbn()[_index] + "'");
        }

        return sql.toString();
    }

    /**
     * 受注更新SQL
     */
    public String getExecStringDOWN() {
        StringBuffer sql = new StringBuffer();

        sql.append(" UPDATE");
        sql.append(" " + TBTHB1DOWN.TBNAME);
        sql.append(" SET");
        sql.append(" " + TBTHB1DOWN.TIMSTMP + " = " + getDBModelInterface().getSystemDateString());
        sql.append(" WHERE");
        sql.append("     " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "'");

        return sql.toString();
    }
}
