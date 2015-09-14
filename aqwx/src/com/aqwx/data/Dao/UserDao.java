package com.aqwx.data.Dao;

import java.util.List;
import java.util.Map;

import com.aqwx.bean.user;

public abstract interface UserDao
{
  public abstract user getUser(user paramuser);

  public abstract user getUserById(user paramuser);

  public abstract void update(user paramuser);

  public abstract void add(user paramuser);

  public abstract boolean delete(user paramuser);

  public abstract List<user> getUsers(Map paramMap);

  public abstract int selectCount();
}

