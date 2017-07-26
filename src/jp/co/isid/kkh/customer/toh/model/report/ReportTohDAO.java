package jp.co.isid.kkh.customer.toh.model.report;

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
 * ���[�iTOH)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE KT)<BR>
 * </P>
 * @author
 */
public class ReportTohDAO extends AbstractRdbDao {

    /**�ėp�}�X�^�������� */
    private ReportTohCondition _cond;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode{KIND,ITEM,};
//    private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportTohDAO() {
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
        return getSelectSQLForItem();
    }

    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append("  " + TBTHB2KMEI.JYUTNO + " ");
        sql.append(" ," + TBTHB2KMEI.JYMEINO + " ");
        sql.append(" ," + TBTHB2KMEI.URMEINO + " ");
        sql.append(" ," + TBTHB2KMEI.DATE1 + " ");
        sql.append(" ," + TBTHB2KMEI.CODE1 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME8 + " ");
        sql.append(" ," + TBTHB2KMEI.NAME2 + " ");
        sql.append(" ," + TBTHB2KMEI.SEIGAK + " ");
        // ����őΉ� 2013/10/09 add HLC H.Watabe start
        sql.append(" ,(" + TBTHB2KMEI.RITU1 + " * 0.01) AS "+ TBTHB2KMEI.RITU1 + " ");
        // ����őΉ� 2013/10/09 add HLC H.Watabe end
        sql.append(" ," + TBTHB2KMEI.KBN1 + " ");
        sql.append(" ," + TBTHB2KMEI.KBN2 + " ");
        sql.append(" ," + TBTHB2KMEI.KNGK1 + " ");
        sql.append(" FROM ");
        sql.append("  " + TBTHB2KMEI.TBNAME + " ");
        sql.append(" ," + TBTHB1DOWN.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
        sql.append(TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND "); //���Ӑ�
        sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND "); ///����
        sql.append(TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");//�S��
        sql.append(TBTHB2KMEI.YYMM + " = '" + _cond.getYm()  + "'  AND "); //HB2_YYMM
        sql.append(TBTHB2KMEI.JYUTNO + " = " +  TBTHB1DOWN.JYUTNO  + " AND "); //HB2_JYUTNO = HB1_JYUTNO  AND
        sql.append(TBTHB2KMEI.JYMEINO + " = " +  TBTHB1DOWN.JYMEINO  + " AND ");//HB2_JYMEINO = HB1_JYMEINO  AND
        sql.append(TBTHB2KMEI.URMEINO + " = " +  TBTHB1DOWN.URMEINO  + " AND ");//HB2_URMEINO = HB1_URMEINO  AND
        sql.append(TBTHB2KMEI.EGCD + " = " +  TBTHB1DOWN.EGCD  + " AND ");//HB2_EGCD = HB1_EGCD  AND
        sql.append(TBTHB2KMEI.TKSKGYCD + " = " +  TBTHB1DOWN.TKSKGYCD  + " AND ");//HB2_TKSKGYCD = HB1_TKSKGYCD  AND
        sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = " +  TBTHB1DOWN.TKSBMNSEQNO  + " AND ");//HB2_TKSBMNSEQNO = HB1_TKSBMNSEQNO  AND
        sql.append(TBTHB2KMEI.TKSTNTSEQNO + " = " +  TBTHB1DOWN.TKSTNTSEQNO  + " AND ");//HB2_TKSTNTSEQNO = HB1_TKSTNTSEQNO  AND
        sql.append(TBTHB2KMEI.YYMM + " = " +  TBTHB1DOWN.YYMM  + " AND ");//HB2_YYMM = HB1_YYMM  AND
        sql.append(TBTHB1DOWN.TJYUTNO +  " = ' '   ");//HB1_TJYUTNO = ' '
        //�[�i�敪��"1""2"�̏ꍇ�͏����Ƃ���B
        if (_cond.getKbn().equals("1") || _cond.getKbn().equals("2")){
            sql.append(" AND " + TBTHB2KMEI.KBN2 +  " = '" + _cond.getKbn()  + "' ");// AND  HB2_KBN2 = '
        }
        //�[�i�敪���R�͑S�Ă��ΏۂƂ���B
        //if (_cond.getKbn().equals("3")){}
//        else{
//            sql.append(" AND " + TBTHB2KMEI.KBN2 +  " = '" + _cond.getKbn()  + "' ");// AND  HB2_KBN2 = '
//        }
        sql.append("  ORDER BY ");
        //���������}�̏��� 1�F�����@�Q�F�}��
        if (_cond.getKenbaikbn().equals("1")){
            sql.append(TBTHB2KMEI.NAME8 + ", ");//HB2_NAME8,
            sql.append(TBTHB2KMEI.CODE2 + ", ");//HB2_CODE2,
        }
        else{
            sql.append(TBTHB2KMEI.CODE2 + ", ");//HB2_CODE2,
            sql.append(TBTHB2KMEI.NAME8 + ", ");//HB2_NAME8,
        }

        sql.append(" " + TBTHB2KMEI.DATE1 + " ");//HB2_DATE1

        return sql.toString();
    }

    /**
     * ���[�f�[�^�iTOH)�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportTohVO> findReportTohByCondition(ReportTohCondition cond) throws KKHException {

        super.setModel(new ReportTohVO());

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
    protected List<ReportTohVO> createFindedModelInstances(List hashList) {
        List<ReportTohVO> list = new ArrayList<ReportTohVO>();
        if (getModel() instanceof ReportTohVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                ReportTohVO vo = new ReportTohVO();
                vo.setCode1((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
                vo.setDate1((String)result.get(TBTHB2KMEI.DATE1.toUpperCase()));
                vo.setJyMeiNo((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
                vo.setJyutNo((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
                vo.setKbn1((String)result.get(TBTHB2KMEI.KBN1.toUpperCase()));
                vo.setKbn2((String)result.get(TBTHB2KMEI.KBN2.toUpperCase()));
                vo.setKngk1((BigDecimal)result.get(TBTHB2KMEI.KNGK1.toUpperCase()));
                vo.setName2((String)result.get(TBTHB2KMEI.NAME2.toUpperCase()));
                vo.setName8((String)result.get(TBTHB2KMEI.NAME8.toUpperCase()));
                vo.setSeiGak((BigDecimal)result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
                // ����őΉ� 2013/10/09 add HLC H.Watabe start
                vo.setRitu1((BigDecimal)result.get(TBTHB2KMEI.RITU1.toUpperCase()));
                // ����őΉ� 2013/10/09 add HLC H.Watabe end
                vo.setUrMeiNo((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
