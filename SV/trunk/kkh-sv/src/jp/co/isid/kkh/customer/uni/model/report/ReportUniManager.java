package jp.co.isid.kkh.customer.uni.model.report;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.util.constants.KKHConstants.GyomKbn;
import jp.co.isid.kkh.util.constants.KKHConstants.SeiKbn;
import jp.co.isid.nj.model.ModelUtils;

public class ReportUniManager {

    /** 文字列の長さ (内容１) */
    private static final int CONTENTS1_LENGTH = 32;
    /** 文字列の長さ (内容２) */
    private static final int CONTENTS2_LENGTH = 18;
    /** 文字列の長さ (内容３) */
    private static final int CONTENTS3_LENGTH = 11;
    /** 文字列の長さ (内容４) */
    private static final int CONTENTS4_LENGTH = 30;

    /** シングルトンインスタンス */
    private static ReportUniManager _manager = new ReportUniManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private ReportUniManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static ReportUniManager getInstance() {
        return _manager;
    }

    /**
     * 帳票（ユニチャーム_広告費明細表）データを検索します。
     *
     * @return ReportUniResult 並び順情報
     * @throws KKHException
     *             処理中にエラーが発生した場合
     */
    public ReportUniResult findReportUniByCondition(ReportUniCondition cond)
            throws KKHException {

        // パラメータの必須チェック
        if (cond.getEsqId() == null || cond.getEsqId().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getEgCd() == null || cond.getEgCd().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }
        if (cond.getYm() == null || cond.getYm().equals("")) {
            throw new KKHException("パラメータ指定エラー", "BD-E0001");
        }

        // 検索結果
        ReportUniResult result = new ReportUniResult();

        // 検索条件
        ReportUniCondition lCond = new ReportUniCondition();

        ReportUniDAO dao = ReportUniDAOFactory.createFindReportUniDAO();
        lCond = cond;

        // ****************************************************************
        // 帳票（ユニチャーム_広告費明細表・プルーフリスト）データの検索
        // ****************************************************************
        List<ReportUniVO> list = dao.findReportUniByCondition(lCond);
        List<ReportUniVO> list_t = dao.findTougouReportUniByCondition(lCond);


        // ****************************************************************
        // 帳票（ユニチャーム_広告費明細表）データを取得
        // ****************************************************************
        result.setMeisai(getMeisai(list, list_t));

        // ****************************************************************
        // 帳票（ユニチャーム_プルーフリスト）データを取得
        // ****************************************************************
        result.setProofs(getProofs(list, list_t));

        return result;
    }

    /**
     * 広告費明細表（暫定・確定）データを取得する
     *
     * @param hashList 検索結果
     * @return 変換後の検索結果
     */
    private List<ReportUniResultVO> getMeisai(List<ReportUniVO> hashList, List<ReportUniVO> hashList_t) {

        List<ReportUniResultVO> list = new ArrayList<ReportUniResultVO>();

        for (int i = 0; i < hashList.size(); i++) {

            ReportUniVO result = new ReportUniVO();
            result = hashList.get(i);
            ReportUniResultVO vo = new ReportUniResultVO();

            // 請求原票No
            String gpyNo = "";
            String temp1 = result.getHb1GpyNo();
            String temp2 = result.getHb2Sonota2();

            // 2013/01/09 JSE M.Naito add
            // 受注データの請求原票Noの形式変更
            gpyNo = changeStr(temp1, temp2);

            String jyutNo1 = "";
            String jyutMNo1 = "";
            String uriMNo1 = "";
            // 統合フラグが立っている場合
            if(result.getHb1TouFlg().equals("1")){

                // 統合先の「受注No」を取得
                jyutNo1 = result.getHb1JyutNo();
                jyutMNo1 = result.getHb1JyMeiNo();
                uriMNo1 = result.getHb1UrMeiNo();

                // 統合元の請求原票Noを取得
                for(int j = 0; j < hashList_t.size(); j++){

                    // 受注データを取得
                    ReportUniVO result_t = new ReportUniVO();
                    result_t = hashList_t.get(j);

                    // 統合元の「統合先受注No、統合先受注明細No、統合先売上明細No」と統合先の「受注No、受注明細No、売上明細No」が一致
                    if(result_t.getHb1TJyutNo().equals(jyutNo1) &&  result_t.getHb1TJymeiNo().equals(jyutMNo1) && result_t.getHb1TUrmeiNo().equals(uriMNo1)){

                        String tmp1 = "";
                        // 統合元の請求原票Noの形式変更
                        tmp1 = changeStr(result_t.getHb1GpyNo(), "");

                        if(!gpyNo.equals("")){
//                            gpyNo += ",";
                            gpyNo += "\n";
                        }
                        gpyNo += tmp1;
                    }
                }
            }

//            if (!temp1.equals("") && temp1.length() == 10) {
//                // 請求原票Noが10文字の場合（正常） 「999999-9999」形式
//                gpyNo += temp1.substring(0, 6);
//                gpyNo += "-";
//                gpyNo += temp1.substring(6, 10);
//
//            } else {
//                // 請求原票Noが10文字以外の場合（異常） 変換せずにセット
//                gpyNo = temp1;
//            }
//
//            if (!temp2.equals("")) {
//                // 請求原票行番号が存在する場合
//                gpyNo += "-";
//                gpyNo += temp2;
//            }
            vo.setGpyNo(gpyNo);

            // 統合フラグ
            vo.setTouFlg(result.getHb1TouFlg());

            // 受注No(受注No + "-" + 受注明細No + "-" + 売上明細No)
            String jyutNo = result.getHb1JyutNo();      // 受注No
            String jyMeiNo = result.getHb1JyMeiNo();    // 受注明細No
            String urMeiNo = result.getHb1UrMeiNo();    // 売上明細No
            vo.setJutyuNo(jyutNo + "-" + jyMeiNo + "-" + urMeiNo);

            // 種別コード
            String showNumStr = result.getShubetsuCd();
            vo.setShubetsuCd(showNumStr);

            // 種別名
            vo.setShubetsuNm(result.getShubetsuNm());

            // 件名
            vo.setKenmei(result.getHb2Name9());

            // 費目
            vo.setHimoku(result.getHb2Name1());

            // 金額
            vo.setKngk(result.getHb2SeiGak());

            // 消費税
            vo.setTax(result.getHb2Kngk2());

            // 金額（受注ダウンロードデータ）
            vo.setKngkJ(result.getHb1SeiGak());

            // 消費税（受注ダウンロードデータ）
            vo.setTaxJ(result.getHb1SzeiGak());

            // 内容１
            String contents1 = getContents1(result, showNumStr);
            vo.setContents1(contents1);

            // 内容２
            String contents2 = getContents2(result, showNumStr);
            vo.setContents2(contents2);

            // 内容３
            String contents3 = getContents3(result, showNumStr);
            vo.setContents3(contents3);

            // 内容４
            String contents4 = getContents4(result, showNumStr);
            vo.setContents4(contents4);

            // 内容
            StringBuffer contents = new StringBuffer();
            contents.append(contentsAddSpace(contents1, CONTENTS1_LENGTH, false));
            contents.append(contentsAddSpace(contents2, CONTENTS2_LENGTH, false));
            contents.append(contentsAddSpace(contents3, CONTENTS3_LENGTH, true));

            // 部署
            vo.setBusho(result.getHb2Name11());

            // テレビ番組、テレビ特番、製作
            if (ReportUniDAO.IDX_TV_BANGUMI.equals(showNumStr) ||
                ReportUniDAO.IDX_TV_TOKUBAN.equals(showNumStr) ||
                ReportUniDAO.IDX_SEISAKU.equals(showNumStr)) {

                if (!contents3.equals("") && !contents4.equals("")) {
                    contents.append("×");
                } else {
                    contents.append("  ");
                }

            } else {
                contents.append("  ");
            }
            contents.append(contentsAddSpace(contents4, CONTENTS4_LENGTH, false));
            vo.setContents(contents.toString());

            // 検索結果直後の状態にする
            ModelUtils.copyMemberSearchAfterInstace(vo);
                list.add(vo);
        }

        return list;
    }

    /**
     * 内容１に表示する文字列を取得する
     *
     * @param vo 明細データ
     * @param showNum 種別表示順
     *
     * @return String 内容１
     */
    private String getContents1(ReportUniVO vo, String showNum) {

        String ret = "";

        // テレビ番組、テレビ特番
        if (ReportUniDAO.IDX_TV_BANGUMI.equals(showNum) || ReportUniDAO.IDX_TV_TOKUBAN.equals(showNum)) {

            String sonota5 = vo.getHb2Sonota5();
            String name3 = vo.getHb2Name3();

            // 放送日をセット
            // 放送月「YYYYMM」形式、放送日「00000･･･00000」形式 → 「M月・D日、･･･D日」形式にする
            if (!sonota5.equals("") && sonota5.length() == 6 &&
                !name3.equals("") && name3.length() == 31) {

                String temp = sonota5.substring(4, 6);
                if (temp.substring(0, 1).equals("0"))
                {
                    temp = temp.substring(1, 2);
                }

                ret = temp + "月・" + changeDate(name3);
            }

        // テレビスポット
        } else if (ReportUniDAO.IDX_TV_SPOT.equals(showNum)) {

            // 放送期間をセット
            // 放送期間「YYYYMMDDYYYYMMDD」形式 → 「M/D-M/D」形式にする
            ret = changeDate(vo.getHb2Name3());

        // 雑誌、新聞、その他
        } else if (ReportUniDAO.IDX_ZASHI.equals(showNum) ||
                   ReportUniDAO.IDX_SHINBUN.equals(showNum) ||
                   ReportUniDAO.IDX_SONOTA.equals(showNum)) {

            // 媒体名をセット
            ret = vo.getHb2Name2();

        // 製作
        } else if (ReportUniDAO.IDX_SEISAKU.equals(showNum)) {

            // 制作内容をセット
            ret = vo.getHb2Name4();
        }

        return ret;
    }

    /**
     * 内容２に表示する文字列を取得する
     *
     * @param vo 明細データ
     * @param showNum 種別表示順
     *
     * @return String 内容２
     */
    private String getContents2(ReportUniVO vo, String showNum) {

        String ret = "";

        // テレビスポット
        if (ReportUniDAO.IDX_TV_SPOT.equals(showNum)) {

            String name2 = vo.getHb2Name2();
            String sonota4 = vo.getHb2Sonota4();

            // ＴＶ ＳＰＯＴ の場合
            // 放送局名 + 局数をセット
            //「"放送局名" 他 "局数" 局」形式にする   例）ﾃﾚﾋﾞ朝日他22局
            if (!name2.equals("")) {
                ret += name2 + "他";
            }

            if (!sonota4.equals("")) {
                DecimalFormat df = new DecimalFormat("#,##0");
                ret += df.format(Integer.valueOf(sonota4)) + "局";
            }

        // 雑誌、新聞
        } else if (ReportUniDAO.IDX_ZASHI.equals(showNum) || ReportUniDAO.IDX_SHINBUN.equals(showNum)) {

            // 発売日をセット(雑誌)
            // 連載日をセット(新聞)
            // 期間「YYYYMMDD」形式 → 「M月D日」形式にする
            ret = changeDate(vo.getHb2Name3());

        // その他
        } else if (ReportUniDAO.IDX_SONOTA.equals(showNum)) {

            // 期間をセット
            // 期間「YYYYMMDDYYYYMMDD」形式 → 「M/D-M/D」形式にする
            ret = changeDate(vo.getHb2Name3());

        // 製作
        } else if (ReportUniDAO.IDX_SEISAKU.equals(showNum)) {

            // 納品目をセット
            String name3 = vo.getHb2Name3();
            if (!name3.equals("")) {
                ret = name3;
            }
        }

        return ret;
    }

    /**
     * 内容３に表示する文字列を取得する
     *
     * @param vo 明細データ
     * @param showNum 種別表示順
     *
     * @return String 内容３
     */
    private String getContents3(ReportUniVO vo, String showNum) {

        String ret = "";

        // テレビ番組、テレビ特番、製作
        if (ReportUniDAO.IDX_TV_BANGUMI.equals(showNum) ||
            ReportUniDAO.IDX_TV_TOKUBAN.equals(showNum) ||
            ReportUniDAO.IDX_SEISAKU.equals(showNum)) {

            // 単価をセット
            BigDecimal kngk1 = vo.getHb2Kngk1();
            if (kngk1.compareTo(BigDecimal.ZERO) > 0) {

                // 「0」以外の場合は単価をセット
                DecimalFormat df = new DecimalFormat("#,##0");
                ret = df.format((kngk1));
            }

        // 雑誌
        } else if (ReportUniDAO.IDX_ZASHI.equals(showNum)) {

            // 掲載号をセット
            ret = vo.getHb2Name6();
        }

        return ret;
    }

    /**
     * 内容４に表示する文字列を取得する
     *
     * @param vo 明細データ
     * @param showNum 種別表示順
     *
     * @return String 内容４
     */
    private String getContents4(ReportUniVO vo, String showNum) {

        String ret = "";

        // テレビ番組、テレビ特番
        if (ReportUniDAO.IDX_TV_BANGUMI.equals(showNum) || ReportUniDAO.IDX_TV_TOKUBAN.equals(showNum)) {

            String sonota4 = vo.getHb2Sonota4();

            // 放送回数をセット
            // 「"放送回数" 回」形式にする
            if (!sonota4.equals("")) {
                DecimalFormat df = new DecimalFormat("#,##0");
                ret = df.format(Integer.valueOf(sonota4)) + "回";
            }

        // 雑誌、新聞
        } else if (ReportUniDAO.IDX_ZASHI.equals(showNum) ||
                   ReportUniDAO.IDX_SHINBUN.equals(showNum)) {

            // スペースをセット
            String name7 = vo.getHb2Name7();
            if (!name7.trim().equals("")) {
                ret = name7;
            }

        // 製作
        } else if (ReportUniDAO.IDX_SEISAKU.equals(showNum)) {

            String sonota4 = vo.getHb2Sonota4();

            // 回数数量をセット
            // 「"回数数量" 本」形式にする
            if (!sonota4.equals("")) {
                DecimalFormat df = new DecimalFormat("#,##0");
                ret = df.format(Integer.valueOf(sonota4)) + "本";
            }
        }

        return ret;
    }

    /**
     * プルーフリストデータを取得する
     *
     * @param hashList 検索結果
     * @return 変換後の検索結果
     */
    private List<ReportUniResultVO> getProofs(List<ReportUniVO> hashList, List<ReportUniVO> hashList_t) {

        List<ReportUniResultVO> list = new ArrayList<ReportUniResultVO>();

        for (int h = 0; h < hashList_t.size(); h++) {

            // リストを一つにまとめる
            hashList.add(hashList_t.get(h));
        }

         for (int i = 0; i < hashList.size(); i++) {

            ReportUniVO result = hashList.get(i);
            ReportUniResultVO vo = new ReportUniResultVO();

            String gyomKbn = result.getHb1GyomKbn();
            String gyomKbnNm = "";

            // 請求原票No
            vo.setGpyNo(result.getHb1GpyNo());

            // 請求原票行No
//            vo.setMGpyNo(result.getHb2Sonota2());

            // 受注No(受注No + "-" + 受注明細No + "-" + 売上明細No)
            String jyutNo = result.getHb1JyutNo();      // 受注No
            String jyMeiNo = result.getHb1JyMeiNo();    // 受注明細No
            String urMeiNo = result.getHb1UrMeiNo();    // 売上明細No
            vo.setJutyuNo(jyutNo + "-" + jyMeiNo + "-" + urMeiNo);

            // 統合フラグ
            vo.setTouFlg(result.getHb1TouFlg());

            // 統合先受注No
            vo.setTJyutNo(result.getHb1TJyutNo());

            // 統合先受注明細No
            vo.setTJymeiNo(result.getHb1TJymeiNo());

            // 統合先売上明細No
            vo.setTUrmeiNo(result.getHb1TUrmeiNo());

            // 業務区分
            if (GyomKbn.TVTIME.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.TVTIME.getName();            // テレビタイム

            } else if (GyomKbn.TVSPOT.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.TVSPOT.getName();            // テレビスポット

            } else if (GyomKbn.ZASHI.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.ZASHI.getName();             // 雑誌

            } else if (GyomKbn.SHINBUN.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.SHINBUN.getName();           // 新聞

            } else if (GyomKbn.CREATIVE.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.CREATIVE.getName();          // クリエーティブ

            } else if (GyomKbn.RADIO.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.RADIO.getName();             // ラジオ

            } else if (GyomKbn.EISEIM.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.EISEIM.getName();            // 衛星メディア

            } else if (GyomKbn.OOHM.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.OOHM.getName();              // OOHメディア

            } else if (GyomKbn.INTERACTIVEM.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.INTERACTIVEM.getName();      // インタラクティブメディア

            } else if (GyomKbn.SONOTAM.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.SONOTAM.getName();           // その他メディア

            } else if (GyomKbn.MPLAN.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.MPLAN.getName();             // メディアプランニング

            } else if (GyomKbn.MARKEPROMO.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.MARKEPROMO.getName();        // マーケティング/プロモーション

            } else if (GyomKbn.SPORTS.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.SPORTS.getName();            // スポーツ

            } else if (GyomKbn.ENTERTAINMENT.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.ENTERTAINMENT.getName();     // エンタテイメント

            } else if (GyomKbn.SONOTAC.getCode().equals(gyomKbn)) {
                gyomKbnNm = GyomKbn.SONOTAC.getName();           // その他コンテンツ
            }
            vo.setGyomKbn(gyomKbn);
            vo.setGyomKbnNm(gyomKbnNm);

            // 請求区分
            String seiKbn = result.getHb1SeiKbn();
            vo.setSeiKbn(result.getHb1SeiKbn());

            // 件名
            vo.setKenmei(result.getHb1KKNameKJ());

            // 費目名
            vo.setHimoku(result.getHb1HimkNmKJ());

            String showNumStr = result.getShubetsuCd();

            // 内容１
            vo.setContents1(getContentsProof1(result, showNumStr, seiKbn));

            // 内容２
            vo.setContents2(getContentsProof2(result, showNumStr, seiKbn));

            // 内容３
            vo.setContents3(getContentsProof3(result, showNumStr, seiKbn));

            // 内容４
            vo.setContents4(getContentsProof4(result, showNumStr, seiKbn));

            // 金額
            vo.setKngk(result.getHb1SeiGak());

            // 消費税額
            vo.setTax(result.getHb1SzeiGak());

            // 部署
//            vo.setBusho(result.getHb2Name11());

            // 検索結果直後の状態にする
            ModelUtils.copyMemberSearchAfterInstace(vo);
            list.add(vo);
        }

        return list;
    }

    /**
     * 内容１に表示する文字列を取得する(プルーフリスト)
     *
     * @param vo  明細データ
     * @param showNum 種別表示順
     * @param seiKbn  請求区分
     *
     * @return String 内容１
     */
    private String getContentsProof1(ReportUniVO vo, String showNum, String seiKbn) {

        String ret = "";

        // テレビ番組、テレビ特番
        if (ReportUniDAO.IDX_TV_BANGUMI.equals(showNum) || ReportUniDAO.IDX_TV_TOKUBAN.equals(showNum)) {
            // タイム
            if (SeiKbn.TIME.getCode().equals(seiKbn)) {

                String field8 = vo.getHb1Field8();
                String field7 = vo.getHb1Field7();

                // 放送日をセット
                // 放送月「YYYYMM」形式、放送日「00000･･･00000」形式 → 「M月・D日、･･･D日」形式にする
                if (!field8.equals("") && field8.substring(0, 6).length() == 6 &&
                    !field7.equals("") && field7.length() == 31) {

                    String temp = field8.substring(4, 6);
                    if (temp.substring(0, 1).equals("0"))
                    {
                        temp = temp.substring(1, 2);
                    }

                    ret = temp + "月・" + changeDate(field7);
                }
            }

        // テレビスポット
        } else if (ReportUniDAO.IDX_TV_SPOT.equals(showNum)) {
            // スポット
            if (SeiKbn.SPOT.getCode().equals(seiKbn)) {
                // 放送期間をセット
                // 放送期間「YYYYMMDDYYYYMMDD」形式 → 「M/D-M/D」形式にする
                ret = changeDate(vo.getHb1Field4());
            }

        // 雑誌
        } else if (ReportUniDAO.IDX_ZASHI.equals(showNum)) {
            // 雑誌
            if (SeiKbn.MAGAZINE.getCode().equals(seiKbn)) {
                ret = vo.getHb1Field2();
            }

        // 新聞
        } else if (ReportUniDAO.IDX_SHINBUN.equals(showNum)) {
            // 新聞
            if (SeiKbn.NEWSPAPER.getCode().equals(seiKbn)) {
                ret = vo.getHb1Field2();
            }

        // その他
        } else {

            // 諸作業
            if (SeiKbn.WORKS.getCode().equals(seiKbn)) {
                ret = "";

            // 国際(諸作業）
            } else if (SeiKbn.KWORKS.getCode().equals(seiKbn)) {
                ret = vo.getHb1Field3();

            // 上記以外
            } else {
                ret = vo.getHb1Field2();
            }
        }

        return ret;
    }

    /**
     * 内容２に表示する文字列を取得する(プルーフリスト)
     *
     * @param vo  明細データ
     * @param showNum 種別表示順
     * @param seiKbn  請求区分
     *
     * @return String 内容２
     */
    private String getContentsProof2(ReportUniVO vo, String showNum, String seiKbn) {

        String ret = "";

        // テレビスポット
        if (ReportUniDAO.IDX_TV_SPOT.equals(showNum)) {

            // スポット
            if (SeiKbn.SPOT.getCode().equals(seiKbn)) {

                String field2 = vo.getHb1Field2();
                String field3 = vo.getHb1Field3();

                // ＴＶ ＳＰＯＴ の場合
                // 放送局名 + 局数をセット
                //「"放送局名" 他 "局数" 局」形式にする   例）ﾃﾚﾋﾞ朝日他22局
                if (!field2.equals("")) {
                    ret += field2 + "他";
                }

                if (!field3.equals("")) {
                    DecimalFormat df = new DecimalFormat("#,##0");
                    ret += df.format(Integer.valueOf(field3)) + "局";
                }
            }

        // 雑誌
        } else if (ReportUniDAO.IDX_ZASHI.equals(showNum)) {
            // 雑誌
            if (SeiKbn.MAGAZINE.getCode().equals(seiKbn)) {
                // 発売日をセット
                // 期間「YYYYMMDD」形式 → 「M月D日」形式にする
                ret = changeDate(vo.getHb1Field3());
            }

        // 新聞
        } else if (ReportUniDAO.IDX_SHINBUN.equals(showNum)) {
            // 新聞
            if (SeiKbn.NEWSPAPER.getCode().equals(seiKbn)) {
                // 連載日をセット
                // 期間「YYYYMMDD」形式 → 「M月D日」形式にする
                ret = changeDate(vo.getHb1Field3());
            }

        // 製作
        } else if (ReportUniDAO.IDX_SEISAKU.equals(showNum)) {
            // 諸作業
            if (SeiKbn.WORKS.getCode().equals(seiKbn)) {
                String field3 = vo.getHb1Field3();
                if (!field3.equals("")) {
                    ret = field3;
                }
            }

        // その他
        } else if (ReportUniDAO.IDX_SONOTA.equals(showNum)) {

            // 期間をセット
            // 期間「YYYYMMDDYYYYMMDD」形式 → 「M/D-M/D」形式にする

            // タイム
            if (SeiKbn.TIME.getCode().equals(seiKbn)) {
                ret = changeDate(vo.getHb1Field8());

            // スポット、国際(諸作業）
            } else if (SeiKbn.SPOT.getCode().equals(seiKbn) ||
                       SeiKbn.KWORKS.getCode().equals(seiKbn)) {
                ret = changeDate(vo.getHb1Field4());

            // 雑誌
            } else if (SeiKbn.MAGAZINE.getCode().equals(seiKbn)) {
                ret = changeDate(vo.getHb1Field10());

            // 新聞
            } else if (SeiKbn.NEWSPAPER.getCode().equals(seiKbn)) {
                ret = changeDate(vo.getHb1Field12());

            // 諸作業、IC、OOH
            } else if (SeiKbn.WORKS.getCode().equals(seiKbn) ||
                       SeiKbn.IC.getCode().equals(seiKbn) ||
                       SeiKbn.OOH.getCode().equals(seiKbn)) {
                ret = changeDate(vo.getHb1Field5());

            // 国際マス
            } else if (SeiKbn.KMAS.getCode().equals(seiKbn)) {
                ret = changeDate(vo.getHb1Field3());
            }
        }

        return ret;
    }

    /**
     * 内容３に表示する文字列を取得する(プルーフリスト)
     *
     * @param vo 明細データ
     * @param showNum 種別表示順
     * @param seiKbn  請求区分
     *
     * @return String 内容３
     */
    private String getContentsProof3(ReportUniVO vo, String showNum, String seiKbn) {

        String ret = "";

        // 雑誌
        if (ReportUniDAO.IDX_ZASHI.equals(showNum)) {
            // 雑誌
            if (SeiKbn.MAGAZINE.getCode().equals(seiKbn)) {
                ret = vo.getHb1Field4();
            }

        // 製作
        } else if (ReportUniDAO.IDX_SEISAKU.equals(showNum)) {
            // 諸作業
            if (SeiKbn.WORKS.getCode().equals(seiKbn)) {

                BigDecimal seiTnka = vo.getHb1SeiTnka();

                if (seiTnka.compareTo(BigDecimal.ZERO) > 0) {

                    // 「0」以外の場合は単価をセット
                    DecimalFormat df = new DecimalFormat("#,###");
                    ret = df.format(seiTnka);
                }
            }
        } else {
           ret = "";
        }

        return ret;
    }

    /**
     * 内容４に表示する文字列を取得する(プルーフリスト)
     *
     * @param vo 明細データ
     * @param showNum 種別表示順
     * @param seiKbn  請求区分
     *
     * @return String 内容４
     */
    private String getContentsProof4(ReportUniVO vo, String showNum, String seiKbn) {

        String ret = "";

        // テレビ番組、テレビ特番
        if (ReportUniDAO.IDX_TV_BANGUMI.equals(showNum) || ReportUniDAO.IDX_TV_TOKUBAN.equals(showNum)) {
            // タイム
            if (SeiKbn.TIME.getCode().equals(seiKbn)) {

                String field6 = vo.getHb1Field6().trim();

                // 放送回数をセット
                // 「"放送回数" 回」形式にする
                if (!field6.equals("")) {
                    int val = Integer.valueOf(field6);
                    if (val != 0) {
                        DecimalFormat df = new DecimalFormat("#,###");
                        ret = df.format(Integer.valueOf(field6)) + "回";
                    }
                }
            }

        // 雑誌
        } else if (ReportUniDAO.IDX_ZASHI.equals(showNum)) {
            // 雑誌
            if (SeiKbn.MAGAZINE.getCode().equals(seiKbn)) {

                String field9 = vo.getHb1Field9();
                String field8 = vo.getHb1Field8();

                // スペースと掲載条件をセット
                if (!field9.equals("")) {
                    ret = field9 + field8;
                }
            }

        // 新聞
        } else if (ReportUniDAO.IDX_SHINBUN.equals(showNum)) {
            // 新聞
            if (SeiKbn.NEWSPAPER.getCode().equals(seiKbn)) {

                String field11 = vo.getHb1Field11();

                // スペースをセット
                if (!field11.equals("")) {
                    ret = field11;
                }
            }

        // 製作
        } else if (ReportUniDAO.IDX_SEISAKU.equals(showNum)) {
            // 諸作業
            if (SeiKbn.WORKS.getCode().equals(seiKbn)) {

                String field6 = vo.getHb1Field6().trim();

                // 回数数量をセット
                // 「"回数数量" 本」形式にする
                if (!field6.equals("")) {
                    int val = Integer.valueOf(field6);
                    if (val != 0) {
                        DecimalFormat df = new DecimalFormat("#,###");
                        ret = df.format(Integer.valueOf(field6)) + "本";
                    }
                }
            }
        }

        return ret;
    }

    /**
     * 引数の文字列の長さにより日付形式に変換した値を返す。
     *
     * @param dateStr 変換対象文字列
     * @return String 変換後の値
     */
    private String changeDate(String dateStr) {

        String ret = "";
        StringBuffer temp = new StringBuffer();

        // 「YYYYMMDD」形式 → 「M月D日」形式にする
        if (!dateStr.trim().equals("") && dateStr.length() == 8) {

            temp.append(Integer.valueOf(dateStr.substring(4, 6)));
            temp.append("月");
            temp.append(Integer.valueOf(dateStr.substring(6, 8)));
            temp.append("日");

            ret = temp.toString();
        }

        // 「YYYYMMDDYYYYMMDD」形式 → 「M/D-M/D」形式にする
        else if (!dateStr.trim().equals("") && dateStr.length() == 16) {

            temp.append(Integer.valueOf(dateStr.substring(4, 6)));
            temp.append("/");
            temp.append(Integer.valueOf(dateStr.substring(6, 8)));
            temp.append("-");
            temp.append(Integer.valueOf(dateStr.substring(12, 14)));
            temp.append("/");
            temp.append(Integer.valueOf(dateStr.substring(14, 16)));

            ret = temp.toString();
        }

        else if(!dateStr.trim().equals("") && dateStr.length() == 31) {

            // 引数の左側より1文字ずつ順に判定を行う
            for (int i = 0; i < dateStr.length(); i++) {

                // 判定文字の抜き出し
                String s = dateStr.substring(i, i + 1);
                if (s.equals("1")) {
                    temp.append(String.valueOf(i+1) + "日、");
                }
            }
            // 文字列の末尾「、」を削除して設定
            ret = temp.toString().substring(0, temp.lastIndexOf("、"));
        }

        return ret;
    }

    /**
     * 文字列を指定したバイト数になるようにSpace埋めを行う
     *
     * @param str 変換前文字列
     * @param length 指定バイト数
     * @param spc
     *         True：Spaceを変換前文字列の前にセット
     *         False：Spaceを変換前文字列の後にセット
     * @return
     */
    private String contentsAddSpace(String str, int length, Boolean spc) {

        String ret = "";
        int len = 0;

        if (length <= str.length()) {
            // 変更前文字列のバイト数が、指定バイト数以上の場合
            ret = str;

        } else {
            // 通常処理（指定バイト数になるようにSpace埋め）
            len = length - str.getBytes().length;

            String space = "";
            // 指定バイト数分のSpaceを生成
            for (int i =0; i< len; i++) {
                space += " ";
            }

            if (spc) {
                // Spaceを文字列の前にセット
                ret = space + str;

            } else {
                // Spaceを文字列の後にセット
                ret = str + space;
            }
        }

        return ret;
    }

    // 2013/01/09 JSE M.Naito add
    /**
     * 文字列を形式を変換した形で返す
     * @param str 変換前文字列
     * @return ret 変換後文字列
     */
    private String changeStr(String str1, String str2) {

        String ret = "";

        if (!str1.equals("") && str1.length() == 10) {
            // 請求原票Noが10文字の場合（正常） 「999999-9999」形式
            ret += str1.substring(0, 6);
            ret += "-";
            ret += str1.substring(6, 10);

        } else {
            // 請求原票Noが10文字以外の場合（異常） 変換せずにセット
            ret = str1;
        }

        if (!str2.equals("")) {
            // 請求原票行番号が存在する場合
            ret += "-";
            ret += str2;
        }

        return ret;
    }

}
