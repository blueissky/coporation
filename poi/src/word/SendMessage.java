package word;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import common.Common;
import common.PropertyFile;

public class SendMessage {
	
	private TreeSet<String> tel;
	/**
	 * 解析TEL文本文件并且发送数据
	 * @param telPath
	 */
	public String readTelTxtAndSend(String telPath){
		try {
			BufferedReader reader=new BufferedReader(new FileReader(new File(telPath)));
			tel = new TreeSet<String>();
			String val="";
			while((val=reader.readLine())!=null){
				tel.add(val);
			}
		} catch (Exception e) {
			return Common.FALSE;
		}
		Iterator<String> iter = tel.iterator();
		SimpleDateFormat sim=new SimpleDateFormat("MM");
		String month=sim.format(new Date());//获取当前月份
		String cont= "尊敬的客户您好，天使卓越温馨提示：请您于近日查收"+month+"月15日的《资金投资报告函》，如有疑问或退订短信通知，请致电400-150-3066，天使卓越（北京）投资管理有限公司。---感 恩 同 行 · 共 享 卓 越---";
		while(iter.hasNext()){
			this.telMessage(iter.next(), cont);//开始发送
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return Common.SUCCESS;
	}
	/**
	 * 发送短息
	 * @param tel 发送电话
	 * @param content 发送内容
	 */
	public void telMessage(String tel,String content) {
		PropertyFile pf = new PropertyFile();
		String PHONE_MSG_USERNAME = pf.read("phone_msg_username");
		String PHONE_MSG_PASSWORD = pf.read("phone_msg_password");
		String PHONE_MSG_URL = pf.read("phone_msg_url");
		Map<String, String> params = new LinkedHashMap<String, String>();
		String message = DocXml(PHONE_MSG_USERNAME, MD5Encode(PHONE_MSG_PASSWORD), "", tel,content, null,null, "");
		params.put("message", message);
		String url = PHONE_MSG_URL + "Submit";
		this.doPost(url, params);
	}

	// 发送短信
	public String doPost(String url, Map<String, String> params) {
		String response = null;
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(url);
		postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");

		// 设置Post数据
		if (!params.isEmpty()) {
			int i = 0;
			NameValuePair[] data = new NameValuePair[params.size()];
			for (Entry<String, String> entry : params.entrySet()) {
				data[i] = new NameValuePair(entry.getKey(), entry.getValue());
				i++;
			}
			postMethod.setRequestBody(data);
		}
		try {
			client.executeMethod(postMethod);
			if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
				response = postMethod.getResponseBodyAsString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			postMethod.releaseConnection();
		}
		return response;
	}

	// MD5加密函数
	public String MD5Encode(String sourceString) {
		String resultString = null;
		try {
			resultString = new String(sourceString);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byte2hexString(md.digest(resultString.getBytes()));
		} catch (Exception ex) {
		}
		return resultString;
	}

	// MD5
	public String byte2hexString(byte[] bytes) {
		StringBuffer bf = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if ((bytes[i] & 0xff) < 0x10) {
				bf.append("0");
			}
			bf.append(Long.toString(bytes[i] & 0xff, 16));
		}
		return bf.toString();
	}

	// DOM
	public String DocXml(String userName, String pwd, String msgid, String phone, String contents, String sign,
			String subcode, String sendtime) {
		Document doc = DocumentHelper.createDocument();
		doc.setXMLEncoding("UTF-8");
		Element message = doc.addElement("response");
		Element account = message.addElement("account");
		account.setText(userName);
		Element password = message.addElement("password");
		password.setText(pwd);
		Element msgid1 = message.addElement("msgid");
		if (null == msgid) {
			msgid1.setText("");
		} else {
			msgid1.setText(msgid);
		}
		Element phones = message.addElement("phones");
		phones.setText(phone);
		Element content = message.addElement("content");
		content.setText(contents);
		Element sign1 = message.addElement("sign");
		if (null == sign) {
			sign1.setText("");
		} else {
			sign1.setText(sign);
		}
		Element subcode1 = message.addElement("subcode");
		if (null == subcode) {
			subcode1.setText("");
		} else {
			subcode1.setText(subcode);
		}

		Element sendtime1 = message.addElement("sendtime");
		sendtime1.setText(sendtime);
		return message.asXML();
	}
}
