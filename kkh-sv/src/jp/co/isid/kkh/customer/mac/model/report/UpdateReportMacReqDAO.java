package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * �f�[�^�X�VDAO(������)
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/18 IP Shimizu)<BR>
 * </P>
 * @author IP Shimizu
 */
public class UpdateReportMacReqDAO extends AbstractSimpleRdbDao {

    /**�ėp�}�X�^(�f�[�^)��������*/
    private UpdateReportMacReqDataVO _updateMeiVO;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public UpdateReportMacReqDAO() {
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
        return TBTHBAMST.TRKTIMSTMP;
    }

    /**
     * �V�X�e�����t�ōX�V�����̒�`�ł�
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[] { TBTHBAMST.TRKTIMSTMP,TBTHBAMST.UPDTIMSTMP };
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    public String getTableName() {
        return TBTHBAMST.TBNAME;
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
     * �}�X�^(�f�[�^)�̓o�^
     *
     * @param vo �}�X�^�f�[�^VO�iINSERT�p�j
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void updateReportMacRequest(UpdateReportMacReqDataVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�X�V�G���[", "BD-E0003");
        }
        _updateMeiVO = vo;
        try {
                super.exec();
              } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

    /**
     * �X�V�r�p�k����
     */
    @Override
    public String getExecString()
    {
        StringBuffer sql = new StringBuffer();

        sql.append(" UPDATE ");
        sql.append(" " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" SET ");
        sql.append(" " + TBTHB2KMEI.DATE2 + " = '" + _updateMeiVO.getDate1() + "', ");
        sql.append(" " + TBTHB2KMEI.UPDAPL + " = '" + _updateMeiVO.getUpdApl() + "', ");
        sql.append(" " + TBTHB2KMEI.TIMSTMP + " = SYSDATE ");
        // Where��
        sql.append(" WHERE ");
        sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _updateMeiVO.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _updateMeiVO.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _updateMeiVO.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _updateMeiVO.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _updateMeiVO.getYymm() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYUTNO + " = '" + _updateMeiVO.getJyutNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.JYMEINO + " = '" + _updateMeiVO.getJyMeiNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.URMEINO + " = '" + _updateMeiVO.getUrMeiNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.RENBN + " = '" + _updateMeiVO.getRenbn() + "' ");

        return sql.toString();
    }

}