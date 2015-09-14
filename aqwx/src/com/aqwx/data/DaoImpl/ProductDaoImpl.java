package com.aqwx.data.DaoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aqwx.bean.product;
import com.aqwx.data.Dao.ProductDao;
import com.aqwx.util.util;

public class ProductDaoImpl
  implements ProductDao
{
  @Override
public Map getProduct(product product)
  {
    Map nw = null;
    SqlSession session = util.getSqlsession();
    nw = (Map)session.selectOne("product.selectOne", product);
    return nw;
  }

  @Override
public void update(product product)
  {
    SqlSession session = util.getSqlsession();
    session.update("product.updateOne", product);
    session.commit();
  }

  @Override
public void add(product product)
  {
    SqlSession session = util.getSqlsession();
    session.insert("product.insertOne", product);
    session.commit();
  }

  @Override
public List<Map> getProduct(Map mp) {
    List nw = null;
    SqlSession session = util.getSqlsession();
    nw = session.selectList("product.selectListByPage", mp);
    return nw;
  }

  @Override
public int selectCount(product p)
  {
    int count = 0;
    SqlSession session = util.getSqlsession();
    count = ((Integer)session.selectOne("product.selectCount", p)).intValue();
    return count;
  }

  @Override
public boolean delete(product nw)
  {
    SqlSession session = util.getSqlsession();
    session.delete("product.deleteOne", nw);
    session.commit();
    return true;
  }

  @Override
public product getProductById(product nw)
  {
    SqlSession session = util.getSqlsession();
    product nws = (product)session.selectOne("product.selectOneById", nw);
    return nws;
  }
}