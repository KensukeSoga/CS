package jp.co.isid.kkh.customer.mac.model.master;

import java.math.BigDecimal;
import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �}�X�^�f�[�^VO�iINSERT�p�j
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/27 IP Shimizu)<BR>
 * </P>
 *
 * @author IP Shimizu
 */
public class MasterMacDataInsertVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public MasterMacDataInsertVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new MasterMacDataInsertVO();
    }

    public void SetData(String culumname, Object val){

        set(culumname, val);
    }

    /**
     * �o�^�^�C���X�^���v��ݒ肵�܂��B
     *
     * @param val String �o�^�^�C���X�^���v
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHBAMST.TRKTIMSTMP, val);
    }

    /**
     * �o�^�^�C���X�^���v��Ԃ��܂��B
     *
     * @return String �o�^�^�C���X�^���v
     */
    public Date getTrkTimStmp() {
        return (Date) get(TBTHBAMST.TRKTIMSTMP);
    }

    /**
     * �o�^�v���O������ݒ肵�܂��B
     *
     * @param val String �o�^�v���O����
     */
    public void setTrkPl(String val) {
        set(TBTHBAMST.TRKPL, val);
    }

    /**
     * �o�^�v���O������Ԃ��܂��B
     *
     * @return String �o�^�v���O����
     */
    public String getTrkPl() {
        return (String) get(TBTHBAMST.TRKPL);
    }

    /**
     * �o�^�S���҂�ݒ肵�܂��B
     *
     * @param val String �o�^�S����
     */
    public void setTrkTnt(String val) {
        set(TBTHBAMST.TRKTNT, val);
    }

    /**
     * �o�^�S���҂�Ԃ��܂��B
     *
     * @return String �o�^�S����
     */
    public String getTrkTnt() {
        return (String) get(TBTHBAMST.TRKTNT);
    }

    /**
     * �X�V�^�C���X�^���v��ݒ肵�܂��B
     *
     * @param val String �X�V�^�C���X�^���v
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHBAMST.UPDTIMSTMP, val);
    }

    /**
     * �X�V�^�C���X�^���v��Ԃ��܂��B
     *
     * @return String �X�V�^�C���X�^���v
     */
    public Date getUpdTimStmp() {
        return (Date) get(TBTHBAMST.UPDTIMSTMP);
    }

    /**
     * �X�V�v���O������ݒ肵�܂��B
     *
     * @param val String �X�V�v���O����
     */
    public void setUpdaPl(String val) {
        set(TBTHBAMST.UPDAPL, val);
    }

    /**
     * �X�V�v���O������Ԃ��܂��B
     *
     * @return String �X�V�v���O����
     */
    public String getUpdaPl() {
        return (String) get(TBTHBAMST.UPDAPL);
    }

    /**
     * �X�V�S���҂�ݒ肵�܂��B
     *
     * @param val String �X�V�S����
     */
    public void setUpdTnt(String val) {
        set(TBTHBAMST.UPDTNT, val);
    }

    /**
     * �X�V�S���҂�Ԃ��܂��B
     *
     * @return String �X�V�S����
     */
    public String getUpdTnt() {
        return (String) get(TBTHBAMST.UPDTNT);
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
     *
     * @param val String �c�Ə��i��j�R�[�h
     */
    public void setEgCd(String val) {
        set(TBTHBAMST.EGCD, val);
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
     *
     * @return String �c�Ə��i��j�R�[�h
     */
    public String getEgCd() {
        return (String) get(TBTHBAMST.EGCD);
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     *
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String val) {
        set(TBTHBAMST.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     *
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return (String) get(TBTHBAMST.TKSKGYCD);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     *
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHBAMST.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     *
     * @return String ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHBAMST.TKSBMNSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     *
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHBAMST.TKSTNTSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     *
     * @return String ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHBAMST.TKSTNTSEQNO);
    }

    /**
     * ��ʂ�ݒ肵�܂��B
     *
     * @param val String ���
     */
    public void setSybt(String val) {
        set(TBTHBAMST.SYBT, val);
    }

    /**
     * ��ʂ�Ԃ��܂��B
     *
     * @return String ���
     */
    public String getSybt() {
        return (String) get(TBTHBAMST.SYBT);
    }

    /**
     * �t�B�[���h1��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h1
     */
    public void setField1(String val) {
        set(TBTHBAMST.FIELD1, val);
    }

    /**
     * �t�B�[���h1��Ԃ��܂��B
     *
     * @return String �t�B�[���h1
     */
    public String getField1() {
        return (String) get(TBTHBAMST.FIELD1);
    }

    /**
     * �t�B�[���h2��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h2
     */
    public void setField2(String val) {
        set(TBTHBAMST.FIELD2, val);
    }

    /**
     * �t�B�[���h2��Ԃ��܂��B
     *
     * @return String �t�B�[���h2
     */
    public String getField2() {
        return (String) get(TBTHBAMST.FIELD2);
    }

    /**
     * �t�B�[���h3��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h3
     */
    public void setField3(String val) {
        set(TBTHBAMST.FIELD3, val);
    }

    /**
     * �t�B�[���h3��Ԃ��܂��B
     *
     * @return String �t�B�[���h3
     */
    public String getField3() {
        return (String) get(TBTHBAMST.FIELD3);
    }

    /**
     * �t�B�[���h4��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h4
     */
    public void setField4(String val) {
        set(TBTHBAMST.FIELD4, val);
    }

    /**
     * �t�B�[���h4��Ԃ��܂��B
     *
     * @return String �t�B�[���h4
     */
    public String getField4() {
        return (String) get(TBTHBAMST.FIELD4);
    }

    /**
     * �t�B�[���h5��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h5
     */
    public void setField5(String val) {
        set(TBTHBAMST.FIELD5, val);
    }

    /**
     * �t�B�[���h5��Ԃ��܂��B
     *
     * @return String �t�B�[���h5
     */
    public String getField5() {
        return (String) get(TBTHBAMST.FIELD5);
    }

    /**
     * �t�B�[���h6��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h6
     */
    public void setField6(String val) {
        set(TBTHBAMST.FIELD6, val);
    }

    /**
     * �t�B�[���h6��Ԃ��܂��B
     *
     * @return String �t�B�[���h6
     */
    public String getField6() {
        return (String) get(TBTHBAMST.FIELD6);
    }

    /**
     * �t�B�[���h7��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h7
     */
    public void setField7(String val) {
        set(TBTHBAMST.FIELD7, val);
    }

    /**
     * �t�B�[���h7��Ԃ��܂��B
     *
     * @return String �t�B�[���h7
     */
    public String getField7() {
        return (String) get(TBTHBAMST.FIELD7);
    }

    /**
     * �t�B�[���h8��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h8
     */
    public void setField8(String val) {
        set(TBTHBAMST.FIELD8, val);
    }

    /**
     * �t�B�[���h8��Ԃ��܂��B
     *
     * @return String �t�B�[���h8
     */
    public String getField8() {
        return (String) get(TBTHBAMST.FIELD8);
    }

    /**
     * �t�B�[���h9��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h9
     */
    public void setField9(String val) {
        set(TBTHBAMST.FIELD9, val);
    }

    /**
     * �t�B�[���h9��Ԃ��܂��B
     *
     * @return String �t�B�[���h9
     */
    public String getField9() {
        return (String) get(TBTHBAMST.FIELD9);
    }

    /**
     * �t�B�[���h10��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h10
     */
    public void setField10(String val) {
        set(TBTHBAMST.FIELD10, val);
    }

    /**
     * �t�B�[���h10��Ԃ��܂��B
     *
     * @return String �t�B�[���h10
     */
    public String getField10() {
        return (String) get(TBTHBAMST.FIELD10);
    }

    /**
     * �t�B�[���h11��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h11
     */
    public void setField11(String val) {
        set(TBTHBAMST.FIELD11, val);
    }

    /**
     * �t�B�[���h11��Ԃ��܂��B
     *
     * @return String �t�B�[���h11
     */
    public String getField11() {
        return (String) get(TBTHBAMST.FIELD11);
    }

    /**
     * �t�B�[���h12��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h12
     */
    public void setField12(String val) {
        set(TBTHBAMST.FIELD12, val);
    }

    /**
     * �t�B�[���h12��Ԃ��܂��B
     *
     * @return String �t�B�[���h12
     */
    public String getField12() {
        return (String) get(TBTHBAMST.FIELD12);
    }

    /**
     * �t�B�[���h13��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h13
     */
    public void setField13(String val) {
        set(TBTHBAMST.FIELD13, val);
    }

    /**
     * �t�B�[���h13��Ԃ��܂��B
     *
     * @return String �t�B�[���h13
     */
    public String getField13() {
        return (String) get(TBTHBAMST.FIELD13);
    }

    /**
     * �t�B�[���h14��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h14
     */
    public void setField14(String val) {
        set(TBTHBAMST.FIELD14, val);
    }

    /**
     * �t�B�[���h14��Ԃ��܂��B
     *
     * @return String �t�B�[���h14
     */
    public String getField14() {
        return (String) get(TBTHBAMST.FIELD14);
    }

    /**
     * �t�B�[���h15��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h15
     */
    public void setField15(String val) {
        set(TBTHBAMST.FIELD15, val);
    }

    /**
     * �t�B�[���h15��Ԃ��܂��B
     *
     * @return String �t�B�[���h15
     */
    public String getField15() {
        return (String) get(TBTHBAMST.FIELD15);
    }

    /**
     * �t�B�[���h16��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h16
     */
    public void setField16(String val) {
        set(TBTHBAMST.FIELD16, val);
    }

    /**
     * �t�B�[���h16��Ԃ��܂��B
     *
     * @return String �t�B�[���h16
     */
    public String getField16() {
        return (String) get(TBTHBAMST.FIELD16);
    }

    /**
     * �t�B�[���h17��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h17
     */
    public void setField17(String val) {
        set(TBTHBAMST.FIELD17, val);
    }

    /**
     * �t�B�[���h17��Ԃ��܂��B
     *
     * @return String �t�B�[���h17
     */
    public String getField17() {
        return (String) get(TBTHBAMST.FIELD17);
    }

    /**
     * �t�B�[���h18��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h18
     */
    public void setField18(String val) {
        set(TBTHBAMST.FIELD18, val);
    }

    /**
     * �t�B�[���h18��Ԃ��܂��B
     *
     * @return String �t�B�[���h18
     */
    public String getField18() {
        return (String) get(TBTHBAMST.FIELD18);
    }

    /**
     * �t�B�[���h19��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h19
     */
    public void setField19(String val) {
        set(TBTHBAMST.FIELD19, val);
    }

    /**
     * �t�B�[���h19��Ԃ��܂��B
     *
     * @return String �t�B�[���h19
     */
    public String getField19() {
        return (String) get(TBTHBAMST.FIELD19);
    }

    /**
     * �t�B�[���h20��ݒ肵�܂��B
     *
     * @param val String �t�B�[���h20
     */
    public void setField20(String val) {
        set(TBTHBAMST.FIELD20, val);
    }

    /**
     * �t�B�[���h20��Ԃ��܂��B
     *
     * @return String �t�B�[���h20
     */
    public String getField20() {
        return (String) get(TBTHBAMST.FIELD20);
    }

    /**
     * ���l1��ݒ肵�܂��B
     *
     * @param val BigDecimal ���l1
     */
    public void setIntValue1(BigDecimal val) {
        set(TBTHBAMST.INTVALUE1, val);
    }

    /**
     * ���l1��Ԃ��܂��B
     *
     * @return BigDecimal ���l1
     */
    public BigDecimal getIntValue1() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE1);
    }

    /**
     * ���l2��ݒ肵�܂��B
     *
     * @param val BigDecimal ���l2
     */
    public void setIntValue2(BigDecimal val) {
        set(TBTHBAMST.INTVALUE2, val);
    }

    /**
     * ���l2��Ԃ��܂��B
     *
     * @return BigDecimal ���l2
     */
    public BigDecimal getIntValue2() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE2);
    }

    /**
     * ���l3��ݒ肵�܂��B
     *
     * @param val BigDecimal ���l3
     */
    public void setIntValue3(BigDecimal val) {
        set(TBTHBAMST.INTVALUE3, val);
    }

    /**
     * ���l3��Ԃ��܂��B
     *
     * @return BigDecimal ���l3
     */
    public BigDecimal getIntValue3() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE3);
    }

    /**
     * ���l4��ݒ肵�܂��B
     *
     * @param val BigDecimal ���l4
     */
    public void setIntValue4(BigDecimal val) {
        set(TBTHBAMST.INTVALUE4, val);
    }

    /**
     * ���l4��Ԃ��܂��B
     *
     * @return BigDecimal ���l4
     */
    public BigDecimal getIntValue4() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE4);
    }

    /**
     * ���l5��ݒ肵�܂��B
     *
     * @param val BigDecimal ���l5
     */
    public void setIntValue5(BigDecimal val) {
        set(TBTHBAMST.INTVALUE5, val);
    }

    /**
     * ���l5��Ԃ��܂��B
     *
     * @return BigDecimal ���l5
     */
    public BigDecimal getIntValue5() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE5);
    }

    /**
     * ���l6��ݒ肵�܂��B
     *
     * @param val BigDecimal ���l6
     */
    public void setIntValue6(BigDecimal val) {
        set(TBTHBAMST.INTVALUE6, val);
    }

    /**
     * ���l6��Ԃ��܂��B
     *
     * @return BigDecimal ���l6
     */
    public BigDecimal getIntValue6() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE6);
    }

    /**
     * ���l7��ݒ肵�܂��B
     *
     * @param val BigDecimal ���l7
     */
    public void setIntValue7(BigDecimal val) {
        set(TBTHBAMST.INTVALUE7, val);
    }

    /**
     * ���l7��Ԃ��܂��B
     *
     * @return BigDecimal ���l7
     */
    public BigDecimal getIntValue7() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE7);
    }

    /**
     * ���l8��ݒ肵�܂��B
     *
     * @param val BigDecimal ���l8
     */
    public void setIntValue8(BigDecimal val) {
        set(TBTHBAMST.INTVALUE8, val);
    }

    /**
     * ���l8��Ԃ��܂��B
     *
     * @return BigDecimal ���l8
     */
    public BigDecimal getIntValue8() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE8);
    }

    /**
     * ���l9��ݒ肵�܂��B
     *
     * @param val BigDecimal ���l9
     */
    public void setIntValue9(BigDecimal val) {
        set(TBTHBAMST.INTVALUE9, val);
    }

    /**
     * ���l9��Ԃ��܂��B
     *
     * @return BigDecimal ���l9
     */
    public BigDecimal getIntValue9() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE9);
    }

    /**
     * ���l10��ݒ肵�܂��B
     *
     * @param val BigDecimal ���l10
     */
    public void setIntValue10(BigDecimal val) {
        set(TBTHBAMST.INTVALUE10, val);
    }

    /**
     * ���l10��Ԃ��܂��B
     *
     * @return BigDecimal ���l10
     */
    public BigDecimal getIntValue10() {
        return (BigDecimal) get(TBTHBAMST.INTVALUE10);
    }

}
