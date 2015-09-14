package com.aqwx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aqwx.bean.Page;
import com.aqwx.bean.product;
import com.aqwx.data.Dao.ProductDao;
import com.aqwx.data.DaoImpl.ProductDaoImpl;
import com.aqwx.util.Utils;

public class productService
{
  public Map getProduct(product product)
  {
    ProductDao dao = new ProductDaoImpl();
    Map nw = dao.getProduct(product);
    return nw;
  }
  public product getProductById(product product) {
    ProductDao dao = new ProductDaoImpl();
    product nw = dao.getProductById(product);
    return nw;
  }
  public boolean modify(product product) {
    ProductDao dao = new ProductDaoImpl();
    dao.update(product);
    return true;
  }
  public boolean delete(product product) {
    ProductDao dao = new ProductDaoImpl();
    dao.delete(product);
    return true;
  }
  public boolean addProduct(product product) {
    ProductDao dao = new ProductDaoImpl();
    dao.add(product);
    return true;
  }
  public Map getListByPage(Map mp) {
    List<Map> usr = null;
    Map mk = new HashMap();
    Page page = new Page();
    int pageNum = ((Integer)mp.get("pageNum")).intValue();
    int numPerPage = ((Integer)mp.get("numPerPage")).intValue();
    if (numPerPage > 0) {
      page.setNumPerPage(numPerPage);
    }
    ProductDao dao = new ProductDaoImpl();
    String id = (String)mp.get("id");
    product m = new product();
    if ((!id.equals("")) && (!id.equals("0"))) {
      m.setClass_id(id);
      mk.put("id", id);
    }
    if ((id == null) || (id.equals("")) || (id.equals("0"))) {
      mk.remove("id");
      mp.remove("id");
    }
    page.setTotalCount(dao.selectCount(m));
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
      if (numPerPage > 0) {
        page.setNumPerPage(numPerPage);
      }
      mk.put("numPerPage", Integer.valueOf(numPerPage));
      mk.put("totalPage", Integer.valueOf(page.getTotalPage()));
      mk.put("totalCount", Integer.valueOf(page.getTotalCount()));
      mk.put("pageNum", Integer.valueOf(pageNum));
    }
    mp.put("index", Integer.valueOf(index));
    mp.put("count", Integer.valueOf(count));
    usr = dao.getProduct(mp);
    if (usr.size() > 0) {
      for (Map kn : usr) {
        kn.put("content", Utils.getContent((String)kn.get("content")));
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