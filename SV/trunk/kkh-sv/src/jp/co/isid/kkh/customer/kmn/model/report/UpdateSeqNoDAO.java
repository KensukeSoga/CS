package jp.co.isid.kkh.customer.kmn.model.report;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;

/**
 *
 * <P>
 * �V�[�P���XNo�o�^�E�X�VDAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/2/26 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class UpdateSeqNoDAO extends AbstractRdbDao {

    /**�V�[�P���XNo�o�^�f�[�^ */
    private UpdateSeqNoCondition _cond;

    /**�V�[�P���XNo�o�^�f�[�^ */
    private ReportKmnListVO _vo;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode{KIND,ITEM,};
//    private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public UpdateSeqNoDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * �v���C�}���L�[��Ԃ��܂��B
     *
     * @return String[] �v���C�}���L�[
     */
    @Override
    public String[] getPrimryKeyNames() {
        return new String[]{
                TBTHB2KMEI.EGCD,
                TBTHB2KMEI.TKSKGYCD,
                TBTHB2KMEI.TKSBMNSEQNO,
                TBTHB2KMEI.TKSTNTSEQNO,
                TBTHB2KMEI.YYMM,
                TBTHB2KMEI.JYUTNO,
                TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO,
                TBTHB2KMEI.RENBN
        };
    }

    /**
     * �X�V���t�t�B�[���h��Ԃ��܂��B
     *
     * @return String �X�V���t�t�B�[���h
     */
    public String getTimeStampKeyName() {
        //new String[] {};
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    @Override
    public String getTableName() {
        return TBTHB2KMEI.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    @Override
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB2KMEI.TIMSTMP,
                TBTHB2KMEI.UPDAPL,
                TBTHB2KMEI.UPDTNT,
                TBTHB2KMEI.EGCD,
                TBTHB2KMEI.TKSKGYCD,
                TBTHB2KMEI.TKSBMNSEQNO,
                TBTHB2KMEI.TKSTNTSEQNO,
                TBTHB2KMEI.YYMM,
                TBTHB2KMEI.JYUTNO,
                TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO,
                TBTHB2KMEI.HIMKCD,
                TBTHB2KMEI.RENBN,
                TBTHB2KMEI.DATEFROM,
                TBTHB2KMEI.DATETO,
                TBTHB2KMEI.SEIGAK,
                TBTHB2KMEI.HNNERT,
                TBTHB2KMEI.HNMAEGAK,
                TBTHB2KMEI.NEBIGAK,
                TBTHB2KMEI.DATE1,
                TBTHB2KMEI.DATE2,
                TBTHB2KMEI.DATE3,
                TBTHB2KMEI.DATE4,
                TBTHB2KMEI.DATE5,
                TBTHB2KMEI.DATE6,
                TBTHB2KMEI.KBN1,
                TBTHB2KMEI.KBN2,
                TBTHB2KMEI.KBN3,
                TBTHB2KMEI.CODE1,
                TBTHB2KMEI.CODE2,
                TBTHB2KMEI.CODE3,
                TBTHB2KMEI.CODE4,
                TBTHB2KMEI.CODE5,
                TBTHB2KMEI.CODE6,
                TBTHB2KMEI.NAME1,
                TBTHB2KMEI.NAME2,
                TBTHB2KMEI.NAME3,
                TBTHB2KMEI.NAME4,
                TBTHB2KMEI.NAME5,
                TBTHB2KMEI.NAME6,
                TBTHB2KMEI.NAME7,
                TBTHB2KMEI.NAME8,
                TBTHB2KMEI.NAME9,
                TBTHB2KMEI.NAME10,
                TBTHB2KMEI.KNGK1,
                TBTHB2KMEI.KNGK2,
                TBTHB2KMEI.KNGK3,
                TBTHB2KMEI.RITU1,
                TBTHB2KMEI.RITU2,
                TBTHB2KMEI.SONOTA1,
                TBTHB2KMEI.SONOTA2,
                TBTHB2KMEI.SONOTA3,
                TBTHB2KMEI.SONOTA4,
                TBTHB2KMEI.SONOTA5,
                TBTHB2KMEI.SONOTA6,
                TBTHB2KMEI.SONOTA7,
                TBTHB2KMEI.SONOTA8,
                TBTHB2KMEI.SONOTA9,
                TBTHB2KMEI.SONOTA10,
                TBTHB2KMEI.BUNFLG,
                TBTHB2KMEI.MEIHNFLG,
                TBTHB2KMEI.NEBHNFLG
        };
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getExecString() {
        return getSelectSQLForItem();
    }

    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        sql.append(" UPDATE ");
        sql.append("  " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" SET ");
        sql.append(" " + TBTHB2KMEI.CODE2 + " ");
        sql.append(" = '" + _vo.getShutNo() + "' "); //�o��No
        sql.append(" ," + TBTHB2KMEI.CODE3 + " ");
        sql.append(" = '" + _vo.getSeqNo() + "' "); //�V�[�P���XNo
        sql.append(" ," + TBTHB2KMEI.NAME16 + " ");
        sql.append(" = '" + _vo.getAtesaki() + "' "); //����
        sql.append(" ," + TBTHB2KMEI.DATE1 + " ");
        sql.append(" = " + "SYSDATE" + " ");        //�^�C���X�^���v
        sql.append(" WHERE ");
        sql.append("  " + TBTHB2KMEI.TKSKGYCD + " ");
        sql.append(" = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append("  " + TBTHB2KMEI.TKSBMNSEQNO + " ");
        sql.append(" = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append("  " + TBTHB2KMEI.TKSTNTSEQNO + " ");
        sql.append(" = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append("  " + TBTHB2KMEI.JYUTNO + " ");
        sql.append(" = '" + _vo.getJyutNo() + "' ");
        sql.append(" AND ");
        sql.append("  " + TBTHB2KMEI.JYMEINO + " ");
        sql.append(" = '" + _vo.getJyMeiNo() + "' ");
        sql.append(" AND ");
        sql.append("  " + TBTHB2KMEI.URMEINO + " ");
        sql.append(" = '" + _vo.getUrMeiNo() + "' ");
        sql.append(" AND ");
        sql.append("  " + TBTHB2KMEI.RENBN + " ");
        sql.append(" = '" + _vo.getRenban() + "' ");
        sql.append(" AND ");
        sql.append("  " + TBTHB2KMEI.NAME6 + " ");
        sql.append(" = '" + _cond.getYm() + "' ");

        return sql.toString();
    }

    /**
     * condition�̃Z�b�g���s���܂��B
     *
     * @return
     * @throws
     */
    public void setConditionByCondition(UpdateSeqNoCondition cond) throws KKHException {
        _cond = cond;
    }

    /**
     * �V�[�N�G���XNo�̓o�^�E�X�V���s���܂��B
     *
     * @return
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    public void updateSeqNoByCondition(ReportKmnListVO vo) throws KKHException {
        try {
            _vo = vo;
            super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

}
