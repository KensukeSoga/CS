package jp.co.isid.kkh.customer.acom.model.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.input.HikVO;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * 発注データ検索DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/08 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
public class HikDAO extends AbstractRdbDao {

    public static final String  BAICD_ZASI     = "22";//雑誌
    public static final String  BAICD_SHINBUN  = "21";//新聞
    public static final String  BAICD_DENP     = "11";//電波
    public static final String  BAICD_KOTU     = "31";//交通

    /**マスタ検索条件 */
    private HikCommonCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public HikDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    @Override
    public String[] getPrimryKeyNames() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public String[] getTableColumnNames() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public String getTableName() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public String getTimeStampKeyName() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
        StringBuilder sql = new StringBuilder();

        sql.append(" SELECT ");
        sql.append("A." + TBTHB5HIK.KOUKBN + ",");        //更新区分
        sql.append("A." + TBTHB5HIK.RIRENO + ",");        //履歴管理番号
        sql.append("A." + TBTHB5HIK.IRYYMM + ",");        //依頼年月
        sql.append("A." + TBTHB5HIK.IRBAN + ",");         //発注番号
        sql.append("A." + TBTHB5HIK.IRROWBAN + ",");      //行番号
        sql.append("A." + TBTHB5HIK.MEDIACD + ",");       //メディアコード
        sql.append("A." + TBTHB5HIK.MEDIANAME + ",");     //メディア名
        sql.append("A." + TBTHB5HIK.SIZECD + ",");        //サイズコード
        sql.append("A." + TBTHB5HIK.SIZENAME + ",");      //サイズ
        sql.append("A." + TBTHB5HIK.KEISAI1 + ",");       //掲載日1
        sql.append("A." + TBTHB5HIK.KEISAI2 + ",");       //掲載日2
        sql.append("A." + TBTHB5HIK.KEISAI3 + ",");       //掲載日3
        sql.append("A." + TBTHB5HIK.KEISAI4 + ",");       //掲載日4
        sql.append("A." + TBTHB5HIK.KEISAI5 + ",");       //掲載日5
        sql.append("A." + TBTHB5HIK.KEITAICD + ",");      //形態区分コード
        sql.append("A." + TBTHB5HIK.KEITAINAME + ",");    //形態区分名
        sql.append("A." + TBTHB5HIK.IRMONTH1 + ",");      //依頼月1
        sql.append("A." + TBTHB5HIK.HOSORYO1  + ",");     //放送料1
        sql.append("A." + TBTHB5HIK.IRMONTH2 + ",");      //依頼月2
        sql.append("A." + TBTHB5HIK.HOSORYO2 + ",");      //放送料2
        sql.append("A." + TBTHB5HIK.IRMONTH3 + ",");      //依頼月3
        sql.append("A." + TBTHB5HIK.HOSORYO3 + ",");      //放送料3
        sql.append("A." + TBTHB5HIK.IRMONTH4 + ",");      //依頼月4
        sql.append("A." + TBTHB5HIK.HOSORYO4 + ",");      //放送料4
        sql.append("A." + TBTHB5HIK.IRMONTH5 + ",");      //依頼月5
        sql.append("A." + TBTHB5HIK.HOSORYO5 + ",");      //放送料5
        sql.append("A." + TBTHB5HIK.IRMONTH6 + ",");      //依頼月6
        sql.append("A." + TBTHB5HIK.HOSORYO6 + ",");      //放送料6
        sql.append("A." + TBTHB5HIK.KOTUKEICD + ",");     //交通掲載コード
        sql.append("A." + TBTHB5HIK.KOTUKEINAME + ",");   //交通掲載名
        sql.append("A." + TBTHB5HIK.KEISAI + ",");        //掲載日
        sql.append("A." + TBTHB5HIK.KEISAIRYO + ",");     //掲載料
        sql.append("A." + TBTHB5HIK.KEISAITANKA + ",");   //掲載単価
        sql.append("A." + TBTHB5HIK.KEISAICNT + ",");     //掲載回数
        sql.append("A." + TBTHB5HIK.SYOHIKBN + ",");      //商品区分
        sql.append("A." + TBTHB5HIK.SAIKBN + ",");        //細目区分
        sql.append("A." + TBTHB5HIK.TEKICD + ",");        //摘要コード
        sql.append("A." + TBTHB5HIK.URIYYMM + ",");       //売上予定年月
        sql.append("A." + TBTHB5HIK.TANNAME + ",");       //担当者名
        sql.append("A." + TBTHB5HIK.TANKINNAME + ",");    //担当者勤務部署名
        sql.append("A." + TBTHB5HIK.ANSYUBE + ",");       //按分種別
        sql.append("A." + TBTHB5HIK.BIKOU1 + ",");        //備考1
        sql.append("A." + TBTHB5HIK.BIKOU2 + ",");        //備考2
        sql.append("A." + TBTHB5HIK.COLORCD + ",");       //色刷コード
        sql.append("A." + TBTHB5HIK.SPACECD + ",");       //スペースコード
        sql.append("A." + TBTHB5HIK.SYBT1CD + ",");       //種別１コード
        sql.append("A." + TBTHB5HIK.SYBT2CD + ",");       //種別２コード
        sql.append("A." + TBTHB5HIK.DESIGNCNT + ",");     //デザイン変更回数
        sql.append("A." + TBTHB5HIK.PLACECD + ",");       //掲載場所コード
        sql.append("A." + TBTHB5HIK.PRINTRYO + ",");      //印刷代
        sql.append("A." + TBTHB5HIK.SASHIKAERYO + ",");   //差替作業料
        sql.append("A." + TBTHB5HIK.DESIGNRYO + ",");     //デザイン料
        sql.append("A." + TBTHB5HIK.HANSHITARYO + ",");   //版下代
        sql.append("A." + TBTHB5HIK.SEIHANRYO + ",");     //製版代
        sql.append("A." + TBTHB5HIK.TOUDATE + ",");       //登録年月日
        sql.append("A." + TBTHB5HIK.HENDATE + ",");       //変更年月日
        sql.append("A." + TBTHB5HIK.TORDATE + ",");       //取消年月日

        //最新データフラグ取得SQL
        sql.append(" DECODE(  ");                     //最新データフラグ
        sql.append("A." + TBTHB5HIK.RIRENO  + ",");
        sql.append(" ( SELECT ");
        sql.append(" MAX( " + TBTHB5HIK.RIRENO +  ")");
        sql.append(" FROM ");
        sql.append(TBTHB5HIK.TBNAME);
        sql.append(getWhere(TBTHB5HIK.TKSKGYCD,TBTHB5HIK.TKSBMNSEQNO,TBTHB5HIK.TKSTNTSEQNO,TBTHB5HIK.SYBT,true));
        sql.append(" GROUP BY ");
        sql.append(TBTHB5HIK.IRBAN + ",");
        sql.append(TBTHB5HIK.IRROWBAN );
        sql.append(" ), '1' ) AS SAISINFLG ,");

        //更新区分名作成SQL
        sql.append(" CASE ");
        //更新区分名

        //変更がなく取消があるか確認 ⇒ 取消
        sql.append(" WHEN TRIM(" + "A." + TBTHB5HIK.TORDATE +  ") is null AND "  +
                         "TRIM(" + "A." + TBTHB5HIK.HENDATE +  ") is not null  THEN '変更'");

        //変更があって取消がないか確認 ⇒ 変更
        sql.append(" WHEN TRIM(" + "A." + TBTHB5HIK.HENDATE +  ") is null AND "  +
                         "TRIM(" + "A." + TBTHB5HIK.TORDATE +  ") is not null  THEN '取消'");

        //変更が取消より大きいか確認 ⇒ 変更
        sql.append(" WHEN " + "A." + TBTHB5HIK.HENDATE + " > " + "A." + TBTHB5HIK.TORDATE + " THEN '変更'");

        //変更が取消より小さいか確認 ⇒ 取消
        sql.append(" WHEN " + "A." + TBTHB5HIK.TORDATE + " > " + "A." + TBTHB5HIK.HENDATE + " THEN '取消'");

        sql.append(" ELSE '新規' ");
        sql.append(" END AS KOUKBNNAME ");

        if(_cond.getSyubetsu().compareTo(BAICD_SHINBUN) == 0)
        {
            //ステータス
            sql.append(" ,");
            sql.append(" CASE ");
            sql.append(" WHEN TRIM(" + "A." + TBTHB5HIK.SPACECD + ") is null THEN 'ｽﾍﾟｰｽ変換ｴﾗｰ' ");
            sql.append(" WHEN TRIM(" + "A." + TBTHB5HIK.MEDIACD + ") is null THEN '媒体変換ｴﾗｰ' ");
            sql.append(" ELSE '正常' ");
            sql.append(" END AS STATUS ");

            //スペース名
            sql.append(" , ");
            sql.append(" CASE ");
            sql.append(" WHEN TRIM(B.HBA_FIELD3) is null THEN '未登録' ");
            sql.append(" ELSE B.HBA_FIELD3");
            sql.append(" END AS " + TBTHB5HIK.SPACENAME);
        }

        //FROM句
        //媒体コードが【新聞】のみの場合
        if(_cond.getSyubetsu().compareTo(BAICD_SHINBUN) == 0)
        {
            sql.append(" FROM ");
            sql.append(TBTHB5HIK.TBNAME  + " A LEFT JOIN ");
            sql.append("THBAMST B ON ");
            sql.append("HBA_SYBT = '907'");
            sql.append(" AND ");
            sql.append("HBA_TKSKGYCD = '" + _cond.getTkskgycd().substring(0,6)  + "'");
            sql.append(" AND ");
            sql.append("A." + TBTHB5HIK.SPACECD + " = HBA_FIELD2");
            sql.append(" AND ");
            sql.append("HBA_FIELD1 = '02'");
            //sql.append(getWhere(_cond.getTkskgycd(),_cond.getTksbmnseqno(),_cond.getTkstntseqno(),_cond.getSyubetsu(),false));
        }
        //媒体コードが【新聞】以外の場合
        else
        {
            sql.append(" FROM ");
            sql.append(TBTHB5HIK.TBNAME  + " A");
        }

        //WHERE句
        sql.append(getWhere(_cond.getTkskgycd(),_cond.getTksbmnseqno(),_cond.getTkstntseqno(),_cond.getSyubetsu(),false));

        //媒体コードが【電波】の場合
        if(_cond.getSyubetsu().compareTo(BAICD_DENP) == 0){
            sql.append(" AND ");
            sql.append("(" + "A." + TBTHB5HIK.IRYYMM);            //依頼年月
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "'");
            sql.append(" OR ");

            sql.append("A." + TBTHB5HIK.IRMONTH2);                //依頼月2
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "'");
            sql.append(" OR ");

            sql.append("A." + TBTHB5HIK.IRMONTH3);                //依頼月3
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "'");
            sql.append(" OR ");

            sql.append("A." + TBTHB5HIK.IRMONTH4);                //依頼月4
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "'");
            sql.append(" OR ");

            sql.append("A." + TBTHB5HIK.IRMONTH5);                //依頼月5
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "'");
            sql.append(" OR ");

            sql.append("A." + TBTHB5HIK.IRMONTH6);                //依頼月6
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "' ) ");
        }
        //媒体コードが【新聞】の場合
        else if(_cond.getSyubetsu().compareTo(BAICD_SHINBUN) == 0){
            sql.append(" AND ");
            sql.append("A." + TBTHB5HIK.RECCD);                  //レコード種別
            sql.append(" = ");
            sql.append("'H'");

            sql.append(" AND ");
            sql.append("A." + TBTHB5HIK.IRYYMM);                 //依頼年月
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "'");
        }
        else{
            sql.append(" AND ");
            sql.append("A." + TBTHB5HIK.IRYYMM);                 //依頼年月
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "'");
        }

        sql.append(" ORDER BY ");
        sql.append("A." + TBTHB5HIK.IRBAN + ",");                 //発注番号
        sql.append("A." + TBTHB5HIK.IRROWBAN + ",");              //行番号
        sql.append("A." + TBTHB5HIK.RIRENO );                     //履歴管理番号

        return sql.toString();
    }

    /**
     * 発注テーブルの検索を行います。
     *
     * @return 発注テーブルVOリスト
     * @throws UserException データアクセス中にエラーが発生した場合。
     */
    @SuppressWarnings("unchecked")
    public List<HikVO> findByCondition(HikCommonCondition cond) throws KKHException {

        super.setModel(new HikVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * Modelの生成を行う<br>
     * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
     * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
     *
     * @param hashList List 検索結果
     * @return List<HikVO> 変換後の検索結果
     */
    @Override
    protected List<HikVO> createFindedModelInstances(List hashList) {
        List<HikVO> list = new ArrayList<HikVO>();
        if (getModel() instanceof HikVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                HikVO vo = new HikVO();
                //VOListに入れ直す処理を行う
                vo.setKouKbn(((String)result.get(TBTHB5HIK.KOUKBN)).trim());                  //更新区分
                vo.setRireNo(((String)result.get(TBTHB5HIK.RIRENO)).trim());                  //履歴管理番号
                vo.setIryymm(((String)result.get(TBTHB5HIK.IRYYMM)).trim());                  //依頼年月
                vo.setIrban((((String)result.get(TBTHB5HIK.IRBAN))).trim());                  //発注番号
                vo.setIrrowban(((String)result.get(TBTHB5HIK.IRROWBAN)).trim());              //行番号
                vo.setMediaCd(((String)result.get(TBTHB5HIK.MEDIACD)).trim());                //メディアコード
                vo.setMediaName(((String)result.get(TBTHB5HIK.MEDIANAME)).trim());            //メディア名
                vo.setSizeCd(((String)result.get(TBTHB5HIK.SIZECD)).trim());                  //サイズコード
                vo.setKeisai1(((String)result.get(TBTHB5HIK.KEISAI1)).trim());                //掲載日1
                vo.setKeisai2(((String)result.get(TBTHB5HIK.KEISAI2)).trim());                //掲載日2
                vo.setKeisai3(((String)result.get(TBTHB5HIK.KEISAI3)).trim());                //掲載日3
                vo.setKeisai4(((String)result.get(TBTHB5HIK.KEISAI4)).trim());                //掲載日4
                vo.setKeisai5(((String)result.get(TBTHB5HIK.KEISAI5)).trim());                //掲載日5
                vo.setKeitaiCd(((String)result.get(TBTHB5HIK.KEITAICD)).trim());              //形態区分コード
                vo.setKeitaiName(((String)result.get(TBTHB5HIK.KEITAINAME)).trim());          //形態区分名
                vo.setIrmonth1(((String)result.get(TBTHB5HIK.IRMONTH1)).trim());              //依頼月1
                vo.setHosoryo1(((BigDecimal)result.get(TBTHB5HIK.HOSORYO1)));                 //放送料1
                vo.setIrmonth2(((String)result.get(TBTHB5HIK.IRMONTH2)).trim());              //依頼月2
                vo.setHosoryo2((BigDecimal)result.get(TBTHB5HIK.HOSORYO2));                   //放送料2
                vo.setIrmonth3(((String)result.get(TBTHB5HIK.IRMONTH3)).trim());              //依頼月3
                vo.setHosoryo3((BigDecimal)result.get(TBTHB5HIK.HOSORYO3));                   //放送料3
                vo.setIrmonth4(((String)result.get(TBTHB5HIK.IRMONTH4)).trim());              //依頼月4
                vo.setHosoryo4((BigDecimal)result.get(TBTHB5HIK.HOSORYO4));                   //放送料4
                vo.setIrmonth5(((String)result.get(TBTHB5HIK.IRMONTH5)).trim());              //依頼月5
                vo.setHosoryo5((BigDecimal)result.get(TBTHB5HIK.HOSORYO5));                   //放送料5
                vo.setIrmonth6(((String)result.get(TBTHB5HIK.IRMONTH6)).trim());              //依頼月6
                vo.setHosoryo6((BigDecimal)result.get(TBTHB5HIK.HOSORYO6));                   //放送料6
                vo.setKotukeiCd(((String)result.get(TBTHB5HIK.KOTUKEICD)).trim());            //交通掲載コード
                vo.setKotukeiName((String)result.get(TBTHB5HIK.KOTUKEINAME));                 //交通掲載名

                //新聞の場合,
                if(_cond.getSyubetsu().compareTo(BAICD_SHINBUN) == 0)
                {
                    int DataMax = Integer.parseInt(((String)result.get(TBTHB5HIK.KEISAICNT)).trim());
                    String tmp = "";
                    String chdata = ((String)result.get(TBTHB5HIK.KEISAI)).trim();
                    int pos = 1;

                    for(int cnt = 0; cnt < DataMax;cnt++){
                        pos = chdata.indexOf("1",pos);  //文字列から1の位置を取得
                        if(pos == -1){
                            break;

                        }else{
                            tmp = tmp +  "," + String.format("%1$02d",pos + 1);
                            pos = pos + 1;
                        }
                    }

                    //先頭のカンマを除去する
                    if(tmp.length() > 1){
                        tmp = tmp.substring(1,tmp.length());
                    }

                    vo.setKeisai(tmp);                  //掲載日
                    vo.setSpaceName(((String)result.get(TBTHB5HIK.SPACENAME)).trim());   //スペース
                }
                else
                {
                    vo.setKeisai(((String)result.get(TBTHB5HIK.KEISAI)).trim());      //掲載日
                    vo.setSizeName(((String)result.get(TBTHB5HIK.SIZENAME)).trim());   //サイズ
                }

                vo.setKeisairyo((BigDecimal)result.get(TBTHB5HIK.KEISAIRYO));                 //掲載料
                vo.setKeisaiTanka(((String)result.get(TBTHB5HIK.KEISAITANKA)).trim());        //掲載単価
                vo.setKeisaiCnt(((String)result.get(TBTHB5HIK.KEISAICNT)).trim());            //掲載回数
                vo.setSyohiKbn(((String)result.get(TBTHB5HIK.SYOHIKBN)).trim());              //商品区分
                vo.setSaiKbn(((String)result.get(TBTHB5HIK.SAIKBN)).trim());                  //細目区分
                vo.setTekiCd(((String)result.get(TBTHB5HIK.TEKICD)).trim());                  //摘要コード
                vo.setUriyymm(((String)result.get(TBTHB5HIK.URIYYMM)).trim());                //売上予定年月
                vo.setTanName(((String)result.get(TBTHB5HIK.TANNAME)).trim());                //担当者名
                vo.setTankinName(((String)result.get(TBTHB5HIK.TANKINNAME)).trim());          //担当者勤務部署名
                vo.setAnsyube(((String)result.get(TBTHB5HIK.ANSYUBE)).trim());                //按分種別
                vo.setBikou1((String)result.get(TBTHB5HIK.BIKOU1));                           //備考1
                vo.setBikou2((String)result.get(TBTHB5HIK.BIKOU2));                           //備考2
                vo.setColorCd((String)result.get(TBTHB5HIK.COLORCD));                         //色刷コード
                vo.setSpaceCd((String)result.get(TBTHB5HIK.SPACECD));                         //スペースコード
                vo.setSybt1Cd((String)result.get(TBTHB5HIK.SYBT1CD));                         //種別１コード
                vo.setSybt2Cd((String)result.get(TBTHB5HIK.SYBT2CD));                         //種別２コード
                vo.setDesignCnt((String)result.get(TBTHB5HIK.DESIGNCNT));                     //デザイン変更回数
                vo.setPlaceCd((String)result.get(TBTHB5HIK.PLACECD));                         //掲載場所コード
                vo.setPrintryo((BigDecimal)result.get(TBTHB5HIK.PRINTRYO));                   //印刷代
                vo.setSashikaeryo((BigDecimal)result.get(TBTHB5HIK.SASHIKAERYO));             //差替作業料
                vo.setDesignryo((BigDecimal)result.get(TBTHB5HIK.DESIGNRYO));                 //デザイン料
                vo.setHanshitaryo((BigDecimal)result.get(TBTHB5HIK.HANSHITARYO));             //版下代
                vo.setSeihanryo((BigDecimal)result.get(TBTHB5HIK.SEIHANRYO));                 //製版代
                vo.setTouDate((String)result.get(TBTHB5HIK.TOUDATE));                         //登録年月日
                vo.setHenDate((String)result.get(TBTHB5HIK.HENDATE));                         //変更年月日
                vo.setTorDate((String)result.get(TBTHB5HIK.TORDATE));                         //取消年月日
                vo.setSaisinFlg((String)result.get("SAISINFLG"));                           //最新データ
                vo.setKouKbnName((String)result.get("KOUKBNNAME"));                         //更新区分名
                vo.setStatus((String)result.get("STATUS"));                                 //ステータス

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

    /**
    * Where句の生成を行う<br>
    * ・新規作成(2011/11/10 HLC J.Morobayashi)<BR>
    *
    * @param Tkskgyc
    * @param Tksbmnseqno
    * @param Tkstntseqno
    * @param Syubetsu
    * @param WhereFlg
    * @return tmp 生成されたWhere句文字列
    *
    */
    private String getWhere(String Tkskgycd,String Tksbmnseqno,String Tkstntseqno,String Syubetsu,Boolean WhereFlg ){
        StringBuilder sql = new StringBuilder();
        String tmp = "";

        sql.append(" WHERE ");
        sql.append("A." + TBTHB5HIK.TKSKGYCD );            //得意先コード
        sql.append(" = ");
        sql.append("'" + Tkskgycd + "'");
        sql.append(" AND ");

        sql.append("A." + TBTHB5HIK.TKSBMNSEQNO );         //得意先部門SEQNO
        sql.append(" = ");
        sql.append("'" + Tksbmnseqno + "'");
        sql.append(" AND ");

        sql.append("A." + TBTHB5HIK.TKSTNTSEQNO );         //得意先担当SEQNO
        sql.append(" = ");
        sql.append("'" + Tkstntseqno + "'");
        sql.append(" AND ");

        sql.append("A." + TBTHB5HIK.SYBT );                //媒体コード
        sql.append(" = ");
        sql.append("'" + Syubetsu + "'");

        if(WhereFlg == true){
            sql.append(" AND ");
            sql.append(TBTHB5HIK.IRBAN  + " = " +  "A." + TBTHB5HIK.IRBAN);
            sql.append(" AND ");
            sql.append(TBTHB5HIK.IRROWBAN  + " = "  + "A." + TBTHB5HIK.IRROWBAN);
            tmp = sql.toString().replaceAll("'", "");
        }else{
            tmp = sql.toString();
        }

        return tmp;
    }

}
