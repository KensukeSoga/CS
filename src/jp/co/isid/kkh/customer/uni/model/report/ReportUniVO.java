package jp.co.isid.kkh.customer.uni.model.report;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;

import jp.co.isid.kkh.integ.tbl.TBTHB1DOWN;
import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.nj.model.AbstractModel;


/**
 * <P>
 * ���[�i���j�`���[��_�L����ו\�j�f�[�^VO
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/1/23 JSE Y.Sato)<BR>
 * </P>
 *
 * @author JSE Y.Sato
 */
public class ReportUniVO extends AbstractModel {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     * �V�K�C���X�^���X���\�z���܂��B
     */
    public ReportUniVO() {
    }

    /**
     * �V�K�C���X�^���X���\�z���܂��B
     *
     * @return �V�K�C���X�^���X
     */
    public Object newInstance() {
        return new ReportUniVO();
    }

    /**
     * ��No��ݒ肵�܂��B
     * @param val String ��No
     */
    public void setHb1JyutNo(String val) {
        set(TBTHB1DOWN.JYUTNO, val);
    }

    /**
     * ��No��Ԃ��܂��B
     * @return String ��No
     */
    public String getHb1JyutNo() {
        return (String) get(TBTHB1DOWN.JYUTNO);
    }

     /**
     * �󒍖���No��ݒ肵�܂��B
     * @param val String �󒍖���No
     */
    public void setHb1JyMeiNo(String val) {
        set(TBTHB1DOWN.JYMEINO, val);
    }

    /**
     * �󒍖���No��Ԃ��܂��B
     * @return String �󒍖���No
     */
    public String getHb1JyMeiNo() {
        return (String) get(TBTHB1DOWN.JYMEINO);
    }

     /**
     * ���㖾��No��ݒ肵�܂��B
     * @param val String ���㖾��No
     */
    public void setHb1UrMeiNo(String val) {
        set(TBTHB1DOWN.URMEINO, val);
    }

    /**
     * ���㖾��No��Ԃ��܂��B
     * @return String ���㖾��No
     */
    public String getHb1UrMeiNo() {
        return (String) get(TBTHB1DOWN.URMEINO);
    }

     /**
     * �������[No��ݒ肵�܂��B
     * @param val String �������[No
     */
    public void setHb1GpyNo(String val) {
        set(TBTHB1DOWN.GPYNO, val);
    }

    /**
     * �������[No��Ԃ��܂��B
     * @return String �������[No
     */
    public String getHb1GpyNo() {
        return (String) get(TBTHB1DOWN.GPYNO);
    }

     /**
     * ����No��ݒ肵�܂��B
     * @param val String ����No
     */
    public void setHb1SeiNo(String val) {
        set(TBTHB1DOWN.SEINO, val);
    }

    /**
     * ����No��Ԃ��܂��B
     * @return String ����No
     */
    public String getHb1SeiNo() {
        return (String) get(TBTHB1DOWN.SEINO);
    }

     /**
     * �Ɩ��敪��ݒ肵�܂��B
     * @param val String �Ɩ��敪
     */
    public void setHb1GyomKbn(String val) {
        set(TBTHB1DOWN.GYOMKBN, val);
    }

    /**
     * �Ɩ��敪��Ԃ��܂��B
     * @return String �Ɩ��敪
     */
    public String getHb1GyomKbn() {
        return (String) get(TBTHB1DOWN.GYOMKBN);
    }

     /**
     * �����敪��ݒ肵�܂��B
     * @param val String �����敪
     */
    public void setHb1SeiKbn(String val) {
        set(TBTHB1DOWN.SEIKBN, val);
    }

    /**
     * �����敪��Ԃ��܂��B
     * @return String �����敪
     */
    public String getHb1SeiKbn() {
        return (String) get(TBTHB1DOWN.SEIKBN);
    }

     /**
     * ����(����)��ݒ肵�܂��B
     * @param val String ����(����)
     */
    public void setHb1KKNameKJ(String val) {
        set(TBTHB1DOWN.KKNAMEKJ, val);
    }

    /**
     * ����(����)��Ԃ��܂��B
     * @return String ����(����)
     */
    public String getHb1KKNameKJ() {
        return (String) get(TBTHB1DOWN.KKNAMEKJ);
    }

     /**
     * �����P����ݒ肵�܂��B
     * @param val BigDecimal �����P��
     */
    public void setHb1SeiTnka(BigDecimal val) {
        set(TBTHB1DOWN.SEITNKA, val);
    }

    /**
     * �����P����Ԃ��܂��B
     * @return BigDecimal �����P��
     */
    @XmlElement(required = true)
    public BigDecimal getHb1SeiTnka() {
        return (BigDecimal) get(TBTHB1DOWN.SEITNKA);
    }

     /**
     * �������z��ݒ肵�܂��B
     * @param val BigDecimal �������z
     */
    public void setHb1SeiGak(BigDecimal val) {
        set(TBTHB1DOWN.SEIGAK, val);
    }

    /**
     * �������z��Ԃ��܂��B
     * @return BigDecimal �������z
     */
    @XmlElement(required = true)
    public BigDecimal getHb1SeiGak() {
        return (BigDecimal) get(TBTHB1DOWN.SEIGAK);
    }

     /**
     * ����Ŋz��ݒ肵�܂��B
     * @param val BigDecimal ����Ŋz
     */
    public void setHb1SzeiGak(BigDecimal val) {
        set(TBTHB1DOWN.SZEIGAK, val);
    }

    /**
     * ����Ŋz��Ԃ��܂��B
     * @return BigDecimal ����Ŋz
     */
    @XmlElement(required = true)
    public BigDecimal getHb1SzeiGak() {
        return (BigDecimal) get(TBTHB1DOWN.SZEIGAK);
    }

     /**
     * ��ږ�(����)��ݒ肵�܂��B
     * @param val String ��ږ�(����)
     */
    public void setHb1HimkNmKJ(String val) {
        set(TBTHB1DOWN.HIMKNMKJ, val);
    }

    /**
     * ��ږ�(����)��Ԃ��܂��B
     * @return String ��ږ�(����)
     */
    public String getHb1HimkNmKJ() {
        return (String) get(TBTHB1DOWN.HIMKNMKJ);
    }

     /**
     * �t�B�[���h1��ݒ肵�܂��B
     * @param val String �t�B�[���h1
     */
    public void setHb1Field1(String val) {
        set(TBTHB1DOWN.FIELD1, val);
    }

    /**
     * �t�B�[���h1��Ԃ��܂��B
     * @return String �t�B�[���h1
     */
    public String getHb1Field1() {
        return (String) get(TBTHB1DOWN.FIELD1);
    }

    // 2013/01/09 JSE M.Naito add start
    /**
     * �����t���O��ݒ肵�܂��B
     * @param val String �����t���O
     */
    public void setHb1TouFlg(String val) {
        set(TBTHB1DOWN.TOUFLG, val);
    }

    /**
     * �����t���O��Ԃ��܂��B
     * @return String �����t���O
     */
    public String getHb1TouFlg() {
        return (String) get(TBTHB1DOWN.TOUFLG);
    }

    /**
     * �������No��ݒ肵�܂��B
     * @param val String �������No
     */
    public void setHb1TJyutNo(String val) {
        set(TBTHB1DOWN.TJYUTNO, val);
    }

    /**
     * �������No��Ԃ��܂��B
     * @return String �������No
     */
    public String getHb1TJyutNo() {
        return (String) get(TBTHB1DOWN.TJYUTNO);
    }

    /**
     * ������󒍖���No��ݒ肵�܂��B
     * @param val String ������󒍖���No
     */
    public void setHb1TJymeiNo(String val) {
        set(TBTHB1DOWN.TJYMEINO, val);
    }

    /**
     * ������󒍖���No��Ԃ��܂��B
     * @return String ������󒍖���No
     */
    public String getHb1TJymeiNo() {
        return (String) get(TBTHB1DOWN.TJYMEINO);
    }

    /**
     * �����攄�㖾��No��ݒ肵�܂��B
     * @param val String �����攄�㖾��No
     */
    public void setHb1TUrmeiNo(String val) {
        set(TBTHB1DOWN.TURMEINO, val);
    }

    /**
     * �����攄�㖾��No��Ԃ��܂��B
     * @return String �����攄�㖾��No
     */
    public String getHb1TUrmeiNo() {
        return (String) get(TBTHB1DOWN.TURMEINO);
    }
    // 2013/01/09 JSE M.Naito add end

     /**
     * �t�B�[���h�Q��ݒ肵�܂��B
     * @param val String �t�B�[���h�Q
     */
    public void setHb1Field2(String val) {
        set(TBTHB1DOWN.FIELD2, val);
    }

    /**
     * �t�B�[���h�Q��Ԃ��܂��B
     * @return String �t�B�[���h�Q
     */
    public String getHb1Field2() {
        return (String) get(TBTHB1DOWN.FIELD2);
    }

     /**
     * �t�B�[���h�R��ݒ肵�܂��B
     * @param val String �t�B�[���h�R
     */
    public void setHb1Field3(String val) {
        set(TBTHB1DOWN.FIELD3, val);
    }

    /**
     * �t�B�[���h�R��Ԃ��܂��B
     * @return String �t�B�[���h�R
     */
    public String getHb1Field3() {
        return (String) get(TBTHB1DOWN.FIELD3);
    }

     /**
     * �t�B�[���h�S��ݒ肵�܂��B
     * @param val String �t�B�[���h�S
     */
    public void setHb1Field4(String val) {
        set(TBTHB1DOWN.FIELD4, val);
    }

    /**
     * �t�B�[���h�S��Ԃ��܂��B
     * @return String �t�B�[���h�S
     */
    public String getHb1Field4() {
        return (String) get(TBTHB1DOWN.FIELD4);
    }

     /**
     * �t�B�[���h�T��ݒ肵�܂��B
     * @param val String �t�B�[���h�T
     */
    public void setHb1Field5(String val) {
        set(TBTHB1DOWN.FIELD5, val);
    }

    /**
     * �t�B�[���h�T��Ԃ��܂��B
     * @return String �t�B�[���h�T
     */
    public String getHb1Field5() {
        return (String) get(TBTHB1DOWN.FIELD5);
    }

     /**
     * �t�B�[���h�U��ݒ肵�܂��B
     * @param val String �t�B�[���h�U
     */
    public void setHb1Field6(String val) {
        set(TBTHB1DOWN.FIELD6, val);
    }

    /**
     * �t�B�[���h�U��Ԃ��܂��B
     * @return String �t�B�[���h�U
     */
    public String getHb1Field6() {
        return (String) get(TBTHB1DOWN.FIELD6);
    }

     /**
     * �t�B�[���h�V��ݒ肵�܂��B
     * @param val String �t�B�[���h�V
     */
    public void setHb1Field7(String val) {
        set(TBTHB1DOWN.FIELD7, val);
    }

    /**
     * �t�B�[���h�V��Ԃ��܂��B
     * @return String �t�B�[���h�V
     */
    public String getHb1Field7() {
        return (String) get(TBTHB1DOWN.FIELD7);
    }

     /**
     * �t�B�[���h�W��ݒ肵�܂��B
     * @param val String �t�B�[���h�W
     */
    public void setHb1Field8(String val) {
        set(TBTHB1DOWN.FIELD8, val);
    }

    /**
     * �t�B�[���h�W��Ԃ��܂��B
     * @return String �t�B�[���h�W
     */
    public String getHb1Field8() {
        return (String) get(TBTHB1DOWN.FIELD8);
    }

     /**
     * �t�B�[���h�X��ݒ肵�܂��B
     * @param val String �t�B�[���h�X
     */
    public void setHb1Field9(String val) {
        set(TBTHB1DOWN.FIELD9, val);
    }

    /**
     * �t�B�[���h�X��Ԃ��܂��B
     * @return String �t�B�[���h�X
     */
    public String getHb1Field9() {
        return (String) get(TBTHB1DOWN.FIELD9);
    }

     /**
     * �t�B�[���h�P�O��ݒ肵�܂��B
     * @param val String �t�B�[���h�P�O
     */
    public void setHb1Field10(String val) {
        set(TBTHB1DOWN.FIELD10, val);
    }

    /**
     * �t�B�[���h�P�O��Ԃ��܂��B
     * @return String �t�B�[���h�P�O
     */
    public String getHb1Field10() {
        return (String) get(TBTHB1DOWN.FIELD10);
    }

     /**
     * �t�B�[���h�P�P��ݒ肵�܂��B
     * @param val String �t�B�[���h�P�P
     */
    public void setHb1Field11(String val) {
        set(TBTHB1DOWN.FIELD11, val);
    }

    /**
     * �t�B�[���h�P�P��Ԃ��܂��B
     * @return String �t�B�[���h�P�P
     */
    public String getHb1Field11() {
        return (String) get(TBTHB1DOWN.FIELD11);
    }

     /**
     * �t�B�[���h�P�Q��ݒ肵�܂��B
     * @param val String �t�B�[���h�P�Q
     */
    public void setHb1Field12(String val) {
        set(TBTHB1DOWN.FIELD12, val);
    }

    /**
     * �t�B�[���h�P�Q��Ԃ��܂��B
     * @return String �t�B�[���h�P�Q
     */
    public String getHb1Field12() {
        return (String) get(TBTHB1DOWN.FIELD12);
    }


    /**
     * ��No��ݒ肵�܂��B
     * @param val String ��No
     */
    public void setHb2JyutNo(String val) {
        set(TBTHB2KMEI.JYUTNO, val);
    }

    /**
     * ��No��Ԃ��܂��B
     * @return String ��No
     */
    public String getHb2JyutNo() {
        return (String) get(TBTHB2KMEI.JYUTNO);
    }

    /**
     * �󒍖���No��ݒ肵�܂��B
     * @param val String �󒍖���No
     */
    public void setHb2JyMeiNo(String val) {
        set(TBTHB2KMEI.JYMEINO, val);
    }

    /**
     * �󒍖���No��Ԃ��܂��B
     * @return String �󒍖���No
     */
    public String getHb2JyMeiNo() {
        return (String) get(TBTHB2KMEI.JYMEINO);
    }

    /**
     * ���㖾��No��ݒ肵�܂��B
     * @param val String ���㖾��No
     */
    public void setHb2UrMeiNo(String val) {
        set(TBTHB2KMEI.URMEINO, val);
    }

    /**
     * ���㖾��No��Ԃ��܂��B
     * @return String ���㖾��No
     */
    public String getHb2UrMeiNo() {
        return (String) get(TBTHB2KMEI.URMEINO);
    }

    /**
     * �������z��ݒ肵�܂��B
     * @param val BigDecimal �������z
     */
    public void setHb2SeiGak(BigDecimal val) {
        set(TBTHB2KMEI.SEIGAK, val);
    }

    /**
     * �������z��Ԃ��܂��B
     * @return BigDecimal �������z
     */
    @XmlElement(required = true)
    public BigDecimal getHb2SeiGak() {
        return (BigDecimal) get(TBTHB2KMEI.SEIGAK);
    }

    /**
     * �R�[�h1��ݒ肵�܂��B
     * @param val String �R�[�h1
     */
    public void setHb2Code1(String val) {
        set(TBTHB2KMEI.CODE1, val);
    }

    /**
     * �R�[�h1��Ԃ��܂��B
     * @return String �R�[�h1
     */
    public String getHb2Code1() {
        return (String) get(TBTHB2KMEI.CODE1);
    }

    /**
     * ����1(����)��ݒ肵�܂��B
     * @param val String ����1(����)
     */
    public void setHb2Name1(String val) {
        set(TBTHB2KMEI.NAME1, val);
    }

    /**
     * ����1(����)��Ԃ��܂��B
     * @return String ����1(����)
     */
    public String getHb2Name1() {
        return (String) get(TBTHB2KMEI.NAME1);
    }

    /**
     * ����2(����)��ݒ肵�܂��B
     * @param val String ����2(����)
     */
    public void setHb2Name2(String val) {
        set(TBTHB2KMEI.NAME2, val);
    }

    /**
     * ����2(����)��Ԃ��܂��B
     * @return String ����2(����)
     */
    public String getHb2Name2() {
        return (String) get(TBTHB2KMEI.NAME2);
    }

    /**
     * ����3(����)��ݒ肵�܂��B
     * @param val String ����3(����)
     */
    public void setHb2Name3(String val) {
        set(TBTHB2KMEI.NAME3, val);
    }

    /**
     * ����3(����)��Ԃ��܂��B
     * @return String ����3(����)
     */
    public String getHb2Name3() {
        return (String) get(TBTHB2KMEI.NAME3);
    }

    /**
     * ����4(����)��ݒ肵�܂��B
     * @param val String ����4(����)
     */
    public void setHb2Name4(String val) {
        set(TBTHB2KMEI.NAME4, val);
    }

    /**
     * ����4(����)��Ԃ��܂��B
     * @return String ����4(����)
     */
    public String getHb2Name4() {
        return (String) get(TBTHB2KMEI.NAME4);
    }

    /**
     * ����5(����)��ݒ肵�܂��B
     * @param val String ����5(����)
     */
    public void setHb2Name5(String val) {
        set(TBTHB2KMEI.NAME5, val);
    }

    /**
     * ����5(����)��Ԃ��܂��B
     * @return String ����5(����)
     */
    public String getHb2Name5() {
        return (String) get(TBTHB2KMEI.NAME5);
    }

    /**
     * ����6(����)��ݒ肵�܂��B
     * @param val String ����6(����)
     */
    public void setHb2Name6(String val) {
        set(TBTHB2KMEI.NAME6, val);
    }

    /**
     * ����6(����)��Ԃ��܂��B
     * @return String ����6(����)
     */
    public String getHb2Name6() {
        return (String) get(TBTHB2KMEI.NAME6);
    }

    /**
     * ����7(����)��ݒ肵�܂��B
     * @param val String ����7(����)
     */
    public void setHb2Name7(String val) {
        set(TBTHB2KMEI.NAME7, val);
    }

    /**
     * ����7(����)��Ԃ��܂��B
     * @return String ����7(����)
     */
    public String getHb2Name7() {
        return (String) get(TBTHB2KMEI.NAME7);
    }

    /**
     * ����8(����)��ݒ肵�܂��B
     * @param val String ����8(����)
     */
    public void setHb2Name8(String val) {
        set(TBTHB2KMEI.NAME8, val);
    }

    /**
     * ����8(����)��Ԃ��܂��B
     * @return String ����8(����)
     */
    public String getHb2Name8() {
        return (String) get(TBTHB2KMEI.NAME8);
    }

    /**
     * ����9(����)��ݒ肵�܂��B
     * @param val String ����9(����)
     */
    public void setHb2Name9(String val) {
        set(TBTHB2KMEI.NAME9, val);
    }

    /**
     * ����9(����)��Ԃ��܂��B
     * @return String ����9(����)
     */
    public String getHb2Name9() {
        return (String) get(TBTHB2KMEI.NAME9);
    }

    /**
     * ����11(����)��ݒ肵�܂��B
     * @param val String ����11(����)
     */
    public void setHb2Name11(String val) {
        set(TBTHB2KMEI.NAME11, val);
    }

    /**
     * ����11(����)��Ԃ��܂��B
     * @return String ����11(����)
     */
    public String getHb2Name11() {
        return (String) get(TBTHB2KMEI.NAME11);
    }

    /**
     * ���z1��ݒ肵�܂��B
     * @param val BigDecimal ���z1
     */
    public void setHb2Kngk1(BigDecimal val) {
        set(TBTHB2KMEI.KNGK1, val);
    }

    /**
     * ���z1��Ԃ��܂��B
     * @return BigDecimal ���z1
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Kngk1() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK1);
    }

    /**
     * ���z2��ݒ肵�܂��B
     * @param val BigDecimal ���z2
     */
    public void setHb2Kngk2(BigDecimal val) {
        set(TBTHB2KMEI.KNGK2, val);
    }

    /**
     * ���z2��Ԃ��܂��B
     * @return BigDecimal ���z2
     */
    @XmlElement(required = true)
    public BigDecimal getHb2Kngk2() {
        return (BigDecimal) get(TBTHB2KMEI.KNGK2);
    }

    /**
     * ���̑�1��ݒ肵�܂��B
     * @param val String ���̑�1
     */
    public void setHb2Sonota1(String val) {
        set(TBTHB2KMEI.SONOTA1, val);
    }

    /**
     * ���̑�1��Ԃ��܂��B
     * @return String ���̑�1
     */
    public String getHb2Sonota1() {
        return (String) get(TBTHB2KMEI.SONOTA1);
    }

    /**
     * ���̑�2��ݒ肵�܂��B
     * @param val String ���̑�2
     */
    public void setHb2Sonota2(String val) {
        set(TBTHB2KMEI.SONOTA2, val);
    }

    /**
     * ���̑�2��Ԃ��܂��B
     * @return String ���̑�2
     */
    public String getHb2Sonota2() {
        return (String) get(TBTHB2KMEI.SONOTA2);
    }

    /**
     * ���̑�3��ݒ肵�܂��B
     * @param val String ���̑�3
     */
    public void setHb2Sonota3(String val) {
        set(TBTHB2KMEI.SONOTA3, val);
    }

    /**
     * ���̑�3��Ԃ��܂��B
     * @return String ���̑�3
     */
    public String getHb2Sonota3() {
        return (String) get(TBTHB2KMEI.SONOTA3);
    }

    /**
     * ���̑�4��ݒ肵�܂��B
     * @param val String ���̑�4
     */
    public void setHb2Sonota4(String val) {
        set(TBTHB2KMEI.SONOTA4, val);
    }

    /**
     * ���̑�4��Ԃ��܂��B
     * @return String ���̑�4
     */
    public String getHb2Sonota4() {
        return (String) get(TBTHB2KMEI.SONOTA4);
    }

    /**
     * ���̑�5��ݒ肵�܂��B
     * @param val String ���̑�5
     */
    public void setHb2Sonota5(String val) {
        set(TBTHB2KMEI.SONOTA5, val);
    }

    /**
     * ���̑�5��Ԃ��܂��B
     * @return String ���̑�5
     */
    public String getHb2Sonota5() {
        return (String) get(TBTHB2KMEI.SONOTA5);
    }

    /**
     * ��ʃR�[�h��ݒ肵�܂��B
     * @param val String ��ʃR�[�h
     */
    public void setShubetsuCd(String val) {
        set("SHOWNUM", val);
    }

    /**
     * ��ʃR�[�h��Ԃ��܂��B
     * @return String ��ʃR�[�h
     */
    public String getShubetsuCd() {
        return (String) get("SHOWNUM");
    }

    /**
     * ��ʖ��̂�ݒ肵�܂��B
     * @param val String ��ʖ���
     */
    public void setShubetsuNm(String val) {
        set("SHUBETSUNM", val);
    }

    /**
     * ��ʖ��̂�Ԃ��܂��B
     * @return String ��ʖ���
     */
    public String getShubetsuNm() {
        return (String) get("SHUBETSUNM");
    }

}