package angelexcellence.util;

import java.awt.Toolkit;
public class Common {
	public static int CUSTOMERNAME = 3; // C
	public static int CUSTOMERBANKNAME = 16;// P
	public static int CUSTOMERBANKCODE = 18;// R
	public static String NAME = "客户姓名";
	public static String BANKNAME = "银行名称";
	public static String BANKCODE = "银行卡号";
	public static String BankFlag = "银行";
	public static String FileName = "Customer.xlsx";
	public static Integer getWidth() {
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		return w;
	}
	public static Integer getHeight() {
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		return h;
	}
}










