package angelexcellence.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import angelexcellence.excel.ReadExcel;
import angelexcellence.util.Common;

public class MyFrame {
	private static String sourcePath="";
	private static String targetPath="";
	MyFrame(){
		this.init();
		this.listener();
	}
	private JFrame frame;
	private JPanel panel;
	private JButton submit;
	private JTextArea area1;
	private JTextArea area2;
	private JButton buta;
	private JButton butb;
	private Font font;
	private JLabel info;
	private static JTextArea sche;

	public void init() {
		font=new Font("微软雅黑", Font.BOLD, 22);
		frame=new JFrame();
		panel=new JPanel();
		area1=new JTextArea();
		area2=new JTextArea();
		sche=new JTextArea();
		info=new JLabel();
		area1.setBorder(BorderFactory.createBevelBorder(1));
		area2.setBorder(BorderFactory.createBevelBorder(1));
		sche.setBorder(BorderFactory.createBevelBorder(1));
		buta=new JButton();
		butb=new JButton();
		submit=new JButton();
		frame.setSize(300,300);
		panel.setSize(300,300);
		submit.setText("开始提取");
		submit.setFont(font);
		submit.setBackground(Color.WHITE);
		panel.add(area1);//保存路径选择
		panel.add(area2);//保存路径选择
		panel.add(sche);//进度执行
		panel.add(buta);//
		panel.add(butb);//
		panel.add(submit);//开始执行
		panel.add(info);
		panel.setLayout(null);
		panel.setBackground(Color.orange);
		area1.setAutoscrolls(true);
		area1.setLineWrap(true);
		buta.setBounds(120,10,160,35);//按钮一位置
		area1.setBounds(0, 50, 400, 60);//文本框一位置
		butb.setBounds(120,120,160,35);//按钮二位置
		area2.setBounds(0, 160, 400, 60);//文本框二位置
		submit.setBounds(120,240,160,35);//按钮三的位置
		sche.setBounds(0,280,400,60);//文本框三的位置
		buta.setText("提取文件");
		buta.setFont(font);
		buta.setBackground(Color.WHITE);
		butb.setText("存放位置");
		butb.setFont(font);
		butb.setBackground(Color.WHITE);
		sche.setAutoscrolls(true);
		info.setBounds(10,320,300,100);
		info.setText("注意格式：客户姓名C列  划扣行别P列  账号R列.");
		info.setFont(new Font("微软雅黑",Font.BOLD,12));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image/file.png"));
		frame.add(panel);
		frame.setTitle("文档内容提取工具");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setBounds(Common.getWidth()/2-400/2,Common.getHeight()/2-500/2,400,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void listener(){
		buta.addActionListener(new ActionListener() {
			/**
			 * 选择文件
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.showDialog(new JLabel(), "选择");
				try {
					File file = chooser.getSelectedFile();
					if(file.isDirectory()){  
					    System.out.println("文件夹:"+file.getAbsolutePath());  
					    area1.setText(file.getAbsolutePath());
					    sourcePath=file.getAbsolutePath();
					}else if(file.isFile()){  
					    System.out.println("文件:"+file.getAbsolutePath());  
					    area1.setText(file.getAbsolutePath());
					    sourcePath=file.getAbsolutePath();
					}
				} catch (Exception e) {
				}  
			}
		});
		butb.addActionListener(new ActionListener() {
			/**
			 * 保存路径
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.showDialog(new JLabel(), "选择");
				try {
					File file = chooser.getSelectedFile();
					if(file.isDirectory()){  
					    System.out.println("文件夹:"+file.getAbsolutePath()); 
					    area2.setText(file.getAbsolutePath());
					    targetPath=file.getAbsolutePath();
					}else if(file.isFile()){  
					    System.out.println("文件:"+file.getAbsolutePath());  
					    area2.setText(file.getAbsolutePath());
					    targetPath=file.getAbsolutePath();
					}
				} catch (Exception e) {
				}  
			}
		});
		/**
		 * 开始执行
		 */
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(area1.getText()==""||area2.getText()==""||area1.getText()==null||area2.getText()==null){
					return;	
				}
				StringBuilder text=new StringBuilder();
				text.append("正在执行,请稍后...");
				sche.setText(text.toString());
				try {
					ReadExcel read = new ReadExcel();
					read.readcustomers(sourcePath, targetPath+File.separator+Common.FileName);
					text.append("\n成功.");
					sche.setText(text.toString());
				} catch (Exception e) {
					text.append("\n失败.\n请检查文件路径是否正确,或者其他原因.");
					sche.setText(text.toString());
					e.printStackTrace();
				}
			}
		});
	}
}
