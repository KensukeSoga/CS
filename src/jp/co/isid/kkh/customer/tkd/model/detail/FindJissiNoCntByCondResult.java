package jp.co.isid.kkh.customer.tkd.model.detail;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * 使用済実施Noの件数を保持する。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/13 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://detail.model.tkd.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.tkd.customer.kkh.isid.co.jp/")
public class FindJissiNoCntByCondResult extends AbstractServiceResult {

	/** 使用済実施Noの件数 */
	private BigDecimal _jissiNoCnt;

	/**
	 * 使用済実施Noの件数を取得します。
	 *
	 * @return jissiNo
	 */
	public BigDecimal getJissiNoCnt() {
		return _jissiNoCnt;
	}

	/**
	 * 使用済実施Noの件数を設定します。
	 *
	 * @param jissiNoCnt
	 */
	public void setJissiNoCnt(BigDecimal jissiNoCnt) {
		_jissiNoCnt = jissiNoCnt;
	}

}
