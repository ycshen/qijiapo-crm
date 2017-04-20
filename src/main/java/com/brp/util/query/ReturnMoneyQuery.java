package com.brp.util.query;

import com.brp.entity.ReturnMoneyEntity;
import com.brp.model.pageutil.Page;

/**
 * Created by fengyue on 2017/4/5.
 */
public class ReturnMoneyQuery extends Page<ReturnMoneyEntity>{

    private String contractId;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }
}
