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
public class ReportMacManager {

    /** �V���O���g���C���X�^���X */
    private static ReportMacManager _manager = new ReportMacManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportMacManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportMacManager getInstance() {
        return _manager;
    }

    /**
     * ���[�f�[�^(TOH)���������܂��B
     *
     * @return ReportMacResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportMacResult findByCondition(ReportMacCondition cond) throws KKHException {
        //��������
        ReportMacResult result = new ReportMacResult();

        //******************************************************
        //�L����׃f�[�^���擾
        //******************************************************
        ReportMacDAO reportMacDAO = ReportMacDAOFactory.createReportMacDAO();

        List<ReportMacVO> list = reportMacDAO.findReportMacByCondition(cond);
        result.setReportMac(list);

        return result;
    }

}
