package jp.co.isid.kkh.customer.lion.model.detail;

import jp.co.isid.kkh.model.AbstractServiceCondition;

public class FindLionCardNoGetCondition extends AbstractServiceCondition {

    private static final long serialVersionUID = 1L;

    /** ��NO */
    private String _jyutno;
    /** �󒍖���NO */
    private String _jymeino;
    /** ���㖾��NO */
    private String _urmeino;

    /**
     * ��NO���擾����
     * @return String ��NO
     */
    public String getJyutno() {
        return _jyutno;
    }

    /**
     * ��NO��ݒ肷��
     * @param Jyutno String ��NO
     */
    public void setJyutno(String jyutno) {
        this._jyutno = jyutno;
    }

    /**
     * �󒍖���NO���擾����
     * @return String �󒍖���NO
     */
    public String getJymeino() {
        return _jymeino;
    }

    /**
     * �󒍖���NO��ݒ肷��
     * @param Jymeino String �󒍖���NO
     */
    public void setJymeino(String jymeino) {
        this._jymeino = jymeino;
    }

    /**
     * ���㖾��NO���擾����
     * @return String ���㖾��NO
     */
    public String getUrmeino() {
        return _urmeino;
    }

    /**
     * ���㖾��NO��ݒ肷��
     * @param urmeino String ���㖾��NO
     */
    public void setUrmeino(String urmeino) {
        this._urmeino = urmeino;
    }

}