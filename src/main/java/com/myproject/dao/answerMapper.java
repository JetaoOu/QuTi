package com.myproject.dao;

import com.myproject.pojo.answer;
import com.myproject.pojo.answerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface answerMapper {
    long countByExample(answerExample example);

    int deleteByExample(answerExample example);

    int deleteByPrimaryKey(String answerid);

    int insert(answer record);

    int insertSelective(answer record);

    List<answer> selectByExample(answerExample example);

    answer selectByPrimaryKey(String answerid);

    int updateByExampleSelective(@Param("record") answer record, @Param("example") answerExample example);

    int updateByExample(@Param("record") answer record, @Param("example") answerExample example);

    int updateByPrimaryKeySelective(answer record);

    int updateByPrimaryKey(answer record);
}