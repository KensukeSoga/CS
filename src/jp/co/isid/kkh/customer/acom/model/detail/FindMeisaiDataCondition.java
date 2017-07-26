package jp.co.isid.kkh.customer.acom.model.detail;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class FindMeisaiDataCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** ��No */
    private String _jyutNo = null;

    /** �󒍖���No */
    private String _jyMeiNo = null;

    /** ���㖾��No */
    private String _urMeiNo = null;

    /**
     * ��No���擾����
     * @return ��No
     */
    public String getJyutNo() {
        return _jyutNo;
    }

    /**
     * ��No��ݒ肷��
     * @param jyutNo ��No
     */
    public void setJyutNo(String jyutNo) {
        this._jyutNo = jyutNo;
    }

    /**
     * �󒍖���No���擾����
     * @return �󒍖���No
     */
    public String getJyMeiNo() {
        return _jyMeiNo;
    }

    /**
     * �󒍖���No��ݒ肷��
     * @param jyMeiNo �󒍖���No
     */
    public void setJyMeiNo(String jyMeiNo) {
        this._jyMeiNo = jyMeiNo;
    }

    /**
     * ���㖾��No���擾����
     * @return ���㖾��No
     */
    public String getUrMeiNo() {
        return _urMeiNo;
    }

    /**
     * ���㖾��No��ݒ肷��
     * @param urMeiNo ���㖾��No
     */
    public void setUrMeiNo(String urMeiNo) {
        this._urMeiNo = urMeiNo;
    }

}
