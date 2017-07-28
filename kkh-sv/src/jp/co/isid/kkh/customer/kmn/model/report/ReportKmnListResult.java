package jp.co.isid.kkh.customer.kmn.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * ���[�i����_�����ꗗ�j�f�[�^��ێ�����B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/1/31 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
@XmlRootElement(namespace = "http://report.model.kmn.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.kmn.customer.kkh.isid.co.jp/")
public class ReportKmnListResult extends AbstractServiceResult {

    /** ���[�i����_�����ꗗ�j�f�[�^VO���X�g */
    private List<ReportKmnListVO> _rptList;

    /**
     * ���[�i����_�����ꗗ�j�f�[�^VO���X�g���擾���܂��B
     *
     * @return _rptList
     */
    public List<ReportKmnListVO> getRptList() {
        return _rptList;
    }

    /**
     * ���[�i����_�����ꗗ�j�f�[�^VO���X�g��ݒ肵�܂��B
     *
     * @param meisai
     */
    public void setRptList(List<ReportKmnListVO> rptList) {
        _rptList = rptList;
    }
}
