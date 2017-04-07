package com.brp.service;

import com.brp.entity.ReturnMoneyDetailEntity;

import java.util.List;

/**
 * Created by fengyue on 2017/4/7.
 */
public interface ReturnMoneyDetailService {

    void insertReturnMoneyDetail(ReturnMoneyDetailEntity returnMoneyDetailEntity);
    void batchInsertReturnMoneyDetail(List<ReturnMoneyDetailEntity> list);
    List<ReturnMoneyDetailEntity> getRMDByReturnMoneyId(String returnMoneyId);
}
