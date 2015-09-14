package com.aqwx.data.Dao;

import java.util.List;
import java.util.Map;

import com.aqwx.bean.company;

public abstract interface CompanyDao
{
  public abstract company getCompany(company paramcompany);

  public abstract company getCompanyById(company paramcompany);

  public abstract void update(company paramcompany);

  public abstract List<company> getCompany(Map paramMap);

  public abstract int selectCount();

  public abstract boolean updateMovie(company paramcompany);
}
