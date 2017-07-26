package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.kkh.integ.tbl.TBTHBBSYS;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * �����f�[�^�o�^DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/6 Fourm A.naito)<BR>
 * </P>
 * @author Fourm A.naito
 */
public class UpdateTimeStampDAO extends AbstractSimpleRdbDao  {

    public static final String C_WRFL_TVBMST = "TVBMST"; // TV�ԑg�}�X�^
    public static final String C_WRFL_RDBMST = "RDBMST"; // ���W�I�ԑg�}�X�^
    public static final String C_WRFL_TVKMST = "TVKMST"; // TV�ǃ}�X�^
    public static final String C_WRFL_RDKMST = "RDKMST"; // ���W�I�ǃ}�X�^
    public static final String C_WRFL_TVRMST = "TVRMST"; // TV�����}�X�^
    public static final String C_WRFL_RDRMST = "RDRMST"; // ���W�I�����}�X�^
    public static final String C_WRFL_TVCMST = "TVCMST"; // TVCM�b���}�X�^
    public static final String C_WRFL_RDCMST = "RDCMST"; // ���W�I�b���}�X�^

	private UpdateTimeStampVO _vo;


	/**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public UpdateTimeStampDAO() {
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
     * ���{NO����UP/DOWN�̓o�^���s���܂��B
     *
     * @param vo VO ���{NoVO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void jissiUp(UpdateTimeStampVO vo) throws KKHException {
    	//�p�����[�^�`�F�b�N
        if (vo == null) {
        	throw new KKHException("�o�^�G���[", "BD-E0002");
        }
        //super.setModel(vo);
        _vo = vo;

        try {
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
    	StringBuffer sql = new StringBuffer();
      	sql.append("UPDATE ");
    	sql.append(TBTHBBSYS.TBNAME);
    	sql.append(" SET ");
        if (_vo.get_mstkbn().equals(C_WRFL_TVBMST)) {
        	sql.append(TBTHBBSYS.FIELD2 + " = ");
        }
        else if (_vo.get_mstkbn().equals(C_WRFL_RDBMST)) {
        	sql.append(TBTHBBSYS.FIELD3 + " = ");
        }
        else if (_vo.get_mstkbn().equals(C_WRFL_TVKMST)) {
        	sql.append(TBTHBBSYS.FIELD4 + " = ");
        }
        else if (_vo.get_mstkbn().equals(C_WRFL_RDKMST)) {
        	sql.append(TBTHBBSYS.FIELD5 + " = ");
        }
        else if (_vo.get_mstkbn().equals(C_WRFL_TVRMST)) {
        	sql.append(TBTHBBSYS.FIELD6 + " = ");
        }
        else if (_vo.get_mstkbn().equals(C_WRFL_RDRMST)) {
        	sql.append(TBTHBBSYS.FIELD7 + " = ");
        }
        else if (_vo.get_mstkbn().equals(C_WRFL_TVCMST)) {
        	sql.append(TBTHBBSYS.FIELD8 + " = ");
        }
        else if (_vo.get_mstkbn().equals(C_WRFL_RDCMST)) {
        	sql.append(TBTHBBSYS.FIELD9 + " = ");
        }
    	sql.append("'" + _vo.gettimeStamp() + "'");
    	sql.append(" WHERE ");
    	sql.append(TBTHBBSYS.EGCD + " = ");
    	sql.append("'" + _vo.get_egCd() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHBBSYS.TKSKGYCD + " = ");
    	sql.append("'" + _vo.get_tksKgyCd() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHBBSYS.TKSBMNSEQNO + " = ");
    	sql.append("'" + _vo.get_tksBmnSeqNo() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHBBSYS.TKSTNTSEQNO + " = ");
    	sql.append("'" + _vo.get_TksTntSeqNo() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHBBSYS.SYBT + " = ");
    	sql.append("'" + _vo.get_syBt() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHBBSYS.FIELD1 + " = ");
    	sql.append("'" + _vo.get_field1() + "'");


    	return sql.toString();
    }
}
