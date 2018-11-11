package bugcodes.service;

/**
 * 转账服务
 * @author bugcoder
 * @date 18/11/8
 */
public interface TransferAccountsService {

    /**
     * 转账服务
     * @param oName 从该用户扣钱
     * @param dName 向该用户加钱
     */
    void transfer(String oName, String dName);
}
