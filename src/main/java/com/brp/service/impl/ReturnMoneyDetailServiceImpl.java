package com.brp.service.impl;

import com.brp.entity.ReturnMoneyDetailEntity;
import com.brp.mapper.ReturnMoneyDetailMapper;
import com.brp.service.ReturnMoneyDetailService;
import com.brp.util.query.ReturnMoneyDetailQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengyue on 2017/4/7.
 */
@Service
public class ReturnMoneyDetailServiceImpl implements ReturnMoneyDetailService {
    @Autowired
    private ReturnMoneyDetailMapper returnMoneyDetailMapper;
    @Override
    public void insertReturnMoneyDetail(ReturnMoneyDetailEntity returnMoneyDetailEntity) {
        returnMoneyDetailMapper.insertReturnMoneyDetail(returnMoneyDetailEntity);
    }

    @Override
    public ReturnMoneyDetailQuery getRMDByReturnMoneyId(ReturnMoneyDetailQuery returnMoneyDetailQuery) {
        List<ReturnMoneyDetailEntity> list = returnMoneyDetailMapper.getRMDByReturnMoneyId(returnMoneyDetailQuery);
        if(list != null && list.size() > 0){
            returnMoneyDetailQuery.setItems(list);
        }
        return returnMoneyDetailQuery;
    }

    @Override
    public void updateReturnMoneyDetail(ReturnMoneyDetailEntity returnMoney) {
        returnMoneyDetailMapper.updateReturnMoneyDetail(returnMoney);
    }

    @Override
    public void deleteReturnMoneyDetailById(String id) {
        returnMoneyDetailMapper.deleteReturnMoneyDetailById(id);
    }

    @Override
    public void batchInsertReturnMoneyDetail(List<ReturnMoneyDetailEntity> list) {
        returnMoneyDetailMapper.batchInsertReturnMoneyDetail(list);
    }

    @Override
    public ReturnMoneyDetailEntity getReturnMoneyDetailById(String id) {
        return returnMoneyDetailMapper.getReturnMoneyDetailById(id);
    }
}
