package com.aqwx.manage.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.company;
import com.aqwx.service.companyService;
import com.aqwx.util.Utils;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("manage")
@Namespace("/company")
public class companyAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  private int pageNum;
  private int numPerPage;
  private String id;
  private String name;
  private String logo;
  private String phone;
  private String phone1;
  private String phone2;
  private String qq1;
  private String qq2;
  private String image;
  private String email;
  private String adress;
  private String adress2;
  private String content;
  private File fm;
  private String fmContentType;
  private String fmFileName;
  private File lg;
  private String lgContentType;
  private String lgFileName;
  private final company nw = new company();

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public File getLg() {
    return this.lg;
  }

  public void setLg(File lg) {
    this.lg = lg;
  }

  public String getLgContentType() {
    return this.lgContentType;
  }

  public void setLgContentType(String lgContentType) {
    this.lgContentType = lgContentType;
  }

  public String getLgFileName() {
    return this.lgFileName;
  }

  public void setLgFileName(String lgFileName) {
    this.lgFileName = lgFileName;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent()
  {
    return this.content;
  }

  public String getLogo() {
    return this.logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public String getPhone1() {
    return this.phone1;
  }

  public String getPhone()
  {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setPhone1(String phone1) {
    this.phone1 = phone1;
  }

  public String getPhone2() {
    return this.phone2;
  }

  public void setPhone2(String phone2) {
    this.phone2 = phone2;
  }

  public String getQq1() {
    return this.qq1;
  }

  public void setQq1(String qq1) {
    this.qq1 = qq1;
  }

  public String getQq2() {
    return this.qq2;
  }

  public void setQq2(String qq2) {
    this.qq2 = qq2;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAdress() {
    return this.adress;
  }

  public String getAdress2()
  {
    return this.adress2;
  }

  public void setAdress2(String adress2) {
    this.adress2 = adress2;
  }

  public void setAdress(String adress) {
    this.adress = adress;
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

  @Action(value="/company/companyView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/company/company.jsp", type="dispatcher")})
  public String managerView()
  {
    Map mp = new HashMap();
    mp.put("pageNum", Integer.valueOf(this.pageNum));
    mp.put("numPerPage", Integer.valueOf(this.numPerPage));
    companyService service = new companyService();
    Map mk = service.getListByPage(mp);
    ServletActionContext.getRequest().setAttribute("mp", mk);

    return "SUCCESS";
  }

  @Action(value="/company/modifyView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/company/modifyView.jsp", type="dispatcher")})
  public String modifyView()
  {
    companyService service = new companyService();
    this.nw.setId(this.id);
    company usr = service.getCompanyById(this.nw);
    ServletActionContext.getRequest().setAttribute("company", usr);
    return "SUCCESS";
  }

  @Action(value="/company/update", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String modifycompany()
  {
    companyService service = new companyService();
    this.nw.setId(this.id);
    this.nw.setName(this.name);
    this.nw.setLogo(this.logo);
    this.nw.setAdress(this.adress);
    this.nw.setAdress2(this.adress2);
    this.nw.setEmail(this.email);
    this.nw.setQq1(this.qq1);
    this.nw.setQq2(this.qq2);
    this.nw.setPhone(this.phone);
    this.nw.setPhone1(this.phone1);
    this.nw.setPhone2(this.phone2);
    this.nw.setContent(this.content);
    this.nw.setImage(this.image);
    if ((this.fm != null) && (this.fm.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/images/company") +
        "/";
      String iname = "";
      if ((this.image != null) && (!this.image.endsWith(""))) {
        iname = this.image.substring(this.image.lastIndexOf("/") + 1, this.image.length());
      }
      else {
        iname = Utils.getImageString(this.fmFileName);
        this.image = ("/images/company/" + iname);
      }
      Utils.write2Image(this.fm, path + iname);
      this.nw.setImage(this.image);
    }
    if ((this.lg != null) && (this.lg.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/images/company") +
        "/";
      String iname = "";
      if ((this.logo != null) && (!this.logo.endsWith(""))) {
        iname = this.logo.substring(this.logo.lastIndexOf("/") + 1, this.logo.length());
      }
      else {
        iname = Utils.getImageString(this.fmFileName);
        this.logo = ("/images/company/" + iname);
      }
      Utils.write2Image(this.lg, path + iname);
      this.nw.setLogo(this.logo);
    }
    service.modify(this.nw);
    return "SUCCESS";
  }

  @Action(value="/company/imageView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/company/image.jsp", type="dispatcher"), @org.apache.struts2.convention.annotation.Result(name="SUCCESS2", location="/manage/jsp/image.jsp", type="dispatcher")})
  public String getImage()
  {
    this.nw.setImage(this.image);
    ServletActionContext.getRequest().setAttribute("company", this.nw);
    String flag = ServletActionContext.getRequest().getParameter("flag");
    if ((flag != null) && (flag.equals("company"))) {
      return "SUCCESS2";
    }
    return "SUCCESS";
  }
}