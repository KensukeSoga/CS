package jp.co.isid.kkh.customer.kmn.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB14SKDOWN;
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
 * ���[�i����_�����ꗗ�j�f�[�^����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/1/31 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class ReportKmnListDAO extends AbstractRdbDao {

    /**���[�i����_�����ꗗ�j�������� */
    private ReportKmnListCondition _cond;

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SqlMode{MEISAI1,MEISAI2,MEISAI3};
    private SqlMode _sqlMode = null;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportKmnListDAO() {
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

        if(_sqlMode == SqlMode.MEISAI1){

            sql.append(" SELECT ");
            sql.append("  " + TBTHB2KMEI.CODE2 + " ");
            sql.append(" ," + TBTHB2KMEI.CODE3 + " ");
            sql.append(" ," + TBTHB2KMEI.JYUTNO + " ");
            sql.append(" ," + TBTHB2KMEI.JYMEINO + " ");
            sql.append(" ," + TBTHB2KMEI.URMEINO + " ");
            sql.append(" ," + TBTHB2KMEI.RENBN + " ");
            sql.append(" ," + TBTHB2KMEI.NAME11 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME12 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME13 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME14 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME1 + " ");
            sql.append(" ," + TBTHB2KMEI.CODE1 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME5 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME2 + " ");
            sql.append(" ," + TBTHB2KMEI.KNGK1 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME15 + " ");
            sql.append(" ,(SELECT ");
            sql.append(" COUNT(" + TBTHB1DOWN.JYUTNO + ") FROM " + TBTHB14SKDOWN.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHB1DOWN.JYUTNO + " = " +  TBTHB14SKDOWN.JYUTNO  + " AND ");
            sql.append(TBTHB1DOWN.JYMEINO + " = " +  TBTHB14SKDOWN.JYMEINO  + " AND ");
            sql.append(TBTHB1DOWN.URMEINO + " = " +  TBTHB14SKDOWN.URMEINO  + " AND ");
            sql.append(TBTHB1DOWN.EGCD + " = " +  TBTHB14SKDOWN.EGCD  + " AND ");
            sql.append(TBTHB1DOWN.TKSKGYCD + " = " +  TBTHB14SKDOWN.TKSKGYCD  + " AND ");
            sql.append(TBTHB1DOWN.TKSBMNSEQNO + " = " +  TBTHB14SKDOWN.TKSBMNSEQNO  + " AND ");
            sql.append(TBTHB1DOWN.TKSTNTSEQNO + " = " +  TBTHB14SKDOWN.TKSTNTSEQNO  + " AND ");
            sql.append(TBTHB1DOWN.YYMM + " = " +  TBTHB14SKDOWN.SEIYYMM );
          //2013/11/07 add �s��Ή��@�X�e�[�^�X�ǉ� start
            sql.append(" AND " + TBTHB14SKDOWN.SEISTATUS  + " = '2' " );
           //2013/11/07 add �s��Ή��@�X�e�[�^�X�ǉ� end
            sql.append(" ) AS SKDOWN_CNT ");
            sql.append(" FROM ");
            sql.append("  " + TBTHB2KMEI.TBNAME + " ");
            sql.append(" ," + TBTHB1DOWN.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            //�����N��
            sql.append(TBTHB2KMEI.NAME6 + " = '" + _cond.getYm()  + "'  AND ");
            sql.append(TBTHB2KMEI.JYUTNO + " = " +  TBTHB1DOWN.JYUTNO  + " AND ");
            sql.append(TBTHB2KMEI.JYMEINO + " = " +  TBTHB1DOWN.JYMEINO  + " AND ");
            sql.append(TBTHB2KMEI.URMEINO + " = " +  TBTHB1DOWN.URMEINO  + " AND ");
            sql.append(TBTHB2KMEI.EGCD + " = " +  TBTHB1DOWN.EGCD  + " AND ");
            sql.append(TBTHB2KMEI.TKSKGYCD + " = " +  TBTHB1DOWN.TKSKGYCD  + " AND ");
            sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = " +  TBTHB1DOWN.TKSBMNSEQNO  + " AND ");
            sql.append(TBTHB2KMEI.TKSTNTSEQNO + " = " +  TBTHB1DOWN.TKSTNTSEQNO  + " AND ");
            sql.append(TBTHB2KMEI.YYMM + " = " +  TBTHB1DOWN.YYMM  + " AND ");
            sql.append(TBTHB1DOWN.TJYUTNO +  " = ' '   ");
            //�����R�[�h���w�肳��Ă����ꍇ
            if(!_cond.getBumonCd().equals("")){
                sql.append(" AND ");
                sql.append(TBTHB2KMEI.CODE1 + " = '" + _cond.getBumonCd()  + "' ");
            }
            sql.append("  ORDER BY ");
            sql.append(TBTHB2KMEI.JYUTNO + ", ");
            sql.append(TBTHB2KMEI.JYMEINO + ", ");
            sql.append(TBTHB2KMEI.URMEINO + ", ");
            sql.append(TBTHB2KMEI.RENBN);

        }else if(_sqlMode == SqlMode.MEISAI2){

            sql.append(" SELECT ");
            sql.append("  " + TBTHB2KMEI.CODE2 + " ");
            sql.append(" ," + TBTHB2KMEI.CODE3 + " ");
            sql.append(" ," + TBTHB2KMEI.JYUTNO + " ");
            sql.append(" ," + TBTHB2KMEI.JYMEINO + " ");
            sql.append(" ," + TBTHB2KMEI.URMEINO + " ");
            sql.append(" ," + TBTHB2KMEI.RENBN + " ");
            sql.append(" ," + TBTHB2KMEI.NAME8 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME3 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME4 + " ");
//            sql.append(" ," + TBTHB2KMEI.NAME11 + " ");
//            sql.append(" ," + TBTHB2KMEI.NAME12 + " ");
//            sql.append(" ," + TBTHB2KMEI.NAME13 + " ");
//            sql.append(" ," + TBTHB2KMEI.NAME14 + " ");
//            sql.append(" ," + TBTHB2KMEI.NAME1 + " ");
            sql.append(" ," + TBTHB2KMEI.CODE1 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME5 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME9 + " ");
            sql.append(" ," + TBTHB2KMEI.NAME10 + " ");
            sql.append(" ," + TBTHB2KMEI.SEIGAK + " ");
//            sql.append(" ," + TBTHB2KMEI.NAME2 + " ");
//            sql.append(" ," + TBTHB2KMEI.KNGK1 + " ");
//            sql.append(" ," + TBTHB2KMEI.NAME15 + " ");
            sql.append(" ,(SELECT ");
            sql.append(" COUNT(" + TBTHB1DOWN.JYUTNO + ") FROM " + TBTHB14SKDOWN.TBNAME);
            sql.append(" WHERE ");
            sql.append(TBTHB1DOWN.JYUTNO + " = " +  TBTHB14SKDOWN.JYUTNO  + " AND ");
            sql.append(TBTHB1DOWN.JYMEINO + " = " +  TBTHB14SKDOWN.JYMEINO  + " AND ");
            sql.append(TBTHB1DOWN.URMEINO + " = " +  TBTHB14SKDOWN.URMEINO  + " AND ");
            sql.append(TBTHB1DOWN.EGCD + " = " +  TBTHB14SKDOWN.EGCD  + " AND ");
            sql.append(TBTHB1DOWN.TKSKGYCD + " = " +  TBTHB14SKDOWN.TKSKGYCD  + " AND ");
            sql.append(TBTHB1DOWN.TKSBMNSEQNO + " = " +  TBTHB14SKDOWN.TKSBMNSEQNO  + " AND ");
            sql.append(TBTHB1DOWN.TKSTNTSEQNO + " = " +  TBTHB14SKDOWN.TKSTNTSEQNO  + " AND ");
            sql.append(TBTHB1DOWN.YYMM + " = " +  TBTHB14SKDOWN.SEIYYMM );
          //2013/11/07 add �s��Ή��@�X�e�[�^�X�ǉ� start
            sql.append(" AND " + TBTHB14SKDOWN.SEISTATUS  + " = '2' " );
           //2013/11/07 add �s��Ή��@�X�e�[�^�X�ǉ� end
            sql.append(" ) AS SKDOWN_CNT ");
            sql.append(" FROM ");
            sql.append("  " + TBTHB2KMEI.TBNAME + " ");
            sql.append(" ," + TBTHB1DOWN.TBNAME + " ");
            sql.append(" WHERE ");
            sql.append(TBTHB2KMEI.EGCD + " = '" + _cond.getEgCd()  + "'  AND ");
            sql.append(TBTHB2KMEI.TKSKGYCD + " = '" + _cond.getTksKgyCd()  + "'  AND ");
            sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo()  + "'  AND ");
            sql.append(TBTHB2KMEI.TKSTNTSEQNO  + " = '" + _cond.getTksTntSeqNo()  + "'  AND ");
            //�����N��
            sql.append(TBTHB2KMEI.NAME6 + " = '" + _cond.getYm()  + "'  AND ");
            sql.append(TBTHB2KMEI.JYUTNO + " = " +  TBTHB1DOWN.JYUTNO  + " AND ");
            sql.append(TBTHB2KMEI.JYMEINO + " = " +  TBTHB1DOWN.JYMEINO  + " AND ");
            sql.append(TBTHB2KMEI.URMEINO + " = " +  TBTHB1DOWN.URMEINO  + " AND ");
            sql.append(TBTHB2KMEI.EGCD + " = " +  TBTHB1DOWN.EGCD  + " AND ");
            sql.append(TBTHB2KMEI.TKSKGYCD + " = " +  TBTHB1DOWN.TKSKGYCD  + " AND ");
            sql.append(TBTHB2KMEI.TKSBMNSEQNO + " = " +  TBTHB1DOWN.TKSBMNSEQNO  + " AND ");
            sql.append(TBTHB2KMEI.TKSTNTSEQNO + " = " +  TBTHB1DOWN.TKSTNTSEQNO  + " AND ");
            sql.append(TBTHB2KMEI.YYMM + " = " +  TBTHB1DOWN.YYMM  + " AND ");
            sql.append(TBTHB1DOWN.TJYUTNO +  " = ' '   ");
            //�����R�[�h���w�肳��Ă����ꍇ
            if(!_cond.getBumonCd().equals("")){
                sql.append(" AND ");
                sql.append(TBTHB2KMEI.CODE1 + " = '" + _cond.getBumonCd()  + "' ");
            }
            sql.append("  ORDER BY ");
            sql.append(TBTHB2KMEI.JYUTNO + ", ");
            sql.append(TBTHB2KMEI.JYMEINO + ", ");
            sql.append(TBTHB2KMEI.URMEINO + ", ");
            sql.append(TBTHB2KMEI.RENBN);

        }else if(_sqlMode == SqlMode.MEISAI3){

         // ====================================================================================================
            // SELECT��
            // ====================================================================================================
            sql.append(" SELECT");
            sql.append(" " + TBTHB14SKDOWN.JYUTNO);                              // ��No
            sql.append("," + TBTHB1DOWN.JYUTNO);                                 // ��No
            sql.append("," + TBTHB1DOWN.TJYUTNO);                                // �������No

            // ====================================================================================================
            // FROM��
            // ====================================================================================================
            sql.append(" FROM");
            sql.append(" " + TBTHB1DOWN.TBNAME);
            sql.append(" LEFT OUTER JOIN");
            sql.append(" " + TBTHB14SKDOWN.TBNAME);
            sql.append(" ON");
            sql.append("     " + TBTHB1DOWN.EGCD + "        = " + TBTHB14SKDOWN.EGCD);
            sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + "    = " + TBTHB14SKDOWN.TKSKGYCD);
            sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = " + TBTHB14SKDOWN.TKSBMNSEQNO);
            sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = " + TBTHB14SKDOWN.TKSTNTSEQNO);
            sql.append(" AND " + TBTHB1DOWN.YYMM + "        = " + TBTHB14SKDOWN.SEIYYMM);
            sql.append(" AND " + TBTHB1DOWN.JYUTNO + "      = " + TBTHB14SKDOWN.JYUTNO);
            sql.append(" AND " + TBTHB1DOWN.JYMEINO + "     = " + TBTHB14SKDOWN.JYMEINO);
            sql.append(" AND " + TBTHB1DOWN.URMEINO + "     = " + TBTHB14SKDOWN.URMEINO);

            // ====================================================================================================
            // WHERE��
            // ====================================================================================================
            sql.append(" WHERE");
            sql.append("     " + TBTHB1DOWN.EGCD + "        = '" + _cond.getEgCd() + "'");
            sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
            sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
            sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
            //sql.append(" AND " + TBTHB2KMEI.YYMM + "        = '" + _cond.getYm() + "'");
            // �������No
            sql.append(" AND " + TBTHB1DOWN.TJYUTNO + " != ' '");

            // ====================================================================================================
            // ORDER BY��
            // ====================================================================================================
            sql.append("  ORDER BY ");
            sql.append(TBTHB1DOWN.JYUTNO );
        }

        return sql.toString();
    }

    /**
     * ���[�i����_�����ꗗ�j�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportKmnListVO> findReportKmnListByCondition(ReportKmnListCondition cond) throws KKHException {

        super.setModel(new ReportKmnListVO());

        try {
            if(cond.getOutput().equals("����")){
                _sqlMode = SqlMode.MEISAI1;
                _cond = cond;
                return super.find();
            }else{
                _sqlMode = SqlMode.MEISAI2;
                _cond = cond;
                return super.find();
            }
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * ���[�i����_�����ꗗ�j�̌������s���܂��B
     *
     * @return �ėp�e�[�u���}�X�^VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportKmnListVO> findReportKmnListByCondition2(ReportKmnListCondition cond) throws KKHException {

        super.setModel(new ReportKmnListVO());

        try {
            _sqlMode = SqlMode.MEISAI3;
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
    protected List<ReportKmnListVO> createFindedModelInstances(List hashList) {
        List<ReportKmnListVO> list = new ArrayList<ReportKmnListVO>();
        if (getModel() instanceof ReportKmnListVO) {

            if(_sqlMode == SqlMode.MEISAI1){

                for (int i = 0; i < hashList.size(); i++) {
                    Map result = (Map) hashList.get(i);
                    ReportKmnListVO vo = new ReportKmnListVO();
                    vo.setShutNo((String)result.get(TBTHB2KMEI.CODE2.toUpperCase()));
                    vo.setSeqNo((String)result.get(TBTHB2KMEI.CODE3.toUpperCase()));
                    vo.setJyutNo((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
                    vo.setJyMeiNo((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
                    vo.setUrMeiNo((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));
                    vo.setRenban((String)result.get(TBTHB2KMEI.RENBN.toUpperCase()));
                    vo.setNaiyo((String)result.get(TBTHB2KMEI.NAME11.toUpperCase()) +
                            (String)result.get(TBTHB2KMEI.NAME12.toUpperCase()) +
                            (String)result.get(TBTHB2KMEI.NAME13.toUpperCase()) +
                            (String)result.get(TBTHB2KMEI.NAME14.toUpperCase()));
                    vo.setHimoku((String)result.get(TBTHB2KMEI.NAME1.toUpperCase()));
                    vo.setBumonCd((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
                    vo.setBumonNm((String)result.get(TBTHB2KMEI.NAME5.toUpperCase()));
                    vo.setKikan((String)result.get(TBTHB2KMEI.NAME2.toUpperCase()));
                    vo.setKingaku((BigDecimal)result.get(TBTHB2KMEI.KNGK1.toUpperCase()));
                    vo.setBiko((String)result.get(TBTHB2KMEI.NAME15.toUpperCase()));

                    BigDecimal cnt = (BigDecimal)result.get("SKDOWN_CNT");

                    // �����ς݃X�e�[�^�X�̐ݒ�
                    if(cnt.compareTo(BigDecimal.ZERO) == 0){

                        // �u�����N��ݒ肷��
                        vo.setSeiZumi("");

                    }else{

                        // �ς�ݒ肷��
                        vo.setSeiZumi("��");
                    }

                    // �������ʒ���̏�Ԃɂ���
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }

            }else if(_sqlMode == SqlMode.MEISAI2){

                for (int i = 0; i < hashList.size(); i++) {
                    Map result = (Map) hashList.get(i);
                    ReportKmnListVO vo = new ReportKmnListVO();
                    vo.setShutNo((String)result.get(TBTHB2KMEI.CODE2.toUpperCase()));
                    vo.setSeqNo((String)result.get(TBTHB2KMEI.CODE3.toUpperCase()));
                    vo.setJyutNo((String)result.get(TBTHB2KMEI.JYUTNO.toUpperCase()));
                    vo.setJyMeiNo((String)result.get(TBTHB2KMEI.JYMEINO.toUpperCase()));
                    vo.setUrMeiNo((String)result.get(TBTHB2KMEI.URMEINO.toUpperCase()));
                    vo.setRenban((String)result.get(TBTHB2KMEI.RENBN.toUpperCase()));
                    vo.setNaiyo((String)result.get(TBTHB2KMEI.NAME8.toUpperCase()) +
                                (String)result.get(TBTHB2KMEI.NAME3.toUpperCase()) +
                                (String)result.get(TBTHB2KMEI.NAME4.toUpperCase()));
                    vo.setHimoku((String)result.get(TBTHB2KMEI.NAME9.toUpperCase()));
                    vo.setBumonCd((String)result.get(TBTHB2KMEI.CODE1.toUpperCase()));
                    vo.setBumonNm((String)result.get(TBTHB2KMEI.NAME5.toUpperCase()));
                    vo.setKikan((String)result.get(TBTHB2KMEI.NAME10.toUpperCase()));
                    vo.setKingaku((BigDecimal)result.get(TBTHB2KMEI.SEIGAK.toUpperCase()));
                    vo.setBiko((String)result.get(TBTHB2KMEI.NAME15.toUpperCase()));

                    BigDecimal cnt = (BigDecimal)result.get("SKDOWN_CNT");
                    vo.setSeiZumi(cnt.toString());


                    // �����ς݃X�e�[�^�X�̐ݒ�
//                    if(cnt.compareTo(BigDecimal.ZERO) == 0){
//
//                        // �u�����N��ݒ肷��
//                        vo.setSeiZumi("");
//
//                    }else{
//
//                        // �ς�ݒ肷��
//                        vo.setSeiZumi("��");
//                    }

                    // �������ʒ���̏�Ԃɂ���
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }

            else if(_sqlMode == SqlMode.MEISAI3){

                for (int i = 0; i < hashList.size(); i++) {
                    Map result = (Map) hashList.get(i);
                    ReportKmnListVO vo = new ReportKmnListVO();

                    vo.setSkJyutNo((String) result.get(TBTHB14SKDOWN.JYUTNO.toUpperCase().trim()));            // ��No
                    vo.setDJyutNo((String) result.get(TBTHB1DOWN.JYUTNO.toUpperCase().trim()));                // ��No
                    vo.setDTJyutNo((String) result.get(TBTHB1DOWN.TJYUTNO.toUpperCase().trim()));              // �������No

                    // �������ʒ���̏�Ԃɂ���
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }
        }

        return list;
    }

}
