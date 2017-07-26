package jp.co.isid.kkh.customer.acom.model.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.acom.model.input.HikVO;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 *
 * <P>
 * �����f�[�^����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/14 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
public class HikCheckDataDAO extends AbstractRdbDao {

    public static final String  BAICD_ZASI     = "22";//�G��
    public static final String  BAICD_SHINBUN  = "21";//�V��
    public static final String  BAICD_DENP     = "11";//�d�g
    public static final String  BAICD_KOTU     = "31";//���

    /**�}�X�^�������� */
    private HikCommonCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public HikCheckDataDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    @Override
    public String[] getPrimryKeyNames() {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        return null;
    }

    @Override
    public String[] getTableColumnNames() {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        return null;
    }

    @Override
    public String getTableName() {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        return null;
    }

    @Override
    public String getTimeStampKeyName() {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        return null;
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
        StringBuilder sql = new StringBuilder();

        sql.append(" SELECT ");
        sql.append(TBTHB5HIK.RECCD + ",");         //���R�[�h���
        sql.append(TBTHB5HIK.IRBAN + ",");         //�˗��ԍ�
        sql.append(TBTHB5HIK.IRROWBAN + ",");      //�˗��s�ԍ�
        sql.append(TBTHB5HIK.RIRENO + ",");        //�����Ǘ��ԍ�
        sql.append(TBTHB5HIK.IRYYMM + ",");        //�˗��N��
        sql.append(TBTHB5HIK.IRKBN + ",");         //�˗��敪
        sql.append(TBTHB5HIK.TKSKGYCD + ",");      //���Ӑ�R�[�h
        sql.append(TBTHB5HIK.EICODE + ",");        //�c�ƕ��R�[�h
        sql.append(TBTHB5HIK.EINAME + ",");        //�c�ƕ���
        sql.append(TBTHB5HIK.TENCD + ",");         //�X��
        sql.append(TBTHB5HIK.TENNAME + ",");       //�X��
        sql.append(TBTHB5HIK.YOSAKBN + ",");       //�\�Z�敪
        sql.append(TBTHB5HIK.IRNAI + ",");         //�˗����e
        sql.append(TBTHB5HIK.SYBT + ",");          //�}�̃R�[�h
        sql.append(TBTHB5HIK.MEDIACD + ",");       //���f�B�A�R�[�h
        sql.append(TBTHB5HIK.MEDIANAME + ",");     //���f�B�A��
        sql.append(TBTHB5HIK.SIZECD + ",");        //�T�C�Y�R�[�h
        sql.append(TBTHB5HIK.SIZENAME + ",");      //�T�C�Y
        sql.append(TBTHB5HIK.KEISAI1 + ",");       //�f�ړ�1
        sql.append(TBTHB5HIK.KEISAI2 + ",");       //�f�ړ�2
        sql.append(TBTHB5HIK.KEISAI3 + ",");       //�f�ړ�3
        sql.append(TBTHB5HIK.KEISAI4 + ",");       //�f�ړ�4
        sql.append(TBTHB5HIK.KEISAI5 + ",");       //�f�ړ�5
        sql.append(TBTHB5HIK.KEITAICD + ",");      //�`�ԋ敪�R�[�h
        sql.append(TBTHB5HIK.KEITAINAME + ",");    //�`�ԋ敪��
        sql.append(TBTHB5HIK.IRMONTH1 + ",");      //�˗���1
        sql.append(TBTHB5HIK.HOSORYO1  + ",");     //������1
        sql.append(TBTHB5HIK.IRMONTH2 + ",");      //�˗���2
        sql.append(TBTHB5HIK.HOSORYO2 + ",");      //������2
        sql.append(TBTHB5HIK.IRMONTH3 + ",");      //�˗���3
        sql.append(TBTHB5HIK.HOSORYO3 + ",");      //������3
        sql.append(TBTHB5HIK.IRMONTH4 + ",");      //�˗���4
        sql.append(TBTHB5HIK.HOSORYO4 + ",");      //������4
        sql.append(TBTHB5HIK.IRMONTH5 + ",");      //�˗���5
        sql.append(TBTHB5HIK.HOSORYO5 + ",");      //������5
        sql.append(TBTHB5HIK.IRMONTH6 + ",");      //�˗���6
        sql.append(TBTHB5HIK.HOSORYO6 + ",");      //������6
        sql.append(TBTHB5HIK.KOTUKEICD + ",");     //��ʌf�ڃR�[�h
        sql.append(TBTHB5HIK.KOTUKEINAME + ",");   //��ʌf�ږ�
        sql.append(TBTHB5HIK.KEISAI + ",");        //�f�ړ�
        sql.append(TBTHB5HIK.KEISAIRYO + ",");     //�f�ڗ�
        sql.append(TBTHB5HIK.KEISAITANKA + ",");   //�f�ڒP��
        sql.append(TBTHB5HIK.KEISAICNT + ",");     //�f�ډ�
        sql.append(TBTHB5HIK.SYOHIKBN + ",");      //���i�敪
        sql.append(TBTHB5HIK.SYOHINAME + ",");     //���i�敪����
        sql.append(TBTHB5HIK.SAIKBN + ",");        //�זڋ敪
        sql.append(TBTHB5HIK.TEKICD + ",");        //�E�v�R�[�h
        sql.append(TBTHB5HIK.URIYYMM + ",");       //����\��N��
        sql.append(TBTHB5HIK.TANNAME + ",");       //�S���Җ�
        sql.append(TBTHB5HIK.TANKINNAME + ",");    //�S���ҋΖ�������
        sql.append(TBTHB5HIK.ANSYUBE + ",");       //�����
        sql.append(TBTHB5HIK.KOUKBN + ",");        //�X�V�敪
        sql.append(TBTHB5HIK.BIKOU1 + ",");        //���l1
        sql.append(TBTHB5HIK.BIKOU2 + ",");        //���l2
        sql.append(TBTHB5HIK.COLORCD + ",");       //�F���R�[�h
        sql.append(TBTHB5HIK.SPACECD + ",");       //�X�y�[�X�R�[�h
        sql.append(TBTHB5HIK.SPACENAME + ",");       //�X�y�[�X����
        sql.append(TBTHB5HIK.SYBT1CD + ",");       //��ʂP�R�[�h
        sql.append(TBTHB5HIK.SYBT2CD + ",");       //��ʂQ�R�[�h
        sql.append(TBTHB5HIK.DESIGNCNT + ",");     //�f�U�C���ύX��
        sql.append(TBTHB5HIK.PLACECD + ",");       //�f�ڏꏊ�R�[�h
        sql.append(TBTHB5HIK.PRINTRYO + ",");      //�����
        sql.append(TBTHB5HIK.SASHIKAERYO + ",");   //���֍�Ɨ�
        sql.append(TBTHB5HIK.DESIGNRYO + ",");     //�f�U�C����
        sql.append(TBTHB5HIK.HANSHITARYO + ",");   //�ŉ���
        sql.append(TBTHB5HIK.SEIHANRYO + ",");     //���ő�
        sql.append(TBTHB5HIK.TOUDATE + ",");       //�o�^�N����
        sql.append(TBTHB5HIK.HENDATE + ",");       //�ύX�N����
        sql.append(TBTHB5HIK.TORDATE + ",");       //����N����
        sql.append("'' AS DUMMY1,");             //�_�~�[1
        sql.append("'' AS DUMMY2");              //�_�~�[2

        //From��
        sql.append(" FROM ");
        sql.append(TBTHB5HIK.TBNAME);

        //Where��
        sql.append(getWhere(_cond.getSyubetsu(),false));

        sql.append("(" + TBTHB5HIK.IRBAN + ",");
        sql.append(TBTHB5HIK.IRROWBAN + ",");
        sql.append(TBTHB5HIK.RIRENO + ")");

        //IN�N�G���[
        sql.append(" IN ");
        sql.append(" ( SELECT ");
        sql.append(TBTHB5HIK.IRBAN + ",");
        sql.append(TBTHB5HIK.IRROWBAN + ",");
        sql.append("MAX(" + TBTHB5HIK.RIRENO + ")");
        sql.append(" FROM ");
        sql.append(TBTHB5HIK.TBNAME);

        //Where��
        sql.append(getWhere(_cond.getSyubetsu(),true));

        sql.append(" GROUP BY ");
        sql.append(TBTHB5HIK.IRBAN +",");
        sql.append(TBTHB5HIK.IRROWBAN +")");

        sql.append(" ORDER BY ");
        sql.append(TBTHB5HIK.IRROWBAN);

        return sql.toString();
    }

    /**
     * �����e�[�u���̌������s���܂��B
     *
     * @return �����e�[�u��VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<HikVO> findByCondition(HikCommonCondition cond) throws KKHException {

        super.setModel(new HikVO());

        try {
            _cond = cond;
            return super.find();
        } catch (UserException e) {
            throw new KKHException(e.getMessage(), "BD-E0001");
        }
    }

    /**
     * Model�̐������s��<br>
     * �������ʂ�VO��KEY���啶���̂��ߕϊ��������s��<br>
     * AbstractRdbDao��createFindedModelInstances���I�[�o�[���C�h<br>
     *
     * @param hashList List ��������
     * @return List<HikVO> �ϊ���̌�������
     */
    @Override
    protected List<HikVO> createFindedModelInstances(List hashList) {
        List<HikVO> list = new ArrayList<HikVO>();
        if (getModel() instanceof HikVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                HikVO vo = new HikVO();
                //VOList�ɓ��꒼���������s��
                vo.setRecCd((String)result.get(TBTHB5HIK.RECCD));                    //���R�[�h���
                vo.setIrban((String)result.get(TBTHB5HIK.IRBAN));                    //�˗��ԍ�
                vo.setIrrowban((String)result.get(TBTHB5HIK.IRROWBAN));              //�˗��s�ԍ�
                vo.setRireNo((String)result.get(TBTHB5HIK.RIRENO));                  //�����Ǘ��ԍ�
                vo.setIryymm((String)result.get(TBTHB5HIK.IRYYMM));                  //�˗��N��
                vo.setIrKbn((String)result.get(TBTHB5HIK.IRKBN));                    //�˗��敪
                vo.setTksKgyCd((String)result.get(TBTHB5HIK.TKSKGYCD));              //���Ӑ�R�[�h
                vo.setEiCode((String)result.get(TBTHB5HIK.EICODE));                  //�c�ƕ��R�[�h
                vo.setEiName((String)result.get(TBTHB5HIK.EINAME));                  //�c�ƕ���
                vo.setTenCd((String)result.get(TBTHB5HIK.TENCD));                    //�X��
                vo.setTenName((String)result.get(TBTHB5HIK.TENNAME));                //�X��
                vo.setYosaKbn((String)result.get(TBTHB5HIK.YOSAKBN));                //�\�Z�敪
                vo.setIrnai((String)result.get(TBTHB5HIK.IRNAI));                    //�˗����e
                vo.setSybt((String)result.get(TBTHB5HIK.SYBT));                      //�}�̃R�[�h
                vo.setMediaCd((String)result.get(TBTHB5HIK.MEDIACD));                //���f�B�A�R�[�h
                vo.setMediaName((String)result.get(TBTHB5HIK.MEDIANAME));            //���f�B�A��
                vo.setSizeCd((String)result.get(TBTHB5HIK.SIZECD));                  //�T�C�Y�R�[�h
                vo.setSizeName((String)result.get(TBTHB5HIK.SIZENAME));              //�T�C�Y
                vo.setKeisai1((String)result.get(TBTHB5HIK.KEISAI1));                //�f�ړ�1
                vo.setKeisai2((String)result.get(TBTHB5HIK.KEISAI2));                //�f�ړ�2
                vo.setKeisai3((String)result.get(TBTHB5HIK.KEISAI3));                //�f�ړ�3
                vo.setKeisai4((String)result.get(TBTHB5HIK.KEISAI4));                //�f�ړ�4
                vo.setKeisai5((String)result.get(TBTHB5HIK.KEISAI5));                //�f�ړ�5
                vo.setKeitaiCd((String)result.get(TBTHB5HIK.KEITAICD));              //�`�ԋ敪�R�[�h
                vo.setKeitaiName((String)result.get(TBTHB5HIK.KEITAINAME));          //�`�ԋ敪��
                vo.setIrmonth1((String)result.get(TBTHB5HIK.IRMONTH1));              //�˗���1
                vo.setHosoryo1((BigDecimal)result.get(TBTHB5HIK.HOSORYO1 ));         //������1
                vo.setIrmonth2((String)result.get(TBTHB5HIK.IRMONTH2));              //�˗���2
                vo.setHosoryo2((BigDecimal)result.get(TBTHB5HIK.HOSORYO2));          //������2
                vo.setIrmonth3((String)result.get(TBTHB5HIK.IRMONTH3));              //�˗���3
                vo.setHosoryo3((BigDecimal)result.get(TBTHB5HIK.HOSORYO3));          //������3
                vo.setIrmonth4((String)result.get(TBTHB5HIK.IRMONTH4));              //�˗���4
                vo.setHosoryo4((BigDecimal)result.get(TBTHB5HIK.HOSORYO4));          //������4
                vo.setIrmonth5((String)result.get(TBTHB5HIK.IRMONTH5));              //�˗���5
                vo.setHosoryo5((BigDecimal)result.get(TBTHB5HIK.HOSORYO5));          //������5
                vo.setIrmonth6((String)result.get(TBTHB5HIK.IRMONTH6));              //�˗���6
                vo.setHosoryo6((BigDecimal)result.get(TBTHB5HIK.HOSORYO6));          //������6
                vo.setKotukeiCd((String)result.get(TBTHB5HIK.KOTUKEICD));            //��ʌf�ڃR�[�h
                vo.setKotukeiName((String)result.get(TBTHB5HIK.KOTUKEINAME));        //��ʌf�ږ�
                vo.setKeisai((String)result.get(TBTHB5HIK.KEISAI));                  //�f�ړ�
                vo.setKeisairyo((BigDecimal)result.get(TBTHB5HIK.KEISAIRYO));        //�f�ڗ�

                /*
                    //�}�̂��y�V���z�̏ꍇ�͉��L�̏������s��
                    if((result.get(TBTHB5HIK.SYBT)).equals(BAICD_SHINBUN) ){
                        Double tmp = 0.0d;
                        tmp = Double.parseDouble(((String)result.get(TBTHB5HIK.KEISAITANKA))) / 100;
                        vo.setKeisaiTanka(tmp.toString());                                           //�f�ڒP��
                    }else{
                        Double tmp = 0.0d;
                        tmp = Double.parseDouble(((String)result.get(TBTHB5HIK.KEISAITANKA)).substring(1,9));
                        vo.setKeisaiTanka(tmp.toString());                                             //�f�ڒP��
                        //vo.setKeisaiTanka(((String)result.get(TBTHB5HIK.KEISAITANKA)).substring(1,9)); //�f�ڒP��
                    }
                */

                vo.setKeisaiTanka((String)result.get(TBTHB5HIK.KEISAITANKA));        //�f�ڒP��
                vo.setKeisaiCnt((String)result.get(TBTHB5HIK.KEISAICNT));            //�f�ډ�
                vo.setSyohiKbn((String)result.get(TBTHB5HIK.SYOHIKBN));              //���i�敪
                vo.setSaiKbn((String)result.get(TBTHB5HIK.SAIKBN));                  //�זڋ敪
                vo.setTekiCd((String)result.get(TBTHB5HIK.TEKICD));                  //�E�v�R�[�h
                vo.setUriyymm((String)result.get(TBTHB5HIK.URIYYMM));                //����\��N��
                vo.setTanName((String)result.get(TBTHB5HIK.TANNAME));                //�S���Җ�
                vo.setTankinName((String)result.get(TBTHB5HIK.TANKINNAME));          //�S���ҋΖ�������
                vo.setAnsyube((String)result.get(TBTHB5HIK.ANSYUBE));                //�����
                vo.setKouKbn((String)result.get(TBTHB5HIK.KOUKBN));                  //�X�V�敪
                vo.setBikou1((String)result.get(TBTHB5HIK.BIKOU1));                  //���l1
                vo.setBikou2((String)result.get(TBTHB5HIK.BIKOU2));                  //���l2
                vo.setColorCd((String)result.get(TBTHB5HIK.COLORCD));                //�F���R�[�h
                vo.setSpaceCd((String)result.get(TBTHB5HIK.SPACECD));                //�X�y�[�X�R�[�h
                vo.setSpaceName((String)result.get(TBTHB5HIK.SPACENAME));            //�X�y�[�X����
                vo.setSybt1Cd((String)result.get(TBTHB5HIK.SYBT1CD));                //��ʂP�R�[�h
                vo.setSybt2Cd((String)result.get(TBTHB5HIK.SYBT2CD));                //��ʂQ�R�[�h
                vo.setDesignCnt((String)result.get(TBTHB5HIK.DESIGNCNT));            //�f�U�C���ύX��
                vo.setPlaceCd((String)result.get(TBTHB5HIK.PLACECD));                //�f�ڏꏊ�R�[�h
                vo.setPrintryo((BigDecimal)result.get(TBTHB5HIK.PRINTRYO));          //�����
                vo.setSashikaeryo((BigDecimal)result.get(TBTHB5HIK.SASHIKAERYO));    //���֍�Ɨ�
                vo.setDesignryo((BigDecimal)result.get(TBTHB5HIK.DESIGNRYO));        //�f�U�C����
                vo.setHanshitaryo((BigDecimal)result.get(TBTHB5HIK.HANSHITARYO));    //�ŉ���
                vo.setSeihanryo((BigDecimal)result.get(TBTHB5HIK.SEIHANRYO));        //���ő�
                vo.setTouDate((String)result.get(TBTHB5HIK.TOUDATE));                //�o�^�N����
                vo.setHenDate((String)result.get(TBTHB5HIK.HENDATE));                //�ύX�N����
                vo.setTorDate((String)result.get(TBTHB5HIK.TORDATE));                //����N����
                vo.setKouKbnName((String)result.get("KOUKBNNAME"));                //�X�V�敪��
                vo.setDummy1((String)result.get("DUMMY1"));                        //�_�~�[1
                vo.setDummy2((String)result.get("DUMMY2"));                        //�_�~�[2

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }
        return list;
    }

    private String getWhere(String Sybt,boolean InqFlg){

        StringBuilder sql = new StringBuilder();

        sql.append(" WHERE ");
        sql.append(TBTHB5HIK.TKSKGYCD );                    //���Ӑ�R�[�h
        sql.append(" = ");
        sql.append("'" + _cond.getTkskgycd() + "'");
        sql.append(" AND ");

        sql.append(TBTHB5HIK.TKSBMNSEQNO );                  //���Ӑ敔��SEQNO
        sql.append(" = ");
        sql.append("'" + _cond.getTksbmnseqno() + "'");
        sql.append(" AND ");

        sql.append(TBTHB5HIK.TKSTNTSEQNO );                  //���Ӑ�S��SEQNO
        sql.append(" = ");
        sql.append("'" + _cond.getTkstntseqno() + "'");
        sql.append(" AND ");

        sql.append(TBTHB5HIK.IRBAN);                          //�����ԍ�
        sql.append(" = ");
        sql.append("'" + _cond.getIrban() + "'");
        sql.append(" AND ");

        sql.append(TBTHB5HIK.IRROWBAN);                       //�����s�ԍ�
        sql.append(" = ");
        sql.append("'" + _cond.getIrrowban() + "'");
        sql.append(" AND ");

        sql.append(TBTHB5HIK.RECCD);                          //���R�[�h���
        sql.append(" = ");
        sql.append("'" + _cond.getRecCd() + "'");
        sql.append(" AND ");

        //�}�̂��y�V���z�ȊO�̏ꍇ
        if(Sybt.equals(BAICD_SHINBUN ) == false){
            sql.append(TBTHB5HIK.SYBT );                       //�}�̃R�[�h
            sql.append(" = ");
            sql.append("'" + _cond.getSyubetsu() + "'");
            sql.append(" AND ");
        }

        //In�N�G���[�̏ꍇ�A"AND"����������
        if(InqFlg == true){
            return sql.toString().substring(0,sql.length() - 5);
        }
        return sql.toString();
    }

}
