package jp.co.isid.kkh.model.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB6LOG;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * 汎用ログ検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/11 IP H.Shimizu)<BR>
 * </P>
 * @author
 */
public class LogDAO extends AbstractRdbDao {

    /**汎用マスタ検索条件 */
    private LogCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public LogDAO() {
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
        return null;
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
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
            return getSelectSQLForLog();
    }


    private String getSelectSQLForLog(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHB6LOG.TRKTIMSTMP + " ");
        sql.append(" ," + TBTHB6LOG.TRKPL + " ");
        sql.append(" ," + TBTHB6LOG.TRKTNT + " ");
        sql.append(" ," + TBTHB6LOG.UPDTIMSTMP + " ");
        sql.append(" ," + TBTHB6LOG.UPDAPL + " ");
        sql.append(" ," + TBTHB6LOG.UPDTNT + " ");
        sql.append(" ," + TBTHB6LOG.EGCD + " ");
        sql.append(" ," + TBTHB6LOG.TKSKGYCD + " ");
        sql.append(" ," + TBTHB6LOG.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHB6LOG.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHB6LOG.SYBT + " ");
        sql.append(" ," + TBTHB6LOG.KBN + " ");
        sql.append(" ," + TBTHB6LOG.KINOID + " ");
        sql.append(" ," + TBTHB6LOG.DESC + " ");
        sql.append(" ," + TBTHB6LOG.ERRDESC + " ");
        sql.append(" ," + TBTHB6LOG.UPDDATE + " ");
        sql.append(" ," + TBTHB6LOG.TANNAME + " ");
        sql.append(" ," + TBTHB6LOG.RECEPTIONKIND + " ");
        sql.append(" ," + TBTHB6LOG.STATUS + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHB6LOG.TBNAME + " ");
        //Where句
        sql.append(" WHERE ");
        sql.append(" " + TBTHB6LOG.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB6LOG.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB6LOG.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB6LOG.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB6LOG.SYBT + " = '" + _cond.getSybt() + "' ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB6LOG.UPDDATE + " DESC");

        return sql.toString();
    }

    /**
     * 汎用テーブルマスタの検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<LogVO> findLogByCondition(LogCondition cond) throws KKHException {

        super.setModel(new LogVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * Modelの生成を行う<br>
     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
     *
     * @param hashList List 検索結果
     * @return List<CommonCodeMasterVO> 変換後の検索結果
     */
    @Override
    protected List<LogVO> createFindedModelInstances(List hashList) {

        List<LogVO> list = new ArrayList<LogVO>();
        if (getModel() instanceof LogVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                LogVO vo = new LogVO();
                vo.setTrkTimStmp((Date)result.get(TBTHB6LOG.TRKTIMSTMP.toUpperCase()));
                vo.setTrkPl((String)result.get(TBTHB6LOG.TRKPL.toUpperCase()));
                vo.setTrkTnt((String)result.get(TBTHB6LOG.TRKTNT.toUpperCase()));
                vo.setUpdTimStmp((Date)result.get(TBTHB6LOG.UPDTIMSTMP.toUpperCase()));
                vo.setUpdPl((String)result.get(TBTHB6LOG.UPDAPL.toUpperCase()));
                vo.setUpdTnt((String)result.get(TBTHB6LOG.UPDTNT   .toUpperCase()));
                vo.setEgCd((String)result.get(TBTHB6LOG.EGCD.toUpperCase()));
                vo.setTksKgyCd((String)result.get(TBTHB6LOG.TKSKGYCD.toUpperCase()));
                vo.setTksBmnSeqNo((String)result.get(TBTHB6LOG.TKSBMNSEQNO.toUpperCase()));
                vo.setTksTntSeqNo((String)result.get(TBTHB6LOG.TKSTNTSEQNO.toUpperCase()));
                vo.setSybt((String)result.get(TBTHB6LOG.SYBT.toUpperCase()));
                vo.setKinoId((String)result.get(TBTHB6LOG.KINOID.toUpperCase()));
                vo.setKbn((String)result.get(TBTHB6LOG.KBN.toUpperCase()));
                vo.setDesc((String)result.get(TBTHB6LOG.DESC.toUpperCase()));
                vo.setErrDesc((String)result.get(TBTHB6LOG.ERRDESC.toUpperCase()));
                vo.setUpdDate((String)result.get(TBTHB6LOG.UPDDATE.toUpperCase()));
                vo.setTanName((String)result.get(TBTHB6LOG.TANNAME.toUpperCase()));
                vo.setReceptionKind((String)result.get(TBTHB6LOG.RECEPTIONKIND.toUpperCase()));
                vo.setStatus((String)result.get(TBTHB6LOG.STATUS.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
