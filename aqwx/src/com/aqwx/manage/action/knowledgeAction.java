package com.aqwx.manage.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.knowledge;
import com.aqwx.service.knowledgeService;
import com.aqwx.util.Utils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("manage")
@Namespace("/knowledge")
public class knowledgeAction extends ActionSupport
  implements ModelDriven<knowledge>
{
  private static final long serialVersionUID = 1L;
  private final knowledge u = new knowledge();
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

  @Action(value="/knowledge/addView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/knowledge/addKnowledge.jsp", type="dispatcher")})
  public String addView()
  {
    return "SUCCESS";
  }

  @Action(value="/knowledge/addKnowledge", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String addProductknowledge()
  {
    knowledgeService service = new knowledgeService();
    this.u.setId(Utils.getRandomString());
    service.addKnowledge(this.u);
    return "SUCCESS";
  }

  @Action(value="/knowledge/knowledgeView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/knowledge/knowledgeList.jsp", type="dispatcher")})
  public String knowledgerView()
  {
    Map mp = new HashMap();
    mp.put("pageNum", Integer.valueOf(this.pageNum));
    mp.put("numPerPage", Integer.valueOf(this.numPerPage));
    knowledgeService service = new knowledgeService();
    Map mk = service.getListByPage(mp);
    ServletActionContext.getRequest().setAttribute("mp", mk);

    return "SUCCESS";
  }

  @Action(value="/knowledge/modifyView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/knowledge/modifyView.jsp", type="dispatcher")})
  public String modifyView()
  {
    knowledgeService service = new knowledgeService();
    knowledge usr = service.getKnowledgeById(this.u);
    ServletActionContext.getRequest().setAttribute("knowledge", usr);
    return "SUCCESS";
  }

  @Action(value="/knowledge/update", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String modifyknowledge()
  {
    knowledgeService service = new knowledgeService();
    service.modify(this.u);
    return "SUCCESS";
  }

  @Action(value="/knowledge/delete", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String delete()
  {
    knowledgeService service = new knowledgeService();
    service.delete(this.u);
    return "SUCCESS";
  }

  @Override
public knowledge getModel() {
    return this.u;
  }
}