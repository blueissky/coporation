package wechat.angle.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import wechat.angle.bean.Userlist;
import wechat.angle.common.SqlCommon;
import wechat.angle.util.SessionFactory;

public class UserlistServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String del = request.getParameter("del");
		SqlSession session = SessionFactory.getSessionFactory().openSession();
		if(del==null){
			List<Userlist> list = session.selectList(SqlCommon.UserlistgetAll);//查询所有中奖的
			request.setAttribute("list",list);
			session.close();
		}else{
			HashMap map = new HashMap();
			map.put("id",del);
			session.delete(SqlCommon.UserInfoDelete,map);
			session.commit();
			session.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
