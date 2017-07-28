package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���[�iMAC)�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE KT)<BR>
 * </P>
 * @author
 */
public class ReportMacRequestManager {

    /** �V���O���g���C���X�^���X */
    private static ReportMacRequestManager _manager = new ReportMacRequestManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportMacRequestManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportMacRequestManager getInstance() {
        return _manager;
    }

    /**
     * ���[�f�[�^(TOH)���������܂��B
     *
     * @return ReportMacResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportMacRequestResult findByCondition(ReportMacRequestCondition cond) throws KKHException {
        //��������
        ReportMacRequestResult result = new ReportMacRequestResult();

        //******************************************************
        //�L����׃f�[�^���擾
        //******************************************************
        ReportMacRequestDAO reportMacDAO = ReportMacRequestDAOFactory.createReportMacRequestDAO();

        List<ReportMacRequestVO> list = reportMacDAO.findReportMacRequestByCondition(cond);
        result.setReportMacRequest(list);

        return result;
    }

}
