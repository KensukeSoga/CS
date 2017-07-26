package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

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
public class FindHatyuConfirmDAO extends AbstractRdbDao  {

    private FindHatyuNumByCondVO _cond;
    //private Thb5HikVO _cond;
     /** getSelectSQLで発行するSQLのモード() */
    private enum SqlMode{COMMON,};
    private SqlMode _sqlMode = SqlMode.COMMON;

    /**
     * デフォルトコンストラクタ。
     */
    public FindHatyuConfirmDAO() {
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
        // TODO 自動生成されたメソッド・スタブ
        return new String[]{
                TBTHB5HIK.TKSKGYCD,
                TBTHB5HIK.TKSBMNSEQNO,
                TBTHB5HIK.TKSTNTSEQNO,
                TBTHB5HIK.IRBAN,
                TBTHB5HIK.IRROWBAN
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
        return TBTHB5HIK.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB5HIK.IRBAN
        };
    }

    /**
     * 実施NO自動UP/DOWNの登録を行います。
     *
     * @param vo VO 実施NoVO
     * @throws UserException データアクセス中にエラーが発生した場合
     */
    public void findThb2Kmei(FindHatyuNumByCondVO vo) throws KKHException {

        //パラメータチェック
        if (vo == null) {
            throw new KKHException("登録エラー", "BD-E0002");
        }
        //super.setModel(vo);
        _cond = vo;

        try {
          super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

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
        sql.append(TBTHB5HIK.IRROWBAN + ", ");
        sql.append(" MAX(" + TBTHB5HIK.MEDIANAME + ") AS " + TBTHB5HIK.MEDIANAME  + " ");
        sql.append(" FROM ");
        sql.append(TBTHB5HIK.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" "+ TBTHB5HIK.TKSKGYCD + " =  '" + _cond.get_tksKgyCd() +"' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.get_tksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.get_tksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.IRBAN + " = '" + _cond.get_Irban() + "' ");
        sql.append(" GROUP BY ");
        sql.append(TBTHB5HIK.IRROWBAN + " ");
        sql.append(" ORDER BY ");
        sql.append(TBTHB5HIK.IRROWBAN + " ");

        return sql.toString();
    }

    /**
     * 広告費明細テーブルの条件指定検索を行います。
     *
     * @return 受注ダウンロードデータVO
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<HikVO> findThb5HikByCondCmn(FindHatyuNumByCondVO Cond) throws KKHException {

        // TODO THB5HIKテーブルに同項目なし
        super.setModel(new HikVO());

        try {
            _cond = Cond;
//        	_selSqlMode = SelSqlMode.COND_CMN;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    @Override
    protected List<HikVO> createFindedModelInstances(List hashList) {
        List<HikVO> list = new ArrayList<HikVO>();
        if (getModel() instanceof HikVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                HikVO vo = new HikVO();
                vo.setIrrowban((String) result.get(TBTHB5HIK.IRROWBAN.toUpperCase()));				//依頼行番号
                vo.setMediaName((String) result.get( TBTHB5HIK.MEDIANAME.toUpperCase()));				//メディアコード

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}