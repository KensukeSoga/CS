package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

/**
 *
 * <P>
 * ライオンプルーフリスト帳票検索条件
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/11)<BR>
 * ・比較帳票対応(2014/07/31 HLC S.Fujimoto)<BR>
 * </BR>
 *
 * @author
 *
 */
public class ReportLionCondition extends AbstractServiceCondition{

    private static final long serialVersionUID = 1L;

    /** 媒体名 */
    private String _baitai = null;

    /* 2014/07/31 比較帳票対応 HLC fujimoto ADD start */
    /** プルーフリスト出力日時 */
    private String _prtOutProofListTimStmp = null;
    /* 2014/07/31 比較帳票対応 HLC fujimoto ADD end */

    /**
     * 媒体名を取得する
     * @return 媒体名
     */
    public String getbaitai() {
        return _baitai;
    }

    /**
     * 媒体名を設定する
     * @param val String 媒体名
     */
    public void setbaitai(String val) {
        _baitai = val;
    }

    /* 2014/07/31 比較帳票対応 HLC fujimoto ADD start */
    /**
     * プルーフリスト出力日時を取得する
     * @return プルーフリスト出力日時
     */
    public String getPrtOutProofListTimStmp() {
        return _prtOutProofListTimStmp;
    }

    /**
     * プルーフリスト出力日時を設定する
     * @param val String プルーフリスト出力日時
     */
    public void setPrtOutProofListTimStmp(String val) {
        _prtOutProofListTimStmp = val;
    }
    /* 2014/07/31 比較帳票対応 HLC fujimoto ADD end */

}
