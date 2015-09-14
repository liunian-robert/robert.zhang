package com.aqwx.manage.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.user;
import com.aqwx.service.manageService;
import com.aqwx.util.BASE64;
import com.aqwx.util.Utils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("manage")
@Namespace("/manage")
public class manageAction extends ActionSupport
  implements ModelDriven<user>
{
  private static final long serialVersionUID = 1L;
  private final user u = new user();
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

  @Action(value="/manage/exit", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/system/login.jsp", type="dispatcher")})
  public String exit()
  {
    ServletActionContext.getRequest().getSession().invalidate();
    return "SUCCESS";
  }

  @Action(value="/manage/addView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/system/addUser.jsp", type="dispatcher")})
  public String addView()
  {
    return "SUCCESS";
  }

  @Action(value="/manage/addUser", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String addUser()
  {
    manageService service = new manageService();
    this.u.setId(Utils.getRandomString());
    this.u.setPassword(BASE64.encode(this.u.getPassword()));
    service.addUser(this.u);
    return "SUCCESS";
  }

  @Action(value="/manage/managerView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/system/managerList.jsp", type="dispatcher")})
  public String managerView()
  {
    Map mp = new HashMap();
    mp.put("pageNum", Integer.valueOf(this.pageNum));
    mp.put("numPerPage", Integer.valueOf(this.numPerPage));
    manageService service = new manageService();
    Map mk = service.getListByPage(mp);
    ServletActionContext.getRequest().setAttribute("mp", mk);

    return "SUCCESS";
  }

  @Action(value="/manage/modifyView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/system/modifyView.jsp", type="dispatcher")})
  public String modifyView()
  {
    manageService service = new manageService();
    user usr = service.getUserById(this.u);
    ServletActionContext.getRequest().setAttribute("user", usr);
    return "SUCCESS";
  }

  @Action(value="/manage/modifyPassword", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String modifyPassword()
  {
    manageService service = new manageService();
    this.u.setPassword(BASE64.encode(this.u.getPassword()));
    service.modify(this.u);
    return "SUCCESS";
  }

  @Action(value="/manage/delete", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String delete()
  {
    manageService service = new manageService();
    service.delete(this.u);
    return "SUCCESS";
  }

  @Action(value="/manage/saveDatabase", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String saveDatabase()
  {
    if (Utils.saveDatabase())
      ServletActionContext.getRequest().setAttribute("save_status", "success");
    else {
      ServletActionContext.getRequest().setAttribute("save_status", "error");
    }
    return "SUCCESS";
  }

  @Override
public user getModel() {
    return this.u;
  }
}