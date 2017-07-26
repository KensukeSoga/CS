package jp.co.isid.kkh.customer.acom.model.report;

import java.math.BigDecimal;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.integ.tbl.TBRCMN_MEU29CC;
import jp.co.isid.nj.model.AbstractModel;

public class ReportAcomVO extends AbstractModel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    /** �A�R�����|�[�g�e�[�u�� */
    //public static String TBNAME = "ACOMREP";



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

	/**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportAcomVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportAcomVO();
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
//	/**
//	* CODE1��ݒ肵�܂��B
//	* @param val String CODE1
//	*/
//	public void setCode1(String val) {
//	  set(TBTHB2KMEI.CODE1, val);
//	}
//
//	/**
//	* CODE1��Ԃ��܂��B
//	* @return String CODE1
//	*/
//	public String getCode1() {
//	  return (String) get(TBTHB2KMEI.CODE1);
//	}

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

//	/**
//	* NAME1��ݒ肵�܂��B
//	* @param val String NAME1
//	*/
//	public void setName1(String val) {
//	  set(TBTHB2KMEI.NAME1, val);
//	}
//
//	/**
//	* NAME1��Ԃ��܂��B
//	* @return String NAME1
//	*/
//	public String getName1() {
//	  return (String) get(TBTHB2KMEI.NAME1);
//	}
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
//	/**
//	* ���z2��ݒ肵�܂��B
//	* @param val BigDecimal ���z2
//	*/
//	public void setKngk2(BigDecimal val) {
//	  set(TBTHB2KMEI.KNGK2, val);
//	}
//
//	/**
//	* ���z2��Ԃ��܂��B
//	* @return BigDecimal ���z2
//	*/
//	public BigDecimal getKngk2() {
//	  return (BigDecimal) get(TBTHB2KMEI.KNGK2);
//	}


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
	 * NEBIGAK��ݒ肷��
	 * @param val NEBIGAK
	 */
	public void setNebigak(BigDecimal val) {
	    set(TBTHB2KMEI.NEBIGAK, val);
	}

	/**
	 * NEBIGAK���擾����
	 * @return NEBIGAK
	 */
	public BigDecimal getNebigak() {
	    return (BigDecimal) get(TBTHB2KMEI.NEBIGAK);
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
}
