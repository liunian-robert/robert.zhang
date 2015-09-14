package com.aqwx.data.DaoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aqwx.bean.brochure;
import com.aqwx.data.Dao.BrochureDao;
import com.aqwx.util.util;

public class BrochureDaoImpl
  implements BrochureDao
{
  @Override
public brochure getBrochure(brochure u)
  {
    brochure usr = null;
    SqlSession session = util.getSqlsession();
    usr = (brochure)session.selectOne("brochure.selectOne", u);
    return usr;
  }

  @Override
public void update(brochure u)
  {
    SqlSession session = util.getSqlsession();
    session.update("brochure.updateOne", u);
    session.commit();
  }

  @Override
public void add(brochure u)
  {
    SqlSession session = util.getSqlsession();
    session.insert("brochure.insertOne", u);
    session.commit();
  }

  @Override
public List<brochure> getBrochures(Map mp) {
    List usr = null;
    SqlSession session = util.getSqlsession();
    usr = session.selectList("brochure.selectListByPage", mp);
    return usr;
  }

  @Override
public int selectCount()
  {
    int count = 0;
    SqlSession session = util.getSqlsession();
    count = ((Integer)session.selectOne("brochure.selectCount")).intValue();
    return count;
  }

  @Override
public boolean delete(brochure u)
  {
    SqlSession session = util.getSqlsession();
    if (session.update("brochure.deleteOne", u) > 0) {
      session.commit();
      return true;
    }
    return false;
  }

  @Override
public brochure getBrochureById(brochure u)
  {
    SqlSession session = util.getSqlsession();
    brochure usr = (brochure)session.selectOne("brochure.selectOneById", u);
    return usr;
  }
}