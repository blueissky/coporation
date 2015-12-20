package wechat.angle.util;

import java.io.InputStream;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import wechat.angle.bean.Manager;
import wechat.angle.common.SqlCommon;

public class MyProjectTest {
	// public void before(){
	// PropertyConfigurator.configure( "source/log4j.properties" );
	// log = Logger.getLogger(myproject.class);
	// }
	@Test
	public void run() {
		// mybatis的配置文件
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream is = MyProjectTest.class.getClassLoader().getResourceAsStream("configure.xml");

		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		// Reader reader = Resources.getResourceAsReader(resource);
		// 构建sqlSession的工厂
		// SqlSessionFactory sessionFactory = new
		// SqlSessionFactoryBuilder().build(reader);
		// 创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
//		int id=5888;
//		Userinfo user = (Userinfo)session.selectOne(SqlCommon.UserInfoSelectOne,5888);
//		System.out.println(user.getT_tel());
//		Manager user = session.selectOne(SqlCommon.ManagerGetUser);
//		System.out.println(user.getT_password());
		HashMap map = new HashMap();
		map.put("password","123");
		session.update(SqlCommon.ManagerUpdatePassword,map);
		session.commit();
		session.close();
//		HashMap map = new HashMap();
//		map.put("code","a12");
//		session.insert(SqlCommon.CaptchaInsert,map);
//		session.commit();
//		String code="a12d";
//		Object x = session.selectOne(SqlCommon.CaptchaSelectOne,code);
//		System.out.println(x);
//		String code="a12";
//		int x = session.delete(SqlCommon.CaptchaDelete,code);//删除返回值0位失败1为成功
//		System.out.println(x);
//		session.close();
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		// wechat.angle.dao.
		// wechat.angle.dao.
		// String statement = "mybatise.main.dao.aosDao.getAos";//映射sql的标识字符串
//		String aa = "PrizeDao.getPrizeOne";// 查看
//		String bb = "PrizeDao.insertPrize";// 新增数据
//		String cc = "PrizeDao.update";// 修改数据
		// Prize xx = (Prize)session.selectOne(aa, 1);
		// System.out.println(xx.getT_prizename());
//		HashMap map = new HashMap();
//		map.put("name","七等奖");
//		int x = session.insert(bb,map);
//		System.out.println(x);
//		HashMap map = new HashMap();
//		map.put("name","十一等奖");
//		map.put("id","1");
//		session.update(cc,map);
//		session.commit();
//		session.close();
		
//		String aa="UserinfoDao.insertUserinfo";
//		Userinfo userinfo = (Userinfo)session.selectOne(aa, 1);
//		System.out.println(userinfo.getT_tel());
//		map.put("tel","83216151313");
//		map.put("prizeId","1");
//		session.insert(aa,map);
		
		// 执行查询返回一个唯一user对象的sql
		// Aos aos = session.selectOne(statement,1);
		// log.info(aos.getAddress());
	}
}
