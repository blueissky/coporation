package wechat.angle.bean;

import java.sql.Timestamp;

public class Userinfo {
private int t_id;
private String t_tel;
private int t_prize;
private Timestamp t_time;
private int t_enable;
public int getT_id() {
	return t_id;
}
public void setT_id(int t_id) {
	this.t_id = t_id;
}
public String getT_tel() {
	return t_tel;
}
public void setT_tel(String t_tel) {
	this.t_tel = t_tel;
}
public int getT_prize() {
	return t_prize;
}
public void setT_prize(int t_prize) {
	this.t_prize = t_prize;
}
public Timestamp getT_time() {
	return t_time;
}
public void setT_time(Timestamp t_time) {
	this.t_time = t_time;
}
public int getT_enable() {
	return t_enable;
}
public void setT_enable(int t_enable) {
	this.t_enable = t_enable;
}
}
