package jp.co.isid.kkh.model.detail;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.common.CommonCondition;
import jp.co.isid.kkh.model.common.CommonDAO;
import jp.co.isid.kkh.model.common.CommonDAOFactory;
import jp.co.isid.kkh.model.common.CommonVO;
import jp.co.isid.kkh.model.common.ExecProcedureDAO;
import jp.co.isid.kkh.model.common.ExecProcedureDAOFactory;
import jp.co.isid.kkh.util.StringUtil;
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
public class DetailManager {

    /** �󒍍폜�t���O�F�n�m */
    private static final String JYUTDELFLG_ON = "1";

    /** ���~�敪�F���~ */
    private static final String STPKBN_STOP = "1";

    /** �V���O���g���C���X�^���X */
    private static DetailManager _manager = new DetailManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private DetailManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static DetailManager getInstance() {
        return _manager;
    }

    //**********************************************************************************************************************************************************************************
    //�ꊇ�o�^
    /**
     * �_�E�����[�h�f�[�^�̍X�V(���דo�^��)
     *
     * @param cond �󒍃_�E�����[�h�f�[�^VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void updateThb1DownForDisplayData(Thb1DownVO vo) throws KKHException {
        List<Thb2KmeiVO> vo2 = null;
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();
        thb1DownDao.updateThb1DownForDisplayData(vo,vo2);
    }

    /**
     * �_�E�����[�h�f�[�^�̍X�V
     *
     * @param cond �󒍃_�E�����[�h�f�[�^VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void updateTourokuIkkatsuKoTaiou(Thb1DownVO vo1) throws KKHException {
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();
        thb1DownDao.updateTourokuKousinTaiou(vo1);
    }

    /**
     * �_�E�����[�h�f�[�^�̔r������(���דo�^��)
     *
     * @param cond �󒍃_�E�����[�h�f�[�^VO�i�����p�j
     * @return �󒍃_�E�����[�h�f�[�^���X�g
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public List<Thb1DownVO> lockThb1Down(Thb1DownVO cond) throws KKHException {

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();
        return dao.lockThb1Down(cond);
    }

    /**
     * �L����׃f�[�^�̔r������(���דo�^��)
     *
     * @param cond �L����׃f�[�^VO�i�����p�j
     * @return �L����׃f�[�^���X�g
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public List<Thb2KmeiVO> lockThb2Kmei(Thb2KmeiVO cond) throws KKHException {

        Thb2KmeiDAO dao = Thb2KmeiDAOFactory.createThb2KmeiDAO();
        return dao.lockThb2Kmei(cond);
    }

    /**
     * �����e�[�u���̍X�V(�ꊇ�o�^)
     *
     * @param cond �󒍃_�E�����[�h�f�[�^VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void updateThb8RirekiForDisplayData(Thb1DownVO vo) throws KKHException {

        //���דo�^�����̎擾
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String meiTimStmp = sdf.format(new Date());

        //�󒍃_�E�����[�h�e�[�u��(�e)
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();
        List<Thb1DownVO> thb1List = thb1DownDao.lockThb1Down(vo);

        List<Thb1DownVO> thb1ChildList = new ArrayList<Thb1DownVO>();

        //�X�V�Ώۂ̎󒍃_�E�����[�h�f�[�^���u�����v�f�[�^�̏ꍇ�A�����O��(�q)�f�[�^���X�V����
        if (vo.getHb1TouFlg().equals("1")){

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
                thb8DownRVo.setHb8UpdApl(vo.getHb1UpdApl());
                thb8DownRVo.setHb8UpdTnt(vo.getHb1UpdTnt());
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
            thb8DownRVo.setHb8UpdApl(vo.getHb1UpdApl());
            thb8DownRVo.setHb8UpdTnt(vo.getHb1UpdTnt());
            thb8DownRVo.setHb8FileTimStmp(thb1List.get(0).getHb1FileTimStmp());
            thb8DownRVo.setHb8MeiTimStmp(meiTimStmp);

            thb8DownRDao.updateThb8DownRForDisplayData(thb8DownRVo, thb8DownCond);
        }
    }

    //**********************************************************************************************************************************************************************************
    //���דo�^
    /**
     * �\���f�[�^�o�^
     * @param vo
     * @throws KKHException
     */
    public DetailUpdateDataResult updateDisplayData(DetailUpdateDataVO vo) throws KKHException{

        DetailUpdateDataResult result = new DetailUpdateDataResult();
        List<Thb2KmeiVO> resThb2KmeiList = new ArrayList<Thb2KmeiVO>();

        //DAO
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();
        Thb2KmeiDAO thb2KmeiDao = Thb2KmeiDAOFactory.createThb2KmeiDAO();

        //�폜�E�r���f�[�^�擾����
        Thb2KmeiVO deleteThb2KmeiCond = new Thb2KmeiVO();


        //*********************************************************************************************************
        //�r������
        //*********************************************************************************************************
        //�󒍃_�E�����[�h�e�[�u��(�e)
        List<Thb1DownVO> thb1List = thb1DownDao.lockThb1Down(vo.getThb1Down());
        if (thb1List.size() <= 0 || vo.getMaxUpdDate().compareTo(thb1List.get(0).getHb1TimStmp()) < 0 ){
            throw new KKHException("�r���G���[", "LOCK-E0001");//TODO �G���[�R�[�h
        }

        List<Thb1DownVO> thb1ChildList = new ArrayList<Thb1DownVO>();
        if (vo.getThb1Down().getHb1TouFlg().equals("1")){
            //�󒍃_�E�����[�h�e�[�u��(�q)
            thb1ChildList = thb1DownDao.lockThb1DownForChild(vo.getThb1Down());
            if (thb1ChildList.size() <= 0 || vo.getMaxUpdDate().compareTo(thb1ChildList.get(0).getHb1TimStmp()) < 0 ){
                throw new KKHException("�r���G���[", "LOCK-E0001");//TODO �G���[�R�[�h
            }
        }

        //�L����׃e�[�u��
        deleteThb2KmeiCond.setHb2EgCd(vo.getThb1Down().getHb1EgCd());
        deleteThb2KmeiCond.setHb2TksKgyCd(vo.getThb1Down().getHb1TksKgyCd());
        deleteThb2KmeiCond.setHb2TksBmnSeqNo(vo.getThb1Down().getHb1TksBmnSeqNo());
        deleteThb2KmeiCond.setHb2TksTntSeqNo(vo.getThb1Down().getHb1TksTntSeqNo());
        deleteThb2KmeiCond.setHb2Yymm(vo.getThb1Down().getHb1Yymm());
        deleteThb2KmeiCond.setHb2JyutNo(vo.getThb1Down().getHb1JyutNo());
        deleteThb2KmeiCond.setHb2JyMeiNo(vo.getThb1Down().getHb1JyMeiNo());
        deleteThb2KmeiCond.setHb2UrMeiNo(vo.getThb1Down().getHb1UrMeiNo());
        List<Thb2KmeiVO> thb2List = thb2KmeiDao.lockThb2Kmei(deleteThb2KmeiCond);
        if (thb2List.size() > 0 && vo.getMaxUpdDate().compareTo(thb2List.get(0).getHb2TimStmp()) < 0 ){
            throw new KKHException("�r���G���[", "LOCK-E0001");//TODO �G���[�R�[�h
        }

//    	updThb1DownCond.setHb1EgCd(vo.getThb1Down().getHb1EgCd());
//    	updThb1DownCond.setHb1TksKgyCd(vo.getThb1Down().getHb1TksKgyCd());
//    	updThb1DownCond.setHb1TksBmnSeqNo(vo.getThb1Down().getHb1TksBmnSeqNo());
//    	updThb1DownCond.setHb1TksTntSeqNo(vo.getThb1Down().getHb1TksTntSeqNo());
//    	updThb1DownCond.setHb1Yymm(vo.getThb1Down().getHb1Yymm());
//    	updThb1DownCond.setHb1JyutNo(vo.getThb1Down().getHb1JyutNo());
//    	updThb1DownCond.setHb1JyMeiNo(vo.getThb1Down().getHb1JyMeiNo());
//    	updThb1DownCond.setHb1UrMeiNo(vo.getThb1Down().getHb1UrMeiNo());


        //*********************************************************************************************************
        //�f�[�^�o�^�E�X�V
        //*********************************************************************************************************
        //���דo�^�����̎擾
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String meiTimStmp = sdf.format(new Date());

        //�L����׃f�[�^�폜
        thb2KmeiDao.deleteThb2KmeiByCondition(deleteThb2KmeiCond);

        //�L����׃f�[�^�����݂���ꍇ�̂ݍX�V
        if (vo.getThb2Kmei() != null && vo.getThb2Kmei().size() > 0){
            //�L����׃f�[�^�o�^
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
            if(!vo.getThb1Down().getHb1KsnTntNm().equals(""))
            {
                //�󒍃_�E�����[�h�f�[�^�X�V
                vo.getThb1Down().setHb1MeiTimStmp(meiTimStmp);
                thb1DownDao.updateThb1DownForDisplayData(vo.getThb1Down(), vo.getThb2Kmei());
            }
        }

        //��������Ă���ꍇ
        if(vo.getTouKouThb1Down() != null)
        {
            if(!vo.getTouKouThb1Down().getHb1TrkTntNm().equals("") || !vo.getTouKouThb1Down().getHb1KsnTntNm().equals(""))
            {
                thb1DownDao.updateTourokuKousinTaiou(vo.getTouKouThb1Down());
            }

//    		if(vo.getTouKouThb1Down().getHb1TrkTntNm() != null || vo.getTouKouThb1Down().getHb1KsnTntNm() != null)
//    		{
//    			thb1DownDao.updateTourokuKousinTaiou(vo.getTouKouThb1Down());
//    		}
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
    public DetailDataBulkUpdateResult bulkUpdateDetailData(DetailDataBulkUpdateVO vo) throws KKHException{

        DetailDataBulkUpdateResult result = new DetailDataBulkUpdateResult();

        for (DetailDataVO detailDataVo : vo.getDetailDataVOList()) {
            DetailUpdateDataVO detailUpdateVo = new DetailUpdateDataVO();

            detailUpdateVo.setEsqId(vo.getEsqId());
            detailUpdateVo.setThb1Down(detailDataVo.getThb1Down());
            detailUpdateVo.setThb2Kmei(detailDataVo.getThb2Kmei());
            detailUpdateVo.setMaxUpdDate(vo.getMaxUpdDate());

            updateDisplayData(detailUpdateVo);
        }

        return result;
    }

    //**********************************************************************************************************************************************************************************
    //���׌���(�󒍓��e�����������ɓ���Ȃ�)
    /**
     * �L����׃f�[�^���������܂��B
     *
     * @return DetailDataResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public DetailDataResult findDetailDataByCond(DetailDataCondition cond) throws KKHException {

        //��������
        DetailDataResult result = new DetailDataResult();

        //******************************************************
        //�L����׃f�[�^���擾
        //******************************************************
        Thb2KmeiDAO thb2KmeiDAO = Thb2KmeiDAOFactory.createThb2KmeiDAO();
        Thb2KmeiVO thb2KmeiCond = new Thb2KmeiVO();
        thb2KmeiCond.setHb2EgCd(cond.getEgCd());
        thb2KmeiCond.setHb2TksKgyCd(cond.getTksKgyCd());
        thb2KmeiCond.setHb2TksBmnSeqNo(cond.getTksBmnSeqNo());
        thb2KmeiCond.setHb2TksTntSeqNo(cond.getTksTntSeqNo());
        thb2KmeiCond.setHb2Yymm(cond.getYymm());
        thb2KmeiCond.setHb2JyutNo(cond.getJyutNo());
        thb2KmeiCond.setHb2JyMeiNo(cond.getJyMeiNo());
        thb2KmeiCond.setHb2UrMeiNo(cond.getUrMeiNo());

        List<Thb2KmeiVO> thb2KmeiList = thb2KmeiDAO.findThb2KmeiByCondCmn(thb2KmeiCond);
        result.setThb2KmeiList(thb2KmeiList);

        return result;
    }

    //**********************************************************************************************************************************************************************************
    //�󒍓o�^���e����
    /**
     * �󒍃f�[�^���������܂��B
     *
     * @return JyutyuDataResult �ėp�}�X�^�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public JyutyuDataCondResult findByCondition(JyutyuDataCondition cond) throws KKHException {

        //��������
        JyutyuDataCondResult result = new JyutyuDataCondResult();

        JyutyuDataDAO dao = JyutyuDataDAOFactory.createJyutyuDataDAO();

        //***********************************************************
        //�ėp�V�X�e���}�X�^�̌���
        //(���דo�^��̎󒍃_�E�����[�h�ύX���`�F�b�N���鍀�ڂ̎擾)
        //***********************************************************
        CommonDAO commonDao = CommonDAOFactory.createCommonDAO();
        CommonCondition commonCond = new CommonCondition();
        commonCond.setEgCd(cond.getEgCd());
        commonCond.setTksKgyCd(cond.getTksKgyCd());
        commonCond.setTksBmnSeqNo(cond.getTksBmnSeqNo());
        commonCond.setTksTntSeqNo(cond.getTksTntSeqNo());
        commonCond.setSybt("004");
        List<CommonVO> commonVoList = commonDao.findCommonByCondition(commonCond);

        //******************************************************
        //�󒍃f�[�^���擾
        //******************************************************
        List<String> compareColumnList = new ArrayList<String>();
        for (CommonVO commonVO : commonVoList) {
            if (commonVO.getField2().equals("1") && StringUtil.isBlank(commonVO.getField1()) == false){
                compareColumnList.addAll(Arrays.asList(commonVO.getField1().split(",")));
            }
        }
        cond.setCompareColumnList(compareColumnList);
        if (compareColumnList.size() > 0){
            cond.setUpdPostFlag(true);
        }
        List<JyutyuDataVO> list = dao.findJyutyuDataCOMMONByCondition(cond);

        // �ύX�E�폜�`�F�b�N�̏ꍇ
        if (cond.getUpdateCheckFlag() == true) {
            boolean updFlg = true;
            checkUpdate(cond, list ,updFlg);

            list = dao.findJyutyuDataCOMMONByCondition(cond);

            //�X�V�t���O��false�ɂ���
            updFlg = false;
            //�X�V��̎󒍃f�[�^���Ď擾����
            checkUpdate(cond, list ,updFlg);
        }

        result.setJutyuData(list);

        return result;
    }

    //**********************************************************************************************************************************************************************************
    //�󒍍폜
    /**
     * �󒍍폜
     * @param vo
     * @throws KKHException
     */
    public void deleteJyutyuData(JyutyuDataDeleteVO vo) throws KKHException{

        //DAO
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();
        Thb2KmeiDAO thb2KmeiDao = Thb2KmeiDAOFactory.createThb2KmeiDAO();

        for (Thb1DownVO deleteThb1DownCond : vo.getThb1DownList()) {

            //�폜�E�r���f�[�^�擾����
            Thb2KmeiVO deleteThb2KmeiCond = new Thb2KmeiVO();

            //*********************************************************************************************************
            //�r������
            //*********************************************************************************************************
            List<Thb1DownVO> thb1List = thb1DownDao.lockThb1DownForJyutyuDataDel(deleteThb1DownCond);
            if (thb1List.size() <= 0 || vo.getMaxUpdDate().compareTo(thb1List.get(0).getHb1TimStmp()) < 0 ){
                throw new KKHException("�r���G���[", "LOCK-E0001");//TODO �G���[�R�[�h
            }

            for (Thb1DownVO deleteThb1Down : thb1List) {
                deleteThb2KmeiCond.setHb2EgCd(deleteThb1Down.getHb1EgCd());
                deleteThb2KmeiCond.setHb2TksKgyCd(deleteThb1Down.getHb1TksKgyCd());
                deleteThb2KmeiCond.setHb2TksBmnSeqNo(deleteThb1Down.getHb1TksBmnSeqNo());
                deleteThb2KmeiCond.setHb2TksTntSeqNo(deleteThb1Down.getHb1TksTntSeqNo());
                deleteThb2KmeiCond.setHb2Yymm(deleteThb1Down.getHb1Yymm());
                deleteThb2KmeiCond.setHb2JyutNo(deleteThb1Down.getHb1JyutNo());
                deleteThb2KmeiCond.setHb2JyMeiNo(deleteThb1Down.getHb1JyMeiNo());
                deleteThb2KmeiCond.setHb2UrMeiNo(deleteThb1Down.getHb1UrMeiNo());
                List<Thb2KmeiVO> thb2List = thb2KmeiDao.lockThb2Kmei(deleteThb2KmeiCond);
                if (thb2List.size() > 0 && vo.getMaxUpdDate().compareTo(thb2List.get(0).getHb2TimStmp()) < 0 ){
                    throw new KKHException("�r���G���[", "LOCK-E0001");//TODO �G���[�R�[�h
                }
            }

            //*********************************************************************************************************
            //�f�[�^�폜
            //*********************************************************************************************************
            for (Thb1DownVO deleteThb1Down : thb1List) {
                //�L����׃f�[�^�폜
                deleteThb2KmeiCond.setHb2EgCd(deleteThb1Down.getHb1EgCd());
                deleteThb2KmeiCond.setHb2TksKgyCd(deleteThb1Down.getHb1TksKgyCd());
                deleteThb2KmeiCond.setHb2TksBmnSeqNo(deleteThb1Down.getHb1TksBmnSeqNo());
                deleteThb2KmeiCond.setHb2TksTntSeqNo(deleteThb1Down.getHb1TksTntSeqNo());
                deleteThb2KmeiCond.setHb2Yymm(deleteThb1Down.getHb1Yymm());
                deleteThb2KmeiCond.setHb2JyutNo(deleteThb1Down.getHb1JyutNo());
                deleteThb2KmeiCond.setHb2JyMeiNo(deleteThb1Down.getHb1JyMeiNo());
                deleteThb2KmeiCond.setHb2UrMeiNo(deleteThb1Down.getHb1UrMeiNo());
                thb2KmeiDao.deleteThb2KmeiByCondition(deleteThb2KmeiCond);
            }

            //�󒍃_�E�����[�h�f�[�^�X�V
            thb1DownDao.deleteThb1DownByCondition(deleteThb1DownCond);
        }
    }

    //**********************************************************************************************************************************************************************************
    //�N���ύX
    /**
     * �����N���ύX
     * @param vo
     * @throws KKHException
     */
    public SeikyuYymmChangeResult changeSeikyuYymm(SeikyuYymmChangeVO vo) throws KKHException{

        SeikyuYymmChangeResult result = new SeikyuYymmChangeResult();
        List<Thb1DownVO> resThb1DownList = new ArrayList<Thb1DownVO>();

        //DAO
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();

        //*********************************************************************************************************
        //�r������
        //*********************************************************************************************************
        for (Thb1DownVO thb1DownVo : vo.getThb1DownList()) {
            List<Thb1DownVO> thb1List = thb1DownDao.lockThb1Down(thb1DownVo);
            if (thb1List.size() <= 0 || vo.getMaxUpdDate().compareTo(thb1List.get(0).getHb1TimStmp()) < 0 ){
                throw new KKHException("�r���G���[", "LOCK-E0001");//TODO �G���[�R�[�h
            }
        }

        //*********************************************************************************************************
        //�f�[�^�o�^�E�X�V
        //*********************************************************************************************************
        for (Thb1DownVO thb1DownVo : vo.getThb1DownList()) {
            Thb1DownVO updThb1DownVo = new Thb1DownVO();
            updThb1DownVo.setHb1TrkApl(thb1DownVo.getHb1TrkApl());	//�o�^�v���O����
            updThb1DownVo.setHb1TrkTnt(thb1DownVo.getHb1TrkTnt());	//�o�^�S����
            updThb1DownVo.setHb1UpdApl(thb1DownVo.getHb1UpdApl());
            //updThb1DownVo.setHb1UpdTnt(vo.getEsqId());
            updThb1DownVo.setHb1UpdTnt(thb1DownVo.getHb1UpdTnt());
            updThb1DownVo.setHb1EgCd(thb1DownVo.getHb1EgCd());
            updThb1DownVo.setHb1TksKgyCd(thb1DownVo.getHb1TksKgyCd());
            updThb1DownVo.setHb1TksBmnSeqNo(thb1DownVo.getHb1TksBmnSeqNo());
            updThb1DownVo.setHb1TksTntSeqNo(thb1DownVo.getHb1TksTntSeqNo());
            updThb1DownVo.setHb1Yymm(vo.getYymmNew());
            updThb1DownVo.setHb1JyutNo(thb1DownVo.getHb1JyutNo());
            updThb1DownVo.setHb1JyMeiNo(thb1DownVo.getHb1JyMeiNo());
            updThb1DownVo.setHb1UrMeiNo(thb1DownVo.getHb1UrMeiNo());
            updThb1DownVo.setHb1TouFlg(thb1DownVo.getHb1TouFlg());
            if (thb1DownVo.getHb1YymmOld().equals(vo.getYymmNew())){
                //�ύX�㐿���N�����ύX�O�N���ƈ�v����ꍇ�͋���Z�b�g
                updThb1DownVo.setHb1YymmOld(" ");
            }else if (!thb1DownVo.getHb1YymmOld().trim().equals("")){
                //�ύX�O�N�����ݒ肳��Ă���ꍇ�͂��̂܂܂̒l���Z�b�g
                updThb1DownVo.setHb1YymmOld(thb1DownVo.getHb1YymmOld());
            }else{
                //�ύX�O�N������̏ꍇ�͍X�V����
                updThb1DownVo.setHb1YymmOld(thb1DownVo.getHb1Yymm());
            }

            Thb1DownVO uniqueChkData = thb1DownDao.loadThb1Down(updThb1DownVo);
            if (uniqueChkData != null) {
                throw new KKHException("�����N���ύX��ɏd������󒍖���No�̏�񂪓o�^����Ă��܂��B", "UNIQUE-E0001");//TODO �G���[�R�[�h
            }

            //�󒍃_�E�����[�h�f�[�^�X�V
            thb1DownDao.updateThb1DownForCngSeikyuYymm(thb1DownVo, updThb1DownVo);
            //�X�V��f�[�^���擾
            resThb1DownList.add(thb1DownDao.loadThb1Down(thb1DownVo));

        }

        result.setThb1DownList(resThb1DownList);
        return result;
    }

    //**********************************************************************************************************************************************************************************
    //�V�K�o�^
    /**
     * �V�K�o�^
     *
     * @param vo �_�E�����[�h�f�[�^VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public JyutyuDataRegisterResult registerJyutyuData(JyutyuDataRegisterVO vo) throws KKHException {

        JyutyuDataRegisterResult result = new JyutyuDataRegisterResult();
        List<Thb1DownVO> retThb1DownList = new ArrayList<Thb1DownVO>();

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();

        for (Thb1DownVO thb1DownVo : vo.getThb1DownList()) {
            if (thb1DownVo.getHb1JyutNo() != null && !thb1DownVo.getHb1JyutNo().trim().equals("")){
                //��No���ݒ肳��Ă���ꍇ�͏d���`�F�b�N���s��
                if (checkUniqueJyutyuNo(thb1DownVo) == false){
                    throw new KKHException("�ݒ肳�ꂽ�󒍂m���͂��łɓo�^����Ă��܂��B", "UNIQUE-E0002");//TODO �G���[�R�[�h
                }
            } else {
                //��No���ݒ肳��Ă��Ȃ��ꍇ�͍̔Ԃ��s��
                setJyutyuNo(thb1DownVo);
            }
            //�o�^����
            dao.insertThb1Down(thb1DownVo);
            //�o�^�f�[�^���������Č��ʂƂ��ĕێ�����B
            retThb1DownList.add(dao.loadThb1Down(thb1DownVo));
        }

        result.setThb1DownList(retThb1DownList);
        return result;
    }

    private boolean checkUniqueJyutyuNo(Thb1DownVO vo) throws KKHException {

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();

        Thb1DownVO cond = new Thb1DownVO();
        cond.setHb1EgCd(vo.getHb1EgCd());
        cond.setHb1TksKgyCd(vo.getHb1TksKgyCd());
        cond.setHb1TksBmnSeqNo(vo.getHb1TksBmnSeqNo());
        cond.setHb1TksTntSeqNo(vo.getHb1TksTntSeqNo());
        cond.setHb1JyutNo(vo.getHb1JyutNo());
        cond.setHb1JyMeiNo(vo.getHb1JyMeiNo());
        cond.setHb1UrMeiNo(vo.getHb1UrMeiNo());
        List<Thb1DownVO> jyutyuNoList = dao.getJyutyuNoForUniqueCheck(cond);

        if (jyutyuNoList == null || jyutyuNoList.size() <= 0){
            return true;
        }else{
            return false;
        }
    }

    private void setJyutyuNo(Thb1DownVO vo) throws KKHException {

        String newJyutyuNo = "";

        if ((vo.getHb1TksKgyCd() + vo.getHb1TksBmnSeqNo() + vo.getHb1TksTntSeqNo()).equals(KKHConstants.TksKgyCode.LION.getCode())||
        		// 2016/01/29 �A�T�q�����J���s�X�Ή� Hisada
        		//�A�T�q�����̏�����ǉ��i��No�̍̔Ԃɂ��ă}�X�^���g�p�j
        		(vo.getHb1TksKgyCd() + vo.getHb1TksBmnSeqNo() + vo.getHb1TksTntSeqNo()).equals(KKHConstants.TksKgyCode.ASHI.getCode())){ 
            ExecProcedureDAO procDao = ExecProcedureDAOFactory.createExecProcedureDAO();
            newJyutyuNo = procDao.execPRCHB_SEQ_JYUTNO(vo.getHb1EgCd(), vo.getHb1TksKgyCd() + vo.getHb1TksBmnSeqNo() + vo.getHb1TksTntSeqNo() , vo.getHb1Yymm());
            newJyutyuNo = newJyutyuNo.trim();
        }else{
            String year = "";
            String mon = "";
            String number = "";

            year = vo.getHb1Yymm().substring(0, 4);

            String mm = vo.getHb1Yymm().substring(4, 6);
            if (mm.equals("01")){
                mon = "JA";
            }else if (mm.equals("02")){
                mon = "FB";
            }else if (mm.equals("03")){
                mon = "MR";
            }else if (mm.equals("04")){
                mon = "AP";
            }else if (mm.equals("05")){
                mon = "MY";
            }else if (mm.equals("06")){
                mon = "JN";
            }else if (mm.equals("07")){
                mon = "JL";
            }else if (mm.equals("08")){
                mon = "AU";
            }else if (mm.equals("09")){
                mon = "SP";
            }else if (mm.equals("10")){
                mon = "OC";
            }else if (mm.equals("11")){
                mon = "NV";
            }else if (mm.equals("12")){
                mon = "DC";
            }

            String maxJyutyuNo = "0000000000";
            //���݂̎�No�ő�l���擾
            Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();
            Thb1DownVO cond = new Thb1DownVO();
            cond.setHb1EgCd(vo.getHb1EgCd());
            cond.setHb1TksKgyCd(vo.getHb1TksKgyCd());
            cond.setHb1TksBmnSeqNo(vo.getHb1TksBmnSeqNo());
            cond.setHb1TksTntSeqNo(vo.getHb1TksTntSeqNo());
            cond.setHb1Yymm(vo.getHb1Yymm());
            cond.setHb1JyutNo(year + mon);
            List<Thb1DownVO> maxJyutyuNoList = dao.getMaxJyutyuNo(cond);
            if (maxJyutyuNoList != null && maxJyutyuNoList.size() > 0 && !maxJyutyuNoList.get(0).getHb1JyutNo().trim().equals("")){
                maxJyutyuNo = maxJyutyuNoList.get(0).getHb1JyutNo();
            }

            number = new DecimalFormat("0000").format(Integer.parseInt(maxJyutyuNo.substring(6, 10)) + 1);

            newJyutyuNo = year + mon + number;
        }

        if (StringUtil.isBlank(newJyutyuNo)){
            throw new KKHException("�󒍔ԍ����̔Ԃ���Ă��܂���B", "E");//TODO �G���[�R�[�h
        }

        vo.setHb1JyutNo(newJyutyuNo);
    }

    //**********************************************************************************************************************************************************************************
    //�󒍓���
    /**
     * �󒍓���
     *
     * @param vo �_�E�����[�h�f�[�^VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public JyutyuDataMergeResult mergeJyutyuData(JyutyuDataMergeVO vo) throws KKHException {

        JyutyuDataMergeResult result = new JyutyuDataMergeResult();
//    	List<Thb1DownVO> retThb1DownList = new ArrayList<Thb1DownVO>();

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();

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

//    	for(Thb1DownVO Vo_i : vo.getTougouMotoList())
//    	{
//    		if(Vo_i.getHb1KsnTimStmp().toString().equals("Mon Jan 03 00:00:00 JST 1"))
//    		{
//    			Vo_i.setHb1KsnTimStmp(null);
//    		}
//    	}
        //�������f�[�^�̍X�V
        for (Thb1DownVO thb1DownVO : vo.getTougouMotoList()) {
            thb1DownVO.setHb1TJyutNo(vo.getTougouSaki().getHb1JyutNo());
            thb1DownVO.setHb1TJyMeiNo(vo.getTougouSaki().getHb1JyMeiNo());
            thb1DownVO.setHb1TUrMeiNo(vo.getTougouSaki().getHb1UrMeiNo());
            dao.updateThb1DownForJyutyuMerge(thb1DownVO);
        }

        //Vo�̃^�C���X�^���v������
        if(vo.getTougouSaki().getHb1KsnTimStmp().toString().equals("Mon Jan 03 00:00:00 JST 1"))
        {
            vo.getTougouSaki().setHb1KsnTimStmp(null);
        }else
        {

//    		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//    		String datehenkan = sdf1.format(vo.getTougouSaki().getHb1KsnTimStmp());
//    		try {
//				Date date1 = DateFormat.getDateInstance().parse(datehenkan);
//				vo.getTougouSaki().setHb1KsnTimStmp(date1);
//			} catch (ParseException e) {
//				// TODO �����������ꂽ catch �u���b�N
//				e.printStackTrace();
//			}
        }

        //������f�[�^�̓o�^
        dao.insertThb1Down(vo.getTougouSaki());

        return result;
    }

    //**********************************************************************************************************************************************************************************
    //��������
    /**
     * ��������
     *
     * @param vo �_�E�����[�h�f�[�^VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public JyutyuDataMergeCancelResult mergeCancelJyutyuData(JyutyuDataMergeCancelVO vo) throws KKHException {

        JyutyuDataMergeCancelResult result = new JyutyuDataMergeCancelResult();

        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();

        //*********************************************************************************************************
        //�r������
        //*********************************************************************************************************
        List<Thb1DownVO> lockThb1Down = dao.lockThb1Down(vo.getTougouSaki());
        if (lockThb1Down.size() <= 0 || vo.getMaxUpdDate().compareTo(lockThb1Down.get(0).getHb1TimStmp()) < 0 ){
            throw new KKHException("�r���G���[", "LOCK-E0001");
        }

        //*********************************************************************************************************
        //�f�[�^�X�V
        //*********************************************************************************************************
        //�������f�[�^�̍X�V
        Thb1DownVO cond = new Thb1DownVO();
        //cond.setHb1UpdTnt(vo.getEsqId());
        cond.setHb1UpdTnt(vo.getTougouSaki().getHb1UpdTnt());
        cond.setHb1UpdApl(vo.getTougouSaki().getHb1UpdApl());
        cond.setHb1EgCd(vo.getTougouSaki().getHb1EgCd());
        cond.setHb1TksKgyCd(vo.getTougouSaki().getHb1TksKgyCd());
        cond.setHb1TksBmnSeqNo(vo.getTougouSaki().getHb1TksBmnSeqNo());
        cond.setHb1TksTntSeqNo(vo.getTougouSaki().getHb1TksTntSeqNo());
        cond.setHb1Yymm(vo.getTougouSaki().getHb1Yymm());
        cond.setHb1TJyutNo(vo.getTougouSaki().getHb1JyutNo());
        cond.setHb1TJyMeiNo(vo.getTougouSaki().getHb1JyMeiNo());
        cond.setHb1TUrMeiNo(vo.getTougouSaki().getHb1UrMeiNo());
        dao.updateThb1DownForJyutyuMergeCancel(cond);

        //������f�[�^�̍폜
        dao.deleteThb1Down(vo.getTougouSaki());

        return result;
    }

    //**********************************************************************************************************************************************************************************
    //��������
    public Thb8DownRResult findJyutyuRirekiDataByCond(Thb8DownRCondition cond)throws KKHException {

        //��������
        Thb8DownRResult result = new Thb8DownRResult();

        //*************************************************
        //�󒍃_�E�����[�h�����f�[�^�擾
        //*************************************************
        Thb8DownRDAO dao = Thb8DownRDAOFactory.createThb8DownRDAO();
        List<Thb8DownRVO> voList = dao.findJyutyuRirekiDataByCond(cond);

        result.setThb8DownRList(voList);

        return result;
    }

    //**********************************************************************************************************************************************************************************
    //�ύX�E�폜�`�F�b�N
    //**********************************************************************************************************************************************************************************
    /**
     * �����P�F�󒍃f�[�^����
     * �����Q�F�󒍃f�[�^VO
     * �����R�F�X�V�t���O�itrue�F�󒍃e�[�u���X�V���� false�F�󒍃e�[�u���X�V���Ȃ��j
     * �߂�l�F����
     **/
    private void checkUpdate(JyutyuDataCondition cond, List<JyutyuDataVO> jyutyuDataVOList, boolean pUpdFlg) throws KKHException {

        // �󒍃f�[�^���O���̏ꍇ
        if (jyutyuDataVOList.size() == 0) {
            return;
        }

        // TODO ���݂�JDBC�ڑ���z�肵�Ď������Ă���BDB�����N�ɂȂ����ꍇ�͗v�ύX
        ThbAdmUriagemDAO thbAdmUriagemDAO = ThbAdmUriagemDAOFactory.createThbAdmUriagemDAO();
        Thb1DownDAO thb1DownDao = Thb1DownDAOFactory.createThb1DownDAO();

        // �󒍃f�[�^�̌������A�J��Ԃ�
        for (int i = 0; i < jyutyuDataVOList.size(); i++) {
            JyutyuDataVO jyutyuDataVO = jyutyuDataVOList.get(i);
            if (JYUTDELFLG_ON.equals(jyutyuDataVO.getJyutDelFlg())) {
                continue;
            }
            // TODO �󒍃��X�g�̌������AVIEW�����A�_�E�����[�h�̍X�V���J��Ԃ��B
            ThbAdmUriagemCondition thbAdmUriagemCondition = new ThbAdmUriagemCondition();
            thbAdmUriagemCondition.setAtEgsyoCd(jyutyuDataVO.getHb1AtuEgCd());
            thbAdmUriagemCondition.setTksKgyCd(jyutyuDataVO.getHb1TksKgyCd());
            thbAdmUriagemCondition.setTksBmnSeqNo(jyutyuDataVO.getHb1TksBmnSeqNo());
            thbAdmUriagemCondition.setTksTntSeqNo(jyutyuDataVO.getHb1TksTntSeqNo());
            thbAdmUriagemCondition.setJyutNo(jyutyuDataVO.getHb1JyutNo());
            thbAdmUriagemCondition.setJyMeiSeq(jyutyuDataVO.getHb1JyMeiNo());
            thbAdmUriagemCondition.setUrMeiSeq(jyutyuDataVO.getHb1UrMeiNo());
            // �L����חp���㖾��VIEW����
            List<ThbAdmUriagemVO> thbAdmUriagemList = thbAdmUriagemDAO.getAdmUriagemViewData(thbAdmUriagemCondition);
            // �f�[�^�Ȃ��̏ꍇ
            if (thbAdmUriagemList.size() == 0) {
                jyutyuDataVO.setJyutDelFlg(JYUTDELFLG_ON);
                jyutyuDataVO.setSeikJtai(null);
                jyutyuDataVO.setSeiSagSts(null);
                jyutyuDataVO.setStpKbn(null);
            // �f�[�^����̏ꍇ
            } else {
                ThbAdmUriagemVO thbAdmUriagemVO = thbAdmUriagemList.get(0);
                // ���~�敪�����~�̏ꍇ
                if (STPKBN_STOP.equals(thbAdmUriagemVO.getStpKbn())) {
                    jyutyuDataVO.setJyutDelFlg(JYUTDELFLG_ON);
                // ���̑��̏ꍇ
                } else {
                    jyutyuDataVO.setJyutDelFlg(null);
                }
                jyutyuDataVO.setSeikJtai(thbAdmUriagemVO.getSeikJtai());
                jyutyuDataVO.setSeiSagSts(thbAdmUriagemVO.getSeiSagSts());
                jyutyuDataVO.setStpKbn(thbAdmUriagemVO.getStpKbn());
            }
            // �L����חp���㖾��VIEW�̎擾���ڂ𔽉f�����󒍃f�[�^�����X�g�ɍĐݒ�
            jyutyuDataVOList.set(i, jyutyuDataVO);

            //�X�V�t���O��true�̏ꍇ
            if(pUpdFlg == true)
            {
                // �󒍍폜�t���O���n�m�̏ꍇ
                if (JYUTDELFLG_ON.equals(jyutyuDataVO.getJyutDelFlg())) {
                    Thb1DownVO updThb1DownVo = new Thb1DownVO();
                    updThb1DownVo.setHb1UpdApl(cond.getAplId());
                    updThb1DownVo.setHb1UpdTnt(cond.getEsqId());
                    updThb1DownVo.setHb1EgCd(jyutyuDataVO.getHb1EgCd());
                    updThb1DownVo.setHb1TksKgyCd(jyutyuDataVO.getHb1TksKgyCd());
                    updThb1DownVo.setHb1TksBmnSeqNo(jyutyuDataVO.getHb1TksBmnSeqNo());
                    updThb1DownVo.setHb1TksTntSeqNo(jyutyuDataVO.getHb1TksTntSeqNo());
                    updThb1DownVo.setHb1Yymm(jyutyuDataVO.getHb1Yymm());
                    updThb1DownVo.setHb1JyutNo(jyutyuDataVO.getHb1JyutNo());
                    updThb1DownVo.setHb1JyMeiNo(jyutyuDataVO.getHb1JyMeiNo());
                    updThb1DownVo.setHb1UrMeiNo(jyutyuDataVO.getHb1UrMeiNo());
                    updThb1DownVo.setHb1TouFlg(jyutyuDataVO.getHb1TouFlg());
                    // �󒍃_�E�����[�h�f�[�^�X�V
                    thb1DownDao.updateThb1DownForUpdateCheck(updThb1DownVo);
                }
            }
        }
    }

    //**********************************************************************************************************************************************************************************
    //����
    //**********************************************************************************************************************************************************************************
    /**
     * �_�E�����[�h�f�[�^�̌���
     *
     * @param vo �_�E�����[�h�f�[�^VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public Thb1DownVO loadThb1Down(Thb1DownVO vo) throws KKHException {
        Thb1DownDAO dao = Thb1DownDAOFactory.createThb1DownDAO();
        return dao.loadThb1Down(vo);
    }

    /**
     * �L����׃f�[�^�̓o�^
     *
     * @param vo �L����׃f�[�^VO
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void insertThb2Kmei(Thb2KmeiVO vo) throws KKHException {
        Thb2KmeiDAO dao = Thb2KmeiDAOFactory.createThb2KmeiDAO();
        dao.insertThb2Kmei(vo);
    }

}
