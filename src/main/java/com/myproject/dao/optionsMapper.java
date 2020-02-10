package com.myproject.dao;

import com.myproject.pojo.options;
import com.myproject.pojo.optionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface optionsMapper {
    long countByExample(optionsExample example);

    int deleteByExample(optionsExample example);

    int deleteByPrimaryKey(String optionsid);

    int insert(options record);

    int insertSelective(options record);

    List<options> selectByExample(optionsExample example);

    options selectByPrimaryKey(String optionsid);

    int updateByExampleSelective(@Param("record") options record, @Param("example") optionsExample example);

    int updateByExample(@Param("record") options record, @Param("example") optionsExample example);

    int updateByPrimaryKeySelective(options record);

    int updateByPrimaryKey(options record);
}