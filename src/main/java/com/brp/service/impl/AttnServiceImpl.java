package com.brp.service.impl;

import com.brp.entity.AttnEntity;
import com.brp.service.AttnService;
import com.brp.util.query.AttnQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengyue on 2017/3/2.
 */
@Service
public class AttnServiceImpl implements AttnService {
    @Override
    public void insertAttn(AttnEntity Attn) {

    }

    @Override
    public void updateAttn(AttnEntity Attn) {

    }

    @Override
    public AttnQuery getAttnPage(AttnQuery AttnQuery) {
        return null;
    }

    @Override
    public AttnEntity getAttnById(String id) {
        return null;
    }

    @Override
    public void deleteAttnById(String id) {

    }

    @Override
    public void batchDeleteAttn(List<String> idList) {

    }
}
