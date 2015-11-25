package angelexcellence.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import angelexcellence.util.Common;

public class ReadExcel {
	private Iterator<Cell> cell_iterator;
	private XSSFWorkbook workbook;
	private XSSFWorkbook workbook2;
	public void readcustomers(String sourcePath,String targetPath) throws Exception{
			XSSFRow row;
			File file = new File(sourcePath);
			FileInputStream fIP = new FileInputStream(file);
			workbook = new XSSFWorkbook(fIP);
			XSSFSheet spreadsheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = spreadsheet.iterator();
			Map<String, Object[]> empinfo = new TreeMap<String, Object[]>();
			empinfo.put("1", new Object[] { Common.BANKNAME,Common.BANKCODE,Common.NAME});
			Object[] obj;
			int keyi=1;
			boolean bool=true;
			while(rowIterator.hasNext()){
				row = (XSSFRow) rowIterator.next();//取行数据
				if(bool){//去掉第一行
					bool=false;
					continue;
				}
				cell_iterator = row.iterator();//获取单元格数据集合
				obj = new Object[3];
				while (cell_iterator.hasNext()) {
					Cell cell = cell_iterator.next();
					if(cell.getColumnIndex()+1==Common.CUSTOMERBANKNAME){//客户银行
						String name = cell.getStringCellValue();
						int i = name.indexOf(Common.BankFlag);
						i+=2;
//					System.out.print("位置："+i+name.substring(0, i));
						obj[0]=name.substring(0, i);
					}
					if(cell.getColumnIndex()+1==Common.CUSTOMERBANKCODE){//客户卡号
//					System.out.print(cell.getStringCellValue());
						obj[1]=cell.getStringCellValue();
					}
					if(cell.getColumnIndex()+1==Common.CUSTOMERNAME){//客户名称
//					System.out.print(cell.getStringCellValue());
						obj[2]=cell.getStringCellValue();
					}
				}
//			System.out.println();
				keyi++;
				empinfo.put(String.valueOf(keyi),obj);
			}
			fIP.close();
			this.write(empinfo,targetPath);
	}
	public void write(Map<String, Object[]> empinfo,String targetPath) {
		workbook2 = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook2.createSheet("CustomerInfo");
		XSSFRow row;
		int size=empinfo.size();
		int rowid = 0;
		for (int j=1;j<=size;j++) {
			row = spreadsheet.createRow(rowid++);
			Object[] objectArr = empinfo.get(String.valueOf(j));
			int cellid = 0;
			for (Object obj : objectArr) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String) obj);
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(new File(targetPath));
			workbook2.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
