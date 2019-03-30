package com.qianfeng.fxmall.goods.service;

import com.qianfeng.fxmall.goods.bean.WxbGood;

import java.util.List;

public interface GoodService {

    List<WxbGood> queryGoodsByPage(Integer page);
    void goodSava(WxbGood wxbGood);
}
