package jp.co.isid.kkh.model.common;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* 営業日を保持する。
* </P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/11/04 JSE K.Fukuda)<BR>
* </P>
* @author HLC K.Honma
*/
@XmlRootElement(namespace = "http://common.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://common.model.kkh.isid.co.jp/")
public class EigyoBiResult extends AbstractServiceResult {

    /** 営業日 */
    private String _eigyoBi;

    /**
    * EIGYOBIを設定します。
    * @param val String EIGYOBI
    */
   public void setEigyoBi(String val) {
       _eigyoBi = val;
   }

   /**
    * EIGYOBIを返します。
    * @return String EIGYOBI
    */
   public String getEigyoBi() {
       return _eigyoBi;
   }

}
