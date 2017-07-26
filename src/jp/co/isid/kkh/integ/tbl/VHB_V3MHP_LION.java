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
public class VHB_V3MHP_LION {

    /**
     * インスタンス生成禁止
     */
    private VHB_V3MHP_LION() {
    }

    /* iClimax連携対応 2014/04/03 HLC fujimoto MOD start */

    /** テーブル名 */
    //public static final String TBNAME = "VHB_V3MHP_LION";
    public static final String TBNAME = "VHB_003_MHP";

    /** Climaxスポット引合NO */
    //public static final String SHK_NO = "QFV3_SHK_NO";
    public static final String SHK_NO = "WC_HB_003_SHK_NO";

    /** 放送局コード */
    //public static final String KYK_CD = "QFV3_KYK_CD";
    public static final String KYK_CD = "WC_HB_003_KYK_CD";

    /** 局案NO */
    //public static final String KYKAN_NO = "QFV3_KYKAN_NO";
    public static final String KYKAN_NO = "WC_HB_003_KYKAN_NO";

    /** 年月 */
    //public static final String YM = "QFV3_YM";
    public static final String YM = "WC_HB_003_YM";

    /** 月料金配分パターン */
    //public static final String MPRHB_PAT = "QFV3_MPRHB_PAT";
    public static final String MPRHB_PAT = "WC_HB_003_MPRHB_PAT";

    /** 放送局引合額発注 */
    //public static final String K_HKGAK_HAT = "QFV3_K_HKGAK_HAT";
    public static final String K_HKGAK_HAT = "WC_HB_003_K_HKGAK_HAT";

    /* iClimax連携対応 2014/04/03 HLC fujimoto MOD end */

}
