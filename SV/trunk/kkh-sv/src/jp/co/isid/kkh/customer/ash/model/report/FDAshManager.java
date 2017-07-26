package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �����f�[�^�iAsh�j����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * </P>
 * @author
 */
public class FDAshManager {

    /** �V���O���g���C���X�^���X */
    private static FDAshManager _manager = new FDAshManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private FDAshManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static FDAshManager getInstance() {
        return _manager;
    }

    /**
     * �����f�[�^�ꗗ���������܂��B
     * @return FDAshResult �����f�[�^�ꗗ�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public FDAshResult findByCondition(ReportAshMediaCondition cond) throws KKHException {
        //��������
        FDAshResult result = new FDAshResult();

        //******************************************************
        //�}�̎�ʃf�[�^���擾
        //******************************************************
        FDAshDAO FDAshDAO = FDAshDAOFactory.createFDAshDAO();
        List<FDAshVO> list = FDAshDAO.findFDAshByCondition(cond);
        result.setFDAsh(list);

        return result;
    }

}
