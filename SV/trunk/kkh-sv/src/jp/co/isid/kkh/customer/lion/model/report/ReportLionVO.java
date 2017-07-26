package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU29CC;
import jp.co.isid.nj.model.AbstractModel;

public class ReportLionVO extends AbstractModel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    /** �ꏊ  */
    public static final String BASHO = "BASHO";

    /** �T�C�Y */
    public static final String SAIZU = "SAIZU";

    /** �L�G */
    public static final String KIZATSU = "KIZATSU";

    /** ���[ */
    public static final String CHOYU = "CHOYU";

    /** ���f�B�A */
    public static final String MEDIA = "MEDIA";

    /** ���f�B�A(��) */
    public static final String MEDIARYA = "MEDIARYA";

    /** �F�� */
    public static final String IROZURI = "IROZURI";

    /** CM�b�����v */
    public static final String BYOSU_GOKEI = "BYOSU_GOKEI";

    /** �u�����h�R�[�h */
    public static final String BRAND_CD = "BRAND_CD";

    /** �u�����h�� */
    public static final String BRAND_MEI = "BRAND_MEI";

    /** �ǃR�[�h */
    public static final String KYOKU_CD = "KYOKU_CD";

    /** �ǖ� */
    public static final String KYOKU_MEI = "KYOKU_MEI";

    /** �ԑg�R�[�h */
    public static final String BANGUMI_CD = "BANGUMI_CD";

    /** �ԑg�� */
    public static final String BANGUMI_MEI = "BANGUMI_MEI";

    /** �e���r�ǃR�[�h */
    public static final String TV_KYOKU_CD = "TV_KYOKU_CD";

    /** �e���r�ǖ� */
    public static final String TV_KYOKU_MEI = "TV_KYOKU_MEI";

    /** �e���r�ԑg�R�[�h */
    public static final String TV_BANGUMI_CD = "TV_BANGUMI_CD";

    /** �e���r�ԑg�� */
    public static final String TV_BANGUMI_MEI = "TV_BANGUMI_MEI";

    /** ���W�I�ǃR�[�h */
    public static final String RD_KYOKU_CD = "RD_KYOKU_CD";

    /** ���W�I�ǖ� */
    public static final String RD_KYOKU_MEI = "RD_KYOKU_MEI";

    /** ���W�I�ԑg�R�[�h */
    public static final String RD_BANGUMI_CD = "RD_BANGUMI_CD";

    /** ���W�I�ԑg�� */
    public static final String RD_BANGUMI_MEI = "RD_BANGUMI_MEI";

    /** ����ŗ� */
    public static final String SHOHIZEI_RITU = "SHOHIZEI_RITU";

    /** ����Ŋz */
    public static final String SHOHIZEI_GAK = "SHOHIZEI_GAK";

    /**�V���R�[�h*/
    public static final String SHINBUN_CD = "SHINBUN_CD";

    /**�V����*/
    public static final String SHINBUN_MEI = "SHINBUN_MEI";

    /**�G���R�[�h*/
    public static final String ZASHI_CD = "ZASHI_CD";

    /**�G����*/
    public static final String ZASHI_NAME = "ZASHI_NAME";

    /**�X�y�[�X*/
    public static final String SPACE = "SPACE";

    /**����*/
    public static final String KEN_NAME = "KEN_NAME";

    /**���R�[�h*/
    public static final String KEN_CD = "KEN_CD";

    /**�H����*/
    public static final String ROSEN_NAME = "ROSEN_NAME";

    /**����*/
    public static final String KIKAN = "KIKAN";

    /**����*/
    public static final String KEN_MEI = "KEN_MEI";

    /**�ǎ��R�[�h*/
    public static final String KYOKUSHI_CD = "KYOKUSHI_CD";

    /**�ǎ���*/
    public static final String KYOKUSHI_NAME = "KYOKUSHI_NAME";

    /**�W�������R�[�h*/
    public static final String JANLE_CD = "JANLE_CD";

    /**�W��������*/
    public static final String JANLE_NAME = "JANLE_NAME";

    /**�v���O�����R�[�h*/
    public static final String PROGRAM_CD = "PROGRAM_CD";

    /**�\��*/
    public static final String HYOJI = "HYOJI";

    /**�{��*/
    public static final String HONSU = "HONSU";

    /**�v���O������*/
    public static final String PROGRAM_NAME = "PROGRAM_NAME";

    /**�}�̃R�[�h*/
    public static final String BAITAI_CD = "BAITAI_CD";

    /**�}�̖�*/
    public static final String BAITAI_NAME = "BAITAI_NAME";

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportLionVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportLionVO();
    }

	/**
	 * ��NO��ݒ肵�܂��B
	 * @param val String ��NO
	 */
	 public void setJyutNo(String val) {
	     set(TBTHB2KMEI.JYUTNO, val);
	 }
	 /**
	 * ��NO��Ԃ��܂��B
	 * @return String ��NO
	 */
	 public String getJyutNo() {
	     return (String) get(TBTHB2KMEI.JYUTNO);
	 }

	/**
	* �󒍖���NO��ݒ肵�܂��B
	* @param val String �󒍖���NO
	*/
	public void setJyMeiNo(String val) {
	  set(TBTHB2KMEI.JYMEINO, val);
	}

	/**
	* �󒍖���NO��Ԃ��܂��B
	* @return String �󒍖���NO
	*/
	public String getJyMeiNo() {
	  return (String) get(TBTHB2KMEI.JYMEINO);
	}

	/**
	* ���㖾��NO��ݒ肵�܂��B
	* @param val String ���㖾��NO
	*/
	public void setUrMeiNo(String val) {
	  set(TBTHB2KMEI.URMEINO, val);
	}

	/**
	* ���㖾��NO��Ԃ��܂��B
	* @return String ���㖾��NO
	*/
	public String getUrMeiNo() {
	  return (String) get(TBTHB2KMEI.URMEINO);
	}

//	/**
//	* �f�ړ���ݒ肵�܂��B
//	* @param val String �f�ړ�
//	*/
//	public void setDate1(String val) {
//	  set(TBTHB2KMEI.DATE1, val);
//	}
//
//	/**
//	* �f�ړ���Ԃ��܂��B
//	* @return String �f�ړ�
//	*/
//	public String getDate1() {
//	  return (String) get(TBTHB2KMEI.DATE1);
//	}
//
	/**
	* CODE1��ݒ肵�܂��B
	* @param val String CODE1
	*/
	public void setCode1(String val) {
	  set(TBTHB2KMEI.CODE1, val);
	}

	/**
	* CODE1��Ԃ��܂��B
	* @return String CODE1
	*/
	public String getCode1() {
	  return (String) get(TBTHB2KMEI.CODE1);
	}

	/**
	* CODE2��ݒ肵�܂��B
	* @param val String CODE2
	*/
	public void setCode2(String val) {
	  set(TBTHB2KMEI.CODE2, val);
	}

	/**
	* CODE2��Ԃ��܂��B
	* @return String CODE2
	*/
	public String getCode2() {
	  return (String) get(TBTHB2KMEI.CODE2);
	}

	/**
	* CODE3��ݒ肵�܂��B
	* @param val String CODE3
	*/
	public void setCode3(String val) {
	  set(TBTHB2KMEI.CODE3, val);
	}

	/**
	* CODE3��Ԃ��܂��B
	* @return String CODE3
	*/
	public String getCode3() {
	  return (String) get(TBTHB2KMEI.CODE3);
	}

	/**
	* CODE4��ݒ肵�܂��B
	* @param val String CODE4
	*/
	public void setCode4(String val) {
	  set(TBTHB2KMEI.CODE4, val);
	}
	/**
	* CODE4��Ԃ��܂��B
	* @return String CODE4
	*/
	public String getCode4() {
	  return (String) get(TBTHB2KMEI.CODE4);
	}

	/**
	* CODE5��ݒ肵�܂��B
	* @param val String CODE5
	*/
	public void setCode5(String val) {
	  set(TBTHB2KMEI.CODE5, val);
	}
	/**
	* CODE5��Ԃ��܂��B
	* @return String CODE5
	*/
	public String getCode5() {
	  return (String) get(TBTHB2KMEI.CODE5);
	}

	/**
	* CODE6��ݒ肵�܂��B
	* @param val String CODE6
	*/
	public void setCode6(String val) {
	  set(TBTHB2KMEI.CODE6, val);
	}
	/**
	* CODE6��Ԃ��܂��B
	* @return String CODE6
	*/
	public String getCode6() {
	  return (String) get(TBTHB2KMEI.CODE6);
	}
	/**
	* NAME1��ݒ肵�܂��B
	* @param val String NAME1
	*/
	public void setName1(String val) {
	  set(TBTHB2KMEI.NAME1, val);
	}

	/**
	* NAME1��Ԃ��܂��B
	* @return String NAME1
	*/
	public String getName1() {
	  return (String) get(TBTHB2KMEI.NAME1);
	}
//
//	/**
//	* NAME2��ݒ肵�܂��B
//	* @param val String NAME2
//	*/
//	public void setName2(String val) {
//	  set(TBTHB2KMEI.NAME2, val);
//	}
//
//	/**
//	* NAME2��Ԃ��܂��B
//	* @return String NAME2
//	*/
//	public String getName2() {
//	  return (String) get(TBTHB2KMEI.NAME2);
//	}

	/**
	* NAME3��ݒ肵�܂��B
	* @param val String NAME3
	*/
	public void setName3(String val) {
	  set(TBTHB2KMEI.NAME3, val);
	}

	/**
	* NAME3��Ԃ��܂��B
	* @return String NAME3
	*/
	public String getName3() {
	  return (String) get(TBTHB2KMEI.NAME3);
	}

	/**
	* NAME4��ݒ肵�܂��B
	* @param val String NAME4
	*/
	public void setName4(String val) {
	  set(TBTHB2KMEI.NAME4, val);
	}

	/**
	* NAME4��Ԃ��܂��B
	* @return String NAME4
	*/
	public String getName4() {
	  return (String) get(TBTHB2KMEI.NAME4);
	}

	/**
	* NAME5��ݒ肵�܂��B
	* @param val String NAME5
	*/
	public void setName5(String val) {
	  set(TBTHB2KMEI.NAME5, val);
	}

	/**
	* NAME5��Ԃ��܂��B
	* @return String NAME5
	*/
	public String getName5() {
	  return (String) get(TBTHB2KMEI.NAME5);
	}

	/**
	* NAME6��ݒ肵�܂��B
	* @param val String NAME6
	*/
	public void setName6(String val) {
	  set(TBTHB2KMEI.NAME6, val);
	}
	/**
	* NAME6��Ԃ��܂��B
	* @return String NAME6
	*/
	public String getName6() {
	  return (String) get(TBTHB2KMEI.NAME6);
	}

	/**
	* NAME7��ݒ肵�܂��B
	* @param val String NAME7
	*/
	public void setName7(String val) {
	  set(TBTHB2KMEI.NAME7, val);
	}
	/**
	* NAME7��Ԃ��܂��B
	* @return String NAME7
	*/
	public String getName7() {
	  return (String) get(TBTHB2KMEI.NAME7);
	}

	/**
	* NAME8��ݒ肵�܂��B
	* @param val String NAME8
	*/
	public void setName8(String val) {
	  set(TBTHB2KMEI.NAME8, val);
	}
	/**
	* NAME8��Ԃ��܂��B
	* @return String NAME8
	*/
	public String getName8() {
	  return (String) get(TBTHB2KMEI.NAME8);
	}

	/**
	* NAME11��ݒ肵�܂��B
	* @param val String NAME11
	*/
	public void setName11(String val) {
	  set(TBTHB2KMEI.NAME11, val);
	}
	/**
	* NAME11��Ԃ��܂��B
	* @return String NAME11
	*/
	public String getName11() {
	  return (String) get(TBTHB2KMEI.NAME11);
	}

	/**
	* NAME12��ݒ肵�܂��B
	* @param val String NAME12
	*/
	public void setName12(String val) {
	  set(TBTHB2KMEI.NAME12, val);
	}
	/**
	* NAME12��Ԃ��܂��B
	* @return String NAME12
	*/
	public String getName12() {
	  return (String) get(TBTHB2KMEI.NAME12);
	}

	/**
	* Name13��ݒ肵�܂��B
	* @param val String NAME13
	*/
	public void setName13(String val) {
	  set(TBTHB2KMEI.NAME13, val);
	}
	/**
	* NAME13��Ԃ��܂��B
	* @return String NAME13
	*/
	public String getName13() {
	  return (String) get(TBTHB2KMEI.NAME13);
	}

	/**
	* NAME14��ݒ肵�܂��B
	* @param val String NAME14
	*/
	public void setName14(String val) {
	  set(TBTHB2KMEI.NAME14, val);
	}
	/**
	* NAME14��Ԃ��܂��B
	* @return String NAME14
	*/
	public String getName14() {
	  return (String) get(TBTHB2KMEI.NAME14);
	}

	/**
	* NAME15��ݒ肵�܂��B
	* @param val String NAME15
	*/
	public void setName15(String val) {
	  set(TBTHB2KMEI.NAME15, val);
	}
	/**
	* NAME15��Ԃ��܂��B
	* @return String NAME15
	*/
	public String getName15() {
	  return (String) get(TBTHB2KMEI.NAME15);
	}

	/**
	* NAME15��ݒ肵�܂��B
	* @param val String NAME16
	*/
	public void setName16(String val) {
	  set(TBTHB2KMEI.NAME16, val);
	}
	/**
	* NAME16��Ԃ��܂��B
	* @return String NAME16
	*/
	public String getName16() {
	  return (String) get(TBTHB2KMEI.NAME16);
	}

	/**
	* NAME17��ݒ肵�܂��B
	* @param val String NAME17
	*/
	public void setName17(String val) {
	  set(TBTHB2KMEI.NAME17, val);
	}
	/**
	* NAME17��Ԃ��܂��B
	* @return String NAME17
	*/
	public String getName17() {
	  return (String) get(TBTHB2KMEI.NAME17);
	}

	/**
	* �敪2��ݒ肵�܂��B
	* @param val String �敪2
	*/
	public void setKbn2(String val) {
	  set(TBTHB2KMEI.KBN2, val);
	}

	/**
	* �敪2��Ԃ��܂��B
	* @return String �敪2
	*/
	public String getKbn2() {
	  return (String) get(TBTHB2KMEI.KBN2);
	}

//
//	/**
//	* ���z1��ݒ肵�܂��B
//	* @param val BigDecimal ���z1
//	*/
//	public void setKngk1(BigDecimal val) {
//	  set(TBTHB2KMEI.KNGK1, val);
//	}
//
//	/**
//	* ���z1��Ԃ��܂��B
//	* @return BigDecimal ���z1
//	*/
//	public BigDecimal getKngk1() {
//	  return (BigDecimal) get(TBTHB2KMEI.KNGK1);
//	}
//
	/**
	* ���z2��ݒ肵�܂��B
	* @param val BigDecimal ���z2
	*/
	public void setKngk2(BigDecimal val) {
	  set(TBTHB2KMEI.KNGK2, val);
	}
	/**
	* ���z2��Ԃ��܂��B
	* @return BigDecimal ���z2
	*/
	public BigDecimal getKngk2() {
	  return (BigDecimal) get(TBTHB2KMEI.KNGK2);
	}

	/**
	* ���z3��ݒ肵�܂��B
	* @param val BigDecimal ���z2
	*/
	public void setKngk3(BigDecimal val) {
	  set(TBTHB2KMEI.KNGK3, val);
	}
	/**
	* ���z3��Ԃ��܂��B
	* @return BigDecimal ���z2
	*/
	public BigDecimal getKngk3() {
	  return (BigDecimal) get(TBTHB2KMEI.KNGK3);
	}

	/**
	* RENBN��ݒ肵�܂��B
	* @param val String RENBN
	*/
	public void setRenbn(String val) {
	  set(TBTHB2KMEI.RENBN, val);
	}

	/**
	* RENBN��Ԃ��܂��B
	* @return String RENBN
	*/
	public String getRenbn() {
	  return (String) get(TBTHB2KMEI.RENBN);
	}


	/**
	* YYMM��ݒ肵�܂��B
	* @param val String YYMM
	*/
	public void setYymm(String val) {
	  set(TBTHB1DOWN.YYMM, val);
	}
	/**
	* YYMM��Ԃ��܂��B
	* @return String YYMM
	*/
	public String getYymm() {
	  return (String) get(TBTHB1DOWN.YYMM);
	}

	/**
	* FIELD1��ݒ肵�܂��B
	* @param val String FIELD1
	*/
	public void setField1(String val) {
	  set(TBTHB1DOWN.FIELD1, val);
	}
	/**
	* FIELD1��Ԃ��܂��B
	* @return String FIELD1
	*/
	public String getField1() {
	  return (String) get(TBTHB1DOWN.FIELD1);
	}

	/**
	* FIELD2��ݒ肵�܂��B
	* @param val String FIELD2
	*/
	public void setField2(String val) {
	  set(TBTHB1DOWN.FIELD2, val);
	}

	/**
	* FIELD2��Ԃ��܂��B
	* @return String FIELD2
	*/
	public String getField2() {
	  return (String) get(TBTHB1DOWN.FIELD2);
	}

	/**
	* FIELD3��ݒ肵�܂��B
	* @param val String FIELD3
	*/
	public void setField3(String val) {
	  set(TBTHB1DOWN.FIELD3, val);
	}

	/**
	* FIELD3��Ԃ��܂��B
	* @return String FIELD3
	*/
	public String getField3() {
	  return (String) get(TBTHB1DOWN.FIELD3);
	}

	/**
	 * FIELD4���擾����
	 * @return FIELD4
	 */
	public String getField4() {
	    return (String) get(TBTHB1DOWN.FIELD4);
	}

	/**
	 * FIELD4��ݒ肷��
	 * @param val FIELD4
	 */
	public void setField4(String val) {
	    set(TBTHB1DOWN.FIELD4, val);
	}

	/**
	 * FIELD5���擾����
	 * @return FIELD5
	 */
	public String getField5() {
	    return (String) get(TBTHB1DOWN.FIELD5);
	}

	/**
	 * FIELD5��ݒ肷��
	 * @param val FIELD5
	 */
	public void setField5(String val) {
	    set(TBTHB1DOWN.FIELD5, val);
	}

	/**
	 * FIELD6���擾����
	 * @return FIELD6
	 */
	public String getField6() {
	    return (String) get(TBTHB1DOWN.FIELD6);
	}
	/**
	 * FIELD6��ݒ肷��
	 * @param val FIELD6
	 */
	public void setField6(String val) {
	    set(TBTHB1DOWN.FIELD6, val);
	}

	/**
	 * FIELD7���擾����
	 * @return FIELD7
	 */
	public String getField7() {
	    return (String) get(TBTHB1DOWN.FIELD7);
	}
	/**
	 * FIELD7��ݒ肷��
	 * @param val FIELD7
	 */
	public void setField7(String val) {
	    set(TBTHB1DOWN.FIELD7, val);
	}

	/**
	* FIELD8��ݒ肵�܂��B
	* @param val String FIELD8
	*/
	public void setField8(String val) {
	  set(TBTHB1DOWN.FIELD8, val);
	}

	/**
	* FIELD8��Ԃ��܂��B
	* @return String FIELD8
	*/
	public String getField8() {
	  return (String) get(TBTHB1DOWN.FIELD8);
	}

	/**
	* FIELD9��ݒ肵�܂��B
	* @param val String FIELD9
	*/
	public void setField9(String val) {
	  set(TBTHB1DOWN.FIELD9, val);
	}

	/**
	* FIELD9��Ԃ��܂��B
	* @return String FIELD9
	*/
	public String getField9() {
	  return (String) get(TBTHB1DOWN.FIELD9);
	}

	/**
	* FIELD11��ݒ肵�܂��B
	* @param val String FIELD11
	*/
	public void setField11(String val) {
	  set(TBTHB1DOWN.FIELD11, val);
	}

	/**
	* FIELD11��Ԃ��܂��B
	* @return String FIELD11
	*/
	public String getField11() {
	  return (String) get(TBTHB1DOWN.FIELD11);
	}
	/**
	* SONOTA1��ݒ肵�܂��B
	* @param val String SONOTA1
	*/
	public void setSonota1(String val) {
	  set(TBTHB2KMEI.SONOTA1, val);
	}
	/**
	* SONOTA1��Ԃ��܂��B
	* @return String SONOTA1
	*/
	public String getSonota1() {
	  return (String) get(TBTHB2KMEI.SONOTA1);
	}

	/**
	* SONOTA5��ݒ肵�܂��B
	* @param val String SONOTA5
	*/
	public void setSonota5(String val) {
	  set(TBTHB2KMEI.SONOTA5, val);
	}
	/**
	* SONOTA5��Ԃ��܂��B
	* @return String SONOTA5
	*/
	public String getSonota5() {
	  return (String) get(TBTHB2KMEI.SONOTA5);
	}


	/**
	 * SONOTA7��ݒ肷��
	 * @param val SONOTA7
	 */
	public void setSonota7(String val) {
	    set(TBTHB2KMEI.SONOTA7, val);
	}
	/**
	 * SONOTA7��Ԃ�
	 * @return String SONOTA7
	 */
	public String getSonota7() {
	    return (String) get(TBTHB2KMEI.SONOTA7);
	}

	/**
	* SONOTA9��ݒ肵�܂��B
	* @param val String SONOTA9
	*/
	public void setSonota9(String val) {
	  set(TBTHB2KMEI.SONOTA9, val);
	}

	/**
	* SONOTA9��Ԃ��܂��B
	* @return String SONOTA9
	*/
	public String getSonota9() {
	  return (String) get(TBTHB2KMEI.SONOTA9);
	}

	/**
	 * �^�C���X�|�b�g�敪��ݒ肷��
	 * @param val TMSPKBN
	 */
	public void setTmspkbn(String val) {
	    set(TBTHB1DOWN.TMSPKBN, val);
	}
	/**
	 * �^�C���X�|�b�g�敪���擾����
	 * @return TMSPKBN
	 */
	public String getTmspkbn() {
	    return (String) get(TBTHB1DOWN.TMSPKBN);
	}

	/**
	 * GYOMKBN��ݒ肷��
	 * @param val GYOMKBN
	 */
	public void setGyomkbn(String val) {
	    set(TBTHB1DOWN.GYOMKBN, val);
	}

	/**
	 * GYOMKBN���擾����
	 * @return GYOMKBN
	 */
	public String getGyomkbn() {
	    return (String) get(TBTHB1DOWN.GYOMKBN);
	}

	/**
	 * �Ɩ��敪���̂�ݒ肷��
	 * @param val GYOMKBNMEI
	 */
	public void setGyomKbnMei(String val) {
	    set(TBRCMN_MEU29CC.MEU29_NAIYJ, val);
	}
	/**
	 * �Ɩ��敪���̂��擾����
	 * @return GYOMKBNMEI
	 */
	public String getGyomKbnMei() {
	    return (String) get(TBRCMN_MEU29CC.MEU29_NAIYJ);
	}

	/**
	* KKNAMEKJ��ݒ肵�܂��B
	* @param val String KKNAMEKJ
	*/
	public void setKkNameKj(String val) {
	  set(TBTHB1DOWN.KKNAMEKJ, val);
	}

	/**
	* KKNAMEKJ��Ԃ��܂��B
	* @return String KKNAMEKJ
	*/
	public String getKkNameKj() {
	  return (String) get(TBTHB1DOWN.KKNAMEKJ);
	}

	/**
	 * HIMKNMKJ��ݒ肷��
	 * @param val HIMKNMKJ
	 */
	public void setHimknmkj(String val) {
	    set(TBTHB1DOWN.HIMKNMKJ, val);
	}

	/**
	 * HIMKNMKJ���擾����
	 * @return HIMKNMKJ
	 */
	public String getHimknmkj() {
	    return (String) get(TBTHB1DOWN.HIMKNMKJ);
	}

	/**
	* �������z��ݒ肵�܂��B
	* @param val String �������z
	*/
	public void setSeiGak(BigDecimal val) {
	  set(TBTHB2KMEI.SEIGAK, val);
	}
	/**
	* �������z��Ԃ��܂��B
	* @return String �������z
	*/
	public BigDecimal getSeiGak() {
	  return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
	}

	/**
	 * �l���z��ݒ肷��
	 * @param val NEBIGAK
	 */
	public void setNebigak(BigDecimal val) {
	    set(TBTHB2KMEI.NEBIGAK, val);
	}
	/**
	 * �l���z���擾����
	 * @return NEBIGAK
	 */
	public BigDecimal getNebigak() {
	    return (BigDecimal) get(TBTHB2KMEI.NEBIGAK);
	}

	/**
     * ����ŗ���ݒ肷��
     * @param val SHOHIZEI_RITU
     */
    public void setShohizeiRitu(BigDecimal val) {
        set(SHOHIZEI_RITU, val);
    }
    /**
     * ����ŗ����擾����
     * @return SHOHIZEI_RITU
     */
    public BigDecimal getShohizeiRitu() {
        return (BigDecimal) get(SHOHIZEI_RITU);
    }

    /**
	 * ����Ŋz��ݒ肷��
	 * @param val SHOHIZEI_GAK
	 */
	public void setShohizeiGak(BigDecimal val) {
	    set(SHOHIZEI_GAK, val);
	}
	/**
	 * ����Ŋz���擾����
	 * @return SHOHIZEI_GAK
	 */
	public BigDecimal getShohizeiGak() {
	    return (BigDecimal) get(SHOHIZEI_GAK);
	}

	/**
	 * �ꏊ��ݒ肷��
	 * @param val BASHO
	 */
	public void setBasho(String val) {
	    set(BASHO, val);
	}

	/**
	 * �ꏊ���擾����
	 * @return BASHO
	 */
	public String getBasho() {
	    return (String) get(BASHO);
	}

	/**
	 * �T�C�Y��ݒ肷��
	 * @param val SIZE_
	 */
	public void setSaizu(String val) {
	    set(SAIZU, val);
	}

	/**
	 * �T�C�Y���擾����
	 * @return SAIZU
	 */
	public String getSaizu() {
	    return (String) get(SAIZU);
	}

	/**
	 * �L�G��ݒ肷��
	 * @param val KIZATSU
	 */
	public void setKizatsu(String val) {
	    set(KIZATSU, val);
	}

	/**
	 * �L�G���擾����
	 * @return KIZATSU
	 */
	public String getKizatsu() {
	    return (String) get(KIZATSU);
	}

	/**
	 * ���[��ݒ肷��
	 * @param val CHOYU
	 */
	public void setChoyu(String val) {
	    set(CHOYU, val);
	}
	/**
	 * ���[���擾����
	 * @return CHOYU
	 */
	public String getChoyu() {
	    return (String) get(CHOYU);
	}

	/**
	 * ���f�B�A��ݒ肷��
	 * @param val MEDIA
	 */
	public void setMedia(String val) {
	    set(MEDIA, val);
	}
	/**
	 * ���f�B�A���擾����
	 * @return MEDIA
	 */
	public String getMedia() {
	    return (String) get(MEDIA);
	}

	/**
	 * ���f�B�A(��)��ݒ肷��
	 * @param val MEDIARYA
	 */
	public void setMediaRya(String val) {
	    set(MEDIARYA, val);
	}
	/**
	 * ���f�B�A(��)���擾����
	 * @return MEDIARYA
	 */
	public String getMediaRya() {
	    return (String) get(MEDIARYA);
	}

	/**
	 * �F����ݒ肷��
	 * @param val IROZURI
	 */
	public void setIrozuri(String val) {
	    set(IROZURI, val);
	}
	/**
	 * �F�����擾����
	 * @return IROZURI
	 */
	public String getIrozuri() {
	    return (String) get(IROZURI);
	}

	/**
	 * CM�b�����v��ݒ肷��
	 * @param val BYOSU_GOKEI
	 */
	public void setByosuGokei(BigDecimal val) {
	    set(BYOSU_GOKEI, val);
	}
	/**
	 * CM�b�����v���擾����
	 * @return BYOSU_GOKEI
	 */
	public BigDecimal getByosuGokei() {
	    return (BigDecimal) get(BYOSU_GOKEI);
	}

	/**
	 * �u�����h�R�[�h��ݒ肷��
	 * @param val BRAND_CD
	 */
	public void setBrandCd(String val) {
	    set(BRAND_CD, val);
	}
	/**
	 * �u�����h�R�[�h���擾����
	 * @return BRAND_CD
	 */
	public String getBrandCd() {
	    return (String) get(BRAND_CD);
	}

	/**
	 * �u�����h����ݒ肷��
	 * @param val BRAND_MEI
	 */
	public void setBrandMei(String val) {
	    set(BRAND_MEI, val);
	}
	/**
	 * �u�����h�����擾����
	 * @return BRAND_MEI
	 */
	public String getBrandMei() {
	    return (String) get(BRAND_MEI);
	}

	/**
	 * �ǃR�[�h��ݒ肷��
	 * @param val KYOKU_CD
	 */
	public void setKyokuCd(String val) {
	    set(KYOKU_CD, val);
	}
	/**
	 * �ǃR�[�h���擾����
	 * @return KYOKU_CD
	 */
	public String getKyokuCd() {
	    return (String) get(KYOKU_CD);
	}

	/**
	 * �ǖ���ݒ肷��
	 * @param val KYOKU_MEI
	 */
	public void setKyokuMei(String val) {
	    set(KYOKU_MEI, val);
	}
	/**
	 * �ǖ����擾����
	 * @return KYOKU_MEI
	 */
	public String getKyokuMei() {
	    return (String) get(KYOKU_MEI);
	}

	/**
	 * �ԑg�R�[�h��ݒ肷��
	 * @param val BANGUMI_CD
	 */
	public void setBangumiCd(String val) {
	    set(BANGUMI_CD, val);
	}
	/**
	 * �ԑg�R�[�h���擾����
	 * @return BANGUMI_CD
	 */
	public String getBangumiCd() {
	    return (String) get(BANGUMI_CD);
	}

	/**
	 * �ԑg����ݒ肷��
	 * @param val BANGUMI_MEI
	 */
	public void setBangumiMei(String val) {
	    set(BANGUMI_MEI, val);
	}
	/**
	 * �ԑg�����擾����
	 * @return BANGUMI_MEI
	 */
	public String getBangumiMei() {
	    return (String) get(BANGUMI_MEI);
	}

	/**
	 * �e���r�ԑg�R�[�h��ݒ肷��
	 * @param val TV_BANGUMI_CD
	 */
	public void setTvBangumiCd(String val) {
	    set(TV_BANGUMI_CD, val);
	}
	/**
	 * �e���r�ԑg�R�[�h���擾����
	 * @return TV_BANGUMI_CD
	 */
	public String getTvBangumiCd() {
	    return (String) get(TV_BANGUMI_CD);
	}

	/**
	 * �e���r�ԑg����ݒ肷��
	 * @param val TV_BANGUMI_MEI
	 */
	public void setTvBangumiMei(String val) {
	    set(TV_BANGUMI_MEI, val);
	}
	/**
	 * �e���r�ԑg�����擾����
	 * @return TV_BANGUMI_MEI
	 */
	public String getTvBangumiMei() {
	    return (String) get(TV_BANGUMI_MEI);
	}

	/**
	 * �e���r�ǃR�[�h��ݒ肷��
	 * @param val TV_BANGUMI_CD
	 */
	public void setTvKyokuCd(String val) {
	    set(TV_KYOKU_CD, val);
	}
	/**
	 * �e���r�ǃR�[�h���擾����
	 * @return TV_KYOKU_CD
	 */
	public String getTvKyokuCd() {
	    return (String) get(TV_KYOKU_CD);
	}

	/**
	 * �e���r�ǖ���ݒ肷��
	 * @param val TV_KYOKU_MEI
	 */
	public void setTvKyokuMei(String val) {
	    set(TV_KYOKU_MEI, val);
	}
	/**
	 * �e���r�ǖ����擾����
	 * @return TV_KYOKU_MEI
	 */
	public String getTvKyokuMei() {
	    return (String) get(TV_KYOKU_MEI);
	}

	/**
	 * ���W�I�ǃR�[�h��ݒ肷��
	 * @param val RD_BANGUMI_CD
	 */
	public void setRdKyokuCd(String val) {
	    set(RD_KYOKU_CD, val);
	}
	/**
	 * ���W�I�ǃR�[�h���擾����
	 * @return RD_KYOKU_CD
	 */
	public String getRdKyokuCd() {
	    return (String) get(RD_KYOKU_CD);
	}

	/**
	 * ���W�I�ǖ���ݒ肷��
	 * @param val RD_KYOKU_MEI
	 */
	public void setRdKyokuMei(String val) {
	    set(RD_KYOKU_MEI, val);
	}
	/**
	 * ���W�I�ǖ����擾����
	 * @return RD_KYOKU_MEI
	 */
	public String getRdKyokuMei() {
	    return (String) get(RD_KYOKU_MEI);
	}

	/**
	 * ���W�I�ԑg�R�[�h��ݒ肷��
	 * @param val RD_BANGUMI_CD
	 */
	public void setRdBangumiCd(String val) {
	    set(RD_BANGUMI_CD, val);
	}
	/**
	 * ���W�I�ԑg�R�[�h���擾����
	 * @return RD_BANGUMI_CD
	 */
	public String getRdBangumiCd() {
	    return (String) get(RD_BANGUMI_CD);
	}

	/**
	 * ���W�I�ԑg����ݒ肷��
	 * @param val RD_BANGUMI_MEI
	 */
	public void setRdBangumiMei(String val) {
	    set(RD_BANGUMI_MEI, val);
	}
	/**
	 * ���W�I�ԑg�����擾����
	 * @return RD_BANGUMI_MEI
	 */
	public String getRdBangumiMei() {
	    return (String) get(RD_BANGUMI_MEI);
	}
	/**
	 * �V���R�[�h��ݒ肷��
	 * @param val ShinBunCd
	 */
	public void setShinCd(String val) {
	    set(SHINBUN_CD, val);
	}
	/**
	 * �V���R�[�h���擾����
	 * @return ShinBunCd
	 */
	public String getShinCd() {
	    return (String) get(SHINBUN_CD);
	}

	/**
	 * �V������ݒ肷��
	 * @param val SHINBUN_MEI
	 */
	public void setShinMei(String val) {
	    set(SHINBUN_MEI, val);
	}
	/**
	 * �V�������擾����
	 * @return SHINBUN_MEI
	 */
	public String getShinMei() {
	    return (String) get(SHINBUN_MEI);
	}

	/**
	 * �G���R�[�h��ݒ肷��
	 * @param val ZASHI_CD
	 */
	public void setZashiCd(String val) {
	    set(ZASHI_CD, val);
	}
	/**
	 * �G���R�[�h���擾����
	 * @return ZASHI_CD
	 */
	public String getZashiCd() {
	    return (String) get(ZASHI_CD);
	}

	/**
	 * �G������ݒ肷��
	 * @param val ZASHI_NAME
	 */
	public void setZashiName(String val) {
	    set(ZASHI_NAME, val);
	}
	/**
	 * �G�������擾����
	 * @return ZASHI_NAME
	 */
	public String getZashiName() {
	    return (String) get(ZASHI_NAME);
	}

//	public static String getSpace() {
//		return SPACE;
//	}
	/**
	 * �X�y�[�X��ݒ肷��
	 * @param val SPACE
	 */
	public void setSpace(String val) {
	    set(SPACE, val);
	}
	/**
	 * �X�y�[�X���擾����
	 * @return SPACE
	 */
	public String getSpace() {
	    return (String) get(SPACE);
	}

	/**
	 * ������ݒ肷��
	 * @param val KEN_NAME
	 */
	public void setKenName(String val) {
	    set(KEN_NAME, val);
	}
	/**
	 * �������擾����
	 * @return KEN_NAME
	 */
	public String getKenName() {
	    return (String) get(KEN_NAME);
	}

	/**
	 * ���R�[�h��ݒ肷��
	 * @param val KEN_CD
	 */
	public void setKenCd(String val) {
	    set(KEN_CD, val);
	}
	/**
	 * ���R�[�h���擾����
	 * @return KEN_CD
	 */
	public String getKenCd() {
	    return (String) get(KEN_CD);
	}

	/**
	 * �H������ݒ肷��
	 * @param val ROSEN_NAME
	 */
	public void setRosenName(String val) {
	    set(ROSEN_NAME, val);
	}
	/**
	 * �H�������擾����
	 * @return ROSEN_NAME
	 */
	public String getRosenName() {
	    return (String) get(ROSEN_NAME);
	}

	/**
	 * ���Ԃ�ݒ肷��
	 * @param val KIKAN
	 */
	public void setKikan(String val) {
	    set(KIKAN, val);
	}
	/**
	 * ���Ԃ��擾����
	 * @return KIKAN
	 */
	public String getKikan() {
	    return (String) get(KIKAN);
	}

	/**
	 * ������ݒ肷��
	 * @param val KEN_MEI
	 */
	public void setKenMei(String val) {
	    set(KEN_MEI, val);
	}
	/**
	 * �������擾����
	 * @return KEN_MEI
	 */
	public String getKenMei() {
	    return (String) get(KEN_MEI);
	}

	/**
	 * �ǎ��R�[�h��ݒ肷��
	 * @param val KYOKUSHI_CD
	 */
	public void setKyokushiCd(String val) {
	    set(KYOKUSHI_CD, val);
	}
	/**
	 * �ǎ��R�[�h���擾����
	 * @return KYOKUSHI_CD
	 */
	public String getKyokushiCd() {
	    return (String) get(KYOKUSHI_CD);
	}

	/**
	 * �ǎ�����ݒ肷��
	 * @param val KYOKUSHI_NAME
	 */
	public void setKyokushiName(String val) {
	    set(KYOKUSHI_NAME, val);
	}
	/**
	 * �ǎ������擾����
	 * @return KYOKUSHI_NAME
	 */
	public String getKyokushiName() {
	    return (String) get(KYOKUSHI_NAME);
	}

	/**
	 * �W�������R�[�h��ݒ肷��
	 * @param val JANLE_CD
	 */
	public void setJanleCd(String val) {
	    set(JANLE_CD, val);
	}
	/**
	 * �W�������R�[�h���擾����
	 * @return JANLE_CD
	 */
	public String getJanleCd() {
	    return (String) get(JANLE_CD);
	}

	/**
	 * �W����������ݒ肷��
	 * @param val JANLE_NAME
	 */
	public void setJanleName(String val) {
	    set(JANLE_NAME, val);
	}
	/**
	 * �W�����������擾����
	 * @return JANLE_NAME
	 */
	public String getJanleName() {
	    return (String) get(JANLE_NAME);
	}

	/**
	 *�v���O�����R�[�h��ݒ肷��
	 * @param val PROGRAM_CD
	 */
	public void setProgramCd(String val) {
	    set(PROGRAM_CD, val);
	}
	/**
	 *�v���O�����R�[�h���擾����
	 * @return PROGRAM_CD
	 */
	public String getProgramCd() {
	    return (String) get(PROGRAM_CD);
	}

	/**
	 * �\����ݒ肷��
	 * @param val HYOJI
	 */
	public void setHyoji(BigDecimal val) {
	    set(HYOJI, val);
	}
	/**
	 * �\�����擾����
	 * @return HYOJI
	 */
	public BigDecimal getHyoji() {
	    return (BigDecimal) get(HYOJI);
	}

	/**
	 *�{����ݒ肷��
	 * @param val HONSU
	 */
	public void setHonsu(String val) {
	    set(HONSU, val);
	}
	/**
	 *�{�����擾����
	 * @return HONSU
	 */
	public String getHonsu() {
	    return (String) get(HONSU);
	}

	/**
	 *�v���O��������ݒ肷��
	 * @param val PROGRAM_NAME
	 */
	public void setProgramName(String val) {
	    set(PROGRAM_NAME, val);
	}
	/**
	 *�v���O���������擾����
	 * @return PROGRAM_NAME
	 */
	public String getProgramName() {
	    return (String) get(PROGRAM_NAME);
	}

	/**
	 *�}�̃R�[�h��ݒ肷��
	 * @param val BAITAI_CD
	 */
	public void setBaitaiCd(String val) {
	    set(BAITAI_CD, val);
	}
	/**
	 *�}�̃R�[�h���擾����
	 * @return BAITAI_CD
	 */
	public String getBaitaiCd() {
	    return (String) get(BAITAI_CD);
	}

	/**
	 *�}�̖���ݒ肷��
	 * @param val BAITAI_NAME
	 */
	public void setBaitaiName(String val) {
	    set(BAITAI_NAME, val);
	}
	/**
	 *�}�̖����擾����
	 * @return BAITAI_NAME
	 */
	public String getBaitaiName() {
	    return (String) get(BAITAI_NAME);
	}
}
