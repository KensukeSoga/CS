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
public class ReportAshMediaChklstManager {

    /** �V���O���g���C���X�^���X */
    private static ReportAshMediaChklstManager _manager = new ReportAshMediaChklstManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportAshMediaChklstManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportAshMediaChklstManager getInstance() {
        return _manager;
    }

    /**
     * ���[�f�[�^(Ash)���������܂��B
     *
     * @return ReportAshMediaResult �}�̎�ʈꗗ�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportAshMediaChklstResult findByCondition(ReportAshMediaCondition cond) throws KKHException {
        //��������
        ReportAshMediaChklstResult result = new ReportAshMediaChklstResult();

        //******************************************************
        //�}�̎�ʃf�[�^���擾
        //******************************************************
        ReportAshMediaChklstDAO reportAshMediaChklstDAO = ReportAshMediaChklstDAOFactory.createReportAshMediaDAO();
        List<ReportAshMediaChklstVO> list = reportAshMediaChklstDAO.findReportAshMediaChklstByCondition(cond);
        result.setReportAshChklst(list);

        return result;
    }

}
