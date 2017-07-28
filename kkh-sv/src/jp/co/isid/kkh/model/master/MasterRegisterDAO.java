package jp.co.isid.kkh.model.master;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
//import jp.co.isid.kkh.model.master.MasterDAO.SqlMode;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * マスタデータ登録DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/11 JSE H.Abe)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class MasterRegisterDAO extends AbstractSimpleRdbDao {

    /**汎用マスタ(データ)検索条件*/
    private MasterCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public MasterRegisterDAO() {
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
        return TBTHBAMST.TRKTIMSTMP;
    }

    /**
     * システム日付で更新する列の定義です
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[] { TBTHBAMST.TRKTIMSTMP,TBTHBAMST.UPDTIMSTMP };
    }

    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    public String getTableName() {
        return TBTHBAMST.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHBAMST.TRKTIMSTMP
                ,TBTHBAMST.TRKPL
                ,TBTHBAMST.TRKTNT
                ,TBTHBAMST.UPDTIMSTMP
                ,TBTHBAMST.UPDAPL
                ,TBTHBAMST.UPDTNT
                ,TBTHBAMST.EGCD
                ,TBTHBAMST.TKSKGYCD
                ,TBTHBAMST.TKSBMNSEQNO
                ,TBTHBAMST.TKSTNTSEQNO
                ,TBTHBAMST.SYBT
                ,TBTHBAMST.FIELD1
                ,TBTHBAMST.FIELD2
                ,TBTHBAMST.FIELD3
                ,TBTHBAMST.FIELD4
                ,TBTHBAMST.FIELD5
                ,TBTHBAMST.FIELD6
                ,TBTHBAMST.FIELD7
                ,TBTHBAMST.FIELD8
                ,TBTHBAMST.FIELD9
                ,TBTHBAMST.FIELD10
                ,TBTHBAMST.FIELD11
                ,TBTHBAMST.FIELD12
                ,TBTHBAMST.FIELD13
                ,TBTHBAMST.FIELD14
                ,TBTHBAMST.FIELD15
                ,TBTHBAMST.FIELD16
                ,TBTHBAMST.FIELD17
                ,TBTHBAMST.FIELD18
                ,TBTHBAMST.FIELD19
                ,TBTHBAMST.FIELD20
                ,TBTHBAMST.INTVALUE1
                ,TBTHBAMST.INTVALUE2
                ,TBTHBAMST.INTVALUE3
                ,TBTHBAMST.INTVALUE4
                ,TBTHBAMST.INTVALUE5
                ,TBTHBAMST.INTVALUE6
                ,TBTHBAMST.INTVALUE7
                ,TBTHBAMST.INTVALUE8
                ,TBTHBAMST.INTVALUE9
                ,TBTHBAMST.INTVALUE10
        };
    }

    /**
     * 汎用マスタ(データ)の登録
     *
     * @param vo マスタデータVO（INSERT用）
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void registMasterDataVO(MasterDataInsertVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("登録エラー", "BD-E0004");
        }
        super.setModel(vo);
        try {
            if (!super.insert()) {
                throw new KKHException("登録エラー", "BD-E0004");
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0004");
        }
    }



    public String getExeckindItemString()
    {
        StringBuffer sql = new StringBuffer();

        sql.append(" DELETE ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        // Where句
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

        if(_cond.getSybt().equals("002"))
        {
            sql.append(" AND ");
            sql.append(" " + "HBA_FIELD1 = '" + _cond.getFilterValue() + "' " );
        }
        return sql.toString();
    }



    /**
     * 削除ＳＱＬ生成
     */
    @Override
    public String getExecString() {

        if(_cond.getSybt().equals("001") || _cond.getSybt().equals("002"))
        {
            return getExeckindItemString();
        }


        StringBuffer sql = new StringBuffer();

        sql.append(" DELETE ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        // Where句
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
        // フィルターがある場合
        if (_cond.getFilterKey() != null && _cond.getFilterValue() != null) {
            sql.append(" AND ");
            sql.append(" " + "HBA_" + _cond.getFilterKey() + " = '" + _cond.getFilterValue() + "' ");
        }

        return sql.toString();
    }

    /**
     * 汎用マスタ(データ)の削除
     *
     * @param cond 削除条件
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public boolean deleteMasterDataByCondition(MasterCondition cond) throws KKHException {
        //パラメータチェック
        if (cond == null) {
            throw new KKHException("削除エラー", "BD-E0003");
        }

        try {
            _cond = cond;
            super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }

        return true;
    }

}