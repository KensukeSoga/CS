package jp.co.isid.kkh.customer.acom.model.input;


import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.input.HikVO;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * 発注データ登録DAO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/14 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
public class HikRegistDAO extends AbstractSimpleRdbDao  {

    /**
     * デフォルトコンストラクタ。
     */
    public HikRegistDAO() {
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
        return new String[]{
            TBTHB5HIK.TRKTIMSTMP,     //登録タイムスタンプ (TRKTIMSTMP)
            TBTHB5HIK.UPDTIMSTMP,     //更新タイムスタンプ (UPDTIMSTMP)
        };
    }

    /**
     * 更新日付フィールドを返します。
     *
     * @return String 更新日付フィールド
     */
    public String getTimeStampKeyName() {
        return TBTHB5HIK.TRKTIMSTMP;   //更新タイムスタンプ (UPDTIMSTMP)
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
        		TBTHB5HIK.TRKTIMSTMP,     //登録タイムスタンプ (TRKTIMSTMP)
        	    TBTHB5HIK.TRKPL,          //登録プログラム (TRKPL)
        	    TBTHB5HIK.TRKTNT,         //登録担当者 (TRKTNT)
        	    TBTHB5HIK.UPDTIMSTMP,     //更新タイムスタンプ (UPDTIMSTMP)
        	    TBTHB5HIK.UPDAPL,         //更新プログラム (UPDAPL)
        	    TBTHB5HIK.UPDTN,          //更新担当者 (UPDTNT)
        	    TBTHB5HIK.EGCD,           //営業所（取）コード (EGCD)
        	    TBTHB5HIK.TKSKGYCD,       //得意先企業コード (TKSKGYCD)
        	    TBTHB5HIK.TKSBMNSEQNO,    //得意先部門SEQNO (TKSBMNSEQNO)
        	    TBTHB5HIK.TKSTNTSEQNO,    //得意先担当SEQNO (TKSTNTSEQNO)
        	    TBTHB5HIK.SYBT,           //媒体コード (SYBT)
        	    TBTHB5HIK.RECCD,          //レコード種別 (RECCD)
        	    TBTHB5HIK.KOUKBN,         //更新区分 (KOUKBN)
        	    TBTHB5HIK.RIRENO,         //履歴管理番号 (RIRENO)
        	    TBTHB5HIK.IRYYMM,         //依頼年月 (IRYYMM)
        	    TBTHB5HIK.IRKBN,          //依頼区分 (IRKBN)
        	    TBTHB5HIK.TOKUICD,        //得意先コード (TOKUICD)
        	    TBTHB5HIK.EICODE,         //営業部コード (EICODE)
        	    TBTHB5HIK.EINAME,         //営業部名 (EINAME)
        	    TBTHB5HIK.TENCD,          //店番 (TENCD)
        	    TBTHB5HIK.TENNAME,        //店名 (TENNAME)
        	    TBTHB5HIK.YOSAKBN,        //予算区分 (YOSAKBN)
        	    TBTHB5HIK.IRNAI,          //依頼内容 (IRNAI)
        	    TBTHB5HIK.IRBAN,          //発注番号 (IRBAN)
        	    TBTHB5HIK.IRROWBAN,       //行番号 (IRROWBAN)
        	    TBTHB5HIK.MEDIACD,        //メディアコード (MEDIACD)
        	    TBTHB5HIK.MEDIANAME,      //メディア名 (MEDIANAME)
        	    TBTHB5HIK.SIZECD,         //サイズコード (SIZECD)
        	    TBTHB5HIK.SIZENAME,       //サイズ名 (SIZENAME)
        	    TBTHB5HIK.KEISAI1,        //掲載日1 (KEISAI1)
        	    TBTHB5HIK.KEISAI2,        //掲載日2 (KEISAI2)
        	    TBTHB5HIK.KEISAI3,        //掲載日3 (KEISAI3)
        	    TBTHB5HIK.KEISAI4,        //掲載日4 (KEISAI4)
        	    TBTHB5HIK.KEISAI5,        //掲載日5 (KEISAI5)
        	    TBTHB5HIK.KEITAICD,       //形態区分コード (KEITAICD)
        	    TBTHB5HIK.KEITAINAME,     //形態区分名 (KEITAINAME)
        	    TBTHB5HIK.IRMONTH1,       //依頼月1 (IRMONTH1)
        	    TBTHB5HIK.HOSORYO1,       //放送料1 (HOSORYO1)
        	    TBTHB5HIK.IRMONTH2,       //依頼月2 (IRMONTH2)
        	    TBTHB5HIK.HOSORYO2,       //放送料2 (HOSORYO2)
        	    TBTHB5HIK.IRMONTH3,       //依頼月3 (IRMONTH3)
        	    TBTHB5HIK.HOSORYO3,       //放送料3 (HOSORYO3)
        	    TBTHB5HIK.IRMONTH4,       //依頼月4 (IRMONTH4)
        	    TBTHB5HIK.HOSORYO4,       //放送料4 (HOSORYO4)
        	    TBTHB5HIK.IRMONTH5,       //依頼月5 (IRMONTH5)
        	    TBTHB5HIK.HOSORYO5,       //放送料5 (HOSORYO5)
        	    TBTHB5HIK.IRMONTH6,       //依頼月6 (IRMONTH6)
        	    TBTHB5HIK.HOSORYO6,       //放送料6 (HOSORYO6)
        	    TBTHB5HIK.KOTUKEICD,      //交通掲載コード (KOTUKEICD)
        	    TBTHB5HIK.KOTUKEINAME,    //交通掲載名 (KOTUKEINAME)
        	    TBTHB5HIK.KEISAI,         //掲載日 (KEISAI)
        	    TBTHB5HIK.KEISAIRYO,      //掲載料 (KEISAIRYO)
        	    TBTHB5HIK.KEISAITANKA,    //掲載単価 (KEISAITANKA)
        	    TBTHB5HIK.KEISAICNT,      //掲載回数 (KEISAICNT)
        	    TBTHB5HIK.SYOHIKBN,       //商品区分 (SYOHIKBN)
        	    TBTHB5HIK.SYOHINAME,      //商品区分名称 (SYOHINAME)
        	    TBTHB5HIK.SAIKBN,         //細目区分 (SAIKBN)
        	    TBTHB5HIK.TEKICD,         //摘要コード (TEKICD)
        	    TBTHB5HIK.URIYYMM,        //売上予定年月 (URIYYMM)
        	    TBTHB5HIK.TANNAME,        //担当者名 (TANNAME)
        	    TBTHB5HIK.TANKINNAME,     //担当者勤務部署名 (TANKINNAME)
        	    TBTHB5HIK.ANSYUBE,        //按分種別 (ANSYUBE)
        	    TBTHB5HIK.BIKOU1,         //備考1 (BIKOU1)
        	    TBTHB5HIK.BIKOU2,         //備考2 (BIKOU2)
        	    TBTHB5HIK.COLORCD,        //色刷コード (COLORCD )
        	    TBTHB5HIK.SPACECD,        //スペースコード (SPACECD )
        	    TBTHB5HIK.SPACENAME,      //スペース名 (SPACENAME )
        	    TBTHB5HIK.SYBT1CD,        //種別１コード (SYBT1CD )
        	    TBTHB5HIK.SYBT2CD,        //種別２コード (SYBT2CD )
        	    TBTHB5HIK.DESIGNCNT,      //デザイン変更回数 (DESIGNCNT )
        	    TBTHB5HIK.PLACECD,        //掲載場所コード (PLACECD )
        	    TBTHB5HIK.PRINTRYO,       //印刷代 (PRINTRYO)
        	    TBTHB5HIK.SASHIKAERYO,    //差替作業料 (SASHIKAERYO)
        	    TBTHB5HIK.DESIGNRYO,      //デザイン料 (DESIGNRYO)
        	    TBTHB5HIK.HANSHITARYO,    //版下代 (HANSHITARYO)
        	    TBTHB5HIK.SEIHANRYO,      //製版代 (SEIHANRYO)
        	    TBTHB5HIK.TOUDATE,        //登録年月日 (TOUDATE)
        	    TBTHB5HIK.HENDATE,        //変更年月日 (HENDATE)
        	    TBTHB5HIK.TORDATE         //取消年月日 (TORDATE)
        };
    }

    /**
     * 発注データの登録を行います。
     *
     * @param vo VO 発注データVO
     * @throws UserException データアクセス中にエラーが発生した場合
     */
    public void registHik(HikVO vo) throws KKHException {
        //パラメータチェック
        if (vo == null) {
            throw new KKHException("登録エラー", "BD-E0002");
        }
        super.setModel(vo);
        try {
            if (!super.insert()) {
                throw new KKHException("登録エラー", "BD-E0002");
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }
}