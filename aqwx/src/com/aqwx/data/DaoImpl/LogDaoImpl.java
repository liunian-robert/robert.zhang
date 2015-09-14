package com.aqwx.data.DaoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aqwx.bean.log;
import com.aqwx.bean.product;
import com.aqwx.data.Dao.LogDao;
import com.aqwx.util.util;

public class LogDaoImpl
  implements LogDao
{
  @Override
public log getLog(log u)
  {
    log usr = null;
    SqlSession session = util.getSqlsession();
    usr = (log)session.selectOne("log.selectOne", u);
    return usr;
  }

  @Override
public void update(log u)
  {
    SqlSession session = util.getSqlsession();
    session.update("log.updateOne", u);
    session.commit();
  }

  @Override
public void add(log u)
  {
    SqlSession session = util.getSqlsession();
    session.insert("log.insertOne", u);
    session.commit();
  }

  @Override
public List<log> getLogs(Map mp) {
    List usr = null;
    SqlSession session = util.getSqlsession();
    usr = session.selectList("log.selectListByPage", mp);
    return usr;
  }

  @Override
public int selectCount()
  {
    int count = 0;
    SqlSession session = util.getSqlsession();
    count = ((Integer)session.selectOne("log.selectCount")).intValue();
    return count;
  }

  @Override
public boolean delete(log u)
  {
    SqlSession session = util.getSqlsession();
    product pt = new product();
    pt.setClass_id(u.getId());
    if (session.update("log.deleteOne", u) > 0) {
      session.commit();
      return true;
    }
    return false;
  }

  @Override
public log getLogById(log u)
  {
    SqlSession session = util.getSqlsession();
    log usr = (log)session.selectOne("log.selectOneById", u);
    return usr;
  }

  @Override
public boolean deleteAll()
  {
    SqlSession session = util.getSqlsession();
    if (session.delete("log.deleteAll") > 0) {
      session.commit();
      return true;
    }
    return false;
  }
}