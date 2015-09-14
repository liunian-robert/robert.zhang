package com.aqwx.data.Dao;

import java.util.List;
import java.util.Map;

import com.aqwx.bean.productClass;

public abstract interface ClassDao
{
  public abstract productClass getProductClass(productClass paramproductClass);

  public abstract productClass getProductClassById(productClass paramproductClass);

  public abstract void update(productClass paramproductClass);

  public abstract void add(productClass paramproductClass);

  public abstract boolean delete(productClass paramproductClass);

  public abstract List<productClass> getProductClasss(Map paramMap);

  public abstract int selectCount();
}
