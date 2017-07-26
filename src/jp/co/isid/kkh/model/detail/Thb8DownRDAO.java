package jp.co.isid.kkh.model.detail;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB8DOWNR;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

public class Thb8DownRDAO extends AbstractSimpleRdbDao {

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public Thb8DownRDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
        //super.setUseTimeStamp(true);
    }

    private Thb8DownRCondition _cond;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SelSqlMode{LOAD, LIST,};
    private SelSqlMode _selSqlMode = SelSqlMode.LOAD;

    /** getExecSQL�Ŕ��s����SQL�̃��[�h() */
    private enum ExecSqlMode{INS, UPD, DEL, UPD_DSP, UPD_CHD,};
    private ExecSqlMode _execSqlMode = ExecSqlMode.INS;

    /**
     * �v���C�}���L�[��Ԃ��܂��B
     *
     * @return String[] �v���C�}���L�[
     */
	@Override
	public String[] getPrimryKeyNames() {
		return new String[]{
				TBTHB8DOWNR.EGCD,
				TBTHB8DOWNR.TKSKGYCD,
				TBTHB8DOWNR.TKSBMNSEQNO,
				TBTHB8DOWNR.TKSTNTSEQNO,
				TBTHB8DOWNR.YYMM,
				TBTHB8DOWNR.JYUTNO,
				TBTHB8DOWNR.JYMEINO,
				TBTHB8DOWNR.URMEINO,
				TBTHB8DOWNR.TOUFLG,
				TBTHB8DOWNR.FILETIMSTMP
		};
	}

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
	@Override
	public String[] getTableColumnNames() {
		String[] retStrs = new String[]{};
		retStrs = new String[]{
				TBTHB8DOWNR.TIMSTMP,
				TBTHB8DOWNR.UPDAPL,
				TBTHB8DOWNR.UPDTNT,
				TBTHB8DOWNR.ATUEGCD,
				TBTHB8DOWNR.EGCD,
				TBTHB8DOWNR.TKSKGYCD,
				TBTHB8DOWNR.TKSBMNSEQNO,
				TBTHB8DOWNR.TKSTNTSEQNO,
				TBTHB8DOWNR.JYUTNO,
				TBTHB8DOWNR.JYMEINO,
				TBTHB8DOWNR.URMEINO,
				TBTHB8DOWNR.GPYNO,
				TBTHB8DOWNR.GPYOPAG,
				TBTHB8DOWNR.SEINO,
				TBTHB8DOWNR.HIMKCD,
				TBTHB8DOWNR.TOUFLG,
				TBTHB8DOWNR.YYMM,
				TBTHB8DOWNR.GYOMKBN,
				TBTHB8DOWNR.MSKBN,
				TBTHB8DOWNR.TMSPKBN,
				TBTHB8DOWNR.KOKKBN,
				TBTHB8DOWNR.SEIKBN,
				TBTHB8DOWNR.SYONO,
				TBTHB8DOWNR.KKNAMEKJ,
				TBTHB8DOWNR.EGGAMENTYPE,
				TBTHB8DOWNR.KKAKSHANKBN,
				TBTHB8DOWNR.TORIGAK,
				TBTHB8DOWNR.SEITNKA,
				TBTHB8DOWNR.SEIGAK,
				TBTHB8DOWNR.NEBIRITU,
				TBTHB8DOWNR.NEBIGAK,
				TBTHB8DOWNR.SZEIKBN,
				TBTHB8DOWNR.SZEIRITU,
				TBTHB8DOWNR.SZEIGAK,
				TBTHB8DOWNR.HIMKNMKJ,
				TBTHB8DOWNR.HIMKNMKN,
				TBTHB8DOWNR.TJYUTNO,
				TBTHB8DOWNR.TJYMEINO,
				TBTHB8DOWNR.TURMEINO,
				TBTHB8DOWNR.MSEIFLG,
				TBTHB8DOWNR.YYMMOLD,
				TBTHB8DOWNR.FIELD1,
				TBTHB8DOWNR.FIELD2,
				TBTHB8DOWNR.FIELD3,
				TBTHB8DOWNR.FIELD4,
				TBTHB8DOWNR.FIELD5,
				TBTHB8DOWNR.FIELD6,
				TBTHB8DOWNR.FIELD7,
				TBTHB8DOWNR.FIELD8,
				TBTHB8DOWNR.FIELD9,
				TBTHB8DOWNR.FIELD10,
				TBTHB8DOWNR.FIELD11,
				TBTHB8DOWNR.FIELD12,
				TBTHB8DOWNR.FILETIMSTMP,
				TBTHB8DOWNR.MEITIMSTMP
		};

		return retStrs;
	}


    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
	@Override
	public String getTableName() {
		return TBTHB8DOWNR.TBNAME;
	}

    /**
     * �X�V���t�t�B�[���h��Ԃ��܂��B
     *
     * @return String �X�V���t�t�B�[���h
     */
	@Override
	public String getTimeStampKeyName() {
		return TBTHB8DOWNR.TIMSTMP;
	}

    /**
     * �V�X�e�����t�ōX�V�����̒�`�ł�
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[] { TBTHB8DOWNR.TIMSTMP};
    }


    /**
     * �󒍃_�E�����[�h�f�[�^��PK�������s���܂��B
     * @param vo
     * @return
     * @throws KKHException
     */
    public Thb8DownRVO loadThb8DownR(Thb8DownRVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�����G���[", "BD-E0001");
        }
        super.setModel(vo);
        try {
        	_selSqlMode = SelSqlMode.LOAD;
            return (Thb8DownRVO)super.load();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * �󒍃_�E�����[�h�f�[�^�̓o�^
     *
     * @param vo �󒍃_�E�����[�h�f�[�^VO�iINSERT�p�j
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void insertThb8DownR(Thb8DownRVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�o�^�G���[", "BD-E0002");
        }
        super.setModel(vo);
        try {
        	_execSqlMode = ExecSqlMode.INS;
            if (!super.insert()) {
                throw new KKHException("�o�^�G���[", "BD-E0002");
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * �󒍃_�E�����[�h�f�[�^�̍X�V(�S���ڑΏ�)
     *
     * @param vo �󒍃_�E�����[�h�f�[�^VO�iINSERT�p�j
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void updateThb8DownR(Thb8DownRVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�X�V�G���[", "BD-E0003");
        }
        super.setModel(vo);
        try {
        	_execSqlMode = ExecSqlMode.UPD;
            if (!super.update()) {
                throw new KKHException("�X�V�G���[", "BD-E0003");
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

    /**
     * �󒍃_�E�����[�h�f�[�^�̍폜���s���܂��B
     *
     * @param vo �󒍃_�E�����[�h�f�[�^VO
     * @return boolean true�F�폜��������
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public boolean deleteThb8DownR(Thb8DownRVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�폜�G���[", "BD-E0004");
        }

        super.setModel(vo);

        try {
        	_execSqlMode = ExecSqlMode.DEL;
            if (!super.remove()) {
                throw new KKHException("�폜�G���[", "BD-E0004");
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0004");
        }

        return true;
    }


    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
    	String sql = "";

    	if (_selSqlMode == SelSqlMode.LIST){
    		sql = getSelectSQLForList();
    	} else {
    		sql = super.getSelectSQL();
    	}

        return sql;
    }

    private String getSelectSQLForList(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	//�S���ڂ��擾
    	for (int i = 0; i < getTableColumnNames().length; i++){
    		if (i == 0){
    			sql.append("  " + getTableColumnNames()[i] + " ");
    		}else{
    			sql.append(" ," + getTableColumnNames()[i] + " ");
    		}
    	}
    	sql.append(" FROM ");
    	sql.append("  " + getTableName() + " ");
    	sql.append(" WHERE ");
    	sql.append(" " + TBTHB8DOWNR.EGCD + " = '" + _cond.getEgCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB8DOWNR.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB8DOWNR.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB8DOWNR.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
//    	sql.append(" AND ");
//    	sql.append(" " + TBTHB8DOWNR.YYMM + " = '" + _cond.getYymm() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB8DOWNR.JYUTNO + " = '" + _cond.getJyutNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB8DOWNR.JYMEINO + " = '" + _cond.getJyMeiNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB8DOWNR.URMEINO + " = '" + _cond.getUrMeiNo() + "' ");
    	sql.append(" ORDER BY ");
    	sql.append("  " + TBTHB8DOWNR.FILETIMSTMP + " ");

    	return sql.toString();
    }

    /**
     * �󒍃_�E�����[�h�����e�[�u���̏����������s���܂��B
     *
     * @return �󒍃_�E�����[�h�����f�[�^VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<Thb8DownRVO> findJyutyuRirekiDataByCond(Thb8DownRCondition cond) throws KKHException{

    	super.setModel(new Thb8DownRVO());

        try {
        	_cond = cond;
        	_selSqlMode = SelSqlMode.LIST;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }


    /**
     * EXEC-SQL����
     */
	@Override
	public String getExecString() {
		StringBuffer sql = new StringBuffer();

		if (_execSqlMode.equals(ExecSqlMode.UPD_DSP)){
			//���דo�^--���דo�^�����X�V
			Thb8DownRVO vo = (Thb8DownRVO)getModel();
	    	sql.append(" UPDATE ");
	    	sql.append(" " + TBTHB8DOWNR.TBNAME + " ");
	    	sql.append(" SET ");
	    	sql.append(" " + TBTHB8DOWNR.MEITIMSTMP + " = '" + vo.getHb8MeiTimStmp() + "' ");
	    	sql.append("," + TBTHB8DOWNR.TIMSTMP + " = SYSDATE ");
	    	sql.append("," + TBTHB8DOWNR.UPDAPL + " ='" + vo.getHb8UpdApl() + "' ");
	    	sql.append("," + TBTHB8DOWNR.UPDTNT + " ='" + vo.getHb8UpdTnt() + "' ");
	    	sql.append(" WHERE ");
	    	sql.append(" " + TBTHB8DOWNR.EGCD + " = '" + _cond.getEgCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB8DOWNR.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB8DOWNR.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB8DOWNR.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
//	    	sql.append(" AND ");
//	    	sql.append(" " + TBTHB8DOWNR.YYMM + " = '" + _cond.getYymm() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB8DOWNR.JYUTNO + " = '" + _cond.getJyutNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB8DOWNR.JYMEINO + " = '" + _cond.getJyMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB8DOWNR.URMEINO + " = '" + _cond.getUrMeiNo() + "' ");
//	    	sql.append(" AND ");
//	    	sql.append(" " + TBTHB8DOWNR.TOUFLG + " = '" + _cond.getHb8TouFlg() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB8DOWNR.FILETIMSTMP + " = '" + _cond.getFileTimStmp() + "' ");
	 	} else {
	 		super.getExecString();
	 	}

	 	return sql.toString();
	}

    /**
     * �󒍃_�E�����[�h�f�[�^�̍X�V(�\���f�[�^�X�V�p)
     *
     * @param vo �󒍃_�E�����[�h�f�[�^VO�iINSERT�p�j
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void updateThb8DownRForDisplayData(Thb8DownRVO vo, Thb8DownRCondition cond) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�X�V�G���[", "BD-E0003");
        }
        super.setModel(vo);
        try {
        	_cond = cond;
        	_execSqlMode = ExecSqlMode.UPD_DSP;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

}
