package jp.co.isid.kkh.integ.tbl;

/**
 *
 * <P>
 * �E�ʓ����O���[�vVIEW
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/10 JSE H.Abe)<BR>
 * �E���v���J���^�f�B���N�g���Ή�(2014/12/22 HLC S.Fujimoto)<BR>
 * </P>
 */
public class VWTITLECLASSGROUPINFO {

    /**
     * �C���X�^���X�����֎~�B
     */
    private VWTITLECLASSGROUPINFO() {
    }

    /** �E�ʓ����O���[�vVIEW */
    /* 2014/12/25 ���v���J���^�f�B���N�g���Ή� HLC fujimoto MOD start */
//    public static final String TBNAME = "VKJ02_TITLECLASSGROUPINFO";
    public static final String TBNAME = "VHB02_TITLECLASSGROUPINFO";

    /** �J�������̃v���t�B�b�N�X */
//    public static final String PREFIX = "KJ02_";
    public static final String PREFIX = "HB02_";
    /* 2014/12/25 ���v���J���^�f�B���N�g���Ή� HLC fujimoto MOD end */

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