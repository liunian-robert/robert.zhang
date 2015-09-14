package com.aqwx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aqwx.bean.Page;
import com.aqwx.bean.news;
import com.aqwx.data.Dao.NewsDao;
import com.aqwx.data.DaoImpl.NewsDaoImpl;
import com.aqwx.util.Utils;

public class newsService
{
  public news login(news news)
  {
    NewsDao dao = new NewsDaoImpl();
    news nw = dao.getNews(news);
    return news;
  }
  public news getNews(news news) {
    NewsDao dao = new NewsDaoImpl();
    news nw = dao.getNews(news);
    return nw;
  }
  public news getNewsById(news news) {
    NewsDao dao = new NewsDaoImpl();
    news nw = dao.getNewsById(news);
    return nw;
  }
  public boolean modify(news news) {
    NewsDao dao = new NewsDaoImpl();
    dao.update(news);
    return true;
  }
  public boolean delete(news news) {
    NewsDao dao = new NewsDaoImpl();
    dao.delete(news);
    return true;
  }
  public boolean addnews(news news) {
    NewsDao dao = new NewsDaoImpl();
    dao.add(news);
    return true;
  }
  public Map getListByPage(Map mp) {
    List<news> usr = null;
    Map mk = new HashMap();
    Page page = new Page();
    int pageNum = ((Integer)mp.get("pageNum")).intValue();
    int numPerPage = ((Integer)mp.get("numPerPage")).intValue();
    if (numPerPage > 0) {
      page.setNumPerPage(numPerPage);
    }
    NewsDao dao = new NewsDaoImpl();
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
    usr = dao.getNews(mp);
    if (usr.size() > 0) {
      for (news kn : usr) {
        System.out.println(kn.getContent());
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