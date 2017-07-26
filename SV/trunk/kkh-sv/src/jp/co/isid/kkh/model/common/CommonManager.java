package jp.co.isid.kkh.model.common;

import java.util.*;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �ėp�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/11 IP H.Shimizu)<BR>
 * </P>
 * @author
 */
public class CommonManager {

    /** �V���O���g���C���X�^���X */
    private static CommonManager _manager = new CommonManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private CommonManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static CommonManager getInstance() {
        return _manager;
    }

    /**
     * �ėp�}�X�^(��ށE����)���������܂��B
     *
     * @return MasterResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public CommonResult findCommonByCondition(CommonCondition cond) throws KKHException {

        //�p�����[�^�̕K�{�`�F�b�N
        if (cond.getEsqId()== null || cond.getEsqId().equals("")){
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getEgCd() == null || cond.getEgCd().equals("")){
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")){
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")){
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")){
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }
        if (cond.getSybt() == null || cond.getSybt().equals("")){
            throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
        }

        //��������
        CommonResult result = new CommonResult();
        //��������(�}�X�^��ސݒ�E���ڐݒ�擾�p)
        CommonCondition lCond = new CommonCondition();

        CommonDAO dao = CommonDAOFactory.createCommonDAO();

        //******************************************************
        //�}�X�^��ސݒ���擾
        //******************************************************
        lCond = cond;
        List<CommonVO> CommonList = dao.findCommonByCondition(lCond);
        result.setCommon(CommonList);

        return result;
    }

}
