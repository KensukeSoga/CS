package jp.co.isid.kkh.customer.lion.model.master;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHB9WLTVB;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class FindTvMastDAO extends AbstractRdbDao  {

    /**�e���r�ԑg�}�X�^�������� */
    private FindTvMastCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindTvMastDAO() {
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
                TBTHB9WLTVB.EGCD,
                TBTHB9WLTVB.TKSKGYCD,
                TBTHB9WLTVB.TKSBMNSEQNO,
                TBTHB9WLTVB.TKSTNTSEQNO,
                TBTHB9WLTVB.BANCD,
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
        return TBTHB9WLTVB.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    @Override
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB9WLTVB.TRKTIMSTMP,
                TBTHB9WLTVB.TRKPL,
                TBTHB9WLTVB.TRKTNT,
                TBTHB9WLTVB.UPDTIMSTMP,
                TBTHB9WLTVB.UPDAPL,
                TBTHB9WLTVB.UPDTNT,
                TBTHB9WLTVB.EGCD,
                TBTHB9WLTVB.TKSKGYCD,
                TBTHB9WLTVB.TKSBMNSEQNO,
                TBTHB9WLTVB.TKSTNTSEQNO,
                TBTHB9WLTVB.BANCD,
                TBTHB9WLTVB.BANNAME,
                TBTHB9WLTVB.HKYOKUCD,
                TBTHB9WLTVB.SEISAKUHI,
                TBTHB9WLTVB.HYOJIJYUN,
                TBTHB9WLTVB.TANKA,
                TBTHB9WLTVB.TYPE2
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
        sql.append("  " + TBTHB9WLTVB.TRKTIMSTMP + " ");
        sql.append(" ," + TBTHB9WLTVB.TRKPL + " ");
        sql.append(" ," + TBTHB9WLTVB.TRKTNT + " ");
        sql.append(" ," + TBTHB9WLTVB.UPDTIMSTMP + " ");
        sql.append(" ," + TBTHB9WLTVB.UPDAPL + " ");
        sql.append(" ," + TBTHB9WLTVB.UPDTNT + " ");
        sql.append(" ," + TBTHB9WLTVB.EGCD + " ");
        sql.append(" ," + TBTHB9WLTVB.TKSKGYCD + " ");
        sql.append(" ," + TBTHB9WLTVB.TKSBMNSEQNO + " ");
        sql.append(" ," + TBTHB9WLTVB.TKSTNTSEQNO + " ");
        sql.append(" ," + TBTHB9WLTVB.BANCD + " ");
        sql.append(" ," + TBTHB9WLTVB.BANNAME + " ");
        sql.append(" ," + TBTHB9WLTVB.HKYOKUCD + " ");
        sql.append(" ," + TBTHB9WLTVB.SEISAKUHI + " ");
        sql.append(" ," + TBTHB9WLTVB.HYOJIJYUN + " ");
        sql.append(" ," + TBTHB9WLTVB.TANKA + " ");
        sql.append(" ," + TBTHB9WLTVB.TYPE2 + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHB9WLTVB.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(TBTHB9WLTVB.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append(TBTHB9WLTVB.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append(TBTHB9WLTVB.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append(TBTHB9WLTVB.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  ");
        //�ԑg�R�[�h�����p
        if (_cond.getBancd().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB9WLTVB.BANCD  + " = '" + _cond.getBancd()  + "' ");
        }
        //�ԑg���̌����p
        if (_cond.getBanname().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB9WLTVB.BANNAME  + " = '" + _cond.getBanname()  + "' ");
        }
        //�ԑg�ǎ��b�c�����p
        if (_cond.getHkyokucd().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB9WLTVB.HKYOKUCD  + " = '" + _cond.getHkyokucd()  + "' ");
        }
        //�P���敪�����p
        if (_cond.getTanka().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB9WLTVB.TANKA  + " = '" + _cond.getTanka()  + "' ");
        }
        //�s�x�o�d�Q�����p
        if (_cond.getType2().equals("")){}
        else{
            sql.append(" AND ");
            sql.append(TBTHB9WLTVB.TYPE2  + " = '" + _cond.getType2()  + "' ");
        }

        sql.append("  ORDER BY ");
        sql.append(TBTHB9WLTVB.HYOJIJYUN);

        return sql.toString();
    }

    /**
     * TV�ԑg�}�X�^�̌������s���܂��B
     *
     * @return �e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<FindTvMastVO> findTvMastByCondition(FindTvMastCondition cond) throws KKHException {

        super.setModel(new FindTvMastVO());

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
    protected List<FindTvMastVO> createFindedModelInstances(List hashList) {
        List<FindTvMastVO> list = new ArrayList<FindTvMastVO>();
        if (getModel() instanceof FindTvMastVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                FindTvMastVO vo = new FindTvMastVO();
                vo.setTrktimstmp((Date)result.get(TBTHB9WLTVB.TRKTIMSTMP.toUpperCase()));
                vo.setTrkpl((String)result.get(TBTHB9WLTVB.TRKPL.toUpperCase()));
                vo.setTrktnt((String)result.get(TBTHB9WLTVB.TRKTNT.toUpperCase()));
                vo.setUpdtimstmp((Date)result.get(TBTHB9WLTVB.UPDTIMSTMP.toUpperCase()));
                vo.setUpdakpl((String)result.get(TBTHB9WLTVB.UPDAPL.toUpperCase()));
                vo.setUpdtnt((String)result.get(TBTHB9WLTVB.UPDTNT.toUpperCase()));
                vo.setEgcd((String)result.get(TBTHB9WLTVB.EGCD.toUpperCase()));
                vo.setTkskgycd((String)result.get(TBTHB9WLTVB.TKSKGYCD.toUpperCase()));
                vo.setTksbmnseqno((String)result.get(TBTHB9WLTVB.TKSBMNSEQNO.toUpperCase()));
                vo.setTkstntseqno((String)result.get(TBTHB9WLTVB.TKSTNTSEQNO.toUpperCase()));
                vo.setBancd((String)result.get(TBTHB9WLTVB.BANCD.toUpperCase()));
                vo.setBanname((String)result.get(TBTHB9WLTVB.BANNAME.toUpperCase()));
                vo.setHkyokucd((String)result.get(TBTHB9WLTVB.HKYOKUCD.toUpperCase()));
                vo.setSeisakuhi((BigDecimal)result.get(TBTHB9WLTVB.SEISAKUHI.toUpperCase()));
                vo.setHyojijyun((String)result.get(TBTHB9WLTVB.HYOJIJYUN.toUpperCase()));
                vo.setTanka((String)result.get(TBTHB9WLTVB.TANKA.toUpperCase()));
                vo.setType2((String)result.get(TBTHB9WLTVB.TYPE2.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
