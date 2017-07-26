package jp.co.isid.kkh.customer.ash.model.detail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.isid.kkh.integ.tbl.TBTHB2KMEI;
import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.Thb1DownDAO;
import jp.co.isid.kkh.model.detail.Thb1DownDAOFactory;
import jp.co.isid.kkh.model.detail.Thb1DownVO;
import jp.co.isid.kkh.model.detail.Thb2KmeiDAO;
import jp.co.isid.kkh.model.detail.Thb2KmeiDAOFactory;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;
import jp.co.isid.kkh.model.master.MasterVO;
import jp.co.isid.kkh.util.constants.KKHConstants;

/**
 * <P>
 * 広告費明細入力Manager。
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2011/12/08 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class DetailAshManager {

    /** シングルトンインスタンス */
    private static DetailAshManager _manager = new DetailAshManager();

    /**
     * シングルトンの為、インスタンス化を禁止します。
     */
    private DetailAshManager() {
    }

    /**
     * インスタンスを返します。
     *
     * @return インスタンス
     */
    public static DetailAshManager getInstance() {
        return _manager;
    }

    //**********************************************************************************************************************************************************************************
    //明細検索
    /**
     * 広告費明細データを検索します。
     *
     * @return DetailDataResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public DetailDataAshResult findDetailDataAshByCond(DetailDataAshCondition cond) throws KKHException {


		DetailDataAshDAO dao = DetailDataAshDAOFactory.createDetailDataDAO();
    	//検索結果
    	DetailDataAshResult result = new DetailDataAshResult();

    	//******************************************************
    	//使用中媒体コード取得
    	//******************************************************
    	String targetBaitaiCd = "";
    	String kariBaitaiCd = "";
    	Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();
    	Thb1DownVO thb1DownCond = new Thb1DownVO();
    	thb1DownCond.setHb1EgCd(cond.getEgCd());
    	thb1DownCond.setHb1TksKgyCd(cond.getTksKgyCd());
    	thb1DownCond.setHb1TksBmnSeqNo(cond.getTksBmnSeqNo());
    	thb1DownCond.setHb1TksTntSeqNo(cond.getTksTntSeqNo());
    	thb1DownCond.setHb1JyutNo(cond.getJyutNo());
    	thb1DownCond.setHb1JyMeiNo(cond.getJyMeiNo());
    	thb1DownCond.setHb1UrMeiNo(cond.getUrMeiNo());
    	thb1DownCond.setHb1Yymm(cond.getYm());
    	thb1DownCond.setHb1TouFlg(" ");
    	Thb1DownVO thb1DownVo = thb1DownDao.loadThb1Down(thb1DownCond);
    	if (cond.getSeiKbn().equals(KKHConstants.SeiKbn.WORKS.getCode())){
    		kariBaitaiCd = " ";
    	}else if(cond.getSeiKbn().equals(KKHConstants.SeiKbn.KWORKS.getCode())){
    		kariBaitaiCd = thb1DownVo.getHb1Field2();
    	}else{
    		kariBaitaiCd = thb1DownVo.getHb1Field1();
    	}
    	List<String> useBaitaiCdList = dao.findUseBaitaiCd(cond);
    	if (useBaitaiCdList.size() <= 0 || useBaitaiCdList.get(0).equals("")){
    		//**************************
    		//対象媒体コード決定処理
    		//**************************
    		//媒体コード変換マスタ取得
    		List<MasterVO> baitaiCdCnvMstList = dao.findBaitaiCdCnvMst(cond);
    		//対象媒体コード決定
    		for (MasterVO masterVO : baitaiCdCnvMstList) {
    			if (cond.getGyoumuKbn().equals(masterVO.getField3()) && cond.getKokKbn().equals(masterVO.getField4())){
    				if (cond.getGyoumuKbn().equals("11030") || cond.getGyoumuKbn().equals("11050")){
    					if (cond.getTmSpKbn().equals(masterVO.getField5()) || masterVO.getField4().equals("1")){
    						if (masterVO.getField6().equals("")){
    							targetBaitaiCd = masterVO.getField2();
    						}else if(kariBaitaiCd.equals(masterVO.getField6())){
    							targetBaitaiCd = masterVO.getField2();
    							break;
    						}
    					}
    				} else {
						if (masterVO.getField6().equals("")){
							targetBaitaiCd = masterVO.getField2();
						}else if(kariBaitaiCd.equals(masterVO.getField6())){
							targetBaitaiCd = masterVO.getField2();
							break;
						}
    				}
    			}
			}
    		if (targetBaitaiCd.equals("")){
    			targetBaitaiCd = "190";
    		}
    	} else {
    		targetBaitaiCd = useBaitaiCdList.get(0);
    	}

    	//******************************************************
    	//広告費明細データを取得
    	//******************************************************
    	cond.setTargetBaitaiCd(targetBaitaiCd);
        // UPD 2015/03/03 K.F アサヒ対応 START
    	//cond.setMstSybt(getMasterSybt(targetBaitaiCd));
    	cond.setMstSybt(getMasterSybt(targetBaitaiCd, cond.getTksKgyCd() + cond.getTksBmnSeqNo() + cond.getTksTntSeqNo()));
        // UPD 2015/03/03 K.F アサヒ対応 END
        List<DetailDataAshVO> detailDataList = dao.findDetailDataByCondition(cond);

        result.setTargetBaitaiCd(targetBaitaiCd);
        result.setDetailData(detailDataList);

        return result;
    }

    /**
     * 対象媒体コードから検索するマスタのマスタ種別を決定する
     * @param targetBaitaiCd
     * @return
     */
    private String getMasterSybt(String targetBaitaiCd, String tksCd){
    	String masterSybt = "";

        // UPD 2015/03/03 K.F アサヒ対応 START
//    	if (targetBaitaiCd.equals("100") || targetBaitaiCd.equals("110")){
//    		//テレビタイム・テレビスポット
//    		masterSybt = "204";
//    	}else if (targetBaitaiCd.equals("120") || targetBaitaiCd.equals("125")){
//    		//ラジオタイム・ラジオスポット
//    		masterSybt = "205";
//    	}else if (targetBaitaiCd.equals("130")){
//    		//新聞
//    		masterSybt = "202";
//    	}else if (targetBaitaiCd.equals("140")){
//    		//雑誌
//    		masterSybt = "203";
//    	}else if (targetBaitaiCd.equals("150")){
//    		//交通
//    		masterSybt = "206";
//    	}else if (targetBaitaiCd.equals("230")){
//    		//メディアフィー
//    		masterSybt = "219";
//    	}else if (targetBaitaiCd.equals("240")){
//    		//ブランド管理フィー
//    		masterSybt = "220";
//    	}else if (targetBaitaiCd.equals("160") || targetBaitaiCd.equals("180")){
//    		//屋外広告・イベント
//    		masterSybt = "217";
//    	}else if (targetBaitaiCd.equals("170")){
//    		//制作
//    		masterSybt = "216";
//    	//2013/02/22 hlc sonobe PR媒体追加対応　Start
//        }else if (targetBaitaiCd.equals("119")){
//            //PR
//            masterSybt = "221";
//        //2013/02/22 hlc sonobe PR媒体追加対応　End
//    	}else if (targetBaitaiCd.equals("190")
//    			|| targetBaitaiCd.equals("115")
//    			|| targetBaitaiCd.equals("116")
//    			|| targetBaitaiCd.equals("117")
//    			|| targetBaitaiCd.equals("118")
//    			|| targetBaitaiCd.equals("195")){
//    		//その他・ニューメディア・インターネット・BS・CS・調査
//    		masterSybt = "218";
//    	}
    	if (KKHConstants.TksKgyCode.ASH.getCode().equals(tksCd)){
    		//アサヒビールの場合
        	if (targetBaitaiCd.equals("100") || targetBaitaiCd.equals("110") || targetBaitaiCd.equals("105")){	// UPD 2015/06/08 K.F アサヒ対応
        		//テレビタイム・テレビスポット・テレビネットスポット
        		masterSybt = "204";
        	}else if (targetBaitaiCd.equals("120") || targetBaitaiCd.equals("125")){
        		//ラジオタイム・ラジオスポット
        		masterSybt = "205";
        	}else if (targetBaitaiCd.equals("130")){
        		//新聞
        		masterSybt = "202";
        	}else if (targetBaitaiCd.equals("140")){
        		//雑誌
        		masterSybt = "203";
        	}else if (targetBaitaiCd.equals("150")){
        		//交通
        		masterSybt = "206";
        	}else if (targetBaitaiCd.equals("230")){
        		//メディアフィー
        		masterSybt = "219";
        	}else if (targetBaitaiCd.equals("240")){
        		//ブランド管理フィー
        		masterSybt = "220";
        	}else if (targetBaitaiCd.equals("160") || targetBaitaiCd.equals("180")){
        		//屋外広告・イベント
        		masterSybt = "217";
        	}else if (targetBaitaiCd.equals("170")){
        		//制作
        		masterSybt = "216";
        	//2013/02/22 hlc sonobe PR媒体追加対応　Start
            }else if (targetBaitaiCd.equals("119")){
                //PR
                masterSybt = "221";
            //2013/02/22 hlc sonobe PR媒体追加対応　End
        	}else if (targetBaitaiCd.equals("190")
        			|| targetBaitaiCd.equals("115")
        			|| targetBaitaiCd.equals("116")
        			|| targetBaitaiCd.equals("117")
        			|| targetBaitaiCd.equals("118")
        			|| targetBaitaiCd.equals("195")
        			|| targetBaitaiCd.equals("193")
        			|| targetBaitaiCd.equals("194")
        			|| targetBaitaiCd.equals("199")){
        		//その他・ニューメディア・インターネット・BS・CS・調査・イメージガール・地元出稿・ニッカ
        		masterSybt = "218";
        	}
        	else
        	{
        		//上記以外はその他扱い
        		masterSybt = "218";
        	}
    	}else{
    		//アサヒ飲料の場合
        	if (targetBaitaiCd.equals("100") || targetBaitaiCd.equals("110")){
        		//テレビタイム・テレビスポット
        		masterSybt = "204";
        	}else if (targetBaitaiCd.equals("120") || targetBaitaiCd.equals("125")){
        		//ラジオタイム・ラジオスポット
        		masterSybt = "205";
        	}else if (targetBaitaiCd.equals("130")){
        		//新聞
        		masterSybt = "202";
        	}else if (targetBaitaiCd.equals("140")){
        		//雑誌
        		masterSybt = "203";
        	}else if (targetBaitaiCd.equals("150")){
        		//交通
        		masterSybt = "206";
        	}else if (targetBaitaiCd.equals("230")){
        		//メディアフィー
        		masterSybt = "219";
        	}else if (targetBaitaiCd.equals("240")){
        		//ブランド管理フィー
        		masterSybt = "220";
        	}else if (targetBaitaiCd.equals("160") || targetBaitaiCd.equals("180")){
        		//屋外広告・イベント
        		masterSybt = "217";
        	}else if (targetBaitaiCd.equals("170")){
        		//制作
        		masterSybt = "216";
        	//2013/02/22 hlc sonobe PR媒体追加対応　Start
            }else if (targetBaitaiCd.equals("119")){
                //PR
                masterSybt = "221";
            //2013/02/22 hlc sonobe PR媒体追加対応　End
        	}else if (targetBaitaiCd.equals("190")
        			|| targetBaitaiCd.equals("115")
        			|| targetBaitaiCd.equals("116")
        			|| targetBaitaiCd.equals("117")
        			|| targetBaitaiCd.equals("118")
        			|| targetBaitaiCd.equals("195")
        			|| targetBaitaiCd.equals("321")
        			|| targetBaitaiCd.equals("322")
        			|| targetBaitaiCd.equals("331")
        			|| targetBaitaiCd.equals("332")
        			|| targetBaitaiCd.equals("333")
        			|| targetBaitaiCd.equals("334")
        			|| targetBaitaiCd.equals("336")
        			|| targetBaitaiCd.equals("380")
        			|| targetBaitaiCd.equals("382")
        			|| targetBaitaiCd.equals("389")){
        		//その他・ニューメディア・インターネット・BS・CS・調査・PR・アメフト・タレント・著作権料
        		//素材代・CF調査・制作フィー・JASRAC・社内使用（広告料）・広告料（その他）
        		masterSybt = "218";
        	}
        	else
        	{
        		//上記以外はその他扱い
        		masterSybt = "218";
        	}
        	// UPD 2015/03/03 K.F アサヒ対応 END
    	}
    	// UPD 2015/03/03 K.F アサヒ対応 END

    	return masterSybt;
    }

    //**********************************************************************************************************************************************************************************
    //受注統合
    /**
     * 受注統合(明細統合)
     *
     * @param vo 受注統合VO
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public DetailDataAshMergeResult mergeDataForAsh(DetailDataAshMergeVO vo) throws KKHException {

        DetailDataAshMergeResult result = new DetailDataAshMergeResult();

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();

        //*********************************************************************************************************
        //受注ダウンロードデータの統合
        //*********************************************************************************************************
        //*********************************************************************************************************
        //排他制御
        //*********************************************************************************************************
        for (Thb1DownVO thb1DownVO : vo.getTougouMotoList()) {
            List<Thb1DownVO> lockThb1Down = dao.lockThb1Down(thb1DownVO);
            if (lockThb1Down.size() <= 0 || vo.getMaxUpdDate().compareTo(lockThb1Down.get(0).getHb1TimStmp()) < 0 ){
                throw new KKHException("排他エラー", "LOCK-E0001");
            }
        }

        //*********************************************************************************************************
        //データ更新
        //*********************************************************************************************************
        //統合元データの更新
        for (Thb1DownVO thb1DownVO : vo.getTougouMotoList()) {
            thb1DownVO.setHb1TJyutNo(vo.getTougouSaki().getHb1JyutNo());
            thb1DownVO.setHb1TJyMeiNo(vo.getTougouSaki().getHb1JyMeiNo());
            thb1DownVO.setHb1TUrMeiNo(vo.getTougouSaki().getHb1UrMeiNo());
            dao.updateThb1DownForJyutyuMerge(thb1DownVO);
        }

        //統合先データの登録
        dao.insertThb1Down(vo.getTougouSaki());

        //*********************************************************************************************************
        //明細データの統合
        //*********************************************************************************************************
        Thb2KmeiDAO thb2KmeiDAO = Thb2KmeiDAOFactory.createThb2KmeiDAO();
        Thb2KmeiVO thb2KmeiCond = new Thb2KmeiVO();                           // 統合先VO
        List<Thb2KmeiVO> tougouSakiList = new ArrayList<Thb2KmeiVO>();        // 統合先明細データ
        List<Thb2KmeiVO> tougouMotoList = new ArrayList<Thb2KmeiVO>();        // 統合元明細データ
        Boolean sumiFlg = true;                                               // 統合先フラグ(統合先明細の有無 有：True無：False)
        String baitaiCd = "";                                                 // 媒体コード

        // 統合先明細データ取得 ---------------------------------------------------------
        thb2KmeiCond.setHb2EgCd(vo.getTougouSaki().getHb1EgCd());
        thb2KmeiCond.setHb2TksKgyCd(vo.getTougouSaki().getHb1TksKgyCd());
        thb2KmeiCond.setHb2TksBmnSeqNo(vo.getTougouSaki().getHb1TksBmnSeqNo());
        thb2KmeiCond.setHb2TksTntSeqNo(vo.getTougouSaki().getHb1TksTntSeqNo());
        thb2KmeiCond.setHb2Yymm(vo.getTougouSaki().getHb1Yymm());
        thb2KmeiCond.setHb2JyutNo(vo.getTougouSaki().getHb1JyutNo());
        thb2KmeiCond.setHb2JyMeiNo(vo.getTougouSaki().getHb1JyMeiNo());
        thb2KmeiCond.setHb2UrMeiNo(vo.getTougouSaki().getHb1UrMeiNo());

        tougouSakiList = thb2KmeiDAO.findThb2KmeiByCondCmn(thb2KmeiCond);
        for(Thb2KmeiVO hb2Vo : tougouSakiList)
        {
            // 統合先明細の媒体コードを取得
            baitaiCd = hb2Vo.getHb2Code1().trim();
            sumiFlg = true;
            break;
        }

        // 統合先明細の媒体コードが取得出来なかった場合
        if (baitaiCd.length() == 0) {

            //パラメータの媒体コードを使用する
            baitaiCd = vo.getBaitaiCd();
            sumiFlg = false;
        }

        // 統合元明細データ取得 ---------------------------------------------------------
        for (Thb1DownVO thb1DownVO : vo.getTougouMotoList()) {

            // 統合先のキー項目と同じ場合は、明細データを取得しない
            if (thb2KmeiCond.getHb2EgCd().equals(thb1DownVO.getHb1EgCd()) &&
                thb2KmeiCond.getHb2TksKgyCd().equals(thb1DownVO.getHb1TksKgyCd()) &&
                thb2KmeiCond.getHb2TksBmnSeqNo().equals(thb1DownVO.getHb1TksBmnSeqNo()) &&
                thb2KmeiCond.getHb2TksTntSeqNo().equals(thb1DownVO.getHb1TksTntSeqNo()) &&
                thb2KmeiCond.getHb2Yymm().equals(thb1DownVO.getHb1Yymm()) &&
                thb2KmeiCond.getHb2JyutNo().equals(thb1DownVO.getHb1JyutNo()) &&
                thb2KmeiCond.getHb2JyMeiNo().equals(thb1DownVO.getHb1JyMeiNo()) &&
                thb2KmeiCond.getHb2UrMeiNo().equals(thb1DownVO.getHb1UrMeiNo()) ) {
                continue;
            }

            Thb2KmeiVO cond = new Thb2KmeiVO();
            cond.setHb2EgCd(thb1DownVO.getHb1EgCd());
            cond.setHb2TksKgyCd(thb1DownVO.getHb1TksKgyCd());
            cond.setHb2TksBmnSeqNo(thb1DownVO.getHb1TksBmnSeqNo());
            cond.setHb2TksTntSeqNo(thb1DownVO.getHb1TksTntSeqNo());
            cond.setHb2Yymm(thb1DownVO.getHb1Yymm());
            cond.setHb2JyutNo(thb1DownVO.getHb1JyutNo());
            cond.setHb2JyMeiNo(thb1DownVO.getHb1JyMeiNo());
            cond.setHb2UrMeiNo(thb1DownVO.getHb1UrMeiNo());
            List<Thb2KmeiVO> list = thb2KmeiDAO.findThb2KmeiByCondCmn(cond);

            for(Thb2KmeiVO hb2Vo : list) {

                // 同一媒体コードのレコードのみ対象
                if (baitaiCd.equals(hb2Vo.getHb2Code1().trim())) {
                    tougouMotoList.add(hb2Vo);
                }
            }
        }

        DetailDataAshDAO ashDao = DetailDataAshDAOFactory.createDetailDataDAO();
        String renban = "";
        int renbanNum = 0;

        // 統合元データの編集と登録 -------------------------------------------------------
        if (baitaiCd.equals("100") || baitaiCd.equals("120")) {

            // テレビタイム/ラジオタイムの場合(Update/Insertデータ)
            if (sumiFlg) {

                // タイム用集計処理へ(Updateデータ作成)
                List<Thb2KmeiVO> updateList = this.getSumTvRdUpdateList(vo.getTougouSaki(), tougouSakiList, tougouMotoList);

                // 更新
                UpdateDataAshDAO updDao = UpdateDataAshDAOFactory.createUpdateOutFlgDAO();
                for (Thb2KmeiVO updateVo : updateList) {
                    updDao.updateThb2Kmei(updateVo);
                }
            }

            // タイム用集計処理へ(Insertデータ作成)
            List<Thb2KmeiVO> insertList = this.getSumTvRdInsertList(vo.getTougouSaki(), tougouSakiList, tougouMotoList);
            // 登録
            for (Thb2KmeiVO motoVo : insertList) {
                // 連番の最大値取得
                List<Thb2KmeiVO> renbanList = ashDao.selectThb2KmeiMaxRenbn(motoVo);

                //連番を取得できなかった場合
                if(renbanList.get(0).getHb2Renbn().equals(""))
                {
                	renban = "0";
                }
                else{
	                for(Thb2KmeiVO renbanVo : renbanList) {
	                    renban = renbanVo.getHb2Renbn();
	                }
                }

                renbanNum = Integer.parseInt(renban) + 1;

                // 連番の最大値を超えた場合はエラーとする
                //if (renbanNum > 999) {  2013/05/09 hlc sonobe 登録件数拡張
                if (renbanNum > 9999) {
                    throw new KKHException("明細統合エラー", "HB-E0020");
                }
                motoVo.setHb2Renbn(String.format("%1$03d", renbanNum));

                // 統合元データの登録
                thb2KmeiDAO.insertThb2Kmei(motoVo);
            }


        } else {
            // タイム以外
            List<Thb2KmeiVO> insertList = this.getMotoDataList(vo.getTougouSaki(), tougouMotoList);
            // 登録
            for (Thb2KmeiVO motoVo : insertList) {
                // 連番の最大値取得
            	List<Thb2KmeiVO> renbanList = ashDao.selectThb2KmeiMaxRenbn(motoVo);

                //連番を取得できなかった場合
                if(renbanList.get(0).getHb2Renbn().equals(""))
                {
                	renban = "0";
                }
                else{
	                for(Thb2KmeiVO renbanVo : renbanList) {
	                    renban = renbanVo.getHb2Renbn();
	                }
                }

                renbanNum = Integer.parseInt(renban) + 1;

                // 連番の最大値を超えた場合はエラーとする
                //if (renbanNum > 999) {  2013/05/09 hlc sonobe 登録件数拡張
                if (renbanNum > 9999) {
                    throw new KKHException("明細統合エラー", "HB-E0020");
                }
                motoVo.setHb2Renbn(String.format("%1$03d", renbanNum));

                // 統合元データの登録
                thb2KmeiDAO.insertThb2Kmei(motoVo);
            }
        }

    	return result;
    }

    /**
     * テレビタイム/ラジオタイムの集計(Insert)
     *
     * @param tougouSaki 統合先情報
     * @param tougouSakiList 統合先明細データ
     * @param tougouMotoList 統合元明細データ
     * @return 統合元データのテレビタイム/ラジオタイム集計結果
     */
    @SuppressWarnings("unchecked")
	private List<Thb2KmeiVO> getSumTvRdInsertList(Thb1DownVO tougouSaki, List<Thb2KmeiVO> tougouSakiList, List<Thb2KmeiVO> tougouMotoList) {

        List<Thb2KmeiVO> retList = new ArrayList<Thb2KmeiVO>();
        Map map = new HashMap();

        for(Thb2KmeiVO sakiVo : tougouSakiList) {
            map.put(sakiVo.getHb2Code2() + sakiVo.getHb2Code3(), sakiVo);
        }

        // 「局コード(コード2)」「品種コード(コード3)」同じでない明細をリストに追加
        for(Thb2KmeiVO motoVo : tougouMotoList) {

            if (map.containsKey(motoVo.getHb2Code2() + motoVo.getHb2Code3()) == false) {
                // 統合先受注No
                motoVo.setHb2JyutNo(tougouSaki.getHb1JyutNo().trim());

                // 統合先受注明細No
                motoVo.setHb2JyMeiNo(tougouSaki.getHb1JyMeiNo().trim());

                // 統合先売上明細No
                motoVo.setHb2UrMeiNo(tougouSaki.getHb1UrMeiNo().trim());

                // 統合先件名
                // 2013/01/17 JSE M.Naito
                //motoVo.setHb2Name8(tougouSaki.getHb1KKNameKJ().trim());
                motoVo.setHb2Name10(tougouSaki.getHb1KKNameKJ().trim());

                // 統合先キー局
                //請求区分がタイムの場合
                if(tougouSaki.getHb1SeiKbn().equals("41")){
                	//局数をセットする
                    motoVo.setHb2Sonota7(tougouSaki.getHb1Field3());
                }else
                {
                	//０をセットする
                    motoVo.setHb2Sonota7("0");
                }

                // 統合先局数
                motoVo.setHb2Sonota8(tougouSaki.getHb1Field1());

                retList.add(motoVo);
            }
        }
        return retList;
    }


    /**
     * テレビタイム/ラジオタイムの集計(Update)
     *
     * @param tougouSaki 統合先情報
     * @param tougouSakiList 統合先明細データ
     * @param tougouMotoList 統合元明細データ
     * @return 統合元データのテレビタイム/ラジオタイム集計結果
     */
    private List<Thb2KmeiVO> getSumTvRdUpdateList(Thb1DownVO tougouSaki, List<Thb2KmeiVO> tougouSakiList, List<Thb2KmeiVO> tougouMotoList) {

        List<Thb2KmeiVO> retList = new ArrayList<Thb2KmeiVO>();

        // 「局コード(コード2)」「品種コード(コード3)」と同じ情報を収集(統合元集計)
        for(Thb2KmeiVO motoVo : tougouMotoList) {

            for(Thb2KmeiVO sakiVo : tougouSakiList) {

                // コード2/コード3比較
                if (sakiVo.getHb2Code2().equals(motoVo.getHb2Code2()) &&
                    sakiVo.getHb2Code3().equals(motoVo.getHb2Code3())) {

                    // 統合先受注No
                    sakiVo.setHb2JyutNo(tougouSaki.getHb1JyutNo().trim());

                    // 統合先受注明細No
                    sakiVo.setHb2JyMeiNo(tougouSaki.getHb1JyMeiNo().trim());

                    // 統合先売上明細No
                    sakiVo.setHb2UrMeiNo(tougouSaki.getHb1UrMeiNo().trim());

                    // 請求額
                    sakiVo.setHb2SeiGak( motoVo.getHb2SeiGak().add(sakiVo.getHb2SeiGak()) );

                    // 見積金額
                    sakiVo.setHb2HnmaeGak( motoVo.getHb2HnmaeGak().add(sakiVo.getHb2HnmaeGak()) );

                    retList.add(sakiVo);
                }
            }
        }

        return retList;
    }

    /**
     * 統合元データの作成
     *
     * @param tougouSaki 統合先情報
     * @param tougouMotoList 統合元明細データ
     * @return 統合元明細データ
     */
    private List<Thb2KmeiVO> getMotoDataList(Thb1DownVO tougouSaki, List<Thb2KmeiVO> tougouMotoList) {

        List<Thb2KmeiVO> retList = new ArrayList<Thb2KmeiVO>();

        for(Thb2KmeiVO motoVo : tougouMotoList) {
            // vo取得
            Thb2KmeiVO vo = motoVo;

            // 統合先受注No
            vo.setHb2JyutNo(tougouSaki.getHb1JyutNo().trim());

            // 統合先受注明細No
            vo.setHb2JyMeiNo(tougouSaki.getHb1JyMeiNo().trim());

            // 統合先売上明細No
            vo.setHb2UrMeiNo(tougouSaki.getHb1UrMeiNo().trim());

            // 統合先件名
            // 2013/01/17 JSE M.Naito
            //vo.setHb2Name8(tougouSaki.getHb1KKNameKJ().trim());
            vo.setHb2Name10(tougouSaki.getHb1KKNameKJ().trim());

            retList.add(vo);
        }

        return retList;
    }

    /**
     * 広告費明細データを検索します。
     *
     * @return DetailDataResult 汎用マスタ検索データ
     * @throws KKHException 処理中にエラーが発生した場合
     */
    public GetFDSeqResult getFDSeq(GetFDSeqCondition cond) throws KKHException {
    	GetFDSeqResult result = new GetFDSeqResult();

    	GetFDSeqDAO dao = GetFDSeqDAOFactory.createDetailDataDAO();

    	List<String> list = dao.getFDSeq(cond);
    	if (list.size() > 0){
    		result.setFdSeq(list.get(0));
    	}

    	return result;
    }

}
