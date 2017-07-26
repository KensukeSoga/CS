package jp.co.isid.kkh.customer.lion.model.report;

import java.math.BigDecimal;

import jp.co.isid.nj.model.AbstractModel;

/**
 * <P>
 * ライオン帳票(追加変更リスト)検索結果VO
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/07/31 HLC S.Fujimoto)<BR>
 * </P>
 *
 * @author HLC S.Fujimoto
 */
public class AddChangeReportLionBaitaiVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /** 履歴タイムスタンプ */
    public static final String RRKTIMSTMP = "RRKTIMSTMP";

    /** 受注No */
    public static final String JYUTNO = "JYUTNO";
    /** 受注明細No */
    public static final String JYMEINO = "JYMEINO";
    /** 売上明細No */
    public static final String URMEINO = "URMEINO";
    /** 連番 */
    public static final String RENBN = "RENBN";
    /** 媒体区分コード */
    public static final String BAITAIKBN = "BAITAIKBN";
    /** 媒体区分名称 */
    public static final String BAITAINM = "BAITAINM";
    /** 媒体区分ソート順 */
    public static final String BAITAISORTNO = "BAITAISORTNO";
    /** 件名 */
    public static final String KENNM = "KENNM";
    /** 請求金額 */
    public static final String SEIGAK = "SEIGAK";
    /** 局誌コード */
    public static final String KYKSHCD = "KYKSHCD";
    /** 局コード */
    public static final String KYKCD = "KYKCD";
    /** 局名 */
    public static final String KYKNM = "KYKNM";
    /** CM秒数 */
    public static final String BYOSU = "BYOSU";
    /** CM本数 */
    public static final String HONSU = "HONSU";
    /** スペース */
    public static final String SPACE = "SPACE";
    /** 掲載日・号・等 */
    public static final String KEISAIBI = "KEISAIBI";
    /** 期間 */
    public static final String TERM = "TERM";
    /** 変更区分 */
    public static final String ADDCHGKBN = "ADDCHGKBN";
    /** SEQ(追加:1、削除:2、変更:3) */
    public static final String SEQ = "SEQ";
    /** ソート順(AD1:1、AD2:2) */
    public static final String ORDERSEQ = "ORDERSEQ";

    /** AD1受注No */
    public static final String AD1JYUTNO = "AD1JYUTNO";
    /** AD1受注明細No */
    public static final String AD1JYMEINO = "AD1JYMEINO";
    /** AD1売上明細No */
    public static final String AD1URMEINO = "AD1URMEINO";
    /** AD1連番 */
    public static final String AD1RENBN = "AD1RENBN";
    /** AD1媒体区分コード */
    public static final String AD1BAITAIKBN = "AD1BAITAIKBN";
    /** AD1媒体区分名 */
    public static final String AD1BAITAINM = "AD1BAITAINM";
    /** AD1媒体区分ソート順 */
    public static final String AD1BAITAISORTNO = "AD1BAITAISORTNO";
    /** AD1件名 */
    public static final String AD1KENNM = "AD1KENNM";
    /** AD1請求金額 */
    public static final String AD1SEIGAK = "AD1SEIGAK";
    /** AD1CM本数 */
    public static final String AD1HONSU = "AD1HONSU";
    /** AD1CM秒数 */
    public static final String AD1BYOSU = "AD1BYOSU";
    /** AD1スペース */
    public static final String AD1SPACE = "AD1SPACE";
    /** AD1期間 */
    public static final String AD1TERM = "AD1TERM";
    /** AD1局誌コード */
    public static final String AD1KYKSHCD = "AD1KYKSHCD";
    /** AD1局コード */
    public static final String AD1KYKCD = "AD1KYKCD";
    /** AD1局名 */
    public static final String AD1KYKNM = "AD1KYKNM";
    /** AD1掲載日 */
    public static final String AD1KEISAIBI = "AD1KEISAIBI";
    /** AD1ブランドコード */
    public static final String AD1BRDCD = "AD1BRDCD";

    /** AD2受注No */
    public static final String AD2JYUTNO = "AD2JYUTNO";
    /** AD2受注明細No */
    public static final String AD2JYMEINO = "AD2JYMEINO";
    /** AD2売上明細No */
    public static final String AD2URMEINO = "AD2URMEINO";
    /** AD2連番 */
    public static final String AD2RENBN = "AD2RENBN";
    /** AD2媒体区分コード */
    public static final String AD2BAITAIKBN = "AD2BAITAIKBN";
    /** AD2媒体区分名 */
    public static final String AD2BAITAINM = "AD2BAITAINM";
    /** AD2媒体区分ソート順 */
    public static final String AD2BAITAISORTNO = "AD2BAITAISORTNO";
    /** AD2件名 */
    public static final String AD2KENNM = "AD2KENNM";
    /** AD2請求金額 */
    public static final String AD2SEIGAK = "AD2SEIGAK";
    /** AD2CM本数 */
    public static final String AD2HONSU = "AD2HONSU";
    /** AD2CM秒数 */
    public static final String AD2BYOSU = "AD2BYOSU";
    /** AD2スペース */
    public static final String AD2SPACE = "AD2SPACE";
    /** AD2期間 */
    public static final String AD2TERM = "AD2TERM";
    /** AD2局誌コード */
    public static final String AD2KYKSHCD = "AD2KYKSHCD";
    /** AD2局コード */
    public static final String AD2KYKCD = "AD2KYKCD";
    /** AD2局名 */
    public static final String AD2KYKNM = "AD2KYKNM";
    /** AD2掲載日 */
    public static final String AD2KEISAIBI = "AD2KEISAIBI";
    /** AD2ブランドコード */
    public static final String AD2BRDCD = "AD2BRDCD";

    /**
     * 新規インスタンスを構築します。
     */
    public AddChangeReportLionBaitaiVO() {
    }

    /**
     * 新規インスタンスを構築します。
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new AddChangeReportLionBaitaiVO();
    }

    /**
     * 履歴タイムスタンプを取得する
     * @return String 履歴タイムスタンプ
     */
    public String getRrkTimStmp() {
        return (String) get(RRKTIMSTMP);
    }

    /**
     * 履歴タイムスタンプを設定する
     * @param val String 履歴タイムスタンプ
     */
    public void setRrkTimStmp(String val) {
        set(RRKTIMSTMP, val);
    }

    /**
     * 受注Noを取得する
     * @return String 受注No
     */
    public String getJyutNo() {
        return (String) get(JYUTNO);
    }

    /**
     * 受注Noを設定する
     * @param val String 受注No
     */
    public void setJyutNo(String val) {
        set(JYUTNO, val);
    }

    /**
     * 受注明細Noを取得する
     * @return String 受注明細No
     */
    public String getJymeiNo() {
        return (String) get(JYMEINO);
    }

    /**
     * 受注明細Noを設定する
     * @param val String 受注明細No
     */
    public void setJymeiNo(String val) {
        set(JYMEINO, val);
    }

    /**
     * 売上明細Noを取得する
     * @return String 売上明細No
     */
    public String getUrmeiNo() {
        return (String) get(URMEINO);
    }

    /**
     * 売上明細Noを設定する
     * @param val String 売上明細No
     */
    public void setUrmeiNo(String val) {
        set(URMEINO, val);
    }

    /**
     * 連番を取得する
     * @return String 連番
     */
    public String getRenbn() {
        return (String) get(RENBN);
    }

    /**
     * 連番を設定する
     * @param val String 連番
     */
    public void setRenbn(String val) {
        set(RENBN, val);
    }

    /**
     * 媒体区分コードを取得する
     * @return String 媒体区分コード
     */
    public String getBaitaiKbn() {
        return (String) get(BAITAIKBN);
    }

    /**
     * 媒体区分コードを設定する
     * @param val String 媒体区分コード
     */
    public void setBaitaiKbn(String val) {
        set(BAITAIKBN, val);
    }

    /**
     * 媒体区分名称を取得する
     * @return String 媒体区分名称
     */
    public String getBaitaiNm() {
        return (String) get(BAITAINM);
    }

    /**
     * 媒体区分名称を設定する
     * @param val String 媒体区分名称
     */
    public void setBaitaiNm(String val) {
        set(BAITAINM, val);
    }

    /**
     * 媒体区分ソート順を取得する
     * @return Integer 媒体区分ソート順
     */
    public Integer getBaitaiSortNo() {
        return (Integer) get(BAITAISORTNO);
    }

    /**
     * 媒体区分ソート順を設定する
     * @param val Integer 媒体区分ソート順
     */
    public void setBaitaiSortNo(Integer val) {
        set(BAITAISORTNO, val);
    }

    /**
     * 件名を取得する
     * @return String 件名
     */
    public String getKenNm() {
        return (String) get(KENNM);
    }

    /**
     * 件名を設定する
     * @param val String 件名
     */
    public void setKenNm(String val) {
        set(KENNM, val);
    }

    /**
     * 請求金額を取得する
     * @return BigDecimal 請求金額
     */
    public BigDecimal getSeigak() {
        return (BigDecimal) get(SEIGAK);
    }

    /**
     * 請求金額を設定する
     * @param val BigDecimal 請求金額
     */
    public void setSeigak(BigDecimal val) {
        set(SEIGAK, val);
    }

    /**
     * 局誌コードを取得する
     * @return String 局誌コード
     */
    public String getKykshCd() {
        return (String) get(KYKSHCD);
    }

    /**
     * 局誌コードを設定する
     * @param val String 局誌コード
     */
    public void setKykshCd(String val) {
        set(KYKSHCD, val);
    }

    /**
     * 局コードを取得する
     * @return String 局コード
     */
    public String getKykCd() {
        return (String) get(KYKCD);
    }

    /**
     * 局コードを設定する
     * @param val String 局コード
     */
    public void setKykCd(String val) {
        set(KYKCD, val);
    }

    /**
     * 局名を取得する
     * @return String 局名
     */
    public String getKykNm() {
        return (String) get(KYKNM);
    }

    /**
     * 局名を設定する
     * @param val String 局名
     */
    public void setKykNm(String val) {
        set(KYKNM, val);
    }

    /**
     * CM秒数を取得する
     * @return BigDecimal CM秒数
     */
    public BigDecimal getByosu() {
        return (BigDecimal) get(BYOSU);
    }

    /**
     * CM秒数を設定する
     * @param val BigDecimal CM秒数
     */
    public void setByosu(BigDecimal val) {
        set(BYOSU, val);
    }

    /**
     * CM本数を取得する
     * @return BigDecimal CM本数
     */
    public BigDecimal getHonsu() {
        return (BigDecimal) get(HONSU);
    }

    /**
     * CM本数を設定する
     * @param val BigDecimal CM本数
     */
    public void setHonsu(BigDecimal val) {
        set(HONSU, val);
    }

    /**
     * スペースを取得する
     * @return String スペース
     */
    public String getSpace() {
        return (String) get(SPACE);
    }

    /**
     * スペースを設定する
     * @param val String スペース
     */
    public void setSpace(String val) {
        set(SPACE, val);
    }

    /**
     * 掲載日・号・等を取得する
     * @return String 掲載日・号・等
     */
    public String getKeisaibi() {
        return (String) get(KEISAIBI);
    }

    /**
     * 掲載日・号・等を設定する
     * @param val String 掲載日・号・等
     */
    public void setKeisaibi(String val) {
        set(KEISAIBI, val);
    }

    /**
     * 期間を取得する
     * @return String 期間
     */
    public String getTerm() {
        return (String) get(TERM);
    }

    /**
     * 期間を設定する
     * @param val String 期間
     */
    public void setTerm(String val) {
        set(TERM, val);
    }

    /**
     * 変更区分を取得する
     * @return String 変更区分
     */
    public String getAddChgKbn() {
        return ((String) get(ADDCHGKBN));
    }

    /**
     * 変更区分を設定する
     * @param val String 変更区分
     */
    public void setAddChgKbn(String val) {
        set(ADDCHGKBN, val);
    }

    /**
     * SEQを取得する
     * @return String SEQ
     */
    public String getSEQ() {
        return ((String) get(SEQ));
    }

    /**
     * SEQを設定する
     * @param val String SEQ
     */
    public void setSEQ(String val) {
        set(SEQ, val);
    }

    /**
     * ソート順を取得する
     * @return String ソート順
     */
    public String getORDERSEQ() {
        return ((String) get(ORDERSEQ));
    }

    /**
     * ソート順を設定する
     * @param val String ソート順
     */
    public void setORDERSEQ(String val) {
        set(ORDERSEQ, val);
    }

    /**
     * AD1請求金額を取得する
     * @return BigDecimal AD1請求金額
     */
    public BigDecimal getAD1Seigak() {
        return (BigDecimal) get(AD1SEIGAK);
    }

    /**
     * AD1請求金額を設定する
     * @param val BigDecimal AD1請求金額
     */
    public void setAD1Seigak(BigDecimal val) {
        set(AD1SEIGAK, val);
    }

    /**
     * AD2請求金額を取得する
     * @return BigDecimal AD2請求金額
     */
    public BigDecimal getAD2Seigak() {
        return (BigDecimal) get(AD2SEIGAK);
    }

    /**
     * AD2請求金額を設定する
     * @param val BigDecimal AD2請求金額
     */
    public void setAD2Seigak(BigDecimal val) {
        set(AD2SEIGAK, val);
    }

//    /** AD1受注Noを取得する
//     * @return String AD1受注No
//     */
//    public String getAD1Jyutno() {
//        return (String) get(AD1JYUTNO);
//    }
//
//    /**
//     * AD1受注Noを設定する
//     * @param val String AD1受注No
//     */
//    public void setAD1Jyutno(String val) {
//        set(AD1JYUTNO, val);
//    }
//
//    /**
//     * AD1受注明細Noを取得する
//     * @return String AD1受注明細No
//     */
//    public String getAD1Jymeino() {
//        return (String) get(AD1JYMEINO);
//    }
//
//    /**
//     * AD1受注明細Noを設定する
//     * @param val String AD1受注明細No
//     */
//    public void setAD1Jymeino(String val) {
//        set(AD1JYMEINO, val);
//    }
//
//    /**
//     * 売上明細Noを取得する
//     * @return String 売上明細No
//     */
//    public String getAD1Urmeino() {
//        return (String) get(AD1URMEINO);
//    }
//
//    /**
//     * 売上明細Noを設定する
//     * @param val String 売上明細No
//     */
//    public void setAD1Urmeino(String val) {
//        set(AD1URMEINO, val);
//    }
//
//    /**
//     * AD1連番を取得する
//     * @return String AD1連番
//     */
//    public String getAD1Renbn() {
//        return (String) get(AD1RENBN);
//    }
//
//    /**
//     * AD1連番を設定する
//     * @param val String AD1連番
//     */
//    public void setAD1Renbn(String val) {
//        set(AD1RENBN, val);
//    }
//
//    /**
//     * AD1媒体区分コードを取得する
//     * @return String AD1媒体区分
//     */
//    public String getAD1BaitaiKbn() {
//        return (String) get(AD1BAITAIKBN);
//    }
//
//    /**
//     * AD1媒体区分コードを設定する
//     * @param val String AD1媒体区分
//     */
//    public void setAD1BaitaiKbn(String val) {
//        set(AD1BAITAIKBN, val);
//    }
//
//    /**
//     * AD1媒体区分名を取得する
//     * @return String AD1媒体区分名
//     */
//    public String getAD1BaitaiNm() {
//        return (String) get(AD1BAITAINM);
//    }
//
//    /**
//     * AD1媒体区分名を設定する
//     * @param val String AD1媒体区分名
//     */
//    public void setAD1BaitaiNm(String val) {
//        set(AD1BAITAINM, val);
//    }
//
//    /**
//     * AD1件名を取得する
//     * @return String AD1件名
//     */
//    public String getAD1KenNm() {
//        return (String) get(AD1KENNM);
//    }
//
//    /**
//     * AD1件名を設定する
//     * @param val String AD1件名
//     */
//    public void setAD1KenNm(String val) {
//        set(AD1KENNM, val);
//    }
//
//    /**
//     * AD1本数を取得する
//     * @return BigDecimal AD1本数
//     */
//    public BigDecimal getAD1Honsu() {
//        return (BigDecimal) get(AD1HONSU);
//    }
//
//    /**
//     * AD1本数を設定する
//     * @param val BigDecimal AD1本数
//     */
//    public void setAD1Honsu(BigDecimal val) {
//        set(AD1HONSU, val);
//    }
//
//    /**
//     * AD1秒数を取得する
//     * @return BigDecimal AD1秒数
//     */
//    public BigDecimal getAD1Byosu() {
//        return (BigDecimal) get(AD1BYOSU);
//    }
//
//    /**
//     * AD1秒数を設定する
//     * @param val BigDecimal AD1秒数
//     */
//    public void setAD1Byosu(BigDecimal val) {
//        set(AD1BYOSU, val);
//    }
//
//    /**
//     * スペースを取得する
//     * @return String スペース
//     */
//    public String getAD1Space() {
//        return (String) get(AD1SPACE);
//    }
//
//    /**
//     * AD1スペースを設定する
//     * @param val String AD1スペース
//     */
//    public void setAD1Space(String val) {
//        set(AD1SPACE, val);
//    }
//
//    /**
//     * AD1期間を取得する
//     * @return String AD1期間
//     */
//    public String getAD1Term() {
//        return (String) get(AD1TERM);
//    }
//
//    /**
//     * AD1期間を設定する
//     * @param val String AD1期間
//     */
//    public void setAD1Term(String val) {
//        set(AD1TERM, val);
//    }
//
//    /**
//     * AD1局誌コードを取得する
//     * @return String AD1局誌コード
//     */
//    public String getAD1KykshCd() {
//        return (String) get(AD1KYKSHCD);
//    }
//
//    /**
//     * AD1局誌コードを設定する
//     * @param val String AD1局誌コード
//     */
//    public void setAD1KykshCd(String val) {
//        set(AD1KYKSHCD, val);
//    }
//
//    /**
//     * AD1局コードを取得する
//     * @return String AD1局コード
//     */
//    public String getAD1KykCd() {
//        return (String) get(AD1KYKCD);
//    }
//
//    /**
//     * AD1局コードを設定する
//     * @param val String AD1局コード
//     */
//    public void setAD1KykCd(String val) {
//        set(AD1KYKCD, val);
//    }
//
//    /**
//     * AD1局名を取得する
//     * @return String AD1局名
//     */
//    public String getAD1KykNm() {
//        return (String) get(AD1KYKNM);
//    }
//
//    /**
//     * AD1局名を設定する
//     * @param val String AD1局名
//     */
//    public void setAD1KykNm(String val) {
//        set(AD1KYKNM, val);
//    }
//
//    /**
//     * AD1掲載日を取得する
//     * @return String AD1掲載日
//     */
//    public String getAD1Keisaibi() {
//        return (String) get(AD1KEISAIBI);
//    }
//
//    /**
//     * AD1掲載日を設定する
//     * @param val String AD1掲載日
//     */
//    public void setAD1Keisaibi(String val) {
//        set(AD1KEISAIBI, val);
//    }
//
//    /** AD2受注Noを取得する
//     * @return String AD2受注No
//     */
//    public String getAD2Jyutno() {
//        return (String) get(AD2JYUTNO);
//    }
//
//    /**
//     * AD2受注Noを設定する
//     * @param val String AD2受注No
//     */
//    public void setAD2Jyutno(String val) {
//        set(AD2JYUTNO, val);
//    }
//
//    /**
//     * AD2受注明細Noを取得する
//     * @return String AD2受注明細No
//     */
//    public String getAD2Jymeino() {
//        return (String) get(AD2JYMEINO);
//    }
//
//    /**
//     * AD2受注明細Noを設定する
//     * @param val String AD2受注明細No
//     */
//    public void setAD2Jymeino(String val) {
//        set(AD2JYMEINO, val);
//    }
//
//    /**
//     * AD2売上明細Noを取得する
//     * @return String AD2売上明細No
//     */
//    public String getAD2Urmeino() {
//        return (String) get(AD2URMEINO);
//    }
//
//    /**
//     * AD2売上明細Noを設定する
//     * @param val String AD2売上明細No
//     */
//    public void setAD2Urmeino(String val) {
//        set(AD2URMEINO, val);
//    }
//
//    /**
//     * AD2連番を取得する
//     * @return String AD2連番
//     */
//    public String getAD2Renbn() {
//        return (String) get(AD2RENBN);
//    }
//
//    /**
//     * AD2連番を設定する
//     * @param val String AD2連番
//     */
//    public void setAD2Renbn(String val) {
//        set(AD2RENBN, val);
//    }
//
//    /**
//     * AD2媒体区分コードを取得する
//     * @return String AD2媒体区分
//     */
//    public String getAD2BaitaiKbn() {
//        return (String) get(AD2BAITAIKBN);
//    }
//
//    /**
//     * AD2媒体区分コードを設定する
//     * @param val String AD2媒体区分
//     */
//    public void setAD2BaitaiKbn(String val) {
//        set(AD2BAITAIKBN, val);
//    }
//
//    /**
//     * AD2媒体区分名を取得する
//     * @return String AD2媒体区分名
//     */
//    public String getAD2BaitaiNm() {
//        return (String) get(AD2BAITAINM);
//    }
//
//    /**
//     * AD2媒体区分名を設定する
//     * @param val String AD2媒体区分名
//     */
//    public void setAD2BaitaiNm(String val) {
//        set(AD2BAITAINM, val);
//    }
//
//    /**
//     * AD2件名を取得する
//     * @return String AD2件名
//     */
//    public String getAD2KenNm() {
//        return (String) get(AD2KENNM);
//    }
//
//    /**
//     * AD2件名を設定する
//     * @param val String AD2件名
//     */
//    public void setAD2KenNm(String val) {
//        set(AD2KENNM, val);
//    }
//
//    /**
//     * AD2本数を取得する
//     * @return BigDecimal AD2本数
//     */
//    public BigDecimal getAD2Honsu() {
//        return (BigDecimal) get(AD2HONSU);
//    }
//
//    /**
//     * AD2本数を設定する
//     * @param val BigDecimal AD2本数
//     */
//    public void setAD2Honsu(BigDecimal val) {
//        set(AD2HONSU, val);
//    }
//
//    /**
//     * AD2秒数を取得する
//     * @return BigDecimal AD2秒数
//     */
//    public BigDecimal getAD2Byosu() {
//        return (BigDecimal) get(AD2BYOSU);
//    }
//
//    /**
//     * AD2秒数を設定する
//     * @param val BigDecimal AD2秒数
//     */
//    public void setAD2Byosu(BigDecimal val) {
//        set(AD2BYOSU, val);
//    }
//
//    /**
//     * AD2スペースを取得する
//     * @return String AD2スペース
//     */
//    public String getAD2Space() {
//        return (String) get(AD2SPACE);
//    }
//
//    /**
//     * AD2スペースを設定する
//     * @param val String AD2スペース
//     */
//    public void setAD2Space(String val) {
//        set(AD2SPACE, val);
//    }
//
//    /**
//     * AD2期間を取得する
//     * @return String AD2期間
//     */
//    public String getAD2Term() {
//        return (String) get(AD2TERM);
//    }
//
//    /**
//     * AD2期間を設定する
//     * @param val String AD2期間
//     */
//    public void setAD2Term(String val) {
//        set(AD2TERM, val);
//    }
//
//    /**
//     * AD2局誌コードを取得する
//     * @return String AD2局誌コード
//     */
//    public String getAD2KykshCd() {
//        return (String) get(AD2KYKSHCD);
//    }
//
//    /**
//     * AD2局誌コードを設定する
//     * @param val String AD2局誌コード
//     */
//    public void setAD2KykshCd(String val) {
//        set(AD2KYKSHCD, val);
//    }
//
//    /**
//     * AD2局コードを取得する
//     * @return String AD2局コード
//     */
//    public String getAD2KykCd() {
//        return (String) get(AD2KYKCD);
//    }
//
//    /**
//     * AD2局コードを設定する
//     * @param val String AD2局コード
//     */
//    public void setAD2KykCd(String val) {
//        set(AD2KYKCD, val);
//    }
//
//    /**
//     * AD2局名を取得する
//     * @return String AD2局名
//     */
//    public String getAD2KykNm() {
//        return (String) get(AD2KYKNM);
//    }
//
//    /**
//     * AD2局名を設定する
//     * @param val String AD2局名
//     */
//    public void setAD2KykNm(String val) {
//        set(AD2KYKNM, val);
//    }
//
//    /**
//     * AD2掲載日を取得する
//     * @return String AD2掲載日
//     */
//    public String getAD2Keisaibi() {
//        return (String) get(AD2KEISAIBI);
//    }
//
//    /**
//     * AD2掲載日を設定する
//     * @param val String AD2掲載日
//     */
//    public void setAD2Keisaibi(String val) {
//        set(AD2KEISAIBI, val);
//    }

}