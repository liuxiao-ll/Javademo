package com.taotao.service;

import com.taotao.common.pojo.CommonBackPage;
import com.taotao.pojo.TbItem;

public interface ItemService {
    TbItem getItemById(long id);
    CommonBackPage getItemList(int page, int rows);
}
