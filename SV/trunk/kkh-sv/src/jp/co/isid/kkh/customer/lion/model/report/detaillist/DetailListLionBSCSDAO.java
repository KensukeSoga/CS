package jp.co.isid.kkh.customer.lion.model.report.detaillist;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB11WLTVK;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB9WLTVB;
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
 * ライオン明細一覧帳票(BS/CS)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/07)<BR>
 * </P>
 *
 * @author
 */

public class DetailListLionBSCSDAO extends AbstractRdbDao implements  DetailListLionDaoInterface{

    /** 汎用マスタ検索条件 */
    private DetailListLionCondition _cond;

    /**  汎用マスタ：媒体種別：テレビ局マスタ */
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
    public DetailListLionBSCSDAO() {
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
        sql.append("  " + TBTHB2KMEI.CODE6 + ", ");
        sql.append("  " + TBTHB2KMEI.YYMM + ", ");
        sql.append("  " + TBTHB2KMEI.CODE4 + ", ");
        sql.append("  " + TBTHB2KMEI.CODE1 + ", ");
        sql.append("  " + TBTHB2KMEI.CODE5 + " " + DetailListLionVO.PROGRAM_CD + ", ");
        sql.append("  " + TBTHB2KMEI.CODE2 + " " + DetailListLionVO.KYOKU_CD + ", ");
//		sql.append("  mast4." + TBTHBAMST.FIELD2 + " " + DetailListLionVO.KYOKU_MEI+ ", ");
        sql.append("  " + TBTHB11WLTVK.KYOKUNAME + " " + DetailListLionVO.KYOKU_MEI+ ", ");
        sql.append("  " + TBTHB2KMEI.NEBIGAK + ", ");
        sql.append(" " + TBTHB9WLTVB.HYOJIJYUN+ " " + DetailListLionVO.HYOJI+ ", ");
        sql.append("  " + TBTHB2KMEI.SEIGAK + ", ");
        sql.append("  TRIM(" + TBTHB2KMEI.SONOTA5 + ") " + DetailListLionVO.HONSU + ", ");
//		sql.append("  mast6." + TBTHBAMST.FIELD2 + " " + DetailListLionVO.PROGRAM_NAME+ ", ");
        sql.append(" " + TBTHB9WLTVB.BANNAME + " " + DetailListLionVO.PROGRAM_NAME+ ", ");
        sql.append("  " + TBTHB2KMEI.NAME1 + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + ", ");
        sql.append("  " + TBTHB1DOWN.TBNAME + ", ");
        sql.append("  " + TBTHB9WLTVB.TBNAME + ", ");
        sql.append("  " + TBTHB11WLTVK.TBNAME + " ");
//		sql.append("  " + TBTHBAMST.TBNAME + " mast4, ");
//		sql.append("  " + TBTHBAMST.TBNAME + " mast6 ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " BETWEEN '" + _cond.getymfrom() + "' AND '" + _cond.getymto() + "' AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB11WLTVK.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB11WLTVK.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB11WLTVK.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB9WLTVB.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB9WLTVB.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB9WLTVB.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = " + TBTHB1DOWN.EGCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = " + TBTHB1DOWN.TKSKGYCD + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO + " AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = " + TBTHB1DOWN.YYMM + " AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = " + TBTHB1DOWN.JYUTNO + " AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = " + TBTHB1DOWN.JYMEINO + " AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = " + TBTHB1DOWN.URMEINO + " AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND ");
        sql.append(" " + TBTHB2KMEI.CODE6 + " IN ('016') AND ");
//		sql.append(" mast4." + TBTHBAMST.SYBT + " = '401' AND ");
//		sql.append(" mast6." + TBTHBAMST.SYBT + " = '601' AND ");
//		sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ") = mast4." + TBTHBAMST.FIELD1 + " AND ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE2 + ") = " + TBTHB11WLTVK.KYOKUCD + " AND ");
//		sql.append(" TRIM(" + TBTHB2KMEI.CODE5 + ") = mast6." + TBTHBAMST.FIELD1 + "  ");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE5 + ") = " + TBTHB9WLTVB.BANCD + "  ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB2KMEI.YYMM + ", ");
        sql.append("  " + TBTHB2KMEI.CODE6 + ", ");
        //sql.append("  mast6." + TBTHBAMST.INTVALUE5 + ", ");
//		sql.append("  " + TBTHB9WLTVB.HYOJIJYUN + ", ");
        sql.append("  " + TBTHB2KMEI.CODE5 + ", ");
        sql.append("  " + TBTHB2KMEI.CODE2 + ", ");
        sql.append("  " + TBTHB2KMEI.JYUTNO + ", ");
        sql.append("  " + TBTHB2KMEI.JYMEINO + ", ");
        sql.append("  " + TBTHB2KMEI.URMEINO + " ");

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
                vo.setCode6((String) result.get(TBTHB2KMEI.CODE6.toUpperCase().trim()));	//カードNO
                vo.setYymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase()));				//検索年月
                vo.setCode4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));	//代理店コード
                vo.setCode1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));	//媒体区分
                vo.setProgramCd((String) result.get(DetailListLionVO.PROGRAM_CD.toUpperCase().trim()));	//プログラムコード
                vo.setKyokuCd((String) result.get(DetailListLionVO.KYOKU_CD.toUpperCase().trim()));	//局コード
                vo.setKyokuMei((String) result.get(DetailListLionVO.KYOKU_MEI.toUpperCase().trim()));	//局名
                vo.setNebigak((BigDecimal) result.get(TBTHB2KMEI.NEBIGAK.toUpperCase().trim()));	//値引額
//				vo.setHyoji((BigDecimal) result.get(DetailListLionVO.HYOJI.toUpperCase().trim()));	//表示
                vo.setSeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));					//請求額
                vo.setHonsu((String) result.get(DetailListLionVO.HONSU.toUpperCase().trim()));	//本数
                vo.setProgramName((String) result.get(DetailListLionVO.PROGRAM_NAME.toUpperCase().trim()));	//プログラム名
                vo.setName1((String) result.get(TBTHB2KMEI.NAME1.toUpperCase().trim()));	//消費税
                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
