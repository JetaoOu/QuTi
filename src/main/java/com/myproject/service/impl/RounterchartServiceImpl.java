package com.myproject.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myproject.dao.rounterchartMapper;
import com.myproject.entiy.PageResult;
import com.myproject.pojo.rounterchart;
import com.myproject.pojo.rounterchartExample;
import com.myproject.pojo.rounterchartExample.Criteria;
import com.myproject.service.RounterchartService;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class RounterchartServiceImpl implements RounterchartService {

	@Autowired
	private rounterchartMapper rounterchartMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<rounterchart> findAll(String rounterChart) {
		rounterchartExample example=new rounterchartExample();
		Criteria criteria = example.createCriteria();
		if(rounterChart!=null){			
			criteria.andRounterchartLike("%"+rounterChart+"%");
		}	
		return rounterchartMapper.selectByExample(example);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<rounterchart> page=   (Page<rounterchart>) rounterchartMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(rounterchart rounterchart) {
		rounterchartMapper.insert(rounterchart);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(rounterchart rounterchart){
		rounterchartMapper.updateByPrimaryKey(rounterchart);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public rounterchart findOne(String id){
		return rounterchartMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(String[] ids) {
		for(String id:ids){
			rounterchartMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(rounterchart rounterchart, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		rounterchartExample example=new rounterchartExample();
		Criteria criteria = example.createCriteria();
		
		if(rounterchart!=null){			
			if(rounterchart.getRounterchartid()!=null && rounterchart.getRounterchartid().length()>0){
				criteria.andRounterchartidLike("%"+rounterchart.getRounterchartid()+"%");
			}
			if(rounterchart.getRounterchart()!=null && rounterchart.getRounterchart().length()>0){
				criteria.andRounterchartLike("%"+rounterchart.getRounterchart()+"%");
			}
			if(rounterchart.getImage()!=null && rounterchart.getImage().length()>0){
				criteria.andImageLike("%"+rounterchart.getImage()+"%");
			}
			if(rounterchart.getIntroduce()!=null && rounterchart.getIntroduce().length()>0){
				criteria.andIntroduceLike("%"+rounterchart.getIntroduce()+"%");
			}
			if(rounterchart.getUrl()!=null && rounterchart.getUrl().length()>0){
				criteria.andUrlLike("%"+rounterchart.getUrl()+"%");
			}
			if(rounterchart.getRemark()!=null && rounterchart.getRemark().length()>0){
				criteria.andRemarkLike("%"+rounterchart.getRemark()+"%");
			}
		}	
		Page<rounterchart> page= (Page<rounterchart>)rounterchartMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
