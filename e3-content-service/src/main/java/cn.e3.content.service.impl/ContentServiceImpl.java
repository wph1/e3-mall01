package cn.e3.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.content.service.ContentService;
import cn.e3.mapper.TbContentMapper;
import cn.e3.pojo.TbContent;
import cn.e3.pojo.TbContentExample;
import cn.e3.pojo.TbContentExample.Criteria;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;
@Service
public class ContentServiceImpl implements ContentService {
	
	//注入内容表Mapper接口代理对象
	@Autowired
	private TbContentMapper contentMapper;

	/**
	 * 需求:根据分类id查询内容信息
	 * 参数:Long categoryId
	 * 返回值:DatagridPagebean
	 */
	public DatagridPageBean findContentWithCategoryId(Long categoryId,Integer page,Integer rows) {
		//创建内容对象example对象
		TbContentExample example = new TbContentExample();
		//创建criteria对象
		Criteria createCriteria = example.createCriteria();
		//设置查询参数 根据分类id查询内容信息
		createCriteria.andCategoryIdEqualTo(categoryId);
		
		//查询之前,设置分页信息
		PageHelper.startPage(page, rows);	
		
		//执行查询
		List<TbContent> list = contentMapper.selectByExample(example);
		
		//创建PageInfo对象,获取分页详细信息
		PageInfo<TbContent> pageInfo = new PageInfo<TbContent>(list);
		
		//创建分页包装类对象DatagridPageBean
		DatagridPageBean pageBean = new DatagridPageBean();
		//设置查询总记录数
		pageBean.setTotal(pageInfo.getTotal());
		//设置总记录
		pageBean.setRows(list);
		
		return pageBean;
	}

	/**
	 * 需求:添加广告内容数据
	 * 参数:TbContent content
	 * 返回值:E3mallResult
	 */
	public E3mallResult saveContent(TbContent content) {
		//补全时间属性
		Date date = new Date();
		content.setUpdated(date);
		content.setCreated(date);
		contentMapper.insert(content);
		return E3mallResult.ok();
	}

}
