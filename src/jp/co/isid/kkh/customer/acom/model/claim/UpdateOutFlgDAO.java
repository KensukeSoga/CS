package jp.co.isid.kkh.customer.acom.model.claim;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * ���M�t���O�X�VDAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/20 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class UpdateOutFlgDAO extends AbstractSimpleRdbDao {

    private int _index;
    private UpdateOutFlgVO _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public UpdateOutFlgDAO() {
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
     * ���M�t���O�̍X�V���s���܂��B
     *
     * @param vo ���M�t���O�X�V���VO
     * @param index �C���f�b�N�X
     * @return int �X�V����
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public int updateThb2KmeiForOutFlg(UpdateOutFlgVO vo, int index)
            throws KKHException {
        // �p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�o�^�G���[", "BD-E0002");
        }
        super.setModel(vo);
        try {
            _cond = vo;
            _index = index;
            return super.exec();
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

        UpdateOutFlgVO vo = (UpdateOutFlgVO) getModel();

        sql.append(" UPDATE");
        sql.append(" " + TBTHB2KMEI.TBNAME);
        sql.append(" SET");
        sql.append(" " + TBTHB2KMEI.TIMSTMP + " = " + getDBModelInterface().getSystemDateString());    // �^�C���X�^���v
        sql.append("," + TBTHB2KMEI.KBN1 + "    = '" + vo.getOutFlg() + "'");                          // �敪1�i���M�t���O�j
        sql.append("," + TBTHB2KMEI.NAME7 + "   = '" + vo.getOutDate() + "'");                         // �o�͓���
        sql.append("," + TBTHB2KMEI.SONOTA1 + " = '" + vo.getSeiNo()[_index] + "'");                   // ������No
        sql.append("," + TBTHB2KMEI.SONOTA2 + " = '" + vo.getSeiGyoNo()[_index] + "'");                // �������sNo
        sql.append("," + TBTHB2KMEI.DATE1 + "   = '" + vo.getSeiYymm()[_index] + "'");                 // �����N����
        sql.append(" WHERE");
        sql.append("     " + TBTHB2KMEI.EGCD + "        = '" + _cond.getEgCd() + "'");                 // �c�Ə��i��j�R�[�h
        sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");             // ���Ӑ��ƃR�[�h
        sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");          // ���Ӑ敔��SEQNO
        sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");          // ���Ӑ�S��SEQNO
        sql.append(" AND " + TBTHB2KMEI.JYUTNO + "      = '" + _cond.getJyutNo()[_index] + "'");       // ��No
        sql.append(" AND " + TBTHB2KMEI.JYMEINO + "     = '" + _cond.getJyMeiNo()[_index] + "'");      // �󒍖���No
        sql.append(" AND " + TBTHB2KMEI.URMEINO + "     = '" + _cond.getUrMeiNo()[_index] + "'");      // ���㖾��No
        sql.append(" AND " + TBTHB2KMEI.RENBN + "       = '" + _cond.getRenban()[_index] + "'");       // �A��

        return sql.toString();
    }
}
