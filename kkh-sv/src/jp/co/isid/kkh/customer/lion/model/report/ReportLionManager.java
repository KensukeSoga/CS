package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;

import jp.co.isid.kkh.customer.lion.model.report.ReportLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionDAOFactory;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionManager;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionResult;
import jp.co.isid.kkh.customer.lion.model.report.ReportLionVO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionSonotaDAO;
import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���[�iLion)�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/11)<BR>
 * �E��r���[�Ή�(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author
 */

public class ReportLionManager {


    /** �V���O���g���C���X�^���X */
    private static ReportLionManager _manager = new ReportLionManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportLionManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * @return �C���X�^���X
     */
    public static ReportLionManager getInstance() {
        return _manager;
    }

    /**
     * ���C�I�����[�f�[�^(�v���[�t���X�g)���������܂��B
     *
     * @return ReportLionResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public ReportLionResult findByCondition(ReportLionCondition cond) throws KKHException {

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
        ReportLionResult result = new ReportLionResult();

        //******************************************************
        //�L����׃f�[�^���擾
        //******************************************************
        //ReportLionDAO reportLionDAO = ReportLionDAOFactory.createReportLionDAO();
        //List<ReportLionVO> list = reportLionDAO.findReportLionByCondition(cond);

        ReportLionProofDaoInterface dao = ReportLionDAOFactory.createReportLionDAO(cond.getbaitai());
        List<ReportLionVO> list = dao.findReportLionByCondition(cond);

        result.setReportLion(list);

        //*****************************************************
        //���̑���p ����Ŏ擾
        //*****************************************************
        if(cond.getbaitai().equals(LionConstants.BaitaiCode.SONOTA.getName()))
        {
            ReportLionSonotaDAO sonotaDAO = new ReportLionSonotaDAO();
            List<ReportLionVO> sonotalist = sonotaDAO.findReportLionSyohiZeiByCondition(cond);
            result.setReportLionSyohiZei(sonotalist);
        }
        //*****************************************************
        //�����p �}�̃R�[�h���̎擾
        //*****************************************************
//    	else if(cond.getbaitai().equals(LionConstants.BaitaiCode.SEISAKU.getName()))
//    	{
//    		ReportLionSeisakDAO seisakuDAO = new ReportLionSeisakDAO();
//    		List<ReportLionVO> seisakulist = seisakuDAO.findReportLionBaitaiCdName(cond);
//    		result.setBaitaiCdName(seisakulist);
//    	}

        return result;
    }

}
