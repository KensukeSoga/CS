package jp.co.isid.kkh.customer.lion.model.report.proof;

public class LionProofConstants {

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
        RYOKIN("701","����");
        //RYOKIN("0022","����");

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

}
