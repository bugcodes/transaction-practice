package bugcodes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author bugcoder
 * @date 18/11/8
 */
@SpringBootApplication
@EnableTransactionManagement
public class TransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class,args);
    }
}
