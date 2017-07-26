package jp.co.isid.kkh.customer.lion.model.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.customer.lion.util.LionConstants;
import jp.co.isid.kkh.integ.tbl.TBTHB11WLTVK;
import jp.co.isid.kkh.integ.tbl.TBTHB12WLRDK;
import jp.co.isid.kkh.integ.tbl.TBTHBAMST;
import jp.co.isid.kkh.integ.util.KKHPoolConnect;
import jp.co.isid.kkh.model.KKHOracleModel;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.nj.exp.UserException;
import jp.co.isid.nj.integ.sql.AbstractRdbDao;
import jp.co.isid.nj.model.ModelUtils;

public class FindLionCodeItrDAO extends AbstractRdbDao {

	/** 汎用マスタ検索条件 */
	private FindLionCodeItrCondition _cond;

    //カードNo///////////////////////////////////////////////////////////////////////////////////////////
    /** 汎用マスタ：カードNO：テレビタイム */
    public static final String C_HBAMST_CARD_TV_TIME =  LionConstants.CardNo.TV_TIME.getCode();
    /** 汎用マスタ：カードNO：テレビローカル */
    public static final String C_HBAMST_CARD_TV_LOCAL =  LionConstants.CardNo.TV_LOCAL.getCode();
    /** 汎用マスタ：カードNO：ラジオタイム */
    public static final String C_HBAMST_CARD_RD_TIME =  LionConstants.CardNo.RD_TIME.getCode();
    /** 汎用マスタ：カードNO：ラジオローカル */
    public static final String C_HBAMST_CARD_RD_LOCAL =  LionConstants.CardNo.RD_LOCAL.getCode();
    /** 汎用マスタ：カードNO：スポット（テレビ、ラジオ） */
    public static final String C_HBAMST_CARD_SPOT =  LionConstants.CardNo.SPOT.getCode();
    /** 汎用マスタ：カードNO：新聞 */
    public static final String C_HBAMST_CARD_SHINBUN =  LionConstants.CardNo.SHINBUN.getCode();
    /** 汎用マスタ：カードNO：雑誌 */
    public static final String C_HBAMST_CARD_ZASHI =  LionConstants.CardNo.ZASHI.getCode();
    /** 汎用マスタ：カードNO：交通 */
    public static final String C_HBAMST_CARD_KOUTU =  LionConstants.CardNo.KOUTU.getCode();
    /** 汎用マスタ：カードNO：その他 */
    public static final String C_HBAMST_CARD_SONOTA =  LionConstants.CardNo.SONOTA.getCode();
    /** 汎用マスタ：カードNO：制作 */
    public static final String C_HBAMST_CARD_SEISAKUHI =  LionConstants.CardNo.SEISAKUHI.getCode();
    /** 汎用マスタ：カードNO：チラシ */
    public static final String C_HBAMST_CARD_LEAFLET =  LionConstants.CardNo.LEAFLET.getCode();
    /** 汎用マスタ：カードNO：サンプリング */
    public static final String C_HBAMST_CARD_SAMPLING =  LionConstants.CardNo.SAMPLING.getCode();
    /** 汎用マスタ：カードNO：BS・CS */
    public static final String C_HBAMST_CARD_BSCS =  LionConstants.CardNo.BSCS.getCode();
    /** 汎用マスタ：カードNO：インターネット */
    public static final String C_HBAMST_CARD_INTERNET =  LionConstants.CardNo.INTERNET.getCode();
    /** 汎用マスタ：カードNO：モバイル */
    public static final String C_HBAMST_CARD_MOBILE =  LionConstants.CardNo.MOBILE.getCode();
    /** 汎用マスタ：カードNO：事業費 */
    public static final String C_HBAMST_CARD_BUSINESSEXP =  LionConstants.CardNo.BUSINESSEXP.getCode();

	// 種別//////////////////////////////////////////////////////////////////////////////////////////////////
	/** 汎用マスタ：種別：新聞 */
	public static final String C_HBAMST_SYBT_SHINBUN = LionConstants.MastBaitaiShubetsu.SHINBUN.getCode();
	/** 汎用マスタ：種別：雑誌 */
	public static final String C_HBAMST_SYBT_ZASHI = LionConstants.MastBaitaiShubetsu.ZASHI.getCode();
	/** 汎用マスタ：種別：雑誌スペース */
	public static final String C_HBAMST_SYBT_ZASHI_SPACE = LionConstants.MastBaitaiShubetsu.ZASHI_SPACE.getCode();
	/** 汎用マスタ：種別：雑誌料金 */
	public static final String C_HBAMST_SYBT_ZASHI_RYOKIN = LionConstants.MastBaitaiShubetsu.ZASHI_RYOKIN.getCode();
	/** 汎用マスタ：種別：ラジオ局 */
	public static final String C_HBAMST_SYBT_RD = LionConstants.MastBaitaiShubetsu.RD_KYOKU.getCode();
	/** 汎用マスタ：種別：テレビ局 */
	public static final String C_HBAMST_SYBT_TV = LionConstants.MastBaitaiShubetsu.TV_KYOKU.getCode();
	/** 汎用マスタ：種別：県 */
	public static final String C_HBAMST_SYBT_KEN = LionConstants.MastBaitaiShubetsu.KEN.getCode();
	/** 汎用マスタ：種別：媒体区分 */
	public static final String C_HBAMST_SYBT_BAITAI_KBN = LionConstants.MastBaitaiShubetsu.BAITAI_KBN.getCode();
	/** 汎用マスタ：種別：インターネット */
	public static final String C_HBAMST_SYBT_INTERNET = LionConstants.MastBaitaiShubetsu.INTERNET.getCode();
	/** 汎用マスタ：種別：モバイル */
	public static final String C_HBAMST_SYBT_MOBILE = LionConstants.MastBaitaiShubetsu.MOBILE.getCode();

    //Field1コード///////////////////////////////////////////////////////////////////////////////////////////
    /** 制作1 */
    public static final String C_HBAMST_FIELD1_SEISAKU1 =  LionConstants.Field1Code.SEISAKU1.getCode();
    /** 制作2 */
    public static final String C_HBAMST_FIELD1_SEISAKU2 =  LionConstants.Field1Code.SEISAKU2.getCode();

	// 2017/06/20 ライオン対応 ITCOM K.SAKUMA Add Start
	/** インターネット */
	public static final String C_HBAMST_FIELD1_INTERNET = LionConstants.Field1Code.INTERNET.getCode();
	/** ソーシャルメディア */
	public static final String C_HBAMST_FIELD1_SOCIALMEDIA = LionConstants.Field1Code.SOCIALMEDIA.getCode();
	/** デジタル動画 */
	public static final String C_HBAMST_FIELD1_DIGITALMOVIE = LionConstants.Field1Code.DIGITALMOVIE.getCode();
	// 2017/06/20 ライオン対応 ITCOM K.SAKUMA Add End

	// 媒体コード/////////////////////////////////////////////////////////////////////////////////////////////
	/** TVスポット */
	public static final String C_HBAMST_BTCD_TV = LionConstants.BaitaiKbn.TV_SPOT.getCode();
	/** RDスポット */
	public static final String C_HBAMST_BTCD_RD = LionConstants.BaitaiKbn.RD_SPOT.getCode();

    /**
     * デフォルトコンストラクタ。
     */
    public FindLionCodeItrDAO() {
        super.setPoolConnectClass(KKHPoolConnect.class);
        super.setDBModelInterface(KKHOracleModel.getInstance());
        super.setBigDecimalMode(true);
    }

    /**
     * プライマリキーを返します。
     *
     * @return String[] プライマリキー
     */
    @Override
    public String[] getPrimryKeyNames() {
        return null;
    }

    /**
     * 更新日付フィールドを返します。
     *
     * @return String 更新日付フィールド
     */
    public String getTimeStampKeyName() {
        return null;
    }

    /**
     * テーブル名を返します。
     *
     * @return String テーブル名
     */
    @Override
    public String getTableName() {
        return null;
    }

    /**
     * テーブル列名を返します。
     *
     * @return String[] テーブル列名
     */
    @Override
    public String[] getTableColumnNames() {
          return null;
    }

    /**
     * デフォルトのSQL文を返します。
     *
     * @return String SQL文
     */
    @Override
    public String getSelectSQL() {
        return getSelectSQLForItem();
    }

    private String getSelectSQLForItem(){

        StringBuffer sql = new StringBuffer();

		// 新聞
		if (_cond.getCdNo().equals(C_HBAMST_CARD_SHINBUN)) {
			sql.append(" SELECT ");
			sql.append("  " + TBTHBAMST.FIELD1 + " AS VAL1 ");
			sql.append(" ," + TBTHBAMST.FIELD2 + " AS VAL2 ");
			sql.append(" FROM ");
			sql.append("  " + TBTHBAMST.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  AND ");
			// 新聞マスタ
			sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_SHINBUN + "' ");
			sql.append("  ORDER BY ");
			sql.append(TBTHBAMST.FIELD1);
		}

		// 雑誌
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_ZASHI)) {
			sql.append(" SELECT ");
			sql.append(" DISTINCT ");
			sql.append("  ZASSHI." + TBTHBAMST.FIELD1 + " AS VAL1 ");
			sql.append(" ,ZASSHI." + TBTHBAMST.FIELD2 + " AS VAL2 ");
			sql.append(" ,ZSPACE." + TBTHBAMST.FIELD1 + " AS VAL3 ");
			sql.append(" ,ZSPACE." + TBTHBAMST.FIELD2 + " AS VAL4 ");
			sql.append(" ,RYOKIN." + TBTHBAMST.INTVALUE1 + " ");
			sql.append(" FROM ");
			sql.append("  " + TBTHBAMST.TBNAME + " ZASSHI, " + TBTHBAMST.TBNAME + " ZSPACE, " + TBTHBAMST.TBNAME + " RYOKIN ");
			sql.append(" WHERE ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSKGYCD + " = ZSPACE." + TBTHBAMST.TKSKGYCD + " AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSBMNSEQNO + " = ZSPACE." + TBTHBAMST.TKSBMNSEQNO + " AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSTNTSEQNO + " = ZSPACE." + TBTHBAMST.TKSTNTSEQNO + " AND ");
			// 雑誌・雑誌スペース・料金マスタ
			sql.append(" ZASSHI." + TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI + "' AND ");
			sql.append(" ZSPACE." + TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI_SPACE + "' AND ");
			sql.append(" RYOKIN." + TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_ZASHI_RYOKIN + "' AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSKGYCD + " = RYOKIN." + TBTHBAMST.TKSKGYCD + " AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSBMNSEQNO + " = RYOKIN." + TBTHBAMST.TKSBMNSEQNO + " AND ");
			sql.append(" ZASSHI." + TBTHBAMST.TKSTNTSEQNO + " = RYOKIN." + TBTHBAMST.TKSTNTSEQNO + " AND ");
			sql.append(" ZASSHI." + TBTHBAMST.FIELD1 + " = RYOKIN." + TBTHBAMST.FIELD1 + " AND ");
			sql.append(" ZSPACE." + TBTHBAMST.FIELD1 + " = RYOKIN." + TBTHBAMST.FIELD2 + " ");
			sql.append("  ORDER BY ");
			sql.append(" ZASSHI." + TBTHBAMST.FIELD1);
		}

		// ラジオタイム・ラジオローカル
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_RD_TIME) || _cond.getCdNo().equals(C_HBAMST_CARD_RD_LOCAL)) {
			sql.append(" SELECT ");
			sql.append("  " + TBTHB12WLRDK.KYOKUCD + " AS VAL1 ");
			sql.append(" ," + TBTHB12WLRDK.KYOKUNAME + " AS VAL2 ");
			sql.append(" ," + TBTHB12WLRDK.KEIRETSU + " AS VAL3 ");
			sql.append(" FROM ");
			sql.append("  " + TBTHB12WLRDK.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHB12WLRDK.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHB12WLRDK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHB12WLRDK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  ");
			sql.append("  ORDER BY ");
			sql.append(TBTHB12WLRDK.KYOKUCD);
		}

		// スポット(テレビ・ラジオ)
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_SPOT)) {
			// テレビスポット
			if (_cond.getBtCd().equals(C_HBAMST_BTCD_TV)) {
				sql.append(" SELECT ");
				sql.append("  " + TBTHB11WLTVK.KYOKUCD + " AS VAL1 ");
				sql.append(" ," + TBTHB11WLTVK.KYOKUNAME + " AS VAL2 ");
				sql.append(" ," + TBTHB11WLTVK.KEIRETSU + " AS VAL3 ");
				sql.append(" FROM ");
				sql.append("  " + TBTHB11WLTVK.TBNAME + " ");
				sql.append(" WHERE ");
				sql.append(TBTHB11WLTVK.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
				sql.append(TBTHB11WLTVK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
				sql.append(TBTHB11WLTVK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
				sql.append("  ORDER BY ");
				sql.append(TBTHB11WLTVK.THYOJIJYUN);
			}
			// ラジオスポット
			else if (_cond.getBtCd().equals(C_HBAMST_BTCD_RD)) {
				sql.append(" SELECT ");
				sql.append("  " + TBTHB12WLRDK.KYOKUCD + " AS VAL1 ");
				sql.append(" ," + TBTHB12WLRDK.KYOKUNAME + " AS VAL2 ");
				sql.append(" ," + TBTHB12WLRDK.KEIRETSU + " AS VAL3 ");
				sql.append(" FROM ");
				sql.append("  " + TBTHB12WLRDK.TBNAME + " ");
				sql.append(" WHERE ");
				sql.append(TBTHB12WLRDK.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
				sql.append(TBTHB12WLRDK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
				sql.append(TBTHB12WLRDK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
				sql.append("  ORDER BY ");
				sql.append(TBTHB12WLRDK.KYOKUCD);
			}
		}

		// テレビタイム・テレビローカル・BSCS
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_TV_TIME) || _cond.getCdNo().equals(C_HBAMST_CARD_TV_LOCAL) || _cond.getCdNo().equals(C_HBAMST_CARD_BSCS)) {
			sql.append(" SELECT ");
			sql.append("  " + TBTHB11WLTVK.KYOKUCD + " AS VAL1 ");
			sql.append(" ," + TBTHB11WLTVK.KYOKUNAME + " AS VAL2 ");
			sql.append(" ," + TBTHB11WLTVK.KEIRETSU + " AS VAL3 ");
			sql.append(" FROM ");
			sql.append("  " + TBTHB11WLTVK.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHB11WLTVK.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHB11WLTVK.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHB11WLTVK.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' ");
			sql.append("  ORDER BY ");
			sql.append(TBTHB11WLTVK.THYOJIJYUN);
		}

		// 交通
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_KOUTU)) {
			sql.append(" SELECT ");
			sql.append("  " + TBTHBAMST.FIELD1 + " AS VAL1 ");
			sql.append(" ," + TBTHBAMST.FIELD2 + " AS VAL2 ");
			sql.append(" FROM ");
			sql.append("  " + TBTHBAMST.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  AND ");
			// 県マスタ
			sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_KEN + "' ");
			sql.append("  ORDER BY ");
			sql.append(TBTHBAMST.FIELD1);
		}

		// 制作
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_SEISAKUHI)) {
			sql.append(" SELECT ");
			sql.append("  " + TBTHBAMST.FIELD1 + " AS VAL1 ");
			sql.append(" ," + TBTHBAMST.FIELD2 + " AS VAL2 ");
			sql.append(" ," + TBTHBAMST.INTVALUE1 + " ");
			sql.append(" FROM ");
			sql.append("  " + TBTHBAMST.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  AND ");
			// 媒体区分マスタ
			sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BAITAI_KBN + "'  AND ");
			// 2017/06/05 ライオン対応 ITCOM A.Nakamura Mod Start
			// 媒体区分40、41以外を表示
			sql.append(TBTHBAMST.FIELD1 + " BETWEEN '" + C_HBAMST_FIELD1_SEISAKU1 + "' AND '" + C_HBAMST_FIELD1_SEISAKU2 + "' AND ");
			sql.append(TBTHBAMST.FIELD1 + " NOT IN ('40' ,'41') ");
			// sql.append(TBTHBAMST.FIELD1 + " BETWEEN '" + C_HBAMST_FIELD1_SEISAKU1 + "' AND '" + C_HBAMST_FIELD1_SEISAKU2 + "' ");
			// 2017/06/05 ライオン対応 ITCOM A.Nakamura Mod End
			sql.append("  ORDER BY ");
			sql.append(TBTHBAMST.FIELD1);
		}
		// 2017/06/20 ライオン対応 ITCOM K.SAKUMA Mod Start
		// インターネット(媒体区分押下時)
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_INTERNET)) {
			sql.append(" SELECT ");
			sql.append("  " + TBTHBAMST.FIELD1 + " AS VAL1 ");
			sql.append(" ," + TBTHBAMST.FIELD2 + " AS VAL2 ");
			sql.append(" FROM ");
			sql.append("  " + TBTHBAMST.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  AND ");
			// インターネットマスタ
			// sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_INTERNET + "' ");
			// 媒体区分マスタ
			sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BAITAI_KBN + "'  AND ");
			sql.append(TBTHBAMST.FIELD1 + " IN ('" + C_HBAMST_FIELD1_INTERNET + "','" + C_HBAMST_FIELD1_SOCIALMEDIA + "','" + C_HBAMST_FIELD1_DIGITALMOVIE + "') ");
			sql.append("  ORDER BY ");
			sql.append(TBTHBAMST.FIELD1);
		}
		// インターネット(局誌コード押下時)
		// else if( _cond.getCdNo().equals(C_HBAMST_CARD_INTERNET) ){
		// sql.append(" SELECT ");
		// sql.append(" " + TBTHBAMST.FIELD1 + " AS VAL1 ");
		// sql.append(" ," + TBTHBAMST.FIELD2 + " AS VAL2 ");
		// sql.append(" FROM ");
		// sql.append(" " + TBTHBAMST.TBNAME + " ");
		// sql.append(" WHERE ");
		// sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "' AND ");
		// sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "' AND ");
		// sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "' AND ");
		// //インターネットマスタ
		// //sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_INTERNET + "' ");
		// sql.append(" ORDER BY ");
		// sql.append(TBTHBAMST.FIELD1);
		// }
		// 2017/06/20 ライオン対応 ITCOM K.SAKUMA Mod End
		// モバイル
		else if (_cond.getCdNo().equals(C_HBAMST_CARD_MOBILE)) {
			sql.append(" SELECT ");
			sql.append("  " + TBTHBAMST.FIELD1 + " AS VAL1 ");
			sql.append(" ," + TBTHBAMST.FIELD2 + " AS VAL2 ");
			sql.append(" FROM ");
			sql.append("  " + TBTHBAMST.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  AND ");
			// モバイルマスタ
			sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_MOBILE + "' ");
			sql.append("  ORDER BY ");
			sql.append(TBTHBAMST.FIELD1);
		}

		else {
			sql.append(" SELECT ");
			sql.append("  " + TBTHBAMST.FIELD1 + " AS VAL1 ");
			sql.append(" ," + TBTHBAMST.FIELD2 + " AS VAL2 ");
			sql.append(" ," + TBTHBAMST.INTVALUE1 + " ");
			sql.append(" FROM ");
			sql.append("  " + TBTHBAMST.TBNAME + " ");
			sql.append(" WHERE ");
			sql.append(TBTHBAMST.TKSKGYCD + " = '" + _cond.getTksKgyCd() + "'  AND ");
			sql.append(TBTHBAMST.TKSBMNSEQNO + " = '" + _cond.getTksBmnSeqNo() + "'  AND ");
			sql.append(TBTHBAMST.TKSTNTSEQNO + " = '" + _cond.getTksTntSeqNo() + "'  AND ");
			sql.append(TBTHBAMST.SYBT + " = '" + C_HBAMST_SYBT_BAITAI_KBN + "'  AND ");
			sql.append(TBTHBAMST.FIELD1 + " IN ('13','50','51') ");
			sql.append("  ORDER BY ");
			sql.append(TBTHBAMST.FIELD1);
		}

		return sql.toString();
	}

	/**
	 * 汎用マスタの検索を行います。
	 *
	 * @return テーブルマスタVOリスト
	 * @throws UserException データアクセス中にエラーが発生した場合。
	 */
	@SuppressWarnings("unchecked")
	public List<FindLionCodeItrVO> findLionCodeItrByCondition(FindLionCodeItrCondition cond) throws KKHException {

		super.setModel(new FindLionCodeItrVO());

		try {
			_cond = cond;
			return super.find();
		} catch (UserException e) {
			throw new KKHException(e.getMessage(), "BD-E0002");
		}
	}

	/**
	 * Modelの生成を行う<br>
	 * 検索結果のVOのKEYが大文字のため変換処理を行う<br>
	 * AbstractRdbDaoのcreateFindedModelInstancesをオーバーライド<br>
	 *
	 * @param hashList List 検索結果
	 * @return List<CommonCodeMasterVO> 変換後の検索結果
	 */
	@Override
	protected List<FindLionCodeItrVO> createFindedModelInstances(List hashList) {
		List<FindLionCodeItrVO> list = new ArrayList<FindLionCodeItrVO>();
		if (getModel() instanceof FindLionCodeItrVO) {
			for (int i = 0; i < hashList.size(); i++) {
				Map result = (Map) hashList.get(i);
				FindLionCodeItrVO vo = new FindLionCodeItrVO();
				// マスタ１～４まで動的
				vo.setVal1((String) result.get(FindLionCodeItrVO.VAL1.toUpperCase()));
				vo.setVal2((String) result.get(FindLionCodeItrVO.VAL2.toUpperCase()));
				vo.setVal3((String) result.get(FindLionCodeItrVO.VAL3.toUpperCase()));
				vo.setVal4((String) result.get(FindLionCodeItrVO.VAL4.toUpperCase()));
				vo.setIntvalue1((BigDecimal) result.get(TBTHBAMST.INTVALUE1.toUpperCase()));

				// 検索結果直後の状態にする
				ModelUtils.copyMemberSearchAfterInstace(vo);
				list.add(vo);
			}
		}

		return list;
	}

}
