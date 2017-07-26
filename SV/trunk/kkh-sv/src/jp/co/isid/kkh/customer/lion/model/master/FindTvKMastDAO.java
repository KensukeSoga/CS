package jp.co.isid.kkh.customer.lion.model.master;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB11WLTVK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class FindTvKMastDAO extends AbstractRdbDao  {

    /**テレビ局マスタ検索条件 */
    private FindTvKMastCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public FindTvKMastDAO() {
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
                TBTHB11WLTVK.EGCD,
                TBTHB11WLTVK.TKSKGYCD,
                TBTHB11WLTVK.TKSBMNSEQNO,
                TBTHB11WLTVK.TKSTNTSEQNO,
                TBTHB11WLTVK.KYOKUCD,
        };
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
    @Override
    public String getTableName() {
        return TBTHB11WLTVK.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB11WLTVK.TRKTIMSTMP,
                TBTHB11WLTVK.TRKPL,
                TBTHB11WLTVK.TRKTNT,
                TBTHB11WLTVK.UPDTIMSTMP,
                TBTHB11WLTVK.UPDAPL,
                TBTHB11WLTVK.UPDTNT,
                TBTHB11WLTVK.EGCD,
                TBTHB11WLTVK.TKSKGYCD,
                TBTHB11WLTVK.TKSBMNSEQNO,
                TBTHB11WLTVK.TKSTNTSEQNO,
                TBTHB11WLTVK.KYOKUCD,
                TBTHB11WLTVK.KYOKUNAME,
                TBTHB11WLTVK.KIGOU,
                TBTHB11WLTVK.KEIRETSU,
                TBTHB11WLTVK.TIKU,
                TBTHB11WLTVK.THYOJIJYUN,
                TBTHB11WLTVK.HYOJIJYUN
        };
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
        return getSelectSQLForItem();
    }

    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHB11WLTVK.TRKTIMSTMP + " ");
        sql.append(" ," + TBTHB11WLTVK.TRKPL + " ");
        sql.append(" ," + TBTHB11WLTVK.TRKTNT + " ");
        sql.append(" ," + TBTHB11WLTVK.UPDTIMSTMP + " ");
        sql.append(" ," + TBTHB11WLTVK.UPDAPL + " ");
        sql.append(" ," + TBTHB11WLTVK.UPDTNT + " ");
        sql.append(" ," + TBTHB11WLTVK.EGCD + " ");
        sql.append(" ," + TBTHB11WLTVK.TKSKGYCD + " ");
        sql.append(" ," + TBTHB11WLTVK.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHB11WLTVK.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHB11WLTVK.KYOKUCD + " ");
        sql.append(" ," + TBTHB11WLTVK.KYOKUNAME + " ");
        sql.append(" ," + TBTHB11WLTVK.KIGOU + " ");
        sql.append(" ," + TBTHB11WLTVK.KEIRETSU + " ");
        sql.append(" ," + TBTHB11WLTVK.TIKU + " ");
        sql.append(" ," + TBTHB11WLTVK.THYOJIJYUN + " ");
        sql.append(" ," + TBTHB11WLTVK.HYOJIJYUN + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHB11WLTVK.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(TBTHB11WLTVK.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append(TBTHB11WLTVK.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append(TBTHB11WLTVK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append(TBTHB11WLTVK.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  ");
        //局コード検索用
        if (_cond.getKyokucd().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB11WLTVK.KYOKUCD  + " = '" + _cond.getKyokucd()  + "' ");
        }
        //記号検索用
        if (_cond.getKigou().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB11WLTVK.KIGOU  + " = '" + _cond.getKigou()  + "' ");
        }
        //系列検索用
        if (_cond.getKeiretsu().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB11WLTVK.KEIRETSU  + " = '" + _cond.getKeiretsu()  + "' ");
        }
        //地区検索用
        if (_cond.getTiku().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB11WLTVK.TIKU  + " = '" + _cond.getTiku()  + "' ");
        }

        sql.append("  ORDER BY ");
        sql.append(TBTHB11WLTVK.THYOJIJYUN + ", ");
        sql.append(TBTHB11WLTVK.HYOJIJYUN);

        return sql.toString();
    }

    /**
     * TV局マスタの検索を行います。
     *
     * @return テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<FindTvKMastVO> findTvKMastByCondition(FindTvKMastCondition cond) throws KKHException {

        super.setModel(new FindTvKMastVO());

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
    protected List<FindTvKMastVO> createFindedModelInstances(List hashList) {
        List<FindTvKMastVO> list = new ArrayList<FindTvKMastVO>();
        if (getModel() instanceof FindTvKMastVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindTvKMastVO vo = new FindTvKMastVO();
                vo.setTrktimstmp((Date)result.get(TBTHB11WLTVK.TRKTIMSTMP.toUpperCase()));
                vo.setTrkpl((String)result.get(TBTHB11WLTVK.TRKPL.toUpperCase()));
                vo.setTrktnt((String)result.get(TBTHB11WLTVK.TRKTNT.toUpperCase()));
                vo.setUpdtimstmp((Date)result.get(TBTHB11WLTVK.UPDTIMSTMP.toUpperCase()));
                vo.setUpdakpl((String)result.get(TBTHB11WLTVK.UPDAPL.toUpperCase()));
                vo.setUpdtnt((String)result.get(TBTHB11WLTVK.UPDTNT.toUpperCase()));
                vo.setEgcd((String)result.get(TBTHB11WLTVK.EGCD.toUpperCase()));
                vo.setTkskgycd((String)result.get(TBTHB11WLTVK.TKSKGYCD.toUpperCase()));
                vo.setTksbmnseqno((String)result.get(TBTHB11WLTVK.TKSBMNSEQNO.toUpperCase()));
                vo.setTkstntseqno((String)result.get(TBTHB11WLTVK.TKSTNTSEQNO.toUpperCase()));
                vo.setKyokuCd((String)result.get(TBTHB11WLTVK.KYOKUCD.toUpperCase()));
                vo.setKyokuName((String)result.get(TBTHB11WLTVK.KYOKUNAME.toUpperCase()));
                vo.setKigou((String)result.get(TBTHB11WLTVK.KIGOU.toUpperCase()));
                vo.setKeiretsu((String)result.get(TBTHB11WLTVK.KEIRETSU.toUpperCase()));
                vo.setTiku((String)result.get(TBTHB11WLTVK.TIKU.toUpperCase()));
                vo.setTHyojiJyun((String)result.get(TBTHB11WLTVK.THYOJIJYUN.toUpperCase()));
                vo.setHyojijyun((String)result.get(TBTHB11WLTVK.HYOJIJYUN.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
