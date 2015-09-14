package com.aqwx.manage.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.news;
import com.aqwx.service.newsService;
import com.aqwx.util.Utils;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("manage")
@Namespace("/news")
public class newsAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  private int pageNum;
  private int numPerPage;
  private String id;
  private String name;
  private String image;
  private String date;
  private String content;
  private File fm;
  private String fmContentType;
  private String fmFileName;
  private String img;
  private final news nw = new news();

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

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
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

  @Action(value="/news/addView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/news/addNews.jsp", type="dispatcher")})
  public String addView()
  {
    return "SUCCESS";
  }

  @Action(value="/news/addNews", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String addNews()
  {
    newsService service = new newsService();
    this.nw.setId(Utils.getRandomString());
    this.nw.setName(this.name);
    this.nw.setContent(this.content);
    this.nw.setDate(this.date);
    if ((this.fm != null) && (this.fm.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/images/news") +
        "/";
      String filename = Utils.getImageString(this.fmFileName);
      Utils.write2Image(this.fm, path + filename);
      this.nw.setImage("/images/news/" + filename);
    }
    service.addnews(this.nw);
    return "SUCCESS";
  }

  @Action(value="/news/newsView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/news/newsList.jsp", type="dispatcher")})
  public String managerView()
  {
    Map mp = new HashMap();
    mp.put("pageNum", Integer.valueOf(this.pageNum));
    mp.put("numPerPage", Integer.valueOf(this.numPerPage));
    newsService service = new newsService();
    Map mk = service.getListByPage(mp);
    ServletActionContext.getRequest().setAttribute("mp", mk);

    return "SUCCESS";
  }

  @Action(value="/news/modifyView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/news/modifyView.jsp", type="dispatcher")})
  public String modifyView()
  {
    newsService service = new newsService();
    this.nw.setId(this.id);
    news usr = service.getNewsById(this.nw);
    ServletActionContext.getRequest().setAttribute("news", usr);
    return "SUCCESS";
  }

  @Action(value="/news/update", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String modifyNews()
  {
    newsService service = new newsService();
    this.nw.setId(this.id);
    this.nw.setName(this.name);
    this.nw.setContent(this.content);
    this.nw.setDate(this.date);
    this.nw.setImage(this.image);
    if ((this.fm != null) && (this.fm.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/images/news") +
        "/";
      String iname = this.image.substring(this.image.lastIndexOf("/") + 1, this.image.length());
      Utils.write2Image(this.fm, path + iname);
      this.nw.setImage(this.image);
    }
    service.modify(this.nw);
    return "SUCCESS";
  }

  @Action(value="/news/delete", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String delete()
  {
    newsService service = new newsService();
    this.nw.setId(this.id);
    news ne = service.getNewsById(this.nw);
    String path = ServletActionContext.getServletContext()
      .getRealPath("/images/news") +
      "/";
    String filename = ne.getImage().substring(ne.getImage().lastIndexOf("/") + 1, ne.getImage().length());
    Utils.deleteFile(path, filename);
    service.delete(this.nw);
    return "SUCCESS";
  }

  @Action(value="/news/imageView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/news/image.jsp", type="dispatcher")})
  public String getImage()
  {
    this.nw.setImage(this.image);
    ServletActionContext.getRequest().setAttribute("news", this.nw);
    return "SUCCESS";
  }
}