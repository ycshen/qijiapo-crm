package com.brp.service.impl;

import com.brp.entity.ProductEntity;
import com.brp.entity.ReturnMoneyEntity;
import com.brp.mapper.ReturnMoneyMapper;
import com.brp.service.ReturnMoneyService;
import com.brp.util.query.ReturnMoneyQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengyue on 2017/4/5.
 */
@Service
public class ReturnMoneyServiceImpl implements ReturnMoneyService {
    @Autowired
    private ReturnMoneyMapper returnMoneyMapper;

    @Override
    public void insertReturnMoney(ReturnMoneyEntity returnMoney) {
        returnMoneyMapper.insertReturnMoney(returnMoney);
    }

    @Override
    public ReturnMoneyQuery getReturnMoneyByContractId(ReturnMoneyQuery returnMoneyQuery) {
        List<ReturnMoneyEntity> list = returnMoneyMapper.getReturnMoneyListByContractId(returnMoneyQuery);
        if(list != null && list.size() > 0){
            returnMoneyQuery.setItems(list);
        }
        return returnMoneyQuery;
    }

    @Override
    public void updateReturnMoney(ReturnMoneyEntity returnMoney) {

    }

    @Override
    public ReturnMoneyEntity getReturnMoneyById(String id) {
        return returnMoneyMapper.getReturnMoneyById(id);
    }

    @Override
    public void deleteReturnMoneyById(String id) {

    }
}
