package com.aqwx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aqwx.bean.Page;
import com.aqwx.bean.student;
import com.aqwx.data.Dao.StudentDao;
import com.aqwx.data.DaoImpl.StudentDaoImpl;
import com.aqwx.util.Utils;

public class studentService
{
  public student login(student u)
  {
    StudentDao dao = new StudentDaoImpl();
    student usr = dao.getStudent(u);
    return usr;
  }
  public student getstudent(student u) {
    StudentDao dao = new StudentDaoImpl();
    student usr = dao.getStudent(u);
    return usr;
  }
  public student getstudentById(student u) {
    StudentDao dao = new StudentDaoImpl();
    student usr = dao.getStudentById(u);
    return usr;
  }
  public boolean modify(student u) {
    StudentDao dao = new StudentDaoImpl();
    dao.update(u);
    return true;
  }
  public boolean delete(student u) {
    StudentDao dao = new StudentDaoImpl();
    dao.delete(u);
    return true;
  }
  public boolean addstudent(student u) {
    StudentDao dao = new StudentDaoImpl();
    dao.add(u);
    return true;
  }
  public Map getListByPage(Map mp) {
    List<student> usr = null;
    Map mk = new HashMap();
    Page page = new Page();
    int pageNum = ((Integer)mp.get("pageNum")).intValue();
    int numPerPage = ((Integer)mp.get("numPerPage")).intValue();
    if (numPerPage > 0) {
      page.setNumPerPage(numPerPage);
    }
    StudentDao dao = new StudentDaoImpl();
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
    usr = dao.getStudents(mp);
    if (usr.size() > 0) {
      for (student kn : usr) {
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