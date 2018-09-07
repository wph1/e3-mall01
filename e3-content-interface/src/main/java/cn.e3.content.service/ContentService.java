package cn.e3.content.service;

import cn.e3.pojo.TbContent;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;

public interface ContentService {
	
	/**
	 * 需求:根据分类id查询内容信息
	 * 参数:Long categoryId
	 * 返回值:DatagridPagebean
	 */
	public DatagridPageBean findContentWithCategoryId(Long categoryId,Integer page,Integer rows);
	/**
	 * 需求:添加广告内容数据
	 * 参数:TbContent content
	 * 返回值:E3mallResult
	 */
	public E3mallResult saveContent(TbContent content);
}
