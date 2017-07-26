package jp.co.isid.kkh.customer.kmn.model.report;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 *
 * <P>
 * �V�[�N�G���XNo�ő�l�擾Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/25 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class MaxSeqNoManager {

    /** �V���O���g���C���X�^���X */
    private static MaxSeqNoManager _manager = new MaxSeqNoManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private MaxSeqNoManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static MaxSeqNoManager getInstance() {
        return _manager;
    }

    /**
     * �V�[�N�G���XNo�ő�l���擾���܂��B
     *
     * @return MaxSeqNoResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public MaxSeqNoResult findByCondition(MaxSeqNoCondition cond) throws KKHException {

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
        if (cond.getYyMm() == null || cond.getYyMm().equals("")) {
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        //��������
        MaxSeqNoResult result = new MaxSeqNoResult();

        //******************************************************
        //�L����׃f�[�^���擾
        //******************************************************
        MaxSeqNoDAO maxSeqNoDAO = MaxSeqNoDAOFactory.createMaxSeqNoDAO();

        List<MaxSeqNoVO> list = maxSeqNoDAO.findMaxSeqNoByCondition(cond);
        result.setMaxSeqNo(list);

        return result;

    }
}