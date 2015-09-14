package com.aqwx.data.DaoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aqwx.bean.user;
import com.aqwx.data.Dao.UserDao;
import com.aqwx.util.util;

public class UserDaoImpl
  implements UserDao
{
  @Override
public user getUser(user u)
  {
    user usr = null;
    SqlSession session = util.getSqlsession();
    usr = (user)session.selectOne("user.selectOne", u);
    return usr;
  }

  @Override
public void update(user u)
  {
    SqlSession session = util.getSqlsession();
    session.update("user.updateOne", u);
    session.commit();
  }

  @Override
public void add(user u)
  {
    SqlSession session = util.getSqlsession();
    session.insert("user.insertOne", u);
    session.commit();
  }

  @Override
public List<user> getUsers(Map mp) {
    List usr = null;
    SqlSession session = util.getSqlsession();
    usr = session.selectList("user.selectListByPage", mp);
    return usr;
  }

  @Override
public int selectCount()
  {
    int count = 0;
    SqlSession session = util.getSqlsession();
    count = ((Integer)session.selectOne("user.selectCount")).intValue();
    return count;
  }

  @Override
public boolean delete(user u)
  {
    SqlSession session = util.getSqlsession();
    if (session.update("user.deleteOne", u) > 0) {
      session.commit();
      return true;
    }
    return false;
  }

  @Override
public user getUserById(user u)
  {
    SqlSession session = util.getSqlsession();
    user usr = (user)session.selectOne("user.selectOneById", u);
    return usr;
  }
}