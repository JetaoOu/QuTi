package com.myproject.controller;
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
import com.myproject.entiy.quData;
import com.myproject.pojo.ques;
import com.myproject.pojo.question;
import com.myproject.pojo.questionnaire;
import com.myproject.pojo.user;
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
	public quData get(String id){
		System.out.println(id);

		questionnaire questionnaire = questionnaireService.findOne(id);	
		List<question> questions = questionService.findQuestions(id);
		for(question item : questions) {
			if(item.getType().equals("score")) {
				item.setQuess(quesService.findQuess(item.getQuestionid()));
			}
		}
		
		quData quData = new quData();
		quData.setQuestionnaireid(questionnaire.getQuestionnaireid());
		quData.setQuestionnairenumber(questionnaire.getQuestionnairenumber());
		quData.setTitle(questionnaire.getTitle());
		quData.setImage(questionnaire.getImage());
		quData.setAuthor(questionnaire.getAuthor());
		quData.setClick(questionnaire.getClick());
		quData.setDigest(questionnaire.getDigest());
		quData.setCutofftime(questionnaire.getCutofftime());
		quData.setStatus(questionnaire.getStatus());
		quData.setSavetime(questionnaire.getSavetime());
		quData.setChangetime(questionnaire.getChangetime());
		quData.setQuestions(questions);

		return quData;
	}
	
	/**
	 * 保存
	 * @param questionnaire
	 * @return
	 */
	@RequestMapping("/save")
	public Result save(@RequestBody quData quData){
		try {
			questionnaire questionnaire = quData;
			questionnaire.setQuestionnaireid(CreatUUID.uuid());
			questionnaireService.add(questionnaire);
			
			for(question item : quData.getQuestions()) {
				item.setQuestionid(CreatUUID.uuid());
				item.setNaireid(questionnaire.getQuestionnaireid());
				questionService.add(item);
				if(item.getQuess() != null) {
					for(ques ques : item.getQuess()) {
						ques.setQuesid(CreatUUID.uuid());
						ques.setNaireid(questionnaire.getQuestionnaireid());
						ques.setQuestionid(item.getQuestionid());
						quesService.add(ques);
					}
				}
			}
			System.out.print(quData.getTitle());
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
