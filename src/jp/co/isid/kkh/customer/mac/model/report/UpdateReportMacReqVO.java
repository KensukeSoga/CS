package jp.co.isid.kkh.customer.mac.model.report;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.customer.mac.model.report.UpdateReportMacPurDataVO;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �f�[�^�X�V(������)�ϗ��p���X�g
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/18)<BR>
 * </P>
 *
 * @author IP Shimizu
 */
public class UpdateReportMacReqVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public UpdateReportMacReqVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new UpdateReportMacPurDataVO();
    }

    /**
     * �N����ݒ肵�܂��B
     * @param val String �N��
     */
    public void setYymm(String val) {
        set(TBTHB2KMEI.YYMM, val);
    }

    /**
     * �N����Ԃ��܂��B
     * @return String �N��
     */
    public String getYymm() {
        return (String) get(TBTHB2KMEI.YYMM);
    }

    /**
     * ��No��ݒ肵�܂��B
     * @param val String ��No
     */
    public void setJyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * ��No��Ԃ��܂��B
     * @return String ��No
     */
    public String getJyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * �󒍖���No��ݒ肵�܂��B
     * @param val String �󒍖���No
     */
    public void setJyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * �󒍖���No��Ԃ��܂��B
     * @return String �󒍖���No
     */
    public String getJyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * ���㖾��No��ݒ肵�܂��B
     * @param val String ���㖾��No
     */
    public void setUrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * ���㖾��No��Ԃ��܂��B
     * @return String ���㖾��No
     */
    public String getUrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * �A�Ԃ�ݒ肵�܂��B
     * @param val String �A��
     */
    public void setRenbn(String val) {
        set(TBTHB2KMEI.RENBN, val);
    }

    /**
     * �A�Ԃ�Ԃ��܂��B
     * @return String �A��
     */
    public String getRenbn() {
        return (String) get(TBTHB2KMEI.RENBN);
    }

}
