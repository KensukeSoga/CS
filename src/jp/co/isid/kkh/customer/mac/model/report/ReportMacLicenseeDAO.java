package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;
import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractSimpleRdbDao;

/**
 *
 * <P>
 * ���[�iMAC)����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/1/12 fourm h.izawa)<BR>
 * �E2014����Ή�(���C�Z���V�[�ꗗ�\���Ή�)(2014/04/25 HLC S.Fujimoto)<BR>
 * </P>
 * @author fourm h.izawa
 */
public class ReportMacLicenseeDAO extends AbstractSimpleRdbDao {

    /**�ėp�}�X�^�������� */
    private ReportMacCondition _cond;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
//    private enum SqlMode{KIND,ITEM,};
//    private SqlMode _sqlMode = SqlMode.KIND;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportMacLicenseeDAO() {
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
//		return new String[]{
//				TBTHB2KMEI.EGCD,
//				TBTHB2KMEI.TKSKGYCD,
//				TBTHB2KMEI.TKSBMNSEQNO,
//				TBTHB2KMEI.TKSTNTSEQNO,
//				TBTHB2KMEI.YYMM,
//				TBTHB2KMEI.JYUTNO,
//				TBTHB2KMEI.JYMEINO,
//				TBTHB2KMEI.URMEINO,
//				TBTHB2KMEI.RENBN
        return null;
//		};
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
                TBTHB2KMEI.SEIGAK,
                TBTHB2KMEI.CODE1,
                TBTHB2KMEI.NAME1,
                TBTHB2KMEI.NAME2,
                TBTHB2KMEI.NAME3,
                TBTHB2KMEI.KNGK1,
                TBTHB2KMEI.KNGK2,
                TBTHB2KMEI.SONOTA1,
                TBTHB2KMEI.JYUTNO,
                TBTHB2KMEI.JYMEINO,
                TBTHB2KMEI.URMEINO,
                TBTHB2KMEI.RENBN,
                TBTHBAMST.FIELD4,
                TBTHBAMST.FIELD12,
                TBTHBAMST.FIELD5,
                TBTHBAMST.FIELD6,
                TBTHBAMST.FIELD10,
                TBTHBAMST.FIELD11,
                TBTHBAMST.FIELD20,
                TBTHB2KMEI.SONOTA2
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
        //�S���ڂ��擾
        for (int i = 0; i < getTableColumnNames().length; i++){
            if (i == 0){
                sql.append("  " + getTableColumnNames()[i] + " ");
            }else{
                sql.append(" ," + getTableColumnNames()[i] + " ");
            }
        }
        //����őΉ� 2013/10/21 add HLC H.Watabe start
        sql.append(" ,(" + TBTHB2KMEI.RITU1 + " * 0.01) AS "+ TBTHB2KMEI.RITU1 + " ");
        //����őΉ� 2013/10/21 add HLC H.Watabe end
        sql.append(" FROM ");
        sql.append(" " + TBTHB2KMEI.TBNAME + ", ");
        //sql.append(" KV_ADM.THB2KMEI, ");
        sql.append(" " + TBTHBAMST.TBNAME + ", ");
        sql.append(" " + TBTHB1DOWN.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "' ");
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "' ");
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "' ");
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "' ");
        sql.append(" AND ");
        sql.append(TBTHB2KMEI.YYMM + " = '" + _cond.getYm()  + "' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB2KMEI.SONOTA1 + " != " + "' ' ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.JYUTNO + " = " + TBTHB2KMEI.JYUTNO + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.JYMEINO + " = " + TBTHB2KMEI.JYMEINO + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.URMEINO + " = " + TBTHB2KMEI.URMEINO + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.EGCD + " = " + TBTHB2KMEI.EGCD + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.YYMM + " = " + TBTHB2KMEI.YYMM + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHB1DOWN.TJYUTNO + " = ' ' " );
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSKGYCD + " = " + TBTHB2KMEI.TKSKGYCD + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSBMNSEQNO + " = " + TBTHB2KMEI.TKSBMNSEQNO + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.TKSTNTSEQNO + " = " + TBTHB2KMEI.TKSTNTSEQNO + " ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.SYBT + " = '301' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.FIELD9 + " = '2' ");
        sql.append(" AND ");
        sql.append(" " + TBTHBAMST.FIELD1 + " = RTRIM(" + TBTHB2KMEI.CODE1+ ") ");
        //�`�[�ԍ��̂ǂ�����������Ȃ��ꍇ�͑S������
        if (_cond.getdenfr().equals("") && _cond.getdento().equals(""))
        {}
        //TO�������AFROM������ꍇ
        else if (_cond.getdento().equals("")){
            sql.append(" AND " + TBTHB2KMEI.SONOTA1 + " >= '" + _cond.getdenfr()  + "' ");
        }
        //TO�������AFROM������ꍇ
        else if (_cond.getdenfr().equals("")){
            sql.append(" AND " +  TBTHB2KMEI.SONOTA1 + " <= '" + _cond.getdento()  + "' ");
        }
        //TO�AFROM�ɗ����Ƃ��l������ꍇ
        else {
            sql.append(" AND " + TBTHB2KMEI.SONOTA1 + " BETWEEN '" + _cond.getdenfr()  + "' ");
            sql.append(" AND " + "'" + _cond.getdento()  + "' ");
        }
        sql.append(" ORDER BY ");
        sql.append(TBTHBAMST.FIELD12 + ",");
        sql.append(TBTHB2KMEI.CODE1);

        /* 2014/04/25 ���C�Z���V�[�ꗗ�\���Ή� fujimoto ADD start */
        sql.append(", " + TBTHB2KMEI.SONOTA1);
        sql.append("," + TBTHB2KMEI.JYUTNO);
        sql.append(", " + TBTHB2KMEI.JYMEINO);
        sql.append("," + TBTHB2KMEI.URMEINO);
        /* 2014/04/25 ���C�Z���V�[�ꗗ�\���Ή� fujimoto ADD end */

        return sql.toString();
    }


    /**
     * ���[�f�[�^�iMAC)�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportMacLicenseeVO> findReportMacByCondition(ReportMacCondition cond) throws KKHException {

        super.setModel(new ReportMacLicenseeVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }

    }


//    /**
//     * Model�̐������s��<br>
//     * �������ʂ�VO��KEY���啶���̂��ߕϊ��������s��<br>
//     * AbstractRdbDao��createFindedModelInstances���I�[�o�[���C�h<br>
//     *
//     * @param hashList List ��������
//     * @return List<CommonCodeMasterVO> �ϊ���̌�������
//     */
//    @Override
//    @SuppressWarnings("unchecked")
//    protected List<ReportMacVO> createFindedModelInstances(List hashList) {
//        List<ReportMacVO> list = new ArrayList<ReportMacVO>();
//        if (getModel() instanceof ReportMacVO) {
//            for (int i = 0; i < hashList.size(); i++) {
//                Map result = (Map) hashList.get(i);
//                ReportMacVO vo = new ReportMacVO();
//                vo.setSeiGak((BigDecimal)result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
//                vo.setDate1((String)result.get(TBTHB2KMEI.DATE1.toUpperCase()));
//                vo.setKbn1((String)result.get(TBTHB2KMEI.KBN1.toUpperCase()));
//                vo.setCode1((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
//                vo.setCode2((String)result.get(TBTHB2KMEI.CODE2.toUpperCase()));
//                vo.setCode4((String)result.get(TBTHB2KMEI.CODE4.toUpperCase()));
//                vo.setName1((String)result.get(TBTHB2KMEI.NAME1.toUpperCase()));
//                vo.setName2((String)result.get(TBTHB2KMEI.NAME2.toUpperCase()));
//                vo.setName3((String)result.get(TBTHB2KMEI.NAME3.toUpperCase()));
//                vo.setKngk1((BigDecimal)result.get(TBTHB2KMEI.KNGK1.toUpperCase()));
//                vo.setKngk2((BigDecimal)result.get(TBTHB2KMEI.KNGK2.toUpperCase()));
//                vo.setSonota1((String)result.get(TBTHB2KMEI.SONOTA1.toUpperCase()));
//                vo.setJyutNo((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
//                vo.setJyMeiNo((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
//                vo.setUrMeiNo((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));
//                vo.setRenbn((String)result.get(TBTHB2KMEI.RENBN.toUpperCase()));
//                vo.setSonota2((String)result.get(TBTHB2KMEI.SONOTA2.toUpperCase()));
//                // �������ʒ���̏�Ԃɂ���
//                ModelUtils.copyMemberSearchAfterInstace(vo);
//                list.add(vo);
//            }
//        }
//        return list;
//    }

}
