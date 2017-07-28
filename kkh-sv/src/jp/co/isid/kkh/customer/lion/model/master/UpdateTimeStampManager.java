package jp.co.isid.kkh.customer.lion.model.master;

import jp.co.isid.kkh.model.base.KKHException;

public class UpdateTimeStampManager {

	/** シングルトンインスタンス */
    private static UpdateTimeStampManager _manager = new UpdateTimeStampManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private UpdateTimeStampManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static UpdateTimeStampManager getInstance() {
        return _manager;
    }

    /**
     * 実施No自動UP/DOWN登録
     * @param vo
     * @throws KKHException
     */
    public void updateJissiData(UpdateTimeStampVO vo) throws KKHException{

    	UpdateTimeStampDAO dao = UpdateTimeStampDAOFactory.createUpjissiDAO();
    dao.jissiUp(vo);
    }
}
