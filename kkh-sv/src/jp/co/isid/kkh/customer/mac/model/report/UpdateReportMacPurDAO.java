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
 * �f�[�^�X�VDAO(�w���`�[)
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/17 IP Shimizu)<BR>
 * </P>
 * @author IP Shimizu
 */
public class UpdateReportMacPurDAO extends AbstractSimpleRdbDao {

    /**�ėp�}�X�^(�f�[�^)��������*/
    private UpdateReportMacPurDataVO _updateMeiVO;
    private UpdateReportMacPurCondition _updateVO;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SqlMode{UPD,SYSUPD};
    private SqlMode _sqlMode = SqlMode.UPD;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public UpdateReportMacPurDAO() {
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
    public void updateReportMacPurchase(UpdateReportMacPurDataVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�X�V�G���[", "BD-E0003");
        }
        _updateMeiVO = vo;
        _sqlMode = SqlMode.UPD;
        try {
                super.exec();
              } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

    /**
     * �}�X�^(�f�[�^)�̓o�^
     *
     * @param vo �}�X�^�f�[�^VO�iINSERT�p�j
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void updateReportMacSysDenNum(UpdateReportMacPurCondition vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�X�V�G���[", "BD-E0002");
        }
        _updateVO = vo;
        _sqlMode = SqlMode.SYSUPD;
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
    public String getExecString() {
        if (_sqlMode == SqlMode.UPD)
            {return getUpdateSQLForMeisai();}
        else
            {return getUpdateSQLForSysMas();}
    }

    /**
     * �V�X�e���}�X�^�X�V�p
     * @return
     */
    private String getUpdateSQLForMeisai(){

        StringBuffer sql = new StringBuffer();

        sql.append(" UPDATE ");
        sql.append(" " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" SET ");
        sql.append(" " + TBTHB2KMEI.SONOTA1 + " = '" + _updateMeiVO.getSonota1() + "', ");
        sql.append(" " + TBTHB2KMEI.UPDAPL + " = '" + _updateMeiVO.getUpdApl() + "', ");
        sql.append(" " + TBTHB2KMEI.UPDTNT + " = '" + _updateMeiVO.getUpdTnt() + "', ");
        if (!_updateMeiVO.getKbn1().equals("2"))
        {
            sql.append(" " + TBTHB2KMEI.DATE1 + " = '" + _updateMeiVO.getDate1() + "', ");
        }
        else
        {
            sql.append(" " + TBTHB2KMEI.DATE1 + " = '" + "        "+ "', ");
        }
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

    /**
     * �V�X�e���}�X�^�X�V�p
     * @return
     */
    private String getUpdateSQLForSysMas(){

        StringBuffer sql = new StringBuffer();

        sql.append(" UPDATE ");
        sql.append(" " + TBTHBAMST.TBNAME + " ");
        sql.append(" SET ");
        sql.append(" " + TBTHBAMST.FIELD1 + " = '" + _updateVO.getDenNum() + "', ");
        sql.append(" " + TBTHBAMST.UPDAPL + " = '" + _updateVO.getAplId() + "', ");
        sql.append(" " + TBTHBAMST.UPDTNT + " = '" + _updateVO.getEsqId() + "', ");
        sql.append(" " + TBTHBAMST.UPDTIMSTMP + " = SYSDATE ");
        // Where��
        sql.append(" WHERE ");
        sql.append(" " + TBTHBAMST.EGCD + " = '" + _updateVO.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = '" + _updateVO.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = '" + _updateVO.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = '" + _updateVO.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '201' ");

        return sql.toString();
    }

}
