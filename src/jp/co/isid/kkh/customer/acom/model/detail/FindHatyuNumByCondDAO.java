package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * 発注データ登録DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/6 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
public class FindHatyuNumByCondDAO extends AbstractRdbDao  {

    private FindHatyuNumByCondVO _cond;
    //private Thb5HikVO _cond;
     /** getSelectSQLで発行するSQLのモード() */
    private enum SqlMode{COMMON,};
    private SqlMode _sqlMode = SqlMode.COMMON;

    /**
     * デフォルトコンストラクタ。
     */
    public FindHatyuNumByCondDAO() {
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
        // TODO 自動生成されたメソッド・スタブ
        return new String[]{
                TBTHB5HIK.TKSKGYCD,
                TBTHB5HIK.TKSBMNSEQNO,
                TBTHB5HIK.TKSTNTSEQNO,
                TBTHB5HIK.IRBAN,
                TBTHB5HIK.IRROWBAN
        };
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
        return TBTHB5HIK.TBNAME;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    public String[] getTableColumnNames() {
        return new String[]{
//    			TBTHB5HIK.TRKTIMSTMP,
//    			TBTHB5HIK.UPDAPL,
//    			TBTHB5HIK.UPDTN,
//    			TBTHB5HIK.TKSKGYCD,
//    			TBTHB5HIK.TKSBMNSEQNO,
//    			TBTHB5HIK.TKSTNTSEQNO,
                TBTHB5HIK.IRBAN,
                TBTHB5HIK.MEDIACD,
                TBTHB5HIK.SYBT,
                TBTHB5HIK.TEKICD,
                TBTHB5HIK.SYOHIKBN,
                TBTHB5HIK.SAIKBN,
                TBTHB5HIK.TENCD,
                TBTHB5HIK.IRROWBAN,
                TBTHB5HIK.ANSYUBE,
                TBTHB5HIK.KEISAI1,
                TBTHB5HIK.KEISAI2,
                TBTHB5HIK.KEISAI3,
                TBTHB5HIK.KEISAI4,
                TBTHB5HIK.KEISAI5,
                TBTHB5HIK.IRMONTH1,
                TBTHB5HIK.IRMONTH2,
                TBTHB5HIK.IRMONTH3,
                TBTHB5HIK.IRMONTH4,
                TBTHB5HIK.IRMONTH5,
                TBTHB5HIK.IRYYMM,
                TBTHB5HIK.KEISAI,
                TBTHB5HIK.TOUDATE,
                TBTHB5HIK.HENDATE,
                TBTHB5HIK.TORDATE,
                TBTHB5HIK.KEISAITANKA,
                TBTHB5HIK.BIKOU1,
                TBTHB5HIK.BIKOU2,
                TBTHB5HIK.PLACECD,
                TBTHB5HIK.SYBT1CD,
                TBTHB5HIK.SYBT2CD,
                TBTHB5HIK.COLORCD,
                TBTHB5HIK.SPACECD,
                TBTHB5HIK.SIZECD,
                TBTHB5HIK.KEITAICD,
                TBTHB5HIK.KEITAINAME,
                TBTHB5HIK.KOTUKEICD,
                TBTHB5HIK.KEISAICNT,
                TBTHB5HIK.MEDIANAME
        };
    }

    /**
     * 実施NO自動UP/DOWNの登録を行います。
     *
     * @param vo VO 実施NoVO
     * @throws UserException データアクセス中にエラーが発生した場合
     */
    public void findThb2Kmei(FindHatyuNumByCondVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("登録エラー", "BD-E0002");
        }
        //super.setModel(vo);
        _cond = vo;

        try {
          super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public  String getSelectSQL() {
        if (_sqlMode.equals(SqlMode.COMMON)){
            return getExecString();
        }
        return "";
    }

    /**
     * EXEC-SQL生成
     */
    @Override
    public String getExecString() {
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
        sql.append(TBTHB5HIK.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" "+ TBTHB5HIK.TKSKGYCD + " =  '" + _cond.get_tksKgyCd() +"' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.get_tksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.get_tksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.IRBAN + " = '" + _cond.get_Irban() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.RECCD + " = 'H' ");
        sql.append(" AND ");
        sql.append(" (" + TBTHB5HIK.IRBAN + " , " + TBTHB5HIK.IRROWBAN + " , " + TBTHB5HIK.RIRENO + ") IN ");
        sql.append(" ( SELECT " + TBTHB5HIK.IRBAN + ", " + TBTHB5HIK.IRROWBAN + ", MAX(" + TBTHB5HIK.RIRENO + ") ");
        sql.append(" FROM ");
        sql.append(TBTHB5HIK.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" "+ TBTHB5HIK.TKSKGYCD + " =  '" + _cond.get_tksKgyCd() +"' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.get_tksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.get_tksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.IRBAN + " = '" + _cond.get_Irban() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.RECCD + " = 'H' ");
        sql.append(" GROUP BY  ");
        sql.append(TBTHB5HIK.IRBAN + ", ");
        sql.append(TBTHB5HIK.IRROWBAN + ") ");
        sql.append(" ORDER BY  ");
        sql.append(TBTHB5HIK.IRBAN + ", ");
        sql.append(TBTHB5HIK.IRROWBAN + " ");

        return sql.toString();
    }

    /**
     * 広告費明細テーブルの条件指定検索を行います。
     *
     * @return 受注ダウンロードデータVO
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<HikVO> findThb5HikByCondCmn(FindHatyuNumByCondVO Cond) throws KKHException {

     // TODO THB5HIKテーブルに同項目なし
        super.setModel(new HikVO());

        try {
            _cond = Cond;
//        	_selSqlMode = SelSqlMode.COND_CMN;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    @Override
    protected List<HikVO> createFindedModelInstances(List hashList) {
        List<HikVO> list = new ArrayList<HikVO>();
        if (getModel() instanceof HikVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                HikVO vo = new HikVO();
                vo.setIrban((String) result.get(TBTHB5HIK.IRBAN.toUpperCase()));					//依頼番号
                vo.setMediaCd((String) result.get(TBTHB5HIK.MEDIACD.toUpperCase()));				//メディアコード
                vo.setSybt((String) result.get(TBTHB5HIK.SYBT.toUpperCase()));						//媒体コード
                vo.setTekiCd((String) result.get(TBTHB5HIK.TEKICD.toUpperCase()));					//摘要コード
                vo.setSyohiKbn((String) result.get(TBTHB5HIK.SYOHIKBN.toUpperCase()));				//商品区分
                vo.setSaiKbn((String) result.get(TBTHB5HIK.SAIKBN.toUpperCase()));					//細目区分
                vo.setTenCd((String) result.get(TBTHB5HIK.TENCD.toUpperCase()));					//店番
                vo.setIrrowban((String) result.get(TBTHB5HIK.IRROWBAN.toUpperCase()));				//依頼行番号
                vo.setAnsyube((String) result.get(TBTHB5HIK.ANSYUBE.toUpperCase()));				//按分種別
                vo.setKeisai1((String) result.get(TBTHB5HIK.KEISAI1.toUpperCase()));				//発売日1
                vo.setKeisai2((String) result.get(TBTHB5HIK.KEISAI2.toUpperCase()));				//発売日2
                vo.setKeisai3((String) result.get(TBTHB5HIK.KEISAI3.toUpperCase()));				//発売日3
                vo.setKeisai4((String) result.get(TBTHB5HIK.KEISAI4.toUpperCase()));				//発売日4
                vo.setKeisai5((String) result.get(TBTHB5HIK.KEISAI5.toUpperCase()));				//発売日5
                vo.setIrmonth1((String) result.get(TBTHB5HIK.IRMONTH1.toUpperCase()));				//依頼月1
                vo.setIrmonth2((String) result.get(TBTHB5HIK.IRMONTH2.toUpperCase()));				//依頼月2
                vo.setIrmonth3((String) result.get(TBTHB5HIK.IRMONTH3.toUpperCase()));				//依頼月3
                vo.setIrmonth4((String) result.get(TBTHB5HIK.IRMONTH4.toUpperCase()));				//依頼月4
                vo.setIrmonth5((String) result.get(TBTHB5HIK.IRMONTH5.toUpperCase()));				//依頼月5
                vo.setIryymm((String) result.get(TBTHB5HIK.IRYYMM.toUpperCase()));					//依頼年月
                vo.setKeisai((String) result.get(TBTHB5HIK.KEISAI.toUpperCase()));					//掲載日
                vo.setTouDate((String) result.get(TBTHB5HIK.TOUDATE.toUpperCase()));				//登録年月日
                vo.setHenDate((String) result.get(TBTHB5HIK.HENDATE.toUpperCase()));				//変更年月日
                vo.setTorDate((String) result.get(TBTHB5HIK.TORDATE.toUpperCase()));				//取消年月日
                vo.setKeisaiTanka((String) result.get(TBTHB5HIK.KEISAITANKA.toUpperCase()));		//掲載単価
                vo.setBikou1((String) result.get(TBTHB5HIK.BIKOU1.toUpperCase()));					//備考1
                vo.setBikou2((String) result.get(TBTHB5HIK.BIKOU2.toUpperCase()));					//備考2
                vo.setPlaceCd((String) result.get(TBTHB5HIK.PLACECD.toUpperCase()));				//掲載場所コード
                vo.setSybt1Cd((String) result.get(TBTHB5HIK.SYBT1CD.toUpperCase()));				//種別1コード
                vo.setSybt2Cd((String) result.get(TBTHB5HIK.SYBT2CD.toUpperCase()));				//種別1コード
                vo.setColorCd((String) result.get(TBTHB5HIK.COLORCD.toUpperCase()));				//色刷コード
                vo.setSpaceCd((String) result.get(TBTHB5HIK.SPACECD.toUpperCase()));				//サイズコード（新聞）
                vo.setSizeCd((String) result.get(TBTHB5HIK.SIZECD.toUpperCase()));					//サイズコード（雑誌）
                vo.setKeitaiCd((String) result.get(TBTHB5HIK.KEITAICD.toUpperCase()));				//形態区分コード
                vo.setKeitaiName((String) result.get(TBTHB5HIK.KEITAINAME.toUpperCase()));			//形態区分名
                vo.setKotukeiCd((String) result.get(TBTHB5HIK.KOTUKEICD.toUpperCase()));			//交通掲載コード
                vo.setKeisaiCnt((String) result.get(TBTHB5HIK.KEISAICNT.toUpperCase()));			//掲載回数
                vo.setMediaName((String) result.get(TBTHB5HIK.MEDIANAME.toUpperCase()));			//メディア名

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}