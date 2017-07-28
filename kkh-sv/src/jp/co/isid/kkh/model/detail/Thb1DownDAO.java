package jp.co.isid.kkh.model.detail;

import java.util.List;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
//import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
//import jp.co.isid.kkh.model.detail.Thb2KmeiDAO.ExecSqlMode;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

public class Thb1DownDAO extends AbstractSimpleRdbDao {

    /** �󒍍폜�t���O�FON */
    private static final String JYUTDELFLG_ON = "1";

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public Thb1DownDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
        //super.setUseTimeStamp(true);
    }

    private Thb1DownVO _cond;
    private List<Thb2KmeiVO> _cond2;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SelSqlMode{LOAD, LOCK, LOCK_IKATSU, LOCK_CHD, LOCK_JDEL, MAX_JNO, JNO_UNQ};
    private SelSqlMode _selSqlMode = SelSqlMode.LOCK;

    /** getExecSQL�Ŕ��s����SQL�̃��[�h() */
    private enum ExecSqlMode{INS, UPD, DEL, UPD_DSP, DEL_JDEL, UPD_YYMM, UPD_MEG, UPD_MCN, UPD_CHD, UPD_CHK, UPD_TRK ,TOrkKoshin,UP1Down};
    private ExecSqlMode _execSqlMode = ExecSqlMode.UPD_DSP;


    /**
     * �v���C�}���L�[��Ԃ��܂��B
     *
     * @return String[] �v���C�}���L�[
     */
	@Override
	public String[] getPrimryKeyNames() {
		return new String[]{
				TBTHB1DOWN.EGCD,
				TBTHB1DOWN.TKSKGYCD,
				TBTHB1DOWN.TKSBMNSEQNO,
				TBTHB1DOWN.TKSTNTSEQNO,
				TBTHB1DOWN.YYMM,
				TBTHB1DOWN.JYUTNO,
				TBTHB1DOWN.JYMEINO,
				TBTHB1DOWN.URMEINO,
				TBTHB1DOWN.TOUFLG
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
				TBTHB1DOWN.TRKTIMSTMP,
				TBTHB1DOWN.TRKAPL,
				TBTHB1DOWN.TRKTNT,
				TBTHB1DOWN.TRKTNTNM,
				TBTHB1DOWN.KSNTIMSTMP,
				TBTHB1DOWN.KSNTNT,
				TBTHB1DOWN.KSNTNTNM,
				TBTHB1DOWN.TIMSTMP,
				TBTHB1DOWN.UPDAPL,
				TBTHB1DOWN.UPDTNT,
				TBTHB1DOWN.ATUEGCD,
				TBTHB1DOWN.EGCD,
				TBTHB1DOWN.TKSKGYCD,
				TBTHB1DOWN.TKSBMNSEQNO,
				TBTHB1DOWN.TKSTNTSEQNO,
				TBTHB1DOWN.JYUTNO,
				TBTHB1DOWN.JYMEINO,
				TBTHB1DOWN.URMEINO,
				TBTHB1DOWN.GPYNO,
				TBTHB1DOWN.GPYOPAG,
				TBTHB1DOWN.SEINO,
				TBTHB1DOWN.HIMKCD,
				TBTHB1DOWN.TOUFLG,
				TBTHB1DOWN.YYMM,
				TBTHB1DOWN.GYOMKBN,
				TBTHB1DOWN.MSKBN,
				TBTHB1DOWN.TMSPKBN,
				TBTHB1DOWN.KOKKBN,
				TBTHB1DOWN.SEIKBN,
				TBTHB1DOWN.SYONO,
				TBTHB1DOWN.KKNAMEKJ,
				TBTHB1DOWN.EGGAMENTYPE,
				TBTHB1DOWN.KKAKSHANKBN,
				TBTHB1DOWN.TORIGAK,
				TBTHB1DOWN.SEITNKA,
				TBTHB1DOWN.SEIGAK,
				TBTHB1DOWN.NEBIRITU,
				TBTHB1DOWN.NEBIGAK,
				TBTHB1DOWN.SZEIKBN,
				TBTHB1DOWN.SZEIRITU,
				TBTHB1DOWN.SZEIGAK,
				TBTHB1DOWN.HIMKNMKJ,
				TBTHB1DOWN.HIMKNMKN,
				TBTHB1DOWN.TJYUTNO,
				TBTHB1DOWN.TJYMEINO,
				TBTHB1DOWN.TURMEINO,
				TBTHB1DOWN.MSEIFLG,
				TBTHB1DOWN.YYMMOLD,
				TBTHB1DOWN.FIELD1,
				TBTHB1DOWN.FIELD2,
				TBTHB1DOWN.FIELD3,
				TBTHB1DOWN.FIELD4,
				TBTHB1DOWN.FIELD5,
				TBTHB1DOWN.FIELD6,
				TBTHB1DOWN.FIELD7,
				TBTHB1DOWN.FIELD8,
				TBTHB1DOWN.FIELD9,
				TBTHB1DOWN.FIELD10,
				TBTHB1DOWN.FIELD11,
				TBTHB1DOWN.FIELD12,
				TBTHB1DOWN.FILETIMSTMP,
				TBTHB1DOWN.MEITIMSTMP,
                TBTHB1DOWN.JYUTDELFLG
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
		return TBTHB1DOWN.TBNAME;
	}

    /**
     * �X�V���t�t�B�[���h��Ԃ��܂��B
     *
     * @return String �X�V���t�t�B�[���h
     */
	@Override
	public String getTimeStampKeyName() {
		return TBTHB1DOWN.TIMSTMP;
	}

    /**
     * �V�X�e�����t�ōX�V�����̒�`�ł�
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[] { TBTHB1DOWN.TIMSTMP};
    }


    /**
     * �󒍃_�E�����[�h�f�[�^��PK�������s���܂��B
     * @param vo
     * @return
     * @throws KKHException
     */
    public Thb1DownVO loadThb1Down(Thb1DownVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�����G���[", "BD-E0001");
        }
        super.setModel(vo);
        try {
        	_selSqlMode = SelSqlMode.LOAD;
            return (Thb1DownVO)super.load();
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
    public void insertThb1Down(Thb1DownVO vo) throws KKHException {
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
    public void updateThb1Down(Thb1DownVO vo) throws KKHException {
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
    public boolean deleteThb1Down(Thb1DownVO vo) throws KKHException {
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

        if (_selSqlMode.equals(SelSqlMode.LOCK)){
        	sql = getSelectSQLForLOCK();
        } else if (_selSqlMode.equals(SelSqlMode.LOCK_IKATSU)) {
        	sql = getSelectSQLForLOCK_IKATSU();
        } else if (_selSqlMode.equals(SelSqlMode.LOCK_CHD)) {
        	sql = getSelectSQLForLOCK_Child();
        } else if (_selSqlMode.equals(SelSqlMode.LOCK_JDEL)) {
        	sql = getSelectSQLForLOCK_JDEL();
        } else if (_selSqlMode.equals(SelSqlMode.MAX_JNO)){
        	sql = getSelectSQLForMaxJyutyuNo();
        } else if (_selSqlMode.equals(SelSqlMode.JNO_UNQ)){
        	sql = getSelectSQLForUniqueCheck();
        }else {
        	sql = getSelectSQLForALL();
        }

        return sql;
    }


    /**
     * �f�t�H���gSQL��Ԃ��܂��B
     * @return
     */
    private String getSelectSQLForALL(){

    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	//PK���ڂ��擾
    	for (int i = 0; i < getTableColumnNames().length; i++){
    		if (i == 0){
    			sql.append("  " + getTableColumnNames()[i] + " ");
    		}else{
    			sql.append(" ," + getTableColumnNames()[i] + " ");
    		}
    	}
    	sql.append(" FROM ");
    	sql.append(" " + getTableName() + " ");

    	return sql.toString();
    }

    /**
     * �r�����b�NSQL��Ԃ��܂��B
     * @return
     */
    public String getSelectSQLForLOCK(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " ");
    	//PK���ڂ��擾
    	for (int i = 0; i < getPrimryKeyNames().length; i++){
    		sql.append(" ," + getPrimryKeyNames()[i] + " ");
    	}
    	sql.append(" ," + TBTHB1DOWN.FILETIMSTMP + " ");
    	sql.append(" FROM ");
    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
    	sql.append(" WHERE ");
    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = ' ' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TURMEINO + " = ' ' ");
    	sql.append(" ORDER BY ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " DESC ");


    	return sql.toString();
    }

    /**
     * �r�����b�NSQL(�ꊇ)��Ԃ��܂��B
     * @return
     */
    public String getSelectSQLForLOCK_IKATSU(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " ");
    	//PK���ڂ��擾
    	for (int i = 0; i < getPrimryKeyNames().length; i++){
    		sql.append(" ," + getPrimryKeyNames()[i] + " ");
    	}
    	sql.append(" ," + TBTHB1DOWN.FILETIMSTMP + " ");
    	sql.append(" FROM ");
    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
    	sql.append(" WHERE ");
    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = ' ' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TURMEINO + " = ' ' ");
    	sql.append(" ORDER BY ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " DESC ");

    	return sql.toString();
    }

    /**
     * �r�����b�NSQL��Ԃ��܂��B(���דo�^�|�q����)
     * @return
     */
    public String getSelectSQLForLOCK_Child(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " ");
    	//PK���ڂ��擾
    	for (int i = 0; i < getPrimryKeyNames().length; i++){
    		sql.append(" ," + getPrimryKeyNames()[i] + " ");
    	}
    	sql.append(" ," + TBTHB1DOWN.FILETIMSTMP + " ");
    	sql.append(" FROM ");
    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
    	sql.append(" WHERE ");
    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TURMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
    	sql.append(" ORDER BY ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " ASC ");
    	//sql.append(" " + TBTHB1DOWN.TIMSTMP + " DESC ");


    	return sql.toString();
    }

    /**
     * �r�����b�NSQL��Ԃ��܂��B(�󒍍폜�p)
     * @return
     */
    public String getSelectSQLForLOCK_JDEL(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " ");
    	//PK���ڂ��擾
    	for (int i = 0; i < getPrimryKeyNames().length; i++){
    		sql.append(" ," + getPrimryKeyNames()[i] + " ");
    	}
    	sql.append(" FROM ");
    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
    	sql.append(" WHERE ");
    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
    	sql.append(" AND ( ");
    	sql.append("         ( ");
    	sql.append("             " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
    	sql.append("             AND ");
    	sql.append("             " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
    	sql.append("             AND ");
    	sql.append("             " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
    	sql.append("         ) ");
    	sql.append("         OR ");
    	sql.append("         ( ");
    	sql.append("             " + TBTHB1DOWN.TJYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
    	sql.append("             AND ");
    	sql.append("             " + TBTHB1DOWN.TJYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
    	sql.append("             AND ");
    	sql.append("             " + TBTHB1DOWN.TURMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
    	sql.append("         ) ");
    	sql.append("     ) ");
    	sql.append(" ORDER BY ");
    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " DESC ");


    	return sql.toString();
    }

    /**
     * ��No�̍ő�l���擾����SQL��Ԃ��܂��B
     * @return
     */
    public String getSelectSQLForMaxJyutyuNo(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	sql.append(" MAX(" + TBTHB1DOWN.JYUTNO + ") AS " + TBTHB1DOWN.JYUTNO + " ");
    	sql.append(" FROM ");
    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
    	sql.append(" WHERE ");
    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.JYUTNO + " LIKE '" + _cond.getHb1JyutNo().substring(0, 6) + "%' ");

    	return sql.toString();
    }

    /**
     * ��No�̏d���`�F�b�N���s���ׂ�SQL��Ԃ��܂��B
     * @return
     */
    public String getSelectSQLForUniqueCheck(){
    	StringBuffer sql = new StringBuffer();

    	sql.append(" SELECT ");
    	sql.append(" " + TBTHB1DOWN.JYUTNO + " ");
    	sql.append(" FROM ");
    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
    	sql.append(" WHERE ");
    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
    	sql.append(" AND ");
    	sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");

    	return sql.toString();
    }


    /**
     * �󒍃_�E�����[�h�f�[�^�̌������s���܂��B
     *
     * @return �󒍃_�E�����[�h�f�[�^VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<Thb1DownVO> lockThb1Down(Thb1DownVO cond) throws KKHException {

    	super.setModel(new Thb1DownVO());

        try {
        	_cond = cond;
        	_selSqlMode = SelSqlMode.LOCK;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * �󒍃_�E�����[�h�f�[�^�̌������s���܂��B
     *
     * @return �󒍃_�E�����[�h�f�[�^VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<Thb1DownVO> lockIkatsuThb1Down(Thb1DownVO cond) throws KKHException {

    	super.setModel(new Thb1DownVO());

        try {
        	_cond = cond;
        	_selSqlMode = SelSqlMode.LOCK_IKATSU;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * �󒍃_�E�����[�h�f�[�^�̌������s���܂��B
     *
     * @return �󒍃_�E�����[�h�f�[�^VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<Thb1DownVO> lockThb1DownForChild(Thb1DownVO cond) throws KKHException {

    	super.setModel(new Thb1DownVO());

        try {
        	_cond = cond;
        	_selSqlMode = SelSqlMode.LOCK_CHD;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }

    }

    /**
     * �󒍃_�E�����[�h�f�[�^�̔r���E�������s���܂��B(�󒍍폜�p)
     *
     * @return �󒍃_�E�����[�h�f�[�^VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<Thb1DownVO> lockThb1DownForJyutyuDataDel(Thb1DownVO cond) throws KKHException {

    	super.setModel(new Thb1DownVO());

        try {
        	_cond = cond;
        	_selSqlMode = SelSqlMode.LOCK_JDEL;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }

    }

    /**
     * ��No�̍ő�l���擾����B
     *
     * @return �󒍃_�E�����[�h�f�[�^VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<Thb1DownVO> getMaxJyutyuNo(Thb1DownVO cond) throws KKHException {

    	super.setModel(new Thb1DownVO());

        try {
        	_cond = cond;
        	_selSqlMode = SelSqlMode.MAX_JNO;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }

    }

    /**
     * ��No���擾����B(�d���`�F�b�N�p)
     *
     * @return �󒍃_�E�����[�h�f�[�^VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<Thb1DownVO> getJyutyuNoForUniqueCheck(Thb1DownVO cond) throws KKHException {

    	super.setModel(new Thb1DownVO());

        try {
        	_cond = cond;
        	_selSqlMode = SelSqlMode.JNO_UNQ;
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
			//���דo�^
			Thb1DownVO vo = (Thb1DownVO)getModel();
	    	sql.append(" UPDATE ");
	    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
	    	sql.append(" SET ");
	    	if (_cond2 != null && _cond2.size() > 0){
		    	sql.append(" " + TBTHB1DOWN.MSEIFLG + " = '" + vo.getHb1MSeiFlg() + "' ,");	//�������t���O
		    	sql.append(" " + TBTHB1DOWN.MEITIMSTMP + " = '" + vo.getHb1MeiTimStmp() + "' ,");	//���׍쐬�^�C���X�^���v
		    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " = SYSDATE ,");
		    	sql.append(" " + TBTHB1DOWN.UPDAPL + " ='" + vo.getHb1UpdApl() + "' ,");
		    	sql.append(" " + TBTHB1DOWN.UPDTNT + " ='" + vo.getHb1UpdTnt() + "' ,");
	    	}
	    	//���׃t���O��0(���ׂ�����)�̏ꍇ
	    	if(vo.getHb1MeisaiFlg().equals("0"))
	    	{
	    		if(vo.getHb1KsnTntNm() == null )
	    		{
	    			//�������܂���
	    		}else
	    		{
		    		//����������
			    	sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + "= '' ,");	//�o�^�^�C���X�^���v
			    	sql.append(" " + TBTHB1DOWN.TRKAPL + " = '' ,");		//�o�^�v���O����
			    	sql.append(" " + TBTHB1DOWN.TRKTNT + " = '' ,");		//�o�^�S����
			    	sql.append(" " + TBTHB1DOWN.TRKTNTNM + " = '' ,");	//�o�^�S����
	    	    	//�X�V�҂�o�^����
	    	    	sql.append(" " + TBTHB1DOWN.KSNTIMSTMP + " = SYSDATE  ,");						//���׍X�V��
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNT + " = '" + vo.getHb1KsnTnt() + "' ,");		//���׍X�V��
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNTNM + " = '" + vo.getHb1KsnTntNm() + "' ,");	//���׍X�V�Җ�
	    		}
	    	}
	    	else//���ׂ�����ꍇ
	    	{
	    		//�o�^�A�X�V�Ƃ��ɋ�ł͂Ȃ��ꍇ�����Ƃ��o�^
	    		if(!vo.getHb1TrkTntNm().equals("") && !vo.getHb1KsnTntNm().equals(""))
	    		{
	    			//�o�^�҂�o�^����
	    	    	sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + " = SYSDATE ,");
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNT + " = '" + vo.getHb1TrkTnt() + "' ,");	//�o�^�S����
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNTNM + " = '" + vo.getHb1TrkTntNm() + "' ,");	//�o�^�S���Җ�
	    	    	//�X�V�҂�o�^����
	    	    	sql.append(" " + TBTHB1DOWN.KSNTIMSTMP + " = SYSDATE  ,");						//���׍X�V��
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNT + " = '" + vo.getHb1KsnTnt() + "' ,");		//�X�V��
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNTNM + " = '" + vo.getHb1KsnTntNm() + "' ,");	//�X�V�Җ�

	    		}
	    		//�o�^�҂���̏ꍇ�X�V�҂�o�^
	    		if(vo.getHb1TrkTntNm().equals(""))
	    		{
	    	    	//�X�V�҂�o�^����
	    	    	sql.append(" " + TBTHB1DOWN.KSNTIMSTMP + " = SYSDATE  ,");						//���׍X�V��
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNT + " = '" + vo.getHb1KsnTnt() + "' ,");		//�X�V��
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNTNM + " = '" + vo.getHb1KsnTntNm() + "' ,");	//�X�V�Җ�
	    		}
	    		//�X�V�҂���̏ꍇ
	    		if(vo.getHb1KsnTntNm().equals(""))
	    		{
	    			//�o�^�҂�o�^����
	    	    	sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + " = SYSDATE ,");
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNT + " = '" + vo.getHb1TrkTnt() + "' ,");	//�o�^�S����
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNTNM + " = '" + vo.getHb1TrkTntNm() + "' ,");	//�o�^�S���Җ�
	    		}


//	    		//�X�V�҂���̏ꍇ
//	    	    if(vo.getHb1KsnTntNm() == null)
//	    	    {
//	    	    	//�o�^�҂�o�^����
//	    	    	sql.append("," + TBTHB1DOWN.TRKTIMSTMP + " = SYSDATE ");
//	    	    	sql.append("," + TBTHB1DOWN.TRKTNT + " = '" + vo.getHb1TrkTnt() + "' ");	//�o�^�S����
//	    	    	sql.append("," + TBTHB1DOWN.TRKTNTNM + " = '" + vo.getHb1TrkTntNm() + "' ");	//�o�^�S���Җ�
//
//	    	    }else
//	    	    {//�X�V�҂��󂶂�Ȃ��ꍇ
//
//	    	    	//�X�V�҂�o�^����
//	    	    	sql.append("," + TBTHB1DOWN.KSNTIMSTMP + " = SYSDATE  ");						//���׍X�V��
//	    	    	sql.append("," + TBTHB1DOWN.KSNTNT + " = '" + vo.getHb1KsnTnt() + "' ");		//�X�V��
//	    	    	sql.append("," + TBTHB1DOWN.KSNTNTNM + " = '" + vo.getHb1KsnTntNm() + "' ");	//�X�V�Җ�
//	    	    }
	    		//null�̏ꍇ�A�X�V����
//	    	    sql.append("," + TBTHB1DOWN.TRKTIMSTMP + "= NVL(" + TBTHB1DOWN.TRKTIMSTMP + ", SYSDATE)");	//�o�^�^�C���X�^���v
//	    	    sql.append("," + TBTHB1DOWN.TRKAPL + " = NVL(TRIM(" + TBTHB1DOWN.TRKAPL + ") , '" + vo.getHb1UpdApl() + "') ");	//�o�^�v���O����
//	    	    sql.append("," + TBTHB1DOWN.TRKTNT + " = NVL(TRIM(" + TBTHB1DOWN.TRKTNT + ") , '" +  vo.getHb1UpdTnt() + "') ");	//�o�^�S����
	    	}
	    	//�R���}�폜
	    	String ToStSQL = sql.toString();
	    	ToStSQL = ToStSQL.substring(0, ToStSQL.length()-1);
	    	sql = new StringBuffer();
	    	sql.append(ToStSQL);

	    	sql.append(" WHERE ");
	    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = ' ' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TURMEINO + " = ' ' ");
	 	} else if (_execSqlMode.equals(ExecSqlMode.DEL_JDEL)) {
	 		//�󒍍폜
			//Thb1DownVO vo = (Thb1DownVO)getModel();
	    	sql.append(" DELETE ");
	    	sql.append(" FROM ");
	    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
	    	sql.append(" WHERE ");
	    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
	    	sql.append(" AND ( ");
	    	sql.append("         ( ");
	    	sql.append("             " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
	    	sql.append("             AND ");
	    	sql.append("             " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
	    	sql.append("             AND ");
	    	sql.append("             " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
	    	sql.append("         ) ");
	    	sql.append("         OR ");
	    	sql.append("         ( ");
	    	sql.append("             " + TBTHB1DOWN.TJYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
	    	sql.append("             AND ");
	    	sql.append("             " + TBTHB1DOWN.TJYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
	    	sql.append("             AND ");
	    	sql.append("             " + TBTHB1DOWN.TURMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
	    	sql.append("         ) ");
	    	sql.append("     ) ");
	 	} else if (_execSqlMode.equals(ExecSqlMode.UPD_YYMM)){
	 		//�����N���X�V
			Thb1DownVO vo = (Thb1DownVO)getModel();
	    	sql.append(" UPDATE ");
	    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
	    	sql.append(" SET ");
	    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " = SYSDATE ");
	    	sql.append("," + TBTHB1DOWN.UPDAPL + " ='" + vo.getHb1UpdApl() + "' ");
	    	sql.append("," + TBTHB1DOWN.UPDTNT + " ='" + vo.getHb1UpdTnt() + "' ");
	    	sql.append("," + TBTHB1DOWN.YYMM + " = '" + vo.getHb1Yymm() + "' ");
	    	sql.append("," + TBTHB1DOWN.YYMMOLD + " = '" + vo.getHb1YymmOld() + "' ");
	    	sql.append(" WHERE ");
	    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TOUFLG + " = '" + _cond.getHb1TouFlg() + "' ");
	 	} else if (_execSqlMode.equals(ExecSqlMode.UPD_MEG)){
	 		//����
			Thb1DownVO vo = (Thb1DownVO)getModel();
	    	sql.append(" UPDATE ");
	    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
	    	sql.append(" SET ");
	    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " = SYSDATE ");
	    	sql.append("," + TBTHB1DOWN.UPDAPL + " ='" + vo.getHb1UpdApl() + "' ");
	    	sql.append("," + TBTHB1DOWN.UPDTNT + " ='" + vo.getHb1UpdTnt() + "' ");
	    	sql.append("," + TBTHB1DOWN.TJYUTNO + " ='" + vo.getHb1TJyutNo() + "' ");
	    	sql.append("," + TBTHB1DOWN.TJYMEINO + " ='" + vo.getHb1TJyMeiNo() + "' ");
	    	sql.append("," + TBTHB1DOWN.TURMEINO + " ='" + vo.getHb1TUrMeiNo() + "' ");
	    	sql.append(" WHERE ");
	    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TOUFLG + " = '" + _cond.getHb1TouFlg() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = ' ' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TURMEINO + " = ' ' ");
	 	} else if (_execSqlMode.equals(ExecSqlMode.UPD_MCN)){
	 		//��������
			Thb1DownVO vo = (Thb1DownVO)getModel();
	    	sql.append(" UPDATE ");
	    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
	    	sql.append(" SET ");
	    	sql.append(" " + TBTHB1DOWN.TIMSTMP + " = SYSDATE ");
	    	sql.append("," + TBTHB1DOWN.UPDAPL + " ='" + vo.getHb1UpdApl() + "' ");
	    	sql.append("," + TBTHB1DOWN.UPDTNT + " ='" + vo.getHb1UpdTnt() + "' ");
	    	sql.append("," + TBTHB1DOWN.TJYUTNO + " =' ' ");
	    	sql.append("," + TBTHB1DOWN.TJYMEINO + " =' ' ");
	    	sql.append("," + TBTHB1DOWN.TURMEINO + " =' ' ");
	    	sql.append(" WHERE ");
	    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = '" + _cond.getHb1TJyutNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = '" + _cond.getHb1TJyMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TURMEINO + " = '" + _cond.getHb1TUrMeiNo() + "' ");
//	    	sql.append(" AND ");
//	    	sql.append(" " + TBTHB1DOWN.TOUFLG + " = ' ' ");
	 	} else if (_execSqlMode.equals(ExecSqlMode.UPD_CHD)){
			//���דo�^�|���דo�^�����X�V(������)
			Thb1DownVO vo = (Thb1DownVO)getModel();
	    	sql.append(" UPDATE ");
	    	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
	    	sql.append(" SET ");
	    	sql.append(" " + TBTHB1DOWN.MEITIMSTMP + " = '" + vo.getHb1MeiTimStmp() + "' ");
	    	sql.append("," + TBTHB1DOWN.TIMSTMP + " = SYSDATE ");
	    	sql.append("," + TBTHB1DOWN.UPDAPL + " ='" + vo.getHb1UpdApl() + "' ");
	    	sql.append("," + TBTHB1DOWN.UPDTNT + " ='" + vo.getHb1UpdTnt() + "' ");
	    	sql.append(" WHERE ");
	    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
	    	sql.append(" AND ");
	    	sql.append(" " + TBTHB1DOWN.TURMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
        } else if (_execSqlMode.equals(ExecSqlMode.UPD_CHK)){
            //�X�V�E�폜�`�F�b�N
            Thb1DownVO vo = (Thb1DownVO)getModel();
            sql.append(" UPDATE ");
            sql.append(" " + TBTHB1DOWN.TBNAME + " ");
            sql.append(" SET ");
            sql.append(" " + TBTHB1DOWN.JYUTDELFLG + " = '" + JYUTDELFLG_ON + "' ");
            sql.append("," + TBTHB1DOWN.TIMSTMP + " = SYSDATE ");
            sql.append("," + TBTHB1DOWN.UPDAPL + " ='" + vo.getHb1UpdApl() + "' ");
            sql.append("," + TBTHB1DOWN.UPDTNT + " ='" + vo.getHb1UpdTnt() + "' ");
            sql.append(" WHERE ");
            sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TOUFLG + " = '" + String.format("%-1s", _cond.getHb1TouFlg()) + "' ");
        }else if(_execSqlMode.equals(ExecSqlMode.TOrkKoshin)){
        	//��������Ă���z�̓o�^�ҍX�V�ґΉ�
        	Thb1DownVO vo = (Thb1DownVO)getModel();
        	sql.append(" UPDATE ");
            sql.append(" " + TBTHB1DOWN.TBNAME + " ");
            sql.append(" SET ");
	    	if(vo.getHb1MeisaiFlg().equals("0"))
	    	{
	    		if(vo.getHb1KsnTntNm() == null )
	    		{
	    			//�������܂���
	    		}else
	    		{
		    		//����������
			    	sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + "= '' ,");	//�o�^�^�C���X�^���v
			    	sql.append(" " + TBTHB1DOWN.TRKAPL + " = '' ,");		//�o�^�v���O����
			    	sql.append(" " + TBTHB1DOWN.TRKTNT + " = '' ,");		//�o�^�S����
			    	sql.append(" " + TBTHB1DOWN.TRKTNTNM + " = '' ,");	//�o�^�S����
	    	    	//�X�V�҂�o�^����
	    	    	sql.append(" " + TBTHB1DOWN.KSNTIMSTMP + " = SYSDATE  ,");						//���׍X�V��
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNT + " = '" + vo.getHb1KsnTnt() + "' ,");		//���׍X�V��
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNTNM + " = '" + vo.getHb1KsnTntNm() + "' ,");	//���׍X�V�Җ�
	    		}
	    	}
	    	else//���ׂ�����ꍇ
	    	{
	    		//�o�^�A�X�V�Ƃ��ɋ�ł͂Ȃ��ꍇ�����Ƃ��o�^
	    		if(vo.getHb1TrkTntNm() != null && vo.getHb1KsnTntNm() != null)
	    		{
	    			//�o�^�҂�o�^����
	    	    	sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + " = SYSDATE ,");
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNT + " = '" + vo.getHb1TrkTnt() + "' ,");	//�o�^�S����
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNTNM + " = '" + vo.getHb1TrkTntNm() + "' ,");	//�o�^�S���Җ�
	    	    	//�X�V�҂�o�^����
	    	    	sql.append(" " + TBTHB1DOWN.KSNTIMSTMP + " = SYSDATE  ,");						//���׍X�V��
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNT + " = '" + vo.getHb1KsnTnt() + "' ,");		//�X�V��
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNTNM + " = '" + vo.getHb1KsnTntNm() + "' ,");	//�X�V�Җ�

	    		}
	    		//�o�^�҂���̏ꍇ�X�V�҂�o�^
	    		if(vo.getHb1TrkTntNm() == null)
	    		{
	    	    	//�X�V�҂�o�^����
	    	    	sql.append(" " + TBTHB1DOWN.KSNTIMSTMP + " = SYSDATE  ,");						//���׍X�V��
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNT + " = '" + vo.getHb1KsnTnt() + "' ,");		//�X�V��
	    	    	sql.append(" " + TBTHB1DOWN.KSNTNTNM + " = '" + vo.getHb1KsnTntNm() + "' ,");	//�X�V�Җ�
	    		}
	    		//�X�V�҂���̏ꍇ
	    		if(vo.getHb1KsnTntNm() == null)
	    		{
	    			//�o�^�҂�o�^����
	    	    	sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + " = SYSDATE ,");
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNT + " = '" + vo.getHb1TrkTnt() + "' ,");	//�o�^�S����
	    	    	sql.append(" " + TBTHB1DOWN.TRKTNTNM + " = '" + vo.getHb1TrkTntNm() + "' ,");	//�o�^�S���Җ�
	    		}

	    	}
            //�J���}���Ƃ鏈����
            String tost = sql.toString();
            tost = tost.substring(0,tost.length()-1);
            sql = new StringBuffer();
            sql.append(tost);

            sql.append(" WHERE ");
            sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TOUFLG + " = ' '");
        }
//        else if (_execSqlMode.equals(ExecSqlMode.UPD_TRK)){
//        	//�o�^�ҍ폜
//            sql.append(" UPDATE ");
//            sql.append(" " + TBTHB1DOWN.TBNAME + " ");
//            sql.append(" SET ");
//            //sql.append(" " + TBTHB1DOWN.TRKTIMSTMP + " = SYSDATE ");
//            sql.append(" " + TBTHB1DOWN.TRKTNT + " = ' ' ");
//            //sql.append("," + TBTHB1DOWN.TRKAPL + " = ' ' ");
//            // Where��
//            sql.append(" WHERE ");
//            sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
//            sql.append(" AND ");
//            sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
//            sql.append(" AND ");
//            sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
//            sql.append(" AND ");
//            sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
//            if (_cond.getHb1Yymm() != null && !_cond.getHb1Yymm().equals("")){
//	            sql.append(" AND ");
//	            sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
//            }
//            if (_cond.getHb1JyutNo() != null && !_cond.getHb1JyutNo().equals("")){
//	            sql.append(" AND ");
//	            sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
//            }
//            if (_cond.getHb1JyMeiNo() != null && !_cond.getHb1JyMeiNo().equals("")){
//	            sql.append(" AND ");
//	            sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
//            }
//            if (_cond.getHb1UrMeiNo() != null && !_cond.getHb1UrMeiNo().equals("")){
//	            sql.append(" AND ");
//	            sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
//            }
//	 	}
        else if(_execSqlMode.equals(ExecSqlMode.UP1Down)){
        	sql.append(" UPDATE ");
        	sql.append(" " + TBTHB1DOWN.TBNAME + " ");
        	sql.append(" SET ");
        	sql.append(" " + TBTHB1DOWN.TIMSTMP + " = SYSDATE ");
        	sql.append(" WHERE ");
        	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _cond.getHb1EgCd() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _cond.getHb1TksKgyCd() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getHb1TksBmnSeqNo() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getHb1TksTntSeqNo() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _cond.getHb1Yymm() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _cond.getHb1JyutNo() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _cond.getHb1JyMeiNo() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _cond.getHb1UrMeiNo() + "' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.TJYMEINO + " = ' ' ");
        	sql.append(" AND ");
        	sql.append(" " + TBTHB1DOWN.TURMEINO + " = ' ' ");
        }
        else {
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
    public void updateThb1DownForDisplayData(Thb1DownVO vo , List<Thb2KmeiVO> vo2) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�X�V�G���[", "BD-E0003");
        }
        super.setModel(vo);
        try {
        	_cond = vo;
        	_cond2 = vo2;
        	_execSqlMode = ExecSqlMode.UPD_DSP;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }
    /**
     * �󒍃_�E�����[�h�f�[�^�̃^�C���X�^���v���X�V
     *
     * @param vo Condition�p
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void updateSysdateTo1down(Thb1DownVO vo) throws KKHException{
    	if(vo == null){
    		throw new KKHException("�X�V�G���[", "BD-E0003");
    	}
    	super.setModel(vo);
    	try
    	{
    		_cond = vo;
    		_execSqlMode = ExecSqlMode.UP1Down;
    		super.exec();
    	}catch(UserException e){
    		throw new KKHException(e.getMessage(),"BD-E0003");
    	}
    }


    /**
     * �󒍃_�E�����[�h�f�[�^�̍X�V(�\���f�[�^�X�V�p)
     *
     * @param vo �󒍃_�E�����[�h�f�[�^VO�iINSERT�p�j
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void updateTourokuKousinTaiou(Thb1DownVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�X�V�G���[", "BD-E0003");
        }
        super.setModel(vo);
        try {
        	_cond = vo;
        	_execSqlMode = ExecSqlMode.TOrkKoshin;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }


    /**
     * �󒍃_�E�����[�h�f�[�^�̍X�V(�\���f�[�^�X�V�p)
     *
     * @param vo �󒍃_�E�����[�h�f�[�^VO�iINSERT�p�j
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void updateThb1DownForDisplayDataChild(Thb1DownVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�X�V�G���[", "BD-E0003");
        }
        super.setModel(vo);
        try {
        	_cond = vo;
        	_execSqlMode = ExecSqlMode.UPD_CHD;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

    /**
     * �󒍃_�E�����[�h�f�[�^�̍폜(�󒍍폜�p)
     * @param vo �󒍃_�E�����[�h�f�[�^VO�iDELETE�p�j
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void deleteThb1DownByCondition(Thb1DownVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�폜�G���[", "BD-E0004");
        }
        super.setModel(vo);
        try {
        	_cond = vo;
        	_execSqlMode = ExecSqlMode.DEL_JDEL;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0004");
        }
    }

    /**
     * �󒍃_�E�����[�h�f�[�^�̍X�V(�����N���ύX�p)
     *
     * @param vo �󒍃_�E�����[�h�f�[�^VO(�X�V����)
     * @param updVo �󒍃_�E�����[�h�f�[�^VO(�X�V�f�[�^)
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void updateThb1DownForCngSeikyuYymm(Thb1DownVO vo, Thb1DownVO updVo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null || updVo == null) {
            throw new KKHException("�X�V�G���[", "BD-E0003");
        }
        super.setModel(updVo);
        try {
        	_cond = vo;
        	_execSqlMode = ExecSqlMode.UPD_YYMM;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }


    /**
     * �󒍃_�E�����[�h�f�[�^�̍X�V(�󒍓����p)
     *
     * @param vo �󒍃_�E�����[�h�f�[�^VO
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void updateThb1DownForJyutyuMerge(Thb1DownVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�X�V�G���[", "BD-E0003");
        }
        super.setModel(vo);
        try {
        	_cond = vo;
        	_execSqlMode = ExecSqlMode.UPD_MEG;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

    /**
     * �󒍃_�E�����[�h�f�[�^�̍X�V(�󒍉����p)
     *
     * @param vo �󒍃_�E�����[�h�f�[�^VO
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void updateThb1DownForJyutyuMergeCancel(Thb1DownVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�X�V�G���[", "BD-E0003");
        }
        super.setModel(vo);
        try {
        	_cond = vo;
        	_execSqlMode = ExecSqlMode.UPD_MCN;
        	super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

    /**
     * �󒍃_�E�����[�h�f�[�^�̍X�V(�ύX�E�폜�`�F�b�N�p)
     *
     * @param vo �󒍃_�E�����[�h�f�[�^VO
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void updateThb1DownForUpdateCheck(Thb1DownVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�X�V�G���[", "BD-E0003");
        }
        super.setModel(vo);
        try {
            _cond = vo;
            _execSqlMode = ExecSqlMode.UPD_CHK;
            super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }

    /**
     * �L����׃e�[�u���̏����w��X�V
     *
     * @param cond �X�V����
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
        //�p�����[�^�`�F�b�N
//    public boolean updateThb1DownTrkByCondition(Thb1DownVO vo) throws KKHException {
//        if (vo == null) {
//            throw new KKHException("�X�V�G���[", "BD-E0003");
//        }
//
//        try {
//            _cond = vo;
//            _execSqlMode = ExecSqlMode.UPD_TRK;
//            super.exec();
//        } catch (UserException e) {
//            throw new KKHException(e.getMessage(), "BD-E0003");
//        }
//
//        return true;
//    }

}
