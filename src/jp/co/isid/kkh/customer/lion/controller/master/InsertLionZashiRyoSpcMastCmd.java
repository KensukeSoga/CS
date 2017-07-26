package jp.co.isid.kkh.customer.lion.controller.master;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterDataInsertVO;
import jp.co.isid.kkh.model.master.MasterDataVO;
import jp.co.isid.kkh.customer.lion.model.master.InsertLionZashiRyoSpcMastResult;
import jp.co.isid.kkh.customer.lion.model.master.InsertLionZashiRyoSpcMastVO;
import jp.co.isid.kkh.customer.lion.model.master.LionManager;
import jp.co.isid.kkh.customer.lion.model.master.UpdateLionZashiRyoSpcMastCondition;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * マスタデータ登録コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/03/07 JSE A.Naito)<BR>
 * </P>
 *
 * @author JSE A.Naito
 */
public class InsertLionZashiRyoSpcMastCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** マスタデータ登録処理用VO */
    private InsertLionZashiRyoSpcMastVO _vo;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * マスタデータ登録処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        LionManager manager = LionManager.getInstance();

        UpdateLionZashiRyoSpcMastCondition mastercondition = new UpdateLionZashiRyoSpcMastCondition();
        mastercondition.setEgCd(_vo.getEgCd());
        mastercondition.setTksKgyCd(_vo.getTksKgyCd());
        mastercondition.setTksBmnSeqNo(_vo.getTksBmnSeqNo());
        mastercondition.setTksTntSeqNo(_vo.getTksTntSeqNo());
        mastercondition.setSybt(_vo.get_sybt());
        mastercondition.setZashiCd(_vo.get_zashiCd());

        //削除開始
        manager.deleteLionZashiRyoSpcMastByCondition(mastercondition);

        //Insert開始
        if (_vo.getMasterData() != null) {
            List<MasterDataInsertVO> insertVOList = new ArrayList<MasterDataInsertVO>();
            insertVOList =  editDefineInsertVo(_vo,_vo.get_sybt(),_vo.get_zashiCd());

            manager.insertLionZashiRyoSpcMast(insertVOList);
        }
        // 正常終了
        getResult().set(RESULT_KEY, new InsertLionZashiRyoSpcMastResult());

    }

    /**
     * マスタデータ登録VOの設定
     *
     * @param vo マスタデータ登録VO
     */
    public void setInsertLionZashiRyoSpcMastVO(InsertLionZashiRyoSpcMastVO vo) {
        _vo = vo;
    }

    /**
     * 実行結果を返します。
     *
     * @return 実行結果
     */
    public InsertLionZashiRyoSpcMastResult getInsertLionZashiRyoSpcMastResult() {
        return (InsertLionZashiRyoSpcMastResult) super.getResult().get(RESULT_KEY);
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
//			if (_vo.getMasterData() == null && _vo.get_maxupdate() == DateFormat.getDateInstance().parse("1000/01/01 01:01:01")) {
//				throw new KKHException("パラメータ指定エラー", "BD-E0001");
//			}
//		} catch (ParseException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//	}

//    /**
//     * エラー情報生成
//     *
//     * @param message メッセージ
//     * @param errorID エラーコード
//     * @return エラー情報
//     */
//    private ErrorInfo createErrorInfo(String message, String errorID) {
//
//        ErrorInfo errorInfo = new ErrorInfo();
//        errorInfo.setError(true);
//        errorInfo.setErrorCode(errorID);
//        List<String> list = new ArrayList<String>();
//        list.add(message);
//        errorInfo.setNote(list);
//        return errorInfo;
//    }

    private List<MasterDataInsertVO> editDefineInsertVo(InsertLionZashiRyoSpcMastVO masterRegisterVO, String Sybt, String zashiCd)
    {
        List<MasterDataInsertVO> insertVOList = new ArrayList<MasterDataInsertVO>();

        List<MasterDataVO> mstdata = masterRegisterVO.getMasterData();

        for(MasterDataVO mstvo : mstdata)
        {
            MasterDataInsertVO addrow = new MasterDataInsertVO();
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
            addrow.setSybt(Sybt);
            addrow.setField1(zashiCd);
            addrow.setField2(mstvo.getColumn2());
            addrow.setField3(mstvo.getColumn3());
            addrow.setField4(mstvo.getColumn4());
            addrow.setField5(mstvo.getColumn5());
            addrow.setField6(mstvo.getColumn6());
            addrow.setField7(mstvo.getColumn7());
            addrow.setField8(mstvo.getColumn8());
            addrow.setField9(mstvo.getColumn9());
            addrow.setField10(mstvo.getColumn10());
            addrow.setField11(mstvo.getColumn11());
            addrow.setField12(mstvo.getColumn12());
            addrow.setField13(mstvo.getColumn13());
            addrow.setField14(mstvo.getColumn14());
            addrow.setField15(mstvo.getColumn15());
            addrow.setField16(mstvo.getColumn16());
            addrow.setField17(mstvo.getColumn17());
            addrow.setField18(mstvo.getColumn18());
            addrow.setField19(mstvo.getColumn19());
            addrow.setField20(mstvo.getColumn20());
            addrow.setIntValue1(toBigDecimal(mstvo.getColumn21()));
            addrow.setIntValue2(toBigDecimal(mstvo.getColumn22()));
            addrow.setIntValue3(toBigDecimal(mstvo.getColumn23()));
            addrow.setIntValue4(toBigDecimal(mstvo.getColumn24()));
            addrow.setIntValue5(toBigDecimal(mstvo.getColumn25()));
            addrow.setIntValue6(toBigDecimal(mstvo.getColumn26()));
            addrow.setIntValue7(toBigDecimal(mstvo.getColumn27()));
            addrow.setIntValue8(toBigDecimal(mstvo.getColumn28()));
            addrow.setIntValue9(toBigDecimal(mstvo.getColumn29()));
            addrow.setIntValue10(toBigDecimal(mstvo.getColumn30()));

            insertVOList.add(addrow);
        }

        return insertVOList;
    }

    /**
     * StringからBigDecimalに変換
     *
     * @param str 変換前文字列
     * @return 変換後数値
     */
    private BigDecimal toBigDecimal(String str) {

        // 未設定の場合
        if (StringUtil.isBlank(str)) {
            return null;
        }

        return new BigDecimal(str);
    }

}
