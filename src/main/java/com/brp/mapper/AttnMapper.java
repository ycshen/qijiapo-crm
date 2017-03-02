package com.brp.mapper;

import com.brp.entity.AttnEntity;
import com.brp.util.query.AttnQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengyue on 2017/3/2.
 */
@Repository
public interface AttnMapper {

    void insertAttn(AttnEntity Attn);
    List<AttnEntity> getAttnPage(AttnQuery AttnQuery);
    AttnEntity getAttnById(String id);
    void deleteAttnById(String id);
    void batchDeleteAttn(@Param("inId")String inId);
    void updateAttn(AttnEntity Attn);
}
