package com.brp.service;

import com.brp.entity.ReturnMoneyEntity;
import com.brp.util.query.ReturnMoneyQuery;

import java.util.List;

/**
 * Created by fengyue on 2017/4/5.
 */
public interface ReturnMoneyService {
    void insertReturnMoney(ReturnMoneyEntity returnMoney);
    ReturnMoneyQuery getReturnMoneyByContractId(ReturnMoneyQuery returnMoneyQuery);
    void updateReturnMoney(ReturnMoneyEntity returnMoney);
//    ReturnMoneyQuery getReturnMoneyPage(ReturnMoneyQuery returnMoneyQuery);
    ReturnMoneyEntity getReturnMoneyById(String id);
    void deleteReturnMoneyById(String id);
}
