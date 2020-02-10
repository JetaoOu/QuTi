package com.myproject.dao;

import com.myproject.pojo.question;
import com.myproject.pojo.questionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface questionMapper {
    long countByExample(questionExample example);

    int deleteByExample(questionExample example);

    int deleteByPrimaryKey(String questionid);

    int insert(question record);

    int insertSelective(question record);

    List<question> selectByExample(questionExample example);

    question selectByPrimaryKey(String questionid);

    int updateByExampleSelective(@Param("record") question record, @Param("example") questionExample example);

    int updateByExample(@Param("record") question record, @Param("example") questionExample example);

    int updateByPrimaryKeySelective(question record);

    int updateByPrimaryKey(question record);
}