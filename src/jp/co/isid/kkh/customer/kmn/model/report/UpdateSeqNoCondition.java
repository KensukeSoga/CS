package jp.co.isid.kkh.customer.kmn.model.report;

import java.util.List;

import jp.co.isid.kkh.model.AbstractServiceCondition;

/**
 * <P>
 * シークエンスNo登録・更新Condition
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/2/26 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class UpdateSeqNoCondition extends AbstractServiceCondition {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** 請求明細一覧(公文)テーブルリスト */
    private List<ReportKmnListVO> _repKmnList = null;

//    /** APLID */
//    private String _aplId = null;
//
//    /** TKSTNTSEQNO */
//    private String _tksTntSeqNo = null;

    /**
     * ダウンロードテーブルを取得する
     * @return ダウンロードテーブル
     */
    public List<ReportKmnListVO> getRepKmnList() {
        return _repKmnList;
    }

    /**
     * ダウンロードテーブルを設定する
     * @param thb1Down ダウンロードテーブル
     */
    public void setRepKmnList(List<ReportKmnListVO> repKmnList) {
        this._repKmnList = repKmnList;
    }

//    /**
//     * APLIDを返します。
//     *
//     * @return _aplId
//     */
//    public String getAplId() {
//        return _aplId;
//    }
//
//    /**
//     * APLIDを設定します。
//     *
//     * @param aplId
//     */
//    public void setBumonCd(String aplId) {
//        this._aplId = aplId;
//    }
//
//    /**
//     * TKSTNTSEQNOを返します。
//     *
//     * @return _tksTntSeqNo
//     */
//    public String getTksTntSeqNo() {
//        return _tksTntSeqNo;
//    }
//
//    /**
//     * TKSTNTSEQNOを設定します。
//     *
//     * @param tksTntSeqNo
//     */
//    public void setTksTntSeqNo(String tksTntSeqNo) {
//        this._tksTntSeqNo = tksTntSeqNo;
//    }
}

