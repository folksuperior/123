/**
 * 
 */
package cn.yin.jx.action.cargo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import cn.yin.jx.action.BaseAction;
import cn.yin.jx.domain.Contract;
import cn.yin.jx.domain.ContractProduct;
import cn.yin.jx.service.ContractProductService;
import cn.yin.jx.utils.DownloadUtil;
import cn.yin.jx.utils.UtilFuns;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月26日
 */
public class OutProductAction extends BaseAction{
	private ContractProductService contractProductService;
	public void setContractProductService(
			ContractProductService contractProductService) {
		this.contractProductService = contractProductService;
	}

	private String inputDate;
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public String toedit(){
		return "toedit";
	}
	
	//大标题的样式
	public CellStyle bigTitle(Workbook wb){
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short)16);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);					//字体加粗
		
		style.setFont(font);
		
		style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中
		
		return style;
	}
		
	//小标题的样式
	public CellStyle title(Workbook wb){
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short)12);
		
		style.setFont(font);
		
		style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中
		
		style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
		style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
		style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
		style.setBorderRight(CellStyle.BORDER_THIN);				//右细线
		
		return style;
	}
	
	//文字样式
	public CellStyle text(Workbook wb){
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short)10);
		
		style.setFont(font);
		
		style.setAlignment(CellStyle.ALIGN_LEFT);					//横向居左
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中
		
		style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
		style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
		style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
		style.setBorderRight(CellStyle.BORDER_THIN);				//右细线
		
		return style;
	}
	
	public String print() throws Exception{
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		
		// 定义公共变量
		Row row = null;
		Cell cell = null;
		
		int rowNo = 0;
		int cellNo = 1;
		
		//设置列宽 第一个参数：第n列，第二个参数：列宽
		sheet.setColumnWidth(0, 6*256);
		sheet.setColumnWidth(1, 26*256);
		sheet.setColumnWidth(2, 12*256);
		sheet.setColumnWidth(3, 30*256);
		sheet.setColumnWidth(4, 12*256);
		sheet.setColumnWidth(5, 15*256);
		sheet.setColumnWidth(6, 10*256);
		sheet.setColumnWidth(7, 10*256);
		sheet.setColumnWidth(8, 10*256);
		
		// **********设置大标题**********
		Row nRow = sheet.createRow(rowNo);
		Cell nCell = nRow.createCell(cellNo);
		
		//行高+合并单元格
		nRow.setHeightInPoints(36f);
		
		//横向合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0,0,1,8));
		
		// 设置数据
		nCell.setCellValue(inputDate.replace("-0", "-").replace("-", "年")+"月份出货表");
		// 设置样式
		nCell.setCellStyle(bigTitle(wb));
		
		// *********写入小标题*********
		rowNo++;
		String[] titles = {"客户","订单号","货号","数量","工厂","工厂交期","船期","贸易条款"};
		nRow = sheet.createRow(rowNo);
		nRow.setHeightInPoints(26.25f);
		for(String title : titles){
			cell = nRow.createCell(cellNo++);
			cell.setCellValue(title);
			cell.setCellStyle(title(wb));
		}
		
		// *********设置出货数据*********
		String hql = "from ContractProduct where to_char(contract.shipTime,'yyyy-mm') = '"+inputDate+"'";
		List<ContractProduct> list = contractProductService.find(hql, ContractProduct.class, null);
		for(ContractProduct cp : list){
			cellNo = 1;
			nRow = sheet.createRow(++rowNo);
			// 再创建每列数据
			// 客户
			nCell = nRow.createCell(cellNo++);
			nCell.setCellValue(cp.getContract().getCustomName());
			nCell.setCellStyle(text(wb));
			// 订单号
			nCell = nRow.createCell(cellNo++);
			nCell.setCellValue(cp.getContract().getContractNo());
			nCell.setCellStyle(text(wb));
			// 货号
			nCell = nRow.createCell(cellNo++);
			nCell.setCellValue(cp.getProductNo());
			nCell.setCellStyle(text(wb));
			// 数量
			nCell = nRow.createCell(cellNo++);
			nCell.setCellValue(cp.getCnumber());
			nCell.setCellStyle(text(wb));
			// 工厂
			nCell =  nRow.createCell(cellNo++);
			nCell.setCellValue(cp.getFactoryName());
			nCell.setCellStyle(text(wb));
			// 工厂交期
			nCell = nRow.createCell(cellNo++);
			nCell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getDeliveryPeriod()));
			nCell.setCellStyle(text(wb));
			// 船期
			nCell = nRow.createCell(cellNo++);
			nCell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getShipTime()));
			nCell.setCellStyle(text(wb));
			// 贸易条款
			nCell = nRow.createCell(cellNo++);
			nCell.setCellValue(cp.getContract().getTradeTerms());
			nCell.setCellStyle(text(wb));
		}
		
		
		
		// 写入流
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  // 字节数组缓冲流
		wb.write(byteArrayOutputStream);
		
		// 下载
		DownloadUtil downloadUtil = new DownloadUtil();
		HttpServletResponse response = ServletActionContext.getResponse();
		downloadUtil.download(byteArrayOutputStream, response, "出货表.xlsx");
		
		return NONE;
	}
	
}
