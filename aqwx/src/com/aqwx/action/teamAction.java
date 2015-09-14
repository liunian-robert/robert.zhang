package com.aqwx.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.team;
import com.aqwx.service.siteService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("mydefault")
@Namespace("/")
public class teamAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;

  @Action(value="team", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/team.jsp", type="dispatcher")})
  public String team()
  {
    siteService service = new siteService();
    String num = ServletActionContext.getRequest().getParameter("pageNum");
    if ((num == null) || (num.equals(""))) {
      num = "1";
    }
    int pageNum = Integer.parseInt(num);
    Map mk = new HashMap();
    mk.put("pageNum", Integer.valueOf(pageNum));
    mk.put("numPerPage", Integer.valueOf(9));
    Map mp = service.getTeamInfo(mk);
    ServletActionContext.getRequest().setAttribute("mp", mp);
    return "success";
  }

  @Action(value="teamDetail", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/jsp/teamDetail.jsp", type="dispatcher")})
  public String newsDetail() {
    String ID = ServletActionContext.getRequest().getParameter("id");
    team nw = new team();
    nw.setId(ID);
    siteService service = new siteService();
    Map mp = service.getTeamDetail(nw);
    ServletActionContext.getRequest().setAttribute("mp", mp);
    return "SUCCESS";
  }
}