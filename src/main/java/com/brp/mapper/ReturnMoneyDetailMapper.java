package com.brp.mapper;

import com.brp.entity.ReturnMoneyDetailEntity;
import com.brp.util.query.ReturnMoneyDetailQuery;

import java.util.List;

/**
 * Created by fengyue on 2017/4/7.
 */
public interface ReturnMoneyDetailMapper {

    void insertReturnMoneyDetail(ReturnMoneyDetailEntity returnMoneyDetailEntity);

    List<ReturnMoneyDetailEntity> getRMDByReturnMoneyId(ReturnMoneyDetailQuery returnMoneyDetailQuery);

    ReturnMoneyDetailEntity getReturnMoneyDetailById(String id);

    void batchInsertReturnMoneyDetail(List<ReturnMoneyDetailEntity> list);

    void updateReturnMoneyDetail(ReturnMoneyDetailEntity returnMoneyDetailEntity);

    void deleteReturnMoneyDetailById(String id);
}
