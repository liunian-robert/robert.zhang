package com.aqwx.data.DaoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aqwx.bean.knowledge;
import com.aqwx.data.Dao.KnowledgeDao;
import com.aqwx.util.util;

public class KnowledgeDaoImpl
  implements KnowledgeDao
{
  @Override
public knowledge getKnowledge(knowledge u)
  {
    knowledge usr = null;
    SqlSession session = util.getSqlsession();
    usr = (knowledge)session.selectOne("knowledge.selectOne", u);
    return usr;
  }

  @Override
public void update(knowledge u)
  {
    SqlSession session = util.getSqlsession();
    session.update("knowledge.updateOne", u);
    session.commit();
  }

  @Override
public void add(knowledge u)
  {
    SqlSession session = util.getSqlsession();
    session.insert("knowledge.insertOne", u);
    session.commit();
  }

  @Override
public List<knowledge> getKnowledges(Map mp) {
    List usr = null;
    SqlSession session = util.getSqlsession();
    usr = session.selectList("knowledge.selectListByPage", mp);
    return usr;
  }

  @Override
public int selectCount()
  {
    int count = 0;
    SqlSession session = util.getSqlsession();
    count = ((Integer)session.selectOne("knowledge.selectCount")).intValue();
    return count;
  }

  @Override
public boolean delete(knowledge u)
  {
    SqlSession session = util.getSqlsession();
    if (session.update("knowledge.deleteOne", u) > 0) {
      session.commit();
      return true;
    }
    return false;
  }

  @Override
public knowledge getKnowledgeById(knowledge u)
  {
    SqlSession session = util.getSqlsession();
    knowledge usr = (knowledge)session.selectOne("knowledge.selectOneById", u);
    return usr;
  }
}