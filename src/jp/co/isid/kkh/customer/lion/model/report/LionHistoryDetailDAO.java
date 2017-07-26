package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHB92RRKKMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;

/**
 *
 * <P>
 * ���C�I�������w�b�_�[�쐬DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */

public class LionHistoryDetailDAO extends AbstractRdbDao {

    /** ���C�I�������쐬���� */
    LionHistoryCondition _cond = null;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public LionHistoryDetailDAO() {
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
                TBTHB92RRKKMEI.RRKTIMSTMP
                ,TBTHB92RRKKMEI.EGCD
                ,TBTHB92RRKKMEI.TKSKGYCD
                ,TBTHB92RRKKMEI.TKSBMNSEQNO
                ,TBTHB92RRKKMEI.TKSTNTSEQNO
                ,TBTHB92RRKKMEI.YYMM
                ,TBTHB92RRKKMEI.JYUTNO
                ,TBTHB92RRKKMEI.JYMEINO
                ,TBTHB92RRKKMEI.URMEINO
                ,TBTHB92RRKKMEI.RENBN
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
        return TBTHB92RRKKMEI.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     * @return String[] �e�[�u����
     */
    @Override
    public String[] getTableColumnNames() {
        //return null;
        return new String[] {
                TBTHB92RRKKMEI.TIMSTMP
                ,TBTHB92RRKKMEI.UPDAPL
                ,TBTHB92RRKKMEI.UPDTNT
                ,TBTHB92RRKKMEI.RRKTIMSTMP
                ,TBTHB92RRKKMEI.EGCD
                ,TBTHB92RRKKMEI.TKSKGYCD
                ,TBTHB92RRKKMEI.TKSBMNSEQNO
                ,TBTHB92RRKKMEI.TKSTNTSEQNO
                ,TBTHB92RRKKMEI.YYMM
                ,TBTHB92RRKKMEI.JYUTNO
                ,TBTHB92RRKKMEI.JYMEINO
                ,TBTHB92RRKKMEI.URMEINO
                ,TBTHB92RRKKMEI.HIMKCD
                ,TBTHB92RRKKMEI.RENBN
                ,TBTHB92RRKKMEI.DATEFROM
                ,TBTHB92RRKKMEI.DATETO
                ,TBTHB92RRKKMEI.SEIGAK
                ,TBTHB92RRKKMEI.HNNERT
                ,TBTHB92RRKKMEI.HNMAEGAK
                ,TBTHB92RRKKMEI.NEBIGAK
                ,TBTHB92RRKKMEI.DATE1
                ,TBTHB92RRKKMEI.DATE2
                ,TBTHB92RRKKMEI.DATE3
                ,TBTHB92RRKKMEI.DATE4
                ,TBTHB92RRKKMEI.DATE5
                ,TBTHB92RRKKMEI.DATE6
                ,TBTHB92RRKKMEI.KBN1
                ,TBTHB92RRKKMEI.KBN2
                ,TBTHB92RRKKMEI.KBN3
                ,TBTHB92RRKKMEI.CODE1
                ,TBTHB92RRKKMEI.CODE2
                ,TBTHB92RRKKMEI.CODE3
                ,TBTHB92RRKKMEI.CODE4
                ,TBTHB92RRKKMEI.CODE5
                ,TBTHB92RRKKMEI.CODE6
                ,TBTHB92RRKKMEI.NAME1
                ,TBTHB92RRKKMEI.NAME2
                ,TBTHB92RRKKMEI.NAME3
                ,TBTHB92RRKKMEI.NAME4
                ,TBTHB92RRKKMEI.NAME5
                ,TBTHB92RRKKMEI.NAME6
                ,TBTHB92RRKKMEI.NAME7
                ,TBTHB92RRKKMEI.NAME8
                ,TBTHB92RRKKMEI.NAME9
                ,TBTHB92RRKKMEI.NAME10
                ,TBTHB92RRKKMEI.NAME11
                ,TBTHB92RRKKMEI.NAME12
                ,TBTHB92RRKKMEI.NAME13
                ,TBTHB92RRKKMEI.NAME14
                ,TBTHB92RRKKMEI.NAME15
                ,TBTHB92RRKKMEI.NAME16
                ,TBTHB92RRKKMEI.NAME17
                ,TBTHB92RRKKMEI.NAME18
                ,TBTHB92RRKKMEI.NAME19
                ,TBTHB92RRKKMEI.NAME20
                ,TBTHB92RRKKMEI.NAME21
                ,TBTHB92RRKKMEI.NAME22
                ,TBTHB92RRKKMEI.NAME23
                ,TBTHB92RRKKMEI.NAME24
                ,TBTHB92RRKKMEI.NAME25
                ,TBTHB92RRKKMEI.NAME26
                ,TBTHB92RRKKMEI.NAME27
                ,TBTHB92RRKKMEI.NAME28
                ,TBTHB92RRKKMEI.NAME29
                ,TBTHB92RRKKMEI.NAME30
                ,TBTHB92RRKKMEI.KNGK1
                ,TBTHB92RRKKMEI.KNGK2
                ,TBTHB92RRKKMEI.KNGK3
                ,TBTHB92RRKKMEI.RITU1
                ,TBTHB92RRKKMEI.RITU2
                ,TBTHB92RRKKMEI.SONOTA1
                ,TBTHB92RRKKMEI.SONOTA2
                ,TBTHB92RRKKMEI.SONOTA3
                ,TBTHB92RRKKMEI.SONOTA4
                ,TBTHB92RRKKMEI.SONOTA5
                ,TBTHB92RRKKMEI.SONOTA6
                ,TBTHB92RRKKMEI.SONOTA7
                ,TBTHB92RRKKMEI.SONOTA8
                ,TBTHB92RRKKMEI.SONOTA9
                ,TBTHB92RRKKMEI.SONOTA10
                ,TBTHB92RRKKMEI.BUNFLG
                ,TBTHB92RRKKMEI.MEIHNFLG
                ,TBTHB92RRKKMEI.NEBHNFLG
        };
    }

    /**
     * SQL������
     * @return String SQL��
     */
    public String getExecString() {

        // SQL.
        StringBuffer sql = new StringBuffer();

        sql.append("INSERT INTO");
        sql.append(" " + TBTHB92RRKKMEI.TBNAME);
        sql.append(" SELECT");
        sql.append(" " + TBTHB2KMEI.TIMSTMP + ",");         //�^�C���X�^���v
        sql.append(" " + TBTHB2KMEI.UPDAPL + ",");          //�X�V�v���O����
        sql.append(" " + TBTHB2KMEI.UPDTNT + ",");          //�X�V�S����
        sql.append(" TO_DATE('" + _cond.getRrkTimStmp() + "','YYYY-MM-DD HH24:MI:SS'),");   //�����^�C���X�^���v
        sql.append(" " + TBTHB2KMEI.EGCD + ",");            //�c�Ə��R�[�h
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + ",");        //���Ӑ��ƃR�[�h
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + ",");     //���Ӑ敔��SEQNO
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + ",");     //���Ӑ�S��SEQNO
        sql.append(" " + TBTHB2KMEI.YYMM + ",");            //�N��
        sql.append(" " + TBTHB2KMEI.JYUTNO + ",");          //��No
        sql.append(" " + TBTHB2KMEI.JYMEINO + ",");         //�󒍖���No
        sql.append(" " + TBTHB2KMEI.URMEINO + ",");         //���㖾��No
        sql.append(" " + TBTHB2KMEI.HIMKCD + ",");          //��ڃR�[�h
        sql.append(" " + TBTHB2KMEI.RENBN + ",");           //�A��
        sql.append(" " + TBTHB2KMEI.DATEFROM + ",");        //�N����From
        sql.append(" " + TBTHB2KMEI.DATETO + ",");          //�N����To
        sql.append(" " + TBTHB2KMEI.SEIGAK + ",");          //�������z
        sql.append(" " + TBTHB2KMEI.HNNERT + ",");          //�ύX�l����
        sql.append(" " + TBTHB2KMEI.HNMAEGAK + ",");        //�l�����ύX�O���z
        sql.append(" " + TBTHB2KMEI.NEBIGAK + ",");         //�l���z
        sql.append(" " + TBTHB2KMEI.DATE1 + ",");           //���t1
        sql.append(" " + TBTHB2KMEI.DATE2 + ",");           //���t2
        sql.append(" " + TBTHB2KMEI.DATE3 + ",");           //���t3
        sql.append(" " + TBTHB2KMEI.DATE4 + ",");           //���t4
        sql.append(" " + TBTHB2KMEI.DATE5 + ",");           //���t5
        sql.append(" " + TBTHB2KMEI.DATE6 + ",");           //���t6
        sql.append(" " + TBTHB2KMEI.KBN1 + ",");            //�敪1
        sql.append(" " + TBTHB2KMEI.KBN2 + ",");            //�敪2
        sql.append(" " + TBTHB2KMEI.KBN3 + ",");            //�敪3
        sql.append(" " + TBTHB2KMEI.CODE1 + ",");           //�R�[�h1
        sql.append(" " + TBTHB2KMEI.CODE2 + ",");           //�R�[�h2
        sql.append(" " + TBTHB2KMEI.CODE3 + ",");           //�R�[�h3
        sql.append(" " + TBTHB2KMEI.CODE4 + ",");           //�R�[�h4
        sql.append(" " + TBTHB2KMEI.CODE5 + ",");           //�R�[�h5
        sql.append(" " + TBTHB2KMEI.CODE6 + ",");           //�R�[�h6
        sql.append(" " + TBTHB2KMEI.NAME1 + ",");           //����1(����)
        sql.append(" " + TBTHB2KMEI.NAME2 + ",");           //����2(����))
        sql.append(" " + TBTHB2KMEI.NAME3 + ",");           //����3(����)
        sql.append(" " + TBTHB2KMEI.NAME4 + ",");           //����4(����)
        sql.append(" " + TBTHB2KMEI.NAME5 + ",");           //����5(����)
        sql.append(" " + TBTHB2KMEI.NAME6 + ",");           //����6(����)
        sql.append(" " + TBTHB2KMEI.NAME7 + ",");           //����7(����)
        sql.append(" " + TBTHB2KMEI.NAME8 + ",");           //����8(����))
        sql.append(" " + TBTHB2KMEI.NAME9 + ",");           //����9(����)
        sql.append(" " + TBTHB2KMEI.NAME10 + ",");          //����10(����)
        sql.append(" " + TBTHB2KMEI.NAME11 + ",");          //����11(����)
        sql.append(" " + TBTHB2KMEI.NAME12 + ",");          //����12(����)
        sql.append(" " + TBTHB2KMEI.NAME13 + ",");          //����13(����)
        sql.append(" " + TBTHB2KMEI.NAME14 + ",");          //����14(����)
        sql.append(" " + TBTHB2KMEI.NAME15 + ",");          //����15(����)
        sql.append(" " + TBTHB2KMEI.NAME16 + ",");          //����16(����)
        sql.append(" " + TBTHB2KMEI.NAME17 + ",");          //����17(����)
        sql.append(" " + TBTHB2KMEI.NAME18 + ",");          //����18(����)
        sql.append(" " + TBTHB2KMEI.NAME19 + ",");          //����19(����)
        sql.append(" " + TBTHB2KMEI.NAME20 + ",");          //����20(����)
        sql.append(" " + TBTHB2KMEI.NAME21 + ",");          //����21(����)
        sql.append(" " + TBTHB2KMEI.NAME22 + ",");          //����22(����)
        sql.append(" " + TBTHB2KMEI.NAME23 + ",");          //����23(����)
        sql.append(" " + TBTHB2KMEI.NAME24 + ",");          //����24(����)
        sql.append(" " + TBTHB2KMEI.NAME25 + ",");          //����25(����)
        sql.append(" " + TBTHB2KMEI.NAME26 + ",");          //����26(����)
        sql.append(" " + TBTHB2KMEI.NAME27 + ",");          //����27(����)
        sql.append(" " + TBTHB2KMEI.NAME28 + ",");          //����28(����)
        sql.append(" " + TBTHB2KMEI.NAME29 + ",");          //����29(����)
        sql.append(" " + TBTHB2KMEI.NAME30 + ",");          //����30(����)
        sql.append(" " + TBTHB2KMEI.KNGK1 + ",");           //���z1
        sql.append(" " + TBTHB2KMEI.KNGK2 + ",");           //���z2
        sql.append(" " + TBTHB2KMEI.KNGK3 + ",");           //���z3
        sql.append(" " + TBTHB2KMEI.RITU1 + ",");           //�䗦1
        sql.append(" " + TBTHB2KMEI.RITU2 + ",");           //�䗦2
        sql.append(" " + TBTHB2KMEI.SONOTA1 + ",");         //���̑�1
        sql.append(" " + TBTHB2KMEI.SONOTA2 + ",");         //���̑�2
        sql.append(" " + TBTHB2KMEI.SONOTA3 + ",");         //���̑�3
        sql.append(" " + TBTHB2KMEI.SONOTA4 + ",");         //���̑�4
        sql.append(" " + TBTHB2KMEI.SONOTA5 + ",");         //���̑�5
        sql.append(" " + TBTHB2KMEI.SONOTA6 + ",");         //���̑�6
        sql.append(" " + TBTHB2KMEI.SONOTA7 + ",");         //���̑�7
        sql.append(" " + TBTHB2KMEI.SONOTA8 + ",");         //���̑�8
        sql.append(" " + TBTHB2KMEI.SONOTA9 + ",");         //���̑�9
        sql.append(" " + TBTHB2KMEI.SONOTA10 + ",");        //���̑�10
        sql.append(" " + TBTHB2KMEI.BUNFLG + ",");          //�����t���O
        sql.append(" " + TBTHB2KMEI.MEIHNFLG + ",");        //�����ύX�t���O
        sql.append(" " + TBTHB2KMEI.NEBHNFLG + ",");              //�l�����ύX�t���O
        sql.append(" '" + _cond.getEsqId() + "'");          //����o�^�S����(ESQ-ID)
        sql.append(" FROM");
        sql.append("  " + TBTHB2KMEI.TBNAME);
        sql.append(" WHERE");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _cond.getYymm() + "'");

        return sql.toString();
    }

    /**
     * �L����ח������쐬
     * @param cond ��������
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void insertHistoryDetailCreate(LionHistoryCondition cond)
            throws KKHException {
        try {
            _cond = cond;
            super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

}
