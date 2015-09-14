package com.aqwx.manage.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.log;
import com.aqwx.service.logService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("manage")
@Namespace("/log")
public class logAction extends ActionSupport
  implements ModelDriven<log>
{
  private static final long serialVersionUID = 1L;
  private final log u = new log();
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

  @Action(value="/log/logView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/log/log.jsp", type="dispatcher")})
  public String logView()
  {
    Map mp = new HashMap();
    mp.put("pageNum", Integer.valueOf(this.pageNum));
    mp.put("numPerPage", Integer.valueOf(this.numPerPage));
    logService service = new logService();
    Map mk = service.getListByPage(mp);
    ServletActionContext.getRequest().setAttribute("mp", mk);

    return "SUCCESS";
  }

  @Action(value="/log/deleteAll", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String deleteAll()
  {
    logService service = new logService();
    service.deleteAll();
    return "SUCCESS";
  }

  @Action(value="/log/delete", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String delete()
  {
    logService service = new logService();
    service.delete(this.u);
    return "SUCCESS";
  }

  @Override
public log getModel() {
    return this.u;
  }
}