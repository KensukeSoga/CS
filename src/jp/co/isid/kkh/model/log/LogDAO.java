package jp.co.isid.kkh.model.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB6LOG;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * �ėp���O����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/11 IP H.Shimizu)<BR>
 * </P>
 * @author
 */
public class LogDAO extends AbstractRdbDao {

    /**�ėp�}�X�^�������� */
    private LogCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public LogDAO() {
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
        return TBTHB6LOG.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB6LOG.TRKTIMSTMP
                ,TBTHB6LOG.TRKPL
                ,TBTHB6LOG.TRKTNT
                ,TBTHB6LOG.UPDTIMSTMP
                ,TBTHB6LOG.UPDAPL
                ,TBTHB6LOG.UPDTNT
                ,TBTHB6LOG.EGCD
                ,TBTHB6LOG.TKSKGYCD
                ,TBTHB6LOG.TKSBMNSEQNO
                ,TBTHB6LOG.TKSTNTSEQNO
                ,TBTHB6LOG.SYBT
                ,TBTHB6LOG.KINOID
                ,TBTHB6LOG.KBN
                ,TBTHB6LOG.DESC
                ,TBTHB6LOG.ERRDESC
                ,TBTHB6LOG.UPDDATE
                ,TBTHB6LOG.TANNAME
                ,TBTHB6LOG.RECEPTIONKIND
                ,TBTHB6LOG.STATUS
        };
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
            return getSelectSQLForLog();
    }


    private String getSelectSQLForLog(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHB6LOG.TRKTIMSTMP + " ");
        sql.append(" ," + TBTHB6LOG.TRKPL + " ");
        sql.append(" ," + TBTHB6LOG.TRKTNT + " ");
        sql.append(" ," + TBTHB6LOG.UPDTIMSTMP + " ");
        sql.append(" ," + TBTHB6LOG.UPDAPL + " ");
        sql.append(" ," + TBTHB6LOG.UPDTNT + " ");
        sql.append(" ," + TBTHB6LOG.EGCD + " ");
        sql.append(" ," + TBTHB6LOG.TKSKGYCD + " ");
        sql.append(" ," + TBTHB6LOG.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHB6LOG.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHB6LOG.SYBT + " ");
        sql.append(" ," + TBTHB6LOG.KBN + " ");
        sql.append(" ," + TBTHB6LOG.KINOID + " ");
        sql.append(" ," + TBTHB6LOG.DESC + " ");
        sql.append(" ," + TBTHB6LOG.ERRDESC + " ");
        sql.append(" ," + TBTHB6LOG.UPDDATE + " ");
        sql.append(" ," + TBTHB6LOG.TANNAME + " ");
        sql.append(" ," + TBTHB6LOG.RECEPTIONKIND + " ");
        sql.append(" ," + TBTHB6LOG.STATUS + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHB6LOG.TBNAME + " ");
        //Where��
        sql.append(" WHERE ");
        sql.append(" " + TBTHB6LOG.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB6LOG.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB6LOG.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB6LOG.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB6LOG.SYBT + " = '" + _cond.getSybt() + "' ");
        sql.append(" ORDER BY ");
        sql.append("  " + TBTHB6LOG.UPDDATE + " DESC");

        return sql.toString();
    }

    /**
     * �ėp�e�[�u���}�X�^�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<LogVO> findLogByCondition(LogCondition cond) throws KKHException {

        super.setModel(new LogVO());

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
     * @param hashList List ��������
     * @return List<CommonCodeMasterVO> �ϊ���̌�������
     */
    @Override
    protected List<LogVO> createFindedModelInstances(List hashList) {

        List<LogVO> list = new ArrayList<LogVO>();
        if (getModel() instanceof LogVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                LogVO vo = new LogVO();
                vo.setTrkTimStmp((Date)result.get(TBTHB6LOG.TRKTIMSTMP.toUpperCase()));
                vo.setTrkPl((String)result.get(TBTHB6LOG.TRKPL.toUpperCase()));
                vo.setTrkTnt((String)result.get(TBTHB6LOG.TRKTNT.toUpperCase()));
                vo.setUpdTimStmp((Date)result.get(TBTHB6LOG.UPDTIMSTMP.toUpperCase()));
                vo.setUpdPl((String)result.get(TBTHB6LOG.UPDAPL.toUpperCase()));
                vo.setUpdTnt((String)result.get(TBTHB6LOG.UPDTNT   .toUpperCase()));
                vo.setEgCd((String)result.get(TBTHB6LOG.EGCD.toUpperCase()));
                vo.setTksKgyCd((String)result.get(TBTHB6LOG.TKSKGYCD.toUpperCase()));
                vo.setTksBmnSeqNo((String)result.get(TBTHB6LOG.TKSBMNSEQNO.toUpperCase()));
                vo.setTksTntSeqNo((String)result.get(TBTHB6LOG.TKSTNTSEQNO.toUpperCase()));
                vo.setSybt((String)result.get(TBTHB6LOG.SYBT.toUpperCase()));
                vo.setKinoId((String)result.get(TBTHB6LOG.KINOID.toUpperCase()));
                vo.setKbn((String)result.get(TBTHB6LOG.KBN.toUpperCase()));
                vo.setDesc((String)result.get(TBTHB6LOG.DESC.toUpperCase()));
                vo.setErrDesc((String)result.get(TBTHB6LOG.ERRDESC.toUpperCase()));
                vo.setUpdDate((String)result.get(TBTHB6LOG.UPDDATE.toUpperCase()));
                vo.setTanName((String)result.get(TBTHB6LOG.TANNAME.toUpperCase()));
                vo.setReceptionKind((String)result.get(TBTHB6LOG.RECEPTIONKIND.toUpperCase()));
                vo.setStatus((String)result.get(TBTHB6LOG.STATUS.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
