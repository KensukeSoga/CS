package jp.co.isid.kkh.util.constants;

/**
 * <P>
 * 広告費明細システム定数クラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/01 JSE H.Abe)<BR>
 * ・得意先ログイン無効化対応(2017/02/08 HLC K.Soga)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class KKHConstants {

    /** インスタンス生成禁止 */
    private KKHConstants() {
    }

    /** 2017/02/09 得意先ログイン無効化対応 HLC K.Soga ADD Start */
    /**
     * フラグ
     */
    /** フラグ:ON */
    public static final String FLAG_ON = "1";
    /** フラグ:OFF */
    public static final String FLAG_OFF = "0";

    /**
     * ユーザー種別
     */
    /** 通常ユーザー */
    public static final String USER_KIND_NORMAL = "0";
    /** スーパーユーザー */
    public static final String USER_KIND_SUPER = "1";
    /** 特別ログインユーザー */
    public static final String USER_KIND_SPECIAL_LOGIN = "2";

    /**
     * 相対権限
     */
    /** 部権限 */
    public static final String RELATIVE_AUTHORITY_BU = "7";
    /** 局権限 */
    public static final String RELATIVE_AUTHORITY_KYOKU = "31";

    /**
     * 汎用システムマスタ(種別)
     */
    /** 999-REPEAL:廃止フラグ */
    public static final String SYBT_REPEALFLG = "999";

    /**
     * 汎用システムマスタ(フィールド1)
     */
    /** 999-REPEAL:廃止フラグ */
    public static final String FIELD1_REPEALFLG = "REPEALFLG";
    /** 2017/02/09 得意先ログイン無効化対応 HLC K.Soga ADD End */

    /**
     * 得意先コード
     */
    public enum TksKgyCode {
        /** アコム */
        ACOM("0088260101","アコム"),
        /** アサヒビール */
        ASH("0168020101","アサヒビール"),
        /** 2016/01/29 アサヒ飲料カルピス対応 JSE A.Hisada ADD Start */
        /** アサヒ飲料 */
        ASHI("2851470301","アサヒ飲料"),
        /** 2016/01/29 アサヒ飲料カルピス対応 JSE A.Hisada ADD End */
        /** スカパー */
        SKYP("6954651301","スカパー"),
        /** ユニチャーム */
        UNI("0310540201","ユニチャーム"),
        /** ライオン */
        LION("1809830201","ライオン"),
        /** 武田製薬 */
        TKD("3855040303","武田製薬"),
        /** マクドナルド */
        MAC("2711430101","マクドナルド"),
        /** エプソン */
        EPS("0040170101","エプソン"),
        /** 東宝 */
        TOH("4007020601","東宝"),
        /** 2015/06/11 東宝アド対応 HLC K.Soga ADD Start */
        /** 東宝アド */
        TOHAD("4006480301","東宝アド"),
        /** 2015/06/11 東宝アド対応 HLC K.Soga ADD End */
        /** 公文 */
        KMN("0470200101","公文"),
        /** 2015/04/01 公文得意先変更対応 HLC K.Fujisaki ADD Start */
        /** 公文(公文得意先変更対応)  */
        KMN_2015("1709810401","公文");
        /** 2015/04/01 公文得意先変更対応 HLC K.Fujisaki ADD End */

        private final String _code;
        private final String _name;

        //コンストラクタ
        private TksKgyCode(String code,String name){
            _code = code;
            _name = name;
        }

        //コード取得
        public String getCode() {
            return _code;
        }

        //名称取得
        public String getName() {
            return _name;
        }
    }

    /**
     * 請求区分
     */
    public enum SeiKbn {
        /** 新聞 */
        NEWSPAPER("11","新聞"),
        /** 雑誌 */
        MAGAZINE("21","雑誌"),
        /** タイム */
        TIME("41","タイム"),
        /** スポット */
        SPOT("42","スポット"),
        /** IC */
        IC("61","IC"),
        /** 交通広告 */
        OOH("71","OOH"),
        /** 諸作業 */
        WORKS("81","諸作業"),
        /** 国際マス */
        KMAS("31","国際マス"),
        /** 国際(諸作業）*/
        KWORKS("32","国際(諸作業）");

        private final String _code;
        private final String _name;

        //コンストラクタ
        private SeiKbn(String code,String name){
            _code = code;
            _name = name;
        }

        //コード取得
        public String getCode() {
            return _code;
        }

        //名称取得
        public String getName() {
            return _name;
        }
    }

    /**
     * 業務区分
     */
    public enum GyomKbn {
        /** 新聞 */
        SHINBUN("11010","新聞"),
        /** 雑誌 */
        ZASHI("11020","雑誌"),
        /** ラジオ */
        RADIO("11030","ラジオ"),
        /** テレビタイム */
        TVTIME("11040","テレビタイム"),
        /** テレビスポット */
        TVSPOT("11045","テレビスポット"),
        /** 衛星メディア */
        EISEIM("11050","衛星メディア"),
        /** インタラクティブメディア */
        INTERACTIVEM("11060","インタラクティブメディア"),
        /** OOHメディア */
        OOHM("11070","OOHメディア"),
        /** その他メディア */
        SONOTAM("11080","その他メディア"),
        /** メディアプランニング */
        MPLAN("11090","メディアプランニング"),
        /** クリエーティブ */
        CREATIVE("12010","クリエーティブ"),
        /** マーケティング/プロモーション */
        MARKEPROMO("13010","マーケティング/プロモーション"),
        /** スポーツ */
        SPORTS("14010","スポーツ"),
        /** エンタテイメント */
        ENTERTAINMENT("14020","エンタテイメント"),
        /** その他コンテンツ */
        SONOTAC("14030","その他コンテンツ");

        private final String _code;
        private final String _name;

        //コンストラクタ
        private GyomKbn(String code,String name){
            _code = code;
            _name = name;
        }

        //コード取得
        public String getCode() {
            return _code;
        }

        //名称取得
        public String getName() {
            return _name;
        }
    }

    /**
     * 種別
     */
    public enum Shubetsu {
        /** テレビ番組 */
        TV_BANGUMI("001","TV番組"),
        /** テレビ特番 */
        TV_TOKUBAN("002","TV特番"),
        /** テレビスポット */
        TV_SPOT("003","TV SPOT"),
        /** 雑誌 */
        ZASHI("004","雑誌"),
        /** 新聞 */
        SHINBUN("005","新聞"),
        /** その他 */
        SONOTA("006","その他"),
        /** 製作 */
        SEISAKU("007","製作");

        private final String _code;
        private final String _name;

        //コンストラクタ
        private Shubetsu(String code,String name){
            _code = code;
            _name = name;
        }

        //コード取得
        public String getCode() {
            return _code;
        }

        //名称取得
        public String getName() {
            return _name;
        }
    }
}
