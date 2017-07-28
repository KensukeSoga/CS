package jp.co.isid.kkh.customer.lion.model.report.detaillist;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionDaoInterface;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionVO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.LionDetailListConstants;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ライオン明細一覧帳票(新聞)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/07)<BR>
 * </P>
 *
 * @author
 */

public class DetailListLionShinbunDAO extends AbstractRdbDao implements DetailListLionDaoInterface{

    /** 汎用マスタ検索条件 */
    private DetailListLionCondition _cond;

    /** 汎用マスタ：媒体種別：テレビ局マスタ */
    public static final String C_HBAMST_SYBT_TV_KYOKU = LionDetailListConstants.MastBaitaiShubetsu.TV_KYOKU.getCode();
    //public static final String C_HBAMST_SYBT_TV_KYOKU = "401";

    /** 汎用マスタ：媒体種別：テレビ番組マスタ */
    public static final String C_HBAMST_SYBT_TV_BANGUMI =  LionDetailListConstants.MastBaitaiShubetsu.TV_BANGUMI.getCode();
    //public static final String C_HBAMST_SYBT_TV_BANGUMI = "601";

    /** getSelectSQLで発行するSQLのモード() */
//	private enum SqlMode {
//		KIND, ITEM,
//	};

    //private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * デフォルトコンストラクタ。
     */
    public DetailListLionShinbunDAO() {
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
        // new String[] {};
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

    private String getSelectSQLForItem() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHB2KMEI.YYMM		+ ", ");	//検索年月
        sql.append("  TRIM(" + TBTHB2KMEI.CODE1		+ ") " + TBTHB2KMEI.CODE1 +" , ");	//媒体区分
        sql.append("  TRIM(" + TBTHB2KMEI.CODE2		+ ")" + TBTHB2KMEI.CODE2 +" , ");	//新聞紙コード
        sql.append("  TRIM(" + TBTHB2KMEI.CODE3	+ ")" + TBTHB2KMEI.CODE3 +" , ");	//ブランドコード
        sql.append("  TRIM(" + TBTHB2KMEI.CODE4	+ ")" + TBTHB2KMEI.CODE4 +" , ");	//代理店コード
        sql.append("  TRIM(" + TBTHB2KMEI.CODE6	+ ")" + TBTHB2KMEI.CODE6 +" , ");	//カードNo
        sql.append("  " + TBTHB2KMEI.NAME1		+ ", ");	//消費税A
        sql.append("  " + TBTHB2KMEI.NAME4		+ ", ");	//実施料
        sql.append("  " + TBTHB2KMEI.NAME7		+ ", ");	//期間
        sql.append("  " + TBTHB2KMEI.NAME8		+ ", ");	//備考
        sql.append("  " + TBTHB2KMEI.SEIGAK		+ ", ");	//請求額
        sql.append("  " + TBTHB2KMEI.NEBIGAK		+ ", ");	//値引額
        sql.append("  " + TBTHB2KMEI.SONOTA5		+ ", ");	//本数
        sql.append("  " + TBTHB2KMEI.SONOTA7		+ ", ");	//秒数
        sql.append("  " + TBTHB2KMEI.RITU1		+ ", ");	//消費税率
//		sql.append("  TRUNC(" + TBTHB2KMEI.SEIGAK + " * " + TBTHB2KMEI.RITU1 + " / 100 ) AS "+ DetailListLionVO.SHOHIZEI_GAK +  ", "  );	//消費税
        sql.append("  TO_NUMBER(" + TBTHB2KMEI.NAME1 + ") AS " + DetailListLionVO.SHOHIZEI_GAK + ", "); // 消費税
        sql.append("  mast5." + TBTHBAMST.SYBT		+ ", ");	//種別
        sql.append("  mast5." + TBTHBAMST.FIELD1		+ " AS " + DetailListLionVO.BRAND_CD + ", ");	//ブランドコード
        sql.append("  mast5." + TBTHBAMST.FIELD2		+ " AS  " + DetailListLionVO.BRAND_MEI + ", ");	//ブランド名
        sql.append("  mast5." + TBTHBAMST.FIELD3		+ " , ");
        sql.append("  mast5." + TBTHBAMST.FIELD4		+ " , ");
        sql.append("  mast5." + TBTHBAMST.FIELD5		+ " , ");
        sql.append("  mast5." + TBTHBAMST.FIELD6		+ " , ");
        sql.append("  mast11." + TBTHBAMST.SYBT		+ ", ");	//種別
        sql.append("  mast11." + TBTHBAMST.FIELD1		+ " AS  " + DetailListLionVO.SHINBUN_CD + ", ");	//新聞コード
        sql.append("  mast11." + TBTHBAMST.FIELD2		+ " AS  " + DetailListLionVO.SHINBUN_MEI + ", ");	//新聞名
        sql.append("  mast11." + TBTHBAMST.FIELD3		+ ", ");
        sql.append("  mast11." + TBTHBAMST.FIELD4		+ ", ");
        sql.append("  mast11." + TBTHBAMST.FIELD5		+ ", ");
        sql.append("  mast11." + TBTHBAMST.FIELD6		+ " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHB1DOWN.TBNAME + " thb1, ");
        sql.append(" " + TBTHB2KMEI.TBNAME + " thb2, ");
        sql.append(" (SELECT ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + ",");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + ",");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + ",");
        sql.append(" " + TBTHBAMST.SYBT + ",");
        sql.append(" " + TBTHBAMST.FIELD1 + ",");
        sql.append(" " + TBTHBAMST.FIELD2 + ",");
        sql.append(" " + TBTHBAMST.FIELD3 + ",");
        sql.append(" " + TBTHBAMST.FIELD4 + ",");
        sql.append(" " + TBTHBAMST.FIELD5 + ",");
        sql.append(" " + TBTHBAMST.FIELD6 + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' ) mast5 ,");
        sql.append(" (SELECT ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + ",");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + ",");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + ",");
        sql.append(" " + TBTHBAMST.SYBT + ",");
        sql.append(" " + TBTHBAMST.FIELD1 + ",");
        sql.append(" " + TBTHBAMST.FIELD2 + ",");
        sql.append(" " + TBTHBAMST.FIELD3 + ",");
        sql.append(" " + TBTHBAMST.FIELD4 + ",");
        sql.append(" " + TBTHBAMST.FIELD5 + ",");
        sql.append(" " + TBTHBAMST.FIELD6 + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '105' ) mast11 ");
        sql.append(" WHERE ");
        sql.append("  thb2." + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append("  thb2." + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append("  thb2." + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append("  thb2." + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append("  thb2." + TBTHB2KMEI.YYMM + " BETWEEN '" + _cond.getymfrom() + "' AND '" + _cond.getymto() + "' AND ");
        sql.append("  thb2." + TBTHB2KMEI.CODE1 + " = '07' AND ");
        sql.append("  thb2." + TBTHB2KMEI.EGCD + " = thb1." + TBTHB1DOWN.EGCD + " AND ");
        sql.append("  thb2." + TBTHB2KMEI.TKSKGYCD + " = thb1." + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append("  thb2." + TBTHB2KMEI.TKSBMNSEQNO + " = thb1." + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append("  thb2." + TBTHB2KMEI.TKSTNTSEQNO + " = thb1." + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append("  thb2." + TBTHB2KMEI.YYMM + " = thb1." + TBTHB1DOWN.YYMM + " AND ");
        sql.append("  thb2." + TBTHB2KMEI.JYUTNO + " = thb1." + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append("  thb2." + TBTHB2KMEI.JYMEINO + " = thb1." + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append("  thb2." + TBTHB2KMEI.URMEINO + " = thb1." + TBTHB1DOWN.URMEINO + " AND ");
        sql.append("  thb1." + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
        sql.append("  thb2." + TBTHB2KMEI.CODE6 + " = '007' AND ");
        sql.append("  TRIM(thb2." + TBTHB2KMEI.CODE3 + ") = mast5." + TBTHBAMST.FIELD1 +" AND ");
        sql.append("  TRIM(thb2." + TBTHB2KMEI.CODE2 + ") = mast11." + TBTHBAMST.FIELD1 +"  ");
        sql.append(" ORDER BY ");
        sql.append(" thb2." + TBTHB2KMEI.YYMM + ", ");
        sql.append(" thb2." + TBTHB2KMEI.CODE3 + ", ");
        sql.append(" mast11." + TBTHBAMST.FIELD4  + ", ");
        sql.append(" mast11." + TBTHBAMST.FIELD5  + ", ");
        sql.append(" thb2." + TBTHB2KMEI.CODE2 + ", ");
        sql.append(" thb2." + TBTHB2KMEI.JYUTNO + ", ");
        sql.append(" thb2." + TBTHB2KMEI.JYMEINO + ", ");
        sql.append(" thb2." + TBTHB2KMEI.URMEINO + " ");

        return sql.toString();
    }

    /**
     * 帳票データ(ライオン)の検索を行います。
     *
     * @return 汎用テーブルマスタVOリスト
     * @throws UserException
     *             データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<DetailListLionVO> findDetailListLionByCondition(DetailListLionCondition cond)
            throws KKHException {

        super.setModel(new DetailListLionVO());

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
     * @param hashList
     *            List 検索結果
     * @return List<CommonCodeMasterVO> 変換後の検索結果
     */
    @Override
    protected List<DetailListLionVO> createFindedModelInstances(List hashList) {
        List<DetailListLionVO> list = new ArrayList<DetailListLionVO>();
        if (getModel() instanceof DetailListLionVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                DetailListLionVO vo = new DetailListLionVO();
                vo.setYymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase()));							//検索年月
                vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));				//媒体区分
                vo.setCode2((String) result.get(TBTHB2KMEI.CODE2.toUpperCase().trim()));
                vo.setCode3((String) result.get(TBTHB2KMEI.CODE3.toUpperCase().trim()));//ブランドコード
                vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));				//代理店コード
                vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));				//カードNo
                vo.setName1((String) result.get(TBTHB2KMEI.NAME1.toUpperCase().trim()));
                vo.setName4((String) result.get(TBTHB2KMEI.NAME4.toUpperCase().trim()));
                vo.setName7((String) result.get(TBTHB2KMEI.NAME7.toUpperCase().trim()));
                vo.setName8((String) result.get(TBTHB2KMEI.NAME8.toUpperCase().trim()));
                vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));					//請求額
                vo.setNebigak((BigDecimal) result.get(TBTHB2KMEI.NEBIGAK.toUpperCase()));				//値引額
                vo.setSonota5((String) result.get(TBTHB2KMEI.SONOTA5.toUpperCase().trim()));			//本数
                vo.setSonota7((String) result.get(TBTHB2KMEI.SONOTA7.toUpperCase().trim()));			//秒数
                vo.setShohizeiGak((BigDecimal) result.get(DetailListLionVO.SHOHIZEI_GAK.toUpperCase().trim()));			//消費税
                vo.setShinCd((String) result.get(DetailListLionVO.SHINBUN_CD.toUpperCase().trim()));   //新聞コード
                vo.setShinMei((String) result.get(DetailListLionVO.SHINBUN_MEI.toUpperCase().trim())); //新聞名
                vo.setBrandCd((String) result.get(DetailListLionVO.BRAND_CD.toUpperCase().trim())); //ブランドコード
                vo.setBrandMei((String) result.get(DetailListLionVO.BRAND_MEI.toUpperCase().trim())); //ブランド名
//
//				vo.setKngk2((BigDecimal) result.get(TBTHB2KMEI.KNGK2.toUpperCase()));					//ネット料
//				vo.setKngk3((BigDecimal) result.get(TBTHB2KMEI.KNGK3.toUpperCase()));					//制作費
//
//
//				vo.setShohizeiGak((BigDecimal) result.get(DetailListLionVO.SHOHIZEI_GAK.toUpperCase()));	//消費税額
//				vo.setByosuGokei((BigDecimal) result.get(DetailListLionVO.BYOSU_GOKEI.toUpperCase()));		//CM秒数合計
//				vo.setKyokuCd((String) result.get(DetailListLionVO.KYOKU_CD.toUpperCase()));				//局コード
//				vo.setKyokuMei((String) result.get(DetailListLionVO.KYOKU_MEI.toUpperCase()));				//局名称
//				vo.setBangumiCd((String) result.get(DetailListLionVO.BANGUMI_CD.toUpperCase()));			//番組コード
//				vo.setBangumiMei((String) result.get(DetailListLionVO.BANGUMI_MEI.toUpperCase()));			//番組名称

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
