package com.brp.util.query;

import com.brp.entity.ReturnMoneyDetailEntity;
import com.brp.model.pageutil.Page;

/**
 * Created by fengyue on 2017/4/19.
 */
public class ReturnMoneyDetailQuery extends Page<ReturnMoneyDetailEntity> {

    private String returnMoneyId;

    public String getReturnMoneyId() {
        return returnMoneyId;
    }

    public void setReturnMoneyId(String returnMoneyId) {
        this.returnMoneyId = returnMoneyId;
    }
}
