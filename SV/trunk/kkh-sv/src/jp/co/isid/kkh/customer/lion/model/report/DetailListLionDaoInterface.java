package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

public interface DetailListLionDaoInterface {

	/** �ėp�}�X�^�������� */
    DetailListLionCondition _cond = null;

	public List<DetailListLionVO> findDetailListLionByCondition(DetailListLionCondition cond) throws KKHException;

}
