package jp.co.isid.kkh.customer.acom.model.input;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.integ.tbl.TBTHB5HIK;
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
public class HikSearchDateCntVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public HikSearchDateCntVO() {
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
    private List<HikSearchDateCntVOList> _VOList;


    /**
     * 発注データVOを設定します。
     * @param VOList List<HikSearchDateCntVOList>
     */
    public void setHikSearchDateCntVOList(List<HikSearchDateCntVOList> VOList) {
        _VOList = VOList;
    }

    /**
     * 発注データVOを返します。
     * @return List<HikSearchDateCntVOList>
     */
    public List<HikSearchDateCntVOList> getHikSearchDateCntVOList() {
        return _VOList;
    }

    /**
     * 得意先企業コードを設定します。
     * @param val String 得意先企業コード
     */
    public void setTksKgyCd(String val) {
        set(TBTHB5HIK.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     * @return String 得意先企業コード
     */
    public String getTksKgyCd() {
        return (String) get(TBTHB5HIK.TKSKGYCD);
    }

    /**
     * 得意先部門SEQNOを設定します。
     * @param val String 得意先部門SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHB5HIK.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     * @return String 得意先部門SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHB5HIK.TKSBMNSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定します。
     * @param val String 得意先担当SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHB5HIK.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     * @return String 得意先担当SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHB5HIK.TKSTNTSEQNO);
    }

    /**
     * 種別を設定します。
     * @param val String 種別
     */
    public void setSybt(String val) {
        set(TBTHB5HIK.SYBT, val);
    }

    /**
     * 種別を返します。
     * @return String 種別
     */
    public String getSybt() {
        return (String) get(TBTHB5HIK.SYBT);
    }

    /**
     * レコード種別を設定します。
     * @param val String レコード種別
     */
    public void setRecCd(String val) {
        set(TBTHB5HIK.RECCD, val);
    }

    /**
     * レコード種別を返します。
     * @return String レコード種別
     */
    public String getRecCd() {
        return (String) get(TBTHB5HIK.RECCD);
    }

    /**
     * 依頼番号を設定します。
     * @param val String 依頼番号
     */
    public void setIrban(String val) {
        set(TBTHB5HIK.IRBAN, val);
    }

    /**
     * 依頼番号を返します。
     * @return String 依頼番号
     */
    public String getIrban() {
        return (String) get(TBTHB5HIK.IRBAN);
    }

    /**
     * 依頼行番号を設定します。
     * @param val String 依頼行番号
     */
    public void setIrrowban(String val) {
        set(TBTHB5HIK.IRROWBAN, val);
    }

    /**
     * 依頼行番号を返します。
     * @return String 依頼行番号
     */
    public String getIrrowban() {
        return (String) get(TBTHB5HIK.IRROWBAN);
    }

}
