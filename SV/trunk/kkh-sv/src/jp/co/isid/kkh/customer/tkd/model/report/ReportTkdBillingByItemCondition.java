package jp.co.isid.kkh.customer.tkd.model.report;

import jp.co.isid.kkh.model.AbstractServiceCondition;

/**
 * <P>
 * ���c�������ׁi�i�ڕʁj�擾����
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/23 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class ReportTkdBillingByItemCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

/*	*//** �N�� *//*
    private String _ym;
*/
    /** �敪 */
    private String _kbn;

/*	*//**
     * @return _ym
     *//*
    public String getYM() {
        return _ym;
    }

    *//**
     * @param ym
     *            �Z�b�g���� ym
     *//*
    public void setYM(String ym) {
        this._ym = ym;
    }*/

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
