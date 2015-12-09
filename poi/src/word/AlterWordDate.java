package word;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.Test;

import common.Common;

public class AlterWordDate {
	/**
	 * 查找文件修改时间
	 * 
	 * @param url
	 *            查找路径
	 * @param date
	 *            设置修改时间
	 * @return 返回时间有误的word
	 */
	public String searchFile(String url, String date) {
		StringBuffer sb = new StringBuffer();
		File file = new File(url);
		File[] list = file.listFiles();
		for (File file_sub : list) {
			if (file_sub.isDirectory()) {
				searchFile(file_sub.getAbsolutePath(), date);
			} else {
				String name = file_sub.getName();// 获取文件名字
				if (name.endsWith("docx")) {
					String time = getexpire(file_sub);//获取word到期日期
					time = dateChangeFormate(time);//日期格式化
					if (dateSub(time, getCurrentTime())<0) {// 小于今天的 超期了 判断几天的
						sb.append(file_sub.getName() + "\r\n");
					}else{//没有超期的修改时间
						alterHeadDate(file_sub, date);
						alterFootDate(file_sub, date);						
					}
				}
			}
		}
		return sb.toString();
	}

	/**
	 * "20120202" 设置字体
	 * 
	 * @throws Exception
	 */
	public void alterHeadDate(File file, String date) {
		try {
			InputStream is = new FileInputStream(file);
			XWPFDocument doc = new XWPFDocument(is);
			Iterator<XWPFTable> dociter = doc.getTablesIterator();
			XWPFTable xx = dociter.next();// 获取第一个单元格
			XWPFTableRow row = xx.getRow(2);// 获取第三行
			XWPFTableCell cell = row.getCell(0);// 获取第一个单元格数据
			cell.removeParagraph(0);// 清除单元格内容
			cell.setText(date);//
			doc.write(new FileOutputStream(file));// 写回源文件
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改底部时间
	 * 
	 * @param file
	 * @param date
	 * @throws Exception
	 */
	public void alterFootDate(File file, String date) {
		try {
			InputStream is = new FileInputStream(file);
			XWPFDocument doc = new XWPFDocument(is);
			Iterator<XWPFParagraph> para = doc.getParagraphsIterator();
			int flag = -1;
			while (para.hasNext()) {
				flag++;
				XWPFParagraph xw = para.next();
			}
			XWPFParagraph xx = doc.getParagraphArray(flag);
			List<XWPFRun> runs = xx.getRuns();
			for (int j = 0; j < runs.size(); j++) {// 获取该行后，将数据全部清空
				runs.get(j).setText(null, 0);
			}
			xx.setAlignment(ParagraphAlignment.RIGHT);// 设置对齐方式
			XWPFRun run = xx.createRun();
			run.setFontFamily("黑体");
			run.setFontSize(10);// 日 期：2015年10月27日
			date = "日 期：" + date.substring(0, 4) + "年" + date.substring(4, 6) + "月" + date.substring(6, 8) + "日";
			run.setText(date);// 设置更换内容
			doc.write(new FileOutputStream(file));// 修改完成写回源文件
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 提取到期日期
	 * 
	 * @throws Exception
	 */
	public String getexpire(File file) {
		String time = "";
		try {
			InputStream is = new FileInputStream(file);
			XWPFDocument doc = new XWPFDocument(is);
			Iterator<XWPFTable> dociter = doc.getTablesIterator();
			int i = 0;
			dociter.next();// 获取第一个表格
			XWPFTable xx = dociter.next();// 获取第二个表格
			XWPFTableRow zz = xx.getRow(3);// 获取第三行
			XWPFTableCell cell = zz.getCell(5);// 获取第六个单元格
			time = cell.getText();// 取数据
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}

	/**
	 * 写文件
	 * 
	 * @param list
	 * @param filename
	 * @throws Exception
	 */
	public void writeExpire(String date, String filename) throws Exception {
		File file = new File(filename);// 本地文件名称
		FileOutputStream fs = new FileOutputStream(file);
		fs.write(date.getBytes());
		fs.flush();
		fs.close();
	}

	/**
	 * 时间转换工具
	 * 
	 * @param date
	 * @return
	 */
	public String dateChangeFormate(String date) {
		if (date.length() > 8) {
			date = date.substring(0, 4) + date.substring(5, 7) + date.substring(8, 10);
		}
		return date;
	}

	/**
	 * 两数相减
	 * 
	 * @param subA
	 *            减数
	 * @param subB
	 *            被减数
	 * @return
	 */
	public int dateSub(String subA, String subB) {
		int a = Integer.parseInt(subA);
		int b = Integer.parseInt(subB);
		return a - b;
	}
	/**
	 * 获取当前时间
	 * @return
	 */
	public String getCurrentTime(){
		SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
		return format.format(new Date())+Common.FIFTYDAY;
	}
}
