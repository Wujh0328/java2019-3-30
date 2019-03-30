package com.qianfeng.fxmall.commons.mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 对SqlSessionFactory进行封装，做到全局唯一
 */
public class MyBatisSessionFactoryUtils {

    public static SqlSessionFactory sqlSessionFactory;

    private  static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    private  static void initSessionFactory(){
        try {
            //1、配置文件只需要加载一次（全局）
            InputStream stream = Resources.getResourceAsStream("mybatis.cfg.xml");
            //2、全局唯一
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //静态代码块
    static {
        initSessionFactory();
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory == null){
            initSessionFactory();
        }
        return sqlSessionFactory;
    }


    public static SqlSession getSession(){
        //同一个线程访问
        SqlSession session = threadLocal.get();
        if(session == null){
            session = sqlSessionFactory.openSession();
            //存入session
            threadLocal.set(session);
        }
        return session;
    }

}
