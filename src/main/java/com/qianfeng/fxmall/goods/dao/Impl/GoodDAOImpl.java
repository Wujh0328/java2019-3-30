package com.qianfeng.fxmall.goods.dao.Impl;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.GoodDAO;
import com.qianfeng.fxmall.goods.mapper.GoodMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * MyBatis的商品数据访问层
 *
 * 注意：
 * 异常在dao层不要捕获
 */
public class GoodDAOImpl implements GoodDAO {


    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) {
        GoodMapper goodMapper = MyBatisSessionFactoryUtils.getSession().getMapper(GoodMapper.class);
        List<WxbGood> goods = goodMapper.queryGoodsByPage(page, SystemConstantsUtils.Page.PAGE_SIZE);
        return goods;
    }

    @Override
    public void goodSava(WxbGood wxbGood) {
        SqlSession session = MyBatisSessionFactoryUtils.getSession();
        GoodMapper mapper = session.getMapper(GoodMapper.class);
        mapper.goodSave(wxbGood);
        session.commit();
    }
}
