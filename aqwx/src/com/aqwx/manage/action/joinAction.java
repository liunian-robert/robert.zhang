package com.aqwx.manage.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.join;
import com.aqwx.service.joinService;
import com.aqwx.util.Utils;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("manage")
@Namespace("/join")
public class joinAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  private int pageNum;
  private int numPerPage;
  private String id;
  private String image;
  private String content;
  private File fm;
  private String fmContentType;
  private String fmFileName;
  private final join nw = new join();

  public String getId()
  {
    return this.id;
  }
  public void setId(String id) {
    this.id = id;
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

  @Action(value="/join/addView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/join/addJoin.jsp", type="dispatcher")})
  public String addView()
  {
    return "SUCCESS";
  }

  @Action(value="/join/addJoin", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String addjoin()
  {
    joinService service = new joinService();
    this.nw.setId(Utils.getRandomString());
    this.nw.setContent(this.content);
    if ((this.fm != null) && (this.fm.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/images/join") +
        "/";
      String filename = Utils.getImageString(this.fmFileName);
      Utils.write2Image(this.fm, path + filename);
      this.nw.setImage("/images/join/" + filename);
    }
    service.addJoin(this.nw);
    return "SUCCESS";
  }

  @Action(value="/join/joinView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/join/joinList.jsp", type="dispatcher")})
  public String managerView()
  {
    Map mp = new HashMap();
    mp.put("pageNum", Integer.valueOf(this.pageNum));
    mp.put("numPerPage", Integer.valueOf(this.numPerPage));
    joinService service = new joinService();
    Map mk = service.getListByPage(mp);
    ServletActionContext.getRequest().setAttribute("mp", mk);

    return "SUCCESS";
  }

  @Action(value="/join/modifyView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/join/modifyView.jsp", type="dispatcher")})
  public String modifyView()
  {
    joinService service = new joinService();
    this.nw.setId(this.id);
    join usr = service.getJoinById(this.nw);
    ServletActionContext.getRequest().setAttribute("join", usr);
    return "SUCCESS";
  }

  @Action(value="/join/update", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String modifyjoin()
  {
    joinService service = new joinService();
    this.nw.setId(this.id);
    this.nw.setContent(this.content);
    this.nw.setImage(this.image);
    if ((this.fm != null) && (this.fm.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/images/join") +
        "/";
      String iname = "";
      if ((this.image != null) && (!this.image.endsWith(""))) {
        iname = this.image.substring(this.image.lastIndexOf("/") + 1, this.image.length());
      }
      else {
        iname = Utils.getImageString(this.fmFileName);
        this.image = ("/images/join/" + iname);
      }
      Utils.write2Image(this.fm, path + iname);
      this.nw.setImage(this.image);
    }
    service.modify(this.nw);
    return "SUCCESS";
  }

  @Action(value="/join/delete", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String delete()
  {
    joinService service = new joinService();
    this.nw.setId(this.id);
    service.delete(this.nw);
    return "SUCCESS";
  }

  @Action(value="/join/imageView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/join/image.jsp", type="dispatcher")})
  public String getImage()
  {
    this.nw.setImage(this.image);
    ServletActionContext.getRequest().setAttribute("join", this.nw);
    return "SUCCESS";
  }
}