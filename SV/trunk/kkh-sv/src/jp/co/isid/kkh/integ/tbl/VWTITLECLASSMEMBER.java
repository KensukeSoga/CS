package jp.co.isid.kkh.integ.tbl;

/**
 *
 * <P>
 * �E�ʓ����O���[�v�����o�[VIEW
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/10 JSE H.Abe)<BR>
 * �E���v���J���^�f�B���N�g���Ή�(2014/12/22 HLC S.Fujimoto)<BR>
 * </P>
 */
public class VWTITLECLASSMEMBER {

    /**
     * �C���X�^���X�����֎~�B
     */
    private VWTITLECLASSMEMBER() {
    }

    /** �E�ʓ����O���[�v�����o�[VIEW */
    /* 2014/12/25 ���v���J���^�f�B���N�g���Ή� HLC fujimoto MOD start */
//    public static final String TBNAME = "VKJ03_TITLECLASSMEMBER";
    public static final String TBNAME = "VHB03_TITLECLASSMEMBER";

    /** �J�������̃v���t�B�b�N�X */
//    public static final String PREFIX = "KJ03_";
    public static final String PREFIX = "HB03_";
    /* 2014/12/25 ���v���J���^�f�B���N�g���Ή� HLC fujimoto MOD end */

    /** GROUPCD */
    public static final String GROUPCD = PREFIX + "GROUPCD";

    /** ESQID */
    public static final String ESQID = PREFIX + "ESQID";

    /** TNTCYINCD */
    public static final String TNTCYINCD = PREFIX + "TNTCYINCD";

}