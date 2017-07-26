package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterVO;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 発注データ登録DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/6 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
public class FindSyouhinNameGetDAO extends AbstractSimpleRdbDao  {

//	private FindMeisaiDataCondition _vo;
    private FindSyohinNameGetCond _cond;
     /** getSelectSQLで発行するSQLのモード() */
    private enum SqlMode{COMMON,};
    private SqlMode _sqlMode = SqlMode.COMMON;

    /**
     * デフォルトコンストラクタ。
     */
    public FindSyouhinNameGetDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * プライマリキーを返します。
     *
     * @return String[] プライマリキー
     */
    @Override
    public String[] getPrimryKeyNames() {
        return new String[]{
                TBTHB2KMEI.EGCD,
                TBTHB2KMEI.TKSKGYCD,
                TBTHB2KMEI.TKSBMNSEQNO,
                TBTHB2KMEI.TKSTNTSEQNO,
                TBTHB2KMEI.YYMM,
                TBTHB2KMEI.JYUTNO,
                TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO,
                TBTHB2KMEI.RENBN
        };
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
        return TBTHB2KMEI.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB2KMEI.NEBHNFLG
        };
    }

    /**
     * 実施NO自動UP/DOWNの登録を行います。
     *
     * @param vo VO 実施NoVO
     * @throws UserException データアクセス中にエラーが発生した場合
     */
//    public void findThb2Kmei(FindMeisaiDataCondition vo) throws KKHException {
//        //パラメータチェック
//        if (vo == null) {
//            throw new KKHException("登録エラー", "BD-E0002");
//        }
//        //super.setModel(vo);
//        _vo = vo;
//
//        try {
//          super.exec();
//        } catch (UserException e) {
//            throw new KKHException(e.getMessage(), "BD-E0002");
//        }
//    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public  String getSelectSQL() {
        if (_sqlMode.equals(SqlMode.COMMON)){
            return getExecString();
        }
        return "";
    }

    /**
     * EXEC-SQL生成
     */
    @Override
    public String getExecString() {
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append(" " + TBTHBAMST.FIELD2+ " ");
        sql.append(" FROM " );
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.get_tksKgyCd() +"' ");
        sql.append( " AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.get_tksBmnSeqNo() +"' ");
        sql.append( " AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.get_tksTntSeqNo() +"' ");
        sql.append( " AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '106' " );
        sql.append( " AND ");
        sql.append(" " + TBTHBAMST.FIELD1+ " = '" + _cond.get_syohinKbn() +"' ");

        return sql.toString();
    }

    /**
     * 広告費明細テーブルの条件指定検索を行います。
     *
     * @return 受注ダウンロードデータVO
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<MasterVO> findsyouhinNameByCond(FindSyohinNameGetCond Cond) throws KKHException {

        super.setModel(new MasterVO());

        try {
            _cond = Cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

}