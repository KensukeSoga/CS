package jp.co.isid.kkh.customer.lion.util;

/**
 * <P>
 * �L����׃V�X�e���A���C�I���萔�N���X�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬<BR>
 * </P>
 *
 * @author
 */
public class LionConstants {

    /**
     * �C���X�^���X�����֎~�B
     */
    private LionConstants() {
    }

    /**
     * �}�̃R�[�h
     */
    public enum BaitaiCode {

        /** �e���r�^�C�� */
        TV_TIME("1","�e���r�^�C��"),

        /** ���W�I�^�C�� */
        RD_TIME("2","���W�I�^�C��"),

        /** �e���r�X�|�b�g */
        TV_SPOT("3","�e���r�X�|�b�g"),

        /** ���W�I�X�|�b�g */
        RD_SPOT("4","���W�I�X�|�b�g"),

        /** �V�� */
        SHINBUN("5","�V��"),

        /** �G�� */
        ZASHI("6","�G��"),

        /** ���̑� */
        SONOTA("7","���̑�"),

        /** ��� */
        KOTSU("8","���"),

        /** ���� */
        SEISAKU("9","����"),

        /** �e���rCM�b�� */
        TV_CM("10","�e���rCM�b��"),

        /** ���W�ICM�b�� */
        RD_CM("11","���W�ICM�b��"),

        /** �`���V */
        CHIRASHI("12","�`���V"),

        /** �T���v�����O */
        SAMPLING("13","�T���v�����O"),

        /** BS�ECS */
        BS_CS("14","�a�r�E�b�r"),

        /** �C���^�[�l�b�g */
        INTERNET("15","�C���^�[�l�b�g"),

        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod Start
        //���̕ύX
        /** ���o�C�� */
        MOBILE("16","���o�C��(�p�~)"),
//        /** ���o�C�� */
//        MOBILE("16","���o�C��"),
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod End

        /** ���Ɣ� */
        JIGYOHI("17","���Ɣ�"),

    	//2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add Start
    	//�\�[�V�������f�B�A�ƃf�W�^�������ǉ�
        /** �\�[�V�������f�B�A */
        SOCIALMEDIA("1B","�\�[�V�������f�B�A"),

        /** �f�W�^������ */
        DIGITALMOVIE("1C","�f�W�^������");
    	//2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add End


        private final String _code;
        private final String _name;

        // �R���X�g���N�^
        private BaitaiCode(String code,String name){
            _code = code;
            _name = name;
        }

        // �R�[�h�擾
        public String getCode() {
            return _code;
        }

        // ���̎擾
        public String getName() {
            return _name;
        }
    }

    /**
     * Field1�R�[�h(�J�[�hNO�ꗗ�Ŏg�p)
     */
    public enum Field1Code {

        /** �e���r�^�C�� */
        TV_TIME("01","�e���r�^�C��"),

        /** ���W�I�^�C�� */
        RD_TIME("04","���W�I�^�C��"),

        /** �e���r�X�|�b�g */
        TV_SPOT("02","�e���r�X�|�b�g"),

        /** ���W�I�X�|�b�g */
        RD_SPOT("05","���W�I�X�|�b�g"),

        /** �V�� */
        SHINBUN("07","�V��"),

        /** �G�� */
        ZASHI("09","�G��"),

        /** ��� */
        KOTSU("11","���"),

        /** ���̑� */
        SONOTA("13","���̑�"),

        /** ���� */
        SEISAKU1("20","����"),
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod Start
        //����̔}�̋敪��20�`39��20�`43��
        /** ���� */
        SEISAKU2("43","����"),
//        /** ���� */
//        SEISAKU2("39","����"),
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod Start

        /** �`���V */
        CHIRASHI("14","�`���V"),

        /** �T���v�����O */
        SAMPLING("15","�T���v�����O"),

        /** BS�ECS */
        BS_CS("16","�a�r�E�b�r"),

        /** �C���^�[�l�b�g */
        INTERNET("17","�C���^�[�l�b�g"),

      //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod Start
        /** ���o�C�� */
        MOBILE("18","���o�C��(�p�~)"),
//        /** ���o�C�� */
//        MOBILE("18","���o�C��"),
      //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod End

        /** ���Ɣ� */
        JIGYOHI("19","���Ɣ�"),

    	//2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add Start
    	/** �\�[�V�������f�B�A */
        SOCIALMEDIA("1B","�\�[�V�������f�B�A"),

        /** �f�W�^������ */
        DIGITALMOVIE("1C","�f�W�^������");
    	//2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add End

        private final String _code;
        private final String _name;

        // �R���X�g���N�^
        private Field1Code(String code,String name){
            _code = code;
            _name = name;
        }

        // �R�[�h�擾
        public String getCode() {
            return _code;
        }

        // ���̎擾
        public String getName() {
            return _name;
        }
    }


    /**
     * �}�̃R�[�h
     */
    public enum BaitaiKbn {

        /** �e���r�X�|�b�g */
        TV_SPOT("02","�e���r�X�|�b�g"),

        /** ���W�I�X�|�b�g */
        RD_SPOT("05","���W�I�X�|�b�g");

        private final String _code;
        private final String _name;

        // �R���X�g���N�^
        private BaitaiKbn(String code,String name){
            _code = code;
            _name = name;
        }

        // �R�[�h�擾
        public String getCode() {
            return _code;
        }

        // ���̎擾
        public String getName() {
            return _name;
        }
    }

    /**
     * ���Ӑ�R�[�h
     */
    public enum TksKgyCode {

        /** �A�R�� */
        ACOM("0088260101","�A�R��"),

        /** �A�T�q�r�[�� */
        ASH("0168020101","�A�T�q�r�[��"),

        /** �X�J�p�[ */
        SKYP("0168020101","�X�J�p�["),

        /** ���j�`���[�� */
        UNI("0310540201","���j�`���[��"),

        /** ���C�I�� */
        LION("1809830201","���C�I��"),

        /** ���c���� */
        TKD("3855040303","���c����"),

        /** �}�N�h�i���h */
        MAC("2711430101","�}�N�h�i���h"),

        /** ���� */
        TOH("4007020601","����");


        private final String _code;
        private final String _name;

        // �R���X�g���N�^
        private TksKgyCode(String code,String name){
            _code = code;
            _name = name;
        }

        // �R�[�h�擾
        public String getCode() {
            return _code;
        }

        // ���̎擾
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

        // �R���X�g���N�^
        private SeiKbn(String code,String name){
            _code = code;
            _name = name;
        }

        // �R�[�h�擾
        public String getCode() {
            return _code;
        }

        // ���̎擾
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

        // �R���X�g���N�^
        private GyomKbn(String code,String name){
            _code = code;
            _name = name;
        }

        // �R�[�h�擾
        public String getCode() {
            return _code;
        }

        // ���̎擾
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

        // �R���X�g���N�^
        private Shubetsu(String code,String name){
            _code = code;
            _name = name;
        }

        // �R�[�h�擾
        public String getCode() {
            return _code;
        }

        // ���̎擾
        public String getName() {
            return _name;
        }
    }

    /**
     * �J�[�hNo
     */
    public enum CardNo {

        /** �e���r�^�C�� */
        TV_TIME("001","�e���r�^�C��"),

        /** �e���r���[�J�� */
        TV_LOCAL("002","�e���r���[�J��"),

        /** ���W�I�^�C�� */
        RD_TIME("003","���W�I�^�C��"),

        /** ���W�I���[�J�� */
        RD_LOCAL("004","���W�I���[�J��"),

        /** �X�|�b�g */
        SPOT("005","�X�|�b�g"),

        /** �V�� */
        SHINBUN("007","�V��"),

        /** �G�� */
        ZASHI("008","�G��"),

        /** ��� */
        KOUTU("009","���"),

        /** ����� */
        SEISAKUHI("012","�����"),

        /** ���̑� */
        SONOTA("010","���̑�"),

        /** �a�r�E�b�r */
        BSCS("016","�a�r�E�b�r"),

        /** �C���^�[�l�b�g */
        INTERNET("017","�C���^�[�l�b�g"),

        /** ���o�C�� */
        MOBILE("018","���o�C��"),

        /** ���o�C�� */
        LEAFLET("014","�`���V"),

        /** �T���v�����O */
        SAMPLING("015","�T���v�����O"),

        /** ���Ɣ� */
        BUSINESSEXP("019","���Ɣ�");



        private final String _code;
        private final String _name;

        // �R���X�g���N�^
        private CardNo(String code,String name){
            _code = code;
            _name = name;
        }

        // �R�[�h�擾
        public String getCode() {
            return _code;
        }

        // ���̎擾
        public String getName() {
            return _name;
        }
    }

	/**
     *  �ėp�}�X�^���
     */
    public enum MastBaitaiShubetsu {

        /** �e���r�� */
        TV_KYOKU("401","�e���r��"),
        //TV_KYOKU("0001","�e���r��"),

        /** �e���r�ԑg */
        TV_BANGUMI("601","�e���r�ԑg"),
        //TV_BANGUMI("0002","�e���r�ԑg"),

        /** ���W�I�� */
        RD_KYOKU("402","���W�I��"),
        //RD_KYOKU("0003","���W�I��"),

        /** ���W�I�ԑg */
        RD_BANGUMI("602","���W�I�ԑg"),
        //RD_BANGUMI("0004","���W�I�ԑg"),

        /** �u�����h */
        BRAND("201","�u�����h"),
        //BRAND("0005","�u�����h"),

        /** ����ŕύX */
        SHOHIZEI_HENKO("202","����ŕύX"),
        //SHOHIZEI_HENKO("0006","����ŕύX"),

        /** �n�� */
        KEIRETSU("101","�n��"),
        //KEIRETSU("0007","�n��"),

        /** �� */
        KEN("102","��"),
        //KEN("0008","��"),

        /** ���i�W������ */
        SHOHIN_GENRE("103","���i�W������"),
        //SHOHIN_GENRE("0009","���i�W������"),

        /** �}�̋敪 */
        BAITAI_KBN("104","�}�̋敪"),
        //BAITAI_KBN("0010","�}�̋敪"),

        /** �V�� */
        SHINBUN("105","�V��"),
        //SHINBUN("0011","�V��"),

        /** �G�� */
        ZASHI("106","�G��"),
        //ZASHI("0012","�G��"),

        /** �G���X�y�[�X */
        ZASHI_SPACE("107","�G���X�y�[�X"),
        //ZASHI_SPACE("0013","�G���X�y�[�X"),

        /** �C���^�[�l�b�g */
        INTERNET("114","�C���^�[�l�b�g"),
        //INTERNET("0014","�C���^�[�l�b�g"),

        /** ���o�C�� */
        MOBILE("115","���o�C��"),
        //MOBILE("0015","���o�C��"),

        /** �V���R�[�h�ϊ� */
        SHINBUN_CD("108","�V���R�[�h�ϊ�"),
        //SHINBUN_CD("0016","�V���R�[�h�ϊ�"),

        /** �G���R�[�h�ϊ� */
        ZASHI_CD("109","�G���R�[�h�ϊ�"),
        //ZASHI_CD("0017","�G���R�[�h�ϊ�"),

        /** �e���r�ǃR�[�h�ϊ� */
        TV_CD("110","�e���r�ǃR�[�h�ϊ�"),
        //TV_CD("0018","�e���r�ǃR�[�h�ϊ�"),

        /** ���W�I�ǃR�[�h�ϊ� */
        RD_CD("111","���W�I�ǃR�[�h�ϊ�"),
        //RD_CD("0019","���W�I�ǃR�[�h�ϊ�"),

        /** ��ʍL���ϊ� */
        KOTSU_AD("112","��ʍL���ϊ�"),
        //KOTSU_AD("0020","��ʍL���ϊ�"),

        /** ���̑��}�̃R�[�h�ϊ� */
        SONOTA_CD("113","���̑��}�̕ϊ��R�[�h"),
        //SONOTA_CD("0021","���̑��}�̕ϊ��R�[�h"),

        /** ���� */
        RYOKIN("701","����"),
        //RYOKIN("0022","����");

        /** �G������ */
        ZASHI_RYOKIN("703","�G������");

        private final String _code;
        private final String _name;

        // �R���X�g���N�^
        private MastBaitaiShubetsu(String code,String name){
            _code = code;
            _name = name;
        }

        // �R�[�h�擾
        public String getCode() {
            return _code;
        }

        // ���̎擾
        public String getName() {
            return _name;
        }
    }

    // 2013/02/01 add start H.Okazaki
    /**
     *  �}�̋敪
     */
    public enum MastBaitaiKbn {

        /** �s�u�ԑg */
        TV_BANGUMI("01","�s�u�ԑg"),

        /** �s�u�X�|�b�g */
        TV_SPOT("02","�s�u�X�|�b�g"),

        /** ���W�I�ԑg */
        RD_BANGUMI("04","���W�I�ԑg"),

        /** ���W�I�X�|�b�g */
        RD_SPOT("05","���W�I�X�|�b�g"),

        /** �V�� */
        SHINBUN("07","�V��"),

        /** �G�� */
        ZASHI("09","�G��"),

        /** ��ʍL�� */
        KOTSU("11","��ʍL��"),

        /** ��`�Ԑڔ� */
        SENDEN("13","��`�Ԑڔ�"),

        /** �`���V */
        TIRASHI("14","�`���V"),

        /** �T���v�����O */
        SAMPLING("15","�T���v�����O"),

        /** �a�r�E�b�r */
        BSCS("16","�a�r�E�b�r"),

        /** �C���^�[�l�b�g */
        INTERNET("17","�C���^�[�l�b�g"),

        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod Start
        //���̕ύX
        /** ���o�C�� */
        MOBILE("18","���o�C��(�p�~)"),
//        /** ���o�C�� */
//        MOBILE("18","���o�C��"),
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod End

        /** ���Ɣ� */
        JIGYOUHI("19","���Ɣ�"),

        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add Start
        //�\�[�V�������f�B�A�ƃf�W�^�������ǉ�
        /** �\�[�V�������f�B�A */
        SOCIALMEDIA("1B","�\�[�V�������f�B�A"),

        /** �f�W�^������ */
        DIGITALMOVIE("1C","�f�W�^������"),
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add End

        /** ���암�D�s�u�b�e���� */
        SEISAKU_TVCF_SEISAKU("20","���암�D�s�u�b�e����"),

        /** ���암�D�s�u�b�e�v�����g�� */
        SEISAKU_TVCF_PRINT("21","���암�D�s�u�b�e�v�����g��"),

        /** ���암�D�i�}�b�l */
        SEISAKU_CM("23","���암�D�i�}�b�l"),

        /** ���암�D������ */
        SEISAKU_TYOUSA("24","���암�D������"),

        /** ���암�D���W�I */
        SEISAKU_RD("25","���암�D���W�I"),

        /** ���암�D�V�� */
        SEISAKU_SHINBUN("27","���암�D�V��"),

        /** ���암�D�G�� */
        SEISAKU_ZASHI("29","���암�D�G��"),

        /** ���암�D�^�����g */
        SEISAKU_TALENT("31","���암�D�^�����g"),
        
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod Start
        /** ���암�DWEB */
        SEISAKU_WEB("33","���암�D�f�W�^������"),
//        /** ���암�DWEB */
//        SEISAKU_WEB("33","���암�DWEB"),
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Mod End
        
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add Start
        /** ���암�D�f�W�^������ */
        SEISAKU_DIGITAL("43","���암�D�f�W�^������"),
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add End

        /** ���암�D�G�L�� */
        SEISAKU_KOKOKU("35","���암�D�G�L��"),

        /** ���암�D��� */
        SEISAKU_KOTSU("36","���암�D���"),

        /** ���암�D�Ԑڔ� */
        SEISAKU_KANSETSU("37","���암�D�Ԑڔ�"),

        /** ���암�D�J���� */
        SEISAKU_KAIHATSU("38","���암�D�J����"),

        /** ���암�D�p�b�P�[�W���� */
        SEISAKU_PACKAGE("39","���암�D�p�b�P�[�W����"),

        /** ���암�D��������(1) */
        SEISAKU_ZEI1("40","���암�D��������(1)"),

        /** ���암�D��������(2) */
        SEISAKU_ZEI2("41","���암�D��������(2)"),

        /** �}�̏����(1) */
        BAITAI_ZEI1("50","�}�̏����(1)"),

        /** �}�̏����(2) */
        BAITAI_ZEI2("51","�}�̏����(2)");


        private final String _code;
        private final String _name;

        // �R���X�g���N�^
        private MastBaitaiKbn(String code,String name){
            _code = code;
            _name = name;
        }

        // �R�[�h�擾
        public String getCode() {
            return _code;
        }

        // ���̎擾
        public String getName() {
            return _name;
        }
    }
    // 2013/02/01 add end H.Okazaki
}
