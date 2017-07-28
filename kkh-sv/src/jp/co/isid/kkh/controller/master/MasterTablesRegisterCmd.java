package jp.co.isid.kkh.controller.master;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.master.MasterCondition;
import jp.co.isid.kkh.model.master.MasterDataCondition;
import jp.co.isid.kkh.model.master.MasterDataInsertVO;
import jp.co.isid.kkh.model.master.MasterDataVO;
import jp.co.isid.kkh.model.master.MasterManager;
import jp.co.isid.kkh.model.master.MasterRegisterResult;
import jp.co.isid.kkh.model.master.MasterRegisterVO;
import jp.co.isid.kkh.model.master.MasterResult;
import jp.co.isid.kkh.model.master.MasterVO;
import jp.co.isid.kkh.service.base.ErrorInfo;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;
import org.springframework.util.StringUtils;

/**
 * <P>
 * 複数マスタデータ登録コマンド
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/04/25 IP K.Kawamura)<BR>
 * </P>
 *
 * @author
 */
public class MasterTablesRegisterCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** マスタデータ登録処理用VO */
    private MasterRegisterVO _vo1;
    private MasterRegisterVO _vo2;

    /** 実行結果キー */
    private static final String RESULT_KEY = "RESULT_KEY";

    /**
     * マスタデータ登録処理を実行します。
     *
     * @throws KKHException 登録に失敗した場合
     */
    public void execute() throws KKHException {

        MasterManager manager = MasterManager.getInstance();

        // 入力チェック
        checkInput(_vo1);
        checkInput(_vo2);

        // マスタ定義取得条件を設定
        MasterCondition masterCondition1 = new MasterCondition();
        MasterCondition masterCondition2 = new MasterCondition();
        setMasterCondition(masterCondition1, _vo1);
        setMasterCondition(masterCondition2, _vo2);

        // マスタ定義の取得
        MasterResult masterResult1 = manager.findMasterDefineByCondition(masterCondition1);
        MasterResult masterResult2 = manager.findMasterDefineByCondition(masterCondition2);
        List<MasterVO> masterKindList1 = masterResult1.getMasterKind();
        List<MasterVO> masterKindList2 = masterResult2.getMasterKind();

        // マスタデータ取得・削除条件を設定
        MasterDataCondition masterDataCondition1 = new MasterDataCondition();
        MasterDataCondition masterDataCondition2 = new MasterDataCondition();
        setMasterDataCondition(masterDataCondition1, _vo1, masterKindList1.get(0));
        setMasterDataCondition(masterDataCondition2, _vo2, masterKindList2.get(0));

        // マスタデータの更新タイムスタンプ（最大値）を取得
        Date newTimStmp = manager.findMasterUpdTimStmpMaxByCondition(masterDataCondition1);

        // 現在のタイムスタンプの最大値を取得
        Date currentTimStmp = _vo1.get_maxupdate();

        if(newTimStmp != null)
        {
            // 排他チェック
            ErrorInfo errorInfo = checkExclusion(newTimStmp, currentTimStmp);
            if (errorInfo != null) {
                MasterRegisterResult result = new MasterRegisterResult();
                result.setErrorInfo(errorInfo);
                getResult().set(RESULT_KEY, result);
                return;
            }
        }

        // マスタデータ1の削除
        manager.deleteMasterDataByCondition(masterDataCondition1);

        if (_vo1.getMasterData() != null) {
            // マスタデータ1の編集
            List<MasterDataInsertVO> insertVOList1 = new ArrayList<MasterDataInsertVO>();
            insertVOList1 = editMasterDataInsertVO(_vo1, masterKindList1.get(0), masterResult1.getMasterItem());

            // マスタデータ1の登録
            manager.registerMaster(insertVOList1);
        }

        // マスタデータ2の削除
        manager.deleteMasterDataByCondition(masterDataCondition2);

        if (_vo2.getMasterData() != null) {
            // マスタデータ2の編集
            List<MasterDataInsertVO> insertVOList2 = new ArrayList<MasterDataInsertVO>();
            insertVOList2 = editMasterDataInsertVO(_vo2, masterKindList2.get(0), masterResult2.getMasterItem());

            // マスタデータ2の登録
            manager.registerMaster(insertVOList2);
        }

        // 正常終了
        getResult().set(RESULT_KEY, new MasterRegisterResult());
    }

    /**
     * マスタデータ登録VOの設定
     *
     * @param vo1 マスタデータ登録VO
     * @param vo2 マスタデータ登録VO
     */
    public void setMasterTablesRegisterVO(MasterRegisterVO vo1, MasterRegisterVO vo2) {
        _vo1 = vo1;
        _vo2 = vo2;
    }

    /**
     * 実行結果を返します。
     *
     * @return 実行結果
     */
    public MasterRegisterResult getMasterRegisterResult() {
        return (MasterRegisterResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * パラメータ入力チェック
     *
     * @param vo マスタデータ登録VO
     * @throws KKHException パラメータ指定エラーの場合
     */
    private void checkInput(MasterRegisterVO vo) throws KKHException {

        //パラメータの必須チェック
        if (StringUtil.isBlank(vo.getEsqId())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(vo.getAplId())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(vo.getEgCd())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(vo.getTksKgyCd())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(vo.getTksBmnSeqNo())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(vo.getTksTntSeqNo())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (StringUtil.isBlank(vo.getMasterKey())) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        try {
            if (vo.getMasterData() == null && vo.get_maxupdate() == DateFormat.getDateInstance().parse("1000/01/01 01:01:01")) {
                throw new KKHException("パラメータ指定エラー", "BD-E0001");
            }
        } catch (ParseException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }

    /**
     * マスタ定義取得条件の設定
     *
     * @param cond マスタ定義取得条件
     * @param masterRegisterVO マスタデータ登録処理用VO
     */
    private void setMasterCondition(MasterCondition cond, MasterRegisterVO masterRegisterVO) {

        cond.setEsqId(masterRegisterVO.getEsqId());
        cond.setEgCd(masterRegisterVO.getEgCd());
        cond.setTksKgyCd(masterRegisterVO.getTksKgyCd());
        cond.setTksBmnSeqNo(masterRegisterVO.getTksBmnSeqNo());
        cond.setTksTntSeqNo(masterRegisterVO.getTksTntSeqNo());
        cond.setMasterKey(masterRegisterVO.getMasterKey());
    }

    /**
     * マスタデータ取得・削除条件の設定
     *
     * @param cond マスタデータ取得・削除条件
     * @param masterRegisterVO マスタデータ登録処理用VO
     * @param masterKindVO マスタ種類設定VO
     */
    private void setMasterDataCondition(MasterCondition cond, MasterRegisterVO masterRegisterVO,MasterVO masterKindVO) {

        cond.setEgCd(masterRegisterVO.getEgCd());
        cond.setTksKgyCd(masterRegisterVO.getTksKgyCd());
        cond.setTksBmnSeqNo(masterRegisterVO.getTksBmnSeqNo());
        cond.setTksTntSeqNo(masterRegisterVO.getTksTntSeqNo());
        cond.setSybt(masterKindVO.getField2());
        if (StringUtil.isBlank(masterKindVO.getField5()) == false) {
            cond.setFilterKey(masterKindVO.getField5());
        }
        if (StringUtil.isBlank(masterRegisterVO.getFilterValue()) == false) {
            cond.setFilterValue(masterRegisterVO.getFilterValue());
        }
    }

    /**
     * 排他チェック
     *
     * @param newTimStmp 更新タイムスタンプ（最新）
     * @param currentTimStmp 更新タイムスタンプ（現在）
     * @return 正常：null、チェックエラー：エラー情報
     */
    private ErrorInfo checkExclusion(Date newTimStmp, Date currentTimStmp) {

        // 対象のタイムスタンプがどちらも存在しない場合
        if (newTimStmp == null && currentTimStmp == null) {
            return null;
        }
        // 対象のタイムスタンプの一方が存在しない場合
        if (newTimStmp == null || currentTimStmp == null) {
            return createErrorInfo("排他エラー", "BD-W0001");
        }
        // 更新タイムスタンプ（最新）が更新タイムスタンプ（現在）より大きい場合
        if (newTimStmp.compareTo(currentTimStmp) > 0) {
            return createErrorInfo("排他エラー", "BD-W0001");
        }
        return null;
    }

    /**
     * エラー情報生成
     *
     * @param message メッセージ
     * @param errorID エラーコード
     * @return エラー情報
     */
    private ErrorInfo createErrorInfo(String message, String errorID) {

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setError(true);
        errorInfo.setErrorCode(errorID);
        List<String> list = new ArrayList<String>();
        list.add(message);
        errorInfo.setNote(list);
        return errorInfo;
    }

    /**
     * マスタデータの編集
     *
     * @param masterRegisterVO マスタデータ登録処理用VO
     * @param masterKindVO マスタ種類設定VO
     * @param itemList マスタ項目VOリスト
     * @return マスタデータVO（INSERT用）のリスト
     */
    private List<MasterDataInsertVO> editMasterDataInsertVO(MasterRegisterVO masterRegisterVO, MasterVO masterKindVO,
            List<MasterVO> masterItemList) {

        List<MasterDataInsertVO> insertVOList = new ArrayList<MasterDataInsertVO>();

        // 項目定義のフィールドを設定
        List<String> itemList = new ArrayList<String>();
        for (MasterVO masterItem : masterItemList) {
            itemList.add(StringUtils.trimWhitespace(masterItem.getField4()));
        }

        // マスタレコード数分ループ
        for (MasterDataVO masterDataVO : masterRegisterVO.getMasterData()) {
            MasterDataInsertVO insertVO = new MasterDataInsertVO();
            // 共通項目
            insertVO.setTrkPl(masterRegisterVO.getAplId());
            insertVO.setTrkTnt(masterRegisterVO.getEsqId());
            insertVO.setUpdaPl(masterRegisterVO.getAplId());
            insertVO.setUpdTnt(masterRegisterVO.getEsqId());
            insertVO.setEgCd(masterRegisterVO.getEgCd());
            insertVO.setTksKgyCd(masterRegisterVO.getTksKgyCd());
            insertVO.setTksBmnSeqNo(masterRegisterVO.getTksBmnSeqNo());
            insertVO.setTksTntSeqNo(masterRegisterVO.getTksTntSeqNo());
            insertVO.setSybt(masterKindVO.getField2());

            // 項目定義の件数分、繰り返す
            for (int i = 0; i < itemList.size(); i++) {
                String item = itemList.get(i);
                if ("FIELD1".equals(item)) {
                    insertVO.setField1(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD2".equals(item)) {
                    insertVO.setField2(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD3".equals(item)) {
                    insertVO.setField3(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD4".equals(item)) {
                    insertVO.setField4(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD5".equals(item)) {
                    insertVO.setField5(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD6".equals(item)) {
                    insertVO.setField6(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD7".equals(item)) {
                    insertVO.setField7(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD8".equals(item)) {
                    insertVO.setField8(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD9".equals(item)) {
                    insertVO.setField9(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD10".equals(item)) {
                    insertVO.setField10(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD11".equals(item)) {
                    insertVO.setField11(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD12".equals(item)) {
                    insertVO.setField12(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD13".equals(item)) {
                    insertVO.setField13(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD14".equals(item)) {
                    insertVO.setField14(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD15".equals(item)) {
                    insertVO.setField15(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD16".equals(item)) {
                    insertVO.setField16(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD17".equals(item)) {
                    insertVO.setField17(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD18".equals(item)) {
                    insertVO.setField18(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD19".equals(item)) {
                    insertVO.setField19(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("FIELD20".equals(item)) {
                    insertVO.setField20(getSubjectColumnData(masterDataVO, i + 1));
                } else if ("INTVALUE1".equals(item)) {
                    insertVO.setIntValue1(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE2".equals(item)) {
                    insertVO.setIntValue2(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE3".equals(item)) {
                    insertVO.setIntValue3(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE4".equals(item)) {
                    insertVO.setIntValue4(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE5".equals(item)) {
                    insertVO.setIntValue5(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE6".equals(item)) {
                    insertVO.setIntValue6(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE7".equals(item)) {
                    insertVO.setIntValue7(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE8".equals(item)) {
                    insertVO.setIntValue8(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE9".equals(item)) {
                    insertVO.setIntValue9(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                } else if ("INTVALUE10".equals(item)) {
                    insertVO.setIntValue10(toBigDecimal(getSubjectColumnData(masterDataVO, i + 1)));
                }
            }

            insertVOList.add(insertVO);
        }

        return insertVOList;
    }

    /**
     * 対象列データの取得
     *
     * @param masterDataVO マスタデータVO
     * @param columnIndex 列順
     */
    private String getSubjectColumnData(MasterDataVO masterDataVO, int columnIndex) {

        String subjectColumnData = null;
        switch (columnIndex) {
        case 1:
            subjectColumnData = masterDataVO.getColumn1();
            break;
        case 2:
            subjectColumnData = masterDataVO.getColumn2();
            break;
        case 3:
            subjectColumnData = masterDataVO.getColumn3();
            break;
        case 4:
            subjectColumnData = masterDataVO.getColumn4();
            break;
        case 5:
            subjectColumnData = masterDataVO.getColumn5();
            break;
        case 6:
            subjectColumnData = masterDataVO.getColumn6();
            break;
        case 7:
            subjectColumnData = masterDataVO.getColumn7();
            break;
        case 8:
            subjectColumnData = masterDataVO.getColumn8();
            break;
        case 9:
            subjectColumnData = masterDataVO.getColumn9();
            break;
        case 10:
            subjectColumnData = masterDataVO.getColumn10();
            break;
        case 11:
            subjectColumnData = masterDataVO.getColumn11();
            break;
        case 12:
            subjectColumnData = masterDataVO.getColumn12();
            break;
        case 13:
            subjectColumnData = masterDataVO.getColumn13();
            break;
        case 14:
            subjectColumnData = masterDataVO.getColumn14();
            break;
        case 15:
            subjectColumnData = masterDataVO.getColumn15();
            break;
        case 16:
            subjectColumnData = masterDataVO.getColumn16();
            break;
        case 17:
            subjectColumnData = masterDataVO.getColumn17();
            break;
        case 18:
            subjectColumnData = masterDataVO.getColumn18();
            break;
        case 19:
            subjectColumnData = masterDataVO.getColumn19();
            break;
        case 20:
            subjectColumnData = masterDataVO.getColumn20();
            break;
        case 21:
            subjectColumnData = masterDataVO.getColumn21();
            break;
        case 22:
            subjectColumnData = masterDataVO.getColumn22();
            break;
        case 23:
            subjectColumnData = masterDataVO.getColumn23();
            break;
        case 24:
            subjectColumnData = masterDataVO.getColumn24();
            break;
        case 25:
            subjectColumnData = masterDataVO.getColumn25();
            break;
        case 26:
            subjectColumnData = masterDataVO.getColumn26();
            break;
        case 27:
            subjectColumnData = masterDataVO.getColumn27();
            break;
        case 28:
            subjectColumnData = masterDataVO.getColumn28();
            break;
        case 29:
            subjectColumnData = masterDataVO.getColumn29();
            break;
        case 30:
            subjectColumnData = masterDataVO.getColumn30();
            break;
        default:
            subjectColumnData = null;
        }

        return subjectColumnData;
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
