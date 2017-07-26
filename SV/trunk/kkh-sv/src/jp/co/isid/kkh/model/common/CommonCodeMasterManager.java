package jp.co.isid.kkh.model.common;

import java.util.*;

import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �ėp�}�X�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/07 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class CommonCodeMasterManager {

    /** �V���O���g���C���X�^���X */
    private static CommonCodeMasterManager _manager = new CommonCodeMasterManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private CommonCodeMasterManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static CommonCodeMasterManager getInstance() {
        return _manager;
    }

    /**
     * �ėp�}�X�^(�f�[�^)���������܂��B
     *
     * @return MasterResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public CommonCodeMasterResult findByCondition(CommonCodeMasterCondition cond) throws KKHException {

        //��������
        CommonCodeMasterResult result = new CommonCodeMasterResult();
        CommonCodeMasterDAO dao = CommonCodeMasterDAOFactory.createMasterDAO();

        //******************************************************
        //���ʃR�[�h�}�X�^����
        //******************************************************
        List<CommonCodeMasterVO> voList = dao.findCommonCodeMasterByCondition(cond);
        result.setCommonCodeMaster(voList);

        return result;
    }

}
