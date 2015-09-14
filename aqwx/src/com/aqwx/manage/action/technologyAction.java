package com.aqwx.manage.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.technology;
import com.aqwx.service.TechnologyService;
import com.aqwx.util.Utils;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("manage")
@Namespace("/technology")
public class technologyAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  private int pageNum;
  private int numPerPage;
  private String id;
  private String name;
  private String image;
  private String date;
  private File fm;
  private String fmContentType;
  private String fmFileName;
  private String img;
  private final technology nw = new technology();

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

  public String getDate() {
    return this.date;
  }

  public void setDate(String date) {
    this.date = date;
  }
  public void setImage(String image) {
    this.image = image;
  }
  public String getImg() {
    return this.img;
  }
  public void setImg(String img) {
    this.img = img;
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

  @Action(value="/technology/addView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/technology/addTechnology.jsp", type="dispatcher")})
  public String addView()
  {
    return "SUCCESS";
  }

  @Action(value="/technology/addTechnology", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String addtechnology()
  {
    TechnologyService service = new TechnologyService();
    this.nw.setId(Utils.getRandomString());
    this.nw.setName(this.name);
    this.nw.setDate(this.date);
    if ((this.fm != null) && (this.fm.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/images/technology") +
        "/";
      String filename = Utils.getImageString(this.fmFileName);
      Utils.write2Image(this.fm, path + filename);
      this.nw.setImage("/images/technology/" + filename);
    }
    service.addTechnology(this.nw);
    return "SUCCESS";
  }

  @Action(value="/technology/technologyView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/technology/technologyList.jsp", type="dispatcher")})
  public String managerView()
  {
    Map mp = new HashMap();
    mp.put("pageNum", Integer.valueOf(this.pageNum));
    mp.put("numPerPage", Integer.valueOf(this.numPerPage));
    TechnologyService service = new TechnologyService();
    Map mk = service.getListByPage(mp);
    ServletActionContext.getRequest().setAttribute("mp", mk);

    return "SUCCESS";
  }

  @Action(value="/technology/modifyView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/technology/modifyView.jsp", type="dispatcher")})
  public String modifyView()
  {
    TechnologyService service = new TechnologyService();
    this.nw.setId(this.id);
    technology usr = service.getTechnologyById(this.nw);
    ServletActionContext.getRequest().setAttribute("technology", usr);
    return "SUCCESS";
  }

  @Action(value="/technology/update", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String modifytechnology()
  {
    TechnologyService service = new TechnologyService();
    this.nw.setId(this.id);
    this.nw.setName(this.name);
    this.nw.setDate(this.date);
    this.nw.setImage(this.image);
    if ((this.fm != null) && (this.fm.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/images/technology") +
        "/";
      String iname = this.image.substring(this.image.lastIndexOf("/") + 1, this.image.length());
      Utils.write2Image(this.fm, path + iname);
      this.nw.setImage(this.image);
    }
    service.modify(this.nw);
    return "SUCCESS";
  }

  @Action(value="/technology/delete", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String delete()
  {
    TechnologyService service = new TechnologyService();
    this.nw.setId(this.id);
    String path = ServletActionContext.getServletContext()
      .getRealPath("/images/technology") +
      "/";
    technology tc = service.getTechnologyById(this.nw);
    String filename = tc.getImage().substring(tc.getImage().lastIndexOf("/") + 1, tc.getImage().length());
    Utils.deleteFile(path, filename);
    service.delete(this.nw);
    return "SUCCESS";
  }

  @Action(value="/technology/imageView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/technology/image.jsp", type="dispatcher")})
  public String getImage()
  {
    this.nw.setImage(this.image);
    ServletActionContext.getRequest().setAttribute("technology", this.nw);
    return "SUCCESS";
  }
}