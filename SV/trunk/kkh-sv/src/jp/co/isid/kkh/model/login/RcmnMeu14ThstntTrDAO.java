package jp.co.isid.kkh.model.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU07SIKKRSPRD;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU12THSKGY;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU13THSKGYBMON;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU14THSTNTTR;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU16SKUKJK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class RcmnMeu14ThstntTrDAO extends AbstractRdbDao {

    /** ���Ӑ�敪�F���Ӑ� */
    private static final String TKKBN_TK = "1";

    /** �I���N���ő�l */
    private static final String ENDYMD_MAX = "99999999";

    /** �����S����񌟍����� */
    private RcmnMeu14ThstntTrCondition _cond;

//    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode {
//        COND,
//    };

//    private SqlMode _sqlMode = SqlMode.COND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public RcmnMeu14ThstntTrDAO() {
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
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    public String getTableName() {
        return "";
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[] {};
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append(" /*+ ordered */ ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.THSKGYCD + " ");
        sql.append(" ," + TBRCMN_MEU14THSTNTTR.SEQNO + " ");
        sql.append(" ," + TBRCMN_MEU14THSTNTTR.TRTNTSEQNO + " ");
        sql.append(" ," + TBRCMN_MEU14THSTNTTR.SIKCD + " ");
        sql.append(" ," + TBRCMN_MEU16SKUKJK.SINCD + " ");
        sql.append(" ," + TBRCMN_MEU12THSKGY.THSKGYDISPKJ + " ");
        sql.append(" ," + TBRCMN_MEU13THSKGYBMON.SUBMEI + " ");
        sql.append(" ," + TBRCMN_MEU07SIKKRSPRD.SIKCDKYK + " ");
        sql.append(" ," + TBRCMN_MEU07SIKKRSPRD.SIKCDBU + " ");
        sql.append(" ," + TBRCMN_MEU07SIKKRSPRD.BUHYOJIKJ + " ");
        sql.append(" FROM ");
        sql.append("  " + TBRCMN_MEU14THSTNTTR.TBNAME + ", " + TBRCMN_MEU12THSKGY.TBNAME);
        sql.append(" ," + TBRCMN_MEU13THSKGYBMON.TBNAME + ", " + TBRCMN_MEU16SKUKJK.TBNAME);
        sql.append(" ," + TBRCMN_MEU07SIKKRSPRD.TBNAME);
        sql.append(" WHERE ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.THSKGYCD + " = '" + _cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.SEQNO + " = '" + _cond.getTksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.TKKBN + " = '" + TKKBN_TK + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.EGSYOCD + " = '" + _cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.ENDYMD + " = '" + ENDYMD_MAX + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU13THSKGYBMON.ENDYMD + " = '" + ENDYMD_MAX + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU12THSKGY.ENDYMD + " = '" + ENDYMD_MAX + "' ");
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU16SKUKJK.ENDYMD + " = '" + ENDYMD_MAX + "' ");
        sql.append(" AND ");
        sql.append(" '" + _cond.getEigyoBi() + "' BETWEEN " +  TBRCMN_MEU07SIKKRSPRD.STARTYMD + " AND " + TBRCMN_MEU07SIKKRSPRD.ENDYMD);
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.THSKGYCD + " = " + TBRCMN_MEU12THSKGY.THSKGYCD);
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.THSKGYCD + " = " + TBRCMN_MEU13THSKGYBMON.THSKGYCD);
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.THSKGYCD + " = " + TBRCMN_MEU16SKUKJK.THSKGYCD);
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.SEQNO + " = " + TBRCMN_MEU13THSKGYBMON.SEQNO);
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.SEQNO + " = " + TBRCMN_MEU16SKUKJK.SEQNO);
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.TRTNTSEQNO + " = " + TBRCMN_MEU16SKUKJK.TRTNTSEQNO);
        sql.append(" AND ");
        sql.append(" " + TBRCMN_MEU14THSTNTTR.SIKCD + " = " + TBRCMN_MEU07SIKKRSPRD.SIKCD);
        sql.append(" ORDER BY ");
        sql.append("  " + TBRCMN_MEU14THSTNTTR.THSKGYCD + ", " + TBRCMN_MEU14THSTNTTR.SEQNO);
        sql.append(" ," + TBRCMN_MEU14THSTNTTR.TRTNTSEQNO);

        return sql.toString();
    }

    /**
     * �����S�����̌������s���܂��B
     *
     * @return �����S�����VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<RcmnMeu14ThstntTrVO> getCustomerChargeInfo(RcmnMeu14ThstntTrCondition cond) throws KKHException {

        super.setModel(new RcmnMeu14ThstntTrVO());

        try {
            _cond = cond;
//            _sqlMode = SqlMode.COND;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "HB-E0001");
        }

    }

    /**
     * Model�̐������s��<br>
     * �������ʂ�VO��KEY���啶���̂��ߕϊ��������s��<br>
     * AbstractRdbDao��createFindedModelInstances���I�[�o�[���C�h<br>
     *
     * @param hashList List ��������
     * @return List<RcmnMeu14ThstntTrVO> �ϊ���̌�������
     */
    @Override
    protected List<RcmnMeu14ThstntTrVO> createFindedModelInstances(List hashList) {

        List<RcmnMeu14ThstntTrVO> list = new ArrayList<RcmnMeu14ThstntTrVO>();
        if (getModel() instanceof RcmnMeu14ThstntTrVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                RcmnMeu14ThstntTrVO vo = new RcmnMeu14ThstntTrVO();
                vo.setThskgyCd(StringUtil.trim((String) result.get(TBRCMN_MEU14THSTNTTR.THSKGYCD.toUpperCase())));
                vo.setSeqNo(StringUtil.trim((String) result.get(TBRCMN_MEU14THSTNTTR.SEQNO.toUpperCase())));
                vo.setTrtntSeqNo(StringUtil.trim((String) result.get(TBRCMN_MEU14THSTNTTR.TRTNTSEQNO.toUpperCase())));
                vo.setSikCd(StringUtil.trim((String) result.get(TBRCMN_MEU14THSTNTTR.SIKCD.toUpperCase())));
                vo.setSinCd((String) result.get(TBRCMN_MEU16SKUKJK.SINCD.toUpperCase())); // �e�����ƂɎg�p�p�r���قȂ邽��TRIM���Ȃ�
                vo.setThskgyDispKj(StringUtil.trim((String) result.get(TBRCMN_MEU12THSKGY.THSKGYDISPKJ.toUpperCase())));
                vo.setSubMei(StringUtil.trim((String) result.get(TBRCMN_MEU13THSKGYBMON.SUBMEI.toUpperCase())));
                vo.setSikcdKyk(StringUtil.trim((String) result.get(TBRCMN_MEU07SIKKRSPRD.SIKCDKYK.toUpperCase())));
                vo.setSikCdBu(StringUtil.trim((String) result.get(TBRCMN_MEU07SIKKRSPRD.SIKCDBU.toUpperCase())));
                vo.setBuHyojiKj(StringUtil.trim((String) result.get(TBRCMN_MEU07SIKKRSPRD.BUHYOJIKJ.toUpperCase())));
                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

}
