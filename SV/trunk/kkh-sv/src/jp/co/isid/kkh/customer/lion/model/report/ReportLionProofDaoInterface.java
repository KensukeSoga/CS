package jp.co.isid.kkh.customer.lion.model.report;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;

public interface ReportLionProofDaoInterface {

	/** �ėp�}�X�^�������� */
	ReportLionCondition _cond=null;

	public List<ReportLionVO> findReportLionByCondition(ReportLionCondition cond) throws KKHException;

}
