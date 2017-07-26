package jp.co.isid.kkh.customer.uni.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * 帳票（ユニチャーム_広告費明細表）データを保持する。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/1/23 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://report.model.uni.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.uni.customer.kkh.isid.co.jp/")
public class ReportUniResult extends AbstractServiceResult {

    /** 帳票（ユニチャーム_広告費明細表_明細）データVOリスト */
    private List<ReportUniResultVO> _meisai;

    /** 帳票（ユニチャーム_広告費明細表_プルーフリスト）データVOリスト */
    private List<ReportUniResultVO> _proofs;

    /**
     * 帳票（ユニチャーム_広告費明細表_明細）データVOリストを取得します。
     *
     * @return _meisai
     */
    public List<ReportUniResultVO> getMeisai() {
        return _meisai;
    }

    /**
     * 帳票（ユニチャーム_広告費明細表_明細）データVOリストを設定します。
     *
     * @param meisai
     */
    public void setMeisai(List<ReportUniResultVO> meisai) {
        _meisai = meisai;
    }

    /**
     * 帳票（ユニチャーム_広告費明細表__プルーフリスト）データVOリストを取得します。
     *
     * @return _proofs
     */
    public List<ReportUniResultVO> getProofs() {
        return _proofs;
    }

    /**
     * 帳票（ユニチャーム_広告費明細表__プルーフリスト）データVOリストを設定します。
     *
     * @param proofs
     */
    public void setProofs(List<ReportUniResultVO> proofs) {
    	_proofs = proofs;
    }

}
