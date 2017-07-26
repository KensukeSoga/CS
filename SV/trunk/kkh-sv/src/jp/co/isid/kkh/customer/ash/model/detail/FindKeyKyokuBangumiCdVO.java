package jp.co.isid.kkh.customer.ash.model.detail;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * キー局の番組コードのVO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/08/20 HLC S.Jang)<BR>
 * </P>
 *
 * @author HLC 張(Jang)
 */
public class FindKeyKyokuBangumiCdVO extends AbstractModel {
    private static final long serialVersionUID = 1L;

    public Object newInstance() {
        return new FindKeyKyokuBangumiCdVO();
    }

    /** 局コード */
    private String KYOKUCD = null;
    /** 局名 */
    private String KYOKUNAME = null;
    /** 番組コード */
    private String BANGUMICD = null;
    /** キー局コード */
    private String KEYBANGUMICD = null;
    /** 局名(略称) */
    private String KYOKURYAKUSYOU = null;

    /**
     * 局コードを取得する
     * @return 局コード
     */
    public String getKYOKUCD() {
        return KYOKUCD;
    }

    /**
     * 局コードを設定する
     * @param val String val
     */
    public void setKYOKUCD(String val) {
        KYOKUCD = val;
    }

    /**
     * 局名を取得する
     * @return 局名
     */
    public String getKYOKUNAME() {
        return KYOKUNAME;
    }

    /**
     * 局名を設定する
     * @param val String 局名
     */
    public void setKYOKUNAME(String val) {
        KYOKUNAME = val;
    }

    /**
     * 番組コードを取得する
     * @return 番組コード
     */
    public String getBANGUMICD() {
        return BANGUMICD;
    }

    /**
     * 番組コードを設定する
     * @param val String 番組コード
     */
    public void setBANGUMICD(String val) {
        BANGUMICD = val;
    }

    /**
     * キー局コードを取得する
     * @return キー局コード
     */
    public String getKEYBANGUMICD() {
        return KEYBANGUMICD;
    }

    /**
     * キー局コードを設定する
     * @param val String キー局コード
     */
    public void setKEYBANGUMICD(String val) {
        KEYBANGUMICD = val;
    }

    /**
     * 局名(略称)を取得する
     * @return 局名(略称)
     */
    public String getKYOKURYAKUSYOU() {
        return KYOKURYAKUSYOU;
    }

    /**
     * 局名(略称)を設定する
     * @param val String 局名(略称)
     */
    public void setKYOKURYAKUSYOU(String val) {
        KYOKURYAKUSYOU = val;
    }

}
