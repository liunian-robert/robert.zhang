package com.aqwx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aqwx.bean.Page;
import com.aqwx.bean.log;
import com.aqwx.data.Dao.LogDao;
import com.aqwx.data.DaoImpl.LogDaoImpl;

public class logService
{
  public log getlog(log u)
  {
    LogDao dao = new LogDaoImpl();
    log usr = dao.getLog(u);
    return usr;
  }
  public log getlogById(log u) {
    LogDao dao = new LogDaoImpl();
    log usr = dao.getLogById(u);
    return usr;
  }
  public boolean modify(log u) {
    LogDao dao = new LogDaoImpl();
    dao.update(u);
    return true;
  }
  public boolean delete(log u) {
    LogDao dao = new LogDaoImpl();
    dao.delete(u);
    return true;
  }
  public boolean deleteAll() {
    LogDao dao = new LogDaoImpl();
    dao.deleteAll();
    return true;
  }
  public boolean addlog(log u) {
    LogDao dao = new LogDaoImpl();
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
    LogDao dao = new LogDaoImpl();
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
    usr = dao.getLogs(mp);
    if (pageNum > 1)
      mk.put("flag", Integer.valueOf((pageNum - 1) * numPerPage));
    else {
      mk.put("flag", Integer.valueOf(0));
    }
    mk.put("list", usr);
    return mk;
  }
}