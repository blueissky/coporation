package wechat.angle.dao;

import wechat.angle.bean.Captcha;

public interface CaptchaDao {
public Captcha getCaptcha();
public void insertCaptcha();
public void deleteCaptcha();
}
