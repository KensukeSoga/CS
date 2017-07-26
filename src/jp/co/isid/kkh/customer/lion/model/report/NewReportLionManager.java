package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ���C�I�����[(���Ϗ�)����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/06 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class NewReportLionManager {

    /** �V���O���g���C���X�^���X */
    private static NewReportLionManager _manager = new NewReportLionManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private NewReportLionManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static NewReportLionManager getInstance() {
        return _manager;
    }

    /**
     * ���C�I�����[�f�[�^(���Ϗ�)���������܂��B
     *
     * @return NewReportLionResult �}�̎�ʈꗗ�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public NewReportLionResult findByCondition(NewReportLionCondition cond) throws KKHException {

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
        if (cond.getYymm() == null || cond.getYymm().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if(cond.getBaitaiCd() == null || cond.getBaitaiCd().equals("")){
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }

        NewReportLionResult result = new NewReportLionResult();
        NewReportLionDAO reportLionDAO = NewReportLionDAOFactory.createReportAshKoukokuHiDAO();
        //�����J�n
        List<NewReportLionVO> list = reportLionDAO.findReportLionByCondition(cond);
        //�������ʊi�[
        result.setReportLion(list);

        return result;
    }

}
