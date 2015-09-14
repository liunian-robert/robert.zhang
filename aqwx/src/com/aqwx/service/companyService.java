package com.aqwx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aqwx.bean.Page;
import com.aqwx.bean.company;
import com.aqwx.data.Dao.CompanyDao;
import com.aqwx.data.DaoImpl.CompanyDaoImpl;

public class companyService
{
  public company getCompany(company company)
  {
    CompanyDao dao = new CompanyDaoImpl();
    company nw = dao.getCompany(company);
    return nw;
  }
  public boolean updateMovie(company cp) {
    CompanyDao dao = new CompanyDaoImpl();
    dao.updateMovie(cp);
    return true;
  }
  public company getCompanyById(company company) {
    CompanyDao dao = new CompanyDaoImpl();
    company nw = dao.getCompanyById(company);
    return nw;
  }
  public boolean modify(company company) {
    CompanyDao dao = new CompanyDaoImpl();
    dao.update(company);
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
    CompanyDao dao = new CompanyDaoImpl();
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
    usr = dao.getCompany(mp);
    mk.put("list", usr);
    return mk;
  }
}