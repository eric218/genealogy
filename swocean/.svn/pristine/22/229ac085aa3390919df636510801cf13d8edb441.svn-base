package com.dct.swocean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.dct.swocean.util.dataimport.Excel;
import com.dct.swocean.util.dataimport.ExcelUtil;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.mysql.fabric.xmlrpc.base.Array;

public class TestExcel{
	
	@Test
	 public void test() throws IOException {

	        // 声明String数组，并初始化元素（表头名称）
	        //第一行表头字段，合并单元格时字段跨几列就将该字段重复几次
	        String[] excelHeader0 = { "城市名称", "监测点", "污染物浓度及空气质量分指数（AQI）", "污染物浓度及空气质量分指数（AQI）", "污染物浓度及空气质量分指数（AQI）",
	                "污染物浓度及空气质量分指数（AQI）", "污染物浓度及空气质量分指数（AQI）", "污染物浓度及空气质量分指数（AQI）", "污染物浓度及空气质量分指数（AQI）",
	                "污染物浓度及空气质量分指数（AQI）", "污染物浓度及空气质量分指数（AQI）", "污染物浓度及空气质量分指数（AQI）", "污染物浓度及空气质量分指数（AQI）",
	                "污染物浓度及空气质量分指数（AQI）", "空气质量指数（AQI）", "首要污染物", "空气质量指数级别", "空气质量指数类别", "空气质量指数类别" };
	           //  “0,2,0,0”  ===>  “起始行，截止行，起始列，截止列”
	        String[] headnum0 = { "0,2,0,0", "0,2,1,1", "0,0,2,13", "0,2,14,14", "0,2,15,15", "0,2,16,16", "0,1,17,18" };

	        //第二行表头字段，其中的空的双引号是为了补全表格边框
	        String[] excelHeader1 = { "二氧化硫（SO₂）24小时平均", "二氧化硫（SO₂）24小时平均", "二氧化氮（NO₂）24小时平均", "二氧化氮（NO₂）24小时平均",
	                "颗粒物（粒径小于等于10μm）24小时平均", "颗粒物（粒径小于等于10μm）24小时平均", "一氧化碳（CO）24小时平均", "一氧化碳（CO）24小时平均", "臭氧（O₃）最大8小时平均",
	                "臭氧（O₃）最大8小时平均", "颗粒物（粒径小于等于2.5μm）24小时平均", "颗粒物（粒径小于等于2.5μm）24小时平均","","","","","" };
	        // 合并单元格
	        String[] headnum1 = { "1,1,2,3", "1,1,4,5", "1,1,6,7", "1,1,8,9", "1,1,10,11", "1,1,12,13" };

	        //第三行表头字段
	        String[] excelHeader2 = {  "", "", "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数",
	                "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数","", "类别", "颜色" };

	        String[] headnum2 = { "2,2,2,2", "2,2,3,3", "2,2,4,4", "2,2,5,5", "2,2,6,6", "2,2,7,7", "2,2,8,8", "2,2,9,9",
	                "2,2,10,10", "2,2,11,11", "2,2,12,12", "2,2,13,13", "2,2,17,17" };

	        // 声明一个工作簿
	        HSSFWorkbook wb = new HSSFWorkbook();
	        // 生成一个表格
	        HSSFSheet sheet = wb.createSheet("TAQIDataReport");

	        // 生成一种样式
	        HSSFCellStyle style = wb.createCellStyle();
	        // 设置样式
	        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
	        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
	        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

	        // 生成一种字体
	        HSSFFont font = wb.createFont();
	        // 设置字体
	        font.setFontName("微软雅黑");
	        // 设置字体大小
	        font.setFontHeightInPoints((short) 12);
	        // 字体加粗
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        // 在样式中引用这种字体
	        style.setFont(font);

	        // 生成并设置另一个样式
	        HSSFCellStyle style2 = wb.createCellStyle();
	        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
	        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
	        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
	        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

	        // 生成另一种字体2
	        HSSFFont font2 = wb.createFont();
	        // 设置字体
	        font2.setFontName("微软雅黑");
	        // 设置字体大小
	        font2.setFontHeightInPoints((short) 12);
	        // 字体加粗
	        // font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        // 在样式2中引用这种字体
	        style2.setFont(font2);

	        // 生成表格的第一行
	        // 第一行表头
	        HSSFRow row = sheet.createRow(0);
	        for (int i = 0; i < excelHeader0.length; i++) {

	            sheet.autoSizeColumn(i, true);// 根据字段长度自动调整列的宽度
	            HSSFCell cell = row.createCell(i);
	            cell.setCellValue(excelHeader0[i]);
	            cell.setCellStyle(style);

	            // System.out.println(excelHeader0[i]);

	            if (i >= 0 && i <= 18) {
	                for (int j = 0; j < excelHeader0.length; j++) {
	                    // 从第j列开始填充
	                    cell = row.createCell(j);
	                    // 填充excelHeader1[j]第j个元素
	                    cell.setCellValue(excelHeader0[j]);
	                    cell.setCellStyle(style);
	                }

	            }

	            // 设置列宽

	            // sheet.setColumnWidth(0, 5500);
	            // sheet.setColumnWidth(1, 6500);
	            // sheet.setColumnWidth(2, 6500);
	            // sheet.setColumnWidth(3, 6000);
	            // sheet.setColumnWidth(4, 6500);
	            // sheet.setColumnWidth(5, 6500);
	            // sheet.setColumnWidth(6, 6500);
	            // sheet.setColumnWidth(7, 6500);
	            // sheet.setColumnWidth(8, 6500);
	            // sheet.setColumnWidth(9, 6500);
	            // sheet.setColumnWidth(10, 6500);
	            // sheet.setColumnWidth(11, 6500);
	            // sheet.setColumnWidth(12, 6500);
	            // sheet.setColumnWidth(13, 6500);
	            // sheet.setColumnWidth(14, 6500);
	            // sheet.setColumnWidth(15, 6500);
	            // sheet.setColumnWidth(16, 6500);
	            // sheet.setColumnWidth(17, 6500);
	            // sheet.setColumnWidth(18, 6500);
	            // sheet.setDefaultRowHeight((short) 360);// 设置行高

	        }

	        // 动态合并单元格
	        for (int i = 0; i < headnum0.length; i++) {

	            sheet.autoSizeColumn(i, true);
	            String[] temp = headnum0[i].split(",");
	            Integer startrow = Integer.parseInt(temp[0]);
	            Integer overrow = Integer.parseInt(temp[1]);
	            Integer startcol = Integer.parseInt(temp[2]);
	            Integer overcol = Integer.parseInt(temp[3]);
	            sheet.addMergedRegion(new CellRangeAddress(startrow, overrow, startcol, overcol));
	        }

	        // 第二行表头
	        row = sheet.createRow(1);
	        for (int i = 0; i < excelHeader1.length; i++) {

	            sheet.autoSizeColumn(i, true);// 自动调整宽度
	            HSSFCell cell = row.createCell(i + 1);
	            cell.setCellValue(excelHeader1[i]);
	            cell.setCellStyle(style);

	            if (i >= 2 && i <= 18) {
	                for (int j = 0; j < excelHeader1.length; j++) {
	                    // 从第j+1列开始填充
	                    cell = row.createCell(j + 2);
	                    // 填充excelHeader1[j]第j个元素
	                    cell.setCellValue(excelHeader1[j]);
	                    cell.setCellStyle(style);
	                }
	            }
	        }

	        // 动态合并单元格
	        for (int i = 0; i < headnum1.length; i++) {

	            sheet.autoSizeColumn(i, true);
	            String[] temp = headnum1[i].split(",");
	            Integer startrow = Integer.parseInt(temp[0]);
	            Integer overrow = Integer.parseInt(temp[1]);
	            Integer startcol = Integer.parseInt(temp[2]);
	            Integer overcol = Integer.parseInt(temp[3]);
	            sheet.addMergedRegion(new CellRangeAddress(startrow, overrow, startcol, overcol));
	        }
	        // 第三行表头
	        row = sheet.createRow(2);
	        for (int i = 0; i < excelHeader2.length; i++) {

	            HSSFCell cell = row.createCell(i + 2);
	            cell.setCellValue(excelHeader2[i]);
	            cell.setCellStyle(style);
	            // System.out.println(excelHeader2[i]);
	            sheet.autoSizeColumn(i, true);// 自动调整宽度

	            if (i > 1 && i <= 18) {
	                for (int j = 0; j < excelHeader2.length; j++) {
	                    // 从第j+2列开始填充
	                    cell = row.createCell(j);
	                    // 填充excelHeader1[j]第j个元素
	                    cell.setCellValue(excelHeader2[j]);
	                    cell.setCellStyle(style);
	                }
	            }
	        }
//	        // 动态合并单元格
//	        for (int i = 0; i < headnum2.length; i++) {
//
//	            sheet.autoSizeColumn(i, true);
//	            String[] temp = headnum2[i].split(",");
//	            Integer startrow = Integer.parseInt(temp[0]);
//	            Integer overrow = Integer.parseInt(temp[1]);
//	            Integer startcol = Integer.parseInt(temp[2]);
//	            Integer overcol = Integer.parseInt(temp[3]);
//	            sheet.addMergedRegion(new CellRangeAddress(startrow, overrow, startcol, overcol));
//	        }

	        List<String[]> list =new ArrayList<String[]>();
	        String[] s1={"1","1","1","3","5"};
	        String[] s2={"1","1","1","3","5"};
	        String[] s3={"1","1","1","3","5"};
	        String[] s4={"1","1","1","3","5"};
	        String[] s5={"1","1","1","3","5"};
	        list.add(s1);
	        list.add(s2);
	        list.add(s3);
	        list.add(s4);
	        list.add(s5);
	        // 第四行数据
	        for (int i = 0; i < list.size(); i++) {

	            row = sheet.createRow(i + 3);
	            String[] strings = (String[]) list.get(i);

	            // 导入对应列的数据
	            for(int n=0;n<strings.length;n++){
	            	HSSFCell cell = row.createCell(n);
	            	cell.setCellValue(strings[n]);
	            	cell.setCellStyle(style2);
	            }
	            
	        }
	        
	        File file=new File("d:\\测试1.xls");
	        file.createNewFile();
	        wb.write(new FileOutputStream(file));  
	          
	        wb.close();//最后记得关闭工作簿  
	    }
	
	@Test
	public void test1() throws FileNotFoundException, IOException{
	    //创建工作簿  
        HSSFWorkbook workBook = new HSSFWorkbook();  
        //创建工作表  工作表的名字叫helloWorld  
        HSSFSheet sheet = workBook.createSheet("helloWorld");  
        //创建行,第3行  
        HSSFRow row = sheet.createRow(2);  
        //创建单元格，操作第三行第三列  
        HSSFCell cell = row.createCell(2, CellType.GREATER_THAN);  
        cell.setCellValue("helloWorld");  
        File file=new File("d:\\测试.xls");
        file.createNewFile();
        workBook.write(new FileOutputStream(file));  
          
        workBook.close();//最后记得关闭工作簿  
	}
	
	
	@Test
	 public void test2() throws IOException {

	        // 声明String数组，并初始化元素（表头名称）
//	        第一行表头字段，合并单元格时字段跨几列就将该字段重复几次
	        String[] excelHeader0 = { "城市名称", "监测点", "污染物浓度及空气质量分指数（AQI）","空气质量指数（AQI）","首要污染物", "空气质量指数级别", "空气质量指数类别"};
	           //  “0,2,0,0”  ===>  “起始行，截止行，起始列，截止列”
	        String[] headnum0 = { "0,2,0,0", "0,2,1,1", "0,0,2,13", "0,2,14,14", "0,2,15,15", "0,2,16,16", "0,1,17,18" };

	        //第二行表头字段，其中的空的双引号是为了补全表格边框
	        String[] excelHeader1 = { "二氧化硫（SO₂）24小时平均", "二氧化硫（SO₂）24小时平均", "二氧化氮（NO₂）24小时平均", "二氧化氮（NO₂）24小时平均",
	                "颗粒物（粒径小于等于10μm）24小时平均", "颗粒物（粒径小于等于10μm）24小时平均", "一氧化碳（CO）24小时平均", "一氧化碳（CO）24小时平均", "臭氧（O₃）最大8小时平均",
	                "臭氧（O₃）最大8小时平均", "颗粒物（粒径小于等于2.5μm）24小时平均", "颗粒物（粒径小于等于2.5μm）24小时平均"};
	        // 合并单元格
	        String[] headnum1 = { "1,1,2,3", "1,1,4,5", "1,1,6,7", "1,1,8,9", "1,1,10,11", "1,1,12,13" };

	        //第三行表头字段
	        String[] excelHeader2 = {  "", "", "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数",
	                "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数","", "类别", "颜色" };

	        String[] headnum2 = { "2,2,2,2", "2,2,3,3", "2,2,4,4", "2,2,5,5", "2,2,6,6", "2,2,7,7", "2,2,8,8", "2,2,9,9",
	                "2,2,10,10", "2,2,11,11", "2,2,12,12", "2,2,13,13", "2,2,17,17", "2,2,18,18" };

	        // 声明一个工作簿
	        HSSFWorkbook wb = new HSSFWorkbook();
	        // 生成一个表格
	        HSSFSheet sheet = wb.createSheet("TAQIDataReport");

	        // 生成一种样式
	        HSSFCellStyle style = wb.createCellStyle();
	        // 设置样式
	        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
	        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
	        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

	        // 生成一种字体
	        HSSFFont font = wb.createFont();
	        // 设置字体
	        font.setFontName("微软雅黑");
	        // 设置字体大小
	        font.setFontHeightInPoints((short) 12);
	        // 字体加粗
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        // 在样式中引用这种字体
	        style.setFont(font);

	        // 生成并设置另一个样式
	        HSSFCellStyle style2 = wb.createCellStyle();
	        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
	        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
	        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
	        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

	        // 生成另一种字体2
	        HSSFFont font2 = wb.createFont();
	        // 设置字体
	        font2.setFontName("微软雅黑");
	        // 设置字体大小
	        font2.setFontHeightInPoints((short) 12);
	        // 字体加粗
	        // font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        // 在样式2中引用这种字体
	        style2.setFont(font2);

	        
	        // 生成表格的第一行
	        
	        // 动态合并单元格3
	        int[] colIndex=new int[headnum0.length];
	        for (int i = 0; i < headnum0.length; i++) {

	            sheet.autoSizeColumn(i, true);
	            String[] temp = headnum0[i].split(",");
	            Integer startrow = Integer.parseInt(temp[0]);
	            Integer overrow = Integer.parseInt(temp[1]);
	            Integer startcol = Integer.parseInt(temp[2]);
	            Integer overcol = Integer.parseInt(temp[3]);
	            sheet.addMergedRegion(new CellRangeAddress(startrow, overrow, startcol, overcol));
	            colIndex[i]=startcol;
	        }
	        // 第一行表头
	        HSSFRow row = sheet.createRow(0);
//	        for (int i = 0; i < colIndex.length; i++) {
//	        	int col= colIndex[i];
//	            sheet.autoSizeColumn(col, true);// 根据字段长度自动调整列的宽度
//	            HSSFCell cell = row.createCell(col);
//	            cell.setCellValue(excelHeader0[i]);
//	            cell.setCellStyle(style);
//	            System.out.println(excelHeader0[i]);
//	      
//	        }

	    

//	        // 第二行表头
//	        row = sheet.createRow(1);
//	        for (int i = 0; i < excelHeader1.length; i++) {
//
//	            sheet.autoSizeColumn(i, true);// 自动调整宽度
//	            HSSFCell cell = row.createCell(i + 1);
//	            cell.setCellValue(excelHeader1[i]);
//	            cell.setCellStyle(style);
//
//	            if (i >= 2 && i <= 18) {
//	                for (int j = 0; j < excelHeader1.length; j++) {
//	                    // 从第j+1列开始填充
//	                    cell = row.createCell(j + 2);
//	                    // 填充excelHeader1[j]第j个元素
//	                    cell.setCellValue(excelHeader1[j]);
//	                    cell.setCellStyle(style);
//	                }
//	            }
//	        }
//
//	        // 动态合并单元格
//	        for (int i = 0; i < headnum1.length; i++) {
//
//	            sheet.autoSizeColumn(i, true);
//	            String[] temp = headnum1[i].split(",");
//	            Integer startrow = Integer.parseInt(temp[0]);
//	            Integer overrow = Integer.parseInt(temp[1]);
//	            Integer startcol = Integer.parseInt(temp[2]);
//	            Integer overcol = Integer.parseInt(temp[3]);
//	            sheet.addMergedRegion(new CellRangeAddress(startrow, overrow, startcol, overcol));
//	        }
	        // 第三行表头
//	        row = sheet.createRow(2);
//	        for (int i = 0; i < excelHeader2.length; i++) {
//
//	            HSSFCell cell = row.createCell(i + 2);
//	            cell.setCellValue(excelHeader2[i]);
//	            cell.setCellStyle(style);
//	            // System.out.println(excelHeader2[i]);
//	            sheet.autoSizeColumn(i, true);// 自动调整宽度
//
//	            if (i > 1 && i <= 18) {
//	                for (int j = 0; j < excelHeader2.length; j++) {
//	                    // 从第j+2列开始填充
//	                    cell = row.createCell(j);
//	                    // 填充excelHeader1[j]第j个元素
//	                    cell.setCellValue(excelHeader2[j]);
//	                    cell.setCellStyle(style);
//	                }
//	            }
//	        }
//	        // 动态合并单元格
//	        for (int i = 0; i < headnum2.length; i++) {
//
//	            sheet.autoSizeColumn(i, true);
//	            String[] temp = headnum2[i].split(",");
//	            Integer startrow = Integer.parseInt(temp[0]);
//	            Integer overrow = Integer.parseInt(temp[1]);
//	            Integer startcol = Integer.parseInt(temp[2]);
//	            Integer overcol = Integer.parseInt(temp[3]);
//	            sheet.addMergedRegion(new CellRangeAddress(startrow, overrow, startcol, overcol));
//	        }

	        List<String[]> list =new ArrayList<String[]>();
	        String[] s1={"1","1","1","3","5"};
	        String[] s2={"1","1","1","3","5"};
	        String[] s3={"1","1","1","3","5"};
	        String[] s4={"1","1","1","3","5"};
	        String[] s5={"1","1","1","3","5"};
	        list.add(s1);
	        list.add(s2);
	        list.add(s3);
	        list.add(s4);
	        list.add(s5);
	        // 第四行数据
	        for (int i = 0; i < list.size(); i++) {

	            row = sheet.createRow(i + 3);
	            String[] strings = (String[]) list.get(i);

	            // 导入对应列的数据
	            for(int n=0;n<strings.length;n++){
	            	HSSFCell cell = row.createCell(n);
	            	cell.setCellValue(strings[n]);
	            	cell.setCellStyle(style2);
	            }
	            
	        }
	        
	        File file=new File("d:/测试.xls");
	        file.createNewFile();
	        wb.write(new FileOutputStream(file));  
	          
	        wb.close();//最后记得关闭工作簿  
	    }
	
	public void writeExcel(String[] headerContent ,String[] headerNum , List<String[]> content ,String path , short headerColor , short contentColor, short headerHeight , short contentHeight ) throws IOException{
		
		   HSSFWorkbook wb = new HSSFWorkbook();
	        // 生成一个表格
	        HSSFSheet sheet = wb.createSheet("sheet");
	        
	        sheet.setDefaultRowHeight(contentHeight);// 设置全局行高
	        // 生成一种样式
	        HSSFCellStyle style = wb.createCellStyle();
	        // 设置样式
	        style.setFillForegroundColor(headerColor);
	        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
	        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

	        // 生成一种字体
	        HSSFFont font = wb.createFont();
	        // 设置字体
	        font.setFontName("微软雅黑");
	        // 设置字体大小
	        font.setFontHeightInPoints((short) 12);
	        // 字体加粗
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        // 在样式中引用这种字体
	        style.setFont(font);

	        // 生成并设置另一个样式
	        HSSFCellStyle style2 = wb.createCellStyle();
	        style2.setFillForegroundColor(contentColor);
	        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
	        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
	        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

	        // 生成另一种字体2
	        HSSFFont font2 = wb.createFont();
	        // 设置字体
	        font2.setFontName("微软雅黑");
	        // 设置字体大小
	        font2.setFontHeightInPoints((short) 12);
	        // 字体加粗
	        // font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        // 在样式2中引用这种字体
	        style2.setFont(font2);

	        
		
	    // 动态合并单元格
        int[] colIndex=new int[headerNum.length];    //保存表头的所在列，为了后面写入表头内容
        int[] rowIndex=new int[headerNum.length];    //保存表头的所在行，为了后面写入表头内容
        int rowCount = 0;                            //表头所占行的数量
        int colCount = 0;
        for (int i = 0; i < headerNum.length; i++) {

            sheet.autoSizeColumn(i, true);
            String[] temp = headerNum[i].split(",");
            Integer startrow = Integer.parseInt(temp[0]);
            Integer overrow = Integer.parseInt(temp[1]);
            Integer startcol = Integer.parseInt(temp[2]);
            Integer overcol = Integer.parseInt(temp[3]);
            if(overrow>startrow || overcol>startcol){
            	sheet.addMergedRegion(new CellRangeAddress(startrow, overrow, startcol, overcol));
            }
            if(overrow+1>rowCount){
            	rowCount=overrow+1;
            }
            if(overcol+1>colCount){
            	colCount=overcol+1;
            }
            colIndex[i]=startcol;
            rowIndex[i]=startrow;
        }
        
        //创建表头的row对象数组
        HSSFRow headerRow[]=new HSSFRow[rowCount];
        for(int i=0;i<rowCount;i++){
        	headerRow[i]=sheet.createRow(i);
        	headerRow[i].setHeight(headerHeight);     //设置表头行高
        }
        
        //给合并后的单元格加边框
        for(int i=0;i<rowCount;i++){
        	for(int j=0;j<colCount;j++){
        		HSSFCell cell= headerRow[i].createCell(j);
        		cell.setCellValue("");
        		cell.setCellStyle(style);
        	}
        	System.out.println(i);
        }
        
        
        // 写入表头内容
        for (int i = 0; i < colIndex.length; i++) {
        	int col= colIndex[i];
            HSSFCell cell = headerRow[rowIndex[i]].createCell(col);
            cell.setCellValue(headerContent[i]);
            cell.setCellStyle(style);
      
        }
	    
        HSSFRow contentRow = null;
        // 第四行数据
        for (int i = 0; i < content.size(); i++) {

        	contentRow = sheet.createRow(i + 3);
            String[] strings = (String[]) content.get(i);

            // 导入对应列的数据
            for(int n=0;n<strings.length;n++){
            	HSSFCell cell = contentRow.createCell(n);
            	cell.setCellValue(strings[n]);
            	cell.setCellStyle(style2);
            }
            
        }
        for(int i=0;i<colCount;i++){
        	 sheet.autoSizeColumn(i, true);// 根据字段长度自动调整列的宽度
        }
        sheet.createFreezePane( 0, rowCount, 0, rowCount );    //固定表头
        path=path.trim();
        File file=new File(path);
        if(!file.exists()){
        	String fileDir=path.substring(0, path.lastIndexOf("/")+1);
        	CreateFolder(fileDir);
        	file.createNewFile();
        }
        wb.write(new FileOutputStream(file));    
        wb.close();//最后记得关闭工作簿  
	};
	/*
	 * 创建文件夹
	 */
	public static void CreateFolder(String sPath) {
		File file1 = new File(sPath);
		// 判断目录或文件是否存在
		if (!file1.exists()) {
			file1.mkdirs();
		}
	}
	
//	
//	@Test
//	public void  test5() throws IOException{
//        // 声明String数组，并初始化元素（表头名称）
////        第一行表头字段，合并单元格时字段跨几列就将该字段重复几次
//        String[] excelHeader0 = { "城市名称", "监测点", "污染物浓度及空气质量分指数（AQI）","空气质量指数（AQI）","首要污染物", "空气质量指数级别", "空气质量指数类别",
//        		"二氧化硫（SO₂）24小时平均", "二氧化氮（NO₂）24小时平均",
//                "颗粒物（粒径小于等于10μm）24小时平均",  "一氧化碳（CO）24小时平均", "臭氧（O₃）最大8小时平均",  "颗粒物（粒径小于等于2.5μm）24小时平均",
//                "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数",
//                "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数", "类别", "颜色"};
//           //  “0,2,0,0”  ===>  “起始行，截止行，起始列，截止列”
//        String[] headnum0 = { "0,2,0,0", "0,2,1,1", "0,0,2,13", "0,2,14,14", "0,2,15,15", "0,2,16,16", "0,1,17,18",
//        		"1,1,2,3", "1,1,4,5", "1,1,6,7", "1,1,8,9", "1,1,10,11", "1,1,12,13",
//        		"2,2,2,2", "2,2,3,3", "2,2,4,4", "2,2,5,5", "2,2,6,6", "2,2,7,7", "2,2,8,8", "2,2,9,9",
//                "2,2,10,10", "2,2,11,11", "2,2,12,12", "2,2,13,13", "2,2,17,17", "2,2,18,18"};
//        
//       List<String[]> list =new ArrayList<String[]>();
//       String[] s1={"1","1","1","3","5"};
//       String[] s2={"1","1","1","3","5"};
//       String[] s3={"1","1","1","3","5"};
//       String[] s4={"1","1","1","3","5"};
//       String[] s5={"1","1","1","3","5"};
//       list.add(s1);
//       list.add(s2);
//       list.add(s3);
//       list.add(s4);
//       list.add(s5);
//       Excel excel = new Excel("d:/测试/测试2.xls");
//       ExcelUtil.writeExcel(excelHeader0, headnum0, list, 1, 3, 5, excel,"test");
//	}
//	
//	@Test
//	public  void test6() throws Exception{
//		List<String[]> list = ExcelUtil.readExcelFromPath("d:/测试/测试.xls", 19, 3);
//		for (String[] strings : list) {
//			for (String string : strings) {
//				System.out.println(string);
//			}
//		}
//	}
	
	@Test
	public  void test7() throws Exception{
		
		List<String[]> list =new ArrayList<String[]>();
	       String[] s1={"afe","1","1","3","5"};
	       String[] s2={"1","1","1","3","5"};
	       String[] s3={"1","1","1","3","5"};
	       String[] s4={"1","1","1","3","5"};
	       String[] s5={"1","1","1","3","5"};
	       list.add(s1);
	       list.add(s2);
	       list.add(s3);
	       list.add(s4);
	       list.add(s5);
	       @SuppressWarnings("rawtypes")
		Map<String[] ,String []> map=new HashMap();
	       ExcelUtil.exportToTemplate(map,list, "d:/测试/test.xlsx", "d:/测试/demo.xlsx", 1,"测试");
	}
	
	
	
	@Test
	public void test9() throws IllegalArgumentException, IOException{
		String[] strs = new String[] { "刘德华", "张学友", "黎明", "郭富城" };
		ExcelUtil.setValidationData(strs, 0, 9, 0, 0, "d:/测试/测试2.xlsx", "d:/测试/测试2.xlsx");
	}
	
	@Test
	public void  test10() throws IOException{
        // 声明String数组，并初始化元素（表头名称）
//        第一行表头字段，合并单元格时字段跨几列就将该字段重复几次
        String[] excelHeader0 = { "城市名称", "监测点", "污染物浓度及空气质量分指数（AQI）","空气质量指数（AQI）","首要污染物", "空气质量指数级别", "空气质量指数类别",
        		"二氧化硫（SO₂）24小时平均", "二氧化氮（NO₂）24小时平均",
                "颗粒物（粒径小于等于10μm）24小时平均",  "一氧化碳（CO）24小时平均", "臭氧（O₃）最大8小时平均",  "颗粒物（粒径小于等于2.5μm）24小时平均",
                "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数",
                "浓度/（μg/m3）", "分指数", "浓度/（μg/m3）", "分指数", "类别", "颜色"};
           //  “0,2,0,0”  ===>  “起始行，截止行，起始列，截止列”
        String[] headnum0 = { "0,2,0,0", "0,2,1,1", "0,0,2,13", "0,2,14,14", "0,2,15,15", "0,2,16,16", "0,1,17,18",
        		"1,1,2,3", "1,1,4,5", "1,1,6,7", "1,1,8,9", "1,1,10,11", "1,1,12,13",
        		"2,2,2,2", "2,2,3,3", "2,2,4,4", "2,2,5,5", "2,2,6,6", "2,2,7,7", "2,2,8,8", "2,2,9,9",
                "2,2,10,10", "2,2,11,11", "2,2,12,12", "2,2,13,13", "2,2,17,17", "2,2,18,18"};
        
       List<String[]> list =new ArrayList<String[]>();
       String[] s1={"1","1","1","3","5"};
       String[] s2={"1","1","1","3","5"};
       String[] s3={"1","1","1","3","5"};
       String[] s4={"1","1","1","3","5"};
       String[] s5={"1","1","1","3","5"};
       list.add(s1);
       list.add(s2);
       list.add(s3);
       list.add(s4);
       list.add(s5);
       Excel excel = new Excel("d:/测试/测试2.xlsx");
       CellStyle style= excel.getEmptyCellSytle();
       CellStyle style2= excel.getEmptyCellSytle();
       
   
       
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		
		style2.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		
	    Font font = excel.getEmptyFont();
	       font.setFontName("微软雅黑");
	       // 设置字体大小
	       font.setFontHeightInPoints((short) 20);
	       // 字体加粗
	       font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	       // 在样式中引用这种字体
	       style2.setFont(font);
		Map<String[],String[]> customContent = new HashMap<String[],String[]>();
		customContent.put(headnum0, excelHeader0);
		Map<CellStyle,String> map =excel.getDetailStyles();
		map.put(style, "20,25,8,10");
		map.put(style2, "0,0,2,2");
		Map<String, Integer> map1=excel.getDetailColumWidths();
		map1.put("0,3",20*256);
		map1.put("5,5",10*256);
		Map<String, Short> map2=excel.getDetailRowHeights();
		map2.put("0,3", (short) 1000);
		map2.put("4,4",(short)200);
		excel.setFreezePane("2,1");  
       ExcelUtil.writeExcel(customContent, list , 5, excel,"testSheet");
	}
}