package jp.co.isid.kkh.customer.tkd.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

/**
 * <P>
 * ���c�������ׁi�����ޕʁj�擾����
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByMiddleClassificationCondition extends AbstractServiceCondition
 {
    private static final long serialVersionUID = 1L;

    /** �敪 */
    private String _kbn;

    /**
     * @return _kbn
     */
    public String getKbn() {
        return _kbn;
    }

    /**
     * @param kbn
     *            �Z�b�g���� kbn
     */
    public void setKbn(String kbn) {
        this._kbn = kbn;
    }

 }
