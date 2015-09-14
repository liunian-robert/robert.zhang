package com.aqwx.manage.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.product;
import com.aqwx.service.productService;
import com.aqwx.util.Utils;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("manage")
@Namespace("/product")
public class productAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  private int pageNum;
  private int numPerPage;
  private String id;
  private String class_id;
  private String name;
  private String image;
  private String content;
  private File fm;
  private String fmContentType;
  private String fmFileName;
  private final product nw = new product();

  public String getId()
  {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getClass_id()
  {
    return this.class_id;
  }

  public void setClass_id(String class_id) {
    this.class_id = class_id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent()
  {
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

  @Action(value="/product/addView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/product/addProduct.jsp", type="dispatcher")})
  public String addView()
  {
    return "SUCCESS";
  }

  @Action(value="/product/addProduct", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String addproduct()
  {
    productService service = new productService();
    HttpServletRequest request = ServletActionContext.getRequest();
    this.nw.setId(Utils.getRandomString());
    this.nw.setName(this.name);
    this.nw.setContent(this.content);
    if ((request.getParameter("product.class_id") != null) && (!request.getParameter("product.class_id").equals(""))) {
      this.nw.setClass_id(request.getParameter("product.class_id").toString().trim());
    }
    if ((this.fm != null) && (this.fm.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/images/product") +
        "/";
      String filename = Utils.getImageString(this.fmFileName);
      Utils.write2Image(this.fm, path + filename);
      this.nw.setImage("/images/product/" + filename);
    }
    service.addProduct(this.nw);
    return "SUCCESS";
  }

  @Action(value="/product/productView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/product/productList.jsp", type="dispatcher")})
  public String managerView()
  {
    Map mp = new HashMap();
    mp.put("pageNum", Integer.valueOf(this.pageNum));
    mp.put("numPerPage", Integer.valueOf(this.numPerPage));
    mp.put("id", "0");
    productService service = new productService();
    Map mk = service.getListByPage(mp);
    ServletActionContext.getRequest().setAttribute("mp", mk);

    return "SUCCESS";
  }

  @Action(value="/product/modifyView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/product/modifyView.jsp", type="dispatcher")})
  public String modifyView()
  {
    productService service = new productService();
    this.nw.setId(this.id);
    Map mp = service.getProduct(this.nw);
    ServletActionContext.getRequest().setAttribute("mp", mp);
    return "SUCCESS";
  }

  @Action(value="/product/update", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/addAjaxDone.html", type="dispatcher")})
  public String modifyproduct()
  {
    productService service = new productService();
    this.nw.setId(this.id);
    this.nw.setName(this.name);
    this.nw.setContent(this.content);
    this.nw.setImage(this.image);
    HttpServletRequest request = ServletActionContext.getRequest();
    if ((request.getParameter("product.class_id") != null) && (!request.getParameter("product.class_id").equals(""))) {
      this.nw.setClass_id(request.getParameter("product.class_id").toString().trim());
    }
    if ((this.fm != null) && (this.fm.isFile())) {
      String path = ServletActionContext.getServletContext()
        .getRealPath("/images/product") +
        "/";
      String iname = this.image.substring(this.image.lastIndexOf("/") + 1, this.image.length());
      Utils.write2Image(this.fm, path + iname);
      this.nw.setImage(this.image);
    }
    service.modify(this.nw);
    return "SUCCESS";
  }

  @Action(value="/product/delete", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/deleteAjaxDone.html", type="dispatcher")})
  public String delete()
  {
    productService service = new productService();
    this.nw.setId(this.id);
    product pt = service.getProductById(this.nw);
    String filename = pt.getImage().substring(pt.getImage().lastIndexOf("/") + 1, pt.getImage().length());
    String path = ServletActionContext.getServletContext()
      .getRealPath("/images/product") +
      "/";
    Utils.deleteFile(path, filename);
    service.delete(this.nw);
    return "SUCCESS";
  }

  @Action(value="/product/imageView", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/manage/jsp/product/image.jsp", type="dispatcher")})
  public String getImage()
  {
    this.nw.setImage(this.image);
    ServletActionContext.getRequest().setAttribute("product", this.nw);
    return "SUCCESS";
  }
}