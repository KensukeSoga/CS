package jp.co.isid.kkh.customer.lion.model.master;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB10WLRDB;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class FindRdMastDAO extends AbstractRdbDao  {

    /**ラジオ番組マスタ検索条件 */
    private FindRdMastCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public FindRdMastDAO() {
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
                TBTHB10WLRDB.EGCD,
                TBTHB10WLRDB.TKSKGYCD,
                TBTHB10WLRDB.TKSBMNSEQNO,
                TBTHB10WLRDB.TKSTNTSEQNO,
                TBTHB10WLRDB.BANCD,
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
        return TBTHB10WLRDB.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB10WLRDB.TRKTIMSTMP,
                TBTHB10WLRDB.TRKPL,
                TBTHB10WLRDB.TRKTNT,
                TBTHB10WLRDB.UPDTIMSTMP,
                TBTHB10WLRDB.UPDAPL,
                TBTHB10WLRDB.UPDTNT,
                TBTHB10WLRDB.EGCD,
                TBTHB10WLRDB.TKSKGYCD,
                TBTHB10WLRDB.TKSBMNSEQNO,
                TBTHB10WLRDB.TKSTNTSEQNO,
                TBTHB10WLRDB.BANCD,
                TBTHB10WLRDB.BANNAME,
                TBTHB10WLRDB.HKYOKUCD,
                TBTHB10WLRDB.SEISAKUHI,
                TBTHB10WLRDB.HYOJIJYUN,
                TBTHB10WLRDB.TANKA,
                TBTHB10WLRDB.TYPE2
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
        sql.append("  " + TBTHB10WLRDB.TRKTIMSTMP + " ");
        sql.append(" ," + TBTHB10WLRDB.TRKPL + " ");
        sql.append(" ," + TBTHB10WLRDB.TRKTNT + " ");
        sql.append(" ," + TBTHB10WLRDB.UPDTIMSTMP + " ");
        sql.append(" ," + TBTHB10WLRDB.UPDAPL + " ");
        sql.append(" ," + TBTHB10WLRDB.UPDTNT + " ");
        sql.append(" ," + TBTHB10WLRDB.EGCD + " ");
        sql.append(" ," + TBTHB10WLRDB.TKSKGYCD + " ");
        sql.append(" ," + TBTHB10WLRDB.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHB10WLRDB.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHB10WLRDB.BANCD + " ");
        sql.append(" ," + TBTHB10WLRDB.BANNAME + " ");
        sql.append(" ," + TBTHB10WLRDB.HKYOKUCD + " ");
        sql.append(" ," + TBTHB10WLRDB.SEISAKUHI + " ");
        sql.append(" ," + TBTHB10WLRDB.HYOJIJYUN + " ");
        sql.append(" ," + TBTHB10WLRDB.TANKA + " ");
        sql.append(" ," + TBTHB10WLRDB.TYPE2 + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHB10WLRDB.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(TBTHB10WLRDB.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append(TBTHB10WLRDB.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append(TBTHB10WLRDB.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append(TBTHB10WLRDB.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  ");
        //番組コード検索用
        if (_cond.getBancd().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB10WLRDB.BANCD  + " = '" + _cond.getBancd()  + "' ");
        }
        //番組名称検索用
        if (_cond.getBanname().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB10WLRDB.BANNAME  + " = '" + _cond.getBanname()  + "' ");
        }
        //番組局誌ＣＤ検索用
        if (_cond.getHkyokucd().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB10WLRDB.HKYOKUCD  + " = '" + _cond.getHkyokucd()  + "' ");
        }
        //単価区分検索用
        if (_cond.getTanka().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB10WLRDB.TANKA  + " = '" + _cond.getTanka()  + "' ");
        }
        //ＴＹＰＥ２検索用
        if (_cond.getType2().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB10WLRDB.TYPE2  + " = '" + _cond.getType2()  + "' ");
        }

        sql.append("  ORDER BY ");
        sql.append(TBTHB10WLRDB.HYOJIJYUN);

        return sql.toString();
    }

    /**
     * ラジオ番組マスタの検索を行います。
     *
     * @return テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<FindRdMastVO> findRdMastByCondition(FindRdMastCondition cond) throws KKHException {

        super.setModel(new FindRdMastVO());

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
    protected List<FindRdMastVO> createFindedModelInstances(List hashList) {
        List<FindRdMastVO> list = new ArrayList<FindRdMastVO>();
        if (getModel() instanceof FindRdMastVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindRdMastVO vo = new FindRdMastVO();
                vo.setTrktimstmp((Date)result.get(TBTHB10WLRDB.TRKTIMSTMP.toUpperCase()));
                vo.setTrkpl((String)result.get(TBTHB10WLRDB.TRKPL.toUpperCase()));
                vo.setTrktnt((String)result.get(TBTHB10WLRDB.TRKTNT.toUpperCase()));
                vo.setUpdtimstmp((Date)result.get(TBTHB10WLRDB.UPDTIMSTMP.toUpperCase()));
                vo.setUpdakpl((String)result.get(TBTHB10WLRDB.UPDAPL.toUpperCase()));
                vo.setUpdtnt((String)result.get(TBTHB10WLRDB.UPDTNT.toUpperCase()));
                vo.setEgcd((String)result.get(TBTHB10WLRDB.EGCD.toUpperCase()));
                vo.setTkskgycd((String)result.get(TBTHB10WLRDB.TKSKGYCD.toUpperCase()));
                vo.setTksbmnseqno((String)result.get(TBTHB10WLRDB.TKSBMNSEQNO.toUpperCase()));
                vo.setTkstntseqno((String)result.get(TBTHB10WLRDB.TKSTNTSEQNO.toUpperCase()));
                vo.setBancd((String)result.get(TBTHB10WLRDB.BANCD.toUpperCase()));
                vo.setBanname((String)result.get(TBTHB10WLRDB.BANNAME.toUpperCase()));
                vo.setHkyokucd((String)result.get(TBTHB10WLRDB.HKYOKUCD.toUpperCase()));
                vo.setSeisakuhi((BigDecimal)result.get(TBTHB10WLRDB.SEISAKUHI.toUpperCase()));
                vo.setHyojijyun((String)result.get(TBTHB10WLRDB.HYOJIJYUN.toUpperCase()));
                vo.setTanka((String)result.get(TBTHB10WLRDB.TANKA.toUpperCase()));
                vo.setType2((String)result.get(TBTHB10WLRDB.TYPE2.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
