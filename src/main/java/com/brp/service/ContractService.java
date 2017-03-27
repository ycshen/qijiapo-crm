package com.brp.service;

import com.brp.entity.ContractEntity;
import com.brp.util.query.ContractQuery;

import java.util.List;

/**
 * Created by fengyue on 2017/3/27.
 */
public interface ContractService {

    void insertContract(ContractEntity contract);
    void updateContract(ContractEntity contract);
    ContractQuery getContractPage(ContractQuery contractQuery);
    ContractEntity getContractById(String id);
    void deleteContractById(String id);
    void batchDeleteContract(List<String> idList);
}
