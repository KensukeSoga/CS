package jp.co.isid.kkh.customer.skyp.model.report;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

public class ReportSkypManager {

    /** �V���O���g���C���X�^���X */
    private static ReportSkypManager _manager = new ReportSkypManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private ReportSkypManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static ReportSkypManager getInstance() {
        return _manager;
    }

    /**
     * ���[�i�X�J�p�[_�[�i�^�������j�f�[�^���������܂��B
     *
     * @return ReportSkypResult ���я����
     * @throws KKHException
     *             �������ɃG���[�����������ꍇ
     */
    public ReportSkypResult findReportSkypByCondition(ReportSkypCondition cond)
            throws KKHException {

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

        // ��������
        ReportSkypResult result = new ReportSkypResult();

        // ��������
        ReportSkypCondition lCond = new ReportSkypCondition();

        // ******************************************************
        // ���[�i�X�J�p�[_�[�i�^�������j�f�[�^���擾
        // ******************************************************
        ReportSkypDAO dao = ReportSkypDAOFactory.createFindReportSkypDAO();
        lCond = cond;
        List<ReportSkypVO> list = dao.findReportSkypByCondition(lCond);
        result.setReportSkyp(list);

        return result;
    }

}
