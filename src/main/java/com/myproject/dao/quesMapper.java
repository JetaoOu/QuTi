package com.myproject.dao;

import com.myproject.pojo.ques;
import com.myproject.pojo.quesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface quesMapper {
    long countByExample(quesExample example);

    int deleteByExample(quesExample example);

    int deleteByPrimaryKey(String quesid);

    int insert(ques record);

    int insertSelective(ques record);

    List<ques> selectByExample(quesExample example);

    ques selectByPrimaryKey(String quesid);

    int updateByExampleSelective(@Param("record") ques record, @Param("example") quesExample example);

    int updateByExample(@Param("record") ques record, @Param("example") quesExample example);

    int updateByPrimaryKeySelective(ques record);

    int updateByPrimaryKey(ques record);
}