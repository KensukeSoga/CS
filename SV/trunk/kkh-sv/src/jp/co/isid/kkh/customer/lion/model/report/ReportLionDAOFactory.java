package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionBSCSDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionDigitalMovieDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionInterNetDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionJigyouBuDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionKoutsuDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionMobileDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionSamplingDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionSeisakDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionShinbunDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionSocialMediaDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionSonotaDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionTiraShiDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionTvSpotDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionRdSpotDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionTvTimeDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionRdTimeDAO;
import jp.co.isid.kkh.customer.lion.model.report.proof.ReportLionZashiDAO;
import jp.co.isid.nj.integ.DaoFactory;
import jp.co.isid.kkh.customer.lion.util.LionConstants;

/**
 * <P>
 * ライオンプルーフリスト検索DAOファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2012/01/11)<BR>
 * </P>
 *
 * @author
 */

public class ReportLionDAOFactory extends DaoFactory{

    /**
    * インスタンス化を禁止します。
    */
    private ReportLionDAOFactory() {
    }

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
/*
        public static ReportLionDAO createReportLionDAO() {
            return (ReportLionDAO) DaoFactory.createDao(ReportLionDAO.class);
        }*/

    /**
    * DAOインスタンスを生成します。
    * @return DAOインスタンス
    */
    public static ReportLionProofDaoInterface createReportLionDAO(String baitai) {

        ReportLionProofDaoInterface dao = null;

//		    	if (baitai.equals("TVTIME")){
//		    		dao=(ReportLionPurufuDaoInterface) DaoFactory.createDao(ReportLionTvTimeDAO.class);
//		    	}

        //****************
        //変数
        //****************
        String _strTvTime = LionConstants.BaitaiCode.TV_TIME.getName();	//テレビタイム
        String _strRdTime = LionConstants.BaitaiCode.RD_TIME.getName();	//ラジオタイム
        String _strTvSpot = LionConstants.BaitaiCode.TV_SPOT.getName();	//テレビスポット
        String _strRdSpot = LionConstants.BaitaiCode.RD_SPOT.getName();	//ラジオスポット
        String _strShin  = LionConstants.BaitaiCode.SHINBUN.getName();	//新聞
        String _strZashi  = LionConstants.BaitaiCode.ZASHI.getName();	//雑誌
        String _strKotsu  = LionConstants.BaitaiCode.KOTSU.getName();	//交通
        String _strSono  = LionConstants.BaitaiCode.SONOTA.getName();	//その他
        String _strSei  = LionConstants.BaitaiCode.SEISAKU.getName();		//制作
        String _strTvCm  = LionConstants.BaitaiCode.TV_CM.getName();	//テレビCM秒数
        String _strRdCm  = LionConstants.BaitaiCode.RD_CM.getName();	//ラジオCM秒数
        String _strChira  = LionConstants.BaitaiCode.CHIRASHI.getName();	//チラシ
        String _strSampl  = LionConstants.BaitaiCode.SAMPLING.getName();	//サンプル
        String _strBsCs  = LionConstants.BaitaiCode.BS_CS.getName();	//BS・CS
        String _strInter  = LionConstants.BaitaiCode.INTERNET.getName();	//インターネット
        String _strMob  = LionConstants.BaitaiCode.MOBILE.getName();		//モバイル
        String _strJigyo  = LionConstants.BaitaiCode.JIGYOHI.getName();	//事業費
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Add Start
        //ソーシャルメディアとデジタル動画を追加
        String _strSocial  = LionConstants.BaitaiCode.SOCIALMEDIA.getName(); //ソーシャルメディア
        String _strDigital  = LionConstants.BaitaiCode.DIGITALMOVIE.getName(); //デジタル動画
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Add End

        //****************
        //媒体で分岐
        //****************
        //テレビタイム
        if(baitai.equals(_strTvTime)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionTvTimeDAO.class);
        }
        //ラジオタイム
        else if(baitai.equals(_strRdTime)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionRdTimeDAO.class);
        }
        //テレビスポット
        else if(baitai.equals(_strTvSpot)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionTvSpotDAO.class);
        }
        //ラジオスポット
        else if(baitai.equals(_strRdSpot)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionRdSpotDAO.class);
        }
        //新聞
        else if(baitai.equals(_strShin)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionShinbunDAO.class);
        }
        //雑誌
        else if(baitai.equals(_strZashi)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionZashiDAO.class);
        }
        //交通
        else if(baitai.equals(_strKotsu)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionKoutsuDAO.class);
        }
        //その他
        else if(baitai.equals(_strSono)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionSonotaDAO.class);
        }
        //制作
        else if(baitai.equals(_strSei)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionSeisakDAO.class);
        }
        //テレビCM秒数
        else if(baitai.equals(_strTvCm)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionRdSpotDAO.class);
        }
        //ラジオCM秒数
        else if(baitai.equals(_strRdCm)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionRdSpotDAO.class);
        }
        //チラシ
        else if(baitai.equals(_strChira)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionTiraShiDAO.class);
        }
        //サンプル
        else if(baitai.equals(_strSampl)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionSamplingDAO.class);
        }
        //BS・CS
        else if(baitai.equals(_strBsCs)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionBSCSDAO.class);
        }
        //インターネット
        else if(baitai.equals(_strInter)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionInterNetDAO.class);
        }
        //モバイル
        else if(baitai.equals(_strMob)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionMobileDAO.class);
        }
        //事業費
        else if(baitai.equals(_strJigyo)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionJigyouBuDAO.class);
        }
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Add Start
        //ソーシャルメディア
        else if(baitai.equals(_strSocial)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionSocialMediaDAO.class);
        }
        //デジタル動画
        else if(baitai.equals(_strDigital)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionDigitalMovieDAO.class);
        }
        //2017/06/05 ライオン対応 ITCOM A.Nakamura Add End
        return dao;
    }

}
