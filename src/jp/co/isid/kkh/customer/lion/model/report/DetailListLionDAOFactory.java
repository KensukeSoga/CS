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
 * �ėp�}�X�^����DAO�̃t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2013/02/07)<BR>
 * </P>
 * @author
 */

public class DetailListLionDAOFactory extends DaoFactory{
    /**
	    * �C���X�^���X�����֎~���܂��B
	    */
	    private DetailListLionDAOFactory() {
	    }

	    /**
	    * DAO�C���X�^���X�𐶐����܂��B
	    * @return DAO�C���X�^���X
	    */

	    /**
	    * DAO�C���X�^���X�𐶐����܂��B
	    * @return DAO�C���X�^���X
	    */
	    public static DetailListLionDaoInterface createDetailListLionDAO(String ymfrom
	                                                                     ,String ymto
	                                                                     ,String baitaikbn
	                                                                     ) {

	        DetailListLionDaoInterface dao = null;

	    	//****************
	    	//�ϐ�
	    	//****************
	    	String _strTvBangumi = LionConstants.MastBaitaiKbn.TV_BANGUMI.getCode();	//�s�u�ԑg
	    	String _strTvSpot = LionConstants.MastBaitaiKbn.TV_SPOT.getCode();	//�s�u�X�|�b�g
	    	String _strRdBangumi = LionConstants.MastBaitaiKbn.RD_BANGUMI.getCode();	//���W�I�ԑg
	    	String _strRdSpot = LionConstants.MastBaitaiKbn.RD_SPOT.getCode();	//���W�I�X�|�b�g
	    	String _strShinbun  = LionConstants.MastBaitaiKbn.SHINBUN.getCode();	//�V��
	    	String _strZashi  = LionConstants.MastBaitaiKbn.ZASHI.getCode();	//�G��
	    	String _strKotsu  = LionConstants.MastBaitaiKbn.KOTSU.getCode();	//��ʍL��
	    	String _strSenden  = LionConstants.MastBaitaiKbn.SENDEN.getCode();	//��`�Ԑڔ�
	    	String _strTirashi  = LionConstants.MastBaitaiKbn.TIRASHI.getCode();		//�`���V
	    	String _strSampling  = LionConstants.MastBaitaiKbn.SAMPLING.getCode();	//�T���v�����O
	    	String _strBsCs  = LionConstants.MastBaitaiKbn.BSCS.getCode();	//�a�r�E�b�r
	    	String _strInternet  = LionConstants.MastBaitaiKbn.INTERNET.getCode();	//�C���^�[�l�b�g
	    	//2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add Start
	    	String _strSocial  = LionConstants.MastBaitaiKbn.SOCIALMEDIA.getCode();	//�\�[�V�������f�B�A
	    	String _strDigital  = LionConstants.MastBaitaiKbn.DIGITALMOVIE.getCode();	//�f�W�^������
	    	//2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add End
	    	String _strMobile  = LionConstants.MastBaitaiKbn.MOBILE.getCode();	//���o�C��
	    	String _strJigyouhi  = LionConstants.MastBaitaiKbn.JIGYOUHI.getCode();	//���Ɣ�
	    	String _strSeiTvcfSeisaku  = LionConstants.MastBaitaiKbn.SEISAKU_TVCF_SEISAKU.getCode();	//���암�D�s�u�b�e����
	    	String _strSeiTvcfPrint  = LionConstants.MastBaitaiKbn.SEISAKU_TVCF_PRINT.getCode();		//���암�D�s�u�b�e�v�����g��
	    	String _strSeiCm  = LionConstants.MastBaitaiKbn.SEISAKU_CM.getCode();	//���암�D�i�}�b�l
            String _strSeiTyousa = LionConstants.MastBaitaiKbn.SEISAKU_TYOUSA.getCode();  //���암�D������
            String _strSeiRd = LionConstants.MastBaitaiKbn.SEISAKU_RD.getCode();  //���암�D���W�I
            String _strSeiShinbun = LionConstants.MastBaitaiKbn.SEISAKU_SHINBUN.getCode();  //���암�D�V��
            String _strSeiZashi = LionConstants.MastBaitaiKbn.SEISAKU_ZASHI.getCode();  //���암�D�G��
            String _strSeiTalent  = LionConstants.MastBaitaiKbn.SEISAKU_TALENT.getCode();   //���암�D�^�����g
            String _strSeiWeb  = LionConstants.MastBaitaiKbn.SEISAKU_WEB.getCode();    //���암�DWEB
            //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add Start
            String _strSeiDigital  = LionConstants.MastBaitaiKbn.SEISAKU_DIGITAL.getCode();    //���암�D�f�W�^������
            //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add End
            String _strSeiKokoku  = LionConstants.MastBaitaiKbn.SEISAKU_KOKOKU.getCode();    //���암�D�G�L��
            String _strSeiKotsu  = LionConstants.MastBaitaiKbn.SEISAKU_KOTSU.getCode();    //���암�D���
            String _strSeiKansetsu  = LionConstants.MastBaitaiKbn.SEISAKU_KANSETSU.getCode();        //���암�D�Ԑڔ�
            String _strSeiKaihatsu  = LionConstants.MastBaitaiKbn.SEISAKU_KAIHATSU.getCode(); //���암�D�J����
            String _strSeiPackage  = LionConstants.MastBaitaiKbn.SEISAKU_PACKAGE.getCode(); //���암�D�p�b�P�[�W����
            String _strSeiZei1  = LionConstants.MastBaitaiKbn.SEISAKU_ZEI1.getCode(); //���암�D��������(1)
            String _strSeiZei2  = LionConstants.MastBaitaiKbn.SEISAKU_ZEI2.getCode(); //���암�D��������(2)
            String _strBaiZei1  = LionConstants.MastBaitaiKbn.BAITAI_ZEI1.getCode(); //�}�̏����(1)
            String _strBaiZei2  = LionConstants.MastBaitaiKbn.BAITAI_ZEI2.getCode(); //�}�̏����(2)

	    	//****************
	    	//�}�̂ŕ���
	    	//****************
	    	//�s�u�ԑg
	    	if(baitaikbn.equals(_strTvBangumi)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionTvTimeDAO.class);
	    	}
	    	//�s�u�X�|�b�g
	    	else if(baitaikbn.equals(_strTvSpot)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionTvSpotDAO.class);
	    	}
	    	//���W�I�ԑg
	    	else if(baitaikbn.equals(_strRdBangumi)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionRdTimeDAO.class);
	    	}
	    	//���W�I�X�|�b�g
	    	else if(baitaikbn.equals(_strRdSpot)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionRdSpotDAO.class);
	    	}
	    	//�V��
	    	else if(baitaikbn.equals(_strShinbun)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionShinbunDAO.class);
	    	}
	    	//�G��
	    	else if(baitaikbn.equals(_strZashi)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionZashiDAO.class);
	    	}
	    	//��ʍL��
	    	else if(baitaikbn.equals(_strKotsu)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionKoutsuDAO.class);
	    	}
	    	//��`�Ԑڔ�
	    	else if(baitaikbn.equals(_strSenden)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSonotaDAO.class);
	    	}
	    	//�`���V
	    	else if(baitaikbn.equals(_strTirashi)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionTiraShiDAO.class);
	    	}
	    	//�T���v�����O
	    	else if(baitaikbn.equals(_strSampling)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSamplingDAO.class);
	    	}
	    	//�a�r�E�b�r
	    	else if(baitaikbn.equals(_strBsCs)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionBSCSDAO.class);
	    	}
	    	//�C���^�[�l�b�g
	    	else if(baitaikbn.equals(_strInternet)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionInterNetDAO.class);
	    	}
	    	//2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add Start
	    	//�\�[�V�������f�B�A
	    	else if(baitaikbn.equals(_strSocial)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSocialMediaDAO.class);
	    	}
	    	//�f�W�^������
	    	else if(baitaikbn.equals(_strDigital)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionDigitalMovieDAO.class);
	    	}
	    	//2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add End
	    	//���o�C��
	    	else if(baitaikbn.equals(_strMobile)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionMobileDAO.class);
	    	}
	    	//���Ɣ�
	    	else if(baitaikbn.equals(_strJigyouhi)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionJigyouBuDAO.class);
	    	}
	    	//���암�D�s�u�b�e����
	    	else if(baitaikbn.equals(_strSeiTvcfSeisaku)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
	    	}
	    	//���암�D�s�u�b�e�v�����g��
	    	else if(baitaikbn.equals(_strSeiTvcfPrint)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
	    	}
	    	//���암�D�i�}�b�l
	    	else if(baitaikbn.equals(_strSeiCm)){
	    		dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
	    	}
	        //���암�D������
            else if(baitaikbn.equals(_strSeiTyousa)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //���암�D���W�I
            else if(baitaikbn.equals(_strSeiRd)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //���암�D�V��
            else if(baitaikbn.equals(_strSeiShinbun)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //���암�D�G��
            else if(baitaikbn.equals(_strSeiZashi)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //���암�D�^�����g
            else if(baitaikbn.equals(_strSeiTalent)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //���암�DWEB
            else if(baitaikbn.equals(_strSeiWeb)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
	    	//2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add Start
	    	//���암�D�f�W�^������
            else if(baitaikbn.equals(_strSeiDigital)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
	    	//2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add End
	         //���암�D�G�L��
            else if(baitaikbn.equals(_strSeiKokoku)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //���암�D���
            else if(baitaikbn.equals(_strSeiKotsu)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //���암�D�Ԑڔ�
            else if(baitaikbn.equals(_strSeiKansetsu)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //���암�D�J����
            else if(baitaikbn.equals(_strSeiKaihatsu)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //���암�D�p�b�P�[�W����
            else if(baitaikbn.equals(_strSeiPackage)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //���암�D��������(1)
            else if(baitaikbn.equals(_strSeiZei1)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
	        //���암�D��������(2)
            else if(baitaikbn.equals(_strSeiZei2)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSeisakDAO.class);
            }
            //�}�̏����(1)
            else if(baitaikbn.equals(_strBaiZei1)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSonotaDAO.class);
            }
            //�}�̏����(2)
            else if(baitaikbn.equals(_strBaiZei2)){
                dao = (DetailListLionDaoInterface) DaoFactory.createDao(DetailListLionSonotaDAO.class);
            }

	    	return dao;
	    }

}
