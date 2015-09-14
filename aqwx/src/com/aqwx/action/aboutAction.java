package com.aqwx.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.service.siteService;

@ParentPackage("mydefault")
@Namespace("/")
public class aboutAction
{
  @Action(value="about", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/about_us.jsp", type="dispatcher")})
  public String about()
  {
    siteService service = new siteService();
    Map mp = service.getAllInfo();
    ServletActionContext.getRequest().setAttribute("mp", mp);
    return "success";
  }

  @Action(value="connect", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/connect.jsp", type="dispatcher")})
  public String connect() {
    siteService service = new siteService();
    Map mp = service.getAllInfo();
    ServletActionContext.getRequest().setAttribute("mp", mp);
    return "success";
  }
}