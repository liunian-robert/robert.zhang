package com.aqwx.data.Dao;

import java.util.List;
import java.util.Map;

import com.aqwx.bean.link;

public abstract interface LinkDao
{
  public abstract link getLink(link paramlink);

  public abstract link getLinkById(link paramlink);

  public abstract void update(link paramlink);

  public abstract void add(link paramlink);

  public abstract boolean delete(link paramlink);

  public abstract List<link> getLinks(Map paramMap);

  public abstract int selectCount();
}

