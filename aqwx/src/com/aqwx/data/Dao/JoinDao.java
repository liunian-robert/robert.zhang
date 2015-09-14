package com.aqwx.data.Dao;

import java.util.List;
import java.util.Map;

import com.aqwx.bean.join;

public abstract interface JoinDao
{
  public abstract join getJoin(join paramjoin);

  public abstract join getJoinById(join paramjoin);

  public abstract void update(join paramjoin);

  public abstract void add(join paramjoin);

  public abstract boolean delete(join paramjoin);

  public abstract List<join> getJoins(Map paramMap);

  public abstract int selectCount();
}

