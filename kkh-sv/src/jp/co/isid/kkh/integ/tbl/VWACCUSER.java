package jp.co.isid.kkh.integ.tbl;

/**
 *
 * <P>
 * �l���VIEW
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/10 JSE H.Abe)<BR>
 * �E���v���J���^�f�B���N�g���Ή�(2014/12/22 HLC S.Fujimoto)<BR>
 * </P>
 */
public class VWACCUSER {

    /**
     * �C���X�^���X�����֎~�B
     */
    private VWACCUSER() {
    }

    /** �l���VIEW */
    /* 2014/12/25 ���v���J���^�f�B���N�g���Ή� HLC fujimoto MOD start */
//    public static final String TBNAME = "VKJ01_ACCUSER";
    public static final String TBNAME = "VHB01_ACCUSER";

    /** �J�������̃v���t�B�b�N�X */
//    public static final String PREFIX = "KJ01_";
    public static final String PREFIX = "HB01_";
    /* 2014/12/25 ���v���J���^�f�B���N�g���Ή� HLC fujimoto MOD end */

    /** ESQID */
    public static final String ESQID = PREFIX + "ESQID";

    /** PASTKBN */
    public static final String PASTKBN = PREFIX + "PASTKBN";

    /** TNTCYINCD */
    public static final String TNTCYINCD = PREFIX + "TNTCYINCD";

    /** CN */
    public static final String CN = PREFIX + "CN";

    /** OGNZUNTCD */
    public static final String OGNZUNTCD = PREFIX + "OGNZUNTCD";

    /** SIKOGNZUNTCD */
    public static final String SIKOGNZUNTCD = PREFIX + "SIKOGNZUNTCD";

    /** HBSIKOGNZUNTCD */
    public static final String HBSIKOGNZUNTCD = PREFIX + "HBSIKOGNZUNTCD";

    /** HBOU */
    public static final String HBOU = PREFIX + "HBOU";

    /** KKSIKOGNZUNTCD */
    public static final String KKSIKOGNZUNTCD = PREFIX + "KKSIKOGNZUNTCD";

    /** KKOU */
    public static final String KKOU = PREFIX + "KKOU";

    /** HTSIKOGNZUNTCD */
    public static final String HTSIKOGNZUNTCD = PREFIX + "HTSIKOGNZUNTCD";

    /** HTOU */
    public static final String HTOU = PREFIX + "HTOU";

    /** BUSIKOGNZUNTCD */
    public static final String BUSIKOGNZUNTCD = PREFIX + "BUSIKOGNZUNTCD";

    /** BUOU */
    public static final String BUOU = PREFIX + "BUOU";

    /** KASIKOGNZUNTCD */
    public static final String KASIKOGNZUNTCD = PREFIX + "KASIKOGNZUNTCD";

    /** KAOU */
    public static final String KAOU = PREFIX + "KAOU";

}