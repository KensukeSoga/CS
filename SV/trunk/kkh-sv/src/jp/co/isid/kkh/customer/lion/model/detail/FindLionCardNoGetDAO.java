package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class FindLionCardNoGetDAO extends AbstractRdbDao  {
       /**テレビ局マスタ検索条件 */
    private FindLionCardNoGetCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public FindLionCardNoGetDAO() {
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
    @Override
    public String getTableName() {
        return TBTHB2KMEI.TBNAME;
    }


    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        return null;
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

        //明細データSQL
        sql.append(" SELECT ");
        sql.append(" " + TBTHB2KMEI.CODE1 + " ");         //媒体区分
        sql.append(" ," + TBTHB2KMEI.CODE6 + " ");         //カードＮｏ
        sql.append(" ," + TBTHB2KMEI.TIMSTMP + " ");//YYYY/MM/DD HH24:MI:SS//) TIMSTMP  //タイムスタンプ
        sql.append(" " + "FROM" + " ");
        sql.append(" " + TBTHB2KMEI.TBNAME + " ");//広告費明細テーブル
        sql.append(" " + "where" + " ");
        sql.append(TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");          //営業所
        sql.append(TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");//得意先コード
        sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");//得意先BMN
        sql.append(TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");//得意先TNT
        sql.append(TBTHB2KMEI.YYMM  + " = '" + _cond.getYm()  + "'  AND ");//年月
        sql.append(TBTHB2KMEI.JYUTNO  + " = '" + _cond.getJyutno()  + "'  AND ");//受注ｎO
        sql.append(TBTHB2KMEI.JYMEINO  + " = '" + _cond.getJymeino()  + "'  AND ");//受注明細
        sql.append(TBTHB2KMEI.URMEINO  + " = '" + _cond.getUrmeino()  + "'  ");//売上明細


        return sql.toString();
    }


    /**
     * カードNOの検索を行います。
     *
     * @return カードNO、VOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<FindLionCardNoGetVO> findLionCardNoGetByCondition(FindLionCardNoGetCondition cond) throws KKHException {

        super.setModel(new FindLionCardNoGetVO());

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
    protected List<FindLionCardNoGetVO> createFindedModelInstances(List hashList) {
        List<FindLionCardNoGetVO> list = new ArrayList<FindLionCardNoGetVO>();
        if (getModel() instanceof FindLionCardNoGetVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindLionCardNoGetVO vo = new FindLionCardNoGetVO();
                vo.setCode1((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
                vo.setCode6((String)result.get(TBTHB2KMEI.CODE6.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
