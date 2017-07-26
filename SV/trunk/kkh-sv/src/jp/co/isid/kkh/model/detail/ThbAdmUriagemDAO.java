package jp.co.isid.kkh.model.detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.VWTHB_ADMURIAGEM;
import jp.co.isid.kkh.integ.util.ECPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class ThbAdmUriagemDAO extends AbstractRdbDao {

    /** 広告費明細用売上明細VIEW検索条件 */
    private ThbAdmUriagemCondition _cond;

//    /** getSelectSQLで発行するSQLのモード() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * デフォルトコンストラクタ。
     */
    public ThbAdmUriagemDAO() {
        super.setPoolConnectClass(ECPoolConnect.class);
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
        return "";
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[] {};
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append(" " + VWTHB_ADMURIAGEM.ATEGSYOCD + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.TKSKGYCD + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.TKSBMNSEQNO + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.TKSTNTSEQNO + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.JYUTNO + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.JYMEISEQ + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.URMEISEQ + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.SEIKJTAI + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.SEISAGSTS + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.STPKBN + " ");
        sql.append(" FROM ");
        sql.append(" " + VWTHB_ADMURIAGEM.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + VWTHB_ADMURIAGEM.ATEGSYOCD + " = '" + _cond.getAtEgsyoCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTHB_ADMURIAGEM.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTHB_ADMURIAGEM.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTHB_ADMURIAGEM.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTHB_ADMURIAGEM.JYUTNO + " = '" + _cond.getJyutNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTHB_ADMURIAGEM.JYMEISEQ + " = '" + _cond.getJyMeiSeq() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTHB_ADMURIAGEM.URMEISEQ + " = '" + _cond.getUrMeiSeq() + "' ");

        return sql.toString();
    }

    /**
     * 広告費明細用売上明細VIEWの検索を行います。
     *
     * @return 広告費明細用売上明細VIEWVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ThbAdmUriagemVO> getAdmUriagemViewData(ThbAdmUriagemCondition cond) throws KKHException {

        super.setModel(new ThbAdmUriagemVO());

        try {
            _cond = cond;
//            _sqlMode = SqlMode.COND;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "HB-E0001");
        }
    }

    /**
     * Modelの生成を行う<br>
     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
     *
     * @param hashList List 検索結果
     * @return List<ThbAdmUriagemVO> 変換後の検索結果
     */
    @Override
    protected List<ThbAdmUriagemVO> createFindedModelInstances(List hashList) {

        List<ThbAdmUriagemVO> list = new ArrayList<ThbAdmUriagemVO>();
        if (getModel() instanceof ThbAdmUriagemVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ThbAdmUriagemVO vo = new ThbAdmUriagemVO();
                vo.setResultKey(StringUtil.trim((String) result.get("RESULTKEY")));
                vo.setSeikJtai(StringUtil.trim((String) result.get(VWTHB_ADMURIAGEM.SEIKJTAI.toUpperCase())));
                vo.setSeiSagSts(StringUtil.trim((String) result.get(VWTHB_ADMURIAGEM.SEISAGSTS.toUpperCase())));
                vo.setStpKbn(StringUtil.trim((String) result.get(VWTHB_ADMURIAGEM.STPKBN.toUpperCase())));
                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
