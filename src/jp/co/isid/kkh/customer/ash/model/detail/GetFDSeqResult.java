package jp.co.isid.kkh.customer.ash.model.detail;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
*
* <P>
* �L����׃f�[�^�������ʂ�ێ�����B
* </P>
* <P>
* <B>�C������</B><BR>
* �E�V�K�쐬(2011/12/27 JSE K.Fukuda)<BR>
* </P>
* @author
*/
@XmlRootElement(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.ash.customer.kkh.isid.co.jp/")
public class GetFDSeqResult extends AbstractServiceResult {

    /** FD SEQ */
    private String _fdSeq;

    /**
     * FD SEQ���擾���܂��B
     * @return
     */
    public String getFdSeq() {
        return _fdSeq;
    }

    /**
     * FD SEQ��ݒ肵�܂��B
     * @param fdSeq
     */
    public void setFdSeq(String fdSeq) {
        this._fdSeq = fdSeq;
    }

}
