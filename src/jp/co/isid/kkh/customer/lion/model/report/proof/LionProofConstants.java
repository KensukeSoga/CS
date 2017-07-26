package jp.co.isid.kkh.customer.lion.model.report.proof;

public class LionProofConstants {

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
        RYOKIN("701","料金");
        //RYOKIN("0022","料金");

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

}
