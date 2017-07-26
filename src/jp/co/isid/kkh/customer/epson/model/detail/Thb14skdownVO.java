package jp.co.isid.kkh.customer.epson.model.detail;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.integ.tbl.TBTHB14SKDOWN;
import jp.co.isid.nj.model.AbstractModel;

@XmlRootElement(namespace = "http://detail.model.kkh.isid.co.jp/")
@XmlType(namespace = "http://detail.model.kkh.isid.co.jp/")
public class Thb14skdownVO extends AbstractModel {

    private static final long serialVersionUID = 1L;

    /**
     * 新規インスタンスを構築します。
     */
    public Thb14skdownVO() {
    }

    /**
     * 新規インスタンスを構築します。
     *
     * @return 新規インスタンス
     */
    public Object newInstance() {
        return new Thb14skdownVO();
    }

    /**
     * タイムスタンプを設定します。
     * @param val Date タイムスタンプ
     */
    public void setHb14TimStmp(Date val) {
        set(TBTHB14SKDOWN.TIMSTMP, val);
    }

    /**
     * タイムスタンプを返します。
     * @return Date タイムスタンプ
     */
    @XmlElement(required = true)
    public Date getHb14TimStmp() {
        return (Date) get(TBTHB14SKDOWN.TIMSTMP);
    }

    /**
     * 更新プログラムを設定します。
     * @param val String 更新プログラム
     */
    public void setHb14UpdApl(String val) {
        set(TBTHB14SKDOWN.UPDAPL, val);
    }

    /**
     * 更新プログラムを返します。
     * @return String 更新プログラム
     */
    public String getHb14UpdApl() {
        return (String) get(TBTHB14SKDOWN.UPDAPL);
    }

    /**
     * 更新担当者を設定します。
     * @param val String 更新担当者
     */
    public void setHb14UpdTnt(String val) {
        set(TBTHB14SKDOWN.UPDTNT, val);
    }

    /**
     * 更新担当者を返します。
     * @return String 更新担当者
     */
    public String getHb14UpdTnt() {
        return (String) get(TBTHB14SKDOWN.UPDTNT);
    }

    /**
     * 請求ヘッダ最終更新日時を設定します。
     * @param val String 請求ヘッダ最終更新日時
     */
    public void setHb14Seihupdtimstmp(String val) {
        set(TBTHB14SKDOWN.SEIHUPDTIMSTMP, val);
    }

    /**
     * 請求ヘッダ最終更新日時を返します。
     * @return String 請求ヘッダ最終更新日時
     */
    public String getHb14Seihupdtimstmp() {
        return (String) get(TBTHB14SKDOWN.SEIHUPDTIMSTMP);
    }

    /**
     * 営業所（取）コードを設定します。
     * @param val String 営業所（取）コード
     */
    public void setHb14EgCd(String val) {
        set(TBTHB14SKDOWN.EGCD, val);
    }

    /**
     * 営業所（取）コードを返します。
     * @return String 営業所（取）コード
     */
    public String getHb14EgCd() {
        return (String) get(TBTHB14SKDOWN.EGCD);
    }

    /**
     * 得意先企業コードを設定します。
     * @param val String 得意先企業コード
     */
    public void setHb14TksKgyCd(String val) {
        set(TBTHB14SKDOWN.TKSKGYCD, val);
    }

    /**
     * 得意先企業コードを返します。
     * @return String 得意先企業コード
     */
    public String getHb14TksKgyCd() {
        return (String) get(TBTHB14SKDOWN.TKSKGYCD);
    }

    /**
     * 得意先部門SEQNOを設定します。
     * @param val String 得意先部門SEQNO
     */
    public void setHb14TksBmnSeqNo(String val) {
        set(TBTHB14SKDOWN.TKSBMNSEQNO, val);
    }

    /**
     * 得意先部門SEQNOを返します。
     * @return String 得意先部門SEQNO
     */
    public String getHb14TksBmnSeqNo() {
        return (String) get(TBTHB14SKDOWN.TKSBMNSEQNO);
    }

    /**
     * 得意先担当SEQNOを設定します。
     * @param val String 得意先担当SEQNO
     */
    public void setHb14TksTntSeqNo(String val) {
        set(TBTHB14SKDOWN.TKSTNTSEQNO, val);
    }

    /**
     * 得意先担当SEQNOを返します。
     * @return String 得意先担当SEQNO
     */
    public String getHb14TksTntSeqNo() {
        return (String) get(TBTHB14SKDOWN.TKSTNTSEQNO);
    }

    /**
     * 請求NOを設定します。
     * @param val String 請求NO
     */
    public void setHb14Seino(String val) {
        set(TBTHB14SKDOWN.SEINO, val);
    }

    /**
     * 請求NOを返します。
     * @return String 請求NO
     */
    public String getHb14Seino() {
        return (String) get(TBTHB14SKDOWN.SEINO);
    }

    /**
     * 請求ステータスを設定します。
     * @param val String 請求ステータス
     */
    public void setHb14Seistatus(String val) {
        set(TBTHB14SKDOWN.SEISTATUS, val);
    }

    /**
     * 請求ステータスを返します。
     * @return String 請求ステータス
     */
    public String getHb14Seistatus() {
        return (String) get(TBTHB14SKDOWN.SEISTATUS);
    }

    /**
     * 請求データ種別を設定します。
     * @param val String 請求データ種別
     */
    public void setHb14Seisybt(String val) {
        set(TBTHB14SKDOWN.SEISYBT, val);
    }

    /**
     * 請求データ種別を返します。
     * @return String 請求データ種別
     */
    public String getHb14Seisybt() {
        return (String) get(TBTHB14SKDOWN.SEISYBT);
    }

    /**
     * 請求書通貨コードを設定します。
     * @param val String 請求書通貨コード
     */
    public void setHb14Seitsukacd(String val) {
        set(TBTHB14SKDOWN.SEITSUKACD, val);
    }

    /**
     * 請求書通貨コードを返します。
     * @return String 請求書通貨コード
     */
    public String getHb14Seitsukacd() {
        return (String) get(TBTHB14SKDOWN.SEITSUKACD);
    }

    /**
     * 請求額合計を設定します。
     * @param val BigDecimal 請求額合計
     */
    public void setHb14Seigakgk(BigDecimal val) {
        set(TBTHB14SKDOWN.SEIGAKGK, val);
    }

    /**
     * 請求額合計を返します。
     * @return BigDecimal 請求額合計
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Seigakgk() {
        return (BigDecimal) get(TBTHB14SKDOWN.SEIGAKGK);
    }

    /**
     * 請求時取料金合計を設定します。
     * @param val BigDecimal 請求時取料金合計
     */
    public void setHb14Torigakgk(BigDecimal val) {
        set(TBTHB14SKDOWN.TORIGAKGK, val);
    }

    /**
     * 請求時取料金合計を返します。
     * @return BigDecimal 請求時取料金合計
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Torigakgk() {
        return (BigDecimal) get(TBTHB14SKDOWN.TORIGAKGK);
    }

    /**
     * 請求時値引額合計を設定します。
     * @param val BigDecimal 請求時値引額合計
     */
    public void setHb14Nebigakgk(BigDecimal val) {
        set(TBTHB14SKDOWN.NEBIGAKGK, val);
    }

    /**
     * 請求時値引額合計を返します。
     * @return BigDecimal 請求時値引額合計
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Nebigakgk() {
        return (BigDecimal) get(TBTHB14SKDOWN.NEBIGAKGK);
    }

    /**
     * 請求時消費税額合計を設定します。
     * @param val BigDecimal 請求時消費税額合計
     */
    public void setHb14Szeigakgk(BigDecimal val) {
        set(TBTHB14SKDOWN.SZEIGAKGK, val);
    }

    /**
     * 請求時消費税額合計を返します。
     * @return BigDecimal 請求時消費税額合計
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Szeigakgk() {
        return (BigDecimal) get(TBTHB14SKDOWN.SZEIGAKGK);
    }

    /**
     * 前受振替額を設定します。
     * @param val BigDecimal 前受振替額
     */
    public void setHb14Maefurigak(BigDecimal val) {
        set(TBTHB14SKDOWN.MAEFURIGAK, val);
    }

    /**
     * 前受振替額を返します。
     * @return BigDecimal 前受振替額
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Maefurigak() {
        return (BigDecimal) get(TBTHB14SKDOWN.MAEFURIGAK);
    }

    /**
     * 前受振替消費税を設定します。
     * @param val BigDecimal 前受振替消費税
     */
    public void setHb14Maefuriszeigak(BigDecimal val) {
        set(TBTHB14SKDOWN.MAEFURISZEIGAK, val);
    }

    /**
     * 前受振替消費税を返します。
     * @return BigDecimal 前受振替消費税
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Maefuriszeigak() {
        return (BigDecimal) get(TBTHB14SKDOWN.MAEFURISZEIGAK);
    }

    /**
     * 回収ステータスを設定します。
     * @param val String 回収ステータス
     */
    public void setHb14Kaistatus(String val) {
        set(TBTHB14SKDOWN.KAISTATUS, val);
    }

    /**
     * 回収ステータスを返します。
     * @return String 回収ステータス
     */
    public String getHb14Kaistatus() {
        return (String) get(TBTHB14SKDOWN.KAISTATUS);
    }

    /**
     * 最終消込年月日を設定します。
     * @param val String 最終消込年月日
     */
    public void setHb14Keshidate(String val) {
        set(TBTHB14SKDOWN.KESHIDATE, val);
    }

    /**
     * 最終消込年月日を返します。
     * @return String 最終消込年月日
     */
    public String getHb14Keshidate() {
        return (String) get(TBTHB14SKDOWN.KESHIDATE);
    }

    /**
     * 回収額を設定します。
     * @param val BigDecimal 回収額
     */
    public void setHb14Kaigak(BigDecimal val) {
        set(TBTHB14SKDOWN.KAIGAK, val);
    }

    /**
     * 回収額を返します。
     * @return BigDecimal 回収額
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Kaigak() {
        return (BigDecimal) get(TBTHB14SKDOWN.KAIGAK);
    }

    /**
     * 回収営業所コードを設定します。
     * @param val String 回収営業所コード
     */
    public void setHb14Kaiegcd(String val) {
        set(TBTHB14SKDOWN.KAIEGCD, val);
    }

    /**
     * 回収営業所コードを返します。
     * @return String 回収営業所コード
     */
    public String getHb14Kaiegcd() {
        return (String) get(TBTHB14SKDOWN.KAIEGCD);
    }

    /**
     * 請求書上の発行日を設定します。
     * @param val String 請求書上の発行日
     */
    public void setHb14Seihakdate(String val) {
        set(TBTHB14SKDOWN.SEIHAKDATE, val);
    }

    /**
     * 請求書上の発行日を返します。
     * @return String 請求書上の発行日
     */
    public String getHb14Seihakdate() {
        return (String) get(TBTHB14SKDOWN.SEIHAKDATE);
    }

    /**
     * 請求書出力年月日を設定します。
     * @param val String 請求書出力年月日
     */
    public void setHb14Seisyudate(String val) {
        set(TBTHB14SKDOWN.SEISYUDATE, val);
    }

    /**
     * 請求書出力年月日を返します。
     * @return String 請求書出力年月日
     */
    public String getHb14Seisyudate() {
        return (String) get(TBTHB14SKDOWN.SEISYUDATE);
    }

    /**
     * 請求書再出力年月日を設定します。
     * @param val String 請求書再出力年月日
     */
    public void setHb14Seisaisyudate(String val) {
        set(TBTHB14SKDOWN.SEISAISYUDATE, val);
    }

    /**
     * 請求書再出力年月日を返します。
     * @return String 請求書再出力年月日
     */
    public String getHb14Seisaisyudate() {
        return (String) get(TBTHB14SKDOWN.SEISAISYUDATE);
    }

    /**
     * 再発行回数を設定します。
     * @param val BigDecimal 再発行回数
     */
    public void setHb14Saihakcnt(BigDecimal val) {
        set(TBTHB14SKDOWN.SAIHAKCNT, val);
    }

    /**
     * 再発行回数を返します。
     * @return BigDecimal 再発行回数
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Saihakcnt() {
        return (BigDecimal) get(TBTHB14SKDOWN.SAIHAKCNT);
    }

    /**
     * 請求書取消年月日を設定します。
     * @param val String 請求書取消年月日
     */
    public void setHb14Seitoridate(String val) {
        set(TBTHB14SKDOWN.SEITORIDATE, val);
    }

    /**
     * 請求書取消年月日を返します。
     * @return String 請求書取消年月日
     */
    public String getHb14Seitoridate() {
        return (String) get(TBTHB14SKDOWN.SEITORIDATE);
    }

    /**
     * 請求年月を設定します。
     * @param val String 請求年月
     */
    public void setHb14Seiyymm(String val) {
        set(TBTHB14SKDOWN.SEIYYMM, val);
    }

    /**
     * 請求年月を返します。
     * @return String 請求年月
     */
    public String getHb14Seiyymm() {
        return (String) get(TBTHB14SKDOWN.SEIYYMM);
    }

    /**
     * 入金先企業コードを設定します。
     * @param val String 入金先企業コード
     */
    public void setHb14Nyukgycd(String val) {
        set(TBTHB14SKDOWN.NYUKGYCD, val);
    }

    /**
     * 入金先企業コードを返します。
     * @return String 入金先企業コード
     */
    public String getHb14Nyukgycd() {
        return (String) get(TBTHB14SKDOWN.NYUKGYCD);
    }

    /**
     * 請求先企業コードを設定します。
     * @param val String 請求先企業コード
     */
    public void setHb14Seikgycd(String val) {
        set(TBTHB14SKDOWN.SEIKGYCD, val);
    }

    /**
     * 請求先企業コードを返します。
     * @return String 請求先企業コード
     */
    public String getHb14Seikgycd() {
        return (String) get(TBTHB14SKDOWN.SEIKGYCD);
    }

    /**
     * 請求先部門SEQNOを取得する
     * @return 請求先部門SEQNO
     */
    public String getHb14Seibmnseqno() {
        return (String) get(TBTHB14SKDOWN.SEIBMNSEQNO);
    }

    /**
     * 請求先部門SEQNOを設定する
     * @param val 請求先部門SEQNO
     */
    public void setHb14Seibmnseqno(String val) {
        set(TBTHB14SKDOWN.SEIBMNSEQNO, val);
    }

    /**
     * 請求先担当SEQNOを取得する
     * @return 請求先担当SEQNO
     */
    public String getHb14Seitntseqno() {
        return (String) get(TBTHB14SKDOWN.SEITNTSEQNO);
    }

    /**
     * 請求先担当SEQNOを設定する
     * @param val 請求先担当SEQNO
     */
    public void setHb14Seitntseqno(String val) {
        set(TBTHB14SKDOWN.SEITNTSEQNO, val);
    }

    /**
     * 請求先名称（上）を取得する
     * @return 請求先名称（上）
     */
    public String getHb14Seinameup() {
        return (String) get(TBTHB14SKDOWN.SEINAMEUP);
    }

    /**
     * 請求先名称（上）を設定する
     * @param val 請求先名称（上）
     */
    public void setHb14Seinameup(String val) {
        set(TBTHB14SKDOWN.SEINAMEUP, val);
    }

    /**
     * 請求先名称（下）を取得する
     * @return 請求先名称（下）
     */
    public String getHb14Seinamedown() {
        return (String) get(TBTHB14SKDOWN.SEINAMEDOWN);
    }

    /**
     * 請求先名称（下）を設定する
     * @param val 請求先名称（下）
     */
    public void setHb14Seinamedown(String val) {
        set(TBTHB14SKDOWN.SEINAMEDOWN, val);
    }

    /**
     * 請求先部門名称を取得する
     * @return 請求先部門名称
     */
    public String getHb14Seibmnname() {
        return (String) get(TBTHB14SKDOWN.SEIBMNNAME);
    }

    /**
     * 請求先部門名称を設定する
     * @param val 請求先部門名称
     */
    public void setHb14Seibmnname(String val) {
        set(TBTHB14SKDOWN.SEIBMNNAME, val);
    }

    /**
     * 営業局名を取得する
     * @return 営業局名
     */
    public String getHb14Egkyoname() {
        return (String) get(TBTHB14SKDOWN.EGKYONAME);
    }

    /**
     * 営業局名を設定する
     * @param val 営業局名
     */
    public void setHb14Egkyoname(String val) {
        set(TBTHB14SKDOWN.EGKYONAME, val);
    }

    /**
     * 営業担当者コードを取得する
     * @return 営業担当者コード
     */
    public String getHb14Egtntcd() {
        return (String) get(TBTHB14SKDOWN.EGTNTCD);
    }

    /**
     * 営業担当者コードを設定する
     * @param val 営業担当者コード
     */
    public void setHb14Egtntcd(String val) {
        set(TBTHB14SKDOWN.EGTNTCD, val);
    }

    /**
     * 営業担当者名を取得する
     * @return 営業担当者名
     */
    public String getHb14Egtntname() {
        return (String) get(TBTHB14SKDOWN.EGTNTNAME);
    }

    /**
     * 営業担当者名を設定する
     * @param val 営業担当者名
     */
    public void setHb14Egtntname(String val) {
        set(TBTHB14SKDOWN.EGTNTNAME, val);
    }

    /**
     * 請求担当者コードを取得する
     * @return 請求担当者コード
     */
    public String getHb14Seitntcd() {
        return (String) get(TBTHB14SKDOWN.SEITNTCD);
    }

    /**
     * 請求担当者コードを設定する
     * @param val 請求担当者コード
     */
    public void setHb14Seitntcd(String val) {
        set(TBTHB14SKDOWN.SEITNTCD, val);
    }

    /**
     * 請求担当者名を取得する
     * @return 請求担当者名
     */
    public String getHb14Seitntname() {
        return (String) get(TBTHB14SKDOWN.SEITNTNAME);
    }

    /**
     * 請求担当者名を設定する
     * @param val 請求担当者名
     */
    public void setHb14Seitntname(String val) {
        set(TBTHB14SKDOWN.SEITNTNAME, val);
    }

    /**
     * 先方指定請求NOを取得する
     * @return 先方指定請求NO
     */
    public String getHb14Senseino() {
        return (String) get(TBTHB14SKDOWN.SENSEINO);
    }

    /**
     * 先方指定請求NOを設定する
     * @param val 先方指定請求NO
     */
    public void setHb14Senseino(String val) {
        set(TBTHB14SKDOWN.SENSEINO, val);
    }

    /**
     * 請求ヘッダ媒体名を取得する
     * @return 請求ヘッダ媒体名
     */
    public String getHb14Seibainame() {
        return (String) get(TBTHB14SKDOWN.SEIBAINAME);
    }

    /**
     * 請求ヘッダ媒体名を設定する
     * @param val 請求ヘッダ媒体名
     */
    public void setHb14Seibainame(String val) {
        set(TBTHB14SKDOWN.SEIBAINAME, val);
    }

    /**
     * 請求件名表示基準年月日を取得する
     * @return 請求件名表示基準年月日
     */
    public String getHb14Seihyodate() {
        return (String) get(TBTHB14SKDOWN.SEIHYODATE);
    }

    /**
     * 請求件名表示基準年月日を設定する
     * @param val 請求件名表示基準年月日
     */
    public void setHb14Seihyodate(String val) {
        set(TBTHB14SKDOWN.SEIHYODATE, val);
    }

    /**
     * 広告件名（漢字）（上）を取得する
     * @return 広告件名（漢字）（上）
     */
    public String getHb14Kounameup() {
        return (String) get(TBTHB14SKDOWN.KOUNAMEUP);
    }

    /**
     * 広告件名（漢字）（上）を設定する
     * @param val 広告件名（漢字）（上）
     */
    public void setHb14Kounameup(String val) {
        set(TBTHB14SKDOWN.KOUNAMEUP, val);
    }

    /**
     * 広告件名（漢字）（下）を取得する
     * @return 広告件名（漢字）（下）
     */
    public String getHb14Kounamedown() {
        return (String) get(TBTHB14SKDOWN.KOUNAMEDOWN);
    }

    /**
     * 広告件名（漢字）（下）を設定する
     * @param val 広告件名（漢字）（下）
     */
    public void setHb14Kounamedown(String val) {
        set(TBTHB14SKDOWN.KOUNAMEDOWN, val);
    }

    /**
     * 振替ステータスを取得する
     * @return 振替ステータス
     */
    public String getHb14Furistatus() {
        return (String) get(TBTHB14SKDOWN.FURISTATUS);
    }

    /**
     * 振替ステータスを設定する
     * @param val 振替ステータス
     */
    public void setHb14Furistatus(String val) {
        set(TBTHB14SKDOWN.FURISTATUS, val);
    }

    /**
     * 請求明細SEQを取得する
     * @return 請求明細SEQ
     */
    public String getHb14Seimeino() {
        return (String) get(TBTHB14SKDOWN.SEIMEINO);
    }

    /**
     * 請求明細SEQを設定する
     * @param val 請求明細SEQ
     */
    public void setHb14Seimeino(String val) {
        set(TBTHB14SKDOWN.SEIMEINO, val);
    }

    /**
     * 営業所コード（扱）を取得する
     * @return 営業所コード（扱）
     */
    public String getHb14Atuegcd() {
        return (String) get(TBTHB14SKDOWN.ATUEGCD);
    }

    /**
     * 営業所コード（扱）を設定する
     * @param val 営業所コード（扱）
     */
    public void setHb14Atuegcd(String val) {
        set(TBTHB14SKDOWN.ATUEGCD, val);
    }

    /**
     * 得意先企業コード（扱）を取得する
     * @return 得意先企業コード（扱）
     */
    public String getHb14Atutkskgycd() {
        return (String) get(TBTHB14SKDOWN.ATUTKSKGYCD);
    }

    /**
     * 得意先企業コード（扱）を設定する
     * @param val 得意先企業コード（扱）
     */
    public void setHb14Atutkskgycd(String val) {
        set(TBTHB14SKDOWN.ATUTKSKGYCD, val);
    }

    /**
     * 得意先部門SEQNO（扱）を取得する
     * @return 得意先部門SEQNO（扱）
     */
    public String getHb14Atutksbmnseqno() {
        return (String) get(TBTHB14SKDOWN.ATUTKSBMNSEQNO);
    }

    /**
     * 得意先部門SEQNO（扱）を設定する
     * @param val 得意先部門SEQNO（扱）
     */
    public void setHb14Atutksbmnseqno(String val) {
        set(TBTHB14SKDOWN.ATUTKSBMNSEQNO, val);
    }

    /**
     * 得意先担当SEQNO（扱）を取得する
     * @return 得意先担当SEQNO（扱）
     */
    public String getHb14Atutkstntseqno() {
        return (String) get(TBTHB14SKDOWN.ATUTKSTNTSEQNO);
    }

    /**
     * 得意先担当SEQNO（扱）を設定する
     * @param val 得意先担当SEQNO（扱）
     */
    public void setHb14Atutkstntseqno(String val) {
        set(TBTHB14SKDOWN.ATUTKSTNTSEQNO, val);
    }

    /**
     * 受注NOを取得する
     * @return 受注NO
     */
    public String getHb14Jyutno() {
        return (String) get(TBTHB14SKDOWN.JYUTNO);
    }

    /**
     * 受注NOを設定する
     * @param val 受注NO
     */
    public void setHb14Jyutno(String val) {
        set(TBTHB14SKDOWN.JYUTNO, val);
    }

    /**
     * 受注明細NOを取得する
     * @return 受注明細NO
     */
    public String getHb14Jymeino() {
        return (String) get(TBTHB14SKDOWN.JYMEINO);
    }

    /**
     * 受注明細NOを設定する
     * @param val 受注明細NO
     */
    public void setHb14Jymeino(String val) {
        set(TBTHB14SKDOWN.JYMEINO, val);
    }

    /**
     * 売上明細NOを取得する
     * @return 売上明細NO
     */
    public String getHb14Urmeino() {
        return (String) get(TBTHB14SKDOWN.URMEINO);
    }

    /**
     * 売上明細NOを設定する
     * @param val 売上明細NO
     */
    public void setHb14Urmeino(String val) {
        set(TBTHB14SKDOWN.URMEINO, val);
    }

    /**
     * 請求原票NOを取得する
     * @return 請求原票NO
     */
    public String getHb14Gpyno() {
        return (String) get(TBTHB14SKDOWN.GPYNO);
    }

    /**
     * 請求原票NOを設定する
     * @param val 請求原票NO
     */
    public void setHb14Gpyno(String val) {
        set(TBTHB14SKDOWN.GPYNO, val);
    }

    /**
     * 受注通貨コードを取得する
     * @return 受注通貨コード
     */
    public String getHb14Jytsukacd() {
        return (String) get(TBTHB14SKDOWN.JYTSUKACD);
    }

    /**
     * 受注通貨コードを設定する
     * @param val 受注通貨コード
     */
    public void setHb14Jytsukacd(String val) {
        set(TBTHB14SKDOWN.JYTSUKACD, val);
    }

    /**
     * 請求時換算レートを取得する
     * @return 請求時換算レート
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Seikanrate() {
        return (BigDecimal) get(TBTHB14SKDOWN.SEIKANRATE);
    }

    /**
     * 請求時換算レートを設定する
     * @param val 請求時換算レート
     */
    public void setHb14Seikanrate(BigDecimal val) {
        set(TBTHB14SKDOWN.SEIKANRATE, val);
    }

    /**
     * レートタイプを取得する
     * @return レートタイプ
     */
    public String getHb14Ratetype() {
        return (String) get(TBTHB14SKDOWN.RATETYPE);
    }

    /**
     * レートタイプを設定する
     * @param val レートタイプ
     */
    public void setHb14Ratetype(String val) {
        set(TBTHB14SKDOWN.RATETYPE, val);
    }

    /**
     * 請求時換算年月日を取得する
     * @return 請求時換算年月日
     */
    public String getHb14Seikandate() {
        return (String) get(TBTHB14SKDOWN.SEIKANDATE);
    }

    /**
     * 請求時換算年月日を設定する
     * @param val 請求時換算年月日
     */
    public void setHb14Seikandate(String val) {
        set(TBTHB14SKDOWN.SEIKANDATE, val);
    }

    /**
     * 請求取料金（受注通貨）を取得する
     * @return 請求取料金（受注通貨）
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Torigakjy() {
        return (BigDecimal) get(TBTHB14SKDOWN.TORIGAKJY);
    }

    /**
     * 請求取料金（受注通貨）を設定する
     * @param val 請求取料金（受注通貨）
     */
    public void setHb14Torigakjy(BigDecimal val) {
        set(TBTHB14SKDOWN.TORIGAKJY, val);
    }

    /**
     * 請求取料金（円貨）を取得する
     * @return 請求取料金（円貨）
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Torigaken() {
        return (BigDecimal) get(TBTHB14SKDOWN.TORIGAKEN);
    }

    /**
     * 請求取料金（円貨）を設定する
     * @param val 請求取料金（円貨）
     */
    public void setHb14Torigaken(BigDecimal val) {
        set(TBTHB14SKDOWN.TORIGAKEN, val);
    }

    /**
     * 請求値引額（受注通貨）を取得する
     * @return 請求値引額（受注通貨）
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Nebigakjy() {
        return (BigDecimal) get(TBTHB14SKDOWN.NEBIGAKJY);
    }

    /**
     * 請求値引額（受注通貨）を設定する
     * @param val 請求値引額（受注通貨）
     */
    public void setHb14Nebigakjy(BigDecimal val) {
        set(TBTHB14SKDOWN.NEBIGAKJY, val);
    }

    /**
     * 請求値引額（円貨）を取得する
     * @return 請求値引額（円貨）
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Nebigaken() {
        return (BigDecimal) get(TBTHB14SKDOWN.NEBIGAKEN);
    }

    /**
     * 請求値引額（円貨）を設定する
     * @param val 請求値引額（円貨）
     */
    public void setHb14Nebigaken(BigDecimal val) {
        set(TBTHB14SKDOWN.NEBIGAKEN, val);
    }

    /**
     * 請求消費税額（円貨）を取得する
     * @return 請求消費税額（円貨）
     */
    @XmlElement(required = true)
    public BigDecimal getHb14Szeigaken() {
        return (BigDecimal) get(TBTHB14SKDOWN.SZEIGAKEN);
    }

    /**
     * 請求消費税額（円貨）を設定する
     * @param val 請求消費税額（円貨）
     */
    public void setHb14Szeigaken(BigDecimal val) {
        set(TBTHB14SKDOWN.SZEIGAKEN, val);
    }

    /**
     * 振替年月日を取得する
     * @return 振替年月日
     */
    public String getHb14Furidate() {
        return (String) get(TBTHB14SKDOWN.FURIDATE);
    }

    /**
     * 振替年月日を設定する
     * @param val 振替年月日
     */
    public void setHb14Furidate(String val) {
        set(TBTHB14SKDOWN.FURIDATE, val);
    }

    /**
     * 振替取消年月日を取得する
     * @return 振替取消年月日
     */
    public String getHb14Furitoridate() {
        return (String) get(TBTHB14SKDOWN.FURITORIDATE);
    }

    /**
     * 振替取消年月日を設定する
     * @param val 振替取消年月日
     */
    public void setHb14Furitoridate(String val) {
        set(TBTHB14SKDOWN.FURITORIDATE, val);
    }

    /**
     * 消費税区分を取得する
     * @return 消費税区分
     */
    public String getHb14Szeikbn() {
        return (String) get(TBTHB14SKDOWN.SZEIKBN);
    }

    /**
     * 消費税区分を設定する
     * @param val 消費税区分
     */
    public void setHb14Szeikbn(String val) {
        set(TBTHB14SKDOWN.SZEIKBN, val);
    }

    /**
     * 計上予定年月日を取得する
     * @return 計上予定年月日
     */
    public String getHb14Keiyodate() {
        return (String) get(TBTHB14SKDOWN.KEIYODATE);
    }

    /**
     * 計上予定年月日を設定する
     * @param val 計上予定年月日
     */
    public void setHb14Keiyodate(String val) {
        set(TBTHB14SKDOWN.KEIYODATE, val);
    }

    /**
     * 計上年月日を取得する
     * @return 計上年月日
     */
    public String getHb14Keidate() {
        return (String) get(TBTHB14SKDOWN.KEIDATE);
    }

    /**
     * 計上年月日を設定する
     * @param val 計上年月日
     */
    public void setHb14Keidate(String val) {
        set(TBTHB14SKDOWN.KEIDATE, val);
    }

    /**
     * ダウンロードファイルタイムスタンプを取得する
     * @return ダウンロードファイルタイムスタンプ
     */
    public String getHb14Filetimstmp() {
        return (String) get(TBTHB14SKDOWN.FILETIMSTMP);
    }

    /**
     * ダウンロードファイルタイムスタンプを設定する
     * @param val ダウンロードファイルタイムスタンプ
     */
    public void setHb14Filetimstmp(String val) {
        set(TBTHB14SKDOWN.FILETIMSTMP, val);
    }

    /**
     * 広告費明細反映日時を取得する
     * @return 広告費明細反映日時
     */
    public String getHb14Kkhmeitimstmp() {
        return (String) get(TBTHB14SKDOWN.KKHMEITIMSTMP);
    }

    /**
     * 広告費明細反映日時を設定する
     * @param val 広告費明細反映日時
     */
    public void setHb14Kkhmeitimstmp(String val) {
        set(TBTHB14SKDOWN.KKHMEITIMSTMP, val);
    }

}
