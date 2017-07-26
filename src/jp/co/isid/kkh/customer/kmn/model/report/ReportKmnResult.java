package jp.co.isid.kkh.customer.kmn.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * 帳票（公文_伝票）データを保持する。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/01/30 JSE M.Naito)<BR>
 * </P>
 *
 * @author JSE M.Naito
 */
@XmlRootElement(namespace = "http://report.model.kmn.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.kmn.customer.kkh.isid.co.jp/")
public class ReportKmnResult extends AbstractServiceResult {

    /** 帳票（公文_伝票_明細）データVOリスト */
    private List<ReportKmnMeisaiVO> _meisai;

    /**
     * 帳票（公文_伝票_明細）データVOリストを取得します。
     *
     * @return _proofs
     */
    public List<ReportKmnMeisaiVO> getMeisai() {
        return _meisai;
    }

    /**
     * 帳票（公文_伝票_明細）データVOリストを設定します。
     *
     * @param proofs
     */
    public void setMeisai(List<ReportKmnMeisaiVO> meisai) {
        _meisai = meisai;
    }

}
