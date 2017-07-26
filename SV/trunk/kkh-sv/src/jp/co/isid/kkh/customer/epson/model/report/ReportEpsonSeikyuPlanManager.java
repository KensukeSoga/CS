package jp.co.isid.kkh.customer.epson.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �����\��ꗗ�i�G�v�\��)�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/9 IP JK)<BR>
 * </P>
 * @author
 */
public class ReportEpsonSeikyuPlanManager {

    /** �V���O���g���C���X�^���X */
    private static ReportEpsonSeikyuPlanManager _manager = new ReportEpsonSeikyuPlanManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportEpsonSeikyuPlanManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportEpsonSeikyuPlanManager getInstance() {
        return _manager;
    }

    /**
     * �����\��ꗗ�f�[�^(�G�v�\��)���������܂��B
     *
     * @return ReportEpsonSeikyuPlanResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportEpsonSeikyuPlanResult findByCondition(ReportEpsonSeikyuPlanCondition cond) throws KKHException {

        // ��������
        ReportEpsonSeikyuPlanResult result = new ReportEpsonSeikyuPlanResult();

        //******************************************************
        // ��o���[�f�[�^���擾
        //******************************************************
        ReportEpsonSeikyuPlanDAO reportDAO = ReportEpsonSeikyuPlanDAOFactory.createReportEpsonSeikyuPlanDAO();
        List<ReportEpsonSeikyuPlanVO> list = reportDAO.findReportEpsonSeikyuPlanByCondition(cond);
        result.setReportEpsonSeikyuPlan(list);

        return result;
    }
}
