package jp.co.isid.kkh.customer.acom.model.input;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 日付データ検索用VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/05 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
@XmlRootElement(namespace = "http://input.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://input.model.kkh.isid.co.jp/")
public class HikSearchDateCntVOList extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public HikSearchDateCntVOList() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new HikSearchDateCntVOList();
    }

    /** 発注登録情報VO **/
    private List<HikSearchDateCntVO> _VOList;

    /**
     * 発注データVOを設定します。
     * @param VOList List<HikSearchDateCntVOList>
     */
    public void setHikSearchDateCntVOList(List<HikSearchDateCntVO> VOList) {
        _VOList = VOList;
    }

    /**
     * 発注データVOを返します。
     * @return List<HikSearchDateCntVOList>
     */
    public List<HikSearchDateCntVO> getHikSearchDateCntVOList() {
        return _VOList;
    }

}
