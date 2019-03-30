package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.service.GoodService;
import com.qianfeng.fxmall.goods.service.Impl.GoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class GoodAddServlet extends HttpServlet {


    private GoodService goodService  = new GoodServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String s = UUID.randomUUID().toString();
        Timestamp time = new Timestamp(new Date().getTime());
        String goodId = s.substring(0,8);
        String goodName = req.getParameter("good_name");
        int orderNo = Integer.parseInt(req.getParameter("order_no"));
        Long sellNum = Long.parseLong(req.getParameter("promote_desc"));
        String tags = req.getParameter("tags");
        String forwardLink = req.getParameter("forward_link");
        String copyDesc = req.getParameter("copy_desc");
        String promoteDesc = req.getParameter("promote_desc");
        String gcopy = req.getParameter("gcopy");
        String zcopyId = req.getParameter("zcopy_id");
        WxbGood wxbGood = new WxbGood();
        wxbGood.setGoodId(goodId);
        wxbGood.setGoodName(goodName);
        wxbGood.setCustomerId("10");
        wxbGood.setGoodPic("XXX");
        wxbGood.setGoodPic1("XXX");
        wxbGood.setGoodPic2("XXX");
        wxbGood.setPromoteDesc(promoteDesc);
        wxbGood.setSkuTitle("智能");
        wxbGood.setSkuCost("3000");
        wxbGood.setSkuPrice("4000");
        wxbGood.setSkuPmoney("200");
        wxbGood.setCopyIds(zcopyId);
        wxbGood.setCopyDesc(copyDesc);
        wxbGood.setForwardLink(forwardLink);
        wxbGood.setOrderNo(orderNo);
        wxbGood.setTypeId("20");
        wxbGood.setTags(tags);
        wxbGood.setState(0);
        wxbGood.setCreateTime(time);
        wxbGood.setToped(0);
        wxbGood.setRecomed(0);
        wxbGood.setTopedTime(time);
        wxbGood.setRecomedTime(time);
        wxbGood.setSpcId("20");
        wxbGood.setZonId(gcopy);
        wxbGood.setSellNum(sellNum);
        wxbGood.setWebsite("www.xxx.com");
        wxbGood.setIswxpay(1);
        wxbGood.setIsfdfk(0);
        wxbGood.setLeixingId(0);
        wxbGood.setKfqq("0");
        goodService.goodSava(wxbGood);
        resp.sendRedirect("./good.do");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
