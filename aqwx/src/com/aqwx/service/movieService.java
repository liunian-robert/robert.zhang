package com.aqwx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aqwx.bean.Page;
import com.aqwx.bean.movie;
import com.aqwx.data.Dao.MovieDao;
import com.aqwx.data.DaoImpl.MovieDaoImpl;

public class movieService
{
  public movie getmovie(movie u)
  {
    MovieDao dao = new MovieDaoImpl();
    movie usr = dao.getMovie(u);
    return usr;
  }
  public movie getMovieById(movie u) {
    MovieDao dao = new MovieDaoImpl();
    movie usr = dao.getMovieById(u);
    return usr;
  }
  public boolean modify(movie u) {
    MovieDao dao = new MovieDaoImpl();
    dao.update(u);
    return true;
  }
  public boolean delete(movie u) {
    MovieDao dao = new MovieDaoImpl();
    dao.delete(u);
    return true;
  }
  public boolean addmovie(movie u) {
    MovieDao dao = new MovieDaoImpl();
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
    MovieDao dao = new MovieDaoImpl();
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
    usr = dao.getMovies(mp);
    if (pageNum > 1)
      mk.put("flag", Integer.valueOf((pageNum - 1) * numPerPage));
    else {
      mk.put("flag", Integer.valueOf(0));
    }
    mk.put("list", usr);
    return mk;
  }
}