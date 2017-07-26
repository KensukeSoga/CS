package jp.co.isid.kkh.customer.acom.model.input;


import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.input.HikVO;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * �����f�[�^�o�^DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/14 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
public class HikRegistDAO extends AbstractSimpleRdbDao  {

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public HikRegistDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }


	@Override
	public String[] getPrimryKeyNames() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

    /**
     * �V�X�e�����t�ōX�V�����̒�`�ł�
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[]{
            TBTHB5HIK.TRKTIMSTMP,     //�o�^�^�C���X�^���v (TRKTIMSTMP)
            TBTHB5HIK.UPDTIMSTMP,     //�X�V�^�C���X�^���v (UPDTIMSTMP)
        };
    }

    /**
     * �X�V���t�t�B�[���h��Ԃ��܂��B
     *
     * @return String �X�V���t�t�B�[���h
     */
    public String getTimeStampKeyName() {
        return TBTHB5HIK.TRKTIMSTMP;   //�X�V�^�C���X�^���v (UPDTIMSTMP)
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    public String getTableName() {
        return TBTHB5HIK.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[]{
        		TBTHB5HIK.TRKTIMSTMP,     //�o�^�^�C���X�^���v (TRKTIMSTMP)
        	    TBTHB5HIK.TRKPL,          //�o�^�v���O���� (TRKPL)
        	    TBTHB5HIK.TRKTNT,         //�o�^�S���� (TRKTNT)
        	    TBTHB5HIK.UPDTIMSTMP,     //�X�V�^�C���X�^���v (UPDTIMSTMP)
        	    TBTHB5HIK.UPDAPL,         //�X�V�v���O���� (UPDAPL)
        	    TBTHB5HIK.UPDTN,          //�X�V�S���� (UPDTNT)
        	    TBTHB5HIK.EGCD,           //�c�Ə��i��j�R�[�h (EGCD)
        	    TBTHB5HIK.TKSKGYCD,       //���Ӑ��ƃR�[�h (TKSKGYCD)
        	    TBTHB5HIK.TKSBMNSEQNO,    //���Ӑ敔��SEQNO (TKSBMNSEQNO)
        	    TBTHB5HIK.TKSTNTSEQNO,    //���Ӑ�S��SEQNO (TKSTNTSEQNO)
        	    TBTHB5HIK.SYBT,           //�}�̃R�[�h (SYBT)
        	    TBTHB5HIK.RECCD,          //���R�[�h��� (RECCD)
        	    TBTHB5HIK.KOUKBN,         //�X�V�敪 (KOUKBN)
        	    TBTHB5HIK.RIRENO,         //�����Ǘ��ԍ� (RIRENO)
        	    TBTHB5HIK.IRYYMM,         //�˗��N�� (IRYYMM)
        	    TBTHB5HIK.IRKBN,          //�˗��敪 (IRKBN)
        	    TBTHB5HIK.TOKUICD,        //���Ӑ�R�[�h (TOKUICD)
        	    TBTHB5HIK.EICODE,         //�c�ƕ��R�[�h (EICODE)
        	    TBTHB5HIK.EINAME,         //�c�ƕ��� (EINAME)
        	    TBTHB5HIK.TENCD,          //�X�� (TENCD)
        	    TBTHB5HIK.TENNAME,        //�X�� (TENNAME)
        	    TBTHB5HIK.YOSAKBN,        //�\�Z�敪 (YOSAKBN)
        	    TBTHB5HIK.IRNAI,          //�˗����e (IRNAI)
        	    TBTHB5HIK.IRBAN,          //�����ԍ� (IRBAN)
        	    TBTHB5HIK.IRROWBAN,       //�s�ԍ� (IRROWBAN)
        	    TBTHB5HIK.MEDIACD,        //���f�B�A�R�[�h (MEDIACD)
        	    TBTHB5HIK.MEDIANAME,      //���f�B�A�� (MEDIANAME)
        	    TBTHB5HIK.SIZECD,         //�T�C�Y�R�[�h (SIZECD)
        	    TBTHB5HIK.SIZENAME,       //�T�C�Y�� (SIZENAME)
        	    TBTHB5HIK.KEISAI1,        //�f�ړ�1 (KEISAI1)
        	    TBTHB5HIK.KEISAI2,        //�f�ړ�2 (KEISAI2)
        	    TBTHB5HIK.KEISAI3,        //�f�ړ�3 (KEISAI3)
        	    TBTHB5HIK.KEISAI4,        //�f�ړ�4 (KEISAI4)
        	    TBTHB5HIK.KEISAI5,        //�f�ړ�5 (KEISAI5)
        	    TBTHB5HIK.KEITAICD,       //�`�ԋ敪�R�[�h (KEITAICD)
        	    TBTHB5HIK.KEITAINAME,     //�`�ԋ敪�� (KEITAINAME)
        	    TBTHB5HIK.IRMONTH1,       //�˗���1 (IRMONTH1)
        	    TBTHB5HIK.HOSORYO1,       //������1 (HOSORYO1)
        	    TBTHB5HIK.IRMONTH2,       //�˗���2 (IRMONTH2)
        	    TBTHB5HIK.HOSORYO2,       //������2 (HOSORYO2)
        	    TBTHB5HIK.IRMONTH3,       //�˗���3 (IRMONTH3)
        	    TBTHB5HIK.HOSORYO3,       //������3 (HOSORYO3)
        	    TBTHB5HIK.IRMONTH4,       //�˗���4 (IRMONTH4)
        	    TBTHB5HIK.HOSORYO4,       //������4 (HOSORYO4)
        	    TBTHB5HIK.IRMONTH5,       //�˗���5 (IRMONTH5)
        	    TBTHB5HIK.HOSORYO5,       //������5 (HOSORYO5)
        	    TBTHB5HIK.IRMONTH6,       //�˗���6 (IRMONTH6)
        	    TBTHB5HIK.HOSORYO6,       //������6 (HOSORYO6)
        	    TBTHB5HIK.KOTUKEICD,      //��ʌf�ڃR�[�h (KOTUKEICD)
        	    TBTHB5HIK.KOTUKEINAME,    //��ʌf�ږ� (KOTUKEINAME)
        	    TBTHB5HIK.KEISAI,         //�f�ړ� (KEISAI)
        	    TBTHB5HIK.KEISAIRYO,      //�f�ڗ� (KEISAIRYO)
        	    TBTHB5HIK.KEISAITANKA,    //�f�ڒP�� (KEISAITANKA)
        	    TBTHB5HIK.KEISAICNT,      //�f�ډ� (KEISAICNT)
        	    TBTHB5HIK.SYOHIKBN,       //���i�敪 (SYOHIKBN)
        	    TBTHB5HIK.SYOHINAME,      //���i�敪���� (SYOHINAME)
        	    TBTHB5HIK.SAIKBN,         //�זڋ敪 (SAIKBN)
        	    TBTHB5HIK.TEKICD,         //�E�v�R�[�h (TEKICD)
        	    TBTHB5HIK.URIYYMM,        //����\��N�� (URIYYMM)
        	    TBTHB5HIK.TANNAME,        //�S���Җ� (TANNAME)
        	    TBTHB5HIK.TANKINNAME,     //�S���ҋΖ������� (TANKINNAME)
        	    TBTHB5HIK.ANSYUBE,        //����� (ANSYUBE)
        	    TBTHB5HIK.BIKOU1,         //���l1 (BIKOU1)
        	    TBTHB5HIK.BIKOU2,         //���l2 (BIKOU2)
        	    TBTHB5HIK.COLORCD,        //�F���R�[�h (COLORCD )
        	    TBTHB5HIK.SPACECD,        //�X�y�[�X�R�[�h (SPACECD )
        	    TBTHB5HIK.SPACENAME,      //�X�y�[�X�� (SPACENAME )
        	    TBTHB5HIK.SYBT1CD,        //��ʂP�R�[�h (SYBT1CD )
        	    TBTHB5HIK.SYBT2CD,        //��ʂQ�R�[�h (SYBT2CD )
        	    TBTHB5HIK.DESIGNCNT,      //�f�U�C���ύX�� (DESIGNCNT )
        	    TBTHB5HIK.PLACECD,        //�f�ڏꏊ�R�[�h (PLACECD )
        	    TBTHB5HIK.PRINTRYO,       //����� (PRINTRYO)
        	    TBTHB5HIK.SASHIKAERYO,    //���֍�Ɨ� (SASHIKAERYO)
        	    TBTHB5HIK.DESIGNRYO,      //�f�U�C���� (DESIGNRYO)
        	    TBTHB5HIK.HANSHITARYO,    //�ŉ��� (HANSHITARYO)
        	    TBTHB5HIK.SEIHANRYO,      //���ő� (SEIHANRYO)
        	    TBTHB5HIK.TOUDATE,        //�o�^�N���� (TOUDATE)
        	    TBTHB5HIK.HENDATE,        //�ύX�N���� (HENDATE)
        	    TBTHB5HIK.TORDATE         //����N���� (TORDATE)
        };
    }

    /**
     * �����f�[�^�̓o�^���s���܂��B
     *
     * @param vo VO �����f�[�^VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void registHik(HikVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�o�^�G���[", "BD-E0002");
        }
        super.setModel(vo);
        try {
            if (!super.insert()) {
                throw new KKHException("�o�^�G���[", "BD-E0002");
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }
}