package jp.co.isid.kkh.customer.uni.model.report;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * ���[�i���j�`���[��_�L����ו\�j�f�[�^��ێ�����B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/23 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
@XmlRootElement(namespace = "http://report.model.uni.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://report.model.uni.customer.kkh.isid.co.jp/")
public class ReportUniResult extends AbstractServiceResult {

    /** ���[�i���j�`���[��_�L����ו\_���ׁj�f�[�^VO���X�g */
    private List<ReportUniResultVO> _meisai;

    /** ���[�i���j�`���[��_�L����ו\_�v���[�t���X�g�j�f�[�^VO���X�g */
    private List<ReportUniResultVO> _proofs;

    /**
     * ���[�i���j�`���[��_�L����ו\_���ׁj�f�[�^VO���X�g���擾���܂��B
     *
     * @return _meisai
     */
    public List<ReportUniResultVO> getMeisai() {
        return _meisai;
    }

    /**
     * ���[�i���j�`���[��_�L����ו\_���ׁj�f�[�^VO���X�g��ݒ肵�܂��B
     *
     * @param meisai
     */
    public void setMeisai(List<ReportUniResultVO> meisai) {
        _meisai = meisai;
    }

    /**
     * ���[�i���j�`���[��_�L����ו\__�v���[�t���X�g�j�f�[�^VO���X�g���擾���܂��B
     *
     * @return _proofs
     */
    public List<ReportUniResultVO> getProofs() {
        return _proofs;
    }

    /**
     * ���[�i���j�`���[��_�L����ו\__�v���[�t���X�g�j�f�[�^VO���X�g��ݒ肵�܂��B
     *
     * @param proofs
     */
    public void setProofs(List<ReportUniResultVO> proofs) {
    	_proofs = proofs;
    }

}
