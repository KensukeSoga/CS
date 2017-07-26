package jp.co.isid.kkh.customer.mac.model.master;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import jp.co.isid.kkh.model.AbstractServiceResult;

/**
 *
 * <P>
 * マクドナルド店舗マスタ履歴テーブルを保持する
 * </P>
 * <P>
 * <B>修正履歴</B><BR>
 * ・新規作成(2013/02/01 JSE H.Okazaki)<BR>
 * </P>
 *
 * @author
 */
@XmlRootElement(namespace = "http://master.model.mac.customer.kkh.isid.co.jp/")
@XmlType(namespace = "http://master.model.mac.customer.kkh.isid.co.jp/")
public class FindMasterMacTnpRByCondResult extends AbstractServiceResult {

    /** マクドナルド店舗マスタ履歴テーブル(THB17RMTNP)VOリスト */
    private List<FindMasterMacTnpRByCondVO> _thb17RmtnpList;


    /**
     * マクドナルド店舗マスタ履歴テーブル(THB17RMTNP)VOリストを設定します。
     * @param thb17RmtnpList
     */
    public List<FindMasterMacTnpRByCondVO> get_thb17RmtnpList() {
        return _thb17RmtnpList;
    }

    /**
     * マクドナルド店舗マスタ履歴テーブル(THB17RMTNP)VOリストを設定します。
     * @param thb17RmtnpList
     */
    public void set_thb17RmtnpList(List<FindMasterMacTnpRByCondVO> thb17RmtnpList) {
        _thb17RmtnpList = thb17RmtnpList;
    }
    /** ListだけではWebサービスに公開されないのでダミープロパティを追加 */
    private String _dummy;

    /**
     * ListだけではWebサービスに公開されないのでダミープロパティを追加を取得します。
     * @return String ダミープロパティ
     */
    public String getDummy() {
        return _dummy;
    }

    /**
     * ListだけではWebサービスに公開されないのでダミープロパティを追加を設定します。
     * @param dummy ダミープロパティ
     */
    public void setDummy(String dummy) {
        this._dummy = dummy;
    }

}
