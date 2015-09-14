package com.aqwx.data.DaoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aqwx.bean.join;
import com.aqwx.data.Dao.JoinDao;
import com.aqwx.util.util;

public class JoinDaoImpl
  implements JoinDao
{
  @Override
public join getJoin(join u)
  {
    join usr = null;
    SqlSession session = util.getSqlsession();
    usr = (join)session.selectOne("join.selectOne", u);
    return usr;
  }

  @Override
public void update(join u)
  {
    SqlSession session = util.getSqlsession();
    session.update("join.updateOne", u);
    session.commit();
  }

  @Override
public void add(join u)
  {
    SqlSession session = util.getSqlsession();
    session.insert("join.insertOne", u);
    session.commit();
  }

  @Override
public List<join> getJoins(Map mp) {
    List usr = null;
    SqlSession session = util.getSqlsession();
    usr = session.selectList("join.selectListByPage", mp);
    return usr;
  }

  @Override
public int selectCount()
  {
    int count = 0;
    SqlSession session = util.getSqlsession();
    count = ((Integer)session.selectOne("join.selectCount")).intValue();
    return count;
  }

  @Override
public boolean delete(join u)
  {
    SqlSession session = util.getSqlsession();
    if (session.update("join.deleteOne", u) > 0) {
      session.commit();
      return true;
    }
    return false;
  }

  @Override
public join getJoinById(join u)
  {
    SqlSession session = util.getSqlsession();
    join usr = (join)session.selectOne("join.selectOneById", u);
    return usr;
  }
}