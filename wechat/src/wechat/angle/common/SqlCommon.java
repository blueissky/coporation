package wechat.angle.common;

public class SqlCommon {
public static String PrizeInsert="PrizeDao.insertPrize";//name
public static String PrizeDelete="PrizeDao.delPrize";//id
public static String PrizeSelectOne="PrizeDao.getPrizeOne";//id
public static String PrizeSelectAll="PrizeDao.getPrize";
public static String PrizeUpdate="PrizeDao.update";//name id

public static String UserInfoInsert="UserinfoDao.insertUserinfo";//tel
public static String UserInfoDelete="UserinfoDao.delUserinfo";//id
public static String UserInfoSelectOne="UserinfoDao.getUserinfoOne";//id
public static String UserInfoSelectAll="UserinfoDao.getUserinfo";//
public static String UserInfoUpdate="UserinfoDao.update";//prizeId tel

public static String CaptchaSelectOne="CaptchaDao.getCaptcha";//code
public static String CaptchaInsert="CaptchaDao.insertCaptcha";//code
public static String CaptchaDelete="CaptchaDao.deleteCaptcha";//code

public static String UserlistgetAll="UserlistDao.getAll";//userlist

public static String PrizeContentGetALL="PrizeContentDao.getPrizeContent";
public static String PrizeContentUpdate="PrizeContentDao.updateContent";

public static String ManagerGetUser="ManagerDao.getPassword";
public static String ManagerUpdatePassword="ManagerDao.updatePassword";
}
