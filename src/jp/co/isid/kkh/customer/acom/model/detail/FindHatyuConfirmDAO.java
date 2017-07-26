package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

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
public class FindHatyuConfirmDAO extends AbstractRdbDao  {

    private FindHatyuNumByCondVO _cond;
    //private Thb5HikVO _cond;
     /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SqlMode{COMMON,};
    private SqlMode _sqlMode = SqlMode.COMMON;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindHatyuConfirmDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * �v���C�}���L�[��Ԃ��܂��B
     *
     * @return String[] �v���C�}���L�[
     */
    @Override
    public String[] getPrimryKeyNames() {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        return new String[]{
                TBTHB5HIK.TKSKGYCD,
                TBTHB5HIK.TKSBMNSEQNO,
                TBTHB5HIK.TKSTNTSEQNO,
                TBTHB5HIK.IRBAN,
                TBTHB5HIK.IRROWBAN
        };
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
        return TBTHB5HIK.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB5HIK.IRBAN
        };
    }

    /**
     * ���{NO����UP/DOWN�̓o�^���s���܂��B
     *
     * @param vo VO ���{NoVO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void findThb2Kmei(FindHatyuNumByCondVO vo) throws KKHException {

        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�o�^�G���[", "BD-E0002");
        }
        //super.setModel(vo);
        _cond = vo;

        try {
          super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public  String getSelectSQL() {
        if (_sqlMode.equals(SqlMode.COMMON)){
            return getExecString();
        }

        return "";
    }

    /**
     * EXEC-SQL����
     */
    @Override
    public String getExecString() {
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append(TBTHB5HIK.IRROWBAN + ", ");
        sql.append(" MAX(" + TBTHB5HIK.MEDIANAME + ") AS " + TBTHB5HIK.MEDIANAME  + " ");
        sql.append(" FROM ");
        sql.append(TBTHB5HIK.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" "+ TBTHB5HIK.TKSKGYCD + " =  '" + _cond.get_tksKgyCd() +"' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.get_tksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.get_tksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.IRBAN + " = '" + _cond.get_Irban() + "' ");
        sql.append(" GROUP BY ");
        sql.append(TBTHB5HIK.IRROWBAN + " ");
        sql.append(" ORDER BY ");
        sql.append(TBTHB5HIK.IRROWBAN + " ");

        return sql.toString();
    }

    /**
     * �L����׃e�[�u���̏����w�茟�����s���܂��B
     *
     * @return �󒍃_�E�����[�h�f�[�^VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<HikVO> findThb5HikByCondCmn(FindHatyuNumByCondVO Cond) throws KKHException {

        // TODO THB5HIK�e�[�u���ɓ����ڂȂ�
        super.setModel(new HikVO());

        try {
            _cond = Cond;
//        	_selSqlMode = SelSqlMode.COND_CMN;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    @Override
    protected List<HikVO> createFindedModelInstances(List hashList) {
        List<HikVO> list = new ArrayList<HikVO>();
        if (getModel() instanceof HikVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                HikVO vo = new HikVO();
                vo.setIrrowban((String) result.get(TBTHB5HIK.IRROWBAN.toUpperCase()));				//�˗��s�ԍ�
                vo.setMediaName((String) result.get( TBTHB5HIK.MEDIANAME.toUpperCase()));				//���f�B�A�R�[�h

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}