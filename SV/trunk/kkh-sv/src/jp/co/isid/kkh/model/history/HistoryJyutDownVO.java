package jp.co.isid.kkh.model.history;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �����iLion)VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/2/1 fourm h.izawa)<BR>
 * </P>
 * @author
 */
public class HistoryJyutDownVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public HistoryJyutDownVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new HistoryJyutDownVO();
    }

    /**
     * ���[�o�̓^�C���X�^���v��ݒ肵�܂��B
     * @param val String GPSYUTIMSTMP
     */
    public void setGPSYUTIMSTMP(String val){
        set("GPSYUTIMSTMP",val);
    }

    /**
     * ���[�o�̓^�C���X�^���v��Ԃ��܂��B
     * @return String GPSYUTIMSTMP
     */
    public String getGPSYUTIMSTMP(){
        return(String) get("GPSYUTIMSTMP");
    }

    /**
     * �o�͋敪��ݒ肵�܂��B
     * @param val String SYUKBN
     */
    public void setSYUKBN(String val){
        set("SYUKBN",val);
    }

    /**
     * �o�͋敪��Ԃ��܂��B
     * @return String SYUKBN
     */
    public String getSYUKBN(){
        return(String) get("SYUKBN");
    }

    /**
     * �����N����ݒ肵�܂��B
     * @param val String YYMM
     */
    public void setYYMM(String val){
        set("YYMM",val);
    }

    /**
     * �����N����Ԃ��܂��B
     * @return String YYMM
     */
    public String getYYMM(){
        return(String) get("YYMM");
    }

    /**
     * �Ɩ��敪��ݒ肵�܂��B
     * @param val String GYOMKBN
     */
    public void setGYOMKBN(String val){
        set("GYOMKBN",val);
    }

    /**
     * �Ɩ��敪��Ԃ��܂��B
     * @return String GYOMKBN
     */
    public String getGYOMKBN(){
        return(String) get("GYOMKBN");
    }

    /**
     * �S���҃R�[�h��ݒ肵�܂��B
     * @param val String TNTCD
     */
    public void setTNTCD(String val){
        set("TNTCD",val);
    }

    /**
     * �S���҃R�[�h��Ԃ��܂��B
     * @return String TNTCD
     */
    public String getTNTCD(){
        return(String) get("TNTCD");
    }

    /**
     * �S���Җ���ݒ肵�܂��B
     * @param val String TNTCD
     */
    public void setTNTNM(String val){
        set("TNTNM",val);
    }

    /**
     * �S���Җ���Ԃ��܂��B
     * @return String TNTCD
     */
    public String getTNTNM(){
        return(String) get("TNTNM");
    }

}
