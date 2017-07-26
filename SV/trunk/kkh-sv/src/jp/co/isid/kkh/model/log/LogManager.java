package jp.co.isid.kkh.model.log;

import java.util.*;
import java.text.*;


import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.log.LogRegistDAO;
import jp.co.isid.kkh.model.log.LogRegistDAOFactory;
import jp.co.isid.kkh.model.log.LogVO;

/**
 * <P>
 * �ėp���O����Manager�B
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2011/11/11 IP H.Shimizu)<BR>
 * </P>
 * @author
 */
public class LogManager {

    /** �V���O���g���C���X�^���X */
    private static LogManager _manager = new LogManager();

    /**
     * �V���O���g���ׁ̈A�C���X�^���X�����֎~���܂��B
     */
    private LogManager() {
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static LogManager getInstance() {
        return _manager;
    }


    /**
     * �ėp���O���������܂��B
     *
     * @return LogResult �ėp���O�����f�[�^
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public LogResult findLogByCondition(LogCondition cond) throws KKHException {

    	//�p�����[�^�̕K�{�`�F�b�N
    	if (cond.getEsqId()== null || cond.getEsqId().equals("")){
    		throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
    	}
    	if (cond.getEgCd() == null || cond.getEgCd().equals("")){
    		throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
    	}
    	if (cond.getTksKgyCd() == null || cond.getTksKgyCd().equals("")){
    		throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
    	}
    	if (cond.getTksBmnSeqNo() == null || cond.getTksBmnSeqNo().equals("")){
    		throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
    	}
    	if (cond.getTksTntSeqNo() == null || cond.getTksTntSeqNo().equals("")){
    		throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
    	}
    	if (cond.getSybt() == null || cond.getSybt().equals("")){
    		throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
    	}

    	//��������
    	LogResult result = new LogResult();
    	//��������(�}�X�^��ސݒ�E���ڐݒ�擾�p)
    	LogCondition lCond = new LogCondition();


    	LogDAO dao = LogDAOFactory.createLogDAO();

    	//******************************************************
    	//�}�X�^��ސݒ���擾
    	//******************************************************
    	lCond = cond;
        List<LogVO> LogList = dao.findLogByCondition(lCond);
        result.setLog(LogList);

        return result;
    }


    /**
     * �ėp���O�f�[�^�̓o�^���s���܂��B
     *
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    public void registLog(LogVO volist) throws KKHException {
    	//�p�����[�^�̕K�{�`�F�b�N
    	if (volist.getTrkPl()== null || volist.getTrkPl().equals("")){
    		throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
    	}
		if (volist.getTrkTnt()== null || volist.getTrkTnt().equals("")){
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
		if (volist.getUpdPl()== null || volist.getUpdPl().equals("")){
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
		if (volist.getUpdTnt()== null || volist.getUpdTnt().equals("")){
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
		if (volist.getEgCd()== null || volist.getEgCd().equals("")){
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
		if (volist.getTksKgyCd()== null || volist.getTksKgyCd().equals("")){
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
		if (volist.getTksBmnSeqNo()== null || volist.getTksBmnSeqNo().equals("")){
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
		if (volist.getTksTntSeqNo()== null || volist.getTksTntSeqNo().equals("")){
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
		if (volist.getSybt()== null || volist.getSybt().equals("")){
			throw new KKHException("�p�����[�^�w��G���[", "BD-E0001");
		}
        // ���O�f�[�^�o�^
    	LogRegistDAO dao = LogRegistDAOFactory.createLogRegistDAO();
    	Date UpdDate = new Date();  //(1)Date�I�u�W�F�N�g�𐶐�


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

    	volist.setUpdDate(sdf.format(UpdDate));
        dao.registLog(volist);

    }

}
