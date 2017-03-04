/**
 * 
 */
package cn.yin.jx.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月23日
 */
public class Demo {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row row = sheet.createRow(3);
		Cell cell = row.createCell(3);
		cell.setCellValue("一统江湖");
		Font font = wb.createFont();
		font.setFontName("华文楷体");
		font.setFontHeightInPoints((short) 48);
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);
		OutputStream os = new FileOutputStream(new File("d://myexcle.xls"));
		wb.write(os);
		os.close();
		System.out.println("success");
		
		
		
	}
}
