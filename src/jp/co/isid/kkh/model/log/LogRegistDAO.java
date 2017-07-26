package jp.co.isid.kkh.model.log;


import jp.co.isid.kkh.integ.tbl.TBTHB6LOG;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * �ėp���O�f�[�^�o�^DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/17 IP H.Shimizu)<BR>
 * </P>
 * @author IP H.Shimizu
 */
public class LogRegistDAO extends AbstractSimpleRdbDao  {

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public LogRegistDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * �v���C�}���L�[��Ԃ��܂��B
     *
     * @return String[] �v���C�}���L�[
     */
    public String[] getPrimryKeyNames() {
        return null;
    }

    /**
     * �X�V���t�t�B�[���h��Ԃ��܂��B
     *
     * @return String �X�V���t�t�B�[���h
     */
    public String getTimeStampKeyName() {
        return TBTHB6LOG.TRKTIMSTMP;
    }

    /**
     * �V�X�e�����t�ōX�V�����̒�`�ł�
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[] { TBTHB6LOG.TRKTIMSTMP,TBTHB6LOG.UPDTIMSTMP };
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    public String getTableName() {
        return TBTHB6LOG.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB6LOG.TRKTIMSTMP
                ,TBTHB6LOG.TRKPL
                ,TBTHB6LOG.TRKTNT
                ,TBTHB6LOG.UPDTIMSTMP
                ,TBTHB6LOG.UPDAPL
                ,TBTHB6LOG.UPDTNT
                ,TBTHB6LOG.EGCD
                ,TBTHB6LOG.TKSKGYCD
                ,TBTHB6LOG.TKSBMNSEQNO
                ,TBTHB6LOG.TKSTNTSEQNO
                ,TBTHB6LOG.SYBT
                ,TBTHB6LOG.KINOID
                ,TBTHB6LOG.KBN
                ,TBTHB6LOG.DESC
                ,TBTHB6LOG.ERRDESC
                ,TBTHB6LOG.UPDDATE
                ,TBTHB6LOG.TANNAME
                ,TBTHB6LOG.RECEPTIONKIND
                ,TBTHB6LOG.STATUS
        };
    }



    /**
     * �ėp���O�f�[�^�̓o�^���s���܂��B
     *
     * @param volist VO �ėp���O�f�[�^VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void registLog(LogVO volist) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (volist == null) {
            throw new KKHException("�o�^�G���[", "BD-E0003");
        }
        super.setModel(volist);
        try {
            if (!super.insert()) {
                throw new KKHException("�o�^�G���[", "BD-E0003");
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0003");
        }
    }
}