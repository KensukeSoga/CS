package jp.co.isid.kkh.customer.lion.controller.master;

import java.util.ArrayList;
import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.customer.lion.model.master.LionDataCondition;
import jp.co.isid.kkh.customer.lion.model.master.LionManager;
import jp.co.isid.kkh.customer.lion.model.master.LionRegisterResult;
import jp.co.isid.kkh.customer.lion.model.master.LionTvMastDataInsertVO;
import jp.co.isid.kkh.customer.lion.model.master.LionTvMastDataVO;
import jp.co.isid.kkh.customer.lion.model.master.LionTvMastRegisterVO;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * マスタデータ登録コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/11/11 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class LionTvMastRegisterCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** マスタデータ登録処理用VO */
    private LionTvMastRegisterVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * マスタデータ登録処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        LionManager manager = LionManager.getInstance();

        LionDataCondition mastercondition = new LionDataCondition();
        mastercondition.setEgCd(_vo.getEgCd());
        mastercondition.setTksKgyCd(_vo.getTksKgyCd());
        mastercondition.setTksBmnSeqNo(_vo.getTksBmnSeqNo());
        mastercondition.setTksTntSeqNo(_vo.getTksTntSeqNo());

        //削除開始
        manager.deleteLionTvMastDataByCondition(mastercondition);

        //Insert開始
        if (_vo.getLionData() != null) {
            List<LionTvMastDataInsertVO> insertVOList = new ArrayList<LionTvMastDataInsertVO>();
            insertVOList =  editDefineInsertVo(_vo,_vo.get_sybt());

            manager.registerLionTvMast(insertVOList);
        }

        // 正常終了
        getResult().set(RESULT_KEY, new LionRegisterResult());
    }

    /**
     * マスタデータ登録VOの設定
     *
     * @param vo マスタデータ登録VO
     */
    public void setLionTvMastRegisterVO(LionTvMastRegisterVO vo) {
        _vo = vo;
    }

    /**
     * 実行結果を返します。
     *
     * @return 実行結果
     */
    public LionRegisterResult getLionRegisterResult() {
        return (LionRegisterResult) super.getResult().get(RESULT_KEY);
    }

//	/**
//	 * パラメータ入力チェック
//	 *
//	 * @throws KKHException パラメータ指定エラーの場合
//	 */
//	private void checkInput() throws KKHException {
//
//		//パラメータの必須チェック
//		if (StringUtil.isBlank(_vo.getEsqId())) {
//			throw new KKHException("パラメータ指定エラー", "BD-E0001");
//		}
//		if (StringUtil.isBlank(_vo.getAplId())) {
//			throw new KKHException("パラメータ指定エラー", "BD-E0001");
//		}
//		if (StringUtil.isBlank(_vo.getEgCd())) {
//			throw new KKHException("パラメータ指定エラー", "BD-E0001");
//		}
//		if (StringUtil.isBlank(_vo.getTksKgyCd())) {
//			throw new KKHException("パラメータ指定エラー", "BD-E0001");
//		}
//		if (StringUtil.isBlank(_vo.getTksBmnSeqNo())) {
//			throw new KKHException("パラメータ指定エラー", "BD-E0001");
//		}
//		if (StringUtil.isBlank(_vo.getTksTntSeqNo())) {
//			throw new KKHException("パラメータ指定エラー", "BD-E0001");
//		}
//		if (StringUtil.isBlank(_vo.getMasterKey())) {
//			throw new KKHException("パラメータ指定エラー", "BD-E0001");
//		}
//		try {
//			if (_vo.getLionData() == null && _vo.get_maxupdate() == DateFormat.getDateInstance().parse("1000/01/01 01:01:01")) {
//				throw new KKHException("パラメータ指定エラー", "BD-E0001");
//			}
//		} catch (ParseException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//	}

//	/**
//	 * エラー情報生成
//	 *
//	 * @param message メッセージ
//	 * @param errorID エラーコード
//	 * @return エラー情報
//	 */
//	private ErrorInfo createErrorInfo(String message, String errorID) {
//
//		ErrorInfo errorInfo = new ErrorInfo();
//		errorInfo.setError(true);
//		errorInfo.setErrorCode(errorID);
//		List<String> list = new ArrayList<String>();
//		list.add(message);
//		errorInfo.setNote(list);
//		return errorInfo;
//	}

    private List<LionTvMastDataInsertVO> editDefineInsertVo(LionTvMastRegisterVO masterRegisterVO, String Sybt)
    {
        List<LionTvMastDataInsertVO> insertVOList = new ArrayList<LionTvMastDataInsertVO>();

        List<LionTvMastDataVO> mstdatavo = masterRegisterVO.getLionData();

        for(LionTvMastDataVO mstvo : mstdatavo)
        {
            LionTvMastDataInsertVO addrow = new LionTvMastDataInsertVO();
            addrow.setTrkTimStmp(mstvo.getTrkTimStmp());
            addrow.setTrkPl(mstvo.getTrkPl());
            addrow.setTrkTnt(mstvo.getTrkTnt());
            addrow.setUpdTimStmp(mstvo.getUpdTimStmp());
            addrow.setUpdaPl(mstvo.getUpdaPl());
            addrow.setUpdTnt(mstvo.getUpdTnt());
            addrow.setEgCd(mstvo.getEgCd());
            addrow.setTksKgyCd(mstvo.getTksKgyCd());
            addrow.setTksBmnSeqNo(mstvo.getTksBmnSeqNo());
            addrow.setTksTntSeqNo(mstvo.getTksTntSeqNo());
            addrow.setBanCd(mstvo.getBanCd());
            addrow.setBanName(mstvo.getBanName());
            addrow.setHkyokuCd(mstvo.getHkyokuCd());
            addrow.setSeisakuhi(mstvo.getSeisakuhi());
            addrow.setHyojijyun(mstvo.getHyojijyun());
            addrow.setTanka(mstvo.getTanka());
            addrow.setType2(mstvo.getType2());
            insertVOList.add(addrow);
        }

        return insertVOList;
    }

//	/**
//	 * StringからBigDecimalに変換
//	 *
//	 * @param str 変換前文字列
//	 * @return 変換後数値
//	 */
//	private BigDecimal toBigDecimal(String str) {
//
//		// 未設定の場合
//		if (StringUtil.isBlank(str)) {
//			return null;
//		}
//
//		return new BigDecimal(str);
//	}

}
