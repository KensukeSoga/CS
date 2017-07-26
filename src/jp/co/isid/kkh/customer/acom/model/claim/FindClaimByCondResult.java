package jp.co.isid.kkh.customer.acom.model.claim;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * 請求データ情報を保持する。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/2/7 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://claim.model.acom.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://claim.model.acom.customer.kkh.isid.co.jp/")
public class FindClaimByCondResult extends AbstractServiceResult {

    /** 発注/請求番号 一覧情報VOリスト */
    private List<FindClaimNoCondResultVO> _claimNoList;
    /** 発注/請求 差異一覧情報VOリスト */
    private List<FindClaimDiffCondResultVO> _claimDiffList;
    /** 請求データ 一覧情報VOリスト */
    private List<FindClaimCondResultVO> _claimList;

    /**
     * 発注/請求番号 一覧情報VOリストを取得します。
     *
     * @return _list
     */
    public List<FindClaimNoCondResultVO> getClaimNoDataList() {
        return _claimNoList;
    }

    /**
     * 発注/請求番号 一覧情報VOリストを設定します。
     *
     * @param list
     */
    public void setClaimNoDataList(List<FindClaimNoCondResultVO> list) {
        _claimNoList = list;
    }

    /**
     * 発注/請求 差異一覧情報VOリストを取得します。
     *
     * @return _list
     */
    public List<FindClaimDiffCondResultVO> getClaimDiffDataList() {
        return _claimDiffList;
    }

    /**
     * 発注/請求 差異一覧情報VOリストを設定します。
     *
     * @param list
     */
    public void setClaimDiffDataList(List<FindClaimDiffCondResultVO> list) {
        _claimDiffList = list;
    }

    /**
     * 請求データ 一覧情報VOリストを取得します。
     *
     * @return _list
     */
    public List<FindClaimCondResultVO> getClaimDataList() {
        return _claimList;
    }

    /**
     * 請求データ 一覧情報VOリストを設定します。
     *
     * @param list
     */
    public void setClaimDataList(List<FindClaimCondResultVO> list) {
        _claimList = list;
    }

}
