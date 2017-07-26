package jp.co.isid.kkh.model.common;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* �c�Ɠ���ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2011/11/04 JSE K.Fukuda)<BR>
* </P>
* @author HLC K.Honma
*/
@XmlRootElement(namespace = "http://common.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://common.model.kkh.isid.co.jp/")
public class EigyoBiResult extends AbstractServiceResult {

    /** �c�Ɠ� */
    private String _eigyoBi;

    /**
    * EIGYOBI��ݒ肵�܂��B
    * @param val String EIGYOBI
    */
   public void setEigyoBi(String val) {
       _eigyoBi = val;
   }

   /**
    * EIGYOBI��Ԃ��܂��B
    * @return String EIGYOBI
    */
   public String getEigyoBi() {
       return _eigyoBi;
   }

}
