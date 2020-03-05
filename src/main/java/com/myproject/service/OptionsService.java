package com.myproject.service;
import java.util.List;

import com.myproject.entiy.PageResult;
import com.myproject.pojo.options;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface OptionsService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<options> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(options options);
	
	
	/**
	 * 修改
	 */
	public void update(options options);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public options findOne(String id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(String [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(options options, int pageNum,int pageSize);


	public List<options> findOption(String questionid);
	
}
