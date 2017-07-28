package jp.co.isid.kkh.customer.ash.model.detail;

import java.util.List;
import jp.co.isid.kkh.model.base.KKHException;

/**
 * <P>
 * �L�[�ǂ̔ԑg�R�[�h��Manager
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2014/08/20 HLC S.Jang)<BR>
 * </P>
 *
 * @author HLC ��(Jang)
 */
public class FindKeyKyokuBangumiCdManager {

    /** �V���O���g���C���X�^���X */
    private static FindKeyKyokuBangumiCdManager _manager = new FindKeyKyokuBangumiCdManager();

    /**
     * �C���X�^���X��Ԃ��܂��B
     *
     * @return �C���X�^���X
     */
    public static FindKeyKyokuBangumiCdManager getInstance() {
        return _manager;
    }

    /**
     * �L�[�ǂ̔ԑg�R�[�h�̃f�[�^���������܂��B
     *
     * @return FindKeyKyokuBangumiCdResult �ėp�}�X�^�����f�[�^
     * @throws KKHException
     *             �������ɃG���[�����������ꍇ
     */
    public FindKeyKyokuBangumiCdResult findKeyKyokuBangumiCd(
            FindKeyKyokuBangumiCdCondition cond) throws KKHException {
        FindKeyKyokuBangumiCdDAO dao = FindKeyKyokuBangumiCdDAOFactory
                .createFindKeyKyokuBangumiCdaDAO();
        FindKeyKyokuBangumiCdResult result = new FindKeyKyokuBangumiCdResult();

        List<FindKeyKyokuBangumiCdVO> bangumiCdVoList = dao
                .findKeyKyokuBangumiCd(cond);
        result.setBangumiCdList(bangumiCdVoList);

        return result;
    }

}
