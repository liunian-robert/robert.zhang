package com.aqwx.manage.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.company;
import com.aqwx.bean.log;
import com.aqwx.bean.user;
import com.aqwx.service.companyService;
import com.aqwx.service.logService;
import com.aqwx.service.manageService;
import com.aqwx.util.BASE64;
import com.aqwx.util.Utils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("login")
@Namespace("/manage")
public class loginAction extends ActionSupport
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

  @Action(value="/manage/", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/manage/jsp/system/login.jsp", type="dispatcher")})
  public String manage()
  {
    return "success";
  }

  @Action(value="/manage/login", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/main.jsp", type="dispatcher"), @org.apache.struts2.convention.annotation.Result(name="relogin", location="/manage/jsp/AjaxDone.html", type="dispatcher")})
  public String login()
  {
    manageService service = new manageService();
    companyService cservice = new companyService();
    company s = new company();
    s.setId("1");
    company cp = cservice.getCompanyById(s);
    cp.setContent(Utils.getContent(cp.getContent()));
    this.u.setPassword(BASE64.encode(this.u.getPassword()));
    String date = Utils.getCurrentDate();
    String week = Utils.getWeek();
    log lg = new log();
    user usr = service.login(this.u);
    lg.setId(Utils.getRandomString());
    lg.setName(this.u.getName());
    lg.setPassword(this.u.getPassword());
    lg.setDate(Utils.getDate());
    lg.setIP(ServletActionContext.getRequest().getRemoteAddr());
    logService ls = new logService();
    if (usr != null) {
      lg.setStatus("登陆成功!");
      ls.addlog(lg);
      ServletActionContext.getRequest().getSession().setMaxInactiveInterval(86400);
      ServletActionContext.getRequest().getSession()
        .setAttribute("user", usr);
      ServletActionContext.getRequest().getSession()
        .setAttribute("company", cp);
      ServletActionContext.getRequest().getSession()
        .setAttribute("date", date);
      ServletActionContext.getRequest().getSession()
        .setAttribute("week", week);
    } else {
      lg.setStatus("用户名或口令错误!");
      ls.addlog(lg);
      ServletActionContext.getRequest().setAttribute("none", "none");
    }
    String method = ServletActionContext.getRequest().getParameter("method");
    if ((method != null) && (method.equals("reLogin"))) {
      return "relogin";
    }
    return "SUCCESS";
  }

  @Override
public user getModel() {
    return this.u;
  }
}