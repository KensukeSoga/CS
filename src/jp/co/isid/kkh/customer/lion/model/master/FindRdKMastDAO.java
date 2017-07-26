package jp.co.isid.kkh.customer.lion.model.master;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB12WLRDK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class FindRdKMastDAO extends AbstractRdbDao  {

    /** ���W�I�ǃ}�X�^�������� */
    private FindRdKMastCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindRdKMastDAO() {
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
        return new String[]{
                TBTHB12WLRDK.EGCD,
                TBTHB12WLRDK.TKSKGYCD,
                TBTHB12WLRDK.TKSBMNSEQNO,
                TBTHB12WLRDK.TKSTNTSEQNO,
                TBTHB12WLRDK.KYOKUCD,
        };
    }

    /**
     * �X�V���t�t�B�[���h��Ԃ��܂��B
     *
     * @return String �X�V���t�t�B�[���h
     */
    public String getTimeStampKeyName() {
        //new String[] {};
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    @Override
    public String getTableName() {
        return TBTHB12WLRDK.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    @Override
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB12WLRDK.TRKTIMSTMP,
                TBTHB12WLRDK.TRKPL,
                TBTHB12WLRDK.TRKTNT,
                TBTHB12WLRDK.UPDTIMSTMP,
                TBTHB12WLRDK.UPDAPL,
                TBTHB12WLRDK.UPDTNT,
                TBTHB12WLRDK.EGCD,
                TBTHB12WLRDK.TKSKGYCD,
                TBTHB12WLRDK.TKSBMNSEQNO,
                TBTHB12WLRDK.TKSTNTSEQNO,
                TBTHB12WLRDK.KYOKUCD,
                TBTHB12WLRDK.KYOKUNAME,
                TBTHB12WLRDK.KIGOU,
                TBTHB12WLRDK.KEIRETSU,
                TBTHB12WLRDK.HYOJIJYUN
        };
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
        return getSelectSQLForItem();
    }

    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHB12WLRDK.TRKTIMSTMP + " ");
        sql.append(" ," + TBTHB12WLRDK.TRKPL + " ");
        sql.append(" ," + TBTHB12WLRDK.TRKTNT + " ");
        sql.append(" ," + TBTHB12WLRDK.UPDTIMSTMP + " ");
        sql.append(" ," + TBTHB12WLRDK.UPDAPL + " ");
        sql.append(" ," + TBTHB12WLRDK.UPDTNT + " ");
        sql.append(" ," + TBTHB12WLRDK.EGCD + " ");
        sql.append(" ," + TBTHB12WLRDK.TKSKGYCD + " ");
        sql.append(" ," + TBTHB12WLRDK.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHB12WLRDK.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHB12WLRDK.KYOKUCD + " ");
        sql.append(" ," + TBTHB12WLRDK.KYOKUNAME + " ");
        sql.append(" ," + TBTHB12WLRDK.KIGOU + " ");
        sql.append(" ," + TBTHB12WLRDK.KEIRETSU + " ");
        sql.append(" ," + TBTHB12WLRDK.HYOJIJYUN + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHB12WLRDK.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(TBTHB12WLRDK.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append(TBTHB12WLRDK.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append(TBTHB12WLRDK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append(TBTHB12WLRDK.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  ");
        //�ǃR�[�h�����p
        if (_cond.getKyokucd().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB12WLRDK.KYOKUCD  + " = '" + _cond.getKyokucd()  + "' ");
        }
        //�L�������p
        if (_cond.getKigou().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB12WLRDK.KIGOU  + " = '" + _cond.getKigou()  + "' ");
        }
        //�n�񌟍��p
        if (_cond.getKeiretsu().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB12WLRDK.KEIRETSU  + " = '" + _cond.getKeiretsu()  + "' ");
        }

        sql.append("  ORDER BY ");
        sql.append(TBTHB12WLRDK.HYOJIJYUN);

        return sql.toString();
    }

    /**
     * ���W�I�ǃ}�X�^�̌������s���܂��B
     *
     * @return �e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<FindRdKMastVO> findRdKMastByCondition(FindRdKMastCondition cond) throws KKHException {

        super.setModel(new FindRdKMastVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * Model�̐������s��<br>
     * �������ʂ�VO��KEY���啶���̂��ߕϊ��������s��<br>
     * AbstractRdbDao��createFindedModelInstances���I�[�o�[���C�h<br>
     *
     * @param hashList List ��������
     * @return List<CommonCodeMasterVO> �ϊ���̌�������
     */
    @Override
    protected List<FindRdKMastVO> createFindedModelInstances(List hashList) {
        List<FindRdKMastVO> list = new ArrayList<FindRdKMastVO>();
        if (getModel() instanceof FindRdKMastVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindRdKMastVO vo = new FindRdKMastVO();
                vo.setTrktimstmp((Date)result.get(TBTHB12WLRDK.TRKTIMSTMP.toUpperCase()));
                vo.setTrkpl((String)result.get(TBTHB12WLRDK.TRKPL.toUpperCase()));
                vo.setTrktnt((String)result.get(TBTHB12WLRDK.TRKTNT.toUpperCase()));
                vo.setUpdtimstmp((Date)result.get(TBTHB12WLRDK.UPDTIMSTMP.toUpperCase()));
                vo.setUpdakpl((String)result.get(TBTHB12WLRDK.UPDAPL.toUpperCase()));
                vo.setUpdtnt((String)result.get(TBTHB12WLRDK.UPDTNT.toUpperCase()));
                vo.setEgcd((String)result.get(TBTHB12WLRDK.EGCD.toUpperCase()));
                vo.setTkskgycd((String)result.get(TBTHB12WLRDK.TKSKGYCD.toUpperCase()));
                vo.setTksbmnseqno((String)result.get(TBTHB12WLRDK.TKSBMNSEQNO.toUpperCase()));
                vo.setTkstntseqno((String)result.get(TBTHB12WLRDK.TKSTNTSEQNO.toUpperCase()));
                vo.setKyokuCd((String)result.get(TBTHB12WLRDK.KYOKUCD.toUpperCase()));
                vo.setKyokuName((String)result.get(TBTHB12WLRDK.KYOKUNAME.toUpperCase()));
                vo.setKigou((String)result.get(TBTHB12WLRDK.KIGOU.toUpperCase()));
                vo.setKeiretsu((String)result.get(TBTHB12WLRDK.KEIRETSU.toUpperCase()));
                vo.setHyojijyun((String)result.get(TBTHB12WLRDK.HYOJIJYUN.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
