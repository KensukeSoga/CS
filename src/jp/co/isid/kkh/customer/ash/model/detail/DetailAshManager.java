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
 * �L����ד���Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/12/08 JSE K.Fukuda)<BR>
 * </P>
 * @author
 */
public class DetailAshManager {

    /** �V���O���g���C���X�^���X */
    private static DetailAshManager _manager = new DetailAshManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private DetailAshManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static DetailAshManager getInstance() {
        return _manager;
    }

    //**********************************************************************************************************************************************************************************
    //���׌���
    /**
     * �L����׃f�[�^���������܂��B
     *
     * @return DetailDataResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public DetailDataAshResult findDetailDataAshByCond(DetailDataAshCondition cond) throws KKHException {


		DetailDataAshDAO dao = DetailDataAshDAOFactory.createDetailDataDAO();
    	//��������
    	DetailDataAshResult result = new DetailDataAshResult();

    	//******************************************************
    	//�g�p���}�̃R�[�h�擾
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
    		//�Ώ۔}�̃R�[�h���菈��
    		//**************************
    		//�}�̃R�[�h�ϊ��}�X�^�擾
    		List<MasterVO> baitaiCdCnvMstList = dao.findBaitaiCdCnvMst(cond);
    		//�Ώ۔}�̃R�[�h����
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
    	//�L����׃f�[�^���擾
    	//******************************************************
    	cond.setTargetBaitaiCd(targetBaitaiCd);
        // UPD 2015/03/03 K.F �A�T�q�Ή� START
    	//cond.setMstSybt(getMasterSybt(targetBaitaiCd));
    	cond.setMstSybt(getMasterSybt(targetBaitaiCd, cond.getTksKgyCd() + cond.getTksBmnSeqNo() + cond.getTksTntSeqNo()));
        // UPD 2015/03/03 K.F �A�T�q�Ή� END
        List<DetailDataAshVO> detailDataList = dao.findDetailDataByCondition(cond);

        result.setTargetBaitaiCd(targetBaitaiCd);
        result.setDetailData(detailDataList);

        return result;
    }

    /**
     * �Ώ۔}�̃R�[�h���猟������}�X�^�̃}�X�^��ʂ����肷��
     * @param targetBaitaiCd
     * @return
     */
    private String getMasterSybt(String targetBaitaiCd, String tksCd){
    	String masterSybt = "";

        // UPD 2015/03/03 K.F �A�T�q�Ή� START
//    	if (targetBaitaiCd.equals("100") || targetBaitaiCd.equals("110")){
//    		//�e���r�^�C���E�e���r�X�|�b�g
//    		masterSybt = "204";
//    	}else if (targetBaitaiCd.equals("120") || targetBaitaiCd.equals("125")){
//    		//���W�I�^�C���E���W�I�X�|�b�g
//    		masterSybt = "205";
//    	}else if (targetBaitaiCd.equals("130")){
//    		//�V��
//    		masterSybt = "202";
//    	}else if (targetBaitaiCd.equals("140")){
//    		//�G��
//    		masterSybt = "203";
//    	}else if (targetBaitaiCd.equals("150")){
//    		//���
//    		masterSybt = "206";
//    	}else if (targetBaitaiCd.equals("230")){
//    		//���f�B�A�t�B�[
//    		masterSybt = "219";
//    	}else if (targetBaitaiCd.equals("240")){
//    		//�u�����h�Ǘ��t�B�[
//    		masterSybt = "220";
//    	}else if (targetBaitaiCd.equals("160") || targetBaitaiCd.equals("180")){
//    		//���O�L���E�C�x���g
//    		masterSybt = "217";
//    	}else if (targetBaitaiCd.equals("170")){
//    		//����
//    		masterSybt = "216";
//    	//2013/02/22 hlc sonobe PR�}�̒ǉ��Ή��@Start
//        }else if (targetBaitaiCd.equals("119")){
//            //PR
//            masterSybt = "221";
//        //2013/02/22 hlc sonobe PR�}�̒ǉ��Ή��@End
//    	}else if (targetBaitaiCd.equals("190")
//    			|| targetBaitaiCd.equals("115")
//    			|| targetBaitaiCd.equals("116")
//    			|| targetBaitaiCd.equals("117")
//    			|| targetBaitaiCd.equals("118")
//    			|| targetBaitaiCd.equals("195")){
//    		//���̑��E�j���[���f�B�A�E�C���^�[�l�b�g�EBS�ECS�E����
//    		masterSybt = "218";
//    	}
    	if (KKHConstants.TksKgyCode.ASH.getCode().equals(tksCd)){
    		//�A�T�q�r�[���̏ꍇ
        	if (targetBaitaiCd.equals("100") || targetBaitaiCd.equals("110") || targetBaitaiCd.equals("105")){	// UPD 2015/06/08 K.F �A�T�q�Ή�
        		//�e���r�^�C���E�e���r�X�|�b�g�E�e���r�l�b�g�X�|�b�g
        		masterSybt = "204";
        	}else if (targetBaitaiCd.equals("120") || targetBaitaiCd.equals("125")){
        		//���W�I�^�C���E���W�I�X�|�b�g
        		masterSybt = "205";
        	}else if (targetBaitaiCd.equals("130")){
        		//�V��
        		masterSybt = "202";
        	}else if (targetBaitaiCd.equals("140")){
        		//�G��
        		masterSybt = "203";
        	}else if (targetBaitaiCd.equals("150")){
        		//���
        		masterSybt = "206";
        	}else if (targetBaitaiCd.equals("230")){
        		//���f�B�A�t�B�[
        		masterSybt = "219";
        	}else if (targetBaitaiCd.equals("240")){
        		//�u�����h�Ǘ��t�B�[
        		masterSybt = "220";
        	}else if (targetBaitaiCd.equals("160") || targetBaitaiCd.equals("180")){
        		//���O�L���E�C�x���g
        		masterSybt = "217";
        	}else if (targetBaitaiCd.equals("170")){
        		//����
        		masterSybt = "216";
        	//2013/02/22 hlc sonobe PR�}�̒ǉ��Ή��@Start
            }else if (targetBaitaiCd.equals("119")){
                //PR
                masterSybt = "221";
            //2013/02/22 hlc sonobe PR�}�̒ǉ��Ή��@End
        	}else if (targetBaitaiCd.equals("190")
        			|| targetBaitaiCd.equals("115")
        			|| targetBaitaiCd.equals("116")
        			|| targetBaitaiCd.equals("117")
        			|| targetBaitaiCd.equals("118")
        			|| targetBaitaiCd.equals("195")
        			|| targetBaitaiCd.equals("193")
        			|| targetBaitaiCd.equals("194")
        			|| targetBaitaiCd.equals("199")){
        		//���̑��E�j���[���f�B�A�E�C���^�[�l�b�g�EBS�ECS�E�����E�C���[�W�K�[���E�n���o�e�E�j�b�J
        		masterSybt = "218";
        	}
        	else
        	{
        		//��L�ȊO�͂��̑�����
        		masterSybt = "218";
        	}
    	}else{
    		//�A�T�q�����̏ꍇ
        	if (targetBaitaiCd.equals("100") || targetBaitaiCd.equals("110")){
        		//�e���r�^�C���E�e���r�X�|�b�g
        		masterSybt = "204";
        	}else if (targetBaitaiCd.equals("120") || targetBaitaiCd.equals("125")){
        		//���W�I�^�C���E���W�I�X�|�b�g
        		masterSybt = "205";
        	}else if (targetBaitaiCd.equals("130")){
        		//�V��
        		masterSybt = "202";
        	}else if (targetBaitaiCd.equals("140")){
        		//�G��
        		masterSybt = "203";
        	}else if (targetBaitaiCd.equals("150")){
        		//���
        		masterSybt = "206";
        	}else if (targetBaitaiCd.equals("230")){
        		//���f�B�A�t�B�[
        		masterSybt = "219";
        	}else if (targetBaitaiCd.equals("240")){
        		//�u�����h�Ǘ��t�B�[
        		masterSybt = "220";
        	}else if (targetBaitaiCd.equals("160") || targetBaitaiCd.equals("180")){
        		//���O�L���E�C�x���g
        		masterSybt = "217";
        	}else if (targetBaitaiCd.equals("170")){
        		//����
        		masterSybt = "216";
        	//2013/02/22 hlc sonobe PR�}�̒ǉ��Ή��@Start
            }else if (targetBaitaiCd.equals("119")){
                //PR
                masterSybt = "221";
            //2013/02/22 hlc sonobe PR�}�̒ǉ��Ή��@End
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
        		//���̑��E�j���[���f�B�A�E�C���^�[�l�b�g�EBS�ECS�E�����EPR�E�A���t�g�E�^�����g�E���쌠��
        		//�f�ޑ�ECF�����E����t�B�[�EJASRAC�E�Г��g�p�i�L�����j�E�L�����i���̑��j
        		masterSybt = "218";
        	}
        	else
        	{
        		//��L�ȊO�͂��̑�����
        		masterSybt = "218";
        	}
        	// UPD 2015/03/03 K.F �A�T�q�Ή� END
    	}
    	// UPD 2015/03/03 K.F �A�T�q�Ή� END

    	return masterSybt;
    }

    //**********************************************************************************************************************************************************************************
    //�󒍓���
    /**
     * �󒍓���(���ד���)
     *
     * @param vo �󒍓���VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public DetailDataAshMergeResult mergeDataForAsh(DetailDataAshMergeVO vo) throws KKHException {

        DetailDataAshMergeResult result = new DetailDataAshMergeResult();

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();

        //*********************************************************************************************************
        //�󒍃_�E�����[�h�f�[�^�̓���
        //*********************************************************************************************************
        //*********************************************************************************************************
        //�r������
        //*********************************************************************************************************
        for (Thb1DownVO thb1DownVO : vo.getTougouMotoList()) {
            List<Thb1DownVO> lockThb1Down = dao.lockThb1Down(thb1DownVO);
            if (lockThb1Down.size() <= 0 || vo.getMaxUpdDate().compareTo(lockThb1Down.get(0).getHb1TimStmp()) < 0 ){
                throw new KKHException("�r���G���[", "LOCK-E0001");
            }
        }

        //*********************************************************************************************************
        //�f�[�^�X�V
        //*********************************************************************************************************
        //�������f�[�^�̍X�V
        for (Thb1DownVO thb1DownVO : vo.getTougouMotoList()) {
            thb1DownVO.setHb1TJyutNo(vo.getTougouSaki().getHb1JyutNo());
            thb1DownVO.setHb1TJyMeiNo(vo.getTougouSaki().getHb1JyMeiNo());
            thb1DownVO.setHb1TUrMeiNo(vo.getTougouSaki().getHb1UrMeiNo());
            dao.updateThb1DownForJyutyuMerge(thb1DownVO);
        }

        //������f�[�^�̓o�^
        dao.insertThb1Down(vo.getTougouSaki());

        //*********************************************************************************************************
        //���׃f�[�^�̓���
        //*********************************************************************************************************
        Thb2KmeiDAO thb2KmeiDAO = Thb2KmeiDAOFactory.createThb2KmeiDAO();
        Thb2KmeiVO thb2KmeiCond = new Thb2KmeiVO();                           // ������VO
        List<Thb2KmeiVO> tougouSakiList = new ArrayList<Thb2KmeiVO>();        // �����斾�׃f�[�^
        List<Thb2KmeiVO> tougouMotoList = new ArrayList<Thb2KmeiVO>();        // ���������׃f�[�^
        Boolean sumiFlg = true;                                               // ������t���O(�����斾�ׂ̗L�� �L�FTrue���FFalse)
        String baitaiCd = "";                                                 // �}�̃R�[�h

        // �����斾�׃f�[�^�擾 ---------------------------------------------------------
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
            // �����斾�ׂ̔}�̃R�[�h���擾
            baitaiCd = hb2Vo.getHb2Code1().trim();
            sumiFlg = true;
            break;
        }

        // �����斾�ׂ̔}�̃R�[�h���擾�o���Ȃ������ꍇ
        if (baitaiCd.length() == 0) {

            //�p�����[�^�̔}�̃R�[�h���g�p����
            baitaiCd = vo.getBaitaiCd();
            sumiFlg = false;
        }

        // ���������׃f�[�^�擾 ---------------------------------------------------------
        for (Thb1DownVO thb1DownVO : vo.getTougouMotoList()) {

            // ������̃L�[���ڂƓ����ꍇ�́A���׃f�[�^���擾���Ȃ�
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

                // ����}�̃R�[�h�̃��R�[�h�̂ݑΏ�
                if (baitaiCd.equals(hb2Vo.getHb2Code1().trim())) {
                    tougouMotoList.add(hb2Vo);
                }
            }
        }

        DetailDataAshDAO ashDao = DetailDataAshDAOFactory.createDetailDataDAO();
        String renban = "";
        int renbanNum = 0;

        // �������f�[�^�̕ҏW�Ɠo�^ -------------------------------------------------------
        if (baitaiCd.equals("100") || baitaiCd.equals("120")) {

            // �e���r�^�C��/���W�I�^�C���̏ꍇ(Update/Insert�f�[�^)
            if (sumiFlg) {

                // �^�C���p�W�v������(Update�f�[�^�쐬)
                List<Thb2KmeiVO> updateList = this.getSumTvRdUpdateList(vo.getTougouSaki(), tougouSakiList, tougouMotoList);

                // �X�V
                UpdateDataAshDAO updDao = UpdateDataAshDAOFactory.createUpdateOutFlgDAO();
                for (Thb2KmeiVO updateVo : updateList) {
                    updDao.updateThb2Kmei(updateVo);
                }
            }

            // �^�C���p�W�v������(Insert�f�[�^�쐬)
            List<Thb2KmeiVO> insertList = this.getSumTvRdInsertList(vo.getTougouSaki(), tougouSakiList, tougouMotoList);
            // �o�^
            for (Thb2KmeiVO motoVo : insertList) {
                // �A�Ԃ̍ő�l�擾
                List<Thb2KmeiVO> renbanList = ashDao.selectThb2KmeiMaxRenbn(motoVo);

                //�A�Ԃ��擾�ł��Ȃ������ꍇ
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

                // �A�Ԃ̍ő�l�𒴂����ꍇ�̓G���[�Ƃ���
                //if (renbanNum > 999) {  2013/05/09 hlc sonobe �o�^�����g��
                if (renbanNum > 9999) {
                    throw new KKHException("���ד����G���[", "HB-E0020");
                }
                motoVo.setHb2Renbn(String.format("%1$03d", renbanNum));

                // �������f�[�^�̓o�^
                thb2KmeiDAO.insertThb2Kmei(motoVo);
            }


        } else {
            // �^�C���ȊO
            List<Thb2KmeiVO> insertList = this.getMotoDataList(vo.getTougouSaki(), tougouMotoList);
            // �o�^
            for (Thb2KmeiVO motoVo : insertList) {
                // �A�Ԃ̍ő�l�擾
            	List<Thb2KmeiVO> renbanList = ashDao.selectThb2KmeiMaxRenbn(motoVo);

                //�A�Ԃ��擾�ł��Ȃ������ꍇ
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

                // �A�Ԃ̍ő�l�𒴂����ꍇ�̓G���[�Ƃ���
                //if (renbanNum > 999) {  2013/05/09 hlc sonobe �o�^�����g��
                if (renbanNum > 9999) {
                    throw new KKHException("���ד����G���[", "HB-E0020");
                }
                motoVo.setHb2Renbn(String.format("%1$03d", renbanNum));

                // �������f�[�^�̓o�^
                thb2KmeiDAO.insertThb2Kmei(motoVo);
            }
        }

    	return result;
    }

    /**
     * �e���r�^�C��/���W�I�^�C���̏W�v(Insert)
     *
     * @param tougouSaki ��������
     * @param tougouSakiList �����斾�׃f�[�^
     * @param tougouMotoList ���������׃f�[�^
     * @return �������f�[�^�̃e���r�^�C��/���W�I�^�C���W�v����
     */
    @SuppressWarnings("unchecked")
	private List<Thb2KmeiVO> getSumTvRdInsertList(Thb1DownVO tougouSaki, List<Thb2KmeiVO> tougouSakiList, List<Thb2KmeiVO> tougouMotoList) {

        List<Thb2KmeiVO> retList = new ArrayList<Thb2KmeiVO>();
        Map map = new HashMap();

        for(Thb2KmeiVO sakiVo : tougouSakiList) {
            map.put(sakiVo.getHb2Code2() + sakiVo.getHb2Code3(), sakiVo);
        }

        // �u�ǃR�[�h(�R�[�h2)�v�u�i��R�[�h(�R�[�h3)�v�����łȂ����ׂ����X�g�ɒǉ�
        for(Thb2KmeiVO motoVo : tougouMotoList) {

            if (map.containsKey(motoVo.getHb2Code2() + motoVo.getHb2Code3()) == false) {
                // �������No
                motoVo.setHb2JyutNo(tougouSaki.getHb1JyutNo().trim());

                // ������󒍖���No
                motoVo.setHb2JyMeiNo(tougouSaki.getHb1JyMeiNo().trim());

                // �����攄�㖾��No
                motoVo.setHb2UrMeiNo(tougouSaki.getHb1UrMeiNo().trim());

                // �����挏��
                // 2013/01/17 JSE M.Naito
                //motoVo.setHb2Name8(tougouSaki.getHb1KKNameKJ().trim());
                motoVo.setHb2Name10(tougouSaki.getHb1KKNameKJ().trim());

                // ������L�[��
                //�����敪���^�C���̏ꍇ
                if(tougouSaki.getHb1SeiKbn().equals("41")){
                	//�ǐ����Z�b�g����
                    motoVo.setHb2Sonota7(tougouSaki.getHb1Field3());
                }else
                {
                	//�O���Z�b�g����
                    motoVo.setHb2Sonota7("0");
                }

                // ������ǐ�
                motoVo.setHb2Sonota8(tougouSaki.getHb1Field1());

                retList.add(motoVo);
            }
        }
        return retList;
    }


    /**
     * �e���r�^�C��/���W�I�^�C���̏W�v(Update)
     *
     * @param tougouSaki ��������
     * @param tougouSakiList �����斾�׃f�[�^
     * @param tougouMotoList ���������׃f�[�^
     * @return �������f�[�^�̃e���r�^�C��/���W�I�^�C���W�v����
     */
    private List<Thb2KmeiVO> getSumTvRdUpdateList(Thb1DownVO tougouSaki, List<Thb2KmeiVO> tougouSakiList, List<Thb2KmeiVO> tougouMotoList) {

        List<Thb2KmeiVO> retList = new ArrayList<Thb2KmeiVO>();

        // �u�ǃR�[�h(�R�[�h2)�v�u�i��R�[�h(�R�[�h3)�v�Ɠ����������W(�������W�v)
        for(Thb2KmeiVO motoVo : tougouMotoList) {

            for(Thb2KmeiVO sakiVo : tougouSakiList) {

                // �R�[�h2/�R�[�h3��r
                if (sakiVo.getHb2Code2().equals(motoVo.getHb2Code2()) &&
                    sakiVo.getHb2Code3().equals(motoVo.getHb2Code3())) {

                    // �������No
                    sakiVo.setHb2JyutNo(tougouSaki.getHb1JyutNo().trim());

                    // ������󒍖���No
                    sakiVo.setHb2JyMeiNo(tougouSaki.getHb1JyMeiNo().trim());

                    // �����攄�㖾��No
                    sakiVo.setHb2UrMeiNo(tougouSaki.getHb1UrMeiNo().trim());

                    // �����z
                    sakiVo.setHb2SeiGak( motoVo.getHb2SeiGak().add(sakiVo.getHb2SeiGak()) );

                    // ���ϋ��z
                    sakiVo.setHb2HnmaeGak( motoVo.getHb2HnmaeGak().add(sakiVo.getHb2HnmaeGak()) );

                    retList.add(sakiVo);
                }
            }
        }

        return retList;
    }

    /**
     * �������f�[�^�̍쐬
     *
     * @param tougouSaki ��������
     * @param tougouMotoList ���������׃f�[�^
     * @return ���������׃f�[�^
     */
    private List<Thb2KmeiVO> getMotoDataList(Thb1DownVO tougouSaki, List<Thb2KmeiVO> tougouMotoList) {

        List<Thb2KmeiVO> retList = new ArrayList<Thb2KmeiVO>();

        for(Thb2KmeiVO motoVo : tougouMotoList) {
            // vo�擾
            Thb2KmeiVO vo = motoVo;

            // �������No
            vo.setHb2JyutNo(tougouSaki.getHb1JyutNo().trim());

            // ������󒍖���No
            vo.setHb2JyMeiNo(tougouSaki.getHb1JyMeiNo().trim());

            // �����攄�㖾��No
            vo.setHb2UrMeiNo(tougouSaki.getHb1UrMeiNo().trim());

            // �����挏��
            // 2013/01/17 JSE M.Naito
            //vo.setHb2Name8(tougouSaki.getHb1KKNameKJ().trim());
            vo.setHb2Name10(tougouSaki.getHb1KKNameKJ().trim());

            retList.add(vo);
        }

        return retList;
    }

    /**
     * �L����׃f�[�^���������܂��B
     *
     * @return DetailDataResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
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
