package com.aqwx.data.DaoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aqwx.bean.technology;
import com.aqwx.data.Dao.TechnologyDao;
import com.aqwx.util.util;

public class TechnologyDaoImpl
  implements TechnologyDao
{
  @Override
public technology getTechnology(technology u)
  {
    technology usr = null;
    SqlSession session = util.getSqlsession();
    usr = (technology)session.selectOne("technology.selectOne", u);
    return usr;
  }

  @Override
public void update(technology u)
  {
    SqlSession session = util.getSqlsession();
    session.update("technology.updateOne", u);
    session.commit();
  }

  @Override
public void add(technology u)
  {
    SqlSession session = util.getSqlsession();
    session.insert("technology.insertOne", u);
    session.commit();
  }

  @Override
public List<technology> getTechnologys(Map mp) {
    List usr = null;
    SqlSession session = util.getSqlsession();
    usr = session.selectList("technology.selectListByPage", mp);
    return usr;
  }

  @Override
public int selectCount()
  {
    int count = 0;
    SqlSession session = util.getSqlsession();
    count = ((Integer)session.selectOne("technology.selectCount")).intValue();
    return count;
  }

  @Override
public boolean delete(technology u)
  {
    SqlSession session = util.getSqlsession();
    if (session.update("technology.deleteOne", u) > 0) {
      session.commit();
      return true;
    }
    return false;
  }

  @Override
public technology getTechnologyById(technology u)
  {
    SqlSession session = util.getSqlsession();
    technology usr = (technology)session.selectOne("technology.selectOneById", u);
    return usr;
  }
}