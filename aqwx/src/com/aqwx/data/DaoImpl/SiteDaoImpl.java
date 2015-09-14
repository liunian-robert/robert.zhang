package com.aqwx.data.DaoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aqwx.bean.company;
import com.aqwx.bean.join;
import com.aqwx.bean.knowledge;
import com.aqwx.bean.news;
import com.aqwx.bean.product;
import com.aqwx.bean.student;
import com.aqwx.bean.team;
import com.aqwx.bean.technology;
import com.aqwx.data.Dao.SiteDao;
import com.aqwx.service.TechnologyService;
import com.aqwx.service.knowledgeService;
import com.aqwx.service.newsService;
import com.aqwx.service.productService;
import com.aqwx.service.studentService;
import com.aqwx.service.teamService;
import com.aqwx.util.Utils;
import com.aqwx.util.util;

public class SiteDaoImpl
  implements SiteDao
{
  @Override
public Map getInfo()
  {
    SqlSession session = util.getSqlsession();
    Map mk = new HashMap();
    company x = new company();
    x.setId("1");
    company m = (company)session.selectOne("company.selectOneById", x);
    m.setContent(Utils.getContent(m.getContent()));
    List nw = null;
    int ncount = ((Integer)session.selectOne("news.selectCount")).intValue();
    if (ncount >= 7) {
      mk.put("index", Integer.valueOf(ncount - 7));
      mk.put("count", Integer.valueOf(ncount));
      nw = session.selectList("news.selectListByPage", mk);
    } else {
      nw = session.selectList("news.selectList");
    }
    List lk = session.selectList("link.selectList");
    List kn = null;
    int kcount = ((Integer)session.selectOne("knowledge.selectCount")).intValue();
    if (kcount >= 7) {
      mk.put("index", Integer.valueOf(kcount - 7));
      mk.put("count", Integer.valueOf(kcount));
      kn = session.selectList("knowledge.selectListByPage", mk);
    }
    else {
      kn = session.selectList("knowledge.selectList");
    }
    List tm = session.selectList("team.selectList");
    List pt = session.selectList("product.selectList");
    List bc = session.selectList("brochure.selectList");
    Map mp = new HashMap();
    mp.put("company", m);
    mp.put("news", nw);
    mp.put("link", lk);
    mp.put("knowledge", kn);
    mp.put("team", tm);
    mp.put("product", pt);
    mp.put("brochure", bc);
    return mp;
  }

  @Override
public Map getAllInfo()
  {
    SqlSession session = util.getSqlsession();
    company cp = new company();
    cp.setId("1");
    company cy = (company)session.selectOne("company.selectOneById", cp);
    Map mp = new HashMap();
    mp.put("company", cy);
    List pc = session.selectList("productClass.selectList");
    mp.put("productclass", pc);
    List tm = session.selectList("team.selectList");
    List bc = session.selectList("brochure.selectList");
    mp.put("team", tm);
    mp.put("brochure", bc);
    return mp;
  }

  @Override
public Map getNewsInfo(Map mk) {
    Map mp = getAllInfo();
    SqlSession session = util.getSqlsession();
    newsService service = new newsService();
    Map ms = service.getListByPage(mk);
    mp.put("mp", ms);
    return mp;
  }

  @Override
public Map getProductInfo(Map mk)
  {
    Map mp = getAllInfo();
    SqlSession session = util.getSqlsession();
    productService service = new productService();
    Map ms = service.getListByPage(mk);
    mp.put("mp", ms);
    return mp;
  }

  @Override
public Map getKnowledgeInfo(Map mk)
  {
    Map mp = getAllInfo();
    SqlSession session = util.getSqlsession();
    knowledgeService service = new knowledgeService();
    Map ms = service.getListByPage(mk);
    mp.put("mp", ms);
    return mp;
  }

  @Override
public Map getTeamInfo(Map mk)
  {
    Map mp = getAllInfo();
    SqlSession session = util.getSqlsession();
    teamService service = new teamService();
    Map ms = service.getListByPage(mk);
    mp.put("mp", ms);
    return mp;
  }

  @Override
public Map getJoinInfo()
  {
    Map mp = getAllInfo();
    SqlSession session = util.getSqlsession();
    join jx = new join();
    jx.setId("1");
    join jn = (join)session.selectOne("join.selectOneById", jx);
    mp.put("join", jn);
    return mp;
  }

  @Override
public Map getStudentInfo(Map mk)
  {
    Map mp = getAllInfo();
    SqlSession session = util.getSqlsession();
    studentService service = new studentService();
    Map ms = service.getListByPage(mk);
    mp.put("mp", ms);
    return mp;
  }

  @Override
public Map getTechnologyInfo(Map mk)
  {
    Map mp = getAllInfo();
    SqlSession session = util.getSqlsession();
    TechnologyService service = new TechnologyService();
    Map ms = service.getListByPage(mk);
    mp.put("mp", ms);
    return mp;
  }

  @Override
public Map getNewsDetail(news nw)
  {
    Map mp = getAllInfo();
    SqlSession session = util.getSqlsession();
    news ns = (news)session.selectOne("news.selectOneById", nw);
    mp.put("newsDetail", ns);
    return mp;
  }

  @Override
public Map getProductDetail(product nw)
  {
    Map mp = getAllInfo();
    SqlSession session = util.getSqlsession();
    product ns = (product)session.selectOne("product.selectOneById", nw);
    mp.put("productDetail", ns);
    return mp;
  }

  @Override
public Map getKnowledgeDetail(knowledge kl)
  {
    Map mp = getAllInfo();
    SqlSession session = util.getSqlsession();
    knowledge ns = (knowledge)session.selectOne("knowledge.selectOneById", kl);
    mp.put("knowledgeDetail", ns);
    return mp;
  }

  @Override
public Map getTeamDetail(team tm)
  {
    Map mp = getAllInfo();
    SqlSession session = util.getSqlsession();
    team ns = (team)session.selectOne("team.selectOneById", tm);
    mp.put("teamDetail", ns);
    return mp;
  }

  @Override
public Map getStudentDetail(student st)
  {
    Map mp = getAllInfo();
    SqlSession session = util.getSqlsession();
    student ns = (student)session.selectOne("student.selectOneById", st);
    mp.put("studentDetail", ns);
    return mp;
  }

  @Override
public Map getTechnologyDetail(technology tg)
  {
    Map mp = getAllInfo();
    SqlSession session = util.getSqlsession();
    technology ns = (technology)session.selectOne("technology.selectOneById", tg);
    mp.put("technologyDetail", ns);
    return mp;
  }
}