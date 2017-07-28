package jp.co.isid.kkh.customer.ash.model.detail;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 広告費明細データ検索結果を保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/12/27 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
public class DetailDataAshResult extends AbstractServiceResult {

    /** 対象媒体コード */
    private String _targetBaitaiCd;

    /** 広告費明細データVOリスト */
    private List<DetailDataAshVO> _detailData;

    /**
     * 対象媒体コードを取得します。
     * @return
     */
    public String getTargetBaitaiCd() {
        return _targetBaitaiCd;
    }

    /**
     * 対象媒体コードを設定します。
     * @param targetBaitaiCd
     */
    public void setTargetBaitaiCd(String targetBaitaiCd) {
        this._targetBaitaiCd = targetBaitaiCd;
    }

    /**
     * 広告費明細テーブル(THB2KMEI)VOリストを取得します。
     * @return _thb2KmeiList
     */
    public List<DetailDataAshVO> getDetailData() {
        return _detailData;
    }

    /**
     * 広告費明細テーブル(THB2KMEI)VOリストを設定します。
     * @param thb2KmeiList
     */
    public void setDetailData(List<DetailDataAshVO> detailData) {
        _detailData = detailData;
    }

}
