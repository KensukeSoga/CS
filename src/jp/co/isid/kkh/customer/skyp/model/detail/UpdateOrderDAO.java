package jp.co.isid.kkh.customer.skyp.model.detail;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * ���я��X�VDAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/22 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class UpdateOrderDAO extends AbstractSimpleRdbDao {

    private int _index;
    private UpdateOrderVO _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public UpdateOrderDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /** getExecSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SqlMode{KMEI, DOWN};
    private SqlMode _sqlMode = SqlMode.KMEI;


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
     * ���я��̍X�V���s���܂�(����)�B
     *
     * @param vo
     *            vo ���я��X�V���VO
     * @param index
     *            index �C���f�b�N�X
     *
     * @return int �X�V����
     *
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public int updateThb2KmeiForOrder(UpdateOrderVO vo, int index)
            throws KKHException {
        // �p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�o�^�G���[", "BD-E0002");
        }
        super.setModel(vo);
        try {
            _cond = vo;
            _index = index;
            _sqlMode = SqlMode.KMEI;
            return super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * �󒍃e�[�u���̃^�C���X�^���v���X�V����B
     *
     * @param vo
     *            vo ���я��X�V���VO
     *
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void updateThb1DownForOrder(UpdateOrderVO vo)
            throws KKHException {
        // �p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�o�^�G���[", "BD-E0002");
        }
        super.setModel(vo);
        try {
            _cond = vo;
            _sqlMode = SqlMode.DOWN;
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
    	if(_sqlMode.equals(SqlMode.KMEI)){
    		return getExecStringKMEI();
        }else{
            return getExecStringDOWN();
        }
    }

    /**
     * ���׍X�VSQL
     */
    public String getExecStringKMEI() {
        StringBuffer sql = new StringBuffer();

        UpdateOrderVO vo = (UpdateOrderVO) getModel();

        sql.append(" UPDATE");
        sql.append(" " + TBTHB2KMEI.TBNAME);
        sql.append(" SET");
        sql.append(" " + TBTHB2KMEI.TIMSTMP + " = " + getDBModelInterface().getSystemDateString());
        sql.append("," + TBTHB2KMEI.SONOTA1 + " = '" + vo.getOrder()[_index] + "'");
        sql.append(" WHERE");
        sql.append("     " + TBTHB2KMEI.EGCD + "        = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHB2KMEI.YYMM + "        = '" + _cond.getYymm() + "'");

        // �󕶎��̏ꍇ�ANULL�������Ɋ܂߂�
        if (_cond.getBaitaiNm()[_index].equals("") ) {
            sql.append(" AND (TRIM(" + TBTHB2KMEI.NAME7 + ") = '' OR TRIM(" + TBTHB2KMEI.NAME7  + ") IS NULL)");
        }
        else {
            sql.append(" AND TRIM(" + TBTHB2KMEI.NAME7 + ") = '" + _cond.getBaitaiNm()[_index] + "'");
        }

        if (_cond.getBaitaiKbn()[_index].equals(""))
        {
            sql.append(" AND (TRIM(" + TBTHB2KMEI.NAME13 + ") = '' OR TRIM(" + TBTHB2KMEI.NAME13  + ") IS NULL)");
        }
        else
        {
            sql.append(" AND TRIM(" + TBTHB2KMEI.NAME13 + ") = '" + _cond.getBaitaiKbn()[_index] + "'");
        }

        return sql.toString();
    }

    /**
     * �󒍍X�VSQL
     */
    public String getExecStringDOWN() {
        StringBuffer sql = new StringBuffer();

        sql.append(" UPDATE");
        sql.append(" " + TBTHB1DOWN.TBNAME);
        sql.append(" SET");
        sql.append(" " + TBTHB1DOWN.TIMSTMP + " = " + getDBModelInterface().getSystemDateString());
        sql.append(" WHERE");
        sql.append("     " + TBTHB1DOWN.EGCD + " = '" + _cond.getEgCd() + "'");
        sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'");
        sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
        sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
        sql.append(" AND " + TBTHB1DOWN.YYMM + " = '" + _cond.getYymm() + "'");

        return sql.toString();
    }
}
