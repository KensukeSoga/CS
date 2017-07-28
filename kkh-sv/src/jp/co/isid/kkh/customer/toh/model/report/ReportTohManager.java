package jp.co.isid.kkh.customer.toh.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���[�iTOH)�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE KT)<BR>
 * </P>
 * @author
 */
public class ReportTohManager {

    /** �V���O���g���C���X�^���X */
    private static ReportTohManager _manager = new ReportTohManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportTohManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportTohManager getInstance() {
        return _manager;
    }

    /**
     * ���[�f�[�^(TOH)���������܂��B
     *
     * @return ReportTohResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportTohResult findByCondition(ReportTohCondition cond) throws KKHException {
        //��������
        ReportTohResult result = new ReportTohResult();

        //******************************************************
        //�L����׃f�[�^���擾
        //******************************************************
        ReportTohDAO reportTohDAO = ReportTohDAOFactory.createReportTohDAO();

        List<ReportTohVO> list = reportTohDAO.findReportTohByCondition(cond);
        result.setReportToh(list);

        return result;
    }

}
