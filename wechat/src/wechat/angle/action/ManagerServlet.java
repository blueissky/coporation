package wechat.angle.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import wechat.angle.bean.Manager;
import wechat.angle.common.SqlCommon;
import wechat.angle.util.SessionFactory;
public class ManagerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession session = SessionFactory.getSessionFactory().openSession();
		String password = request.getParameter("password");
		Manager manager = session.selectOne(SqlCommon.ManagerGetUser);
		String pw = manager.getT_password();
		PrintWriter writer = response.getWriter();
		if(password.equals(pw)){
			writer.println(1);
			request.getSession().setAttribute("admin",pw);
			//密码正确
		}else{
			writer.print(0);
			//密码不正确
		}
		writer.close();
		session.close();
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
