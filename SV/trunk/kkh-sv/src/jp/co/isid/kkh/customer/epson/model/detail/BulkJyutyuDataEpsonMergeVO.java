package jp.co.isid.kkh.customer.epson.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.detail.JyutyuDataMergeVO;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 一括統合処理用VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/24 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class BulkJyutyuDataEpsonMergeVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** 受注統合データリスト */
    private List<JyutyuDataMergeVO> _jyutyuDataMergeVOList = null;

    /** ダミープロパティ */
    private String _dummy = null;

    /**
     * 受注統合データリストを取得する
     * @return 受注統合データリスト
     */
    public List<JyutyuDataMergeVO> getJyutyuDataMergeVOList() {
        return _jyutyuDataMergeVOList;
    }

    /**
     * 受注統合データリストを設定する
     * @param jyutyuDataMergeVOList 受注統合データリスト
     */
    public void setJyutyuDataMergeVOList(List<JyutyuDataMergeVO> jyutyuDataMergeVOList) {
        this._jyutyuDataMergeVOList = jyutyuDataMergeVOList;
    }

    /**
     * ダミープロパティを取得する
     * @return ダミープロパティ
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * ダミープロパティを設定する
     * @param dummy ダミープロパティ
     */
    public void setDummy(String dummy) {
        this._dummy = dummy;
    }

}
