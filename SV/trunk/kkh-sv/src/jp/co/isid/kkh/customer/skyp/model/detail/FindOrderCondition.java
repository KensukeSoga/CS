package jp.co.isid.kkh.customer.skyp.model.detail;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class FindOrderCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** �}�̋敪 */
     private String _baitaikbn;

     /**
     * �}�̋敪��Ԃ��܂��B
     *
     * @return esqId
     */
    public String getbaitaikbn() {
        return _baitaikbn;
    }
    /**
     * �}�̋敪��ݒ肵�܂��B
     *
     * @param esqId
     */
    public void setbaitaikbn(String baitaikbn) {
        this._baitaikbn = baitaikbn;
    }

}
