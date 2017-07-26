package jp.co.isid.kkh.model.common;

import java.util.Date;

import jp.co.isid.kkh.integ.tbl.TBTHBBSYS;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * �}�X�^�f�[�^VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/11 IP H.SHimizu)<BR>
 * </P>
 * @author
 */
public class CommonVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public CommonVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new CommonVO();
    }

    /**
     * �o�^�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �o�^�^�C���X�^���v
     */
    public void setTrkTimStmp(Date val) {
        set(TBTHBBSYS.TRKTIMSTMP, val);
    }

    /**
     * �o�^�^�C���X�^���v��Ԃ��܂��B
     * @return String �o�^�^�C���X�^���v
     */
    public Date getTrkTimStmp() {
        return (Date) get(TBTHBBSYS.TRKTIMSTMP);
    }

    /**
     * �o�^�v���O������ݒ肵�܂��B
     * @param val String �o�^�v���O����
     */
    public void setTrkPl(String val) {
        set(TBTHBBSYS.TRKPL, val);
    }

    /**
     * �o�^�v���O������Ԃ��܂��B
     * @return String �o�^�v���O����
     */
    public String getTrkPl() {
        return (String) get(TBTHBBSYS.TRKPL);
    }

    /**
     * �o�^�S���҂�ݒ肵�܂��B
     * @param val String �o�^�S����
     */
    public void setTrkTnt(String val) {
        set(TBTHBBSYS.TRKTNT, val);
    }

    /**
     * �o�^�S���҂�Ԃ��܂��B
     * @return String �o�^�S����
     */
    public String getTrkTnt() {
        return (String) get(TBTHBBSYS.TRKTNT);
    }

    /**
     * �X�V�^�C���X�^���v��ݒ肵�܂��B
     * @param val String �X�V�^�C���X�^���v
     */
    public void setUpdTimStmp(Date val) {
        set(TBTHBBSYS.UPDTIMSTMP, val);
    }

    /**
     * �X�V�^�C���X�^���v��Ԃ��܂��B
     * @return String �X�V�^�C���X�^���v
     */
    public Date getUpdTimStmp() {
        return (Date) get(TBTHBBSYS.UPDTIMSTMP);
    }

    /**
     * �X�V�v���O������ݒ肵�܂��B
     * @param val String �X�V�v���O����
     */
    public void setUpdaPl(String val) {
        set(TBTHBBSYS.UPDAPL, val);
    }

    /**
     * �X�V�v���O������Ԃ��܂��B
     * @return String �X�V�v���O����
     */
    public String getUpdaPl() {
        return (String) get(TBTHBBSYS.UPDAPL);
    }

    /**
     * �X�V�S���҂�ݒ肵�܂��B
     * @param val String �X�V�S����
     */
    public void setUpdTnt(String val) {
        set(TBTHBBSYS.UPDTNT   , val);
    }

    /**
     * �X�V�S���҂�Ԃ��܂��B
     * @return String �X�V�S����
     */
    public String getUpdTnt() {
        return (String) get(TBTHBBSYS.UPDTNT   );
    }

    /**
     * �c�Ə��i��j�R�[�h��ݒ肵�܂��B
     * @param val String �c�Ə��i��j�R�[�h
     */
    public void setEgCd(String val) {
        set(TBTHBBSYS.EGCD, val);
    }

    /**
     * �c�Ə��i��j�R�[�h��Ԃ��܂��B
     * @return String �c�Ə��i��j�R�[�h
     */
    public String getEgCd() {
        return (String) get(TBTHBBSYS.EGCD);
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     * @param val String ���Ӑ��ƃR�[�h
     */
    public void setTksKgyCd(String val) {
        set(TBTHBBSYS.TKSKGYCD, val);
    }

    /**
     * ���Ӑ��ƃR�[�h��Ԃ��܂��B
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getTksKgyCd() {
        return (String) get(TBTHBBSYS.TKSKGYCD);
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ敔��SEQNO
     */
    public void setTksBmnSeqNo(String val) {
        set(TBTHBBSYS.TKSBMNSEQNO, val);
    }

    /**
     * ���Ӑ敔��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ敔��SEQNO
     */
    public String getTksBmnSeqNo() {
        return (String) get(TBTHBBSYS.TKSBMNSEQNO);
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     * @param val String ���Ӑ�S��SEQNO
     */
    public void setTksTntSeqNo(String val) {
        set(TBTHBBSYS.TKSTNTSEQNO, val);
    }

    /**
     * ���Ӑ�S��SEQNO��Ԃ��܂��B
     * @return String ���Ӑ�S��SEQNO
     */
    public String getTksTntSeqNo() {
        return (String) get(TBTHBBSYS.TKSTNTSEQNO);
    }

    /**
     * ��ʂ�ݒ肵�܂��B
     * @param val String ���
     */
    public void setSybt(String val) {
        set(TBTHBBSYS.SYBT, val);
    }

    /**
     * ��ʂ�Ԃ��܂��B
     * @return String ���
     */
    public String getSybt() {
        return (String) get(TBTHBBSYS.SYBT);
    }

    /**
     * �t�B�[���h1��ݒ肵�܂��B
     * @param val String �t�B�[���h1
     */
    public void setField1(String val) {
        set(TBTHBBSYS.FIELD1, val);
    }

    /**
     * �t�B�[���h1��Ԃ��܂��B
     * @return String �t�B�[���h1
     */
    public String getField1() {
        return (String) get(TBTHBBSYS.FIELD1);
    }

    /**
     * �t�B�[���h2��ݒ肵�܂��B
     * @param val String �t�B�[���h2
     */
    public void setField2(String val) {
        set(TBTHBBSYS.FIELD2, val);
    }

    /**
     * �t�B�[���h2��Ԃ��܂��B
     * @return String �t�B�[���h2
     */
    public String getField2() {
        return (String) get(TBTHBBSYS.FIELD2);
    }

    /**
     * �t�B�[���h3��ݒ肵�܂��B
     * @param val String �t�B�[���h3
     */
    public void setField3(String val) {
        set(TBTHBBSYS.FIELD3, val);
    }

    /**
     * �t�B�[���h3��Ԃ��܂��B
     * @return String �t�B�[���h3
     */
    public String getField3() {
        return (String) get(TBTHBBSYS.FIELD3);
    }

    /**
     * �t�B�[���h4��ݒ肵�܂��B
     * @param val String �t�B�[���h4
     */
    public void setField4(String val) {
        set(TBTHBBSYS.FIELD4, val);
    }

    /**
     * �t�B�[���h4��Ԃ��܂��B
     * @return String �t�B�[���h4
     */
    public String getField4() {
        return (String) get(TBTHBBSYS.FIELD4);
    }

    /**
     * �t�B�[���h5��ݒ肵�܂��B
     * @param val String �t�B�[���h5
     */
    public void setField5(String val) {
        set(TBTHBBSYS.FIELD5, val);
    }

    /**
     * �t�B�[���h5��Ԃ��܂��B
     * @return String �t�B�[���h5
     */
    public String getField5() {
        return (String) get(TBTHBBSYS.FIELD5);
    }

    /**
     * �t�B�[���h6��ݒ肵�܂��B
     * @param val String �t�B�[���h6
     */
    public void setField6(String val) {
        set(TBTHBBSYS.FIELD6, val);
    }

    /**
     * �t�B�[���h6��Ԃ��܂��B
     * @return String �t�B�[���h6
     */
    public String getField6() {
        return (String) get(TBTHBBSYS.FIELD6);
    }

    /**
     * �t�B�[���h7��ݒ肵�܂��B
     * @param val String �t�B�[���h7
     */
    public void setField7(String val) {
        set(TBTHBBSYS.FIELD7, val);
    }

    /**
     * �t�B�[���h7��Ԃ��܂��B
     * @return String �t�B�[���h7
     */
    public String getField7() {
        return (String) get(TBTHBBSYS.FIELD7);
    }

    /**
     * �t�B�[���h8��ݒ肵�܂��B
     * @param val String �t�B�[���h8
     */
    public void setField8(String val) {
        set(TBTHBBSYS.FIELD8, val);
    }

    /**
     * �t�B�[���h8��Ԃ��܂��B
     * @return String �t�B�[���h8
     */
    public String getField8() {
        return (String) get(TBTHBBSYS.FIELD8);
    }

    /**
     * �t�B�[���h9��ݒ肵�܂��B
     * @param val String �t�B�[���h9
     */
    public void setField9(String val) {
        set(TBTHBBSYS.FIELD9, val);
    }

    /**
     * �t�B�[���h9��Ԃ��܂��B
     * @return String �t�B�[���h9
     */
    public String getField9() {
        return (String) get(TBTHBBSYS.FIELD9);
    }

    /**
     * �t�B�[���h10��ݒ肵�܂��B
     * @param val String �t�B�[���h10
     */
    public void setField10(String val) {
        set(TBTHBBSYS.FIELD10, val);
    }

    /**
     * �t�B�[���h10��Ԃ��܂��B
     * @return String �t�B�[���h10
     */
    public String getField10() {
        return (String) get(TBTHBBSYS.FIELD10);
    }

}
