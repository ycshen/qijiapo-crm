package com.brp.service.impl;

import com.brp.entity.SalesLeadsEntity;
import com.brp.mapper.SalesLeadsMapper;
import com.brp.service.SalesLeadsService;
import com.brp.util.query.SalesLeadsQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengyue on 2017/3/28.
 */
@Service
public class SalesLeadsServiceImpl implements SalesLeadsService {
    @Autowired
    private SalesLeadsMapper salesLeadsMapper;

    @Override
    public void insertSalesLeads(SalesLeadsEntity salesLeads) {
        salesLeadsMapper.insertSalesLeads(salesLeads);
    }

    @Override
    public SalesLeadsQuery getSalesLeadsPage(SalesLeadsQuery salesLeadsQuery) {
        List<SalesLeadsEntity> list = salesLeadsMapper.getSalesLeadsPage(salesLeadsQuery);
        if(list != null && list.size() > 0){
            salesLeadsQuery.setItems(list);
        }


        return salesLeadsQuery;
    }

    @Override
    public SalesLeadsEntity getSalesLeadsById(String id) {
        return salesLeadsMapper.getSalesLeadsById(id);
    }

    @Override
    public void deleteSalesLeadsById(String id) {
        salesLeadsMapper.deleteSalesLeadsById(id);
    }

    @Override
    public void batchDeleteSalesLeads(List<String> idList) {
        if(idList != null && idList.size() > 0){
            String inId = "";
            for (String id : idList) {
                inId += id + ",";
            }

            if(StringUtils.isNotBlank(inId)){
                inId = inId.substring(0, inId.length() - 1);
                salesLeadsMapper.batchDeleteSalesLeads(inId);
            }
        }
    }

    @Override
    public void updateSalesLeads(SalesLeadsEntity salesLeads) {
        salesLeadsMapper.updateSalesLeads(salesLeads);
    }
}
