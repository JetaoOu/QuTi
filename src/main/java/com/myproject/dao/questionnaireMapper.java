package com.myproject.dao;

import com.myproject.pojo.questionnaire;
import com.myproject.pojo.questionnaireExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface questionnaireMapper {
    long countByExample(questionnaireExample example);

    int deleteByExample(questionnaireExample example);

    int deleteByPrimaryKey(String questionnaireid);

    int insert(questionnaire record);

    int insertSelective(questionnaire record);

    List<questionnaire> selectByExample(questionnaireExample example);

    questionnaire selectByPrimaryKey(String questionnaireid);

    int updateByExampleSelective(@Param("record") questionnaire record, @Param("example") questionnaireExample example);

    int updateByExample(@Param("record") questionnaire record, @Param("example") questionnaireExample example);

    int updateByPrimaryKeySelective(questionnaire record);

    int updateByPrimaryKey(questionnaire record);
}