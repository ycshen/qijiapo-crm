package com.brp.mapper;

import com.brp.entity.ReturnMoneyDetailEntity;
import com.brp.entity.ReturnMoneyEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengyue on 2017/4/5.
 */
@Repository
public interface ReturnMoneyMapper {

    void insertReturnMoney(ReturnMoneyEntity returnMoneyEntity);
    ReturnMoneyEntity getReturnMoneyById(String id);
    List<ReturnMoneyEntity> getReturnMoneyListByReturnMoneyId(String contractId);
}
