package jp.co.isid.kkh.customer.tkd.model.detail;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * ���{No�ő�l�̌������ʂ�ێ�����B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/9 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://detail.model.tkd.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.tkd.customer.kkh.isid.co.jp/")
public class FindMaxJissiNoByCondResult extends AbstractServiceResult {

	/** ���{No�ő�l */
	private BigDecimal _jissiNo;

	/**
	 * ���{No�ő�l���擾���܂��B
	 *
	 * @return jissiNo
	 */
	public BigDecimal getJissiNo() {
		return _jissiNo;
	}

	/**
	 * ���{No�ő�l��ݒ肵�܂��B
	 *
	 * @param jissiNo
	 */
	public void setJissiNo(BigDecimal jissiNo) {
		_jissiNo = jissiNo;
	}

}
