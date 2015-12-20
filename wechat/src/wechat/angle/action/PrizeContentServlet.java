package wechat.angle.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import wechat.angle.bean.PrizeContent;
import wechat.angle.common.SqlCommon;
import wechat.angle.util.SessionFactory;

public class PrizeContentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession session = SessionFactory.getSessionFactory().openSession();
		String text = request.getParameter("text");
		String id = request.getParameter("id");
		if(text==null){
			List<PrizeContent> list = session.selectList(SqlCommon.PrizeContentGetALL);
			request.setAttribute("list",list);
			for (PrizeContent prizeContent : list) {
				request.setAttribute("p"+prizeContent.getT_id(),prizeContent.getT_name());	
			}	
			session.close();
		}else{
			HashMap map = new HashMap();
			map.put("id",id);
			map.put("name",text);
			session.update(SqlCommon.PrizeContentUpdate,map);
			session.commit();
			session.close();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
