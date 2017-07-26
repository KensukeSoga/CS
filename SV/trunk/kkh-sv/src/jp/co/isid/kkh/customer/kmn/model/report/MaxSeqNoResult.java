package jp.co.isid.kkh.customer.kmn.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * �V�[�N�G���XNo�̍ő�l��ێ�����B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/2/25 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
@XmlRootElement(namespace = "http://report.model.kmn.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.kmn.customer.kkh.isid.co.jp/")
public class MaxSeqNoResult extends AbstractServiceResult {

    /** �V�[�N�G���XNo�̍ő�l */
    private List<MaxSeqNoVO> _maxSeqNo = null;

    /**
     * �V�[�N�G���XNo�̍ő�l���擾���܂��B
     *
     * @return maxSeqNo
     */
    public List<MaxSeqNoVO> getMaxSeqNo() {
        return _maxSeqNo;
    }

    /**
     * �V�[�N�G���XNo�̍ő�l��ݒ肵�܂��B
     *
     * @param maxSeqNo
     */
    public void setMaxSeqNo(List<MaxSeqNoVO> maxSeqNo) {
        _maxSeqNo = maxSeqNo;
    }
}
