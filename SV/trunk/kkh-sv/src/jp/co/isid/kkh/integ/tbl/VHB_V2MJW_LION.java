package jp.co.isid.kkh.integ.tbl;

/**
*
* <P>ClimaxTVSpotデータVIEW</P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2012/03/14 JSE H.Sasaki)<BR>
* ・iClimax連携対応(2014/04/03 HLC S.Fujimoto)<BR>
* </P>
* @author JSE H.Sasaki
*/
public class VHB_V2MJW_LION {

    /**
     * インスタンス生成禁止
     */
    private VHB_V2MJW_LION() {
    }

    /* iClimax連携対応 2014/04/03 HLC fujimoto MOD start */

    /** テーブル名 */
    //public static final String TBNAME = "VHB_V2MJW_LION";
    public static final String TBNAME = "VHB_002_MJW";

    /** Climaxスポット引合NO */
    //public static final String SHK_NO = "QFV2_SHK_NO";
    public static final String SHK_NO = "WC_HB_002_SHK_NO";

    /** 放送局コード */
    //public static final String KYK_CD = "QFV2_KYK_CD";
    public static final String KYK_CD = "WC_HB_002_KYK_CD";

    /** 局案NO */
    //public static final String KYKAN_NO = "QFV2_KYKAN_NO";
    public static final String KYKAN_NO = "WC_HB_002_KYKAN_NO";

    /** 時間枠NO */
    //public static final String JWK_NO = "QFV2_JWK_NO";
    public static final String JWK_NO = "WC_HB_002_JWK_NO";

    /** 放送日 */
    //public static final String ONA_DT = "QFV2_ONA_DT";
    public static final String ONA_DT = "WC_HB_002_ONA_DT";

    /** 開始時刻 */
    //public static final String KYKAN_STM = "QFV2_KYKAN_STM";
    public static final String KYKAN_STM = "WC_HB_002_KYKAN_STM";

    /** 終了時刻 */
    //public static final String KYKAN_ETM = "QFV2_KYKAN_ETM";
    public static final String KYKAN_ETM = "WC_HB_002_KYKAN_ETM";

    /** CM秒数 */
    //public static final String CM_SEC = "QFV2_CM_SEC";
    public static final String CM_SEC = "WC_HB_002_CM_SEC";

    /** 放送局素材略号 */
    //public static final String K_SZI_RYKG = "QFV2_K_SZI_RYKG";
    public static final String K_SZI_RYKG = "WC_HB_002_K_SZI_RYKG";

    /** 素材共通コード区分 */
    //public static final String SZIKYTU_KB = "QFV2_SZIKYTU_KB";
    public static final String SZIKYTU_KB = "WC_HB_002_SZIKYTU_KB";

    /** 素材共通コード */
    //public static final String SZIKYTU_CD = "QFV2_SZIKYTU_CD";
    public static final String SZIKYTU_CD = "WC_HB_002_SZIKYTU_CD";

    /** 広告主コード */
    //public static final String AC_CD = "QFV2_AC_CD";
    public static final String AC_CD = "WC_HB_002_AC_CD";

    /** 番組タイトル名称 */
    //public static final String BNG_MTITLE = "QFV2_BNG_MTITLE";
    public static final String BNG_MTITLE = "WC_HB_002_BNG_MTITLE";

    /** 番組サブタイトル名称 */
    //public static final String SUB_TITLE = "QFV2_SUB_TITLE";
    public static final String SUB_TITLE = "WC_HB_002_SUB_TITLE";

    /* iClimax連携対応 2014/04/03 HLC fujimoto MOD end */

}
