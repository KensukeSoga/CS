package jp.co.isid.kkh.customer.acom.model.claim;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 送信フラグ更新DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/20 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class UpdateOutFlgDAO extends AbstractSimpleRdbDao {

    private int _index;
    private UpdateOutFlgVO _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public UpdateOutFlgDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    @Override
    public String[] getPrimryKeyNames() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    /**
     * システム日付で更新する列の定義です
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return null;
    }

    /**
     * 更新日付フィールドを返します。
     *
     * @return String 更新日付フィールド
     */
    public String getTimeStampKeyName() {
        return null;
    }

    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    public String getTableName() {
        return null;
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
     * 送信フラグの更新を行います。
     *
     * @param vo 送信フラグ更新情報VO
     * @param index インデックス
     * @return int 更新件数
     * @throws UserException データアクセス中にエラーが発生した場合
     */
    public int updateThb2KmeiForOutFlg(UpdateOutFlgVO vo, int index)
            throws KKHException {
        // パラメータチェック
        if (vo == null) {
            throw new KKHException("登録エラー", "BD-E0002");
        }
        super.setModel(vo);
        try {
            _cond = vo;
            _index = index;
            return super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * EXEC-SQL生成
     */
    @Override
    public String getExecString() {
        StringBuffer sql = new StringBuffer();

        UpdateOutFlgVO vo = (UpdateOutFlgVO) getModel();

        sql.append(" UPDATE");
        sql.append(" " + TBTHB2KMEI.TBNAME);
        sql.append(" SET");
        sql.append(" " + TBTHB2KMEI.TIMSTMP + " = " + getDBModelInterface().getSystemDateString());    // タイムスタンプ
        sql.append("," + TBTHB2KMEI.KBN1 + "    = '" + vo.getOutFlg() + "'");                          // 区分1（送信フラグ）
        sql.append("," + TBTHB2KMEI.NAME7 + "   = '" + vo.getOutDate() + "'");                         // 出力日時
        sql.append("," + TBTHB2KMEI.SONOTA1 + " = '" + vo.getSeiNo()[_index] + "'");                   // 請求書No
        sql.append("," + TBTHB2KMEI.SONOTA2 + " = '" + vo.getSeiGyoNo()[_index] + "'");                // 請求書行No
        sql.append("," + TBTHB2KMEI.DATE1 + "   = '" + vo.getSeiYymm()[_index] + "'");                 // 請求年月日
        sql.append(" WHERE");
        sql.append("     " + TBTHB2KMEI.EGCD + "        = '" + _cond.getEgCd() + "'");                 // 営業所（取）コード
        sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");             // 得意先企業コード
        sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");          // 得意先部門SEQNO
        sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");          // 得意先担当SEQNO
        sql.append(" AND " + TBTHB2KMEI.JYUTNO + "      = '" + _cond.getJyutNo()[_index] + "'");       // 受注No
        sql.append(" AND " + TBTHB2KMEI.JYMEINO + "     = '" + _cond.getJyMeiNo()[_index] + "'");      // 受注明細No
        sql.append(" AND " + TBTHB2KMEI.URMEINO + "     = '" + _cond.getUrMeiNo()[_index] + "'");      // 売上明細No
        sql.append(" AND " + TBTHB2KMEI.RENBN + "       = '" + _cond.getRenban()[_index] + "'");       // 連番

        return sql.toString();
    }
}
