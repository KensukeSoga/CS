package jp.co.isid.kkh.customer.acom.model.input;

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
 * �����f�[�^����DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/08 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
public class HikSearchDateCntDAO extends AbstractRdbDao {

    /**�}�X�^�������� */
    private HikCommonCondition _cond;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public HikSearchDateCntDAO() {
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

        //SELECT��
        sql.append(" SELECT ");
        sql.append( TBTHB5HIK.IRBAN  + ",");
        sql.append( TBTHB5HIK.IRROWBAN);

        //FROM��
        sql.append(" FROM ");
        sql.append(TBTHB5HIK.TBNAME);

        //WHRE��
        sql.append(" WHERE ");
        sql.append(TBTHB5HIK.TKSKGYCD  + " = " + "'" + _cond.getTkskgycd() + "'");
        sql.append(" AND ");
        sql.append(TBTHB5HIK.TKSBMNSEQNO + " = " + "'" +  _cond.getTksbmnseqno() + "'");
        sql.append(" AND ");
        sql.append( TBTHB5HIK.TKSTNTSEQNO  + " = " + "'" +_cond.getTkstntseqno() + "'");
        sql.append(" AND ");
        sql.append(TBTHB5HIK.RECCD + " = " + "'" +_cond.getRecCd() + "'");
        sql.append(" AND ");
        sql.append( TBTHB5HIK.IRBAN  + " = " + "'" + _cond.getIrban() + "'");
        sql.append(" AND ");
        sql.append( TBTHB5HIK.SYBT  + " = " + "'" + _cond.getSyubetsu() + "'");
        sql.append(" AND ");
        sql.append( TBTHB5HIK.IRROWBAN + " = " + "'" + _cond.getIrrowban() + "'");

        return sql.toString();
    }

    /**
     * �����e�[�u���̌������s���܂��B
     *
     * @return �����e�[�u��VO���X�g
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<HikSearchDateCntVO> findByCondition(HikCommonCondition cond) throws KKHException {

        super.setModel(new HikSearchDateCntVO());

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
    protected List<HikSearchDateCntVO> createFindedModelInstances(List hashList) {
        List<HikSearchDateCntVO> list = new ArrayList<HikSearchDateCntVO>();
        if (getModel() instanceof HikSearchDateCntVO) {
            for (int i = 0; i < hashList.size(); i++) {
                Map result = (Map) hashList.get(i);
                HikSearchDateCntVO vo = new HikSearchDateCntVO();
                //VOList�ɓ��꒼���������s��
                vo.setIrban((String)result.get(TBTHB5HIK.IRBAN));         //�����ԍ�
                vo.setIrrowban((String)result.get(TBTHB5HIK.IRROWBAN));   //�����s�ԍ�

                // �������ʒ���̏�Ԃɂ���
                ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
            }
        }

        return list;
    }

}
