package wechat.angle.util;

import java.io.InputStream;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory implements ServletContextListener{
	private static SqlSessionFactory sessionFactory;
	public static SqlSessionFactory getSessionFactory(){
		return sessionFactory;
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		InputStream is = SessionFactory.class.getClassLoader().getResourceAsStream("configure.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(is);
	}
}
