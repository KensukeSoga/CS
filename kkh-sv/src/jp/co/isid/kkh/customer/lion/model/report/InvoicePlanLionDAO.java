package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ライオン制作費請求予定表検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */

public class InvoicePlanLionDAO extends AbstractRdbDao {

    /** ライオン請求予定表検索条件 */
    InvoicePlanLionCondition _cond = null;

    /** 事業部：生コマ */
    private static final String DIV_ONAIR_CM_CODE = "23";
    private static final String DIV_ONAIR_CM_NAME = "生コマ";
    /** 事業部：プリント費 */
    private static final String DIV_PRINT_COST_CODE = "21";
    private static final String DIV_PRINT_COST_NAME = "プリント費";

    /**
     * デフォルトコンストラクタ。
     */
    public InvoicePlanLionDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * プライマリキーを返します。
     * @return String[] プライマリキー
     */
    @Override
    public String[] getPrimryKeyNames() {
        return null;
    }

    /**
     * 更新日付フィールドを返します。
     * @return String 更新日付フィールド
     */
    public String getTimeStampKeyName() {
        return null;
    }

    /**
     * テーブル名を返します。
     * @return String テーブル名
     */
    @Override
    public String getTableName() {
        return null;
    }

    /**
     * テーブル列名を返します。
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        return null;
    }

    /**
     * SQL文生成
     */
    public String getSelectSQL() {
        return getSelectSQLInvoicePlan();
    }

    /**
     * 請求予定表取得SQL文生成
     * @return SQL文
     */
    private String getSelectSQLInvoicePlan() {

        //SQL
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " " + InvoicePlanLionVO.JYUTNO + ",");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " " + InvoicePlanLionVO.JYMEINO + ",");
        sql.append(" " + TBTHB2KMEI.URMEINO + " " + InvoicePlanLionVO.URMEINO + ",");
        sql.append(" " + TBTHB2KMEI.CODE3 + " " + InvoicePlanLionVO.BRDCD + ",");
        sql.append(" M2." + TBTHBAMST.FIELD2 + " " + InvoicePlanLionVO.BRDNM + ",");
        sql.append(" TRIM(" + TBTHB2KMEI.NAME10 + ") " + InvoicePlanLionVO.KENNM + ",");
        sql.append(" " + TBTHB2KMEI.SEIGAK + " " + InvoicePlanLionVO.SEIGAK + ",");
        sql.append(" " + TBTHB2KMEI.CODE1 + " " + InvoicePlanLionVO.BAITAIKBN + ",");
        sql.append(" M3." + TBTHBAMST.FIELD2 + " " + InvoicePlanLionVO.BAITAINM);
        sql.append(" FROM");
        sql.append(" " + TBTHB1DOWN.TBNAME + ",");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHBAMST.TBNAME + " M2,"); //ADブランドマスタ
        sql.append(" " + TBTHBAMST.TBNAME + " M3");  //媒体区分
        sql.append(" WHERE");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "' AND");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM + " AND");
        sql.append(" " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO + " AND");
        sql.append(" " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO + " AND");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' AND");
        sql.append(" " + TBTHB2KMEI.CODE6 + " = '012' AND");

//        //ライオン商事の場合
//        if (_cond.getDivision().equals(DIV_LION_AFFAIRS_NAME)) {
//            sql.append(" TRIM(" + TBTHB2KMEI.NAME10 + ") LIKE '【" + DIV_LION_AFFAIRS_NAME + "】%' AND");
//        } else {
//            sql.append(" TRIM(" + TBTHB2KMEI.NAME10 + ") NOT LIKE '【" + DIV_LION_AFFAIRS_NAME + "】%' AND");

            //生コマの場合
            if (_cond.getDivision().equals(DIV_ONAIR_CM_NAME)) {
                sql.append(" " + TBTHB2KMEI.CODE1 + " = '" + DIV_ONAIR_CM_CODE + "' AND");
            } else if (_cond.getDivision().equals(DIV_PRINT_COST_NAME)) {
                //プリント費の場合
                sql.append(" " + TBTHB2KMEI.CODE1 + " = '" + DIV_PRINT_COST_CODE + "' AND");
            } else {
                sql.append(" " + TBTHB2KMEI.CODE1 + " NOT IN ( '" + DIV_ONAIR_CM_CODE + "', '" + DIV_PRINT_COST_CODE + "' ) AND");
                sql.append(" M2." + TBTHBAMST.FIELD6 + " = '" + _cond.getDivision() + "' AND");
            }
//        }

        sql.append(" M2." + TBTHBAMST.SYBT + " = '201' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = M2." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = M2." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = M2." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE3 +") = M2." + TBTHBAMST.FIELD1 + " AND");
        sql.append(" M3." + TBTHBAMST.SYBT + " = '104' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = M3." + TBTHBAMST.TKSKGYCD + " AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = M3." + TBTHBAMST.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = M3." + TBTHBAMST.TKSTNTSEQNO + " AND");
        sql.append(" TRIM(" + TBTHB2KMEI.CODE1 + ") = M3." + TBTHBAMST.FIELD1);
        sql.append(" ORDER BY");
        sql.append(" " + InvoicePlanLionVO.BRDCD + ",");
        sql.append(" " + InvoicePlanLionVO.BAITAIKBN + ",");
        sql.append(" " + InvoicePlanLionVO.JYUTNO + ",");
        sql.append(" " + InvoicePlanLionVO.JYMEINO + ",");
        sql.append(" " + InvoicePlanLionVO.URMEINO);

        return sql.toString();
    }

    /**
     * ライオン制作室リストデータの検索を行います。
     *
     * @return ライオン制作室リストデータ取得VOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<InvoicePlanLionVO> findInvoicePlan(InvoicePlanLionCondition cond) throws KKHException {
        super.setModel(new InvoicePlanLionVO());

        try {
            _cond = cond;
            return (List<InvoicePlanLionVO>)super.find();
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
     * @return List<AddChangeReportVO> 変換後の検索結果
     */
    @Override
    protected List<InvoicePlanLionVO> createFindedModelInstances(List hashList) {
        List<InvoicePlanLionVO> list = new ArrayList<InvoicePlanLionVO>();
        for (int i = 0; i < hashList.size(); i++) {
            Map result = (Map) hashList.get(i);
            InvoicePlanLionVO vo = new InvoicePlanLionVO();

            //受注No
            vo.setJyutno((String) result.get(InvoicePlanLionVO.JYUTNO.toUpperCase()));
            //受注明細No
            vo.setJymeino((String) result.get(InvoicePlanLionVO.JYMEINO.toUpperCase()));
            //売上明細No
            vo.setUrmeino((String) result.get(InvoicePlanLionVO.URMEINO.toUpperCase()));
            //ブランドコード
            vo.setBrdCd((String) result.get(InvoicePlanLionVO.BRDCD.toUpperCase()));
            //ブランド名
            vo.setBrdNm((String) result.get(InvoicePlanLionVO.BRDNM.toUpperCase()));
            //件名
            vo.setKenNm((String) result.get(InvoicePlanLionVO.KENNM.toUpperCase()));
            //請求金額
            vo.setSeigak((BigDecimal) result.get(InvoicePlanLionVO.SEIGAK.toUpperCase()));
            //媒体区分コード
            vo.setBaitaiKbn((String) result.get(InvoicePlanLionVO.BAITAIKBN.toUpperCase()));
            //媒体区分名
            vo.setBaitaiNm((String) result.get(InvoicePlanLionVO.BAITAINM.toUpperCase()));

            //検索結果直後の状態にする
            ModelUtils.copyMemberSearchAfterInstace(vo);
            list.add(vo);
        }

        return list;
    }

}
