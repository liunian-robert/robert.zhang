package com.aqwx.manage.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.productClass;
import com.aqwx.service.classService;
import com.aqwx.util.Utils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("manage")
@Namespace("/class")
public class classAction extends ActionSupport
  implements ModelDriven<productClass>
{
  private static final long serialVersionUID = 1L;
  private final productClass u = new productClass();
  private int pageNum;
  private int numPerPage;

  public int getPageNum()
  {
    return this.pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }

  public int getNumPerPage() {
    return this.numPerPage;
  }

  public void setNumPerPage(int numPerPage) {
    this.numPerPage = numPerPage;
  }

  @Action(value="/class/addView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/productClass/addClass.jsp", type="dispatcher")})
  public String addView()
  {
    return "SUCCESS";
  }

  @Action(value="/class/addClass", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String addProductClass()
  {
    classService service = new classService();
    this.u.setId(Utils.getRandomString());
    service.addProductClass(this.u);
    return "SUCCESS";
  }

  @Action(value="/class/classView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/productClass/classList.jsp", type="dispatcher"), @org.apache.struts2.convention.annotation.Result(name="suggest", location="/manage/jsp/productClass/selectClass.jsp", type="dispatcher")})
  public String classView()
  {
    String m = ServletActionContext.getRequest().getParameter("method");
    Map mp = new HashMap();
    mp.put("pageNum", Integer.valueOf(this.pageNum));
    mp.put("numPerPage", Integer.valueOf(this.numPerPage));
    classService service = new classService();
    Map mk = service.getListByPage(mp);
    ServletActionContext.getRequest().setAttribute("mp", mk);

    if ((m != null) && (m.equals("suggest"))) {
      return "suggest";
    }
    return "SUCCESS";
  }

  @Action(value="/class/modifyView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/productClass/modifyView.jsp", type="dispatcher")})
  public String modifyView()
  {
    classService service = new classService();
    productClass usr = service.getProductClassById(this.u);
    ServletActionContext.getRequest().setAttribute("productClass", usr);
    return "SUCCESS";
  }

  @Action(value="/class/modify", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String modifyClass()
  {
    classService service = new classService();
    service.modify(this.u);
    return "SUCCESS";
  }

  @Action(value="/class/delete", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String delete()
  {
    classService service = new classService();
    service.delete(this.u);
    return "SUCCESS";
  }

  @Override
public productClass getModel() {
    return this.u;
  }
}