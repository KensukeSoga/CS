package jp.co.isid.kkh.integ.tbl;

/**
*
* <P>ClimaxTVSpotデータVIEW</P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2012/03/14 JSE H.Sasaki)<BR>
* ・iClimax連携対応(2014/04/03 HLC S.Fujimoto<BR>
* </P>
* @author JSE H.Sasaki
*/
public class VHB_V1GSM_LION {

    /**
     * インスタンス生成禁止
     */
    private VHB_V1GSM_LION() {
    }

    /* iClimax連携対応 2014/04/03 HLC fujimoto MOD start */

    /** テーブル名 */
    //public static final String TBNAME = "VHB_V1GSM_LION";
    public static final String TBNAME = "VHB_001_GSM";

    /** Climaxスポット引合NO */
    //public static final String SHK_NO = "QFV1_SHK_NO";
    public static final String SHK_NO = "WC_HB_001_SHK_NO";

    /** 業推案NO */
    //public static final String GYOAN_NO = "QFV1_GYOAN_NO";
    public static final String GYOAN_NO = "WC_HB_001_GYOAN_NO";

    /** 伝送区分 */
    //public static final String DNS_KB = "QFV1_DNS_KB";

    /** AD区分 */
    //public static final String AD_KB = "QFV1_AD_KB";

    /** サービスID */
    //public static final String SRV_ID = "QFV1_SRV_ID";
    public static final String SRV_ID = "WC_HB_001_SRV_ID";

    /** 放送局コード */
    //public static final String KYK_CD = "QFV1_KYK_CD";
    public static final String KYK_CD = "WC_HB_001_KYK_CD";

    /** 局案NO */
    //public static final String KYKAN_NO = "QFV1_KYKAN_NO";
    public static final String KYKAN_NO = "WC_HB_001_KYKAN_NO";

    /** 営業所コード */
    //public static final String EG_CD = "QFV1_EG_CD";
    public static final String EG_CD = "WC_HB_001_EG_CD";

    /** 得意先コード */
    //public static final String TKI_CD = "QFV1_TKI_CD";
    public static final String TKI_CD = "WC_HB_001_TKI_CD";

    /** JOB番号 */
    //public static final String JOB_NO = "QFV1_JOB_NO";
    public static final String JOB_NO = "WC_HB_001_JOB_NO";

    /** 契約名 */
    //public static final String CONTRA_NAME = "QFV1_CONTRA_NAME";
    public static final String CONTRA_NAME = "WC_HB_001_CONTRA_NAME";

    /** 引合期間開始 */
    //public static final String HK_SDT = "QFV1_HK_SDT";
    public static final String HK_SDT = "WC_HB_001_HK_SDT";

    /** 引合期間終了 */
    //public static final String HK_EDT = "QFV1_HK_EDT";
    public static final String HK_EDT = "WC_HB_001_HK_EDT";

    /** 月料金配分パターン */
    //public static final String MPRHB_PAT = "QFV1_MPRHB_PAT";
    public static final String MPRHB_PAT = "WC_HB_001_MPRHB_PAT";

    /* iClimax連携対応 2014/04/03 HLC fujimoto MOD end */

}
