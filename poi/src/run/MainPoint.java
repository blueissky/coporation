package run;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.commons.lang.StringUtils;

import print.PrintClass;
import word.AlterWordDate;
import word.OperExcel;
import word.SendMessage;
import common.Common;

public class MainPoint {
	public static void main(String[] args) {
		new MainPoint().init();
	}

	private JFrame frame;
	private JPanel panel;
	private JLabel lab1;
	private JLabel lab2;
	private JLabel lab3;
	private JLabel lab4;
	private JButton button;
	private JTextArea t1;
	private JTextArea t2;
	private JTextArea t3;
	private JTextArea t4;
	private JTextArea t5;
	private JLabel lab5;
	private JTextArea t6;
	private JTextArea t7;
	private JButton sendbut;
	private JLabel lab6;
	private JButton print;
	private JTextArea t8;
	private JTextArea t9;

	public void init() {
		Font font = new Font("微软雅黑", Font.BOLD, 12);
		frame = new JFrame();
		panel = new JPanel();
		lab1 = new JLabel("客户资料路径");
		lab2 = new JLabel("word文件路径");
		lab3 = new JLabel("word另存路径");
		lab4 = new JLabel("更改日期");
		lab5 = new JLabel("发送电话文本路径");
		lab6=new JLabel("批量打印文件夹");
		lab1.setFont(font);
		lab2.setFont(font);
		lab3.setFont(font);
		lab4.setFont(font);
		lab5.setFont(font);
		lab6.setFont(font);
		t1 = new JTextArea("");
		t2 = new JTextArea("");
		t3 = new JTextArea("");
		t4 = new JTextArea("");
		t5 = new JTextArea("");
		t6 = new JTextArea("");
		t7 = new JTextArea("");
		t8 = new JTextArea("");
		t9 = new JTextArea("");
		button = new JButton("开始执行");
		sendbut = new JButton("开始发送");
		print=new JButton("开始打印");
		lab1.setBounds(10, 10, 100, 50);
		lab2.setBounds(10, 50, 100, 50);
		lab3.setBounds(10, 100, 100, 50);
		lab4.setBounds(10, 150, 100, 50);
		lab5.setBounds(620, 10, 100, 40);
		lab6.setBounds(620, 220, 100, 40);
		t1.setBounds(130, 20, 450, 20);
		t2.setBounds(130, 70, 450, 20);
		t3.setBounds(130, 120, 450, 20);
		t4.setBounds(130, 170, 450, 20);
		t5.setBounds(10, 290, 560, 160);
		t6.setBounds(620, 40, 230, 20);
		t7.setBounds(620, 110, 230, 90);
		t8.setBounds(620, 330, 230, 120);
		t9.setBounds(620, 250, 230, 20);
		t7.setLineWrap(true);
		t1.setBorder(BorderFactory.createBevelBorder(1));
		t2.setBorder(BorderFactory.createBevelBorder(1));
		t3.setBorder(BorderFactory.createBevelBorder(1));
		t4.setBorder(BorderFactory.createBevelBorder(1));
		t5.setBorder(BorderFactory.createBevelBorder(1));
		t6.setBorder(BorderFactory.createBevelBorder(1));
		t7.setBorder(BorderFactory.createBevelBorder(1));
		t8.setBorder(BorderFactory.createBevelBorder(1));
		t9.setBorder(BorderFactory.createBevelBorder(1));
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		t4.setFont(font);
		t5.setFont(font);
		t6.setFont(font);
		t9.setFont(font);
		button.setBounds(130, 230, 450, 40);
		sendbut.setBounds(620, 70, 230, 30);
		print.setBounds(620, 290, 230, 30);
		panel.setLayout(null);
		panel.add(lab1);
		panel.add(lab2);
		panel.add(lab3);
		panel.add(lab4);
		panel.add(lab5);
		panel.add(lab6);
		panel.add(t1);
		panel.add(t2);
		panel.add(t3);
		panel.add(t4);
		panel.add(t5);
		panel.add(t6);
		panel.add(t7);
		panel.add(t8);
		panel.add(t9);
		panel.add(button);
		panel.add(sendbut);
		panel.add(print);
		frame.add(panel);
		frame.setResizable(false);
		frame.setBounds(Common.getWidth() / 2 - 900 / 2, Common.getHeight() / 2 - 500 / 2, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("WORD文件提取");
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String a = StringUtils.trim(t1.getText()); // 去掉空格
				String b = StringUtils.trim(t2.getText());
				String c = StringUtils.trim(t3.getText());
				String d = StringUtils.trim(t4.getText());
				if (a.length() == 0 || b.length() == 0 || c.length() == 0 || d.length() == 0) {
					JOptionPane.showMessageDialog(null, "内容不能为空!");
					return;
				}
				MainPoint point = new MainPoint();
				String flag = point.param(a, b, c, d);
				if (flag.equals(Common.SUCCESS)) {
					StringBuilder sb = new StringBuilder();
					sb.append("客户总表:customer.txt\n");
					sb.append("过期WORD文件合同号:expire.txt\n");
					sb.append("发送电话总表:tel.txt\n");
					sb.append("完成.\n");
					t5.setText(sb.toString());
				} else {
					t5.setText(Common.FALSE + " 失败!");
				}
			}
		});
		/**
		 * 发送短信
		 */
		sendbut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String telPath = StringUtils.trim(t6.getText());
				if(telPath.length()==0){
					JOptionPane.showMessageDialog(null, "内容不能为空!");
					return;
				}
				SendMessage mes = new SendMessage();
				String flag = mes.readTelTxtAndSend(telPath);
				if (flag.equals(Common.SUCCESS)) {
					t7.setText("发送成功");
				} else {
					t7.setText("发送失败");
				}
			}
		});
		/**
		 * 批量打印
		 */
		print.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String telPath = StringUtils.trim(t9.getText());
				if(telPath.length()==0){
					JOptionPane.showMessageDialog(null, "内容不能为空!");
					return;
				}
				PrintClass printpager = new PrintClass();
				System.out.println(telPath);
				try {
					printpager.print(telPath);
					t8.setText("完成");
				} catch (Exception e1) {
					e1.printStackTrace();
					t8.setText("失败"+Common.FALSE);
				}
			}
		});
	}

	/**
	 * excel操作类
	 * @param urlexcel
	 * @param urlword
	 * @param copydir
	 * @param date
	 * @return
	 */
	public String param(String urlexcel, String urlword, String copydir, String date) {
		// String urlexcel = "F:/AngelManager/文件资料/客户资料.xlsx";// 需要提取的文件
		// String urlword = "F:/AngelManager/文件资料";// 查找对应的word文件
		// String copydir = "F:/AngelManager/savefile/";// 保存word文件
		// String date = "20110112";
		if (!copydir.endsWith("/")) {
			copydir = copydir + "/";
		}
		String customerTxt = copydir + "customer.txt";// 保存EXCEL客户资料目录
		String wordTxt = copydir + "expire.txt";// 保存到期WORD文件
		String telTxt = copydir + "tel.txt";// 客户电话
		AlterWordDate word = new AlterWordDate();
		OperExcel excel = new OperExcel();
		try {
			HashMap<String, Object> map = excel.readcustomers(urlexcel);
			TreeSet<String> telphone = (TreeSet<String>) map.get("telphone");// 获取电话号码
			List<String> agreement = (List<String>) map.get("agreement");// 获取合同号
			List<String> customer = (List<String>) map.get("customer");// 客户资料总表
			excel.writeagreement(customer, customerTxt);// 存放客户资料txt
			excel.writetelphone(telphone, telTxt);// 保存电话资料
			excel.searchFile(urlword, copydir, agreement);// 查找文件并复制
			String expiredates = word.searchFile(copydir, date);
			word.writeExpire(expiredates, wordTxt);
		} catch (Exception e) {
			return Common.FALSE;
		}
		return Common.SUCCESS;
	}
}
