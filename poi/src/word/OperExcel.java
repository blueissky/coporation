package word;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import common.Common;


public class OperExcel {
	private XSSFWorkbook workbook;
	/**
	 * 查找内容 telphone agreement
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public HashMap<String, Object> readcustomers(String url) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<String> agreementset = new ArrayList<String>();// 合同号
		TreeSet<String> telphone = new TreeSet<String>();// 电话号码
		List<String> customer=new ArrayList<String>();
		XSSFRow row;
		File file = new File(url);// 查找文件
		FileInputStream fIP = new FileInputStream(file);
		workbook = new XSSFWorkbook(fIP);
		XSSFSheet spreadsheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = spreadsheet.iterator();
		boolean bool = true;
		while (rowIterator.hasNext()) {
			row = (XSSFRow) rowIterator.next();// 取行数据
			if (bool) {// 去掉第一行
				bool = false;
				continue;
			}
			String flag = row.getCell(Common.EXPIRE).toString();// 是否处理标志
			String agreement = row.getCell(Common.AGREEMENT).toString();// 获取合同号
			String customername=row.getCell(Common.CUSTOMER).toString();//获取客户名称
			String tel = row.getCell(Common.TEL).toString();//获取电话号码
			String city = row.getCell(Common.CITY).toString();//获取城市
			if (!flag.equals(Common.FLAG)) {//客户总表过期标志
				//只提取黄岛的用户合同号
				if(city.equals(Common.CITY_HUANGDAO)){
					agreementset.add(agreement);// 添加合同号
				}
				telphone.add(tel);
				customer.add(customername+"电话:"+tel+"合同号:"+agreement+"城市:"+city);
			}
		}
		fIP.close();
		map.put("agreement", agreementset);
		map.put("telphone", telphone);
		map.put("customer",customer);
		return map;
	}

	/**
	 * 在目录当中查找文件
	 * 
	 * @param url
	 *            查找的路径
	 * @param copydir
	 *            复制的路径
	 * @param agreementset
	 *            匹配的文件名称
	 * @throws Exception
	 */
	public void searchFile(String url, String copydir, List<String> agreement) {// 执行二
		try {
			File file = new File(url);
			File[] list = file.listFiles();
			for (File file_sub : list) {
				if (file_sub.isDirectory()) {
					searchFile(file_sub.getAbsolutePath(), copydir, agreement);
				} else {
					String name = file_sub.getName();// 获取文件名字
					if (name.startsWith(Common.INVEST)&&!name.startsWith(Common.WORDTemp)) {// 满足前缀和合同号
						for (String string : agreement) {
							if (name.indexOf(string) != -1) {
								this.copyfile(file_sub, copydir + name);
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 文件复制
	 * @param file
	 *            复制的文件
	 * @param newPath
	 *            保存的位置
	 * @throws Exception
	 */
	public void copyfile(File file, String newPath) throws Exception {// 执行三
		int bytesum = 0;
		int byteread = 0;
		File oldfile = file;
		InputStream inStream = new FileInputStream(oldfile);
		FileOutputStream fs = new FileOutputStream(newPath);
		byte[] buffer = new byte[1444];
		int length;
		while ((byteread = inStream.read(buffer)) != -1) {
			bytesum += byteread;
			fs.write(buffer, 0, byteread);
		}
	}

	/**
	 * 写入本地文件 telphone txt
	 * @param set
	 * @throws Exception
	 */
	public void writetelphone(TreeSet<String> set, String filename) throws Exception {
		StringBuilder sb = new StringBuilder();
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			sb.append(iter.next() +"\r\n");
		}
		String strend = sb.toString();// 要写的内容
		File file = new File(filename);// 本地文件名称
		FileOutputStream fs = new FileOutputStream(file);
		fs.write(strend.getBytes());
		fs.flush();
		fs.close();
	}

	/**
	 * 写入合同号 agreement txt
	 * @param set
	 * @param filename
	 * @throws Exception
	 */
	public void writeagreement(List<String> list, String filename) throws Exception {
		StringBuilder sb = new StringBuilder();
		for (String string : list) {
			sb.append(string + "\r\n");
		}
		String strend = sb.toString();// 要写的内容
		File file = new File(filename);// 本地文件名称
		FileOutputStream fs = new FileOutputStream(file);
		fs.write(strend.getBytes());
		fs.flush();
		fs.close();
	}
}
