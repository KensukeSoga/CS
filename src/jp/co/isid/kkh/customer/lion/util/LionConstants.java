package jp.co.isid.kkh.customer.lion.util;

/**
 * <P>
 * 広告費明細システム、ライオン定数クラス。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成<BR>
 * </P>
 *
 * @author
 */
public class LionConstants {

    /**
     * インスタンス生成禁止。
     */
    private LionConstants() {
    }

    /**
     * 媒体コード
     */
    public enum BaitaiCode {

        /** テレビタイム */
        TV_TIME("1","テレビタイム"),

        /** ラジオタイム */
        RD_TIME("2","ラジオタイム"),

        /** テレビスポット */
        TV_SPOT("3","テレビスポット"),

        /** ラジオスポット */
        RD_SPOT("4","ラジオスポット"),

        /** 新聞 */
        SHINBUN("5","新聞"),

        /** 雑誌 */
        ZASHI("6","雑誌"),

        /** その他 */
        SONOTA("7","その他"),

        /** 交通 */
        KOTSU("8","交通"),

        /** 制作 */
        SEISAKU("9","制作"),

        /** テレビCM秒数 */
        TV_CM("10","テレビCM秒数"),

        /** ラジオCM秒数 */
        RD_CM("11","ラジオCM秒数"),

        /** チラシ */
        CHIRASHI("12","チラシ"),

        /** サンプリング */
        SAMPLING("13","サンプリング"),

        /** BS・CS */
        BS_CS("14","ＢＳ・ＣＳ"),

        /** インターネット */
        INTERNET("15","インターネット"),

        //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod Start
        //名称変更
        /** モバイル */
        MOBILE("16","モバイル(廃止)"),
//        /** モバイル */
//        MOBILE("16","モバイル"),
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod End

        /** 事業費 */
        JIGYOHI("17","事業費"),

    	//2017/06/05 ライオン対応 ITCOM A.Nakamura Add Start
    	//ソーシャルメディアとデジタル動画を追加
        /** ソーシャルメディア */
        SOCIALMEDIA("1B","ソーシャルメディア"),

        /** デジタル動画 */
        DIGITALMOVIE("1C","デジタル動画");
    	//2017/06/05 ライオン対応 ITCOM A.Nakamura Add End


        private final String _code;
        private final String _name;

        // コンストラクタ
        private BaitaiCode(String code,String name){
            _code = code;
            _name = name;
        }

        // コード取得
        public String getCode() {
            return _code;
        }

        // 名称取得
        public String getName() {
            return _name;
        }
    }

    /**
     * Field1コード(カードNO一覧で使用)
     */
    public enum Field1Code {

        /** テレビタイム */
        TV_TIME("01","テレビタイム"),

        /** ラジオタイム */
        RD_TIME("04","ラジオタイム"),

        /** テレビスポット */
        TV_SPOT("02","テレビスポット"),

        /** ラジオスポット */
        RD_SPOT("05","ラジオスポット"),

        /** 新聞 */
        SHINBUN("07","新聞"),

        /** 雑誌 */
        ZASHI("09","雑誌"),

        /** 交通 */
        KOTSU("11","交通"),

        /** その他 */
        SONOTA("13","その他"),

        /** 制作 */
        SEISAKU1("20","制作"),
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod Start
        //制作の媒体区分を20～39→20～43へ
        /** 制作 */
        SEISAKU2("43","制作"),
//        /** 制作 */
//        SEISAKU2("39","制作"),
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod Start

        /** チラシ */
        CHIRASHI("14","チラシ"),

        /** サンプリング */
        SAMPLING("15","サンプリング"),

        /** BS・CS */
        BS_CS("16","ＢＳ・ＣＳ"),

        /** インターネット */
        INTERNET("17","インターネット"),

      //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod Start
        /** モバイル */
        MOBILE("18","モバイル(廃止)"),
//        /** モバイル */
//        MOBILE("18","モバイル"),
      //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod End

        /** 事業費 */
        JIGYOHI("19","事業費"),

    	//2017/06/05 ライオン対応 ITCOM A.Nakamura Add Start
    	/** ソーシャルメディア */
        SOCIALMEDIA("1B","ソーシャルメディア"),

        /** デジタル動画 */
        DIGITALMOVIE("1C","デジタル動画");
    	//2017/06/05 ライオン対応 ITCOM A.Nakamura Add End

        private final String _code;
        private final String _name;

        // コンストラクタ
        private Field1Code(String code,String name){
            _code = code;
            _name = name;
        }

        // コード取得
        public String getCode() {
            return _code;
        }

        // 名称取得
        public String getName() {
            return _name;
        }
    }


    /**
     * 媒体コード
     */
    public enum BaitaiKbn {

        /** テレビスポット */
        TV_SPOT("02","テレビスポット"),

        /** ラジオスポット */
        RD_SPOT("05","ラジオスポット");

        private final String _code;
        private final String _name;

        // コンストラクタ
        private BaitaiKbn(String code,String name){
            _code = code;
            _name = name;
        }

        // コード取得
        public String getCode() {
            return _code;
        }

        // 名称取得
        public String getName() {
            return _name;
        }
    }

    /**
     * 得意先コード
     */
    public enum TksKgyCode {

        /** アコム */
        ACOM("0088260101","アコム"),

        /** アサヒビール */
        ASH("0168020101","アサヒビール"),

        /** スカパー */
        SKYP("0168020101","スカパー"),

        /** ユニチャーム */
        UNI("0310540201","ユニチャーム"),

        /** ライオン */
        LION("1809830201","ライオン"),

        /** 武田製薬 */
        TKD("3855040303","武田製薬"),

        /** マクドナルド */
        MAC("2711430101","マクドナルド"),

        /** 東宝 */
        TOH("4007020601","東宝");


        private final String _code;
        private final String _name;

        // コンストラクタ
        private TksKgyCode(String code,String name){
            _code = code;
            _name = name;
        }

        // コード取得
        public String getCode() {
            return _code;
        }

        // 名称取得
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

        // コンストラクタ
        private SeiKbn(String code,String name){
            _code = code;
            _name = name;
        }

        // コード取得
        public String getCode() {
            return _code;
        }

        // 名称取得
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

        // コンストラクタ
        private GyomKbn(String code,String name){
            _code = code;
            _name = name;
        }

        // コード取得
        public String getCode() {
            return _code;
        }

        // 名称取得
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

        // コンストラクタ
        private Shubetsu(String code,String name){
            _code = code;
            _name = name;
        }

        // コード取得
        public String getCode() {
            return _code;
        }

        // 名称取得
        public String getName() {
            return _name;
        }
    }

    /**
     * カードNo
     */
    public enum CardNo {

        /** テレビタイム */
        TV_TIME("001","テレビタイム"),

        /** テレビローカル */
        TV_LOCAL("002","テレビローカル"),

        /** ラジオタイム */
        RD_TIME("003","ラジオタイム"),

        /** ラジオローカル */
        RD_LOCAL("004","ラジオローカル"),

        /** スポット */
        SPOT("005","スポット"),

        /** 新聞 */
        SHINBUN("007","新聞"),

        /** 雑誌 */
        ZASHI("008","雑誌"),

        /** 交通 */
        KOUTU("009","交通"),

        /** 制作費 */
        SEISAKUHI("012","制作費"),

        /** その他 */
        SONOTA("010","その他"),

        /** ＢＳ・ＣＳ */
        BSCS("016","ＢＳ・ＣＳ"),

        /** インターネット */
        INTERNET("017","インターネット"),

        /** モバイル */
        MOBILE("018","モバイル"),

        /** モバイル */
        LEAFLET("014","チラシ"),

        /** サンプリング */
        SAMPLING("015","サンプリング"),

        /** 事業費 */
        BUSINESSEXP("019","事業費");



        private final String _code;
        private final String _name;

        // コンストラクタ
        private CardNo(String code,String name){
            _code = code;
            _name = name;
        }

        // コード取得
        public String getCode() {
            return _code;
        }

        // 名称取得
        public String getName() {
            return _name;
        }
    }

	/**
     *  汎用マスタ種別
     */
    public enum MastBaitaiShubetsu {

        /** テレビ局 */
        TV_KYOKU("401","テレビ局"),
        //TV_KYOKU("0001","テレビ局"),

        /** テレビ番組 */
        TV_BANGUMI("601","テレビ番組"),
        //TV_BANGUMI("0002","テレビ番組"),

        /** ラジオ局 */
        RD_KYOKU("402","ラジオ局"),
        //RD_KYOKU("0003","ラジオ局"),

        /** ラジオ番組 */
        RD_BANGUMI("602","ラジオ番組"),
        //RD_BANGUMI("0004","ラジオ番組"),

        /** ブランド */
        BRAND("201","ブランド"),
        //BRAND("0005","ブランド"),

        /** 消費税変更 */
        SHOHIZEI_HENKO("202","消費税変更"),
        //SHOHIZEI_HENKO("0006","消費税変更"),

        /** 系列 */
        KEIRETSU("101","系列"),
        //KEIRETSU("0007","系列"),

        /** 県 */
        KEN("102","県"),
        //KEN("0008","県"),

        /** 商品ジャンル */
        SHOHIN_GENRE("103","商品ジャンル"),
        //SHOHIN_GENRE("0009","商品ジャンル"),

        /** 媒体区分 */
        BAITAI_KBN("104","媒体区分"),
        //BAITAI_KBN("0010","媒体区分"),

        /** 新聞 */
        SHINBUN("105","新聞"),
        //SHINBUN("0011","新聞"),

        /** 雑誌 */
        ZASHI("106","雑誌"),
        //ZASHI("0012","雑誌"),

        /** 雑誌スペース */
        ZASHI_SPACE("107","雑誌スペース"),
        //ZASHI_SPACE("0013","雑誌スペース"),

        /** インターネット */
        INTERNET("114","インターネット"),
        //INTERNET("0014","インターネット"),

        /** モバイル */
        MOBILE("115","モバイル"),
        //MOBILE("0015","モバイル"),

        /** 新聞コード変換 */
        SHINBUN_CD("108","新聞コード変換"),
        //SHINBUN_CD("0016","新聞コード変換"),

        /** 雑誌コード変換 */
        ZASHI_CD("109","雑誌コード変換"),
        //ZASHI_CD("0017","雑誌コード変換"),

        /** テレビ局コード変換 */
        TV_CD("110","テレビ局コード変換"),
        //TV_CD("0018","テレビ局コード変換"),

        /** ラジオ局コード変換 */
        RD_CD("111","ラジオ局コード変換"),
        //RD_CD("0019","ラジオ局コード変換"),

        /** 交通広告変換 */
        KOTSU_AD("112","交通広告変換"),
        //KOTSU_AD("0020","交通広告変換"),

        /** その他媒体コード変換 */
        SONOTA_CD("113","その他媒体変換コード"),
        //SONOTA_CD("0021","その他媒体変換コード"),

        /** 料金 */
        RYOKIN("701","料金"),
        //RYOKIN("0022","料金");

        /** 雑誌料金 */
        ZASHI_RYOKIN("703","雑誌料金");

        private final String _code;
        private final String _name;

        // コンストラクタ
        private MastBaitaiShubetsu(String code,String name){
            _code = code;
            _name = name;
        }

        // コード取得
        public String getCode() {
            return _code;
        }

        // 名称取得
        public String getName() {
            return _name;
        }
    }

    // 2013/02/01 add start H.Okazaki
    /**
     *  媒体区分
     */
    public enum MastBaitaiKbn {

        /** ＴＶ番組 */
        TV_BANGUMI("01","ＴＶ番組"),

        /** ＴＶスポット */
        TV_SPOT("02","ＴＶスポット"),

        /** ラジオ番組 */
        RD_BANGUMI("04","ラジオ番組"),

        /** ラジオスポット */
        RD_SPOT("05","ラジオスポット"),

        /** 新聞 */
        SHINBUN("07","新聞"),

        /** 雑誌 */
        ZASHI("09","雑誌"),

        /** 交通広告 */
        KOTSU("11","交通広告"),

        /** 宣伝間接費 */
        SENDEN("13","宣伝間接費"),

        /** チラシ */
        TIRASHI("14","チラシ"),

        /** サンプリング */
        SAMPLING("15","サンプリング"),

        /** ＢＳ・ＣＳ */
        BSCS("16","ＢＳ・ＣＳ"),

        /** インターネット */
        INTERNET("17","インターネット"),

        //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod Start
        //名称変更
        /** モバイル */
        MOBILE("18","モバイル(廃止)"),
//        /** モバイル */
//        MOBILE("18","モバイル"),
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod End

        /** 事業費 */
        JIGYOUHI("19","事業費"),

        //2017/06/05 ライオン対応 ITCOM A.Nakamura Add Start
        //ソーシャルメディアとデジタル動画を追加
        /** ソーシャルメディア */
        SOCIALMEDIA("1B","ソーシャルメディア"),

        /** デジタル動画 */
        DIGITALMOVIE("1C","デジタル動画"),
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Add End

        /** 制作部．ＴＶＣＦ制作 */
        SEISAKU_TVCF_SEISAKU("20","制作部．ＴＶＣＦ制作"),

        /** 制作部．ＴＶＣＦプリント費 */
        SEISAKU_TVCF_PRINT("21","制作部．ＴＶＣＦプリント費"),

        /** 制作部．ナマＣＭ */
        SEISAKU_CM("23","制作部．ナマＣＭ"),

        /** 制作部．調査費 */
        SEISAKU_TYOUSA("24","制作部．調査費"),

        /** 制作部．ラジオ */
        SEISAKU_RD("25","制作部．ラジオ"),

        /** 制作部．新聞 */
        SEISAKU_SHINBUN("27","制作部．新聞"),

        /** 制作部．雑誌 */
        SEISAKU_ZASHI("29","制作部．雑誌"),

        /** 制作部．タレント */
        SEISAKU_TALENT("31","制作部．タレント"),
        
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod Start
        /** 制作部．WEB */
        SEISAKU_WEB("33","制作部．デジタル制作"),
//        /** 制作部．WEB */
//        SEISAKU_WEB("33","制作部．WEB"),
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Mod End
        
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Add Start
        /** 制作部．デジタル動画 */
        SEISAKU_DIGITAL("43","制作部．デジタル動画"),
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Add End

        /** 制作部．雑広告 */
        SEISAKU_KOKOKU("35","制作部．雑広告"),

        /** 制作部．交通 */
        SEISAKU_KOTSU("36","制作部．交通"),

        /** 制作部．間接費 */
        SEISAKU_KANSETSU("37","制作部．間接費"),

        /** 制作部．開発費 */
        SEISAKU_KAIHATSU("38","制作部．開発費"),

        /** 制作部．パッケージ制作 */
        SEISAKU_PACKAGE("39","制作部．パッケージ制作"),

        /** 制作部．制作消費税(1) */
        SEISAKU_ZEI1("40","制作部．制作消費税(1)"),

        /** 制作部．制作消費税(2) */
        SEISAKU_ZEI2("41","制作部．制作消費税(2)"),

        /** 媒体消費税(1) */
        BAITAI_ZEI1("50","媒体消費税(1)"),

        /** 媒体消費税(2) */
        BAITAI_ZEI2("51","媒体消費税(2)");


        private final String _code;
        private final String _name;

        // コンストラクタ
        private MastBaitaiKbn(String code,String name){
            _code = code;
            _name = name;
        }

        // コード取得
        public String getCode() {
            return _code;
        }

        // 名称取得
        public String getName() {
            return _name;
        }
    }
    // 2013/02/01 add end H.Okazaki
}
