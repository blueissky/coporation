package wechat.angle.dao;

import java.util.List;

import wechat.angle.bean.Prize;

public interface PrizeDao {
	public List<Prize> getPrize();//查看所有
	public Prize getPrizeOne(int i);//查看单个
	public int insertPrize();//增
	public int delPrize();//删
	public int update();//改
}
