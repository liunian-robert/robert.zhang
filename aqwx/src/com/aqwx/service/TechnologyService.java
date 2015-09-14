package com.aqwx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aqwx.bean.Page;
import com.aqwx.bean.technology;
import com.aqwx.data.Dao.TechnologyDao;
import com.aqwx.data.DaoImpl.TechnologyDaoImpl;

public class TechnologyService
{
  public technology getTechnology(technology u)
  {
    TechnologyDao dao = new TechnologyDaoImpl();
    technology usr = dao.getTechnology(u);
    return usr;
  }
  public technology getTechnologyById(technology u) {
    TechnologyDao dao = new TechnologyDaoImpl();
    technology usr = dao.getTechnologyById(u);
    return usr;
  }
  public boolean modify(technology u) {
    TechnologyDao dao = new TechnologyDaoImpl();
    dao.update(u);
    return true;
  }
  public boolean delete(technology u) {
    TechnologyDao dao = new TechnologyDaoImpl();
    dao.delete(u);
    return true;
  }
  public boolean addTechnology(technology u) {
    TechnologyDao dao = new TechnologyDaoImpl();
    dao.add(u);
    return true;
  }
  public Map getListByPage(Map mp) {
    List usr = null;
    Map mk = new HashMap();
    Page page = new Page();
    int pageNum = ((Integer)mp.get("pageNum")).intValue();
    int numPerPage = ((Integer)mp.get("numPerPage")).intValue();
    if (numPerPage > 0) {
      page.setNumPerPage(numPerPage);
    }
    TechnologyDao dao = new TechnologyDaoImpl();
    page.setTotalCount(dao.selectCount());
    if (pageNum > page.getTotalPage()) {
      pageNum = page.getTotalPage();
    }
    int index = (pageNum - 1) * numPerPage;
    int count = numPerPage;
    if (pageNum == 0) {
      index = 0;
      count = page.getNumPerPage();
      mk.put("numPerPage", Integer.valueOf(page.getNumPerPage()));
      mk.put("totalPage", Integer.valueOf(page.getTotalPage()));
      mk.put("totalCount", Integer.valueOf(page.getTotalCount()));
      mk.put("pageNum", Integer.valueOf(page.getPageNum()));
    } else {
      page.setNumPerPage(numPerPage);
      mk.put("numPerPage", Integer.valueOf(numPerPage));
      mk.put("totalPage", Integer.valueOf(page.getTotalPage()));
      mk.put("totalCount", Integer.valueOf(page.getTotalCount()));
      mk.put("pageNum", Integer.valueOf(pageNum));
    }
    mp.put("index", Integer.valueOf(index));
    mp.put("count", Integer.valueOf(count));
    usr = dao.getTechnologys(mp);
    mk.put("list", usr);
    if (pageNum > 1)
      mk.put("flag", Integer.valueOf((pageNum - 1) * numPerPage));
    else {
      mk.put("flag", Integer.valueOf(0));
    }
    return mk;
  }
}