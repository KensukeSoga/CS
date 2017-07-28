package jp.co.isid.kkh.customer.acom.model.input;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * 発注データVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/14 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
@XmlRootElement(namespace = "http://input.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://input.model.kkh.isid.co.jp/")
public class HikRegistVOList extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** 発注登録情報VO **/
    private List<HikVO> _VOList;

    /**
     * 新規インスタンスを構築します。
     */
    public HikRegistVOList() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new HikRegistVOList();
    }

    /**
     * 発注データVOを設定します。
     * @param VOList List<HikRegistVO> 発注登録情報VO
     */
    public void setHikRegistVOList(List<HikVO> VOList) {
        _VOList = VOList;
    }

    /**
     * 発注データVOを返します。
     * @return List<HikRegistVO> 発注登録情報VO
     */
    public List<HikVO> getHikRegistVOList() {
        return _VOList;
    }

}
