package com.dct.swocean.util.dataimport;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * excel样式包装类，封装了excel的样式，字体，行高，列宽，冻结excel某些区域
 * 
 * @author zh
 *
 */
public class Excel {

	private Workbook workbook;

	private String savePath;

	private short defaultRowHeight = (short) 360; // 默认全局行高

	private CellStyle defaultStyle; // 默认全局样式

	private Font defaultFont; // 默认全局字体样式
	
	private Map<CellStyle,String> detailStyles = new HashMap<CellStyle, String>();
	
	private Map<String,Short> detailRowHeights =new HashMap<String, Short>();
	
	private Map<String,Integer> detailColumWidths =new HashMap<String, Integer>();
		
	private String freezePane=null;

	public Map<String, Short> getDetailRowHeights() {
		return detailRowHeights;
	}



	public String getFreezePane() {
		return freezePane;
	}



	public void setFreezePane(String freezePane) {
		this.freezePane = freezePane;
	}



	public void setDetailRowHeights(Map<String, Short> detailRowHeights) {
		this.detailRowHeights = detailRowHeights;
	}



	public Map<String, Integer> getDetailColumWidths() {
		return detailColumWidths;
	}



	public void setDetailColumWidths(Map<String, Integer> detailColumWidths) {
		this.detailColumWidths = detailColumWidths;
	}



	public Map<CellStyle, String> getDetailStyles() {
		return detailStyles;
	}

	

	public void setDetailStyles(Map<CellStyle, String> detailStyles) {
		this.detailStyles = detailStyles;
	}

	/**
	 * 创建Excel对象
	 * 
	 * @param path
	 *            excel模板路径或保存文件的路径
	 */
	public Excel(String path) {
		super();
		savePath = path.trim();
		workbook = ExcelUtil.getEmptyWorkBook(savePath);
		defaultStyle = workbook.createCellStyle();
		defaultFont = workbook.createFont();
		init();
	}

	private void init() {
		// 默认样式
		defaultStyle.setFillForegroundColor(HSSFColor.WHITE.index);
		defaultStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		defaultStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		defaultStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		defaultStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		defaultStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		defaultStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		defaultStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// 默认字体
		// 生成一种字体
		defaultFont = workbook.createFont();
		// 设置字体
		defaultFont.setFontName("微软雅黑");
		// 设置字体大小
		defaultFont.setFontHeightInPoints((short) 12);
		// 字体加粗
		defaultFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		
		// 在样式中引用这种字体
		defaultStyle.setFont(defaultFont);
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public Workbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}

	public short getDefaultRowHeight() {
		return defaultRowHeight;
	}

	public void setDefaultRowHeight(short defaultRowHeight) {
		this.defaultRowHeight = defaultRowHeight;
	}

	public CellStyle getDefaultStyle() {
		return defaultStyle;
	}

	public void setDefaultStyle(CellStyle defaultStyle) {
		this.defaultStyle = defaultStyle;
	}

	public Font getDefaultFont() {
		return defaultFont;
	}

	public void setDefaultFont(Font defaultFont) {
		this.defaultFont = defaultFont;
	}
    
	
	public CellStyle getEmptyCellSytle(){
		return workbook.createCellStyle();
	};
	
	public Font getEmptyFont(){
		return workbook.createFont();
	}
	
}
