package com.myproject.service;
import java.util.List;

import com.myproject.entiy.PageResult;
import com.myproject.pojo.rounterchart;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface RounterchartService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<rounterchart> findAll(String rounterChart);
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(rounterchart rounterchart);
	
	
	/**
	 * 修改
	 */
	public void update(rounterchart rounterchart);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public rounterchart findOne(String id);
	
	
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
	public PageResult findPage(rounterchart rounterchart, int pageNum,int pageSize);
	
}
