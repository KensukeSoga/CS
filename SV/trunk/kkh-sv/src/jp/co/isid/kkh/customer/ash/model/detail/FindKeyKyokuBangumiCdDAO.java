package jp.co.isid.kkh.customer.ash.model.detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

/**
 * <P>
 * �L�[�ǂ̔ԑg�R�[�h��DAO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/08/20 HLC S.Jang)<BR>
 * </P>
 *
 * @author HLC ��(Jang)
 */
public class FindKeyKyokuBangumiCdDAO extends AbstractRdbDao {

    /**�������� */
    private FindKeyKyokuBangumiCdCondition _cond;


    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindKeyKyokuBangumiCdDAO() {
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
        //new String[] {};
        return null;
    }

    /**
     * �e�[�u������Ԃ��܂��B
     *
     * @return String �e�[�u����
     */
    public String getTableName() {
        return "";
    }

    /**
     * �e�[�u���񖼂�Ԃ��܂��B
     *
     * @return String[] �e�[�u����
     */
    public String[] getTableColumnNames() {
        return new String[]{
        };
    }

    /**
     * �f�t�H���g��SQL����Ԃ��܂��B
     *
     * @return String SQL��
     */
    @Override
    public String getSelectSQL() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT");
        sql.append("      A.HBA_FIELD1 AS KYOKUCD,");
        sql.append("      A.HBA_FIELD2 AS KYOKUNAME,");
        sql.append("      A.HBA_FIELD3 AS BANGUMICD,");
        sql.append("      B.HBA_FIELD3 AS KEYBANGUMICD,");
        sql.append("      A.HBA_FIELD4 AS KYOKURYAKUSYOU");
        sql.append(" FROM ");
        sql.append("     THBAMST A,");
        sql.append("     THBAMST B ");
        sql.append(" WHERE ");
        sql.append("     A.HBA_EGCD = '" + this._cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append("     A.HBA_TKSKGYCD = '" + this._cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append("     A.HBA_TKSBMNSEQNO = '" + this._cond.getTksBmnSeqNo()
                + "' ");
        sql.append(" AND ");
        sql.append("     A.HBA_TKSTNTSEQNO = '" + this._cond.getTksTntSeqNo()
                + "' ");
        sql.append(" AND ");
        sql.append("     A.HBA_SYBT = '" + this._cond.getSybt() + "' ");
        sql.append(" AND ");
        sql.append("     SUBSTR(A.HBA_FIELD1,0,1) = SUBSTR(B.HBA_FIELD1,0,1) ");
        sql.append(" AND ");
        sql.append("     A.HBA_EGCD = B.HBA_EGCD ");
        sql.append(" AND ");
        sql.append("     A.HBA_TKSKGYCD = B.HBA_TKSKGYCD ");
        sql.append(" AND ");
        sql.append("     A.HBA_TKSBMNSEQNO = B.HBA_TKSBMNSEQNO ");
        sql.append(" AND ");
        sql.append("     A.HBA_TKSTNTSEQNO = B.HBA_TKSTNTSEQNO ");
        sql.append(" AND ");
        sql.append("     A.HBA_SYBT = B.HBA_SYBT ");
        sql.append(" AND ");
        sql.append("     B.HBA_FIELD1 LIKE '%01'");

        // HLC ��(Jang) ADD START 2014/08/20
        // M50,�S����ǉ����邽�߂�SQL��
        sql.append(" UNION ALL ");
        sql.append(" SELECT ");
        sql.append("    HBA_FIELD1,");
        sql.append("    HBA_FIELD2,");
        sql.append("    HBA_FIELD3,");
        sql.append("    '10',");
        sql.append("    HBA_FIELD4");
        sql.append(" FROM ");
        sql.append("    THBAMST");
        sql.append(" WHERE ");
        sql.append("     HBA_EGCD = '" + this._cond.getEgCd() + "' ");
        sql.append(" AND ");
        sql.append("     HBA_TKSKGYCD = '" + this._cond.getTksKgyCd() + "' ");
        sql.append(" AND ");
        sql.append("     HBA_TKSBMNSEQNO = '" + this._cond.getTksBmnSeqNo()
                + "' ");
        sql.append(" AND ");
        sql.append("     HBA_TKSTNTSEQNO = '" + this._cond.getTksTntSeqNo()
                + "' ");
        sql.append(" AND ");
        sql.append("     HBA_SYBT = '" + this._cond.getSybt() + "' ");
        sql.append(" AND ");
        sql.append("     HBA_FIELD1 LIKE 'M%'");
        // HLC ��(Jang) ADD END 2014/08/20

        sql.append(" ORDER BY ");
        sql.append("     KYOKUCD");

        return sql.toString();
    }

    /**
     * �L�[�ǂ̔ԑg�R�[�h�̃f�[�^���������܂��B
     *
     * @return �L�[�ǂ̔ԑg�R�[�h��Condition
     * @throws UserException �f�[�^�A�N�Z�X���ɃG���[�����������ꍇ�B
     */
    @SuppressWarnings("unchecked")
    public List<FindKeyKyokuBangumiCdVO> findKeyKyokuBangumiCd(
            FindKeyKyokuBangumiCdCondition cond) throws KKHException {
        super.setModel(new FindKeyKyokuBangumiCdVO());
        try {
            this._cond = cond;
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
     * @return List<DetailDataVO> �ϊ���̌�������
     */
    @Override
    @SuppressWarnings("unchecked")
    protected List createFindedModelInstances(List hashList) {
        List list = new ArrayList();
        for (int i = 0; i < hashList.size(); i++) {
            Map result = (Map) hashList.get(i);
            FindKeyKyokuBangumiCdVO vo = new FindKeyKyokuBangumiCdVO();
            vo.setKYOKUCD((String) result.get("KYOKUCD"));
            vo.setKYOKUNAME((String) result.get("KYOKUNAME"));
            vo.setBANGUMICD((String) result.get("BANGUMICD"));
            vo.setKEYBANGUMICD((String) result.get("KEYBANGUMICD"));
            vo.setKYOKURYAKUSYOU((String) result.get("KYOKURYAKUSYOU"));

            ModelUtils.copyMemberSearchAfterInstace(vo);
            list.add(vo);
        }
        return list;
    }

}
