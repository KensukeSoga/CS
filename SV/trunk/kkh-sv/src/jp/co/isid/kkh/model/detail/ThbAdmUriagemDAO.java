package jp.co.isid.kkh.model.detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.VWTHB_ADMURIAGEM;
import jp.co.isid.kkh.integ.util.ECPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class ThbAdmUriagemDAO extends AbstractRdbDao {

    /** �L����חp���㖾��VIEW�������� */
    private ThbAdmUriagemCondition _cond;

//    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ThbAdmUriagemDAO() {
        super.setPoolConnectClass(ECPoolConnect.class);
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
        return "";
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[] {};
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append(" " + VWTHB_ADMURIAGEM.ATEGSYOCD + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.TKSKGYCD + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.TKSBMNSEQNO + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.TKSTNTSEQNO + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.JYUTNO + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.JYMEISEQ + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.URMEISEQ + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.SEIKJTAI + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.SEISAGSTS + ", ");
        sql.append(" " + VWTHB_ADMURIAGEM.STPKBN + " ");
        sql.append(" FROM ");
        sql.append(" " + VWTHB_ADMURIAGEM.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + VWTHB_ADMURIAGEM.ATEGSYOCD + " = '" + _cond.getAtEgsyoCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTHB_ADMURIAGEM.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTHB_ADMURIAGEM.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTHB_ADMURIAGEM.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTHB_ADMURIAGEM.JYUTNO + " = '" + _cond.getJyutNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTHB_ADMURIAGEM.JYMEISEQ + " = '" + _cond.getJyMeiSeq() + "' ");
        sql.append(" AND ");
        sql.append(" " + VWTHB_ADMURIAGEM.URMEISEQ + " = '" + _cond.getUrMeiSeq() + "' ");

        return sql.toString();
    }

    /**
     * �L����חp���㖾��VIEW�̌������s���܂��B
     *
     * @return �L����חp���㖾��VIEWVO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ThbAdmUriagemVO> getAdmUriagemViewData(ThbAdmUriagemCondition cond) throws KKHException {

        super.setModel(new ThbAdmUriagemVO());

        try {
            _cond = cond;
//            _sqlMode = SqlMode.COND;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "HB-E0001");
        }
    }

    /**
     * Model�̐������s��<br>
     * �������ʂ�VO��KEY���啶���̂��ߕϊ��������s��<br>
     * AbstractRdbDao��createFindedModelInstances���I�[�o�[���C�h<br>
     *
     * @param hashList List ��������
     * @return List<ThbAdmUriagemVO> �ϊ���̌�������
     */
    @Override
    protected List<ThbAdmUriagemVO> createFindedModelInstances(List hashList) {

        List<ThbAdmUriagemVO> list = new ArrayList<ThbAdmUriagemVO>();
        if (getModel() instanceof ThbAdmUriagemVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ThbAdmUriagemVO vo = new ThbAdmUriagemVO();
                vo.setResultKey(StringUtil.trim((String) result.get("RESULTKEY")));
                vo.setSeikJtai(StringUtil.trim((String) result.get(VWTHB_ADMURIAGEM.SEIKJTAI.toUpperCase())));
                vo.setSeiSagSts(StringUtil.trim((String) result.get(VWTHB_ADMURIAGEM.SEISAGSTS.toUpperCase())));
                vo.setStpKbn(StringUtil.trim((String) result.get(VWTHB_ADMURIAGEM.STPKBN.toUpperCase())));
                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
