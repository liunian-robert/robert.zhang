package com.aqwx.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.aqwx.bean.product;
import com.aqwx.service.siteService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("mydefault")
@Namespace("/")
public class productsAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;

  @Action(value="product", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/jsp/product.jsp", type="dispatcher")})
  public String product()
  {
    siteService service = new siteService();
    Map mk = new HashMap();
    String num = ServletActionContext.getRequest().getParameter("pageNum");
    String ID = ServletActionContext.getRequest().getParameter("id");
    if ((ID == null) || (ID.equals(""))) {
      ID = "0";
    }
    mk.put("id", ID);
    if ((num == null) || (num.equals(""))) {
      num = "1";
    }
    int pageNum = Integer.parseInt(num);
    mk.put("pageNum", Integer.valueOf(pageNum));
    mk.put("numPerPage", Integer.valueOf(9));
    Map mp = service.getProductInfo(mk);
    ServletActionContext.getRequest().setAttribute("mp", mp);
    return "SUCCESS";
  }

  @Action(value="productDetail", results={@org.apache.struts2.convention.annotation.Result(name="SUCCESS", location="/jsp/productDetail.jsp", type="dispatcher")})
  public String newsDetail() {
    String ID = ServletActionContext.getRequest().getParameter("id");
    product nw = new product();
    nw.setId(ID);
    siteService service = new siteService();
    Map mp = service.getProductDetail(nw);
    ServletActionContext.getRequest().setAttribute("mp", mp);
    return "SUCCESS";
  }
}