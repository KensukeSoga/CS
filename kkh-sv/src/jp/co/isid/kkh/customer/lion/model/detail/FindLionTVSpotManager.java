package jp.co.isid.kkh.customer.lion.model.detail;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotCondition;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotDAO;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotDAOFactory;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotResult;
import jp.co.isid.kkh.customer.lion.model.detail.FindLionTVSpotVO;
import jp.co.isid.kkh.customer.lion.model.master.FindTvKMastCondition;
import jp.co.isid.kkh.customer.lion.model.master.FindTvKMastDAO;
import jp.co.isid.kkh.customer.lion.model.master.FindTvKMastDAOFactory;
import jp.co.isid.kkh.customer.lion.model.master.FindTvKMastVO;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * ライオンTVSpotデータ取得マネージャー
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/03/05 JSE Hitoshi Sasaki)<BR>
 * </P>
 *
 * @author JSE Hitoshi Sasaki
 */
public class FindLionTVSpotManager {

	/** シングルトンインスタンス */
	private static FindLionTVSpotManager _manager = new FindLionTVSpotManager();

	/**
	 * シングルトンの為、インスタンス化を禁止します。
	 */
	private FindLionTVSpotManager() {
	}

	/**
	 * ライオンTVSpotデータソート用クラス
	 */
	private class TVSpotComparator implements Comparator<FindLionTVSpotVO>
	{
		public int compare(FindLionTVSpotVO arg0, FindLionTVSpotVO arg1)
		{
			int retval = 0;

			// 地区表示順
			retval = compareTo(arg0.getTHYOJIJYUN(), arg1.getTHYOJIJYUN());

			if (retval != 0)
			{
				return retval;
			}

			// 表示順
			retval = compareTo(arg0.getHYOJIJYUN(), arg1.getHYOJIJYUN());

			if (retval != 0)
			{
				return retval;
			}

			// Climaxスポット引合NO
			retval = compareTo(arg0.getSHK_NO(), arg1.getSHK_NO());

			if (retval != 0)
			{
				return retval;
			}

			// 放送局コード
			retval = compareTo(arg0.getKYK_CD(), arg1.getKYK_CD());

			if (retval != 0)
			{
				return retval;
			}

			// 局案NO
			retval = compareTo(arg0.getKYKAN_NO(), arg1.getKYKAN_NO());

			if (retval != 0)
			{
				return retval;
			}

			// 時間枠NO
			retval = compareTo(arg0.getJWK_NO(), arg1.getJWK_NO());

			if (retval != 0)
			{
				return retval;
			}

			return 0;
		}

		public int compareTo( String val1, String val2 )
		{
			int retval = 0;

			if ((val1 == null) && (val2 == null))
			{
				// 両方ともnullの場合は同一と判定
				return 0;
			}
			else if (val1 == null)
			{
				// 片方だけnullの場合はnull側を大なりと判定
				return 1;
			}
			else if (val2 == null)
			{
				// 片方だけnullの場合はnull側を大なりと判定
				return -1;
			}
			else if (val1.equals("") && val2.equals(""))
			{
				// 両方とも空文字の場合は同一と判定
				return 0;
			}
			else if (val1.equals(""))
			{
				// 片方だけ空文字の場合は空文字側を大なりと判定
				return 1;
			}
			else if (val2.equals(""))
			{
				// 片方だけ空文字の場合は空文字側を大なりと判定
				return -1;
			}
			else
			{
				// その他は文字コードで判定
				retval = val1.compareTo(val2);
			}

			return retval;
		}
	}

	/**
	 * インスタンスを返します。
	 *
	 * @return インスタンス
	 */
	public static FindLionTVSpotManager getInstance() {
		return _manager;
	}

	/**
	 * ライオンTVSpotデータを検索します。
	 *
	 * @return FindLionTVSpotResult ライオンTVSpotデータ取得結果
	 * @throws KKHException
	 *             処理中にエラーが発生した場合
	 */
	public FindLionTVSpotResult findByCondition(FindLionTVSpotCondition cond) throws KKHException {

		// 高速化の為にマスタとの結合を当メソッド内で行う

		// TVSPOTデータの取得

		FindLionTVSpotResult result = new FindLionTVSpotResult();

		FindLionTVSpotDAO dao = FindLionTVSpotDAOFactory.createDAO();

		List<FindLionTVSpotVO> list = dao.findFindLionTVSpotByCondition(cond);


		// ライオン局マスタの取得

		FindTvKMastCondition cond2 = new FindTvKMastCondition();

		cond2.setEsqId(cond.getEsqId());

		cond2.setEgCd(cond.getEgCd());

		cond2.setTksKgyCd(cond.getTksKgyCd());

		cond2.setTksBmnSeqNo(cond.getBmncd());

		cond2.setTksTntSeqNo(cond.getTntcd());

		cond2.setYm(cond.getYM());

		cond2.setKyokucd("");

		cond2.setKigou("");

		cond2.setKeiretsu("");

		cond2.setTiku("");

		FindTvKMastDAO dao2 = FindTvKMastDAOFactory.createFindTvKMastDAO();

		List<FindTvKMastVO> list2 = dao2.findTvKMastByCondition(cond2);


		// TVSPOTデータにライオン局マスタのデータを付与

		for (FindLionTVSpotVO ts : list)
		{
			for (FindTvKMastVO tkm : list2)
			{
				if (!ts.getKYK_CD().equals(tkm.getKigou()))
				{
					continue;
				}

//				// 地区コード
//				ts.setTIKU(tkm.getTiku());
//
//				// 放送局コード
//				ts.setKYOKUCD(tkm.getKyokuCd());
//
//				// 放送局名称
//				ts.setKYOKUNAME(tkm.getKyokuName());
//
//				// 地区表示順
//				ts.setTHYOJIJYUN(tkm.getTHyojiJyun());
//
//				// 表示順
//				ts.setHYOJIJYUN(tkm.getHyojijyun());

				// 地区コード
				if (tkm.getTiku().equals(""))
				{
				    ts.setTIKU("00");
				}
				else
				{
				    ts.setTIKU(tkm.getTiku());
				}

                // 放送局コード
                ts.setKYOKUCD(tkm.getKyokuCd());

                // 放送局名称
                ts.setKYOKUNAME(tkm.getKyokuName());

                // 地区表示順
                if (tkm.getTHyojiJyun().equals(""))
                {
                    ts.setTHYOJIJYUN("000");
                }
                else
                {
                    ts.setTHYOJIJYUN(tkm.getTHyojiJyun());
                }

                // 表示順
                if (tkm.getHyojijyun().equals(""))
                {
                    ts.setHYOJIJYUN("0");
                }
                else
                {
                    ts.setHYOJIJYUN(tkm.getHyojijyun());
                }

				break;
			}
		}


		// TVSPOTデータの再ソート

		Collections.sort(list, new TVSpotComparator());


		// 取得結果の設定
		result.setFindLionTVSpot(list);


		return result;
	}
}
