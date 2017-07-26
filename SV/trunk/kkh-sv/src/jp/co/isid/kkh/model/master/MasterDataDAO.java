package jp.co.isid.kkh.model.master;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.DummyNull;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * 汎用マスタ検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class MasterDataDAO extends AbstractRdbDao {

    /**汎用マスタ(データ)検索条件*/
    private MasterDataCondition _cond;

    /** getSelectSQLで発行するSQLのモード() */
    private enum SqlMode{DATA, UPDTIMSTMP_MAX};
    private SqlMode _sqlMode = SqlMode.DATA;

    /**
     * デフォルトコンストラクタ。
     */
    public MasterDataDAO() {
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
        return TBTHBAMST.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHBAMST.TRKTIMSTMP
                ,TBTHBAMST.TRKPL
                ,TBTHBAMST.TRKTNT
                ,TBTHBAMST.UPDTIMSTMP
                ,TBTHBAMST.UPDAPL
                ,TBTHBAMST.UPDTNT
                ,TBTHBAMST.EGCD
                ,TBTHBAMST.TKSKGYCD
                ,TBTHBAMST.TKSBMNSEQNO
                ,TBTHBAMST.TKSTNTSEQNO
                ,TBTHBAMST.SYBT
                ,TBTHBAMST.FIELD1
                ,TBTHBAMST.FIELD2
                ,TBTHBAMST.FIELD3
                ,TBTHBAMST.FIELD4
                ,TBTHBAMST.FIELD5
                ,TBTHBAMST.FIELD6
                ,TBTHBAMST.FIELD7
                ,TBTHBAMST.FIELD8
                ,TBTHBAMST.FIELD9
                ,TBTHBAMST.FIELD10
                ,TBTHBAMST.FIELD11
                ,TBTHBAMST.FIELD12
                ,TBTHBAMST.FIELD13
                ,TBTHBAMST.FIELD14
                ,TBTHBAMST.FIELD15
                ,TBTHBAMST.FIELD16
                ,TBTHBAMST.FIELD17
                ,TBTHBAMST.FIELD18
                ,TBTHBAMST.FIELD19
                ,TBTHBAMST.FIELD20
                ,TBTHBAMST.INTVALUE1
                ,TBTHBAMST.INTVALUE2
                ,TBTHBAMST.INTVALUE3
                ,TBTHBAMST.INTVALUE4
                ,TBTHBAMST.INTVALUE5
                ,TBTHBAMST.INTVALUE6
                ,TBTHBAMST.INTVALUE7
                ,TBTHBAMST.INTVALUE8
                ,TBTHBAMST.INTVALUE9
                ,TBTHBAMST.INTVALUE10
        };
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {

        if (_sqlMode.equals(SqlMode.DATA)) {
            return getSelectSQLForData();
        } else if (_sqlMode.equals(SqlMode.UPDTIMSTMP_MAX)) {
            return getSelectSQLForUpdTimStmpMax();
        }

        return "";
    }

    private String getSelectSQLForData(){
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHBAMST.TRKTIMSTMP + " ");
        sql.append(" ," + TBTHBAMST.TRKPL + " ");
        sql.append(" ," + TBTHBAMST.TRKTNT + " ");
        sql.append(" ," + TBTHBAMST.UPDTIMSTMP + " ");
        sql.append(" ," + TBTHBAMST.UPDAPL + " ");
        sql.append(" ," + TBTHBAMST.UPDTNT + " ");
        sql.append(" ," + TBTHBAMST.EGCD + " ");
        sql.append(" ," + TBTHBAMST.TKSKGYCD + " ");
        sql.append(" ," + TBTHBAMST.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHBAMST.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHBAMST.SYBT + " ");
        for (int i = 0; i < _cond.getSelectColumns().size(); i++){
            sql.append(" ,HBA_" + _cond.getSelectColumns().get(i) + " AS FIELD" + String.valueOf(i + 1) + " ");
        }
        sql.append(" FROM ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        //Where句
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '" + _cond.getSybt() + "' ");
        // フィルターがある場合
        if (_cond.getFilterKey() != null && _cond.getFilterValue() != null && !_cond.getFilterKey().equals("")) {
            sql.append(" AND ");
            sql.append(" " + "RTRIM(HBA_" + _cond.getFilterKey() + ") = '" + _cond.getFilterValue() + "' ");
        }
        //Order句
        sql.append(" ORDER BY ");
        sql.append(" " + TBTHBAMST.SYBT + " ");//列順
        for (int i = 0; i < _cond.getSortKey().size(); i++){
            if (_cond.getSortKey().get(i) != null && !_cond.getSortKey().get(i).equals("")){
                sql.append(" ,HBA_" + _cond.getSortKey().get(i) + " ");
            }
        }

        return sql.toString();
    }

    /**
     * 汎用マスタ（データ）の更新タイムスタンプ（最大値）取得用ＳＱＬ生成
     */
    private String getSelectSQLForUpdTimStmpMax(){
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  MAX(" + TBTHBAMST.UPDTIMSTMP + ") AS " + TBTHBAMST.UPDTIMSTMP  + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        //Where句
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '" + _cond.getSybt() + "' ");
        // フィルターがある場合
        if (_cond.getFilterKey() != null && _cond.getFilterValue() != null ){//|| _cond.getFilterKey() != "") {
            sql.append(" AND ");
            sql.append(" " + "HBA_" + _cond.getFilterKey() + " = '" + _cond.getFilterValue() + "' ");
        }

        return sql.toString();
    }

    /**
     * 汎用テーブルマスタの検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<MasterDataVO> findMasterDataByCondition(MasterDataCondition cond) throws KKHException {

        super.setModel(new MasterDataVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.DATA;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * 汎用テーブルマスタの更新日付（最大値）を取得
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws KKHException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<MasterDataVO> findMasterUpdTimStmpMaxByCondition(MasterDataCondition cond) throws KKHException {

        super.setModel(new MasterDataVO());

        try {
            _cond = cond;
            _sqlMode = SqlMode.UPDTIMSTMP_MAX;
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
    protected List<MasterDataVO> createFindedModelInstances(List hashList) {
        List<MasterDataVO> list = new ArrayList<MasterDataVO>();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        if (getModel() instanceof MasterDataVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                MasterDataVO vo = new MasterDataVO();
                // 汎用マスタ(データ)取得の場合
                if (_sqlMode.equals(SqlMode.DATA)) {

                    vo.setTrkTimStmp((Date)result.get(TBTHBAMST.TRKTIMSTMP.toUpperCase()));
                    //Date trtim = (Date)result.get(TBTKVMST.TRKTIMSTMP.toUpperCase());
                    //vo.setTrkTimStmp(format.format(trtim));
                    vo.setTrkPl((String)result.get(TBTHBAMST.TRKPL.toUpperCase()));
                    vo.setTrkTnt((String)result.get(TBTHBAMST.TRKTNT.toUpperCase()));
                    vo.setUpdTimStmp((Date)result.get(TBTHBAMST.UPDTIMSTMP.toUpperCase()));
                    //Date uptim = (Date)result.get(TBTKVMST.UPDTIMSTMP.toUpperCase());
                   // vo.setUpdTimStmp(format.format(uptim));
                    vo.setUpdaPl((String)result.get(TBTHBAMST.UPDAPL.toUpperCase()));
                    vo.setUpdTnt((String)result.get(TBTHBAMST.UPDTNT   .toUpperCase()));
                    vo.setEgCd((String)result.get(TBTHBAMST.EGCD.toUpperCase()));
                    vo.setTksKgyCd((String)result.get(TBTHBAMST.TKSKGYCD.toUpperCase()));
                    vo.setTksBmnSeqNo((String)result.get(TBTHBAMST.TKSBMNSEQNO.toUpperCase()));
                    vo.setTksTntSeqNo((String)result.get(TBTHBAMST.TKSTNTSEQNO.toUpperCase()));
                    vo.setSybt((String)result.get(TBTHBAMST.SYBT.toUpperCase()));

                    vo.setColumn1(String.valueOf(result.get("FIELD1")));
                    vo.setColumn2(String.valueOf(result.get("FIELD2")));
                    vo.setColumn3(String.valueOf(result.get("FIELD3")));
                    vo.setColumn4(String.valueOf(result.get("FIELD4")));
                    vo.setColumn5(String.valueOf(result.get("FIELD5")));
                    vo.setColumn6(String.valueOf(result.get("FIELD6")));
                    vo.setColumn7(String.valueOf(result.get("FIELD7")));
                    vo.setColumn8(String.valueOf(result.get("FIELD8")));
                    vo.setColumn9(String.valueOf(result.get("FIELD9")));
                    vo.setColumn10(String.valueOf(result.get("FIELD10")));
                    vo.setColumn11(String.valueOf(result.get("FIELD11")));
                    vo.setColumn12(String.valueOf(result.get("FIELD12")));
                    vo.setColumn13(String.valueOf(result.get("FIELD13")));
                    vo.setColumn14(String.valueOf(result.get("FIELD14")));
                    vo.setColumn15(String.valueOf(result.get("FIELD15")));
                    vo.setColumn16(String.valueOf(result.get("FIELD16")));
                    vo.setColumn17(String.valueOf(result.get("FIELD17")));
                    vo.setColumn18(String.valueOf(result.get("FIELD18")));
                    vo.setColumn19(String.valueOf(result.get("FIELD19")));
                    vo.setColumn20(String.valueOf(result.get("FIELD20")));
                    vo.setColumn21(String.valueOf(result.get("FIELD21")));
                    vo.setColumn22(String.valueOf(result.get("FIELD22")));
                    vo.setColumn23(String.valueOf(result.get("FIELD23")));
                    vo.setColumn24(String.valueOf(result.get("FIELD24")));
                    vo.setColumn25(String.valueOf(result.get("FIELD25")));
                    vo.setColumn26(String.valueOf(result.get("FIELD26")));
                    vo.setColumn27(String.valueOf(result.get("FIELD27")));
                    vo.setColumn28(String.valueOf(result.get("FIELD28")));
                    vo.setColumn29(String.valueOf(result.get("FIELD29")));
                    vo.setColumn30(String.valueOf(result.get("FIELD30")));
                // 汎用マスタ（データ）の更新タイムスタンプ（最大値）取得の場合
                } else if (_sqlMode.equals(SqlMode.UPDTIMSTMP_MAX)) {
                    // 該当データがない場合
                    if (result.get(TBTHBAMST.UPDTIMSTMP.toUpperCase()) instanceof DummyNull) {
                        vo.setUpdTimStmp(null);
                    // 該当データがある場合
                    } else {
                       // vo.setUpdTimStmp(format.format((Date)result.get(TBTKVMST.UPDTIMSTMP.toUpperCase())));
                        vo.setUpdTimStmp((Date)result.get(TBTHBAMST.UPDTIMSTMP.toUpperCase()));
                    }
                }

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
