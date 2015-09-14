package com.aqwx.manage.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.team;
import com.aqwx.service.teamService;
import com.aqwx.util.Utils;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("manage")
@Namespace("/team")
public class teamAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  private int pageNum;
  private int numPerPage;
  private String id;
  private String name;
  private String image;
  private String content;
  private File fm;
  private String fmContentType;
  private String fmFileName;
  private final team nw = new team();

  public String getId()
  {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return this.content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public void setImage(String image) {
    this.image = image;
  }
  public int getPageNum() {
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
  public File getFm() {
    return this.fm;
  }

  public void setFm(File fm) {
    this.fm = fm;
  }

  public String getFmContentType() {
    return this.fmContentType;
  }

  public void setFmContentType(String fmContentType) {
    this.fmContentType = fmContentType;
  }

  public String getFmFileName() {
    return this.fmFileName;
  }

  public void setFmFileName(String fmFileName) {
    this.fmFileName = fmFileName;
  }

  @Action(value="/team/addView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/team/addTeam.jsp", type="dispatcher")})
  public String addView()
  {
    return "SUCCESS";
  }

  @Action(value="/team/addTeam", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String addTeam()
  {
    teamService service = new teamService();
    this.nw.setId(Utils.getRandomString());
    this.nw.setName(this.name);
    this.nw.setContent(this.content);
    if ((this.fm != null) && (this.fm.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/images/team") +
        "/";
      String filename = Utils.getImageString(this.fmFileName);
      Utils.write2Image(this.fm, path + filename);
      this.nw.setImage("/images/team/" + filename);
    }
    service.addTeam(this.nw);
    return "SUCCESS";
  }

  @Action(value="/team/teamView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/team/teamList.jsp", type="dispatcher")})
  public String managerView()
  {
    Map mp = new HashMap();
    mp.put("pageNum", Integer.valueOf(this.pageNum));
    mp.put("numPerPage", Integer.valueOf(this.numPerPage));
    teamService service = new teamService();
    Map mk = service.getListByPage(mp);
    ServletActionContext.getRequest().setAttribute("mp", mk);

    return "SUCCESS";
  }

  @Action(value="/team/modifyView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/team/modifyView.jsp", type="dispatcher")})
  public String modifyView()
  {
    teamService service = new teamService();
    this.nw.setId(this.id);
    team usr = service.getTeamById(this.nw);
    ServletActionContext.getRequest().setAttribute("team", usr);
    return "SUCCESS";
  }

  @Action(value="/team/update", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String modifyteam()
  {
    teamService service = new teamService();
    this.nw.setId(this.id);
    this.nw.setName(this.name);
    this.nw.setContent(this.content);
    this.nw.setImage(this.image);
    if ((this.fm != null) && (this.fm.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/images/team") +
        "/";
      String iname = this.image.substring(this.image.lastIndexOf("/") + 1, this.image.length());
      Utils.write2Image(this.fm, path + iname);
      this.nw.setImage(this.image);
    }
    service.modify(this.nw);
    return "SUCCESS";
  }

  @Action(value="/team/delete", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String delete()
  {
    teamService service = new teamService();
    this.nw.setId(this.id);
    team te = service.getTeamById(this.nw);
    String path = ServletActionContext.getServletContext()
      .getRealPath("/images/team") +
      "/";
    String filename = te.getImage().substring(te.getImage().lastIndexOf("/") + 1, te.getImage().length());
    Utils.deleteFile(path, filename);
    service.delete(this.nw);
    return "SUCCESS";
  }

  @Action(value="/team/imageView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/team/image.jsp", type="dispatcher")})
  public String getImage()
  {
    this.nw.setImage(this.image);
    ServletActionContext.getRequest().setAttribute("team", this.nw);
    return "SUCCESS";
  }
}