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
public class EigyoBiManager {

    /** �V���O���g���C���X�^���X */
    private static EigyoBiManager _manager = new EigyoBiManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private EigyoBiManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static EigyoBiManager getInstance() {
        return _manager;
    }

    /**
     * �ėp�}�X�^(�f�[�^)���������܂��B
     *
     * @return MasterResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public EigyoBiResult getEigyoBi(EigyoBiCondition cond) throws KKHException {

        //��������
        EigyoBiResult result = new EigyoBiResult();
        EigyoBiDAO dao = EigyoBiDAOFactory.createEigyoBiDAO();

        //******************************************************
        //�c�Ɠ��擾
        //******************************************************
        List<EigyoBiVO> voList = dao.getEigyoBi(cond);
        if (voList.size() > 0){
            result.setEigyoBi(voList.get(0).getEigyoBi());
        }

        return result;
    }

}
