package jp.co.isid.kkh.controller.login;

import java.util.List;

import jp.co.isid.kkh.model.base.KKHException;
import jp.co.isid.kkh.model.common.CommonCondition;
import jp.co.isid.kkh.model.common.CommonManager;
import jp.co.isid.kkh.model.common.CommonResult;
import jp.co.isid.kkh.model.common.CommonVO;
import jp.co.isid.kkh.model.login.AccountSecurityRoleCondition;
import jp.co.isid.kkh.model.login.AccountSecurityRoleManager;
import jp.co.isid.kkh.model.login.AccountSecurityRoleResult;
import jp.co.isid.kkh.util.StringUtil;
import jp.co.isid.nj.controller.command.Command;

/**
 * <P>
 * �Ɩ���v�Z�L�����e�B���[���擾�R�}���h
 * </P>
 * <P>
 * <B>�C������</B><BR>
 * �E�V�K�쐬(2012/02/13 JSE H.Abe)<BR>
 * </P>
 *
 * @author JSE H.Abe
 */
public class AccountSecurityRoleGetCmd extends Command {

    private static final long serialVersionUID = 1L;

    /** �c�Ə��i��j�R�[�h�F�Ɩ���v�Z�L�����e�B���[���擾�ΏۊOESQID */
    private static final String EGCD_NOT_SUBJECT_ESQID = "99";

    /** ���Ӑ��ƃR�[�h�F�Ɩ���v�Z�L�����e�B���[���擾�ΏۊOESQID */
    private static final String TKSKGYCD_NOT_SUBJECT_ESQID = "999999";

    /** ���Ӑ敔��SEQNO�F�Ɩ���v�Z�L�����e�B���[���擾�ΏۊOESQID */
    private static final String TKSBMNSEQNO_NOT_SUBJECT_ESQID = "99";

    /** ���Ӑ�S��SEQNO�F�Ɩ���v�Z�L�����e�B���[���擾�ΏۊOESQID */
    private static final String TKSTNTSEQNO_NOT_SUBJECT_ESQID = "99";

    /** ��ʁF�Ɩ���v�Z�L�����e�B���[���擾�ΏۊOESQID */
    private static final String SYBT_NOT_SUBJECT_ESQID = "006";

    /** �������ʃL�[ */
    private static final String RESULT_KEY = "RESULT_KEY";

    /** �������� */
    private AccountSecurityRoleCondition _condition;

    /**
     * �����������g�p���A�������������s���܂��B
     *
     * @throws KKHException �����Ɏ��s�����ꍇ
     */
    public void execute() throws KKHException {

        // ���̓`�F�b�N
        checkInput();
        // �ΏۊO���[�U�[�`�F�b�N
        if (checkNotSubjectUser() == true){
            getResult().set(RESULT_KEY, setResult(null, true));
            return;
        }
        // �Ɩ���v�Z�L�����e�B���[���i���Ό����j�擾
        AccountSecurityRoleManager manager = AccountSecurityRoleManager.getInstance();
        String relativeAuthority = manager.getAccountSecurityRole(_condition);
        // �ԋp�l�ݒ�
        getResult().set(RESULT_KEY, setResult(relativeAuthority, false));
    }

    /**
     * ����������ݒ肵�܂��B
     *
     * @param condition ��������
     */
    public void setAccountSecurityRoleCondition(AccountSecurityRoleCondition condition) {
        _condition = condition;
    }

    /**
     * �������ʂ�Ԃ��܂��B
     *
     * @return ��������
     */
    public AccountSecurityRoleResult getAccountSecurityRoleResult() {
        return (AccountSecurityRoleResult) super.getResult().get(RESULT_KEY);
    }

    /**
     * �p�����[�^���̓`�F�b�N
     *
     * @throws KKHException �p�����[�^�w��G���[�̏ꍇ
     */
    private void checkInput() throws KKHException {

        if (StringUtil.isBlank(_condition.getAplId())) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getEsqId())) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
        if (StringUtil.isBlank(_condition.getPassword())) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
        if (_condition.getSecurityInfo() == null) {
            throw new KKHException("�p�����[�^�w��G���[", "HB-E0017");
        }
    }

    /**
     * �ΏۊO���[�U�[�`�F�b�N
     *
     * @return �ΏۊO���[�U�[�Ftrue�A���̑��Ffalse
     * @throws KKHException �������ɃG���[�����������ꍇ
     */
    private boolean checkNotSubjectUser() throws KKHException {

        CommonCondition cond = new CommonCondition();
        cond.setEsqId(_condition.getEsqId());
        cond.setEgCd(EGCD_NOT_SUBJECT_ESQID);
        cond.setTksKgyCd(TKSKGYCD_NOT_SUBJECT_ESQID);
        cond.setTksBmnSeqNo(TKSBMNSEQNO_NOT_SUBJECT_ESQID);
        cond.setTksTntSeqNo(TKSTNTSEQNO_NOT_SUBJECT_ESQID);
        cond.setSybt(SYBT_NOT_SUBJECT_ESQID);
        cond.setfield1(_condition.getEsqId());
        CommonManager manager = CommonManager.getInstance();
        CommonResult result = manager.findCommonByCondition(cond);
        List<CommonVO> list = result.getCommon();
        // �f�[�^���Ȃ��ꍇ
        if (list.size() == 0) {
            return false;
        }
        return true;
    }

    /**
     * �ԋp�l�ݒ�
     *
     * @param relativeAuthority ���Ό���
     * @param notSecurityRoleFlag �Z�L�����e�B���[���擾�ΏۊO�t���O
     * @return �Ɩ���v�Z�L�����e�B���[���擾����
     */
    private AccountSecurityRoleResult setResult(String relativeAuthority, boolean notSecurityRoleFlag) {

        AccountSecurityRoleResult result = new AccountSecurityRoleResult();
        result.setRelativeAuthority(relativeAuthority);
        result.setNotSecurityRoleFlag(notSecurityRoleFlag);
        return result;
    }

}
