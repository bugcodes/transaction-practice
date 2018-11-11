package bugcodes.service.impl;

import bugcodes.constant.TransferStatus;
import bugcodes.exception.BusinessException;
import bugcodes.repository.dao.UserJpaRepository;
import bugcodes.repository.entity.TransactionUserEntity;
import bugcodes.service.BalanceService;
import bugcodes.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author bugcoder
 * @date 18/11/9
 */
@Service
public class BalanceServiceImpl implements BalanceService{

    private static final Logger LOGGER = LoggerFactory.getLogger(BalanceServiceImpl.class);

    @Autowired
    private UserJpaRepository jpaRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void withdrawal(String name, BigDecimal usd) {
        LOGGER.info("{} 账号开始扣钱 {}",name,usd);
        TransactionUserEntity entity = get(name);
        if (null == entity){
            throw new BusinessException("000101",name+"用户信息不存在");
        }
        if (check(entity.getBalance(),usd)){
            entity.setBalance(entity.getBalance().subtract(usd));
            entity.setUpdateTime(DateUtil.getSysDate());
            entity.setStatus((byte)0);
            jpaRepository.saveAndFlush(entity);
        }else {
            throw new BusinessException("000102",name+"你的余额离财务自由越来越远了");
        }
        LOGGER.info("{} 账号扣钱成功 {}",name,usd);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void deposit(String name, BigDecimal usd) {
        LOGGER.info("{} 账号开始加钱 {}",name,usd);
        TransactionUserEntity entity = get(name);
        if (null == entity){
            throw new BusinessException("000101",name+"用户信息不存在");
        }
        entity.setBalance(entity.getBalance().add(usd));
        entity.setUpdateTime(DateUtil.getSysDate());
        entity.setStatus(TransferStatus.DEPOSIT.getValue());
        jpaRepository.saveAndFlush(entity);
        LOGGER.info("{} 账号加钱成功 {}",name,usd);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY,rollbackFor = Exception.class)
    public boolean check(BigDecimal oUsd, BigDecimal dUsd) {
        return oUsd.compareTo(dUsd) > -1;
    }

    private TransactionUserEntity get(String name){
        return jpaRepository.findFirstByName(name);
    }

}
