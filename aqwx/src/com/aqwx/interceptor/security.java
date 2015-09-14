package com.aqwx.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class security
  implements Interceptor
{
  private static final long serialVersionUID = 1L;

  @Override
public void destroy()
  {
  }

  @Override
public void init()
  {
  }

  @Override
public String intercept(ActionInvocation invocation)
    throws Exception
  {
    HttpServletRequest request = ServletActionContext.getRequest();
    System.out.println(request.getRequestURL());
    return invocation.invoke();
  }
}