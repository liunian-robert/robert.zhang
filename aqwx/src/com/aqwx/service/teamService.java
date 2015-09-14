package com.aqwx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aqwx.bean.Page;
import com.aqwx.bean.team;
import com.aqwx.data.Dao.TeamDao;
import com.aqwx.data.DaoImpl.TeamDaoImpl;
import com.aqwx.util.Utils;

public class teamService
{
  public team getTeam(team u)
  {
    TeamDao dao = new TeamDaoImpl();
    team usr = dao.getTeam(u);
    return usr;
  }
  public team getTeamById(team u) {
    TeamDao dao = new TeamDaoImpl();
    team usr = dao.getTeamById(u);
    return usr;
  }
  public boolean modify(team u) {
    TeamDao dao = new TeamDaoImpl();
    dao.update(u);
    return true;
  }
  public boolean delete(team u) {
    TeamDao dao = new TeamDaoImpl();
    dao.delete(u);
    return true;
  }
  public boolean addTeam(team u) {
    TeamDao dao = new TeamDaoImpl();
    dao.add(u);
    return true;
  }
  public Map getListByPage(Map mp) {
    List<team> usr = null;
    Map mk = new HashMap();
    Page page = new Page();
    int pageNum = ((Integer)mp.get("pageNum")).intValue();
    int numPerPage = ((Integer)mp.get("numPerPage")).intValue();
    if (numPerPage > 0) {
      page.setNumPerPage(numPerPage);
    }
    TeamDao dao = new TeamDaoImpl();
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
    usr = dao.getTeams(mp);
    if (usr.size() > 0) {
      for (team kn : usr) {
        kn.setContent(Utils.getContent(kn.getContent()));
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