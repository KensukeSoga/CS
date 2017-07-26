package jp.co.isid.kkh.customer.tkd.model.detail;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * 実施No最大値の検索結果を保持する。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/9 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://detail.model.tkd.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.tkd.customer.kkh.isid.co.jp/")
public class FindMaxJissiNoByCondResult extends AbstractServiceResult {

	/** 実施No最大値 */
	private BigDecimal _jissiNo;

	/**
	 * 実施No最大値を取得します。
	 *
	 * @return jissiNo
	 */
	public BigDecimal getJissiNo() {
		return _jissiNo;
	}

	/**
	 * 実施No最大値を設定します。
	 *
	 * @param jissiNo
	 */
	public void setJissiNo(BigDecimal jissiNo) {
		_jissiNo = jissiNo;
	}

}
