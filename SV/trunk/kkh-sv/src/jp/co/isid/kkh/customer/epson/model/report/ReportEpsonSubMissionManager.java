package jp.co.isid.kkh.customer.epson.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ��o���[�i�G�v�\��)�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/5 JSE YS)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSubMissionManager {

    /** �V���O���g���C���X�^���X */
    private static ReportEpsonSubMissionManager _manager = new ReportEpsonSubMissionManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportEpsonSubMissionManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportEpsonSubMissionManager getInstance() {
        return _manager;
    }

    /**
     * ��o���[�f�[�^(�G�v�\��)���������܂��B
     *
     * @return ReportEpsonSubMissionResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportEpsonSubMissionResult findByCondition(ReportEpsonSubMissionCondition cond) throws KKHException {

        // ��������
        ReportEpsonSubMissionResult result = new ReportEpsonSubMissionResult();

        //******************************************************
        // ��o���[�f�[�^���擾
        //******************************************************
        ReportEpsonSubMissionDAO reportDAO = ReportEpsonSubMissionDAOFactory.createReportEpsonSubMissionDAO();
        List<ReportEpsonSubMissionVO> list = reportDAO.findReportEpsonSubMissionByCondition(cond);
        result.setReportEpsonSubMission(list);

        return result;
    }
}
