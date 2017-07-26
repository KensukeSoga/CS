package jp.co.isid.kkh.customer.lion.model.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB91RRKDOWN;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ライオン履歴ヘッダーDAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */

public class LionHistoryHeaderDAO extends AbstractRdbDao {

    /** ライオン履歴条件 */
    LionHistoryCondition _cond = null;

    /**
     * デフォルトコンストラクタ。
     */
    public LionHistoryHeaderDAO() {
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
        return new String[] {
                TBTHB91RRKDOWN.RRKTIMSTMP
                ,TBTHB91RRKDOWN.EGCD
                ,TBTHB91RRKDOWN.TKSKGYCD
                ,TBTHB91RRKDOWN.TKSBMNSEQNO
                ,TBTHB91RRKDOWN.TKSTNTSEQNO
                ,TBTHB91RRKDOWN.YYMM
                ,TBTHB91RRKDOWN.JYUTNO
                ,TBTHB91RRKDOWN.JYMEINO
                ,TBTHB91RRKDOWN.URMEINO
                ,TBTHB91RRKDOWN.TOUFLG
        };
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
        return TBTHB91RRKDOWN.TBNAME;
    }

    /**
     * テーブル列名を返します。
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
        //return null;
        return new String[] {
                TBTHB91RRKDOWN.TRKTIMSTMP
                ,TBTHB91RRKDOWN.TRKAPL
                ,TBTHB91RRKDOWN.TRKTNT
                ,TBTHB91RRKDOWN.TRKTNTNM
                ,TBTHB91RRKDOWN.KSNTIMSTMP
                ,TBTHB91RRKDOWN.KSNTNT
                ,TBTHB91RRKDOWN.KSNTNTNM
                ,TBTHB91RRKDOWN.TIMSTMP
                ,TBTHB91RRKDOWN.UPDAPL
                ,TBTHB91RRKDOWN.UPDTNT
                ,TBTHB91RRKDOWN.ATUEGCD
                ,TBTHB91RRKDOWN.RRKTIMSTMP
                ,TBTHB91RRKDOWN.EGCD
                ,TBTHB91RRKDOWN.TKSKGYCD
                ,TBTHB91RRKDOWN.TKSBMNSEQNO
                ,TBTHB91RRKDOWN.TKSTNTSEQNO
                ,TBTHB91RRKDOWN.JYUTNO
                ,TBTHB91RRKDOWN.JYMEINO
                ,TBTHB91RRKDOWN.URMEINO
                ,TBTHB91RRKDOWN.GPYNO
                ,TBTHB91RRKDOWN.GPYOPAG
                ,TBTHB91RRKDOWN.SEINO
                ,TBTHB91RRKDOWN.HIMKCD
                ,TBTHB91RRKDOWN.TOUFLG
                ,TBTHB91RRKDOWN.YYMM
                ,TBTHB91RRKDOWN.GYOMKBN
                ,TBTHB91RRKDOWN.MSKBN
                ,TBTHB91RRKDOWN.TMSPKBN
                ,TBTHB91RRKDOWN.KOKKBN
                ,TBTHB91RRKDOWN.SEIKBN
                ,TBTHB91RRKDOWN.SYONO
                ,TBTHB91RRKDOWN.KKNAMEKJ
                ,TBTHB91RRKDOWN.EGGAMENTYPE
                ,TBTHB91RRKDOWN.KKAKSHANKBN
                ,TBTHB91RRKDOWN.TORIGAK
                ,TBTHB91RRKDOWN.SEITNKA
                ,TBTHB91RRKDOWN.SEIGAK
                ,TBTHB91RRKDOWN.NEBIRITU
                ,TBTHB91RRKDOWN.NEBIGAK
                ,TBTHB91RRKDOWN.SZEIKBN
                ,TBTHB91RRKDOWN.SZEIRITU
                ,TBTHB91RRKDOWN.SZEIGAK
                ,TBTHB91RRKDOWN.HIMKNMKJ
                ,TBTHB91RRKDOWN.HIMKNMKN
                ,TBTHB91RRKDOWN.TJYUTNO
                ,TBTHB91RRKDOWN.TJYMEINO
                ,TBTHB91RRKDOWN.TURMEINO
                ,TBTHB91RRKDOWN.MSEIFLG
                ,TBTHB91RRKDOWN.YYMMOLD
                ,TBTHB91RRKDOWN.FIELD1
                ,TBTHB91RRKDOWN.FIELD2
                ,TBTHB91RRKDOWN.FIELD3
                ,TBTHB91RRKDOWN.FIELD4
                ,TBTHB91RRKDOWN.FIELD5
                ,TBTHB91RRKDOWN.FIELD6
                ,TBTHB91RRKDOWN.FIELD7
                ,TBTHB91RRKDOWN.FIELD8
                ,TBTHB91RRKDOWN.FIELD9
                ,TBTHB91RRKDOWN.FIELD10
                ,TBTHB91RRKDOWN.FIELD11
                ,TBTHB91RRKDOWN.FIELD12
                ,TBTHB91RRKDOWN.FILETIMSTMP
                ,TBTHB91RRKDOWN.MEITIMSTMP
                ,TBTHB91RRKDOWN.JYUTDELFLG
        };
    }

    /**
     * 履歴作成SQL文生成
     * @return String SQL文
     */
    public String getExecString() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("INSERT INTO");
        sql.append(" " + TBTHB91RRKDOWN.TBNAME);
        sql.append(" SELECT");
        sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + ",");      //登録タイムスタンプ
        sql.append(" " + TBTHB1DOWN.TRKAPL + ",");          //登録プログラム
        sql.append(" " + TBTHB1DOWN.TRKTNT + ",");          //登録担当者ID
        sql.append(" " + TBTHB1DOWN.TRKTNTNM + ",");        //登録担当者名
        sql.append(" " + TBTHB1DOWN.KSNTIMSTMP + ",");      //明細更新タイムスタンプ
        sql.append(" " + TBTHB1DOWN.KSNTNT + ",");          //明細更新者ID
        sql.append(" " + TBTHB1DOWN.KSNTNTNM + ",");        //明細更新者名
        sql.append(" " + TBTHB1DOWN.TIMSTMP + ",");         //更新タイムスタンプ
        sql.append(" " + TBTHB1DOWN.UPDAPL + ",");          //更新プログラム
        sql.append(" " + TBTHB1DOWN.UPDTNT + ",");          //更新担当者
        sql.append(" " + TBTHB1DOWN.ATUEGCD+ ",");          //営業所(扱)コード
        sql.append(" TO_DATE('" + _cond.getRrkTimStmp() + "','YYYY-MM-DD HH24:MI:SS'),");    //履歴タイムスタンプ
        sql.append(" " + TBTHB1DOWN.EGCD + ",");            //営業所(取)コード
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + ",");        //得意先企業コード
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + ",");     //得意先部門SEQNO
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + ",");     //得意先担当SEQNO
        sql.append(" " + TBTHB1DOWN.JYUTNO + ",");          //受注No
        sql.append(" " + TBTHB1DOWN.JYMEINO + ",");         //受注明細No
        sql.append(" " + TBTHB1DOWN.URMEINO + ",");         //売上明細No
        sql.append(" " + TBTHB1DOWN.GPYNO + ",");           //請求原票No
        sql.append(" " + TBTHB1DOWN.GPYOPAG + ",");         //ページNo
        sql.append(" " + TBTHB1DOWN.SEINO + ",");           //請求No
        sql.append(" " + TBTHB1DOWN.HIMKCD + ",");          //費目コード
        sql.append(" " + TBTHB1DOWN.TOUFLG + ",");          //統合フラグ
        sql.append(" " + TBTHB1DOWN.YYMM + ",");            //年月
        sql.append(" " + TBTHB1DOWN.GYOMKBN + ",");         //業務区分
        sql.append(" " + TBTHB1DOWN.MSKBN + ",");           //マス正味区分
        sql.append(" " + TBTHB1DOWN.TMSPKBN + ",");         //タイムスポット区分
        sql.append(" " + TBTHB1DOWN.KOKKBN + ",");          //国際区分
        sql.append(" " + TBTHB1DOWN.SEIKBN + ",");          //請求区分
        sql.append(" " + TBTHB1DOWN.SYONO + ",");           //商品No
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + ",");        //件名(漢字)
        sql.append(" " + TBTHB1DOWN.EGGAMENTYPE + ",");     //営業画面タイプ
        sql.append(" " + TBTHB1DOWN.KKAKSHANKBN + ",");     //企画・製版区分
        sql.append(" " + TBTHB1DOWN.TORIGAK + ",");         //取料金
        sql.append(" " + TBTHB1DOWN.SEITNKA + ",");         //請求単価
        sql.append(" " + TBTHB1DOWN.SEIGAK + ",");          //請求金額
        sql.append(" " + TBTHB1DOWN.NEBIRITU + ",");        //値引率
        sql.append(" " + TBTHB1DOWN.NEBIGAK + ",");         //値引額
        sql.append(" " + TBTHB1DOWN.SZEIKBN + ",");         //消費税区分
        sql.append(" " + TBTHB1DOWN.SZEIRITU + ",");        //消費税率
        sql.append(" " + TBTHB1DOWN.SZEIGAK + ",");         //消費税額
        sql.append(" " + TBTHB1DOWN.HIMKNMKJ + ",");        //費目名(漢字)
        sql.append(" " + TBTHB1DOWN.HIMKNMKN + ",");        //費目名(カナ)
        sql.append(" " + TBTHB1DOWN.TJYUTNO + ",");         //統合先受注No
        sql.append(" " + TBTHB1DOWN.TJYMEINO + ",");        //統合先受注明細No
        sql.append(" " + TBTHB1DOWN.TURMEINO + ",");        //統合先売上明細No
        sql.append(" " + TBTHB1DOWN.MSEIFLG + ",");         //未請求フラグ
        sql.append(" " + TBTHB1DOWN.YYMMOLD + ",");         //変更前年月
        sql.append(" " + TBTHB1DOWN.FIELD1 + ",");          //フィールド1
        sql.append(" " + TBTHB1DOWN.FIELD2 + ",");          //フィールド2
        sql.append(" " + TBTHB1DOWN.FIELD3 + ",");          //フィールド3
        sql.append(" " + TBTHB1DOWN.FIELD4 + ",");          //フィールド4
        sql.append(" " + TBTHB1DOWN.FIELD5 + ",");          //フィールド5
        sql.append(" " + TBTHB1DOWN.FIELD6 + ",");          //フィールド6
        sql.append(" " + TBTHB1DOWN.FIELD7 + ",");          //フィールド7
        sql.append(" " + TBTHB1DOWN.FIELD8 + ",");          //フィールド8
        sql.append(" " + TBTHB1DOWN.FIELD9 + ",");          //フィールド9
        sql.append(" " + TBTHB1DOWN.FIELD10 + ",");         //フィールド10
        sql.append(" " + TBTHB1DOWN.FIELD11 + ",");         //フィールド11
        sql.append(" " + TBTHB1DOWN.FIELD12 + ",");         //フィールド12
        sql.append(" " + TBTHB1DOWN.FILETIMSTMP + ",");     //ダウンロードファイルタイムスタンプ
        sql.append(" " + TBTHB1DOWN.MEITIMSTMP + ",");      //明細登録日時
        sql.append(" " + TBTHB1DOWN.JYUTDELFLG + ",");      //受注削除フラグ
        sql.append(" '" + _cond.getEsqId() + "',");         //履歴登録担当者(ESQ-ID)
        sql.append(" '" + _cond.getRrkGetBaitai() + "',");  //履歴作成時選択媒体
        sql.append(" '0'");                                 //履歴AD1フラグ
        sql.append(" FROM");
        sql.append("  " + TBTHB1DOWN.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "'");

        return sql.toString();
    }

   /**
     * 受注ダウンロード履歴を作成
     * @param cond 検索条件
     * @throws KKHException データアクセス中にエラーが発生した場合
     */
    public void insertHistoryHeaderCreate(LionHistoryCondition cond) throws KKHException {

        try {
            _cond = cond;
            super.exec();
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
     * @return List<LionHistoryVO> ライオン履歴データ検索結果VOリスト
     */
    @Override
    protected List<LionHistoryVO> createFindedModelInstances(List hashList) {

        List<LionHistoryVO> list = new ArrayList<LionHistoryVO>();
        if (getModel() instanceof LionHistoryVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                LionHistoryVO vo = new LionHistoryVO();

                //履歴タイムスタンプ
                vo.setRrkTimStmp((String) result.get(TBTHB91RRKDOWN.RRKTIMSTMP.toUpperCase()));

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
