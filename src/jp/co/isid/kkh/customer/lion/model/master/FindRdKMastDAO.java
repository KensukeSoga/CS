package jp.co.isid.kkh.customer.lion.model.master;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB12WLRDK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class FindRdKMastDAO extends AbstractRdbDao  {

    /** ラジオ局マスタ検索条件 */
    private FindRdKMastCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public FindRdKMastDAO() {
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
                TBTHB12WLRDK.EGCD,
                TBTHB12WLRDK.TKSKGYCD,
                TBTHB12WLRDK.TKSBMNSEQNO,
                TBTHB12WLRDK.TKSTNTSEQNO,
                TBTHB12WLRDK.KYOKUCD,
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
        return TBTHB12WLRDK.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB12WLRDK.TRKTIMSTMP,
                TBTHB12WLRDK.TRKPL,
                TBTHB12WLRDK.TRKTNT,
                TBTHB12WLRDK.UPDTIMSTMP,
                TBTHB12WLRDK.UPDAPL,
                TBTHB12WLRDK.UPDTNT,
                TBTHB12WLRDK.EGCD,
                TBTHB12WLRDK.TKSKGYCD,
                TBTHB12WLRDK.TKSBMNSEQNO,
                TBTHB12WLRDK.TKSTNTSEQNO,
                TBTHB12WLRDK.KYOKUCD,
                TBTHB12WLRDK.KYOKUNAME,
                TBTHB12WLRDK.KIGOU,
                TBTHB12WLRDK.KEIRETSU,
                TBTHB12WLRDK.HYOJIJYUN
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
        sql.append("  " + TBTHB12WLRDK.TRKTIMSTMP + " ");
        sql.append(" ," + TBTHB12WLRDK.TRKPL + " ");
        sql.append(" ," + TBTHB12WLRDK.TRKTNT + " ");
        sql.append(" ," + TBTHB12WLRDK.UPDTIMSTMP + " ");
        sql.append(" ," + TBTHB12WLRDK.UPDAPL + " ");
        sql.append(" ," + TBTHB12WLRDK.UPDTNT + " ");
        sql.append(" ," + TBTHB12WLRDK.EGCD + " ");
        sql.append(" ," + TBTHB12WLRDK.TKSKGYCD + " ");
        sql.append(" ," + TBTHB12WLRDK.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHB12WLRDK.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHB12WLRDK.KYOKUCD + " ");
        sql.append(" ," + TBTHB12WLRDK.KYOKUNAME + " ");
        sql.append(" ," + TBTHB12WLRDK.KIGOU + " ");
        sql.append(" ," + TBTHB12WLRDK.KEIRETSU + " ");
        sql.append(" ," + TBTHB12WLRDK.HYOJIJYUN + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHB12WLRDK.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(TBTHB12WLRDK.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append(TBTHB12WLRDK.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append(TBTHB12WLRDK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append(TBTHB12WLRDK.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  ");
        //局コード検索用
        if (_cond.getKyokucd().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB12WLRDK.KYOKUCD  + " = '" + _cond.getKyokucd()  + "' ");
        }
        //記号検索用
        if (_cond.getKigou().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB12WLRDK.KIGOU  + " = '" + _cond.getKigou()  + "' ");
        }
        //系列検索用
        if (_cond.getKeiretsu().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB12WLRDK.KEIRETSU  + " = '" + _cond.getKeiretsu()  + "' ");
        }

        sql.append("  ORDER BY ");
        sql.append(TBTHB12WLRDK.HYOJIJYUN);

        return sql.toString();
    }

    /**
     * ラジオ局マスタの検索を行います。
     *
     * @return テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<FindRdKMastVO> findRdKMastByCondition(FindRdKMastCondition cond) throws KKHException {

        super.setModel(new FindRdKMastVO());

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
    protected List<FindRdKMastVO> createFindedModelInstances(List hashList) {
        List<FindRdKMastVO> list = new ArrayList<FindRdKMastVO>();
        if (getModel() instanceof FindRdKMastVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindRdKMastVO vo = new FindRdKMastVO();
                vo.setTrktimstmp((Date)result.get(TBTHB12WLRDK.TRKTIMSTMP.toUpperCase()));
                vo.setTrkpl((String)result.get(TBTHB12WLRDK.TRKPL.toUpperCase()));
                vo.setTrktnt((String)result.get(TBTHB12WLRDK.TRKTNT.toUpperCase()));
                vo.setUpdtimstmp((Date)result.get(TBTHB12WLRDK.UPDTIMSTMP.toUpperCase()));
                vo.setUpdakpl((String)result.get(TBTHB12WLRDK.UPDAPL.toUpperCase()));
                vo.setUpdtnt((String)result.get(TBTHB12WLRDK.UPDTNT.toUpperCase()));
                vo.setEgcd((String)result.get(TBTHB12WLRDK.EGCD.toUpperCase()));
                vo.setTkskgycd((String)result.get(TBTHB12WLRDK.TKSKGYCD.toUpperCase()));
                vo.setTksbmnseqno((String)result.get(TBTHB12WLRDK.TKSBMNSEQNO.toUpperCase()));
                vo.setTkstntseqno((String)result.get(TBTHB12WLRDK.TKSTNTSEQNO.toUpperCase()));
                vo.setKyokuCd((String)result.get(TBTHB12WLRDK.KYOKUCD.toUpperCase()));
                vo.setKyokuName((String)result.get(TBTHB12WLRDK.KYOKUNAME.toUpperCase()));
                vo.setKigou((String)result.get(TBTHB12WLRDK.KIGOU.toUpperCase()));
                vo.setKeiretsu((String)result.get(TBTHB12WLRDK.KEIRETSU.toUpperCase()));
                vo.setHyojijyun((String)result.get(TBTHB12WLRDK.HYOJIJYUN.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
