package jp.co.isid.kkh.customer.mac.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;
/**
 * <P>
 * ���[�iMAC)�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/1/12 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportMacLicenseeManager {

    /** �V���O���g���C���X�^���X */
    private static ReportMacLicenseeManager _manager = new ReportMacLicenseeManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportMacLicenseeManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportMacLicenseeManager getInstance() {
        return _manager;
    }

    /**
     * ���[�f�[�^(MAC)���������܂��B
     *
     * @return ReportMacResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportMacLicenseeResult findByCondition(ReportMacCondition cond) throws KKHException {
    	//��������
    	ReportMacLicenseeResult result = new ReportMacLicenseeResult();

    	//******************************************************
    	//�L����׃f�[�^���擾
    	//******************************************************
    	ReportMacLicenseeDAO reportMacLicenseeDAO = ReportMacLicenseeDAOFactory.createReportMacLicenseeDAO();
    	List<ReportMacLicenseeVO> list = reportMacLicenseeDAO.findReportMacByCondition(cond);
    	result.setReportMac(list);

        return result;

    }



}
