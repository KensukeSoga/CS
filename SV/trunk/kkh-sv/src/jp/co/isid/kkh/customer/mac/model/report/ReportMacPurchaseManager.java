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
public class ReportMacPurchaseManager {

    /** �V���O���g���C���X�^���X */
    private static ReportMacPurchaseManager _manager = new ReportMacPurchaseManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportMacPurchaseManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportMacPurchaseManager getInstance() {
        return _manager;
    }

    /**
     * ���[�f�[�^(TOH)���������܂��B
     *
     * @return ReportMacResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportMacPurchaseResult findByCondition(ReportMacPurchaseCondition cond) throws KKHException {

        //��������
        ReportMacPurchaseResult result = new ReportMacPurchaseResult();

        //******************************************************
        //�L����׃f�[�^���擾
        //******************************************************
        ReportMacPurchaseDAO reportMacDAO = ReportMacPurchaseDAOFactory.createReportMacRequestDAO();

        List<ReportMacPurchaseVO> list = reportMacDAO.findReportMacPurchaseByCondition(cond);
        result.setReportMacPurchase(list);

        return result;
    }

}
