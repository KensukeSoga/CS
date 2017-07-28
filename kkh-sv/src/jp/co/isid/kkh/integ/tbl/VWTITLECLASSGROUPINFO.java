package jp.co.isid.kkh.integ.tbl;

/**
 *
 * <P>
 * 職位等級グループVIEW
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/10 JSE H.Abe)<BR>
 * ・レプリカメタディレクトリ対応(2014/12/22 HLC S.Fujimoto)<BR>
 * </P>
 */
public class VWTITLECLASSGROUPINFO {

    /**
     * インスタンス生成禁止。
     */
    private VWTITLECLASSGROUPINFO() {
    }

    /** 職位等級グループVIEW */
    /* 2014/12/25 レプリカメタディレクトリ対応 HLC fujimoto MOD start */
//    public static final String TBNAME = "VKJ02_TITLECLASSGROUPINFO";
    public static final String TBNAME = "VHB02_TITLECLASSGROUPINFO";

    /** カラム名のプレフィックス */
//    public static final String PREFIX = "KJ02_";
    public static final String PREFIX = "HB02_";
    /* 2014/12/25 レプリカメタディレクトリ対応 HLC fujimoto MOD end */

    /** GROUPCD */
    public static final String GROUPCD = PREFIX + "GROUPCD";

    /** GROUPNMKJ */
    public static final String GROUPNMKJ = PREFIX + "GROUPNMKJ";

    /** GROUPNMALPH */
    public static final String GROUPNMALPH = PREFIX + "GROUPNMALPH";

    /** STRTYMD */
    public static final String STRTYMD = PREFIX + "STRTYMD";

    /** STPYMD */
    public static final String STPYMD = PREFIX + "STPYMD";

}