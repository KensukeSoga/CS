package jp.co.isid.kkh.customer.ash.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���[�iAsh)�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/1/20 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class ReportAshMediaManager {

    /** �V���O���g���C���X�^���X */
    private static ReportAshMediaManager _manager = new ReportAshMediaManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportAshMediaManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportAshMediaManager getInstance() {
        return _manager;
    }

    /**
     * ���[�f�[�^(Ash)���������܂��B
     *
     * @return ReportAshMediaResult �}�̎�ʈꗗ�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportAshMediaResult findByCondition(ReportAshMediaCondition cond) throws KKHException {

        //��������
        ReportAshMediaResult result = new ReportAshMediaResult();

        //******************************************************
        //�}�̎�ʃf�[�^���擾
        //******************************************************
        ReportAshMediaDAO reportAshMediaDAO = ReportAshMediaDAOFactory.createReportAshMediaDAO();
        List<ReportAshMediaVO> list = reportAshMediaDAO.findReportMacByCondition(cond);
        result.setReportAsh(list);

        List<ReportAshMediaVO> listALL = reportAshMediaDAO.findReportMacALLByCondition(cond);
        result.setReportAshALL(listALL);

        return result;
    }

}
