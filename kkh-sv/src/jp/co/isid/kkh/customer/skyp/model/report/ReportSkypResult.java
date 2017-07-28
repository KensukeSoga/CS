package jp.co.isid.kkh.customer.skyp.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * ���[�i�X�J�p�[_�[�i�^�������j�f�[�^��ێ�����B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/16 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://report.model.skyp.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.skyp.customer.kkh.isid.co.jp/")
public class ReportSkypResult extends AbstractServiceResult {

    /** ���[�i�X�J�p�[_�[�i�^�������j�f�[�^VO���X�g */
    private List<ReportSkypVO> _reportSkyp;

    /**
     * ���[�i�X�J�p�[_�[�i�^�������j�f�[�^VO���X�g���擾���܂��B
     *
     * @return _reportSkyp
     */
    public List<ReportSkypVO> getReportSkyp() {
        return _reportSkyp;
    }

    /**
     * ���[�i�X�J�p�[_�[�i�^�������j�f�[�^VO���X�g��ݒ肵�܂��B
     *
     * @param reportSkyp
     */
    public void setReportSkyp(List<ReportSkypVO> reportSkyp) {
        _reportSkyp = reportSkyp;
    }

}
