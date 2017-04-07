package com.brp.service.impl;

import com.brp.entity.ContractEntity;
import com.brp.entity.ContractEntity;
import com.brp.mapper.ContractMapper;
import com.brp.service.ContractService;
import com.brp.util.query.ContractQuery;
import com.brp.util.query.ContractQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengyue on 2017/3/27.
 */
@Service
public class ContractServiceImpl implements ContractService{

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public void insertContract(ContractEntity contract) {
        contractMapper.insertContract(contract);
    }

    @Override
    public ContractQuery getContractPage(ContractQuery contractQuery) {
        List<ContractEntity> list = contractMapper.getContractPage(contractQuery);
        if(list != null && list.size() > 0){
            contractQuery.setItems(list);
        }


        return contractQuery;
    }

    @Override
    public ContractEntity getContractById(String id) {
        return contractMapper.getContractById(id);
    }

    @Override
    public void deleteContractById(String id) {
        contractMapper.deleteContractById(id);
    }

    @Override
    public void batchDeleteContract(List<String> idList) {
        if(idList != null && idList.size() > 0){
            String inId = "";
            for (String id : idList) {
                inId += id + ",";
            }

            if(StringUtils.isNotBlank(inId)){
                inId = inId.substring(0, inId.length() - 1);
                contractMapper.batchDeleteContract(inId);
            }
        }
    }

    @Override
    public void updateSaleMoneyById(String id, String returnMoney) {
        contractMapper.updateSaleMoneyById(id,returnMoney);
    }

    @Override
    public void updateContract(ContractEntity contract) {
        contractMapper.updateContract(contract);
    }
}
