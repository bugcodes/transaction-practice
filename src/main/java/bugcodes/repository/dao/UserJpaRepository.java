package bugcodes.repository.dao;

import bugcodes.repository.entity.TransactionUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bugcoder
 * @date 18/11/8
 */
public interface UserJpaRepository extends JpaRepository<TransactionUserEntity,Integer>{

    /**
     * 获取用户信息
     * @param name 用户名称
     * @return
     */
    TransactionUserEntity findFirstByName(String name);
}
