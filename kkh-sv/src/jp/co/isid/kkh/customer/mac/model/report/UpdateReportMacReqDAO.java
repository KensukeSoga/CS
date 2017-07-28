package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * データ更新DAO(請求書)
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/18 IP Shimizu)<BR>
 * </P>
 * @author IP Shimizu
 */
public class UpdateReportMacReqDAO extends AbstractSimpleRdbDao {

    /**汎用マスタ(データ)検索条件*/
    private UpdateReportMacReqDataVO _updateMeiVO;

    /**
     * デフォルトコンストラクタ。
     */
    public UpdateReportMacReqDAO() {
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
        return TBTHBAMST.TRKTIMSTMP;
    }

    /**
     * システム日付で更新する列の定義です
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[] { TBTHBAMST.TRKTIMSTMP,TBTHBAMST.UPDTIMSTMP };
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
        return null;
    }

    /**
     * マスタ(データ)の登録
     *
     * @param vo マスタデータVO（INSERT用）
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void updateReportMacRequest(UpdateReportMacReqDataVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("更新エラー", "BD-E0003");
        }
        _updateMeiVO = vo;
        try {
                super.exec();
              } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

    /**
     * 更新ＳＱＬ生成
     */
    @Override
    public String getExecString()
    {
        StringBuffer sql = new StringBuffer();

        sql.append(" UPDATE ");
        sql.append(" " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" SET ");
        sql.append(" " + TBTHB2KMEI.DATE2 + " = '" + _updateMeiVO.getDate1() + "', ");
        sql.append(" " + TBTHB2KMEI.UPDAPL + " = '" + _updateMeiVO.getUpdApl() + "', ");
        sql.append(" " + TBTHB2KMEI.TIMSTMP + " = SYSDATE ");
        // Where句
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _updateMeiVO.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _updateMeiVO.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _updateMeiVO.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _updateMeiVO.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _updateMeiVO.getYymm() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = '" + _updateMeiVO.getJyutNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = '" + _updateMeiVO.getJyMeiNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = '" + _updateMeiVO.getUrMeiNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.RENBN + " = '" + _updateMeiVO.getRenbn() + "' ");

        return sql.toString();
    }

}