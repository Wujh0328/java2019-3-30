package com.qianfeng.fxmall.goods.mapper;

import com.qianfeng.fxmall.goods.bean.WxbGoodSku;

import java.util.List;

public interface GoodSkuMapper {

    List<WxbGoodSku> queryGoodSku();
    void skuSave(WxbGoodSku wxbGoodSku);
}
