package jp.co.isid.kkh.customer.acom.model.input;

import java.math.BigDecimal;

/**
 * <P>
 * �����f�[�^�}�X�^���������B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/08 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
public class HikCommonCondition {

    /** �N�x */
    private String _year;

    /** ��� */
    private String _syubetsu;

    /** ���Ӑ��ƃR�[�h */
    private String _tkskgycd;

    /** ���Ӑ敔��SEQNO */
    private String _tksbmnseqno;

    /** ���Ӑ�S��SEQNO */
    private String _tkstntseqno;

	/** �X�V�敪 */
	private String _KouKbn;

	/** �����Ǘ��ԍ� */
	private String _RireNo;

	/** ���R�[�h��� */
	private String _RecCd;

	/** �˗��N�� */
	private String _Iryymm;

	/** �����ԍ� */
	private String _Irban;

	/** �s�ԍ� */
	private String _Irrowban;

	/** ���f�B�A�R�[�h */
	private String _MediaCd;

	/** ���f�B�A�� */
	private String _MediaName;

	/** �T�C�Y�R�[�h */
	private String _SizeCd;

	/** �T�C�Y */
	private String _SizeName;

	/** �f�ړ�1 */
	private String _Keisai1;

	/** �f�ړ�2 */
	private String _Keisai2;

	/** �f�ړ�3 */
	private String _Keisai3;

	/** �f�ړ�4 */
	private String _Keisai4;

	/** �f�ړ�5 */
	private String _Keisai5;

	/** �`�ԋ敪�R�[�h */
	private String _KeitaiCd;

	/** �`�ԋ敪�� */
	private String _KeitaiName;

	/** �˗���1 */
	private String _Irmonth1;

	/** ������1 */
	private BigDecimal _Hosoryo1;

	/** �˗���2 */
	private String _Irmonth2;

	/** ������2 */
	private BigDecimal _Hosoryo2;

	/** �˗���3 */
	private String _Irmonth3;

	/** ������3 */
	private BigDecimal _Hosoryo3;

	/** �˗���4 */
	private String _Irmonth4;

	/** ������4 */
	private BigDecimal _Hosoryo4;

	/** �˗���5 */
	private String _Irmonth5;

	/** ������5 */
	private BigDecimal _Hosoryo5;

	/** �˗���6 */
	private String _Irmonth6;

	/** ������6 */
	private BigDecimal _Hosoryo6;

	/** ��ʌf�ڃR�[�h */
	private String _KotukeiCd;

	/** ��ʌf�ږ� */
	private String _KotukeiName;

	/** �f�ړ� */
	private String _Keisai;

	/** �f�ڗ� */
	private BigDecimal _Keisairyo;

	/** �f�ڒP�� */
	private String _KeisaiTanka;

	/** �f�ډ� */
	private String _KeisaiCnt;

	/** ���i�敪 */
	private String _SyohiKbn;

	/** �זڋ敪 */
	private String _SaiKbn;

	/** �E�v�R�[�h */
	private String _TekiCd;

	/** ����\��N�� */
	private String _Uriyymm;

	/** �S���Җ� */
	private String _TanName;

	/** �S���ҋΖ������� */
	private String _TankinName;

	/** ����� */
	private String _Ansyube;

	/** ���l1 */
	private String _Bikou1;

	/** ���l2 */
	private String _Bikou2;

	/** �F���R�[�h */
	private String _ColorCd;

	/** �f�U�C���ύX�� */
	private String _DesignCnt;

	/** ����� */
	private BigDecimal _Printryo;

	/** ���֍�Ɨ� */
	private BigDecimal _Sashikaeryo;

	/** �f�U�C���� */
	private BigDecimal _Designryo;

	/** �ŉ��� */
	private BigDecimal _Hanshitaryo;

	/** ���ő� */
	private BigDecimal _Seihanryo;

	/** �o�^�N���� */
	private String _TouDate;

	/** �ύX�N���� */
	private String _HenDate;

	/** ����N����     */
	private String _TorDate;


    /**
    * �V�K�C���X�^���X���\�z���܂��B
    */
    public HikCommonCondition() {
    }

    /**
     * �N�x���擾���܂��B
     * @return �N�x
     */
    public String getYear() {
        return _year;
    }

    /**
     * �N�x��ݒ肵�܂��B
     * @param year �N�x
     */
    public void setYear(String year) {
        _year = year;
    }

    /**
     * ��ʂ��擾���܂��B
     * @return String ���
     */
    public String getSyubetsu() {
        return _syubetsu;
    }

    /**
     * ��ʂ�ݒ肵�܂��B
     * @param syubetsu String ���
     */
    public void setSyubetsu(String syubetsu) {
        _syubetsu = syubetsu;
    }

    /**
     * ���Ӑ��ƃR�[�h���擾���܂��B
     * @return String ���Ӑ��ƃR�[�h
     */
    public String getTkskgycd() {
        return _tkskgycd;
    }

    /**
     * ���Ӑ��ƃR�[�h��ݒ肵�܂��B
     * @param syubetsu String ���Ӑ��ƃR�[�h
     */
    public void setTkskgycd(String tkskgycd) {
    	_tkskgycd = tkskgycd;
    }


    /**
     * ���Ӑ敔��SEQNO���擾���܂��B
     * @return String ���Ӑ敔��SEQNO
     */
    public String getTksbmnseqno() {
        return _tksbmnseqno;
    }

    /**
     * ���Ӑ敔��SEQNO��ݒ肵�܂��B
     * @param syubetsu String ���Ӑ�S��SEQNO
     */
    public void setTksbmnseqno(String tksbmnseqno) {
    	_tksbmnseqno = tksbmnseqno;
    }

    /**
     * ���Ӑ�S��SEQNO���擾���܂��B
     * @return String ���Ӑ�S��SEQNO
     */
    public String getTkstntseqno() {
        return _tkstntseqno;
    }

    /**
     * ���Ӑ�S��SEQNO��ݒ肵�܂��B
     * @param syubetsu String ���Ӑ�S��SEQNO
     */
    public void setTkstntseqno(String tkstntseqno) {
    	_tkstntseqno = tkstntseqno;
    }

	/**
	 * �X�V�敪���擾����
	 @return �X�V�敪
	 */
	public String getKouKbn() {
	    return _KouKbn;
	}

	/**
	 * �X�V�敪��ݒ肷��
	 @param KouKbn �X�V�敪
	 */
	public void setKouKbn(String KouKbn) {
	    this._KouKbn = KouKbn;
	}

	/**
	 * �����Ǘ��ԍ����擾����
	 @return �����Ǘ��ԍ�
	 */
	public String getRireNo() {
	    return _RireNo;
	}

	/**
	 * �����Ǘ��ԍ���ݒ肷��
	 @param RireNo �����Ǘ��ԍ�
	 */
	public void setRireNo(String RireNo) {
	    this._RireNo = RireNo;
	}

	/**
	 * ���R�[�h��ʂ��擾����
	 @return RecCd ���R�[�h���
	 */
	public String getRecCd() {
	    return _RecCd;
	}

	/**
	 * ���R�[�h��ʂ�ݒ肷��
	 @param RecCd ���R�[�h���
	 */
	public void setRecCd(String RecCd) {
	    this._RecCd = RecCd;
	}

	/**
	 * �˗��N�����擾����
	 @return �˗��N��
	 */
	public String getIryymm() {
	    return _Iryymm;
	}

	/**
	 * �˗��N����ݒ肷��
	 @param Iryymm �˗��N��
	 */
	public void setIryymm(String Iryymm) {
	    this._Iryymm = Iryymm;
	}

	/**
	 * �����ԍ����擾����
	 @return �����ԍ�
	 */
	public String getIrban() {
	    return _Irban;
	}

	/**
	 * �����ԍ���ݒ肷��
	 @param Irban �����ԍ�
	 */
	public void setIrban(String Irban) {
	    this._Irban = Irban;
	}

	/**
	 * �s�ԍ����擾����
	 @return �s�ԍ�
	 */
	public String getIrrowban() {
	    return _Irrowban;
	}

	/**
	 * �s�ԍ���ݒ肷��
	 @param Irrowban �s�ԍ�
	 */
	public void setIrrowban(String Irrowban) {
	    this._Irrowban = Irrowban;
	}

	/**
	 * ���f�B�A�R�[�h���擾����
	 @return ���f�B�A�R�[�h
	 */
	public String getMediaCd() {
	    return _MediaCd;
	}

	/**
	 * ���f�B�A�R�[�h��ݒ肷��
	 @param MediaCd ���f�B�A�R�[�h
	 */
	public void setMediaCd(String MediaCd) {
	    this._MediaCd = MediaCd;
	}

	/**
	 * ���f�B�A�����擾����
	 @return ���f�B�A��
	 */
	public String getMediaName() {
	    return _MediaName;
	}

	/**
	 * ���f�B�A����ݒ肷��
	 @param MediaName ���f�B�A��
	 */
	public void setMediaName(String MediaName) {
	    this._MediaName = MediaName;
	}

	/**
	 * �T�C�Y�R�[�h���擾����
	 @return �T�C�Y�R�[�h
	 */
	public String getSizeCd() {
	    return _SizeCd;
	}

	/**
	 * �T�C�Y�R�[�h��ݒ肷��
	 @param SizeCd �T�C�Y�R�[�h
	 */
	public void setSizeCd(String SizeCd) {
	    this._SizeCd = SizeCd;
	}

	/**
	 * �T�C�Y���擾����
	 @return �T�C�Y
	 */
	public String getSizeName() {
	    return _SizeName;
	}

	/**
	 * �T�C�Y��ݒ肷��
	 @param SizeName �T�C�Y
	 */
	public void setSizeName(String SizeName) {
	    this._SizeName = SizeName;
	}

	/**
	 * �f�ړ�1���擾����
	 @return �f�ړ�1
	 */
	public String getKeisai1() {
	    return _Keisai1;
	}

	/**
	 * �f�ړ�1��ݒ肷��
	 @param Keisai1 �f�ړ�1
	 */
	public void setKeisai1(String Keisai1) {
	    this._Keisai1 = Keisai1;
	}

	/**
	 * �f�ړ�2���擾����
	 @return �f�ړ�2
	 */
	public String getKeisai2() {
	    return _Keisai2;
	}

	/**
	 * �f�ړ�2��ݒ肷��
	 @param Keisai2 �f�ړ�2
	 */
	public void setKeisai2(String Keisai2) {
	    this._Keisai2 = Keisai2;
	}

	/**
	 * �f�ړ�3���擾����
	 @return �f�ړ�3
	 */
	public String getKeisai3() {
	    return _Keisai3;
	}

	/**
	 * �f�ړ�3��ݒ肷��
	 @param Keisai3 �f�ړ�3
	 */
	public void setKeisai3(String Keisai3) {
	    this._Keisai3 = Keisai3;
	}

	/**
	 * �f�ړ�4���擾����
	 @return �f�ړ�4
	 */
	public String getKeisai4() {
	    return _Keisai4;
	}

	/**
	 * �f�ړ�4��ݒ肷��
	 @param Keisai4 �f�ړ�4
	 */
	public void setKeisai4(String Keisai4) {
	    this._Keisai4 = Keisai4;
	}

	/**
	 * �f�ړ�5���擾����
	 @return �f�ړ�5
	 */
	public String getKeisai5() {
	    return _Keisai5;
	}

	/**
	 * �f�ړ�5��ݒ肷��
	 @param Keisai5 �f�ړ�5
	 */
	public void setKeisai5(String Keisai5) {
	    this._Keisai5 = Keisai5;
	}

	/**
	 * �`�ԋ敪�R�[�h���擾����
	 @return �`�ԋ敪�R�[�h
	 */
	public String getKeitaiCd() {
	    return _KeitaiCd;
	}

	/**
	 * �`�ԋ敪�R�[�h��ݒ肷��
	 @param KeitaiCd �`�ԋ敪�R�[�h
	 */
	public void setKeitaiCd(String KeitaiCd) {
	    this._KeitaiCd = KeitaiCd;
	}

	/**
	 * �`�ԋ敪�����擾����
	 @return �`�ԋ敪��
	 */
	public String getKeitaiName() {
	    return _KeitaiName;
	}

	/**
	 * �`�ԋ敪����ݒ肷��
	 @param KeitaiName �`�ԋ敪��
	 */
	public void setKeitaiName(String KeitaiName) {
	    this._KeitaiName = KeitaiName;
	}

	/**
	 * �˗���1���擾����
	 @return �˗���1
	 */
	public String getIrmonth1() {
	    return _Irmonth1;
	}

	/**
	 * �˗���1��ݒ肷��
	 @param Irmonth1 �˗���1
	 */
	public void setIrmonth1(String Irmonth1) {
	    this._Irmonth1 = Irmonth1;
	}

	/**
	 * ������1���擾����
	 @return ������1
	 */
	public BigDecimal getHosoryo1() {
	    return _Hosoryo1;
	}

	/**
	 * ������1��ݒ肷��
	 @param Hosoryo1 ������1
	 */
	public void setHosoryo1(BigDecimal Hosoryo1) {
	    this._Hosoryo1 = Hosoryo1;
	}

	/**
	 * �˗���2���擾����
	 @return �˗���2
	 */
	public String getIrmonth2() {
	    return _Irmonth2;
	}

	/**
	 * �˗���2��ݒ肷��
	 @param Irmonth2 �˗���2
	 */
	public void setIrmonth2(String Irmonth2) {
	    this._Irmonth2 = Irmonth2;
	}

	/**
	 * ������2���擾����
	 @return ������2
	 */
	public BigDecimal getHosoryo2() {
	    return _Hosoryo2;
	}

	/**
	 * ������2��ݒ肷��
	 @param Hosoryo2 ������2
	 */
	public void setHosoryo2(BigDecimal Hosoryo2) {
	    this._Hosoryo2 = Hosoryo2;
	}

	/**
	 * �˗���3���擾����
	 @return �˗���3
	 */
	public String getIrmonth3() {
	    return _Irmonth3;
	}

	/**
	 * �˗���3��ݒ肷��
	 @param Irmonth3 �˗���3
	 */
	public void setIrmonth3(String Irmonth3) {
	    this._Irmonth3 = Irmonth3;
	}

	/**
	 * ������3���擾����
	 @return ������3
	 */
	public BigDecimal getHosoryo3() {
	    return _Hosoryo3;
	}

	/**
	 * ������3��ݒ肷��
	 @param Hosoryo3 ������3
	 */
	public void setHosoryo3(BigDecimal Hosoryo3) {
	    this._Hosoryo3 = Hosoryo3;
	}

	/**
	 * �˗���4���擾����
	 @return �˗���4
	 */
	public String getIrmonth4() {
	    return _Irmonth4;
	}

	/**
	 * �˗���4��ݒ肷��
	 @param Irmonth4 �˗���4
	 */
	public void setIrmonth4(String Irmonth4) {
	    this._Irmonth4 = Irmonth4;
	}

	/**
	 * ������4���擾����
	 @return ������4
	 */
	public BigDecimal getHosoryo4() {
	    return _Hosoryo4;
	}

	/**
	 * ������4��ݒ肷��
	 @param Hosoryo4 ������4
	 */
	public void setHosoryo4(BigDecimal Hosoryo4) {
	    this._Hosoryo4 = Hosoryo4;
	}

	/**
	 * �˗���5���擾����
	 @return �˗���5
	 */
	public String getIrmonth5() {
	    return _Irmonth5;
	}

	/**
	 * �˗���5��ݒ肷��
	 @param Irmonth5 �˗���5
	 */
	public void setIrmonth5(String Irmonth5) {
	    this._Irmonth5 = Irmonth5;
	}

	/**
	 * ������5���擾����
	 @return ������5
	 */
	public BigDecimal getHosoryo5() {
	    return _Hosoryo5;
	}

	/**
	 * ������5��ݒ肷��
	 @param Hosoryo5 ������5
	 */
	public void setHosoryo5(BigDecimal Hosoryo5) {
	    this._Hosoryo5 = Hosoryo5;
	}

	/**
	 * �˗���6���擾����
	 @return �˗���6
	 */
	public String getIrmonth6() {
	    return _Irmonth6;
	}

	/**
	 * �˗���6��ݒ肷��
	 @param Irmonth6 �˗���6
	 */
	public void setIrmonth6(String Irmonth6) {
	    this._Irmonth6 = Irmonth6;
	}

	/**
	 * ������6���擾����
	 @return ������6
	 */
	public BigDecimal getHosoryo6() {
	    return _Hosoryo6;
	}

	/**
	 * ������6��ݒ肷��
	 @param Hosoryo6 ������6
	 */
	public void setHosoryo6(BigDecimal Hosoryo6) {
	    this._Hosoryo6 = Hosoryo6;
	}

	/**
	 * ��ʌf�ڃR�[�h���擾����
	 @return ��ʌf�ڃR�[�h
	 */
	public String getKotukeiCd() {
	    return _KotukeiCd;
	}

	/**
	 * ��ʌf�ڃR�[�h��ݒ肷��
	 @param KotukeiCd ��ʌf�ڃR�[�h
	 */
	public void setKotukeiCd(String KotukeiCd) {
	    this._KotukeiCd = KotukeiCd;
	}

	/**
	 * ��ʌf�ږ����擾����
	 @return ��ʌf�ږ�
	 */
	public String getKotukeiName() {
	    return _KotukeiName;
	}

	/**
	 * ��ʌf�ږ���ݒ肷��
	 @param KotukeiName ��ʌf�ږ�
	 */
	public void setKotukeiName(String KotukeiName) {
	    this._KotukeiName = KotukeiName;
	}

	/**
	 * �f�ړ����擾����
	 @return �f�ړ�
	 */
	public String getKeisai() {
	    return _Keisai;
	}

	/**
	 * �f�ړ���ݒ肷��
	 @param Keisai �f�ړ�
	 */
	public void setKeisai(String Keisai) {
	    this._Keisai = Keisai;
	}

	/**
	 * �f�ڗ����擾����
	 @return �f�ڗ�
	 */
	public BigDecimal getKeisairyo() {
	    return _Keisairyo;
	}

	/**
	 * �f�ڗ���ݒ肷��
	 @param Keisairyo �f�ڗ�
	 */
	public void setKeisairyo(BigDecimal Keisairyo) {
	    this._Keisairyo = Keisairyo;
	}

	/**
	 * �f�ڒP�����擾����
	 @return �f�ڒP��
	 */
	public String getKeisaiTanka() {
	    return _KeisaiTanka;
	}

	/**
	 * �f�ڒP����ݒ肷��
	 @param KeisaiTanka �f�ڒP��
	 */
	public void setKeisaiTanka(String KeisaiTanka) {
	    this._KeisaiTanka = KeisaiTanka;
	}

	/**
	 * �f�ډ񐔂��擾����
	 @return �f�ډ�
	 */
	public String getKeisaiCnt() {
	    return _KeisaiCnt;
	}

	/**
	 * �f�ډ񐔂�ݒ肷��
	 @param KeisaiCnt �f�ډ�
	 */
	public void setKeisaiCnt(String KeisaiCnt) {
	    this._KeisaiCnt = KeisaiCnt;
	}

	/**
	 * ���i�敪���擾����
	 @return ���i�敪
	 */
	public String getSyohiKbn() {
	    return _SyohiKbn;
	}

	/**
	 * ���i�敪��ݒ肷��
	 @param SyohiKbn ���i�敪
	 */
	public void setSyohiKbn(String SyohiKbn) {
	    this._SyohiKbn = SyohiKbn;
	}

	/**
	 * �זڋ敪���擾����
	 @return �זڋ敪
	 */
	public String getSaiKbn() {
	    return _SaiKbn;
	}

	/**
	 * �זڋ敪��ݒ肷��
	 @param SaiKbn �זڋ敪
	 */
	public void setSaiKbn(String SaiKbn) {
	    this._SaiKbn = SaiKbn;
	}

	/**
	 * �E�v�R�[�h���擾����
	 @return �E�v�R�[�h
	 */
	public String getTekiCd() {
	    return _TekiCd;
	}

	/**
	 * �E�v�R�[�h��ݒ肷��
	 @param TekiCd �E�v�R�[�h
	 */
	public void setTekiCd(String TekiCd) {
	    this._TekiCd = TekiCd;
	}

	/**
	 * ����\��N�����擾����
	 @return ����\��N��
	 */
	public String getUriyymm() {
	    return _Uriyymm;
	}

	/**
	 * ����\��N����ݒ肷��
	 @param Uriyymm ����\��N��
	 */
	public void setUriyymm(String Uriyymm) {
	    this._Uriyymm = Uriyymm;
	}

	/**
	 * �S���Җ����擾����
	 @return �S���Җ�
	 */
	public String getTanName() {
	    return _TanName;
	}

	/**
	 * �S���Җ���ݒ肷��
	 @param TanName �S���Җ�
	 */
	public void setTanName(String TanName) {
	    this._TanName = TanName;
	}

	/**
	 * �S���ҋΖ����������擾����
	 @return �S���ҋΖ�������
	 */
	public String getTankinName() {
	    return _TankinName;
	}

	/**
	 * �S���ҋΖ���������ݒ肷��
	 @param TankinName �S���ҋΖ�������
	 */
	public void setTankinName(String TankinName) {
	    this._TankinName = TankinName;
	}

	/**
	 * ����ʂ��擾����
	 @return �����
	 */
	public String getAnsyube() {
	    return _Ansyube;
	}

	/**
	 * ����ʂ�ݒ肷��
	 @param Ansyube �����
	 */
	public void setAnsyube(String Ansyube) {
	    this._Ansyube = Ansyube;
	}

	/**
	 * ���l1���擾����
	 @return ���l1
	 */
	public String getBikou1() {
	    return _Bikou1;
	}

	/**
	 * ���l1��ݒ肷��
	 @param Bikou1 ���l1
	 */
	public void setBikou1(String Bikou1) {
	    this._Bikou1 = Bikou1;
	}

	/**
	 * ���l2���擾����
	 @return ���l2
	 */
	public String getBikou2() {
	    return _Bikou2;
	}

	/**
	 * ���l2��ݒ肷��
	 @param Bikou2 ���l2
	 */
	public void setBikou2(String Bikou2) {
	    this._Bikou2 = Bikou2;
	}

	/**
	 * �F���R�[�h���擾����
	 @return �F���R�[�h
	 */
	public String getColorCd() {
	    return _ColorCd;
	}

	/**
	 * �F���R�[�h��ݒ肷��
	 @param ColorCd �F���R�[�h
	 */
	public void setColorCd(String ColorCd) {
	    this._ColorCd = ColorCd;
	}

	/**
	 * �f�U�C���ύX�񐔂��擾����
	 @return �f�U�C���ύX��
	 */
	public String getDesignCnt() {
	    return _DesignCnt;
	}

	/**
	 * �f�U�C���ύX�񐔂�ݒ肷��
	 @param DesignCnt �f�U�C���ύX��
	 */
	public void setDesignCnt(String DesignCnt) {
	    this._DesignCnt = DesignCnt;
	}

	/**
	 * �������擾����
	 @return �����
	 */
	public BigDecimal getPrintryo() {
	    return _Printryo;
	}

	/**
	 * ������ݒ肷��
	 @param Printryo �����
	 */
	public void setPrintryo(BigDecimal Printryo) {
	    this._Printryo = Printryo;
	}

	/**
	 * ���֍�Ɨ����擾����
	 @return ���֍�Ɨ�
	 */
	public BigDecimal getSashikaeryo() {
	    return _Sashikaeryo;
	}

	/**
	 * ���֍�Ɨ���ݒ肷��
	 @param Sashikaeryo ���֍�Ɨ�
	 */
	public void setSashikaeryo(BigDecimal Sashikaeryo) {
	    this._Sashikaeryo = Sashikaeryo;
	}

	/**
	 * �f�U�C�������擾����
	 @return �f�U�C����
	 */
	public BigDecimal getDesignryo() {
	    return _Designryo;
	}

	/**
	 * �f�U�C������ݒ肷��
	 @param Designryo �f�U�C����
	 */
	public void setDesignryo(BigDecimal Designryo) {
	    this._Designryo = Designryo;
	}

	/**
	 * �ŉ�����擾����
	 @return �ŉ���
	 */
	public BigDecimal getHanshitaryo() {
	    return _Hanshitaryo;
	}

	/**
	 * �ŉ����ݒ肷��
	 @param Hanshitaryo �ŉ���
	 */
	public void setHanshitaryo(BigDecimal Hanshitaryo) {
	    this._Hanshitaryo = Hanshitaryo;
	}

	/**
	 * ���ő���擾����
	 @return ���ő�
	 */
	public BigDecimal getSeihanryo() {
	    return _Seihanryo;
	}

	/**
	 * ���ő��ݒ肷��
	 @param Seihanryo ���ő�
	 */
	public void setSeihanryo(BigDecimal Seihanryo) {
	    this._Seihanryo = Seihanryo;
	}

	/**
	 * �o�^�N�������擾����
	 @return �o�^�N����
	 */
	public String getTouDate() {
	    return _TouDate;
	}

	/**
	 * �o�^�N������ݒ肷��
	 @param TouDate �o�^�N����
	 */
	public void setTouDate(String TouDate) {
	    this._TouDate = TouDate;
	}

	/**
	 * �ύX�N�������擾����
	 @return �ύX�N����
	 */
	public String getHenDate() {
	    return _HenDate;
	}

	/**
	 * �ύX�N������ݒ肷��
	 @param HenDate �ύX�N����
	 */
	public void setHenDate(String HenDate) {
	    this._HenDate = HenDate;
	}

	/**
	 * ����N����    ���擾����
	 @return ����N����
	 */
	public String getTorDate() {
	    return _TorDate;
	}

	/**
	 * ����N����    ��ݒ肷��
	 @param TorDate ����N����
	 */
	public void setTorDate(String TorDate) {
	    this._TorDate = TorDate;
	}
}
