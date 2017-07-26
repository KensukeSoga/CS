package jp.co.isid.kkh.customer.epson.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * �����\��ꗗ�i�G�v�\��)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/9 IP JK)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSeikyuPlanDAO extends AbstractRdbDao {

    /** �������� */
    private ReportEpsonSeikyuPlanCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportEpsonSeikyuPlanDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * �v���C�}���L�[��Ԃ��܂��B
     *
     * @return String[] �v���C�}���L�[
     */
    public String[] getPrimryKeyNames() {
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
        return null;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return null;
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    public String getSelectSQL() {
        return getSelectSQLForItem();
    }

    /**
     * ��o���[���擾��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        // ====================================================================================================
        // SELECT��
        // ====================================================================================================
        sql.append(" SELECT ");
        // 2015/04/06 �G�v�\�������g���Ή� Fujisaki Cng Start
        //sql.append(          TBTHB2KMEI.NAME8 	+ " ");          // �L������
        sql.append(          TBTHB2KMEI.NAME11 	+ " ");          // �L������(�g���Ή�)
        // 2015/04/06 �G�v�\�������g���Ή� Fujisaki Cng End
        sql.append("    ," + TBTHB2KMEI.NAME3 	+ " ");          // ���S��
        sql.append("    ," + TBTHB2KMEI.NAME10  + " ");          // ����
        sql.append("    ," + TBTHB2KMEI.CODE4   + " ");          // ������ʃR�[�h
        sql.append("    ," + TBTHB2KMEI.KNGK2   + " ");          // ���O
        sql.append("    ," + TBTHB2KMEI.SEIGAK   + " ");         // ����
        sql.append("    ,CASE " + TBTHB2KMEI.CODE3);
        sql.append("         WHEN ' ' THEN 'zzz'");
        sql.append("         ELSE " + TBTHB2KMEI.CODE3);
        sql.append("     END AS SORT_KEY");
        sql.append("    ," + TBTHB2KMEI.JYUTNO);
        sql.append("    ," + TBTHB2KMEI.JYMEINO);
        sql.append("    ," + TBTHB2KMEI.URMEINO);

        // ====================================================================================================
        // FROM��
        // ====================================================================================================
        sql.append(" FROM");
        sql.append(" " + TBTHB2KMEI.TBNAME);

        // ====================================================================================================
        // WHERE��
        // ====================================================================================================
        sql.append(" WHERE");
        // �������� ---------------------------------------------------------------------------------------------
        sql.append("     " + TBTHB2KMEI.EGCD + "           = '" + _cond.getEgCd() + "'");          // �c�Ə��R�[�h
        sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "       = '" + _cond.getTksKgyCd() + "'");      // ���Ӑ��ƃR�[�h
        sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + "    = '" + _cond.getTksBmnSeqNo() + "'");   // ���Ӑ敔��SEQNO
        sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + "    = '" + _cond.getTksTntSeqNo() + "'");   // ���Ӑ�S��SEQNO
        sql.append(" AND " + TBTHB2KMEI.YYMM  + "          = '" + _cond.getYm() + "'");            // �N��
        sql.append(" AND " + TBTHB2KMEI.NAME21  + "        = '1'");                                // ���׎��

        // ====================================================================================================
        // ORDER BY��
        // ====================================================================================================
        sql.append(" ORDER BY");
        //sql.append("    " + TBTHB2KMEI.NAME3  + " ");         // ���S��
        //sql.append("   ," + TBTHB2KMEI.NAME8  + " ");         // �L������
        //sql.append("   ," + TBTHB2KMEI.NAME10);               // ����
        sql.append("    SORT_KEY");
        sql.append("    ," + TBTHB2KMEI.JYUTNO);
        sql.append("    ," + TBTHB2KMEI.JYMEINO);
        sql.append("    ," + TBTHB2KMEI.URMEINO);

        return sql.toString();
    }


    /**
     * �����\��ꗗ�f�[�^�i�G�v�\��)�̌������s���܂��B
     *
     * @return �����\��ꗗ�i�G�v�\��)VO ���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportEpsonSeikyuPlanVO> findReportEpsonSeikyuPlanByCondition(ReportEpsonSeikyuPlanCondition cond)
            throws KKHException {

        super.setModel(new ReportEpsonSeikyuPlanVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }

    }

    /**
     * Model�̐������s��<br>
     * �������ʂ�VO��KEY���啶���̂��ߕϊ��������s��<br>
     * AbstractRdbDao��createFindedModelInstances���I�[�o�[���C�h<br>
     *
     * @param hashList
     *            List ��������
     * @return List<ReportEpsonSeikyuPlanVO> �ϊ���̌�������
     */
    @Override
    protected List<ReportEpsonSeikyuPlanVO> createFindedModelInstances(List hashList) {

        List<ReportEpsonSeikyuPlanVO> list = new ArrayList<ReportEpsonSeikyuPlanVO>();

        if (getModel() instanceof ReportEpsonSeikyuPlanVO) {

            for (int i = 0; i < hashList.size(); i++) {

                Map result = (Map) hashList.get(i);
                ReportEpsonSeikyuPlanVO vo = new ReportEpsonSeikyuPlanVO();

                // 2015/04/06 �G�v�\�������g���Ή� Fujisaki Cng Start
                //vo.setNAME8((String) result.get(TBTHB2KMEI.NAME8.toUpperCase().trim()));         // �L������
                vo.setNAME11((String) result.get(TBTHB2KMEI.NAME11.toUpperCase().trim()));        // �L������(�g���Ή�)
                // 2015/04/06 �G�v�\�������g���Ή� Fujisaki Cng Start
                vo.setNAME3((String) result.get(TBTHB2KMEI.NAME3.toUpperCase().trim()));         // ���S��
                vo.setNAME10((String) result.get(TBTHB2KMEI.NAME10.toUpperCase().trim()));       // ����
                vo.setCODE4((String) result.get(TBTHB2KMEI.CODE4.toUpperCase().trim()));         // ������ʃR�[�h
                vo.setKNGK2((BigDecimal) result.get(TBTHB2KMEI.KNGK2.toUpperCase().trim()));         // ���O
                vo.setSEIGAK((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase().trim()));       // ����

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
