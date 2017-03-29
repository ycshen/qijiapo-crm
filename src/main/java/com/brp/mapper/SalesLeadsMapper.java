package com.brp.mapper;

import com.brp.entity.SalesLeadsEntity;
import com.brp.util.query.SalesLeadsQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fengyue on 2017/3/28.
 */
public interface SalesLeadsMapper {

    void insertSalesLeads(SalesLeadsEntity salesLeads);
    List<SalesLeadsEntity> getSalesLeadsPage(SalesLeadsQuery salesLeadsQuery);
    SalesLeadsEntity getSalesLeadsById(String id);
    void deleteSalesLeadsById(String id);
    void batchDeleteSalesLeads(@Param("inId")String inId);
    void updateSalesLeads(SalesLeadsEntity salesLeads);
}
