package com.aqwx.manage.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.brochure;
import com.aqwx.service.brochureService;
import com.aqwx.util.Utils;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("manage")
@Namespace("/brochure")
public class brochureAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  private int pageNum;
  private int numPerPage;
  private String id;
  private String name;
  private String image;
  private File fm;
  private String fmContentType;
  private String fmFileName;
  private final brochure nw = new brochure();

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

  public File getFm()
  {
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

  @Action(value="/brochure/addView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/brochure/addBrochure.jsp", type="dispatcher")})
  public String addView()
  {
    return "SUCCESS";
  }

  @Action(value="/brochure/addBrochure", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String addbrochure()
  {
    brochureService service = new brochureService();
    this.nw.setName(this.name);
    this.nw.setId(Utils.getRandomString());
    if ((this.fm != null) && (this.fm.isFile())) {
    String path = ServletActionContext.getServletContext()
            .getRealPath("/images/slideshow") +
             "/";
      String filename = Utils.getImageString(this.fmFileName);
      Utils.write2Image(this.fm, path + filename);
      this.nw.setImage(path + filename);
    }
    service.addbrochure(this.nw);
    return "SUCCESS";
  }

  @Action(value="/brochure/brochureView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/brochure/brochureList.jsp", type="dispatcher")})
  public String managerView()
  {
    Map mp = new HashMap();
    mp.put("pageNum", Integer.valueOf(this.pageNum));
    mp.put("numPerPage", Integer.valueOf(this.numPerPage));
    brochureService service = new brochureService();
    Map mk = service.getListByPage(mp);
    ServletActionContext.getRequest().setAttribute("mp", mk);

    return "SUCCESS";
  }

  @Action(value="/brochure/modifyView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/brochure/modifyView.jsp", type="dispatcher")})
  public String modifyView()
  {
    brochureService service = new brochureService();
    this.nw.setId(this.id);
    brochure usr = service.getbrochureById(this.nw);
    ServletActionContext.getRequest().setAttribute("brochure", usr);
    return "SUCCESS";
  }

  @Action(value="/brochure/update", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String modifybrochure()
  {
    brochureService service = new brochureService();
    this.nw.setId(this.id);
    this.nw.setName(this.name);
    this.nw.setImage(this.image);
    if ((this.fm != null) && (this.fm.isFile())) {
        String path = ServletActionContext.getServletContext()
                   .getRealPath("/images/slideshow") +
                   "/";
      String iname = this.image.substring(this.image.lastIndexOf("/") + 1, this.image.length());
      Utils.write2Image(this.fm, path + iname);
      this.nw.setImage("/images/slideshow/"+iname);
    }
    service.modify(this.nw);
    return "SUCCESS";
  }

  @Action(value="/brochure/delete", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String delete()
  {
    brochureService service = new brochureService();
    this.nw.setId(this.id);
    brochure br = service.getbrochureById(this.nw);
    String ms = br.getImage().substring(br.getImage().lastIndexOf("/") + 1, br.getImage().length());
    String path = ServletActionContext.getServletContext()
            .getRealPath("/images/slideshow") +
            "/";
    Utils.deleteFile(path, ms);
    service.delete(this.nw);
    return "SUCCESS";
  }

  @Action(value="/brochure/imageView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/brochure/image.jsp", type="dispatcher")})
  public String getImage()
  {
    this.nw.setImage(this.image);
    ServletActionContext.getRequest().setAttribute("brochure", this.nw);
    return "SUCCESS";
  }
}