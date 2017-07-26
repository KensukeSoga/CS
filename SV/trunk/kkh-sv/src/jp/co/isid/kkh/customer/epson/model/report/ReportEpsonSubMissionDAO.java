package jp.co.isid.kkh.customer.epson.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.isid.kkh.integ.tbl.TBTHB14SKDOWN;
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
 * 提出帳票（エプソン)検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/3/5 JSE YS)<BR>
 * ・エプソン仕入先情報変更対応(2017/04/14 HLC K.Soga)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSubMissionDAO extends AbstractRdbDao {

    /** 検索条件 */
    private ReportEpsonSubMissionCondition _cond;

    /** デフォルトコンストラクタ */
    public ReportEpsonSubMissionDAO() {
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
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    public String getSelectSQL() {
        return getSelectSQLForItem();
    }

    /**
     * 提出帳票情報取得のSQL文を返します。
     *
     * @return String SQL文
     */
    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT DISTINCT");
        sql.append(" SIIRESAKI." + TBTHBAMST.FIELD3 + " KAISHCD,");                     // 会社CD
        /** 2017/04/14 エプソン仕入先情報変更対応 HLC K.Soga MOD Start */
        //sql.append(" SIIRESAKI." + TBTHBAMST.FIELD4 + " KIHYOBMNCD,");                // 起票部門CD
        sql.append(" " + TBTHB2KMEI.SONOTA2 + " KIHYOBMNCD,");
        /** 2017/04/14 エプソン仕入先情報変更対応 HLC K.Soga MOD End */
        sql.append(" SIIRESAKI." + TBTHBAMST.FIELD1 + " SHIIRESKCD,");                  // 仕入先コード
        sql.append(" SIIRESAKI." + TBTHBAMST.FIELD5 + " TUKACD,");                      // 通貨CD
        sql.append(" " + TBTHB2KMEI.DATE1 + " KEIJYOBI,");                              // 計上日
        sql.append(" SIIRESAKI." + TBTHBAMST.INTVALUE2 + " RATE,");                     // 換算レート
        sql.append(" " + TBTHB2KMEI.SONOTA1 + " SEINO,");                               // 取引先請求No
        sql.append(" SIIRESAKI." + TBTHBAMST.INTVALUE1 + " ZEIKBN,");                   // 内外税区分
        sql.append(" " + TBTHB2KMEI.CODE4 + " TORISIKICD,");                            // 取引識別コード
        /** 2017/04/14 エプソン仕入先情報変更対応 HLC K.Soga MOD Start **/
        //sql.append(" SIIRESAKI." + TBTHBAMST.FIELD6 + " GENKACENT,");                 // 原価センタ
        sql.append(" " + TBTHB2KMEI.SONOTA3 + " GENKACENT,");
        /** 2017/04/14 エプソン仕入先情報変更対応 HLC K.Soga MOD End **/
        sql.append(" " + TBTHB2KMEI.NAME5 + " SASHIZUNO,");                             // 指図No
        sql.append(" " + TBTHB2KMEI.NAME6 + " SEGUSASHINO,");                           // セグメント指図番号
        sql.append(" " + TBTHB2KMEI.SEIGAK + " + " + TBTHB2KMEI.KNGK1 + " TORIGAK,");   // 取引金額
        sql.append(" " + TBTHB2KMEI.KNGK1 + " SYOHIGAK,");                              // 消費税額
        sql.append(" CASE " + TBTHB2KMEI.NAME7);                                        // ソートキー
        sql.append(" WHEN ' ' THEN 0 ELSE TO_NUMBER(" + TBTHB2KMEI.NAME7 + ") END SORT_KEY");

        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME + ",");
        sql.append(" " + TBTHB14SKDOWN.TBNAME + ",");
        sql.append(" (SELECT");
        sql.append(" " + TBTHBAMST.FIELD1 + ",");       // フィールド1：取引先コード
        sql.append(" " + TBTHBAMST.FIELD2 + ",");       // フィールド2：振込先コード
        sql.append(" " + TBTHBAMST.FIELD3 + ",");       // フィールド3：会社CD
        sql.append(" " + TBTHBAMST.FIELD4 + ",");       // フィールド4：起票部門CD
        sql.append(" " + TBTHBAMST.FIELD5 + ",");       // フィールド5：通貨CD
        sql.append(" " + TBTHBAMST.FIELD6 + ",");       // フィールド6：原価センタ
        sql.append(" " + TBTHBAMST.INTVALUE1 + ",");    // 数値1      ：税区分
        sql.append(" " + TBTHBAMST.INTVALUE2);          // 数値2      ：換算レート
        sql.append(" FROM");
        sql.append(" " + TBTHBAMST.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHBAMST.SYBT  + " = '103'");
        sql.append(" ) SIIRESAKI");

        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM  + " = '" + _cond.getYm() + "' AND");
        sql.append(" " + TBTHB2KMEI.NAME21  + " = '2' AND");        // 明細種別
        sql.append(" " + TBTHB2KMEI.KBN1 + " <> '1' AND");          // 請求対象外フラグが、1以外のレコードが対照
        sql.append(" " + TBTHB14SKDOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " AND");
        sql.append(" " + TBTHB14SKDOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " AND");
        sql.append(" " + TBTHB14SKDOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " AND");
        sql.append(" " + TBTHB14SKDOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " AND");
        sql.append(" " + TBTHB14SKDOWN.SEINO + " = " + TBTHB2KMEI.SONOTA1 + " AND");
        sql.append(" " + TBTHB14SKDOWN.SEIYYMM + " = " + TBTHB2KMEI.YYMM + " AND");
        sql.append(" " + TBTHB14SKDOWN.SEISTATUS + " IN ('2','3') ");

        sql.append(" ORDER BY");
        sql.append(" SORT_KEY"); // ソートキー

        return sql.toString();
    }

    /**
     * 提出帳票データ（エプソン)の検索を行います。
     *
     * @return 提出帳票（エプソン)VO リスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<ReportEpsonSubMissionVO> findReportEpsonSubMissionByCondition(ReportEpsonSubMissionCondition cond)
            throws KKHException {

        super.setModel(new ReportEpsonSubMissionVO());

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
     * @return List<ReportEpsonSubMissionVO> 変換後の検索結果
     */
    @Override
    protected List<ReportEpsonSubMissionVO> createFindedModelInstances(List hashList) {

        List<ReportEpsonSubMissionVO> list = new ArrayList<ReportEpsonSubMissionVO>();

        if (getModel() instanceof ReportEpsonSubMissionVO) {

            for (int i = 0; i < hashList.size(); i++) {

                Map result = (Map) hashList.get(i);
                ReportEpsonSubMissionVO vo = new ReportEpsonSubMissionVO();

                vo.setDenpyoNo("");                                          // 伝票登録NO
                vo.setMeisaiNo("");                                          // 明細NO
                vo.setKaishCd((String) result.get("KAISHCD"));               // 会社CD
                vo.setKihyoBmnCd((String) result.get("KIHYOBMNCD"));         // 起票部門CD
                vo.setShireskCd((String) result.get("SHIIRESKCD"));          // 仕入先コード
                vo.setTukaCd((String) result.get("TUKACD"));                 // 通貨CD
                vo.setHatskCd("");                                           // 発注先部門CD
                vo.setKeijyobi((String) result.get("KEIJYOBI"));             // 計上日
                vo.setRate((BigDecimal) result.get("RATE"));                 // 換算レート

                {
                    String s = (String)result.get("SEINO");

                    if ((s != null) && (s.length() == 12))
                    {
                        s = s.substring(0, 8) + "-" + s.substring(8, 12);
                    }

                    vo.setSeiNo(s);                                          // 取引先請求No
                }

                vo.setZeiKbn((BigDecimal) result.get("ZEIKBN"));             // 内外税区分
                vo.setToriSikiCd((String) result.get("TORISIKICD"));         // 取引識別コード
                vo.setGenkaCent((String) result.get("GENKACENT"));           // 原価センタ
                vo.setRiekiCent("");                                         // 利益センタ
                vo.setSashizuNo((String) result.get("SASHIZUNO"));           // 指図No
                vo.setSeguSashiNo((String) result.get("SEGUSASHINO"));       // セグメント指図番号
                vo.setToriSaki("");                                          // 取引先（立替先）
                vo.setToriNaiyo("");                                         // 具体的取引内容
                vo.setToriGak((BigDecimal) result.get("TORIGAK"));           // 取引金額
                vo.setSyohiGak((BigDecimal) result.get("SYOHIGAK"));         // 消費税額
                vo.setKansanGak("");                                         // 換算金額
                vo.setKansanSGak("");                                        // 換算消費税額
                vo.setKeshikomiKey("");                                      // 消込Key
                vo.setHinmokuCd("");                                         // 品目コード
                vo.setHinmokuMei("");                                        // 品目名称
                vo.setKataban("");                                           // 型番
                vo.setSuryo("");                                             // 数量
                vo.setTani("");                                              // 単位
                vo.setToriTank("");                                          // 取引単価
                vo.setKansanTank("");                                        // 換算単価
                vo.setPoNo("");                                              // P/ONo
                vo.setKeiyakuNo("");                                         // 契約No
                vo.setRingiNo("");                                           // 稟議書No
                vo.setGensenToriGak("");                                     // 源泉税取引金額
                vo.setGensenZeiRitu("");                                     // 源泉税率
                vo.setMaeTaisyoKbn("");                                      // 前払対象区分
                vo.setJyokenKakuKbn("");                                     // 条件確定区分
                vo.setKikanFrom("");                                         // 期間（From）
                vo.setKikanTo("");                                           // 期間（To）
                vo.setFurikaeJyoken("");                                     // 振替条件

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }
}