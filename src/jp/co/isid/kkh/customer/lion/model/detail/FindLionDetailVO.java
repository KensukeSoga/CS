package jp.co.isid.kkh.customer.lion.model.detail;

import java.math.BigDecimal;
import java.util.Date;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * TV�ԑgVO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/20 JSE A.Naito)<BR>
 * </P>
 * @author
 */
public class FindLionDetailVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public FindLionDetailVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new FindLionDetailVO();
    }

    /** VAL1 */
    public static final String VAL1 = "VAL1";

    /** VAL2 */
    public static final String VAL2 = "VAL2";

    /** VAL3 */
    public static final String VAL3 = "VAL3";

    /**
    * ��NO��ݒ肵�܂��B
    * @param val String ��NO
    */
    public void setJyutno(String val) {
      set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
    * ��NO��Ԃ��܂��B
    * @return String ��NO
    */
    public String getJyutno() {
      return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
    * �󒍖���NO��ݒ肵�܂��B
    * @param val String �󒍖���NO
    */
    public void setJymeino(String val) {
      set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
    * �󒍖���NO��Ԃ��܂��B
    * @return String �󒍖���NO
    */
    public String getJymeino() {
      return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
    * ���㖾��NO��ݒ肵�܂��B
    * @param val String ���㖾��NO
    */
    public void setUrmeino(String val) {
      set(TBTHB2KMEI.URMEINO, val);
    }

    /**
    * ���㖾��NO��Ԃ��܂��B
    * @return String ���㖾��NO
    */
    public String getUrmeino() {
      return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
    * �N����ݒ肵�܂��B
    * @param val String ���㖾��NO
    */
    public void setYymm(String val) {
      set(TBTHB2KMEI.YYMM, val);
    }

    /**
    * �N����Ԃ��܂��B
    * @return String �N��
    */
    public String getYymm() {
      return (String) get(TBTHB2KMEI.YYMM);
    }

    /**
    * HIMKCD��ݒ肵�܂��B
    * @param val String HIMKCD
    */
    public void setHimkcd(String val) {
      set(TBTHB2KMEI.HIMKCD, val);
    }

    /**
    * HIMKCD��Ԃ��܂��B
    * @return String HIMKCD
    */
    public String getHimkcd() {
      return (String) get(TBTHB2KMEI.HIMKCD);
    }

    /**
    * HNNERT��ݒ肵�܂��B
    * @param val BigDecimal HNNERT
    */
    public void setHnnert(BigDecimal val) {
      set(TBTHB2KMEI.HNNERT, val);
    }
    /**
    * HNNERT��Ԃ��܂��B
    * @return BigDecimal HNNERT
    */
    public BigDecimal getHnnert() {
      return (BigDecimal) get(TBTHB2KMEI.HNNERT);
    }

    /**
    * NEBIGAK��ݒ肵�܂��B
    * @param val BigDecimal NEBIGAK
    */
    public void setNebigak(BigDecimal val) {
      set(TBTHB2KMEI.NEBIGAK, val);
    }
    /**
    * NEBIGAK��Ԃ��܂��B
    * @return BigDecimal NEBIGAK
    */
    public BigDecimal getNebigak() {
      return (BigDecimal) get(TBTHB2KMEI.NEBIGAK);
    }

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
    * @return String CODE3
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

    /**
    * NAME2��ݒ肵�܂��B
    * @param val String NAME2
    */
    public void setName2(String val) {
      set(TBTHB2KMEI.NAME2, val);
    }

    /**
    * NAME2��Ԃ��܂��B
    * @return String NAME2
    */
    public String getName2() {
      return (String) get(TBTHB2KMEI.NAME2);
    }

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
    * NAME10��ݒ肵�܂��B
    * @param val String NAME10
    */
    public void setName10(String val) {
      set(TBTHB2KMEI.NAME10, val);
    }

    /**
    * NAME10��Ԃ��܂��B
    * @return String NAME10
    */
    public String getName10() {
      return (String) get(TBTHB2KMEI.NAME10);
    }

    /**
    * KNGK1��ݒ肵�܂��B
    * @param val BigDecimal KNGK1
    */
    public void setKngk1(BigDecimal val) {
      set(TBTHB2KMEI.KNGK1, val);
    }

    /**
    * KNGK1��Ԃ��܂��B
    * @return BigDecimal KNGK1
    */
    public BigDecimal getKngk1() {
      return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

    /**
    * KNGK2��ݒ肵�܂��B
    * @param val BigDecimal KNGK2
    */
    public void setKngk2(BigDecimal val) {
      set(TBTHB2KMEI.KNGK2, val);
    }

    /**
    * KNGK2��Ԃ��܂��B
    * @return BigDecimal KNGK2
    */
    public BigDecimal getKngk2() {
      return (BigDecimal) get(TBTHB2KMEI.KNGK2);
    }

    /**
    * KNGK3��ݒ肵�܂��B
    * @param val BigDecimal KNGK3
    */
    public void setKngk3(BigDecimal val) {
      set(TBTHB2KMEI.KNGK3, val);
    }

    /**
    * KNGK3��Ԃ��܂��B
    * @return BigDecimal KNGK3
    */
    public BigDecimal getKngk3() {
      return (BigDecimal) get(TBTHB2KMEI.KNGK3);
    }

    /**
    * RITU1��ݒ肵�܂��B
    * @param val BigDecimal RITU1
    */
    public void setRitu1(BigDecimal val) {
      set(TBTHB2KMEI.RITU1, val);
    }
    /**
    * RITU1��Ԃ��܂��B
    * @return BigDecimal RITU1
    */
    public BigDecimal getRitu1() {
      return (BigDecimal) get(TBTHB2KMEI.RITU1);
    }

    /**
    * SEIGAK��ݒ肵�܂��B
    * @param val BigDecimal SEIGAK
    */
    public void setSeigak(BigDecimal val) {
      set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
    * SEIGAK��Ԃ��܂��B
    * @return BigDecimal SEIGAK
    */
    public BigDecimal getSeigak() {
      return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
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
    * SONOTA2��ݒ肵�܂��B
    * @param val String SONOTA2
    */
    public void setSonota2(String val) {
      set(TBTHB2KMEI.SONOTA2, val);
    }

    /**
    * SONOTA2��Ԃ��܂��B
    * @return String SONOTA2
    */
    public String getSonota2() {
      return (String) get(TBTHB2KMEI.SONOTA2);
    }

    /**
    * SONOTA3��ݒ肵�܂��B
    * @param val String SONOTA3
    */
    public void setSonota3(String val) {
      set(TBTHB2KMEI.SONOTA3, val);
    }

    /**
    * SONOTA3��Ԃ��܂��B
    * @return String SONOTA3
    */
    public String getSonota3() {
      return (String) get(TBTHB2KMEI.SONOTA3);
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
    * SONOTA6��ݒ肵�܂��B
    * @param val String SONOTA6
    */
    public void setSonota6(String val) {
      set(TBTHB2KMEI.SONOTA6, val);
    }

    /**
    * SONOTA6��Ԃ��܂��B
    * @return String SONOTA6
    */
    public String getSonota6() {
      return (String) get(TBTHB2KMEI.SONOTA6);
    }

    /**
    * SONOTA7��ݒ肵�܂��B
    * @param val String SONOTA7
    */
    public void setSonota7(String val) {
      set(TBTHB2KMEI.SONOTA7, val);
    }

    /**
    * SONOTA7��Ԃ��܂��B
    * @return String SONOTA7
    */
    public String getSonota7() {
      return (String) get(TBTHB2KMEI.SONOTA7);
    }

    /**
    * SONOTA8��ݒ肵�܂��B
    * @param val String SONOTA8
    */
    public void setSonota8(String val) {
      set(TBTHB2KMEI.SONOTA8, val);
    }

    /**
    * SONOTA8��Ԃ��܂��B
    * @return String SONOTA8
    */
    public String getSonota8() {
      return (String) get(TBTHB2KMEI.SONOTA8);
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

    //���I�}�X�^////////////////////////////////
    /**
     * VAL1��ݒ肷��
     * @param val VAL1
     */
    public void setVal1(String val) {
        set(VAL1, val);
    }

    /**
     * VAL1���擾����
     * @return VAL1
     */
    public String getVal1() {
        return (String) get(VAL1);
    }

    /**
     * VAL2��ݒ肷��
     * @param val VAL2
     */
    public void setVal2(String val) {
        set(VAL2, val);
    }

    /**
     * VAL2���擾����
     * @return VAL2
     */
    public String getVal2() {
        return (String) get(VAL2);
    }

    /**
     * VAL3��ݒ肷��
     * @param val VAL3
     */
    public void setVal3(String val) {
        set(VAL3, val);
    }

    /**
     * VAL3���擾����
     * @return VAL3
     */
    public String getVal3() {
        return (String) get(VAL3);
    }

    //���I�}�X�^////////////////////////////////

     /**
     * �^�C���X�^���v��ݒ肵�܂��B
     * @param val String �^�C���X�^���v
     */
     public void setTimstmp(Date val) {
         set(TBTHB2KMEI.TIMSTMP, val);
     }

     /**
     * �^�C���X�^���v��Ԃ��܂��B
     * @return String �^�C���X�^���v
     */
     public Date getTimstmp() {
         return (Date) get(TBTHB2KMEI.TIMSTMP);
     }

}