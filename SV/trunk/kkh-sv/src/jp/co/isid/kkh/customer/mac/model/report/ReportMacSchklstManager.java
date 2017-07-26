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
public class ReportMacSchklstManager {

    /** �V���O���g���C���X�^���X */
    private static ReportMacSchklstManager _manager = new ReportMacSchklstManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportMacSchklstManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportMacSchklstManager getInstance() {
        return _manager;
    }

    /**
     * ���[�f�[�^(TOH)���������܂��B
     *
     * @return ReportMacResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportMacSchklstResult findByCondition(ReportMacSchklstCondition cond) throws KKHException {
        //��������
        ReportMacSchklstResult result = new ReportMacSchklstResult();

        //******************************************************
        //�L����׃f�[�^���擾
        //******************************************************
        ReportMacSchklstDAO reportMacDAO = ReportMacSchklstDAOFactory.createReportMacSchklstDAO();

        List<ReportMacSchklstVO> list = reportMacDAO.findReportMacSchklstByCondition(cond);
        result.setReportMacSchklst(list);

        return result;
    }

}
