package jp.co.isid.kkh.integ.tbl;

/**
*
* <P>ログマスタ</P>
* <P>
* <B>修正履歴</B><BR>
* ・新規作成(2011/11/11 IP H.Shimizu)<BR>
* </P>
* @author
*/
public class TBTHB6LOG {

	/**
	 * インスタンス生成禁止
	 */
	private TBTHB6LOG(){
	}

	/** テーブル名 */
	public static final String TBNAME = "THB6LOG";

	/** 登録タイムスタンプ(TRKTIMSTMP) */
	public static final String TRKTIMSTMP = "HB6_TRKTIMSTMP";

	/** 登録プログラム(TRKPL) */
	public static final String TRKPL = "HB6_TRKPL";

	/** 登録担当者(TRKTNT) */
	public static final String TRKTNT = "HB6_TRKTNT";

	/** 更新タイムスタンプ(UPDTIMSTMP) */
	public static final String UPDTIMSTMP = "HB6_UPDTIMSTMP";

	/** 更新プログラム(UPDAPL) */
	public static final String UPDAPL = "HB6_UPDAPL";

	/** 更新担当者(UPDTNT   ) */
	public static final String UPDTNT    = "HB6_UPDTNT";

	/** 営業所（取）コード(EGCD) */
	public static final String EGCD = "HB6_EGCD";

	/** 得意先企業コード(TKSKGYCD) */
	public static final String TKSKGYCD = "HB6_TKSKGYCD";

	/** 得意先部門SEQNO(TKSBMNSEQNO) */
	public static final String TKSBMNSEQNO = "HB6_TKSBMNSEQNO";

	/** 得意先担当SEQNO(TKSTNTSEQNO) */
	public static final String TKSTNTSEQNO = "HB6_TKSTNTSEQNO";

	/** 種別(SYBT) */
	public static final String SYBT = "HB6_SYBT";

	/** 機能ID(KINOID) */
	public static final String KINOID = "HB6_KINOID";

	/** 区分(KBN) */
	public static final String KBN = "HB6_KBN";

	/** 内容(DESC) */
	public static final String DESC = "HB6_DESC";

	/** エラー内容(DESC) */
	public static final String ERRDESC = "HB6_ERRDESC";

	/** 更新日時(UPDDATE) */
	public static final String UPDDATE = "HB6_UPDDATE";

	/** 担当者名(TANNAME) */
	public static final String TANNAME = "HB6_TANNAME";

	/** 送受信種別(RECEPTIONKIND) */
	public static final String RECEPTIONKIND = "HB6_RECEPTIONKIND";

	/** 送信ステータス(STATUS) */
	public static final String STATUS = "HB6_STATUS";

}
