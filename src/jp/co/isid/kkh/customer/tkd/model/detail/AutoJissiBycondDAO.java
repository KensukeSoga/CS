package jp.co.isid.kkh.customer.tkd.model.detail;


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
 * ���{NO����UP/DOWN�i���{No�����t�^�j�pDAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/6 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
public class AutoJissiBycondDAO extends AbstractSimpleRdbDao  {

    private AutoJissiBycondVO _vo;


    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public AutoJissiBycondDAO() {
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
        return TBTHB2KMEI.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[]{};
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
     * ���{NO����UP/DOWN�̓o�^���s���܂�(����)�B
     *
     * @param vo VO ���{NoVO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void AutojissiUp(AutoJissiBycondVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�o�^�G���[", "BD-E0002");
        }
        _vo = vo;

        try {
            if(!_vo.getFuyoOrUpdown().equals("0"))
            {
            	//�󒍂��X�V
                _sqlMode = SqlMode.DOWN;
                super.exec();
                //���ׂ��X�V
                _sqlMode = SqlMode.KMEI;
                super.exec();
            }else if(_vo.getFuyoOrUpdown().equals("0"))
            {

                for(int i = 0; i< _vo.get_jyutNo().length; i++)
                {
                	//�v�f�����擾
                    _vo.setNum2(i);
                	//�󒍂��X�V
                    _sqlMode = SqlMode.DOWN;
                    super.exec();
                    //���ׂ��X�V
                    _sqlMode = SqlMode.KMEI;
                    super.exec();
                }
            }

        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * ���{NO����UP/DOWN�̓o�^���s���܂�(��)�B
     *
     * @param vo VO ���{NoVO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void AutojissiUpDOWN(AutoJissiBycondVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�o�^�G���[", "BD-E0002");
        }
        _vo = vo;

        try {
            if(!_vo.getFuyoOrUpdown().equals("0"))
            {
                _sqlMode = SqlMode.DOWN;
                super.exec();
            }else if(_vo.getFuyoOrUpdown().equals("0"))
            {

                for(int i = 0; i< _vo.get_jyutNo().length; i++)
                {
                    _vo.setNum2(i);
                    _sqlMode = SqlMode.DOWN;
                    super.exec();
                }
            }

        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * ���׍X�VSQL
     */
    public String getExecStringKMEI() {
        StringBuffer sql = new StringBuffer();

        if(_vo.getFuyoOrUpdown().equals("0"))
        {
            sql.append("UPDATE ");
            sql.append(TBTHB2KMEI.TBNAME);
            sql.append(" SET ");
            sql.append(" " + TBTHB2KMEI.TIMSTMP + " = " + getDBModelInterface().getSystemDateString());
            sql.append("," + TBTHB2KMEI.KNGK1 + " = " + _vo.get_JissiNo()[_vo.getNum2()] + " ");
            sql.append(" WHERE");
            sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _vo.get_egCd() + "' " );
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _vo.get_tksKgyCd() + "' " );
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '"+ _vo.get_tksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '"+ _vo.get_tksTntSeqNo() + "' " );
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _vo.get_YYMM() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.JYUTNO + " = '" + _vo.get_jyutNo()[_vo.getNum2()] + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.JYMEINO + " = '" + _vo.get_jyMeiNo()[_vo.getNum2()] + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.URMEINO + " = '" + _vo.get_urMeiNo()[_vo.getNum2()] + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.RENBN + " = '" + _vo.get_Renban()[_vo.getNum2()] + "' ");

        }else if(!_vo.getFuyoOrUpdown().equals("0"))
        {
            String[] fuyo = _vo.getFuyoOrUpdown().split(",");
            sql.append("UPDATE ");
            sql.append(TBTHB2KMEI.TBNAME);
            sql.append(" SET ");
            sql.append(" " + TBTHB2KMEI.TIMSTMP + " = " + getDBModelInterface().getSystemDateString());
            sql.append("," + TBTHB2KMEI.KNGK1 + " = " + TBTHB2KMEI.KNGK1 + " " + fuyo[0] + " 1 ");
            sql.append(" WHERE ");
            sql.append(" " + TBTHB2KMEI.EGCD + " = '" + _vo.get_egCd() + "' " );
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.TKSKGYCD + " = '" + _vo.get_tksKgyCd() + "' " );
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.TKSBMNSEQNO + " = '"+ _vo.get_tksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.TKSTNTSEQNO + " = '"+ _vo.get_tksTntSeqNo() + "' " );
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.YYMM + " = '" + _vo.get_YYMM() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB2KMEI.KNGK1 + " >= " + fuyo[1]+ " ");
            sql.append(" AND ");
            sql.append(" NOT "+ TBTHB2KMEI.KBN2 + " = '2'");

        }

        return sql.toString();
    }

    /**
     * �󒍍X�VSQL
     */
    public String getExecStringDOWN() {
        StringBuffer sql = new StringBuffer();

        if(_vo.getFuyoOrUpdown().equals("0"))
        {
            sql.append("UPDATE ");
            sql.append(TBTHB1DOWN.TBNAME);
            sql.append(" SET ");
            sql.append(" " + TBTHB1DOWN.TIMSTMP + " = " + getDBModelInterface().getSystemDateString());
            sql.append(" WHERE");
            sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _vo.get_egCd() + "' " );
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _vo.get_tksKgyCd() + "' " );
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '"+ _vo.get_tksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '"+ _vo.get_tksTntSeqNo() + "' " );
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _vo.get_YYMM() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _vo.get_jyutNo()[_vo.getNum2()] + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.JYMEINO + " = '" + _vo.get_jyMeiNo()[_vo.getNum2()] + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.URMEINO + " = '" + _vo.get_urMeiNo()[_vo.getNum2()] + "' ");

        }else if(!_vo.getFuyoOrUpdown().equals("0"))
        {
            sql.append("UPDATE ");
            sql.append(TBTHB1DOWN.TBNAME);
            sql.append(" SET ");
            sql.append(" " + TBTHB1DOWN.TIMSTMP + " = " + getDBModelInterface().getSystemDateString());
            sql.append(" WHERE ");
            sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _vo.get_egCd() + "' " );
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _vo.get_tksKgyCd() + "' " );
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '"+ _vo.get_tksBmnSeqNo() + "' ");
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '"+ _vo.get_tksTntSeqNo() + "' " );
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _vo.get_YYMM() + "' ");

        }

        return sql.toString();
    }
}