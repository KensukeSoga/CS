package jp.co.isid.kkh.model.log;


import jp.co.isid.kkh.integ.tbl.TBTHB6LOG;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 汎用ログデータ登録DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/17 IP H.Shimizu)<BR>
 * </P>
 * @author IP H.Shimizu
 */
public class LogRegistDAO extends AbstractSimpleRdbDao  {

    /**
     * デフォルトコンストラクタ。
     */
    public LogRegistDAO() {
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
        return TBTHB6LOG.TRKTIMSTMP;
    }

    /**
     * システム日付で更新する列の定義です
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[] { TBTHB6LOG.TRKTIMSTMP,TBTHB6LOG.UPDTIMSTMP };
    }

    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    public String getTableName() {
        return TBTHB6LOG.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB6LOG.TRKTIMSTMP
                ,TBTHB6LOG.TRKPL
                ,TBTHB6LOG.TRKTNT
                ,TBTHB6LOG.UPDTIMSTMP
                ,TBTHB6LOG.UPDAPL
                ,TBTHB6LOG.UPDTNT
                ,TBTHB6LOG.EGCD
                ,TBTHB6LOG.TKSKGYCD
                ,TBTHB6LOG.TKSBMNSEQNO
                ,TBTHB6LOG.TKSTNTSEQNO
                ,TBTHB6LOG.SYBT
                ,TBTHB6LOG.KINOID
                ,TBTHB6LOG.KBN
                ,TBTHB6LOG.DESC
                ,TBTHB6LOG.ERRDESC
                ,TBTHB6LOG.UPDDATE
                ,TBTHB6LOG.TANNAME
                ,TBTHB6LOG.RECEPTIONKIND
                ,TBTHB6LOG.STATUS
        };
    }



    /**
     * 汎用ログデータの登録を行います。
     *
     * @param volist VO 汎用ログデータVO
     * @throws UserException データアクセス中にエラーが発生した場合
     */
    public void registLog(LogVO volist) throws KKHException {
        //パラメータチェック
        if (volist == null) {
            throw new KKHException("登録エラー", "BD-E0003");
        }
        super.setModel(volist);
        try {
            if (!super.insert()) {
                throw new KKHException("登録エラー", "BD-E0003");
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }
}