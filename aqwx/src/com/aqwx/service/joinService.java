package com.aqwx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aqwx.bean.Page;
import com.aqwx.bean.join;
import com.aqwx.data.Dao.JoinDao;
import com.aqwx.data.DaoImpl.JoinDaoImpl;
import com.aqwx.util.Utils;

public class joinService
{
  public join getJoin(join u)
  {
    JoinDao dao = new JoinDaoImpl();
    join usr = dao.getJoin(u);
    return usr;
  }
  public join getJoinById(join u) {
    JoinDao dao = new JoinDaoImpl();
    join usr = dao.getJoinById(u);
    return usr;
  }
  public boolean modify(join u) {
    JoinDao dao = new JoinDaoImpl();
    dao.update(u);
    return true;
  }
  public boolean delete(join u) {
    JoinDao dao = new JoinDaoImpl();
    dao.delete(u);
    return true;
  }
  public boolean addJoin(join u) {
    JoinDao dao = new JoinDaoImpl();
    dao.add(u);
    return true;
  }
  public Map getListByPage(Map mp) {
    List<join> usr = null;
    Map mk = new HashMap();
    Page page = new Page();
    int pageNum = ((Integer)mp.get("pageNum")).intValue();
    int numPerPage = ((Integer)mp.get("numPerPage")).intValue();
    if (numPerPage > 0) {
      page.setNumPerPage(numPerPage);
    }
    JoinDao dao = new JoinDaoImpl();
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
    usr = dao.getJoins(mp);
    if (usr.size() > 0) {
      for (join jn : usr) {
        jn.setContent(Utils.getContent(jn.getContent()));
      }
    }
    mk.put("list", usr);
    if (pageNum > 1)
      mk.put("flag", Integer.valueOf((pageNum - 1) * numPerPage));
    else {
      mk.put("flag", Integer.valueOf(0));
    }
    return mk;
  }
}