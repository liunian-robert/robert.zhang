package com.aqwx.data.Dao;

import java.util.List;
import java.util.Map;

import com.aqwx.bean.knowledge;

public abstract interface KnowledgeDao
{
  public abstract knowledge getKnowledge(knowledge paramknowledge);

  public abstract knowledge getKnowledgeById(knowledge paramknowledge);

  public abstract void update(knowledge paramknowledge);

  public abstract void add(knowledge paramknowledge);

  public abstract boolean delete(knowledge paramknowledge);

  public abstract List<knowledge> getKnowledges(Map paramMap);

  public abstract int selectCount();
}

