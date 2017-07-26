package jp.co.isid.kkh.customer.toh.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;


/**
 * <P>
 * ���[�i�N���ʔ}�̕ʏW�v)����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/22 JSE T.Kobayashi)<BR>
 * </P>
 * @author
 */
public class ReportTohTotalManager {

    /** �V���O���g���C���X�^���X */
    private static ReportTohTotalManager _manager = new ReportTohTotalManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportTohTotalManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportTohTotalManager getInstance() {
        return _manager;
    }

    /**
     * ���[�i�N���ʔ}�̕ʏW�v)���������܂��B
     *
     * @return ReportTohTotalResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportTohTotalResult findByCondition(ReportTohTotalCondition cond) throws KKHException {
    	//��������
    	ReportTohTotalResult result = new ReportTohTotalResult();

    	//******************************************************
    	//�L����׃f�[�^���擾
    	//******************************************************
    	ReportTohTotalDAO reportTohTotalDAO = ReportTohTotalDAOFactory.createReportTohTotalDAO();

    	List<ReportTohTotalVO> list = reportTohTotalDAO.findReportTohTotalByCondition(cond);
    	result.setReportTohTotal(list);

        return result;

    }




}
