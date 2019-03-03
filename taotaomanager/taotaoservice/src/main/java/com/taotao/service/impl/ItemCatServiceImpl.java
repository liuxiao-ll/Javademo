package com.taotao.service.impl;

import com.taotao.common.pojo.TreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import com.taotao.pojo.TbItemCatExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public List<TreeNode> getItemCatList(long parentId) {
        // 根据父亲parentId查询list
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        // 创建搜索条件
        Criteria criteria = tbItemCatExample.createCriteria();
        // 增加搜索方法
        criteria.andParentIdEqualTo(parentId);
        // 执行搜索条件
        List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(tbItemCatExample);
        // 创建[]接收node
        ArrayList<TreeNode> treeNodeArrayList = new ArrayList<>();
        // iter快捷键
        for (TbItemCat tbItemCat : tbItemCats) {
            // 生成node
            TreeNode node = new TreeNode(tbItemCat.getId(), tbItemCat.getName(), tbItemCat.getIsParent() ? "closed" : "open");
            treeNodeArrayList.add(node);
        }
        return treeNodeArrayList;
    }
}
