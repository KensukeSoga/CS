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
 * ���[�i����_���[�o�́j�f�[�^����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
public class ReportKmnDAO extends AbstractRdbDao {

    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SelSqlMode {
        MEISAI1,MEISAI2,
    };

    private SelSqlMode _SelSqlMode = null;

    /** �f�[�^�������� */
    private ReportKmnCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportKmnDAO() {
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
        return null;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return null;
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {

        return getSelectSQLMeisai();
    }

    /**
     * ���[�i����_���[�o�́j�f�[�^�擾��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    private String getSelectSQLMeisai() {
        StringBuffer sql = new StringBuffer();

        if(_SelSqlMode == SelSqlMode.MEISAI1){

            // ====================================================================================================
            // SELECT��
            // ====================================================================================================
            sql.append(" SELECT");
            sql.append(" " + TBTHB2KMEI.JYUTNO);                                 // ��No
            sql.append("," + TBTHB2KMEI.JYMEINO);                                // �󒍖���No
            sql.append("," + TBTHB2KMEI.URMEINO);                                // ���㖾��No
            sql.append("," + TBTHB2KMEI.YYMM);                                   // �N��
            sql.append("," + TBTHB2KMEI.SEIGAK);                                 // �������z
            sql.append("," + TBTHB2KMEI.CODE1);                                  // �R�[�h1
            sql.append("," + TBTHB2KMEI.CODE2);                                  // �R�[�h2
            sql.append("," + TBTHB2KMEI.NAME1);                                  // ����1
            sql.append("," + TBTHB2KMEI.NAME2);                                  // ����2
            sql.append("," + TBTHB2KMEI.NAME3);                                  // ����3
            sql.append("," + TBTHB2KMEI.NAME4);                                  // ����4
            sql.append("," + TBTHB2KMEI.NAME5);                                  // ����5
            sql.append("," + TBTHB2KMEI.NAME6);                                  // ����6
            sql.append("," + TBTHB2KMEI.NAME7);                                  // ����7
            sql.append("," + TBTHB2KMEI.NAME8);                                  // ����8
            sql.append("," + TBTHB2KMEI.NAME9);                                  // ����9
            sql.append("," + TBTHB2KMEI.NAME11);                                 // ����11
            sql.append("," + TBTHB2KMEI.NAME16);                                 // ����16
            sql.append("," + TBTHB2KMEI.KNGK1);                                  // ���z1
            sql.append("," + TBTHB2KMEI.KNGK2);                                  // ���z2
            sql.append("," + TBTHB2KMEI.KNGK3);                                  // ���z3
            sql.append("," + TBTHB2KMEI.SONOTA2);                                // ���̑�2
            sql.append("," + TBTHB2KMEI.SONOTA3);                                // ���̑�3
            sql.append("," + TBTHB2KMEI.SONOTA4);                                // ���̑�4
            sql.append("," + TBTHB2KMEI.SONOTA5);                                // ���̑�5
            sql.append("," + TBTHB14SKDOWN.JYUTNO);                              // ��No
            sql.append("," + TBTHB1DOWN.JYUTNO);                                 // ��No
            sql.append("," + TBTHB1DOWN.TJYUTNO);                                // �������No
//            sql.append(", '0' AS OYAKOFLG");                                     // �e�q�t���O(0:�e 1:�q)

            // ====================================================================================================
            // FROM��
            // ====================================================================================================
            sql.append(" FROM");
            sql.append(" ( ");
            sql.append(" " + TBTHB2KMEI.TBNAME);
            sql.append(" INNER JOIN");
            sql.append(" " + TBTHB1DOWN.TBNAME);
            sql.append(" ON");
            sql.append("     " + TBTHB2KMEI.EGCD + "        = " + TBTHB1DOWN.EGCD);
            sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "    = " + TBTHB1DOWN.TKSKGYCD);
            sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO);
            sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO);
            sql.append(" AND " + TBTHB2KMEI.YYMM + "        = " + TBTHB1DOWN.YYMM);
            sql.append(" AND " + TBTHB2KMEI.JYUTNO + "      = " + TBTHB1DOWN.JYUTNO);
            sql.append(" AND " + TBTHB2KMEI.JYMEINO + "     = " + TBTHB1DOWN.JYMEINO);
            sql.append(" AND " + TBTHB2KMEI.URMEINO + "     = " + TBTHB1DOWN.URMEINO);
            sql.append(" ) ");
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
          //2013/11/07 add �s��Ή��@�X�e�[�^�X�ǉ� start
            sql.append(" AND " + TBTHB14SKDOWN.SEISTATUS  + " = '2' " );
           //2013/11/07 add �s��Ή��@�X�e�[�^�X�ǉ� end

            // ====================================================================================================
            // WHERE��
            // ====================================================================================================
            sql.append(" WHERE");
            sql.append("     " + TBTHB2KMEI.EGCD + "        = '" + _cond.getEgCd() + "'");
            sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
            sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
            sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
            //sql.append(" AND " + TBTHB2KMEI.YYMM + "        = '" + _cond.getYm() + "'");
            // �������No
            sql.append(" AND " + TBTHB1DOWN.TJYUTNO + " = ' '");

            // �o��No
            if(_cond.getOutputNo().trim().equals("")){

                // �����N��
                sql.append(" AND " + TBTHB2KMEI.NAME6 + "  = '" + _cond.getYm() + "'");
                // ����R�[�h
                if(_cond.getBumon().trim().equals("")){
                }else{
                    sql.append(" AND " + TBTHB2KMEI.CODE1 + " = '" + _cond.getBumon() + "'");
                }

            }else{
                // �o��No
                sql.append(" AND " + TBTHB2KMEI.CODE2 + " = '" + _cond.getOutputNo() + "'");
            }

            // ====================================================================================================
            // ORDER BY��
            // ====================================================================================================
            sql.append("  ORDER BY ");
            sql.append(TBTHB2KMEI.JYUTNO + ", ");
            sql.append(TBTHB2KMEI.JYMEINO + ", ");
            sql.append(TBTHB2KMEI.URMEINO + ", ");
            sql.append(TBTHB2KMEI.RENBN);

        }else if(_SelSqlMode == SelSqlMode.MEISAI2){

            // ====================================================================================================
            // SELECT��
            // ====================================================================================================
            sql.append(" SELECT");
            sql.append(" " + TBTHB14SKDOWN.JYUTNO);                              // ��No
            sql.append("," + TBTHB1DOWN.JYUTNO);                                 // ��No
            sql.append("," + TBTHB1DOWN.TJYUTNO);                                // �������No
//            sql.append(", '1' AS OYAKOFLG");                                     // �e�q�t���O(0:�e 1:�q)

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
          //2013/11/07 add �s��Ή��@�X�e�[�^�X�ǉ� start
            sql.append(" AND " + TBTHB14SKDOWN.SEISTATUS  + " = '2' " );
           //2013/11/07 add �s��Ή��@�X�e�[�^�X�ǉ� end

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
     * ���[�i����_�`�[�j�f�[�^�̌������s���܂��B
     *
     * @return ���[�i����_�`�[�j�f�[�^���܂�VO���X�g
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportKmnVO> findReportKmnByCondition(ReportKmnCondition cond)
            throws KKHException {

        super.setModel(new ReportKmnVO());

        try {
            _SelSqlMode = SelSqlMode.MEISAI1;
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * ���[�i����_�`�[�j�f�[�^�̌������s���܂��B
     *
     * @return ���[�i����_�`�[�j�f�[�^���܂�VO���X�g
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportKmnVO> findReportKmnByCondition2(ReportKmnCondition cond)
            throws KKHException {

        super.setModel(new ReportKmnVO());

        try {
            _SelSqlMode = SelSqlMode.MEISAI2;
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
     * @param hashList
     *            List ��������
     * @return List<ReportUniVO> �ϊ���̌�������
     */
    @Override
    protected List<ReportKmnVO> createFindedModelInstances(List hashList) {
        return getMeisaiList(hashList);
    }

    /**
     * �L����ו\�i�b��E�m��j�f�[�^���擾����
     *
     * @param hashList ��������
     * @return �ϊ���̌�������
     */
    private List<ReportKmnVO> getMeisaiList(List hashList) {

        List<ReportKmnVO> list = new ArrayList<ReportKmnVO>();

        if(_SelSqlMode == SelSqlMode.MEISAI1){

            if (getModel() instanceof ReportKmnVO) {

                for (int i = 0; i < hashList.size(); i++) {

                    Map result = (Map) hashList.get(i);
                    ReportKmnVO vo = new ReportKmnVO();

                    vo.setHb2JyutNo((String) result.get(TBTHB2KMEI.JYUTNO.toUpperCase().trim()));                // ��No
                    vo.setHb2JymeiNo((String) result.get(TBTHB2KMEI.JYMEINO.toUpperCase().trim()));              // �󒍖���No
                    vo.setHb2UrmeiNo((String) result.get(TBTHB2KMEI.URMEINO.toUpperCase().trim()));              // ���㖾��No
                    vo.setHb2Yymm((String) result.get(TBTHB2KMEI.YYMM.toUpperCase().trim()));                    // �N��
                    //--�����N���\�����@�C���Ή� 2013/07/18 HLC H.Watabe start
                    vo.setHb2Name6((String) result.get(TBTHB2KMEI.NAME6.toUpperCase().trim()));                 //�����N��
                    //--�����N���\�����@�C���Ή� 2013/07/18 HLC H.Watabe end
                    vo.setHb2Code1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));                  // �R�[�h1
                    vo.setHb2Code2((String) result.get(TBTHB2KMEI.CODE2.toUpperCase().trim()));                  // �R�[�h2
                    vo.setHb2Name8((String) result.get(TBTHB2KMEI.NAME8.toUpperCase().trim()));                  // ����8
                    vo.setHb2Name3((String) result.get(TBTHB2KMEI.NAME3.toUpperCase().trim()));                  // ����3
                    vo.setHb2Name4((String) result.get(TBTHB2KMEI.NAME4.toUpperCase().trim()));                  // ����4
                    vo.setHb2Name5((String) result.get(TBTHB2KMEI.NAME5.toUpperCase().trim()));                  // ����5
                    vo.setHb2Name16((String) result.get(TBTHB2KMEI.NAME16.toUpperCase().trim()));                  // ����16
                    vo.setHb2Kngk3((BigDecimal) result.get(TBTHB2KMEI.KNGK3.toUpperCase().trim()));              // ���z3
                    vo.setHb2Seigak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase().trim()));            // �������z
                    vo.setHb14JyutNo((String) result.get(TBTHB14SKDOWN.JYUTNO.toUpperCase().trim()));            // ��No
//                    vo.setOyako((String) result.get("OYAKOFLG"));                                                // �e�q�t���O
                    vo.setHb1JyutNo((String) result.get(TBTHB1DOWN.JYUTNO.toUpperCase().trim()));            // ��No
                    vo.setHb1TJyutNo((String) result.get(TBTHB1DOWN.TJYUTNO.toUpperCase().trim()));            // �������No

                    // �������ʒ���̏�Ԃɂ���
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }
        }else if(_SelSqlMode == SelSqlMode.MEISAI2){

            if (getModel() instanceof ReportKmnVO) {

                for (int i = 0; i < hashList.size(); i++) {

                    Map result = (Map) hashList.get(i);
                    ReportKmnVO vo = new ReportKmnVO();

                    vo.setHb14JyutNo((String) result.get(TBTHB14SKDOWN.JYUTNO.toUpperCase().trim()));            // ��No
                    vo.setHb1JyutNo((String) result.get(TBTHB1DOWN.JYUTNO.toUpperCase().trim()));                // ��No
                    vo.setHb1TJyutNo((String) result.get(TBTHB1DOWN.TJYUTNO.toUpperCase().trim()));              // �������No

                    // �������ʒ���̏�Ԃɂ���
                    ModelUtils.copyMemberSearchAfterInstace(vo);
                    list.add(vo);
                }
            }
        }

        return list;
    }

}
