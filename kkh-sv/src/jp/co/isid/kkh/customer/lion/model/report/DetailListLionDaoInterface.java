package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

public interface DetailListLionDaoInterface {

	/** 汎用マスタ検索条件 */
    DetailListLionCondition _cond = null;

	public List<DetailListLionVO> findDetailListLionByCondition(DetailListLionCondition cond) throws KKHException;

}
