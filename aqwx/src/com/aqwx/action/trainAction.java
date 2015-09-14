package com.aqwx.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.service.siteService;

@ParentPackage("mydefault")
@Namespace("/")
public class trainAction
{
  @Action(value="train", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/train.jsp", type="dispatcher")})
  public String train()
  {
    siteService service = new siteService();
    Map mp = service.getJoinInfo();
    ServletActionContext.getRequest().setAttribute("mp", mp);
    return "success";
  }
}