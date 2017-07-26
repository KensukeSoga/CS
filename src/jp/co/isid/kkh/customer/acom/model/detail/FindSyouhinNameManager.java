package jp.co.isid.kkh.customer.acom.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterVO;

public class FindSyouhinNameManager {

    /** �V���O���g���C���X�^���X */
    private static FindSyouhinNameManager _manager = new FindSyouhinNameManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private FindSyouhinNameManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static FindSyouhinNameManager getInstance() {
        return _manager;
    }

    /**
     *THB5HIK�̌���
     * @param vo
     * @throws KKHException
     */
    public String findThb2Kmeidata(FindSyohinNameGetCond cond) throws KKHException{

        FindSyouhinNameGetDAO dao = FindSyouhinNameDAOFactory.createfinetgr84hikDAO();

        List<MasterVO> List =  dao.findsyouhinNameByCond(cond);
        if(List ==null || List.size() == 0)
        {
            return "";
        }

        String SyohinName = List.get(0).getField2();

        return SyohinName;
    }

}
