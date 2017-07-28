package jp.co.isid.kkh.customer.ash.model.detail;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * �X�VDAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/29 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class UpdateDataAshDAO extends AbstractSimpleRdbDao {

    private Thb2KmeiVO _vo;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public UpdateDataAshDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    @Override
    public String[] getPrimryKeyNames() {
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
     * �X�V���s���܂��B�L����׃f�[�^�̍X�V(�󒍓����p)
     *
     * @param vo VO
     * @return int �X�V����
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public int updateThb2Kmei(Thb2KmeiVO vo)
            throws KKHException {
        // �p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�o�^�G���[", "BD-E0002");
        }
        super.setModel(vo);
        try {
            _vo = vo;
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

        sql.append(" UPDATE ");
        sql.append("     " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" SET ");
    	sql.append("    " + TBTHB2KMEI.TIMSTMP + " = SYSDATE ");
        sql.append("   ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYUTNO           + " = '" + _vo.getHb2JyutNo() + "' ");
        sql.append("   ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYMEINO          + " = '" + _vo.getHb2JyMeiNo() + "' ");
        sql.append("   ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.URMEINO          + " = '" + _vo.getHb2UrMeiNo() + "' ");
        sql.append("   ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.SEIGAK           + " = '" + _vo.getHb2SeiGak() + "' ");
        sql.append("   ," + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.HNMAEGAK         + " = '" + _vo.getHb2HnmaeGak() + "' ");
        sql.append(" WHERE ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.EGCD             + " = '" + _vo.getHb2EgCd() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSKGYCD         + " = '" + _vo.getHb2TksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSBMNSEQNO      + " = '" + _vo.getHb2TksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.TKSTNTSEQNO      + " = '" + _vo.getHb2TksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.YYMM             + " = '" + _vo.getHb2Yymm() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYUTNO           + " = '" + _vo.getHb2JyutNo() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.JYMEINO          + " = '" + _vo.getHb2JyMeiNo() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.URMEINO          + " = '" + _vo.getHb2UrMeiNo() + "' ");
        sql.append(" AND ");
        sql.append("    " + TBTHB2KMEI.TBNAME + "." + TBTHB2KMEI.RENBN            + " = '" + _vo.getHb2Renbn() + "' ");

        return sql.toString();
    }
}
