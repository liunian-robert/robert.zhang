package com.aqwx.data.DaoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aqwx.bean.team;
import com.aqwx.data.Dao.TeamDao;
import com.aqwx.util.util;

public class TeamDaoImpl
  implements TeamDao
{
  @Override
public team getTeam(team u)
  {
    team usr = null;
    SqlSession session = util.getSqlsession();
    usr = (team)session.selectOne("team.selectOne", u);
    return usr;
  }

  @Override
public void update(team u)
  {
    SqlSession session = util.getSqlsession();
    session.update("team.updateOne", u);
    session.commit();
  }

  @Override
public void add(team u)
  {
    SqlSession session = util.getSqlsession();
    session.insert("team.insertOne", u);
    session.commit();
  }

  @Override
public List<team> getTeams(Map mp) {
    List usr = null;
    SqlSession session = util.getSqlsession();
    usr = session.selectList("team.selectListByPage", mp);
    return usr;
  }

  @Override
public int selectCount()
  {
    int count = 0;
    SqlSession session = util.getSqlsession();
    count = ((Integer)session.selectOne("team.selectCount")).intValue();
    return count;
  }

  @Override
public boolean delete(team u)
  {
    SqlSession session = util.getSqlsession();
    if (session.update("team.deleteOne", u) > 0) {
      session.commit();
      return true;
    }
    return false;
  }

  @Override
public team getTeamById(team u)
  {
    SqlSession session = util.getSqlsession();
    team usr = (team)session.selectOne("team.selectOneById", u);
    return usr;
  }
}