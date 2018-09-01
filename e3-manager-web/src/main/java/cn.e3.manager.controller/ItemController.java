package cn.e3.manager.controller;

import cn.e3.pojo.TbItemDesc;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.manager.service.ItemService;
import cn.e3.pojo.TbItem;

@Controller
public class ItemController {
	
	//注入service服务对象
	@Autowired
	private ItemService itemService;
	
	/**
	 * 需求:根据id查询商品信息
	 * 请求:/item/{11111}
	 * 参数:Long itemId
	 * 返回值:Tbitem
	 * 方法:findItemByID
	 */
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem findItemByID(@PathVariable Long itemId){
		//调用service服务,根据id查询
		TbItem item = itemService.findItemByID(itemId);
			
		return item;
	}
	/**
	 * 需求:分页查询商品列表
	 * 请求:/item/list
	 * 参数:Integer page,Integer rows
	 * 返回值:json格式DatagridPageBean
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public DatagridPageBean findItemList(@RequestParam(defaultValue="1")Integer page,
										 @RequestParam(defaultValue="30") Integer rows){
		//调用远程service服务对象方法,查询商品分页列表
		DatagridPageBean pageBean = itemService.findItemList(page, rows);
		return pageBean;
	}
	/**
	 * 需求:保存商品表数据,商品描述表数据
	 * 请求:/item/save
	 * 参数:TbItem item,TbItemDesc itemDesc
	 * 返回值:E3mallResult
	 * 业务:
	 * 商品id不能重复,必须保证商品id唯一性
	 * 模式:
	 * 1,redis+1
	 * 2,数据库生成id
	 * 3,时间+随机数(√)---- 毫秒+2位随机数(99)---每一个毫秒有10000
	 */
	@RequestMapping("/item/save")
	@ResponseBody
	public E3mallResult saveItem(TbItem item, TbItemDesc itemDesc){
		//调用远程service服务对象
		E3mallResult result = itemService.saveItem(item, itemDesc);
		return result;
	}

}
