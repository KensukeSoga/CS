package jp.co.isid.kkh.customer.mac.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ���[�iMAC)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE KT)<BR>
 * �E�s��Ή�(2014/04/30 HLC S.Fujimoto)<BR>
 * </P>
 * @author
 */
public class ReportMacSchklstDAO extends AbstractRdbDao {

    /**�ėp�}�X�^�������� */
    private ReportMacSchklstCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportMacSchklstDAO() {
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
                TBTHB2KMEI.EGCD,
                TBTHB2KMEI.TKSKGYCD,
                TBTHB2KMEI.TKSBMNSEQNO,
                TBTHB2KMEI.TKSTNTSEQNO,
                TBTHB2KMEI.YYMM,
                TBTHB2KMEI.JYUTNO,
                TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO,
                TBTHB2KMEI.RENBN
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
        return TBTHB2KMEI.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    @Override
    public String[] getTableColumnNames() {
        return new String[]{
                TBTHB2KMEI.TIMSTMP,
                TBTHB2KMEI.UPDAPL,
                TBTHB2KMEI.UPDTNT,
                TBTHB2KMEI.EGCD,
                TBTHB2KMEI.TKSKGYCD,
                TBTHB2KMEI.TKSBMNSEQNO,
                TBTHB2KMEI.TKSTNTSEQNO,
                TBTHB2KMEI.YYMM,
                TBTHB2KMEI.JYUTNO,
                TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO,
                TBTHB2KMEI.HIMKCD,
                TBTHB2KMEI.RENBN,
                TBTHB2KMEI.DATEFROM,
                TBTHB2KMEI.DATETO,
                TBTHB2KMEI.SEIGAK,
                TBTHB2KMEI.HNNERT,
                TBTHB2KMEI.HNMAEGAK,
                TBTHB2KMEI.NEBIGAK,
                TBTHB2KMEI.DATE1,
                TBTHB2KMEI.DATE2,
                TBTHB2KMEI.DATE3,
                TBTHB2KMEI.DATE4,
                TBTHB2KMEI.DATE5,
                TBTHB2KMEI.DATE6,
                TBTHB2KMEI.KBN1,
                TBTHB2KMEI.KBN2,
                TBTHB2KMEI.KBN3,
                TBTHB2KMEI.CODE1,
                TBTHB2KMEI.CODE2,
                TBTHB2KMEI.CODE3,
                TBTHB2KMEI.CODE4,
                TBTHB2KMEI.CODE5,
                TBTHB2KMEI.CODE6,
                TBTHB2KMEI.NAME1,
                TBTHB2KMEI.NAME2,
                TBTHB2KMEI.NAME3,
                TBTHB2KMEI.NAME4,
                TBTHB2KMEI.NAME5,
                TBTHB2KMEI.NAME6,
                TBTHB2KMEI.NAME7,
                TBTHB2KMEI.NAME8,
                TBTHB2KMEI.NAME9,
                TBTHB2KMEI.NAME10,
                TBTHB2KMEI.KNGK1,
                TBTHB2KMEI.KNGK2,
                TBTHB2KMEI.KNGK3,
                TBTHB2KMEI.RITU1,
                TBTHB2KMEI.RITU2,
                TBTHB2KMEI.SONOTA1,
                TBTHB2KMEI.SONOTA2,
                TBTHB2KMEI.SONOTA3,
                TBTHB2KMEI.SONOTA4,
                TBTHB2KMEI.SONOTA5,
                TBTHB2KMEI.SONOTA6,
                TBTHB2KMEI.SONOTA7,
                TBTHB2KMEI.SONOTA8,
                TBTHB2KMEI.SONOTA9,
                TBTHB2KMEI.SONOTA10,
                TBTHB2KMEI.BUNFLG,
                TBTHB2KMEI.MEIHNFLG,
                TBTHB2KMEI.NEBHNFLG
        };
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
        //1:�X�܃R�[�h�����A2:�f�[�^����
        if (_cond.gettordflg().equals("1")){
            return getSelectSQLForMast();
        } else {
            return getSelectSQLForItem();
        }
    }

    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  sum(" + TBTHB2KMEI.SEIGAK + ") AS " + TBTHB2KMEI.SEIGAK + " ");
        sql.append(" ," + TBTHB2KMEI.CODE2 + " ");
        sql.append(" ," + TBTHB2KMEI.CODE4 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME1 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME2 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME5 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME4 + " ");
        sql.append(" ," + TBTHB2KMEI.JYUTNO + " ");
        sql.append(" ," + TBTHB2KMEI.JYMEINO + " ");
        sql.append(" ," + TBTHB2KMEI.URMEINO + " ");
        sql.append(" FROM ");
        /* �s��Ή� 2014/04/30 fujimoto ADD start */
        sql.append(TBTHB1DOWN.TBNAME + ",");
        /* �s��Ή� 2014/04/30 fujimoto ADD end */
        sql.append("  " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append(TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append(TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
        sql.append(TBTHB2KMEI.YYMM + " = '" + _cond.getYm()  + "'  ");
        /* �s��Ή� 2014/04/30 fujimoto ADD start */
        sql.append(" AND " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD);
        sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD);
        sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO);
        sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO);
        sql.append(" AND " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM);
        sql.append(" AND " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO);
        sql.append(" AND " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO);
        sql.append(" AND " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO);
        sql.append(" AND " + TBTHB1DOWN.TJYUTNO + "= ' '");
        /* �s��Ή� 2014/04/30 fujimoto ADD end */
        //�R�[�h�������ꍇ�͑S���w��
        if (_cond.getcode1().equals(""))
        {}
        //�R�[�h�w��
        else
        {
            sql.append(" AND " + TBTHB2KMEI.CODE1 + " = '" + _cond.getcode1()  + "' ");
        }
        sql.append("  GROUP BY ");
        sql.append(TBTHB2KMEI.CODE2 + ", ");
        sql.append(TBTHB2KMEI.CODE4 + ", ");
        sql.append(TBTHB2KMEI.NAME1 + ", ");
        sql.append(TBTHB2KMEI.NAME2 + ", ");
        sql.append(TBTHB2KMEI.NAME5 + ", ");
        sql.append(TBTHB2KMEI.NAME4 + ", ");
        sql.append(TBTHB2KMEI.JYUTNO + ", ");
        sql.append(TBTHB2KMEI.JYMEINO + ", ");
        sql.append(TBTHB2KMEI.URMEINO);
        sql.append("  ORDER BY ");
        sql.append(TBTHB2KMEI.CODE2 + ", ");
        sql.append(TBTHB2KMEI.JYUTNO + ", ");
        sql.append(TBTHB2KMEI.JYMEINO + ", ");
        sql.append(TBTHB2KMEI.URMEINO);

        return sql.toString();
    }

    private String getSelectSQLForMast(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  MAX(0) AS " + TBTHB2KMEI.SEIGAK + " ");
        sql.append(" ," + TBTHB2KMEI.CODE1 + " AS " + TBTHB2KMEI.CODE2 + " ");
        sql.append(" ,MAX('') AS " + TBTHB2KMEI.CODE4 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME3 + " AS " + TBTHB2KMEI.NAME1 + " ");
        sql.append(" ,MAX('') AS " + TBTHB2KMEI.NAME2 + " ");
        sql.append(" ,MAX('') AS " + TBTHB2KMEI.NAME5 + " ");
        sql.append(" ,MAX('') AS " + TBTHB2KMEI.NAME4 + " ");
        sql.append(" ,MAX('') AS " + TBTHB2KMEI.JYUTNO + " ");
        sql.append(" ,MAX('') AS " + TBTHB2KMEI.JYMEINO + " ");
        sql.append(" ,MAX('') AS " + TBTHB2KMEI.URMEINO + " ");
        sql.append(" FROM ");
        /* �s��Ή� 2014/04/30 fujimoto ADD start */
        sql.append(TBTHB1DOWN.TBNAME + ",");
        /* �s��Ή� 2014/04/30 fujimoto ADD end */
        sql.append("  " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append(TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
        sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
        sql.append(TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
        sql.append(TBTHB2KMEI.YYMM + " = '" + _cond.getYm()  + "'  ");
        /* �s��Ή� 2014/04/30 fujimoto ADD start */
        sql.append(" AND " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD);
        sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD);
        sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO);
        sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO);
        sql.append(" AND " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO);
        sql.append(" AND " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO);
        sql.append(" AND " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO);
        sql.append(" AND " + TBTHB1DOWN.TJYUTNO + " = ' '");
        /* �s��Ή� 2014/04/30 fujimoto ADD end */
        sql.append("  GROUP BY ");
        sql.append(TBTHB2KMEI.CODE1 + ", ");
        sql.append(TBTHB2KMEI.NAME3 + " ");
        sql.append("  ORDER BY ");
        sql.append(TBTHB2KMEI.CODE1 + " ");

        return sql.toString();
    }

    /**
     * ���[�f�[�^�iMAC)�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportMacSchklstVO> findReportMacSchklstByCondition(ReportMacSchklstCondition cond) throws KKHException {

        super.setModel(new ReportMacSchklstVO());

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
    protected List<ReportMacSchklstVO> createFindedModelInstances(List hashList) {
        List<ReportMacSchklstVO> list = new ArrayList<ReportMacSchklstVO>();
        if (getModel() instanceof ReportMacSchklstVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ReportMacSchklstVO vo = new ReportMacSchklstVO();
                vo.setSeiGak((BigDecimal)result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
                vo.setCode2((String)result.get(TBTHB2KMEI.CODE2.toUpperCase()));
                vo.setCode4((String)result.get(TBTHB2KMEI.CODE4.toUpperCase()));
                vo.setName1((String)result.get(TBTHB2KMEI.NAME1.toUpperCase()));
                vo.setName2((String)result.get(TBTHB2KMEI.NAME2.toUpperCase()));
                vo.setName5((String)result.get(TBTHB2KMEI.NAME5.toUpperCase()));
                vo.setName4((String)result.get(TBTHB2KMEI.NAME4.toUpperCase()));
                vo.setJyutNo((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
                vo.setJyMeiNo((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
                vo.setUrMeiNo((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));
                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
