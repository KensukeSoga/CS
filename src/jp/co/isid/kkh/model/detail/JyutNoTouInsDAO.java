package jp.co.isid.kkh.model.detail;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 受注番号統合DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/28 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
public class JyutNoTouInsDAO extends AbstractSimpleRdbDao  {

    private JyutNoTouInsVO _vo;

    /**
     * デフォルトコンストラクタ。
     */
    public JyutNoTouInsDAO() {
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
        return TBTHB1DOWN.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[]{};
    }

    /**
     * 受注内容統合登録を行います。
     *
     * @param vo VO
     * @throws UserException データアクセス中にエラーが発生した場合
     */
    public void JyutNoTouIns(JyutNoTouInsVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("登録エラー", "BD-E0002");
        }
        //super.setModel(vo);
        _vo = vo;
        try {
                super.exec();
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

        sql.append(" INSERT ");
        sql.append(" INTO " + TBTHB1DOWN.TBNAME);
        sql.append(" ( ");
        sql.append("   " + TBTHB1DOWN.TIMSTMP);
        sql.append("  ," + TBTHB1DOWN.UPDAPL);
        sql.append("  ," + TBTHB1DOWN.UPDTNT);
        sql.append("  ," + TBTHB1DOWN.ATUEGCD);
        sql.append("  ," + TBTHB1DOWN.EGCD);
        sql.append("  ," + TBTHB1DOWN.TKSKGYCD);
        sql.append("  ," + TBTHB1DOWN.TKSBMNSEQNO);
        sql.append("  ," + TBTHB1DOWN.TKSTNTSEQNO);
        sql.append("  ," + TBTHB1DOWN.JYUTNO);
        sql.append("  ," + TBTHB1DOWN.JYMEINO);
        sql.append("  ," + TBTHB1DOWN.URMEINO);
        sql.append("  ," + TBTHB1DOWN.GPYNO);
        sql.append("  ," + TBTHB1DOWN.GPYOPAG);
        sql.append("  ," + TBTHB1DOWN.SEINO);
        sql.append("  ," + TBTHB1DOWN.HIMKCD);
        sql.append("  ," + TBTHB1DOWN.TOUFLG);
        sql.append("  ," + TBTHB1DOWN.YYMM);
        sql.append("  ," + TBTHB1DOWN.GYOMKBN);
        sql.append("  ," + TBTHB1DOWN.MSKBN);
        sql.append("  ," + TBTHB1DOWN.TMSPKBN);
        sql.append("  ," + TBTHB1DOWN.KOKKBN);
        sql.append("  ," + TBTHB1DOWN.SEIKBN);
        sql.append("  ," + TBTHB1DOWN.SYONO);
        sql.append("  ," + TBTHB1DOWN.KKNAMEKJ);
        sql.append("  ," + TBTHB1DOWN.EGGAMENTYPE);
        sql.append("  ," + TBTHB1DOWN.KKAKSHANKBN);
        sql.append("  ," + TBTHB1DOWN.TORIGAK);
        sql.append("  ," + TBTHB1DOWN.SEITNKA);
        sql.append("  ," + TBTHB1DOWN.SEIGAK);
        sql.append("  ," + TBTHB1DOWN.NEBIRITU);
        sql.append("  ," + TBTHB1DOWN.NEBIGAK);
        sql.append("  ," + TBTHB1DOWN.SZEIKBN);
        sql.append("  ," + TBTHB1DOWN.SZEIRITU);
        sql.append("  ," + TBTHB1DOWN.SZEIGAK);
        sql.append("  ," + TBTHB1DOWN.HIMKNMKJ);
        sql.append("  ," + TBTHB1DOWN.HIMKNMKN);
        sql.append("  ," + TBTHB1DOWN.TJYUTNO);
        sql.append("  ," + TBTHB1DOWN.TJYMEINO);
        sql.append("  ," + TBTHB1DOWN.TURMEINO);
        sql.append("  ," + TBTHB1DOWN.MSEIFLG);
        sql.append("  ," + TBTHB1DOWN.YYMMOLD);
        sql.append("  ," + TBTHB1DOWN.FIELD1);
        sql.append("  ," + TBTHB1DOWN.FIELD2);
        sql.append("  ," + TBTHB1DOWN.FIELD3);
        sql.append("  ," + TBTHB1DOWN.FIELD4);
        sql.append("  ," + TBTHB1DOWN.FIELD5);
        sql.append("  ," + TBTHB1DOWN.FIELD6);
        sql.append("  ," + TBTHB1DOWN.FIELD7);
        sql.append("  ," + TBTHB1DOWN.FIELD8);
        sql.append("  ," + TBTHB1DOWN.FIELD9);
        sql.append("  ," + TBTHB1DOWN.FIELD10);
        sql.append("  ," + TBTHB1DOWN.FIELD11);
        sql.append("  ," + TBTHB1DOWN.FIELD12);
        sql.append("  ," + TBTHB1DOWN.FILETIMSTMP);
        sql.append("  ," + TBTHB1DOWN.MEITIMSTMP);
        sql.append("  ," + TBTHB1DOWN.JYUTDELFLG);
        sql.append(" ) ");
        sql.append("VALUES ( ");
        sql.append(" SYSDATE, "); 										//タイムスタンプ
        sql.append(" '" + _vo.get_aplId() + "' , ");						//
        sql.append(" '" + _vo.get_esqId() + "', ");						//更新担当者
        sql.append(" '" + _vo.get_egCd() + "', ");						//扱い営業所
        sql.append(" '" + _vo.get_egCd() + "', ");						//営業所
        sql.append(" '" + _vo.get_tksKgyCd() + "', ");					//得意先コード
        sql.append(" '" + _vo.get_tksBmnSeqNo() + "', ");				//得意先部門SEQNO
        sql.append(" '" + _vo.get_tksTntSeqNo() + "', ");				//得意先担当SEQNO
        sql.append(" '" + _vo.get_keyJyutno() + "', ");					//受注No
        sql.append(" '" + _vo.get_keyJyMeiNo() + "', ");				//受注明細No
        sql.append(" '" + _vo.get_keyUriMeiNo() + "', ");				//売上明細No
        sql.append(" ' ', ");											//請求原票No
        sql.append(" ' ', ");											//ページNo
        sql.append(" ' ', ");											//請求No
        sql.append(" '" + _vo.get_himkCd() + "', ");					//費目コード
        sql.append(" '1', ");											//統合フラグ
        sql.append(" '" + _vo.get_YYMM() + "', ");						//年月
        sql.append(" '" + _vo.get_gyomKbn() + "', ");					//業務区分
        sql.append(" '" + _vo.get_msKbn() + "', ");						//国際マス正味区分
        sql.append(" '" + _vo.get_tmsKbn() + "', ");					//タイムスポット区分
        sql.append(" '" + _vo.get_kokKbn() + "', ");					//国際区分
        sql.append(" '" + _vo.get_seiKbn() + "', ");					//請求区分
        sql.append(" '" + _vo.get_syoNo() + "', ");						//商品No
        sql.append(" '" + _vo.get_kknameKj() + "', ");					//件名
        sql.append(" '" + _vo.get_egGamenType() + "', ");				//営業画面タイプ
        sql.append(" '" + _vo.get_kkakShanKbn() + "', ");				//企画・製版区分
        sql.append(" " + _vo.get_toriRyouKin() + ", ");					//取り料金
        sql.append(" 0, ");												//請求単価
        sql.append(" " + _vo.get_seikyuKin() + ", ");					//請求金額
        sql.append(" " + _vo.get_nebikiRitu() + ", ");					//値引率
        sql.append(" " + _vo.get_nebikiGaku() + ", ");					//値引額
        sql.append(" '" + _vo.get_szeiKbn() + "', ");					//消費税区分
        sql.append(" " + _vo.get_szeiRitu() + ", ");					//消費税率
        sql.append(" " + _vo.get_szeiGaku() + ", ");					//消費税額
        sql.append(" '" + _vo.get_himkNmkj() + "', ");					//費目名
        sql.append(" ' ', ");											//費目名kana
        sql.append(" ' ', ");											//統合先受注No
        sql.append(" ' ', ");											//統合先受注明細No
        sql.append(" ' ', ");											//統合先売上明細No
        sql.append(" ' ', ");											//未請求フラグ
        sql.append(" null, ");											//変更前請求年月
        sql.append(" '" + _vo.get_field1() + "', ");					//フィールド1
        sql.append(" '" + _vo.get_field2() + "', ");					//フィールド2
        sql.append(" '" + _vo.get_field3() + "', ");					//フィールド3
        sql.append(" '" + _vo.get_field4() + "', ");					//フィールド4
        sql.append(" '" + _vo.get_field5() + "', ");					//フィールド5
        sql.append(" '" + _vo.get_field6() + "', ");					//フィールド6
        sql.append(" '" + _vo.get_field7() + "', ");					//フィールド7
        sql.append(" '" + _vo.get_field8() + "', ");					//フィールド8
        sql.append(" '" + _vo.get_field9() + "', ");					//フィールド9
        sql.append(" '" + _vo.get_field10() + "', ");					//フィールド10
        sql.append(" '" + _vo.get_field11() + "', ");					//フィールド11
        sql.append(" '" + _vo.get_field12() + "', ");					//フィールド12
        sql.append(" '" + _vo.get_fileTimStmp() + "', ");				//ダウンロードファイルタイムスタンプ
        sql.append(" '" + _vo.get_meiTimStmp() + "', ");				//明細登録日時
        sql.append(" '" + _vo.get_jyutDelFlg() + "') ");				//受注削除フラグ

        return sql.toString();
    }

}