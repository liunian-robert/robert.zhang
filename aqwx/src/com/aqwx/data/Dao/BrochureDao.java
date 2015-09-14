package com.aqwx.data.Dao;

import java.util.List;
import java.util.Map;

import com.aqwx.bean.brochure;

public abstract interface BrochureDao
{
  public abstract brochure getBrochure(brochure parambrochure);

  public abstract brochure getBrochureById(brochure parambrochure);

  public abstract void update(brochure parambrochure);

  public abstract void add(brochure parambrochure);

  public abstract boolean delete(brochure parambrochure);

  public abstract List<brochure> getBrochures(Map paramMap);

  public abstract int selectCount();
}

