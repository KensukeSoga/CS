package jp.co.isid.kkh.customer.lion.model.report;

import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionBSCSDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionDigitalMovieDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionInterNetDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionJigyouBuDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionKoutsuDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionMobileDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionSamplingDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionSeisakDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionShinbunDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionSocialMediaDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionSonotaDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionTiraShiDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionTvSpotDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionRdSpotDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionTvTimeDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionRdTimeDAO;
import jp.co.isid.kkh.customer.lion.model.report.detaillist.DetailListLionZashiDAO;
import jp.co.isid.nj.integ.DaoFactory;
import jp.co.isid.kkh.customer.lion.util.LionConstants;

/**
 * <P>
 * 汎用マスタ検索DAOのファクトリクラス
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/07)<BR>
 * </P>
 * @author
 */

public class DetailListLionDAOFactory extends DaoFactory{
    /**
	    * インスタンス化を禁止します。
	    */
	    private DetailListLionDAOFactory() {
	    }

	    /**
	    * DAOインスタンスを生成します。
	    * @return DAOインスタンス
	    */

	    /**
	    * DAOインスタンスを生成します。
	    * @return DAOインスタンス
	    */
	    public static DetailListLionDaoInterface createDetailListLionDAO(String ymfrom
	                                                                     ,String ymto
	                                                                     ,String baitaikbn
	                                                                     ) {

	        DetailListLionDaoInterface dao = null;

	    	//****************
	    	//変数
	    	//****************
	    	String _strTvBangumi = LionConstants.MastBaitaiKbn.TV_BANGUMI.getCode();	//ＴＶ番組
	    	String _strTvSpot = LionConstants.MastBaitaiKbn.TV_SPOT.getCode();	//ＴＶスポット
	    	String _strRdBangumi = LionConstants.MastBaitaiKbn.RD_BANGUMI.getCode();	//ラジオ番組
	    	String _strRdSpot = LionConstants.MastBaitaiKbn.RD_SPOT.getCode();	//ラジオスポット
	    	String _strShinbun  = LionConstants.MastBaitaiKbn.SHINBUN.getCode();	//新聞
	    	String _strZashi  = LionConstants.MastBaitaiKbn.ZASHI.getCode();	//雑誌
	    	String _strKotsu  = LionConstants.MastBaitaiKbn.KOTSU.getCode();	//交通広告
	    	String _strSenden  = LionConstants.MastBaitaiKbn.SENDEN.getCode();	//宣伝間接費
	    	String _strTirashi  = LionConstants.MastBaitaiKbn.TIRASHI.getCode();		//チラシ
	    	String _strSampling  = LionConstants.MastBaitaiKbn.SAMPLING.getCode();	//サンプリング
	    	String _strBsCs  = LionConstants.MastBaitaiKbn.BSCS.getCode();	//ＢＳ・ＣＳ
	    	String _strInternet  = LionConstants.MastBaitaiKbn.INTERNET.getCode();	//インターネット
	    	//2017/06/05 ライオン対応 ITCOM A.Nakamura Add Start
	    	String _strSocial  = LionConstants.MastBaitaiKbn.SOCIALMEDIA.getCode();	//ソーシャルメディア
	    	String _strDigital  = LionConstants.MastBaitaiKbn.DIGITALMOVIE.getCode();	//デジタル動画
	    	//2017/06/05 ライオン対応 ITCOM A.Nakamura Add End
	    	String _strMobile  = LionConstants.MastBaitaiKbn.MOBILE.getCode();	//モバイル
	    	String _strJigyouhi  = LionConstants.MastBaitaiKbn.JIGYOUHI.getCode();	//事業費
	    	String _strSeiTvcfSeisaku  = LionConstants.MastBaitaiKbn.SEISAKU_TVCF_SEISAKU.getCode();	//制作部．ＴＶＣＦ制作
	    	String _strSeiTvcfPrint  = LionConstants.MastBaitaiKbn.SEISAKU_TVCF_PRINT.getCode();		//制作部．ＴＶＣＦプリント費
	    	String _strSeiCm  = LionConstants.MastBaitaiKbn.SEISAKU_CM.getCode();	//制作部．ナマＣＭ
            String _strSeiTyousa = LionConstants.MastBaitaiKbn.SEISAKU_TYOUSA.getCode();  //制作部．調査費
            String _strSeiRd = LionConstants.MastBaitaiKbn.SEISAKU_RD.getCode();  //制作部．ラジオ
            String _strSeiShinbun = LionConstants.MastBaitaiKbn.SEISAKU_SHINBUN.getCode();  //制作部．新聞
            String _strSeiZashi = LionConstants.MastBaitaiKbn.SEISAKU_ZASHI.getCode();  //制作部．雑誌
            String _strSeiTalent  = LionConstants.MastBaitaiKbn.SEISAKU_TALENT.getCode();   //制作部．タレント
            String _strSeiWeb  = LionConstants.MastBaitaiKbn.SEISAKU_WEB.getCode();    //制作部．WEB
            //2017/06/05 ライオン対応 ITCOM A.Nakamura Add Start
            String _strSeiDigital  = LionConstants.MastBaitaiKbn.SEISAKU_DIGITAL.getCode();    //制作部．デジタル動画
            //2017/06/05 ライオン対応 ITCOM A.Nakamura Add End
            String _strSeiKokoku  = LionConstants.MastBaitaiKbn.SEISAKU_KOKOKU.getCode();    //制作部．雑広告
            String _strSeiKotsu  = LionConstants.MastBaitaiKbn.SEISAKU_KOTSU.getCode();    //制作部．交通
            String _strSeiKansetsu  = LionConstants.MastBaitaiKbn.SEISAKU_KANSETSU.getCode();        //制作部．間接費
            String _strSeiKaihatsu  = LionConstants.MastBaitaiKbn.SEISAKU_KAIHATSU.getCode(); //制作部．開発費
            String _strSeiPackage  = LionConstants.MastBaitaiKbn.SEISAKU_PACKAGE.getCode(); //制作部．パッケージ制作
            String _strSeiZei1  = LionConstants.MastBaitaiKbn.SEISAKU_ZEI1.getCode(); //制作部．制作消費税(1)
            String _strSeiZei2  = LionConstants.MastBaitaiKbn.SEISAKU_ZEI2.getCode(); //制作部．制作消費税(2)
            String _strBaiZei1  = LionConstants.MastBaitaiKbn.BAITAI_ZEI1.getCode(); //媒体消費税(1)
            String _strBaiZei2  = LionConstants.MastBaitaiKbn.BAITAI_ZEI2.getCode(); //媒体消費税(2)

	    	//****************
	    	//媒体で分岐
	    	//****************
	    	//ＴＶ番組
	    	if(baitaikbn.equals(_strTvBangumi)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionTvTimeDAO.class);
	    	}
	    	//ＴＶスポット
	    	else if(baitaikbn.equals(_strTvSpot)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionTvSpotDAO.class);
	    	}
	    	//ラジオ番組
	    	else if(baitaikbn.equals(_strRdBangumi)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionRdTimeDAO.class);
	    	}
	    	//ラジオスポット
	    	else if(baitaikbn.equals(_strRdSpot)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionRdSpotDAO.class);
	    	}
	    	//新聞
	    	else if(baitaikbn.equals(_strShinbun)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionShinbunDAO.class);
	    	}
	    	//雑誌
	    	else if(baitaikbn.equals(_strZashi)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionZashiDAO.class);
	    	}
	    	//交通広告
	    	else if(baitaikbn.equals(_strKotsu)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionKoutsuDAO.class);
	    	}
	    	//宣伝間接費
	    	else if(baitaikbn.equals(_strSenden)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSonotaDAO.class);
	    	}
	    	//チラシ
	    	else if(baitaikbn.equals(_strTirashi)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionTiraShiDAO.class);
	    	}
	    	//サンプリング
	    	else if(baitaikbn.equals(_strSampling)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSamplingDAO.class);
	    	}
	    	//ＢＳ・ＣＳ
	    	else if(baitaikbn.equals(_strBsCs)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionBSCSDAO.class);
	    	}
	    	//インターネット
	    	else if(baitaikbn.equals(_strInternet)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionInterNetDAO.class);
	    	}
	    	//2017/06/05 ライオン対応 ITCOM A.Nakamura Add Start
	    	//ソーシャルメディア
	    	else if(baitaikbn.equals(_strSocial)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSocialMediaDAO.class);
	    	}
	    	//デジタル動画
	    	else if(baitaikbn.equals(_strDigital)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionDigitalMovieDAO.class);
	    	}
	    	//2017/06/05 ライオン対応 ITCOM A.Nakamura Add End
	    	//モバイル
	    	else if(baitaikbn.equals(_strMobile)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionMobileDAO.class);
	    	}
	    	//事業費
	    	else if(baitaikbn.equals(_strJigyouhi)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionJigyouBuDAO.class);
	    	}
	    	//制作部．ＴＶＣＦ制作
	    	else if(baitaikbn.equals(_strSeiTvcfSeisaku)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
	    	}
	    	//制作部．ＴＶＣＦプリント費
	    	else if(baitaikbn.equals(_strSeiTvcfPrint)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
	    	}
	    	//制作部．ナマＣＭ
	    	else if(baitaikbn.equals(_strSeiCm)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
	    	}
	        //制作部．調査費
            else if(baitaikbn.equals(_strSeiTyousa)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //制作部．ラジオ
            else if(baitaikbn.equals(_strSeiRd)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //制作部．新聞
            else if(baitaikbn.equals(_strSeiShinbun)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //制作部．雑誌
            else if(baitaikbn.equals(_strSeiZashi)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //制作部．タレント
            else if(baitaikbn.equals(_strSeiTalent)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //制作部．WEB
            else if(baitaikbn.equals(_strSeiWeb)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
	    	//2017/06/05 ライオン対応 ITCOM A.Nakamura Add Start
	    	//制作部．デジタル動画
            else if(baitaikbn.equals(_strSeiDigital)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
	    	//2017/06/05 ライオン対応 ITCOM A.Nakamura Add End
	         //制作部．雑広告
            else if(baitaikbn.equals(_strSeiKokoku)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //制作部．交通
            else if(baitaikbn.equals(_strSeiKotsu)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //制作部．間接費
            else if(baitaikbn.equals(_strSeiKansetsu)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //制作部．開発費
            else if(baitaikbn.equals(_strSeiKaihatsu)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //制作部．パッケージ制作
            else if(baitaikbn.equals(_strSeiPackage)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //制作部．制作消費税(1)
            else if(baitaikbn.equals(_strSeiZei1)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
	        //制作部．制作消費税(2)
            else if(baitaikbn.equals(_strSeiZei2)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //媒体消費税(1)
            else if(baitaikbn.equals(_strBaiZei1)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSonotaDAO.class);
            }
            //媒体消費税(2)
            else if(baitaikbn.equals(_strBaiZei2)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSonotaDAO.class);
            }

	    	return dao;
	    }

}
