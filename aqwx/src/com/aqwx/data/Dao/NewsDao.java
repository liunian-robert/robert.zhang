package com.aqwx.data.Dao;

import com.aqwx.bean.news;
import java.util.List;
import java.util.Map;

public abstract interface NewsDao
{
  public abstract news getNews(news paramnews);

  public abstract news getNewsById(news paramnews);

  public abstract void update(news paramnews);

  public abstract void add(news paramnews);

  public abstract boolean delete(news paramnews);

  public abstract List<news> getNews(Map paramMap);

  public abstract int selectCount();
}

/* Location:           C:\Users\ZHANGYAPO\Desktop\www\WEB-INF\classes\
 * Qualified Name:     com.aqwx.data.Dao.NewsDao
 * JD-Core Version:    0.6.2
 */