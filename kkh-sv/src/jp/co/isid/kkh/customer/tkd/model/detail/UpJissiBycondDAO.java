package jp.co.isid.kkh.customer.tkd.model.detail;

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
 * �E�V�K�쐬(2011/12/6 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
public class UpJissiBycondDAO extends AbstractSimpleRdbDao  {

    private UpJissiBycondVO _vo;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public UpJissiBycondDAO() {
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
    public void jissiUp(UpJissiBycondVO vo) throws KKHException {
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

        sql.append("UPDATE");
        sql.append(" THB2KMEI");
        sql.append(" SET");
        sql.append(" HB2_KNGK1 =");
        sql.append(" HB2_KNGK1 ");
        sql.append(_vo.get_atnum());
        sql.append(" WHERE ");
        sql.append(" HB2_EGCD = ");
        sql.append("'" + _vo.get_egCd()+"'");
        sql.append(" AND ");
        sql.append(" HB2_TKSKGYCD = ");
        sql.append("'"+_vo.get_tksKgyCd()+"'");
        sql.append("AND");
        sql.append(" HB2_TKSBMNSEQNO = ");
        sql.append("'"+_vo.get_tksBmnSeqNo()+"'");
        sql.append(" AND ");
        sql.append(" HB2_TKSTNTSEQNO = ");
        sql.append("'" + _vo.get_TksTntSeqNo() + "'");
        sql.append(" AND ");
        sql.append(" HB2_YYMM = ");
        sql.append("'"+_vo.get_YYMM() +"'");
        sql.append("AND");
        sql.append(" HB2_KNGK1 >= 1");
//    	sql.append(" AND ");
//    	sql.append(" NOT HB2_KBN2 = 0 ");

        return sql.toString();
    }

}
