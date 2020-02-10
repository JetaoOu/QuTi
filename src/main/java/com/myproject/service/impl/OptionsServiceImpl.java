package com.myproject.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myproject.dao.optionsMapper;
import com.myproject.entiy.PageResult;
import com.myproject.pojo.options;
import com.myproject.pojo.optionsExample;
import com.myproject.pojo.optionsExample.Criteria;
import com.myproject.service.OptionsService;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class OptionsServiceImpl implements OptionsService {

	@Autowired
	private optionsMapper optionsMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<options> findAll() {
		return optionsMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<options> page=   (Page<options>) optionsMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(options options) {
		optionsMapper.insert(options);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(options options){
		optionsMapper.updateByPrimaryKey(options);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public options findOne(String id){
		return optionsMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(String[] ids) {
		for(String id:ids){
			optionsMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(options options, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		optionsExample example=new optionsExample();
		Criteria criteria = example.createCriteria();
		
		if(options!=null){			
			if(options.getOptionsid()!=null && options.getOptionsid().length()>0){
				criteria.andOptionsidLike("%"+options.getOptionsid()+"%");
			}
			if(options.getOptionscontent()!=null && options.getOptionscontent().length()>0){
				criteria.andOptionscontentLike("%"+options.getOptionscontent()+"%");
			}
//			if(options.getQuestionnumber()!=null && options.getQuestionnumber().length()>0){
//				criteria.andQuestionnumberLike("%"+options.getQuestionnumber()+"%");
//			}
//			if(options.getOptionstypenumber()!=null && options.getOptionstypenumber().length()>0){
//				criteria.andOptionstypenumberLike("%"+options.getOptionstypenumber()+"%");
//			}
	
		}
		
		Page<options> page= (Page<options>)optionsMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
