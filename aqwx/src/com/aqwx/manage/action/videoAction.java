package com.aqwx.manage.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.company;
import com.aqwx.bean.movie;
import com.aqwx.service.companyService;
import com.aqwx.service.movieService;
import com.aqwx.util.Utils;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("manage")
@Namespace("/movie")
public class videoAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  private int pageNum;
  private int numPerPage;
  private String id;
  private String name;
  private String movie;
  private File fm;
  private String fmContentType;
  private String fmFileName;
  private final movie nw = new movie();

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

  public void setMovie(String movie) {
    this.movie = movie;
  }

  @Action(value="/movie/addView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/movie/addMovie.jsp", type="dispatcher")})
  public String addView()
  {
    return "SUCCESS";
  }

  @Action(value="/movie/addMovie", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String addmovie()
  {
    movieService service = new movieService();
    this.nw.setId(Utils.getRandomString());
    this.nw.setName(this.name);
    this.nw.setFormat(this.fmContentType);
    if ((this.fm != null) && (this.fm.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/video") +
        "/";
      String filename = Utils.getImageString(this.fmFileName);
      Utils.write2Image(this.fm, path + filename);
      this.nw.setMovie("/video/" + filename);
    }
    service.addmovie(this.nw);
    return "SUCCESS";
  }

  @Action(value="/movie/movieView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/movie/movieList.jsp", type="dispatcher")})
  public String managerView()
  {
    Map mp = new HashMap();
    mp.put("pageNum", Integer.valueOf(this.pageNum));
    mp.put("numPerPage", Integer.valueOf(this.numPerPage));
    movieService service = new movieService();
    Map mk = service.getListByPage(mp);
    ServletActionContext.getRequest().setAttribute("mp", mk);

    return "SUCCESS";
  }

  @Action(value="/movie/modifyView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/movie/modifyView.jsp", type="dispatcher")})
  public String modifyView()
  {
    movieService service = new movieService();
    this.nw.setId(this.id);
    movie usr = service.getMovieById(this.nw);
    ServletActionContext.getRequest().setAttribute("movie", usr);
    return "SUCCESS";
  }

  @Action(value="/movie/modify", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String modifyMovie()
  {
    movieService service = new movieService();
    this.nw.setId(this.id);
    this.nw.setName(this.name);
    this.nw.setFormat(this.fmContentType);
    if ((this.fm != null) && (this.fm.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/video") +
        "/";
      String iname = this.movie.substring(this.movie.lastIndexOf("/") + 1, this.movie.length());
      Utils.write2Image(this.fm, path + iname);
      this.nw.setMovie(this.movie);
    }
    service.modify(this.nw);
    return "SUCCESS";
  }

  @Action(value="/movie/delete", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String delete()
  {
    movieService service = new movieService();
    this.nw.setId(this.id);
    String path = ServletActionContext.getServletContext()
      .getRealPath("/video") +
      "/";
    movie mv = service.getMovieById(this.nw);
    String filename = mv.getMovie().substring(mv.getMovie().lastIndexOf("/") + 1, mv.getMovie().length());
    Utils.deleteFile(path, filename);
    service.delete(this.nw);
    return "SUCCESS";
  }

  @Action(value="/movie/seeVideo", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/movie/video.jsp", type="dispatcher")})
  public String getMovie()
  {
    this.nw.setMovie(this.movie);
    ServletActionContext.getRequest().setAttribute("movie", this.nw);
    return "SUCCESS";
  }

  @Action(value="/movie/setDefault", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String setDefault()
  {
    movieService movice = new movieService();
    movie mv = new movie();
    mv.setId(this.id);
    movie mc = movice.getMovieById(mv);
    companyService service = new companyService();
    company cp = new company();
    cp.setId("1");
    cp.setMovie(mc.getMovie());
    service.updateMovie(cp);
    return "SUCCESS";
  }
}