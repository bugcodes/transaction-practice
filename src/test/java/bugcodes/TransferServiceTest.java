package bugcodes;

import bugcodes.repository.dao.UserJpaRepository;
import bugcodes.repository.entity.TransactionUserEntity;
import bugcodes.service.TransferAccountsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @author bugcoder
 * @date 18/11/9
 */
public class TransferServiceTest extends AbstractTest{

    @Autowired
    TransferAccountsService accountsService;

    @Autowired
    UserJpaRepository userJpaRepository;

    @Test
    public void init(){
        TransactionUserEntity entity = new TransactionUserEntity();
        entity.setName("peppa");
        entity.setAccount(00010001000101);
        entity.setBalance(new BigDecimal(100000));
        TransactionUserEntity entity1 = new TransactionUserEntity();
        entity1.setName("george");
        entity1.setAccount(00010001000102);
        entity1.setBalance(new BigDecimal(10000));
        userJpaRepository.saveAndFlush(entity);
        userJpaRepository.saveAndFlush(entity1);
    }

    @Test
    public void testRequired(){
        accountsService.transfer("peppa","george");
    }
}
