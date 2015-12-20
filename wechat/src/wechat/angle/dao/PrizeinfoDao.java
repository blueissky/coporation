package wechat.angle.dao;

import java.util.List;

import wechat.angle.bean.Prize;
import wechat.angle.bean.Userinfo;
public interface PrizeinfoDao {
	public List<Prize> getUserinfo();//查看所有
	public Userinfo getUserinfoOne(int i);//查看单个
	public int insertUserinfo();//增
	public int update();//删
	public int delUserinfo();//改
}
