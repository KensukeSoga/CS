package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.kkh.model.base.KKHException;

public class UpdateSubjectManager {

	/** �V���O���g���C���X�^���X */
    private static UpdateSubjectManager _manager = new UpdateSubjectManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private UpdateSubjectManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static UpdateSubjectManager getInstance() {
        return _manager;
    }

    /**
     * �����ύX�f�[�^�o�^
     * @param vo
     * @throws KKHException
     */
    public void updateJissiData(UpdateSubjectVO vo) throws KKHException{

    	UpdateSubjectDAO dao = UpdateSubjectDAOFactory.createUpjissiDAO();
    	dao.jissiUp(vo);
    }
}
