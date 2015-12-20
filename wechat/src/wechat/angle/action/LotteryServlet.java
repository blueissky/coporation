package wechat.angle.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import wechat.angle.common.SqlCommon;
import wechat.angle.util.SessionFactory;

public class LotteryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String tel = (String)request.getSession().getAttribute("tel");
		String prizeId = request.getParameter("prizeId");
		HashMap map = new HashMap();
		map.put("prizeId",prizeId);
		map.put("tel",tel);
		SqlSession session = SessionFactory.getSessionFactory().openSession();
		int flag = session.update(SqlCommon.UserInfoUpdate,map);
		session.commit();
		session.close();
		PrintWriter out = response.getWriter();
		out.print(prizeId);//将结果返回前台
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
