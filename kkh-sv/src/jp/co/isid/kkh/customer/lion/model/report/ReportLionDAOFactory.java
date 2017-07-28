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
 * ���C�I���v���[�t���X�g����DAO�t�@�N�g���N���X
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/01/11)<BR>
 * </P>
 *
 * @author
 */

public class ReportLionDAOFactory extends DaoFactory{

    /**
    * �C���X�^���X�����֎~���܂��B
    */
    private ReportLionDAOFactory() {
    }

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
/*
        public static ReportLionDAO createReportLionDAO() {
            return (ReportLionDAO) DaoFactory.createDao(ReportLionDAO.class);
        }*/

    /**
    * DAO�C���X�^���X�𐶐����܂��B
    * @return DAO�C���X�^���X
    */
    public static ReportLionProofDaoInterface createReportLionDAO(String baitai) {

        ReportLionProofDaoInterface dao = null;

//		    	if (baitai.equals("TVTIME")){
//		    		dao=(ReportLionPurufuDaoInterface) DaoFactory.createDao(ReportLionTvTimeDAO.class);
//		    	}

        //****************
        //�ϐ�
        //****************
        String _strTvTime = LionConstants.BaitaiCode.TV_TIME.getName();	//�e���r�^�C��
        String _strRdTime = LionConstants.BaitaiCode.RD_TIME.getName();	//���W�I�^�C��
        String _strTvSpot = LionConstants.BaitaiCode.TV_SPOT.getName();	//�e���r�X�|�b�g
        String _strRdSpot = LionConstants.BaitaiCode.RD_SPOT.getName();	//���W�I�X�|�b�g
        String _strShin  = LionConstants.BaitaiCode.SHINBUN.getName();	//�V��
        String _strZashi  = LionConstants.BaitaiCode.ZASHI.getName();	//�G��
        String _strKotsu  = LionConstants.BaitaiCode.KOTSU.getName();	//���
        String _strSono  = LionConstants.BaitaiCode.SONOTA.getName();	//���̑�
        String _strSei  = LionConstants.BaitaiCode.SEISAKU.getName();		//����
        String _strTvCm  = LionConstants.BaitaiCode.TV_CM.getName();	//�e���rCM�b��
        String _strRdCm  = LionConstants.BaitaiCode.RD_CM.getName();	//���W�ICM�b��
        String _strChira  = LionConstants.BaitaiCode.CHIRASHI.getName();	//�`���V
        String _strSampl  = LionConstants.BaitaiCode.SAMPLING.getName();	//�T���v��
        String _strBsCs  = LionConstants.BaitaiCode.BS_CS.getName();	//BS�ECS
        String _strInter  = LionConstants.BaitaiCode.INTERNET.getName();	//�C���^�[�l�b�g
        String _strMob  = LionConstants.BaitaiCode.MOBILE.getName();		//���o�C��
        String _strJigyo  = LionConstants.BaitaiCode.JIGYOHI.getName();	//���Ɣ�
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add Start
        //�\�[�V�������f�B�A�ƃf�W�^�������ǉ�
        String _strSocial  = LionConstants.BaitaiCode.SOCIALMEDIA.getName(); //�\�[�V�������f�B�A
        String _strDigital  = LionConstants.BaitaiCode.DIGITALMOVIE.getName(); //�f�W�^������
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add End

        //****************
        //�}�̂ŕ���
        //****************
        //�e���r�^�C��
        if(baitai.equals(_strTvTime)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionTvTimeDAO.class);
        }
        //���W�I�^�C��
        else if(baitai.equals(_strRdTime)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionRdTimeDAO.class);
        }
        //�e���r�X�|�b�g
        else if(baitai.equals(_strTvSpot)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionTvSpotDAO.class);
        }
        //���W�I�X�|�b�g
        else if(baitai.equals(_strRdSpot)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionRdSpotDAO.class);
        }
        //�V��
        else if(baitai.equals(_strShin)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionShinbunDAO.class);
        }
        //�G��
        else if(baitai.equals(_strZashi)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionZashiDAO.class);
        }
        //���
        else if(baitai.equals(_strKotsu)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionKoutsuDAO.class);
        }
        //���̑�
        else if(baitai.equals(_strSono)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionSonotaDAO.class);
        }
        //����
        else if(baitai.equals(_strSei)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionSeisakDAO.class);
        }
        //�e���rCM�b��
        else if(baitai.equals(_strTvCm)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionRdSpotDAO.class);
        }
        //���W�ICM�b��
        else if(baitai.equals(_strRdCm)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionRdSpotDAO.class);
        }
        //�`���V
        else if(baitai.equals(_strChira)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionTiraShiDAO.class);
        }
        //�T���v��
        else if(baitai.equals(_strSampl)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionSamplingDAO.class);
        }
        //BS�ECS
        else if(baitai.equals(_strBsCs)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionBSCSDAO.class);
        }
        //�C���^�[�l�b�g
        else if(baitai.equals(_strInter)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionInterNetDAO.class);
        }
        //���o�C��
        else if(baitai.equals(_strMob)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionMobileDAO.class);
        }
        //���Ɣ�
        else if(baitai.equals(_strJigyo)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionJigyouBuDAO.class);
        }
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add Start
        //�\�[�V�������f�B�A
        else if(baitai.equals(_strSocial)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionSocialMediaDAO.class);
        }
        //�f�W�^������
        else if(baitai.equals(_strDigital)){
            dao = (ReportLionProofDaoInterface) DaoFactory.createDao(ReportLionDigitalMovieDAO.class);
        }
        //2017/06/05 ���C�I���Ή� ITCOM A.Nakamura Add End
        return dao;
    }

}
