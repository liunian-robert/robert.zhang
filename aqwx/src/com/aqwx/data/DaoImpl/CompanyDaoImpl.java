package com.aqwx.data.DaoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aqwx.bean.company;
import com.aqwx.data.Dao.CompanyDao;
import com.aqwx.util.util;

public class CompanyDaoImpl
  implements CompanyDao
{
  @Override
public company getCompany(company company)
  {
    company nw = null;
    SqlSession session = util.getSqlsession();
    nw = (company)session.selectOne("company.selectOne", company);
    return nw;
  }

  @Override
public void update(company company)
  {
    SqlSession session = util.getSqlsession();
    session.update("company.updateOne", company);
    session.commit();
  }

  @Override
public List<company> getCompany(Map mp)
  {
    List nw = null;
    SqlSession session = util.getSqlsession();
    nw = session.selectList("company.selectListByPage", mp);
    return nw;
  }

  @Override
public int selectCount()
  {
    int count = 0;
    SqlSession session = util.getSqlsession();
    count = ((Integer)session.selectOne("company.selectCount")).intValue();
    return count;
  }

  @Override
public company getCompanyById(company nw)
  {
    SqlSession session = util.getSqlsession();
    company nws = (company)session.selectOne("company.selectOneById", nw);
    return nws;
  }

  @Override
public boolean updateMovie(company cp)
  {
    SqlSession session = util.getSqlsession();
    if (session.update("company.updateMovie", cp) > 0) {
      session.commit();
      return true;
    }
    return false;
  }
}