package jp.co.isid.kkh.customer.epson.model.detail;

import java.util.List;

import jp.co.isid.kkh.model.detail.JyutyuDataMergeVO;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �ꊇ���������pVO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/24 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class BulkJyutyuDataEpsonMergeVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** �󒍓����f�[�^���X�g */
    private List<JyutyuDataMergeVO> _jyutyuDataMergeVOList = null;

    /** �_�~�[�v���p�e�B */
    private String _dummy = null;

    /**
     * �󒍓����f�[�^���X�g���擾����
     * @return �󒍓����f�[�^���X�g
     */
    public List<JyutyuDataMergeVO> getJyutyuDataMergeVOList() {
        return _jyutyuDataMergeVOList;
    }

    /**
     * �󒍓����f�[�^���X�g��ݒ肷��
     * @param jyutyuDataMergeVOList �󒍓����f�[�^���X�g
     */
    public void setJyutyuDataMergeVOList(List<JyutyuDataMergeVO> jyutyuDataMergeVOList) {
        this._jyutyuDataMergeVOList = jyutyuDataMergeVOList;
    }

    /**
     * �_�~�[�v���p�e�B���擾����
     * @return �_�~�[�v���p�e�B
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * �_�~�[�v���p�e�B��ݒ肷��
     * @param dummy �_�~�[�v���p�e�B
     */
    public void setDummy(String dummy) {
        this._dummy = dummy;
    }

}
