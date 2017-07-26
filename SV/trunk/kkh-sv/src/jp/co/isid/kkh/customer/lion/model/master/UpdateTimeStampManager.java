package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.kkh.model.base.KKHException;

public class UpdateTimeStampManager {

	/** �V���O���g���C���X�^���X */
    private static UpdateTimeStampManager _manager = new UpdateTimeStampManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private UpdateTimeStampManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static UpdateTimeStampManager getInstance() {
        return _manager;
    }

    /**
     * ���{No����UP/DOWN�o�^
     * @param vo
     * @throws KKHException
     */
    public void updateJissiData(UpdateTimeStampVO vo) throws KKHException{

    	UpdateTimeStampDAO dao = UpdateTimeStampDAOFactory.createUpjissiDAO();
    dao.jissiUp(vo);
    }
}
