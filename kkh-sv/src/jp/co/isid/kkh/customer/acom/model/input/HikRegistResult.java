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
public class HikRegistResult extends AbstractServiceResult {

    /** 発注データVOリスト */
    private List<HikRegistVOList> _hikUpdataVOList;

    /** ListだけではWebサービスに公開されないのでダミープロパティを追加 */
    private String _dummy;


    /**
     * 発注データVOリストを取得します。
     *
     * @return List<HikUpdataVO> 発注データVOリスト情報のリスト
     */
    public List<HikRegistVOList> getHikVOList() {
        return _hikUpdataVOList;
    }

    /**
     * 発注データVOリストを設定します。
     * @param hikVOList List<HikUpdataVO> 発注データVOリスト
     */
    public void setHikVOList(List<HikRegistVOList> hikUpdataVOList) {
    	_hikUpdataVOList = hikUpdataVOList;
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
