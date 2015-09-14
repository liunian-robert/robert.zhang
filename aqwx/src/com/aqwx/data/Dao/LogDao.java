package com.aqwx.data.Dao;

import java.util.List;
import java.util.Map;

import com.aqwx.bean.log;

public abstract interface LogDao
{
  public abstract log getLog(log paramlog);

  public abstract log getLogById(log paramlog);

  public abstract void update(log paramlog);

  public abstract void add(log paramlog);

  public abstract boolean delete(log paramlog);

  public abstract boolean deleteAll();

  public abstract List<log> getLogs(Map paramMap);

  public abstract int selectCount();
}

