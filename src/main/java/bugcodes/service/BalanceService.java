package bugcodes.service;

import java.math.BigDecimal;

/**
 * 余额变动服务
 * @author bugcoder
 * @date 18/11/9
 */
public interface BalanceService {

    /**
     * 取款操作
     * @param name 用户
     * @param usd 钱
     */
    void withdrawal(String name, BigDecimal usd);

    /**
     * 存款操作
     * @param name 用户
     * @param usd 钱
     */
    void deposit(String name, BigDecimal usd);

    /**
     * 检查余额
     * @param oUsd 现有的钱
     * @param dUsd 要取得钱
     * @return
     */
    boolean check(BigDecimal oUsd,BigDecimal dUsd);
}
