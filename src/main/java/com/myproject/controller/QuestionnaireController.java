package com.myproject.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.firewall.FirewalledRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.entiy.PageResult;
import com.myproject.entiy.QuestionnaireNum;
import com.myproject.entiy.Result;
import com.myproject.pojo.options;
import com.myproject.pojo.ques;
import com.myproject.pojo.question;
import com.myproject.pojo.questionnaire;
import com.myproject.pojo.user;
import com.myproject.service.OptionsService;
import com.myproject.service.QuesService;
import com.myproject.service.QuestionService;
import com.myproject.service.QuestionnaireService;
import com.myproject.utils.CreatUUID;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

	@Autowired
	private QuestionnaireService questionnaireService;
	

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuesService quesService;
	
	@Autowired
	private OptionsService optionsService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<questionnaire> findAll(){			
		return questionnaireService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return questionnaireService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param questionnaire
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody questionnaire questionnaire){
		try {
			questionnaire.setQuestionnaireid(CreatUUID.uuid());
			questionnaireService.add(questionnaire);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 获取
	 * @param questionnaire
	 * @return
	 */
	@RequestMapping("/get")
	public questionnaire get(String id){
		questionnaire questionnaire = questionnaireService.findOne(id);	
		List<question> questions = questionService.findQuestions(id);
		for(question item : questions) {
			if(item.getType().equals("score")) {
				item.setQuess(quesService.findQuess(item.getQuestionid()));
			}
		}	
		questionnaire.setQuestions(questions);
	
		return questionnaire;
	}
	
	
	/**
	 * 获取
	 * @param questionnaire
	 * @return
	 */
	@RequestMapping("/getDetail")
	public questionnaire getDetail(String id){
		questionnaire questionnaire = questionnaireService.findOne(id);	
		List<question> questions = questionService.findQuestions(id);
		
		for(question item : questions) {
			if(item.getType().equals("score")) {
				List<ques> quess = quesService.findQuess(item.getQuestionid());
				for(ques element : quess) {
					element.setOptions(optionsService.findOption(element.getQuesid()));
				}
				item.setQuess(quess);
			}else {
				item.setOptions(optionsService.findOption(item.getQuestionid()));
			}
		}
		questionnaire.setQuestions(questions);
		
		return questionnaire;
	}
	
	/**
	 * 保存
	 * @param questionnaire
	 * @return
	 */
	@RequestMapping("/save")
	public Result save(@RequestBody questionnaire quData){
		try {
			quData.setQuestionnaireid(CreatUUID.uuid());
			questionnaireService.add(quData);
			
			for(question item : quData.getQuestions()) {
				item.setQuestionid(CreatUUID.uuid());
				item.setNaireid(quData.getQuestionnaireid());
				questionService.add(item);
				if(item.getQuess() != null) {
					for(ques ques : item.getQuess()) {
						ques.setQuesid(CreatUUID.uuid());
						ques.setNaireid(quData.getQuestionnaireid());
						ques.setQuestionid(item.getQuestionid());
						quesService.add(ques);
					}
				}
			}
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param questionnaire
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody questionnaire questionnaire){
		try {
			questionnaireService.update(questionnaire);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public questionnaire findOne(String id){
		System.out.print(id);
		return questionnaireService.findOne(id);		
	}
	

	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(String [] ids){
		try {
			questionnaireService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(String filtersStatus,String filtersQuestionnairenumber, String filtersTitle, int page, int rows  ){
		questionnaire questionnaire = new questionnaire();
		questionnaire.setTitle(filtersTitle);
		questionnaire.setStatus(filtersStatus);
		questionnaire.setQuestionnairenumber(filtersQuestionnairenumber);
		return questionnaireService.findPage(questionnaire, page, rows);		
	}
	
	
	@RequestMapping("/status")
	public void status(@RequestBody questionnaire questionnaire){
		 questionnaireService.changeStatus(questionnaire);		
	}
	
	@RequestMapping("/findAllNum")
	public List<questionnaire> findAllNum(String filtersStatus){
		return questionnaireService.findAllNum(filtersStatus);		
	}
	
}
