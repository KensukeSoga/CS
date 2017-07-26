package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.kkh.model.base.KKHException;

public class UpdateSubjectManager {

	/** シングルトンインスタンス */
    private static UpdateSubjectManager _manager = new UpdateSubjectManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private UpdateSubjectManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static UpdateSubjectManager getInstance() {
        return _manager;
    }

    /**
     * 件名変更データ登録
     * @param vo
     * @throws KKHException
     */
    public void updateJissiData(UpdateSubjectVO vo) throws KKHException{

    	UpdateSubjectDAO dao = UpdateSubjectDAOFactory.createUpjissiDAO();
    	dao.jissiUp(vo);
    }
}
