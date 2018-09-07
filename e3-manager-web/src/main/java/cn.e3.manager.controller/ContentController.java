package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.content.service.ContentService;
import cn.e3.pojo.TbContent;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;

@Controller
public class ContentController {
	
	//注入广告内容服务对象
	@Autowired
	private ContentService contentService;
	
	/**
	 * 需求:根据分类id查询内容信息
	 * 请求:/content/query/list
	 * 参数:Long categoryId,Integer page,Integer rows
	 * 返回值:json格式DatagridPagebean
	 */
	@RequestMapping("/content/query/list")
	@ResponseBody
	public DatagridPageBean findContentWithCategoryId(Long categoryId,
			@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="30") Integer rows){
		//调用远程内容服务对象
		DatagridPageBean pageBean = contentService.findContentWithCategoryId(categoryId, page, rows);
		
		return pageBean;
		
		}
	/**
	 * 需求:添加广告内容数据
	 * 请求:/content/save
	 * 参数:TbContent content
	 * 返回值:E3mallResult
	 */
	@RequestMapping("/content/save")
	@ResponseBody
	public E3mallResult saveContent(TbContent content){
		//保存
		E3mallResult result = contentService.saveContent(content);
		return result;
	}

}
