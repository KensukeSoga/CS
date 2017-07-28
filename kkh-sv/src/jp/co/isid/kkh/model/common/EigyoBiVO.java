package jp.co.isid.kkh.model.common;

import jp.co.isid.kkh.integ.tbl.TBTKJ99KNR;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * マスタデータVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/04 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class EigyoBiVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public EigyoBiVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new EigyoBiVO();
    }

    /**
    * EIGYOBIを設定します。
    * @param val String EIGYOBI
    */
   public void setEigyoBi(String val) {
       set(TBTKJ99KNR.EIGYOBI, val);
   }

   /**
    * EIGYOBIを返します。
    * @return String EIGYOBI
    */
   public String getEigyoBi() {
       return (String) get(TBTKJ99KNR.EIGYOBI);
   }

}