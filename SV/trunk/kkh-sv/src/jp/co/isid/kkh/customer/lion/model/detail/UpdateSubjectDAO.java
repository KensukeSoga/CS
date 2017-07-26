package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * �����ύX�f�[�^�o�^DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/09 Fourm A.naito)<BR>
 * </P>
 * @author Fourm A.naito
 */
public class UpdateSubjectDAO extends AbstractSimpleRdbDao  {

	private UpdateSubjectVO _vo;


	/**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public UpdateSubjectDAO() {
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
     * �����ύX�f�[�^�̓o�^���s���܂��B
     *
     * @param vo VO �����ύXVO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void jissiUp(UpdateSubjectVO vo) throws KKHException {
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
    	sql.append(TBTHB1DOWN.TBNAME);
    	sql.append(" SET ");
    	sql.append(TBTHB1DOWN.KKNAMEKJ + " = ");
    	sql.append("'" + _vo.get_kkNameKJ() + "'");
    	sql.append(" WHERE ");
    	sql.append(TBTHB1DOWN.EGCD + " = ");
    	sql.append("'" + _vo.get_egCd() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHB1DOWN.TKSKGYCD + " = ");
    	sql.append("'" + _vo.get_tksKgyCd() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHB1DOWN.TKSBMNSEQNO + " = ");
    	sql.append("'" + _vo.get_tksBmnSeqNo() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHB1DOWN.TKSTNTSEQNO + " = ");
    	sql.append("'" + _vo.get_TksTntSeqNo() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHB1DOWN.YYMM + " = ");
    	sql.append("'" + _vo.get_YYMM() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHB1DOWN.JYUTNO + " = ");
    	sql.append("'" + _vo.get_jyutNo() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHB1DOWN.JYMEINO + " = ");
    	sql.append("'" + _vo.get_jyMeiNo() + "'");
    	sql.append(" AND ");
    	sql.append(TBTHB1DOWN.URMEINO + " = ");
    	sql.append("'" + _vo.get_lUrmeino() + "'");

    	return sql.toString();
    }
}
