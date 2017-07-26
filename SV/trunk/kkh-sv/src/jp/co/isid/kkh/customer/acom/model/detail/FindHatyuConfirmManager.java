package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

public class FindHatyuConfirmManager {

    /** �V���O���g���C���X�^���X */
    private static FindHatyuConfirmManager _manager = new FindHatyuConfirmManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private FindHatyuConfirmManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static FindHatyuConfirmManager getInstance() {
        return _manager;
    }

    /**
     *THB5HIK�̌���
     * @param vo
     * @throws KKHException
     */
    public FindHatyuConfirmResult findThb2Kmeidata(FindHatyuNumByCondVO vo) throws KKHException{

        FindHatyuConfirmResult result = new FindHatyuConfirmResult();

        FindHatyuConfirmDAO thb5HikDAO = FindHatyuConfirmDAOFactory.createfinetgr84hikDAO();
        List<HikVO> thb5HikList =  thb5HikDAO.findThb5HikByCondCmn(vo);

        result.set_thb5HikList(thb5HikList);

        return result;
    }

}
