package jp.co.isid.kkh.model.history;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �����iLion)����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/2/1 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class HistoryJyutDownManager {

    /** �V���O���g���C���X�^���X */
    private static HistoryJyutDownManager _manager = new HistoryJyutDownManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private HistoryJyutDownManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static HistoryJyutDownManager getInstance() {
        return _manager;
    }

    /**
     * ���[�f�[�^(Ash)���������܂��B
     *
     * @return ReportAshMediaResult �}�̎�ʈꗗ�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public HistoryJyutDownResult findByCondition(HistoryJyutDownCondition cond) throws KKHException {
        //��������
        HistoryJyutDownResult result = new HistoryJyutDownResult();

        //******************************************************
        //�}�̎�ʃf�[�^���擾
        //******************************************************
        HistoryJyutDownDAO HisLionDAO = HistoryJyutDownDAOFactory.createHistoryLionJyutDownDAO();
        List<HistoryJyutDownVO> list = HisLionDAO.findReportMacByCondition(cond);
        result.setReportAsh(list);

        return result;
    }

}
