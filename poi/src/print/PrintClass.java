package print;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class PrintClass {
	/**
	 * 打印文件
	 * @param url
	 */
	public void print(String url) {
		List<File> list = this.searchFile(url);
		for (File file : list) {
			this.printWord(file.getAbsolutePath());
		}
	}
	/**
	 * 获取本地所有文件
	 * @param url
	 * @return
	 */
	public List<File> searchFile(String url) {
		ArrayList<File> filelist = new ArrayList<File>();
		File file = new File(url);
		File[] list = file.listFiles();
		for (File file_sub : list) {
			if (file_sub.isDirectory()) {
				searchFile(file_sub.getAbsolutePath());
			} else {
				String name = file_sub.getName();// 获取文件名字
				if (name.endsWith("docx")) {
					filelist.add(file_sub);
				}
			}
		}
		return filelist;
	}

	/**
	 * 打印excel
	 * @param filePath
	 */
//	public static void printExcel(String filePath) {
//		/**
//		 * 功能:实现打印工作
//		 */
//		ComThread.InitSTA();
//		ActiveXComponent xl = new ActiveXComponent("Excel.Application");
//		try {
//			// System.out.println("version=" + xl.getProperty("Version"));
//			// 不打开文档
//			Dispatch.put(xl, "Visible", new Variant(true));
//			Dispatch workbooks = xl.getProperty("Workbooks").toDispatch();
//			// 打开文档
//			Dispatch excel = Dispatch.call(workbooks, "Open", filePath).toDispatch();
//			// 开始打印
//			Dispatch.call(excel, "PrintOut");
//			xl.invoke("Quit", new Variant[] {});
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// 始终释放资源
//			ComThread.Release();
//		}
//	}

	/**
	 * 打印word
	 * @param filePath
	 */
	public static void printWord(String filePath) {
		ComThread.InitSTA();
		ActiveXComponent wd = new ActiveXComponent("Word.Application");
		try {
			// 不打开文档
			Dispatch.put(wd, "Visible", new Variant(true));
			Dispatch document = wd.getProperty("Documents").toDispatch();
			// 打开文档
			System.out.println(filePath);
			Dispatch doc = Dispatch.invoke(document, "Open", Dispatch.Method, new Object[] { filePath }, new int[1])
					.toDispatch();
			// 开始打印
			Dispatch.callN(doc, "PrintOut");
			wd.invoke("Quit", new Variant[] {});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 始终释放资源
			ComThread.Release();
		}
	}
	// 获得文件后缀名
//	public static String getPostfix(String inputFilePath) {
//		String[] p = inputFilePath.split("\\.");
//		if (p.length > 0) {// 判断文件有无扩展名
//			// 比较文件扩展名
//			return p[p.length - 1];
//		} else {
//			return null;
//		}
//	}
}
