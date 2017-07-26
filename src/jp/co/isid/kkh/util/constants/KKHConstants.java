package jp.co.isid.kkh.util.constants;

/**
 * <P>
 * �L����׃V�X�e���萔�N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/01 JSE H.Abe)<BR>
 * �E���Ӑ惍�O�C���������Ή�(2017/02/08 HLC K.Soga)<BR>
 * </P>
 * @author JSE H.Abe
 */
public class KKHConstants {

    /** �C���X�^���X�����֎~ */
    private KKHConstants() {
    }

    /** 2017/02/09 ���Ӑ惍�O�C���������Ή� HLC K.Soga ADD Start */
    /**
     * �t���O
     */
    /** �t���O:ON */
    public static final String FLAG_ON = "1";
    /** �t���O:OFF */
    public static final String FLAG_OFF = "0";

    /**
     * ���[�U�[���
     */
    /** �ʏ탆�[�U�[ */
    public static final String USER_KIND_NORMAL = "0";
    /** �X�[�p�[���[�U�[ */
    public static final String USER_KIND_SUPER = "1";
    /** ���ʃ��O�C�����[�U�[ */
    public static final String USER_KIND_SPECIAL_LOGIN = "2";

    /**
     * ���Ό���
     */
    /** ������ */
    public static final String RELATIVE_AUTHORITY_BU = "7";
    /** �ǌ��� */
    public static final String RELATIVE_AUTHORITY_KYOKU = "31";

    /**
     * �ėp�V�X�e���}�X�^(���)
     */
    /** 999-REPEAL:�p�~�t���O */
    public static final String SYBT_REPEALFLG = "999";

    /**
     * �ėp�V�X�e���}�X�^(�t�B�[���h1)
     */
    /** 999-REPEAL:�p�~�t���O */
    public static final String FIELD1_REPEALFLG = "REPEALFLG";
    /** 2017/02/09 ���Ӑ惍�O�C���������Ή� HLC K.Soga ADD End */

    /**
     * ���Ӑ�R�[�h
     */
    public enum TksKgyCode {
        /** �A�R�� */
        ACOM("0088260101","�A�R��"),
        /** �A�T�q�r�[�� */
        ASH("0168020101","�A�T�q�r�[��"),
        /** 2016/01/29 �A�T�q�����J���s�X�Ή� JSE A.Hisada ADD Start */
        /** �A�T�q���� */
        ASHI("2851470301","�A�T�q����"),
        /** 2016/01/29 �A�T�q�����J���s�X�Ή� JSE A.Hisada ADD End */
        /** �X�J�p�[ */
        SKYP("6954651301","�X�J�p�["),
        /** ���j�`���[�� */
        UNI("0310540201","���j�`���[��"),
        /** ���C�I�� */
        LION("1809830201","���C�I��"),
        /** ���c���� */
        TKD("3855040303","���c����"),
        /** �}�N�h�i���h */
        MAC("2711430101","�}�N�h�i���h"),
        /** �G�v�\�� */
        EPS("0040170101","�G�v�\��"),
        /** ���� */
        TOH("4007020601","����"),
        /** 2015/06/11 ����A�h�Ή� HLC K.Soga ADD Start */
        /** ����A�h */
        TOHAD("4006480301","����A�h"),
        /** 2015/06/11 ����A�h�Ή� HLC K.Soga ADD End */
        /** ���� */
        KMN("0470200101","����"),
        /** 2015/04/01 �������Ӑ�ύX�Ή� HLC K.Fujisaki ADD Start */
        /** ����(�������Ӑ�ύX�Ή�)  */
        KMN_2015("1709810401","����");
        /** 2015/04/01 �������Ӑ�ύX�Ή� HLC K.Fujisaki ADD End */

        private final String _code;
        private final String _name;

        //�R���X�g���N�^
        private TksKgyCode(String code,String name){
            _code = code;
            _name = name;
        }

        //�R�[�h�擾
        public String getCode() {
            return _code;
        }

        //���̎擾
        public String getName() {
            return _name;
        }
    }

    /**
     * �����敪
     */
    public enum SeiKbn {
        /** �V�� */
        NEWSPAPER("11","�V��"),
        /** �G�� */
        MAGAZINE("21","�G��"),
        /** �^�C�� */
        TIME("41","�^�C��"),
        /** �X�|�b�g */
        SPOT("42","�X�|�b�g"),
        /** IC */
        IC("61","IC"),
        /** ��ʍL�� */
        OOH("71","OOH"),
        /** ����� */
        WORKS("81","�����"),
        /** ���ۃ}�X */
        KMAS("31","���ۃ}�X"),
        /** ����(����Ɓj*/
        KWORKS("32","����(����Ɓj");

        private final String _code;
        private final String _name;

        //�R���X�g���N�^
        private SeiKbn(String code,String name){
            _code = code;
            _name = name;
        }

        //�R�[�h�擾
        public String getCode() {
            return _code;
        }

        //���̎擾
        public String getName() {
            return _name;
        }
    }

    /**
     * �Ɩ��敪
     */
    public enum GyomKbn {
        /** �V�� */
        SHINBUN("11010","�V��"),
        /** �G�� */
        ZASHI("11020","�G��"),
        /** ���W�I */
        RADIO("11030","���W�I"),
        /** �e���r�^�C�� */
        TVTIME("11040","�e���r�^�C��"),
        /** �e���r�X�|�b�g */
        TVSPOT("11045","�e���r�X�|�b�g"),
        /** �q�����f�B�A */
        EISEIM("11050","�q�����f�B�A"),
        /** �C���^���N�e�B�u���f�B�A */
        INTERACTIVEM("11060","�C���^���N�e�B�u���f�B�A"),
        /** OOH���f�B�A */
        OOHM("11070","OOH���f�B�A"),
        /** ���̑����f�B�A */
        SONOTAM("11080","���̑����f�B�A"),
        /** ���f�B�A�v�����j���O */
        MPLAN("11090","���f�B�A�v�����j���O"),
        /** �N���G�[�e�B�u */
        CREATIVE("12010","�N���G�[�e�B�u"),
        /** �}�[�P�e�B���O/�v�����[�V���� */
        MARKEPROMO("13010","�}�[�P�e�B���O/�v�����[�V����"),
        /** �X�|�[�c */
        SPORTS("14010","�X�|�[�c"),
        /** �G���^�e�C�����g */
        ENTERTAINMENT("14020","�G���^�e�C�����g"),
        /** ���̑��R���e���c */
        SONOTAC("14030","���̑��R���e���c");

        private final String _code;
        private final String _name;

        //�R���X�g���N�^
        private GyomKbn(String code,String name){
            _code = code;
            _name = name;
        }

        //�R�[�h�擾
        public String getCode() {
            return _code;
        }

        //���̎擾
        public String getName() {
            return _name;
        }
    }

    /**
     * ���
     */
    public enum Shubetsu {
        /** �e���r�ԑg */
        TV_BANGUMI("001","TV�ԑg"),
        /** �e���r���� */
        TV_TOKUBAN("002","TV����"),
        /** �e���r�X�|�b�g */
        TV_SPOT("003","TV SPOT"),
        /** �G�� */
        ZASHI("004","�G��"),
        /** �V�� */
        SHINBUN("005","�V��"),
        /** ���̑� */
        SONOTA("006","���̑�"),
        /** ���� */
        SEISAKU("007","����");

        private final String _code;
        private final String _name;

        //�R���X�g���N�^
        private Shubetsu(String code,String name){
            _code = code;
            _name = name;
        }

        //�R�[�h�擾
        public String getCode() {
            return _code;
        }

        //���̎擾
        public String getName() {
            return _name;
        }
    }
}
