package com.brp.util.query;

import com.brp.entity.SalesLeadsEntity;
import com.brp.model.pageutil.Page;

/**
 * Created by fengyue on 2017/3/28.
 */
public class SalesLeadsQuery extends Page<SalesLeadsEntity>{

    private Long id;

    private String customerName;//姓名

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
