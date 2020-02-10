package com.myproject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myproject.entiy.PageResult;
import com.myproject.entiy.Result;
import com.myproject.pojo.answer;
import com.myproject.pojo.user;
import com.myproject.service.AnswerService;
import com.myproject.utils.CreatUUID;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<answer> findAll(){			
		return answerService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return answerService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param answer
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody answer answer){
		try {
			answerService.add(answer);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	
	@RequestMapping("/addList")
	public Result addList(@RequestBody String answers){
		try {
			answer answer =new answer();
			JSONObject root = JSONObject.parseObject(answers);
			for(Object ans : root.getJSONArray("answers")) {
				JSONObject obj = (JSONObject) ans;
				answer = JSONObject.toJavaObject(obj, answer.getClass());
				answer.setAnswerid(CreatUUID.uuid());
				answerService.add(answer);
			}
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	
	
	/**
	 * 修改
	 * @param answer
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody answer answer){
		try {
			answerService.update(answer);
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
	public answer findOne(String id){
		return answerService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(String [] ids){
		try {
			answerService.delete(ids);
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
	public PageResult search(@RequestBody answer answer, int page, int rows  ){
		return answerService.findPage(answer, page, rows);		
	}
	
	
	@RequestMapping("/findByNum")
	public List<user> findByNum(String num){
		return answerService.findByNum(num);		
	}
	
	@RequestMapping("/findByOptionsID")
	public List<Long> findByOptionsID(String[] optionsidList){
		return answerService.findByOptionsID(optionsidList);		
	}
	
}
