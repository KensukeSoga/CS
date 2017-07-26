package jp.co.isid.kkh.model.detail;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * �󒍔ԍ�����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/28 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
public class JyutNoTouInsDAO extends AbstractSimpleRdbDao  {

    private JyutNoTouInsVO _vo;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public JyutNoTouInsDAO() {
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
        return null;
    }

    /**
     * �X�V���t�t�B�[���h��Ԃ��܂��B
     *
     * @return String �X�V���t�t�B�[���h
     */
    public String getTimeStampKeyName() {
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    public String getTableName() {
        return TBTHB1DOWN.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[]{};
    }

    /**
     * �󒍓��e�����o�^���s���܂��B
     *
     * @param vo VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void JyutNoTouIns(JyutNoTouInsVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�o�^�G���[", "BD-E0002");
        }
        //super.setModel(vo);
        _vo = vo;
        try {
                super.exec();
              } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * EXEC-SQL����
     */
    @Override
    public String getExecString() {

        StringBuffer sql = new StringBuffer();

        sql.append(" INSERT ");
        sql.append(" INTO " + TBTHB1DOWN.TBNAME);
        sql.append(" ( ");
        sql.append("   " + TBTHB1DOWN.TIMSTMP);
        sql.append("  ," + TBTHB1DOWN.UPDAPL);
        sql.append("  ," + TBTHB1DOWN.UPDTNT);
        sql.append("  ," + TBTHB1DOWN.ATUEGCD);
        sql.append("  ," + TBTHB1DOWN.EGCD);
        sql.append("  ," + TBTHB1DOWN.TKSKGYCD);
        sql.append("  ," + TBTHB1DOWN.TKSBMNSEQNO);
        sql.append("  ," + TBTHB1DOWN.TKSTNTSEQNO);
        sql.append("  ," + TBTHB1DOWN.JYUTNO);
        sql.append("  ," + TBTHB1DOWN.JYMEINO);
        sql.append("  ," + TBTHB1DOWN.URMEINO);
        sql.append("  ," + TBTHB1DOWN.GPYNO);
        sql.append("  ," + TBTHB1DOWN.GPYOPAG);
        sql.append("  ," + TBTHB1DOWN.SEINO);
        sql.append("  ," + TBTHB1DOWN.HIMKCD);
        sql.append("  ," + TBTHB1DOWN.TOUFLG);
        sql.append("  ," + TBTHB1DOWN.YYMM);
        sql.append("  ," + TBTHB1DOWN.GYOMKBN);
        sql.append("  ," + TBTHB1DOWN.MSKBN);
        sql.append("  ," + TBTHB1DOWN.TMSPKBN);
        sql.append("  ," + TBTHB1DOWN.KOKKBN);
        sql.append("  ," + TBTHB1DOWN.SEIKBN);
        sql.append("  ," + TBTHB1DOWN.SYONO);
        sql.append("  ," + TBTHB1DOWN.KKNAMEKJ);
        sql.append("  ," + TBTHB1DOWN.EGGAMENTYPE);
        sql.append("  ," + TBTHB1DOWN.KKAKSHANKBN);
        sql.append("  ," + TBTHB1DOWN.TORIGAK);
        sql.append("  ," + TBTHB1DOWN.SEITNKA);
        sql.append("  ," + TBTHB1DOWN.SEIGAK);
        sql.append("  ," + TBTHB1DOWN.NEBIRITU);
        sql.append("  ," + TBTHB1DOWN.NEBIGAK);
        sql.append("  ," + TBTHB1DOWN.SZEIKBN);
        sql.append("  ," + TBTHB1DOWN.SZEIRITU);
        sql.append("  ," + TBTHB1DOWN.SZEIGAK);
        sql.append("  ," + TBTHB1DOWN.HIMKNMKJ);
        sql.append("  ," + TBTHB1DOWN.HIMKNMKN);
        sql.append("  ," + TBTHB1DOWN.TJYUTNO);
        sql.append("  ," + TBTHB1DOWN.TJYMEINO);
        sql.append("  ," + TBTHB1DOWN.TURMEINO);
        sql.append("  ," + TBTHB1DOWN.MSEIFLG);
        sql.append("  ," + TBTHB1DOWN.YYMMOLD);
        sql.append("  ," + TBTHB1DOWN.FIELD1);
        sql.append("  ," + TBTHB1DOWN.FIELD2);
        sql.append("  ," + TBTHB1DOWN.FIELD3);
        sql.append("  ," + TBTHB1DOWN.FIELD4);
        sql.append("  ," + TBTHB1DOWN.FIELD5);
        sql.append("  ," + TBTHB1DOWN.FIELD6);
        sql.append("  ," + TBTHB1DOWN.FIELD7);
        sql.append("  ," + TBTHB1DOWN.FIELD8);
        sql.append("  ," + TBTHB1DOWN.FIELD9);
        sql.append("  ," + TBTHB1DOWN.FIELD10);
        sql.append("  ," + TBTHB1DOWN.FIELD11);
        sql.append("  ," + TBTHB1DOWN.FIELD12);
        sql.append("  ," + TBTHB1DOWN.FILETIMSTMP);
        sql.append("  ," + TBTHB1DOWN.MEITIMSTMP);
        sql.append("  ," + TBTHB1DOWN.JYUTDELFLG);
        sql.append(" ) ");
        sql.append("VALUES ( ");
        sql.append(" SYSDATE, "); 										//�^�C���X�^���v
        sql.append(" '" + _vo.get_aplId() + "' , ");						//
        sql.append(" '" + _vo.get_esqId() + "', ");						//�X�V�S����
        sql.append(" '" + _vo.get_egCd() + "', ");						//�����c�Ə�
        sql.append(" '" + _vo.get_egCd() + "', ");						//�c�Ə�
        sql.append(" '" + _vo.get_tksKgyCd() + "', ");					//���Ӑ�R�[�h
        sql.append(" '" + _vo.get_tksBmnSeqNo() + "', ");				//���Ӑ敔��SEQNO
        sql.append(" '" + _vo.get_tksTntSeqNo() + "', ");				//���Ӑ�S��SEQNO
        sql.append(" '" + _vo.get_keyJyutno() + "', ");					//��No
        sql.append(" '" + _vo.get_keyJyMeiNo() + "', ");				//�󒍖���No
        sql.append(" '" + _vo.get_keyUriMeiNo() + "', ");				//���㖾��No
        sql.append(" ' ', ");											//�������[No
        sql.append(" ' ', ");											//�y�[�WNo
        sql.append(" ' ', ");											//����No
        sql.append(" '" + _vo.get_himkCd() + "', ");					//��ڃR�[�h
        sql.append(" '1', ");											//�����t���O
        sql.append(" '" + _vo.get_YYMM() + "', ");						//�N��
        sql.append(" '" + _vo.get_gyomKbn() + "', ");					//�Ɩ��敪
        sql.append(" '" + _vo.get_msKbn() + "', ");						//���ۃ}�X�����敪
        sql.append(" '" + _vo.get_tmsKbn() + "', ");					//�^�C���X�|�b�g�敪
        sql.append(" '" + _vo.get_kokKbn() + "', ");					//���ۋ敪
        sql.append(" '" + _vo.get_seiKbn() + "', ");					//�����敪
        sql.append(" '" + _vo.get_syoNo() + "', ");						//���iNo
        sql.append(" '" + _vo.get_kknameKj() + "', ");					//����
        sql.append(" '" + _vo.get_egGamenType() + "', ");				//�c�Ɖ�ʃ^�C�v
        sql.append(" '" + _vo.get_kkakShanKbn() + "', ");				//���E���ŋ敪
        sql.append(" " + _vo.get_toriRyouKin() + ", ");					//��藿��
        sql.append(" 0, ");												//�����P��
        sql.append(" " + _vo.get_seikyuKin() + ", ");					//�������z
        sql.append(" " + _vo.get_nebikiRitu() + ", ");					//�l����
        sql.append(" " + _vo.get_nebikiGaku() + ", ");					//�l���z
        sql.append(" '" + _vo.get_szeiKbn() + "', ");					//����ŋ敪
        sql.append(" " + _vo.get_szeiRitu() + ", ");					//����ŗ�
        sql.append(" " + _vo.get_szeiGaku() + ", ");					//����Ŋz
        sql.append(" '" + _vo.get_himkNmkj() + "', ");					//��ږ�
        sql.append(" ' ', ");											//��ږ�kana
        sql.append(" ' ', ");											//�������No
        sql.append(" ' ', ");											//������󒍖���No
        sql.append(" ' ', ");											//�����攄�㖾��No
        sql.append(" ' ', ");											//�������t���O
        sql.append(" null, ");											//�ύX�O�����N��
        sql.append(" '" + _vo.get_field1() + "', ");					//�t�B�[���h1
        sql.append(" '" + _vo.get_field2() + "', ");					//�t�B�[���h2
        sql.append(" '" + _vo.get_field3() + "', ");					//�t�B�[���h3
        sql.append(" '" + _vo.get_field4() + "', ");					//�t�B�[���h4
        sql.append(" '" + _vo.get_field5() + "', ");					//�t�B�[���h5
        sql.append(" '" + _vo.get_field6() + "', ");					//�t�B�[���h6
        sql.append(" '" + _vo.get_field7() + "', ");					//�t�B�[���h7
        sql.append(" '" + _vo.get_field8() + "', ");					//�t�B�[���h8
        sql.append(" '" + _vo.get_field9() + "', ");					//�t�B�[���h9
        sql.append(" '" + _vo.get_field10() + "', ");					//�t�B�[���h10
        sql.append(" '" + _vo.get_field11() + "', ");					//�t�B�[���h11
        sql.append(" '" + _vo.get_field12() + "', ");					//�t�B�[���h12
        sql.append(" '" + _vo.get_fileTimStmp() + "', ");				//�_�E�����[�h�t�@�C���^�C���X�^���v
        sql.append(" '" + _vo.get_meiTimStmp() + "', ");				//���דo�^����
        sql.append(" '" + _vo.get_jyutDelFlg() + "') ");				//�󒍍폜�t���O

        return sql.toString();
    }

}