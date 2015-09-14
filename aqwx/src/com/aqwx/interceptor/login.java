package com.aqwx.interceptor;

import org.apache.struts2.ServletActionContext;

import com.aqwx.bean.user;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class login
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
    user u = (user)ServletActionContext.getRequest().getSession().getAttribute("user");
    if (u == null) {
      return "serverOut";
    }
    return invocation.invoke();
  }
}