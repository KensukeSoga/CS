package jp.co.isid.kkh.model.master;


import java.util.List;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;

import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;
/**
 *
 * <P>
 * 汎用マスタ検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/3 Fourm H.izawa)<BR>
 * </P>
 * @author
 */
public class MasterItemDAO extends AbstractSimpleRdbDao {

    /**汎用マスタ検索条件 */
    private MasterCondition _cond;

    /** getSelectSQLで発行するSQLのモード() */
   // private enum SqlMode{KIND,ITEM,};
   // private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * デフォルトコンストラクタ。
     */
    public MasterItemDAO() {
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

    	return getSelectSQLForKind();
    }

    private String getSelectSQLForKind(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	//全項目を取得
    	for (int i = 0; i < getTableColumnNames().length; i++){
    		if (i == 0){
    			sql.append("  " + getTableColumnNames()[i] + " ");
    		}else{
    			sql.append(" ," + getTableColumnNames()[i] + " ");
    		}
    	}

    	sql.append(" FROM ");
    	sql.append("" + TBTHBAMST.TBNAME + " ");
    	sql.append(" WHERE ");
    	sql.append("" + TBTHBAMST.EGCD + " =  '" + _cond.getEgCd() + "' ");
    	sql.append(" AND ");
    	sql.append("" + TBTHBAMST.TKSKGYCD + " =  '" + _cond.getTksKgyCd() + "' ");
    	sql.append(" AND ");
    	sql.append("" + TBTHBAMST.TKSBMNSEQNO + " =  '" + _cond.getTksBmnSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append("" + TBTHBAMST.TKSTNTSEQNO + " =  '" + _cond.getTksTntSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append("" + TBTHBAMST.SYBT+ " =  '" + _cond.getSybt() + "' ");
    	sql.append(" AND ");
    	sql.append("" + TBTHBAMST.FIELD1 + " =  '" + _cond.getFilterValue() + "' ");


    	return sql.toString();
    }



    /**
     * 汎用テーブルマスタの検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<MasterVO> findMasterKindByCondition(MasterCondition cond) throws KKHException {

    	super.setModel(new MasterVO());

        try {
        	_cond = cond;
        	//_sqlMode = SqlMode.KIND;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }

    }

//    /**
//     * 汎用テーブルマスタの検索を行います。
//     *
//     * @return 汎用テーブルマスタVOリスト
//     * @throws UserException データアクセス中にエラーが発生した場合。
//     */
//    @SuppressWarnings("unchecked")
//    public List<MasterVO> findMasterItemByCondition(MasterCondition cond) throws KKHException {
//
//    	super.setModel(new MasterVO());
//
//        try {
//        	_cond = cond;
//        	_sqlMode = SqlMode.ITEM;
//            return super.find();
//        } catch (UserException e) {
//            throw new KKHException(e.getMessage(), "BD-E0002");
//        }
//
//    }

//
//    /**
//     * Modelの生成を行う<br>
//     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
//     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
//     *
//     * @param hashList List 検索結果
//     * @return List<CommonCodeMasterVO> 変換後の検索結果
//     */
//    @Override
//    @SuppressWarnings("unchecked")
//    protected List<MasterVO> createFindedModelInstances(List hashList) {
//        List<MasterVO> list = new ArrayList<MasterVO>();
//        if (getModel() instanceof MasterVO) {
//            for (int i = 0; i < hashList.size(); i++) {
//                Map result = (Map) hashList.get(i);
//                MasterVO vo = new MasterVO();
//                vo.setTrkTimStmp((Date)result.get(TBTHBAMST.TRKTIMSTMP.toUpperCase()));
//                vo.setTrkPl((String)result.get(TBTHBAMST.TRKPL.toUpperCase()));
//                vo.setTrkTnt((String)result.get(TBTHBAMST.TRKTNT.toUpperCase()));
//                vo.setUpdTimStmp((Date)result.get(TBTHBAMST.UPDTIMSTMP.toUpperCase()));
//                vo.setUpdaPl((String)result.get(TBTHBAMST.UPDAPL.toUpperCase()));
//                vo.setUpdTnt((String)result.get(TBTHBAMST.UPDTNT   .toUpperCase()));
//                vo.setEgCd((String)result.get(TBTHBAMST.EGCD.toUpperCase()));
//                vo.setTksKgyCd((String)result.get(TBTHBAMST.TKSKGYCD.toUpperCase()));
//                vo.setTksBmnSeqNo((String)result.get(TBTHBAMST.TKSBMNSEQNO.toUpperCase()));
//                vo.setTksTntSeqNo((String)result.get(TBTHBAMST.TKSTNTSEQNO.toUpperCase()));
//                vo.setSybt((String)result.get(TBTHBAMST.SYBT.toUpperCase()));
//                vo.setField1((String)result.get(TBTHBAMST.FIELD1.toUpperCase()));
//                vo.setField2((String)result.get(TBTHBAMST.FIELD2.toUpperCase()));
//                vo.setField3((String)result.get(TBTHBAMST.FIELD3.toUpperCase()));
//                vo.setField4((String)result.get(TBTHBAMST.FIELD4.toUpperCase()));
//                vo.setField5((String)result.get(TBTHBAMST.FIELD5.toUpperCase()));
//                vo.setField6((String)result.get(TBTHBAMST.FIELD6.toUpperCase()));
//                vo.setField7((String)result.get(TBTHBAMST.FIELD7.toUpperCase()));
//                vo.setField8((String)result.get(TBTHBAMST.FIELD8.toUpperCase()));
//                vo.setField9((String)result.get(TBTHBAMST.FIELD9.toUpperCase()));
//                vo.setField10((String)result.get(TBTHBAMST.FIELD10.toUpperCase()));
//                vo.setField11((String)result.get(TBTHBAMST.FIELD11.toUpperCase()));
//                vo.setField12((String)result.get(TBTHBAMST.FIELD12.toUpperCase()));
//                vo.setField13((String)result.get(TBTHBAMST.FIELD13.toUpperCase()));
//                vo.setField14((String)result.get(TBTHBAMST.FIELD14.toUpperCase()));
//                vo.setField15((String)result.get(TBTHBAMST.FIELD15.toUpperCase()));
//                vo.setField16((String)result.get(TBTHBAMST.FIELD16.toUpperCase()));
//                vo.setField17((String)result.get(TBTHBAMST.FIELD17.toUpperCase()));
//                vo.setField18((String)result.get(TBTHBAMST.FIELD18.toUpperCase()));
//                vo.setField19((String)result.get(TBTHBAMST.FIELD19.toUpperCase()));
//                vo.setField20((String)result.get(TBTHBAMST.FIELD20.toUpperCase()));
//                vo.setIntValue1((BigDecimal)result.get(TBTHBAMST.INTVALUE1.toUpperCase()));
//                vo.setIntValue2((BigDecimal)result.get(TBTHBAMST.INTVALUE2.toUpperCase()));
//                vo.setIntValue3((BigDecimal)result.get(TBTHBAMST.INTVALUE3.toUpperCase()));
//                vo.setIntValue4((BigDecimal)result.get(TBTHBAMST.INTVALUE4.toUpperCase()));
//                vo.setIntValue5((BigDecimal)result.get(TBTHBAMST.INTVALUE5.toUpperCase()));
//                vo.setIntValue6((BigDecimal)result.get(TBTHBAMST.INTVALUE6.toUpperCase()));
//                vo.setIntValue7((BigDecimal)result.get(TBTHBAMST.INTVALUE7.toUpperCase()));
//                vo.setIntValue8((BigDecimal)result.get(TBTHBAMST.INTVALUE8.toUpperCase()));
//                vo.setIntValue9((BigDecimal)result.get(TBTHBAMST.INTVALUE9.toUpperCase()));
//                vo.setIntValue10((BigDecimal)result.get(TBTHBAMST.INTVALUE10.toUpperCase()));
//
//
//                // 検索結果直後の状態にする
//                ModelUtils.copyMemberSearchAfterInstace(vo);
//                list.add(vo);
//            }
//        }
//        return list;
//    }

}
