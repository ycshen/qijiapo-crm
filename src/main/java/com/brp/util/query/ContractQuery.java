package com.brp.util.query;

import com.brp.entity.ContractEntity;
import com.brp.model.pageutil.Page;

/**
 * Created by fengyue on 2017/3/27.
 */
public class ContractQuery extends Page<ContractEntity> {
    private Long id;
    private String contractName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }
}
