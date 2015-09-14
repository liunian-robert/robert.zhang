package com.aqwx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aqwx.bean.Page;
import com.aqwx.bean.productClass;
import com.aqwx.data.Dao.ClassDao;
import com.aqwx.data.DaoImpl.ClassDaoImpl;

public class classService
{
  public productClass login(productClass u)
  {
    ClassDao dao = new ClassDaoImpl();
    productClass usr = dao.getProductClass(u);
    return usr;
  }
  public productClass getProductClass(productClass u) {
    ClassDao dao = new ClassDaoImpl();
    productClass usr = dao.getProductClass(u);
    return usr;
  }
  public productClass getProductClassById(productClass u) {
    ClassDao dao = new ClassDaoImpl();
    productClass usr = dao.getProductClassById(u);
    return usr;
  }
  public boolean modify(productClass u) {
    ClassDao dao = new ClassDaoImpl();
    dao.update(u);
    return true;
  }
  public boolean delete(productClass u) {
    ClassDao dao = new ClassDaoImpl();
    dao.delete(u);
    return true;
  }
  public boolean addProductClass(productClass u) {
    ClassDao dao = new ClassDaoImpl();
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
    ClassDao dao = new ClassDaoImpl();
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
    usr = dao.getProductClasss(mp);
    if (pageNum > 1)
      mk.put("flag", Integer.valueOf((pageNum - 1) * numPerPage));
    else {
      mk.put("flag", Integer.valueOf(0));
    }
    mk.put("list", usr);
    return mk;
  }
}