package jp.co.isid.kkh.integ.tbl;

/**
 *
 * <P>
 * 職位等級グループメンバーVIEW
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/02/10 JSE H.Abe)<BR>
 * ・レプリカメタディレクトリ対応(2014/12/22 HLC S.Fujimoto)<BR>
 * </P>
 */
public class VWTITLECLASSMEMBER {

    /**
     * インスタンス生成禁止。
     */
    private VWTITLECLASSMEMBER() {
    }

    /** 職位等級グループメンバーVIEW */
    /* 2014/12/25 レプリカメタディレクトリ対応 HLC fujimoto MOD start */
//    public static final String TBNAME = "VKJ03_TITLECLASSMEMBER";
    public static final String TBNAME = "VHB03_TITLECLASSMEMBER";

    /** カラム名のプレフィックス */
//    public static final String PREFIX = "KJ03_";
    public static final String PREFIX = "HB03_";
    /* 2014/12/25 レプリカメタディレクトリ対応 HLC fujimoto MOD end */

    /** GROUPCD */
    public static final String GROUPCD = PREFIX + "GROUPCD";

    /** ESQID */
    public static final String ESQID = PREFIX + "ESQID";

    /** TNTCYINCD */
    public static final String TNTCYINCD = PREFIX + "TNTCYINCD";

}