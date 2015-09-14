package com.aqwx.manage.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.link;
import com.aqwx.service.linkService;
import com.aqwx.util.Utils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("manage")
@Namespace("/link")
public class linkAction extends ActionSupport
  implements ModelDriven<link>
{
  private static final long serialVersionUID = 1L;
  private final link u = new link();
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

  @Action(value="/link/addView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/link/addLink.jsp", type="dispatcher")})
  public String addView()
  {
    return "SUCCESS";
  }

  @Action(value="/link/addLink", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String addlink()
  {
    linkService service = new linkService();
    this.u.setId(Utils.getRandomString());
    service.addLink(this.u);
    return "SUCCESS";
  }

  @Action(value="/link/linkView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/link/linkList.jsp", type="dispatcher")})
  public String classrView()
  {
    Map mp = new HashMap();
    mp.put("pageNum", Integer.valueOf(this.pageNum));
    mp.put("numPerPage", Integer.valueOf(this.numPerPage));
    linkService service = new linkService();
    Map mk = service.getListByPage(mp);
    ServletActionContext.getRequest().setAttribute("mp", mk);

    return "SUCCESS";
  }

  @Action(value="/link/modifyView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/link/modifyView.jsp", type="dispatcher")})
  public String modifyView()
  {
    linkService service = new linkService();
    link usr = service.getlinkById(this.u);
    ServletActionContext.getRequest().setAttribute("link", usr);
    return "SUCCESS";
  }

  @Action(value="/link/modify", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String modifyClass()
  {
    linkService service = new linkService();
    service.modify(this.u);
    return "SUCCESS";
  }

  @Action(value="/link/delete", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String delete()
  {
    linkService service = new linkService();
    service.delete(this.u);
    return "SUCCESS";
  }

  @Override
public link getModel() {
    return this.u;
  }
}