     package com.aqwx.util;

     import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

     public class util
     {
       public static SqlSessionFactory getFactory()
       {
       InputStream in = null;
         try {
         in = Resources.getResourceAsStream("Configuration.xml");
         } catch (IOException e) {
         e.printStackTrace();
         throw new RuntimeException("未找到指定的bean映射文件", e);
         }
       SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
       SqlSessionFactory factory = builder.build(in);
       return factory;
       }

       public static SqlSession getSqlsession() {
       SqlSessionFactory factory = getFactory();
       return factory.openSession();
       }
     }

