package com.brp.mapper;

import com.brp.entity.ContractEntity;
import com.brp.util.query.ContractQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fengyue on 2017/3/27.
 */
public interface ContractMapper {
    void insertContract(ContractEntity contract);
    List<ContractEntity> getContractPage(ContractQuery contractQuery);
    ContractEntity getContractById(String id);
    void deleteContractById(String id);
    void batchDeleteContract(@Param("inId")String inId);
    void updateContract(ContractEntity contract);
}
