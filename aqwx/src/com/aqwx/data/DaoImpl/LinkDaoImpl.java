package com.aqwx.data.DaoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aqwx.bean.link;
import com.aqwx.data.Dao.LinkDao;
import com.aqwx.util.util;

public class LinkDaoImpl
  implements LinkDao
{
  @Override
public link getLink(link u)
  {
    link usr = null;
    SqlSession session = util.getSqlsession();
    usr = (link)session.selectOne("link.selectOne", u);
    return usr;
  }

  @Override
public void update(link u)
  {
    SqlSession session = util.getSqlsession();
    session.update("link.updateOne", u);
    session.commit();
  }

  @Override
public void add(link u)
  {
    SqlSession session = util.getSqlsession();
    session.insert("link.insertOne", u);
    session.commit();
  }

  @Override
public List<link> getLinks(Map mp) {
    List usr = null;
    SqlSession session = util.getSqlsession();
    usr = session.selectList("link.selectListByPage", mp);
    return usr;
  }

  @Override
public int selectCount()
  {
    int count = 0;
    SqlSession session = util.getSqlsession();
    count = ((Integer)session.selectOne("link.selectCount")).intValue();
    return count;
  }

  @Override
public boolean delete(link u)
  {
    SqlSession session = util.getSqlsession();
    if (session.update("link.deleteOne", u) > 0) {
      session.commit();
      return true;
    }
    return false;
  }

  @Override
public link getLinkById(link u)
  {
    SqlSession session = util.getSqlsession();
    link usr = (link)session.selectOne("link.selectOneById", u);
    return usr;
  }
}