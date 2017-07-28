package jp.co.isid.kkh.customer.ash.model.detail;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * キー局の番組コードのManager
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2014/08/20 HLC S.Jang)<BR>
 * </P>
 *
 * @author HLC 張(Jang)
 */
public class FindKeyKyokuBangumiCdManager {

    /** シングルトンインスタンス */
    private static FindKeyKyokuBangumiCdManager _manager = new FindKeyKyokuBangumiCdManager();

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static FindKeyKyokuBangumiCdManager getInstance() {
        return _manager;
    }

    /**
     * キー局の番組コードのデータを検索します。
     *
     * @return FindKeyKyokuBangumiCdResult 汎用マスタ検索データ
     * @throws KKHException
     *             処理中にエラーが発生した場合
     */
    public FindKeyKyokuBangumiCdResult findKeyKyokuBangumiCd(
            FindKeyKyokuBangumiCdCondition cond) throws KKHException {
        FindKeyKyokuBangumiCdDAO dao = FindKeyKyokuBangumiCdDAOFactory
                .createFindKeyKyokuBangumiCdaDAO();
        FindKeyKyokuBangumiCdResult result = new FindKeyKyokuBangumiCdResult();

        List<FindKeyKyokuBangumiCdVO> bangumiCdVoList = dao
                .findKeyKyokuBangumiCd(cond);
        result.setBangumiCdList(bangumiCdVoList);

        return result;
    }

}
