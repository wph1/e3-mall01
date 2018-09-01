package cn.e3.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3.manager.service.ItemCatService;
import cn.e3.mapper.TbItemCatMapper;
import cn.e3.pojo.TbItemCat;
import cn.e3.pojo.TbItemCatExample;
import cn.e3.pojo.TbItemCatExample.Criteria;
import cn.e3.utils.TreeNode;
@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	//注入商品类目Mapper接口代理对象
	@Autowired
	private TbItemCatMapper itemCatMapper;

	/**
	 * 需求:根据父id查询此节点下子节点
	 * 参数:Long parentId
	 * 返回值:List<TreeNode>
	 * 思考:服务是否发布?
	 */
	public List<TreeNode> findItemCatWithTreeNodeList(Long parentId) {
		
		//创建树形节点List<TreeNode>对象,封装树形节点数据
		List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
		
		//创建example对象
		TbItemCatExample example = new TbItemCatExample();
		//创建criteria对象,设置查询参数
		Criteria createCriteria = example.createCriteria();
		//根据父id查询此节点下子节点
		createCriteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> catList = itemCatMapper.selectByExample(example);
		//循环遍历商品类目数据集合,把数据封装树形节点
		for (TbItemCat tbItemCat : catList) {
			//创建TreeNode对象,封装单个树形节点数据
			TreeNode node = new TreeNode();
			//设置树形节点id
			node.setId(tbItemCat.getId());
			//设置树形节点名称
			node.setText(tbItemCat.getName());
			//设置树形节点状态
			//is_parent=1,表示节点有子节点,state="closed",表示可打开状态
			//is_parent=0,表示子节点没有子节点,state=open,表示已经处于打开状态
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			
			//把单个树形节点放入树形节点集合
			treeNodeList.add(node);
			
		}
		return treeNodeList;
	}

}
