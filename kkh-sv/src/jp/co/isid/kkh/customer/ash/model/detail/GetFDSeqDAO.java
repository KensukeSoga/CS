package jp.co.isid.kkh.customer.ash.model.detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;

/**
 *
 * <P>
 * 広告費明細検索(アサヒ)DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class GetFDSeqDAO extends AbstractRdbDao {

    /**受注データ検索条件 */
    private GetFDSeqCondition _cond;

    /** getSelectSQLで発行するSQLのモード() */
    private enum SqlMode{FDSEQ,};
    private SqlMode _sqlMode = SqlMode.FDSEQ;

    /**
     * デフォルトコンストラクタ。
     */
    public GetFDSeqDAO() {
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
        //new String[] {};
        return null;
    }

    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    public String getTableName() {
        return "";
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
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {

        StringBuffer sql = new StringBuffer();

        if (_sqlMode.equals(SqlMode.FDSEQ)){
            sql.append(" SELECT ");
            sql.append("     NVL(REPLACE(MAX(RTRIM(" + TBTHB2KMEI.SONOTA9 +")),0),0) AS " + TBTHB2KMEI.SONOTA9 + " ");        //FD明細SEQ
            sql.append(" FROM ");
            sql.append("     " + TBTHB2KMEI.TBNAME + " ");   //広告費明細テーブル
            sql.append("    ," + TBTHB1DOWN.TBNAME + " ");   //ダウンロードテーブル
            sql.append(" WHERE ");
            sql.append("     " + TBTHB1DOWN.EGCD        + " = '" + _cond.getEgCd() + "'");    //営業所コード
            sql.append(" and " + TBTHB1DOWN.TKSKGYCD    + " = '" + _cond.getTksKgyCd() + "' ");          //得意先コード
            sql.append(" and " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");     //得意先部門SEQNO
            sql.append(" and " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");     //得意先担当SEQNO
            sql.append(" and " + TBTHB1DOWN.YYMM        + " = '" + _cond.getYymm() + "'");             //年月
            sql.append(" and " + TBTHB1DOWN.TJYUTNO     + " = ' '");
            sql.append(" and " + TBTHB2KMEI.EGCD        + " = " + TBTHB1DOWN.EGCD + " ");       //営業所
            sql.append(" and " + TBTHB2KMEI.TKSKGYCD    + " = " + TBTHB1DOWN.TKSKGYCD + " ");   //得意先コード
            sql.append(" and " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " ");//得意先部門SEQNO
            sql.append(" and " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " ");//得意先担当SEQNO
            sql.append(" and " + TBTHB2KMEI.YYMM        + " = " + TBTHB1DOWN.YYMM + " ");       //年月
            sql.append(" and " + TBTHB2KMEI.JYUTNO      + " = " + TBTHB1DOWN.JYUTNO + " ");     //受注No
            sql.append(" and " + TBTHB2KMEI.JYMEINO     + " = " + TBTHB1DOWN.JYMEINO + " ");    //受注明細No
            sql.append(" and " + TBTHB2KMEI.URMEINO     + " = " + TBTHB1DOWN.URMEINO + " ");    //売上明細No
            sql.append(" and " + TBTHB2KMEI.JYUTNO      + " <> ' '");
            sql.append(" and " + TBTHB2KMEI.NAME3       + " like '" + _cond.getUrMeiNo() + "%' ");  //売上明細No（2008040001-001）
        }

        return sql.toString();
    }

    /**
     * 広告費明細データの検索を行います。
     *
     * @return 広告費明細データVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<String> getFDSeq(GetFDSeqCondition cond) throws KKHException {

        super.setModel(new GetFDSeqVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.FDSEQ;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * Modelの生成を行う<br>
     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
     *
     * @param hashList List 検索結果
     * @return List<DetailDataVO> 変換後の検索結果
     */
    @Override
    @SuppressWarnings("unchecked")
    //protected List<DetailDataVO> createFindedModelInstances(List hashList) {
    protected List createFindedModelInstances(List hashList) {
        List list = null;
        if (_sqlMode == SqlMode.FDSEQ){
            list = new ArrayList<String>();
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                list.add((String)result.get(TBTHB2KMEI.SONOTA9));
            }
        }

        return list;
    }

}
