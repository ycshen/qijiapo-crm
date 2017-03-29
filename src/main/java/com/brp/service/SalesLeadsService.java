package com.brp.service;

import com.brp.entity.SalesLeadsEntity;
import com.brp.util.query.SalesLeadsQuery;

import java.util.List;

/**
 * Created by fengyue on 2017/3/28.
 */
public interface SalesLeadsService {

    void insertSalesLeads(SalesLeadsEntity salesLeads);
    void updateSalesLeads(SalesLeadsEntity salesLeads);
    SalesLeadsQuery getSalesLeadsPage(SalesLeadsQuery salesLeadsQuery);
    SalesLeadsEntity getSalesLeadsById(String id);
    void deleteSalesLeadsById(String id);
    void batchDeleteSalesLeads(List<String> idList);
}
