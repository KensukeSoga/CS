package jp.co.isid.kkh.customer.uni.model.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.constants.KKHConstants.GyomKbn;
import jp.co.isid.kkh.util.constants.KKHConstants.Shubetsu;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * ���[�i���j�`���[��_�L����ו\�j�f�[�^����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/23 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class ReportUniDAO extends AbstractRdbDao {


    /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SelSqlMode {
        MEISAI1,MEISAI2,
    };

    private SelSqlMode _SelSqlMode = null;

    /** ��ʕ\���� (�e���r�ԑg) */
    static final String IDX_TV_BANGUMI = "1";
    /** ��ʕ\���� (�e���r����) */
    static final String IDX_TV_TOKUBAN = "2";
    /** ��ʕ\���� (�e���r�X�|�b�g) */
    static final String IDX_TV_SPOT = "3";
    /** ��ʕ\���� (�G��) */
    static final String IDX_ZASHI = "4";
    /** ��ʕ\���� (�V��) */
    static final String IDX_SHINBUN = "5";
    /** ��ʕ\���� (���̑�) */
    static final String IDX_SONOTA = "6";
    /** ��ʕ\���� (����) */
    static final String IDX_SEISAKU = "7";

    /** �f�[�^�������� */
    private ReportUniCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ReportUniDAO() {
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
     * ���[�i���j�`���[��_�L����ו\�j�f�[�^�擾��SQL����Ԃ��܂��B
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
            sql.append(" CASE ");
            // ��ʕ\����
            sql.append(TBTHB2KMEI.CODE1);
            sql.append(" WHEN '" + Shubetsu.TV_BANGUMI.getCode() + "' THEN 1");  // �e���r�ԑg
            sql.append(" WHEN '" + Shubetsu.TV_TOKUBAN.getCode() + "' THEN 2");  // �e���r����
            sql.append(" WHEN '" + Shubetsu.TV_SPOT.getCode() + "'    THEN 3");  // �e���r�X�|�b�g
            sql.append(" WHEN '" + Shubetsu.ZASHI.getCode() + "'      THEN 4");  // �G��
            sql.append(" WHEN '" + Shubetsu.SHINBUN.getCode() + "'    THEN 5");  // �V��
            sql.append(" WHEN '" + Shubetsu.SEISAKU.getCode() + "'    THEN 7");  // ����
            sql.append(" ELSE 6");                                               // ���̑�
            sql.append(" END AS SHOWNUM");                                       // �\����
            // ���̑�
            sql.append("," + TBTHB1DOWN.GPYNO);                                  // �������[No
            sql.append("," + TBTHB1DOWN.SEIGAK);                                 // �������z
            sql.append("," + TBTHB1DOWN.SZEIGAK);                                // ����Ŋz
            sql.append("," + TBTHB1DOWN.JYUTNO);                                 // ��No
            sql.append("," + TBTHB1DOWN.JYMEINO);                                // �󒍖���No
            sql.append("," + TBTHB1DOWN.URMEINO);                                // ���㖾��No
            sql.append("," + TBTHB1DOWN.GYOMKBN);                                // �Ɩ��敪
            sql.append("," + TBTHB1DOWN.SEIKBN);                                 // �����敪
            sql.append("," + TBTHB1DOWN.KKNAMEKJ);                               // ����(����)
            sql.append("," + TBTHB1DOWN.HIMKNMKJ);                               // ��ږ�(����)
            sql.append("," + TBTHB1DOWN.SEITNKA);                                // �����P��
            // 2013/01/09 JSE M.Naito add start
            sql.append("," + TBTHB1DOWN.TOUFLG);                                 // �����t���O
            sql.append("," + TBTHB1DOWN.TJYUTNO);                                // �������No
            // 2013/01/09 JSE M.Naito add end
            sql.append("," + TBTHB1DOWN.FIELD1);                                 // �t�B�[���h�P
            sql.append("," + TBTHB1DOWN.FIELD2);                                 // �t�B�[���h�Q
            sql.append("," + TBTHB1DOWN.FIELD3);                                 // �t�B�[���h�R
            sql.append("," + TBTHB1DOWN.FIELD4);                                 // �t�B�[���h�S
            sql.append("," + TBTHB1DOWN.FIELD5);                                 // �t�B�[���h�T
            sql.append("," + TBTHB1DOWN.FIELD6);                                 // �t�B�[���h�U
            sql.append("," + TBTHB1DOWN.FIELD7);                                 // �t�B�[���h�V
            sql.append("," + TBTHB1DOWN.FIELD8);                                 // �t�B�[���h�W
            sql.append("," + TBTHB1DOWN.FIELD9);                                 // �t�B�[���h�X
            sql.append("," + TBTHB1DOWN.FIELD10);                                // �t�B�[���h�P�O
            sql.append("," + TBTHB1DOWN.FIELD11);                                // �t�B�[���h�P�P
            sql.append("," + TBTHB1DOWN.FIELD12);                                // �t�B�[���h�P�Q
            sql.append("," + TBTHB2KMEI.JYUTNO);                                 // ��No
            sql.append("," + TBTHB2KMEI.JYMEINO);                                // �󒍖���No
            sql.append("," + TBTHB2KMEI.URMEINO);                                // ���㖾��No
            sql.append("," + TBTHB2KMEI.SEIGAK);                                 // �������z
            sql.append("," + TBTHB2KMEI.CODE1);                                  // �R�[�h1(��ʃR�[�h)
            sql.append("," + TBTHB2KMEI.NAME1);                                  // ����1(���)
            sql.append("," + TBTHB2KMEI.NAME2);                                  // ����2
            sql.append("," + TBTHB2KMEI.NAME3);                                  // ����3
            sql.append("," + TBTHB2KMEI.NAME4);                                  // ����4
            sql.append("," + TBTHB2KMEI.NAME6);                                  // ����6
            sql.append("," + TBTHB2KMEI.NAME7);                                  // ����7
            sql.append("," + TBTHB2KMEI.NAME9);                                  // ����9
            sql.append("," + TBTHB2KMEI.NAME11);                                  // ����11
            sql.append("," + TBTHB2KMEI.KNGK1);                                  // ���z1
            sql.append("," + TBTHB2KMEI.KNGK2);                                  // ���z2
            sql.append("," + TBTHB2KMEI.SONOTA2);                                // ���̑�2
            sql.append("," + TBTHB2KMEI.SONOTA3);                                // ���̑�3
            sql.append("," + TBTHB2KMEI.SONOTA4);                                // ���̑�4
            sql.append("," + TBTHB2KMEI.SONOTA5);                                // ���̑�5

            // ====================================================================================================
            // FROM��
            // ====================================================================================================
            sql.append(" FROM");
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

            // ====================================================================================================
            // WHERE��
            // ====================================================================================================
            sql.append(" WHERE");
            sql.append("     " + TBTHB2KMEI.EGCD + "        = '" + _cond.getEgCd() + "'");
            sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
            sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
            sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
            sql.append(" AND " + TBTHB2KMEI.YYMM + "        = '" + _cond.getYm() + "'");
            if(_cond.getBusho().trim().equals("")){
            }else{
                sql.append(" AND " + TBTHB2KMEI.NAME11 + "      = '" + _cond.getBusho() + "'");
            }
            // 2013/01/09 JSE M.Naito add
            // �������No
            sql.append(" AND " + TBTHB1DOWN.TJYUTNO + " = ' '");

            // ====================================================================================================
            // ORDER BY��
            // ====================================================================================================
            sql.append(" ORDER BY");
            sql.append("     SHOWNUM");                                          // �\����
            sql.append(",CAST(RTRIM(" + TBTHB2KMEI.SONOTA3 + ") AS INT)");       // �\�[�g�ԍ�
            sql.append("," + TBTHB1DOWN.GPYNO);                                  // �������[No
            sql.append("," + TBTHB2KMEI.SONOTA2);                                // �������[�s�ԍ��i1���j

        }

        else if (_SelSqlMode == SelSqlMode.MEISAI2) {

            sql.append(" SELECT");
//            sql.append(" CASE ");
            // ��ʕ\����
//            sql.append(TBTHB2KMEI.CODE1);
//            sql.append(" WHEN '" + Shubetsu.TV_BANGUMI.getCode() + "' THEN 1");  // �e���r�ԑg
//            sql.append(" WHEN '" + Shubetsu.TV_TOKUBAN.getCode() + "' THEN 2");  // �e���r����
//            sql.append(" WHEN '" + Shubetsu.TV_SPOT.getCode() + "'    THEN 3");  // �e���r�X�|�b�g
//            sql.append(" WHEN '" + Shubetsu.ZASHI.getCode() + "'      THEN 4");  // �G��
//            sql.append(" WHEN '" + Shubetsu.SHINBUN.getCode() + "'    THEN 5");  // �V��
//            sql.append(" WHEN '" + Shubetsu.SEISAKU.getCode() + "'    THEN 7");  // ����
//            sql.append(" ELSE 6");                                               // ���̑�
//            sql.append(" END AS SHOWNUM");                                       // �\����
            // ���̑�
//            sql.append("," + TBTHB1DOWN.GPYNO);                                  // �������[No
            sql.append(" " + TBTHB1DOWN.GPYNO);                                  // �������[No
            sql.append("," + TBTHB1DOWN.SEIGAK);                                 // �������z
            sql.append("," + TBTHB1DOWN.SZEIGAK);                                // ����Ŋz
            sql.append("," + TBTHB1DOWN.JYUTNO);                                 // ��No
            sql.append("," + TBTHB1DOWN.JYMEINO);                                // �󒍖���No
            sql.append("," + TBTHB1DOWN.URMEINO);                                // ���㖾��No
            sql.append("," + TBTHB1DOWN.GYOMKBN);                                // �Ɩ��敪
            sql.append("," + TBTHB1DOWN.SEIKBN);                                 // �����敪
            sql.append("," + TBTHB1DOWN.KKNAMEKJ);                               // ����(����)
            sql.append("," + TBTHB1DOWN.HIMKNMKJ);                               // ��ږ�(����)
            sql.append("," + TBTHB1DOWN.SEITNKA);                                // �����P��
            // 2013/01/09 JSE M.Naito add start
            sql.append("," + TBTHB1DOWN.TOUFLG);                                 // �����t���O
            sql.append("," + TBTHB1DOWN.TJYUTNO);                                // �������No
            sql.append("," + TBTHB1DOWN.TJYMEINO);                                // ������󒍖���No
            sql.append("," + TBTHB1DOWN.TURMEINO);                                // �����攄�㖾��No
            // 2013/01/09 JSE M.Naito add end
            sql.append("," + TBTHB1DOWN.FIELD1);                                 // �t�B�[���h�P
            sql.append("," + TBTHB1DOWN.FIELD2);                                 // �t�B�[���h�Q
            sql.append("," + TBTHB1DOWN.FIELD3);                                 // �t�B�[���h�R
            sql.append("," + TBTHB1DOWN.FIELD4);                                 // �t�B�[���h�S
            sql.append("," + TBTHB1DOWN.FIELD5);                                 // �t�B�[���h�T
            sql.append("," + TBTHB1DOWN.FIELD6);                                 // �t�B�[���h�U
            sql.append("," + TBTHB1DOWN.FIELD7);                                 // �t�B�[���h�V
            sql.append("," + TBTHB1DOWN.FIELD8);                                 // �t�B�[���h�W
            sql.append("," + TBTHB1DOWN.FIELD9);                                 // �t�B�[���h�X
            sql.append("," + TBTHB1DOWN.FIELD10);                                // �t�B�[���h�P�O
            sql.append("," + TBTHB1DOWN.FIELD11);                                // �t�B�[���h�P�P
            sql.append("," + TBTHB1DOWN.FIELD12);                                // �t�B�[���h�P�Q
//            sql.append("," + TBTHB2KMEI.JYUTNO);                                 // ��No
//            sql.append("," + TBTHB2KMEI.JYMEINO);                                // �󒍖���No
//            sql.append("," + TBTHB2KMEI.URMEINO);                                // ���㖾��No
//            sql.append("," + TBTHB2KMEI.SEIGAK);                                 // �������z
//            sql.append("," + TBTHB2KMEI.CODE1);                                  // �R�[�h1(��ʃR�[�h)
//            sql.append("," + TBTHB2KMEI.NAME1);                                  // ����1(���)
//            sql.append("," + TBTHB2KMEI.NAME2);                                  // ����2
//            sql.append("," + TBTHB2KMEI.NAME3);                                  // ����3
//            sql.append("," + TBTHB2KMEI.NAME4);                                  // ����4
//            sql.append("," + TBTHB2KMEI.NAME6);                                  // ����6
//            sql.append("," + TBTHB2KMEI.NAME7);                                  // ����7
//            sql.append("," + TBTHB2KMEI.NAME9);                                  // ����9
//            sql.append("," + TBTHB2KMEI.NAME11);                                  // ����11
//            sql.append("," + TBTHB2KMEI.KNGK1);                                  // ���z1
//            sql.append("," + TBTHB2KMEI.KNGK2);                                  // ���z2
//            sql.append("," + TBTHB2KMEI.SONOTA2);                                // ���̑�2
//            sql.append("," + TBTHB2KMEI.SONOTA3);                                // ���̑�3
//            sql.append("," + TBTHB2KMEI.SONOTA4);                                // ���̑�4
//            sql.append("," + TBTHB2KMEI.SONOTA5);                                // ���̑�5

            // ====================================================================================================
            // FROM��
            // ====================================================================================================
            sql.append(" FROM");
            sql.append(" " + TBTHB1DOWN.TBNAME);
//            sql.append(" LEFT OUTER JOIN");
//            sql.append(" " + TBTHB2KMEI.TBNAME);
//            sql.append(" ON");
//            sql.append("     " + TBTHB2KMEI.EGCD + "        = " + TBTHB1DOWN.EGCD);
//            sql.append(" AND " + TBTHB2KMEI.TKSKGYCD + "    = " + TBTHB1DOWN.TKSKGYCD);
//            sql.append(" AND " + TBTHB2KMEI.TKSBMNSEQNO + " = " + TBTHB1DOWN.TKSBMNSEQNO);
//            sql.append(" AND " + TBTHB2KMEI.TKSTNTSEQNO + " = " + TBTHB1DOWN.TKSTNTSEQNO);
//            sql.append(" AND " + TBTHB2KMEI.YYMM + "        = " + TBTHB1DOWN.YYMM);
//            sql.append(" AND " + TBTHB2KMEI.JYUTNO + "      = " + TBTHB1DOWN.JYUTNO);
//            sql.append(" AND " + TBTHB2KMEI.JYMEINO + "     = " + TBTHB1DOWN.JYMEINO);
//            sql.append(" AND " + TBTHB2KMEI.URMEINO + "     = " + TBTHB1DOWN.URMEINO);

            // ====================================================================================================
            // WHERE��
            // ====================================================================================================
            sql.append(" WHERE");
            sql.append("     " + TBTHB1DOWN.EGCD + "        = '" + _cond.getEgCd() + "'");
            sql.append(" AND " + TBTHB1DOWN.TKSKGYCD + "    = '" + _cond.getTksKgyCd() + "'");
            sql.append(" AND " + TBTHB1DOWN.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'");
            sql.append(" AND " + TBTHB1DOWN.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'");
            sql.append(" AND " + TBTHB1DOWN.YYMM + "        = '" + _cond.getYm() + "'");
//            if(_cond.getBusho().trim().equals("")){
//            }else{
//                sql.append(" AND " + TBTHB2KMEI.NAME11 + "      = '" + _cond.getBusho() + "'");
//            }
            // �������No
            sql.append(" AND " + TBTHB1DOWN.TJYUTNO + " != ' '");

            // ====================================================================================================
            // ORDER BY��
            // ====================================================================================================
            sql.append(" ORDER BY");
//            sql.append("     SHOWNUM");                                          // �\����
//            sql.append(",CAST(RTRIM(" + TBTHB2KMEI.SONOTA3 + ") AS INT)");       // �\�[�g�ԍ�
//            sql.append("," + TBTHB1DOWN.GPYNO);                                  // �������[No
            sql.append(" " + TBTHB1DOWN.GPYNO);                                  // �������[No
//            sql.append("," + TBTHB2KMEI.SONOTA2);                                // �������[�s�ԍ��i1���j

        }

        return sql.toString();
    }

    /**
     * ���[�i���j�`���[��_�L����ו\�E�v���[�t���X�g�j�f�[�^�̌������s���܂��B
     *
     * @return ���[�i���j�`���[��_�L����ו\�E�v���[�t���X�g�j�f�[�^���܂�VO���X�g
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportUniVO> findReportUniByCondition(ReportUniCondition cond)
            throws KKHException {

        super.setModel(new ReportUniVO());

        try {
            _SelSqlMode = SelSqlMode.MEISAI1;
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * ���[�i���j�`���[��_�L����ו\�E�v���[�t���X�g�j�f�[�^�̌������s���܂��B
     * �������f�[�^�̂ݑΏ�
     * @return ���[�i���j�`���[��_�L����ו\�E�v���[�t���X�g�j�f�[�^���܂�VO���X�g
     * @throws UserException
     *             �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<ReportUniVO> findTougouReportUniByCondition(ReportUniCondition cond)
            throws KKHException {

        super.setModel(new ReportUniVO());

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
    protected List<ReportUniVO> createFindedModelInstances(List hashList) {
        return getMeisaiList(hashList);
    }

    /**
     * �L����ו\�i�b��E�m��j�f�[�^���擾����
     *
     * @param hashList ��������
     * @return �ϊ���̌�������
     */
    private List<ReportUniVO> getMeisaiList(List hashList) {

        List<ReportUniVO> list = new ArrayList<ReportUniVO>();

        if (getModel() instanceof ReportUniVO) {

            for (int i = 0; i < hashList.size(); i++) {

                Map result = (Map) hashList.get(i);
                ReportUniVO vo = new ReportUniVO();

                // ��ʃR�[�h
                BigDecimal showNum = (BigDecimal) result.get("SHOWNUM");
                //String showNumStr = String.valueOf(showNum);
                String showNumStr = "";

                // ��ʃR�[�h����̏ꍇ�A�Ɩ��敪�����ʃR�[�h��ݒ肷��
                if(showNum == null){

                    // �Ɩ��敪���擾
                    String gyomKbn = (String)result.get(TBTHB1DOWN.GYOMKBN);

                    if (GyomKbn.TVTIME.getCode().equals(gyomKbn)) {
                        showNumStr = IDX_TV_BANGUMI;                           // �e���r�ԑg

                    } else if (GyomKbn.TVSPOT.getCode().equals(gyomKbn)) {
                        showNumStr = IDX_TV_SPOT;                              // �e���r�X�|�b�g

                    } else if (GyomKbn.ZASHI.getCode().equals(gyomKbn)) {
                        showNumStr = IDX_ZASHI;                                // �G��

                    } else if (GyomKbn.SHINBUN.getCode().equals(gyomKbn)) {
                        showNumStr = IDX_SHINBUN;                              // �V��

                    } else if (GyomKbn.CREATIVE.getCode().equals(gyomKbn)) {
                        showNumStr = IDX_SEISAKU;                              // ����

                    } else {
                        showNumStr = IDX_SONOTA;                               // ���̑�
                    }
                }
                else
                {
                    showNumStr = String.valueOf(showNum);
                }

                // �擾������ʃR�[�h���Z�b�g
                vo.setShubetsuCd(showNumStr);

                // ��ʖ�
                String shubetsuNm = "";
                if (IDX_TV_BANGUMI.equals(showNumStr)) {
                    shubetsuNm = Shubetsu.TV_BANGUMI.getName();    // �e���r�ԑg

                } else if (IDX_TV_TOKUBAN.equals(showNumStr)) {
                    shubetsuNm = Shubetsu.TV_TOKUBAN.getName();    // �e���r����

                } else if (IDX_TV_SPOT.equals(showNumStr)) {
                    shubetsuNm = Shubetsu.TV_SPOT.getName();       // �e���r�X�|�b�g

                } else if (IDX_ZASHI.equals(showNumStr)) {
                    shubetsuNm = Shubetsu.ZASHI.getName();         // �G��

                } else if (IDX_SHINBUN.equals(showNumStr)) {
                    shubetsuNm = Shubetsu.SHINBUN.getName();       // �V��

                } else if (IDX_SONOTA.equals(showNumStr)) {
                    shubetsuNm = Shubetsu.SONOTA.getName();        // ���̑�

                } else if (IDX_SEISAKU.equals(showNumStr)) {
                    shubetsuNm = Shubetsu.SEISAKU.getName();       // ����
                }
                vo.setShubetsuNm(shubetsuNm);

                vo.setHb1GpyNo((String) result.get(TBTHB1DOWN.GPYNO.toUpperCase().trim()));            // �������[No
                vo.setHb1SeiGak((BigDecimal) result.get(TBTHB1DOWN.SEIGAK.toUpperCase().trim()));      // �������z
                vo.setHb1SzeiGak((BigDecimal) result.get(TBTHB1DOWN.SZEIGAK.toUpperCase().trim()));    // ����Ŋz
                vo.setHb1JyutNo((String) result.get(TBTHB1DOWN.JYUTNO.toUpperCase().trim()));          // ��No
                vo.setHb1JyMeiNo((String) result.get(TBTHB1DOWN.JYMEINO.toUpperCase().trim()));        // �󒍖���No
                vo.setHb1UrMeiNo((String) result.get(TBTHB1DOWN.URMEINO.toUpperCase().trim()));        // ���㖾��No
                vo.setHb1GyomKbn((String) result.get(TBTHB1DOWN.GYOMKBN.toUpperCase().trim()));        // �Ɩ��敪
                vo.setHb1SeiKbn((String) result.get(TBTHB1DOWN.SEIKBN.toUpperCase().trim()));          // �����敪
                vo.setHb1KKNameKJ((String) result.get(TBTHB1DOWN.KKNAMEKJ.toUpperCase().trim()));      // ����(����)
                vo.setHb1HimkNmKJ((String) result.get(TBTHB1DOWN.HIMKNMKJ.toUpperCase().trim()));      // ��ږ�(����)
                vo.setHb1SeiTnka((BigDecimal) result.get(TBTHB1DOWN.SEITNKA.toUpperCase().trim()));    // �����P��
                // 2013/01/09 JSE M.Naito add start
                vo.setHb1TouFlg((String) result.get(TBTHB1DOWN.TOUFLG.toUpperCase().trim()));          // �����t���O
                vo.setHb1TJyutNo((String) result.get(TBTHB1DOWN.TJYUTNO.toUpperCase().trim()));        // �������No
                vo.setHb1TJymeiNo((String) result.get(TBTHB1DOWN.TJYMEINO.toUpperCase().trim()));      // ������󒍖���No
                vo.setHb1TUrmeiNo((String) result.get(TBTHB1DOWN.TURMEINO.toUpperCase().trim()));      // �����攄�㖾��No
                // 2013/01/09 JSE M.Naito add end
                vo.setHb1Field1((String) result.get(TBTHB1DOWN.FIELD1.toUpperCase().trim()));          // �t�B�[���h�P
                vo.setHb1Field2((String) result.get(TBTHB1DOWN.FIELD2.toUpperCase().trim()));          // �t�B�[���h�Q
                vo.setHb1Field3((String) result.get(TBTHB1DOWN.FIELD3.toUpperCase().trim()));          // �t�B�[���h�R
                vo.setHb1Field4((String) result.get(TBTHB1DOWN.FIELD4.toUpperCase().trim()));          // �t�B�[���h�S
                vo.setHb1Field5((String) result.get(TBTHB1DOWN.FIELD5.toUpperCase().trim()));          // �t�B�[���h�T
                vo.setHb1Field6((String) result.get(TBTHB1DOWN.FIELD6.toUpperCase().trim()));          // �t�B�[���h�U
                vo.setHb1Field7((String) result.get(TBTHB1DOWN.FIELD7.toUpperCase().trim()));          // �t�B�[���h�V
                vo.setHb1Field8((String) result.get(TBTHB1DOWN.FIELD8.toUpperCase().trim()));          // �t�B�[���h�W
                vo.setHb1Field9((String) result.get(TBTHB1DOWN.FIELD9.toUpperCase().trim()));          // �t�B�[���h�X
                vo.setHb1Field10((String) result.get(TBTHB1DOWN.FIELD10.toUpperCase().trim()));        // �t�B�[���h�P�O
                vo.setHb1Field11((String) result.get(TBTHB1DOWN.FIELD11.toUpperCase().trim()));        // �t�B�[���h�P�P
                vo.setHb1Field12((String) result.get(TBTHB1DOWN.FIELD12.toUpperCase().trim()));        // �t�B�[���h�P�Q

                vo.setHb2SeiGak((BigDecimal) result.get(TBTHB2KMEI.SEIGAK.toUpperCase().trim()));      // �������z
                vo.setHb2Code1((String) result.get(TBTHB2KMEI.CODE1.toUpperCase().trim()));            // �R�[�h1
                vo.setHb2Name1((String) result.get(TBTHB2KMEI.NAME1.toUpperCase().trim()));            // ����1
                vo.setHb2Name2((String) result.get(TBTHB2KMEI.NAME2.toUpperCase().trim()));            // ����2
                vo.setHb2Name3((String) result.get(TBTHB2KMEI.NAME3.toUpperCase().trim()));            // ����3
                vo.setHb2Name4((String) result.get(TBTHB2KMEI.NAME4.toUpperCase().trim()));            // ����4
                vo.setHb2Name6((String) result.get(TBTHB2KMEI.NAME6.toUpperCase().trim()));            // ����6
                vo.setHb2Name7((String) result.get(TBTHB2KMEI.NAME7.toUpperCase().trim()));            // ����7
                vo.setHb2Name9((String) result.get(TBTHB2KMEI.NAME9.toUpperCase().trim()));            // ����9
                vo.setHb2Name11((String) result.get(TBTHB2KMEI.NAME11.toUpperCase().trim()));            // ����9
                vo.setHb2Kngk1((BigDecimal) result.get(TBTHB2KMEI.KNGK1.toUpperCase().trim()));        // ���z1
                vo.setHb2Kngk2((BigDecimal) result.get(TBTHB2KMEI.KNGK2.toUpperCase().trim()));        // ���z2
                vo.setHb2Sonota2((String) result.get(TBTHB2KMEI.SONOTA2.toUpperCase().trim()));        // ���̑�2
                vo.setHb2Sonota3((String) result.get(TBTHB2KMEI.SONOTA3.toUpperCase().trim()));        // ���̑�3
                vo.setHb2Sonota4((String) result.get(TBTHB2KMEI.SONOTA4.toUpperCase().trim()));        // ���̑�4
                vo.setHb2Sonota5((String) result.get(TBTHB2KMEI.SONOTA5.toUpperCase().trim()));        // ���̑�5

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
