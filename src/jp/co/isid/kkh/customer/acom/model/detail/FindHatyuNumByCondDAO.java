package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * �����f�[�^�o�^DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/6 Fourm H.izawa)<BR>
 * </P>
 * @author Fourm H.izawa
 */
public class FindHatyuNumByCondDAO extends AbstractRdbDao  {

    private FindHatyuNumByCondVO _cond;
    //private Thb5HikVO _cond;
     /** getSelectSQL�Ŕ��s����SQL�̃��[�h() */
    private enum SqlMode{COMMON,};
    private SqlMode _sqlMode = SqlMode.COMMON;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindHatyuNumByCondDAO() {
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
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        return new String[]{
                TBTHB5HIK.TKSKGYCD,
                TBTHB5HIK.TKSBMNSEQNO,
                TBTHB5HIK.TKSTNTSEQNO,
                TBTHB5HIK.IRBAN,
                TBTHB5HIK.IRROWBAN
        };
    }

    /**
     * �V�X�e�����t�ōX�V�����̒�`�ł�
     */
    @Override
    protected String[] getSystemDateColumnNames() {
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
        return TBTHB5HIK.TBNAME;
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[]{
//    			TBTHB5HIK.TRKTIMSTMP,
//    			TBTHB5HIK.UPDAPL,
//    			TBTHB5HIK.UPDTN,
//    			TBTHB5HIK.TKSKGYCD,
//    			TBTHB5HIK.TKSBMNSEQNO,
//    			TBTHB5HIK.TKSTNTSEQNO,
                TBTHB5HIK.IRBAN,
                TBTHB5HIK.MEDIACD,
                TBTHB5HIK.SYBT,
                TBTHB5HIK.TEKICD,
                TBTHB5HIK.SYOHIKBN,
                TBTHB5HIK.SAIKBN,
                TBTHB5HIK.TENCD,
                TBTHB5HIK.IRROWBAN,
                TBTHB5HIK.ANSYUBE,
                TBTHB5HIK.KEISAI1,
                TBTHB5HIK.KEISAI2,
                TBTHB5HIK.KEISAI3,
                TBTHB5HIK.KEISAI4,
                TBTHB5HIK.KEISAI5,
                TBTHB5HIK.IRMONTH1,
                TBTHB5HIK.IRMONTH2,
                TBTHB5HIK.IRMONTH3,
                TBTHB5HIK.IRMONTH4,
                TBTHB5HIK.IRMONTH5,
                TBTHB5HIK.IRYYMM,
                TBTHB5HIK.KEISAI,
                TBTHB5HIK.TOUDATE,
                TBTHB5HIK.HENDATE,
                TBTHB5HIK.TORDATE,
                TBTHB5HIK.KEISAITANKA,
                TBTHB5HIK.BIKOU1,
                TBTHB5HIK.BIKOU2,
                TBTHB5HIK.PLACECD,
                TBTHB5HIK.SYBT1CD,
                TBTHB5HIK.SYBT2CD,
                TBTHB5HIK.COLORCD,
                TBTHB5HIK.SPACECD,
                TBTHB5HIK.SIZECD,
                TBTHB5HIK.KEITAICD,
                TBTHB5HIK.KEITAINAME,
                TBTHB5HIK.KOTUKEICD,
                TBTHB5HIK.KEISAICNT,
                TBTHB5HIK.MEDIANAME
        };
    }

    /**
     * ���{NO����UP/DOWN�̓o�^���s���܂��B
     *
     * @param vo VO ���{NoVO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ
     */
    public void findThb2Kmei(FindHatyuNumByCondVO vo) throws KKHException {
        //�p�����[�^�`�F�b�N
        if (vo == null) {
            throw new KKHException("�o�^�G���[", "BD-E0002");
        }
        //super.setModel(vo);
        _cond = vo;

        try {
          super.exec();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0002");
        }
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public  String getSelectSQL() {
        if (_sqlMode.equals(SqlMode.COMMON)){
            return getExecString();
        }
        return "";
    }

    /**
     * EXEC-SQL����
     */
    @Override
    public String getExecString() {
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

        sql.append(" FROM ");
        sql.append(TBTHB5HIK.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" "+ TBTHB5HIK.TKSKGYCD + " =  '" + _cond.get_tksKgyCd() +"' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.get_tksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.get_tksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.IRBAN + " = '" + _cond.get_Irban() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.RECCD + " = 'H' ");
        sql.append(" AND ");
        sql.append(" (" + TBTHB5HIK.IRBAN + " , " + TBTHB5HIK.IRROWBAN + " , " + TBTHB5HIK.RIRENO + ") IN ");
        sql.append(" ( SELECT " + TBTHB5HIK.IRBAN + ", " + TBTHB5HIK.IRROWBAN + ", MAX(" + TBTHB5HIK.RIRENO + ") ");
        sql.append(" FROM ");
        sql.append(TBTHB5HIK.TBNAME + " ");
        sql.append(" WHERE ");
        sql.append(" "+ TBTHB5HIK.TKSKGYCD + " =  '" + _cond.get_tksKgyCd() +"' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.TKSBMNSEQNO + " = '" + _cond.get_tksBmnSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.TKSTNTSEQNO + " = '" + _cond.get_tksTntSeqNo() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.IRBAN + " = '" + _cond.get_Irban() + "' ");
        sql.append(" AND ");
        sql.append(" " +TBTHB5HIK.RECCD + " = 'H' ");
        sql.append(" GROUP BY  ");
        sql.append(TBTHB5HIK.IRBAN + ", ");
        sql.append(TBTHB5HIK.IRROWBAN + ") ");
        sql.append(" ORDER BY  ");
        sql.append(TBTHB5HIK.IRBAN + ", ");
        sql.append(TBTHB5HIK.IRROWBAN + " ");

        return sql.toString();
    }

    /**
     * �L����׃e�[�u���̏����w�茟�����s���܂��B
     *
     * @return �󒍃_�E�����[�h�f�[�^VO
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<HikVO> findThb5HikByCondCmn(FindHatyuNumByCondVO Cond) throws KKHException {

     // TODO THB5HIK�e�[�u���ɓ����ڂȂ�
        super.setModel(new HikVO());

        try {
            _cond = Cond;
//        	_selSqlMode = SelSqlMode.COND_CMN;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    @Override
    protected List<HikVO> createFindedModelInstances(List hashList) {
        List<HikVO> list = new ArrayList<HikVO>();
        if (getModel() instanceof HikVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                HikVO vo = new HikVO();
                vo.setIrban((String) result.get(TBTHB5HIK.IRBAN.toUpperCase()));					//�˗��ԍ�
                vo.setMediaCd((String) result.get(TBTHB5HIK.MEDIACD.toUpperCase()));				//���f�B�A�R�[�h
                vo.setSybt((String) result.get(TBTHB5HIK.SYBT.toUpperCase()));						//�}�̃R�[�h
                vo.setTekiCd((String) result.get(TBTHB5HIK.TEKICD.toUpperCase()));					//�E�v�R�[�h
                vo.setSyohiKbn((String) result.get(TBTHB5HIK.SYOHIKBN.toUpperCase()));				//���i�敪
                vo.setSaiKbn((String) result.get(TBTHB5HIK.SAIKBN.toUpperCase()));					//�זڋ敪
                vo.setTenCd((String) result.get(TBTHB5HIK.TENCD.toUpperCase()));					//�X��
                vo.setIrrowban((String) result.get(TBTHB5HIK.IRROWBAN.toUpperCase()));				//�˗��s�ԍ�
                vo.setAnsyube((String) result.get(TBTHB5HIK.ANSYUBE.toUpperCase()));				//�����
                vo.setKeisai1((String) result.get(TBTHB5HIK.KEISAI1.toUpperCase()));				//������1
                vo.setKeisai2((String) result.get(TBTHB5HIK.KEISAI2.toUpperCase()));				//������2
                vo.setKeisai3((String) result.get(TBTHB5HIK.KEISAI3.toUpperCase()));				//������3
                vo.setKeisai4((String) result.get(TBTHB5HIK.KEISAI4.toUpperCase()));				//������4
                vo.setKeisai5((String) result.get(TBTHB5HIK.KEISAI5.toUpperCase()));				//������5
                vo.setIrmonth1((String) result.get(TBTHB5HIK.IRMONTH1.toUpperCase()));				//�˗���1
                vo.setIrmonth2((String) result.get(TBTHB5HIK.IRMONTH2.toUpperCase()));				//�˗���2
                vo.setIrmonth3((String) result.get(TBTHB5HIK.IRMONTH3.toUpperCase()));				//�˗���3
                vo.setIrmonth4((String) result.get(TBTHB5HIK.IRMONTH4.toUpperCase()));				//�˗���4
                vo.setIrmonth5((String) result.get(TBTHB5HIK.IRMONTH5.toUpperCase()));				//�˗���5
                vo.setIryymm((String) result.get(TBTHB5HIK.IRYYMM.toUpperCase()));					//�˗��N��
                vo.setKeisai((String) result.get(TBTHB5HIK.KEISAI.toUpperCase()));					//�f�ړ�
                vo.setTouDate((String) result.get(TBTHB5HIK.TOUDATE.toUpperCase()));				//�o�^�N����
                vo.setHenDate((String) result.get(TBTHB5HIK.HENDATE.toUpperCase()));				//�ύX�N����
                vo.setTorDate((String) result.get(TBTHB5HIK.TORDATE.toUpperCase()));				//����N����
                vo.setKeisaiTanka((String) result.get(TBTHB5HIK.KEISAITANKA.toUpperCase()));		//�f�ڒP��
                vo.setBikou1((String) result.get(TBTHB5HIK.BIKOU1.toUpperCase()));					//���l1
                vo.setBikou2((String) result.get(TBTHB5HIK.BIKOU2.toUpperCase()));					//���l2
                vo.setPlaceCd((String) result.get(TBTHB5HIK.PLACECD.toUpperCase()));				//�f�ڏꏊ�R�[�h
                vo.setSybt1Cd((String) result.get(TBTHB5HIK.SYBT1CD.toUpperCase()));				//���1�R�[�h
                vo.setSybt2Cd((String) result.get(TBTHB5HIK.SYBT2CD.toUpperCase()));				//���1�R�[�h
                vo.setColorCd((String) result.get(TBTHB5HIK.COLORCD.toUpperCase()));				//�F���R�[�h
                vo.setSpaceCd((String) result.get(TBTHB5HIK.SPACECD.toUpperCase()));				//�T�C�Y�R�[�h�i�V���j
                vo.setSizeCd((String) result.get(TBTHB5HIK.SIZECD.toUpperCase()));					//�T�C�Y�R�[�h�i�G���j
                vo.setKeitaiCd((String) result.get(TBTHB5HIK.KEITAICD.toUpperCase()));				//�`�ԋ敪�R�[�h
                vo.setKeitaiName((String) result.get(TBTHB5HIK.KEITAINAME.toUpperCase()));			//�`�ԋ敪��
                vo.setKotukeiCd((String) result.get(TBTHB5HIK.KOTUKEICD.toUpperCase()));			//��ʌf�ڃR�[�h
                vo.setKeisaiCnt((String) result.get(TBTHB5HIK.KEISAICNT.toUpperCase()));			//�f�ډ�
                vo.setMediaName((String) result.get(TBTHB5HIK.MEDIANAME.toUpperCase()));			//���f�B�A��

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}