package com.aqwx.data.DaoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aqwx.bean.product;
import com.aqwx.bean.productClass;
import com.aqwx.data.Dao.ClassDao;
import com.aqwx.util.util;

public class ClassDaoImpl
  implements ClassDao
{
  @Override
public productClass getProductClass(productClass u)
  {
    productClass usr = null;
    SqlSession session = util.getSqlsession();
    usr = (productClass)session.selectOne("productClass.selectOne", u);
    return usr;
  }

  @Override
public void update(productClass u)
  {
    SqlSession session = util.getSqlsession();
    session.update("productClass.updateOne", u);
    session.commit();
  }

  @Override
public void add(productClass u)
  {
    SqlSession session = util.getSqlsession();
    session.insert("productClass.insertOne", u);
    session.commit();
  }

  @Override
public List<productClass> getProductClasss(Map mp) {
    List usr = null;
    SqlSession session = util.getSqlsession();
    usr = session.selectList("productClass.selectListByPage", mp);
    return usr;
  }

  @Override
public int selectCount()
  {
    int count = 0;
    SqlSession session = util.getSqlsession();
    count = ((Integer)session.selectOne("productClass.selectCount")).intValue();
    return count;
  }

  @Override
public boolean delete(productClass u)
  {
    SqlSession session = util.getSqlsession();
    product pt = new product();
    pt.setClass_id(u.getId());
    if (session.update("productClass.deleteOne", u) > 0) {
      session.delete("product.deleteClass", pt);
      session.commit();
      return true;
    }
    return false;
  }

  @Override
public productClass getProductClassById(productClass u)
  {
    SqlSession session = util.getSqlsession();
    productClass usr = (productClass)session.selectOne("productClass.selectOneById", u);
    return usr;
  }
}