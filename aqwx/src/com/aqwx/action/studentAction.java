package com.aqwx.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.student;
import com.aqwx.service.siteService;

@ParentPackage("mydefault")
@Namespace("/")
public class studentAction
{
  @Action(value="student", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/jsp/student.jsp", type="dispatcher")})
  public String about()
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
    Map mp = service.getStudentInfo(mk);
    ServletActionContext.getRequest().setAttribute("mp", mp);
    return "success";
  }

  @Action(value="studentDetail", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/jsp/studentDetail.jsp", type="dispatcher")})
  public String newsDetail() {
    String ID = ServletActionContext.getRequest().getParameter("id");
    student nw = new student();
    nw.setId(ID);
    siteService service = new siteService();
    Map mp = service.getStudentDetail(nw);
    ServletActionContext.getRequest().setAttribute("mp", mp);
    return "SUCCESS";
  }
}