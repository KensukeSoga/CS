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
public class ReportMacGetDenNumManager {

    /** �V���O���g���C���X�^���X */
    private static ReportMacGetDenNumManager _manager = new ReportMacGetDenNumManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportMacGetDenNumManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportMacGetDenNumManager getInstance() {
        return _manager;
    }

    /**
     * ���[�f�[�^(TOH)���������܂��B
     *
     * @return ReportMacResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportMacGetDenNumResult findByCondition(ReportMacGetDenNumCondition cond) throws KKHException {
        //��������
        ReportMacGetDenNumResult result = new ReportMacGetDenNumResult();

        //******************************************************
        //�L����׃f�[�^���擾
        //******************************************************
        ReportMacGetDenNumDAO reportMacDAO = ReportMacGetDenNumDAOFactory.createReportMacGetDenNumDAO();

        List<ReportMacGetDenNumVO> list = reportMacDAO.findReportMacGetDenNumByCondition(cond);
        result.setReportMacGetDenNum(list);

        return result;
    }

}
