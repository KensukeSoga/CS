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
 * ・新規作成(2011/11/14 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
public class HikCheckDataDAO extends AbstractRdbDao {

    public static final String  BAICD_ZASI     = "22";//雑誌
    public static final String  BAICD_SHINBUN  = "21";//新聞
    public static final String  BAICD_DENP     = "11";//電波
    public static final String  BAICD_KOTU     = "31";//交通

    /**マスタ検索条件 */
    private HikCommonCondition _cond;

    /**
     * デフォルトコンストラクタ。
     */
    public HikCheckDataDAO() {
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
        sql.append(TBTHB5HIK.RECCD + ",");         //レコード種別
        sql.append(TBTHB5HIK.IRBAN + ",");         //依頼番号
        sql.append(TBTHB5HIK.IRROWBAN + ",");      //依頼行番号
        sql.append(TBTHB5HIK.RIRENO + ",");        //履歴管理番号
        sql.append(TBTHB5HIK.IRYYMM + ",");        //依頼年月
        sql.append(TBTHB5HIK.IRKBN + ",");         //依頼区分
        sql.append(TBTHB5HIK.TKSKGYCD + ",");      //得意先コード
        sql.append(TBTHB5HIK.EICODE + ",");        //営業部コード
        sql.append(TBTHB5HIK.EINAME + ",");        //営業部名
        sql.append(TBTHB5HIK.TENCD + ",");         //店番
        sql.append(TBTHB5HIK.TENNAME + ",");       //店名
        sql.append(TBTHB5HIK.YOSAKBN + ",");       //予算区分
        sql.append(TBTHB5HIK.IRNAI + ",");         //依頼内容
        sql.append(TBTHB5HIK.SYBT + ",");          //媒体コード
        sql.append(TBTHB5HIK.MEDIACD + ",");       //メディアコード
        sql.append(TBTHB5HIK.MEDIANAME + ",");     //メディア名
        sql.append(TBTHB5HIK.SIZECD + ",");        //サイズコード
        sql.append(TBTHB5HIK.SIZENAME + ",");      //サイズ
        sql.append(TBTHB5HIK.KEISAI1 + ",");       //掲載日1
        sql.append(TBTHB5HIK.KEISAI2 + ",");       //掲載日2
        sql.append(TBTHB5HIK.KEISAI3 + ",");       //掲載日3
        sql.append(TBTHB5HIK.KEISAI4 + ",");       //掲載日4
        sql.append(TBTHB5HIK.KEISAI5 + ",");       //掲載日5
        sql.append(TBTHB5HIK.KEITAICD + ",");      //形態区分コード
        sql.append(TBTHB5HIK.KEITAINAME + ",");    //形態区分名
        sql.append(TBTHB5HIK.IRMONTH1 + ",");      //依頼月1
        sql.append(TBTHB5HIK.HOSORYO1  + ",");     //放送料1
        sql.append(TBTHB5HIK.IRMONTH2 + ",");      //依頼月2
        sql.append(TBTHB5HIK.HOSORYO2 + ",");      //放送料2
        sql.append(TBTHB5HIK.IRMONTH3 + ",");      //依頼月3
        sql.append(TBTHB5HIK.HOSORYO3 + ",");      //放送料3
        sql.append(TBTHB5HIK.IRMONTH4 + ",");      //依頼月4
        sql.append(TBTHB5HIK.HOSORYO4 + ",");      //放送料4
        sql.append(TBTHB5HIK.IRMONTH5 + ",");      //依頼月5
        sql.append(TBTHB5HIK.HOSORYO5 + ",");      //放送料5
        sql.append(TBTHB5HIK.IRMONTH6 + ",");      //依頼月6
        sql.append(TBTHB5HIK.HOSORYO6 + ",");      //放送料6
        sql.append(TBTHB5HIK.KOTUKEICD + ",");     //交通掲載コード
        sql.append(TBTHB5HIK.KOTUKEINAME + ",");   //交通掲載名
        sql.append(TBTHB5HIK.KEISAI + ",");        //掲載日
        sql.append(TBTHB5HIK.KEISAIRYO + ",");     //掲載料
        sql.append(TBTHB5HIK.KEISAITANKA + ",");   //掲載単価
        sql.append(TBTHB5HIK.KEISAICNT + ",");     //掲載回数
        sql.append(TBTHB5HIK.SYOHIKBN + ",");      //商品区分
        sql.append(TBTHB5HIK.SYOHINAME + ",");     //商品区分名称
        sql.append(TBTHB5HIK.SAIKBN + ",");        //細目区分
        sql.append(TBTHB5HIK.TEKICD + ",");        //摘要コード
        sql.append(TBTHB5HIK.URIYYMM + ",");       //売上予定年月
        sql.append(TBTHB5HIK.TANNAME + ",");       //担当者名
        sql.append(TBTHB5HIK.TANKINNAME + ",");    //担当者勤務部署名
        sql.append(TBTHB5HIK.ANSYUBE + ",");       //按分種別
        sql.append(TBTHB5HIK.KOUKBN + ",");        //更新区分
        sql.append(TBTHB5HIK.BIKOU1 + ",");        //備考1
        sql.append(TBTHB5HIK.BIKOU2 + ",");        //備考2
        sql.append(TBTHB5HIK.COLORCD + ",");       //色刷コード
        sql.append(TBTHB5HIK.SPACECD + ",");       //スペースコード
        sql.append(TBTHB5HIK.SPACENAME + ",");       //スペース名称
        sql.append(TBTHB5HIK.SYBT1CD + ",");       //種別１コード
        sql.append(TBTHB5HIK.SYBT2CD + ",");       //種別２コード
        sql.append(TBTHB5HIK.DESIGNCNT + ",");     //デザイン変更回数
        sql.append(TBTHB5HIK.PLACECD + ",");       //掲載場所コード
        sql.append(TBTHB5HIK.PRINTRYO + ",");      //印刷代
        sql.append(TBTHB5HIK.SASHIKAERYO + ",");   //差替作業料
        sql.append(TBTHB5HIK.DESIGNRYO + ",");     //デザイン料
        sql.append(TBTHB5HIK.HANSHITARYO + ",");   //版下代
        sql.append(TBTHB5HIK.SEIHANRYO + ",");     //製版代
        sql.append(TBTHB5HIK.TOUDATE + ",");       //登録年月日
        sql.append(TBTHB5HIK.HENDATE + ",");       //変更年月日
        sql.append(TBTHB5HIK.TORDATE + ",");       //取消年月日
        sql.append("'' AS DUMMY1,");             //ダミー1
        sql.append("'' AS DUMMY2");              //ダミー2

        //From句
        sql.append(" FROM ");
        sql.append(TBTHB5HIK.TBNAME);

        //Where句
        sql.append(getWhere(_cond.getSyubetsu(),false));

        sql.append("(" + TBTHB5HIK.IRBAN + ",");
        sql.append(TBTHB5HIK.IRROWBAN + ",");
        sql.append(TBTHB5HIK.RIRENO + ")");

        //INクエリー
        sql.append(" IN ");
        sql.append(" ( SELECT ");
        sql.append(TBTHB5HIK.IRBAN + ",");
        sql.append(TBTHB5HIK.IRROWBAN + ",");
        sql.append("MAX(" + TBTHB5HIK.RIRENO + ")");
        sql.append(" FROM ");
        sql.append(TBTHB5HIK.TBNAME);

        //Where句
        sql.append(getWhere(_cond.getSyubetsu(),true));

        sql.append(" GROUP BY ");
        sql.append(TBTHB5HIK.IRBAN +",");
        sql.append(TBTHB5HIK.IRROWBAN +")");

        sql.append(" ORDER BY ");
        sql.append(TBTHB5HIK.IRROWBAN);

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
                vo.setRecCd((String)result.get(TBTHB5HIK.RECCD));                    //レコード種別
                vo.setIrban((String)result.get(TBTHB5HIK.IRBAN));                    //依頼番号
                vo.setIrrowban((String)result.get(TBTHB5HIK.IRROWBAN));              //依頼行番号
                vo.setRireNo((String)result.get(TBTHB5HIK.RIRENO));                  //履歴管理番号
                vo.setIryymm((String)result.get(TBTHB5HIK.IRYYMM));                  //依頼年月
                vo.setIrKbn((String)result.get(TBTHB5HIK.IRKBN));                    //依頼区分
                vo.setTksKgyCd((String)result.get(TBTHB5HIK.TKSKGYCD));              //得意先コード
                vo.setEiCode((String)result.get(TBTHB5HIK.EICODE));                  //営業部コード
                vo.setEiName((String)result.get(TBTHB5HIK.EINAME));                  //営業部名
                vo.setTenCd((String)result.get(TBTHB5HIK.TENCD));                    //店番
                vo.setTenName((String)result.get(TBTHB5HIK.TENNAME));                //店名
                vo.setYosaKbn((String)result.get(TBTHB5HIK.YOSAKBN));                //予算区分
                vo.setIrnai((String)result.get(TBTHB5HIK.IRNAI));                    //依頼内容
                vo.setSybt((String)result.get(TBTHB5HIK.SYBT));                      //媒体コード
                vo.setMediaCd((String)result.get(TBTHB5HIK.MEDIACD));                //メディアコード
                vo.setMediaName((String)result.get(TBTHB5HIK.MEDIANAME));            //メディア名
                vo.setSizeCd((String)result.get(TBTHB5HIK.SIZECD));                  //サイズコード
                vo.setSizeName((String)result.get(TBTHB5HIK.SIZENAME));              //サイズ
                vo.setKeisai1((String)result.get(TBTHB5HIK.KEISAI1));                //掲載日1
                vo.setKeisai2((String)result.get(TBTHB5HIK.KEISAI2));                //掲載日2
                vo.setKeisai3((String)result.get(TBTHB5HIK.KEISAI3));                //掲載日3
                vo.setKeisai4((String)result.get(TBTHB5HIK.KEISAI4));                //掲載日4
                vo.setKeisai5((String)result.get(TBTHB5HIK.KEISAI5));                //掲載日5
                vo.setKeitaiCd((String)result.get(TBTHB5HIK.KEITAICD));              //形態区分コード
                vo.setKeitaiName((String)result.get(TBTHB5HIK.KEITAINAME));          //形態区分名
                vo.setIrmonth1((String)result.get(TBTHB5HIK.IRMONTH1));              //依頼月1
                vo.setHosoryo1((BigDecimal)result.get(TBTHB5HIK.HOSORYO1 ));         //放送料1
                vo.setIrmonth2((String)result.get(TBTHB5HIK.IRMONTH2));              //依頼月2
                vo.setHosoryo2((BigDecimal)result.get(TBTHB5HIK.HOSORYO2));          //放送料2
                vo.setIrmonth3((String)result.get(TBTHB5HIK.IRMONTH3));              //依頼月3
                vo.setHosoryo3((BigDecimal)result.get(TBTHB5HIK.HOSORYO3));          //放送料3
                vo.setIrmonth4((String)result.get(TBTHB5HIK.IRMONTH4));              //依頼月4
                vo.setHosoryo4((BigDecimal)result.get(TBTHB5HIK.HOSORYO4));          //放送料4
                vo.setIrmonth5((String)result.get(TBTHB5HIK.IRMONTH5));              //依頼月5
                vo.setHosoryo5((BigDecimal)result.get(TBTHB5HIK.HOSORYO5));          //放送料5
                vo.setIrmonth6((String)result.get(TBTHB5HIK.IRMONTH6));              //依頼月6
                vo.setHosoryo6((BigDecimal)result.get(TBTHB5HIK.HOSORYO6));          //放送料6
                vo.setKotukeiCd((String)result.get(TBTHB5HIK.KOTUKEICD));            //交通掲載コード
                vo.setKotukeiName((String)result.get(TBTHB5HIK.KOTUKEINAME));        //交通掲載名
                vo.setKeisai((String)result.get(TBTHB5HIK.KEISAI));                  //掲載日
                vo.setKeisairyo((BigDecimal)result.get(TBTHB5HIK.KEISAIRYO));        //掲載料

                /*
                    //媒体が【新聞】の場合は下記の処理を行う
                    if((result.get(TBTHB5HIK.SYBT)).equals(BAICD_SHINBUN) ){
                        Double tmp = 0.0d;
                        tmp = Double.parseDouble(((String)result.get(TBTHB5HIK.KEISAITANKA))) / 100;
                        vo.setKeisaiTanka(tmp.toString());                                           //掲載単価
                    }else{
                        Double tmp = 0.0d;
                        tmp = Double.parseDouble(((String)result.get(TBTHB5HIK.KEISAITANKA)).substring(1,9));
                        vo.setKeisaiTanka(tmp.toString());                                             //掲載単価
                        //vo.setKeisaiTanka(((String)result.get(TBTHB5HIK.KEISAITANKA)).substring(1,9)); //掲載単価
                    }
                */

                vo.setKeisaiTanka((String)result.get(TBTHB5HIK.KEISAITANKA));        //掲載単価
                vo.setKeisaiCnt((String)result.get(TBTHB5HIK.KEISAICNT));            //掲載回数
                vo.setSyohiKbn((String)result.get(TBTHB5HIK.SYOHIKBN));              //商品区分
                vo.setSaiKbn((String)result.get(TBTHB5HIK.SAIKBN));                  //細目区分
                vo.setTekiCd((String)result.get(TBTHB5HIK.TEKICD));                  //摘要コード
                vo.setUriyymm((String)result.get(TBTHB5HIK.URIYYMM));                //売上予定年月
                vo.setTanName((String)result.get(TBTHB5HIK.TANNAME));                //担当者名
                vo.setTankinName((String)result.get(TBTHB5HIK.TANKINNAME));          //担当者勤務部署名
                vo.setAnsyube((String)result.get(TBTHB5HIK.ANSYUBE));                //按分種別
                vo.setKouKbn((String)result.get(TBTHB5HIK.KOUKBN));                  //更新区分
                vo.setBikou1((String)result.get(TBTHB5HIK.BIKOU1));                  //備考1
                vo.setBikou2((String)result.get(TBTHB5HIK.BIKOU2));                  //備考2
                vo.setColorCd((String)result.get(TBTHB5HIK.COLORCD));                //色刷コード
                vo.setSpaceCd((String)result.get(TBTHB5HIK.SPACECD));                //スペースコード
                vo.setSpaceName((String)result.get(TBTHB5HIK.SPACENAME));            //スペース名称
                vo.setSybt1Cd((String)result.get(TBTHB5HIK.SYBT1CD));                //種別１コード
                vo.setSybt2Cd((String)result.get(TBTHB5HIK.SYBT2CD));                //種別２コード
                vo.setDesignCnt((String)result.get(TBTHB5HIK.DESIGNCNT));            //デザイン変更回数
                vo.setPlaceCd((String)result.get(TBTHB5HIK.PLACECD));                //掲載場所コード
                vo.setPrintryo((BigDecimal)result.get(TBTHB5HIK.PRINTRYO));          //印刷代
                vo.setSashikaeryo((BigDecimal)result.get(TBTHB5HIK.SASHIKAERYO));    //差替作業料
                vo.setDesignryo((BigDecimal)result.get(TBTHB5HIK.DESIGNRYO));        //デザイン料
                vo.setHanshitaryo((BigDecimal)result.get(TBTHB5HIK.HANSHITARYO));    //版下代
                vo.setSeihanryo((BigDecimal)result.get(TBTHB5HIK.SEIHANRYO));        //製版代
                vo.setTouDate((String)result.get(TBTHB5HIK.TOUDATE));                //登録年月日
                vo.setHenDate((String)result.get(TBTHB5HIK.HENDATE));                //変更年月日
                vo.setTorDate((String)result.get(TBTHB5HIK.TORDATE));                //取消年月日
                vo.setKouKbnName((String)result.get("KOUKBNNAME"));                //更新区分名
                vo.setDummy1((String)result.get("DUMMY1"));                        //ダミー1
                vo.setDummy2((String)result.get("DUMMY2"));                        //ダミー2

                // 検索結果直後の状態にする
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

    private String getWhere(String Sybt,boolean InqFlg){

        StringBuilder sql = new StringBuilder();

        sql.append(" WHERE ");
        sql.append(TBTHB5HIK.TKSKGYCD );                    //得意先コード
        sql.append(" = ");
        sql.append("'" + _cond.getTkskgycd() + "'");
        sql.append(" AND ");

        sql.append(TBTHB5HIK.TKSBMNSEQNO );                  //得意先部門SEQNO
        sql.append(" = ");
        sql.append("'" + _cond.getTksbmnseqno() + "'");
        sql.append(" AND ");

        sql.append(TBTHB5HIK.TKSTNTSEQNO );                  //得意先担当SEQNO
        sql.append(" = ");
        sql.append("'" + _cond.getTkstntseqno() + "'");
        sql.append(" AND ");

        sql.append(TBTHB5HIK.IRBAN);                          //発注番号
        sql.append(" = ");
        sql.append("'" + _cond.getIrban() + "'");
        sql.append(" AND ");

        sql.append(TBTHB5HIK.IRROWBAN);                       //発注行番号
        sql.append(" = ");
        sql.append("'" + _cond.getIrrowban() + "'");
        sql.append(" AND ");

        sql.append(TBTHB5HIK.RECCD);                          //レコード種別
        sql.append(" = ");
        sql.append("'" + _cond.getRecCd() + "'");
        sql.append(" AND ");

        //媒体が【新聞】以外の場合
        if(Sybt.equals(BAICD_SHINBUN ) == false){
            sql.append(TBTHB5HIK.SYBT );                       //媒体コード
            sql.append(" = ");
            sql.append("'" + _cond.getSyubetsu() + "'");
            sql.append(" AND ");
        }

        //Inクエリーの場合、"AND"を除去する
        if(InqFlg == true){
            return sql.toString().substring(0,sql.length() - 5);
        }
        return sql.toString();
    }

}
