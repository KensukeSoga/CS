package jp.co.isid.kkh.customer.acom.model.input;

import java.util.ArrayList;
import java.util.List;

import jp.co.isid.kkh.customer.acom.model.input.HikCommonCondition;
import jp.co.isid.kkh.customer.acom.model.input.HikVO;
import jp.co.isid.kkh.customer.acom.model.input.HikRegistVOList;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �����f�[�^����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/08 HLC J.Morobayashi)<BR>
 * </P>
 * @author HLC J.Morobayashi
 */
public class HikManager {

    /** �V���O���g���C���X�^���X */
    private static HikManager _manager = new HikManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private HikManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static HikManager getInstance() {
        return _manager;
    }

    /**
     * �����f�[�^���������܂��B
     *
     * @return HikSearchResult �����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public HikSearchResult findByCondition(HikCommonCondition cond) throws KKHException {

        // �����f�[�^����
    	HikDAO dao = HikDAOFactory.createHikDAO();

        List<HikVO> list = dao.findByCondition(cond);
        HikSearchResult result = new HikSearchResult();
        result.setHikVOList(list);
        return result;
    }

    /**
     * ���t�֌W�̂��������܂��B
     *
     * @return HikSearchResult �����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public HikSearchResult findDateCntByVoList(HikSearchDateCntVOList volist) throws KKHException {

        HikSearchDateCntDAO    dao = HikSearchDateCntDAOFactory.createHikSearchDateCntDAO();
        HikCommonCondition cond = new HikCommonCondition();
        HikSearchResult result = new HikSearchResult();

        List<HikSearchDateCntVO> list = new ArrayList<HikSearchDateCntVO>();

        if(volist.getHikSearchDateCntVOList() != null){
            for (HikSearchDateCntVO vo : volist.getHikSearchDateCntVOList()) {

                //��r�p�f�[�^�擾�̂��߁A������condition�ɃZ�b�g����
                cond.setTkskgycd(vo.getTksKgyCd());
                cond.setTksbmnseqno(vo.getTksBmnSeqNo());
                cond.setTkstntseqno(vo.getTksTntSeqNo());
                cond.setSyubetsu(vo.getSybt());
                cond.setIrban(vo.getIrban());
                cond.setIrrowban(vo.getIrrowban());
                cond.setRecCd(vo.getRecCd());

                //���X�g�ɓ��꒼�����s��
                for (HikSearchDateCntVO tmp : dao.findByCondition(cond)) {
                   list.add(tmp);
                }
            }
        }

        result.setHikSearchDateCntVOList(list);
        return result;
    }


    /**
     * ��r���p�����f�[�^���������܂��B
     *
     * @return HikSearchResult ��r���p�����f�[�^
     * @throws  KKHException �������ɃG���[�����������ꍇ
     */
    public HikSearchResult findCheckDataByVoList(HikRegistVOList volist) throws KKHException {

        HikCheckDataDAO    cdao = HikDAOFactory.createHikCheckDataDAO();
        HikCommonCondition cond = new HikCommonCondition();
        HikSearchResult result = new HikSearchResult();

        List<HikVO> list = new ArrayList<HikVO>();

        if(volist.getHikRegistVOList() != null){
            for (HikVO vo : volist.getHikRegistVOList()) {

                //��r�p�f�[�^�擾�̂��߁A������condition�ɃZ�b�g����
                cond.setTkskgycd(vo.getTksKgyCd());
                cond.setTksbmnseqno(vo.getTksBmnSeqNo());
                cond.setTkstntseqno(vo.getTksTntSeqNo());
                cond.setSyubetsu(vo.getSybt());
                cond.setIrrowban(vo.getIrrowban());
                cond.setIrban(vo.getIrban());
                cond.setRecCd(vo.getRecCd());

                //���X�g�ɓ��꒼�����s��
                for (HikVO tmp : cdao.findByCondition(cond)) {
                   list.add(tmp);
                }
            }
        }

        result.setHikVOList(list);
        return result;
    }

    /**
     * �����f�[�^�̓o�^���s���܂��B
     *
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void registHik(HikRegistVOList volist) throws KKHException {
        // �����f�[�^�o�^
        HikRegistDAO dao  = HikRegistDAOFactory.createHikRegistDAO();

        if(volist.getHikRegistVOList() != null){
            for (HikVO vo : volist.getHikRegistVOList()) {
                //�����f�[�^�o�^����
                dao.registHik(vo);
            }
        }
    }
}
