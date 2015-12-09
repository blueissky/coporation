package common;

import java.awt.Toolkit;

public class Common {
	public static String SUCCESS="SUCCESS";
	public static String FALSE="FALSE";
	public static String FLAG = "已处理";// 索引标志
	public static String INVEST = "投资情况报表-";// 索引标志
	public static int CITY = 41;
	public static int EXPIRE = 44;
	public static int TEL = 29;
	public static int AGREEMENT = 1;
	public static int CUSTOMER = 2;
	public static String CITY_HUANGDAO = "黄岛";
	public static String CITY_TAO = "青岛";
	public static String SEPARATE = ",";//电话分隔符号
	public static String WORDTemp = "~$";//排除WORD临时文件
	public static String FIFTYDAY="15";
	public static Integer getWidth() {
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		return w;
	}

	public static Integer getHeight() {
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		return h;
	}

}
