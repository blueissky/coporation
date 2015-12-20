package wechat.angle.bean;

import java.sql.Timestamp;

public class Userlist {
	private String t_id;
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	private String t_tel;
	private String t_prizename;
	private Timestamp t_time;
	public String getT_tel() {
		return t_tel;
	}

	public void setT_tel(String t_tel) {
		this.t_tel = t_tel;
	}

	public String getT_prizename() {
		return t_prizename;
	}

	public void setT_prizename(String t_prizename) {
		this.t_prizename = t_prizename;
	}

	public Timestamp getT_time() {
		return t_time;
	}

	public void setT_time(Timestamp t_time) {
		this.t_time = t_time;
	}

}
