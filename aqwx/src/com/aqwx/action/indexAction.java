package com.aqwx.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.service.siteService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("mydefault")
@Namespace("/")
public class indexAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;

  @Action(value="index", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/index.jsp", type="dispatcher")})
  public String index()
  {
    String path = ServletActionContext.getRequest().getContextPath();
    String basePath = ServletActionContext.getRequest().getScheme() + "://" + ServletActionContext.getRequest().getServerName() + ":" + ServletActionContext.getRequest().getServerPort() + path + "/";
    ServletActionContext.getRequest().getSession().setMaxInactiveInterval(86400);
    ServletActionContext.getRequest().getSession().setAttribute("path", basePath);
    siteService service = new siteService();
    Map mp = service.getInfo();
    ServletActionContext.getRequest().setAttribute("mp", mp);
    return "success";
  }
}