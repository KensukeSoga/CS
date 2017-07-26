package jp.co.isid.kkh.customer.mac.model.master;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.mac.model.master.FindMasterMacTnpRByCondCondition;

/**
 * <P>
 * �}�N�h�i���h�X�܃}�X�^�����e�[�u������Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 * @author
 */
public class FindMasterMacTnpRByCondManager {

    /** �V���O���g���C���X�^���X */
    private static FindMasterMacTnpRByCondManager _manager = new FindMasterMacTnpRByCondManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private FindMasterMacTnpRByCondManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static FindMasterMacTnpRByCondManager getInstance() {
        return _manager;
    }

    /**
     * �}�N�h�i���h�X�܃}�X�^�����e�[�u������
     *
     * @return FindMasterMacTnpRByCondResult ��������
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public FindMasterMacTnpRByCondResult findthb17rmtnp(
            FindMasterMacTnpRByCondCondition cond) throws KKHException {

        // ��������
        FindMasterMacTnpRByCondResult result = new FindMasterMacTnpRByCondResult();

        FindMasterMacTnpRByCondDAO dao = FindMasterMacTnpRByCondDAOFactory.createFindMasterMacTnpRByCondDAO();

        List<FindMasterMacTnpRByCondVO> list = dao.findthb17rmtnp(cond);
        result.set_thb17RmtnpList(list);

        return result;
    }

}
