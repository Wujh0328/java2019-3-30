package com.qianfeng.fxmall.goods.dao;

import com.qianfeng.fxmall.goods.bean.WxbGood;

import java.util.List;

public interface GoodDAO {

    List<WxbGood> queryGoodsByPage(Integer page);

    void goodSava(WxbGood wxbGood);
}
