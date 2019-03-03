package com.taotao.controller;

import com.taotao.common.pojo.CommonBackPage;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById (@PathVariable Long itemId) {

        TbItem t = itemService.getItemById(itemId);
        System.out.println(t);
        return t;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public CommonBackPage getItemList (int page, int rows) {
        CommonBackPage itemList = itemService.getItemList(page, rows);
        return itemList;
    }
}
