package com.aqwx.data.Dao;

import java.util.List;
import java.util.Map;

import com.aqwx.bean.technology;

public abstract interface TechnologyDao
{
  public abstract technology getTechnology(technology paramtechnology);

  public abstract technology getTechnologyById(technology paramtechnology);

  public abstract void update(technology paramtechnology);

  public abstract void add(technology paramtechnology);

  public abstract boolean delete(technology paramtechnology);

  public abstract List<technology> getTechnologys(Map paramMap);

  public abstract int selectCount();
}

