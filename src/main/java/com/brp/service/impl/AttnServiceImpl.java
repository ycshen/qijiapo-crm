package com.brp.service.impl;

import com.brp.entity.AttnEntity;
import com.brp.mapper.AttnMapper;
import com.brp.service.AttnService;
import com.brp.util.query.AttnQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengyue on 2017/3/2.
 */
@Service
public class AttnServiceImpl implements AttnService {
    @Autowired
    private AttnMapper attnMapper;

    @Override
    public void insertAttn(AttnEntity attn) {
        attnMapper.insertAttn(attn);
    }

    @Override
    public void updateAttn(AttnEntity attn) {
        attnMapper.updateAttn(attn);
    }

    @Override
    public AttnQuery getAttnPage(AttnQuery attnQuery) {
        List<AttnEntity> attnQueries = attnMapper.getAttnPage(attnQuery);
        if (attnQueries != null && attnQueries.size() > 0){
            attnQuery.setItems(attnQueries);
        }
        return attnQuery;
    }

    @Override
    public AttnEntity getAttnById(String id) {
        return attnMapper.getAttnById(id);
    }

    @Override
    public void deleteAttnById(String id) {
        attnMapper.deleteAttnById(id);
    }

    @Override
    public void batchDeleteAttn(List<String> idList) {
        if(idList != null && idList.size() > 0){
            String inId = "";
            for (String id : idList) {
                inId += id + ",";
            }

            if(StringUtils.isNotBlank(inId)){
                inId = inId.substring(0, inId.length() - 1);
                attnMapper.batchDeleteAttn(inId);
            }
        }
    }
}
