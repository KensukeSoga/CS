package jp.co.isid.kkh.customer.kmn.model.report;

import java.util.List;

import jp.co.isid.kkh.model.AbstractServiceCondition;

/**
 * <P>
 * �V�[�N�G���XNo�o�^�E�X�VCondition
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/2/26 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class UpdateSeqNoCondition extends AbstractServiceCondition {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** �������׈ꗗ(����)�e�[�u�����X�g */
    private List<ReportKmnListVO> _repKmnList = null;

//    /** APLID */
//    private String _aplId = null;
//
//    /** TKSTNTSEQNO */
//    private String _tksTntSeqNo = null;

    /**
     * �_�E�����[�h�e�[�u�����擾����
     * @return �_�E�����[�h�e�[�u��
     */
    public List<ReportKmnListVO> getRepKmnList() {
        return _repKmnList;
    }

    /**
     * �_�E�����[�h�e�[�u����ݒ肷��
     * @param thb1Down �_�E�����[�h�e�[�u��
     */
    public void setRepKmnList(List<ReportKmnListVO> repKmnList) {
        this._repKmnList = repKmnList;
    }

//    /**
//     * APLID��Ԃ��܂��B
//     *
//     * @return _aplId
//     */
//    public String getAplId() {
//        return _aplId;
//    }
//
//    /**
//     * APLID��ݒ肵�܂��B
//     *
//     * @param aplId
//     */
//    public void setBumonCd(String aplId) {
//        this._aplId = aplId;
//    }
//
//    /**
//     * TKSTNTSEQNO��Ԃ��܂��B
//     *
//     * @return _tksTntSeqNo
//     */
//    public String getTksTntSeqNo() {
//        return _tksTntSeqNo;
//    }
//
//    /**
//     * TKSTNTSEQNO��ݒ肵�܂��B
//     *
//     * @param tksTntSeqNo
//     */
//    public void setTksTntSeqNo(String tksTntSeqNo) {
//        this._tksTntSeqNo = tksTntSeqNo;
//    }
}

