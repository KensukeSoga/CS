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
 * �E�V�K�쐬(2011/11/08 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
public class HikDAO extends AbstractRdbDao {

    public static final String  BAICD_ZASI     = "22";//�G��
    public static final String  BAICD_SHINBUN  = "21";//�V��
    public static final String  BAICD_DENP     = "11";//�d�g
    public static final String  BAICD_KOTU     = "31";//���

    /**�}�X�^�������� */
    private HikCommonCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public HikDAO() {
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
        sql.append("A." + TBTHB5HIK.KOUKBN + ",");        //�X�V�敪
        sql.append("A." + TBTHB5HIK.RIRENO + ",");        //�����Ǘ��ԍ�
        sql.append("A." + TBTHB5HIK.IRYYMM + ",");        //�˗��N��
        sql.append("A." + TBTHB5HIK.IRBAN + ",");         //�����ԍ�
        sql.append("A." + TBTHB5HIK.IRROWBAN + ",");      //�s�ԍ�
        sql.append("A." + TBTHB5HIK.MEDIACD + ",");       //���f�B�A�R�[�h
        sql.append("A." + TBTHB5HIK.MEDIANAME + ",");     //���f�B�A��
        sql.append("A." + TBTHB5HIK.SIZECD + ",");        //�T�C�Y�R�[�h
        sql.append("A." + TBTHB5HIK.SIZENAME + ",");      //�T�C�Y
        sql.append("A." + TBTHB5HIK.KEISAI1 + ",");       //�f�ړ�1
        sql.append("A." + TBTHB5HIK.KEISAI2 + ",");       //�f�ړ�2
        sql.append("A." + TBTHB5HIK.KEISAI3 + ",");       //�f�ړ�3
        sql.append("A." + TBTHB5HIK.KEISAI4 + ",");       //�f�ړ�4
        sql.append("A." + TBTHB5HIK.KEISAI5 + ",");       //�f�ړ�5
        sql.append("A." + TBTHB5HIK.KEITAICD + ",");      //�`�ԋ敪�R�[�h
        sql.append("A." + TBTHB5HIK.KEITAINAME + ",");    //�`�ԋ敪��
        sql.append("A." + TBTHB5HIK.IRMONTH1 + ",");      //�˗���1
        sql.append("A." + TBTHB5HIK.HOSORYO1  + ",");     //������1
        sql.append("A." + TBTHB5HIK.IRMONTH2 + ",");      //�˗���2
        sql.append("A." + TBTHB5HIK.HOSORYO2 + ",");      //������2
        sql.append("A." + TBTHB5HIK.IRMONTH3 + ",");      //�˗���3
        sql.append("A." + TBTHB5HIK.HOSORYO3 + ",");      //������3
        sql.append("A." + TBTHB5HIK.IRMONTH4 + ",");      //�˗���4
        sql.append("A." + TBTHB5HIK.HOSORYO4 + ",");      //������4
        sql.append("A." + TBTHB5HIK.IRMONTH5 + ",");      //�˗���5
        sql.append("A." + TBTHB5HIK.HOSORYO5 + ",");      //������5
        sql.append("A." + TBTHB5HIK.IRMONTH6 + ",");      //�˗���6
        sql.append("A." + TBTHB5HIK.HOSORYO6 + ",");      //������6
        sql.append("A." + TBTHB5HIK.KOTUKEICD + ",");     //��ʌf�ڃR�[�h
        sql.append("A." + TBTHB5HIK.KOTUKEINAME + ",");   //��ʌf�ږ�
        sql.append("A." + TBTHB5HIK.KEISAI + ",");        //�f�ړ�
        sql.append("A." + TBTHB5HIK.KEISAIRYO + ",");     //�f�ڗ�
        sql.append("A." + TBTHB5HIK.KEISAITANKA + ",");   //�f�ڒP��
        sql.append("A." + TBTHB5HIK.KEISAICNT + ",");     //�f�ډ�
        sql.append("A." + TBTHB5HIK.SYOHIKBN + ",");      //���i�敪
        sql.append("A." + TBTHB5HIK.SAIKBN + ",");        //�זڋ敪
        sql.append("A." + TBTHB5HIK.TEKICD + ",");        //�E�v�R�[�h
        sql.append("A." + TBTHB5HIK.URIYYMM + ",");       //����\��N��
        sql.append("A." + TBTHB5HIK.TANNAME + ",");       //�S���Җ�
        sql.append("A." + TBTHB5HIK.TANKINNAME + ",");    //�S���ҋΖ�������
        sql.append("A." + TBTHB5HIK.ANSYUBE + ",");       //�����
        sql.append("A." + TBTHB5HIK.BIKOU1 + ",");        //���l1
        sql.append("A." + TBTHB5HIK.BIKOU2 + ",");        //���l2
        sql.append("A." + TBTHB5HIK.COLORCD + ",");       //�F���R�[�h
        sql.append("A." + TBTHB5HIK.SPACECD + ",");       //�X�y�[�X�R�[�h
        sql.append("A." + TBTHB5HIK.SYBT1CD + ",");       //��ʂP�R�[�h
        sql.append("A." + TBTHB5HIK.SYBT2CD + ",");       //��ʂQ�R�[�h
        sql.append("A." + TBTHB5HIK.DESIGNCNT + ",");     //�f�U�C���ύX��
        sql.append("A." + TBTHB5HIK.PLACECD + ",");       //�f�ڏꏊ�R�[�h
        sql.append("A." + TBTHB5HIK.PRINTRYO + ",");      //�����
        sql.append("A." + TBTHB5HIK.SASHIKAERYO + ",");   //���֍�Ɨ�
        sql.append("A." + TBTHB5HIK.DESIGNRYO + ",");     //�f�U�C����
        sql.append("A." + TBTHB5HIK.HANSHITARYO + ",");   //�ŉ���
        sql.append("A." + TBTHB5HIK.SEIHANRYO + ",");     //���ő�
        sql.append("A." + TBTHB5HIK.TOUDATE + ",");       //�o�^�N����
        sql.append("A." + TBTHB5HIK.HENDATE + ",");       //�ύX�N����
        sql.append("A." + TBTHB5HIK.TORDATE + ",");       //����N����

        //�ŐV�f�[�^�t���O�擾SQL
        sql.append(" DECODE(  ");                     //�ŐV�f�[�^�t���O
        sql.append("A." + TBTHB5HIK.RIRENO  + ",");
        sql.append(" ( SELECT ");
        sql.append(" MAX( " + TBTHB5HIK.RIRENO +  ")");
        sql.append(" FROM ");
        sql.append(TBTHB5HIK.TBNAME);
        sql.append(getWhere(TBTHB5HIK.TKSKGYCD,TBTHB5HIK.TKSBMNSEQNO,TBTHB5HIK.TKSTNTSEQNO,TBTHB5HIK.SYBT,true));
        sql.append(" GROUP BY ");
        sql.append(TBTHB5HIK.IRBAN + ",");
        sql.append(TBTHB5HIK.IRROWBAN );
        sql.append(" ), '1' ) AS SAISINFLG ,");

        //�X�V�敪���쐬SQL
        sql.append(" CASE ");
        //�X�V�敪��

        //�ύX���Ȃ���������邩�m�F �� ���
        sql.append(" WHEN TRIM(" + "A." + TBTHB5HIK.TORDATE +  ") is null AND "  +
                         "TRIM(" + "A." + TBTHB5HIK.HENDATE +  ") is not null  THEN '�ύX'");

        //�ύX�������Ď�����Ȃ����m�F �� �ύX
        sql.append(" WHEN TRIM(" + "A." + TBTHB5HIK.HENDATE +  ") is null AND "  +
                         "TRIM(" + "A." + TBTHB5HIK.TORDATE +  ") is not null  THEN '���'");

        //�ύX��������傫�����m�F �� �ύX
        sql.append(" WHEN " + "A." + TBTHB5HIK.HENDATE + " > " + "A." + TBTHB5HIK.TORDATE + " THEN '�ύX'");

        //�ύX�������菬�������m�F �� ���
        sql.append(" WHEN " + "A." + TBTHB5HIK.TORDATE + " > " + "A." + TBTHB5HIK.HENDATE + " THEN '���'");

        sql.append(" ELSE '�V�K' ");
        sql.append(" END AS KOUKBNNAME ");

        if(_cond.getSyubetsu().compareTo(BAICD_SHINBUN) == 0)
        {
            //�X�e�[�^�X
            sql.append(" ,");
            sql.append(" CASE ");
            sql.append(" WHEN TRIM(" + "A." + TBTHB5HIK.SPACECD + ") is null THEN '��߰��ϊ��װ' ");
            sql.append(" WHEN TRIM(" + "A." + TBTHB5HIK.MEDIACD + ") is null THEN '�}�̕ϊ��װ' ");
            sql.append(" ELSE '����' ");
            sql.append(" END AS STATUS ");

            //�X�y�[�X��
            sql.append(" , ");
            sql.append(" CASE ");
            sql.append(" WHEN TRIM(B.HBA_FIELD3) is null THEN '���o�^' ");
            sql.append(" ELSE B.HBA_FIELD3");
            sql.append(" END AS " + TBTHB5HIK.SPACENAME);
        }

        //FROM��
        //�}�̃R�[�h���y�V���z�݂̂̏ꍇ
        if(_cond.getSyubetsu().compareTo(BAICD_SHINBUN) == 0)
        {
            sql.append(" FROM ");
            sql.append(TBTHB5HIK.TBNAME  + " A LEFT JOIN ");
            sql.append("THBAMST B ON ");
            sql.append("HBA_SYBT = '907'");
            sql.append(" AND ");
            sql.append("HBA_TKSKGYCD = '" + _cond.getTkskgycd().substring(0,6)  + "'");
            sql.append(" AND ");
            sql.append("A." + TBTHB5HIK.SPACECD + " = HBA_FIELD2");
            sql.append(" AND ");
            sql.append("HBA_FIELD1 = '02'");
            //sql.append(getWhere(_cond.getTkskgycd(),_cond.getTksbmnseqno(),_cond.getTkstntseqno(),_cond.getSyubetsu(),false));
        }
        //�}�̃R�[�h���y�V���z�ȊO�̏ꍇ
        else
        {
            sql.append(" FROM ");
            sql.append(TBTHB5HIK.TBNAME  + " A");
        }

        //WHERE��
        sql.append(getWhere(_cond.getTkskgycd(),_cond.getTksbmnseqno(),_cond.getTkstntseqno(),_cond.getSyubetsu(),false));

        //�}�̃R�[�h���y�d�g�z�̏ꍇ
        if(_cond.getSyubetsu().compareTo(BAICD_DENP) == 0){
            sql.append(" AND ");
            sql.append("(" + "A." + TBTHB5HIK.IRYYMM);            //�˗��N��
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "'");
            sql.append(" OR ");

            sql.append("A." + TBTHB5HIK.IRMONTH2);                //�˗���2
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "'");
            sql.append(" OR ");

            sql.append("A." + TBTHB5HIK.IRMONTH3);                //�˗���3
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "'");
            sql.append(" OR ");

            sql.append("A." + TBTHB5HIK.IRMONTH4);                //�˗���4
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "'");
            sql.append(" OR ");

            sql.append("A." + TBTHB5HIK.IRMONTH5);                //�˗���5
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "'");
            sql.append(" OR ");

            sql.append("A." + TBTHB5HIK.IRMONTH6);                //�˗���6
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "' ) ");
        }
        //�}�̃R�[�h���y�V���z�̏ꍇ
        else if(_cond.getSyubetsu().compareTo(BAICD_SHINBUN) == 0){
            sql.append(" AND ");
            sql.append("A." + TBTHB5HIK.RECCD);                  //���R�[�h���
            sql.append(" = ");
            sql.append("'H'");

            sql.append(" AND ");
            sql.append("A." + TBTHB5HIK.IRYYMM);                 //�˗��N��
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "'");
        }
        else{
            sql.append(" AND ");
            sql.append("A." + TBTHB5HIK.IRYYMM);                 //�˗��N��
            sql.append(" = ");
            sql.append("'" + _cond.getYear() + "'");
        }

        sql.append(" ORDER BY ");
        sql.append("A." + TBTHB5HIK.IRBAN + ",");                 //�����ԍ�
        sql.append("A." + TBTHB5HIK.IRROWBAN + ",");              //�s�ԍ�
        sql.append("A." + TBTHB5HIK.RIRENO );                     //�����Ǘ��ԍ�

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
                vo.setKouKbn(((String)result.get(TBTHB5HIK.KOUKBN)).trim());                  //�X�V�敪
                vo.setRireNo(((String)result.get(TBTHB5HIK.RIRENO)).trim());                  //�����Ǘ��ԍ�
                vo.setIryymm(((String)result.get(TBTHB5HIK.IRYYMM)).trim());                  //�˗��N��
                vo.setIrban((((String)result.get(TBTHB5HIK.IRBAN))).trim());                  //�����ԍ�
                vo.setIrrowban(((String)result.get(TBTHB5HIK.IRROWBAN)).trim());              //�s�ԍ�
                vo.setMediaCd(((String)result.get(TBTHB5HIK.MEDIACD)).trim());                //���f�B�A�R�[�h
                vo.setMediaName(((String)result.get(TBTHB5HIK.MEDIANAME)).trim());            //���f�B�A��
                vo.setSizeCd(((String)result.get(TBTHB5HIK.SIZECD)).trim());                  //�T�C�Y�R�[�h
                vo.setKeisai1(((String)result.get(TBTHB5HIK.KEISAI1)).trim());                //�f�ړ�1
                vo.setKeisai2(((String)result.get(TBTHB5HIK.KEISAI2)).trim());                //�f�ړ�2
                vo.setKeisai3(((String)result.get(TBTHB5HIK.KEISAI3)).trim());                //�f�ړ�3
                vo.setKeisai4(((String)result.get(TBTHB5HIK.KEISAI4)).trim());                //�f�ړ�4
                vo.setKeisai5(((String)result.get(TBTHB5HIK.KEISAI5)).trim());                //�f�ړ�5
                vo.setKeitaiCd(((String)result.get(TBTHB5HIK.KEITAICD)).trim());              //�`�ԋ敪�R�[�h
                vo.setKeitaiName(((String)result.get(TBTHB5HIK.KEITAINAME)).trim());          //�`�ԋ敪��
                vo.setIrmonth1(((String)result.get(TBTHB5HIK.IRMONTH1)).trim());              //�˗���1
                vo.setHosoryo1(((BigDecimal)result.get(TBTHB5HIK.HOSORYO1)));                 //������1
                vo.setIrmonth2(((String)result.get(TBTHB5HIK.IRMONTH2)).trim());              //�˗���2
                vo.setHosoryo2((BigDecimal)result.get(TBTHB5HIK.HOSORYO2));                   //������2
                vo.setIrmonth3(((String)result.get(TBTHB5HIK.IRMONTH3)).trim());              //�˗���3
                vo.setHosoryo3((BigDecimal)result.get(TBTHB5HIK.HOSORYO3));                   //������3
                vo.setIrmonth4(((String)result.get(TBTHB5HIK.IRMONTH4)).trim());              //�˗���4
                vo.setHosoryo4((BigDecimal)result.get(TBTHB5HIK.HOSORYO4));                   //������4
                vo.setIrmonth5(((String)result.get(TBTHB5HIK.IRMONTH5)).trim());              //�˗���5
                vo.setHosoryo5((BigDecimal)result.get(TBTHB5HIK.HOSORYO5));                   //������5
                vo.setIrmonth6(((String)result.get(TBTHB5HIK.IRMONTH6)).trim());              //�˗���6
                vo.setHosoryo6((BigDecimal)result.get(TBTHB5HIK.HOSORYO6));                   //������6
                vo.setKotukeiCd(((String)result.get(TBTHB5HIK.KOTUKEICD)).trim());            //��ʌf�ڃR�[�h
                vo.setKotukeiName((String)result.get(TBTHB5HIK.KOTUKEINAME));                 //��ʌf�ږ�

                //�V���̏ꍇ,
                if(_cond.getSyubetsu().compareTo(BAICD_SHINBUN) == 0)
                {
                    int DataMax = Integer.parseInt(((String)result.get(TBTHB5HIK.KEISAICNT)).trim());
                    String tmp = "";
                    String chdata = ((String)result.get(TBTHB5HIK.KEISAI)).trim();
                    int pos = 1;

                    for(int cnt = 0; cnt < DataMax;cnt++){
                        pos = chdata.indexOf("1",pos);  //�����񂩂�1�̈ʒu���擾
                        if(pos == -1){
                            break;

                        }else{
                            tmp = tmp +  "," + String.format("%1$02d",pos + 1);
                            pos = pos + 1;
                        }
                    }

                    //�擪�̃J���}����������
                    if(tmp.length() > 1){
                        tmp = tmp.substring(1,tmp.length());
                    }

                    vo.setKeisai(tmp);                  //�f�ړ�
                    vo.setSpaceName(((String)result.get(TBTHB5HIK.SPACENAME)).trim());   //�X�y�[�X
                }
                else
                {
                    vo.setKeisai(((String)result.get(TBTHB5HIK.KEISAI)).trim());      //�f�ړ�
                    vo.setSizeName(((String)result.get(TBTHB5HIK.SIZENAME)).trim());   //�T�C�Y
                }

                vo.setKeisairyo((BigDecimal)result.get(TBTHB5HIK.KEISAIRYO));                 //�f�ڗ�
                vo.setKeisaiTanka(((String)result.get(TBTHB5HIK.KEISAITANKA)).trim());        //�f�ڒP��
                vo.setKeisaiCnt(((String)result.get(TBTHB5HIK.KEISAICNT)).trim());            //�f�ډ�
                vo.setSyohiKbn(((String)result.get(TBTHB5HIK.SYOHIKBN)).trim());              //���i�敪
                vo.setSaiKbn(((String)result.get(TBTHB5HIK.SAIKBN)).trim());                  //�זڋ敪
                vo.setTekiCd(((String)result.get(TBTHB5HIK.TEKICD)).trim());                  //�E�v�R�[�h
                vo.setUriyymm(((String)result.get(TBTHB5HIK.URIYYMM)).trim());                //����\��N��
                vo.setTanName(((String)result.get(TBTHB5HIK.TANNAME)).trim());                //�S���Җ�
                vo.setTankinName(((String)result.get(TBTHB5HIK.TANKINNAME)).trim());          //�S���ҋΖ�������
                vo.setAnsyube(((String)result.get(TBTHB5HIK.ANSYUBE)).trim());                //�����
                vo.setBikou1((String)result.get(TBTHB5HIK.BIKOU1));                           //���l1
                vo.setBikou2((String)result.get(TBTHB5HIK.BIKOU2));                           //���l2
                vo.setColorCd((String)result.get(TBTHB5HIK.COLORCD));                         //�F���R�[�h
                vo.setSpaceCd((String)result.get(TBTHB5HIK.SPACECD));                         //�X�y�[�X�R�[�h
                vo.setSybt1Cd((String)result.get(TBTHB5HIK.SYBT1CD));                         //��ʂP�R�[�h
                vo.setSybt2Cd((String)result.get(TBTHB5HIK.SYBT2CD));                         //��ʂQ�R�[�h
                vo.setDesignCnt((String)result.get(TBTHB5HIK.DESIGNCNT));                     //�f�U�C���ύX��
                vo.setPlaceCd((String)result.get(TBTHB5HIK.PLACECD));                         //�f�ڏꏊ�R�[�h
                vo.setPrintryo((BigDecimal)result.get(TBTHB5HIK.PRINTRYO));                   //�����
                vo.setSashikaeryo((BigDecimal)result.get(TBTHB5HIK.SASHIKAERYO));             //���֍�Ɨ�
                vo.setDesignryo((BigDecimal)result.get(TBTHB5HIK.DESIGNRYO));                 //�f�U�C����
                vo.setHanshitaryo((BigDecimal)result.get(TBTHB5HIK.HANSHITARYO));             //�ŉ���
                vo.setSeihanryo((BigDecimal)result.get(TBTHB5HIK.SEIHANRYO));                 //���ő�
                vo.setTouDate((String)result.get(TBTHB5HIK.TOUDATE));                         //�o�^�N����
                vo.setHenDate((String)result.get(TBTHB5HIK.HENDATE));                         //�ύX�N����
                vo.setTorDate((String)result.get(TBTHB5HIK.TORDATE));                         //����N����
                vo.setSaisinFlg((String)result.get("SAISINFLG"));                           //�ŐV�f�[�^
                vo.setKouKbnName((String)result.get("KOUKBNNAME"));                         //�X�V�敪��
                vo.setStatus((String)result.get("STATUS"));                                 //�X�e�[�^�X

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

    /**
    * Where��̐������s��<br>
    * �E�V�K�쐬(2011/11/10 HLC J.Morobayashi)<BR>
    *
    * @param Tkskgyc
    * @param Tksbmnseqno
    * @param Tkstntseqno
    * @param Syubetsu
    * @param WhereFlg
    * @return tmp �������ꂽWhere�啶����
    *
    */
    private String getWhere(String Tkskgycd,String Tksbmnseqno,String Tkstntseqno,String Syubetsu,Boolean WhereFlg ){
        StringBuilder sql = new StringBuilder();
        String tmp = "";

        sql.append(" WHERE ");
        sql.append("A." + TBTHB5HIK.TKSKGYCD );            //���Ӑ�R�[�h
        sql.append(" = ");
        sql.append("'" + Tkskgycd + "'");
        sql.append(" AND ");

        sql.append("A." + TBTHB5HIK.TKSBMNSEQNO );         //���Ӑ敔��SEQNO
        sql.append(" = ");
        sql.append("'" + Tksbmnseqno + "'");
        sql.append(" AND ");

        sql.append("A." + TBTHB5HIK.TKSTNTSEQNO );         //���Ӑ�S��SEQNO
        sql.append(" = ");
        sql.append("'" + Tkstntseqno + "'");
        sql.append(" AND ");

        sql.append("A." + TBTHB5HIK.SYBT );                //�}�̃R�[�h
        sql.append(" = ");
        sql.append("'" + Syubetsu + "'");

        if(WhereFlg == true){
            sql.append(" AND ");
            sql.append(TBTHB5HIK.IRBAN  + " = " +  "A." + TBTHB5HIK.IRBAN);
            sql.append(" AND ");
            sql.append(TBTHB5HIK.IRROWBAN  + " = "  + "A." + TBTHB5HIK.IRROWBAN);
            tmp = sql.toString().replaceAll("'", "");
        }else{
            tmp = sql.toString();
        }

        return tmp;
    }

}
