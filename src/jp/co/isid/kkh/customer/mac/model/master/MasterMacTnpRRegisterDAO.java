package jp.co.isid.kkh.customer.mac.model.master;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.tbl.TBTHB17RMTNP;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterCondition;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * マクドナルド店舗マスタ履歴テーブル登録DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 * @author
 */
public class MasterMacTnpRRegisterDAO extends AbstractSimpleRdbDao {

    /**マクドナルド店舗マスタ履歴テーブル(データ)検索条件*/
    private MasterCondition _cond;
    private String _aplid;
    private Integer _tmpUpdKey = 9999;

    /** getSelectSQLで発行するSQLのモード() */
    private enum SqlMode{ALLINS,NEWINS,DEL,UPDDELMODE,UPDDATE};
    private SqlMode _sqlMode = SqlMode.ALLINS;

    /** 更新画面（1:取込、2:単一更新、3:一覧更新） */
    private Integer _updMode = 1;

    /**
     * デフォルトコンストラクタ。
     */
    public MasterMacTnpRRegisterDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * プライマリキーを返します。
     *
     * @return String[] プライマリキー
     */
    public String[] getPrimryKeyNames() {
        return null;
    }

    /**
     * 更新日付フィールドを返します。
     *
     * @return String 更新日付フィールド
     */
    public String getTimeStampKeyName() {
        return TBTHB17RMTNP.TRKTIMSTMP;
    }

    /**
     * システム日付で更新する列の定義です
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[] { TBTHB17RMTNP.TRKTIMSTMP,TBTHB17RMTNP.UPDTIMSTMP };
    }

    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    public String getTableName() {
        return TBTHB17RMTNP.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[]{
        };
    }

    /**
     * マクドナルド店舗マスタ履歴テーブルに全データ登録
     *
     * @param cond 更新条件
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void insertAllDataVO(MasterCondition cond, String aplid) throws KKHException {
        //パラメータチェック
        if (cond == null) {
            throw new KKHException("登録エラー", "BD-E0004");
        }
        try {
            _cond = cond;
            _aplid = aplid;
            _sqlMode = SqlMode.ALLINS;
            if(_cond.getFilterValue()==null){
                //店舗データ取込画面はアプリIDが10
                if(_aplid.equals("10"))
                {
                    _updMode = 1;

                } else {
                    _updMode = 3;
                }
            } else {
                _updMode = 2;
            }
             super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0004");
        }
    }

    /**
     * マクドナルド店舗マスタ履歴テーブルに新規データ登録
     *
     * @param cond 更新条件
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void insertNewDataVO(MasterCondition cond, String aplid) throws KKHException {
        //パラメータチェック
        if (cond == null) {
            throw new KKHException("登録エラー", "BD-E0004");
        }
        try {
            _cond = cond;
            _aplid = aplid;
            _sqlMode = SqlMode.NEWINS;
            if(_cond.getFilterValue()==null){
                //店舗データ取込画面はアプリIDが10
                if(_aplid.equals("10"))
                {
                    _updMode = 1;

                } else {
                    _updMode = 3;
                }
            } else {
                _updMode = 2;
            }
             super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0004");
        }
    }

    /**
     * マクドナルド店舗マスタ履歴テーブルからデータ削除
     *
     * @param cond 削除条件
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void deleteDataVO(MasterCondition cond) throws KKHException {
        //パラメータチェック
        if (cond == null) {
            throw new KKHException("登録エラー", "BD-E0004");
        }
        try {
            _cond = cond;
            _sqlMode = SqlMode.DEL;
             super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0004");
        }
    }

    /**
     * マクドナルド店舗マスタ履歴テーブルのデータを削除モードに更新
     *
     * @param cond 更新条件
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void updateDelModeVO(MasterCondition cond) throws KKHException {
        //パラメータチェック
        if (cond == null) {
            throw new KKHException("登録エラー", "BD-E0004");
        }
        try {
            _cond = cond;
            _sqlMode = SqlMode.UPDDELMODE;
             super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0004");
        }
    }

    /**
    * マクドナルド店舗マスタ履歴テーブルの更新実施キーを一括更新
    *
    * @param cond 更新条件
    * @throws KKHException データアクセス中にエラーが発生した場合
    */
   public boolean updateDateVO(MasterCondition cond) throws KKHException {
       //パラメータチェック
       if (cond == null) {
           throw new KKHException("更新エラー", "BD-E0003");
       }
       try {
           _cond = cond;
    	   _sqlMode = SqlMode.UPDDATE;
           super.exec();
       } catch (UserException e) {
           throw new KKHException(e.getMessage(), "BD-E0003");
       }

       return true;
   }

    /**
     * ＳＱＬ生成
     */
    @Override
    public String getExecString()
    {
        StringBuffer sql = new StringBuffer();

    	if (_sqlMode == SqlMode.ALLINS)
    	{
	        sql.append(" INSERT INTO ");
	        sql.append(" " + TBTHB17RMTNP.TBNAME + " ");
	        sql.append(" ( ");
	        sql.append(" " + TBTHB17RMTNP.TRKTIMSTMP + " ");
	        sql.append("," + TBTHB17RMTNP.TRKPL + " ");
	        sql.append("," + TBTHB17RMTNP.TRKTNT + " ");
	        sql.append("," + TBTHB17RMTNP.UPDTIMSTMP + " ");
	        sql.append("," + TBTHB17RMTNP.UPDAPL + " ");
	        sql.append("," + TBTHB17RMTNP.UPDTNT + " ");
	        sql.append("," + TBTHB17RMTNP.EGCD + " ");
	        sql.append("," + TBTHB17RMTNP.TKSKGYCD + " ");
	        sql.append("," + TBTHB17RMTNP.TKSBMNSEQNO + " ");
	        sql.append("," + TBTHB17RMTNP.TKSTNTSEQNO + " ");
	        sql.append("," + TBTHB17RMTNP.TENPOCD + " ");
	        sql.append("," + TBTHB17RMTNP.TENPONM + " ");
	        sql.append("," + TBTHB17RMTNP.TERRITORY + " ");
	        sql.append("," + TBTHB17RMTNP.TENPOKBN + " ");
	        sql.append("," + TBTHB17RMTNP.KAMOKU + " ");
            sql.append("," + TBTHB17RMTNP.YUBINNO + " ");
	        sql.append("," + TBTHB17RMTNP.ADDRESS1+ " ");
            sql.append("," + TBTHB17RMTNP.ADDRESS2+ " ");
            sql.append("," + TBTHB17RMTNP.TELNO + " ");
            sql.append("," + TBTHB17RMTNP.SPLITFLG + " ");
            sql.append("," + TBTHB17RMTNP.COMPANYNM + " ");
            sql.append("," + TBTHB17RMTNP.NAME + " ");
            sql.append("," + TBTHB17RMTNP.TORIHIKICD + " ");
            sql.append("," + TBTHB17RMTNP.INSTATUS + " ");
            sql.append("," + TBTHB17RMTNP.SGOPEN + " ");
            sql.append("," + TBTHB17RMTNP.GOPEN + " ");
            sql.append("," + TBTHB17RMTNP.GCLOSE + " ");
            sql.append("," + TBTHB17RMTNP.UPDRRKTIMSTMP + " ");
            sql.append("," + TBTHB17RMTNP.TORIKOMIFLG + " ");
            sql.append("," + TBTHB17RMTNP.RRKSYBT + " ");
            sql.append(" ) ");
            sql.append(" SELECT ");
            sql.append(" " + TBTHBAMST.TRKTIMSTMP + " ");
            sql.append("," + TBTHBAMST.TRKPL + " ");
            sql.append("," + TBTHBAMST.TRKTNT + " ");
            sql.append("," + TBTHBAMST.UPDTIMSTMP + " ");
            sql.append("," + TBTHBAMST.UPDAPL + " ");
            sql.append("," + TBTHBAMST.UPDTNT + " ");
            sql.append("," + TBTHBAMST.EGCD + " ");
            sql.append("," + TBTHBAMST.TKSKGYCD + " ");
            sql.append("," + TBTHBAMST.TKSBMNSEQNO + " ");
            sql.append("," + TBTHBAMST.TKSTNTSEQNO + " ");
            sql.append("," + TBTHBAMST.FIELD1 + " ");
            sql.append("," + TBTHBAMST.FIELD2 + " ");
            sql.append("," + TBTHBAMST.FIELD8 + " ");
            sql.append("," + TBTHBAMST.FIELD9 + " ");
            sql.append("," + TBTHBAMST.FIELD3 + " ");
            sql.append("," + TBTHBAMST.FIELD4 + " ");
            sql.append("," + TBTHBAMST.FIELD20 + " ");
            sql.append("," + TBTHBAMST.FIELD6 + " ");
            sql.append("," + TBTHBAMST.FIELD7 + " ");
            sql.append("," + TBTHBAMST.FIELD13 + " ");
            sql.append("," + TBTHBAMST.FIELD10 + " ");
            sql.append("," + TBTHBAMST.FIELD11 + " ");
            sql.append("," + TBTHBAMST.FIELD12 + " ");
            sql.append("," + TBTHBAMST.FIELD14 + " ");
            sql.append("," + TBTHBAMST.FIELD15 + " ");
            sql.append("," + TBTHBAMST.FIELD16 + " ");
            sql.append("," + TBTHBAMST.FIELD17 + " ");
            sql.append(", '" + _tmpUpdKey + "' ");
            sql.append(", '" + _updMode + "' ");
            sql.append(",'2' ");
            sql.append(" FROM ");
	        sql.append(" " + TBTHBAMST.TBNAME + " ");
	        sql.append(" WHERE ");
	        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' ");
	        sql.append(" AND ");
	        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
	        sql.append(" AND ");
	        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
	        sql.append(" AND ");
	        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
	        sql.append(" AND ");
	        sql.append(" " + TBTHBAMST.SYBT + " = '" + _cond.getSybt() + "' ");
    	}
    	else if (_sqlMode == SqlMode.NEWINS)
    	{
            sql.append(" INSERT INTO ");
            sql.append(" " + TBTHB17RMTNP.TBNAME + " ");
            sql.append(" ( ");
            sql.append(" " + TBTHB17RMTNP.TRKTIMSTMP + " ");
            sql.append("," + TBTHB17RMTNP.TRKPL + " ");
            sql.append("," + TBTHB17RMTNP.TRKTNT + " ");
            sql.append("," + TBTHB17RMTNP.UPDTIMSTMP + " ");
            sql.append("," + TBTHB17RMTNP.UPDAPL + " ");
            sql.append("," + TBTHB17RMTNP.UPDTNT + " ");
            sql.append("," + TBTHB17RMTNP.EGCD + " ");
            sql.append("," + TBTHB17RMTNP.TKSKGYCD + " ");
            sql.append("," + TBTHB17RMTNP.TKSBMNSEQNO + " ");
            sql.append("," + TBTHB17RMTNP.TKSTNTSEQNO + " ");
            sql.append("," + TBTHB17RMTNP.TENPOCD + " ");
            sql.append("," + TBTHB17RMTNP.TENPONM + " ");
            sql.append("," + TBTHB17RMTNP.TERRITORY + " ");
            sql.append("," + TBTHB17RMTNP.TENPOKBN + " ");
            sql.append("," + TBTHB17RMTNP.KAMOKU + " ");
            sql.append("," + TBTHB17RMTNP.YUBINNO + " ");
            sql.append("," + TBTHB17RMTNP.ADDRESS1+ " ");
            sql.append("," + TBTHB17RMTNP.ADDRESS2+ " ");
            sql.append("," + TBTHB17RMTNP.TELNO + " ");
            sql.append("," + TBTHB17RMTNP.SPLITFLG + " ");
            sql.append("," + TBTHB17RMTNP.COMPANYNM + " ");
            sql.append("," + TBTHB17RMTNP.NAME + " ");
            sql.append("," + TBTHB17RMTNP.TORIHIKICD + " ");
            sql.append("," + TBTHB17RMTNP.INSTATUS + " ");
            sql.append("," + TBTHB17RMTNP.SGOPEN + " ");
            sql.append("," + TBTHB17RMTNP.GOPEN + " ");
            sql.append("," + TBTHB17RMTNP.GCLOSE + " ");
            sql.append("," + TBTHB17RMTNP.UPDRRKTIMSTMP + " ");
            sql.append("," + TBTHB17RMTNP.TORIKOMIFLG + " ");
            sql.append("," + TBTHB17RMTNP.RRKSYBT + " ");
            sql.append(" ) ");
            sql.append(" SELECT ");
            sql.append(" " + TBTHBAMST.TRKTIMSTMP + " ");
            sql.append("," + TBTHBAMST.TRKPL + " ");
            sql.append("," + TBTHBAMST.TRKTNT + " ");
            sql.append("," + TBTHBAMST.UPDTIMSTMP + " ");
            sql.append("," + TBTHBAMST.UPDAPL + " ");
            sql.append("," + TBTHBAMST.UPDTNT + " ");
            sql.append("," + TBTHBAMST.EGCD + " ");
            sql.append("," + TBTHBAMST.TKSKGYCD + " ");
            sql.append("," + TBTHBAMST.TKSBMNSEQNO + " ");
            sql.append("," + TBTHBAMST.TKSTNTSEQNO + " ");
            sql.append("," + TBTHBAMST.FIELD1 + " ");
            sql.append("," + TBTHBAMST.FIELD2 + " ");
            sql.append("," + TBTHBAMST.FIELD8 + " ");
            sql.append("," + TBTHBAMST.FIELD9 + " ");
            sql.append("," + TBTHBAMST.FIELD3 + " ");
            sql.append("," + TBTHBAMST.FIELD4 + " ");
            sql.append("," + TBTHBAMST.FIELD20 + " ");
            sql.append("," + TBTHBAMST.FIELD6 + " ");
            sql.append("," + TBTHBAMST.FIELD7 + " ");
            sql.append("," + TBTHBAMST.FIELD13 + " ");
            sql.append("," + TBTHBAMST.FIELD10 + " ");
            sql.append("," + TBTHBAMST.FIELD11 + " ");
            sql.append("," + TBTHBAMST.FIELD12 + " ");
            sql.append("," + TBTHBAMST.FIELD14 + " ");
            sql.append("," + TBTHBAMST.FIELD15 + " ");
            sql.append("," + TBTHBAMST.FIELD16 + " ");
            sql.append("," + TBTHBAMST.FIELD17 + " ");
            sql.append(", '" + _tmpUpdKey + "' ");
            sql.append(", '" + _updMode + "' ");
            sql.append(",'1' ");
            sql.append(" FROM ");
            sql.append(" " + TBTHBAMST.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHBAMST.SYBT + " = '" + _cond.getSybt() + "' ");
            sql.append(" AND ");
            sql.append(" NOT EXISTS ( ");
            sql.append("        SELECT ");
            sql.append("            * ");
            sql.append("        FROM ");
            sql.append("        " + TBTHB17RMTNP.TBNAME + " ");
            sql.append("        WHERE ");
            sql.append("        " + TBTHBAMST.EGCD + " = " + TBTHB17RMTNP.EGCD + " ");
            sql.append("        AND ");
            sql.append("        " + TBTHBAMST.TKSKGYCD + " = " + TBTHB17RMTNP.TKSKGYCD + " ");
            sql.append("        AND ");
            sql.append("        " + TBTHBAMST.TKSBMNSEQNO + " = " + TBTHB17RMTNP.TKSBMNSEQNO + " ");
            sql.append("        AND ");
            sql.append("        " + TBTHBAMST.TKSTNTSEQNO + " = " + TBTHB17RMTNP.TKSTNTSEQNO + " ");
            sql.append("        AND ");
            sql.append("        " + TBTHBAMST.FIELD1 + " = " + TBTHB17RMTNP.TENPOCD + " ");
            sql.append(" ) ");
    	}
    	else if (_sqlMode == SqlMode.DEL)
    	{
            sql.append(" DELETE ");
            sql.append(" FROM ");
            sql.append(" " + TBTHB17RMTNP.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(" " + TBTHB17RMTNP.EGCD + " = '" + _cond.getEgCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB17RMTNP.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB17RMTNP.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB17RMTNP.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB17RMTNP.UPDRRKTIMSTMP + " = '" + _tmpUpdKey + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB17RMTNP.RRKSYBT + "= '2' ");
            sql.append(" AND ");
            sql.append(" EXISTS ( ");
            sql.append("        SELECT ");
            sql.append("            * ");
            sql.append("        FROM ");
            sql.append("        " + TBTHBAMST.TBNAME + " ");
            sql.append("        WHERE ");
            sql.append("        " + TBTHB17RMTNP.EGCD + " = " + TBTHBAMST.EGCD + " ");
            sql.append("        AND ");
            sql.append("        " + TBTHB17RMTNP.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " ");
            sql.append("        AND ");
            sql.append("        " + TBTHB17RMTNP.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " ");
            sql.append("        AND ");
            sql.append("        " + TBTHB17RMTNP.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " ");
            sql.append("        AND ");
            sql.append("        " + TBTHB17RMTNP.TENPOCD + " = " + TBTHBAMST.FIELD1 + " ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.TENPONM + ",' ') " + " = NVL(" + TBTHBAMST.FIELD2 + ",' ') ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.TERRITORY + ",' ') " + " = NVL(" + TBTHBAMST.FIELD8 + ",' ') ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.TENPOKBN + ",' ') " + " = NVL(" + TBTHBAMST.FIELD9 + ",' ') ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.KAMOKU + ",' ') " + " = NVL(" + TBTHBAMST.FIELD3 + ",' ') ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.YUBINNO + ",' ') " + " = NVL(" + TBTHBAMST.FIELD4 + ",' ') ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.ADDRESS1 + ",' ') " + " = NVL(" + TBTHBAMST.FIELD20 + ",' ') ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.ADDRESS2 + ",' ') " + " = NVL(" + TBTHBAMST.FIELD6 + ",' ') ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.TELNO + ",' ') " + " = NVL(" + TBTHBAMST.FIELD7 + ",' ') ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.SPLITFLG + ",' ') " + " = NVL(" + TBTHBAMST.FIELD13 + ",' ') ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.COMPANYNM + ",' ') " + " = NVL(" + TBTHBAMST.FIELD10 + ",' ') ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.NAME + ",' ') " + " = NVL(" + TBTHBAMST.FIELD11 + ",' ') ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.TORIHIKICD + ",' ') " + " = NVL(" + TBTHBAMST.FIELD12 + ",' ') ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.INSTATUS + ",' ') " + " = NVL(" + TBTHBAMST.FIELD14 + ",' ') ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.SGOPEN + ",' ') " + " = NVL(" + TBTHBAMST.FIELD15 + ",' ') ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.GOPEN + ",' ') " + " = NVL(" + TBTHBAMST.FIELD16 + ",' ') ");
            sql.append("        AND ");
            sql.append("        NVL(" + TBTHB17RMTNP.GCLOSE + ",' ') " + " = NVL(" + TBTHBAMST.FIELD17 + ",' ') ");
            sql.append(" ) ");
    	}
        else if (_sqlMode == SqlMode.UPDDELMODE)
        {
            sql.append(" UPDATE ");
            sql.append(" " + TBTHB17RMTNP.TBNAME + " ");
            sql.append(" SET ");
            sql.append(" " + TBTHB17RMTNP.RRKSYBT + " = '3' ");
            sql.append(" WHERE ");
            sql.append(" " + TBTHB17RMTNP.EGCD + " = '" + _cond.getEgCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB17RMTNP.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB17RMTNP.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB17RMTNP.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB17RMTNP.UPDRRKTIMSTMP + " ='" + _tmpUpdKey + "' ");
            sql.append(" AND ");
            sql.append(" NOT EXISTS ( ");
            sql.append("        SELECT ");
            sql.append("            * ");
            sql.append("        FROM ");
            sql.append("        " + TBTHBAMST.TBNAME + " ");
            sql.append("        WHERE ");
            sql.append("        " + TBTHB17RMTNP.EGCD + " = " + TBTHBAMST.EGCD + " ");
            sql.append("        AND ");
            sql.append("        " + TBTHB17RMTNP.TKSKGYCD + " = " + TBTHBAMST.TKSKGYCD + " ");
            sql.append("        AND ");
            sql.append("        " + TBTHB17RMTNP.TKSBMNSEQNO + " = " + TBTHBAMST.TKSBMNSEQNO + " ");
            sql.append("        AND ");
            sql.append("        " + TBTHB17RMTNP.TKSTNTSEQNO + " = " + TBTHBAMST.TKSTNTSEQNO + " ");
            sql.append("        AND ");
            sql.append("        " + TBTHB17RMTNP.TENPOCD + " = " + TBTHBAMST.FIELD1 + " ");
            sql.append(" ) ");
        }
        else if (_sqlMode == SqlMode.UPDDATE)
        {
            sql.append(" UPDATE ");
            sql.append(" " + TBTHB17RMTNP.TBNAME + " ");
            sql.append(" SET ");
            sql.append(" " + TBTHB17RMTNP.UPDRRKTIMSTMP + " = TO_CHAR(SYSTIMESTAMP,'yyyymmddhh24missff3') ");
            sql.append(" WHERE ");
            sql.append(" " + TBTHB17RMTNP.EGCD + " = '" + _cond.getEgCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB17RMTNP.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB17RMTNP.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB17RMTNP.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB17RMTNP.UPDRRKTIMSTMP + " = '" + _tmpUpdKey + "' ");
        }

        return sql.toString();
    }



}