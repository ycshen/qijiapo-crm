package com.brp.service;

import com.brp.entity.ReturnMoneyDetailEntity;
import com.brp.util.query.ReturnMoneyDetailQuery;

import java.util.List;

/**
 * Created by fengyue on 2017/4/7.
 */
public interface ReturnMoneyDetailService {

    void insertReturnMoneyDetail(ReturnMoneyDetailEntity returnMoneyDetailEntity);
    void batchInsertReturnMoneyDetail(List<ReturnMoneyDetailEntity> list);
    ReturnMoneyDetailEntity getReturnMoneyDetailById(String id);
    ReturnMoneyDetailQuery getRMDByReturnMoneyId(ReturnMoneyDetailQuery returnMoneyDetailQuery);
    void updateReturnMoneyDetail(ReturnMoneyDetailEntity returnMoney);
    void deleteReturnMoneyDetailById(String id);
}
