package jp.co.isid.kkh.customer.ash.model.detail;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 * <P>
 * キー局の番組コードのを保持する。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/08/20 HLC S.Jang)<BR>
 * </P>
 *
 * @author HLC 張(Jang)
 */
@XmlRootElement(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
public class FindKeyKyokuBangumiCdResult extends AbstractServiceResult {

    /** 番組コードリスト */
    private List<FindKeyKyokuBangumiCdVO> _bangumiCdList;

    public List<FindKeyKyokuBangumiCdVO> getBangumiCdList() {
        return _bangumiCdList;
    }

    public void setBangumiCdList(List<FindKeyKyokuBangumiCdVO> val) {
        _bangumiCdList = val;
    }

}
