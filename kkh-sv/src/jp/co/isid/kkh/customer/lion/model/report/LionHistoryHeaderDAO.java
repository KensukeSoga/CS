package jp.co.isid.kkh.customer.lion.model.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB91RRKDOWN;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ���C�I�������w�b�_�[DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */

public class LionHistoryHeaderDAO extends AbstractRdbDao {

    /** ���C�I���������� */
    LionHistoryCondition _cond = null;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public LionHistoryHeaderDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * �v���C�}���L�[��Ԃ��܂��B
     * @return String[] �v���C�}���L�[
     */
    @Override
    public String[] getPrimryKeyNames() {
        return new String[] {
                TBTHB91RRKDOWN.RRKTIMSTMP
                ,TBTHB91RRKDOWN.EGCD
                ,TBTHB91RRKDOWN.TKSKGYCD
                ,TBTHB91RRKDOWN.TKSBMNSEQNO
                ,TBTHB91RRKDOWN.TKSTNTSEQNO
                ,TBTHB91RRKDOWN.YYMM
                ,TBTHB91RRKDOWN.JYUTNO
                ,TBTHB91RRKDOWN.JYMEINO
                ,TBTHB91RRKDOWN.URMEINO
                ,TBTHB91RRKDOWN.TOUFLG
        };
    }

    /**
     * �X�V���t�t�B�[���h��Ԃ��܂��B
     * @return String �X�V���t�t�B�[���h
     */
    public String getTimeStampKeyName() {
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     * @return String �e�[�u����
     */
    @Override
    public String getTableName() {
        return TBTHB91RRKDOWN.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     * @return String[] �e�[�u����
     */
    @Override
    public String[] getTableColumnNames() {
        //return null;
        return new String[] {
                TBTHB91RRKDOWN.TRKTIMSTMP
                ,TBTHB91RRKDOWN.TRKAPL
                ,TBTHB91RRKDOWN.TRKTNT
                ,TBTHB91RRKDOWN.TRKTNTNM
                ,TBTHB91RRKDOWN.KSNTIMSTMP
                ,TBTHB91RRKDOWN.KSNTNT
                ,TBTHB91RRKDOWN.KSNTNTNM
                ,TBTHB91RRKDOWN.TIMSTMP
                ,TBTHB91RRKDOWN.UPDAPL
                ,TBTHB91RRKDOWN.UPDTNT
                ,TBTHB91RRKDOWN.ATUEGCD
                ,TBTHB91RRKDOWN.RRKTIMSTMP
                ,TBTHB91RRKDOWN.EGCD
                ,TBTHB91RRKDOWN.TKSKGYCD
                ,TBTHB91RRKDOWN.TKSBMNSEQNO
                ,TBTHB91RRKDOWN.TKSTNTSEQNO
                ,TBTHB91RRKDOWN.JYUTNO
                ,TBTHB91RRKDOWN.JYMEINO
                ,TBTHB91RRKDOWN.URMEINO
                ,TBTHB91RRKDOWN.GPYNO
                ,TBTHB91RRKDOWN.GPYOPAG
                ,TBTHB91RRKDOWN.SEINO
                ,TBTHB91RRKDOWN.HIMKCD
                ,TBTHB91RRKDOWN.TOUFLG
                ,TBTHB91RRKDOWN.YYMM
                ,TBTHB91RRKDOWN.GYOMKBN
                ,TBTHB91RRKDOWN.MSKBN
                ,TBTHB91RRKDOWN.TMSPKBN
                ,TBTHB91RRKDOWN.KOKKBN
                ,TBTHB91RRKDOWN.SEIKBN
                ,TBTHB91RRKDOWN.SYONO
                ,TBTHB91RRKDOWN.KKNAMEKJ
                ,TBTHB91RRKDOWN.EGGAMENTYPE
                ,TBTHB91RRKDOWN.KKAKSHANKBN
                ,TBTHB91RRKDOWN.TORIGAK
                ,TBTHB91RRKDOWN.SEITNKA
                ,TBTHB91RRKDOWN.SEIGAK
                ,TBTHB91RRKDOWN.NEBIRITU
                ,TBTHB91RRKDOWN.NEBIGAK
                ,TBTHB91RRKDOWN.SZEIKBN
                ,TBTHB91RRKDOWN.SZEIRITU
                ,TBTHB91RRKDOWN.SZEIGAK
                ,TBTHB91RRKDOWN.HIMKNMKJ
                ,TBTHB91RRKDOWN.HIMKNMKN
                ,TBTHB91RRKDOWN.TJYUTNO
                ,TBTHB91RRKDOWN.TJYMEINO
                ,TBTHB91RRKDOWN.TURMEINO
                ,TBTHB91RRKDOWN.MSEIFLG
                ,TBTHB91RRKDOWN.YYMMOLD
                ,TBTHB91RRKDOWN.FIELD1
                ,TBTHB91RRKDOWN.FIELD2
                ,TBTHB91RRKDOWN.FIELD3
                ,TBTHB91RRKDOWN.FIELD4
                ,TBTHB91RRKDOWN.FIELD5
                ,TBTHB91RRKDOWN.FIELD6
                ,TBTHB91RRKDOWN.FIELD7
                ,TBTHB91RRKDOWN.FIELD8
                ,TBTHB91RRKDOWN.FIELD9
                ,TBTHB91RRKDOWN.FIELD10
                ,TBTHB91RRKDOWN.FIELD11
                ,TBTHB91RRKDOWN.FIELD12
                ,TBTHB91RRKDOWN.FILETIMSTMP
                ,TBTHB91RRKDOWN.MEITIMSTMP
                ,TBTHB91RRKDOWN.JYUTDELFLG
        };
    }

    /**
     * �����쐬SQL������
     * @return String SQL��
     */
    public String getExecString() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("INSERT INTO");
        sql.append(" " + TBTHB91RRKDOWN.TBNAME);
        sql.append(" SELECT");
        sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + ",");      //�o�^�^�C���X�^���v
        sql.append(" " + TBTHB1DOWN.TRKAPL + ",");          //�o�^�v���O����
        sql.append(" " + TBTHB1DOWN.TRKTNT + ",");          //�o�^�S����ID
        sql.append(" " + TBTHB1DOWN.TRKTNTNM + ",");        //�o�^�S���Җ�
        sql.append(" " + TBTHB1DOWN.KSNTIMSTMP + ",");      //���׍X�V�^�C���X�^���v
        sql.append(" " + TBTHB1DOWN.KSNTNT + ",");          //���׍X�V��ID
        sql.append(" " + TBTHB1DOWN.KSNTNTNM + ",");        //���׍X�V�Җ�
        sql.append(" " + TBTHB1DOWN.TIMSTMP + ",");         //�X�V�^�C���X�^���v
        sql.append(" " + TBTHB1DOWN.UPDAPL + ",");          //�X�V�v���O����
        sql.append(" " + TBTHB1DOWN.UPDTNT + ",");          //�X�V�S����
        sql.append(" " + TBTHB1DOWN.ATUEGCD+ ",");          //�c�Ə�(��)�R�[�h
        sql.append(" TO_DATE('" + _cond.getRrkTimStmp() + "','YYYY-MM-DD HH24:MI:SS'),");    //�����^�C���X�^���v
        sql.append(" " + TBTHB1DOWN.EGCD + ",");            //�c�Ə�(��)�R�[�h
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + ",");        //���Ӑ��ƃR�[�h
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + ",");     //���Ӑ敔��SEQNO
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + ",");     //���Ӑ�S��SEQNO
        sql.append(" " + TBTHB1DOWN.JYUTNO + ",");          //��No
        sql.append(" " + TBTHB1DOWN.JYMEINO + ",");         //�󒍖���No
        sql.append(" " + TBTHB1DOWN.URMEINO + ",");         //���㖾��No
        sql.append(" " + TBTHB1DOWN.GPYNO + ",");           //�������[No
        sql.append(" " + TBTHB1DOWN.GPYOPAG + ",");         //�y�[�WNo
        sql.append(" " + TBTHB1DOWN.SEINO + ",");           //����No
        sql.append(" " + TBTHB1DOWN.HIMKCD + ",");          //��ڃR�[�h
        sql.append(" " + TBTHB1DOWN.TOUFLG + ",");          //�����t���O
        sql.append(" " + TBTHB1DOWN.YYMM + ",");            //�N��
        sql.append(" " + TBTHB1DOWN.GYOMKBN + ",");         //�Ɩ��敪
        sql.append(" " + TBTHB1DOWN.MSKBN + ",");           //�}�X�����敪
        sql.append(" " + TBTHB1DOWN.TMSPKBN + ",");         //�^�C���X�|�b�g�敪
        sql.append(" " + TBTHB1DOWN.KOKKBN + ",");          //���ۋ敪
        sql.append(" " + TBTHB1DOWN.SEIKBN + ",");          //�����敪
        sql.append(" " + TBTHB1DOWN.SYONO + ",");           //���iNo
        sql.append(" " + TBTHB1DOWN.KKNAMEKJ + ",");        //����(����)
        sql.append(" " + TBTHB1DOWN.EGGAMENTYPE + ",");     //�c�Ɖ�ʃ^�C�v
        sql.append(" " + TBTHB1DOWN.KKAKSHANKBN + ",");     //���E���ŋ敪
        sql.append(" " + TBTHB1DOWN.TORIGAK + ",");         //�旿��
        sql.append(" " + TBTHB1DOWN.SEITNKA + ",");         //�����P��
        sql.append(" " + TBTHB1DOWN.SEIGAK + ",");          //�������z
        sql.append(" " + TBTHB1DOWN.NEBIRITU + ",");        //�l����
        sql.append(" " + TBTHB1DOWN.NEBIGAK + ",");         //�l���z
        sql.append(" " + TBTHB1DOWN.SZEIKBN + ",");         //����ŋ敪
        sql.append(" " + TBTHB1DOWN.SZEIRITU + ",");        //����ŗ�
        sql.append(" " + TBTHB1DOWN.SZEIGAK + ",");         //����Ŋz
        sql.append(" " + TBTHB1DOWN.HIMKNMKJ + ",");        //��ږ�(����)
        sql.append(" " + TBTHB1DOWN.HIMKNMKN + ",");        //��ږ�(�J�i)
        sql.append(" " + TBTHB1DOWN.TJYUTNO + ",");         //�������No
        sql.append(" " + TBTHB1DOWN.TJYMEINO + ",");        //������󒍖���No
        sql.append(" " + TBTHB1DOWN.TURMEINO + ",");        //�����攄�㖾��No
        sql.append(" " + TBTHB1DOWN.MSEIFLG + ",");         //�������t���O
        sql.append(" " + TBTHB1DOWN.YYMMOLD + ",");         //�ύX�O�N��
        sql.append(" " + TBTHB1DOWN.FIELD1 + ",");          //�t�B�[���h1
        sql.append(" " + TBTHB1DOWN.FIELD2 + ",");          //�t�B�[���h2
        sql.append(" " + TBTHB1DOWN.FIELD3 + ",");          //�t�B�[���h3
        sql.append(" " + TBTHB1DOWN.FIELD4 + ",");          //�t�B�[���h4
        sql.append(" " + TBTHB1DOWN.FIELD5 + ",");          //�t�B�[���h5
        sql.append(" " + TBTHB1DOWN.FIELD6 + ",");          //�t�B�[���h6
        sql.append(" " + TBTHB1DOWN.FIELD7 + ",");          //�t�B�[���h7
        sql.append(" " + TBTHB1DOWN.FIELD8 + ",");          //�t�B�[���h8
        sql.append(" " + TBTHB1DOWN.FIELD9 + ",");          //�t�B�[���h9
        sql.append(" " + TBTHB1DOWN.FIELD10 + ",");         //�t�B�[���h10
        sql.append(" " + TBTHB1DOWN.FIELD11 + ",");         //�t�B�[���h11
        sql.append(" " + TBTHB1DOWN.FIELD12 + ",");         //�t�B�[���h12
        sql.append(" " + TBTHB1DOWN.FILETIMSTMP + ",");     //�_�E�����[�h�t�@�C���^�C���X�^���v
        sql.append(" " + TBTHB1DOWN.MEITIMSTMP + ",");      //���דo�^����
        sql.append(" " + TBTHB1DOWN.JYUTDELFLG + ",");      //�󒍍폜�t���O
        sql.append(" '" + _cond.getEsqId() + "',");         //����o�^�S����(ESQ-ID)
        sql.append(" '" + _cond.getRrkGetBaitai() + "',");  //�����쐬���I��}��
        sql.append(" '0'");                                 //����AD1�t���O
        sql.append(" FROM");
        sql.append("  " + TBTHB1DOWN.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "'");

        return sql.toString();
    }

   /**
     * �󒍃_�E�����[�h�������쐬
     * @param cond ��������
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void insertHistoryHeaderCreate(LionHistoryCondition cond) throws KKHException {

        try {
            _cond = cond;
            super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * Model�̐������s��<br>
     * �������ʂ�VO��KEY���啶���̂��ߕϊ��������s��<br>
     * AbstractRdbDao��createFindedModelInstances���I�[�o�[���C�h<br>
     *
     * @param hashList List ��������
     * @return List<LionHistoryVO> ���C�I�������f�[�^��������VO���X�g
     */
    @Override
    protected List<LionHistoryVO> createFindedModelInstances(List hashList) {

        List<LionHistoryVO> list = new ArrayList<LionHistoryVO>();
        if (getModel() instanceof LionHistoryVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                LionHistoryVO vo = new LionHistoryVO();

                //�����^�C���X�^���v
                vo.setRrkTimStmp((String) result.get(TBTHB91RRKDOWN.RRKTIMSTMP.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
