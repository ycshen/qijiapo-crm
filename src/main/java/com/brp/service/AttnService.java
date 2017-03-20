package com.brp.service;

import com.brp.entity.AttnEntity;
import com.brp.util.query.AttnQuery;

import java.util.List;

/**
 * Created by fengyue on 2017/3/2.
 */
public interface AttnService {
    void insertAttn(AttnEntity attn);
    void updateAttn(AttnEntity attn);
    AttnQuery getAttnPage(AttnQuery attnQuery);
    AttnEntity getAttnById(String id);
    void deleteAttnById(String id);
    void batchDeleteAttn(List<String> idList);
}
