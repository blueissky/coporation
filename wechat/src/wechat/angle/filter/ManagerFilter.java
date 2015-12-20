package wechat.angle.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerFilter implements Filter{
	@Override
	public void doFilter(ServletRequest re, ServletResponse rs, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)re;
		HttpServletResponse response = (HttpServletResponse)rs;
		String clear = request.getParameter("clearAdmin");
		if(clear!=null){//清空登录
			request.getSession().setAttribute("admin",null);
		}
		Object flag = request.getSession().getAttribute("admin");
		if(flag==null){
			response.sendRedirect("/wechat/admin.jsp");
		}
		chain.doFilter(request,response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
