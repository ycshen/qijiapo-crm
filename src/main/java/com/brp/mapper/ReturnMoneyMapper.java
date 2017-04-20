package com.brp.mapper;

import com.brp.entity.ReturnMoneyDetailEntity;
import com.brp.entity.ReturnMoneyEntity;
import com.brp.util.query.ReturnMoneyQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengyue on 2017/4/5.
 */
@Repository
public interface ReturnMoneyMapper {

    void insertReturnMoney(ReturnMoneyEntity returnMoneyEntity);
    ReturnMoneyEntity getReturnMoneyById(String id);
    List<ReturnMoneyEntity> getReturnMoneyListByContractId(ReturnMoneyQuery returnMoneyQuery);

}
