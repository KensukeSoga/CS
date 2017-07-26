package jp.co.isid.kkh.customer.mac.model.master;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB17RMTNP;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.mac.model.master.FindMasterMacTnpRByCondCondition;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * �}�N�h�i���h�X�܃}�X�^�����e�[�u������DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 * @author
 */
public class FindMasterMacTnpRByCondDAO extends AbstractRdbDao {

    /**�ėp�}�X�^(�f�[�^)��������*/
    private FindMasterMacTnpRByCondCondition _cond;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SqlMode{SINGLE,ALL};
    private SqlMode _sqlMode = SqlMode.SINGLE;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindMasterMacTnpRByCondDAO() {
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
        return TBTHB17RMTNP.TRKTIMSTMP;
    }

    /**
     * �V�X�e�����t�ōX�V�����̒�`�ł�
     */
    @Override
    protected String[] getSystemDateColumnNames() {
        return new String[] { TBTHB17RMTNP.TRKTIMSTMP,TBTHB17RMTNP.UPDTIMSTMP };
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    public String getTableName() {
        return TBTHB17RMTNP.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[]{
        };
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {

        return getSelectSQLMacTnpR();
    }

    /**
     * �}�N�h�i���h�X�܃}�X�^�����e�[�u��������
     *
     * @param cond �X�V����
     * @throws KKHException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    @SuppressWarnings("unchecked")
    public List<FindMasterMacTnpRByCondVO> findthb17rmtnp(FindMasterMacTnpRByCondCondition cond) throws KKHException {

        super.setModel(new FindMasterMacTnpRByCondVO());

        try {
            _cond = cond;

            if(_cond.getTenpoCd().isEmpty())
            {
                _sqlMode = SqlMode.ALL;
            }
            else
            {
                _sqlMode = SqlMode.SINGLE;
            }
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * �r�p�k����
     */
    public String getSelectSQLMacTnpR()
    {
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append(" " + TBTHB17RMTNP.TRKTIMSTMP + " ");
        sql.append("," + TBTHB17RMTNP.TRKPL + " ");
        sql.append("," + TBTHB17RMTNP.TRKTNT + " ");
        sql.append("," + TBTHB17RMTNP.UPDTIMSTMP + " ");
        sql.append("," + TBTHB17RMTNP.UPDAPL + " ");
        sql.append("," + TBTHB17RMTNP.UPDTNT + " ");
        sql.append("," + TBTHB17RMTNP.EGCD + " ");
        sql.append("," + TBTHB17RMTNP.TKSKGYCD + " ");
        sql.append("," + TBTHB17RMTNP.TKSBMNSEQNO + " ");
        sql.append("," + TBTHB17RMTNP.TKSTNTSEQNO + " ");
        sql.append("," + TBTHB17RMTNP.TENPOCD + " ");
        sql.append("," + TBTHB17RMTNP.TENPONM + " ");
        sql.append("," + TBTHB17RMTNP.TERRITORY + " ");
        sql.append("," + TBTHB17RMTNP.TENPOKBN + " ");
        sql.append("," + TBTHB17RMTNP.KAMOKU + " ");
        sql.append("," + TBTHB17RMTNP.YUBINNO + " ");
        sql.append("," + TBTHB17RMTNP.ADDRESS1+ " ");
        sql.append("," + TBTHB17RMTNP.ADDRESS2+ " ");
        sql.append("," + TBTHB17RMTNP.TELNO + " ");
        sql.append("," + TBTHB17RMTNP.SPLITFLG + " ");
        sql.append("," + TBTHB17RMTNP.COMPANYNM + " ");
        sql.append("," + TBTHB17RMTNP.NAME + " ");
        sql.append("," + TBTHB17RMTNP.TORIHIKICD + " ");
        sql.append("," + TBTHB17RMTNP.INSTATUS + " ");
        sql.append("," + TBTHB17RMTNP.SGOPEN + " ");
        sql.append("," + TBTHB17RMTNP.GOPEN + " ");
        sql.append("," + TBTHB17RMTNP.GCLOSE + " ");
        sql.append("," + TBTHB17RMTNP.UPDRRKTIMSTMP + " ");
        sql.append("," + TBTHB17RMTNP.TORIKOMIFLG + " ");
        sql.append("," + TBTHB17RMTNP.RRKSYBT + " ");
        sql.append(" FROM ");
        sql.append(" " + TBTHB17RMTNP.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" " + TBTHB17RMTNP.EGCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB17RMTNP.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB17RMTNP.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB17RMTNP.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
        if (_sqlMode == SqlMode.SINGLE)
        {
            sql.append(" AND ");
            sql.append(" " + TBTHB17RMTNP.TENPOCD + " = '" + _cond.getTenpoCd() + "' ");
        }
        else if (_sqlMode == SqlMode.ALL)
        {
            if(!_cond.getUpdRrkTimstmp().isEmpty())
            {
                sql.append(" AND ");
                sql.append(" " + TBTHB17RMTNP.UPDRRKTIMSTMP + " = '" + _cond.getUpdRrkTimstmp() + "' ");
            }
            if(!_cond.getRrkSybt().isEmpty())
            {
                sql.append(" AND ");
                sql.append(" " + TBTHB17RMTNP.RRKSYBT + " = '" + _cond.getRrkSybt() + "' ");
            }
            if(!_cond.getTorikomiFlg().isEmpty())
            {
                sql.append(" AND ");
                sql.append(" " + TBTHB17RMTNP.TORIKOMIFLG + " = '" + _cond.getTorikomiFlg() + "' ");
            }
        }
        sql.append(" ORDER BY ");
        sql.append(" " + TBTHB17RMTNP.UPDRRKTIMSTMP + " DESC ");
        sql.append("," + TBTHB17RMTNP.TENPOCD + " ");

        return sql.toString();
    }

    /**
     * Model�̐������s��<br>
     * �������ʂ�VO��KEY���啶���̂��ߕϊ��������s��<br>
     * AbstractRdbDao��createFindedModelInstances���I�[�o�[���C�h<br>
     *
     * @param hashList
     *            List ��������
     * @return List<CommonCodeMasterVO> �ϊ���̌�������
     */
    @Override
    protected List<FindMasterMacTnpRByCondVO> createFindedModelInstances(List hashList) {
        List<FindMasterMacTnpRByCondVO> list = new ArrayList<FindMasterMacTnpRByCondVO>();
        if (getModel() instanceof FindMasterMacTnpRByCondVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindMasterMacTnpRByCondVO vo = new FindMasterMacTnpRByCondVO();

                vo.setTrkTimStmp((Date)result.get(TBTHB17RMTNP.TRKTIMSTMP.toUpperCase()));
                vo.setTrkPl((String)result.get(TBTHB17RMTNP.TRKPL.toUpperCase()));
                vo.setTrkTnt((String)result.get(TBTHB17RMTNP.TRKTNT.toUpperCase()));
                vo.setUpdTimStmp((Date)result.get(TBTHB17RMTNP.UPDTIMSTMP.toUpperCase()));
                vo.setUpdaPl((String)result.get(TBTHB17RMTNP.UPDAPL.toUpperCase()));
                vo.setUpdTnt((String)result.get(TBTHB17RMTNP.UPDTNT.toUpperCase()));
                vo.setEgCd((String)result.get(TBTHB17RMTNP.EGCD.toUpperCase()));
                vo.setTksKgyCd((String)result.get(TBTHB17RMTNP.TKSKGYCD.toUpperCase()));
                vo.setTksBmnSeqNo((String)result.get(TBTHB17RMTNP.TKSBMNSEQNO.toUpperCase()));
                vo.setTksTntSeqNo((String)result.get(TBTHB17RMTNP.TKSTNTSEQNO.toUpperCase()));
                vo.setTenpoCd((String)result.get(TBTHB17RMTNP.TENPOCD.toUpperCase()));
                vo.setTenpoNm((String)result.get(TBTHB17RMTNP.TENPONM.toUpperCase()));
                vo.setTerritory((String)result.get(TBTHB17RMTNP.TERRITORY.toUpperCase()));
                vo.setTenpoKbn((String)result.get(TBTHB17RMTNP.TENPOKBN.toUpperCase()));
                vo.setKamoku((String)result.get(TBTHB17RMTNP.KAMOKU.toUpperCase()));
                vo.setYubinNo((String)result.get(TBTHB17RMTNP.YUBINNO.toUpperCase()));
                vo.setAddress1((String)result.get(TBTHB17RMTNP.ADDRESS1.toUpperCase()));
                vo.setAddress2((String)result.get(TBTHB17RMTNP.ADDRESS2.toUpperCase()));
                vo.setTelNo((String)result.get(TBTHB17RMTNP.TELNO.toUpperCase()));
                vo.setSplitFlg((String)result.get(TBTHB17RMTNP.SPLITFLG.toUpperCase()));
                vo.setCompanyNm((String)result.get(TBTHB17RMTNP.COMPANYNM.toUpperCase()));
                vo.setName((String)result.get(TBTHB17RMTNP.NAME.toUpperCase()));
                vo.setTorihikiCd((String)result.get(TBTHB17RMTNP.TORIHIKICD.toUpperCase()));
                vo.setInStatus((String)result.get(TBTHB17RMTNP.INSTATUS.toUpperCase()));
                vo.setSGOpen((String)result.get(TBTHB17RMTNP.SGOPEN.toUpperCase()));
                vo.setGOpen((String)result.get(TBTHB17RMTNP.GOPEN.toUpperCase()));
                vo.setGClose((String)result.get(TBTHB17RMTNP.GCLOSE.toUpperCase()));
                vo.setUpdRrkTimstmp((String)result.get(TBTHB17RMTNP.UPDRRKTIMSTMP.toUpperCase()));
                vo.setTorikomiFlg((String)result.get(TBTHB17RMTNP.TORIKOMIFLG.toUpperCase()));
                vo.setRrkSybt((String)result.get(TBTHB17RMTNP.RRKSYBT.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
