package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.CommonBackPage;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public TbItem getItemById(long id) {
        TbItem tbItem = tbItemMapper.selectByPrimaryKey(id);
        if (tbItem != null) {
            return  tbItem;
        }
        return null;
    }

    @Override
    public CommonBackPage getItemList(int page, int rows) {
        TbItemExample tbItemExample = new TbItemExample();
        // 分页处理
        PageHelper.startPage(page,rows);
        List<TbItem> tbItems = tbItemMapper.selectByExample(tbItemExample);
        // 创建分页pojo
        CommonBackPage commonBackPage = new CommonBackPage();
        commonBackPage.setRows(tbItems);
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItems);
        commonBackPage.setTotal(pageInfo.getTotal());
        return commonBackPage;
    }
}
