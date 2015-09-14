package com.aqwx.data.DaoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aqwx.bean.news;
import com.aqwx.data.Dao.NewsDao;
import com.aqwx.util.util;

public class NewsDaoImpl
  implements NewsDao
{
  @Override
public news getNews(news news)
  {
    news nw = null;
    SqlSession session = util.getSqlsession();
    nw = (news)session.selectOne("news.selectOne", news);
    return nw;
  }

  @Override
public void update(news news)
  {
    SqlSession session = util.getSqlsession();
    session.update("news.updateOne", news);
    session.commit();
  }

  @Override
public void add(news news)
  {
    SqlSession session = util.getSqlsession();
    session.insert("news.insertOne", news);
    session.commit();
  }

  @Override
public List<news> getNews(Map mp) {
    List nw = null;
    SqlSession session = util.getSqlsession();
    nw = session.selectList("news.selectListByPage", mp);
    return nw;
  }

  @Override
public int selectCount()
  {
    int count = 0;
    SqlSession session = util.getSqlsession();
    count = ((Integer)session.selectOne("news.selectCount")).intValue();
    return count;
  }

  @Override
public boolean delete(news nw)
  {
    SqlSession session = util.getSqlsession();
    session.delete("news.deleteOne", nw);
    session.commit();
    return true;
  }

  @Override
public news getNewsById(news nw)
  {
    SqlSession session = util.getSqlsession();
    news nws = (news)session.selectOne("news.selectOneById", nw);
    return nws;
  }
}