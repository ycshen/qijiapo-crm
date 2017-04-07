package com.brp.service.impl;

import com.brp.entity.ReturnMoneyDetailEntity;
import com.brp.service.ReturnMoneyDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengyue on 2017/4/7.
 */
@Service
public class ReturnMoneyDetailServiceImpl implements ReturnMoneyDetailService {
    @Override
    public void insertReturnMoneyDetail(ReturnMoneyDetailEntity returnMoneyDetailEntity) {

    }

    @Override
    public List<ReturnMoneyDetailEntity> getRMDByReturnMoneyId(String returnMoneyId) {
        return null;
    }

    @Override
    public void batchInsertReturnMoneyDetail(List<ReturnMoneyDetailEntity> list) {

    }
}
