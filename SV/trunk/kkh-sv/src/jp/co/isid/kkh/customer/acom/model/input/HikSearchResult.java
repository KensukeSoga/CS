package jp.co.isid.kkh.customer.acom.model.input;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;


/**
 *
 * <P>
 * 発注データを保持する。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/08 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
@XmlRootElement(namespace = "http://input.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://input.model.kkh.isid.co.jp/")
public class HikSearchResult extends AbstractServiceResult {

    /** 発注データVOリスト */
    private List<HikVO> _hikVOList;


    /** 日付件数データVOリスト */
    private List<HikSearchDateCntVO> _hikSearchDateCntVOList;

    /** ListだけではWebサービスに公開されないのでダミープロパティを追加 */
    private String _dummy;


    /**
     * 発注データVOリストを取得します。
     *
     * @return List<HikVO> 発注データVOリスト情報のリスト
     */
    public List<HikVO> getHikVOList() {
        return _hikVOList;
    }

    /**
     * 発注データVOリストを設定します。
     * @param hikVOList List<HikVO> 発注データVOリスト
     */
    public void setHikVOList(List<HikVO> hikVOList) {
        _hikVOList = hikVOList;
    }

    /**
     * 日付件数データVOリストを取得します。
     *
     * @return List<HikVO> 発注データVOリスト情報のリスト
     */
    public List<HikSearchDateCntVO> getHikSearchDateCntVOList() {
        return _hikSearchDateCntVOList;
    }

    /**
     * 日付件数データVOリストを設定します。
     * @param hikVOList List<HikVO> 日付件数データVOリスト
     */
    public void setHikSearchDateCntVOList(List<HikSearchDateCntVO> hikSearchDateCntVOList) {
    	_hikSearchDateCntVOList = hikSearchDateCntVOList;
    }

    /**
     * ListだけではWebサービスに公開されないのでダミープロパティを追加を取得します。
     * @return String ダミープロパティ
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * ListだけではWebサービスに公開されないのでダミープロパティを追加を設定します。
     * @param dummy ダミープロパティ
     */
    public void setDummy(String dummy) {
        this._dummy = dummy;
    }

}
