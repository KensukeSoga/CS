package jp.co.isid.kkh.customer.lion.model.master;


import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterDataInsertVO;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 雑誌スペース料金マスタデータ登録DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/03/07 JSE A.Naito)<BR>
 * </P>
 * @author JSE A.Naito
 */
public class UpdateLionZashiRyoSpcMastDAO extends AbstractSimpleRdbDao {

    /**汎用マスタ(データ)検索条件*/
    private UpdateLionZashiRyoSpcMastCondition _cond;

    //種別//////////////////////////////////////////////////////////////////////////////////////////////////
    /** 汎用マスタ：種別：雑誌 */
    public static final String C_HBAMST_SYBT_ZASHI =  LionConstants.MastBaitaiShubetsu.ZASHI.getCode();
    /** 汎用マスタ：種別：雑誌スペース */
    public static final String C_HBAMST_SYBT_ZASHI_SPACE =  LionConstants.MastBaitaiShubetsu.ZASHI_SPACE.getCode();
    /** 汎用マスタ：種別：料金 */
    public static final String C_HBAMST_SYBT_ZASHI_RYOKIN =  LionConstants.MastBaitaiShubetsu.ZASHI_RYOKIN.getCode();
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * デフォルトコンストラクタ。
     */
    public UpdateLionZashiRyoSpcMastDAO() {
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
    public void insertLionZashiRyoSpcMastVO(MasterDataInsertVO vo) throws KKHException {
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

    /**
     * 削除ＳＱＬ生成
     */
    @Override
    public String getExecString() {
        StringBuffer sql = new StringBuffer();
        if(_cond.getSybt().equals(C_HBAMST_SYBT_ZASHI_RYOKIN)){
            sql.append(" DELETE ");
            sql.append(" FROM ");
            sql.append(" " + TBTHBAMST.TBNAME + " ");
            // Where句
            sql.append(" WHERE ");
            sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(" " + TBTHBAMST.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            sql.append(" " + TBTHBAMST.SYBT + " = '" + _cond.getSybt() + "' AND ");
            sql.append(" " + TBTHBAMST.FIELD1 + " = '" + _cond.getZashiCd() + "' ");
        }

        return sql.toString();
    }

    /**
     * 汎用マスタ(データ)の削除
     *
     * @param cond 削除条件
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public boolean deleteLionZashiRyoSpcMastCondition(UpdateLionZashiRyoSpcMastCondition cond) throws KKHException {
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
