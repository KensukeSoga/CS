package jp.co.isid.kkh.customer.acom.model.report;

import java.util.List;

import jp.co.isid.kkh.customer.acom.model.report.ReportAcomCondition;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomDAO;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomDAOFactory;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomManager;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomResult;
import jp.co.isid.kkh.customer.acom.model.report.ReportAcomVO;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���[�i�A�R��)�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/11)<BR>
 * </P>
 * @author
 */

public class ReportAcomManager {


    /** �V���O���g���C���X�^���X */
    private static ReportAcomManager _manager = new ReportAcomManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportAcomManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportAcomManager getInstance() {
        return _manager;
    }


    /**
     * ���[�f�[�^(ACOM)���������܂��B
     *
     * @return ReportAcomResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportAcomResult findByCondition(ReportAcomCondition cond) throws KKHException {
        // �p�����[�^�̕K�{�`�F�b�N
        if (cond.getEsqId() == null || cond.getEsqId().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getEgCd() == null || cond.getEgCd().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getYm() == null || cond.getYm().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
    	//��������
    	ReportAcomResult result = new ReportAcomResult();

    	//******************************************************
    	//�L����׃f�[�^���擾
    	//******************************************************
    	ReportAcomDAO reportAcomDAO = ReportAcomDAOFactory.createReportAcomDAO();

    	List<ReportAcomVO> list = reportAcomDAO.findReportAcomByCondition(cond);
    	result.setReportAcom(list);

        return result;
    }

}
