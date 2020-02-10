package com.myproject.dao;

import com.myproject.pojo.rounterchart;
import com.myproject.pojo.rounterchartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface rounterchartMapper {
    long countByExample(rounterchartExample example);

    int deleteByExample(rounterchartExample example);

    int deleteByPrimaryKey(String rounterchartid);

    int insert(rounterchart record);

    int insertSelective(rounterchart record);

    List<rounterchart> selectByExample(rounterchartExample example);

    rounterchart selectByPrimaryKey(String rounterchartid);

    int updateByExampleSelective(@Param("record") rounterchart record, @Param("example") rounterchartExample example);

    int updateByExample(@Param("record") rounterchart record, @Param("example") rounterchartExample example);

    int updateByPrimaryKeySelective(rounterchart record);

    int updateByPrimaryKey(rounterchart record);
}