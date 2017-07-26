package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;

import jp.co.isid.kkh.customer.lion.model.report.DetailListLionCondition;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionDAOFactory;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionManager;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionResult;
import jp.co.isid.kkh.customer.lion.model.report.DetailListLionVO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionSonotaDAO;
import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.model.base.KKHException;
/**
 * <P>
 * ���C�I�����׈ꗗ���[�����}�l�[�W��
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/07)<BR>
 * </P>
 * @author
 */

public class DetailListLionManager {


    /** �V���O���g���C���X�^���X */
    private static DetailListLionManager _manager = new DetailListLionManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private DetailListLionManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static DetailListLionManager getInstance() {
        return _manager;
    }


    /**
     * ���׈ꗗ�f�[�^(Lion)���������܂��B
     *
     * @return DetailListLionResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public DetailListLionResult findByCondition(DetailListLionCondition cond) throws KKHException {
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
        DetailListLionResult result = new DetailListLionResult();

        //******************************************************
        //�L����׃f�[�^���擾
        //******************************************************
        DetailListLionDaoInterface dao = DetailListLionDAOFactory.createDetailListLionDAO(cond.getymfrom()
                                                                                          ,cond.getymto()
                                                                                          ,cond.getbaitaikbn()
                                                                                          );
        List<DetailListLionVO> list = dao.findDetailListLionByCondition(cond);

        result.setDetailListLion(list);

        //*****************************************************
        //���̑���p ����Ŏ擾
        //*****************************************************
        if(cond.getbaitaikbn().equals(LionConstants.BaitaiCode.SONOTA.getName()))
        {
            DetailListLionSonotaDAO sonotaDAO = new DetailListLionSonotaDAO();
            List<DetailListLionVO> sonotalist = sonotaDAO.findDetailListLionSyohiZeiByCondition(cond);
            result.setDetailListLionSyohiZei(sonotalist);
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
