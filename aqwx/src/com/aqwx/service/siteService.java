package com.aqwx.service;

import java.util.Map;

import com.aqwx.bean.knowledge;
import com.aqwx.bean.news;
import com.aqwx.bean.product;
import com.aqwx.bean.student;
import com.aqwx.bean.team;
import com.aqwx.bean.technology;
import com.aqwx.data.Dao.SiteDao;
import com.aqwx.data.DaoImpl.SiteDaoImpl;

public class siteService
{
  public Map getInfo()
  {
    SiteDao dao = new SiteDaoImpl();
    Map mp = dao.getInfo();
    return mp;
  }
  public Map getAllInfo() {
    SiteDao dao = new SiteDaoImpl();
    Map mp = dao.getAllInfo();
    return mp;
  }
  public Map getNewsInfo(Map mk) {
    SiteDao dao = new SiteDaoImpl();
    Map mp = dao.getNewsInfo(mk);
    return mp;
  }
  public Map getProductInfo(Map mk) {
    SiteDao dao = new SiteDaoImpl();
    Map mp = dao.getProductInfo(mk);
    return mp;
  }
  public Map getKnowledgeInfo(Map mk) {
    SiteDao dao = new SiteDaoImpl();
    Map mp = dao.getKnowledgeInfo(mk);
    return mp;
  }
  public Map getTeamInfo(Map mk) {
    SiteDao dao = new SiteDaoImpl();
    Map mp = dao.getTeamInfo(mk);
    return mp;
  }
  public Map getJoinInfo() {
    SiteDao dao = new SiteDaoImpl();
    Map mp = dao.getJoinInfo();
    return mp;
  }
  public Map getStudentInfo(Map mk) {
    SiteDao dao = new SiteDaoImpl();
    Map mp = dao.getStudentInfo(mk);
    return mp;
  }
  public Map getTechnologyInfo(Map mk) {
    SiteDao dao = new SiteDaoImpl();
    Map mp = dao.getTechnologyInfo(mk);
    return mp;
  }
  public Map getNewsDetail(news nw) {
    SiteDao dao = new SiteDaoImpl();
    Map mp = dao.getNewsDetail(nw);
    return mp;
  }
  public Map getProductDetail(product nw) {
    SiteDao dao = new SiteDaoImpl();
    Map mp = dao.getProductDetail(nw);
    return mp;
  }
  public Map getKnowledgeDetail(knowledge kl) {
    SiteDao dao = new SiteDaoImpl();
    Map mp = dao.getKnowledgeDetail(kl);
    return mp;
  }
  public Map getTeamDetail(team tm) {
    SiteDao dao = new SiteDaoImpl();
    Map mp = dao.getTeamDetail(tm);
    return mp;
  }
  public Map getStudentDetail(student st) {
    SiteDao dao = new SiteDaoImpl();
    Map mp = dao.getStudentDetail(st);
    return mp;
  }
  public Map getTechnologyDetail(technology tg) {
    SiteDao dao = new SiteDaoImpl();
    Map mp = dao.getTechnologyDetail(tg);
    return mp;
  }
}