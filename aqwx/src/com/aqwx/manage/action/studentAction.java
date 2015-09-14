package com.aqwx.manage.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.student;
import com.aqwx.service.studentService;
import com.aqwx.util.Utils;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("manage")
@Namespace("/student")
public class studentAction extends ActionSupport
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
  private final student nw = new student();

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

  @Action(value="/student/addView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/student/addStudent.jsp", type="dispatcher")})
  public String addView()
  {
    return "SUCCESS";
  }

  @Action(value="/student/addStudent", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String addstudent()
  {
    studentService service = new studentService();
    this.nw.setId(Utils.getRandomString());
    this.nw.setName(this.name);
    this.nw.setContent(this.content);
    if ((this.fm != null) && (this.fm.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/images/student") +
        "/";
      String filename = Utils.getImageString(this.fmFileName);
      Utils.write2Image(this.fm, path + filename);
      this.nw.setImage("/images/student/" + filename);
    }
    service.addstudent(this.nw);
    return "SUCCESS";
  }

  @Action(value="/student/studentView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/student/studentList.jsp", type="dispatcher")})
  public String managerView()
  {
    Map mp = new HashMap();
    mp.put("pageNum", Integer.valueOf(this.pageNum));
    mp.put("numPerPage", Integer.valueOf(this.numPerPage));
    studentService service = new studentService();
    Map mk = service.getListByPage(mp);
    ServletActionContext.getRequest().setAttribute("mp", mk);

    return "SUCCESS";
  }

  @Action(value="/student/modifyView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/student/modifyView.jsp", type="dispatcher")})
  public String modifyView()
  {
    studentService service = new studentService();
    this.nw.setId(this.id);
    student usr = service.getstudentById(this.nw);
    ServletActionContext.getRequest().setAttribute("student", usr);
    return "SUCCESS";
  }

  @Action(value="/student/update", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String modifystudent()
  {
    studentService service = new studentService();
    this.nw.setId(this.id);
    this.nw.setName(this.name);
    this.nw.setContent(this.content);
    this.nw.setImage(this.image);
    if ((this.fm != null) && (this.fm.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/images/student") +
        "/";
      String iname = this.image.substring(this.image.lastIndexOf("/") + 1, this.image.length());
      Utils.write2Image(this.fm, path + iname);
      this.nw.setImage(this.image);
    }
    service.modify(this.nw);
    return "SUCCESS";
  }

  @Action(value="/student/delete", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String delete()
  {
    studentService service = new studentService();
    this.nw.setId(this.id);
    student st = service.getstudentById(this.nw);
    String filename = st.getImage().substring(st.getImage().lastIndexOf("/") + 1, st.getImage().length());
    String path = ServletActionContext.getServletContext()
      .getRealPath("/images/student") +
      "/";
    Utils.deleteFile(path, filename);
    service.delete(this.nw);
    return "SUCCESS";
  }

  @Action(value="/student/imageView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/student/image.jsp", type="dispatcher")})
  public String getImage()
  {
    this.nw.setImage(this.image);
    ServletActionContext.getRequest().setAttribute("student", this.nw);
    return "SUCCESS";
  }
}