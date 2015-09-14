package com.aqwx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aqwx.bean.Page;
import com.aqwx.bean.user;
import com.aqwx.data.Dao.UserDao;
import com.aqwx.data.DaoImpl.UserDaoImpl;

public class manageService
{
  public user login(user u)
  {
    UserDao dao = new UserDaoImpl();
    user usr = dao.getUser(u);
    return usr;
  }
  public user getUser(user u) {
    UserDao dao = new UserDaoImpl();
    user usr = dao.getUser(u);
    return usr;
  }
  public user getUserById(user u) {
    UserDao dao = new UserDaoImpl();
    user usr = dao.getUserById(u);
    return usr;
  }
  public boolean modify(user u) {
    UserDao dao = new UserDaoImpl();
    dao.update(u);
    return true;
  }
  public boolean delete(user u) {
    UserDao dao = new UserDaoImpl();
    dao.delete(u);
    return true;
  }
  public boolean addUser(user u) {
    UserDao dao = new UserDaoImpl();
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
    UserDao dao = new UserDaoImpl();
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
    usr = dao.getUsers(mp);
    mk.put("list", usr);
    if (pageNum > 1)
      mk.put("flag", Integer.valueOf((pageNum - 1) * numPerPage));
    else {
      mk.put("flag", Integer.valueOf(0));
    }
    return mk;
  }
}