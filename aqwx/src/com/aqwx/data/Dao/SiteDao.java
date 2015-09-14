package com.aqwx.data.Dao;

import java.util.Map;

import com.aqwx.bean.knowledge;
import com.aqwx.bean.news;
import com.aqwx.bean.product;
import com.aqwx.bean.student;
import com.aqwx.bean.team;
import com.aqwx.bean.technology;

public abstract interface SiteDao
{
  public abstract Map getInfo();

  public abstract Map getAllInfo();

  public abstract Map getNewsInfo(Map paramMap);

  public abstract Map getProductInfo(Map paramMap);

  public abstract Map getKnowledgeInfo(Map paramMap);

  public abstract Map getTeamInfo(Map paramMap);

  public abstract Map getJoinInfo();

  public abstract Map getStudentInfo(Map paramMap);

  public abstract Map getTechnologyInfo(Map paramMap);

  public abstract Map getNewsDetail(news paramnews);

  public abstract Map getProductDetail(product paramproduct);

  public abstract Map getKnowledgeDetail(knowledge paramknowledge);

  public abstract Map getTeamDetail(team paramteam);

  public abstract Map getStudentDetail(student paramstudent);

  public abstract Map getTechnologyDetail(technology paramtechnology);
}

