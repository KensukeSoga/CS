package jp.co.isid.kkh.customer.epson.model.detail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.detail.Thb1DownDAO;
import jp.co.isid.kkh.model.detail.Thb1DownDAOFactory;
import jp.co.isid.kkh.model.detail.Thb1DownVO;
import jp.co.isid.kkh.model.detail.Thb2KmeiDAO;
import jp.co.isid.kkh.model.detail.Thb2KmeiDAOFactory;
import jp.co.isid.kkh.model.detail.Thb2KmeiVO;
import jp.co.isid.kkh.model.detail.Thb8DownRCondition;
import jp.co.isid.kkh.model.detail.Thb8DownRDAO;
import jp.co.isid.kkh.model.detail.Thb8DownRDAOFactory;
import jp.co.isid.kkh.model.detail.Thb8DownRVO;

/**
 * <P>
 * �L����ד���Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/3/5 IP.Shimizu)<BR>
 * </P>
 * @author
 */
public class DetailEpsonManager {

    /** �V���O���g���C���X�^���X */
    private static DetailEpsonManager _manager = new DetailEpsonManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private DetailEpsonManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static DetailEpsonManager getInstance() {
        return _manager;
    }

    //**********************************************************************************************************************************************************************************
    //���דo�^����
    /**
     * �\���f�[�^�o�^
     * @param vo
     * @throws KKHException
     */
    public DetailUpdateDataEpsonResult updateDisplayDataEpson(DetailUpdateDataEpsonVO vo) throws KKHException{

        DetailUpdateDataEpsonResult result = new DetailUpdateDataEpsonResult();
        List<Thb2KmeiVO> resThb2KmeiList = new ArrayList<Thb2KmeiVO>();

        //DAO
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();
        Thb2KmeiDAO thb2KmeiDao = Thb2KmeiDAOFactory.createThb2KmeiDAO();

        //�폜�E�r���f�[�^�擾����
        Thb2KmeiVO deleteThb2KmeiCond = new Thb2KmeiVO();

        //bulkUpdateDetailDataEpson�Ŕr�������������Ȃ��Ă��邽�߁A�폜���ƂĂ����悢�A�͂�
//    	//*********************************************************************************************************
//    	//�r������
//    	//*********************************************************************************************************
//    	//�󒍃_�E�����[�h�e�[�u��(�e)
        List<Thb1DownVO> thb1List = thb1DownDao.lockThb1Down(vo.getThb1Down());
//    	if (thb1List.size() <= 0 || vo.getMaxUpdDate().compareTo(thb1List.get(0).getHb1TimStmp()) < 0 ){
//    		throw new KKHException("�r���G���[", "LOCK-E0001");//TODO �G���[�R�[�h
//    	}
//
        List<Thb1DownVO> thb1ChildList = new ArrayList<Thb1DownVO>();
//    	if (vo.getThb1Down().getHb1TouFlg().equals("1")){
//	    	//�󒍃_�E�����[�h�e�[�u��(�q)
//	    	thb1ChildList = thb1DownDao.lockThb1DownForChild(vo.getThb1Down());
//	    	if (thb1ChildList.size() <= 0 || vo.getMaxUpdDate().compareTo(thb1ChildList.get(0).getHb1TimStmp()) < 0 ){
//	    		throw new KKHException("�r���G���[", "LOCK-E0001");//TODO �G���[�R�[�h
//	    	}
//    	}

        //�L����׃e�[�u��
        deleteThb2KmeiCond.setHb2EgCd(vo.getThb1Down().getHb1EgCd());
        deleteThb2KmeiCond.setHb2TksKgyCd(vo.getThb1Down().getHb1TksKgyCd());
        deleteThb2KmeiCond.setHb2TksBmnSeqNo(vo.getThb1Down().getHb1TksBmnSeqNo());
        deleteThb2KmeiCond.setHb2TksTntSeqNo(vo.getThb1Down().getHb1TksTntSeqNo());
        deleteThb2KmeiCond.setHb2Yymm(vo.getThb1Down().getHb1Yymm());
        deleteThb2KmeiCond.setHb2JyutNo(vo.getThb1Down().getHb1JyutNo());
        deleteThb2KmeiCond.setHb2JyMeiNo(vo.getThb1Down().getHb1JyMeiNo());
        deleteThb2KmeiCond.setHb2UrMeiNo(vo.getThb1Down().getHb1UrMeiNo());
        List<Thb2KmeiVO> thb2List = thb2KmeiDao.epsonLockThb2Kmei(deleteThb2KmeiCond);
//    	if (thb2List.size() > 0 && vo.getMaxUpdDate().compareTo(thb2List.get(0).getHb2TimStmp()) < 0 ){
//    		throw new KKHException("�r���G���[", "LOCK-E0001");//TODO �G���[�R�[�h
//    	}

        //*********************************************************************************************************
        //�f�[�^�o�^�E�X�V
        //*********************************************************************************************************
        //���דo�^�����̎擾
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String meiTimStmp = sdf.format(new Date());

        //�L����׃f�[�^�폜
        //thb2KmeiDao.deleteThb2KmeiByCondition(deleteThb2KmeiCond);

        //�L����׃f�[�^�o�^
        if (vo.getThb2Kmei() != null && vo.getThb2Kmei().size() > 0){
            for (Thb2KmeiVO thb2KmeiVO : vo.getThb2Kmei()) {
                thb2KmeiDao.insertThb2Kmei(thb2KmeiVO);
                //�o�^�f�[�^�̎擾
                resThb2KmeiList.add(thb2KmeiDao.loadThb2Kmei(thb2KmeiVO));
            }
            result.setThb2Kmei(resThb2KmeiList);

            //�o�^�f�[�^�̎擾
            for (Thb1DownVO Thb1DownVO : thb1List) {
                result.setThb1Down(thb1DownDao.loadThb1Down(Thb1DownVO));
            }

            //�X�V�Ώۂ̎󒍃_�E�����[�h�f�[�^���u�����v�f�[�^�̏ꍇ�A�����O��(�q)�f�[�^���X�V����
            if (vo.getThb1Down().getHb1TouFlg().equals("1")){
                //�󒍃_�E�����[�h�f�[�^�X�V
                thb1DownDao.updateThb1DownForDisplayDataChild(vo.getThb1Down());

                //�󒍃_�E�����[�h�����f�[�^�X�V
                for(Thb1DownVO thb1DownVo : thb1ChildList){
                    Thb8DownRDAO thb8DownRDao = Thb8DownRDAOFactory.createThb8DownRDAO();
                    Thb8DownRCondition thb8DownCond = new Thb8DownRCondition();
                    Thb8DownRVO thb8DownRVo = new Thb8DownRVO();
                    //�X�V�����ݒ�
                    thb8DownCond.setEgCd(thb1DownVo.getHb1EgCd());
                    thb8DownCond.setTksKgyCd(thb1DownVo.getHb1TksKgyCd());
                    thb8DownCond.setTksBmnSeqNo(thb1DownVo.getHb1TksBmnSeqNo());
                    thb8DownCond.setTksTntSeqNo(thb1DownVo.getHb1TksTntSeqNo());
                    thb8DownCond.setYymm(thb1DownVo.getHb1Yymm());
                    thb8DownCond.setJyutNo(thb1DownVo.getHb1JyutNo());
                    thb8DownCond.setJyMeiNo(thb1DownVo.getHb1JyMeiNo());
                    thb8DownCond.setUrMeiNo(thb1DownVo.getHb1UrMeiNo());
                    thb8DownCond.setFileTimStmp(thb1DownVo.getHb1FileTimStmp());
                    //�X�V�l�ݒ�
                    thb8DownRVo.setHb8UpdApl(vo.getThb1Down().getHb1UpdApl());
                    thb8DownRVo.setHb8UpdTnt(vo.getThb1Down().getHb1UpdTnt());
                    thb8DownRVo.setHb8FileTimStmp(thb1DownVo.getHb1FileTimStmp());
                    thb8DownRVo.setHb8MeiTimStmp(meiTimStmp);

                    thb8DownRDao.updateThb8DownRForDisplayData(thb8DownRVo, thb8DownCond);
                }
            }else{
                //�󒍃_�E�����[�h�����f�[�^�X�V
                Thb8DownRDAO thb8DownRDao = Thb8DownRDAOFactory.createThb8DownRDAO();
                Thb8DownRCondition thb8DownCond = new Thb8DownRCondition();
                Thb8DownRVO thb8DownRVo = new Thb8DownRVO();
                thb8DownCond.setEgCd(thb1List.get(0).getHb1EgCd());
                thb8DownCond.setTksKgyCd(thb1List.get(0).getHb1TksKgyCd());
                thb8DownCond.setTksBmnSeqNo(thb1List.get(0).getHb1TksBmnSeqNo());
                thb8DownCond.setTksTntSeqNo(thb1List.get(0).getHb1TksTntSeqNo());
                thb8DownCond.setYymm(thb1List.get(0).getHb1Yymm());
                thb8DownCond.setJyutNo(thb1List.get(0).getHb1JyutNo());
                thb8DownCond.setJyMeiNo(thb1List.get(0).getHb1JyMeiNo());
                thb8DownCond.setUrMeiNo(thb1List.get(0).getHb1UrMeiNo());
                thb8DownCond.setFileTimStmp(thb1List.get(0).getHb1FileTimStmp());

                //�X�V�l�ݒ�
                thb8DownRVo.setHb8UpdApl(vo.getThb1Down().getHb1UpdApl());
                thb8DownRVo.setHb8UpdTnt(vo.getThb1Down().getHb1UpdTnt());
                thb8DownRVo.setHb8FileTimStmp(thb1List.get(0).getHb1FileTimStmp());
                thb8DownRVo.setHb8MeiTimStmp(meiTimStmp);

                thb8DownRDao.updateThb8DownRForDisplayData(thb8DownRVo, thb8DownCond);
            }

        }
        if (vo.getThb2Kmei() != null && vo.getThb2Kmei().size() > 0){
            //�󒍃_�E�����[�h�f�[�^�X�V
            vo.getThb1Down().setHb1MeiTimStmp(meiTimStmp);
            thb1DownDao.updateThb1DownForDisplayData(vo.getThb1Down(), vo.getThb2Kmei());
        }else{
            if(vo.getThb1Down().getHb1KsnTntNm() != null)
            {
                //�󒍃_�E�����[�h�f�[�^�X�V
                vo.getThb1Down().setHb1MeiTimStmp(meiTimStmp);
                thb1DownDao.updateThb1DownForDisplayData(vo.getThb1Down(), vo.getThb2Kmei());
            }
        }

//    	//�󒍃_�E�����[�h�f�[�^�X�V
//    	vo.getThb1Down().setHb1MeiTimStmp(meiTimStmp);
//    	thb1DownDao.updateThb1DownForDisplayData(vo.getThb1Down(),vo.getThb2Kmei());

        return result;
    }

    /**
     * �\���f�[�^�o�^
     *
     * @param vo
     * @throws KKHException
     */
    public DetailUpdateDataEpsonResult updateSeikyuDetail(DetailUpdateDataEpsonVO vo) throws KKHException {

        DetailUpdateDataEpsonResult result = new DetailUpdateDataEpsonResult();

        List<Thb2KmeiVO> resThb2KmeiList = new ArrayList<Thb2KmeiVO>();

        Thb2KmeiDAO thb2KmeiDao = Thb2KmeiDAOFactory.createThb2KmeiDAO();

        Thb2KmeiVO deleteThb2KmeiCond = new Thb2KmeiVO();

        deleteThb2KmeiCond.setHb2EgCd(vo.getThb2Kmei().get(0).getHb2EgCd());
        deleteThb2KmeiCond.setHb2TksKgyCd(vo.getThb2Kmei().get(0).getHb2TksKgyCd());
        deleteThb2KmeiCond.setHb2TksBmnSeqNo(vo.getThb2Kmei().get(0).getHb2TksBmnSeqNo());
        deleteThb2KmeiCond.setHb2TksTntSeqNo(vo.getThb2Kmei().get(0).getHb2TksTntSeqNo());
        deleteThb2KmeiCond.setHb2Yymm(vo.getThb2Kmei().get(0).getHb2Yymm());
        deleteThb2KmeiCond.setHb2JyutNo(vo.getThb2Kmei().get(0).getHb2JyutNo());
        deleteThb2KmeiCond.setHb2JyMeiNo(vo.getThb2Kmei().get(0).getHb2JyMeiNo());
        deleteThb2KmeiCond.setHb2UrMeiNo(vo.getThb2Kmei().get(0).getHb2UrMeiNo());

        List<Thb2KmeiVO> thb2List = thb2KmeiDao.epsonSKLockThb2Kmei(deleteThb2KmeiCond);

        if (thb2List.size() > 0 && vo.getMaxUpdDate().compareTo(thb2List.get(0).getHb2TimStmp()) < 0) {

            throw new KKHException("�r���G���[", "LOCK-E0001");
        }

        if (vo.getThb2Kmei() != null && vo.getThb2Kmei().size() > 0) {

            for (Thb2KmeiVO thb2KmeiVO : vo.getThb2Kmei()) {

                thb2KmeiDao.insertThb2Kmei(thb2KmeiVO);

                resThb2KmeiList.add(thb2KmeiDao.loadThb2Kmei(thb2KmeiVO));
            }

            result.setThb2Kmei(resThb2KmeiList);
        }

        return result;
    }

    //**********************************************************************************************************************************************************************************
    //���דo�^(�ꊇ)
    /**
     * �\���f�[�^�o�^(�ꊇ)
     * @param vo
     * @throws KKHException
     */
    public DetailDataEpsonBulkUpdateResult bulkUpdateDetailDataEpson(DetailDataEpsonBulkUpdateVO vo) throws KKHException{

        DetailDataEpsonBulkUpdateResult result = new DetailDataEpsonBulkUpdateResult();

        //*****************
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();
        Thb2KmeiDAO thb2KmeiDao = Thb2KmeiDAOFactory.createThb2KmeiDAO();

        //�폜�E�r���f�[�^�擾����
        Thb2KmeiVO deleteThb2KmeiCond = new Thb2KmeiVO();
        deleteThb2KmeiCond.setHb2EgCd(vo.getEgCd());
        deleteThb2KmeiCond.setHb2TksKgyCd(vo.getTksKgyCd());
        deleteThb2KmeiCond.setHb2TksBmnSeqNo(vo.getTksBmnSeqNo());
        deleteThb2KmeiCond.setHb2TksTntSeqNo(vo.getTksTntSeqNo());
        deleteThb2KmeiCond.setHb2Yymm(vo.getYymm());

        //*********************************************************************************************************
        //�r������
        //*********************************************************************************************************
        //�󒍃_�E�����[�h�e�[�u��(�e)
        if (vo.getTouIkkatsuThb1Down() != null) {
            List<Thb1DownVO> thb1List = thb1DownDao.lockIkatsuThb1Down(vo.getTouIkkatsuThb1Down().get(0));
            if (thb1List.size() <= 0 || vo.getMaxUpdDate().compareTo(thb1List.get(0).getHb1TimStmp()) < 0) {
                throw new KKHException("�r���G���[", "LOCK-E0001");
            }
        }

        List<Thb2KmeiVO> thb2List = thb2KmeiDao.epsonLockThb2Kmei(deleteThb2KmeiCond);
        //���׃e�[�u��
        if (thb2List.size() > 0 && vo.getMaxUpdDate().compareTo(thb2List.get(0).getHb2TimStmp()) < 0) {
            throw new KKHException("�r���G���[", "LOCK-E0001");
        }

        //�L����׃f�[�^�폜
        thb2KmeiDao.deleteThb2KmeiByCondition(deleteThb2KmeiCond);
        //*****************
        if (vo.getInputFlg() != null && !vo.getInputFlg().equals(""))
        // if (vo.getInputFlg().equals("1"))
        {
            for (DetailDataEpsonVO detailDataEpsonVo : vo.getDetailDataEpsonVOList()) {

                String kbn = detailDataEpsonVo.getKbn();

                if ((kbn != null) && (kbn.equals("1"))) {

                    //�L����p���׃f�[�^
                    DetailUpdateDataEpsonVO detailUpdateEpsonVo = new DetailUpdateDataEpsonVO();

                    detailUpdateEpsonVo.setEsqId(vo.getEsqId());
                    detailUpdateEpsonVo.setThb1Down(detailDataEpsonVo.getThb1Down());
                    detailUpdateEpsonVo.setThb2Kmei(detailDataEpsonVo.getThb2Kmei());
                    detailUpdateEpsonVo.setMaxUpdDate(vo.getMaxUpdDate());

                    updateDisplayDataEpson(detailUpdateEpsonVo);
                } else if ((kbn != null) && (kbn.equals("2"))) {

                    //��������p���׃f�[�^
                    DetailUpdateDataEpsonVO detailUpdateEpsonVo = new DetailUpdateDataEpsonVO();

                    detailUpdateEpsonVo.setEsqId(vo.getEsqId());
                    detailUpdateEpsonVo.setThb2Kmei(detailDataEpsonVo.getThb2Kmei());
                    detailUpdateEpsonVo.setMaxUpdDate(vo.getMaxUpdDate());

                    updateSeikyuDetail(detailUpdateEpsonVo);
                }
            }
        }

        //Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();
        /*
         * �ꊇ�o�^�����q�Ή�
         */
        if(vo.getTouIkkatsuThb1Down() != null)
        {
            for(Thb1DownVO UpRow : vo.getTouIkkatsuThb1Down())
            {
                if(UpRow.getHb1MeisaiFlg().equals("0"))
                {
                    if(UpRow.getHb1KsnTntNm() == null)
                    {
                    }else
                    {
                        //���s;
                        thb1DownDao.updateTourokuKousinTaiou(UpRow);
                    }
                }else
                {
                    //���s;
                    thb1DownDao.updateTourokuKousinTaiou(UpRow);
                }
            }
        }

        return result;
    }

    //**********************************************************************************************************************************************************************************
    //���׌���
    /**
     * �L����׃f�[�^���������܂��B
     *
     * @return DetailDataResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public DetailDataEpsonResult findDetailDataEpsonByCond(DetailDataEpsonCondition cond) throws KKHException {

        DetailDataEpsonDAO dao = DetailDataEpsonDAOFactory.createDetailDataDAO();
        //��������
        DetailDataEpsonResult result = new DetailDataEpsonResult();


        List<DetailDataFindEpsonVO> detailDataList = dao.findDetailDataByCondition(cond);

        result.setDetailData(detailDataList);

        return result;
    }

}
