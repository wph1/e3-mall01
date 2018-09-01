package cn.e3.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.manager.service.ItemCatService;
import cn.e3.utils.TreeNode;

@Controller
public class ItemCatController {
	
	//注入service服务对象
	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 需求:根据父id查询此节点下子节点
	 * 请求:/item/cat/list
	 * 参数:Long parentId
	 * 返回值:List<TreeNode>
	 * 思考:服务是否引入?
	 * 业务分析:
	 * 1,前端框架easyUI treeNode传递参数 id
	 * 2,初始化顶级节点 parent_id=0
	 */
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<TreeNode> findItemCatWithTreeNodeList(@RequestParam(value="id",defaultValue="0") Long parentId){
		//调用远程service服务对象
		List<TreeNode> list = itemCatService.findItemCatWithTreeNodeList(parentId);
		return list;
	}

}
