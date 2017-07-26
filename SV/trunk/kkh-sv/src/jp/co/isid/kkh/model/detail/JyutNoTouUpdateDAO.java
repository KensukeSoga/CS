package jp.co.isid.kkh.model.detail;


import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * �󒍔ԍ�����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/27 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
public class JyutNoTouUpdateDAO extends AbstractSimpleRdbDao  {

    private JyutNoTouUpdateVO _vo;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public JyutNoTouUpdateDAO() {
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
        return TBTHB1DOWN.TBNAME;
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
     * �󒍓��e�����o�^���s���܂��B
     *
     * @param vo VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void JyutNoTouUpdate(JyutNoTouUpdateVO vo) throws KKHException {
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

        sql.append(" UPDATE ");
        sql.append(" " + TBTHB1DOWN.TBNAME + " ");
        sql.append(" SET ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = '" + _vo.get_keyJyutno() + "', ");
        sql.append(" " + TBTHB1DOWN.TJYMEINO + " = '" + _vo.get_keyJyMeiNo() + "', ");
        sql.append(" " + TBTHB1DOWN.TURMEINO + " = '" + _vo.get_keyUriMeiNo() + "' ");
        sql.append(" WHERE");
//    	sql.append(" " + TBTHB1DOWN.EGCD + " = '" + _vo.get_egCd() + "' ");
//    	sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = '" + _vo.get_tksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _vo.get_tksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _vo.get_tksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.YYMM + " = '" + _vo.get_YYMM() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.JYUTNO + " = '" + _vo.get_keyJyutno() + "' ");

        if(_vo.get_Gyomkbn().equals("") || _vo.get_Gyomkbn() == null)
        {
        }else
        {
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.GYOMKBN + " = '" + _vo.get_Gyomkbn() + "' ");
        }

        if(_vo.get_Tmspkbn().equals("") || _vo.get_Tmspkbn() == null)
        {
        }else
        {
            sql.append(" AND ");
            sql.append(" " + TBTHB1DOWN.TMSPKBN + " = '" + _vo.get_Tmspkbn() + "' ");
        }

        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TJYMEINO + " = ' ' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TURMEINO + " = ' ' ");

        return sql.toString();
    }

}
