package wechat.angle.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import wechat.angle.bean.Userinfo;
import wechat.angle.common.SqlCommon;
import wechat.angle.util.SessionFactory;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tel = request.getParameter("tel");
		PrintWriter writer = response.getWriter();
		SqlSession session = SessionFactory.getSessionFactory().openSession();
		request.getSession().setAttribute("tel",tel);
		Userinfo user = session.selectOne(SqlCommon.UserInfoSelectOne,tel);
		if(user!=null){
			writer.println(2);//电话已存在返回2
			session.close();
			writer.close();
			return;
		}
		int f2 = session.insert(SqlCommon.UserInfoInsert,tel);//插入电话
		session.commit();
		session.close();
		writer.println(1);//成功跳转
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
