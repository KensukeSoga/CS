package jp.co.isid.kkh.customer.lion.model.master;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB9WLTVB;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class FindTvMastDAO extends AbstractRdbDao  {

    /**テレビ番組マスタ検索条件 */
    private FindTvMastCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public FindTvMastDAO() {
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
                TBTHB9WLTVB.EGCD,
                TBTHB9WLTVB.TKSKGYCD,
                TBTHB9WLTVB.TKSBMNSEQNO,
                TBTHB9WLTVB.TKSTNTSEQNO,
                TBTHB9WLTVB.BANCD,
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
        return TBTHB9WLTVB.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB9WLTVB.TRKTIMSTMP,
                TBTHB9WLTVB.TRKPL,
                TBTHB9WLTVB.TRKTNT,
                TBTHB9WLTVB.UPDTIMSTMP,
                TBTHB9WLTVB.UPDAPL,
                TBTHB9WLTVB.UPDTNT,
                TBTHB9WLTVB.EGCD,
                TBTHB9WLTVB.TKSKGYCD,
                TBTHB9WLTVB.TKSBMNSEQNO,
                TBTHB9WLTVB.TKSTNTSEQNO,
                TBTHB9WLTVB.BANCD,
                TBTHB9WLTVB.BANNAME,
                TBTHB9WLTVB.HKYOKUCD,
                TBTHB9WLTVB.SEISAKUHI,
                TBTHB9WLTVB.HYOJIJYUN,
                TBTHB9WLTVB.TANKA,
                TBTHB9WLTVB.TYPE2
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
        sql.append("  " + TBTHB9WLTVB.TRKTIMSTMP + " ");
        sql.append(" ," + TBTHB9WLTVB.TRKPL + " ");
        sql.append(" ," + TBTHB9WLTVB.TRKTNT + " ");
        sql.append(" ," + TBTHB9WLTVB.UPDTIMSTMP + " ");
        sql.append(" ," + TBTHB9WLTVB.UPDAPL + " ");
        sql.append(" ," + TBTHB9WLTVB.UPDTNT + " ");
        sql.append(" ," + TBTHB9WLTVB.EGCD + " ");
        sql.append(" ," + TBTHB9WLTVB.TKSKGYCD + " ");
        sql.append(" ," + TBTHB9WLTVB.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHB9WLTVB.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHB9WLTVB.BANCD + " ");
        sql.append(" ," + TBTHB9WLTVB.BANNAME + " ");
        sql.append(" ," + TBTHB9WLTVB.HKYOKUCD + " ");
        sql.append(" ," + TBTHB9WLTVB.SEISAKUHI + " ");
        sql.append(" ," + TBTHB9WLTVB.HYOJIJYUN + " ");
        sql.append(" ," + TBTHB9WLTVB.TANKA + " ");
        sql.append(" ," + TBTHB9WLTVB.TYPE2 + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHB9WLTVB.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(TBTHB9WLTVB.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append(TBTHB9WLTVB.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append(TBTHB9WLTVB.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append(TBTHB9WLTVB.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  ");
        //番組コード検索用
        if (_cond.getBancd().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB9WLTVB.BANCD  + " = '" + _cond.getBancd()  + "' ");
        }
        //番組名称検索用
        if (_cond.getBanname().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB9WLTVB.BANNAME  + " = '" + _cond.getBanname()  + "' ");
        }
        //番組局誌ＣＤ検索用
        if (_cond.getHkyokucd().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB9WLTVB.HKYOKUCD  + " = '" + _cond.getHkyokucd()  + "' ");
        }
        //単価区分検索用
        if (_cond.getTanka().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB9WLTVB.TANKA  + " = '" + _cond.getTanka()  + "' ");
        }
        //ＴＹＰＥ２検索用
        if (_cond.getType2().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB9WLTVB.TYPE2  + " = '" + _cond.getType2()  + "' ");
        }

        sql.append("  ORDER BY ");
        sql.append(TBTHB9WLTVB.HYOJIJYUN);

        return sql.toString();
    }

    /**
     * TV番組マスタの検索を行います。
     *
     * @return テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<FindTvMastVO> findTvMastByCondition(FindTvMastCondition cond) throws KKHException {

        super.setModel(new FindTvMastVO());

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
    protected List<FindTvMastVO> createFindedModelInstances(List hashList) {
        List<FindTvMastVO> list = new ArrayList<FindTvMastVO>();
        if (getModel() instanceof FindTvMastVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindTvMastVO vo = new FindTvMastVO();
                vo.setTrktimstmp((Date)result.get(TBTHB9WLTVB.TRKTIMSTMP.toUpperCase()));
                vo.setTrkpl((String)result.get(TBTHB9WLTVB.TRKPL.toUpperCase()));
                vo.setTrktnt((String)result.get(TBTHB9WLTVB.TRKTNT.toUpperCase()));
                vo.setUpdtimstmp((Date)result.get(TBTHB9WLTVB.UPDTIMSTMP.toUpperCase()));
                vo.setUpdakpl((String)result.get(TBTHB9WLTVB.UPDAPL.toUpperCase()));
                vo.setUpdtnt((String)result.get(TBTHB9WLTVB.UPDTNT.toUpperCase()));
                vo.setEgcd((String)result.get(TBTHB9WLTVB.EGCD.toUpperCase()));
                vo.setTkskgycd((String)result.get(TBTHB9WLTVB.TKSKGYCD.toUpperCase()));
                vo.setTksbmnseqno((String)result.get(TBTHB9WLTVB.TKSBMNSEQNO.toUpperCase()));
                vo.setTkstntseqno((String)result.get(TBTHB9WLTVB.TKSTNTSEQNO.toUpperCase()));
                vo.setBancd((String)result.get(TBTHB9WLTVB.BANCD.toUpperCase()));
                vo.setBanname((String)result.get(TBTHB9WLTVB.BANNAME.toUpperCase()));
                vo.setHkyokucd((String)result.get(TBTHB9WLTVB.HKYOKUCD.toUpperCase()));
                vo.setSeisakuhi((BigDecimal)result.get(TBTHB9WLTVB.SEISAKUHI.toUpperCase()));
                vo.setHyojijyun((String)result.get(TBTHB9WLTVB.HYOJIJYUN.toUpperCase()));
                vo.setTanka((String)result.get(TBTHB9WLTVB.TANKA.toUpperCase()));
                vo.setType2((String)result.get(TBTHB9WLTVB.TYPE2.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
