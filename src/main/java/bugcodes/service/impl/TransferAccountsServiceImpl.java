package bugcodes.service.impl;

import bugcodes.exception.BusinessException;
import bugcodes.service.BalanceService;
import bugcodes.service.TransferAccountsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author bugcoder
 * @date 18/11/8
 */
@Service
public class TransferAccountsServiceImpl implements TransferAccountsService{

    private static final Logger LOGGER = LoggerFactory.getLogger(TransferAccountsServiceImpl.class);

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void transfer(String oName, String dName) {
        if (true){
            throw new BusinessException("000002","throw exception");
        }
        balanceService.withdrawal(oName,new BigDecimal(10000));
        balanceService.deposit(dName,new BigDecimal(10000));
    }
}
