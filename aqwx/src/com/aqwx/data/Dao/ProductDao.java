package com.aqwx.data.Dao;

import com.aqwx.bean.product;
import java.util.List;
import java.util.Map;

public abstract interface ProductDao
{
  public abstract Map getProduct(product paramproduct);

  public abstract product getProductById(product paramproduct);

  public abstract void update(product paramproduct);

  public abstract void add(product paramproduct);

  public abstract boolean delete(product paramproduct);

  public abstract List<Map> getProduct(Map paramMap);

  public abstract int selectCount(product paramproduct);
}

/* Location:           C:\Users\ZHANGYAPO\Desktop\www\WEB-INF\classes\
 * Qualified Name:     com.aqwx.data.Dao.ProductDao
 * JD-Core Version:    0.6.2
 */