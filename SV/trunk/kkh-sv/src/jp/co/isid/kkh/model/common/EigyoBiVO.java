package jp.co.isid.kkh.model.common;

import jp.co.isid.kkh.integ.tbl.TBTKJ99KNR;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �}�X�^�f�[�^VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/04 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class EigyoBiVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public EigyoBiVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new EigyoBiVO();
    }

    /**
    * EIGYOBI��ݒ肵�܂��B
    * @param val String EIGYOBI
    */
   public void setEigyoBi(String val) {
       set(TBTKJ99KNR.EIGYOBI, val);
   }

   /**
    * EIGYOBI��Ԃ��܂��B
    * @return String EIGYOBI
    */
   public String getEigyoBi() {
       return (String) get(TBTKJ99KNR.EIGYOBI);
   }

}