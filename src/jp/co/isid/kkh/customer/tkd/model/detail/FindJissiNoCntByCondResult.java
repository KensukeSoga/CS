package jp.co.isid.kkh.customer.tkd.model.detail;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * �g�p�ώ��{No�̌�����ێ�����B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/13 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://detail.model.tkd.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.tkd.customer.kkh.isid.co.jp/")
public class FindJissiNoCntByCondResult extends AbstractServiceResult {

	/** �g�p�ώ��{No�̌��� */
	private BigDecimal _jissiNoCnt;

	/**
	 * �g�p�ώ��{No�̌������擾���܂��B
	 *
	 * @return jissiNo
	 */
	public BigDecimal getJissiNoCnt() {
		return _jissiNoCnt;
	}

	/**
	 * �g�p�ώ��{No�̌�����ݒ肵�܂��B
	 *
	 * @param jissiNoCnt
	 */
	public void setJissiNoCnt(BigDecimal jissiNoCnt) {
		_jissiNoCnt = jissiNoCnt;
	}

}
